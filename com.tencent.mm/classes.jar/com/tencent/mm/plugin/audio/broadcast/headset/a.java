package com.tencent.mm.plugin.audio.broadcast.headset;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/audio/broadcast/headset/HeadsetPlugMgr;", "", "()V", "onHeadsetPlugStateUpdate", "", "isConnected", "", "plugin-audio_release"})
public final class a
{
  public static final a nry;
  
  static
  {
    AppMethodBeat.i(199740);
    nry = new a();
    AppMethodBeat.o(199740);
  }
  
  public static final void ip(boolean paramBoolean)
  {
    AppMethodBeat.i(199739);
    if (paramBoolean)
    {
      locala = com.tencent.mm.plugin.audio.c.a.nrV;
      a.a.bGC().hC(8);
      AppMethodBeat.o(199739);
      return;
    }
    a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    a.a.bGC().hC(9);
    AppMethodBeat.o(199739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.headset.a
 * JD-Core Version:    0.7.0.1
 */