package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
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
  private TXCRTMPDownloader.a mCurrentThread;
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
    AppMethodBeat.i(67460);
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
    AppMethodBeat.o(67460);
  }
  
  private void internalReconnect(boolean paramBoolean)
  {
    AppMethodBeat.i(67464);
    if (!this.mIsRunning)
    {
      AppMethodBeat.o(67464);
      return;
    }
    if ((this.mIsPlayRtmpAccStream) && (this.mLastNetworkType != b.d(this.mApplicationContext)))
    {
      this.mLastNetworkType = b.d(this.mApplicationContext);
      if (this.mRestartListener != null) {
        this.mRestartListener.onRestartDownloader();
      }
      AppMethodBeat.o(67464);
      return;
    }
    boolean bool = this.mQuicChannel;
    if (this.mIsPlayRtmpAccStream)
    {
      if (this.mEnableNearestIP) {
        break label279;
      }
      paramBoolean = false;
    }
    label279:
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
        AppMethodBeat.o(67464);
        return;
      }
      if (this.connectRetryTimes < this.connectRetryLimit)
      {
        this.connectRetryTimes += 1;
        TXCLog.d("network.TXCRTMPDownloader", "reconnect retry count:" + this.connectRetryTimes + " limit:" + this.connectRetryLimit);
        sendNotifyEvent(2103);
        startInternal();
        AppMethodBeat.o(67464);
        return;
      }
      TXCLog.e("network.TXCRTMPDownloader", "reconnect all times retried, send failed event ");
      sendNotifyEvent(-2301);
      AppMethodBeat.o(67464);
      return;
    }
  }
  
  private native TXCStreamDownloader.DownloadStats nativeGetStats(long paramLong);
  
  private native long nativeInitRtmpHandler(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2);
  
  private native void nativeStart(long paramLong);
  
  private native void nativeStop(long paramLong);
  
  private native void nativeUninitRtmpHandler(long paramLong);
  
  private void postReconnectMsg()
  {
    AppMethodBeat.i(67462);
    Message localMessage = new Message();
    localMessage.what = 101;
    if (this.mHandler != null) {
      this.mHandler.sendMessageDelayed(localMessage, this.connectRetryInterval * 1000);
    }
    AppMethodBeat.o(67462);
  }
  
  private void reconnect(boolean paramBoolean)
  {
    AppMethodBeat.i(67463);
    synchronized (this.mRTMPThreadLock)
    {
      if (this.mCurrentThread != null)
      {
        this.mCurrentThread.a();
        this.mCurrentThread = null;
      }
      if (this.mHandler != null) {
        this.mHandler.postDelayed(new TXCRTMPDownloader.1(this, paramBoolean), this.connectRetryInterval * 1000);
      }
      AppMethodBeat.o(67463);
      return;
    }
  }
  
  private void startInternal()
  {
    AppMethodBeat.i(67461);
    if (this.mQuicChannel) {
      this.mConnectCountQuic += 1;
    }
    synchronized (this.mRTMPThreadLock)
    {
      this.mCurrentThread = new TXCRTMPDownloader.a(this, this.mPlayUrl, this.mQuicChannel);
      this.mCurrentThread.start();
      AppMethodBeat.o(67461);
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
    AppMethodBeat.i(67469);
    synchronized (this.mRTMPThreadLock)
    {
      if (this.mCurrentThread != null)
      {
        TXCStreamDownloader.DownloadStats localDownloadStats = this.mCurrentThread.b();
        AppMethodBeat.o(67469);
        return localDownloadStats;
      }
      AppMethodBeat.o(67469);
      return null;
    }
  }
  
  public boolean isQuicChannel()
  {
    return this.mQuicChannel;
  }
  
  public void sendNotifyEvent(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(67466);
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (paramInt == 1) {}
      for (;;)
      {
        reconnect(bool);
        AppMethodBeat.o(67466);
        return;
        bool = false;
      }
    }
    super.sendNotifyEvent(paramInt);
    AppMethodBeat.o(67466);
  }
  
  public void sendNotifyEvent(int paramInt, String paramString)
  {
    AppMethodBeat.i(67465);
    if (paramString.isEmpty())
    {
      sendNotifyEvent(paramInt);
      AppMethodBeat.o(67465);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_MSG", paramString);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (this.mNotifyListener != null) {
      this.mNotifyListener.onNotifyEvent(paramInt, localBundle);
    }
    AppMethodBeat.o(67465);
  }
  
  public void startDownload(Vector<e> paramVector, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(67467);
    if (this.mIsRunning)
    {
      AppMethodBeat.o(67467);
      return;
    }
    if ((paramVector == null) || (paramVector.isEmpty()))
    {
      AppMethodBeat.o(67467);
      return;
    }
    this.mEnableMessage = paramBoolean3;
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
        break label276;
      }
    }
    label276:
    for (paramVector = "yes";; paramVector = "no")
    {
      TXCLog.d("network.TXCRTMPDownloader", paramVector);
      this.mConnectCountQuic = 0;
      this.mConnectCountTcp = 0;
      this.connectRetryTimes = 0;
      if (this.mThread == null)
      {
        this.mThread = new HandlerThread("RTMP_PULL");
        this.mThread.start();
      }
      this.mHandler = new TXCRTMPDownloader.2(this, this.mThread.getLooper());
      startInternal();
      AppMethodBeat.o(67467);
      return;
      i += 1;
      break;
    }
  }
  
  public void stopDownload()
  {
    AppMethodBeat.i(67468);
    if (!this.mIsRunning)
    {
      AppMethodBeat.o(67468);
      return;
    }
    this.mIsRunning = false;
    this.mVecPlayUrls.removeAllElements();
    this.mVecPlayUrls = null;
    this.mIsPlayRtmpAccStream = false;
    this.mEnableNearestIP = false;
    TXCLog.d("network.TXCRTMPDownloader", "stop pull");
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
      AppMethodBeat.o(67468);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.network.TXCRTMPDownloader
 * JD-Core Version:    0.7.0.1
 */