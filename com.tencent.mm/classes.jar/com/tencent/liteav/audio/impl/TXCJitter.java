package com.tencent.liteav.audio.impl;

import com.tencent.liteav.audio.c;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TXCJitter
{
  private static final String TAG = "TXCJitter";
  private static WeakReference<d> mAudioCoreDataListener;
  protected float mAutoAdjustMaxCache = 5.0F;
  protected float mAutoAdjustMinCache = 1.0F;
  protected float mCacheTime = 5.0F;
  protected WeakReference<d> mDataListener;
  protected boolean mEnableVolumeLevelCal = false;
  protected WeakReference<c> mEventListener;
  protected boolean mIsAutoAdjustCache = true;
  protected boolean mIsPlayMute = false;
  protected volatile boolean mIsPlaying = false;
  protected boolean mIsRealTimePlay = false;
  protected long mJitterBuffer = 0L;
  protected boolean mMuteInSpeaker = false;
  protected int mPlayVolume = 100;
  protected int mSmoothMode = 0;
  protected String mUserID = null;
  
  static
  {
    AppMethodBeat.i(16498);
    f.f();
    mAudioCoreDataListener = null;
    AppMethodBeat.o(16498);
  }
  
  public TXCJitter(String paramString)
  {
    this.mUserID = paramString;
  }
  
  public static void EnableCoreplayVolumeLevelCal(boolean paramBoolean)
  {
    AppMethodBeat.i(16497);
    nativeEnableCoreplayVolumeLevelCal(paramBoolean);
    AppMethodBeat.o(16497);
  }
  
  public static int GetCorePlayVolumeLevel()
  {
    AppMethodBeat.i(16496);
    int i = nativeGetCorePlayVolumeLevel();
    AppMethodBeat.o(16496);
    return i;
  }
  
  public static native void nativeEnableCoreplayVolumeLevelCal(boolean paramBoolean);
  
  public static native int nativeGetCorePlayVolumeLevel();
  
  public static native boolean nativeIsTracksEmpty();
  
  public static native void nativePlayAfterCorePlayCallback(byte[] paramArrayOfByte, int paramInt);
  
  public static native void nativeSetCorePlayListener(boolean paramBoolean);
  
  public static native boolean nativeStopAllTracks();
  
  public static void onCorePlayPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16478);
    if (mAudioCoreDataListener != null)
    {
      d locald = (d)mAudioCoreDataListener.get();
      if (locald != null) {
        locald.onAudioPlayPcmData(null, paramArrayOfByte, paramLong, paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(16478);
  }
  
  public static void setAudioCorePlayListener(d paramd)
  {
    boolean bool2 = false;
    AppMethodBeat.i(16477);
    mAudioCoreDataListener = new WeakReference(paramd);
    StringBuilder localStringBuilder = new StringBuilder(" setAudioCorePlayListener: ");
    if (paramd == null)
    {
      bool1 = false;
      TXCLog.i("TXCJitter", bool1);
      if (paramd != null) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      nativeSetCorePlayListener(bool1);
      AppMethodBeat.o(16477);
      return;
      bool1 = true;
      break;
    }
  }
  
  public void enableAutojustCache(boolean paramBoolean)
  {
    AppMethodBeat.i(16480);
    TXCLog.i("TXCJitter", "set auto adjust cache to ".concat(String.valueOf(paramBoolean)));
    if (this.mJitterBuffer == 0L) {
      this.mIsAutoAdjustCache = paramBoolean;
    }
    AppMethodBeat.o(16480);
  }
  
  public void enableRealTimePlay(boolean paramBoolean)
  {
    AppMethodBeat.i(16483);
    if (paramBoolean == this.mIsRealTimePlay)
    {
      AppMethodBeat.o(16483);
      return;
    }
    TXCLog.i("TXCJitter", "set real-time play to ".concat(String.valueOf(paramBoolean)));
    if (this.mJitterBuffer == 0L) {
      this.mIsRealTimePlay = paramBoolean;
    }
    AppMethodBeat.o(16483);
  }
  
  public void enableVolumeLevelCal(boolean paramBoolean)
  {
    AppMethodBeat.i(16484);
    this.mEnableVolumeLevelCal = paramBoolean;
    if (this.mJitterBuffer != 0L) {
      nativeEnableVolumeLevelCal(this.mJitterBuffer, paramBoolean);
    }
    AppMethodBeat.o(16484);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(16476);
    if (this.mJitterBuffer != 0L)
    {
      nativeDestoryJitterBuffer(this.mJitterBuffer);
      this.mJitterBuffer = 0L;
    }
    AppMethodBeat.o(16476);
  }
  
  public int getVolumeLevel()
  {
    AppMethodBeat.i(16485);
    if ((this.mJitterBuffer != 0L) && (this.mEnableVolumeLevelCal))
    {
      int i = nativeGetVolumeLevel(this.mJitterBuffer);
      AppMethodBeat.o(16485);
      return i;
    }
    AppMethodBeat.o(16485);
    return 0;
  }
  
  public boolean isPlaying()
  {
    return this.mIsPlaying;
  }
  
  public void muteInSpeaker(boolean paramBoolean)
  {
    AppMethodBeat.i(16489);
    if (paramBoolean != this.mMuteInSpeaker)
    {
      this.mMuteInSpeaker = paramBoolean;
      if (this.mJitterBuffer != 0L) {
        nativeMuteInSpeaker(this.mJitterBuffer, paramBoolean);
      }
    }
    AppMethodBeat.o(16489);
  }
  
  protected native long nativeCreateJitterBuffer(TXCJitter paramTXCJitter, boolean paramBoolean);
  
  protected native void nativeDestoryJitterBuffer(long paramLong);
  
  protected native void nativeEnableAutoAdjustCache(long paramLong, boolean paramBoolean);
  
  protected native void nativeEnableVolumeLevelCal(long paramLong, boolean paramBoolean);
  
  protected native int nativeGetVolumeLevel(long paramLong);
  
  protected native void nativeMuteInSpeaker(long paramLong, boolean paramBoolean);
  
  protected native void nativeSetAutoAdjustMaxCache(long paramLong, float paramFloat);
  
  protected native void nativeSetAutoAdjustMinCache(long paramLong, float paramFloat);
  
  protected native void nativeSetCacheTime(long paramLong, float paramFloat);
  
  protected native void nativeSetJitterCycle(long paramLong1, long paramLong2);
  
  protected native void nativeSetJitterDataListener(boolean paramBoolean);
  
  protected native void nativeSetLoadingThreshold(long paramLong1, long paramLong2);
  
  protected native void nativeSetMute(long paramLong, boolean paramBoolean);
  
  protected native void nativeSetRtcPlayHungryTimeThreshold(long paramLong, int paramInt);
  
  protected native void nativeSetUserID(long paramLong, String paramString);
  
  protected native void nativeSetVolume(long paramLong, int paramInt);
  
  public void onAudioJitterBufferError(int paramInt, String paramString)
  {
    AppMethodBeat.i(16494);
    if (this.mEventListener != null)
    {
      c localc = (c)this.mEventListener.get();
      if (localc != null) {
        localc.onAudioJitterBufferError(this.mUserID, paramInt, paramString);
      }
    }
    AppMethodBeat.o(16494);
  }
  
  public void onAudioJitterBufferNotify(int paramInt, String paramString)
  {
    AppMethodBeat.i(16495);
    if (this.mEventListener != null)
    {
      TXCLog.e("TXCJitter", "onAudioJitterBufferNotify  cur state ".concat(String.valueOf(paramInt)));
      c localc = (c)this.mEventListener.get();
      if (localc != null) {
        localc.onAudioJitterBufferNotify(this.mUserID, paramInt, paramString);
      }
    }
    AppMethodBeat.o(16495);
  }
  
  public void onAudioPlayPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16492);
    if (this.mDataListener != null)
    {
      d locald = (d)this.mDataListener.get();
      if (locald != null) {
        locald.onAudioPlayPcmData(this.mUserID, paramArrayOfByte, paramLong, paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(16492);
  }
  
  public void setAutoAdjustMaxCache(float paramFloat)
  {
    AppMethodBeat.i(16481);
    TXCLog.i("TXCJitter", "set auto adjust max cache to ".concat(String.valueOf(paramFloat)));
    if (this.mJitterBuffer == 0L) {
      this.mAutoAdjustMaxCache = paramFloat;
    }
    AppMethodBeat.o(16481);
  }
  
  public void setAutoAdjustMinCache(float paramFloat)
  {
    AppMethodBeat.i(16482);
    TXCLog.i("TXCJitter", "set auto adjust min cache to ".concat(String.valueOf(paramFloat)));
    if (this.mJitterBuffer == 0L) {
      this.mAutoAdjustMinCache = paramFloat;
    }
    AppMethodBeat.o(16482);
  }
  
  public void setCacheTime(float paramFloat)
  {
    AppMethodBeat.i(16479);
    TXCLog.i("TXCJitter", "set cache time to ".concat(String.valueOf(paramFloat)));
    if (this.mJitterBuffer == 0L) {
      this.mCacheTime = paramFloat;
    }
    AppMethodBeat.o(16479);
  }
  
  public void setDataListener(d paramd)
  {
    boolean bool2 = false;
    AppMethodBeat.i(16491);
    this.mDataListener = new WeakReference(paramd);
    StringBuilder localStringBuilder = new StringBuilder(" setDataListener: ");
    if (paramd == null)
    {
      bool1 = false;
      TXCLog.i("TXCJitter", bool1);
      if (paramd != null) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      nativeSetJitterDataListener(bool1);
      AppMethodBeat.o(16491);
      return;
      bool1 = true;
      break;
    }
  }
  
  public void setEventListener(c paramc)
  {
    AppMethodBeat.i(16493);
    this.mEventListener = new WeakReference(paramc);
    StringBuilder localStringBuilder = new StringBuilder(" setEventListener: ");
    if (paramc == null) {}
    for (boolean bool = false;; bool = true)
    {
      TXCLog.i("TXCJitter", bool);
      AppMethodBeat.o(16493);
      return;
    }
  }
  
  public void setPlayMute(boolean paramBoolean)
  {
    AppMethodBeat.i(16488);
    if ((this.mJitterBuffer != 0L) && (paramBoolean != this.mIsPlayMute)) {
      nativeSetMute(this.mJitterBuffer, paramBoolean);
    }
    TXCLog.i("TXCJitter", "set mute to ".concat(String.valueOf(paramBoolean)));
    this.mIsPlayMute = paramBoolean;
    AppMethodBeat.o(16488);
  }
  
  public void setPlayVolume(int paramInt)
  {
    AppMethodBeat.i(16490);
    if ((this.mJitterBuffer != 0L) && (paramInt != this.mPlayVolume)) {
      nativeSetVolume(this.mJitterBuffer, paramInt);
    }
    TXCLog.i("TXCJitter", "set volume to ".concat(String.valueOf(paramInt)));
    this.mPlayVolume = paramInt;
    AppMethodBeat.o(16490);
  }
  
  public void setUserID(String paramString)
  {
    this.mUserID = paramString;
  }
  
  public int startPlay()
  {
    AppMethodBeat.i(16486);
    this.mIsPlaying = true;
    if (this.mJitterBuffer == 0L)
    {
      this.mJitterBuffer = nativeCreateJitterBuffer(this, this.mIsRealTimePlay);
      if (this.mJitterBuffer == 0L) {
        break label232;
      }
      nativeSetUserID(this.mJitterBuffer, this.mUserID);
      nativeSetCacheTime(this.mJitterBuffer, this.mCacheTime);
      nativeEnableAutoAdjustCache(this.mJitterBuffer, this.mIsAutoAdjustCache);
      nativeSetAutoAdjustMaxCache(this.mJitterBuffer, this.mAutoAdjustMaxCache);
      nativeSetAutoAdjustMinCache(this.mJitterBuffer, this.mAutoAdjustMinCache);
      nativeSetMute(this.mJitterBuffer, this.mIsPlayMute);
      nativeMuteInSpeaker(this.mJitterBuffer, this.mMuteInSpeaker);
      nativeEnableVolumeLevelCal(this.mJitterBuffer, this.mEnableVolumeLevelCal);
      nativeSetJitterCycle(this.mJitterBuffer, b.a().a("Audio", "LIVE_JitterCycle"));
      nativeSetLoadingThreshold(this.mJitterBuffer, b.a().a("Audio", "LoadingThreshold"));
      nativeSetRtcPlayHungryTimeThreshold(this.mJitterBuffer, (int)b.a().a("Audio", "RtcPlayHungryTimeThreshold"));
    }
    for (;;)
    {
      TXCLog.e("TXCJitter", "soft dec, create jitterbuffer with id " + this.mJitterBuffer);
      AppMethodBeat.o(16486);
      return 0;
      label232:
      TXCLog.e("TXCJitter", "soft dec, create jitterbuffer failed!!");
    }
  }
  
  public int stopPlay()
  {
    AppMethodBeat.i(16487);
    this.mIsPlaying = false;
    if (this.mJitterBuffer != 0L)
    {
      nativeDestoryJitterBuffer(this.mJitterBuffer);
      this.mJitterBuffer = 0L;
    }
    this.mEventListener = null;
    this.mDataListener = null;
    this.mCacheTime = 5.0F;
    this.mIsAutoAdjustCache = true;
    this.mAutoAdjustMaxCache = 5.0F;
    this.mAutoAdjustMinCache = 1.0F;
    this.mIsRealTimePlay = false;
    this.mIsPlayMute = false;
    this.mMuteInSpeaker = false;
    this.mSmoothMode = 0;
    this.mUserID = null;
    AppMethodBeat.o(16487);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.TXCJitter
 * JD-Core Version:    0.7.0.1
 */