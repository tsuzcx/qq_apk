package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.log.TXCLog;

public class c
  extends TXCAudioBasePlayController
  implements d
{
  private static final String a = "AudioCenter:" + c.class.getSimpleName();
  private com.tencent.liteav.basic.f.a b;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    TXCTraeJNI.setContext(paramContext);
    TXCTraeJNI.nativeSetAudioMode(paramInt);
  }
  
  protected void finalize()
  {
    if (this.mJitterBuffer != 0L)
    {
      nativeDestoryJitterBuffer(this.mJitterBuffer);
      this.mJitterBuffer = 0L;
    }
  }
  
  public void onPlayAudioInfoChanged(com.tencent.liteav.basic.f.a parama1, com.tencent.liteav.basic.f.a parama2)
  {
    if (this.b == null) {
      this.b = parama1;
    }
    if (this.mListener != null) {
      this.mListener.onPlayAudioInfoChanged(parama1, parama2);
    }
    TXCTraeJNI.traeStartPlay(this.mContext);
  }
  
  public int playData(com.tencent.liteav.basic.f.a parama)
  {
    if (parama == null) {
      return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
    }
    if ((com.tencent.liteav.basic.a.a.k != parama.d) && (com.tencent.liteav.basic.a.a.l != parama.d) && (com.tencent.liteav.basic.a.a.m != parama.d))
    {
      TXCLog.e(a, "soft dec, not support audio type , packet type : " + parama.d);
      onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT, "解码器不支持当前音频格式，包类型:" + parama.d);
      return TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT;
    }
    if (com.tencent.liteav.basic.a.a.k == parama.d) {
      TXCLog.i(a, "soft dec, recv aac seq " + parama.f);
    }
    if (!this.mIsPlaying)
    {
      onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE, "播放器还没有启动");
      TXCLog.w(a, "sotf dec, invalid state. player not started yet!");
      return TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
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
        nativeSetSmoothSpeed(this.mJitterBuffer, b.a().b("Audio", "SmoothSpeed"));
        nativeSetJitterCycle(this.mJitterBuffer, b.a().a("Audio", "LIVE_JitterCycle"));
        nativeSetRealtimeJitterCycle(this.mJitterBuffer, b.a().a("Audio", "RTC_JitterCycle"));
        nativeSetLoadingThreshold(this.mJitterBuffer, b.a().a("Audio", "LoadingThreshold"));
        TXCLog.e(a, "soft dec, create jitterbuffer with id " + this.mJitterBuffer);
      }
    }
    else
    {
      if (this.mJitterBuffer == 0L) {
        break label524;
      }
      nativeAddData(this.mJitterBuffer, parama.f, parama.d, parama.e);
      if (com.tencent.liteav.basic.a.a.k != parama.d) {
        break label547;
      }
      this.b = new com.tencent.liteav.basic.f.a();
      this.b.a = nativeGetSamplerate(this.mJitterBuffer);
      this.b.b = nativeGetChannel(this.mJitterBuffer);
      this.b.c = com.tencent.liteav.audio.c.c;
      this.b.d = com.tencent.liteav.basic.a.a.k;
      parama = new com.tencent.liteav.basic.f.a();
      parama.a = 48000;
      parama.b = 2;
      parama.c = 16;
      parama.d = com.tencent.liteav.basic.a.a.k;
      onPlayAudioInfoChanged(this.b, parama);
    }
    for (;;)
    {
      return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
      TXCLog.e(a, "soft dec, create jitterbuffer failed!!");
      break;
      label524:
      onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_NOT_CREATE_JIT, "jitterbuf 还未创建");
      TXCLog.e(a, "soft dec, jitterbuffer not created yet!!");
      return TXEAudioDef.TXE_AUDIO_PLAY_ERR_NOT_CREATE_JIT;
      label547:
      if ((com.tencent.liteav.basic.a.a.m == parama.d) && (this.b == null))
      {
        this.b = new com.tencent.liteav.basic.f.a();
        this.b.a = nativeGetSamplerate(this.mJitterBuffer);
        this.b.b = nativeGetChannel(this.mJitterBuffer);
        this.b.c = com.tencent.liteav.audio.c.c;
        this.b.d = com.tencent.liteav.basic.a.a.k;
        parama = new com.tencent.liteav.basic.f.a();
        parama.a = 48000;
        parama.b = 2;
        parama.c = 16;
        parama.d = com.tencent.liteav.basic.a.a.k;
        onPlayAudioInfoChanged(this.b, parama);
      }
    }
  }
  
  public int startPlay()
  {
    TXCLog.i(a, "start play audio!");
    if (!this.mIsPlaying)
    {
      super.startPlay();
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
      TXCTraeJNI.traeStopPlay();
      this.b = null;
      TXCLog.i(a, "finish stop play audio!");
      return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
    }
    TXCLog.e(a, "repeat stop play audio, ignore it!");
    return TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.c
 * JD-Core Version:    0.7.0.1
 */