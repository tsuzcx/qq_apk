package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.a.a;
import com.tencent.liteav.audio.impl.a.f;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class TXCAudioUGCRecorder
  implements f
{
  private static final String TAG = "AudioCenter:TXCAudioUGCRecorder";
  static TXCAudioUGCRecorder instance;
  protected int mAECType = 0;
  private a mBGMRecorder = null;
  protected int mBits = 16;
  protected int mChannels = 1;
  protected Context mContext;
  private boolean mCurBGMRecordFlag = false;
  private long mEffectorObj = 0L;
  private boolean mEnableBGMRecord = false;
  protected boolean mIsEarphoneOn = false;
  protected boolean mIsMute = false;
  private boolean mIsPause = false;
  private long mLastPTS = 0L;
  protected int mReverbType = 0;
  protected int mSampleRate = 48000;
  private float mSpeedRate = 1.0F;
  private int mVoiceEnvironment = -1;
  private int mVoiceKind = -1;
  private float mVolume = 1.0F;
  private WeakReference<e> mWeakRecordListener;
  
  static
  {
    AppMethodBeat.i(16329);
    d.f();
    instance = new TXCAudioUGCRecorder();
    AppMethodBeat.o(16329);
  }
  
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
        AppMethodBeat.i(16326);
        uninitEffector();
        this.mEffectorObj = nativeCreateEffector(this.mSampleRate, this.mChannels, this.mBits);
        bool = false;
        if ((!this.mIsEarphoneOn) && (this.mAECType != 1))
        {
          nativeSetReverbType(this.mEffectorObj, this.mReverbType);
          nativeSetChangerType(this.mEffectorObj, this.mVoiceKind, this.mVoiceEnvironment);
          nativeMixBGM(this.mEffectorObj, bool);
          nativeSetVolume(this.mEffectorObj, this.mVolume);
          nativeSetSpeedRate(this.mEffectorObj, this.mSpeedRate);
          nativeEnableEncoder(this.mEffectorObj, true);
          this.mLastPTS = 0L;
          AppMethodBeat.o(16326);
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
      AppMethodBeat.i(16327);
      if (this.mEffectorObj > 0L)
      {
        nativeDestroyEffector(this.mEffectorObj);
        this.mEffectorObj = 0L;
      }
      AppMethodBeat.o(16327);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void clearCache()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 16321
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 10
    //   10: ldc 143
    //   12: invokestatic 148	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 80	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   19: lconst_0
    //   20: lcmp
    //   21: ifgt +12 -> 33
    //   24: sipush 16321
    //   27: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 80	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   38: invokespecial 150	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeClearCache	(J)V
    //   41: sipush 16321
    //   44: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: goto -17 -> 30
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	TXCAudioUGCRecorder
    //   50	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	30	50	finally
    //   33	47	50	finally
  }
  
  public void enableBGMRecord(boolean paramBoolean)
  {
    AppMethodBeat.i(16315);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "enableBGMRecord: ".concat(String.valueOf(paramBoolean)));
    this.mEnableBGMRecord = paramBoolean;
    AppMethodBeat.o(16315);
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
    //   2: sipush 16309
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 170	com/tencent/liteav/audio/TXCAudioUGCRecorder:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   12: ifnull +24 -> 36
    //   15: aload_0
    //   16: getfield 170	com/tencent/liteav/audio/TXCAudioUGCRecorder:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   19: invokevirtual 176	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   22: checkcast 178	com/tencent/liteav/audio/e
    //   25: astore_1
    //   26: sipush 16309
    //   29: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: areturn
    //   36: aconst_null
    //   37: astore_1
    //   38: sipush 16309
    //   41: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -12 -> 32
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	TXCAudioUGCRecorder
    //   25	13	1	locale	e
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	32	47	finally
    //   38	44	47	finally
  }
  
  /* Error */
  public long getPcmCacheLen()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: sipush 16318
    //   7: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 80	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   14: lconst_0
    //   15: lcmp
    //   16: ifgt +13 -> 29
    //   19: sipush 16318
    //   22: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: lload_1
    //   28: lreturn
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 80	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   34: invokespecial 182	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeGetPcmCacheLen	(J)J
    //   37: lstore_1
    //   38: sipush 16318
    //   41: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -19 -> 25
    //   47: astore_3
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_3
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	TXCAudioUGCRecorder
    //   1	37	1	l	long
    //   47	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	25	47	finally
    //   29	44	47	finally
  }
  
  public int getSampleRate()
  {
    return this.mSampleRate;
  }
  
  public boolean isRecording()
  {
    AppMethodBeat.i(16317);
    if (this.mBGMRecorder != null)
    {
      bool = this.mBGMRecorder.b();
      AppMethodBeat.o(16317);
      return bool;
    }
    boolean bool = com.tencent.liteav.audio.impl.a.e.a().b();
    AppMethodBeat.o(16317);
    return bool;
  }
  
  public void onAudioRecordError(int paramInt, String paramString)
  {
    AppMethodBeat.i(16324);
    TXCLog.e("AudioCenter:TXCAudioUGCRecorder", "sys audio record error: " + paramInt + ", " + paramString);
    e locale = getListener();
    if (locale != null) {
      locale.onRecordError(paramInt, paramString);
    }
    AppMethodBeat.o(16324);
  }
  
  public void onAudioRecordPCM(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(16325);
    if (this.mIsPause)
    {
      AppMethodBeat.o(16325);
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
        for (;;)
        {
          try
          {
            paramArrayOfByte = nativeReadOneFrame(this.mEffectorObj);
            if (paramArrayOfByte != null)
            {
              this.mLastPTS = l;
              e locale = getListener();
              if (locale != null) {
                locale.onRecordEncData(paramArrayOfByte, l, this.mSampleRate, this.mChannels, this.mBits);
              }
            }
          }
          finally
          {
            AppMethodBeat.o(16325);
          }
          try
          {
            l += (1024000.0F / this.mSampleRate * this.mSpeedRate);
            if (paramArrayOfByte == null)
            {
              AppMethodBeat.o(16325);
              return;
            }
          }
          finally
          {
            AppMethodBeat.o(16325);
          }
        }
        paramArrayOfByte = finally;
        AppMethodBeat.o(16325);
      }
    }
    TXCLog.e("AudioCenter:TXCAudioUGCRecorder", "effectorObj is null");
    AppMethodBeat.o(16325);
  }
  
  public void onAudioRecordStart()
  {
    AppMethodBeat.i(16322);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "sys audio record start");
    AppMethodBeat.o(16322);
  }
  
  public void onAudioRecordStop()
  {
    AppMethodBeat.i(16323);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "sys audio record stop");
    com.tencent.liteav.audio.impl.a.e.a().a(null);
    AppMethodBeat.o(16323);
  }
  
  public void pause()
  {
    AppMethodBeat.i(16306);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "pause");
    this.mIsPause = true;
    if ((!this.mEnableBGMRecord) && (isRecording()))
    {
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "停止系统录音");
      com.tencent.liteav.audio.impl.a.e.a().a(true);
    }
    AppMethodBeat.o(16306);
  }
  
  public void resume()
  {
    AppMethodBeat.i(16307);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "resume");
    this.mIsPause = false;
    if ((!this.mEnableBGMRecord) && (!isRecording()))
    {
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "恢复系统录音");
      this.mCurBGMRecordFlag = false;
      setEarphoneOn(false);
      com.tencent.liteav.audio.impl.a.e.a().a(this);
      com.tencent.liteav.audio.impl.a.e.a().a(this.mContext, this.mSampleRate, this.mChannels, this.mBits, this.mAECType);
    }
    AppMethodBeat.o(16307);
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfByte) {}
  
  public void setAECType(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(16313);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setAECType: ".concat(String.valueOf(paramInt)));
    this.mAECType = paramInt;
    if (paramContext != null) {
      this.mContext = paramContext.getApplicationContext();
    }
    AppMethodBeat.o(16313);
  }
  
  /* Error */
  public void setChangerType(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 16328
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 10
    //   10: new 200	java/lang/StringBuilder
    //   13: dup
    //   14: ldc_w 295
    //   17: invokespecial 205	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: iload_1
    //   21: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: ldc_w 297
    //   27: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_2
    //   31: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 148	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: iload_1
    //   42: putfield 96	com/tencent/liteav/audio/TXCAudioUGCRecorder:mVoiceKind	I
    //   45: aload_0
    //   46: iload_2
    //   47: putfield 98	com/tencent/liteav/audio/TXCAudioUGCRecorder:mVoiceEnvironment	I
    //   50: aload_0
    //   51: getfield 80	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   54: lconst_0
    //   55: lcmp
    //   56: ifgt +12 -> 68
    //   59: sipush 16328
    //   62: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 80	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   73: iload_1
    //   74: iload_2
    //   75: invokespecial 116	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeSetChangerType	(JII)V
    //   78: sipush 16328
    //   81: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: goto -19 -> 65
    //   87: astore_3
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_3
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	TXCAudioUGCRecorder
    //   0	92	1	paramInt1	int
    //   0	92	2	paramInt2	int
    //   87	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	65	87	finally
    //   68	84	87	finally
  }
  
  public void setChannels(int paramInt)
  {
    AppMethodBeat.i(16310);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setChannels: ".concat(String.valueOf(paramInt)));
    this.mChannels = paramInt;
    AppMethodBeat.o(16310);
  }
  
  public void setEarphoneOn(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(16316);
        TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setEarphoneOn: ".concat(String.valueOf(paramBoolean)));
        this.mIsEarphoneOn = paramBoolean;
        if (this.mEffectorObj > 0L)
        {
          boolean bool = false;
          if (!paramBoolean)
          {
            paramBoolean = bool;
            if (this.mAECType != 1) {
              nativeMixBGM(this.mEffectorObj, paramBoolean);
            }
          }
        }
        else
        {
          AppMethodBeat.o(16316);
          return;
        }
      }
      finally {}
      paramBoolean = true;
    }
  }
  
  /* Error */
  public void setListener(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 16308
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +17 -> 26
    //   12: aload_0
    //   13: aconst_null
    //   14: putfield 170	com/tencent/liteav/audio/TXCAudioUGCRecorder:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   17: sipush 16308
    //   20: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: new 172	java/lang/ref/WeakReference
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 307	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   35: putfield 170	com/tencent/liteav/audio/TXCAudioUGCRecorder:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   38: sipush 16308
    //   41: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -21 -> 23
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	TXCAudioUGCRecorder
    //   0	52	1	parame	e
    // Exception table:
    //   from	to	target	type
    //   2	8	47	finally
    //   12	23	47	finally
    //   26	44	47	finally
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(16314);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setMute: ".concat(String.valueOf(paramBoolean)));
    this.mIsMute = paramBoolean;
    AppMethodBeat.o(16314);
  }
  
  public void setReverbType(int paramInt)
  {
    try
    {
      AppMethodBeat.i(16312);
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setReverbType: ".concat(String.valueOf(paramInt)));
      this.mReverbType = paramInt;
      if (this.mEffectorObj > 0L) {
        nativeSetReverbType(this.mEffectorObj, paramInt);
      }
      AppMethodBeat.o(16312);
      return;
    }
    finally {}
  }
  
  public void setSampleRate(int paramInt)
  {
    AppMethodBeat.i(16311);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setSampleRate: ".concat(String.valueOf(paramInt)));
    this.mSampleRate = paramInt;
    AppMethodBeat.o(16311);
  }
  
  /* Error */
  public void setSpeedRate(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 16320
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 10
    //   10: ldc_w 320
    //   13: fload_1
    //   14: invokestatic 323	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   17: invokevirtual 164	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokestatic 148	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: fload_1
    //   25: putfield 92	com/tencent/liteav/audio/TXCAudioUGCRecorder:mSpeedRate	F
    //   28: aload_0
    //   29: getfield 80	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   32: lconst_0
    //   33: lcmp
    //   34: ifgt +12 -> 46
    //   37: sipush 16320
    //   40: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 80	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   51: aload_0
    //   52: getfield 92	com/tencent/liteav/audio/TXCAudioUGCRecorder:mSpeedRate	F
    //   55: invokespecial 127	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeSetSpeedRate	(JF)V
    //   58: sipush 16320
    //   61: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: goto -21 -> 43
    //   67: astore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	TXCAudioUGCRecorder
    //   0	72	1	paramFloat	float
    //   67	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	67	finally
    //   46	64	67	finally
  }
  
  /* Error */
  public void setVolume(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 16319
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 10
    //   10: ldc_w 326
    //   13: fload_1
    //   14: invokestatic 323	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   17: invokevirtual 164	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokestatic 148	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: fload_1
    //   25: putfield 84	com/tencent/liteav/audio/TXCAudioUGCRecorder:mVolume	F
    //   28: aload_0
    //   29: getfield 80	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   32: lconst_0
    //   33: lcmp
    //   34: ifgt +12 -> 46
    //   37: sipush 16319
    //   40: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 80	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   51: fload_1
    //   52: invokespecial 124	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeSetVolume	(JF)V
    //   55: sipush 16319
    //   58: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: goto -18 -> 43
    //   64: astore_2
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	TXCAudioUGCRecorder
    //   0	69	1	paramFloat	float
    //   64	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	64	finally
    //   46	61	64	finally
  }
  
  public int startRecord(Context paramContext)
  {
    AppMethodBeat.i(16304);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "startRecord");
    boolean bool;
    if (isRecording())
    {
      if (this.mEnableBGMRecord == this.mCurBGMRecordFlag)
      {
        TXCLog.e("AudioCenter:TXCAudioUGCRecorder", "startRecord failed! recorder is still running!");
        AppMethodBeat.o(16304);
        return -1;
      }
      TXCLog.e("AudioCenter:TXCAudioUGCRecorder", "recorder is still running. will restart record! bgm record flag = " + this.mEnableBGMRecord);
      stopRecord();
      if (!this.mCurBGMRecordFlag)
      {
        bool = true;
        enableBGMRecord(bool);
      }
    }
    else
    {
      if (paramContext != null) {
        this.mContext = paramContext.getApplicationContext();
      }
      initEffector();
      if (!this.mEnableBGMRecord) {
        break label188;
      }
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "录制BGM");
      this.mCurBGMRecordFlag = true;
      this.mBGMRecorder = new a();
      this.mBGMRecorder.a(this);
      setEarphoneOn(true);
      this.mBGMRecorder.a(this.mContext, this.mSampleRate, this.mChannels, this.mBits);
    }
    for (;;)
    {
      AppMethodBeat.o(16304);
      return 0;
      bool = false;
      break;
      label188:
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "录制人声");
      this.mCurBGMRecordFlag = false;
      setEarphoneOn(false);
      com.tencent.liteav.audio.impl.a.e.a().a(this);
      com.tencent.liteav.audio.impl.a.e.a().a(this.mContext, this.mSampleRate, this.mChannels, this.mBits, this.mAECType);
    }
  }
  
  public int stopRecord()
  {
    AppMethodBeat.i(16305);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "stopRecord");
    if (this.mBGMRecorder != null)
    {
      this.mBGMRecorder.a();
      this.mBGMRecorder = null;
    }
    com.tencent.liteav.audio.impl.a.e.a().a(true);
    enableBGMRecord(false);
    this.mIsPause = false;
    uninitEffector();
    AppMethodBeat.o(16305);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCAudioUGCRecorder
 * JD-Core Version:    0.7.0.1
 */