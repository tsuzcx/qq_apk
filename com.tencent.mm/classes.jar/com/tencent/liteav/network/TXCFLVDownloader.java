package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private final int CONNECT_TIMEOUT;
  private final int FLV_HEAD_SIZE;
  private final int MAX_FRAME_SIZE;
  private final int MSG_CONNECT;
  private final int MSG_DISCONNECT;
  private final int MSG_QUIT;
  private final int MSG_RECONNECT;
  private final int MSG_RECV_DATA;
  private final int MSG_RESUME;
  private final int MSG_SEEK;
  private final int READ_STREAM_SIZE;
  public final String TAG;
  private HttpURLConnection mConnection;
  private long mContentLength;
  private long mCurrentNalTs;
  private long mDownloadedSize;
  private long mFLVParser;
  private Handler mFlvHandler;
  private HandlerThread mFlvThread;
  private boolean mHandleDataInJava;
  private InputStream mInputStream;
  private long mLastIFramelTs;
  private byte[] mPacketBytes;
  private String mPlayUrl;
  private boolean mRecvData;
  private long mRefFLVParser;
  private TXCStreamDownloader.DownloadStats mStats;
  private boolean mStopJitter;
  private boolean mbFirstAudio;
  private boolean mbFirstVideo;
  
  public TXCFLVDownloader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(67596);
    this.TAG = "network.TXCFLVDownloader";
    this.FLV_HEAD_SIZE = 9;
    this.MAX_FRAME_SIZE = 1048576;
    this.MSG_CONNECT = 100;
    this.MSG_RECV_DATA = 101;
    this.MSG_DISCONNECT = 102;
    this.MSG_RECONNECT = 103;
    this.MSG_SEEK = 104;
    this.MSG_RESUME = 105;
    this.MSG_QUIT = 106;
    this.CONNECT_TIMEOUT = 8000;
    this.READ_STREAM_SIZE = 1388;
    this.mFlvThread = null;
    this.mFlvHandler = null;
    this.mInputStream = null;
    this.mConnection = null;
    this.mPacketBytes = null;
    this.mRecvData = false;
    this.mContentLength = 0L;
    this.mDownloadedSize = 0L;
    this.mHandleDataInJava = false;
    this.mFLVParser = 0L;
    this.mRefFLVParser = 0L;
    this.mCurrentNalTs = 0L;
    this.mLastIFramelTs = 0L;
    this.mStopJitter = true;
    this.mPlayUrl = "";
    this.mbFirstVideo = false;
    this.mbFirstAudio = false;
    this.mStats = null;
    this.mStats = new TXCStreamDownloader.DownloadStats();
    this.mStats.afterParseAudioBytes = 0L;
    this.mStats.dnsTS = 0L;
    this.mStats.startTS = TXCTimeUtil.getTimeTick();
    TXCLog.i("network.TXCFLVDownloader", "new flv download ".concat(String.valueOf(this)));
    AppMethodBeat.o(67596);
  }
  
  public TXCFLVDownloader(Context paramContext, TXCFLVDownloader paramTXCFLVDownloader)
  {
    super(paramContext);
    AppMethodBeat.i(146788);
    this.TAG = "network.TXCFLVDownloader";
    this.FLV_HEAD_SIZE = 9;
    this.MAX_FRAME_SIZE = 1048576;
    this.MSG_CONNECT = 100;
    this.MSG_RECV_DATA = 101;
    this.MSG_DISCONNECT = 102;
    this.MSG_RECONNECT = 103;
    this.MSG_SEEK = 104;
    this.MSG_RESUME = 105;
    this.MSG_QUIT = 106;
    this.CONNECT_TIMEOUT = 8000;
    this.READ_STREAM_SIZE = 1388;
    this.mFlvThread = null;
    this.mFlvHandler = null;
    this.mInputStream = null;
    this.mConnection = null;
    this.mPacketBytes = null;
    this.mRecvData = false;
    this.mContentLength = 0L;
    this.mDownloadedSize = 0L;
    this.mHandleDataInJava = false;
    this.mFLVParser = 0L;
    this.mRefFLVParser = 0L;
    this.mCurrentNalTs = 0L;
    this.mLastIFramelTs = 0L;
    this.mStopJitter = true;
    this.mPlayUrl = "";
    this.mbFirstVideo = false;
    this.mbFirstAudio = false;
    this.mStats = null;
    this.mStats = new TXCStreamDownloader.DownloadStats();
    this.mStats.afterParseAudioBytes = 0L;
    this.mStats.dnsTS = 0L;
    this.mStats.startTS = TXCTimeUtil.getTimeTick();
    if (paramTXCFLVDownloader != null)
    {
      this.mRefFLVParser = paramTXCFLVDownloader.mFLVParser;
      paramTXCFLVDownloader.mStopJitter = false;
    }
    TXCLog.i("network.TXCFLVDownloader", "new multi flv download ".concat(String.valueOf(this)));
    AppMethodBeat.o(146788);
  }
  
  private void connect()
  {
    AppMethodBeat.i(67606);
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
    sendNotifyEvent(2001);
    AppMethodBeat.o(67606);
  }
  
  private void disconnect()
  {
    AppMethodBeat.i(67608);
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
    AppMethodBeat.o(67608);
  }
  
  private native void nativeCleanData(long paramLong);
  
  private native int nativeGetAudioBytes(long paramLong);
  
  private native int nativeGetVideoBytes(long paramLong);
  
  private native int nativeGetVideoGop(long paramLong);
  
  private native long nativeInitFlvHander(String paramString, int paramInt, boolean paramBoolean);
  
  private native long nativeInitFlvHanderByRef(long paramLong);
  
  private native int nativeParseData(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native void nativeUninitFlvhander(long paramLong, boolean paramBoolean);
  
  private void postConnectMsg()
  {
    AppMethodBeat.i(67605);
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
    AppMethodBeat.o(67605);
  }
  
  private void postDisconnectMsg()
  {
    AppMethodBeat.i(67604);
    if (this.mFlvHandler != null) {
      this.mFlvHandler.sendEmptyMessage(102);
    }
    AppMethodBeat.o(67604);
  }
  
  private void postReconnectMsg()
  {
    AppMethodBeat.i(67603);
    if (this.mFlvHandler != null) {
      this.mFlvHandler.sendEmptyMessageDelayed(103, this.connectRetryInterval * 1000);
    }
    AppMethodBeat.o(67603);
  }
  
  private void processMsgConnect()
  {
    AppMethodBeat.i(67597);
    for (;;)
    {
      try
      {
        connect();
        if (this.mFLVParser == 0L)
        {
          if (this.mRefFLVParser != 0L)
          {
            this.mFLVParser = nativeInitFlvHanderByRef(this.mRefFLVParser);
            this.mRefFLVParser = 0L;
          }
        }
        else
        {
          if (this.mFlvHandler != null) {
            this.mFlvHandler.sendEmptyMessage(101);
          }
          AppMethodBeat.o(67597);
          return;
        }
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        TXCLog.e("network.TXCFLVDownloader", "socket timeout, reconnect");
        postReconnectMsg();
        AppMethodBeat.o(67597);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        TXCLog.e("network.TXCFLVDownloader", "file not found, reconnect");
        postReconnectMsg();
        AppMethodBeat.o(67597);
        return;
      }
      catch (Exception localException)
      {
        TXCLog.e("network.TXCFLVDownloader", "exception, reconnect");
        postReconnectMsg();
        AppMethodBeat.o(67597);
        return;
      }
      catch (Error localError)
      {
        TXCLog.e("network.TXCFLVDownloader", "error, reconnect");
        postReconnectMsg();
        AppMethodBeat.o(67597);
        return;
      }
      this.mFLVParser = nativeInitFlvHander(this.mUserID, 0, this.mEnableMessage);
    }
  }
  
  private void processMsgDisConnect()
  {
    AppMethodBeat.i(67599);
    try
    {
      disconnect();
      label10:
      if (this.mFLVParser != 0L)
      {
        nativeUninitFlvhander(this.mFLVParser, this.mStopJitter);
        this.mFLVParser = 0L;
      }
      AppMethodBeat.o(67599);
      return;
    }
    catch (Exception localException)
    {
      break label10;
    }
  }
  
  private void processMsgReconnect()
  {
    AppMethodBeat.i(67600);
    if (this.mStopJitter)
    {
      reconnect();
      AppMethodBeat.o(67600);
      return;
    }
    TXCLog.i("network.TXCFLVDownloader", "ignore processMsgReconnect when start multi stream switch".concat(String.valueOf(this)));
    if (this.mRestartListener != null) {
      this.mRestartListener.onOldStreamStop();
    }
    AppMethodBeat.o(67600);
  }
  
  private void processMsgRecvData()
  {
    int i = 0;
    AppMethodBeat.i(67598);
    if (this.mInputStream != null) {
      try
      {
        int j = this.mInputStream.read(this.mPacketBytes, 0, 1388);
        if (j > 0)
        {
          this.mDownloadedSize += j;
          if (!this.mRecvData)
          {
            TXCLog.w("network.TXCFLVDownloader", "flv play receive first data ".concat(String.valueOf(this)));
            this.mRecvData = true;
          }
          if (this.mFLVParser != 0L)
          {
            TXCStreamDownloader.DownloadStats localDownloadStats = this.mStats;
            localDownloadStats.beforeParseVideoBytes += j;
            i = nativeParseData(this.mFLVParser, this.mPacketBytes, j);
            this.mStats.afterParseVideoBytes = nativeGetVideoBytes(this.mFLVParser);
            this.mStats.afterParseAudioBytes = nativeGetAudioBytes(this.mFLVParser);
            this.mStats.videoGop = nativeGetVideoGop(this.mFLVParser);
          }
          if (i > 1048576)
          {
            TXCLog.e("network.TXCFLVDownloader", "flv play parse frame: " + i + " > 1048576,sart reconnect");
            postReconnectMsg();
            AppMethodBeat.o(67598);
          }
        }
        else if (j < 0)
        {
          TXCLog.w("network.TXCFLVDownloader", "http read: " + j + " < 0, start reconnect");
          postReconnectMsg();
          AppMethodBeat.o(67598);
          return;
        }
        if (this.mFlvHandler != null) {
          this.mFlvHandler.sendEmptyMessage(101);
        }
        AppMethodBeat.o(67598);
        return;
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        TXCLog.w("network.TXCFLVDownloader", "socket timeout start reconnect");
        postReconnectMsg();
        AppMethodBeat.o(67598);
        return;
      }
      catch (SocketException localSocketException)
      {
        TXCLog.w("network.TXCFLVDownloader", "socket exception start reconnect");
        postReconnectMsg();
        AppMethodBeat.o(67598);
        return;
      }
      catch (SSLException localSSLException)
      {
        TXCLog.w("network.TXCFLVDownloader", "ssl exception start reconnect");
        postReconnectMsg();
        AppMethodBeat.o(67598);
        return;
      }
      catch (EOFException localEOFException)
      {
        TXCLog.w("network.TXCFLVDownloader", "eof exception start reconnect");
        postReconnectMsg();
        AppMethodBeat.o(67598);
        return;
      }
      catch (Exception localException)
      {
        TXCLog.e("network.TXCFLVDownloader", "exception");
        this.mInputStream = null;
        this.mConnection = null;
        AppMethodBeat.o(67598);
        return;
      }
      catch (Error localError)
      {
        TXCLog.e("network.TXCFLVDownloader", "error");
        this.mInputStream = null;
        this.mConnection = null;
      }
    }
    AppMethodBeat.o(67598);
  }
  
  private void reconnect()
  {
    AppMethodBeat.i(67602);
    processMsgDisConnect();
    if (this.connectRetryTimes < this.connectRetryLimit)
    {
      this.connectRetryTimes += 1;
      TXCLog.d("network.TXCFLVDownloader", "reconnect retry time:" + this.connectRetryTimes + ", limit:" + this.connectRetryLimit);
      processMsgConnect();
      sendNotifyEvent(2103);
      AppMethodBeat.o(67602);
      return;
    }
    TXCLog.e("network.TXCFLVDownloader", "reconnect all times retried, send failed event ");
    sendNotifyEvent(-2301);
    AppMethodBeat.o(67602);
  }
  
  private void startInternal()
  {
    AppMethodBeat.i(67601);
    if (this.mFlvThread == null)
    {
      this.mFlvThread = new HandlerThread("FlvThread");
      this.mFlvThread.start();
    }
    if (this.mFlvHandler == null) {
      this.mFlvHandler = new TXCFLVDownloader.1(this, this.mFlvThread.getLooper());
    }
    postConnectMsg();
    AppMethodBeat.o(67601);
  }
  
  public void PushAudioFrame(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(146790);
    nativePushAudioFrame(this.mFLVParser, paramArrayOfByte, paramInt1, paramLong, paramInt2);
    AppMethodBeat.o(146790);
  }
  
  public void PushVideoFrame(byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(146789);
    nativePushVideoFrame(this.mFLVParser, paramArrayOfByte, paramInt1, paramLong1, paramLong2, paramInt2);
    AppMethodBeat.o(146789);
  }
  
  public long getCurrentTS()
  {
    return this.mCurrentNalTs;
  }
  
  public TXCStreamDownloader.DownloadStats getDownloadStats()
  {
    AppMethodBeat.i(67609);
    TXCStreamDownloader.DownloadStats localDownloadStats = new TXCStreamDownloader.DownloadStats();
    localDownloadStats.afterParseAudioBytes = this.mStats.afterParseAudioBytes;
    localDownloadStats.afterParseVideoBytes = this.mStats.afterParseVideoBytes;
    localDownloadStats.beforeParseVideoBytes = this.mStats.beforeParseVideoBytes;
    localDownloadStats.beforeParseAudioBytes = this.mStats.beforeParseAudioBytes;
    localDownloadStats.videoGop = this.mStats.videoGop;
    localDownloadStats.startTS = this.mStats.startTS;
    localDownloadStats.dnsTS = this.mStats.dnsTS;
    localDownloadStats.connTS = this.mStats.connTS;
    localDownloadStats.firstAudioTS = this.mStats.firstAudioTS;
    localDownloadStats.firstVideoTS = this.mStats.firstVideoTS;
    localDownloadStats.serverIP = this.mStats.serverIP;
    AppMethodBeat.o(67609);
    return localDownloadStats;
  }
  
  public long getLastIFrameTS()
  {
    return this.mLastIFramelTs;
  }
  
  public String getRealStreamUrl()
  {
    AppMethodBeat.i(67607);
    if (this.mConnection != null)
    {
      String str = this.mConnection.getURL().toString();
      AppMethodBeat.o(67607);
      return str;
    }
    AppMethodBeat.o(67607);
    return null;
  }
  
  public native void nativePushAudioFrame(long paramLong1, byte[] paramArrayOfByte, int paramInt1, long paramLong2, int paramInt2);
  
  public native void nativePushVideoFrame(long paramLong1, byte[] paramArrayOfByte, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
  
  public void onRecvAudioData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(67613);
    if (!this.mbFirstAudio)
    {
      this.mbFirstAudio = true;
      this.mStats.firstAudioTS = TXCTimeUtil.getTimeTick();
      TXCLog.d("network.TXCFLVDownloader", "receive first audio with ts " + this.mStats.firstAudioTS);
    }
    TXCStreamDownloader.DownloadStats localDownloadStats = this.mStats;
    localDownloadStats.afterParseAudioBytes += paramArrayOfByte.length;
    super.onRecvAudioData(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(67613);
  }
  
  public void onRecvVideoData(byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(67612);
    if (!this.mbFirstVideo)
    {
      this.mbFirstVideo = true;
      this.mStats.firstVideoTS = TXCTimeUtil.getTimeTick();
      TXCLog.d("network.TXCFLVDownloader", "receive first video with ts " + this.mStats.firstVideoTS);
    }
    TXCStreamDownloader.DownloadStats localDownloadStats = this.mStats;
    localDownloadStats.afterParseVideoBytes += paramArrayOfByte.length;
    super.onRecvVideoData(paramArrayOfByte, paramInt1, paramLong1, paramLong2, paramInt2);
    AppMethodBeat.o(67612);
  }
  
  public void recvData(boolean paramBoolean)
  {
    this.mHandleDataInJava = paramBoolean;
  }
  
  public void startDownload(Vector<e> paramVector, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(67610);
    if (this.mIsRunning)
    {
      AppMethodBeat.o(67610);
      return;
    }
    if ((paramVector == null) || (paramVector.isEmpty()))
    {
      AppMethodBeat.o(67610);
      return;
    }
    this.mEnableMessage = paramBoolean3;
    this.mIsRunning = true;
    this.mPlayUrl = ((e)paramVector.get(0)).a;
    TXCLog.d("network.TXCFLVDownloader", "start pull with url " + this.mPlayUrl);
    startInternal();
    AppMethodBeat.o(67610);
  }
  
  public void stopDownload()
  {
    AppMethodBeat.i(67611);
    if (!this.mIsRunning)
    {
      AppMethodBeat.o(67611);
      return;
    }
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
      }
      AppMethodBeat.o(67611);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(67611);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.network.TXCFLVDownloader
 * JD-Core Version:    0.7.0.1
 */