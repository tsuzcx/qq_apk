package com.tencent.mm.plugin.audio.broadcast.headset;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/broadcast/headset/HeadsetPlugMgr;", "", "()V", "onHeadsetPlugStateUpdate", "", "isConnected", "", "plugin-audio_release"})
public final class a
{
  public static final a oHK;
  
  static
  {
    AppMethodBeat.i(223949);
    oHK = new a();
    AppMethodBeat.o(223949);
  }
  
  public static final void jo(boolean paramBoolean)
  {
    AppMethodBeat.i(223948);
    if (paramBoolean)
    {
      locala = com.tencent.mm.plugin.audio.c.a.oIh;
      a.a.cea().iY(8);
      AppMethodBeat.o(223948);
      return;
    }
    a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    a.a.cea().iY(9);
    AppMethodBeat.o(223948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.headset.a
 * JD-Core Version:    0.7.0.1
 */