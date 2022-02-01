package com.tencent.mm.audio;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/audio/SceneVoiceRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "isRequestBluetoothStart", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "startRecordHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "plugin-audiologic_release"})
public final class b
  extends com.tencent.mm.plugin.audio.b.d
{
  public static final b.a dtN;
  private final MMHandler dtK;
  private boolean dtL;
  kotlin.g.a.b<? super Boolean, x> dtM;
  
  static
  {
    AppMethodBeat.i(187347);
    dtN = new b.a((byte)0);
    AppMethodBeat.o(187347);
  }
  
  public b(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(187346);
    this.dtM = paramb;
    com.tencent.mm.plugin.audio.d.b.cet();
    com.tencent.mm.plugin.audio.d.d.cet();
    paramb = com.tencent.mm.plugin.audio.c.a.oIh;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    this.dtK = new MMHandler((MMHandler.Callback)new b(this));
    AppMethodBeat.o(187346);
  }
  
  public final void Yo()
  {
    AppMethodBeat.i(187343);
    Object localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    Log.i("MicroMsg.SceneVoiceRecorderAudioManager", "some one has been request audio to record");
    localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    localObject = com.tencent.mm.plugin.audio.d.b.oIo;
    if (com.tencent.mm.plugin.audio.d.b.cee())
    {
      localObject = com.tencent.mm.plugin.audio.d.b.oIo;
      if (com.tencent.mm.plugin.audio.d.b.ceu())
      {
        if (isBluetoothScoOn())
        {
          this.dtL = true;
          this.dtM.invoke(Boolean.TRUE);
          b("record", Integer.valueOf(1));
          AppMethodBeat.o(187343);
          return;
        }
        this.dtL = true;
        if (b("record", Integer.valueOf(4)) != -1)
        {
          this.dtK.sendEmptyMessageDelayed(0, 1000L);
          AppMethodBeat.o(187343);
          return;
        }
        this.dtM.invoke(Boolean.TRUE);
        AppMethodBeat.o(187343);
        return;
      }
    }
    this.dtM.invoke(Boolean.TRUE);
    AppMethodBeat.o(187343);
  }
  
  public final void Yp()
  {
    AppMethodBeat.i(187344);
    this.dtK.removeCallbacksAndMessages(null);
    if (this.dtL)
    {
      agq("record");
      this.dtL = false;
    }
    a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    a.a.agt("record");
    AppMethodBeat.o(187344);
  }
  
  public final void iY(int paramInt)
  {
    AppMethodBeat.i(187345);
    super.iY(paramInt);
    switch (paramInt)
    {
    }
    label132:
    label135:
    for (;;)
    {
      AppMethodBeat.o(187345);
      return;
      this.dtK.removeCallbacksAndMessages(null);
      p.h("record", "type");
      Iterator localIterator = ((Iterable)this.oHP).iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (p.j((String)localObject, "record")) {
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
        Log.i("MicroMsg.SceneVoiceRecorderAudioManager", "checkIfSomeRequestAvailable available");
        this.dtM.invoke(Boolean.TRUE);
        break;
        localObject = null;
        break label94;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements MMHandler.Callback
  {
    b(b paramb) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(187342);
      this.dtO.dtM.invoke(Boolean.FALSE);
      AppMethodBeat.o(187342);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b
 * JD-Core Version:    0.7.0.1
 */