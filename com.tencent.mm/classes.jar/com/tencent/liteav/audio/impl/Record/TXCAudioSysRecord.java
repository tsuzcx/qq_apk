package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import android.media.AudioRecord;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class TXCAudioSysRecord
  implements Runnable
{
  private static final String TAG;
  private static TXCAudioSysRecord instance;
  private int mAECType;
  private int mBits;
  private int mChannels;
  private Context mContext;
  private boolean mIsCapFirstFrame;
  private boolean mIsRunning;
  private AudioRecord mMic;
  private AtomicBoolean mPause;
  private byte[] mRecordBuffer;
  private Thread mRecordThread;
  private int mSampleRate;
  private boolean mSendMuteData;
  private WeakReference<c> mWeakRefListener;
  private Object threadMutex;
  
  static
  {
    AppMethodBeat.i(230515);
    TAG = "AudioCenter:" + TXCAudioSysRecord.class.getSimpleName();
    instance = null;
    AppMethodBeat.o(230515);
  }
  
  private TXCAudioSysRecord()
  {
    AppMethodBeat.i(230456);
    this.mSampleRate = 48000;
    this.mChannels = 1;
    this.mBits = 16;
    this.mAECType = 0;
    this.mRecordBuffer = null;
    this.mRecordThread = null;
    this.mIsRunning = false;
    this.mIsCapFirstFrame = false;
    this.mSendMuteData = false;
    this.mPause = new AtomicBoolean(false);
    this.threadMutex = new Object();
    nativeClassInit();
    AppMethodBeat.o(230456);
  }
  
  public static TXCAudioSysRecord getInstance()
  {
    AppMethodBeat.i(230450);
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new TXCAudioSysRecord();
      }
      TXCAudioSysRecord localTXCAudioSysRecord = instance;
      AppMethodBeat.o(230450);
      return localTXCAudioSysRecord;
    }
    finally
    {
      AppMethodBeat.o(230450);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(230471);
    int k = this.mSampleRate;
    int m = this.mChannels;
    int n = this.mBits;
    int i = this.mAECType;
    TXCLog.i(TAG, String.format("audio record sampleRate = %d, channels = %d, bits = %d, aectype = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i) }));
    i = 12;
    if (m == 1) {
      i = 16;
    }
    if (n == 8) {}
    for (int j = 3;; j = 2)
    {
      int i1 = AudioRecord.getMinBufferSize(k, i, j);
      try
      {
        TXCLog.i(TAG, "audio record type: system normal");
        this.mMic = new AudioRecord(1, k, i, j, i1 * 2);
        if ((this.mMic == null) || (this.mMic.getState() != 1))
        {
          TXCLog.e(TAG, "audio record: initialize the mic failed.");
          uninit();
          onRecordError(-1, "microphone permission denied!");
          AppMethodBeat.o(230471);
          return;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          TXCLog.e(TAG, "create AudioRecord failed.", localIllegalArgumentException);
        }
        i = m * 1024 * n / 8;
        if (i > i1) {}
        for (this.mRecordBuffer = new byte[i1];; this.mRecordBuffer = new byte[i])
        {
          TXCLog.i(TAG, String.format("audio record: mic open rate=%dHZ, channels=%d, bits=%d, buffer=%d/%d, state=%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(this.mRecordBuffer.length), Integer.valueOf(this.mMic.getState()) }));
          if (this.mMic == null) {
            break;
          }
          try
          {
            a.a(this.mMic, "com/tencent/liteav/audio/impl/Record/TXCAudioSysRecord", "init", "()V", "android/media/AudioRecord", "startRecording", "()V");
            AppMethodBeat.o(230471);
            return;
          }
          catch (Exception localException)
          {
            TXCLog.e(TAG, "mic startRecording failed.", localException);
            onRecordError(-1, "start recording failed!");
            AppMethodBeat.o(230471);
            return;
          }
        }
        AppMethodBeat.o(230471);
        return;
      }
    }
  }
  
  private native void nativeClassInit();
  
  private native void nativeSendSysRecordAudioData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private void onRecordError(int paramInt, String paramString)
  {
    AppMethodBeat.i(230489);
    c localc = null;
    try
    {
      if (this.mWeakRefListener != null) {
        localc = (c)this.mWeakRefListener.get();
      }
      if (localc != null)
      {
        localc.onAudioRecordError(paramInt, paramString);
        AppMethodBeat.o(230489);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(230489);
    }
    TXCLog.e(TAG, "onRecordError:no callback");
    AppMethodBeat.o(230489);
  }
  
  private void onRecordPcmData(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(230484);
    c localc = null;
    if (this.mWeakRefListener != null) {
      localc = (c)this.mWeakRefListener.get();
    }
    if (localc != null)
    {
      localc.onAudioRecordPCM(paramArrayOfByte, paramInt, paramLong);
      AppMethodBeat.o(230484);
      return;
    }
    TXCLog.e(TAG, "onRecordPcmData:no callback");
    AppMethodBeat.o(230484);
  }
  
  private void onRecordStart()
  {
    AppMethodBeat.i(230495);
    c localc = null;
    try
    {
      if (this.mWeakRefListener != null) {
        localc = (c)this.mWeakRefListener.get();
      }
      if (localc != null)
      {
        localc.onAudioRecordStart();
        AppMethodBeat.o(230495);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(230495);
    }
    TXCLog.e(TAG, "onRecordStart:no callback");
    AppMethodBeat.o(230495);
  }
  
  private void onRecordStop()
  {
    AppMethodBeat.i(230501);
    c localc = null;
    try
    {
      if (this.mWeakRefListener != null) {
        localc = (c)this.mWeakRefListener.get();
      }
      if (localc != null)
      {
        localc.onAudioRecordStop();
        AppMethodBeat.o(230501);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(230501);
    }
    TXCLog.e(TAG, "onRecordStop:no callback");
    AppMethodBeat.o(230501);
  }
  
  private void uninit()
  {
    AppMethodBeat.i(230479);
    if (this.mMic != null) {
      TXCLog.i(TAG, "stop mic");
    }
    try
    {
      this.mMic.setRecordPositionUpdateListener(null);
      this.mMic.stop();
      this.mMic.release();
      this.mMic = null;
      this.mRecordBuffer = null;
      this.mIsCapFirstFrame = false;
      AppMethodBeat.o(230479);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TXCLog.e(TAG, "stop AudioRecord failed.", localException);
      }
    }
  }
  
  public boolean isRecording()
  {
    try
    {
      boolean bool = this.mIsRunning;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void pause(boolean paramBoolean)
  {
    AppMethodBeat.i(230541);
    TXCLog.i(TAG, "system audio record pause");
    this.mPause.set(true);
    this.mSendMuteData = paramBoolean;
    AppMethodBeat.o(230541);
  }
  
  public void resume()
  {
    AppMethodBeat.i(230545);
    TXCLog.i(TAG, "system audio record resume");
    this.mPause.set(false);
    AppMethodBeat.o(230545);
  }
  
  public void run()
  {
    AppMethodBeat.i(230564);
    if (!this.mIsRunning)
    {
      TXCLog.w(TAG, "audio record: abandom start audio sys record thread!");
      AppMethodBeat.o(230564);
      return;
    }
    onRecordStart();
    TXCLog.i(TAG, "start capture audio data ...,mIsRunning:" + this.mIsRunning + " Thread.interrupted:" + Thread.interrupted() + " mMic:" + this.mMic);
    init();
    int i = 0;
    int j = 0;
    while ((this.mIsRunning) && (!Thread.interrupted()) && (this.mMic != null) && (j <= 5))
    {
      System.currentTimeMillis();
      int k = this.mMic.read(this.mRecordBuffer, i, this.mRecordBuffer.length - i);
      if (k != this.mRecordBuffer.length - i)
      {
        if (k <= 0)
        {
          TXCLog.e(TAG, "read pcm error, len =".concat(String.valueOf(k)));
          j += 1;
        }
        else
        {
          i += k;
        }
      }
      else
      {
        if (!this.mIsCapFirstFrame)
        {
          onRecordError(-6, "First frame captured#");
          this.mIsCapFirstFrame = true;
        }
        if (this.mSendMuteData) {
          Arrays.fill(this.mRecordBuffer, (byte)0);
        }
        if ((!this.mPause.get()) || (this.mSendMuteData)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0)
          {
            onRecordPcmData(this.mRecordBuffer, this.mRecordBuffer.length, TXCTimeUtil.getTimeTick());
            nativeSendSysRecordAudioData(this.mRecordBuffer, this.mRecordBuffer.length, this.mSampleRate, this.mChannels, this.mBits);
          }
          i = 0;
          j = 0;
          break;
        }
      }
    }
    TXCLog.d(TAG, "stop capture audio data ...,mIsRunning:" + this.mIsRunning + " mMic:" + this.mMic + " nFailedCount:" + j);
    uninit();
    if (j > 5)
    {
      onRecordError(-1, "read data failed!");
      AppMethodBeat.o(230564);
      return;
    }
    onRecordStop();
    AppMethodBeat.o(230564);
  }
  
  /* Error */
  public void setAudioRecordListener(c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 340
    //   5: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +17 -> 26
    //   12: aload_0
    //   13: aconst_null
    //   14: putfield 194	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecord:mWeakRefListener	Ljava/lang/ref/WeakReference;
    //   17: ldc_w 340
    //   20: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: new 196	java/lang/ref/WeakReference
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 343	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   35: putfield 194	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecord:mWeakRefListener	Ljava/lang/ref/WeakReference;
    //   38: ldc_w 340
    //   41: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -21 -> 23
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	TXCAudioSysRecord
    //   0	52	1	paramc	c
    // Exception table:
    //   from	to	target	type
    //   2	8	47	finally
    //   12	23	47	finally
    //   26	44	47	finally
  }
  
  public void start(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(230527);
    TXCLog.i(TAG, "start");
    synchronized (this.threadMutex)
    {
      stop();
      this.mSampleRate = paramInt1;
      this.mChannels = paramInt2;
      this.mBits = paramInt3;
      this.mIsRunning = true;
      this.mRecordThread = new Thread(this, "AudioSysRecord Thread");
      this.mRecordThread.start();
      TXCLog.i(TAG, "start ok");
      AppMethodBeat.o(230527);
      return;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(230536);
    TXCLog.i(TAG, "stop");
    synchronized (this.threadMutex)
    {
      this.mIsRunning = false;
      long l1 = System.currentTimeMillis();
      if ((this.mRecordThread != null) && (this.mRecordThread.isAlive()))
      {
        long l2 = Thread.currentThread().getId();
        long l3 = this.mRecordThread.getId();
        if (l2 == l3) {}
      }
      try
      {
        this.mRecordThread.join();
        TXCLog.i(TAG, "stop ok,stop record cost time(MS): " + (System.currentTimeMillis() - l1));
        this.mRecordThread = null;
        TXCLog.i(TAG, "stop ok");
        AppMethodBeat.o(230536);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          TXCLog.e(TAG, "record stop Exception: " + localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.TXCAudioSysRecord
 * JD-Core Version:    0.7.0.1
 */