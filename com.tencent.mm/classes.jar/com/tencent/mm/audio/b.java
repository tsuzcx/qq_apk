package com.tencent.mm.audio;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/audio/SceneVoiceRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "isRequestBluetoothStart", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "startRecordHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "plugin-audiologic_release"})
public final class b
  extends com.tencent.mm.plugin.audio.b.d
{
  public static final b.a fmv;
  private final MMHandler fms;
  private boolean fmt;
  kotlin.g.a.b<? super Boolean, x> fmu;
  
  static
  {
    AppMethodBeat.i(226388);
    fmv = new b.a((byte)0);
    AppMethodBeat.o(226388);
  }
  
  public b(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(226386);
    this.fmu = paramb;
    com.tencent.mm.plugin.audio.d.b.crG();
    com.tencent.mm.plugin.audio.d.d.crG();
    paramb = com.tencent.mm.plugin.audio.c.a.rJX;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    this.fms = new MMHandler((MMHandler.Callback)new b(this));
    AppMethodBeat.o(226386);
  }
  
  public final void acU()
  {
    AppMethodBeat.i(226378);
    Object localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    Log.i("MicroMsg.SceneVoiceRecorderAudioManager", "some one has been request audio to record");
    localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    localObject = com.tencent.mm.plugin.audio.d.b.rKe;
    if (com.tencent.mm.plugin.audio.d.b.crr())
    {
      localObject = com.tencent.mm.plugin.audio.d.b.rKe;
      if (com.tencent.mm.plugin.audio.d.b.crH())
      {
        if (crm())
        {
          this.fmt = true;
          this.fmu.invoke(Boolean.TRUE);
          b("record", Integer.valueOf(1));
          AppMethodBeat.o(226378);
          return;
        }
        this.fmt = true;
        if (b("record", Integer.valueOf(4)) != -1)
        {
          this.fms.sendEmptyMessageDelayed(0, 1000L);
          AppMethodBeat.o(226378);
          return;
        }
        this.fmu.invoke(Boolean.TRUE);
        AppMethodBeat.o(226378);
        return;
      }
    }
    this.fmu.invoke(Boolean.TRUE);
    AppMethodBeat.o(226378);
  }
  
  public final void acV()
  {
    AppMethodBeat.i(226381);
    this.fms.removeCallbacksAndMessages(null);
    if (this.fmt)
    {
      anT("record");
      this.fmt = false;
    }
    a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    a.a.anX("record");
    AppMethodBeat.o(226381);
  }
  
  public final void ko(int paramInt)
  {
    AppMethodBeat.i(226383);
    super.ko(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(226383);
      return;
      this.fms.removeCallbacksAndMessages(null);
      if (anU("record"))
      {
        Log.i("MicroMsg.SceneVoiceRecorderAudioManager", "checkIfSomeRequestAvailable available");
        this.fmu.invoke(Boolean.TRUE);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements MMHandler.Callback
  {
    b(b paramb) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(227763);
      this.fmw.fmu.invoke(Boolean.FALSE);
      AppMethodBeat.o(227763);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.b
 * JD-Core Version:    0.7.0.1
 */