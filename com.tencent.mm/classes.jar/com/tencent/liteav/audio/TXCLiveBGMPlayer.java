package com.tencent.liteav.audio;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TXCLiveBGMPlayer
{
  private static final int PLAY_ERR_AUDIO_TRACK = -3;
  private static final int PLAY_ERR_AUDIO_TRACK_PLAY = -4;
  private static final int PLAY_ERR_FILE_NOTFOUND = -2;
  private static final int PLAY_ERR_OPEN = -1;
  private static final int PLAY_SUCCESS = 0;
  private static final String TAG;
  private static TXCLiveBGMPlayer instance;
  private Context mContext = null;
  private String mFilePath = null;
  private boolean mIsPause = false;
  private boolean mIsRunning = false;
  private WeakReference<f> mWeakListener = null;
  
  static
  {
    AppMethodBeat.i(16236);
    d.f();
    TAG = "AudioCenter:" + TXCLiveBGMPlayer.class.getSimpleName();
    AppMethodBeat.o(16236);
  }
  
  public static TXCLiveBGMPlayer getInstance()
  {
    AppMethodBeat.i(16222);
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new TXCLiveBGMPlayer();
      }
      TXCLiveBGMPlayer localTXCLiveBGMPlayer = instance;
      AppMethodBeat.o(16222);
      return localTXCLiveBGMPlayer;
    }
    finally
    {
      AppMethodBeat.o(16222);
    }
  }
  
  private native int nativeGetBitsPerChannel();
  
  private native int nativeGetChannels();
  
  private native int nativeGetCurDurationMS();
  
  private native int nativeGetCurPtsMS();
  
  private native int nativeGetDurationMS(String paramString);
  
  private native int nativeGetSampleRate();
  
  private void nativeOPlayProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(16235);
    onPlayProgress(paramLong1, paramLong2);
    if (paramLong1 == paramLong2) {
      onPlayEnd(0);
    }
    AppMethodBeat.o(16235);
  }
  
  private native void nativePause();
  
  private native void nativeResume();
  
  private native int nativeSetCurPtsMS(int paramInt);
  
  private native void nativeSetPitch(float paramFloat);
  
  private native void nativeSetPlayoutVolume(float paramFloat);
  
  private native void nativeSetPublishVolume(float paramFloat);
  
  private native void nativeSetVolume(float paramFloat);
  
  private native boolean nativeStartPlay(String paramString, TXCLiveBGMPlayer paramTXCLiveBGMPlayer);
  
  private native void nativeStopPlay();
  
  private void onPlayEnd(final int paramInt)
  {
    AppMethodBeat.i(16233);
    final f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      new Handler(Looper.getMainLooper()).post(new Runnable()
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
  
  private void onPlayProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(16234);
    f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      if (localf != null) {
        localf.onPlayProgress(paramLong1, paramLong2);
      }
      AppMethodBeat.o(16234);
      return;
    }
    finally
    {
      AppMethodBeat.o(16234);
    }
  }
  
  private void onPlayStart()
  {
    AppMethodBeat.i(16232);
    final f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      new Handler(Looper.getMainLooper()).post(new Runnable()
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
      AppMethodBeat.o(16232);
      return;
    }
    finally
    {
      AppMethodBeat.o(16232);
    }
  }
  
  public int getBGMDuration(String paramString)
  {
    AppMethodBeat.i(16229);
    if (paramString == null)
    {
      i = nativeGetCurDurationMS();
      AppMethodBeat.o(16229);
      return i;
    }
    int i = nativeGetDurationMS(paramString);
    AppMethodBeat.o(16229);
    return i;
  }
  
  public boolean isPlaying()
  {
    return this.mIsRunning;
  }
  
  public boolean isRunning()
  {
    return (this.mIsRunning) && (!this.mIsPause);
  }
  
  public boolean pause()
  {
    AppMethodBeat.i(16226);
    TXCLog.i(TAG, "pause");
    this.mIsPause = true;
    nativePause();
    AppMethodBeat.o(16226);
    return true;
  }
  
  public boolean resume()
  {
    AppMethodBeat.i(16227);
    TXCLog.i(TAG, "resume");
    this.mIsPause = false;
    nativeResume();
    AppMethodBeat.o(16227);
    return true;
  }
  
  public boolean setBGMPlayoutVolume(float paramFloat)
  {
    AppMethodBeat.i(182283);
    nativeSetPlayoutVolume(paramFloat);
    AppMethodBeat.o(182283);
    return true;
  }
  
  public int setBGMPosition(int paramInt)
  {
    AppMethodBeat.i(16230);
    if (paramInt >= getBGMDuration(null))
    {
      TXCLog.e(TAG, "setMusicPosition with position out of current music duration , finish play!");
      stopPlay();
      onPlayEnd(0);
      AppMethodBeat.o(16230);
      return 0;
    }
    paramInt = nativeSetCurPtsMS(paramInt);
    AppMethodBeat.o(16230);
    return paramInt;
  }
  
  public boolean setBGMPublishVolume(float paramFloat)
  {
    AppMethodBeat.i(182284);
    nativeSetPublishVolume(paramFloat);
    AppMethodBeat.o(182284);
    return true;
  }
  
  public void setContext(Context paramContext)
  {
    this.mContext = paramContext;
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
    nativeSetPitch(paramFloat);
    AppMethodBeat.o(16231);
  }
  
  public boolean setVolume(float paramFloat)
  {
    AppMethodBeat.i(16228);
    nativeSetVolume(paramFloat);
    AppMethodBeat.o(16228);
    return true;
  }
  
  public boolean startPlay(String paramString)
  {
    AppMethodBeat.i(16224);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      TXCLog.e(TAG, "start live bgm failed! invalid params!");
      AppMethodBeat.o(16224);
      return false;
    }
    stopPlay();
    this.mFilePath = paramString;
    this.mIsRunning = true;
    if (!nativeStartPlay(this.mFilePath, this))
    {
      onPlayEnd(-1);
      AppMethodBeat.o(16224);
      return false;
    }
    TXCTraeJNI.traeStartPlay(this.mContext);
    onPlayStart();
    TXCLog.i(TAG, "start bgm play : filePath = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(16224);
    return true;
  }
  
  public boolean stopPlay()
  {
    AppMethodBeat.i(16225);
    this.mIsRunning = false;
    long l = System.currentTimeMillis();
    nativeStopPlay();
    TXCTraeJNI.traeStopPlay();
    this.mFilePath = null;
    this.mContext = null;
    this.mIsPause = false;
    TXCLog.i(TAG, "stopBGMPlay cost(MS): " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(16225);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCLiveBGMPlayer
 * JD-Core Version:    0.7.0.1
 */