package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/LiveConstants$Confetti;", "", "()V", "CONFETTI_SIZE", "", "getCONFETTI_SIZE", "()I", "HIGH_LIGHT_CONFETTI_SIZE", "getHIGH_LIGHT_CONFETTI_SIZE", "plugin-logic_release"})
public final class o$b
{
  private static final int hGm;
  private static final int hGn;
  public static final b hGo;
  
  static
  {
    AppMethodBeat.i(207595);
    hGo = new b();
    hGm = at.fromDPToPix(MMApplicationContext.getContext(), 40);
    hGn = at.fromDPToPix(MMApplicationContext.getContext(), 48);
    AppMethodBeat.o(207595);
  }
  
  public static int aFl()
  {
    return hGm;
  }
  
  public static int aFm()
  {
    return hGn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.o.b
 * JD-Core Version:    0.7.0.1
 */