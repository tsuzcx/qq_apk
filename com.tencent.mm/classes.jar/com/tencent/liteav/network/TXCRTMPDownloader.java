package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Vector;

public class TXCRTMPDownloader
  extends TXIStreamDownloader
{
  private final int MSG_EVENT;
  private final int MSG_RECONNECT;
  private final String TAG;
  private int mConnectCountQuic;
  private int mConnectCountTcp;
  private a mCurrentThread;
  private boolean mEnableNearestIP;
  private Handler mHandler;
  private boolean mHasTcpPlayUrl;
  private boolean mIsPlayRtmpAccStream;
  private int mLastNetworkType;
  private String mPlayUrl;
  private boolean mQuicChannel;
  private Object mRTMPThreadLock;
  private String mServerIp;
  private HandlerThread mThread;
  private Vector<e> mVecPlayUrls;
  
  public TXCRTMPDownloader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(15470);
    this.TAG = "network.TXCRTMPDownloader";
    this.MSG_RECONNECT = 101;
    this.MSG_EVENT = 102;
    this.mPlayUrl = "";
    this.mQuicChannel = false;
    this.mServerIp = "";
    this.mCurrentThread = null;
    this.mRTMPThreadLock = null;
    this.mThread = null;
    this.mHandler = null;
    this.mIsPlayRtmpAccStream = false;
    this.mEnableNearestIP = false;
    this.mConnectCountQuic = 0;
    this.mConnectCountTcp = 0;
    this.mLastNetworkType = 0;
    this.mRTMPThreadLock = new Object();
    AppMethodBeat.o(15470);
  }
  
  private void internalReconnect(boolean paramBoolean)
  {
    AppMethodBeat.i(15474);
    if (!this.mIsRunning)
    {
      AppMethodBeat.o(15474);
      return;
    }
    if ((this.mIsPlayRtmpAccStream) && (this.mLastNetworkType != h.e(this.mApplicationContext)))
    {
      this.mLastNetworkType = h.e(this.mApplicationContext);
      if (this.mRestartListener != null) {
        this.mRestartListener.onRestartDownloader();
      }
      AppMethodBeat.o(15474);
      return;
    }
    boolean bool = this.mQuicChannel;
    if (this.mIsPlayRtmpAccStream)
    {
      if (this.mEnableNearestIP) {
        break label285;
      }
      paramBoolean = false;
    }
    label285:
    for (;;)
    {
      if (bool) {
        paramBoolean = true;
      }
      if ((paramBoolean) && (this.mVecPlayUrls != null) && (!this.mVecPlayUrls.isEmpty()))
      {
        e locale = (e)this.mVecPlayUrls.get(0);
        this.mVecPlayUrls.remove(0);
        this.mPlayUrl = locale.a;
        this.mQuicChannel = locale.b;
      }
      if ((bool) && (this.mHasTcpPlayUrl))
      {
        sendNotifyEvent(2103);
        startInternal();
        AppMethodBeat.o(15474);
        return;
      }
      if (this.connectRetryTimes < this.connectRetryLimit)
      {
        this.connectRetryTimes += 1;
        TXCLog.i("network.TXCRTMPDownloader", "reconnect retry count:" + this.connectRetryTimes + " limit:" + this.connectRetryLimit);
        sendNotifyEvent(2103);
        startInternal();
        AppMethodBeat.o(15474);
        return;
      }
      TXCLog.e("network.TXCRTMPDownloader", "reconnect all times retried, send failed event ");
      sendNotifyEvent(-2301);
      AppMethodBeat.o(15474);
      return;
    }
  }
  
  private native TXCStreamDownloader.DownloadStats nativeGetStats(long paramLong);
  
  private native long nativeInitRtmpHandler(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  private native void nativeRequestKeyFrame(long paramLong, String paramString);
  
  private native void nativeStart(long paramLong);
  
  private native void nativeStop(long paramLong);
  
  private native void nativeUninitRtmpHandler(long paramLong);
  
  private void postReconnectMsg()
  {
    AppMethodBeat.i(15472);
    Message localMessage = new Message();
    localMessage.what = 101;
    if (this.mHandler != null) {
      this.mHandler.sendMessageDelayed(localMessage, this.connectRetryInterval * 1000);
    }
    AppMethodBeat.o(15472);
  }
  
  private void reconnect(final boolean paramBoolean)
  {
    AppMethodBeat.i(15473);
    synchronized (this.mRTMPThreadLock)
    {
      if (this.mCurrentThread != null)
      {
        this.mCurrentThread.a();
        this.mCurrentThread = null;
      }
      if (this.mHandler != null) {
        this.mHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(15455);
            TXCRTMPDownloader.access$600(TXCRTMPDownloader.this, paramBoolean);
            AppMethodBeat.o(15455);
          }
        }, this.connectRetryInterval * 1000);
      }
      AppMethodBeat.o(15473);
      return;
    }
  }
  
  private void startInternal()
  {
    AppMethodBeat.i(15471);
    if (this.mQuicChannel) {
      this.mConnectCountQuic += 1;
    }
    synchronized (this.mRTMPThreadLock)
    {
      this.mCurrentThread = new a(this.mPlayUrl, this.mQuicChannel);
      this.mCurrentThread.start();
      AppMethodBeat.o(15471);
      return;
      this.mConnectCountTcp += 1;
    }
  }
  
  public int getConnectCountQuic()
  {
    return this.mConnectCountQuic;
  }
  
  public int getConnectCountTcp()
  {
    return this.mConnectCountTcp;
  }
  
  public String getCurrentStreamUrl()
  {
    return this.mPlayUrl;
  }
  
  public TXCStreamDownloader.DownloadStats getDownloadStats()
  {
    AppMethodBeat.i(15479);
    synchronized (this.mRTMPThreadLock)
    {
      if (this.mCurrentThread != null)
      {
        TXCStreamDownloader.DownloadStats localDownloadStats = this.mCurrentThread.b();
        AppMethodBeat.o(15479);
        return localDownloadStats;
      }
      AppMethodBeat.o(15479);
      return null;
    }
  }
  
  public boolean isQuicChannel()
  {
    return this.mQuicChannel;
  }
  
  public void requestKeyFrame(String paramString)
  {
    AppMethodBeat.i(15480);
    synchronized (this.mRTMPThreadLock)
    {
      if (this.mCurrentThread != null) {
        this.mCurrentThread.a(paramString);
      }
      AppMethodBeat.o(15480);
      return;
    }
  }
  
  public void sendNotifyEvent(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(15476);
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (paramInt == 1) {}
      for (;;)
      {
        reconnect(bool);
        AppMethodBeat.o(15476);
        return;
        bool = false;
      }
    }
    super.sendNotifyEvent(paramInt);
    AppMethodBeat.o(15476);
  }
  
  public void sendNotifyEvent(int paramInt, String paramString)
  {
    AppMethodBeat.i(15475);
    if (paramString.isEmpty())
    {
      sendNotifyEvent(paramInt);
      AppMethodBeat.o(15475);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_MSG", paramString);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    if (this.mNotifyListener != null) {
      this.mNotifyListener.onNotifyEvent(paramInt, localBundle);
    }
    AppMethodBeat.o(15475);
  }
  
  public void startDownload(Vector<e> paramVector, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(15477);
    if (this.mIsRunning)
    {
      AppMethodBeat.o(15477);
      return;
    }
    if ((paramVector == null) || (paramVector.isEmpty()))
    {
      AppMethodBeat.o(15477);
      return;
    }
    this.mEnableMessage = paramBoolean3;
    this.mEnableMetaData = paramBoolean4;
    this.mIsPlayRtmpAccStream = paramBoolean1;
    this.mEnableNearestIP = paramBoolean2;
    this.mVecPlayUrls = paramVector;
    this.mHasTcpPlayUrl = false;
    int i = 0;
    StringBuilder localStringBuilder;
    if (i < this.mVecPlayUrls.size())
    {
      if (!((e)this.mVecPlayUrls.elementAt(i)).b) {
        this.mHasTcpPlayUrl = true;
      }
    }
    else
    {
      paramVector = (e)this.mVecPlayUrls.get(0);
      this.mVecPlayUrls.remove(0);
      this.mPlayUrl = paramVector.a;
      this.mQuicChannel = paramVector.b;
      this.mIsRunning = true;
      localStringBuilder = new StringBuilder("start pull with url:").append(this.mPlayUrl).append(" quic:");
      if (!this.mQuicChannel) {
        break label282;
      }
    }
    label282:
    for (paramVector = "yes";; paramVector = "no")
    {
      TXCLog.i("network.TXCRTMPDownloader", paramVector);
      this.mConnectCountQuic = 0;
      this.mConnectCountTcp = 0;
      this.connectRetryTimes = 0;
      if (this.mThread == null)
      {
        this.mThread = new HandlerThread("RTMP_PULL");
        this.mThread.start();
      }
      this.mHandler = new Handler(this.mThread.getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(15386);
          if (paramAnonymousMessage.what == 101) {
            TXCRTMPDownloader.access$700(TXCRTMPDownloader.this);
          }
          AppMethodBeat.o(15386);
        }
      };
      startInternal();
      AppMethodBeat.o(15477);
      return;
      i += 1;
      break;
    }
  }
  
  public void stopDownload()
  {
    AppMethodBeat.i(15478);
    if (!this.mIsRunning)
    {
      AppMethodBeat.o(15478);
      return;
    }
    this.mIsRunning = false;
    this.mVecPlayUrls.removeAllElements();
    this.mVecPlayUrls = null;
    this.mIsPlayRtmpAccStream = false;
    this.mEnableNearestIP = false;
    TXCLog.i("network.TXCRTMPDownloader", "stop pull");
    synchronized (this.mRTMPThreadLock)
    {
      if (this.mCurrentThread != null)
      {
        this.mCurrentThread.a();
        this.mCurrentThread = null;
      }
      if (this.mThread != null)
      {
        this.mThread.quit();
        this.mThread = null;
      }
      if (this.mHandler != null) {
        this.mHandler = null;
      }
      AppMethodBeat.o(15478);
      return;
    }
  }
  
  class a
    extends Thread
  {
    private long b = 0L;
    private String c;
    private boolean d;
    
    a(String paramString, boolean paramBoolean)
    {
      super();
      this.c = paramString;
      this.d = paramBoolean;
    }
    
    public void a()
    {
      AppMethodBeat.i(15410);
      try
      {
        if (this.b != 0L) {
          TXCRTMPDownloader.access$300(TXCRTMPDownloader.this, this.b);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(15410);
      }
    }
    
    public void a(String paramString)
    {
      AppMethodBeat.i(15412);
      try
      {
        if (this.b != 0L) {
          TXCRTMPDownloader.access$500(TXCRTMPDownloader.this, this.b, paramString);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(15412);
      }
    }
    
    public TXCStreamDownloader.DownloadStats b()
    {
      AppMethodBeat.i(15411);
      TXCStreamDownloader.DownloadStats localDownloadStats = null;
      try
      {
        if (this.b != 0L) {
          localDownloadStats = TXCRTMPDownloader.access$400(TXCRTMPDownloader.this, this.b);
        }
        return localDownloadStats;
      }
      finally
      {
        AppMethodBeat.o(15411);
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: sipush 15409
      //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: monitorenter
      //   8: aload_0
      //   9: aload_0
      //   10: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
      //   13: aload_0
      //   14: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
      //   17: getfield 57	com/tencent/liteav/network/TXCRTMPDownloader:mUserID	Ljava/lang/String;
      //   20: aload_0
      //   21: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
      //   24: getfield 60	com/tencent/liteav/network/TXCRTMPDownloader:mOriginUrl	Ljava/lang/String;
      //   27: aload_0
      //   28: getfield 27	com/tencent/liteav/network/TXCRTMPDownloader$a:c	Ljava/lang/String;
      //   31: aload_0
      //   32: getfield 29	com/tencent/liteav/network/TXCRTMPDownloader$a:d	Z
      //   35: aload_0
      //   36: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
      //   39: getfield 63	com/tencent/liteav/network/TXCRTMPDownloader:mEnableMessage	Z
      //   42: aload_0
      //   43: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
      //   46: getfield 66	com/tencent/liteav/network/TXCRTMPDownloader:mEnableMetaData	Z
      //   49: invokestatic 70	com/tencent/liteav/network/TXCRTMPDownloader:access$000	(Lcom/tencent/liteav/network/TXCRTMPDownloader;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)J
      //   52: putfield 25	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
      //   55: aload_0
      //   56: monitorexit
      //   57: aload_0
      //   58: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
      //   61: aload_0
      //   62: getfield 25	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
      //   65: invokestatic 73	com/tencent/liteav/network/TXCRTMPDownloader:access$100	(Lcom/tencent/liteav/network/TXCRTMPDownloader;J)V
      //   68: aload_0
      //   69: monitorenter
      //   70: aload_0
      //   71: getfield 18	com/tencent/liteav/network/TXCRTMPDownloader$a:a	Lcom/tencent/liteav/network/TXCRTMPDownloader;
      //   74: aload_0
      //   75: getfield 25	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
      //   78: invokestatic 76	com/tencent/liteav/network/TXCRTMPDownloader:access$200	(Lcom/tencent/liteav/network/TXCRTMPDownloader;J)V
      //   81: aload_0
      //   82: lconst_0
      //   83: putfield 25	com/tencent/liteav/network/TXCRTMPDownloader$a:b	J
      //   86: aload_0
      //   87: monitorexit
      //   88: sipush 15409
      //   91: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   94: return
      //   95: astore_1
      //   96: aload_0
      //   97: monitorexit
      //   98: sipush 15409
      //   101: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   104: aload_1
      //   105: athrow
      //   106: astore_1
      //   107: aload_0
      //   108: monitorexit
      //   109: sipush 15409
      //   112: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   115: aload_1
      //   116: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	117	0	this	a
      //   95	10	1	localObject1	Object
      //   106	10	1	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   8	57	95	finally
      //   70	88	106	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.TXCRTMPDownloader
 * JD-Core Version:    0.7.0.1
 */