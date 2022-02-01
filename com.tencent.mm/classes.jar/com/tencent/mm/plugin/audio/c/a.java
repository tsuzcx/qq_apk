package com.tencent.mm.plugin.audio.c;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.audio.b.c;
import com.tencent.mm.plugin.audio.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "Lcom/tencent/mm/model/ISubCore;", "()V", "mAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "getMAudioManager", "()Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "setMAudioManager", "(Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;)V", "mBroadCastHelper", "Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper;", "mRequestAudioManagerQueue", "", "", "getMRequestAudioManagerQueue", "()[Ljava/lang/String;", "setMRequestAudioManagerQueue", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "requesterType", "getRequesterType", "()Ljava/lang/String;", "setRequesterType", "(Ljava/lang/String;)V", "clearPluginData", "", "p0", "", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "", "onAccountRelease", "onSdcardMount", "registerBroadcast", "unRegisterBroadcast", "Companion", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements be
{
  public static final a uVi;
  public com.tencent.mm.plugin.audio.a uVj;
  com.tencent.mm.plugin.audio.b.a uVk;
  String uVl;
  String[] uVm;
  
  static
  {
    AppMethodBeat.i(263868);
    uVi = new a((byte)0);
    AppMethodBeat.o(263868);
  }
  
  public a()
  {
    AppMethodBeat.i(263735);
    this.uVj = new com.tencent.mm.plugin.audio.a();
    this.uVk = ((com.tencent.mm.plugin.audio.b.a)new c());
    this.uVl = "music";
    int i = 0;
    String[] arrayOfString = new String[2];
    while (i < 2)
    {
      arrayOfString[i] = "";
      i += 1;
    }
    this.uVm = arrayOfString;
    AppMethodBeat.o(263735);
  }
  
  public static final void EY(int paramInt)
  {
    AppMethodBeat.i(263826);
    a.cTW().EY(paramInt);
    AppMethodBeat.o(263826);
  }
  
  public static final void EZ(int paramInt)
  {
    AppMethodBeat.i(263836);
    a.cTW().EZ(paramInt);
    AppMethodBeat.o(263836);
  }
  
  public static final com.tencent.mm.plugin.audio.b.a ahs(String paramString)
  {
    AppMethodBeat.i(263753);
    s.u(paramString, "type");
    if (s.p(a.cUe().uVl, paramString))
    {
      paramString = a.cTW();
      AppMethodBeat.o(263753);
      return paramString;
    }
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      com.tencent.mm.plugin.audio.b.a locala = (com.tencent.mm.plugin.audio.b.a)new c();
      label91:
      a.cUe().uVk = locala;
      a locala1 = a.cUe();
      s.u(paramString, "<set-?>");
      locala1.uVl = paramString;
      AppMethodBeat.o(263753);
      return locala;
      if (paramString.equals("ipcall")) {
        do
        {
          locala = (com.tencent.mm.plugin.audio.b.a)new com.tencent.mm.plugin.audio.b.b();
          break label91;
          if (!paramString.equals("voip")) {
            break;
          }
          do
          {
            locala = (com.tencent.mm.plugin.audio.b.a)new e();
            break;
          } while (paramString.equals("voipcs"));
          break;
        } while (paramString.equals("multitalke"));
      }
    }
  }
  
  public static final void bLg()
  {
    AppMethodBeat.i(263841);
    a.cTW().bLg();
    AppMethodBeat.o(263841);
  }
  
  public static final void bLh()
  {
    AppMethodBeat.i(263844);
    a.cTW().bLh();
    AppMethodBeat.o(263844);
  }
  
  public static final void cTP()
  {
    AppMethodBeat.i(263814);
    a.cTW().cTP();
    AppMethodBeat.o(263814);
  }
  
  public static final boolean cTQ()
  {
    AppMethodBeat.i(263818);
    boolean bool = a.cTW().cTQ();
    AppMethodBeat.o(263818);
    return bool;
  }
  
  public static final int cTR()
  {
    AppMethodBeat.i(263790);
    int i = a.cTW().cTR();
    AppMethodBeat.o(263790);
    return i;
  }
  
  public static final boolean cTU()
  {
    AppMethodBeat.i(263770);
    boolean bool = a.cTW().cTU();
    AppMethodBeat.o(263770);
    return bool;
  }
  
  public static final com.tencent.mm.plugin.audio.b.a cTW()
  {
    AppMethodBeat.i(263743);
    com.tencent.mm.plugin.audio.b.a locala = a.cTW();
    AppMethodBeat.o(263743);
    return locala;
  }
  
  public static final boolean cTX()
  {
    AppMethodBeat.i(263760);
    com.tencent.mm.plugin.audio.d.b localb = com.tencent.mm.plugin.audio.d.b.uVo;
    boolean bool = com.tencent.mm.plugin.audio.d.b.cTX();
    AppMethodBeat.o(263760);
    return bool;
  }
  
  public static final boolean cTY()
  {
    AppMethodBeat.i(263764);
    boolean bool = com.tencent.mm.plugin.audio.d.b.a(a.cTW().audioManager);
    AppMethodBeat.o(263764);
    return bool;
  }
  
  public static final int cTZ()
  {
    AppMethodBeat.i(263800);
    com.tencent.mm.plugin.audio.b.a locala = a.cTW();
    int i = locala.lQq;
    locala.lQq = 0;
    AppMethodBeat.o(263800);
    return i;
  }
  
  public static final boolean cUa()
  {
    AppMethodBeat.i(263807);
    com.tencent.mm.plugin.audio.d.b localb = com.tencent.mm.plugin.audio.d.b.uVo;
    boolean bool = com.tencent.mm.plugin.audio.d.b.cUa();
    AppMethodBeat.o(263807);
    return bool;
  }
  
  public static final boolean cUb()
  {
    AppMethodBeat.i(263855);
    boolean bool = a.cTW().audioManager.isStreamMute(3);
    AppMethodBeat.o(263855);
    return bool;
  }
  
  public static final void cUc()
  {
    AppMethodBeat.i(263862);
    a.cUe().uVj.registerBroadcasts();
    AppMethodBeat.o(263862);
  }
  
  public static final void cUd()
  {
    AppMethodBeat.i(263866);
    a.cUe().uVj.unRegisterBroadcasts();
    AppMethodBeat.o(263866);
  }
  
  public static final int getMode()
  {
    AppMethodBeat.i(263852);
    int i = a.cTW().audioManager.getMode();
    AppMethodBeat.o(263852);
    return i;
  }
  
  public static final int getStreamMaxVolume(int paramInt)
  {
    AppMethodBeat.i(263774);
    paramInt = a.cTW().getStreamMaxVolume(paramInt);
    AppMethodBeat.o(263774);
    return paramInt;
  }
  
  public static final int getStreamVolume(int paramInt)
  {
    AppMethodBeat.i(263778);
    paramInt = a.cTW().getStreamVolume(paramInt);
    AppMethodBeat.o(263778);
    return paramInt;
  }
  
  public static final void gi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263784);
    a.cTW().gi(paramInt1, paramInt2);
    AppMethodBeat.o(263784);
  }
  
  public static final int lS(boolean paramBoolean)
  {
    AppMethodBeat.i(263858);
    int i = a.cTW().lS(paramBoolean);
    AppMethodBeat.o(263858);
    return i;
  }
  
  public static final void setMode(int paramInt)
  {
    AppMethodBeat.i(263848);
    com.tencent.mm.plugin.audio.b.a.a(a.cTW(), paramInt);
    AppMethodBeat.o(263848);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(263875);
    Log.i("MicroMsg.SubCoreAudio", "onAccountPostReset");
    this.uVj.registerBroadcasts();
    AppMethodBeat.o(263875);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(263871);
    Log.i("MicroMsg.SubCoreAudio", "onAccountRelease");
    this.uVj.unRegisterBroadcasts();
    AppMethodBeat.o(263871);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio$Companion;", "", "()V", "TAG", "", "bindBroadcast", "", "checkAndSetRequestPriority", "", "current", "request", "checkCurrentRingerMode", "", "getAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "type", "getBluetoothScoStreamType", "getCore", "Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "getCurrentAudioManagerType", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "streamType", "getStreamMode", "speakerOn", "getStreamVolume", "initAudioManager", "audioManager", "isBluetoothCanUse", "isBluetoothOn", "isBluetoothScoAvailable", "isHeadsetPlugged", "isSpeakerphoneOn", "isStreamMute", "onAudioDeviceStateChanged", "status", "pauseMusic", "resetSpeaker", "resumeMusic", "setMode", "mode", "setStreamVolume", "index", "flags", "unBindBroadcast", "unInitAudioManager", "volumeDown", "volumeUp", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(com.tencent.mm.plugin.audio.b.a parama, String paramString)
    {
      AppMethodBeat.i(263785);
      s.u(parama, "audioManager");
      s.u(paramString, "type");
      Log.printInfoStack("MicroMsg.SubCoreAudio", s.X("init audio manager from ", paramString), new Object[0]);
      String str = (String)k.X(cUe().uVm);
      if (s.p(str, ""))
      {
        cUe().uVm[0] = paramString;
        cUe().uVk = parama;
      }
      for (;;)
      {
        com.tencent.mm.plugin.audio.broadcast.bluetooth.a.cTI();
        AppMethodBeat.o(263785);
        return;
        if (fu(str, paramString))
        {
          Log.i("MicroMsg.SubCoreAudio", s.X("success set the audio manager is: ", paramString));
          paramString = a.uVi;
          cUe().uVk = parama;
        }
        else
        {
          Log.i("MicroMsg.SubCoreAudio", "current  " + str + " is running a priority higher than request: " + paramString);
        }
      }
    }
    
    public static boolean aht(String paramString)
    {
      AppMethodBeat.i(263792);
      s.u(paramString, "type");
      if ((s.p(paramString, cUe().uVm[0])) || (s.p(cUe().uVm[0], "")))
      {
        AppMethodBeat.o(263792);
        return true;
      }
      AppMethodBeat.o(263792);
      return false;
    }
    
    public static void ahu(String paramString)
    {
      AppMethodBeat.i(263811);
      s.u(paramString, "type");
      if (s.p(paramString, (String)k.X(cUe().uVm)))
      {
        Log.i("MicroMsg.SubCoreAudio", "current do unInit audio manager and clear the queue");
        cUe().uVm[0] = "";
        cUe().uVk = null;
      }
      AppMethodBeat.o(263811);
    }
    
    public static com.tencent.mm.plugin.audio.b.a cTW()
    {
      AppMethodBeat.i(263752);
      Object localObject = cUe().uVk;
      if (localObject == null)
      {
        localObject = new c();
        a locala = a.uVi;
        cUe().uVm[0] = "music";
        localObject = (com.tencent.mm.plugin.audio.b.a)localObject;
        AppMethodBeat.o(263752);
        return localObject;
      }
      AppMethodBeat.o(263752);
      return localObject;
    }
    
    public static boolean cTY()
    {
      AppMethodBeat.i(263759);
      boolean bool = com.tencent.mm.plugin.audio.d.b.a(cTW().audioManager);
      AppMethodBeat.o(263759);
      return bool;
    }
    
    public static void cUc()
    {
      AppMethodBeat.i(263777);
      cUe().uVj.registerBroadcasts();
      AppMethodBeat.o(263777);
    }
    
    public static a cUe()
    {
      AppMethodBeat.i(263744);
      Object localObject = y.aL(a.class);
      s.s(localObject, "theCore(SubCoreAudio::class.java)");
      localObject = (a)localObject;
      AppMethodBeat.o(263744);
      return localObject;
    }
    
    public static String cUf()
    {
      AppMethodBeat.i(263767);
      Object localObject = cTW();
      int i = ((com.tencent.mm.plugin.audio.b.a)localObject).audioManager.getMode();
      localObject = new StringBuilder("mode:").append(i).append(" isSpeakerphoneOn:").append(((com.tencent.mm.plugin.audio.b.a)localObject).cTU()).append(" isBluetoothOn:");
      com.tencent.mm.plugin.audio.d.b localb = com.tencent.mm.plugin.audio.d.b.uVo;
      localObject = com.tencent.mm.plugin.audio.d.b.cTX();
      AppMethodBeat.o(263767);
      return localObject;
    }
    
    public static String cUg()
    {
      AppMethodBeat.i(263802);
      String str = cUe().uVm[0];
      AppMethodBeat.o(263802);
      return str;
    }
    
    public static int cUh()
    {
      AppMethodBeat.i(263828);
      int i = cTW().audioManager.getRingerMode();
      AppMethodBeat.o(263828);
      return i;
    }
    
    private static boolean fu(String paramString1, String paramString2)
    {
      int j = 2;
      AppMethodBeat.i(263823);
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
          break label229;
        }
        cUe().uVm[1] = paramString2;
        AppMethodBeat.o(263823);
        return false;
        if (!paramString1.equals("ipcall")) {
          break;
        }
        for (;;)
        {
          i = 2;
          break label54;
          if (!paramString1.equals("voip"))
          {
            break;
            if (!paramString1.equals("voipcs")) {
              if ((goto 52) || (!paramString1.equals("multitalke"))) {
                break;
              }
            }
          }
        }
        if (!paramString2.equals("ipcall"))
        {
          break label100;
          if (!paramString2.equals("voip"))
          {
            break label100;
            if (!paramString2.equals("voipcs")) {
              if ((goto 100) || (!paramString2.equals("multitalke"))) {
                break label100;
              }
            }
          }
        }
      }
      label229:
      cUe().uVm[0] = paramString2;
      AppMethodBeat.o(263823);
      return true;
    }
    
    public static int getMode()
    {
      AppMethodBeat.i(369731);
      int i = cTW().audioManager.getMode();
      AppMethodBeat.o(369731);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.c.a
 * JD-Core Version:    0.7.0.1
 */