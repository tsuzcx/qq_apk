package com.tencent.mm.plugin.audio.broadcast.headset;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/audio/broadcast/headset/HeadsetPlugMgr;", "", "()V", "onHeadsetPlugStateUpdate", "", "isConnected", "", "plugin-audio_release"})
public final class a
{
  public static final a nwR;
  
  static
  {
    AppMethodBeat.i(201052);
    nwR = new a();
    AppMethodBeat.o(201052);
  }
  
  public static final void in(boolean paramBoolean)
  {
    AppMethodBeat.i(201051);
    if (paramBoolean)
    {
      locala = com.tencent.mm.plugin.audio.c.a.nxo;
      a.a.bHy().hE(8);
      AppMethodBeat.o(201051);
      return;
    }
    a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    a.a.bHy().hE(9);
    AppMethodBeat.o(201051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.headset.a
 * JD-Core Version:    0.7.0.1
 */