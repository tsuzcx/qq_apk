package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.util.Vector;

public class TXCRTMPDownloader
  extends TXIStreamDownloader
{
  private final int MSG_EVENT = 102;
  private final int MSG_RECONNECT = 101;
  private final String TAG = "network.TXCRTMPDownloader";
  private int mConnectCountQuic = 0;
  private int mConnectCountTcp = 0;
  private TXCRTMPDownloader.a mCurrentThread = null;
  private boolean mEnableNearestIP = false;
  private Handler mHandler = null;
  private boolean mHasTcpPlayUrl;
  private boolean mIsPlayRtmpAccStream = false;
  private int mLastNetworkType = 255;
  private String mPlayUrl = "";
  private boolean mQuicChannel = false;
  private Object mRTMPThreadLock = null;
  private String mServerIp = "";
  private HandlerThread mThread = null;
  private Vector<e> mVecPlayUrls;
  
  public TXCRTMPDownloader(Context paramContext)
  {
    super(paramContext);
  }
  
  private void internalReconnect(boolean paramBoolean)
  {
    if (!this.mIsRunning) {}
    do
    {
      return;
      if ((!this.mIsPlayRtmpAccStream) || (this.mLastNetworkType == com.tencent.liteav.basic.util.a.c(this.mApplicationContext))) {
        break;
      }
      this.mLastNetworkType = com.tencent.liteav.basic.util.a.c(this.mApplicationContext);
    } while (this.mRestartListener == null);
    this.mRestartListener.onRestartDownloader();
    return;
    boolean bool = this.mQuicChannel;
    if (this.mIsPlayRtmpAccStream)
    {
      if (this.mEnableNearestIP) {
        break label242;
      }
      paramBoolean = false;
    }
    label242:
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
        sendNotifyEvent(12015);
        startInternal();
        return;
      }
      if (this.connectRetryTimes < this.connectRetryLimit)
      {
        this.connectRetryTimes += 1;
        TXCLog.d("network.TXCRTMPDownloader", "reconnect retry count:" + this.connectRetryTimes + " limit:" + this.connectRetryLimit);
        sendNotifyEvent(12015);
        startInternal();
        return;
      }
      sendNotifyEvent(12012);
      return;
    }
  }
  
  private native TXCStreamDownloader.DownloadStats nativeGetStats(long paramLong);
  
  private native long nativeInitRtmpHandler(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  private native void nativeStart(long paramLong);
  
  private native void nativeStop(long paramLong);
  
  private native void nativeUninitRtmpHandler(long paramLong);
  
  private void postReconnectMsg()
  {
    Message localMessage = new Message();
    localMessage.what = 101;
    if (this.mHandler != null) {
      this.mHandler.sendMessageDelayed(localMessage, this.connectRetryInterval * 1000);
    }
  }
  
  private void reconnect(boolean paramBoolean)
  {
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
      return;
    }
  }
  
  private void startInternal()
  {
    if (this.mQuicChannel) {
      this.mConnectCountQuic += 1;
    }
    synchronized (this.mRTMPThreadLock)
    {
      this.mCurrentThread = new TXCRTMPDownloader.a(this, this.mPlayUrl, this.mQuicChannel);
      this.mCurrentThread.start();
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
    synchronized (this.mRTMPThreadLock)
    {
      if (this.mCurrentThread != null)
      {
        TXCStreamDownloader.DownloadStats localDownloadStats = this.mCurrentThread.b();
        return localDownloadStats;
      }
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
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (paramInt == 1) {}
      for (;;)
      {
        reconnect(bool);
        return;
        bool = false;
      }
    }
    super.sendNotifyEvent(paramInt);
  }
  
  public void sendNotifyEvent(int paramInt, String paramString)
  {
    if (paramString.isEmpty()) {
      sendNotifyEvent(paramInt);
    }
    Bundle localBundle;
    do
    {
      return;
      localBundle = new Bundle();
      localBundle.putString("EVT_MSG", paramString);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    } while (this.mNotifyListener == null);
    this.mNotifyListener.onNotifyEvent(paramInt, localBundle);
  }
  
  public void startDownload(Vector<e> paramVector, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.mIsRunning) {}
    while ((paramVector == null) || (paramVector.isEmpty())) {
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
        break label251;
      }
    }
    label251:
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
      return;
      i += 1;
      break;
    }
  }
  
  public void stopDownload()
  {
    if (!this.mIsRunning) {}
    for (;;)
    {
      return;
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
        if (this.mHandler == null) {
          continue;
        }
        this.mHandler = null;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.network.TXCRTMPDownloader
 * JD-Core Version:    0.7.0.1
 */