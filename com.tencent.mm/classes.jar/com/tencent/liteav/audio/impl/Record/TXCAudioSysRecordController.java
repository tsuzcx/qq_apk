package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class TXCAudioSysRecordController
  extends c
  implements h, com.tencent.liteav.audio.impl.d
{
  private static final String TAG = "AudioCenter:" + TXCAudioSysRecordController.class.getSimpleName();
  private byte[] mBuf = null;
  private d mCustomRecord = null;
  private long mEffectorObj = 0L;
  private e mHWEcoder = null;
  private com.tencent.liteav.audio.impl.b mHeadsetMgr = null;
  private long mLastPTS = 0L;
  private boolean mNeedMix = false;
  private int mPosition = 0;
  private int mRecordSampleRate = com.tencent.liteav.basic.a.a.e;
  private long mSoftEncObj = 0L;
  
  static {}
  
  private void doHWEncode(byte[] paramArrayOfByte, long paramLong)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (this.mBuf == null) || (this.mHWEcoder == null)) {
      TXCLog.e(TAG, "doHWEncode failed! data = " + paramArrayOfByte + ", buf = " + this.mBuf + ", encoder = " + this.mHWEcoder);
    }
    do
    {
      return;
      int j = this.mBuf.length - this.mPosition;
      int i = j;
      if (j > paramArrayOfByte.length) {
        i = paramArrayOfByte.length;
      }
      System.arraycopy(paramArrayOfByte, 0, this.mBuf, this.mPosition, i);
      this.mPosition = (i + this.mPosition);
    } while (this.mPosition != this.mBuf.length);
    this.mPosition = 0;
    this.mHWEcoder.a(this.mBuf, paramLong);
  }
  
  private void initEffectAndEnc()
  {
    this.mEffectorObj = nativeCreateEffector(this.mSampleRate, this.mChannels, this.mBits);
    if (this.mSampleRate != this.mRecordSampleRate) {
      nativeSetInputInfo(this.mEffectorObj, this.mRecordSampleRate, this.mChannels, this.mBits);
    }
    if ((this.mIsEarphoneOn) || (this.mAECType == TXEAudioDef.TXE_AEC_SYSTEM)) {}
    for (boolean bool = true;; bool = false)
    {
      nativeSetReverbType(this.mEffectorObj, this.mReverbType);
      nativeMixBGM(this.mEffectorObj, bool);
      nativeSetNoiseSuppression(this.mEffectorObj, this.mNSMode);
      nativeSetChangerType(this.mEffectorObj, this.mVoiceKind, this.mVoiceEnvironment);
      Object localObject2;
      label226:
      StringBuilder localStringBuilder;
      if (this.mEnableHWEncoder)
      {
        this.mHWEcoder = new e();
        localObject1 = getListener();
        localObject2 = this.mHWEcoder;
        int i = TXEAudioDef.TXE_AUDIO_TYPE_AAC;
        int j = this.mSampleRate;
        int k = this.mChannels;
        int m = this.mBits;
        if (localObject1 != null)
        {
          localObject1 = new WeakReference(localObject1);
          ((e)localObject2).a(i, j, k, m, (WeakReference)localObject1);
          this.mBuf = new byte[this.mChannels * 1024 * this.mBits / 8];
          this.mPosition = 0;
          this.mLastPTS = 0L;
          localObject2 = TAG;
          localStringBuilder = new StringBuilder("初始化直播录制:录制模式 = ");
          if (this.mCustomRecord != null) {
            break label396;
          }
        }
      }
      label396:
      for (Object localObject1 = "麦克风录制";; localObject1 = "用户自定义录制")
      {
        TXCLog.i((String)localObject2, (String)localObject1 + ", 录制采样率 = " + this.mRecordSampleRate + ", 输出采样率 = " + this.mSampleRate + ", 是否混音 = " + bool + ", 混响模式 = " + this.mReverbType + ", 是否启动硬编码 = " + this.mEnableHWEncoder + ", 噪声抑制mode = " + this.mNSMode);
        this.mHeadsetMgr = new com.tencent.liteav.audio.impl.b(this.mContext);
        this.mHeadsetMgr.a(this);
        return;
        localObject1 = null;
        break;
        this.mSoftEncObj = nativeCreateSoftEncoder(this.mSampleRate, this.mChannels, this.mBits);
        break label226;
      }
    }
  }
  
  private native void nativeAddEffect(long paramLong, byte[] paramArrayOfByte);
  
  private native void nativeAddEffectAndSoftEnc(long paramLong1, long paramLong2, byte[] paramArrayOfByte);
  
  private native long nativeCreateEffector(int paramInt1, int paramInt2, int paramInt3);
  
  private native long nativeCreateSoftEncoder(int paramInt1, int paramInt2, int paramInt3);
  
  private native void nativeDestorySoftEncoder(long paramLong);
  
  private native void nativeDestroyEffector(long paramLong);
  
  private native void nativeEnableEncoder(long paramLong, boolean paramBoolean);
  
  private native void nativeMixBGM(long paramLong, boolean paramBoolean);
  
  private native byte[] nativeReadOneEncFrame();
  
  private native byte[] nativeReadOneFrame(long paramLong, int paramInt);
  
  private native void nativeSetChangerType(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSetInputInfo(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private native void nativeSetNoiseSuppression(long paramLong, int paramInt);
  
  private native void nativeSetReverbParam(long paramLong, int paramInt, float paramFloat);
  
  private native void nativeSetReverbType(long paramLong, int paramInt);
  
  private native void nativeSetVolume(long paramLong, float paramFloat);
  
  private void onRecordPcmData(byte[] paramArrayOfByte)
  {
    com.tencent.liteav.audio.e locale = getListener();
    if (locale != null) {
      locale.a(paramArrayOfByte, TXCTimeUtil.getTimeTick(), this.mSampleRate, this.mChannels, this.mBits);
    }
  }
  
  private void onRecordRawPcmData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    com.tencent.liteav.audio.e locale = getListener();
    long l;
    int i;
    if (locale != null)
    {
      l = TXCTimeUtil.getTimeTick();
      i = this.mBits;
      if ((!TXCLiveBGMPlayer.getInstance().isRunning()) || (this.mNeedMix)) {
        break label58;
      }
    }
    label58:
    for (boolean bool = true;; bool = false)
    {
      locale.a(paramArrayOfByte, l, paramInt1, paramInt2, i, bool);
      return;
    }
  }
  
  private void uninitEffectAndEnc()
  {
    if (this.mEffectorObj != 0L)
    {
      nativeDestroyEffector(this.mEffectorObj);
      this.mEffectorObj = 0L;
    }
    if (this.mSoftEncObj != 0L)
    {
      nativeDestorySoftEncoder(this.mSoftEncObj);
      this.mSoftEncObj = 0L;
    }
    if (this.mHWEcoder != null)
    {
      this.mHWEcoder.a();
      this.mHWEcoder = null;
    }
  }
  
  public void OnHeadsetState(boolean paramBoolean)
  {
    setEarphoneOn(paramBoolean);
  }
  
  public boolean isRecording()
  {
    if (this.mCustomRecord != null) {
      return this.mCustomRecord.d();
    }
    return f.a().c();
  }
  
  public void onAudioRecordError(int paramInt, String paramString)
  {
    try
    {
      TXCLog.e(TAG, "sys audio record error: " + paramInt + ", " + paramString);
      f.a().a(null);
      uninitEffectAndEnc();
      if (this.mWeakRecordListener != null)
      {
        com.tencent.liteav.audio.e locale = (com.tencent.liteav.audio.e)this.mWeakRecordListener.get();
        if (locale != null) {
          locale.a(paramInt, paramString);
        }
      }
      return;
    }
    finally {}
  }
  
  public void onAudioRecordPCM(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    label239:
    label251:
    for (;;)
    {
      com.tencent.liteav.audio.e locale;
      try
      {
        if (this.mEffectorObj <= 0L) {
          break label239;
        }
        if (this.mIsMute) {
          Arrays.fill(paramArrayOfByte, (byte)0);
        }
        if (this.mLastPTS < paramLong) {
          break label251;
        }
        paramLong = this.mLastPTS + 2L;
        if (this.mHWEcoder != null)
        {
          nativeAddEffect(this.mEffectorObj, paramArrayOfByte);
          paramArrayOfByte = nativeReadOneFrame(this.mEffectorObj, this.mChannels * 1024 * this.mBits / 8);
          if (paramArrayOfByte != null)
          {
            this.mLastPTS = paramLong;
            if (this.mHWEcoder != null) {
              doHWEncode(paramArrayOfByte, paramLong);
            }
          }
          else
          {
            paramInt = 1024000 / this.mSampleRate;
            paramLong += paramInt;
            if (paramArrayOfByte != null) {
              continue;
            }
            return;
          }
          locale = getListener();
          if (locale == null) {
            continue;
          }
          locale.b(paramArrayOfByte, paramLong, this.mSampleRate, this.mChannels, this.mBits);
          continue;
        }
        nativeAddEffectAndSoftEnc(this.mEffectorObj, this.mSoftEncObj, paramArrayOfByte);
      }
      finally {}
      for (;;)
      {
        paramArrayOfByte = nativeReadOneEncFrame();
        if (paramArrayOfByte == null) {
          break;
        }
        this.mLastPTS = paramLong;
        locale = getListener();
        if (locale != null) {
          locale.b(paramArrayOfByte, paramLong, this.mSampleRate, this.mChannels, this.mBits);
        }
        paramLong += 1024000 / this.mSampleRate;
      }
      TXCLog.e(TAG, "effectorObj is null");
    }
  }
  
  public void onAudioRecordStart()
  {
    try
    {
      TXCLog.i(TAG, "sys audio record start");
      uninitEffectAndEnc();
      initEffectAndEnc();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onAudioRecordStop()
  {
    try
    {
      TXCLog.i(TAG, "sys audio record stop");
      f.a().a(null);
      uninitEffectAndEnc();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfByte)
  {
    if (this.mCustomRecord != null) {
      this.mCustomRecord.a(paramArrayOfByte);
    }
  }
  
  public void setChangerType(int paramInt1, int paramInt2)
  {
    super.setChangerType(paramInt1, paramInt2);
    if (this.mEffectorObj != 0L) {
      nativeSetChangerType(this.mEffectorObj, paramInt1, paramInt2);
    }
  }
  
  /* Error */
  public void setEarphoneOn(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial 364	com/tencent/liteav/audio/impl/Record/c:setEarphoneOn	(Z)V
    //   7: aload_0
    //   8: getfield 62	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecordController:mEffectorObj	J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifle +34 -> 47
    //   16: iload_1
    //   17: ifne +13 -> 30
    //   20: aload_0
    //   21: getfield 136	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecordController:mAECType	I
    //   24: getstatic 141	com/tencent/liteav/audio/TXEAudioDef:TXE_AEC_SYSTEM	I
    //   27: if_icmpne +23 -> 50
    //   30: aload_0
    //   31: iconst_1
    //   32: putfield 81	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecordController:mNeedMix	Z
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 62	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecordController:mEffectorObj	J
    //   40: aload_0
    //   41: getfield 81	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecordController:mNeedMix	Z
    //   44: invokespecial 152	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecordController:nativeMixBGM	(JZ)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 81	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecordController:mNeedMix	Z
    //   55: goto -20 -> 35
    //   58: astore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_2
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	TXCAudioSysRecordController
    //   0	63	1	paramBoolean	boolean
    //   58	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	58	finally
    //   20	30	58	finally
    //   30	35	58	finally
    //   35	47	58	finally
    //   50	55	58	finally
  }
  
  public void setNoiseSuppression(int paramInt)
  {
    try
    {
      super.setNoiseSuppression(paramInt);
      if (this.mEffectorObj > 0L) {
        nativeSetNoiseSuppression(this.mEffectorObj, paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setReverbParam(int paramInt, float paramFloat)
  {
    try
    {
      super.setReverbParam(paramInt, paramFloat);
      if (this.mEffectorObj != 0L) {
        nativeSetReverbParam(this.mEffectorObj, paramInt, paramFloat);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setReverbType(int paramInt)
  {
    try
    {
      super.setReverbType(paramInt);
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
  
  public void setVolume(float paramFloat)
  {
    super.setVolume(paramFloat);
    if (this.mEffectorObj != 0L) {
      nativeSetVolume(this.mEffectorObj, paramFloat);
    }
  }
  
  public int startRecord(Context paramContext)
  {
    TXCLog.i(TAG, "startRecord");
    super.startRecord(paramContext);
    if (!this.mIsCustomRecord) {
      if (this.mAECType == TXEAudioDef.TXE_AEC_SYSTEM) {
        if (this.mSampleRate > com.tencent.liteav.basic.e.b.a().h())
        {
          this.mRecordSampleRate = com.tencent.liteav.basic.e.b.a().i();
          if (this.mRecordSampleRate == 0) {
            this.mRecordSampleRate = 16000;
          }
          label69:
          f.a().a(this);
          f.a().a(this.mContext, this.mRecordSampleRate, this.mChannels, this.mBits, this.mAECType);
          label102:
          if ((this.mWeakRecordListener != null) && (this.mWeakRecordListener.get() != null)) {
            if (this.mAECType != TXEAudioDef.TXE_AEC_SYSTEM) {
              break label290;
            }
          }
        }
      }
    }
    label290:
    for (paramContext = "SYSTEM-AEC,";; paramContext = "NO-AEC,")
    {
      paramContext = paramContext + "采样率(" + this.mRecordSampleRate + "|" + this.mSampleRate + "),声道数" + this.mChannels;
      ((com.tencent.liteav.audio.e)this.mWeakRecordListener.get()).a(TXEAudioDef.TXE_AUDIO_NOTIFY_AUDIO_INFO, paramContext);
      return 0;
      this.mRecordSampleRate = com.tencent.liteav.basic.e.b.a().h();
      break;
      this.mRecordSampleRate = this.mSampleRate;
      break label69;
      setNoiseSuppression(-1);
      this.mRecordSampleRate = this.mSampleRate;
      this.mCustomRecord = new d();
      this.mCustomRecord.a(this);
      this.mCustomRecord.a(this.mContext, this.mRecordSampleRate, this.mChannels, this.mBits);
      break label102;
    }
  }
  
  public int stopRecord()
  {
    TXCLog.i(TAG, "stopRecord");
    if (this.mCustomRecord != null)
    {
      this.mCustomRecord.c();
      this.mCustomRecord = null;
    }
    f.a().b();
    if (this.mHeadsetMgr != null)
    {
      this.mHeadsetMgr.a();
      this.mHeadsetMgr = null;
    }
    this.mNeedMix = false;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.TXCAudioSysRecordController
 * JD-Core Version:    0.7.0.1
 */