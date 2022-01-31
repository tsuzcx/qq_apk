package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Record.f;
import com.tencent.liteav.audio.impl.Record.h;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class TXCAudioUGCRecorder
  implements h
{
  private static final String TAG = "AudioCenter:TXCAudioUGCRecorder";
  static TXCAudioUGCRecorder instance = new TXCAudioUGCRecorder();
  protected int mAECType = TXEAudioDef.TXE_AEC_NONE;
  private com.tencent.liteav.audio.impl.Record.a mBGMRecorder = null;
  protected int mBits = com.tencent.liteav.basic.a.a.h;
  protected int mChannels = com.tencent.liteav.basic.a.a.f;
  protected Context mContext;
  private boolean mCurBGMRecordFlag = false;
  private long mEffectorObj = 0L;
  private boolean mEnableBGMRecord = false;
  protected boolean mIsEarphoneOn = false;
  protected boolean mIsMute = false;
  private boolean mIsPause = false;
  private long mLastPTS = 0L;
  protected int mReverbType = TXEAudioDef.TXE_REVERB_TYPE_0;
  protected int mSampleRate = com.tencent.liteav.basic.a.a.e;
  private float mSpeedRate = 1.0F;
  private int mVoiceEnvironment;
  private int mVoiceKind;
  private float mVolume = 1.0F;
  private WeakReference<e> mWeakRecordListener;
  
  static {}
  
  public static TXCAudioUGCRecorder getInstance()
  {
    return instance;
  }
  
  private void initEffector()
  {
    for (;;)
    {
      try
      {
        uninitEffector();
        this.mEffectorObj = nativeCreateEffector(this.mSampleRate, this.mChannels, this.mBits);
        bool = false;
        if ((!this.mIsEarphoneOn) && (this.mAECType != TXEAudioDef.TXE_AEC_SYSTEM))
        {
          nativeSetReverbType(this.mEffectorObj, this.mReverbType);
          nativeSetChangerType(this.mEffectorObj, this.mVoiceKind, this.mVoiceEnvironment);
          nativeMixBGM(this.mEffectorObj, bool);
          nativeSetVolume(this.mEffectorObj, this.mVolume);
          nativeSetSpeedRate(this.mEffectorObj, this.mSpeedRate);
          nativeEnableEncoder(this.mEffectorObj, true);
          this.mLastPTS = 0L;
          return;
        }
      }
      finally {}
      boolean bool = true;
    }
  }
  
  private native void nativeClearCache(long paramLong);
  
  private native long nativeCreateEffector(int paramInt1, int paramInt2, int paramInt3);
  
  private native void nativeDestroyEffector(long paramLong);
  
  private native void nativeEnableEncoder(long paramLong, boolean paramBoolean);
  
  private native long nativeGetPcmCacheLen(long paramLong);
  
  private native void nativeMixBGM(long paramLong, boolean paramBoolean);
  
  private native void nativeProcess(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native byte[] nativeReadOneFrame(long paramLong);
  
  private native void nativeSetChangerType(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSetReverbType(long paramLong, int paramInt);
  
  private native void nativeSetSpeedRate(long paramLong, float paramFloat);
  
  private native void nativeSetVolume(long paramLong, float paramFloat);
  
  private void uninitEffector()
  {
    try
    {
      if (this.mEffectorObj > 0L)
      {
        nativeDestroyEffector(this.mEffectorObj);
        this.mEffectorObj = 0L;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void clearCache()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 10
    //   4: ldc 154
    //   6: invokestatic 160	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 88	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   13: lstore_1
    //   14: lload_1
    //   15: lconst_0
    //   16: lcmp
    //   17: ifgt +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 88	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   28: invokespecial 162	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeClearCache	(J)V
    //   31: goto -11 -> 20
    //   34: astore_3
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_3
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	TXCAudioUGCRecorder
    //   13	2	1	l	long
    //   34	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	34	finally
    //   23	31	34	finally
  }
  
  public void enableBGMRecord(boolean paramBoolean)
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "enableBGMRecord: " + paramBoolean);
    this.mEnableBGMRecord = paramBoolean;
  }
  
  public int getChannels()
  {
    return this.mChannels;
  }
  
  /* Error */
  public e getListener()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 185	com/tencent/liteav/audio/TXCAudioUGCRecorder:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   6: ifnull +18 -> 24
    //   9: aload_0
    //   10: getfield 185	com/tencent/liteav/audio/TXCAudioUGCRecorder:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   13: invokevirtual 191	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   16: checkcast 193	com/tencent/liteav/audio/e
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: aconst_null
    //   25: astore_1
    //   26: goto -6 -> 20
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	TXCAudioUGCRecorder
    //   19	7	1	locale	e
    //   29	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	29	finally
  }
  
  /* Error */
  public long getPcmCacheLen()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 88	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   8: lstore_3
    //   9: lload_3
    //   10: lconst_0
    //   11: lcmp
    //   12: ifgt +7 -> 19
    //   15: aload_0
    //   16: monitorexit
    //   17: lload_1
    //   18: lreturn
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 88	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   24: invokespecial 197	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeGetPcmCacheLen	(J)J
    //   27: lstore_1
    //   28: goto -13 -> 15
    //   31: astore 5
    //   33: aload_0
    //   34: monitorexit
    //   35: aload 5
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	TXCAudioUGCRecorder
    //   1	27	1	l1	long
    //   8	2	3	l2	long
    //   31	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	31	finally
    //   19	28	31	finally
  }
  
  public int getSampleRate()
  {
    return this.mSampleRate;
  }
  
  public boolean isRecording()
  {
    if (this.mBGMRecorder != null) {
      return this.mBGMRecorder.b();
    }
    return f.a().c();
  }
  
  public void onAudioRecordError(int paramInt, String paramString)
  {
    TXCLog.e("AudioCenter:TXCAudioUGCRecorder", "sys audio record error: " + paramInt + ", " + paramString);
    f.a().a(null);
    e locale = getListener();
    if (locale != null) {
      locale.a(paramInt, paramString);
    }
  }
  
  public void onAudioRecordPCM(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    if (this.mIsPause) {
      return;
    }
    if (this.mEffectorObj > 0L)
    {
      if (this.mIsMute) {
        Arrays.fill(paramArrayOfByte, (byte)0);
      }
      long l = paramLong;
      if (this.mLastPTS >= paramLong) {
        l = this.mLastPTS + 2L;
      }
      try
      {
        nativeProcess(this.mEffectorObj, paramArrayOfByte, paramInt);
      }
      finally
      {
        try
        {
          do
          {
            paramArrayOfByte = nativeReadOneFrame(this.mEffectorObj);
            if (paramArrayOfByte != null)
            {
              this.mLastPTS = l;
              e locale = getListener();
              if (locale != null) {
                locale.b(paramArrayOfByte, l, this.mSampleRate, this.mChannels, this.mBits);
              }
            }
            l = ((float)l + 1024000 / this.mSampleRate * this.mSpeedRate);
          } while (paramArrayOfByte != null);
          return;
        }
        finally {}
        paramArrayOfByte = finally;
      }
    }
    TXCLog.e("AudioCenter:TXCAudioUGCRecorder", "effectorObj is null");
  }
  
  public void onAudioRecordStart()
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "sys audio record start");
  }
  
  public void onAudioRecordStop()
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "sys audio record stop");
    f.a().a(null);
  }
  
  public void pause()
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "pause");
    this.mIsPause = true;
    if ((!this.mEnableBGMRecord) && (isRecording()))
    {
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "停止系统录音");
      f.a().b();
    }
  }
  
  public void resume()
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "resume");
    this.mIsPause = false;
    if ((!this.mEnableBGMRecord) && (!isRecording()))
    {
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "恢复系统录音");
      this.mCurBGMRecordFlag = false;
      setEarphoneOn(false);
      f.a().a(this);
      f.a().a(this.mContext, this.mSampleRate, this.mChannels, this.mBits, this.mAECType);
    }
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfByte) {}
  
  public void setAECType(int paramInt, Context paramContext)
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setAECType: " + paramInt);
    this.mAECType = paramInt;
    if (paramContext != null) {
      this.mContext = paramContext.getApplicationContext();
    }
  }
  
  public void setChangerType(int paramInt1, int paramInt2)
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setChangerType: " + paramInt1 + " " + paramInt2);
    this.mVoiceKind = paramInt1;
    this.mVoiceEnvironment = paramInt2;
    if (this.mEffectorObj <= 0L) {
      return;
    }
    nativeSetChangerType(this.mEffectorObj, paramInt1, paramInt2);
  }
  
  public void setChannels(int paramInt)
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setChannels: " + paramInt);
    this.mChannels = paramInt;
  }
  
  public void setEarphoneOn(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setEarphoneOn: " + paramBoolean);
        this.mIsEarphoneOn = paramBoolean;
        if (this.mEffectorObj > 0L)
        {
          boolean bool = false;
          if (!paramBoolean)
          {
            paramBoolean = bool;
            if (this.mAECType != TXEAudioDef.TXE_AEC_SYSTEM) {
              nativeMixBGM(this.mEffectorObj, paramBoolean);
            }
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      paramBoolean = true;
    }
  }
  
  public void setListener(e parame)
  {
    if (parame == null) {}
    for (;;)
    {
      try
      {
        this.mWeakRecordListener = null;
        return;
      }
      finally {}
      this.mWeakRecordListener = new WeakReference(parame);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setMute: " + paramBoolean);
    this.mIsMute = paramBoolean;
  }
  
  public void setReverbType(int paramInt)
  {
    try
    {
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setReverbType: " + paramInt);
      this.mReverbType = paramInt;
      if (this.mEffectorObj > 0L) {
        nativeSetReverbType(this.mEffectorObj, paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setSampleRate(int paramInt)
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setSampleRate: " + paramInt);
    this.mSampleRate = paramInt;
  }
  
  /* Error */
  public void setSpeedRate(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 10
    //   4: new 166	java/lang/StringBuilder
    //   7: dup
    //   8: ldc_w 323
    //   11: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: fload_1
    //   15: invokevirtual 326	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   18: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 160	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: fload_1
    //   26: putfield 100	com/tencent/liteav/audio/TXCAudioUGCRecorder:mSpeedRate	F
    //   29: aload_0
    //   30: getfield 88	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   33: lstore_2
    //   34: lload_2
    //   35: lconst_0
    //   36: lcmp
    //   37: ifgt +6 -> 43
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 88	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   48: aload_0
    //   49: getfield 100	com/tencent/liteav/audio/TXCAudioUGCRecorder:mSpeedRate	F
    //   52: invokespecial 138	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeSetSpeedRate	(JF)V
    //   55: goto -15 -> 40
    //   58: astore 4
    //   60: aload_0
    //   61: monitorexit
    //   62: aload 4
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	TXCAudioUGCRecorder
    //   0	65	1	paramFloat	float
    //   33	2	2	l	long
    //   58	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	58	finally
    //   43	55	58	finally
  }
  
  /* Error */
  public void setVolume(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 10
    //   4: new 166	java/lang/StringBuilder
    //   7: dup
    //   8: ldc_w 329
    //   11: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: fload_1
    //   15: invokevirtual 326	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   18: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 160	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: fload_1
    //   26: putfield 92	com/tencent/liteav/audio/TXCAudioUGCRecorder:mVolume	F
    //   29: aload_0
    //   30: getfield 88	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   33: lstore_2
    //   34: lload_2
    //   35: lconst_0
    //   36: lcmp
    //   37: ifgt +6 -> 43
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 88	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   48: fload_1
    //   49: invokespecial 135	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeSetVolume	(JF)V
    //   52: goto -12 -> 40
    //   55: astore 4
    //   57: aload_0
    //   58: monitorexit
    //   59: aload 4
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	TXCAudioUGCRecorder
    //   0	62	1	paramFloat	float
    //   33	2	2	l	long
    //   55	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	55	finally
    //   43	52	55	finally
  }
  
  public int startRecord(Context paramContext)
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "startRecord");
    if (isRecording())
    {
      if (this.mEnableBGMRecord == this.mCurBGMRecordFlag)
      {
        TXCLog.e("AudioCenter:TXCAudioUGCRecorder", "startRecord failed! recorder is still running!");
        return -1;
      }
      TXCLog.e("AudioCenter:TXCAudioUGCRecorder", "recorder is still running. will restart record! bgm record flag = " + this.mEnableBGMRecord);
      stopRecord();
      if (this.mCurBGMRecordFlag) {
        break label165;
      }
    }
    label165:
    for (boolean bool = true;; bool = false)
    {
      enableBGMRecord(bool);
      if (paramContext != null) {
        this.mContext = paramContext.getApplicationContext();
      }
      initEffector();
      if (!this.mEnableBGMRecord) {
        break;
      }
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "录制BGM");
      this.mCurBGMRecordFlag = true;
      this.mBGMRecorder = new com.tencent.liteav.audio.impl.Record.a();
      this.mBGMRecorder.a(this);
      setEarphoneOn(true);
      this.mBGMRecorder.a(this.mContext, this.mSampleRate, this.mChannels, this.mBits);
      return 0;
    }
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "录制人声");
    this.mCurBGMRecordFlag = false;
    setEarphoneOn(false);
    f.a().a(this);
    f.a().a(this.mContext, this.mSampleRate, this.mChannels, this.mBits, this.mAECType);
    return 0;
  }
  
  public int stopRecord()
  {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "stopRecord");
    if (this.mBGMRecorder != null)
    {
      this.mBGMRecorder.a();
      this.mBGMRecorder = null;
    }
    f.a().b();
    enableBGMRecord(false);
    this.mIsPause = false;
    uninitEffector();
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCAudioUGCRecorder
 * JD-Core Version:    0.7.0.1
 */