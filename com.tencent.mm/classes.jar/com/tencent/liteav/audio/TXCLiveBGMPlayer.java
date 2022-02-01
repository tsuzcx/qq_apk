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
  private WeakReference<h> mWeakListener;
  
  static
  {
    AppMethodBeat.i(16236);
    com.tencent.liteav.basic.util.h.d();
    AppMethodBeat.o(16236);
  }
  
  private TXCLiveBGMPlayer()
  {
    AppMethodBeat.i(230380);
    this.mIsRunning = false;
    this.mIsPause = false;
    this.mWeakListener = null;
    this.mBGMId = 2147483647;
    this.mHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(230380);
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
    final h localh = null;
    try
    {
      if (this.mWeakListener != null) {
        localh = (h)this.mWeakListener.get();
      }
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16330);
          if (localh != null) {
            localh.onPlayEnd(paramInt);
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
    final h localh = null;
    try
    {
      if (this.mWeakListener != null) {
        localh = (h)this.mWeakListener.get();
      }
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(230407);
          if (localh != null) {
            localh.onPlayProgress(paramLong1, this.c);
          }
          AppMethodBeat.o(230407);
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
    AppMethodBeat.i(230386);
    final h localh = null;
    try
    {
      if (this.mWeakListener != null) {
        localh = (h)this.mWeakListener.get();
      }
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16280);
          if (localh != null) {
            localh.onPlayStart();
          }
          AppMethodBeat.o(16280);
        }
      });
      AppMethodBeat.o(230386);
      return;
    }
    finally
    {
      AppMethodBeat.o(230386);
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
    AppMethodBeat.i(230485);
    if (paramString == null)
    {
      long l = TXAudioEffectManagerImpl.getInstance().getMusicCurrentPosInMS(this.mBGMId);
      AppMethodBeat.o(230485);
      return l;
    }
    AppMethodBeat.o(230485);
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
    AppMethodBeat.i(230509);
    onPlayEnd(paramInt2);
    AppMethodBeat.o(230509);
  }
  
  public void onPlayProgress(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(230499);
    onPlayProgress(paramLong1, paramLong2);
    AppMethodBeat.o(230499);
  }
  
  public void onStart(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230503);
    onPlayStart(paramInt2);
    AppMethodBeat.o(230503);
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
    AppMethodBeat.i(230488);
    TXAudioEffectManagerImpl.getInstance().seekMusicToPosInMS(this.mBGMId, paramInt);
    AppMethodBeat.o(230488);
  }
  
  public void setOnPlayListener(h paramh)
  {
    try
    {
      AppMethodBeat.i(230410);
      if (paramh == null) {
        this.mWeakListener = null;
      }
      this.mWeakListener = new WeakReference(paramh);
      AppMethodBeat.o(230410);
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
    AppMethodBeat.i(230466);
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", "setPlayoutVolume:".concat(String.valueOf(paramFloat)));
    TXAudioEffectManagerImpl.getInstance().setMusicPlayoutVolume(this.mBGMId, (int)(100.0F * paramFloat));
    AppMethodBeat.o(230466);
    return true;
  }
  
  public boolean setPublishVolume(float paramFloat)
  {
    AppMethodBeat.i(230474);
    TXAudioEffectManagerImpl.getInstance().setMusicPublishVolume(this.mBGMId, (int)(100.0F * paramFloat));
    AppMethodBeat.o(230474);
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
    AppMethodBeat.i(230432);
    TXAudioEffectManagerImpl.getInstance().stopAllMusics();
    TXAudioEffectManagerImpl.getAutoCacheHolder().stopAllMusics();
    TXAudioEffectManagerImpl.getCacheInstance().stopAllMusics();
    AppMethodBeat.o(230432);
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
      AppMethodBeat.i(230373);
      a = new TXCLiveBGMPlayer(null);
      AppMethodBeat.o(230373);
    }
    
    public static TXCLiveBGMPlayer a()
    {
      return a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCLiveBGMPlayer
 * JD-Core Version:    0.7.0.1
 */