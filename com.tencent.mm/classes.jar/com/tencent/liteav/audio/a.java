package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.TXCAudioEngImplBase;
import com.tencent.liteav.audio.impl.TXCJitter;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  static a a;
  private static volatile TXCAudioEngImplBase b;
  
  static
  {
    AppMethodBeat.i(16279);
    a = new a();
    b = null;
    AppMethodBeat.o(16279);
  }
  
  public static a a()
  {
    return a;
  }
  
  public static TXCAudioEngImplBase a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(16237);
        TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "CreateInstance: ");
        if (b != null)
        {
          TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "CreateInstance already created~ ");
          paramContext = b;
          AppMethodBeat.o(16237);
          return paramContext;
        }
        if (TXCTraeJNI.nativeCheckTraeEngine(paramContext))
        {
          TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "new TXCAudioEngImplTRAE( ): ");
          b = new com.tencent.liteav.audio.impl.a();
          TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "sAudioEngineInstance: " + b);
          b.InitBeforeStart(paramContext);
          paramContext = b;
          AppMethodBeat.o(16237);
          continue;
        }
        TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "new TXCAudioEngImplBase( ): ");
      }
      finally {}
      b = new TXCAudioEngImplBase();
    }
  }
  
  public static void a(d paramd)
  {
    AppMethodBeat.i(16274);
    TXCAudioEngImplBase.setAudioCorePlayListener(paramd);
    AppMethodBeat.o(16274);
  }
  
  public static boolean a(boolean paramBoolean)
  {
    AppMethodBeat.i(16238);
    TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "enableVolumeLevel : ".concat(String.valueOf(paramBoolean)));
    if (b != null)
    {
      b.enableVolumeLevel(paramBoolean);
      AppMethodBeat.o(16238);
      return true;
    }
    AppMethodBeat.o(16238);
    return false;
  }
  
  public static void c(int paramInt)
  {
    AppMethodBeat.i(16276);
    TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "setAudioRoute: ");
    TXCTraeJNI.nativeSetAudioRoute(paramInt);
    AppMethodBeat.o(16276);
  }
  
  public static void d(int paramInt)
  {
    AppMethodBeat.i(16277);
    TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "setVolumeType: ".concat(String.valueOf(paramInt)));
    TXCTraeJNI.nativeTraeChangeVolumeType(paramInt);
    AppMethodBeat.o(16277);
  }
  
  public static void f(boolean paramBoolean)
  {
    AppMethodBeat.i(16278);
    TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "setAudioEarMonitoring: ".concat(String.valueOf(paramBoolean)));
    TXCTraeJNI.nativesetAudioEarMonitoring(paramBoolean);
    AppMethodBeat.o(16278);
  }
  
  public static int i()
  {
    AppMethodBeat.i(16275);
    int i = TXCJitter.GetCorePlayVolumeLevel();
    AppMethodBeat.o(16275);
    return i;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16239);
    if (b != null)
    {
      paramInt1 = b.startRecord(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(16239);
      return paramInt1;
    }
    TXCLog.e("TXCAudioEngine[TXSDK-TRAE-LOG]", "start Record failed! Please call CreateInstance fisrt!!!!");
    AppMethodBeat.o(16239);
    return -901;
  }
  
  public void a(com.tencent.liteav.basic.structs.a parama)
  {
    AppMethodBeat.i(16244);
    if (b != null) {
      b.sendCustomPCMData(parama);
    }
    AppMethodBeat.o(16244);
  }
  
  public void a(String paramString, float paramFloat)
  {
    AppMethodBeat.i(16266);
    if (b != null) {
      b.setCacheTime(paramString, paramFloat);
    }
    AppMethodBeat.o(16266);
  }
  
  public void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(16271);
    TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "set volume to ".concat(String.valueOf(paramInt)));
    if (b != null) {
      b.setPlayVolume(paramString, paramInt);
    }
    AppMethodBeat.o(16271);
  }
  
  public void a(String paramString, c paramc)
  {
    AppMethodBeat.i(16263);
    if (b != null) {
      b.setJitterChannelEventListener(paramString, paramc);
    }
    AppMethodBeat.o(16263);
  }
  
  public void a(String paramString, d paramd)
  {
    AppMethodBeat.i(16262);
    if (b != null) {
      b.setJitterChannelDataListener(paramString, paramd);
    }
    AppMethodBeat.o(16262);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(16264);
    if (b != null) {
      b.enableRealTimePlay(paramString, paramBoolean);
    }
    AppMethodBeat.o(16264);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(16251);
    TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "enableSoftAEC: enable = " + paramBoolean + " level = " + paramInt);
    if (b != null) {
      b.enableSoftAEC(paramBoolean, paramInt);
    }
    AppMethodBeat.o(16251);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16243);
    if (b != null) {
      b.sendCustomPCMData(paramArrayOfByte);
    }
    AppMethodBeat.o(16243);
  }
  
  public boolean a(float paramFloat)
  {
    AppMethodBeat.i(16250);
    TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "setRecordVolume: ".concat(String.valueOf(paramFloat)));
    if (b != null)
    {
      b.setRecordVolume(paramFloat);
      AppMethodBeat.o(16250);
      return true;
    }
    AppMethodBeat.o(16250);
    return false;
  }
  
  public boolean a(int paramInt)
  {
    AppMethodBeat.i(16249);
    TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "setReverbType: ".concat(String.valueOf(paramInt)));
    if (b != null)
    {
      b.setReverbType(paramInt);
      AppMethodBeat.o(16249);
      return true;
    }
    AppMethodBeat.o(16249);
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16256);
    if (b != null)
    {
      b.setEncInfo(paramInt1, paramInt2);
      AppMethodBeat.o(16256);
      return true;
    }
    AppMethodBeat.o(16256);
    return false;
  }
  
  public boolean a(e parame)
  {
    AppMethodBeat.i(16246);
    if (b != null)
    {
      b.setRecordListener(parame);
      AppMethodBeat.o(16246);
      return true;
    }
    AppMethodBeat.o(16246);
    return false;
  }
  
  public boolean a(String paramString)
  {
    AppMethodBeat.i(16245);
    if (b != null)
    {
      b.setRecordID(paramString);
      AppMethodBeat.o(16245);
      return false;
    }
    AppMethodBeat.o(16245);
    return true;
  }
  
  public int b()
  {
    AppMethodBeat.i(16241);
    if (b != null)
    {
      int i = b.resumeRecord();
      AppMethodBeat.o(16241);
      return i;
    }
    TXCLog.e("TXCAudioEngine[TXSDK-TRAE-LOG]", "resume Record failed! Please call CreateInstance fisrt!!!!");
    AppMethodBeat.o(16241);
    return -901;
  }
  
  public int b(boolean paramBoolean)
  {
    AppMethodBeat.i(16240);
    if (b != null)
    {
      int i = b.pauseRecord(paramBoolean);
      AppMethodBeat.o(16240);
      return i;
    }
    TXCLog.e("TXCAudioEngine[TXSDK-TRAE-LOG]", "pause Record[" + paramBoolean + "] failed! Please call CreateInstance fisrt!!!!");
    AppMethodBeat.o(16240);
    return -901;
  }
  
  public void b(String paramString, float paramFloat)
  {
    AppMethodBeat.i(16267);
    if (b != null) {
      b.setAutoAdjustMaxCache(paramString, paramFloat);
    }
    AppMethodBeat.o(16267);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(16265);
    if (b != null) {
      b.enableAutoAdjustCache(paramString, paramBoolean);
    }
    AppMethodBeat.o(16265);
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(16252);
    TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "enableSoftANS: enable = " + paramBoolean + " level = " + paramInt);
    if (b != null) {
      b.enableSoftANS(paramBoolean, paramInt);
    }
    AppMethodBeat.o(16252);
  }
  
  public boolean b(float paramFloat)
  {
    AppMethodBeat.i(16255);
    TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "setPlayoutVolume: ".concat(String.valueOf(paramFloat)));
    if (b != null)
    {
      b.setPlayoutVolume(paramFloat);
      AppMethodBeat.o(16255);
      return true;
    }
    AppMethodBeat.o(16255);
    return false;
  }
  
  public boolean b(int paramInt)
  {
    AppMethodBeat.i(16254);
    if (b != null)
    {
      b.setVoiceChangerType(paramInt);
      AppMethodBeat.o(16254);
      return true;
    }
    AppMethodBeat.o(16254);
    return false;
  }
  
  public boolean b(String paramString)
  {
    AppMethodBeat.i(16259);
    if (b != null)
    {
      b.addJitterChannel(paramString);
      AppMethodBeat.o(16259);
      return true;
    }
    AppMethodBeat.o(16259);
    return false;
  }
  
  public int c()
  {
    AppMethodBeat.i(16242);
    if (b != null)
    {
      int i = b.stopRecord();
      AppMethodBeat.o(16242);
      return i;
    }
    AppMethodBeat.o(16242);
    return -1;
  }
  
  public int c(String paramString)
  {
    AppMethodBeat.i(16260);
    if (b != null)
    {
      int i = b.startJitterChannelPlay(paramString);
      AppMethodBeat.o(16260);
      return i;
    }
    TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "Please call CreateInstance fisrt!!! ");
    AppMethodBeat.o(16260);
    return -105;
  }
  
  public void c(String paramString, float paramFloat)
  {
    AppMethodBeat.i(16268);
    if (b != null) {
      b.setAutoAdjustMinCache(paramString, paramFloat);
    }
    AppMethodBeat.o(16268);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(16269);
    TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "set mute to ".concat(String.valueOf(paramBoolean)));
    if (b != null) {
      b.setPlayMute(paramString, paramBoolean);
    }
    AppMethodBeat.o(16269);
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(16247);
    TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "setIsCustomRecord: ".concat(String.valueOf(paramBoolean)));
    if (b != null) {
      b.setIsCustomRecord(paramBoolean);
    }
    AppMethodBeat.o(16247);
  }
  
  public void c(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(16253);
    TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "enableSoftAGC: enable = " + paramBoolean + " level = " + paramInt);
    if (b != null) {
      b.enableSoftAGC(paramBoolean, paramInt);
    }
    AppMethodBeat.o(16253);
  }
  
  public boolean c(float paramFloat)
  {
    AppMethodBeat.i(182288);
    if (b != null)
    {
      b.setFecRatio(paramFloat);
      AppMethodBeat.o(182288);
      return true;
    }
    AppMethodBeat.o(182288);
    return false;
  }
  
  public int d()
  {
    return 2;
  }
  
  public int d(String paramString)
  {
    AppMethodBeat.i(16261);
    if (b != null)
    {
      int i = b.stopJitterChannelPlay(paramString);
      AppMethodBeat.o(16261);
      return i;
    }
    AppMethodBeat.o(16261);
    return -101;
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(16270);
    if (b != null) {
      b.muteInSpeaker(paramString, paramBoolean);
    }
    AppMethodBeat.o(16270);
  }
  
  public boolean d(boolean paramBoolean)
  {
    AppMethodBeat.i(16248);
    TXCLog.i("TXCAudioEngine[TXSDK-TRAE-LOG]", "setRecordMute: ".concat(String.valueOf(paramBoolean)));
    if (b != null)
    {
      b.setRecordMute(paramBoolean);
      AppMethodBeat.o(16248);
      return true;
    }
    AppMethodBeat.o(16248);
    return false;
  }
  
  public int e()
  {
    AppMethodBeat.i(16258);
    if (b != null)
    {
      int i = b.getRecordVolumeLevel();
      AppMethodBeat.o(16258);
      return i;
    }
    AppMethodBeat.o(16258);
    return 0;
  }
  
  public int e(String paramString)
  {
    AppMethodBeat.i(16272);
    if (b != null)
    {
      int i = b.getJitterChannelVolumeLevel(paramString);
      AppMethodBeat.o(16272);
      return i;
    }
    AppMethodBeat.o(16272);
    return 0;
  }
  
  public boolean e(boolean paramBoolean)
  {
    AppMethodBeat.i(16257);
    if (b != null)
    {
      b.enableEosMode(paramBoolean);
      AppMethodBeat.o(16257);
      return true;
    }
    AppMethodBeat.o(16257);
    return false;
  }
  
  public int f()
  {
    return 48000;
  }
  
  public int g()
  {
    return 2;
  }
  
  public int h()
  {
    AppMethodBeat.i(16273);
    if (b != null)
    {
      int i = b.getPlayAECType();
      AppMethodBeat.o(16273);
      return i;
    }
    AppMethodBeat.o(16273);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.a
 * JD-Core Version:    0.7.0.1
 */