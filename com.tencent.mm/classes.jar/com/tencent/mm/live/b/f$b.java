package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.ao;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveConstants$Confetti;", "", "()V", "CONFETTI_SIZE", "", "getCONFETTI_SIZE", "()I", "plugin-logic_release"})
public final class f$b
{
  private static final int gtl;
  public static final b gtm;
  
  static
  {
    AppMethodBeat.i(189754);
    gtm = new b();
    gtl = ao.fromDPToPix(ai.getContext(), 40);
    AppMethodBeat.o(189754);
  }
  
  public static int akk()
  {
    return gtl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.f.b
 * JD-Core Version:    0.7.0.1
 */