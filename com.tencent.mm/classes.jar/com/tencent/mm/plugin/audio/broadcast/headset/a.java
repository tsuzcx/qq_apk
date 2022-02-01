package com.tencent.mm.plugin.audio.broadcast.headset;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/broadcast/headset/HeadsetPlugMgr;", "", "()V", "onHeadsetPlugStateUpdate", "", "isConnected", "", "plugin-audio_release"})
public final class a
{
  public static final a mQZ;
  
  static
  {
    AppMethodBeat.i(198342);
    mQZ = new a();
    AppMethodBeat.o(198342);
  }
  
  public static final void ig(boolean paramBoolean)
  {
    AppMethodBeat.i(198341);
    if (paramBoolean)
    {
      locala = com.tencent.mm.plugin.audio.c.a.mRw;
      a.a.bCx().hv(8);
      AppMethodBeat.o(198341);
      return;
    }
    a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    a.a.bCx().hv(9);
    AppMethodBeat.o(198341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.broadcast.headset.a
 * JD-Core Version:    0.7.0.1
 */