package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.aq;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/LiveConstants$Confetti;", "", "()V", "CONFETTI_SIZE", "", "getCONFETTI_SIZE", "()I", "plugin-logic_release"})
public final class f$b
{
  private static final int gPF;
  public static final b gPG;
  
  static
  {
    AppMethodBeat.i(215659);
    gPG = new b();
    gPF = aq.fromDPToPix(ak.getContext(), 40);
    AppMethodBeat.o(215659);
  }
  
  public static int anl()
  {
    return gPF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.b.f.b
 * JD-Core Version:    0.7.0.1
 */