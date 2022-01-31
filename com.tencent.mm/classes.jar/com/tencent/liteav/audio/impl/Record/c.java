package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.a;
import java.lang.ref.WeakReference;

public abstract class c
{
  private static final String TAG = "AudioCenter:" + c.class.getSimpleName();
  protected int mAECType = 0;
  protected int mAudioFormat = 10;
  protected int mBits = 16;
  protected int mChannels = 1;
  protected Context mContext;
  protected boolean mEnableHWEncoder = false;
  protected boolean mEnableVolumeLevel = false;
  protected float mFecRatio = 0.0F;
  protected int mFrameLenMs = 21;
  protected String mID;
  protected boolean mIsCustomRecord = false;
  protected boolean mIsEarphoneOn = false;
  protected boolean mIsMute = false;
  protected int mNSMode = -1;
  protected int mReverbType = 0;
  protected int mSampleRate = 48000;
  protected int mSamplesNumPerFrame = 1024;
  protected int mVoiceEnvironment = -1;
  protected int mVoiceKind = -1;
  protected float mVolume = 1.0F;
  protected WeakReference<d> mWeakRecordListener;
  
  public void SetID(String paramString)
  {
    this.mID = paramString;
  }
  
  public void enableHWEncoder(boolean paramBoolean)
  {
    TXCLog.i(TAG, "enableHWEncoder: ".concat(String.valueOf(paramBoolean)));
    this.mEnableHWEncoder = paramBoolean;
  }
  
  /* Error */
  public d getListener()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 125	com/tencent/liteav/audio/impl/Record/c:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   6: ifnull +18 -> 24
    //   9: aload_0
    //   10: getfield 125	com/tencent/liteav/audio/impl/Record/c:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   13: invokevirtual 131	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   16: checkcast 133	com/tencent/liteav/audio/d
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
    //   19	7	1	locald	d
    //   29	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	29	finally
  }
  
  public int getVolumeLevel()
  {
    return 0;
  }
  
  public abstract boolean isRecording();
  
  public abstract void sendCustomPCMData(a parama);
  
  public abstract void sendCustomPCMData(byte[] paramArrayOfByte);
  
  public void setAECType(int paramInt)
  {
    TXCLog.i(TAG, "setAECType: ".concat(String.valueOf(paramInt)));
    this.mAECType = paramInt;
  }
  
  public void setAudioFormat(int paramInt)
  {
    TXCLog.i(TAG, "setAudioFormat : ".concat(String.valueOf(paramInt)));
    if (isRecording()) {}
    do
    {
      return;
      this.mAudioFormat = paramInt;
      if (10 == this.mAudioFormat)
      {
        this.mSamplesNumPerFrame = 1024;
        return;
      }
    } while (11 != this.mAudioFormat);
    this.mSamplesNumPerFrame = 960;
  }
  
  public void setChangerType(int paramInt1, int paramInt2)
  {
    TXCLog.i(TAG, "setChangerType: " + paramInt1 + " " + paramInt2);
    this.mVoiceKind = paramInt1;
    this.mVoiceEnvironment = paramInt2;
  }
  
  public void setChannels(int paramInt)
  {
    TXCLog.i(TAG, "setChannels: ".concat(String.valueOf(paramInt)));
    this.mChannels = paramInt;
  }
  
  public void setEarphoneOn(boolean paramBoolean)
  {
    TXCLog.i(TAG, "setEarphoneOn: ".concat(String.valueOf(paramBoolean)));
    this.mIsEarphoneOn = paramBoolean;
  }
  
  public void setEnableVolumeLevel(boolean paramBoolean)
  {
    this.mEnableVolumeLevel = paramBoolean;
  }
  
  public void setEncBitRate(int paramInt) {}
  
  public void setEncFrameLenMs(int paramInt)
  {
    TXCLog.i(TAG, "setEncFrameLenMs: ".concat(String.valueOf(paramInt)));
    this.mFrameLenMs = paramInt;
  }
  
  public void setEncInfo(int paramInt1, int paramInt2)
  {
    this.mFrameLenMs = paramInt1;
  }
  
  public void setFecRatio(float paramFloat)
  {
    this.mFecRatio = paramFloat;
  }
  
  public void setIsCustomRecord(boolean paramBoolean)
  {
    TXCLog.i(TAG, "setIsCustomRecord: ".concat(String.valueOf(paramBoolean)));
    this.mIsCustomRecord = paramBoolean;
  }
  
  /* Error */
  public void setListener(d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 58	com/tencent/liteav/audio/impl/Record/c:TAG	Ljava/lang/String;
    //   5: ldc 182
    //   7: aload_1
    //   8: invokestatic 185	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   11: invokevirtual 115	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   14: invokestatic 121	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnonnull +11 -> 29
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 125	com/tencent/liteav/audio/impl/Record/c:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: new 127	java/lang/ref/WeakReference
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 188	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   38: putfield 125	com/tencent/liteav/audio/impl/Record/c:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   41: goto -15 -> 26
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	c
    //   0	49	1	paramd	d
    // Exception table:
    //   from	to	target	type
    //   2	17	44	finally
    //   21	26	44	finally
    //   29	41	44	finally
  }
  
  public void setMute(boolean paramBoolean)
  {
    TXCLog.i(TAG, "setMute: ".concat(String.valueOf(paramBoolean)));
    this.mIsMute = paramBoolean;
  }
  
  public void setNoiseSuppression(int paramInt)
  {
    TXCLog.i(TAG, "setNoiseSuppression: ".concat(String.valueOf(paramInt)));
    this.mNSMode = paramInt;
  }
  
  public void setReverbParam(int paramInt, float paramFloat) {}
  
  public void setReverbType(int paramInt)
  {
    TXCLog.i(TAG, "setReverbType: ".concat(String.valueOf(paramInt)));
    this.mReverbType = paramInt;
  }
  
  public void setSamplerate(int paramInt)
  {
    TXCLog.i(TAG, "setSampleRate: ".concat(String.valueOf(paramInt)));
    this.mSampleRate = paramInt;
  }
  
  public void setVolume(float paramFloat)
  {
    if (paramFloat <= 0.2F) {
      TXCLog.w(TAG, "setVolume, warning volume too low : ".concat(String.valueOf(paramFloat)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.c
 * JD-Core Version:    0.7.0.1
 */