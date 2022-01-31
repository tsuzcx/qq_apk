package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import android.os.Environment;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.f.a;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.File;

public class TXCAudioBasePlayController
  implements d
{
  private static final String TAG = "AudioCenter:" + TXCAudioBasePlayController.class.getSimpleName();
  protected float mAutoAdjustMaxCache = com.tencent.liteav.audio.b.d;
  protected float mAutoAdjustMinCache = com.tencent.liteav.audio.b.e;
  protected float mCacheTime = com.tencent.liteav.audio.b.b;
  protected Context mContext;
  protected boolean mIsAutoAdjustCache = com.tencent.liteav.audio.b.c;
  protected boolean mIsHWAcceleration = false;
  protected boolean mIsMute = com.tencent.liteav.audio.b.f;
  protected volatile boolean mIsPlaying = false;
  protected boolean mIsRealTimePlay = false;
  protected long mJitterBuffer = 0L;
  protected d mListener;
  protected int mSmoothMode = 0;
  
  static
  {
    nativeSetTempPath(Environment.getExternalStorageDirectory().getAbsolutePath());
  }
  
  public TXCAudioBasePlayController(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static native byte[] nativeGetMixedTracksData(int paramInt);
  
  public static native boolean nativeIsTracksEmpty();
  
  public static native void nativeSetTempPath(String paramString);
  
  public static void setAudioMode(Context paramContext, int paramInt)
  {
    b.a(paramContext, paramInt);
    c.a(paramContext, paramInt);
  }
  
  public void enableAutojustCache(boolean paramBoolean)
  {
    TXCLog.i(TAG, "set auto adjust cache to " + paramBoolean);
    nativeEnableAutoAdjustCache(this.mJitterBuffer, paramBoolean);
    this.mIsAutoAdjustCache = paramBoolean;
  }
  
  public void enableHWAcceleration(boolean paramBoolean)
  {
    TXCLog.i(TAG, "set hw acceleration to " + paramBoolean);
    this.mIsHWAcceleration = paramBoolean;
  }
  
  public void enableRealTimePlay(boolean paramBoolean)
  {
    if (paramBoolean == this.mIsRealTimePlay) {
      return;
    }
    TXCLog.i(TAG, "set real-time play to " + paramBoolean);
    nativeEnableRealTimePlay(this.mJitterBuffer, paramBoolean);
    this.mIsRealTimePlay = paramBoolean;
  }
  
  public long getCacheDuration()
  {
    return nativeGetCacheDuration(this.mJitterBuffer);
  }
  
  public float getCacheThreshold()
  {
    return nativeGetCacheThreshold(this.mJitterBuffer);
  }
  
  public long getCurPts()
  {
    return nativeGetCurPts(this.mJitterBuffer);
  }
  
  public long getCurRecvTS()
  {
    return nativeGetNetRecvTS(this.mJitterBuffer);
  }
  
  public int getRecvJitter()
  {
    return nativeGetRecvJitter(this.mJitterBuffer);
  }
  
  public TXAudioJitterBufferReportInfo getReportInfo()
  {
    if ((this.mIsPlaying) && (this.mJitterBuffer != 0L)) {
      return nativeGetLoadingInfo(this.mJitterBuffer);
    }
    return null;
  }
  
  public boolean isPlaying()
  {
    return this.mIsPlaying;
  }
  
  protected native void nativeAddData(long paramLong1, byte[] paramArrayOfByte, int paramInt, long paramLong2);
  
  protected native long nativeCreateJitterBuffer(boolean paramBoolean, TXCAudioBasePlayController paramTXCAudioBasePlayController);
  
  protected native void nativeDestoryJitterBuffer(long paramLong);
  
  protected native void nativeEnableAutoAdjustCache(long paramLong, boolean paramBoolean);
  
  protected native void nativeEnableRealTimePlay(long paramLong, boolean paramBoolean);
  
  protected native long nativeGetCacheDuration(long paramLong);
  
  protected native float nativeGetCacheThreshold(long paramLong);
  
  protected native int nativeGetChannel(long paramLong);
  
  protected native long nativeGetCurPts(long paramLong);
  
  protected native TXAudioJitterBufferReportInfo nativeGetLoadingInfo(long paramLong);
  
  protected native long nativeGetNetRecvTS(long paramLong);
  
  protected native int nativeGetRecvJitter(long paramLong);
  
  protected native int nativeGetSamplerate(long paramLong);
  
  protected native void nativeSetAutoAdjustMaxCache(long paramLong, float paramFloat);
  
  protected native void nativeSetAutoAdjustMinCache(long paramLong, float paramFloat);
  
  protected native void nativeSetCacheTime(long paramLong, float paramFloat);
  
  protected native void nativeSetJitterCycle(long paramLong1, long paramLong2);
  
  protected native void nativeSetLoadingThreshold(long paramLong1, long paramLong2);
  
  protected native void nativeSetMute(long paramLong, boolean paramBoolean);
  
  protected native void nativeSetRealtimeJitterCycle(long paramLong1, long paramLong2);
  
  protected native void nativeSetSmoothMode(long paramLong1, long paramLong2);
  
  protected native void nativeSetSmoothSpeed(long paramLong, float paramFloat);
  
  public void onPlayAudioInfoChanged(a parama1, a parama2)
  {
    try
    {
      if (this.mListener != null) {
        this.mListener.onPlayAudioInfoChanged(parama1, parama2);
      }
      return;
    }
    finally
    {
      parama1 = finally;
      throw parama1;
    }
  }
  
  public void onPlayError(int paramInt, String paramString)
  {
    try
    {
      if (this.mListener != null) {
        this.mListener.onPlayError(paramInt, paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onPlayJitterStateNotify(int paramInt)
  {
    try
    {
      TXCLog.e(TAG, "onPlayJitterStateNotify  cur state " + paramInt);
      if (this.mListener != null) {
        this.mListener.onPlayJitterStateNotify(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onPlayPcmData(byte[] paramArrayOfByte, long paramLong)
  {
    try
    {
      if (this.mListener != null) {
        this.mListener.onPlayPcmData(paramArrayOfByte, paramLong);
      }
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public int playData(a parama)
  {
    return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
  }
  
  public void setAutoAdjustMaxCache(float paramFloat)
  {
    TXCLog.i(TAG, "set auto adjust max cache to " + paramFloat);
    nativeSetAutoAdjustMaxCache(this.mJitterBuffer, paramFloat);
    this.mAutoAdjustMaxCache = paramFloat;
  }
  
  public void setAutoAdjustMinCache(float paramFloat)
  {
    TXCLog.i(TAG, "set auto adjust min cache to " + paramFloat);
    nativeSetAutoAdjustMinCache(this.mJitterBuffer, paramFloat);
    this.mAutoAdjustMinCache = paramFloat;
  }
  
  public void setCacheTime(float paramFloat)
  {
    TXCLog.i(TAG, "set cache time to " + paramFloat);
    nativeSetCacheTime(this.mJitterBuffer, paramFloat);
    this.mCacheTime = paramFloat;
  }
  
  public void setListener(d paramd)
  {
    try
    {
      this.mListener = paramd;
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (paramBoolean != this.mIsMute) {
      nativeSetMute(this.mJitterBuffer, paramBoolean);
    }
    TXCLog.i(TAG, "set mute to " + paramBoolean);
    this.mIsMute = paramBoolean;
  }
  
  public void setSmootheMode(int paramInt)
  {
    TXCLog.i(TAG, "set careful mode to " + paramInt);
    this.mSmoothMode = paramInt;
  }
  
  public int startPlay()
  {
    this.mIsPlaying = true;
    return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
  }
  
  public int stopPlay()
  {
    this.mIsPlaying = false;
    this.mCacheTime = com.tencent.liteav.audio.b.b;
    this.mIsAutoAdjustCache = com.tencent.liteav.audio.b.c;
    this.mAutoAdjustMaxCache = com.tencent.liteav.audio.b.d;
    this.mAutoAdjustMinCache = com.tencent.liteav.audio.b.e;
    this.mIsRealTimePlay = false;
    this.mIsHWAcceleration = false;
    this.mIsMute = com.tencent.liteav.audio.b.f;
    this.mSmoothMode = 0;
    return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.TXCAudioBasePlayController
 * JD-Core Version:    0.7.0.1
 */