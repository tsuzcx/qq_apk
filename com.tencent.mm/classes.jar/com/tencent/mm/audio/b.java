package com.tencent.mm.audio;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.audio.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/audio/SceneVoiceRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "isRequestBluetoothStart", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "startRecordHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "plugin-audiologic_release"})
public final class b
  extends d
{
  public static final b.a dbU;
  private final ap dbR;
  private boolean dbS;
  d.g.a.b<? super Boolean, z> dbT;
  
  static
  {
    AppMethodBeat.i(205855);
    dbU = new b.a((byte)0);
    AppMethodBeat.o(205855);
  }
  
  public b(d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(205854);
    this.dbT = paramb;
    com.tencent.mm.plugin.audio.d.a.bGM();
    c.bGM();
    paramb = com.tencent.mm.plugin.audio.c.a.nrV;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    this.dbR = new ap((ap.a)new b(this));
    AppMethodBeat.o(205854);
  }
  
  public final void Oe()
  {
    AppMethodBeat.i(205851);
    Object localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    ad.i("MicroMsg.SceneVoiceRecorderAudioManager", "some one has been request audio to record");
    localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    localObject = com.tencent.mm.plugin.audio.d.a.nrY;
    if (com.tencent.mm.plugin.audio.d.a.bGG())
    {
      if (isBluetoothScoOn())
      {
        this.dbS = true;
        this.dbT.invoke(Boolean.TRUE);
        b("record", Integer.valueOf(1));
        AppMethodBeat.o(205851);
        return;
      }
      this.dbS = true;
      if (b("record", Integer.valueOf(4)) != -1)
      {
        this.dbR.sendEmptyMessageDelayed(0, 1000L);
        AppMethodBeat.o(205851);
        return;
      }
      this.dbT.invoke(Boolean.TRUE);
      AppMethodBeat.o(205851);
      return;
    }
    this.dbT.invoke(Boolean.TRUE);
    AppMethodBeat.o(205851);
  }
  
  public final void Of()
  {
    AppMethodBeat.i(205852);
    this.dbR.removeCallbacksAndMessages(null);
    if (this.dbS)
    {
      VJ("record");
      this.dbS = false;
    }
    a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    a.a.VM("record");
    AppMethodBeat.o(205852);
  }
  
  public final void hC(int paramInt)
  {
    AppMethodBeat.i(205853);
    super.hC(paramInt);
    switch (paramInt)
    {
    }
    label132:
    label135:
    for (;;)
    {
      AppMethodBeat.o(205853);
      return;
      this.dbR.removeCallbacksAndMessages(null);
      p.h("record", "type");
      Iterator localIterator = ((Iterable)this.nrD).iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (p.i((String)localObject, "record")) {
          label94:
          if (localObject == null) {
            break label132;
          }
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label135;
        }
        ad.i("MicroMsg.SceneVoiceRecorderAudioManager", "checkIfSomeRequestAvailable available");
        this.dbT.invoke(Boolean.TRUE);
        break;
        localObject = null;
        break label94;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements ap.a
  {
    b(b paramb) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(205850);
      this.dbV.dbT.invoke(Boolean.FALSE);
      AppMethodBeat.o(205850);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.b
 * JD-Core Version:    0.7.0.1
 */