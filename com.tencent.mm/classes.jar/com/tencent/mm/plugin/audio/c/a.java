package com.tencent.mm.plugin.audio.c;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.audio.b.b;
import com.tencent.mm.plugin.audio.b.c;
import com.tencent.mm.plugin.audio.b.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import d.g.b.k;
import d.l;
import java.util.HashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "Lcom/tencent/mm/model/ISubCore;", "()V", "mAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "getMAudioManager", "()Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "setMAudioManager", "(Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;)V", "mBroadCastHelper", "Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper;", "mRequestAudioManagerQueue", "", "", "getMRequestAudioManagerQueue", "()[Ljava/lang/String;", "setMRequestAudioManagerQueue", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "requesterType", "getRequesterType", "()Ljava/lang/String;", "setRequesterType", "(Ljava/lang/String;)V", "clearPluginData", "", "p0", "", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "", "onAccountRelease", "onSdcardMount", "Companion", "plugin-audio_release"})
public final class a
  implements aw
{
  public static final a.a mpv;
  private com.tencent.mm.plugin.audio.a mpr;
  com.tencent.mm.plugin.audio.b.a mps;
  String mpt;
  public String[] mpu;
  
  static
  {
    AppMethodBeat.i(189246);
    mpv = new a.a((byte)0);
    AppMethodBeat.o(189246);
  }
  
  public a()
  {
    AppMethodBeat.i(189245);
    this.mpr = new com.tencent.mm.plugin.audio.a();
    this.mps = ((com.tencent.mm.plugin.audio.b.a)new c());
    this.mpt = "music";
    String[] arrayOfString = new String[2];
    int i = 0;
    while (i < 2)
    {
      arrayOfString[i] = "";
      i += 1;
    }
    this.mpu = arrayOfString;
    AppMethodBeat.o(189245);
  }
  
  public static final com.tencent.mm.plugin.audio.b.a Od(String paramString)
  {
    AppMethodBeat.i(189248);
    k.h(paramString, "type");
    if (k.g(a.a.bvG().mpt, paramString))
    {
      paramString = a.a.bvB();
      AppMethodBeat.o(189248);
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
        a.a.bvG().mps = locala;
        a locala1 = a.a.bvG();
        k.h(paramString, "<set-?>");
        locala1.mpt = paramString;
        AppMethodBeat.o(189248);
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
        locala = (com.tencent.mm.plugin.audio.b.a)new e();
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
  
  public static final void azB()
  {
    AppMethodBeat.i(189261);
    a.a.bvB().audioManager.setStreamMute(3, true);
    AppMethodBeat.o(189261);
  }
  
  public static final void azC()
  {
    AppMethodBeat.i(189262);
    a.a.bvB().audioManager.setStreamMute(3, false);
    AppMethodBeat.o(189262);
  }
  
  public static final com.tencent.mm.plugin.audio.b.a bvB()
  {
    AppMethodBeat.i(189247);
    com.tencent.mm.plugin.audio.b.a locala = a.a.bvB();
    AppMethodBeat.o(189247);
    return locala;
  }
  
  public static final boolean bvC()
  {
    AppMethodBeat.i(189249);
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.mpy;
    boolean bool = com.tencent.mm.plugin.audio.d.a.bvC();
    AppMethodBeat.o(189249);
    return bool;
  }
  
  public static final int bvD()
  {
    AppMethodBeat.i(189255);
    com.tencent.mm.plugin.audio.b.a locala = a.a.bvB();
    int i = locala.fyS;
    locala.fyS = 0;
    AppMethodBeat.o(189255);
    return i;
  }
  
  public static final boolean bvE()
  {
    AppMethodBeat.i(189256);
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.mpy;
    boolean bool = com.tencent.mm.plugin.audio.d.a.bvE();
    AppMethodBeat.o(189256);
    return bool;
  }
  
  public static final boolean bvF()
  {
    AppMethodBeat.i(189265);
    boolean bool = a.a.bvB().audioManager.isStreamMute(3);
    AppMethodBeat.o(189265);
    return bool;
  }
  
  public static final void bvv()
  {
    AppMethodBeat.i(189257);
    a.a.bvB().bvv();
    AppMethodBeat.o(189257);
  }
  
  public static final boolean bvw()
  {
    AppMethodBeat.i(189258);
    boolean bool = a.a.bvB().bvw();
    AppMethodBeat.o(189258);
    return bool;
  }
  
  public static final int bvx()
  {
    AppMethodBeat.i(189254);
    int i = a.a.bvB().bvx();
    AppMethodBeat.o(189254);
    return i;
  }
  
  public static final void ex(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189253);
    a.a.bvB().ex(paramInt1, paramInt2);
    AppMethodBeat.o(189253);
  }
  
  public static final int getMode()
  {
    AppMethodBeat.i(189264);
    int i = a.a.getMode();
    AppMethodBeat.o(189264);
    return i;
  }
  
  public static final int getStreamMaxVolume(int paramInt)
  {
    AppMethodBeat.i(189251);
    paramInt = a.a.bvB().getStreamMaxVolume(paramInt);
    AppMethodBeat.o(189251);
    return paramInt;
  }
  
  public static final int getStreamVolume(int paramInt)
  {
    AppMethodBeat.i(189252);
    paramInt = a.a.bvB().getStreamVolume(paramInt);
    AppMethodBeat.o(189252);
    return paramInt;
  }
  
  public static final int hO(boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(189266);
    com.tencent.mm.plugin.audio.b.a locala = a.a.bvB();
    int j;
    int i;
    if ((locala.audioManager.isBluetoothScoOn()) || (locala.fyP))
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
      AppMethodBeat.o(189266);
      return i;
      j = 0;
      break;
      i = 0;
      break label39;
    }
  }
  
  public static final boolean isSpeakerphoneOn()
  {
    AppMethodBeat.i(189250);
    boolean bool = a.a.bvB().isSpeakerphoneOn();
    AppMethodBeat.o(189250);
    return bool;
  }
  
  public static final void setMode(int paramInt)
  {
    AppMethodBeat.i(189263);
    com.tencent.mm.plugin.audio.b.a.a(a.a.bvB(), paramInt);
    AppMethodBeat.o(189263);
  }
  
  public static final void vO(int paramInt)
  {
    AppMethodBeat.i(189259);
    a.a.bvB().vO(paramInt);
    AppMethodBeat.o(189259);
  }
  
  public static final void vP(int paramInt)
  {
    AppMethodBeat.i(189260);
    a.a.bvB().vP(paramInt);
    AppMethodBeat.o(189260);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(189244);
    ad.i("MicroMsg.SubCoreAudio", "onAccountPostReset");
    this.mpr.registerBroadcasts();
    AppMethodBeat.o(189244);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(189243);
    ad.i("MicroMsg.SubCoreAudio", "onAccountRelease");
    this.mpr.unRegisterBroadcasts();
    AppMethodBeat.o(189243);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.c.a
 * JD-Core Version:    0.7.0.1
 */