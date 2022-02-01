package com.tencent.mm.plugin.audio.c;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.audio.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.e;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio$Companion;", "", "()V", "TAG", "", "checkAndSetRequestPriority", "", "current", "request", "getAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "type", "getBluetoothScoStreamType", "", "getCore", "Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "getCurrentAudioManagerType", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "streamType", "getStreamMode", "speakerOn", "getStreamVolume", "initAudioManager", "", "audioManager", "isBluetoothCanUse", "isBluetoothOn", "isHeadsetPlugged", "isSpeakerphoneOn", "isStreamMute", "onAudioDeviceStateChanged", "status", "pauseMusic", "resetSpeaker", "resumeMusic", "setMode", "mode", "setStreamVolume", "index", "flags", "unInitAudioManager", "volumeDown", "volumeUp", "plugin-audio_release"})
public final class a$a
{
  public static void Oe(String paramString)
  {
    AppMethodBeat.i(189241);
    k.h(paramString, "type");
    if (k.g(paramString, (String)e.N(bvG().mpu)))
    {
      ad.i("MicroMsg.SubCoreAudio", "current do unInit audio manager and clear the queue");
      bvG().mpu[0] = "";
      bvG().mps = null;
    }
    AppMethodBeat.o(189241);
  }
  
  public static void a(com.tencent.mm.plugin.audio.b.a parama, String paramString)
  {
    AppMethodBeat.i(189240);
    k.h(parama, "audioManager");
    k.h(paramString, "type");
    ad.m("MicroMsg.SubCoreAudio", "init audio manager from ".concat(String.valueOf(paramString)), new Object[0]);
    String str = (String)e.N(bvG().mpu);
    if (k.g(str, ""))
    {
      bvG().mpu[0] = paramString;
      bvG().mps = parama;
      AppMethodBeat.o(189240);
      return;
    }
    if (dZ(str, paramString))
    {
      ad.i("MicroMsg.SubCoreAudio", "success set the audio manager is: ".concat(String.valueOf(paramString)));
      paramString = a.mpv;
      bvG().mps = parama;
      AppMethodBeat.o(189240);
      return;
    }
    ad.i("MicroMsg.SubCoreAudio", "current is running a priority higher than request: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(189240);
  }
  
  public static com.tencent.mm.plugin.audio.b.a bvB()
  {
    AppMethodBeat.i(189238);
    Object localObject2 = bvG().mps;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new c();
      localObject2 = a.mpv;
      bvG().mpu[0] = "music";
      localObject1 = (com.tencent.mm.plugin.audio.b.a)localObject1;
    }
    AppMethodBeat.o(189238);
    return localObject1;
  }
  
  public static a bvG()
  {
    AppMethodBeat.i(189237);
    Object localObject = t.ap(a.class);
    k.g(localObject, "CompatSubCore.theCore(SubCoreAudio::class.java)");
    localObject = (a)localObject;
    AppMethodBeat.o(189237);
    return localObject;
  }
  
  private static boolean dZ(String paramString1, String paramString2)
  {
    int j = 2;
    AppMethodBeat.i(189242);
    int i;
    switch (paramString1.hashCode())
    {
    default: 
      i = 1;
      label54:
      switch (paramString2.hashCode())
      {
      default: 
        label100:
        j = 1;
      }
      break;
    }
    for (;;)
    {
      if (i <= j) {
        break label221;
      }
      bvG().mpu[1] = paramString2;
      AppMethodBeat.o(189242);
      return false;
      if (!paramString1.equals("ipcall")) {
        break;
      }
      for (;;)
      {
        i = 2;
        break label54;
        if (!paramString1.equals("voip")) {
          break;
        }
        continue;
        if (!paramString1.equals("voipcs")) {
          break;
        }
        continue;
        if (!paramString1.equals("multitalke")) {
          break;
        }
      }
      if (!paramString2.equals("ipcall")) {
        break label100;
      }
      continue;
      if (!paramString2.equals("voip")) {
        break label100;
      }
      continue;
      if (!paramString2.equals("voipcs")) {
        break label100;
      }
      continue;
      if (!paramString2.equals("multitalke")) {
        break label100;
      }
    }
    label221:
    bvG().mpu[0] = paramString2;
    AppMethodBeat.o(189242);
    return true;
  }
  
  public static int getMode()
  {
    AppMethodBeat.i(189239);
    int i = bvB().audioManager.getMode();
    AppMethodBeat.o(189239);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.c.a.a
 * JD-Core Version:    0.7.0.1
 */