package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.basic.a.a;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

public abstract class c
{
  private static final String TAG = "AudioCenter:" + c.class.getSimpleName();
  protected int mAECType = TXEAudioDef.TXE_AEC_NONE;
  protected int mBits = a.h;
  protected int mChannels = a.f;
  protected Context mContext;
  protected boolean mEnableHWEncoder = false;
  protected boolean mIsCustomRecord = false;
  protected boolean mIsEarphoneOn = false;
  protected boolean mIsMute = false;
  protected int mNSMode = -1;
  protected int mReverbType = TXEAudioDef.TXE_REVERB_TYPE_0;
  protected int mSampleRate = a.e;
  protected int mVoiceEnvironment = -1;
  protected int mVoiceKind = -1;
  protected float mVolume = 1.0F;
  protected WeakReference<e> mWeakRecordListener;
  
  public void enableHWEncoder(boolean paramBoolean)
  {
    TXCLog.i(TAG, "enableHWEncoder: " + paramBoolean);
    this.mEnableHWEncoder = paramBoolean;
  }
  
  /* Error */
  public e getListener()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 117	com/tencent/liteav/audio/impl/Record/c:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   6: ifnull +18 -> 24
    //   9: aload_0
    //   10: getfield 117	com/tencent/liteav/audio/impl/Record/c:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   13: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   16: checkcast 125	com/tencent/liteav/audio/e
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
    //   0	34	0	this	c
    //   19	7	1	locale	e
    //   29	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	29	finally
  }
  
  public abstract boolean isRecording();
  
  public abstract void sendCustomPCMData(byte[] paramArrayOfByte);
  
  public void setAECType(int paramInt)
  {
    TXCLog.i(TAG, "setAECType: " + paramInt);
    this.mAECType = paramInt;
  }
  
  public void setChangerType(int paramInt1, int paramInt2)
  {
    TXCLog.i(TAG, "setChangerType: " + paramInt1 + " " + paramInt2);
    this.mVoiceKind = paramInt1;
    this.mVoiceEnvironment = paramInt2;
  }
  
  public void setChannels(int paramInt)
  {
    TXCLog.i(TAG, "setChannels: " + paramInt);
    this.mChannels = paramInt;
  }
  
  public void setEarphoneOn(boolean paramBoolean)
  {
    TXCLog.i(TAG, "setEarphoneOn: " + paramBoolean);
    this.mIsEarphoneOn = paramBoolean;
  }
  
  public void setIsCustomRecord(boolean paramBoolean)
  {
    TXCLog.i(TAG, "setIsCustomRecord: " + paramBoolean);
    this.mIsCustomRecord = paramBoolean;
  }
  
  /* Error */
  public void setListener(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 52	com/tencent/liteav/audio/impl/Record/c:TAG	Ljava/lang/String;
    //   5: new 31	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 155
    //   11: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 113	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_1
    //   25: ifnonnull +11 -> 36
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 117	com/tencent/liteav/audio/impl/Record/c:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: new 119	java/lang/ref/WeakReference
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 161	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   45: putfield 117	com/tencent/liteav/audio/impl/Record/c:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   48: goto -15 -> 33
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	c
    //   0	56	1	parame	e
    // Exception table:
    //   from	to	target	type
    //   2	24	51	finally
    //   28	33	51	finally
    //   36	48	51	finally
  }
  
  public void setMute(boolean paramBoolean)
  {
    TXCLog.i(TAG, "setMute: " + paramBoolean);
    this.mIsMute = paramBoolean;
  }
  
  public void setNoiseSuppression(int paramInt)
  {
    TXCLog.i(TAG, "setNoiseSuppression: " + paramInt);
    this.mNSMode = paramInt;
  }
  
  public void setReverbParam(int paramInt, float paramFloat) {}
  
  public void setReverbType(int paramInt)
  {
    TXCLog.i(TAG, "setReverbType: " + paramInt);
    this.mReverbType = paramInt;
  }
  
  public void setSamplerate(int paramInt)
  {
    TXCLog.i(TAG, "setSampleRate: " + paramInt);
    this.mSampleRate = paramInt;
  }
  
  public void setVolume(float paramFloat)
  {
    if (paramFloat <= 0.2F) {
      TXCLog.w(TAG, "setVolume, warning volume too low : " + paramFloat);
    }
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    this.mVolume = f;
  }
  
  public int startRecord(Context paramContext)
  {
    if (paramContext != null) {
      this.mContext = paramContext.getApplicationContext();
    }
    return 0;
  }
  
  public abstract int stopRecord();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.c
 * JD-Core Version:    0.7.0.1
 */