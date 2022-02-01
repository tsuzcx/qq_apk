package com.tencent.mm.plugin.audio.c;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.audio.b.b;
import com.tencent.mm.plugin.audio.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h.b;
import d.g.b.k;
import d.l;
import java.util.HashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "Lcom/tencent/mm/model/ISubCore;", "()V", "mAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "getMAudioManager", "()Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "setMAudioManager", "(Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;)V", "mBroadCastHelper", "Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper;", "mRequestAudioManagerQueue", "", "", "getMRequestAudioManagerQueue", "()[Ljava/lang/String;", "setMRequestAudioManagerQueue", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "requesterType", "getRequesterType", "()Ljava/lang/String;", "setRequesterType", "(Ljava/lang/String;)V", "clearPluginData", "", "p0", "", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "", "onAccountRelease", "onSdcardMount", "registerBroadcast", "unRegisterBroadcast", "Companion", "plugin-audio_release"})
public final class a
  implements aw
{
  public static final a mRw;
  public com.tencent.mm.plugin.audio.a mRs;
  com.tencent.mm.plugin.audio.b.a mRt;
  String mRu;
  String[] mRv;
  
  static
  {
    AppMethodBeat.i(198369);
    mRw = new a((byte)0);
    AppMethodBeat.o(198369);
  }
  
  public a()
  {
    AppMethodBeat.i(198368);
    this.mRs = new com.tencent.mm.plugin.audio.a();
    this.mRt = ((com.tencent.mm.plugin.audio.b.a)new c());
    this.mRu = "music";
    String[] arrayOfString = new String[2];
    int i = 0;
    while (i < 2)
    {
      arrayOfString[i] = "";
      i += 1;
    }
    this.mRv = arrayOfString;
    AppMethodBeat.o(198368);
  }
  
  public static final com.tencent.mm.plugin.audio.b.a Sm(String paramString)
  {
    AppMethodBeat.i(198371);
    k.h(paramString, "type");
    if (k.g(a.bCC().mRu, paramString))
    {
      paramString = a.bCx();
      AppMethodBeat.o(198371);
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
        a.bCC().mRt = locala;
        a locala1 = a.bCC();
        k.h(paramString, "<set-?>");
        locala1.mRu = paramString;
        AppMethodBeat.o(198371);
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
  
  public static final void aGr()
  {
    AppMethodBeat.i(198384);
    a.bCx().audioManager.setStreamMute(3, true);
    AppMethodBeat.o(198384);
  }
  
  public static final void aGs()
  {
    AppMethodBeat.i(198385);
    a.bCx().audioManager.setStreamMute(3, false);
    AppMethodBeat.o(198385);
  }
  
  public static final void bAf()
  {
    AppMethodBeat.i(210320);
    a.bCC().mRs.registerBroadcasts();
    AppMethodBeat.o(210320);
  }
  
  public static final void bAg()
  {
    AppMethodBeat.i(210321);
    a.bCC().mRs.unRegisterBroadcasts();
    AppMethodBeat.o(210321);
  }
  
  public static final boolean bCA()
  {
    AppMethodBeat.i(198379);
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.mRz;
    boolean bool = com.tencent.mm.plugin.audio.d.a.bCA();
    AppMethodBeat.o(198379);
    return bool;
  }
  
  public static final boolean bCB()
  {
    AppMethodBeat.i(198388);
    boolean bool = a.bCx().audioManager.isStreamMute(3);
    AppMethodBeat.o(198388);
    return bool;
  }
  
  public static final void bCr()
  {
    AppMethodBeat.i(198380);
    a.bCx().bCr();
    AppMethodBeat.o(198380);
  }
  
  public static final boolean bCs()
  {
    AppMethodBeat.i(198381);
    boolean bool = a.bCx().bCs();
    AppMethodBeat.o(198381);
    return bool;
  }
  
  public static final int bCt()
  {
    AppMethodBeat.i(198377);
    int i = a.bCx().bCt();
    AppMethodBeat.o(198377);
    return i;
  }
  
  public static final com.tencent.mm.plugin.audio.b.a bCx()
  {
    AppMethodBeat.i(198370);
    com.tencent.mm.plugin.audio.b.a locala = a.bCx();
    AppMethodBeat.o(198370);
    return locala;
  }
  
  public static final boolean bCy()
  {
    AppMethodBeat.i(198372);
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.mRz;
    boolean bool = com.tencent.mm.plugin.audio.d.a.bCy();
    AppMethodBeat.o(198372);
    return bool;
  }
  
  public static final int bCz()
  {
    AppMethodBeat.i(198378);
    com.tencent.mm.plugin.audio.b.a locala = a.bCx();
    int i = locala.fCz;
    locala.fCz = 0;
    AppMethodBeat.o(198378);
    return i;
  }
  
  public static final void eA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198376);
    a.bCx().eA(paramInt1, paramInt2);
    AppMethodBeat.o(198376);
  }
  
  public static final int getMode()
  {
    AppMethodBeat.i(198387);
    int i = a.getMode();
    AppMethodBeat.o(198387);
    return i;
  }
  
  public static final int getStreamMaxVolume(int paramInt)
  {
    AppMethodBeat.i(198374);
    paramInt = a.bCx().getStreamMaxVolume(paramInt);
    AppMethodBeat.o(198374);
    return paramInt;
  }
  
  public static final int getStreamVolume(int paramInt)
  {
    AppMethodBeat.i(198375);
    paramInt = a.bCx().getStreamVolume(paramInt);
    AppMethodBeat.o(198375);
    return paramInt;
  }
  
  public static final int io(boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(198389);
    com.tencent.mm.plugin.audio.b.a locala = a.bCx();
    int j;
    int i;
    if ((locala.audioManager.isBluetoothScoOn()) || (locala.fCw))
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
      AppMethodBeat.o(198389);
      return i;
      j = 0;
      break;
      i = 0;
      break label39;
    }
  }
  
  public static final boolean isSpeakerphoneOn()
  {
    AppMethodBeat.i(198373);
    boolean bool = a.bCx().isSpeakerphoneOn();
    AppMethodBeat.o(198373);
    return bool;
  }
  
  public static final void setMode(int paramInt)
  {
    AppMethodBeat.i(198386);
    com.tencent.mm.plugin.audio.b.a.a(a.bCx(), paramInt);
    AppMethodBeat.o(198386);
  }
  
  public static final void wF(int paramInt)
  {
    AppMethodBeat.i(198382);
    a.bCx().wF(paramInt);
    AppMethodBeat.o(198382);
  }
  
  public static final void wG(int paramInt)
  {
    AppMethodBeat.i(198383);
    a.bCx().wG(paramInt);
    AppMethodBeat.o(198383);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(198367);
    ac.i("MicroMsg.SubCoreAudio", "onAccountPostReset");
    this.mRs.registerBroadcasts();
    AppMethodBeat.o(198367);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(198366);
    ac.i("MicroMsg.SubCoreAudio", "onAccountRelease");
    this.mRs.unRegisterBroadcasts();
    AppMethodBeat.o(198366);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio$Companion;", "", "()V", "TAG", "", "bindBroadcast", "", "checkAndSetRequestPriority", "", "current", "request", "getAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "type", "getBluetoothScoStreamType", "", "getCore", "Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "getCurrentAudioManagerType", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "streamType", "getStreamMode", "speakerOn", "getStreamVolume", "initAudioManager", "audioManager", "isBluetoothCanUse", "isBluetoothOn", "isHeadsetPlugged", "isSpeakerphoneOn", "isStreamMute", "onAudioDeviceStateChanged", "status", "pauseMusic", "resetSpeaker", "resumeMusic", "setMode", "mode", "setStreamVolume", "index", "flags", "unBindBroadcast", "unInitAudioManager", "volumeDown", "volumeUp", "plugin-audio_release"})
  public static final class a
  {
    public static boolean Sn(String paramString)
    {
      AppMethodBeat.i(198363);
      k.h(paramString, "type");
      if ((k.g(paramString, bCC().mRv[0])) || (k.g(bCC().mRv[0], "")))
      {
        AppMethodBeat.o(198363);
        return true;
      }
      AppMethodBeat.o(198363);
      return false;
    }
    
    public static void So(String paramString)
    {
      AppMethodBeat.i(198364);
      k.h(paramString, "type");
      if (k.g(paramString, (String)d.a.e.P(bCC().mRv)))
      {
        ac.i("MicroMsg.SubCoreAudio", "current do unInit audio manager and clear the queue");
        bCC().mRv[0] = "";
        bCC().mRt = null;
      }
      AppMethodBeat.o(198364);
    }
    
    public static void a(com.tencent.mm.plugin.audio.b.a parama, String paramString)
    {
      AppMethodBeat.i(198362);
      k.h(parama, "audioManager");
      k.h(paramString, "type");
      ac.m("MicroMsg.SubCoreAudio", "init audio manager from ".concat(String.valueOf(paramString)), new Object[0]);
      String str = (String)d.a.e.P(bCC().mRv);
      if (k.g(str, ""))
      {
        bCC().mRv[0] = paramString;
        bCC().mRt = parama;
        AppMethodBeat.o(198362);
        return;
      }
      if (el(str, paramString))
      {
        ac.i("MicroMsg.SubCoreAudio", "success set the audio manager is: ".concat(String.valueOf(paramString)));
        paramString = a.mRw;
        bCC().mRt = parama;
        AppMethodBeat.o(198362);
        return;
      }
      ac.i("MicroMsg.SubCoreAudio", "current is running a priority higher than request: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(198362);
    }
    
    public static a bCC()
    {
      AppMethodBeat.i(198359);
      Object localObject = t.ap(a.class);
      k.g(localObject, "CompatSubCore.theCore(SubCoreAudio::class.java)");
      localObject = (a)localObject;
      AppMethodBeat.o(198359);
      return localObject;
    }
    
    public static com.tencent.mm.plugin.audio.b.a bCx()
    {
      AppMethodBeat.i(198360);
      Object localObject2 = bCC().mRt;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new c();
        localObject2 = a.mRw;
        bCC().mRv[0] = "music";
        localObject1 = (com.tencent.mm.plugin.audio.b.a)localObject1;
      }
      AppMethodBeat.o(198360);
      return localObject1;
    }
    
    private static boolean el(String paramString1, String paramString2)
    {
      int j = 2;
      AppMethodBeat.i(198365);
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
        bCC().mRv[1] = paramString2;
        AppMethodBeat.o(198365);
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
      bCC().mRv[0] = paramString2;
      AppMethodBeat.o(198365);
      return true;
    }
    
    public static int getMode()
    {
      AppMethodBeat.i(198361);
      int i = bCx().audioManager.getMode();
      AppMethodBeat.o(198361);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.c.a
 * JD-Core Version:    0.7.0.1
 */