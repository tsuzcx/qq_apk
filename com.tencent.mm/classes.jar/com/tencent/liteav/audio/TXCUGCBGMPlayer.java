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
  private WeakReference<h> mWeakListener;
  
  static
  {
    AppMethodBeat.i(16297);
    com.tencent.liteav.basic.util.h.d();
    AppMethodBeat.o(16297);
  }
  
  private TXCUGCBGMPlayer()
  {
    AppMethodBeat.i(230368);
    this.mWeakListener = null;
    this.mIsRunning = false;
    this.mVolume = 1.0F;
    this.mSpeedRate = 1.0F;
    this.mStartTimeMS = 0L;
    this.mEndTimeMS = 0L;
    this.mSeekBytes = 0L;
    this.mBGMId = -2147483648;
    TXCMultAudioTrackPlayer.getInstance();
    AppMethodBeat.o(230368);
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
    h localh = null;
    try
    {
      if (this.mWeakListener != null) {
        localh = (h)this.mWeakListener.get();
      }
      if (localh != null) {
        localh.onPlayEnd(paramInt);
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
    h localh = null;
    try
    {
      if (this.mWeakListener != null) {
        localh = (h)this.mWeakListener.get();
      }
      if (localh != null) {
        localh.onPlayProgress(paramLong1, paramLong2);
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
    h localh = null;
    try
    {
      if (this.mWeakListener != null) {
        localh = (h)this.mWeakListener.get();
      }
      if (localh != null) {
        localh.onPlayStart();
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
    AppMethodBeat.i(230469);
    onPlayEnd(paramInt2);
    AppMethodBeat.o(230469);
  }
  
  public void onPlayProgress(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(230457);
    onPlayProgress(paramLong1, paramLong2);
    AppMethodBeat.o(230457);
  }
  
  public void onStart(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230463);
    onPlayStart();
    AppMethodBeat.o(230463);
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
    long l1 = paramLong;
    if (paramLong < 0L)
    {
      TXCLog.e("AudioCenter:TXCUGCBGMPlayer", "seek bytes can not be negative. change to 0");
      l1 = 0L;
    }
    long l2 = TXAudioEffectManagerImpl.getCacheInstance().getAvailableBGMBytes(this.mBGMId);
    paramLong = l1;
    if (l2 > 0L) {
      paramLong = l1 % l2;
    }
    this.mSeekBytes = paramLong;
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "mSeekBytes:" + this.mSeekBytes);
    TXAudioEffectManagerImpl.getCacheInstance().seekMusicToPosInBytes(this.mBGMId, paramLong);
    AppMethodBeat.o(16290);
  }
  
  public void setChangerType(int paramInt)
  {
    AppMethodBeat.i(230437);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "changerType:".concat(String.valueOf(paramInt)));
    TXAudioEffectManagerImpl.getCacheInstance().setMusicChangerType(this.mBGMId, paramInt);
    AppMethodBeat.o(230437);
  }
  
  public void setOnPlayListener(h paramh)
  {
    try
    {
      AppMethodBeat.i(230397);
      if (paramh == null) {
        this.mWeakListener = null;
      }
      this.mWeakListener = new WeakReference(paramh);
      AppMethodBeat.o(230397);
      return;
    }
    finally {}
  }
  
  public void setReverbType(int paramInt)
  {
    AppMethodBeat.i(230442);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "int reverbType:".concat(String.valueOf(paramInt)));
    TXAudioEffectManagerImpl.getCacheInstance().setMusicReverbType(this.mBGMId, paramInt);
    AppMethodBeat.o(230442);
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
    AppMethodBeat.i(230404);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "startPlay:" + paramString + "record:" + paramBoolean);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(230404);
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
      AppMethodBeat.o(230404);
      return;
    }
    onPlayStart();
    AppMethodBeat.o(230404);
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
      AppMethodBeat.i(230530);
      a = new TXCUGCBGMPlayer(null);
      AppMethodBeat.o(230530);
    }
    
    public static TXCUGCBGMPlayer a()
    {
      return a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCUGCBGMPlayer
 * JD-Core Version:    0.7.0.1
 */