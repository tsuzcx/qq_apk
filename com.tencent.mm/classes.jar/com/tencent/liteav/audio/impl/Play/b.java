package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

public class b
  extends TXCAudioBasePlayController
{
  public static final String a = "AudioCenter:" + b.class.getSimpleName();
  private a b;
  private com.tencent.liteav.basic.f.a c;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  private int a(com.tencent.liteav.basic.f.a parama)
  {
    if (parama == null) {
      return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
    }
    int i = TXEAudioDef.TXE_AUDIO_TYPE_INVALID;
    if ((com.tencent.liteav.basic.a.a.k == parama.d) || (com.tencent.liteav.basic.a.a.l == parama.d)) {
      i = TXEAudioDef.TXE_AUDIO_TYPE_AAC;
    }
    while (!this.mIsPlaying)
    {
      onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE, "播放器还没有启动");
      TXCLog.w(a, "sotf dec, invalid state. player not started yet!");
      return TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
      if (com.tencent.liteav.basic.a.a.m == parama.d)
      {
        i = TXEAudioDef.TXE_AUDIO_TYPE_MP3;
      }
      else
      {
        TXCLog.e(a, "soft dec, not support audio type , packet type : " + parama.d);
        onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT, "解码器不支持当前音频格式，包类型:" + parama.d);
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT;
      }
    }
    if (this.mJitterBuffer == 0L)
    {
      this.mJitterBuffer = nativeCreateJitterBuffer(false, this);
      if (this.mJitterBuffer != 0L)
      {
        nativeSetCacheTime(this.mJitterBuffer, this.mCacheTime);
        nativeSetMute(this.mJitterBuffer, this.mIsMute);
        nativeEnableRealTimePlay(this.mJitterBuffer, this.mIsRealTimePlay);
        nativeEnableAutoAdjustCache(this.mJitterBuffer, this.mIsAutoAdjustCache);
        nativeSetAutoAdjustMaxCache(this.mJitterBuffer, this.mAutoAdjustMaxCache);
        nativeSetAutoAdjustMinCache(this.mJitterBuffer, this.mAutoAdjustMinCache);
        nativeSetSmoothMode(this.mJitterBuffer, this.mSmoothMode);
        nativeSetSmoothSpeed(this.mJitterBuffer, com.tencent.liteav.basic.e.b.a().b("Audio", "SmoothSpeed"));
        nativeSetJitterCycle(this.mJitterBuffer, com.tencent.liteav.basic.e.b.a().a("Audio", "LIVE_JitterCycle"));
        nativeSetRealtimeJitterCycle(this.mJitterBuffer, com.tencent.liteav.basic.e.b.a().a("Audio", "RTC_JitterCycle"));
        nativeSetLoadingThreshold(this.mJitterBuffer, com.tencent.liteav.basic.e.b.a().a("Audio", "LoadingThreshold"));
        TXCLog.e(a, "soft dec, create jitterbuffer with id " + this.mJitterBuffer);
      }
    }
    else
    {
      if (com.tencent.liteav.basic.a.a.k == parama.d) {
        TXCLog.i(a, "soft dec, recv aac seq " + com.tencent.liteav.audio.impl.a.a(parama.f));
      }
      if (this.mJitterBuffer == 0L) {
        break label540;
      }
      nativeAddData(this.mJitterBuffer, parama.f, parama.d, parama.e);
      if (com.tencent.liteav.basic.a.a.k != parama.d) {
        break label561;
      }
      this.c = new com.tencent.liteav.basic.f.a();
      this.c.a = nativeGetSamplerate(this.mJitterBuffer);
      this.c.b = nativeGetChannel(this.mJitterBuffer);
      this.c.c = c.c;
      this.c.d = com.tencent.liteav.basic.a.a.k;
      parama = new com.tencent.liteav.basic.f.a();
      parama.a = 48000;
      parama.b = 2;
      parama.c = 16;
      parama.d = com.tencent.liteav.basic.a.a.k;
      onPlayAudioInfoChanged(this.c, parama);
    }
    for (;;)
    {
      return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
      TXCLog.e(a, "soft dec, create jitterbuffer failed!!");
      break;
      label540:
      onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_NOT_CREATE_JIT, "jitterbuf 还未创建");
      TXCLog.e(a, "soft dec, jitterbuffer not created yet!!");
      return TXEAudioDef.TXE_AUDIO_PLAY_ERR_NOT_CREATE_JIT;
      label561:
      if ((com.tencent.liteav.basic.a.a.m == parama.d) && (this.c == null))
      {
        this.c = new com.tencent.liteav.basic.f.a();
        this.c.a = nativeGetSamplerate(this.mJitterBuffer);
        this.c.b = nativeGetChannel(this.mJitterBuffer);
        this.c.c = c.c;
        this.c.d = com.tencent.liteav.basic.a.a.k;
        parama = new com.tencent.liteav.basic.f.a();
        parama.a = 48000;
        parama.b = 2;
        parama.c = 16;
        parama.d = com.tencent.liteav.basic.a.a.k;
        onPlayAudioInfoChanged(this.c, parama);
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    d.a().a(paramContext, paramInt);
  }
  
  private int b(com.tencent.liteav.basic.f.a parama)
  {
    if (parama == null) {
      return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
    }
    int i = TXEAudioDef.TXE_AUDIO_TYPE_INVALID;
    if ((com.tencent.liteav.basic.a.a.k == parama.d) || (com.tencent.liteav.basic.a.a.l == parama.d)) {
      i = TXEAudioDef.TXE_AUDIO_TYPE_AAC;
    }
    while (!this.mIsPlaying)
    {
      onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE, "播放器还没有启动");
      TXCLog.w(a, "hw dec, invalid state. player not started yet!");
      return TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
      if (com.tencent.liteav.basic.a.a.m == parama.d)
      {
        i = TXEAudioDef.TXE_AUDIO_TYPE_MP3;
      }
      else
      {
        TXCLog.e(a, "hw dec, not support audio type , packet type : " + parama.d);
        onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT, "解码器不支持当前音频格式，包类型:" + parama.d);
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT;
      }
    }
    if (this.mJitterBuffer == 0L)
    {
      this.mJitterBuffer = nativeCreateJitterBuffer(true, this);
      if (this.mJitterBuffer == 0L) {
        break label406;
      }
      nativeSetCacheTime(this.mJitterBuffer, this.mCacheTime);
      nativeSetMute(this.mJitterBuffer, this.mIsMute);
      nativeEnableRealTimePlay(this.mJitterBuffer, this.mIsRealTimePlay);
      nativeEnableAutoAdjustCache(this.mJitterBuffer, this.mIsAutoAdjustCache);
      nativeSetAutoAdjustMaxCache(this.mJitterBuffer, this.mAutoAdjustMaxCache);
      nativeSetAutoAdjustMinCache(this.mJitterBuffer, this.mAutoAdjustMinCache);
      nativeSetSmoothMode(this.mJitterBuffer, this.mSmoothMode);
      nativeSetSmoothSpeed(this.mJitterBuffer, com.tencent.liteav.basic.e.b.a().b("Audio", "SmoothSpeed"));
      nativeSetJitterCycle(this.mJitterBuffer, com.tencent.liteav.basic.e.b.a().a("Audio", "LIVE_JitterCycle"));
      nativeSetRealtimeJitterCycle(this.mJitterBuffer, com.tencent.liteav.basic.e.b.a().a("Audio", "RTC_JitterCycle"));
      nativeSetLoadingThreshold(this.mJitterBuffer, com.tencent.liteav.basic.e.b.a().a("Audio", "LoadingThreshold"));
    }
    for (;;)
    {
      TXCLog.e(a, "hw dec, create jitterbuffer with id " + this.mJitterBuffer);
      if (com.tencent.liteav.basic.a.a.k == parama.d) {
        TXCLog.i(a, "soft dec, recv aac seq " + com.tencent.liteav.audio.impl.a.a(parama.f));
      }
      if (this.b != null) {
        this.b.a(parama);
      }
      return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
      label406:
      TXCLog.e(a, "hw dec, create jitterbuffer failed!!");
    }
  }
  
  protected void finalize()
  {
    if (this.mJitterBuffer != 0L)
    {
      nativeDestoryJitterBuffer(this.mJitterBuffer);
      this.mJitterBuffer = 0L;
    }
  }
  
  public long getCacheDuration()
  {
    if (this.mIsHWAcceleration) {
      return this.b.a() + nativeGetCacheDuration(this.mJitterBuffer);
    }
    return nativeGetCacheDuration(this.mJitterBuffer);
  }
  
  public void onPlayAudioInfoChanged(com.tencent.liteav.basic.f.a parama1, com.tencent.liteav.basic.f.a parama2)
  {
    if (this.c == null) {
      this.c = parama1;
    }
    if (this.mListener != null) {
      this.mListener.onPlayAudioInfoChanged(parama1, parama2);
    }
    if (!nativeIsTracksEmpty()) {
      d.a().b();
    }
  }
  
  public void onPlayPcmData(byte[] paramArrayOfByte, long paramLong)
  {
    super.onPlayPcmData(paramArrayOfByte, paramLong);
    if ((this.mJitterBuffer != 0L) && (this.mIsHWAcceleration)) {
      nativeAddData(this.mJitterBuffer, paramArrayOfByte, com.tencent.liteav.basic.a.a.n, paramLong);
    }
  }
  
  public int playData(com.tencent.liteav.basic.f.a parama)
  {
    if (this.mIsHWAcceleration) {
      return b(parama);
    }
    return a(parama);
  }
  
  public int startPlay()
  {
    TXCLog.i(a, "start play audio!");
    if (!this.mIsPlaying)
    {
      if (this.mIsHWAcceleration)
      {
        this.b = new a();
        this.b.a(new WeakReference(this));
      }
      this.mIsPlaying = true;
      TXCLog.i(a, "finish start play audio!");
      return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
    }
    TXCLog.e(a, "repeat start play audio, ignore it!");
    return TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
  }
  
  public int stopPlay()
  {
    TXCLog.i(a, "stop play audio!");
    if (this.mIsPlaying)
    {
      super.stopPlay();
      if (this.mJitterBuffer != 0L)
      {
        nativeDestoryJitterBuffer(this.mJitterBuffer);
        this.mJitterBuffer = 0L;
      }
      if (nativeIsTracksEmpty()) {
        d.a().c();
      }
      if (this.b != null)
      {
        this.b.b();
        this.b = null;
      }
      this.c = null;
      TXCLog.i(a, "finish stop play audio!");
      return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
    }
    TXCLog.e(a, "repeat stop play audio, ignore it!");
    return TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.b
 * JD-Core Version:    0.7.0.1
 */