package com.tencent.mm.plugin.audio.c;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.audio.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "Lcom/tencent/mm/model/ISubCore;", "()V", "mAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "getMAudioManager", "()Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "setMAudioManager", "(Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;)V", "mBroadCastHelper", "Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper;", "mRequestAudioManagerQueue", "", "", "getMRequestAudioManagerQueue", "()[Ljava/lang/String;", "setMRequestAudioManagerQueue", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "requesterType", "getRequesterType", "()Ljava/lang/String;", "setRequesterType", "(Ljava/lang/String;)V", "clearPluginData", "", "p0", "", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "", "onAccountRelease", "onSdcardMount", "registerBroadcast", "unRegisterBroadcast", "Companion", "plugin-audio_release"})
public final class a
  implements bd
{
  public static final a oIh;
  public com.tencent.mm.plugin.audio.a oId;
  com.tencent.mm.plugin.audio.b.a oIe;
  String oIf;
  String[] oIg;
  
  static
  {
    AppMethodBeat.i(223979);
    oIh = new a((byte)0);
    AppMethodBeat.o(223979);
  }
  
  public a()
  {
    AppMethodBeat.i(223978);
    this.oId = new com.tencent.mm.plugin.audio.a();
    this.oIe = ((com.tencent.mm.plugin.audio.b.a)new c());
    this.oIf = "music";
    String[] arrayOfString = new String[2];
    int i = 0;
    while (i < 2)
    {
      arrayOfString[i] = "";
      i += 1;
    }
    this.oIg = arrayOfString;
    AppMethodBeat.o(223978);
  }
  
  public static final void AW(int paramInt)
  {
    AppMethodBeat.i(223993);
    a.cea().AW(paramInt);
    AppMethodBeat.o(223993);
  }
  
  public static final void AX(int paramInt)
  {
    AppMethodBeat.i(223994);
    a.cea().AX(paramInt);
    AppMethodBeat.o(223994);
  }
  
  public static final com.tencent.mm.plugin.audio.b.a agr(String paramString)
  {
    AppMethodBeat.i(223981);
    p.h(paramString, "type");
    if (p.j(a.cei().oIf, paramString))
    {
      paramString = a.cea();
      AppMethodBeat.o(223981);
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
        a.cei().oIe = locala;
        a locala1 = a.cei();
        p.h(paramString, "<set-?>");
        locala1.oIf = paramString;
        AppMethodBeat.o(223981);
        return locala;
      } while (!paramString.equals("ipcall"));
    }
    for (;;)
    {
      locala = (com.tencent.mm.plugin.audio.b.a)new com.tencent.mm.plugin.audio.b.b();
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
  
  public static final void bdY()
  {
    AppMethodBeat.i(223995);
    a.cea().audioManager.setStreamMute(3, true);
    AppMethodBeat.o(223995);
  }
  
  public static final void bdZ()
  {
    AppMethodBeat.i(223996);
    a.cea().audioManager.setStreamMute(3, false);
    AppMethodBeat.o(223996);
  }
  
  public static final void cdV()
  {
    AppMethodBeat.i(223991);
    a.cea().cdV();
    AppMethodBeat.o(223991);
  }
  
  public static final boolean cdW()
  {
    AppMethodBeat.i(223992);
    boolean bool = a.cea().cdW();
    AppMethodBeat.o(223992);
    return bool;
  }
  
  public static final int cdX()
  {
    AppMethodBeat.i(223988);
    int i = a.cea().cdX();
    AppMethodBeat.o(223988);
    return i;
  }
  
  public static final com.tencent.mm.plugin.audio.b.a cea()
  {
    AppMethodBeat.i(223980);
    com.tencent.mm.plugin.audio.b.a locala = a.cea();
    AppMethodBeat.o(223980);
    return locala;
  }
  
  public static final boolean ceb()
  {
    AppMethodBeat.i(223982);
    com.tencent.mm.plugin.audio.d.b localb = com.tencent.mm.plugin.audio.d.b.oIo;
    boolean bool = com.tencent.mm.plugin.audio.d.b.ceb();
    AppMethodBeat.o(223982);
    return bool;
  }
  
  public static final boolean cec()
  {
    AppMethodBeat.i(223983);
    boolean bool = a.cec();
    AppMethodBeat.o(223983);
    return bool;
  }
  
  public static final int ced()
  {
    AppMethodBeat.i(223989);
    com.tencent.mm.plugin.audio.b.a locala = a.cea();
    int i = locala.gCZ;
    locala.gCZ = 0;
    AppMethodBeat.o(223989);
    return i;
  }
  
  public static final boolean cee()
  {
    AppMethodBeat.i(223990);
    com.tencent.mm.plugin.audio.d.b localb = com.tencent.mm.plugin.audio.d.b.oIo;
    boolean bool = com.tencent.mm.plugin.audio.d.b.cee();
    AppMethodBeat.o(223990);
    return bool;
  }
  
  public static final boolean cef()
  {
    AppMethodBeat.i(223999);
    boolean bool = a.cea().audioManager.isStreamMute(3);
    AppMethodBeat.o(223999);
    return bool;
  }
  
  public static final void ceg()
  {
    AppMethodBeat.i(224001);
    a.cei().oId.registerBroadcasts();
    AppMethodBeat.o(224001);
  }
  
  public static final void ceh()
  {
    AppMethodBeat.i(224002);
    a.cei().oId.unRegisterBroadcasts();
    AppMethodBeat.o(224002);
  }
  
  public static final void eQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223987);
    a.cea().eQ(paramInt1, paramInt2);
    AppMethodBeat.o(223987);
  }
  
  public static final int getMode()
  {
    AppMethodBeat.i(223998);
    int i = a.getMode();
    AppMethodBeat.o(223998);
    return i;
  }
  
  public static final int getStreamMaxVolume(int paramInt)
  {
    AppMethodBeat.i(223985);
    paramInt = a.cea().getStreamMaxVolume(paramInt);
    AppMethodBeat.o(223985);
    return paramInt;
  }
  
  public static final int getStreamVolume(int paramInt)
  {
    AppMethodBeat.i(223986);
    paramInt = a.cea().getStreamVolume(paramInt);
    AppMethodBeat.o(223986);
    return paramInt;
  }
  
  public static final boolean isSpeakerphoneOn()
  {
    AppMethodBeat.i(223984);
    boolean bool = a.cea().isSpeakerphoneOn();
    AppMethodBeat.o(223984);
    return bool;
  }
  
  public static final int jv(boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(224000);
    com.tencent.mm.plugin.audio.b.a locala = a.cea();
    int j;
    int i;
    if ((locala.audioManager.isBluetoothScoOn()) || (locala.gCW))
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
      AppMethodBeat.o(224000);
      return i;
      j = 0;
      break;
      i = 0;
      break label39;
    }
  }
  
  public static final void setMode(int paramInt)
  {
    AppMethodBeat.i(223997);
    com.tencent.mm.plugin.audio.b.a.a(a.cea(), paramInt);
    AppMethodBeat.o(223997);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(223977);
    Log.i("MicroMsg.SubCoreAudio", "onAccountPostReset");
    this.oId.registerBroadcasts();
    AppMethodBeat.o(223977);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(223976);
    Log.i("MicroMsg.SubCoreAudio", "onAccountRelease");
    this.oId.unRegisterBroadcasts();
    AppMethodBeat.o(223976);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio$Companion;", "", "()V", "TAG", "", "bindBroadcast", "", "checkAndSetRequestPriority", "", "current", "request", "getAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "type", "getBluetoothScoStreamType", "", "getCore", "Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "getCurrentAudioManagerType", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "streamType", "getStreamMode", "speakerOn", "getStreamVolume", "initAudioManager", "audioManager", "isBluetoothCanUse", "isBluetoothOn", "isBluetoothScoAvailable", "isHeadsetPlugged", "isSpeakerphoneOn", "isStreamMute", "onAudioDeviceStateChanged", "status", "pauseMusic", "resetSpeaker", "resumeMusic", "setMode", "mode", "setStreamVolume", "index", "flags", "unBindBroadcast", "unInitAudioManager", "volumeDown", "volumeUp", "plugin-audio_release"})
  public static final class a
  {
    public static void a(com.tencent.mm.plugin.audio.b.a parama, String paramString)
    {
      AppMethodBeat.i(223971);
      p.h(parama, "audioManager");
      p.h(paramString, "type");
      Log.printInfoStack("MicroMsg.SubCoreAudio", "init audio manager from ".concat(String.valueOf(paramString)), new Object[0]);
      String str = (String)kotlin.a.e.Q(cei().oIg);
      if (p.j(str, ""))
      {
        cei().oIg[0] = paramString;
        cei().oIe = parama;
      }
      for (;;)
      {
        com.tencent.mm.plugin.audio.broadcast.bluetooth.a.cdS();
        AppMethodBeat.o(223971);
        return;
        if (eP(str, paramString))
        {
          Log.i("MicroMsg.SubCoreAudio", "success set the audio manager is: ".concat(String.valueOf(paramString)));
          paramString = a.oIh;
          cei().oIe = parama;
        }
        else
        {
          Log.i("MicroMsg.SubCoreAudio", "current  " + str + " is running a priority higher than request: " + paramString);
        }
      }
    }
    
    public static boolean ags(String paramString)
    {
      AppMethodBeat.i(223972);
      p.h(paramString, "type");
      if ((p.j(paramString, cei().oIg[0])) || (p.j(cei().oIg[0], "")))
      {
        AppMethodBeat.o(223972);
        return true;
      }
      AppMethodBeat.o(223972);
      return false;
    }
    
    public static void agt(String paramString)
    {
      AppMethodBeat.i(223974);
      p.h(paramString, "type");
      if (p.j(paramString, (String)kotlin.a.e.Q(cei().oIg)))
      {
        Log.i("MicroMsg.SubCoreAudio", "current do unInit audio manager and clear the queue");
        cei().oIg[0] = "";
        cei().oIe = null;
      }
      AppMethodBeat.o(223974);
    }
    
    public static com.tencent.mm.plugin.audio.b.a cea()
    {
      AppMethodBeat.i(223967);
      Object localObject2 = cei().oIe;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new c();
        localObject2 = a.oIh;
        cei().oIg[0] = "music";
        localObject1 = (com.tencent.mm.plugin.audio.b.a)localObject1;
      }
      AppMethodBeat.o(223967);
      return localObject1;
    }
    
    public static boolean cec()
    {
      AppMethodBeat.i(223968);
      boolean bool = com.tencent.mm.plugin.audio.d.b.a(cea().audioManager);
      AppMethodBeat.o(223968);
      return bool;
    }
    
    public static a cei()
    {
      AppMethodBeat.i(223966);
      Object localObject = y.at(a.class);
      p.g(localObject, "CompatSubCore.theCore(SubCoreAudio::class.java)");
      localObject = (a)localObject;
      AppMethodBeat.o(223966);
      return localObject;
    }
    
    public static String cej()
    {
      AppMethodBeat.i(223969);
      Object localObject = cea();
      int i = ((com.tencent.mm.plugin.audio.b.a)localObject).audioManager.getMode();
      localObject = new StringBuilder("mode:").append(i).append(" isSpeakerphoneOn:").append(((com.tencent.mm.plugin.audio.b.a)localObject).isSpeakerphoneOn()).append(" isBluetoothOn:");
      com.tencent.mm.plugin.audio.d.b localb = com.tencent.mm.plugin.audio.d.b.oIo;
      localObject = com.tencent.mm.plugin.audio.d.b.ceb();
      AppMethodBeat.o(223969);
      return localObject;
    }
    
    public static String cek()
    {
      AppMethodBeat.i(223973);
      String str = cei().oIg[0];
      AppMethodBeat.o(223973);
      return str;
    }
    
    private static boolean eP(String paramString1, String paramString2)
    {
      int j = 2;
      AppMethodBeat.i(223975);
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
        cei().oIg[1] = paramString2;
        AppMethodBeat.o(223975);
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
      cei().oIg[0] = paramString2;
      AppMethodBeat.o(223975);
      return true;
    }
    
    public static int getMode()
    {
      AppMethodBeat.i(223970);
      int i = cea().audioManager.getMode();
      AppMethodBeat.o(223970);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.c.a
 * JD-Core Version:    0.7.0.1
 */