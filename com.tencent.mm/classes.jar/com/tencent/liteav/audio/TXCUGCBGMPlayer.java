package com.tencent.liteav.audio;

import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TXCUGCBGMPlayer
  implements TXAudioEffectManager.TXMusicPlayObserver
{
  private static final int PLAY_ERR_OPEN = -1;
  private static final int PLAY_SUCCESS = 0;
  private static final String TAG = "AudioCenter:TXCUGCBGMPlayer";
  private int mBGMId;
  private long mEndTimeMS;
  private boolean mIsRunning;
  private long mSeekBytes;
  private float mSpeedRate;
  private long mStartTimeMS;
  private float mVolume;
  private WeakReference<f> mWeakListener;
  
  static
  {
    AppMethodBeat.i(16297);
    com.tencent.liteav.basic.util.f.f();
    AppMethodBeat.o(16297);
  }
  
  private TXCUGCBGMPlayer()
  {
    AppMethodBeat.i(221833);
    this.mWeakListener = null;
    this.mIsRunning = false;
    this.mVolume = 1.0F;
    this.mSpeedRate = 1.0F;
    this.mStartTimeMS = 0L;
    this.mEndTimeMS = 0L;
    this.mSeekBytes = 0L;
    this.mBGMId = -2147483648;
    TXCMultAudioTrackPlayer.getInstance();
    AppMethodBeat.o(221833);
  }
  
  public static TXCUGCBGMPlayer getInstance()
  {
    AppMethodBeat.i(16281);
    TXCUGCBGMPlayer localTXCUGCBGMPlayer = a.a();
    AppMethodBeat.o(16281);
    return localTXCUGCBGMPlayer;
  }
  
  private void onPlayEnd(int paramInt)
  {
    AppMethodBeat.i(16294);
    f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      if (localf != null) {
        localf.onPlayEnd(paramInt);
      }
      AppMethodBeat.o(16294);
      return;
    }
    finally
    {
      AppMethodBeat.o(16294);
    }
  }
  
  private void onPlayProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(16295);
    f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      if (localf != null) {
        localf.onPlayProgress(paramLong1, paramLong2);
      }
      AppMethodBeat.o(16295);
      return;
    }
    finally
    {
      AppMethodBeat.o(16295);
    }
  }
  
  private void onPlayStart()
  {
    AppMethodBeat.i(16293);
    f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      if (localf != null) {
        localf.onPlayStart();
      }
      AppMethodBeat.o(16293);
      return;
    }
    finally
    {
      AppMethodBeat.o(16293);
    }
  }
  
  public long getDurationMS(String paramString)
  {
    AppMethodBeat.i(16292);
    long l = TXAudioEffectManagerImpl.getCacheInstance().getMusicDurationInMS(paramString);
    AppMethodBeat.o(16292);
    return l;
  }
  
  public void onComplete(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221839);
    onPlayEnd(paramInt2);
    AppMethodBeat.o(221839);
  }
  
  public void onPlayProgress(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221837);
    onPlayProgress(paramLong1, paramLong2);
    AppMethodBeat.o(221837);
  }
  
  public void onStart(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221838);
    onPlayStart();
    AppMethodBeat.o(221838);
  }
  
  public void pause()
  {
    AppMethodBeat.i(16285);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "pause");
    TXAudioEffectManagerImpl.getCacheInstance().pausePlayMusic(this.mBGMId);
    AppMethodBeat.o(16285);
  }
  
  public void playFromTime(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(16289);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "startPlayRange:" + paramLong1 + ", " + paramLong2);
    this.mStartTimeMS = paramLong1;
    this.mEndTimeMS = paramLong2;
    AppMethodBeat.o(16289);
  }
  
  public void resume()
  {
    AppMethodBeat.i(16286);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "resume");
    TXAudioEffectManagerImpl.getCacheInstance().resumePlayMusic(this.mBGMId);
    AppMethodBeat.o(16286);
  }
  
  public void seekBytes(long paramLong)
  {
    AppMethodBeat.i(16290);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "seekBytes:".concat(String.valueOf(paramLong)));
    long l = paramLong;
    if (paramLong < 0L)
    {
      TXCLog.e("AudioCenter:TXCUGCBGMPlayer", "seek bytes can not be negative. change to 0");
      l = 0L;
    }
    this.mSeekBytes = l;
    TXAudioEffectManagerImpl.getCacheInstance().seekMusicToPosInBytes(this.mBGMId, l);
    AppMethodBeat.o(16290);
  }
  
  public void setChangerType(int paramInt)
  {
    AppMethodBeat.i(221835);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "changerType:".concat(String.valueOf(paramInt)));
    TXAudioEffectManagerImpl.getCacheInstance().setMusicChangerType(this.mBGMId, paramInt);
    AppMethodBeat.o(221835);
  }
  
  public void setOnPlayListener(f paramf)
  {
    try
    {
      AppMethodBeat.i(16282);
      if (paramf == null) {
        this.mWeakListener = null;
      }
      this.mWeakListener = new WeakReference(paramf);
      AppMethodBeat.o(16282);
      return;
    }
    finally {}
  }
  
  public void setReverbType(int paramInt)
  {
    AppMethodBeat.i(221836);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "int reverbType:".concat(String.valueOf(paramInt)));
    TXAudioEffectManagerImpl.getCacheInstance().setMusicReverbType(this.mBGMId, paramInt);
    AppMethodBeat.o(221836);
  }
  
  public void setSpeedRate(float paramFloat)
  {
    AppMethodBeat.i(16288);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "setSpeedRate:".concat(String.valueOf(paramFloat)));
    this.mSpeedRate = paramFloat;
    TXAudioEffectManagerImpl.getCacheInstance().setMusicPlayoutSpeedRate(this.mBGMId, paramFloat);
    AppMethodBeat.o(16288);
  }
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(16287);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "setVolume:".concat(String.valueOf(paramFloat)));
    this.mVolume = paramFloat;
    TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(this.mBGMId, (int)(100.0F * paramFloat));
    AppMethodBeat.o(16287);
  }
  
  public void startPlay(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(221834);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "startPlay:" + paramString + "record:" + paramBoolean);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(221834);
      return;
    }
    if (this.mIsRunning)
    {
      TXCLog.w("AudioCenter:TXCUGCBGMPlayer", "BGM is playing, restarting...");
      stopPlay();
    }
    this.mSeekBytes = 0L;
    this.mIsRunning = true;
    TXAudioEffectManager.AudioMusicParam localAudioMusicParam = new TXAudioEffectManager.AudioMusicParam(this.mBGMId, paramString);
    localAudioMusicParam.publish = paramBoolean;
    localAudioMusicParam.loopCount = 0;
    localAudioMusicParam.startTimeMS = this.mStartTimeMS;
    localAudioMusicParam.endTimeMS = this.mEndTimeMS;
    localAudioMusicParam.isShortFile = true;
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "start bgm play : filePath = " + paramString + " publish:" + paramBoolean + " startTimeMS:" + this.mStartTimeMS + " endTimeMS:" + this.mEndTimeMS + " isShortFile:" + localAudioMusicParam.isShortFile + "mVolume:" + this.mVolume);
    TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(this.mBGMId, (int)(this.mVolume * 100.0F));
    TXAudioEffectManagerImpl.getCacheInstance().setMusicPlayoutSpeedRate(this.mBGMId, this.mSpeedRate);
    if (paramBoolean) {
      TXAudioEffectManagerImpl.getCacheInstance().setMuteDataDurationToPublish(this.mBGMId, 200);
    }
    paramBoolean = TXAudioEffectManagerImpl.getCacheInstance().startPlayMusic(localAudioMusicParam);
    TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(this.mBGMId, this);
    if (!paramBoolean)
    {
      onPlayEnd(-1);
      AppMethodBeat.o(221834);
      return;
    }
    onPlayStart();
    AppMethodBeat.o(221834);
  }
  
  public void stopPlay()
  {
    AppMethodBeat.i(16284);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "stopPlay");
    this.mIsRunning = false;
    long l = System.currentTimeMillis();
    try
    {
      TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(this.mBGMId, null);
      TXAudioEffectManagerImpl.getCacheInstance().stopPlayMusic(this.mBGMId);
      TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "stopBGMPlay cost(MS): " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(16284);
      return;
    }
    finally
    {
      AppMethodBeat.o(16284);
    }
  }
  
  static class a
  {
    private static TXCUGCBGMPlayer a;
    
    static
    {
      AppMethodBeat.i(222008);
      a = new TXCUGCBGMPlayer(null);
      AppMethodBeat.o(222008);
    }
    
    public static TXCUGCBGMPlayer a()
    {
      return a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCUGCBGMPlayer
 * JD-Core Version:    0.7.0.1
 */