package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import android.os.Environment;
import com.tencent.liteav.audio.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;

public class TXCAudioBasePlayController
  implements com.tencent.liteav.audio.c
{
  private static final String TAG;
  private static WeakReference<com.tencent.liteav.audio.c> mAudioCoreListener;
  protected float mAutoAdjustMaxCache = a.c;
  protected float mAutoAdjustMinCache = a.d;
  protected float mCacheTime = a.a;
  protected Context mContext;
  protected boolean mEnableVolumeLevelCal = false;
  protected boolean mIsAutoAdjustCache = a.b;
  protected boolean mIsHWAcceleration = false;
  protected boolean mIsMute = a.e;
  protected volatile boolean mIsPlaying = false;
  protected boolean mIsRealTimePlay = false;
  protected long mJitterBuffer = 0L;
  protected com.tencent.liteav.audio.c mListener;
  protected int mSmoothMode = 0;
  protected int mStreamFormat = 0;
  protected String mUserID = null;
  
  static
  {
    AppMethodBeat.i(66623);
    TAG = "AudioCenter:" + TXCAudioBasePlayController.class.getSimpleName();
    mAudioCoreListener = null;
    nativeSetTempPath(Environment.getExternalStorageDirectory().getAbsolutePath());
    AppMethodBeat.o(66623);
  }
  
  public TXCAudioBasePlayController(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static native void nativeEnableCoreplayVolumeLevelCal(boolean paramBoolean);
  
  public static native int nativeGetCorePlayVolumeLevel();
  
  public static native byte[] nativeGetMixedTracksData(int paramInt);
  
  public static native boolean nativeIsTracksEmpty();
  
  public static native void nativeSetTempPath(String paramString);
  
  public static void onCorePlayPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146216);
    if (mAudioCoreListener != null)
    {
      com.tencent.liteav.audio.c localc = (com.tencent.liteav.audio.c)mAudioCoreListener.get();
      if (localc != null) {
        localc.onPlayPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(146216);
  }
  
  public static void setAudioCorePlayListener(com.tencent.liteav.audio.c paramc)
  {
    AppMethodBeat.i(146215);
    mAudioCoreListener = new WeakReference(paramc);
    AppMethodBeat.o(146215);
  }
  
  public static void setAudioMode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(66604);
    b.a(paramContext, paramInt);
    c.a(paramContext, paramInt);
    AppMethodBeat.o(66604);
  }
  
  public void enableAutojustCache(boolean paramBoolean)
  {
    AppMethodBeat.i(66606);
    TXCLog.i(TAG, "set auto adjust cache to ".concat(String.valueOf(paramBoolean)));
    nativeEnableAutoAdjustCache(this.mJitterBuffer, paramBoolean);
    this.mIsAutoAdjustCache = paramBoolean;
    AppMethodBeat.o(66606);
  }
  
  public void enableHWAcceleration(boolean paramBoolean)
  {
    AppMethodBeat.i(66609);
    TXCLog.i(TAG, "set hw acceleration to ".concat(String.valueOf(paramBoolean)));
    this.mIsHWAcceleration = paramBoolean;
    AppMethodBeat.o(66609);
  }
  
  public void enableRealTimePlay(boolean paramBoolean)
  {
    AppMethodBeat.i(66612);
    if (paramBoolean == this.mIsRealTimePlay)
    {
      AppMethodBeat.o(66612);
      return;
    }
    TXCLog.i(TAG, "set real-time play to ".concat(String.valueOf(paramBoolean)));
    nativeEnableRealTimePlay(this.mJitterBuffer, paramBoolean);
    this.mIsRealTimePlay = paramBoolean;
    AppMethodBeat.o(66612);
  }
  
  public float getCacheThreshold()
  {
    AppMethodBeat.i(66617);
    float f = nativeGetCacheThreshold(this.mJitterBuffer);
    AppMethodBeat.o(66617);
    return f;
  }
  
  public TXAudioJitterBufferReportInfo getReportInfo()
  {
    AppMethodBeat.i(66613);
    if ((this.mIsPlaying) && (this.mJitterBuffer != 0L))
    {
      TXAudioJitterBufferReportInfo localTXAudioJitterBufferReportInfo = nativeGetLoadingInfo(this.mJitterBuffer);
      AppMethodBeat.o(66613);
      return localTXAudioJitterBufferReportInfo;
    }
    AppMethodBeat.o(66613);
    return null;
  }
  
  public int getVolumeLevel()
  {
    AppMethodBeat.i(146219);
    if (this.mEnableVolumeLevelCal)
    {
      int i = nativeGetVolumeLevel(this.mJitterBuffer);
      AppMethodBeat.o(146219);
      return i;
    }
    AppMethodBeat.o(146219);
    return 0;
  }
  
  public boolean isPlaying()
  {
    return this.mIsPlaying;
  }
  
  protected native long nativeCreateJitterBuffer(boolean paramBoolean, TXCAudioBasePlayController paramTXCAudioBasePlayController, int paramInt);
  
  protected native void nativeDestoryJitterBuffer(long paramLong);
  
  protected native void nativeEnableAutoAdjustCache(long paramLong, boolean paramBoolean);
  
  protected native void nativeEnableRealTimePlay(long paramLong, boolean paramBoolean);
  
  protected native void nativeEnableVolumeLevelCal(long paramLong, boolean paramBoolean);
  
  protected native float nativeGetCacheThreshold(long paramLong);
  
  protected native TXAudioJitterBufferReportInfo nativeGetLoadingInfo(long paramLong);
  
  protected native int nativeGetVolumeLevel(long paramLong);
  
  protected native void nativeSetAutoAdjustMaxCache(long paramLong, float paramFloat);
  
  protected native void nativeSetAutoAdjustMinCache(long paramLong, float paramFloat);
  
  protected native void nativeSetCacheTime(long paramLong, float paramFloat);
  
  protected native void nativeSetJitterCycle(long paramLong1, long paramLong2);
  
  protected native void nativeSetLoadingThreshold(long paramLong1, long paramLong2);
  
  protected native void nativeSetMute(long paramLong, boolean paramBoolean);
  
  protected native void nativeSetRTCPlayHungryTimeThreshold(long paramLong, int paramInt);
  
  protected native void nativeSetRealtimeJitterCycle(long paramLong1, long paramLong2);
  
  protected native void nativeSetSmoothAdjust(long paramLong1, long paramLong2);
  
  protected native void nativeSetSmoothMode(long paramLong1, long paramLong2);
  
  protected native void nativeSetSmoothSpeed(long paramLong, float paramFloat);
  
  protected native void nativeSetUserID(long paramLong, String paramString);
  
  public void onPlayError(int paramInt, String paramString)
  {
    try
    {
      AppMethodBeat.i(66620);
      if (this.mListener != null) {
        this.mListener.onPlayError(paramInt, paramString);
      }
      AppMethodBeat.o(66620);
      return;
    }
    finally {}
  }
  
  public void onPlayJitterStateNotify(int paramInt)
  {
    try
    {
      AppMethodBeat.i(66621);
      TXCLog.e(TAG, "onPlayJitterStateNotify  cur state ".concat(String.valueOf(paramInt)));
      if (this.mListener != null) {
        this.mListener.onPlayJitterStateNotify(paramInt);
      }
      AppMethodBeat.o(66621);
      return;
    }
    finally {}
  }
  
  public void onPlayPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146221);
    if (this.mListener != null) {
      this.mListener.onPlayPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2);
    }
    AppMethodBeat.o(146221);
  }
  
  public void setAutoAdjustMaxCache(float paramFloat)
  {
    AppMethodBeat.i(66607);
    TXCLog.i(TAG, "set auto adjust max cache to ".concat(String.valueOf(paramFloat)));
    nativeSetAutoAdjustMaxCache(this.mJitterBuffer, paramFloat);
    this.mAutoAdjustMaxCache = paramFloat;
    AppMethodBeat.o(66607);
  }
  
  public void setAutoAdjustMinCache(float paramFloat)
  {
    AppMethodBeat.i(66608);
    TXCLog.i(TAG, "set auto adjust min cache to ".concat(String.valueOf(paramFloat)));
    nativeSetAutoAdjustMinCache(this.mJitterBuffer, paramFloat);
    this.mAutoAdjustMinCache = paramFloat;
    AppMethodBeat.o(66608);
  }
  
  public void setCacheTime(float paramFloat)
  {
    AppMethodBeat.i(66605);
    TXCLog.i(TAG, "set cache time to ".concat(String.valueOf(paramFloat)));
    nativeSetCacheTime(this.mJitterBuffer, paramFloat);
    this.mCacheTime = paramFloat;
    AppMethodBeat.o(66605);
  }
  
  public void setEnableVolumeLevelCal(boolean paramBoolean)
  {
    AppMethodBeat.i(146218);
    this.mEnableVolumeLevelCal = paramBoolean;
    nativeEnableVolumeLevelCal(this.mJitterBuffer, paramBoolean);
    AppMethodBeat.o(146218);
  }
  
  public void setListener(com.tencent.liteav.audio.c paramc)
  {
    try
    {
      this.mListener = paramc;
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(66618);
    if (paramBoolean != this.mIsMute) {
      nativeSetMute(this.mJitterBuffer, paramBoolean);
    }
    TXCLog.i(TAG, "set mute to ".concat(String.valueOf(paramBoolean)));
    this.mIsMute = paramBoolean;
    AppMethodBeat.o(66618);
  }
  
  public void setSmootheMode(int paramInt)
  {
    AppMethodBeat.i(66610);
    TXCLog.i(TAG, "set careful mode to ".concat(String.valueOf(paramInt)));
    this.mSmoothMode = paramInt;
    AppMethodBeat.o(66610);
  }
  
  public int setStreamFormat(int paramInt)
  {
    AppMethodBeat.i(146220);
    if (paramInt == this.mStreamFormat)
    {
      AppMethodBeat.o(146220);
      return -104;
    }
    this.mStreamFormat = paramInt;
    if (this.mJitterBuffer == 0L)
    {
      this.mJitterBuffer = nativeCreateJitterBuffer(false, this, this.mStreamFormat);
      if (this.mJitterBuffer == 0L) {
        break label320;
      }
      nativeSetSmoothMode(this.mJitterBuffer, this.mSmoothMode);
      nativeSetSmoothAdjust(this.mJitterBuffer, com.tencent.liteav.basic.e.b.a().a("Audio", "SmoothAdjust"));
      nativeSetCacheTime(this.mJitterBuffer, this.mCacheTime);
      nativeSetMute(this.mJitterBuffer, this.mIsMute);
      nativeEnableRealTimePlay(this.mJitterBuffer, this.mIsRealTimePlay);
      nativeEnableAutoAdjustCache(this.mJitterBuffer, this.mIsAutoAdjustCache);
      nativeSetAutoAdjustMaxCache(this.mJitterBuffer, this.mAutoAdjustMaxCache);
      nativeSetAutoAdjustMinCache(this.mJitterBuffer, this.mAutoAdjustMinCache);
      nativeEnableVolumeLevelCal(this.mJitterBuffer, this.mEnableVolumeLevelCal);
      setUserID(this.mUserID);
      nativeSetSmoothSpeed(this.mJitterBuffer, com.tencent.liteav.basic.e.b.a().b("Audio", "SmoothSpeed"));
      nativeSetJitterCycle(this.mJitterBuffer, com.tencent.liteav.basic.e.b.a().a("Audio", "LIVE_JitterCycle"));
      nativeSetRealtimeJitterCycle(this.mJitterBuffer, com.tencent.liteav.basic.e.b.a().a("Audio", "RTC_JitterCycle"));
      nativeSetLoadingThreshold(this.mJitterBuffer, com.tencent.liteav.basic.e.b.a().a("Audio", "LoadingThreshold"));
      nativeSetRTCPlayHungryTimeThreshold(this.mJitterBuffer, (int)com.tencent.liteav.basic.e.b.a().a("Audio", "RtcPlayHungryTimeThreshold"));
    }
    for (;;)
    {
      TXCLog.e(TAG, "soft dec, create jitterbuffer with id " + this.mJitterBuffer);
      AppMethodBeat.o(146220);
      return 0;
      label320:
      TXCLog.e(TAG, "soft dec, create jitterbuffer failed!!");
    }
  }
  
  public void setUserID(String paramString)
  {
    AppMethodBeat.i(146217);
    this.mUserID = paramString;
    if (this.mUserID != null) {
      nativeSetUserID(this.mJitterBuffer, this.mUserID);
    }
    AppMethodBeat.o(146217);
  }
  
  public int startPlay()
  {
    this.mIsPlaying = true;
    return 0;
  }
  
  public int stopPlay()
  {
    this.mIsPlaying = false;
    this.mCacheTime = a.a;
    this.mIsAutoAdjustCache = a.b;
    this.mAutoAdjustMaxCache = a.c;
    this.mAutoAdjustMinCache = a.d;
    this.mIsRealTimePlay = false;
    this.mIsHWAcceleration = false;
    this.mIsMute = a.e;
    this.mSmoothMode = 0;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.TXCAudioBasePlayController
 * JD-Core Version:    0.7.0.1
 */