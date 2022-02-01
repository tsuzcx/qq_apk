package com.tencent.mm.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveConstants$Confetti;", "", "()V", "CONFETTI_SIZE", "", "getCONFETTI_SIZE", "()I", "HIGH_LIGHT_CONFETTI_SIZE", "getHIGH_LIGHT_CONFETTI_SIZE", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l$b
{
  public static final b mYf;
  private static final int mYg;
  private static final int mYh;
  
  static
  {
    AppMethodBeat.i(246628);
    mYf = new b();
    mYg = bd.fromDPToPix(MMApplicationContext.getContext(), 40);
    mYh = bd.fromDPToPix(MMApplicationContext.getContext(), 48);
    AppMethodBeat.o(246628);
  }
  
  public static int bhn()
  {
    return mYg;
  }
  
  public static int bho()
  {
    return mYh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.model.l.b
 * JD-Core Version:    0.7.0.1
 */