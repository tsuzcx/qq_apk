package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Record.a;
import com.tencent.liteav.audio.impl.Record.f;
import com.tencent.liteav.audio.impl.Record.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class TXCAudioUGCRecorder
  implements h
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
  private WeakReference<d> mWeakRecordListener;
  
  static
  {
    AppMethodBeat.i(66500);
    b.f();
    instance = new TXCAudioUGCRecorder();
    AppMethodBeat.o(66500);
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
        AppMethodBeat.i(66497);
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
          AppMethodBeat.o(66497);
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
      AppMethodBeat.i(66498);
      if (this.mEffectorObj > 0L)
      {
        nativeDestroyEffector(this.mEffectorObj);
        this.mEffectorObj = 0L;
      }
      AppMethodBeat.o(66498);
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
    //   2: ldc 146
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 10
    //   9: ldc 147
    //   11: invokestatic 152	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 81	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   18: lconst_0
    //   19: lcmp
    //   20: ifgt +11 -> 31
    //   23: ldc 146
    //   25: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 81	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   36: invokespecial 154	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeClearCache	(J)V
    //   39: ldc 146
    //   41: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -16 -> 28
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	TXCAudioUGCRecorder
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	28	47	finally
    //   31	44	47	finally
  }
  
  public void enableBGMRecord(boolean paramBoolean)
  {
    AppMethodBeat.i(66486);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "enableBGMRecord: ".concat(String.valueOf(paramBoolean)));
    this.mEnableBGMRecord = paramBoolean;
    AppMethodBeat.o(66486);
  }
  
  public int getChannels()
  {
    return this.mChannels;
  }
  
  /* Error */
  public d getListener()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 174
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 176	com/tencent/liteav/audio/TXCAudioUGCRecorder:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   11: ifnull +23 -> 34
    //   14: aload_0
    //   15: getfield 176	com/tencent/liteav/audio/TXCAudioUGCRecorder:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   18: invokevirtual 182	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   21: checkcast 184	com/tencent/liteav/audio/d
    //   24: astore_1
    //   25: ldc 174
    //   27: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: areturn
    //   34: aconst_null
    //   35: astore_1
    //   36: ldc 174
    //   38: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -11 -> 30
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	TXCAudioUGCRecorder
    //   24	12	1	locald	d
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	30	44	finally
    //   36	41	44	finally
  }
  
  /* Error */
  public long getPcmCacheLen()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 187
    //   6: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 81	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   13: lconst_0
    //   14: lcmp
    //   15: ifgt +12 -> 27
    //   18: ldc 187
    //   20: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: lload_1
    //   26: lreturn
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 81	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   32: invokespecial 189	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeGetPcmCacheLen	(J)J
    //   35: lstore_1
    //   36: ldc 187
    //   38: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -18 -> 23
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	TXCAudioUGCRecorder
    //   1	35	1	l	long
    //   44	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	23	44	finally
    //   27	41	44	finally
  }
  
  public int getSampleRate()
  {
    return this.mSampleRate;
  }
  
  public boolean isRecording()
  {
    AppMethodBeat.i(66488);
    if (this.mBGMRecorder != null)
    {
      bool = this.mBGMRecorder.b();
      AppMethodBeat.o(66488);
      return bool;
    }
    boolean bool = f.a().c();
    AppMethodBeat.o(66488);
    return bool;
  }
  
  public void onAudioRecordError(int paramInt, String paramString)
  {
    AppMethodBeat.i(66495);
    TXCLog.e("AudioCenter:TXCAudioUGCRecorder", "sys audio record error: " + paramInt + ", " + paramString);
    f.a().a(null);
    d locald = getListener();
    if (locald != null) {
      locald.a(paramInt, paramString);
    }
    AppMethodBeat.o(66495);
  }
  
  public void onAudioRecordPCM(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(66496);
    if (this.mIsPause)
    {
      AppMethodBeat.o(66496);
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
              d locald = getListener();
              if (locald != null) {
                locald.b(paramArrayOfByte, l, this.mSampleRate, this.mChannels, this.mBits);
              }
            }
          }
          finally
          {
            AppMethodBeat.o(66496);
          }
          try
          {
            l += (1024000.0F / this.mSampleRate * this.mSpeedRate);
            if (paramArrayOfByte == null)
            {
              AppMethodBeat.o(66496);
              return;
            }
          }
          finally
          {
            AppMethodBeat.o(66496);
          }
        }
        paramArrayOfByte = finally;
        AppMethodBeat.o(66496);
      }
    }
    TXCLog.e("AudioCenter:TXCAudioUGCRecorder", "effectorObj is null");
    AppMethodBeat.o(66496);
  }
  
  public void onAudioRecordStart()
  {
    AppMethodBeat.i(66493);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "sys audio record start");
    AppMethodBeat.o(66493);
  }
  
  public void onAudioRecordStop()
  {
    AppMethodBeat.i(66494);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "sys audio record stop");
    f.a().a(null);
    AppMethodBeat.o(66494);
  }
  
  public void pause()
  {
    AppMethodBeat.i(66477);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "pause");
    this.mIsPause = true;
    if ((!this.mEnableBGMRecord) && (isRecording()))
    {
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "停止系统录音");
      f.a().b();
    }
    AppMethodBeat.o(66477);
  }
  
  public void resume()
  {
    AppMethodBeat.i(66478);
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
    AppMethodBeat.o(66478);
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfByte) {}
  
  public void setAECType(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(66484);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setAECType: ".concat(String.valueOf(paramInt)));
    this.mAECType = paramInt;
    if (paramContext != null) {
      this.mContext = paramContext.getApplicationContext();
    }
    AppMethodBeat.o(66484);
  }
  
  /* Error */
  public void setChangerType(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 309
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 10
    //   10: new 211	java/lang/StringBuilder
    //   13: dup
    //   14: ldc_w 311
    //   17: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: iload_1
    //   21: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: ldc_w 313
    //   27: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_2
    //   31: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 152	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: iload_1
    //   42: putfield 97	com/tencent/liteav/audio/TXCAudioUGCRecorder:mVoiceKind	I
    //   45: aload_0
    //   46: iload_2
    //   47: putfield 99	com/tencent/liteav/audio/TXCAudioUGCRecorder:mVoiceEnvironment	I
    //   50: aload_0
    //   51: getfield 81	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   54: lconst_0
    //   55: lcmp
    //   56: ifgt +12 -> 68
    //   59: ldc_w 309
    //   62: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 81	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   73: iload_1
    //   74: iload_2
    //   75: invokespecial 118	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeSetChangerType	(JII)V
    //   78: ldc_w 309
    //   81: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(66481);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setChannels: ".concat(String.valueOf(paramInt)));
    this.mChannels = paramInt;
    AppMethodBeat.o(66481);
  }
  
  public void setEarphoneOn(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(66487);
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
          AppMethodBeat.o(66487);
          return;
        }
      }
      finally {}
      paramBoolean = true;
    }
  }
  
  /* Error */
  public void setListener(d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 323
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +17 -> 26
    //   12: aload_0
    //   13: aconst_null
    //   14: putfield 176	com/tencent/liteav/audio/TXCAudioUGCRecorder:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   17: ldc_w 323
    //   20: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: new 178	java/lang/ref/WeakReference
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 326	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   35: putfield 176	com/tencent/liteav/audio/TXCAudioUGCRecorder:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   38: ldc_w 323
    //   41: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -21 -> 23
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	TXCAudioUGCRecorder
    //   0	52	1	paramd	d
    // Exception table:
    //   from	to	target	type
    //   2	8	47	finally
    //   12	23	47	finally
    //   26	44	47	finally
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(66485);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setMute: ".concat(String.valueOf(paramBoolean)));
    this.mIsMute = paramBoolean;
    AppMethodBeat.o(66485);
  }
  
  public void setReverbType(int paramInt)
  {
    try
    {
      AppMethodBeat.i(66483);
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setReverbType: ".concat(String.valueOf(paramInt)));
      this.mReverbType = paramInt;
      if (this.mEffectorObj > 0L) {
        nativeSetReverbType(this.mEffectorObj, paramInt);
      }
      AppMethodBeat.o(66483);
      return;
    }
    finally {}
  }
  
  public void setSampleRate(int paramInt)
  {
    AppMethodBeat.i(66482);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setSampleRate: ".concat(String.valueOf(paramInt)));
    this.mSampleRate = paramInt;
    AppMethodBeat.o(66482);
  }
  
  /* Error */
  public void setSpeedRate(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 341
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 10
    //   10: ldc_w 343
    //   13: fload_1
    //   14: invokestatic 346	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   17: invokevirtual 169	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokestatic 152	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: fload_1
    //   25: putfield 93	com/tencent/liteav/audio/TXCAudioUGCRecorder:mSpeedRate	F
    //   28: aload_0
    //   29: getfield 81	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   32: lconst_0
    //   33: lcmp
    //   34: ifgt +12 -> 46
    //   37: ldc_w 341
    //   40: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 81	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   51: aload_0
    //   52: getfield 93	com/tencent/liteav/audio/TXCAudioUGCRecorder:mSpeedRate	F
    //   55: invokespecial 129	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeSetSpeedRate	(JF)V
    //   58: ldc_w 341
    //   61: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 348
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 10
    //   10: ldc_w 350
    //   13: fload_1
    //   14: invokestatic 346	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   17: invokevirtual 169	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokestatic 152	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: fload_1
    //   25: putfield 85	com/tencent/liteav/audio/TXCAudioUGCRecorder:mVolume	F
    //   28: aload_0
    //   29: getfield 81	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   32: lconst_0
    //   33: lcmp
    //   34: ifgt +12 -> 46
    //   37: ldc_w 348
    //   40: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 81	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEffectorObj	J
    //   51: fload_1
    //   52: invokespecial 126	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeSetVolume	(JF)V
    //   55: ldc_w 348
    //   58: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(66475);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "startRecord");
    boolean bool;
    if (isRecording())
    {
      if (this.mEnableBGMRecord == this.mCurBGMRecordFlag)
      {
        TXCLog.e("AudioCenter:TXCAudioUGCRecorder", "startRecord failed! recorder is still running!");
        AppMethodBeat.o(66475);
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
      AppMethodBeat.o(66475);
      return 0;
      bool = false;
      break;
      label188:
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "录制人声");
      this.mCurBGMRecordFlag = false;
      setEarphoneOn(false);
      f.a().a(this);
      f.a().a(this.mContext, this.mSampleRate, this.mChannels, this.mBits, this.mAECType);
    }
  }
  
  public int stopRecord()
  {
    AppMethodBeat.i(66476);
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
    AppMethodBeat.o(66476);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCAudioUGCRecorder
 * JD-Core Version:    0.7.0.1
 */