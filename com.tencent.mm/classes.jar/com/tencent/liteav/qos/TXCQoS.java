package com.tencent.liteav.qos;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;

public class TXCQoS
{
  public static final int AUTO_ADJUST_LIVEPUSH_RESOLUTION_STRATEGY = 1;
  public static final int AUTO_ADJUST_REALTIME_VIDEOCHAT_STRATEGY = 5;
  static final String TAG = "TXCQos";
  private int mAutoStrategy = -1;
  private int mBitrate = 0;
  private Handler mHandler = new Handler();
  private int mHeight = 0;
  private long mInstance;
  private long mInterval = 1000L;
  private boolean mIsEnableDrop = false;
  private a mListener;
  private com.tencent.liteav.basic.c.a mNotifyListener;
  private Runnable mRunnable = new Runnable()
  {
    public void run()
    {
      int i;
      int j;
      int k;
      Bundle localBundle;
      if (TXCQoS.this.mListener != null)
      {
        i = TXCQoS.this.mListener.onGetEncoderRealBitrate();
        j = TXCQoS.this.mListener.onGetQueueInputSize();
        k = TXCQoS.this.mListener.onGetQueueOutputSize();
        int m = TXCQoS.this.mListener.onGetVideoQueueMaxCount();
        int n = TXCQoS.this.mListener.onGetVideoQueueCurrentCount();
        int i1 = TXCQoS.this.mListener.onGetVideoDropCount();
        TXCQoS.this.nativeSetVideoRealBitrate(TXCQoS.this.mInstance, i);
        TXCQoS.this.nativeAdjustBitrate(TXCQoS.this.mInstance, m, n, i1, k, j);
        boolean bool = TXCQoS.this.nativeIsEnableDrop(TXCQoS.this.mInstance);
        if (TXCQoS.this.mIsEnableDrop != bool)
        {
          TXCQoS.access$502(TXCQoS.this, bool);
          TXCQoS.this.mListener.onEnableDropStatusChanged(bool);
        }
        i = TXCQoS.this.nativeGetBitrate(TXCQoS.this.mInstance);
        j = TXCQoS.this.nativeGetWidth(TXCQoS.this.mInstance);
        k = TXCQoS.this.nativeGetHeight(TXCQoS.this.mInstance);
        if ((j == TXCQoS.this.mWidth) && (k == TXCQoS.this.mHeight)) {
          break label418;
        }
        if ((TXCQoS.this.mAutoStrategy == 1) || (TXCQoS.this.mAutoStrategy == 5))
        {
          TXCQoS.this.mListener.onEncoderParamsChanged(i, j, k);
          if (TXCQoS.this.mNotifyListener != null)
          {
            localBundle = new Bundle();
            localBundle.putCharSequence("EVT_MSG", "调整分辨率:new bitrate:" + i + " new resolution:" + j + "*" + k);
            localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            TXCQoS.this.mNotifyListener.onNotifyEvent(1005, localBundle);
          }
        }
      }
      for (;;)
      {
        TXCQoS.access$1302(TXCQoS.this, i);
        TXCQoS.access$902(TXCQoS.this, j);
        TXCQoS.access$1002(TXCQoS.this, k);
        TXCQoS.this.mHandler.postDelayed(this, TXCQoS.this.mInterval);
        return;
        label418:
        if (i != TXCQoS.this.mBitrate)
        {
          TXCQoS.this.mListener.onEncoderParamsChanged(i, 0, 0);
          if (TXCQoS.this.mNotifyListener != null)
          {
            localBundle = new Bundle();
            localBundle.putCharSequence("EVT_MSG", "调整编码码率:new bitrate:" + i);
            localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            localBundle.putLong("EVT_USERID", TXCQoS.this.mUserID);
            TXCQoS.this.mNotifyListener.onNotifyEvent(1006, localBundle);
          }
        }
      }
    }
  };
  private long mUserID = 0L;
  private int mWidth = 0;
  
  static {}
  
  public TXCQoS(boolean paramBoolean)
  {
    this.mInstance = nativeInit(paramBoolean);
  }
  
  private native void nativeAddQueueInputSize(long paramLong, int paramInt);
  
  private native void nativeAddQueueOutputSize(long paramLong, int paramInt);
  
  private native void nativeAdjustBitrate(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private native void nativeDeinit(long paramLong);
  
  private native int nativeGetBitrate(long paramLong);
  
  private native int nativeGetHeight(long paramLong);
  
  public static native int nativeGetProperResolutionByVideoBitrate(boolean paramBoolean, int paramInt1, int paramInt2);
  
  private native int nativeGetWidth(long paramLong);
  
  private native long nativeInit(boolean paramBoolean);
  
  private native boolean nativeIsEnableDrop(long paramLong);
  
  private native void nativeReset(long paramLong, boolean paramBoolean);
  
  private native void nativeSetAutoAdjustBitrate(long paramLong, boolean paramBoolean);
  
  private native void nativeSetAutoAdjustStrategy(long paramLong, int paramInt);
  
  private native void nativeSetHasVideo(long paramLong, boolean paramBoolean);
  
  private native void nativeSetVideoDefaultResolution(long paramLong, int paramInt);
  
  private native void nativeSetVideoEncBitrate(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private native void nativeSetVideoExpectBitrate(long paramLong, int paramInt);
  
  private native void nativeSetVideoRealBitrate(long paramLong, int paramInt);
  
  protected void finalize()
  {
    try
    {
      nativeDeinit(this.mInstance);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public long getUserID()
  {
    return this.mUserID;
  }
  
  public boolean isEnableDrop()
  {
    return nativeIsEnableDrop(this.mInstance);
  }
  
  public void reset(boolean paramBoolean)
  {
    nativeReset(this.mInstance, paramBoolean);
  }
  
  public void setAutoAdjustBitrate(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("autoAdjustBitrate is ");
    if (paramBoolean) {}
    for (String str = "yes";; str = "no")
    {
      TXCLog.d("TXCQos", str);
      nativeSetAutoAdjustBitrate(this.mInstance, paramBoolean);
      return;
    }
  }
  
  public void setAutoAdjustStrategy(int paramInt)
  {
    TXCLog.d("TXCQos", "autoAdjustStrategy is " + paramInt);
    nativeSetAutoAdjustStrategy(this.mInstance, paramInt);
    this.mAutoStrategy = paramInt;
  }
  
  public void setDefaultVideoResolution(int paramInt)
  {
    TXCLog.d("TXCQos", "DefaultVideoResolution is " + paramInt);
    this.mWidth = 0;
    this.mHeight = 0;
    nativeSetVideoDefaultResolution(this.mInstance, paramInt);
  }
  
  public void setHasVideo(boolean paramBoolean)
  {
    nativeSetHasVideo(this.mInstance, paramBoolean);
  }
  
  public void setListener(a parama)
  {
    this.mListener = parama;
  }
  
  public void setNotifyListener(com.tencent.liteav.basic.c.a parama)
  {
    this.mNotifyListener = parama;
  }
  
  public void setUserID(long paramLong)
  {
    this.mUserID = paramLong;
  }
  
  public void setVideoEncBitrate(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mBitrate = 0;
    nativeSetVideoEncBitrate(this.mInstance, paramInt1, paramInt2, paramInt3);
  }
  
  public void setVideoExpectBitrate(int paramInt)
  {
    nativeSetVideoExpectBitrate(this.mInstance, paramInt);
  }
  
  public void start(long paramLong)
  {
    this.mInterval = paramLong;
    this.mHandler.postDelayed(this.mRunnable, this.mInterval);
  }
  
  public void stop()
  {
    this.mHandler.removeCallbacks(this.mRunnable);
    this.mAutoStrategy = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.qos.TXCQoS
 * JD-Core Version:    0.7.0.1
 */