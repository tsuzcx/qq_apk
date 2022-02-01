package com.tencent.mm.audio;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.audio.d.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/audio/SceneVoiceRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "isRequestBluetoothStart", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "startRecordHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "plugin-audiologic_release"})
public final class b
  extends d
{
  public static final b.a dcW;
  private final aq dcT;
  private boolean dcU;
  d.g.a.b<? super Boolean, z> dcV;
  
  static
  {
    AppMethodBeat.i(200175);
    dcW = new b.a((byte)0);
    AppMethodBeat.o(200175);
  }
  
  public b(d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(200174);
    this.dcV = paramb;
    com.tencent.mm.plugin.audio.d.a.bHI();
    c.bHI();
    paramb = com.tencent.mm.plugin.audio.c.a.nxo;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    this.dcT = new aq((aq.a)new b(this));
    AppMethodBeat.o(200174);
  }
  
  public final void Oc()
  {
    AppMethodBeat.i(200171);
    Object localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    ae.i("MicroMsg.SceneVoiceRecorderAudioManager", "some one has been request audio to record");
    localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    localObject = com.tencent.mm.plugin.audio.d.a.nxr;
    if (com.tencent.mm.plugin.audio.d.a.bHC())
    {
      if (isBluetoothScoOn())
      {
        this.dcU = true;
        this.dcV.invoke(Boolean.TRUE);
        b("record", Integer.valueOf(1));
        AppMethodBeat.o(200171);
        return;
      }
      this.dcU = true;
      if (b("record", Integer.valueOf(4)) != -1)
      {
        this.dcT.sendEmptyMessageDelayed(0, 1000L);
        AppMethodBeat.o(200171);
        return;
      }
      this.dcV.invoke(Boolean.TRUE);
      AppMethodBeat.o(200171);
      return;
    }
    this.dcV.invoke(Boolean.TRUE);
    AppMethodBeat.o(200171);
  }
  
  public final void Od()
  {
    AppMethodBeat.i(200172);
    this.dcT.removeCallbacksAndMessages(null);
    if (this.dcU)
    {
      Wv("record");
      this.dcU = false;
    }
    a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    a.a.Wy("record");
    AppMethodBeat.o(200172);
  }
  
  public final void hE(int paramInt)
  {
    AppMethodBeat.i(200173);
    super.hE(paramInt);
    switch (paramInt)
    {
    }
    label132:
    label135:
    for (;;)
    {
      AppMethodBeat.o(200173);
      return;
      this.dcT.removeCallbacksAndMessages(null);
      p.h("record", "type");
      Iterator localIterator = ((Iterable)this.nwW).iterator();
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
        ae.i("MicroMsg.SceneVoiceRecorderAudioManager", "checkIfSomeRequestAvailable available");
        this.dcV.invoke(Boolean.TRUE);
        break;
        localObject = null;
        break label94;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements aq.a
  {
    b(b paramb) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(200170);
      this.dcX.dcV.invoke(Boolean.FALSE);
      AppMethodBeat.o(200170);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.b
 * JD-Core Version:    0.7.0.1
 */