package com.tencent.mm.plugin.audio.broadcast.headset;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/audio/broadcast/headset/HeadsetPlugMgr;", "", "()V", "onHeadsetPlugStateUpdate", "", "isConnected", "", "plugin-audio_release"})
public final class a
{
  public static final a rJA;
  
  static
  {
    AppMethodBeat.i(257625);
    rJA = new a();
    AppMethodBeat.o(257625);
  }
  
  public static final void kz(boolean paramBoolean)
  {
    AppMethodBeat.i(257621);
    if (paramBoolean)
    {
      locala = com.tencent.mm.plugin.audio.c.a.rJX;
      a.a.crn().ko(8);
      AppMethodBeat.o(257621);
      return;
    }
    a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    a.a.crn().ko(9);
    AppMethodBeat.o(257621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.headset.a
 * JD-Core Version:    0.7.0.1
 */