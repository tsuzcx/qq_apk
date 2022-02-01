package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class TXCAudioEngImplBase
  implements com.tencent.liteav.basic.c.a
{
  private static final String TAG = "TXCAudioEngImplBase[TXSDK-TRAE-LOG]";
  private static WeakReference<d> mAudioCoreDataListener = null;
  private String ID;
  protected boolean mDeviceIsPlaying;
  protected HashMap<String, TXCJitter> mJitterMap;
  protected Object mLockObj;
  protected Context mPlayContext;
  
  public TXCAudioEngImplBase()
  {
    AppMethodBeat.i(16343);
    this.mPlayContext = null;
    this.mJitterMap = new HashMap();
    this.mDeviceIsPlaying = false;
    this.mLockObj = new Object();
    TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "construct TXCAudioEngImplBase");
    AppMethodBeat.o(16343);
  }
  
  static void ChangeVolumeType(int paramInt) {}
  
  public static void onCorePlayPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16358);
    if (mAudioCoreDataListener != null)
    {
      d locald = (d)mAudioCoreDataListener.get();
      if (locald != null) {
        locald.onAudioPlayPcmData(null, paramArrayOfByte, paramLong, paramInt1, paramInt2);
      }
      if (paramArrayOfByte != null) {
        TXCJitter.nativePlayAfterCorePlayCallback(paramArrayOfByte, paramArrayOfByte.length);
      }
    }
    AppMethodBeat.o(16358);
  }
  
  public static void setAudioCorePlayListener(d paramd)
  {
    AppMethodBeat.i(16357);
    mAudioCoreDataListener = new WeakReference(paramd);
    TXCJitter.setAudioCorePlayListener(paramd);
    AppMethodBeat.o(16357);
  }
  
  public void InitBeforeStart(Context paramContext)
  {
    AppMethodBeat.i(16344);
    TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "TXCAudioEngImplBase InitBeforeStart");
    this.mPlayContext = paramContext.getApplicationContext();
    AppMethodBeat.o(16344);
  }
  
  public void UnInitEngine()
  {
    AppMethodBeat.i(16345);
    TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "TXCAudioEngImplBase UnInitEngine");
    AppMethodBeat.o(16345);
  }
  
  public int addJitterChannel(String paramString)
  {
    AppMethodBeat.i(16359);
    if (getJitterByID(paramString) != null)
    {
      TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "addJitterChannel: " + paramString + " already exist");
      AppMethodBeat.o(16359);
      return 0;
    }
    if (this.mPlayContext == null)
    {
      TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "Please call CreateInstance fisrt!!!");
      AppMethodBeat.o(16359);
      return -1;
    }
    TXCJitter localTXCJitter = new TXCJitter(paramString);
    synchronized (this.mLockObj)
    {
      this.mJitterMap.put(paramString, localTXCJitter);
      AppMethodBeat.o(16359);
      return 0;
    }
  }
  
  public void enableAutoAdjustCache(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(16368);
    paramString = getJitterByID(paramString);
    if (paramString != null) {
      paramString.enableAutojustCache(paramBoolean);
    }
    AppMethodBeat.o(16368);
  }
  
  public void enableEosMode(boolean paramBoolean) {}
  
  public void enableRealTimePlay(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(16376);
    paramString = getJitterByID(paramString);
    if (paramString != null)
    {
      paramString.enableRealTimePlay(paramBoolean);
      AppMethodBeat.o(16376);
      return;
    }
    AppMethodBeat.o(16376);
  }
  
  public void enableSoftAEC(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(16351);
    TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "enableSoftAEC: enable = " + paramBoolean + " level = " + paramInt);
    AppMethodBeat.o(16351);
  }
  
  public void enableSoftAGC(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(16353);
    TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "enableSoftAGC: enable = " + paramBoolean + " level = " + paramInt);
    AppMethodBeat.o(16353);
  }
  
  public void enableSoftANS(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(16352);
    TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "enableSoftANS: enable = " + paramBoolean + " level = " + paramInt);
    AppMethodBeat.o(16352);
  }
  
  public void enableVolumeLevel(boolean paramBoolean) {}
  
  public int getAECType()
  {
    return 0;
  }
  
  protected TXCJitter getJitterByID(String paramString)
  {
    AppMethodBeat.i(16377);
    synchronized (this.mLockObj)
    {
      if (this.mJitterMap != null)
      {
        paramString = (TXCJitter)this.mJitterMap.get(paramString);
        AppMethodBeat.o(16377);
        return paramString;
      }
      AppMethodBeat.o(16377);
      return null;
    }
  }
  
  public boolean getJitterChannel(String paramString)
  {
    AppMethodBeat.i(16362);
    if (getJitterByID(paramString) != null)
    {
      AppMethodBeat.o(16362);
      return true;
    }
    AppMethodBeat.o(16362);
    return false;
  }
  
  public int getJitterChannelVolumeLevel(String paramString)
  {
    AppMethodBeat.i(16374);
    paramString = getJitterByID(paramString);
    if (paramString != null)
    {
      int i = paramString.getVolumeLevel();
      AppMethodBeat.o(16374);
      return i;
    }
    AppMethodBeat.o(16374);
    return 0;
  }
  
  public int getPlayAECType()
  {
    return 0;
  }
  
  public int getRecordVolumeLevel()
  {
    return 0;
  }
  
  public int getVolumeLevel()
  {
    return 0;
  }
  
  public boolean isJitterChannelPlaying(String paramString)
  {
    AppMethodBeat.i(16375);
    paramString = getJitterByID(paramString);
    if (paramString != null)
    {
      boolean bool = paramString.isPlaying();
      AppMethodBeat.o(16375);
      return bool;
    }
    AppMethodBeat.o(16375);
    return false;
  }
  
  public boolean isRecording()
  {
    return false;
  }
  
  public void muteInSpeaker(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(16372);
    paramString = getJitterByID(paramString);
    if (paramString != null) {
      paramString.muteInSpeaker(paramBoolean);
    }
    AppMethodBeat.o(16372);
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle) {}
  
  public int pauseRecord(boolean paramBoolean)
  {
    return 0;
  }
  
  public int resumeRecord()
  {
    return 0;
  }
  
  public void sendCustomPCMData(com.tencent.liteav.basic.structs.a parama) {}
  
  public void sendCustomPCMData(byte[] paramArrayOfByte) {}
  
  void setAudioMode(Context paramContext, int paramInt) {}
  
  public void setAutoAdjustMaxCache(String paramString, float paramFloat)
  {
    AppMethodBeat.i(16369);
    paramString = getJitterByID(paramString);
    if (paramString != null) {
      paramString.setAutoAdjustMaxCache(paramFloat);
    }
    AppMethodBeat.o(16369);
  }
  
  public void setAutoAdjustMinCache(String paramString, float paramFloat)
  {
    AppMethodBeat.i(16370);
    paramString = getJitterByID(paramString);
    if (paramString != null) {
      paramString.setAutoAdjustMinCache(paramFloat);
    }
    AppMethodBeat.o(16370);
  }
  
  public void setCacheTime(String paramString, float paramFloat)
  {
    AppMethodBeat.i(16367);
    paramString = getJitterByID(paramString);
    if (paramString != null) {
      paramString.setCacheTime(paramFloat);
    }
    AppMethodBeat.o(16367);
  }
  
  public void setEarphoneOn(boolean paramBoolean)
  {
    AppMethodBeat.i(16350);
    TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "setEarphoneOn: ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(16350);
  }
  
  public void setEncInfo(int paramInt1, int paramInt2) {}
  
  public void setFecRatio(float paramFloat) {}
  
  public void setIsCustomRecord(boolean paramBoolean)
  {
    AppMethodBeat.i(16355);
    TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "setIsCustomRecord: ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(16355);
  }
  
  public void setJitterChannelDataListener(String paramString, d paramd)
  {
    AppMethodBeat.i(16365);
    paramString = getJitterByID(paramString);
    if (paramString != null) {
      paramString.setDataListener(paramd);
    }
    AppMethodBeat.o(16365);
  }
  
  public void setJitterChannelEventListener(String paramString, c paramc)
  {
    AppMethodBeat.i(16366);
    paramString = getJitterByID(paramString);
    if (paramString != null) {
      paramString.setEventListener(paramc);
    }
    AppMethodBeat.o(16366);
  }
  
  public void setPlayMute(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(16371);
    paramString = getJitterByID(paramString);
    if (paramString != null) {
      paramString.setPlayMute(paramBoolean);
    }
    AppMethodBeat.o(16371);
  }
  
  public void setPlayVolume(String paramString, int paramInt)
  {
    AppMethodBeat.i(16373);
    paramString = getJitterByID(paramString);
    if (paramString != null) {
      paramString.setPlayVolume(paramInt);
    }
    AppMethodBeat.o(16373);
  }
  
  public void setPlayoutVolume(float paramFloat) {}
  
  public void setRecordID(String paramString)
  {
    AppMethodBeat.i(16346);
    TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "setRecordID");
    AppMethodBeat.o(16346);
  }
  
  public void setRecordListener(e parame)
  {
    try
    {
      AppMethodBeat.i(16347);
      TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "setListener:".concat(String.valueOf(parame)));
      AppMethodBeat.o(16347);
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  public void setRecordMute(boolean paramBoolean)
  {
    AppMethodBeat.i(16349);
    TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "setRecordMute: ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(16349);
  }
  
  public void setRecordVolume(float paramFloat) {}
  
  public void setReverbParam(int paramInt, float paramFloat) {}
  
  public void setReverbType(int paramInt)
  {
    AppMethodBeat.i(16348);
    TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "setReverbType: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(16348);
  }
  
  public void setVoiceChangerType(int paramInt)
  {
    AppMethodBeat.i(16354);
    TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "setVoiceChangerType: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(16354);
  }
  
  public int startDevicePlay()
  {
    AppMethodBeat.i(16364);
    TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "startDevicePlay!");
    if (this.mDeviceIsPlaying != true)
    {
      if (!TXCJitter.nativeIsTracksEmpty())
      {
        TXCMultAudioTrackPlayer.a().b();
        this.mDeviceIsPlaying = true;
      }
      TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "finish start play audio!");
      AppMethodBeat.o(16364);
      return 0;
    }
    TXCLog.e("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "repeat start play audio, ignore it!");
    AppMethodBeat.o(16364);
    return -104;
  }
  
  public int startJitterChannelPlay(String paramString)
  {
    AppMethodBeat.i(16360);
    paramString = getJitterByID(paramString);
    if (paramString != null) {
      paramString.startPlay();
    }
    startDevicePlay();
    AppMethodBeat.o(16360);
    return 0;
  }
  
  public int startRecord(int paramInt1, int paramInt2, int paramInt3)
  {
    return 0;
  }
  
  public int stopDevicePlay()
  {
    AppMethodBeat.i(16363);
    this.mDeviceIsPlaying = false;
    synchronized (this.mLockObj)
    {
      this.mJitterMap.clear();
      TXCMultAudioTrackPlayer.a().c();
      AppMethodBeat.o(16363);
      return 0;
    }
  }
  
  public int stopJitterChannelPlay(String paramString)
  {
    AppMethodBeat.i(16361);
    int i = -105;
    ??? = getJitterByID(paramString);
    if (??? != null) {
      i = ((TXCJitter)???).stopPlay();
    }
    synchronized (this.mLockObj)
    {
      this.mJitterMap.remove(paramString);
      if (getJitterByID(paramString) != null) {
        TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "stopJitterChannelPlay: " + paramString + " is not remove???");
      }
      if (TXCJitter.nativeIsTracksEmpty())
      {
        TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "No JitterChannel  stopDevicePlay() ");
        stopDevicePlay();
      }
      AppMethodBeat.o(16361);
      return i;
    }
  }
  
  public int stopRecord()
  {
    AppMethodBeat.i(16356);
    TXCLog.i("TXCAudioEngImplBase[TXSDK-TRAE-LOG]", "stopRecord ");
    AppMethodBeat.o(16356);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.TXCAudioEngImplBase
 * JD-Core Version:    0.7.0.1
 */