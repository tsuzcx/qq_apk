package com.tencent.mm.plugin.audio.broadcast.headset;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/audio/broadcast/headset/HeadsetPlugMgr;", "", "()V", "onHeadsetPlugStateUpdate", "", "isConnected", "", "plugin-audio_release"})
public final class a
{
  public static final a moY;
  
  static
  {
    AppMethodBeat.i(189222);
    moY = new a();
    AppMethodBeat.o(189222);
  }
  
  public static final void hI(boolean paramBoolean)
  {
    AppMethodBeat.i(189221);
    if (paramBoolean)
    {
      locala = com.tencent.mm.plugin.audio.c.a.mpv;
      a.a.bvB().hL(8);
      AppMethodBeat.o(189221);
      return;
    }
    a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    a.a.bvB().hL(9);
    AppMethodBeat.o(189221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.headset.a
 * JD-Core Version:    0.7.0.1
 */