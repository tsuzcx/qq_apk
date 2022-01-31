package com.tencent.liteav.qos;

import android.os.Handler;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCQoS
{
  public static final int AUTO_ADJUST_LIVEPUSH_RESOLUTION_STRATEGY = 1;
  public static final int AUTO_ADJUST_REALTIME_VIDEOCHAT_STRATEGY = 5;
  static final String TAG = "TXCQos";
  private int mAutoStrategy;
  private int mBitrate;
  private Handler mHandler;
  private int mHeight;
  private long mInstance;
  private long mInterval;
  private boolean mIsEnableDrop;
  private a mListener;
  private com.tencent.liteav.basic.c.a mNotifyListener;
  private Runnable mRunnable;
  private String mUserID;
  private int mWidth;
  
  static
  {
    AppMethodBeat.i(66821);
    b.f();
    AppMethodBeat.o(66821);
  }
  
  public TXCQoS(boolean paramBoolean)
  {
    AppMethodBeat.i(66803);
    this.mInterval = 1000L;
    this.mUserID = "";
    this.mIsEnableDrop = false;
    this.mBitrate = 0;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mAutoStrategy = -1;
    this.mHandler = new Handler();
    this.mRunnable = new TXCQoS.1(this);
    this.mInstance = nativeInit(paramBoolean);
    AppMethodBeat.o(66803);
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
    AppMethodBeat.i(66804);
    try
    {
      nativeDeinit(this.mInstance);
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(66804);
    }
  }
  
  public String getUserID()
  {
    return this.mUserID;
  }
  
  public boolean isEnableDrop()
  {
    AppMethodBeat.i(66808);
    boolean bool = nativeIsEnableDrop(this.mInstance);
    AppMethodBeat.o(66808);
    return bool;
  }
  
  public void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(66807);
    nativeReset(this.mInstance, paramBoolean);
    AppMethodBeat.o(66807);
  }
  
  public void setAutoAdjustBitrate(boolean paramBoolean)
  {
    AppMethodBeat.i(66810);
    StringBuilder localStringBuilder = new StringBuilder("autoAdjustBitrate is ");
    if (paramBoolean) {}
    for (String str = "yes";; str = "no")
    {
      TXCLog.d("TXCQos", str);
      nativeSetAutoAdjustBitrate(this.mInstance, paramBoolean);
      AppMethodBeat.o(66810);
      return;
    }
  }
  
  public void setAutoAdjustStrategy(int paramInt)
  {
    AppMethodBeat.i(66811);
    TXCLog.d("TXCQos", "autoAdjustStrategy is ".concat(String.valueOf(paramInt)));
    nativeSetAutoAdjustStrategy(this.mInstance, paramInt);
    this.mAutoStrategy = paramInt;
    AppMethodBeat.o(66811);
  }
  
  public void setDefaultVideoResolution(int paramInt)
  {
    AppMethodBeat.i(66812);
    TXCLog.d("TXCQos", "DefaultVideoResolution is ".concat(String.valueOf(paramInt)));
    this.mWidth = 0;
    this.mHeight = 0;
    nativeSetVideoDefaultResolution(this.mInstance, paramInt);
    AppMethodBeat.o(66812);
  }
  
  public void setHasVideo(boolean paramBoolean)
  {
    AppMethodBeat.i(66809);
    nativeSetHasVideo(this.mInstance, paramBoolean);
    AppMethodBeat.o(66809);
  }
  
  public void setListener(a parama)
  {
    this.mListener = parama;
  }
  
  public void setNotifyListener(com.tencent.liteav.basic.c.a parama)
  {
    this.mNotifyListener = parama;
  }
  
  public void setUserID(String paramString)
  {
    this.mUserID = paramString;
  }
  
  public void setVideoEncBitrate(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(66813);
    this.mBitrate = 0;
    nativeSetVideoEncBitrate(this.mInstance, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(66813);
  }
  
  public void setVideoExpectBitrate(int paramInt)
  {
    AppMethodBeat.i(66814);
    nativeSetVideoExpectBitrate(this.mInstance, paramInt);
    AppMethodBeat.o(66814);
  }
  
  public void start(long paramLong)
  {
    AppMethodBeat.i(66805);
    this.mInterval = paramLong;
    this.mHandler.postDelayed(this.mRunnable, this.mInterval);
    AppMethodBeat.o(66805);
  }
  
  public void stop()
  {
    AppMethodBeat.i(66806);
    this.mHandler.removeCallbacks(this.mRunnable);
    this.mAutoStrategy = -1;
    AppMethodBeat.o(66806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.qos.TXCQoS
 * JD-Core Version:    0.7.0.1
 */