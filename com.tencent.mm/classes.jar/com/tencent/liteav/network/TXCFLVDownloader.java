package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
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
  private boolean mHandleDataInJava;
  private boolean mHasReceivedFirstAudio;
  private boolean mHasReceivedFirstVideo;
  private InputStream mInputStream;
  private long mLastIFramelTs;
  private byte[] mPacketBytes;
  private String mPlayUrl;
  private boolean mRecvData;
  private WeakReference<TXCFLVDownloader> mRefFLVDownloader;
  private TXCStreamDownloader.DownloadStats mStats;
  private boolean mStopJitter;
  
  public TXCFLVDownloader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(15310);
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
    this.mFlvHandler = null;
    this.mInputStream = null;
    this.mConnection = null;
    this.mPacketBytes = null;
    this.mRecvData = false;
    this.mContentLength = 0L;
    this.mDownloadedSize = 0L;
    this.mHandleDataInJava = false;
    this.mFLVParser = 0L;
    this.mCurrentNalTs = 0L;
    this.mLastIFramelTs = 0L;
    this.mStopJitter = true;
    this.mPlayUrl = "";
    this.mHasReceivedFirstVideo = false;
    this.mHasReceivedFirstAudio = false;
    this.mStats = null;
    this.mRefFLVDownloader = null;
    this.mStats = new TXCStreamDownloader.DownloadStats();
    this.mStats.afterParseAudioBytes = 0L;
    this.mStats.dnsTS = 0L;
    this.mStats.startTS = TXCTimeUtil.getTimeTick();
    apiLog("new flv download ".concat(String.valueOf(this)));
    AppMethodBeat.o(15310);
  }
  
  public TXCFLVDownloader(Context paramContext, TXCFLVDownloader paramTXCFLVDownloader)
  {
    super(paramContext);
    AppMethodBeat.i(15311);
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
    this.mFlvHandler = null;
    this.mInputStream = null;
    this.mConnection = null;
    this.mPacketBytes = null;
    this.mRecvData = false;
    this.mContentLength = 0L;
    this.mDownloadedSize = 0L;
    this.mHandleDataInJava = false;
    this.mFLVParser = 0L;
    this.mCurrentNalTs = 0L;
    this.mLastIFramelTs = 0L;
    this.mStopJitter = true;
    this.mPlayUrl = "";
    this.mHasReceivedFirstVideo = false;
    this.mHasReceivedFirstAudio = false;
    this.mStats = null;
    this.mRefFLVDownloader = null;
    this.mStats = new TXCStreamDownloader.DownloadStats();
    this.mStats.afterParseAudioBytes = 0L;
    this.mStats.dnsTS = 0L;
    this.mStats.startTS = TXCTimeUtil.getTimeTick();
    this.mRefFLVDownloader = new WeakReference(paramTXCFLVDownloader);
    apiLog("new multi flv download ".concat(String.valueOf(this)));
    AppMethodBeat.o(15311);
  }
  
  private void apiError(String paramString)
  {
    AppMethodBeat.i(229684);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    TXCLog.e("network.TXCFLVDownloader", "TXCFLVDownloader(" + hashCode() + ") " + str);
    AppMethodBeat.o(229684);
  }
  
  private void apiError(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(229688);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    TXCLog.e("network.TXCFLVDownloader", "TXCFLVDownloader(" + hashCode() + ") " + str, paramThrowable);
    AppMethodBeat.o(229688);
  }
  
  private void apiLog(String paramString)
  {
    AppMethodBeat.i(229681);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    TXCLog.i("network.TXCFLVDownloader", "TXCFLVDownloader (" + hashCode() + ") " + str);
    AppMethodBeat.o(229681);
  }
  
  private void connect()
  {
    AppMethodBeat.i(15323);
    if (this.mConnection != null)
    {
      this.mConnection.disconnect();
      this.mConnection = null;
    }
    apiLog("[FirstFramePath][Network] TXCFLVDownloader: start network connect. instance:" + hashCode() + " url:" + this.mPlayUrl);
    long l1 = System.currentTimeMillis();
    this.mConnection = ((HttpURLConnection)new URL(this.mPlayUrl).openConnection());
    this.mStats.dnsTS = TXCTimeUtil.getTimeTick();
    this.mConnection.setConnectTimeout(8000);
    this.mConnection.setReadTimeout(8000);
    this.mConnection.setRequestProperty("Accept-Encoding", "identity");
    this.mConnection.setInstanceFollowRedirects(true);
    Object localObject;
    if (this.mHeaders != null)
    {
      localObject = this.mHeaders.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        this.mConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    this.mConnection.connect();
    if (200 == this.mConnection.getResponseCode()) {
      this.mStats.connTS = TXCTimeUtil.getTimeTick();
    }
    for (;;)
    {
      this.mInputStream = this.mConnection.getInputStream();
      this.mPacketBytes = new byte[1388];
      this.mRecvData = false;
      this.mContentLength = this.mConnection.getContentLength();
      this.mDownloadedSize = 0L;
      this.mStats.serverIP = InetAddress.getByName(this.mConnection.getURL().getHost()).getHostAddress();
      localObject = "connect server success,ServerIp:" + this.mStats.serverIP;
      apiLog((String)localObject);
      long l2 = System.currentTimeMillis();
      apiLog("[FirstFramePath][Network] TXCFLVDownloader: connect server success. instance:" + hashCode() + " ip:" + this.mStats.serverIP + " cost:" + (l2 - l1) + " rspCode:" + this.mStats.errorCode);
      sendNotifyEvent(2001, (String)localObject);
      localObject = this.mConnection.getHeaderField("X-Tlive-SpanId");
      this.mStats.flvSessionKey = ((String)localObject);
      if (!TextUtils.isEmpty(this.mFlvSessionKey))
      {
        localObject = this.mConnection.getHeaderField(this.mFlvSessionKey);
        if (localObject != null)
        {
          apiLog("receive flvSessionKey ".concat(String.valueOf(localObject)));
          sendNotifyEvent(2031, (String)localObject);
        }
      }
      AppMethodBeat.o(15323);
      return;
      this.mStats.errorCode = this.mConnection.getResponseCode();
    }
  }
  
  private void disconnect()
  {
    AppMethodBeat.i(15325);
    apiLog("[Network]FLVDownloader disconnect.");
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
    AppMethodBeat.o(15325);
  }
  
  private native void nativeCleanData(long paramLong);
  
  private native int nativeGetAudioBytes(long paramLong);
  
  private native int nativeGetVideoBytes(long paramLong);
  
  private native int nativeGetVideoGop(long paramLong);
  
  private native long nativeInitFlvHander(String paramString1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString2, String paramString3);
  
  private native long nativeInitFlvHanderByRef(long paramLong, int paramInt, String paramString1, String paramString2);
  
  private native int nativeParseData(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native void nativeUninitFlvhander(long paramLong, boolean paramBoolean);
  
  private void onRecvFirstAudioData()
  {
    AppMethodBeat.i(229679);
    if (!this.mHasReceivedFirstAudio)
    {
      this.mHasReceivedFirstAudio = true;
      this.mStats.firstAudioTS = TXCTimeUtil.getTimeTick();
      apiLog("[FirstFramePath][Network][Audio] TXCFlvDownloader: recv first audio frame. instance:" + hashCode());
    }
    AppMethodBeat.o(229679);
  }
  
  private void onRecvFirstVideoData()
  {
    AppMethodBeat.i(229678);
    if (!this.mHasReceivedFirstVideo)
    {
      this.mHasReceivedFirstVideo = true;
      this.mStats.firstVideoTS = TXCTimeUtil.getTimeTick();
      apiLog("[FirstFramePath][Network][Video] TXCFlvDownloader: recv first video frame. instance:" + hashCode());
    }
    AppMethodBeat.o(229678);
  }
  
  private void postConnectMsg()
  {
    AppMethodBeat.i(15322);
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
    AppMethodBeat.o(15322);
  }
  
  private void postDisconnectMsg()
  {
    AppMethodBeat.i(15321);
    if (this.mFlvHandler != null) {
      this.mFlvHandler.sendEmptyMessage(102);
    }
    AppMethodBeat.o(15321);
  }
  
  private void postReconnectMsg()
  {
    AppMethodBeat.i(15320);
    if (this.mFlvHandler != null) {
      this.mFlvHandler.sendEmptyMessageDelayed(103, this.connectRetryInterval * 1000);
    }
    AppMethodBeat.o(15320);
  }
  
  private void processMsgConnect(e parame)
  {
    AppMethodBeat.i(229643);
    for (;;)
    {
      TXCFLVDownloader localTXCFLVDownloader;
      try
      {
        connect();
        if (this.mFLVParser == 0L)
        {
          if (this.mRefFLVDownloader == null) {
            break label471;
          }
          localTXCFLVDownloader = (TXCFLVDownloader)this.mRefFLVDownloader.get();
          if (localTXCFLVDownloader == null) {
            break label359;
          }
          if (localTXCFLVDownloader.mIsRunning)
          {
            apiLog("[Network]init flv parser with old downloader:" + localTXCFLVDownloader.hashCode());
            localTXCFLVDownloader.mStopJitter = false;
            l = localTXCFLVDownloader.mFLVParser;
            this.mRefFLVDownloader = null;
            if (l == 0L) {
              break label381;
            }
            apiLog("[Network]init flv parser with reference parse:".concat(String.valueOf(l)));
            if ((parame == null) || (!TXCCommonUtil.equalURL(parame.a(), this.mPlayUrl))) {
              break label364;
            }
            this.mFLVParser = nativeInitFlvHanderByRef(l, parame.b(), parame.c(), parame.d());
          }
        }
        else
        {
          if (this.mFlvHandler != null) {
            this.mFlvHandler.sendEmptyMessage(101);
          }
          AppMethodBeat.o(229643);
          return;
        }
      }
      catch (SocketTimeoutException parame)
      {
        apiError("[Network]socket timeout, reconnect");
        this.mStats.errorCode = -1;
        this.mStats.errorInfo = parame.toString();
        postReconnectMsg();
        AppMethodBeat.o(229643);
        return;
      }
      catch (FileNotFoundException parame)
      {
        apiError("[Network]file not found, reconnect");
        this.mStats.errorCode = -1;
        this.mStats.errorInfo = parame.toString();
        postReconnectMsg();
        AppMethodBeat.o(229643);
        return;
      }
      catch (Exception parame)
      {
        apiError("[Network]exception, reconnect");
        this.mStats.errorCode = -1;
        this.mStats.errorInfo = parame.toString();
        postReconnectMsg();
        AppMethodBeat.o(229643);
        return;
      }
      catch (Error parame)
      {
        apiError("[Network]error, reconnect");
        this.mStats.errorCode = -1;
        this.mStats.errorInfo = parame.toString();
        postReconnectMsg();
        AppMethodBeat.o(229643);
        return;
      }
      apiError("[Network]old downloader:" + localTXCFLVDownloader.hashCode() + " isn't running now. just create new parser.");
      label359:
      long l = 0L;
      continue;
      label364:
      this.mFLVParser = nativeInitFlvHanderByRef(l, 0, "", "");
      continue;
      label381:
      apiLog("[Network]init flv parser.");
      if ((parame != null) && (TXCCommonUtil.equalURL(parame.a(), this.mPlayUrl)))
      {
        this.mFLVParser = nativeInitFlvHander(this.mUserID, 0, this.mEnableMessage, this.mEnableMetaData, parame.b(), parame.c(), parame.d());
      }
      else
      {
        this.mFLVParser = nativeInitFlvHander(this.mUserID, 0, this.mEnableMessage, this.mEnableMetaData, 0, "", "");
        continue;
        label471:
        l = 0L;
      }
    }
  }
  
  private void processMsgDisConnect()
  {
    AppMethodBeat.i(15316);
    try
    {
      disconnect();
      if (this.mFLVParser != 0L)
      {
        nativeUninitFlvhander(this.mFLVParser, this.mStopJitter);
        this.mFLVParser = 0L;
      }
      AppMethodBeat.o(15316);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        apiError("disconnect failed.", localException);
      }
    }
  }
  
  private void processMsgReconnect(e parame)
  {
    AppMethodBeat.i(229652);
    if (this.mStopJitter)
    {
      reconnect(parame);
      AppMethodBeat.o(229652);
      return;
    }
    apiLog("ignore processMsgReconnect when start multi stream switch".concat(String.valueOf(this)));
    if (this.mRestartListener != null) {
      this.mRestartListener.onOldStreamStop();
    }
    AppMethodBeat.o(229652);
  }
  
  private void processMsgRecvData()
  {
    int i = 0;
    AppMethodBeat.i(15315);
    if (this.mInputStream != null) {
      try
      {
        int j = this.mInputStream.read(this.mPacketBytes, 0, 1388);
        if (j > 0)
        {
          this.mDownloadedSize += j;
          if (!this.mRecvData)
          {
            this.mRecvData = true;
            apiLog("[FirstFramePath][Network] TXCFLVDownloader: recv first data packet. instance:" + hashCode());
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
            apiError("[Network]flv play parse frame: " + i + " > 1048576,start reconnect");
            postReconnectMsg();
            AppMethodBeat.o(15315);
          }
        }
        else if (j < 0)
        {
          apiError("[Network]http read: " + j + " < 0, start reconnect");
          postReconnectMsg();
          AppMethodBeat.o(15315);
          return;
        }
        if (this.mFlvHandler != null) {
          this.mFlvHandler.sendEmptyMessage(101);
        }
        AppMethodBeat.o(15315);
        return;
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        apiError("[Network]socket timeout start reconnect");
        this.mStats.errorCode = -1;
        this.mStats.errorInfo = localSocketTimeoutException.toString();
        postReconnectMsg();
        AppMethodBeat.o(15315);
        return;
      }
      catch (SocketException localSocketException)
      {
        apiError("[Network]socket exception start reconnect");
        this.mStats.errorCode = -1;
        this.mStats.errorInfo = localSocketException.toString();
        postReconnectMsg();
        AppMethodBeat.o(15315);
        return;
      }
      catch (SSLException localSSLException)
      {
        apiError("[Network]ssl exception start reconnect");
        this.mStats.errorCode = -1;
        this.mStats.errorInfo = localSSLException.toString();
        postReconnectMsg();
        AppMethodBeat.o(15315);
        return;
      }
      catch (EOFException localEOFException)
      {
        apiError("[Network]eof exception start reconnect");
        this.mStats.errorCode = -1;
        this.mStats.errorInfo = localEOFException.toString();
        postReconnectMsg();
        AppMethodBeat.o(15315);
        return;
      }
      catch (Exception localException)
      {
        apiError("[Network]exception");
        this.mStats.errorCode = -1;
        this.mStats.errorInfo = localException.toString();
        this.mInputStream = null;
        this.mConnection = null;
        AppMethodBeat.o(15315);
        return;
      }
      catch (Error localError)
      {
        apiError("[Network]error");
        this.mStats.errorCode = -1;
        this.mStats.errorInfo = localError.toString();
        this.mInputStream = null;
        this.mConnection = null;
      }
    }
    AppMethodBeat.o(15315);
  }
  
  private void reconnect(e parame)
  {
    AppMethodBeat.i(229659);
    processMsgDisConnect();
    String str = "ServerIp:" + this.mStats.serverIP + ",errCode:" + this.mStats.errorCode + ",errInfo:" + this.mStats.errorInfo;
    apiLog("reconnect:".concat(String.valueOf(str)));
    if (this.connectRetryTimes < this.connectRetryLimit)
    {
      this.connectRetryTimes += 1;
      apiLog("[Network] start reconnect, times:" + this.connectRetryTimes + " limit:" + this.connectRetryLimit);
      processMsgConnect(parame);
      sendNotifyEvent(2103, str);
      AppMethodBeat.o(229659);
      return;
    }
    apiLog("[Network] reconnect fail. all times retried. limit:" + this.connectRetryLimit);
    sendNotifyEvent(-2301, str);
    AppMethodBeat.o(229659);
  }
  
  private void startInternal(final e parame)
  {
    AppMethodBeat.i(229656);
    if (this.mFlvHandler == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("FlvThread");
      localHandlerThread.start();
      apiLog("[Network] flv downloader thread id:" + localHandlerThread.getId() + " instance:" + hashCode());
      this.mFlvHandler = new Handler(localHandlerThread.getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(15468);
          switch (paramAnonymousMessage.what)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(15468);
            return;
            TXCFLVDownloader.access$000(TXCFLVDownloader.this, parame);
            AppMethodBeat.o(15468);
            return;
            TXCFLVDownloader.access$100(TXCFLVDownloader.this);
            AppMethodBeat.o(15468);
            return;
            TXCFLVDownloader.access$200(TXCFLVDownloader.this);
            AppMethodBeat.o(15468);
            return;
            TXCFLVDownloader.access$300(TXCFLVDownloader.this, parame);
            AppMethodBeat.o(15468);
            return;
            try
            {
              Looper.myLooper().quit();
              AppMethodBeat.o(15468);
              return;
            }
            catch (Exception paramAnonymousMessage) {}
          }
        }
      };
    }
    postConnectMsg();
    AppMethodBeat.o(229656);
  }
  
  public void PushAudioFrame(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(15313);
    nativePushAudioFrame(this.mFLVParser, paramArrayOfByte, paramInt1, paramLong, paramInt2);
    AppMethodBeat.o(15313);
  }
  
  public void PushVideoFrame(byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(15312);
    nativePushVideoFrame(this.mFLVParser, paramArrayOfByte, paramInt1, paramLong1, paramLong2, paramInt2);
    AppMethodBeat.o(15312);
  }
  
  public long getCurrentTS()
  {
    return this.mCurrentNalTs;
  }
  
  public TXCStreamDownloader.DownloadStats getDownloadStats()
  {
    AppMethodBeat.i(15326);
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
    localDownloadStats.flvSessionKey = this.mStats.flvSessionKey;
    localDownloadStats.errorCode = this.mStats.errorCode;
    localDownloadStats.errorInfo = this.mStats.errorInfo;
    AppMethodBeat.o(15326);
    return localDownloadStats;
  }
  
  public long getLastIFrameTS()
  {
    return this.mLastIFramelTs;
  }
  
  public String getRealStreamUrl()
  {
    AppMethodBeat.i(15324);
    if (this.mConnection != null)
    {
      String str = this.mConnection.getURL().toString();
      AppMethodBeat.o(15324);
      return str;
    }
    AppMethodBeat.o(15324);
    return null;
  }
  
  public boolean hasRecvAVData()
  {
    return (this.mHasReceivedFirstAudio) || (this.mHasReceivedFirstVideo);
  }
  
  public native void nativePushAudioFrame(long paramLong1, byte[] paramArrayOfByte, int paramInt1, long paramLong2, int paramInt2);
  
  public native void nativePushVideoFrame(long paramLong1, byte[] paramArrayOfByte, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
  
  public void onRecvAudioData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(15330);
    if (!this.mHasReceivedFirstAudio)
    {
      this.mHasReceivedFirstAudio = true;
      this.mStats.firstAudioTS = TXCTimeUtil.getTimeTick();
      apiLog("[FirstFramePath][Network][Audio] TXCFlvDownloader: recv first audio frame. instance:" + hashCode());
    }
    TXCStreamDownloader.DownloadStats localDownloadStats = this.mStats;
    localDownloadStats.afterParseAudioBytes += paramArrayOfByte.length;
    super.onRecvAudioData(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(15330);
  }
  
  public void onRecvVideoData(byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(15329);
    if (!this.mHasReceivedFirstVideo)
    {
      this.mHasReceivedFirstVideo = true;
      this.mStats.firstVideoTS = TXCTimeUtil.getTimeTick();
      apiLog("[FirstFramePath][Network][Video] TXCFlvDownloader: recv first video frame. instance:" + hashCode());
    }
    TXCStreamDownloader.DownloadStats localDownloadStats = this.mStats;
    localDownloadStats.afterParseVideoBytes += paramArrayOfByte.length;
    super.onRecvVideoData(paramArrayOfByte, paramInt1, paramLong1, paramLong2, paramInt2);
    AppMethodBeat.o(15329);
  }
  
  public void recvData(boolean paramBoolean)
  {
    this.mHandleDataInJava = paramBoolean;
  }
  
  public void startDownload(Vector<f> paramVector, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(15327);
    startDownload(paramVector, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, null);
    AppMethodBeat.o(15327);
  }
  
  public void startDownload(Vector<f> paramVector, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, e parame)
  {
    AppMethodBeat.i(229711);
    if (this.mIsRunning)
    {
      AppMethodBeat.o(229711);
      return;
    }
    if ((paramVector == null) || (paramVector.isEmpty()))
    {
      AppMethodBeat.o(229711);
      return;
    }
    this.mEnableMessage = paramBoolean3;
    this.mEnableMetaData = paramBoolean4;
    this.mIsRunning = true;
    this.mPlayUrl = ((f)paramVector.get(0)).a;
    apiLog("start pull with url " + this.mPlayUrl);
    startInternal(parame);
    AppMethodBeat.o(229711);
  }
  
  public void stopDownload()
  {
    AppMethodBeat.i(15328);
    if (!this.mIsRunning)
    {
      AppMethodBeat.o(15328);
      return;
    }
    this.mIsRunning = false;
    apiLog("stop pull");
    try
    {
      if (this.mFlvHandler != null)
      {
        this.mFlvHandler.removeCallbacksAndMessages(null);
        this.mFlvHandler.sendEmptyMessage(102);
        this.mFlvHandler.sendEmptyMessage(106);
        this.mFlvHandler = null;
      }
      AppMethodBeat.o(15328);
      return;
    }
    catch (Exception localException)
    {
      apiError("stop download failed.", localException);
      AppMethodBeat.o(15328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.network.TXCFLVDownloader
 * JD-Core Version:    0.7.0.1
 */