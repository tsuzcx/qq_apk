package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import javax.net.ssl.SSLException;

public class TXCFLVDownloader
  extends TXIStreamDownloader
{
  private final int CONNECT_TIMEOUT = 8000;
  private final int FLV_HEAD_SIZE = 9;
  private final int MAX_FRAME_SIZE = 1048576;
  private final int MSG_CONNECT = 100;
  private final int MSG_DISCONNECT = 102;
  private final int MSG_QUIT = 106;
  private final int MSG_RECONNECT = 103;
  private final int MSG_RECV_DATA = 101;
  private final int MSG_RESUME = 105;
  private final int MSG_SEEK = 104;
  private final int READ_STREAM_SIZE = 1388;
  public final String TAG = "network.TXCFLVDownloader";
  private HttpURLConnection mConnection = null;
  private long mContentLength = 0L;
  private long mDownloadedSize = 0L;
  private long mFLVParser = 0L;
  private Handler mFlvHandler = null;
  private HandlerThread mFlvThread = null;
  private InputStream mInputStream = null;
  private byte[] mPacketBytes = null;
  private String mPlayUrl = "";
  private boolean mRecvData = false;
  private TXCStreamDownloader.DownloadStats mStats = null;
  private boolean mbFirstAudio = false;
  private boolean mbFirstVideo = false;
  
  public TXCFLVDownloader(Context paramContext)
  {
    super(paramContext);
    this.mStats.afterParseAudioBytes = 0L;
    this.mStats.dnsTS = 0L;
    this.mStats.startTS = TXCTimeUtil.getTimeTick();
  }
  
  private void connect()
  {
    if (this.mConnection != null)
    {
      this.mConnection.disconnect();
      this.mConnection = null;
    }
    this.mConnection = ((HttpURLConnection)new URL(this.mPlayUrl).openConnection());
    this.mStats.dnsTS = TXCTimeUtil.getTimeTick();
    this.mConnection.setConnectTimeout(8000);
    this.mConnection.setReadTimeout(8000);
    this.mConnection.setRequestProperty("Accept-Encoding", "identity");
    this.mConnection.setInstanceFollowRedirects(true);
    if (this.mHeaders != null)
    {
      Iterator localIterator = this.mHeaders.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.mConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    this.mConnection.connect();
    this.mInputStream = this.mConnection.getInputStream();
    this.mPacketBytes = new byte[1388];
    this.mRecvData = false;
    this.mContentLength = this.mConnection.getContentLength();
    this.mDownloadedSize = 0L;
    this.mStats.serverIP = InetAddress.getByName(this.mConnection.getURL().getHost()).getHostAddress();
    this.mStats.connTS = TXCTimeUtil.getTimeTick();
    sendNotifyEvent(12001);
  }
  
  private void disconnect()
  {
    if (this.mConnection != null)
    {
      this.mConnection.disconnect();
      this.mConnection = null;
    }
    if (this.mInputStream != null)
    {
      this.mInputStream.close();
      this.mInputStream = null;
    }
  }
  
  private native void nativeCleanData(long paramLong);
  
  private native long nativeInitFlvHander(String paramString, int paramInt, boolean paramBoolean);
  
  private native int nativeParseData(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native void nativeUninitFlvhander(long paramLong);
  
  private void postConnectMsg()
  {
    this.mInputStream = null;
    if (this.mConnection != null)
    {
      this.mConnection.disconnect();
      this.mConnection = null;
    }
    Message localMessage = new Message();
    localMessage.what = 100;
    localMessage.arg1 = 0;
    if (this.mFlvHandler != null) {
      this.mFlvHandler.sendMessage(localMessage);
    }
  }
  
  private void postDisconnectMsg()
  {
    if (this.mFlvHandler != null) {
      this.mFlvHandler.sendEmptyMessage(102);
    }
  }
  
  private void postReconnectMsg()
  {
    if (this.mFlvHandler != null) {
      this.mFlvHandler.sendEmptyMessageDelayed(103, this.connectRetryInterval * 1000);
    }
  }
  
  private void processMsgConnect()
  {
    try
    {
      connect();
      if (this.mFLVParser == 0L) {
        this.mFLVParser = nativeInitFlvHander(this.mPlayUrl, 0, this.mEnableMessage);
      }
      if (this.mFlvHandler != null) {
        this.mFlvHandler.sendEmptyMessage(101);
      }
      return;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      TXCLog.e("network.TXCFLVDownloader", "socket timeout, reconnect");
      postReconnectMsg();
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      TXCLog.e("network.TXCFLVDownloader", "file not found, reconnect");
      postReconnectMsg();
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("network.TXCFLVDownloader", "exception, reconnect");
      postReconnectMsg();
      return;
    }
    catch (Error localError)
    {
      TXCLog.e("network.TXCFLVDownloader", "error, reconnect");
      postReconnectMsg();
    }
  }
  
  private void processMsgDisConnect()
  {
    try
    {
      disconnect();
      label4:
      if (this.mFLVParser != 0L)
      {
        nativeUninitFlvhander(this.mFLVParser);
        this.mFLVParser = 0L;
      }
      return;
    }
    catch (Exception localException)
    {
      break label4;
    }
  }
  
  private void processMsgReconnect()
  {
    reconnect();
  }
  
  private void processMsgRecvData()
  {
    int i = 0;
    if (this.mInputStream != null) {
      try
      {
        int j = this.mInputStream.read(this.mPacketBytes, 0, 1388);
        if (j > 0)
        {
          this.mDownloadedSize += j;
          if (!this.mRecvData)
          {
            TXCLog.w("network.TXCFLVDownloader", "flv play receive first data");
            this.mRecvData = true;
          }
          if (this.mFLVParser != 0L)
          {
            TXCStreamDownloader.DownloadStats localDownloadStats = this.mStats;
            localDownloadStats.beforeParseVideoBytes += j;
            i = nativeParseData(this.mFLVParser, this.mPacketBytes, j);
          }
          if (i > 1048576)
          {
            TXCLog.e("network.TXCFLVDownloader", "flv play parse frame: " + i + " > 1048576,sart reconnect");
            postReconnectMsg();
          }
        }
        else if (j < 0)
        {
          TXCLog.w("network.TXCFLVDownloader", "http read: " + j + " < 0, start reconnect");
          postReconnectMsg();
          return;
        }
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        TXCLog.w("network.TXCFLVDownloader", "socket timeout start reconnect");
        postReconnectMsg();
        return;
        if (this.mFlvHandler != null)
        {
          this.mFlvHandler.sendEmptyMessage(101);
          return;
        }
      }
      catch (SocketException localSocketException)
      {
        TXCLog.w("network.TXCFLVDownloader", "socket exception start reconnect");
        postReconnectMsg();
        return;
      }
      catch (SSLException localSSLException)
      {
        TXCLog.w("network.TXCFLVDownloader", "ssl exception start reconnect");
        postReconnectMsg();
        return;
      }
      catch (EOFException localEOFException)
      {
        TXCLog.w("network.TXCFLVDownloader", "eof exception start reconnect");
        postReconnectMsg();
        return;
      }
      catch (Exception localException)
      {
        TXCLog.e("network.TXCFLVDownloader", "exception");
        this.mInputStream = null;
        this.mConnection = null;
        return;
      }
      catch (Error localError)
      {
        TXCLog.e("network.TXCFLVDownloader", "error");
        this.mInputStream = null;
        this.mConnection = null;
      }
    }
  }
  
  private void reconnect()
  {
    processMsgDisConnect();
    if (this.connectRetryTimes < this.connectRetryLimit)
    {
      this.connectRetryTimes += 1;
      TXCLog.d("network.TXCFLVDownloader", "reconnect retry time:" + this.connectRetryTimes + ", limit:" + this.connectRetryLimit);
      processMsgConnect();
      sendNotifyEvent(12015);
      return;
    }
    sendNotifyEvent(12012);
  }
  
  private void startInternal()
  {
    if (this.mFlvThread == null)
    {
      this.mFlvThread = new HandlerThread("FlvThread");
      this.mFlvThread.start();
    }
    if (this.mFlvHandler == null) {
      this.mFlvHandler = new TXCFLVDownloader.1(this, this.mFlvThread.getLooper());
    }
    postConnectMsg();
  }
  
  public TXCStreamDownloader.DownloadStats getDownloadStats()
  {
    TXCStreamDownloader.DownloadStats localDownloadStats = new TXCStreamDownloader.DownloadStats();
    localDownloadStats.afterParseAudioBytes = this.mStats.afterParseAudioBytes;
    localDownloadStats.afterParseVideoBytes = this.mStats.afterParseVideoBytes;
    localDownloadStats.beforeParseVideoBytes = this.mStats.beforeParseVideoBytes;
    localDownloadStats.beforeParseAudioBytes = this.mStats.beforeParseAudioBytes;
    localDownloadStats.startTS = this.mStats.startTS;
    localDownloadStats.dnsTS = this.mStats.dnsTS;
    localDownloadStats.connTS = this.mStats.connTS;
    localDownloadStats.firstAudioTS = this.mStats.firstAudioTS;
    localDownloadStats.firstVideoTS = this.mStats.firstVideoTS;
    localDownloadStats.serverIP = this.mStats.serverIP;
    return localDownloadStats;
  }
  
  public void onRecvAudioData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.mbFirstAudio)
    {
      this.mbFirstAudio = true;
      this.mStats.firstAudioTS = TXCTimeUtil.getTimeTick();
      TXCLog.d("network.TXCFLVDownloader", "receive first audio with ts " + this.mStats.firstAudioTS);
    }
    TXCStreamDownloader.DownloadStats localDownloadStats = this.mStats;
    localDownloadStats.afterParseAudioBytes += paramArrayOfByte.length;
    super.onRecvAudioData(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
  }
  
  public void onRecvVideoData(byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (!this.mbFirstVideo)
    {
      this.mbFirstVideo = true;
      this.mStats.firstVideoTS = TXCTimeUtil.getTimeTick();
      TXCLog.d("network.TXCFLVDownloader", "receive first video with ts " + this.mStats.firstVideoTS);
    }
    TXCStreamDownloader.DownloadStats localDownloadStats = this.mStats;
    localDownloadStats.afterParseVideoBytes += paramArrayOfByte.length;
    super.onRecvVideoData(paramArrayOfByte, paramInt1, paramLong1, paramLong2, paramInt2);
  }
  
  public void startDownload(Vector<e> paramVector, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.mIsRunning) {}
    while ((paramVector == null) || (paramVector.isEmpty())) {
      return;
    }
    this.mEnableMessage = paramBoolean3;
    this.mIsRunning = true;
    this.mPlayUrl = ((e)paramVector.get(0)).a;
    TXCLog.d("network.TXCFLVDownloader", "start pull with url " + this.mPlayUrl);
    startInternal();
  }
  
  public void stopDownload()
  {
    if (!this.mIsRunning) {}
    for (;;)
    {
      return;
      this.mIsRunning = false;
      TXCLog.d("network.TXCFLVDownloader", "stop pull");
      try
      {
        if (this.mFlvHandler != null)
        {
          this.mFlvHandler.removeCallbacksAndMessages(null);
          this.mFlvHandler.sendEmptyMessage(102);
          this.mFlvHandler.sendEmptyMessage(106);
          this.mFlvHandler = null;
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.network.TXCFLVDownloader
 * JD-Core Version:    0.7.0.1
 */