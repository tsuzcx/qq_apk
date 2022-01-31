package com.tencent.liteav.audio;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TXCLiveBGMPlayer
  implements Runnable
{
  private static final int PLAY_ERR_AUDIO_TRACK = -3;
  private static final int PLAY_ERR_AUDIO_TRACK_PLAY = -4;
  private static final int PLAY_ERR_FILE_NOTFOUND = -2;
  private static final int PLAY_ERR_OPEN = -1;
  private static final int PLAY_SUCCESS = 0;
  private static final String TAG;
  private static TXCLiveBGMPlayer instance;
  private int mAECType = 0;
  private int mBgmDurationMs = 0;
  private Context mContext = null;
  private String mFilePath = null;
  private boolean mIsPause = false;
  private boolean mIsRunning = false;
  private float mPitch = 0.0F;
  private Thread mThread = null;
  private WeakReference<e> mWeakListener = null;
  
  static
  {
    AppMethodBeat.i(66516);
    b.f();
    TAG = "AudioCenter:" + TXCLiveBGMPlayer.class.getSimpleName();
    AppMethodBeat.o(66516);
  }
  
  public static TXCLiveBGMPlayer getInstance()
  {
    AppMethodBeat.i(66501);
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new TXCLiveBGMPlayer();
      }
      TXCLiveBGMPlayer localTXCLiveBGMPlayer = instance;
      AppMethodBeat.o(66501);
      return localTXCLiveBGMPlayer;
    }
    finally
    {
      AppMethodBeat.o(66501);
    }
  }
  
  private native int nativeGetBitsPerChannel();
  
  private native int nativeGetChannels();
  
  private native long nativeGetCurPtsMS();
  
  private native long nativeGetDurationMS(String paramString);
  
  private native int nativeGetSampleRate();
  
  private void nativeOPlayProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(66514);
    onPlayProgress(paramLong1, paramLong2);
    if (paramLong1 == paramLong2) {
      onPlayEnd(0);
    }
    AppMethodBeat.o(66514);
  }
  
  private native void nativePause();
  
  private native int nativeRead(byte[] paramArrayOfByte, int paramInt);
  
  private native void nativeResume();
  
  private native void nativeSetPitch(float paramFloat);
  
  private native void nativeSetVolume(float paramFloat);
  
  private native boolean nativeStartPlay(String paramString, TXCLiveBGMPlayer paramTXCLiveBGMPlayer);
  
  private native void nativeStopPlay();
  
  private void onPlayEnd(int paramInt)
  {
    AppMethodBeat.i(66512);
    e locale = null;
    try
    {
      if (this.mWeakListener != null) {
        locale = (e)this.mWeakListener.get();
      }
      new Handler(Looper.getMainLooper()).post(new TXCLiveBGMPlayer.2(this, locale, paramInt));
      AppMethodBeat.o(66512);
      return;
    }
    finally
    {
      AppMethodBeat.o(66512);
    }
  }
  
  private void onPlayProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(66513);
    e locale = null;
    try
    {
      if (this.mWeakListener != null) {
        locale = (e)this.mWeakListener.get();
      }
      if (locale != null) {
        locale.onPlayProgress(paramLong1, paramLong2);
      }
      AppMethodBeat.o(66513);
      return;
    }
    finally
    {
      AppMethodBeat.o(66513);
    }
  }
  
  private void onPlayStart()
  {
    AppMethodBeat.i(66511);
    e locale = null;
    try
    {
      if (this.mWeakListener != null) {
        locale = (e)this.mWeakListener.get();
      }
      new Handler(Looper.getMainLooper()).post(new TXCLiveBGMPlayer.1(this, locale));
      AppMethodBeat.o(66511);
      return;
    }
    finally
    {
      AppMethodBeat.o(66511);
    }
  }
  
  public long getMusicDuration(String paramString)
  {
    AppMethodBeat.i(66509);
    if (paramString != null)
    {
      l = nativeGetDurationMS(paramString);
      AppMethodBeat.o(66509);
      return l;
    }
    long l = this.mBgmDurationMs;
    AppMethodBeat.o(66509);
    return l;
  }
  
  public boolean isPlaying()
  {
    return this.mIsRunning;
  }
  
  public boolean isRunning()
  {
    return (this.mIsRunning) && (!this.mIsPause);
  }
  
  public void pause()
  {
    AppMethodBeat.i(66506);
    TXCLog.i(TAG, "pause");
    this.mIsPause = true;
    nativePause();
    AppMethodBeat.o(66506);
  }
  
  public void resume()
  {
    AppMethodBeat.i(66507);
    TXCLog.i(TAG, "resume");
    this.mIsPause = false;
    nativeResume();
    AppMethodBeat.o(66507);
  }
  
  public void run()
  {
    int j = 3;
    AppMethodBeat.i(66515);
    long l = System.currentTimeMillis();
    int i;
    AudioTrack localAudioTrack;
    if ((this.mFilePath == null) || (this.mFilePath.isEmpty()))
    {
      i = -2;
      localAudioTrack = null;
      if (localAudioTrack == null) {}
    }
    for (;;)
    {
      try
      {
        Object localObject;
        for (;;)
        {
          localAudioTrack.pause();
          localAudioTrack.flush();
          localAudioTrack.stop();
          localAudioTrack.release();
          TXCLog.i(TAG, "Live BGM player play time: " + (System.currentTimeMillis() - l));
          if (this.mIsRunning) {
            onPlayEnd(i);
          }
          AppMethodBeat.o(66515);
          return;
          int k = nativeGetSampleRate();
          int m = nativeGetChannels();
          int n = nativeGetBitsPerChannel();
          if (m != 1) {
            break label364;
          }
          i = 2;
          if (n != 8) {
            break label359;
          }
          try
          {
            localAudioTrack = new AudioTrack(3, k, i, j, AudioTrack.getMinBufferSize(k, i, j), 1);
          }
          catch (Exception localException1)
          {
            try
            {
              localAudioTrack.play();
              i = m * 2048;
              byte[] arrayOfByte = new byte[i];
              if ((!this.mIsRunning) || (Thread.interrupted()) || (this.mAECType == 2)) {
                break label354;
              }
              j = nativeRead(arrayOfByte, i);
              if (j >= 0) {
                break label298;
              }
              onPlayProgress(this.mBgmDurationMs, this.mBgmDurationMs);
              i = 0;
            }
            catch (Exception localException3)
            {
              TXCLog.e(TAG, "AudioTrack play Exception: " + localException3.getMessage());
              i = -4;
            }
            localException1 = localException1;
            TXCLog.e(TAG, "new AudioTrack Exception: " + localException1.getMessage());
            i = -3;
            localObject = null;
          }
        }
        break;
        break;
        label298:
        if (j == 0)
        {
          if (!this.mIsPause) {
            continue;
          }
          try
          {
            Thread.sleep(100L);
          }
          catch (InterruptedException localInterruptedException) {}
          continue;
        }
        localObject.write(localException3, 0, j);
        onPlayProgress(nativeGetCurPtsMS(), this.mBgmDurationMs);
        continue;
      }
      catch (Exception localException2)
      {
        continue;
        label354:
        i = 0;
      }
      break;
      label359:
      j = 2;
      continue;
      label364:
      i = 3;
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void setOnPlayListener(e parame)
  {
    try
    {
      AppMethodBeat.i(66502);
      if (parame == null) {
        this.mWeakListener = null;
      }
      this.mWeakListener = new WeakReference(parame);
      AppMethodBeat.o(66502);
      return;
    }
    finally {}
  }
  
  public void setPitch(float paramFloat)
  {
    AppMethodBeat.i(66510);
    this.mPitch = paramFloat;
    nativeSetPitch(paramFloat);
    AppMethodBeat.o(66510);
  }
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(66508);
    nativeSetVolume(paramFloat);
    AppMethodBeat.o(66508);
  }
  
  public boolean startPlay(String paramString, int paramInt)
  {
    AppMethodBeat.i(66503);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      TXCLog.e(TAG, "start live bgm failed! invalid params!");
      AppMethodBeat.o(66503);
      return false;
    }
    stopPlay();
    this.mAECType = paramInt;
    this.mFilePath = paramString;
    this.mIsRunning = true;
    if (!nativeStartPlay(this.mFilePath, this))
    {
      onPlayEnd(-1);
      AppMethodBeat.o(66503);
      return false;
    }
    this.mBgmDurationMs = ((int)nativeGetDurationMS(this.mFilePath));
    if (this.mAECType == 2) {
      TXCTraeJNI.traeStartPlay(this.mContext);
    }
    for (;;)
    {
      onPlayStart();
      TXCLog.i(TAG, "startPlay filePath = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(66503);
      return true;
      if (this.mThread == null)
      {
        this.mThread = new Thread(this, "BGMPlayer");
        this.mThread.start();
      }
    }
  }
  
  public void stopPlay()
  {
    AppMethodBeat.i(66504);
    this.mIsRunning = false;
    long l = System.currentTimeMillis();
    if ((this.mThread != null) && (this.mThread.isAlive()) && (Thread.currentThread().getId() != this.mThread.getId())) {}
    try
    {
      this.mThread.join();
      label56:
      this.mThread = null;
      nativeStopPlay();
      TXCTraeJNI.traeStopPlay();
      this.mIsPause = false;
      this.mBgmDurationMs = 0;
      TXCLog.i(TAG, "stopBGMPlay cost(MS): " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(66504);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label56;
    }
  }
  
  public void switchAecType(int paramInt)
  {
    AppMethodBeat.i(66505);
    if (!this.mIsRunning)
    {
      TXCLog.w(TAG, "未开始播放BGM，不能切换AEC Type");
      AppMethodBeat.o(66505);
      return;
    }
    if (this.mAECType == paramInt)
    {
      TXCLog.i(TAG, "无需切换AEC Type. aecType = " + this.mAECType);
      AppMethodBeat.o(66505);
      return;
    }
    TXCLog.i(TAG, "切换AEC Type为 ".concat(String.valueOf(paramInt)));
    this.mAECType = paramInt;
    if ((this.mAECType != 2) || ((this.mThread != null) && (this.mThread.isAlive()) && (Thread.currentThread().getId() != this.mThread.getId()))) {}
    try
    {
      this.mThread.join();
      label140:
      this.mThread = null;
      AppMethodBeat.o(66505);
      return;
      if (this.mThread == null)
      {
        this.mThread = new Thread(this, "BGMPlayer");
        this.mThread.start();
      }
      AppMethodBeat.o(66505);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label140;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCLiveBGMPlayer
 * JD-Core Version:    0.7.0.1
 */