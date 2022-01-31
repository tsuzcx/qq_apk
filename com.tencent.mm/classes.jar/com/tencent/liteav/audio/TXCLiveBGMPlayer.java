package com.tencent.liteav.audio;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.a;
import java.lang.ref.WeakReference;

public class TXCLiveBGMPlayer
  implements Runnable
{
  private static final int PLAY_ERR_AUDIO_TRACK = -3;
  private static final int PLAY_ERR_AUDIO_TRACK_PLAY = -4;
  private static final int PLAY_ERR_FILE_NOTFOUND = -2;
  private static final int PLAY_ERR_OPEN = -1;
  private static final int PLAY_SUCCESS = 0;
  private static final String TAG = "AudioCenter:" + TXCLiveBGMPlayer.class.getSimpleName();
  private static TXCLiveBGMPlayer instance;
  private int mAECType = TXEAudioDef.TXE_AEC_NONE;
  private Context mContext = null;
  private String mFilePath = null;
  private boolean mIsPause = false;
  private boolean mIsRunning = false;
  private float mPitch = 0.0F;
  private Thread mThread = null;
  private WeakReference<f> mWeakListener = null;
  
  static {}
  
  public static TXCLiveBGMPlayer getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new TXCLiveBGMPlayer();
      }
      return instance;
    }
    finally {}
  }
  
  private native int nativeGetBitsPerChannel();
  
  private native int nativeGetChannels();
  
  private native long nativeGetCurDurationMS();
  
  private native long nativeGetCurPtsMS();
  
  private native long nativeGetDurationMS(String paramString);
  
  private native int nativeGetSampleRate();
  
  private void nativeOPlayProgress(long paramLong1, long paramLong2)
  {
    onPlayProgress(paramLong1, paramLong2);
    if (paramLong1 == paramLong2) {
      onPlayEnd(0);
    }
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
    f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      new Handler(Looper.getMainLooper()).post(new TXCLiveBGMPlayer.2(this, localf, paramInt));
      return;
    }
    finally {}
  }
  
  private void onPlayProgress(long paramLong1, long paramLong2)
  {
    f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      if (localf != null) {
        localf.a(paramLong1, paramLong2);
      }
      return;
    }
    finally {}
  }
  
  private void onPlayStart()
  {
    f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      new Handler(Looper.getMainLooper()).post(new TXCLiveBGMPlayer.1(this, localf));
      return;
    }
    finally {}
  }
  
  public long getMusicDuration(String paramString)
  {
    return nativeGetDurationMS(paramString);
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
    TXCLog.i(TAG, "pause");
    this.mIsPause = true;
    nativePause();
  }
  
  public void resume()
  {
    TXCLog.i(TAG, "resume");
    this.mIsPause = false;
    nativeResume();
  }
  
  public void run()
  {
    int j = 3;
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
          return;
          int k = nativeGetSampleRate();
          int m = nativeGetChannels();
          int n = nativeGetBitsPerChannel();
          if (m != 1) {
            break label352;
          }
          i = 2;
          if (n != 8) {
            break label347;
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
              if ((!this.mIsRunning) || (Thread.interrupted()) || (this.mAECType == TXEAudioDef.TXE_AEC_TRAE)) {
                break label342;
              }
              j = nativeRead(arrayOfByte, i);
              if (j >= 0) {
                break label287;
              }
              onPlayProgress(nativeGetCurDurationMS(), nativeGetCurDurationMS());
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
        label287:
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
        onPlayProgress(nativeGetCurPtsMS(), nativeGetCurDurationMS());
        continue;
      }
      catch (Exception localException2)
      {
        continue;
        label342:
        i = 0;
      }
      break;
      label347:
      j = 2;
      continue;
      label352:
      i = 3;
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void setOnPlayListener(f paramf)
  {
    if (paramf == null) {}
    try
    {
      this.mWeakListener = null;
      this.mWeakListener = new WeakReference(paramf);
      return;
    }
    finally {}
  }
  
  public void setPitch(float paramFloat)
  {
    this.mPitch = paramFloat;
    nativeSetPitch(paramFloat);
  }
  
  public void setVolume(float paramFloat)
  {
    nativeSetVolume(paramFloat);
  }
  
  public boolean startPlay(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      TXCLog.e(TAG, "start live bgm failed! invalid params!");
      return false;
    }
    stopPlay();
    this.mAECType = paramInt;
    this.mFilePath = paramString;
    this.mIsRunning = true;
    onPlayStart();
    if (!nativeStartPlay(this.mFilePath, this))
    {
      onPlayEnd(-1);
      return false;
    }
    if (this.mAECType == TXEAudioDef.TXE_AEC_TRAE) {
      TXCTraeJNI.nativeTraeStartPlay(this.mContext);
    }
    for (;;)
    {
      TXCLog.i(TAG, "startPlay filePath = " + paramString);
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
    this.mIsRunning = false;
    long l = System.currentTimeMillis();
    if ((this.mThread != null) && (this.mThread.isAlive()) && (Thread.currentThread().getId() != this.mThread.getId())) {}
    try
    {
      this.mThread.join();
      label50:
      this.mThread = null;
      nativeStopPlay();
      TXCTraeJNI.nativeTraeStopPlay();
      this.mIsPause = false;
      TXCLog.i(TAG, "stopBGMPlay cost(MS): " + (System.currentTimeMillis() - l));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label50;
    }
  }
  
  public void switchAecType(int paramInt)
  {
    if (!this.mIsRunning) {
      TXCLog.w(TAG, "未开始播放BGM，不能切换AEC Type");
    }
    for (;;)
    {
      return;
      if (this.mAECType == paramInt)
      {
        TXCLog.i(TAG, "无需切换AEC Type. aecType = " + this.mAECType);
        return;
      }
      TXCLog.i(TAG, "切换AEC Type为 " + paramInt);
      this.mAECType = paramInt;
      if ((this.mAECType != TXEAudioDef.TXE_AEC_TRAE) || ((this.mThread != null) && (this.mThread.isAlive()) && (Thread.currentThread().getId() != this.mThread.getId()))) {}
      try
      {
        this.mThread.join();
        label131:
        this.mThread = null;
        return;
        if (this.mThread != null) {
          continue;
        }
        this.mThread = new Thread(this, "BGMPlayer");
        this.mThread.start();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label131;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCLiveBGMPlayer
 * JD-Core Version:    0.7.0.1
 */