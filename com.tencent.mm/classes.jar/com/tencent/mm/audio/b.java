package com.tencent.mm.audio;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/audio/SceneVoiceRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "isRequestBluetoothStart", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "startRecordHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "plugin-audiologic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.audio.b.d
{
  public static final b.a hqE;
  private kotlin.g.a.b<? super Boolean, ah> hqF;
  private final MMHandler hqG;
  private boolean hqH;
  
  static
  {
    AppMethodBeat.i(236154);
    hqE = new b.a((byte)0);
    AppMethodBeat.o(236154);
  }
  
  public b(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(236148);
    this.hqF = paramb;
    com.tencent.mm.plugin.audio.d.b.cUq();
    com.tencent.mm.plugin.audio.d.d.cUq();
    paramb = com.tencent.mm.plugin.audio.c.a.uVi;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    this.hqG = new MMHandler(new b..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(236148);
  }
  
  private static final boolean a(b paramb, Message paramMessage)
  {
    AppMethodBeat.i(236151);
    s.u(paramb, "this$0");
    s.u(paramMessage, "it");
    paramb.hqF.invoke(Boolean.FALSE);
    AppMethodBeat.o(236151);
    return false;
  }
  
  public final void aEU()
  {
    AppMethodBeat.i(236159);
    Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    Log.i("MicroMsg.SceneVoiceRecorderAudioManager", "some one has been request audio to record");
    localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    localObject = com.tencent.mm.plugin.audio.d.b.uVo;
    if (com.tencent.mm.plugin.audio.d.b.cUa())
    {
      localObject = com.tencent.mm.plugin.audio.d.b.uVo;
      if (com.tencent.mm.plugin.audio.d.b.cUr())
      {
        if (cTV())
        {
          this.hqH = true;
          this.hqF.invoke(Boolean.TRUE);
          b("record", Integer.valueOf(1));
          AppMethodBeat.o(236159);
          return;
        }
        this.hqH = true;
        if (b("record", Integer.valueOf(4)) != -1)
        {
          this.hqG.sendEmptyMessageDelayed(0, 1000L);
          AppMethodBeat.o(236159);
          return;
        }
        this.hqF.invoke(Boolean.TRUE);
        AppMethodBeat.o(236159);
        return;
      }
    }
    this.hqF.invoke(Boolean.TRUE);
    AppMethodBeat.o(236159);
  }
  
  public final void aEV()
  {
    AppMethodBeat.i(236162);
    this.hqG.removeCallbacksAndMessages(null);
    if (this.hqH)
    {
      ahq("record");
      this.hqH = false;
    }
    a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    a.a.ahu("record");
    AppMethodBeat.o(236162);
  }
  
  public final void nW(int paramInt)
  {
    AppMethodBeat.i(236165);
    super.nW(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(236165);
      return;
      this.hqG.removeCallbacksAndMessages(null);
      if (ahr("record"))
      {
        Log.i("MicroMsg.SceneVoiceRecorderAudioManager", "checkIfSomeRequestAvailable available");
        this.hqF.invoke(Boolean.TRUE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.b
 * JD-Core Version:    0.7.0.1
 */