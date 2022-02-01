package com.tencent.liteav.audio.impl;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class a
  extends TXCAudioEngImplBase
  implements c
{
  protected static boolean e = false;
  protected String a;
  protected boolean b;
  protected Context c;
  protected boolean d;
  protected boolean f;
  private com.tencent.liteav.audio.impl.a.c g;
  
  public a()
  {
    AppMethodBeat.i(16413);
    this.b = false;
    this.c = null;
    this.d = false;
    this.g = null;
    this.f = false;
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "construct: TXCAudioEngImplTRAE.");
    AppMethodBeat.o(16413);
  }
  
  public void InitBeforeStart(Context paramContext)
  {
    AppMethodBeat.i(16414);
    super.InitBeforeStart(paramContext);
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", " InitBeforeStart");
    if (paramContext != null) {
      this.c = paramContext.getApplicationContext();
    }
    TXCTraeJNI.InitTraeEngineLibrary(paramContext);
    com.tencent.liteav.basic.e.b.a().a(paramContext);
    TXCTraeJNI.nativeSetTraeConfig(com.tencent.liteav.basic.e.b.a().b());
    TXCTraeJNI.nativeInitBeforeEngineCreate(paramContext);
    TXCTraeJNI.nativeNewAudioSessionDuplicate(this.c);
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", " TXCTelephonyMgr set...");
    b.a().a(this.c);
    b.a().a(this);
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", " InitBeforeStart end...");
    AppMethodBeat.o(16414);
  }
  
  public void UnInitEngine()
  {
    AppMethodBeat.i(16415);
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "TXCAudioEngImplTRAE UnInitEngine");
    TXCTraeJNI.nativeUnInitEngine();
    b.a().b(this);
    AppMethodBeat.o(16415);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(16444);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(16444);
      return;
      TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "TelephonyManager.CALL_STATE_RINGING!");
      AppMethodBeat.o(16444);
      return;
      TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "TelephonyManager.CALL_STATE_OFFHOOK!");
      TXCTraeJNI.traePauseAuioRecord(true);
      TXCTraeJNI.traeSetSilence(true);
      this.f = true;
      AppMethodBeat.o(16444);
      return;
      TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "TelephonyManager.CALL_STATE_IDLE!");
      if (this.f)
      {
        this.f = false;
        TXCTraeJNI.traeResumeAuioRecord();
        TXCTraeJNI.traeSetSilence(false);
      }
    }
  }
  
  public int addJitterChannel(String paramString)
  {
    AppMethodBeat.i(16439);
    super.addJitterChannel(paramString);
    paramString = getJitterByID(paramString);
    if (paramString != null) {
      paramString.enableVolumeLevelCal(e);
    }
    AppMethodBeat.o(16439);
    return 0;
  }
  
  public void enableEosMode(boolean paramBoolean)
  {
    AppMethodBeat.i(16427);
    TXCTraeJNI.nativeTraeEnableEosMode(paramBoolean);
    AppMethodBeat.o(16427);
  }
  
  public void enableSoftAEC(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(16422);
    TXCTraeJNI.nativeSetTraeAEC(paramBoolean, paramInt);
    AppMethodBeat.o(16422);
  }
  
  public void enableSoftAGC(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(16424);
    TXCTraeJNI.nativeSetTraeAGC(paramBoolean, paramInt);
    AppMethodBeat.o(16424);
  }
  
  public void enableSoftANS(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(16423);
    TXCTraeJNI.nativeSetTraeANS(paramBoolean, paramInt);
    AppMethodBeat.o(16423);
  }
  
  public void enableVolumeLevel(boolean paramBoolean)
  {
    AppMethodBeat.i(16428);
    e = paramBoolean;
    TXCTraeJNI.nativeTraeEnableVolumeLevel(paramBoolean);
    TXCJitter.EnableCoreplayVolumeLevelCal(paramBoolean);
    Object localObject1 = null;
    synchronized (this.mLockObj)
    {
      if (this.mJitterMap != null) {
        localObject1 = (HashMap)this.mJitterMap.clone();
      }
      if (localObject1 != null)
      {
        localObject1 = ((HashMap)localObject1).entrySet().iterator();
        if (((Iterator)localObject1).hasNext()) {
          ((TXCJitter)((Map.Entry)((Iterator)localObject1).next()).getValue()).enableVolumeLevelCal(paramBoolean);
        }
      }
    }
    AppMethodBeat.o(16428);
  }
  
  public int getAECType()
  {
    return 0;
  }
  
  public int getPlayAECType()
  {
    return 2;
  }
  
  public int getRecordVolumeLevel()
  {
    AppMethodBeat.i(16429);
    int i = TXCTraeJNI.nativeTraeGetVolumeLevel();
    AppMethodBeat.o(16429);
    return i;
  }
  
  public int getVolumeLevel()
  {
    AppMethodBeat.i(16419);
    int i = TXCTraeJNI.nativeTraeGetVolumeLevel();
    AppMethodBeat.o(16419);
    return i;
  }
  
  public boolean isRecording()
  {
    AppMethodBeat.i(16436);
    boolean bool = TXCTraeJNI.nativeTraeIsRecording();
    AppMethodBeat.o(16436);
    return bool;
  }
  
  public int pauseRecord(boolean paramBoolean)
  {
    AppMethodBeat.i(16431);
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "trae pauseRecord : ".concat(String.valueOf(paramBoolean)));
    TXCTraeJNI.nativeTraePauseAuioRecord(paramBoolean);
    AppMethodBeat.o(16431);
    return 0;
  }
  
  public int resumeRecord()
  {
    AppMethodBeat.i(16432);
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "trae resumeRecord");
    TXCTraeJNI.nativeTraeResumeAuioRecord();
    AppMethodBeat.o(16432);
    return 0;
  }
  
  public void sendCustomPCMData(com.tencent.liteav.basic.structs.a parama)
  {
    AppMethodBeat.i(16435);
    TXCTraeJNI.sendCustomPCMData(parama);
    AppMethodBeat.o(16435);
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16434);
    TXCTraeJNI.sendCustomPCMData(paramArrayOfByte);
    AppMethodBeat.o(16434);
  }
  
  public void setAudioMode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(16443);
    TXCTraeJNI.setContext(paramContext);
    TXCTraeJNI.nativeSetAudioMode(paramInt);
    AppMethodBeat.o(16443);
  }
  
  public void setEarphoneOn(boolean paramBoolean)
  {
    AppMethodBeat.i(16421);
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "setEarphoneOn: ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(16421);
  }
  
  public void setEncInfo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16438);
    TXCTraeJNI.nativeSetEncInfo(paramInt1, paramInt2);
    AppMethodBeat.o(16438);
  }
  
  public void setFecRatio(float paramFloat)
  {
    AppMethodBeat.i(16426);
    TXCTraeJNI.nativeSetFecRatio(paramFloat);
    AppMethodBeat.o(16426);
  }
  
  public void setIsCustomRecord(boolean paramBoolean)
  {
    AppMethodBeat.i(16437);
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "setIsCustomRecord: ".concat(String.valueOf(paramBoolean)));
    if (isRecording())
    {
      TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "setIsCustomRecord must set before startRecord!!! ");
      AppMethodBeat.o(16437);
      return;
    }
    this.d = paramBoolean;
    TXCTraeJNI.setIsCustomRecord(paramBoolean);
    AppMethodBeat.o(16437);
  }
  
  public void setPlayoutVolume(float paramFloat)
  {
    AppMethodBeat.i(182285);
    TXCTraeJNI.nativeTraeSetPlayoutVolume(paramFloat);
    AppMethodBeat.o(182285);
  }
  
  public void setRecordID(String paramString)
  {
    this.a = paramString;
  }
  
  /* Error */
  public void setRecordListener(com.tencent.liteav.audio.e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 16416
    //   5: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 43
    //   10: ldc_w 286
    //   13: aload_1
    //   14: invokestatic 289	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   17: invokevirtual 228	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokestatic 50	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_1
    //   24: ifnonnull +16 -> 40
    //   27: aconst_null
    //   28: invokestatic 293	com/tencent/liteav/audio/impl/TXCTraeJNI:setTraeRecordListener	(Ljava/lang/ref/WeakReference;)V
    //   31: sipush 16416
    //   34: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: new 295	java/lang/ref/WeakReference
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 298	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   48: invokestatic 293	com/tencent/liteav/audio/impl/TXCTraeJNI:setTraeRecordListener	(Ljava/lang/ref/WeakReference;)V
    //   51: sipush 16416
    //   54: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: goto -20 -> 37
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	a
    //   0	65	1	parame	com.tencent.liteav.audio.e
    // Exception table:
    //   from	to	target	type
    //   2	23	60	finally
    //   27	37	60	finally
    //   40	57	60	finally
  }
  
  public void setRecordMute(boolean paramBoolean)
  {
    AppMethodBeat.i(16418);
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "setRecordMute: ".concat(String.valueOf(paramBoolean)));
    TXCTraeJNI.nativeTraeSetRecordMute(paramBoolean);
    AppMethodBeat.o(16418);
  }
  
  public void setRecordVolume(float paramFloat)
  {
    AppMethodBeat.i(16420);
    TXCTraeJNI.nativeTraeSetRecordVolume(paramFloat);
    AppMethodBeat.o(16420);
  }
  
  public void setReverbParam(int paramInt, float paramFloat) {}
  
  public void setReverbType(int paramInt)
  {
    AppMethodBeat.i(16417);
    TXCTraeJNI.nativeTraeSetRecordReverb(paramInt);
    AppMethodBeat.o(16417);
  }
  
  public void setVoiceChangerType(int paramInt)
  {
    int i = 13;
    AppMethodBeat.i(16425);
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "setVoiceChangerType: ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      paramInt = -1;
      i = -1;
    }
    for (;;)
    {
      TXCTraeJNI.nativeTraeSetChangerType(i, paramInt);
      AppMethodBeat.o(16425);
      return;
      paramInt = -1;
      i = 6;
      continue;
      paramInt = -1;
      i = 4;
      continue;
      paramInt = -1;
      i = 5;
      continue;
      paramInt = 9;
      i = -1;
      continue;
      paramInt = 50;
      i = 536936433;
      continue;
      paramInt = 5;
      i = -1;
      continue;
      paramInt = 1;
      continue;
      paramInt = -1;
      continue;
      paramInt = 4;
      i = 10;
      continue;
      paramInt = 20;
      i = 10;
      continue;
      paramInt = 2;
      i = -1;
    }
  }
  
  public int startDevicePlay()
  {
    AppMethodBeat.i(16442);
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "startDevicePlay!");
    if (this.mDeviceIsPlaying != true)
    {
      if (!TXCJitter.nativeIsTracksEmpty())
      {
        TXCTraeJNI.InitTraeEngineLibrary(this.mPlayContext);
        TXCTraeJNI.traeStartPlay(this.mPlayContext);
        TXCTraeJNI.nativeNewAudioSessionDuplicate(this.mPlayContext);
        this.mDeviceIsPlaying = true;
      }
      TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "finish start play audio!");
      AppMethodBeat.o(16442);
      return 0;
    }
    TXCLog.e("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "repeat start play audio, ignore it!");
    AppMethodBeat.o(16442);
    return -104;
  }
  
  public int startJitterChannelPlay(String paramString)
  {
    AppMethodBeat.i(16440);
    super.startJitterChannelPlay(paramString);
    AppMethodBeat.o(16440);
    return 0;
  }
  
  public int startRecord(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16430);
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "trae startRecord");
    if (this.c == null)
    {
      TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "Please call CreateInstance fisrt!!!");
      AppMethodBeat.o(16430);
      return -1;
    }
    TXCTraeJNI.InitTraeEngineLibrary(this.c);
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "startRecord: " + paramInt1 + "," + paramInt2 + "," + paramInt3);
    TXCTraeJNI.nativeNewAudioSessionDuplicate(this.c);
    TXCTraeJNI.nativeTraeEnableVolumeLevel(e);
    TXCTraeJNI.nativeTraeStartRecord(this.c, paramInt1, paramInt2, paramInt3);
    this.b = true;
    AppMethodBeat.o(16430);
    return 0;
  }
  
  public int stopDevicePlay()
  {
    AppMethodBeat.i(16441);
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "stopDevicePlay()!");
    this.mDeviceIsPlaying = false;
    synchronized (this.mLockObj)
    {
      if (this.mJitterMap != null) {
        this.mJitterMap.clear();
      }
      TXCTraeJNI.traeStopPlay();
      if (!this.b) {
        TXCTraeJNI.nativeDeleteAudioSessionDuplicate();
      }
      AppMethodBeat.o(16441);
      return 0;
    }
  }
  
  public int stopRecord()
  {
    AppMethodBeat.i(16433);
    TXCLog.i("TXCAudioEngImplTRAE[TXSDK-TRAE-LOG]", "trae stopRecord");
    TXCTraeJNI.nativeTraeStopRecord();
    this.b = false;
    AppMethodBeat.o(16433);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a
 * JD-Core Version:    0.7.0.1
 */