package com.tencent.liteav.audio;

import android.media.AudioTrack;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.a;
import java.lang.ref.WeakReference;

public class TXCUGCBGMPlayer
  implements Runnable
{
  private static final int PLAY_ERR_AUDIO_TRACK = -3;
  private static final int PLAY_ERR_AUDIO_TRACK_PLAY = -4;
  private static final int PLAY_ERR_FILE_NOTFOUND = -2;
  private static final int PLAY_ERR_OPEN = -1;
  private static final int PLAY_SUCCESS = 0;
  private static final String TAG = "AudioCenter:TXCUGCBGMPlayer";
  private static TXCUGCBGMPlayer instance;
  private long mEndTimeMS = 0L;
  private String mFilePath = null;
  private boolean mIsPause = false;
  private boolean mIsRunning = false;
  private long mSeekBytes = 0L;
  private float mSpeedRate = 1.0F;
  private long mStartTimeMS = 0L;
  private Thread mThread = null;
  private float mVolume = 1.0F;
  private WeakReference<f> mWeakListener = null;
  
  static {}
  
  public static long getDurationMS(String paramString)
  {
    return nativeGetDurationMS(paramString);
  }
  
  public static TXCUGCBGMPlayer getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new TXCUGCBGMPlayer();
      }
      return instance;
    }
    finally {}
  }
  
  private native int nativeGetBitsPerChannel();
  
  private native int nativeGetChannels();
  
  private native long nativeGetCurDurationMS();
  
  private native long nativeGetCurPosition();
  
  private native long nativeGetCurPtsMS();
  
  private static native long nativeGetDurationMS(String paramString);
  
  private native int nativeGetSampleRate();
  
  private native void nativePause();
  
  private native void nativePlayFromTime(long paramLong1, long paramLong2);
  
  private native int nativeRead(byte[] paramArrayOfByte, int paramInt);
  
  private native void nativeResume();
  
  private native void nativeSeekBytes(long paramLong);
  
  private native void nativeSetSpeedRate(float paramFloat);
  
  private native void nativeSetVolume(float paramFloat);
  
  private native boolean nativeStartPlay(String paramString);
  
  private native void nativeStopPlay();
  
  private void onPlayEnd(int paramInt)
  {
    f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      if (localf != null) {
        localf.a(paramInt);
      }
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
      if (localf != null) {
        localf.a();
      }
      return;
    }
    finally {}
  }
  
  public long getCurPosition()
  {
    long l = nativeGetCurPosition();
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "getCurPosition:" + l);
    return l;
  }
  
  public void pause()
  {
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "pause");
    this.mIsPause = true;
    nativePause();
  }
  
  public void playFromTime(long paramLong1, long paramLong2)
  {
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "playFromTime:" + paramLong1 + ", " + paramLong2);
    this.mStartTimeMS = paramLong1;
    this.mEndTimeMS = paramLong2;
    nativePlayFromTime(paramLong1, paramLong2);
  }
  
  public void resume()
  {
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "resume");
    this.mIsPause = false;
    nativeResume();
  }
  
  public void run()
  {
    int j = 3;
    long l = System.currentTimeMillis();
    onPlayStart();
    int i;
    AudioTrack localAudioTrack;
    if ((this.mFilePath == null) || (this.mFilePath.isEmpty()))
    {
      TXCLog.e("AudioCenter:TXCUGCBGMPlayer", "file path = " + this.mFilePath);
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
          TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "UGC BGM player play time: " + (System.currentTimeMillis() - l));
          if (this.mIsRunning) {
            onPlayEnd(i);
          }
          return;
          nativeSetVolume(this.mVolume);
          nativeSetSpeedRate(this.mSpeedRate);
          nativePlayFromTime(this.mStartTimeMS, this.mEndTimeMS);
          nativeSeekBytes(this.mSeekBytes);
          if (!nativeStartPlay(this.mFilePath))
          {
            i = -1;
            localAudioTrack = null;
            break;
          }
          int k;
          int m;
          if (this.mIsPause)
          {
            nativePause();
            TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "start play bgm: path = " + this.mFilePath + "volume = " + this.mVolume + ", speedRate = " + this.mSpeedRate + ", startTime = " + this.mStartTimeMS + ", endTime = " + this.mEndTimeMS + ", seekBytes = " + this.mSeekBytes + ", pause = " + this.mIsPause);
            k = nativeGetSampleRate();
            m = nativeGetChannels();
            int n = nativeGetBitsPerChannel();
            if (m != 1) {
              break label548;
            }
            i = 2;
            if (n != 8) {
              break label543;
            }
          }
          try
          {
            localAudioTrack = new AudioTrack(3, k, i, j, AudioTrack.getMinBufferSize(k, i, j), 1);
          }
          catch (Exception localException1)
          {
            byte[] arrayOfByte;
            TXCLog.e("AudioCenter:TXCUGCBGMPlayer", "new AudioTrack Exception: " + localException1.getMessage());
            i = -3;
            localObject = null;
          }
          try
          {
            localAudioTrack.play();
            i = m * 2048 * 2;
            arrayOfByte = new byte[i];
            if ((!this.mIsRunning) || (Thread.interrupted())) {
              break label538;
            }
            j = nativeRead(arrayOfByte, i);
            if (j >= 0) {
              break label483;
            }
            TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "UGC BGM播放结束");
            onPlayProgress(nativeGetCurDurationMS(), nativeGetCurDurationMS());
            i = 0;
          }
          catch (Exception localException3)
          {
            TXCLog.e("AudioCenter:TXCUGCBGMPlayer", "AudioTrack play Exception: " + localException3.getMessage());
            i = -4;
          }
        }
        nativeResume();
        continue;
        break;
        break;
        label483:
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
        label538:
        i = 0;
      }
      break;
      label543:
      j = 2;
      continue;
      label548:
      i = 3;
    }
  }
  
  public void seekBytes(long paramLong)
  {
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "seekBytes:" + paramLong);
    long l = paramLong;
    if (paramLong < 0L)
    {
      TXCLog.e("AudioCenter:TXCUGCBGMPlayer", "seek bytes can not be negative. change to 0");
      l = 0L;
    }
    this.mSeekBytes = l;
    nativeSeekBytes(l);
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
  
  public void setSpeedRate(float paramFloat)
  {
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "setSpeedRate:" + paramFloat);
    this.mSpeedRate = paramFloat;
    nativeSetSpeedRate(paramFloat);
  }
  
  public void setVolume(float paramFloat)
  {
    this.mVolume = paramFloat;
    nativeSetVolume(paramFloat);
  }
  
  public void startPlay(String paramString)
  {
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "startPlay:" + paramString);
    if ((paramString == null) || (paramString.isEmpty())) {
      return;
    }
    if (this.mIsRunning)
    {
      TXCLog.w("AudioCenter:TXCUGCBGMPlayer", "BGM正在播放中，将重新启动");
      stopPlay();
    }
    this.mIsPause = false;
    this.mSeekBytes = 0L;
    this.mFilePath = paramString;
    this.mIsRunning = true;
    this.mThread = new Thread(this, "UGCBGMPlayer");
    this.mThread.start();
  }
  
  public void stopPlay()
  {
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "stopPlay");
    this.mIsRunning = false;
    long l = System.currentTimeMillis();
    if ((this.mThread != null) && (this.mThread.isAlive()) && (Thread.currentThread().getId() != this.mThread.getId())) {}
    try
    {
      this.mThread.join();
      label58:
      this.mThread = null;
      try
      {
        nativeStopPlay();
        TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "stopBGMPlay cost(MS): " + (System.currentTimeMillis() - l));
        return;
      }
      finally {}
    }
    catch (InterruptedException localInterruptedException)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCUGCBGMPlayer
 * JD-Core Version:    0.7.0.1
 */