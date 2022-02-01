package com.tencent.mm.plugin.audio.c;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.audio.b.b;
import com.tencent.mm.plugin.audio.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h.b;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "Lcom/tencent/mm/model/ISubCore;", "()V", "mAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "getMAudioManager", "()Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "setMAudioManager", "(Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;)V", "mBroadCastHelper", "Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper;", "mRequestAudioManagerQueue", "", "", "getMRequestAudioManagerQueue", "()[Ljava/lang/String;", "setMRequestAudioManagerQueue", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "requesterType", "getRequesterType", "()Ljava/lang/String;", "setRequesterType", "(Ljava/lang/String;)V", "clearPluginData", "", "p0", "", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "", "onAccountRelease", "onSdcardMount", "registerBroadcast", "unRegisterBroadcast", "Companion", "plugin-audio_release"})
public final class a
  implements az
{
  public static final a nxo;
  public com.tencent.mm.plugin.audio.a nxk;
  com.tencent.mm.plugin.audio.b.a nxl;
  String nxm;
  String[] nxn;
  
  static
  {
    AppMethodBeat.i(201080);
    nxo = new a((byte)0);
    AppMethodBeat.o(201080);
  }
  
  public a()
  {
    AppMethodBeat.i(201079);
    this.nxk = new com.tencent.mm.plugin.audio.a();
    this.nxl = ((com.tencent.mm.plugin.audio.b.a)new c());
    this.nxm = "music";
    String[] arrayOfString = new String[2];
    int i = 0;
    while (i < 2)
    {
      arrayOfString[i] = "";
      i += 1;
    }
    this.nxn = arrayOfString;
    AppMethodBeat.o(201079);
  }
  
  public static final com.tencent.mm.plugin.audio.b.a Ww(String paramString)
  {
    AppMethodBeat.i(201082);
    p.h(paramString, "type");
    if (p.i(a.bHG().nxm, paramString))
    {
      paramString = a.bHy();
      AppMethodBeat.o(201082);
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
        a.bHG().nxl = locala;
        a locala1 = a.bHG();
        p.h(paramString, "<set-?>");
        locala1.nxm = paramString;
        AppMethodBeat.o(201082);
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
  
  public static final void aJV()
  {
    AppMethodBeat.i(201096);
    a.bHy().audioManager.setStreamMute(3, true);
    AppMethodBeat.o(201096);
  }
  
  public static final void aJW()
  {
    AppMethodBeat.i(201097);
    a.bHy().audioManager.setStreamMute(3, false);
    AppMethodBeat.o(201097);
  }
  
  public static final boolean bHA()
  {
    AppMethodBeat.i(201084);
    boolean bool = a.bHA();
    AppMethodBeat.o(201084);
    return bool;
  }
  
  public static final int bHB()
  {
    AppMethodBeat.i(201090);
    com.tencent.mm.plugin.audio.b.a locala = a.bHy();
    int i = locala.fXT;
    locala.fXT = 0;
    AppMethodBeat.o(201090);
    return i;
  }
  
  public static final boolean bHC()
  {
    AppMethodBeat.i(201091);
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.nxr;
    boolean bool = com.tencent.mm.plugin.audio.d.a.bHC();
    AppMethodBeat.o(201091);
    return bool;
  }
  
  public static final boolean bHD()
  {
    AppMethodBeat.i(201100);
    boolean bool = a.bHy().audioManager.isStreamMute(3);
    AppMethodBeat.o(201100);
    return bool;
  }
  
  public static final void bHE()
  {
    AppMethodBeat.i(201102);
    a.bHG().nxk.registerBroadcasts();
    AppMethodBeat.o(201102);
  }
  
  public static final void bHF()
  {
    AppMethodBeat.i(201103);
    a.bHG().nxk.unRegisterBroadcasts();
    AppMethodBeat.o(201103);
  }
  
  public static final void bHs()
  {
    AppMethodBeat.i(201092);
    a.bHy().bHs();
    AppMethodBeat.o(201092);
  }
  
  public static final boolean bHt()
  {
    AppMethodBeat.i(201093);
    boolean bool = a.bHy().bHt();
    AppMethodBeat.o(201093);
    return bool;
  }
  
  public static final int bHu()
  {
    AppMethodBeat.i(201089);
    int i = a.bHy().bHu();
    AppMethodBeat.o(201089);
    return i;
  }
  
  public static final com.tencent.mm.plugin.audio.b.a bHy()
  {
    AppMethodBeat.i(201081);
    com.tencent.mm.plugin.audio.b.a locala = a.bHy();
    AppMethodBeat.o(201081);
    return locala;
  }
  
  public static final boolean bHz()
  {
    AppMethodBeat.i(201083);
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.nxr;
    boolean bool = com.tencent.mm.plugin.audio.d.a.bHz();
    AppMethodBeat.o(201083);
    return bool;
  }
  
  public static final void eD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201088);
    a.bHy().eD(paramInt1, paramInt2);
    AppMethodBeat.o(201088);
  }
  
  public static final int getMode()
  {
    AppMethodBeat.i(201099);
    int i = a.getMode();
    AppMethodBeat.o(201099);
    return i;
  }
  
  public static final int getStreamMaxVolume(int paramInt)
  {
    AppMethodBeat.i(201086);
    paramInt = a.bHy().getStreamMaxVolume(paramInt);
    AppMethodBeat.o(201086);
    return paramInt;
  }
  
  public static final int getStreamVolume(int paramInt)
  {
    AppMethodBeat.i(201087);
    paramInt = a.bHy().getStreamVolume(paramInt);
    AppMethodBeat.o(201087);
    return paramInt;
  }
  
  public static final boolean isSpeakerphoneOn()
  {
    AppMethodBeat.i(201085);
    boolean bool = a.bHy().isSpeakerphoneOn();
    AppMethodBeat.o(201085);
    return bool;
  }
  
  public static final int iv(boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(201101);
    com.tencent.mm.plugin.audio.b.a locala = a.bHy();
    int j;
    int i;
    if ((locala.audioManager.isBluetoothScoOn()) || (locala.fXQ))
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
      AppMethodBeat.o(201101);
      return i;
      j = 0;
      break;
      i = 0;
      break label39;
    }
  }
  
  public static final void setMode(int paramInt)
  {
    AppMethodBeat.i(201098);
    com.tencent.mm.plugin.audio.b.a.a(a.bHy(), paramInt);
    AppMethodBeat.o(201098);
  }
  
  public static final void xq(int paramInt)
  {
    AppMethodBeat.i(201094);
    a.bHy().xq(paramInt);
    AppMethodBeat.o(201094);
  }
  
  public static final void xr(int paramInt)
  {
    AppMethodBeat.i(201095);
    a.bHy().xr(paramInt);
    AppMethodBeat.o(201095);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(201078);
    ae.i("MicroMsg.SubCoreAudio", "onAccountPostReset");
    this.nxk.registerBroadcasts();
    AppMethodBeat.o(201078);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(201077);
    ae.i("MicroMsg.SubCoreAudio", "onAccountRelease");
    this.nxk.unRegisterBroadcasts();
    AppMethodBeat.o(201077);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio$Companion;", "", "()V", "TAG", "", "bindBroadcast", "", "checkAndSetRequestPriority", "", "current", "request", "getAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "type", "getBluetoothScoStreamType", "", "getCore", "Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "getCurrentAudioManagerType", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "streamType", "getStreamMode", "speakerOn", "getStreamVolume", "initAudioManager", "audioManager", "isBluetoothCanUse", "isBluetoothOn", "isBluetoothScoAvailable", "isHeadsetPlugged", "isSpeakerphoneOn", "isStreamMute", "onAudioDeviceStateChanged", "status", "pauseMusic", "resetSpeaker", "resumeMusic", "setMode", "mode", "setStreamVolume", "index", "flags", "unBindBroadcast", "unInitAudioManager", "volumeDown", "volumeUp", "plugin-audio_release"})
  public static final class a
  {
    public static boolean Wx(String paramString)
    {
      AppMethodBeat.i(201074);
      p.h(paramString, "type");
      if ((p.i(paramString, bHG().nxn[0])) || (p.i(bHG().nxn[0], "")))
      {
        AppMethodBeat.o(201074);
        return true;
      }
      AppMethodBeat.o(201074);
      return false;
    }
    
    public static void Wy(String paramString)
    {
      AppMethodBeat.i(201075);
      p.h(paramString, "type");
      if (p.i(paramString, (String)d.a.e.P(bHG().nxn)))
      {
        ae.i("MicroMsg.SubCoreAudio", "current do unInit audio manager and clear the queue");
        bHG().nxn[0] = "";
        bHG().nxl = null;
      }
      AppMethodBeat.o(201075);
    }
    
    public static void a(com.tencent.mm.plugin.audio.b.a parama, String paramString)
    {
      AppMethodBeat.i(201073);
      p.h(parama, "audioManager");
      p.h(paramString, "type");
      ae.m("MicroMsg.SubCoreAudio", "init audio manager from ".concat(String.valueOf(paramString)), new Object[0]);
      String str = (String)d.a.e.P(bHG().nxn);
      if (p.i(str, ""))
      {
        bHG().nxn[0] = paramString;
        bHG().nxl = parama;
        AppMethodBeat.o(201073);
        return;
      }
      if (ex(str, paramString))
      {
        ae.i("MicroMsg.SubCoreAudio", "success set the audio manager is: ".concat(String.valueOf(paramString)));
        paramString = a.nxo;
        bHG().nxl = parama;
        AppMethodBeat.o(201073);
        return;
      }
      ae.i("MicroMsg.SubCoreAudio", "current is running a priority higher than request: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(201073);
    }
    
    public static boolean bHA()
    {
      AppMethodBeat.i(201071);
      boolean bool = com.tencent.mm.plugin.audio.d.a.a(bHy().audioManager);
      AppMethodBeat.o(201071);
      return bool;
    }
    
    public static a bHG()
    {
      AppMethodBeat.i(201069);
      Object localObject = u.ap(a.class);
      p.g(localObject, "CompatSubCore.theCore(SubCoreAudio::class.java)");
      localObject = (a)localObject;
      AppMethodBeat.o(201069);
      return localObject;
    }
    
    public static com.tencent.mm.plugin.audio.b.a bHy()
    {
      AppMethodBeat.i(201070);
      Object localObject2 = bHG().nxl;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new c();
        localObject2 = a.nxo;
        bHG().nxn[0] = "music";
        localObject1 = (com.tencent.mm.plugin.audio.b.a)localObject1;
      }
      AppMethodBeat.o(201070);
      return localObject1;
    }
    
    private static boolean ex(String paramString1, String paramString2)
    {
      int j = 2;
      AppMethodBeat.i(201076);
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
        bHG().nxn[1] = paramString2;
        AppMethodBeat.o(201076);
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
      bHG().nxn[0] = paramString2;
      AppMethodBeat.o(201076);
      return true;
    }
    
    public static int getMode()
    {
      AppMethodBeat.i(201072);
      int i = bHy().audioManager.getMode();
      AppMethodBeat.o(201072);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.c.a
 * JD-Core Version:    0.7.0.1
 */