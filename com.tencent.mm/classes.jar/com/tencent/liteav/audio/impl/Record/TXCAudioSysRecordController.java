package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import android.os.Build;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TXCAudioSysRecordController
  extends c
  implements h, com.tencent.liteav.audio.impl.d
{
  private static final String TAG;
  private byte[] mBuf;
  private d mCustomRecord;
  private long mEffectorObj;
  private e mHWEcoder;
  private long mLastPTS;
  private boolean mNeedMix;
  private int mPosition;
  private int mRecordSampleRate;
  private long mSoftEncObj;
  private long mTimestampInSamples;
  
  static
  {
    AppMethodBeat.i(66704);
    com.tencent.liteav.basic.util.b.f();
    TAG = "AudioCenter:" + TXCAudioSysRecordController.class.getSimpleName();
    AppMethodBeat.o(66704);
  }
  
  public TXCAudioSysRecordController()
  {
    AppMethodBeat.i(66682);
    this.mEffectorObj = 0L;
    this.mSoftEncObj = 0L;
    this.mRecordSampleRate = 48000;
    this.mHWEcoder = null;
    this.mBuf = null;
    this.mPosition = 0;
    this.mLastPTS = 0L;
    this.mNeedMix = false;
    this.mCustomRecord = null;
    this.mTimestampInSamples = 0L;
    com.tencent.liteav.audio.impl.a.a().a(this);
    AppMethodBeat.o(66682);
  }
  
  private void doHWEncode(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66700);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (this.mBuf == null) || (this.mHWEcoder == null))
    {
      TXCLog.e(TAG, "doHWEncode failed! data = " + paramArrayOfByte + ", buf = " + this.mBuf + ", encoder = " + this.mHWEcoder);
      AppMethodBeat.o(66700);
      return;
    }
    int j = this.mBuf.length - this.mPosition;
    int i = j;
    if (j > paramArrayOfByte.length) {
      i = paramArrayOfByte.length;
    }
    System.arraycopy(paramArrayOfByte, 0, this.mBuf, this.mPosition, i);
    this.mPosition = (i + this.mPosition);
    if (this.mPosition == this.mBuf.length)
    {
      this.mPosition = 0;
      this.mHWEcoder.a(this.mBuf, paramLong);
    }
    AppMethodBeat.o(66700);
  }
  
  private long getFixedTimestamp(long paramLong)
  {
    if (11 == this.mAudioFormat)
    {
      this.mTimestampInSamples += this.mFrameLenMs * this.mSampleRate / 1000;
      paramLong = this.mTimestampInSamples;
    }
    return paramLong;
  }
  
  private String getProperty(String paramString)
  {
    AppMethodBeat.i(66684);
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString, "unknown" });
      AppMethodBeat.o(66684);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = "unknown";
      }
    }
  }
  
  private void initEffectAndEnc()
  {
    AppMethodBeat.i(66698);
    this.mEffectorObj = nativeCreateEffector(this.mSampleRate, this.mChannels, this.mBits);
    if (this.mSampleRate != this.mRecordSampleRate) {
      nativeSetInputInfo(this.mEffectorObj, this.mRecordSampleRate, this.mChannels, this.mBits);
    }
    if ((this.mIsEarphoneOn) || (this.mAECType == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      nativeEnableVolumeLevel(this.mEffectorObj, this.mEnableVolumeLevel);
      nativeSetReverbType(this.mEffectorObj, this.mReverbType);
      nativeMixBGM(this.mEffectorObj, bool);
      nativeSetChangerType(this.mEffectorObj, this.mVoiceKind, this.mVoiceEnvironment);
      Object localObject2;
      label231:
      StringBuilder localStringBuilder;
      if (this.mEnableHWEncoder)
      {
        this.mHWEcoder = new e();
        localObject1 = getListener();
        localObject2 = this.mHWEcoder;
        int i = this.mAudioFormat;
        int j = this.mSampleRate;
        int k = this.mChannels;
        int m = this.mBits;
        if (localObject1 != null)
        {
          localObject1 = new WeakReference(localObject1);
          ((e)localObject2).a(i, j, k, m, (WeakReference)localObject1);
          this.mBuf = new byte[this.mSamplesNumPerFrame * this.mChannels * this.mBits / 8];
          this.mPosition = 0;
          this.mLastPTS = 0L;
          localObject2 = TAG;
          localStringBuilder = new StringBuilder("初始化直播录制:录制模式 = ");
          if (this.mCustomRecord != null) {
            break label426;
          }
        }
      }
      label426:
      for (Object localObject1 = "麦克风录制";; localObject1 = "用户自定义录制")
      {
        TXCLog.i((String)localObject2, (String)localObject1 + ", 录制采样率 = " + this.mRecordSampleRate + ", 输出采样率 = " + this.mSampleRate + ", 是否混音 = " + bool + ", 混响模式 = " + this.mReverbType + ", 是否启动硬编码 = " + this.mEnableHWEncoder + ", 噪声抑制mode = " + this.mNSMode);
        AppMethodBeat.o(66698);
        return;
        localObject1 = null;
        break;
        this.mSoftEncObj = nativeCreateSoftEncoder(this.mSampleRate, this.mChannels, this.mBits, this.mAudioFormat, this.mFrameLenMs);
        nativeSetID(this.mSoftEncObj, this.mID);
        if (this.mAudioFormat != 11) {
          break label231;
        }
        nativeSetFecRatio(this.mSoftEncObj, this.mFecRatio);
        break label231;
      }
    }
  }
  
  private native void nativeAddEffect(long paramLong, byte[] paramArrayOfByte);
  
  private native void nativeAddEffectAndSoftEnc(long paramLong1, long paramLong2, byte[] paramArrayOfByte, long paramLong3);
  
  private native long nativeCreateEffector(int paramInt1, int paramInt2, int paramInt3);
  
  private native long nativeCreateSoftEncoder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private native void nativeDestorySoftEncoder(long paramLong);
  
  private native void nativeDestroyEffector(long paramLong);
  
  private native void nativeEnableEncoder(long paramLong, boolean paramBoolean);
  
  private native void nativeEnableVolumeLevel(long paramLong, boolean paramBoolean);
  
  private native int nativeGetVolumeLevel(long paramLong);
  
  private native void nativeMixBGM(long paramLong, boolean paramBoolean);
  
  private native byte[] nativeReadOneFrame(long paramLong, int paramInt);
  
  private native void nativeSetChangerType(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSetEncBitRate(long paramLong, int paramInt);
  
  private native void nativeSetEncFrameLenMs(long paramLong, int paramInt);
  
  private native void nativeSetEncInfo(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSetFecRatio(long paramLong, float paramFloat);
  
  private native void nativeSetID(long paramLong, String paramString);
  
  private native void nativeSetInputInfo(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private native void nativeSetReverbParam(long paramLong, int paramInt, float paramFloat);
  
  private native void nativeSetReverbType(long paramLong, int paramInt);
  
  private native void nativeSetVolume(long paramLong, float paramFloat);
  
  private void onRecordPcmData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66702);
    com.tencent.liteav.audio.d locald = getListener();
    if (locald != null) {
      locald.a(paramArrayOfByte, TXCTimeUtil.getTimeTick(), this.mSampleRate, this.mChannels, this.mBits);
    }
    AppMethodBeat.o(66702);
  }
  
  private void onRecordRawPcmData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66701);
    com.tencent.liteav.audio.d locald = getListener();
    long l;
    int i;
    if (locald != null)
    {
      l = TXCTimeUtil.getTimeTick();
      i = this.mBits;
      if ((!TXCLiveBGMPlayer.getInstance().isRunning()) || (this.mNeedMix)) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      locald.a(paramArrayOfByte, l, paramInt1, paramInt2, i, bool);
      AppMethodBeat.o(66701);
      return;
    }
  }
  
  private void uninitEffectAndEnc()
  {
    AppMethodBeat.i(66699);
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
    AppMethodBeat.o(66699);
  }
  
  public void OnHeadsetState(boolean paramBoolean)
  {
    AppMethodBeat.i(66703);
    setEarphoneOn(paramBoolean);
    AppMethodBeat.o(66703);
  }
  
  public void SetID(String paramString)
  {
    AppMethodBeat.i(146243);
    super.SetID(paramString);
    nativeSetID(this.mSoftEncObj, this.mID);
    AppMethodBeat.o(146243);
  }
  
  public int getVolumeLevel()
  {
    AppMethodBeat.i(146250);
    if ((this.mEffectorObj != 0L) && (this.mEnableVolumeLevel))
    {
      int i = nativeGetVolumeLevel(this.mEffectorObj);
      AppMethodBeat.o(146250);
      return i;
    }
    AppMethodBeat.o(146250);
    return 0;
  }
  
  public boolean isRecording()
  {
    AppMethodBeat.i(66687);
    if (this.mCustomRecord != null)
    {
      bool = this.mCustomRecord.d();
      AppMethodBeat.o(66687);
      return bool;
    }
    boolean bool = f.a().c();
    AppMethodBeat.o(66687);
    return bool;
  }
  
  public void onAudioRecordError(int paramInt, String paramString)
  {
    try
    {
      AppMethodBeat.i(66696);
      TXCLog.e(TAG, "sys audio record error: " + paramInt + ", " + paramString);
      f.a().a(null);
      uninitEffectAndEnc();
      if (this.mWeakRecordListener != null)
      {
        com.tencent.liteav.audio.d locald = (com.tencent.liteav.audio.d)this.mWeakRecordListener.get();
        if (locald != null) {
          locald.a(paramInt, paramString);
        }
      }
      AppMethodBeat.o(66696);
      return;
    }
    finally {}
  }
  
  public void onAudioRecordPCM(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    label207:
    label225:
    label233:
    for (;;)
    {
      long l;
      try
      {
        AppMethodBeat.i(66697);
        if (this.mEffectorObj <= 0L) {
          break label207;
        }
        if (this.mIsMute) {
          Arrays.fill(paramArrayOfByte, (byte)0);
        }
        if (this.mHWEcoder != null)
        {
          if (this.mLastPTS < paramLong) {
            break label233;
          }
          paramLong = this.mLastPTS + 2L;
          nativeAddEffect(this.mEffectorObj, paramArrayOfByte);
          paramArrayOfByte = nativeReadOneFrame(this.mEffectorObj, this.mSamplesNumPerFrame * this.mChannels * this.mBits / 8);
          if (paramArrayOfByte != null)
          {
            this.mLastPTS = paramLong;
            if (this.mHWEcoder != null) {
              doHWEncode(paramArrayOfByte, paramLong);
            }
          }
          else
          {
            l = this.mSamplesNumPerFrame * 1000 / this.mSampleRate;
            if (paramArrayOfByte != null) {
              break label225;
            }
            AppMethodBeat.o(66697);
            return;
          }
          com.tencent.liteav.audio.d locald = getListener();
          if (locald == null) {
            continue;
          }
          locald.b(paramArrayOfByte, getFixedTimestamp(paramLong), this.mSampleRate, this.mChannels, this.mBits);
          continue;
        }
        nativeAddEffectAndSoftEnc(this.mEffectorObj, this.mSoftEncObj, paramArrayOfByte, paramLong);
      }
      finally {}
      AppMethodBeat.o(66697);
      continue;
      TXCLog.e(TAG, "effectorObj is null");
      AppMethodBeat.o(66697);
      continue;
      paramLong = l + paramLong;
    }
  }
  
  public void onAudioRecordStart()
  {
    try
    {
      AppMethodBeat.i(66694);
      TXCLog.i(TAG, "sys audio record start");
      uninitEffectAndEnc();
      initEffectAndEnc();
      AppMethodBeat.o(66694);
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
      AppMethodBeat.i(66695);
      TXCLog.i(TAG, "sys audio record stop");
      f.a().a(null);
      uninitEffectAndEnc();
      this.mFecRatio = 0.0F;
      AppMethodBeat.o(66695);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void sendCustomPCMData(com.tencent.liteav.basic.structs.a parama)
  {
    AppMethodBeat.i(146244);
    if (this.mCustomRecord != null) {
      this.mCustomRecord.a(parama);
    }
    AppMethodBeat.o(146244);
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66686);
    if (this.mCustomRecord != null) {
      this.mCustomRecord.a(paramArrayOfByte);
    }
    AppMethodBeat.o(66686);
  }
  
  public void setChangerType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66693);
    super.setChangerType(paramInt1, paramInt2);
    if (this.mEffectorObj != 0L) {
      nativeSetChangerType(this.mEffectorObj, paramInt1, paramInt2);
    }
    AppMethodBeat.o(66693);
  }
  
  /* Error */
  public void setEarphoneOn(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 444
    //   5: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: iload_1
    //   10: invokespecial 445	com/tencent/liteav/audio/impl/Record/c:setEarphoneOn	(Z)V
    //   13: aload_0
    //   14: getfield 73	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecordController:mEffectorObj	J
    //   17: lconst_0
    //   18: lcmp
    //   19: ifle +32 -> 51
    //   22: iload_1
    //   23: ifne +11 -> 34
    //   26: aload_0
    //   27: getfield 191	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecordController:mAECType	I
    //   30: iconst_1
    //   31: if_icmpne +29 -> 60
    //   34: aload_0
    //   35: iconst_1
    //   36: putfield 88	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecordController:mNeedMix	Z
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 73	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecordController:mEffectorObj	J
    //   44: aload_0
    //   45: getfield 88	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecordController:mNeedMix	Z
    //   48: invokespecial 208	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecordController:nativeMixBGM	(JZ)V
    //   51: ldc_w 444
    //   54: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 88	com/tencent/liteav/audio/impl/Record/TXCAudioSysRecordController:mNeedMix	Z
    //   65: goto -26 -> 39
    //   68: astore_2
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	TXCAudioSysRecordController
    //   0	73	1	paramBoolean	boolean
    //   68	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	68	finally
    //   26	34	68	finally
    //   34	39	68	finally
    //   39	51	68	finally
    //   51	57	68	finally
    //   60	65	68	finally
  }
  
  public void setEnableVolumeLevel(boolean paramBoolean)
  {
    AppMethodBeat.i(146249);
    super.setEnableVolumeLevel(paramBoolean);
    if (this.mEffectorObj != 0L) {
      nativeEnableVolumeLevel(this.mEffectorObj, paramBoolean);
    }
    AppMethodBeat.o(146249);
  }
  
  public void setEncBitRate(int paramInt)
  {
    AppMethodBeat.i(146245);
    super.setEncBitRate(paramInt);
    if (this.mSoftEncObj != 0L) {
      nativeSetEncBitRate(this.mSoftEncObj, paramInt);
    }
    AppMethodBeat.o(146245);
  }
  
  public void setEncFrameLenMs(int paramInt)
  {
    AppMethodBeat.i(146246);
    super.setEncFrameLenMs(paramInt);
    if (this.mSoftEncObj != 0L) {
      nativeSetEncFrameLenMs(this.mSoftEncObj, paramInt);
    }
    AppMethodBeat.o(146246);
  }
  
  public void setEncInfo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146247);
    super.setEncInfo(paramInt1, paramInt2);
    if (this.mSoftEncObj != 0L) {
      nativeSetEncInfo(this.mSoftEncObj, paramInt1, paramInt2);
    }
    AppMethodBeat.o(146247);
  }
  
  public void setFecRatio(float paramFloat)
  {
    AppMethodBeat.i(146248);
    super.setFecRatio(paramFloat);
    if (this.mSoftEncObj != 0L) {
      nativeSetFecRatio(this.mSoftEncObj, this.mFecRatio);
    }
    AppMethodBeat.o(146248);
  }
  
  public void setReverbParam(int paramInt, float paramFloat)
  {
    try
    {
      AppMethodBeat.i(66692);
      super.setReverbParam(paramInt, paramFloat);
      if (this.mEffectorObj != 0L) {
        nativeSetReverbParam(this.mEffectorObj, paramInt, paramFloat);
      }
      AppMethodBeat.o(66692);
      return;
    }
    finally {}
  }
  
  public void setReverbType(int paramInt)
  {
    try
    {
      AppMethodBeat.i(66689);
      super.setReverbType(paramInt);
      if (this.mEffectorObj > 0L) {
        nativeSetReverbType(this.mEffectorObj, paramInt);
      }
      AppMethodBeat.o(66689);
      return;
    }
    finally {}
  }
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(66691);
    super.setVolume(paramFloat);
    if (this.mEffectorObj != 0L) {
      nativeSetVolume(this.mEffectorObj, paramFloat);
    }
    AppMethodBeat.o(66691);
  }
  
  public int startRecord(Context paramContext)
  {
    AppMethodBeat.i(66683);
    TXCLog.i(TAG, "startRecord");
    super.startRecord(paramContext);
    if (!this.mIsCustomRecord) {
      if (this.mAECType == 1) {
        if (this.mSampleRate > com.tencent.liteav.basic.e.b.a().h())
        {
          this.mRecordSampleRate = com.tencent.liteav.basic.e.b.a().i();
          if (this.mRecordSampleRate == 0) {
            this.mRecordSampleRate = 16000;
          }
          label73:
          f.a().a(this);
          f.a().a(this.mContext, this.mRecordSampleRate, this.mChannels, this.mBits, this.mAECType);
          label106:
          if ((this.mWeakRecordListener != null) && (this.mWeakRecordListener.get() != null)) {
            if (this.mAECType != 1) {
              break label424;
            }
          }
        }
      }
    }
    label424:
    for (paramContext = "SYSTEM-AEC,";; paramContext = "NO-AEC,")
    {
      paramContext = paramContext + "采样率(" + this.mRecordSampleRate + "|" + this.mSampleRate + "),声道数" + this.mChannels;
      ((com.tencent.liteav.audio.d)this.mWeakRecordListener.get()).a(1, paramContext);
      AppMethodBeat.o(66683);
      return 0;
      this.mRecordSampleRate = com.tencent.liteav.basic.e.b.a().h();
      break;
      this.mRecordSampleRate = this.mSampleRate;
      if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
        break label73;
      }
      paramContext = getProperty("ro.board.platform");
      String str = getProperty("ro.build.version.emui");
      if (((!paramContext.equalsIgnoreCase("hi3650")) || (!str.equalsIgnoreCase("EmotionUI_8.0.0"))) && ((!paramContext.equalsIgnoreCase("kirin970")) || (!str.equalsIgnoreCase("EmotionUI_8.1.0"))) && ((!paramContext.equalsIgnoreCase("kirin970")) || (!str.equalsIgnoreCase("EmotionUI_8.2.0")))) {
        break label73;
      }
      TXCLog.e(TAG, "Force record sample rate 16000, HUAWEI-" + paramContext + "-" + str);
      this.mRecordSampleRate = 16000;
      break label73;
      setNoiseSuppression(-1);
      this.mRecordSampleRate = this.mSampleRate;
      this.mCustomRecord = new d();
      this.mCustomRecord.a(this);
      this.mCustomRecord.a(this.mContext, this.mRecordSampleRate, this.mChannels, this.mBits);
      break label106;
    }
  }
  
  public int stopRecord()
  {
    AppMethodBeat.i(66685);
    TXCLog.i(TAG, "stopRecord");
    if (this.mCustomRecord != null)
    {
      this.mCustomRecord.c();
      this.mCustomRecord = null;
    }
    f.a().b();
    com.tencent.liteav.audio.impl.a.a().b(this);
    this.mNeedMix = false;
    this.mTimestampInSamples = 0L;
    AppMethodBeat.o(66685);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.TXCAudioSysRecordController
 * JD-Core Version:    0.7.0.1
 */