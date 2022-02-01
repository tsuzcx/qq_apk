package com.tencent.mm.plugin.audio.broadcast.headset;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/broadcast/headset/HeadsetPlugMgr;", "", "()V", "onHeadsetPlugStateUpdate", "", "isConnected", "", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a uUS;
  
  static
  {
    AppMethodBeat.i(263804);
    uUS = new a();
    AppMethodBeat.o(263804);
  }
  
  public static final void lM(boolean paramBoolean)
  {
    AppMethodBeat.i(263795);
    if (paramBoolean)
    {
      locala = com.tencent.mm.plugin.audio.c.a.uVi;
      a.a.cTW().nW(8);
      AppMethodBeat.o(263795);
      return;
    }
    a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    a.a.cTW().nW(9);
    AppMethodBeat.o(263795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.headset.a
 * JD-Core Version:    0.7.0.1
 */