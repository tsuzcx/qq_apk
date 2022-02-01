package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecord;
import com.tencent.liteav.audio.impl.Record.a;
import com.tencent.liteav.audio.impl.Record.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TXCAudioUGCRecorder
  implements c
{
  private static final TXCAudioUGCRecorder INSTANCE;
  private static final String TAG = "AudioCenter:TXCAudioUGCRecorder";
  private final int AAC_SAMPLE_NUM;
  protected int mAACFrameLength;
  protected int mAECType;
  private a mBGMRecorder;
  protected int mBits;
  protected int mChannels;
  protected Context mContext;
  private boolean mCurBGMRecordFlag;
  private boolean mEnableBGMRecord;
  private final List<byte[]> mEncodedAudioList;
  protected boolean mIsEarphoneOn;
  private boolean mIsMute;
  private boolean mIsPause;
  private boolean mIsRunning;
  private long mLastPTS;
  protected int mReverbType;
  protected AtomicInteger mSampleRate;
  private int mShouldClearAACDataCnt;
  private AtomicReference<Float> mSpeedRate;
  protected int mVoiceChangerType;
  private float mVolume;
  private WeakReference<g> mWeakRecordListener;
  
  static
  {
    AppMethodBeat.i(16329);
    h.d();
    INSTANCE = new TXCAudioUGCRecorder();
    AppMethodBeat.o(16329);
  }
  
  private TXCAudioUGCRecorder()
  {
    AppMethodBeat.i(230388);
    this.AAC_SAMPLE_NUM = 1024;
    this.mSampleRate = new AtomicInteger(48000);
    this.mChannels = 1;
    this.mBits = 16;
    this.mAACFrameLength = (this.mChannels * 1024 * this.mBits / 8);
    this.mReverbType = 0;
    this.mVoiceChangerType = 0;
    this.mAECType = 0;
    this.mIsEarphoneOn = false;
    this.mLastPTS = 0L;
    this.mVolume = 1.0F;
    this.mBGMRecorder = null;
    this.mEnableBGMRecord = false;
    this.mShouldClearAACDataCnt = 0;
    this.mCurBGMRecordFlag = false;
    this.mSpeedRate = new AtomicReference(Float.valueOf(1.0F));
    this.mIsRunning = false;
    this.mIsPause = false;
    this.mIsMute = false;
    this.mEncodedAudioList = new ArrayList();
    TXCAudioSysRecord.getInstance();
    nativeClassInit();
    AppMethodBeat.o(230388);
  }
  
  public static TXCAudioUGCRecorder getInstance()
  {
    return INSTANCE;
  }
  
  private native void nativeClassInit();
  
  private native void nativeEnableMixMode(boolean paramBoolean);
  
  private native void nativeSetChangerType(int paramInt);
  
  private native void nativeSetReverbType(int paramInt);
  
  private native void nativeSetSpeedRate(float paramFloat);
  
  private native void nativeSetVolume(float paramFloat);
  
  private native void nativeStartAudioRecord(int paramInt1, int paramInt2, int paramInt3);
  
  private native void nativeStopAudioRecord();
  
  private void updateAudioEffector()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(230395);
        boolean bool = false;
        if ((!this.mEnableBGMRecord) && (this.mAECType != 1))
        {
          if (!bool)
          {
            nativeSetReverbType(this.mReverbType);
            nativeSetChangerType(this.mVoiceChangerType);
            if (this.mIsMute) {
              nativeSetVolume(0.0F);
            }
          }
          else
          {
            if (bool) {
              nativeSetVolume(0.0F);
            }
            nativeEnableMixMode(bool);
            nativeSetSpeedRate(((Float)this.mSpeedRate.get()).floatValue());
            AppMethodBeat.o(230395);
            return;
          }
          nativeSetVolume(this.mVolume);
          continue;
        }
        bool = true;
      }
      finally {}
    }
  }
  
  /* Error */
  public void clearCache()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 16321
    //   5: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 12
    //   10: ldc 173
    //   12: invokestatic 178	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 131	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEncodedAudioList	Ljava/util/List;
    //   19: astore_1
    //   20: aload_1
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 131	com/tencent/liteav/audio/TXCAudioUGCRecorder:mEncodedAudioList	Ljava/util/List;
    //   26: invokeinterface 183 1 0
    //   31: aload_1
    //   32: monitorexit
    //   33: sipush 16321
    //   36: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: astore_2
    //   43: aload_1
    //   44: monitorexit
    //   45: sipush 16321
    //   48: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_2
    //   52: athrow
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	TXCAudioUGCRecorder
    //   53	4	1	localObject1	Object
    //   42	10	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	33	42	finally
    //   2	22	53	finally
    //   33	39	53	finally
    //   43	53	53	finally
  }
  
  public void enableBGMRecord(boolean paramBoolean)
  {
    AppMethodBeat.i(16315);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "enableBGMRecord: ".concat(String.valueOf(paramBoolean)));
    if ((this.mEnableBGMRecord != paramBoolean) && (!paramBoolean)) {
      this.mShouldClearAACDataCnt = 2;
    }
    this.mEnableBGMRecord = paramBoolean;
    updateAudioEffector();
    AppMethodBeat.o(16315);
  }
  
  public int getChannels()
  {
    return this.mChannels;
  }
  
  public g getListener()
  {
    AppMethodBeat.i(230529);
    if (this.mWeakRecordListener != null)
    {
      g localg = (g)this.mWeakRecordListener.get();
      AppMethodBeat.o(230529);
      return localg;
    }
    AppMethodBeat.o(230529);
    return null;
  }
  
  public int getSampleRate()
  {
    AppMethodBeat.i(230573);
    int i = this.mSampleRate.get();
    AppMethodBeat.o(230573);
    return i;
  }
  
  public boolean isPaused()
  {
    return this.mIsPause;
  }
  
  public boolean isRecording()
  {
    AppMethodBeat.i(16317);
    boolean bool = this.mIsRunning;
    AppMethodBeat.o(16317);
    return bool;
  }
  
  public void onAudioRecordError(int paramInt, String paramString)
  {
    AppMethodBeat.i(16324);
    TXCLog.e("AudioCenter:TXCAudioUGCRecorder", "sys audio record error: " + paramInt + ", " + paramString);
    g localg = getListener();
    if (localg != null) {
      localg.onRecordError(paramInt, paramString);
    }
    AppMethodBeat.o(16324);
  }
  
  public void onAudioRecordPCM(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(16325);
    if (this.mLastPTS >= paramLong) {
      paramLong = 2L + this.mLastPTS;
    }
    label228:
    for (;;)
    {
      synchronized (this.mEncodedAudioList)
      {
        if ((!this.mEncodedAudioList.isEmpty()) && (!this.mIsPause))
        {
          paramArrayOfByte = (byte[])this.mEncodedAudioList.get(0);
          this.mEncodedAudioList.remove(0);
          if (this.mShouldClearAACDataCnt <= 0) {
            break label228;
          }
          this.mShouldClearAACDataCnt -= 1;
          paramArrayOfByte = null;
          long l = paramLong;
          if (paramArrayOfByte != null)
          {
            this.mLastPTS = paramLong;
            g localg = getListener();
            if (localg == null) {
              continue;
            }
            localg.onRecordEncData(paramArrayOfByte, paramLong, this.mSampleRate.get(), this.mChannels, this.mBits);
            paramInt = this.mSampleRate.get();
            l = paramLong;
            if (paramInt > 0) {
              l = paramLong + (((Float)this.mSpeedRate.get()).floatValue() * 1024000.0F / paramInt);
            }
          }
          paramLong = l;
          if (paramArrayOfByte != null) {
            continue;
          }
          AppMethodBeat.o(16325);
        }
        else
        {
          paramArrayOfByte = null;
          continue;
        }
        TXCLog.e("AudioCenter:TXCAudioUGCRecorder", "onAudioRecordPCM listener is null");
      }
    }
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
    AppMethodBeat.o(16323);
  }
  
  public void onEncodedData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(230629);
    synchronized (this.mEncodedAudioList)
    {
      this.mEncodedAudioList.add(paramArrayOfByte);
      AppMethodBeat.o(230629);
      return;
    }
  }
  
  public void pause()
  {
    AppMethodBeat.i(16306);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "pause");
    TXCAudioEngine.getInstance().pauseLocalAudio();
    synchronized (this.mEncodedAudioList)
    {
      this.mIsPause = true;
      AppMethodBeat.o(16306);
      return;
    }
  }
  
  public void resume()
  {
    AppMethodBeat.i(16307);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "resume");
    TXCAudioEngine.getInstance().resumeLocalAudio();
    synchronized (this.mEncodedAudioList)
    {
      this.mIsPause = false;
      nativeEnableMixMode(this.mEnableBGMRecord);
      if ((this.mIsMute) || (this.mEnableBGMRecord))
      {
        nativeSetVolume(0.0F);
        AppMethodBeat.o(16307);
        return;
      }
    }
    nativeSetVolume(this.mVolume);
    AppMethodBeat.o(16307);
  }
  
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
  
  public void setChangerType(int paramInt)
  {
    try
    {
      AppMethodBeat.i(230682);
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setChangerType: ".concat(String.valueOf(paramInt)));
      this.mVoiceChangerType = paramInt;
      nativeSetChangerType(paramInt);
      AppMethodBeat.o(230682);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setChannels(int paramInt)
  {
    AppMethodBeat.i(16310);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setChannels: ".concat(String.valueOf(paramInt)));
    this.mChannels = paramInt;
    AppMethodBeat.o(16310);
  }
  
  /* Error */
  public void setListener(g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 320
    //   5: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +17 -> 26
    //   12: aload_0
    //   13: aconst_null
    //   14: putfield 204	com/tencent/liteav/audio/TXCAudioUGCRecorder:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   17: ldc_w 320
    //   20: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: new 206	java/lang/ref/WeakReference
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 321	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   35: putfield 204	com/tencent/liteav/audio/TXCAudioUGCRecorder:mWeakRecordListener	Ljava/lang/ref/WeakReference;
    //   38: ldc_w 320
    //   41: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -21 -> 23
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	TXCAudioUGCRecorder
    //   0	52	1	paramg	g
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
    if (paramBoolean)
    {
      nativeSetVolume(0.0F);
      AppMethodBeat.o(16314);
      return;
    }
    nativeSetVolume(this.mVolume);
    AppMethodBeat.o(16314);
  }
  
  public void setReverbType(int paramInt)
  {
    try
    {
      AppMethodBeat.i(16312);
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setReverbType: ".concat(String.valueOf(paramInt)));
      this.mReverbType = paramInt;
      nativeSetReverbType(paramInt);
      AppMethodBeat.o(16312);
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
    AppMethodBeat.i(16311);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setSampleRate: ".concat(String.valueOf(paramInt)));
    this.mSampleRate.set(paramInt);
    AppMethodBeat.o(16311);
  }
  
  public void setSpeedRate(float paramFloat)
  {
    try
    {
      AppMethodBeat.i(16320);
      TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "setSpeedRate: ".concat(String.valueOf(paramFloat)));
      this.mSpeedRate.set(Float.valueOf(paramFloat));
      nativeSetSpeedRate(((Float)this.mSpeedRate.get()).floatValue());
      AppMethodBeat.o(16320);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void setVolume(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 16319
    //   5: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 12
    //   10: ldc_w 344
    //   13: fload_1
    //   14: invokestatic 339	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   17: invokevirtual 195	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokestatic 178	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: fload_1
    //   25: putfield 99	com/tencent/liteav/audio/TXCAudioUGCRecorder:mVolume	F
    //   28: aload_0
    //   29: getfield 126	com/tencent/liteav/audio/TXCAudioUGCRecorder:mIsMute	Z
    //   32: ifeq +17 -> 49
    //   35: aload_0
    //   36: fconst_0
    //   37: invokespecial 159	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeSetVolume	(F)V
    //   40: sipush 16319
    //   43: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: fload_1
    //   51: invokespecial 159	com/tencent/liteav/audio/TXCAudioUGCRecorder:nativeSetVolume	(F)V
    //   54: sipush 16319
    //   57: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: goto -14 -> 46
    //   63: astore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	TXCAudioUGCRecorder
    //   0	68	1	paramFloat	float
    //   63	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	46	63	finally
    //   49	60	63	finally
  }
  
  public int startRecord(Context paramContext)
  {
    AppMethodBeat.i(16304);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "startRecord");
    if (paramContext != null) {
      this.mContext = paramContext.getApplicationContext();
    }
    updateAudioEffector();
    TXCAudioSysRecord.getInstance().setAudioRecordListener(this);
    nativeStartAudioRecord(this.mSampleRate.get(), this.mChannels, this.mBits);
    this.mIsRunning = true;
    this.mLastPTS = 0L;
    AppMethodBeat.o(16304);
    return 0;
  }
  
  public int stopRecord()
  {
    AppMethodBeat.i(16305);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "stopRecord");
    TXCAudioSysRecord.getInstance().setAudioRecordListener(null);
    if (this.mBGMRecorder != null)
    {
      this.mBGMRecorder.a();
      this.mBGMRecorder = null;
    }
    nativeStopAudioRecord();
    nativeEnableMixMode(false);
    nativeSetVolume(1.0F);
    synchronized (this.mEncodedAudioList)
    {
      this.mEncodedAudioList.clear();
      this.mIsRunning = false;
      this.mLastPTS = 0L;
      this.mIsPause = false;
      this.mIsMute = false;
      this.mShouldClearAACDataCnt = 0;
      AppMethodBeat.o(16305);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCAudioUGCRecorder
 * JD-Core Version:    0.7.0.1
 */