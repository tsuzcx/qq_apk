package com.tencent.mm.audio;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.audio.d.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/audio/SceneVoiceRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "isRequestBluetoothStart", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "startRecordHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "plugin-audiologic_release"})
public final class b
  extends d
{
  public static final b.a cQE;
  private final ao cQB;
  private boolean cQC;
  d.g.a.b<? super Boolean, y> cQD;
  
  static
  {
    AppMethodBeat.i(209476);
    cQE = new b.a((byte)0);
    AppMethodBeat.o(209476);
  }
  
  public b(d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(209475);
    this.cQD = paramb;
    com.tencent.mm.plugin.audio.d.a.bCE();
    c.bCE();
    paramb = com.tencent.mm.plugin.audio.c.a.mRw;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    this.cQB = new ao((ao.a)new b(this));
    AppMethodBeat.o(209475);
  }
  
  public final void Mv()
  {
    AppMethodBeat.i(209472);
    Object localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    ac.i("MicroMsg.SceneVoiceRecorderAudioManager", "some one has been request audio to record");
    localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    localObject = com.tencent.mm.plugin.audio.d.a.mRz;
    if (com.tencent.mm.plugin.audio.d.a.bCA())
    {
      if (isBluetoothScoOn())
      {
        this.cQC = true;
        this.cQD.ay(Boolean.TRUE);
        b("record", Integer.valueOf(1));
        AppMethodBeat.o(209472);
        return;
      }
      this.cQC = true;
      if (b("record", Integer.valueOf(4)) != -1)
      {
        this.cQB.sendEmptyMessageDelayed(0, 1000L);
        AppMethodBeat.o(209472);
        return;
      }
      this.cQD.ay(Boolean.TRUE);
      AppMethodBeat.o(209472);
      return;
    }
    this.cQD.ay(Boolean.TRUE);
    AppMethodBeat.o(209472);
  }
  
  public final void Mw()
  {
    AppMethodBeat.i(209473);
    this.cQB.removeCallbacksAndMessages(null);
    if (this.cQC)
    {
      Sl("record");
      this.cQC = false;
    }
    a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    a.a.So("record");
    AppMethodBeat.o(209473);
  }
  
  public final void hv(int paramInt)
  {
    AppMethodBeat.i(209474);
    super.hv(paramInt);
    switch (paramInt)
    {
    }
    label132:
    label135:
    for (;;)
    {
      AppMethodBeat.o(209474);
      return;
      this.cQB.removeCallbacksAndMessages(null);
      k.h("record", "type");
      Iterator localIterator = ((Iterable)this.mRe).iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (k.g((String)localObject, "record")) {
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
        ac.i("MicroMsg.SceneVoiceRecorderAudioManager", "checkIfSomeRequestAvailable available");
        this.cQD.ay(Boolean.TRUE);
        break;
        localObject = null;
        break label94;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements ao.a
  {
    b(b paramb) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(209471);
      this.cQF.cQD.ay(Boolean.FALSE);
      AppMethodBeat.o(209471);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.b
 * JD-Core Version:    0.7.0.1
 */