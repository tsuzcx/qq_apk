package com.tencent.liteav.audio;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TXCLiveBGMPlayer
  implements TXAudioEffectManager.TXMusicPlayObserver
{
  private static final int PLAY_ERR_OPEN = -1;
  private static final int PLAY_SUCCESS = 0;
  private static final String TAG = "AudioCenter:TXCLiveBGMPlayer";
  private int mBGMId;
  private final Handler mHandler;
  private boolean mIsPause;
  private boolean mIsRunning;
  private WeakReference<f> mWeakListener;
  
  static
  {
    AppMethodBeat.i(16236);
    com.tencent.liteav.basic.util.f.f();
    AppMethodBeat.o(16236);
  }
  
  private TXCLiveBGMPlayer()
  {
    AppMethodBeat.i(221840);
    this.mIsRunning = false;
    this.mIsPause = false;
    this.mWeakListener = null;
    this.mBGMId = 2147483647;
    this.mHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(221840);
  }
  
  public static TXCLiveBGMPlayer getInstance()
  {
    AppMethodBeat.i(16222);
    TXCLiveBGMPlayer localTXCLiveBGMPlayer = a.a();
    AppMethodBeat.o(16222);
    return localTXCLiveBGMPlayer;
  }
  
  private void onPlayEnd(final int paramInt)
  {
    AppMethodBeat.i(16233);
    final f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16330);
          if (localf != null) {
            localf.onPlayEnd(paramInt);
          }
          AppMethodBeat.o(16330);
        }
      });
      AppMethodBeat.o(16233);
      return;
    }
    finally
    {
      AppMethodBeat.o(16233);
    }
  }
  
  private void onPlayProgress(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(16234);
    final f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(221788);
          if (localf != null) {
            localf.onPlayProgress(paramLong1, this.c);
          }
          AppMethodBeat.o(221788);
        }
      });
      AppMethodBeat.o(16234);
      return;
    }
    finally
    {
      AppMethodBeat.o(16234);
    }
  }
  
  private void onPlayStart(int paramInt)
  {
    AppMethodBeat.i(221846);
    final f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16280);
          if (localf != null) {
            localf.onPlayStart();
          }
          AppMethodBeat.o(16280);
        }
      });
      AppMethodBeat.o(221846);
      return;
    }
    finally
    {
      AppMethodBeat.o(221846);
    }
  }
  
  public int getBGMDuration(String paramString)
  {
    AppMethodBeat.i(16229);
    int i = (int)TXAudioEffectManagerImpl.getInstance().getMusicDurationInMS(paramString);
    AppMethodBeat.o(16229);
    return i;
  }
  
  public long getBGMGetCurrentProgressInMs(String paramString)
  {
    AppMethodBeat.i(221844);
    if (paramString == null)
    {
      long l = TXAudioEffectManagerImpl.getInstance().getMusicCurrentPosInMS(this.mBGMId);
      AppMethodBeat.o(221844);
      return l;
    }
    AppMethodBeat.o(221844);
    return 0L;
  }
  
  public boolean isPlaying()
  {
    return this.mIsRunning;
  }
  
  public boolean isRunning()
  {
    return (this.mIsRunning) && (!this.mIsPause);
  }
  
  public void onComplete(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221849);
    onPlayEnd(paramInt2);
    AppMethodBeat.o(221849);
  }
  
  public void onPlayProgress(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221847);
    onPlayProgress(paramLong1, paramLong2);
    AppMethodBeat.o(221847);
  }
  
  public void onStart(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221848);
    onPlayStart(paramInt2);
    AppMethodBeat.o(221848);
  }
  
  public boolean pause()
  {
    AppMethodBeat.i(16226);
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", "pause");
    this.mIsPause = true;
    TXAudioEffectManagerImpl.getInstance().pausePlayMusic(this.mBGMId);
    AppMethodBeat.o(16226);
    return true;
  }
  
  public boolean resume()
  {
    AppMethodBeat.i(16227);
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", "resume");
    this.mIsPause = false;
    TXAudioEffectManagerImpl.getInstance().resumePlayMusic(this.mBGMId);
    AppMethodBeat.o(16227);
    return true;
  }
  
  public void setBGMPosition(int paramInt)
  {
    AppMethodBeat.i(221845);
    TXAudioEffectManagerImpl.getInstance().seekMusicToPosInMS(this.mBGMId, paramInt);
    AppMethodBeat.o(221845);
  }
  
  public void setOnPlayListener(f paramf)
  {
    try
    {
      AppMethodBeat.i(16223);
      if (paramf == null) {
        this.mWeakListener = null;
      }
      this.mWeakListener = new WeakReference(paramf);
      AppMethodBeat.o(16223);
      return;
    }
    finally {}
  }
  
  public void setPitch(float paramFloat)
  {
    AppMethodBeat.i(16231);
    TXAudioEffectManagerImpl.getInstance().setMusicPitch(this.mBGMId, paramFloat);
    AppMethodBeat.o(16231);
  }
  
  public boolean setPlayoutVolume(float paramFloat)
  {
    AppMethodBeat.i(221842);
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", "setPlayoutVolume:".concat(String.valueOf(paramFloat)));
    TXAudioEffectManagerImpl.getInstance().setMusicPlayoutVolume(this.mBGMId, (int)(100.0F * paramFloat));
    AppMethodBeat.o(221842);
    return true;
  }
  
  public boolean setPublishVolume(float paramFloat)
  {
    AppMethodBeat.i(221843);
    TXAudioEffectManagerImpl.getInstance().setMusicPublishVolume(this.mBGMId, (int)(100.0F * paramFloat));
    AppMethodBeat.o(221843);
    return true;
  }
  
  public boolean setVolume(float paramFloat)
  {
    AppMethodBeat.i(16228);
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", "setVolume");
    TXAudioEffectManagerImpl.getInstance().setMusicVolume(this.mBGMId, (int)(100.0F * paramFloat));
    AppMethodBeat.o(16228);
    return true;
  }
  
  public boolean startPlay(String paramString)
  {
    AppMethodBeat.i(16224);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      TXCLog.e("AudioCenter:TXCLiveBGMPlayer", "start live bgm failed! invalid params!");
      AppMethodBeat.o(16224);
      return false;
    }
    this.mIsRunning = true;
    TXAudioEffectManager.AudioMusicParam localAudioMusicParam = new TXAudioEffectManager.AudioMusicParam(this.mBGMId, paramString);
    localAudioMusicParam.publish = true;
    localAudioMusicParam.loopCount = 0;
    boolean bool = TXAudioEffectManagerImpl.getInstance().startPlayMusic(localAudioMusicParam);
    TXAudioEffectManagerImpl.getInstance().setMusicObserver(this.mBGMId, this);
    if (!bool)
    {
      onPlayEnd(-1);
      AppMethodBeat.o(16224);
      return false;
    }
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", "start bgm play : filePath = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(16224);
    return true;
  }
  
  public void stopAll()
  {
    AppMethodBeat.i(221841);
    TXAudioEffectManagerImpl.getInstance().stopAllMusics();
    TXAudioEffectManagerImpl.getAutoCacheHolder().stopAllMusics();
    TXAudioEffectManagerImpl.getCacheInstance().stopAllMusics();
    AppMethodBeat.o(221841);
  }
  
  public boolean stopPlay()
  {
    AppMethodBeat.i(16225);
    this.mIsRunning = false;
    long l = System.currentTimeMillis();
    TXAudioEffectManagerImpl.getInstance().setMusicObserver(this.mBGMId, null);
    TXAudioEffectManagerImpl.getInstance().stopPlayMusic(this.mBGMId);
    this.mIsPause = false;
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", "stopBGMPlay cost(MS): " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(16225);
    return true;
  }
  
  static class a
  {
    private static TXCLiveBGMPlayer a;
    
    static
    {
      AppMethodBeat.i(222006);
      a = new TXCLiveBGMPlayer(null);
      AppMethodBeat.o(222006);
    }
    
    public static TXCLiveBGMPlayer a()
    {
      return a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCLiveBGMPlayer
 * JD-Core Version:    0.7.0.1
 */