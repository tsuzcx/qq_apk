package com.tencent.liteav.qos;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.liteav.basic.b.c;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TXCQoS
{
  public static final int AUTO_ADJUST_LIVEPUSH_RESOLUTION_STRATEGY = 1;
  public static final int AUTO_ADJUST_REALTIME_VIDEOCHAT_STRATEGY = 5;
  private static final Map<Integer, c> RESOLUTION_MAP;
  static final String TAG = "TXCQos";
  private int mAutoStrategy;
  private int mBitrate;
  private Handler mHandler;
  private int mHeight;
  private long mInstance;
  private long mInterval;
  private boolean mIsEnableDrop;
  private a mListener;
  private b mNotifyListener;
  private Runnable mRunnable;
  private String mUserID;
  private int mWidth;
  
  static
  {
    AppMethodBeat.i(16221);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), c.b);
    localHashMap.put(Integer.valueOf(1), c.c);
    localHashMap.put(Integer.valueOf(2), c.d);
    localHashMap.put(Integer.valueOf(3), c.e);
    localHashMap.put(Integer.valueOf(4), c.f);
    localHashMap.put(Integer.valueOf(5), c.g);
    localHashMap.put(Integer.valueOf(6), c.h);
    localHashMap.put(Integer.valueOf(7), c.i);
    localHashMap.put(Integer.valueOf(8), c.j);
    localHashMap.put(Integer.valueOf(9), c.k);
    localHashMap.put(Integer.valueOf(10), c.l);
    localHashMap.put(Integer.valueOf(11), c.m);
    localHashMap.put(Integer.valueOf(12), c.n);
    localHashMap.put(Integer.valueOf(13), c.o);
    localHashMap.put(Integer.valueOf(14), c.p);
    localHashMap.put(Integer.valueOf(15), c.q);
    localHashMap.put(Integer.valueOf(16), c.r);
    localHashMap.put(Integer.valueOf(17), c.s);
    localHashMap.put(Integer.valueOf(18), c.t);
    localHashMap.put(Integer.valueOf(19), c.u);
    RESOLUTION_MAP = Collections.unmodifiableMap(localHashMap);
    h.d();
    AppMethodBeat.o(16221);
  }
  
  public TXCQoS(boolean paramBoolean)
  {
    AppMethodBeat.i(16203);
    this.mInterval = 1000L;
    this.mUserID = "";
    this.mIsEnableDrop = false;
    this.mBitrate = 0;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mAutoStrategy = -1;
    this.mHandler = new Handler();
    this.mRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16202);
        int i;
        int j;
        int k;
        Bundle localBundle;
        if (TXCQoS.this.mListener != null)
        {
          i = TXCQoS.this.mListener.a();
          j = TXCQoS.this.mListener.b();
          k = TXCQoS.this.mListener.c();
          int m = TXCQoS.this.mListener.d();
          int n = TXCQoS.this.mListener.e();
          int i1 = TXCQoS.this.mListener.f();
          int i2 = TXCQoS.this.mListener.g();
          TXCQoS.access$200(TXCQoS.this, TXCQoS.this.mInstance, i);
          TXCQoS.access$300(TXCQoS.this, TXCQoS.this.mInstance, m, n, i1, k, j, i2);
          boolean bool = TXCQoS.access$400(TXCQoS.this, TXCQoS.this.mInstance);
          if (TXCQoS.this.mIsEnableDrop != bool)
          {
            TXCQoS.access$502(TXCQoS.this, bool);
            TXCQoS.this.mListener.a(bool);
          }
          i = TXCQoS.access$600(TXCQoS.this, TXCQoS.this.mInstance);
          j = TXCQoS.access$700(TXCQoS.this, TXCQoS.this.mInstance);
          k = TXCQoS.access$800(TXCQoS.this, TXCQoS.this.mInstance);
          if ((j == TXCQoS.this.mWidth) && (k == TXCQoS.this.mHeight)) {
            break label446;
          }
          if ((TXCQoS.this.mAutoStrategy == 1) || (TXCQoS.this.mAutoStrategy == 5))
          {
            TXCQoS.this.mListener.a(i, j, k);
            if (TXCQoS.this.mNotifyListener != null)
            {
              localBundle = new Bundle();
              localBundle.putCharSequence("EVT_MSG", "Adjust resolution:new bitrate:" + i + " new resolution:" + j + "*" + k);
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
          AppMethodBeat.o(16202);
          return;
          label446:
          if (i != TXCQoS.this.mBitrate)
          {
            TXCQoS.this.mListener.a(i, 0, 0);
            if (TXCQoS.this.mNotifyListener != null)
            {
              localBundle = new Bundle();
              localBundle.putCharSequence("EVT_MSG", "Adjust encoding bitrate:new bitrate:".concat(String.valueOf(i)));
              localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
              localBundle.putString("EVT_USERID", TXCQoS.this.mUserID);
              TXCQoS.this.mNotifyListener.onNotifyEvent(1006, localBundle);
            }
          }
        }
      }
    };
    this.mInstance = nativeInit(paramBoolean);
    AppMethodBeat.o(16203);
  }
  
  public static c getProperResolutionByVideoBitrate(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229477);
    paramInt1 = nativeGetProperResolutionByVideoBitrate(paramBoolean, paramInt1, paramInt2);
    c localc = (c)RESOLUTION_MAP.get(Integer.valueOf(paramInt1));
    AppMethodBeat.o(229477);
    return localc;
  }
  
  private native void nativeAddQueueInputSize(long paramLong, int paramInt);
  
  private native void nativeAddQueueOutputSize(long paramLong, int paramInt);
  
  private native void nativeAdjustBitrate(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  private native void nativeDeinit(long paramLong);
  
  private native int nativeGetBitrate(long paramLong);
  
  private native int nativeGetHeight(long paramLong);
  
  private static native int nativeGetProperResolutionByVideoBitrate(boolean paramBoolean, int paramInt1, int paramInt2);
  
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
    AppMethodBeat.i(16204);
    try
    {
      nativeDeinit(this.mInstance);
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(16204);
    }
  }
  
  public String getUserID()
  {
    return this.mUserID;
  }
  
  public boolean isEnableDrop()
  {
    AppMethodBeat.i(16208);
    boolean bool = nativeIsEnableDrop(this.mInstance);
    AppMethodBeat.o(16208);
    return bool;
  }
  
  public void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(16207);
    nativeReset(this.mInstance, paramBoolean);
    AppMethodBeat.o(16207);
  }
  
  public void setAutoAdjustBitrate(boolean paramBoolean)
  {
    AppMethodBeat.i(16210);
    StringBuilder localStringBuilder = new StringBuilder("autoAdjustBitrate is ");
    if (paramBoolean) {}
    for (String str = "yes";; str = "no")
    {
      TXCLog.i("TXCQos", str);
      nativeSetAutoAdjustBitrate(this.mInstance, paramBoolean);
      AppMethodBeat.o(16210);
      return;
    }
  }
  
  public void setAutoAdjustStrategy(int paramInt)
  {
    AppMethodBeat.i(16211);
    TXCLog.i("TXCQos", "autoAdjustStrategy is ".concat(String.valueOf(paramInt)));
    nativeSetAutoAdjustStrategy(this.mInstance, paramInt);
    this.mAutoStrategy = paramInt;
    AppMethodBeat.o(16211);
  }
  
  public void setDefaultVideoResolution(c paramc)
  {
    AppMethodBeat.i(229623);
    TXCLog.i("TXCQos", "DefaultVideoResolution is ".concat(String.valueOf(paramc)));
    this.mWidth = 0;
    this.mHeight = 0;
    Iterator localIterator = RESOLUTION_MAP.entrySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() != paramc) {
        break label111;
      }
      i = ((Integer)localEntry.getKey()).intValue();
    }
    label111:
    for (;;)
    {
      break;
      nativeSetVideoDefaultResolution(this.mInstance, i);
      AppMethodBeat.o(229623);
      return;
    }
  }
  
  public void setHasVideo(boolean paramBoolean)
  {
    AppMethodBeat.i(16209);
    nativeSetHasVideo(this.mInstance, paramBoolean);
    AppMethodBeat.o(16209);
  }
  
  public void setListener(a parama)
  {
    this.mListener = parama;
  }
  
  public void setNotifyListener(b paramb)
  {
    this.mNotifyListener = paramb;
  }
  
  public void setUserID(String paramString)
  {
    this.mUserID = paramString;
  }
  
  public void setVideoEncBitrate(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16213);
    this.mBitrate = 0;
    nativeSetVideoEncBitrate(this.mInstance, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(16213);
  }
  
  public void setVideoExpectBitrate(int paramInt)
  {
    AppMethodBeat.i(16214);
    nativeSetVideoExpectBitrate(this.mInstance, paramInt);
    AppMethodBeat.o(16214);
  }
  
  public void start(long paramLong)
  {
    AppMethodBeat.i(16205);
    this.mInterval = paramLong;
    this.mHandler.postDelayed(this.mRunnable, this.mInterval);
    AppMethodBeat.o(16205);
  }
  
  public void stop()
  {
    AppMethodBeat.i(16206);
    this.mHandler.removeCallbacks(this.mRunnable);
    this.mAutoStrategy = -1;
    AppMethodBeat.o(16206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.qos.TXCQoS
 * JD-Core Version:    0.7.0.1
 */