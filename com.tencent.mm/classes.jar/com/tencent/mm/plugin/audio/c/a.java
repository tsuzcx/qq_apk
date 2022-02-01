package com.tencent.mm.plugin.audio.c;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.audio.b.b;
import com.tencent.mm.plugin.audio.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "Lcom/tencent/mm/model/ISubCore;", "()V", "mAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "getMAudioManager", "()Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "setMAudioManager", "(Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;)V", "mBroadCastHelper", "Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper;", "mRequestAudioManagerQueue", "", "", "getMRequestAudioManagerQueue", "()[Ljava/lang/String;", "setMRequestAudioManagerQueue", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "requesterType", "getRequesterType", "()Ljava/lang/String;", "setRequesterType", "(Ljava/lang/String;)V", "clearPluginData", "", "p0", "", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "", "onAccountRelease", "onSdcardMount", "registerBroadcast", "unRegisterBroadcast", "Companion", "plugin-audio_release"})
public final class a
  implements ax
{
  public static final a nrV;
  public com.tencent.mm.plugin.audio.a nrR;
  com.tencent.mm.plugin.audio.b.a nrS;
  String nrT;
  String[] nrU;
  
  static
  {
    AppMethodBeat.i(199768);
    nrV = new a((byte)0);
    AppMethodBeat.o(199768);
  }
  
  public a()
  {
    AppMethodBeat.i(199767);
    this.nrR = new com.tencent.mm.plugin.audio.a();
    this.nrS = ((com.tencent.mm.plugin.audio.b.a)new c());
    this.nrT = "music";
    String[] arrayOfString = new String[2];
    int i = 0;
    while (i < 2)
    {
      arrayOfString[i] = "";
      i += 1;
    }
    this.nrU = arrayOfString;
    AppMethodBeat.o(199767);
  }
  
  public static final com.tencent.mm.plugin.audio.b.a VK(String paramString)
  {
    AppMethodBeat.i(199770);
    p.h(paramString, "type");
    if (p.i(a.bGK().nrT, paramString))
    {
      paramString = a.bGC();
      AppMethodBeat.o(199770);
      return paramString;
    }
    com.tencent.mm.plugin.audio.b.a locala;
    switch (paramString.hashCode())
    {
    default: 
    case -1182426107: 
      label91:
      do
      {
        locala = (com.tencent.mm.plugin.audio.b.a)new c();
        a.bGK().nrS = locala;
        a locala1 = a.bGK();
        p.h(paramString, "<set-?>");
        locala1.nrT = paramString;
        AppMethodBeat.o(199770);
        return locala;
      } while (!paramString.equals("ipcall"));
    }
    for (;;)
    {
      locala = (com.tencent.mm.plugin.audio.b.a)new b();
      break label91;
      if (!paramString.equals("voip")) {
        break;
      }
      for (;;)
      {
        locala = (com.tencent.mm.plugin.audio.b.a)new com.tencent.mm.plugin.audio.b.e();
        break label91;
        if (!paramString.equals("voipcs")) {
          break;
        }
      }
      if (!paramString.equals("multitalke")) {
        break;
      }
    }
  }
  
  public static final void aJC()
  {
    AppMethodBeat.i(199784);
    a.bGC().audioManager.setStreamMute(3, true);
    AppMethodBeat.o(199784);
  }
  
  public static final void aJD()
  {
    AppMethodBeat.i(199785);
    a.bGC().audioManager.setStreamMute(3, false);
    AppMethodBeat.o(199785);
  }
  
  public static final com.tencent.mm.plugin.audio.b.a bGC()
  {
    AppMethodBeat.i(199769);
    com.tencent.mm.plugin.audio.b.a locala = a.bGC();
    AppMethodBeat.o(199769);
    return locala;
  }
  
  public static final boolean bGD()
  {
    AppMethodBeat.i(199771);
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.nrY;
    boolean bool = com.tencent.mm.plugin.audio.d.a.bGD();
    AppMethodBeat.o(199771);
    return bool;
  }
  
  public static final boolean bGE()
  {
    AppMethodBeat.i(199772);
    boolean bool = a.bGE();
    AppMethodBeat.o(199772);
    return bool;
  }
  
  public static final int bGF()
  {
    AppMethodBeat.i(199778);
    com.tencent.mm.plugin.audio.b.a locala = a.bGC();
    int i = locala.fVN;
    locala.fVN = 0;
    AppMethodBeat.o(199778);
    return i;
  }
  
  public static final boolean bGG()
  {
    AppMethodBeat.i(199779);
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.nrY;
    boolean bool = com.tencent.mm.plugin.audio.d.a.bGG();
    AppMethodBeat.o(199779);
    return bool;
  }
  
  public static final boolean bGH()
  {
    AppMethodBeat.i(199788);
    boolean bool = a.bGC().audioManager.isStreamMute(3);
    AppMethodBeat.o(199788);
    return bool;
  }
  
  public static final void bGI()
  {
    AppMethodBeat.i(199790);
    a.bGK().nrR.registerBroadcasts();
    AppMethodBeat.o(199790);
  }
  
  public static final void bGJ()
  {
    AppMethodBeat.i(199791);
    a.bGK().nrR.unRegisterBroadcasts();
    AppMethodBeat.o(199791);
  }
  
  public static final void bGw()
  {
    AppMethodBeat.i(199780);
    a.bGC().bGw();
    AppMethodBeat.o(199780);
  }
  
  public static final boolean bGx()
  {
    AppMethodBeat.i(199781);
    boolean bool = a.bGC().bGx();
    AppMethodBeat.o(199781);
    return bool;
  }
  
  public static final int bGy()
  {
    AppMethodBeat.i(199777);
    int i = a.bGC().bGy();
    AppMethodBeat.o(199777);
    return i;
  }
  
  public static final void eD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199776);
    a.bGC().eD(paramInt1, paramInt2);
    AppMethodBeat.o(199776);
  }
  
  public static final int getMode()
  {
    AppMethodBeat.i(199787);
    int i = a.getMode();
    AppMethodBeat.o(199787);
    return i;
  }
  
  public static final int getStreamMaxVolume(int paramInt)
  {
    AppMethodBeat.i(199774);
    paramInt = a.bGC().getStreamMaxVolume(paramInt);
    AppMethodBeat.o(199774);
    return paramInt;
  }
  
  public static final int getStreamVolume(int paramInt)
  {
    AppMethodBeat.i(199775);
    paramInt = a.bGC().getStreamVolume(paramInt);
    AppMethodBeat.o(199775);
    return paramInt;
  }
  
  public static final boolean isSpeakerphoneOn()
  {
    AppMethodBeat.i(199773);
    boolean bool = a.bGC().isSpeakerphoneOn();
    AppMethodBeat.o(199773);
    return bool;
  }
  
  public static final int ix(boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(199789);
    com.tencent.mm.plugin.audio.b.a locala = a.bGC();
    int j;
    int i;
    if ((locala.audioManager.isBluetoothScoOn()) || (locala.fVK))
    {
      j = 1;
      if (!paramBoolean) {
        break label57;
      }
      i = 3;
      label39:
      if (j == 0) {
        break label62;
      }
      i = k;
    }
    label57:
    label62:
    for (;;)
    {
      AppMethodBeat.o(199789);
      return i;
      j = 0;
      break;
      i = 0;
      break label39;
    }
  }
  
  public static final void setMode(int paramInt)
  {
    AppMethodBeat.i(199786);
    com.tencent.mm.plugin.audio.b.a.a(a.bGC(), paramInt);
    AppMethodBeat.o(199786);
  }
  
  public static final void xl(int paramInt)
  {
    AppMethodBeat.i(199782);
    a.bGC().xl(paramInt);
    AppMethodBeat.o(199782);
  }
  
  public static final void xm(int paramInt)
  {
    AppMethodBeat.i(199783);
    a.bGC().xm(paramInt);
    AppMethodBeat.o(199783);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(199766);
    ad.i("MicroMsg.SubCoreAudio", "onAccountPostReset");
    this.nrR.registerBroadcasts();
    AppMethodBeat.o(199766);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(199765);
    ad.i("MicroMsg.SubCoreAudio", "onAccountRelease");
    this.nrR.unRegisterBroadcasts();
    AppMethodBeat.o(199765);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio$Companion;", "", "()V", "TAG", "", "bindBroadcast", "", "checkAndSetRequestPriority", "", "current", "request", "getAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "type", "getBluetoothScoStreamType", "", "getCore", "Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "getCurrentAudioManagerType", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "streamType", "getStreamMode", "speakerOn", "getStreamVolume", "initAudioManager", "audioManager", "isBluetoothCanUse", "isBluetoothOn", "isBluetoothScoAvailable", "isHeadsetPlugged", "isSpeakerphoneOn", "isStreamMute", "onAudioDeviceStateChanged", "status", "pauseMusic", "resetSpeaker", "resumeMusic", "setMode", "mode", "setStreamVolume", "index", "flags", "unBindBroadcast", "unInitAudioManager", "volumeDown", "volumeUp", "plugin-audio_release"})
  public static final class a
  {
    public static boolean VL(String paramString)
    {
      AppMethodBeat.i(199762);
      p.h(paramString, "type");
      if ((p.i(paramString, bGK().nrU[0])) || (p.i(bGK().nrU[0], "")))
      {
        AppMethodBeat.o(199762);
        return true;
      }
      AppMethodBeat.o(199762);
      return false;
    }
    
    public static void VM(String paramString)
    {
      AppMethodBeat.i(199763);
      p.h(paramString, "type");
      if (p.i(paramString, (String)d.a.e.Q(bGK().nrU)))
      {
        ad.i("MicroMsg.SubCoreAudio", "current do unInit audio manager and clear the queue");
        bGK().nrU[0] = "";
        bGK().nrS = null;
      }
      AppMethodBeat.o(199763);
    }
    
    public static void a(com.tencent.mm.plugin.audio.b.a parama, String paramString)
    {
      AppMethodBeat.i(199761);
      p.h(parama, "audioManager");
      p.h(paramString, "type");
      ad.m("MicroMsg.SubCoreAudio", "init audio manager from ".concat(String.valueOf(paramString)), new Object[0]);
      String str = (String)d.a.e.Q(bGK().nrU);
      if (p.i(str, ""))
      {
        bGK().nrU[0] = paramString;
        bGK().nrS = parama;
        AppMethodBeat.o(199761);
        return;
      }
      if (eu(str, paramString))
      {
        ad.i("MicroMsg.SubCoreAudio", "success set the audio manager is: ".concat(String.valueOf(paramString)));
        paramString = a.nrV;
        bGK().nrS = parama;
        AppMethodBeat.o(199761);
        return;
      }
      ad.i("MicroMsg.SubCoreAudio", "current is running a priority higher than request: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(199761);
    }
    
    public static com.tencent.mm.plugin.audio.b.a bGC()
    {
      AppMethodBeat.i(199758);
      Object localObject2 = bGK().nrS;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new c();
        localObject2 = a.nrV;
        bGK().nrU[0] = "music";
        localObject1 = (com.tencent.mm.plugin.audio.b.a)localObject1;
      }
      AppMethodBeat.o(199758);
      return localObject1;
    }
    
    public static boolean bGE()
    {
      AppMethodBeat.i(199759);
      boolean bool = com.tencent.mm.plugin.audio.d.a.a(bGC().audioManager);
      AppMethodBeat.o(199759);
      return bool;
    }
    
    public static a bGK()
    {
      AppMethodBeat.i(199757);
      Object localObject = t.ap(a.class);
      p.g(localObject, "CompatSubCore.theCore(SubCoreAudio::class.java)");
      localObject = (a)localObject;
      AppMethodBeat.o(199757);
      return localObject;
    }
    
    private static boolean eu(String paramString1, String paramString2)
    {
      int j = 2;
      AppMethodBeat.i(199764);
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
        bGK().nrU[1] = paramString2;
        AppMethodBeat.o(199764);
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
      bGK().nrU[0] = paramString2;
      AppMethodBeat.o(199764);
      return true;
    }
    
    public static int getMode()
    {
      AppMethodBeat.i(199760);
      int i = bGC().audioManager.getMode();
      AppMethodBeat.o(199760);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.c.a
 * JD-Core Version:    0.7.0.1
 */