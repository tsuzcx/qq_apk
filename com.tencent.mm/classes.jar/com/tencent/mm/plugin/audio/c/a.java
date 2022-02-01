package com.tencent.mm.plugin.audio.c;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.audio.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "Lcom/tencent/mm/model/ISubCore;", "()V", "mAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "getMAudioManager", "()Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "setMAudioManager", "(Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;)V", "mBroadCastHelper", "Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper;", "mRequestAudioManagerQueue", "", "", "getMRequestAudioManagerQueue", "()[Ljava/lang/String;", "setMRequestAudioManagerQueue", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "requesterType", "getRequesterType", "()Ljava/lang/String;", "setRequesterType", "(Ljava/lang/String;)V", "clearPluginData", "", "p0", "", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "", "onAccountRelease", "onSdcardMount", "registerBroadcast", "unRegisterBroadcast", "Companion", "plugin-audio_release"})
public final class a
  implements be
{
  public static final a rJX;
  public com.tencent.mm.plugin.audio.a rJT;
  com.tencent.mm.plugin.audio.b.a rJU;
  String rJV;
  String[] rJW;
  
  static
  {
    AppMethodBeat.i(257712);
    rJX = new a((byte)0);
    AppMethodBeat.o(257712);
  }
  
  public a()
  {
    AppMethodBeat.i(257711);
    this.rJT = new com.tencent.mm.plugin.audio.a();
    this.rJU = ((com.tencent.mm.plugin.audio.b.a)new c());
    this.rJV = "music";
    String[] arrayOfString = new String[2];
    int i = 0;
    while (i < 2)
    {
      arrayOfString[i] = "";
      i += 1;
    }
    this.rJW = arrayOfString;
    AppMethodBeat.o(257711);
  }
  
  public static final void Ex(int paramInt)
  {
    AppMethodBeat.i(257728);
    a.crn().Ex(paramInt);
    AppMethodBeat.o(257728);
  }
  
  public static final void Ey(int paramInt)
  {
    AppMethodBeat.i(257729);
    a.crn().Ey(paramInt);
    AppMethodBeat.o(257729);
  }
  
  public static final com.tencent.mm.plugin.audio.b.a anV(String paramString)
  {
    AppMethodBeat.i(257714);
    p.k(paramString, "type");
    if (p.h(a.crv().rJV, paramString))
    {
      paramString = a.crn();
      AppMethodBeat.o(257714);
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
        a.crv().rJU = locala;
        a locala1 = a.crv();
        p.k(paramString, "<set-?>");
        locala1.rJV = paramString;
        AppMethodBeat.o(257714);
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
  
  public static final void bnt()
  {
    AppMethodBeat.i(257730);
    a.crn().audioManager.setStreamMute(3, true);
    AppMethodBeat.o(257730);
  }
  
  public static final void bnu()
  {
    AppMethodBeat.i(257731);
    a.crn().audioManager.setStreamMute(3, false);
    AppMethodBeat.o(257731);
  }
  
  public static final void crg()
  {
    AppMethodBeat.i(257725);
    a.crn().crg();
    AppMethodBeat.o(257725);
  }
  
  public static final boolean crh()
  {
    AppMethodBeat.i(257726);
    boolean bool = a.crn().crh();
    AppMethodBeat.o(257726);
    return bool;
  }
  
  public static final int cri()
  {
    AppMethodBeat.i(257722);
    int i = a.crn().cri();
    AppMethodBeat.o(257722);
    return i;
  }
  
  public static final boolean crl()
  {
    AppMethodBeat.i(257718);
    boolean bool = a.crn().crl();
    AppMethodBeat.o(257718);
    return bool;
  }
  
  public static final com.tencent.mm.plugin.audio.b.a crn()
  {
    AppMethodBeat.i(257713);
    com.tencent.mm.plugin.audio.b.a locala = a.crn();
    AppMethodBeat.o(257713);
    return locala;
  }
  
  public static final boolean cro()
  {
    AppMethodBeat.i(257716);
    com.tencent.mm.plugin.audio.d.b localb = com.tencent.mm.plugin.audio.d.b.rKe;
    boolean bool = com.tencent.mm.plugin.audio.d.b.cro();
    AppMethodBeat.o(257716);
    return bool;
  }
  
  public static final boolean crp()
  {
    AppMethodBeat.i(257717);
    boolean bool = a.crp();
    AppMethodBeat.o(257717);
    return bool;
  }
  
  public static final int crq()
  {
    AppMethodBeat.i(257723);
    com.tencent.mm.plugin.audio.b.a locala = a.crn();
    int i = locala.jnf;
    locala.jnf = 0;
    AppMethodBeat.o(257723);
    return i;
  }
  
  public static final boolean crr()
  {
    AppMethodBeat.i(257724);
    com.tencent.mm.plugin.audio.d.b localb = com.tencent.mm.plugin.audio.d.b.rKe;
    boolean bool = com.tencent.mm.plugin.audio.d.b.crr();
    AppMethodBeat.o(257724);
    return bool;
  }
  
  public static final boolean crs()
  {
    AppMethodBeat.i(257734);
    boolean bool = a.crn().audioManager.isStreamMute(3);
    AppMethodBeat.o(257734);
    return bool;
  }
  
  public static final void crt()
  {
    AppMethodBeat.i(257736);
    a.crv().rJT.registerBroadcasts();
    AppMethodBeat.o(257736);
  }
  
  public static final void cru()
  {
    AppMethodBeat.i(257737);
    a.crv().rJT.unRegisterBroadcasts();
    AppMethodBeat.o(257737);
  }
  
  public static final void fp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257721);
    a.crn().fp(paramInt1, paramInt2);
    AppMethodBeat.o(257721);
  }
  
  public static final int getMode()
  {
    AppMethodBeat.i(257733);
    int i = a.getMode();
    AppMethodBeat.o(257733);
    return i;
  }
  
  public static final int getStreamMaxVolume(int paramInt)
  {
    AppMethodBeat.i(257719);
    paramInt = a.crn().getStreamMaxVolume(paramInt);
    AppMethodBeat.o(257719);
    return paramInt;
  }
  
  public static final int getStreamVolume(int paramInt)
  {
    AppMethodBeat.i(257720);
    paramInt = a.crn().getStreamVolume(paramInt);
    AppMethodBeat.o(257720);
    return paramInt;
  }
  
  public static final int kG(boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(257735);
    com.tencent.mm.plugin.audio.b.a locala = a.crn();
    int j;
    int i;
    if ((locala.audioManager.isBluetoothScoOn()) || (locala.jnc))
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
      AppMethodBeat.o(257735);
      return i;
      j = 0;
      break;
      i = 0;
      break label39;
    }
  }
  
  public static final void setMode(int paramInt)
  {
    AppMethodBeat.i(257732);
    com.tencent.mm.plugin.audio.b.a.a(a.crn(), paramInt);
    AppMethodBeat.o(257732);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(257710);
    Log.i("MicroMsg.SubCoreAudio", "onAccountPostReset");
    this.rJT.registerBroadcasts();
    AppMethodBeat.o(257710);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(257707);
    Log.i("MicroMsg.SubCoreAudio", "onAccountRelease");
    this.rJT.unRegisterBroadcasts();
    AppMethodBeat.o(257707);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio$Companion;", "", "()V", "TAG", "", "bindBroadcast", "", "checkAndSetRequestPriority", "", "current", "request", "getAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "type", "getBluetoothScoStreamType", "", "getCore", "Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "getCurrentAudioManagerType", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "streamType", "getStreamMode", "speakerOn", "getStreamVolume", "initAudioManager", "audioManager", "isBluetoothCanUse", "isBluetoothOn", "isBluetoothScoAvailable", "isHeadsetPlugged", "isSpeakerphoneOn", "isStreamMute", "onAudioDeviceStateChanged", "status", "pauseMusic", "resetSpeaker", "resumeMusic", "setMode", "mode", "setStreamVolume", "index", "flags", "unBindBroadcast", "unInitAudioManager", "volumeDown", "volumeUp", "plugin-audio_release"})
  public static final class a
  {
    public static void a(com.tencent.mm.plugin.audio.b.a parama, String paramString)
    {
      AppMethodBeat.i(257641);
      p.k(parama, "audioManager");
      p.k(paramString, "type");
      Log.printInfoStack("MicroMsg.SubCoreAudio", "init audio manager from ".concat(String.valueOf(paramString)), new Object[0]);
      String str = (String)kotlin.a.e.T(crv().rJW);
      if (p.h(str, ""))
      {
        crv().rJW[0] = paramString;
        crv().rJU = parama;
      }
      for (;;)
      {
        com.tencent.mm.plugin.audio.broadcast.bluetooth.a.crb();
        AppMethodBeat.o(257641);
        return;
        if (fd(str, paramString))
        {
          Log.i("MicroMsg.SubCoreAudio", "success set the audio manager is: ".concat(String.valueOf(paramString)));
          paramString = a.rJX;
          crv().rJU = parama;
        }
        else
        {
          Log.i("MicroMsg.SubCoreAudio", "current  " + str + " is running a priority higher than request: " + paramString);
        }
      }
    }
    
    public static boolean anW(String paramString)
    {
      AppMethodBeat.i(257643);
      p.k(paramString, "type");
      if ((p.h(paramString, crv().rJW[0])) || (p.h(crv().rJW[0], "")))
      {
        AppMethodBeat.o(257643);
        return true;
      }
      AppMethodBeat.o(257643);
      return false;
    }
    
    public static void anX(String paramString)
    {
      AppMethodBeat.i(257645);
      p.k(paramString, "type");
      if (p.h(paramString, (String)kotlin.a.e.T(crv().rJW)))
      {
        Log.i("MicroMsg.SubCoreAudio", "current do unInit audio manager and clear the queue");
        crv().rJW[0] = "";
        crv().rJU = null;
      }
      AppMethodBeat.o(257645);
    }
    
    public static com.tencent.mm.plugin.audio.b.a crn()
    {
      AppMethodBeat.i(257637);
      Object localObject2 = crv().rJU;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new c();
        localObject2 = a.rJX;
        crv().rJW[0] = "music";
        localObject1 = (com.tencent.mm.plugin.audio.b.a)localObject1;
      }
      AppMethodBeat.o(257637);
      return localObject1;
    }
    
    public static boolean crp()
    {
      AppMethodBeat.i(257638);
      boolean bool = com.tencent.mm.plugin.audio.d.b.a(crn().audioManager);
      AppMethodBeat.o(257638);
      return bool;
    }
    
    public static a crv()
    {
      AppMethodBeat.i(257636);
      Object localObject = y.as(a.class);
      p.j(localObject, "CompatSubCore.theCore(SubCoreAudio::class.java)");
      localObject = (a)localObject;
      AppMethodBeat.o(257636);
      return localObject;
    }
    
    public static String crw()
    {
      AppMethodBeat.i(257639);
      Object localObject = crn();
      int i = ((com.tencent.mm.plugin.audio.b.a)localObject).audioManager.getMode();
      localObject = new StringBuilder("mode:").append(i).append(" isSpeakerphoneOn:").append(((com.tencent.mm.plugin.audio.b.a)localObject).crl()).append(" isBluetoothOn:");
      com.tencent.mm.plugin.audio.d.b localb = com.tencent.mm.plugin.audio.d.b.rKe;
      localObject = com.tencent.mm.plugin.audio.d.b.cro();
      AppMethodBeat.o(257639);
      return localObject;
    }
    
    public static String crx()
    {
      AppMethodBeat.i(257644);
      String str = crv().rJW[0];
      AppMethodBeat.o(257644);
      return str;
    }
    
    private static boolean fd(String paramString1, String paramString2)
    {
      int j = 2;
      AppMethodBeat.i(257646);
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
        crv().rJW[1] = paramString2;
        AppMethodBeat.o(257646);
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
      crv().rJW[0] = paramString2;
      AppMethodBeat.o(257646);
      return true;
    }
    
    public static int getMode()
    {
      AppMethodBeat.i(257640);
      int i = crn().audioManager.getMode();
      AppMethodBeat.o(257640);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.c.a
 * JD-Core Version:    0.7.0.1
 */