package com.tencent.mm.audio;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.audio.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/audio/SceneVoiceRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "isRequestBluetoothStart", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "startRecordHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "plugin-audiologic_release"})
public final class b
  extends d
{
  public static final b.a cTh;
  private final ap cTe;
  private boolean cTf;
  d.g.a.b<? super Boolean, y> cTg;
  
  static
  {
    AppMethodBeat.i(189934);
    cTh = new b.a((byte)0);
    AppMethodBeat.o(189934);
  }
  
  public b(d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(189933);
    this.cTg = paramb;
    com.tencent.mm.plugin.audio.d.a.bvI();
    c.bvI();
    paramb = com.tencent.mm.plugin.audio.c.a.mpv;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    this.cTe = new ap((ap.a)new b(this));
    AppMethodBeat.o(189933);
  }
  
  public final void Mx()
  {
    AppMethodBeat.i(189930);
    Object localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    ad.i("MicroMsg.SceneVoiceRecorderAudioManager", "some one has been request audio to record");
    localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    localObject = com.tencent.mm.plugin.audio.d.a.mpy;
    if (com.tencent.mm.plugin.audio.d.a.bvE())
    {
      if (isBluetoothScoOn())
      {
        this.cTf = true;
        this.cTg.aA(Boolean.TRUE);
        b("record", Integer.valueOf(1));
        AppMethodBeat.o(189930);
        return;
      }
      this.cTf = true;
      if (b("record", Integer.valueOf(4)) != -1)
      {
        this.cTe.sendEmptyMessageDelayed(0, 1000L);
        AppMethodBeat.o(189930);
        return;
      }
      this.cTg.aA(Boolean.TRUE);
      AppMethodBeat.o(189930);
      return;
    }
    this.cTg.aA(Boolean.TRUE);
    AppMethodBeat.o(189930);
  }
  
  public final void My()
  {
    AppMethodBeat.i(189931);
    this.cTe.removeCallbacksAndMessages(null);
    if (this.cTf)
    {
      Oc("record");
      this.cTf = false;
    }
    a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    a.a.Oe("record");
    AppMethodBeat.o(189931);
  }
  
  public final void hL(int paramInt)
  {
    AppMethodBeat.i(189932);
    super.hL(paramInt);
    switch (paramInt)
    {
    }
    label132:
    label135:
    for (;;)
    {
      AppMethodBeat.o(189932);
      return;
      this.cTe.removeCallbacksAndMessages(null);
      k.h("record", "type");
      Iterator localIterator = ((Iterable)this.mpd).iterator();
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
        ad.i("MicroMsg.SceneVoiceRecorderAudioManager", "checkIfSomeRequestAvailable available");
        this.cTg.aA(Boolean.TRUE);
        break;
        localObject = null;
        break label94;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements ap.a
  {
    b(b paramb) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(189929);
      this.cTi.cTg.aA(Boolean.FALSE);
      AppMethodBeat.o(189929);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.b
 * JD-Core Version:    0.7.0.1
 */