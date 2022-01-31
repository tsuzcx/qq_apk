package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

public final class i
{
  private static al oHC;
  
  static
  {
    AppMethodBeat.i(76521);
    oHC = new al("MMSightHandler");
    AppMethodBeat.o(76521);
  }
  
  public static void O(Runnable paramRunnable)
  {
    AppMethodBeat.i(76519);
    oHC.ac(paramRunnable);
    AppMethodBeat.o(76519);
  }
  
  public static void P(Runnable paramRunnable)
  {
    AppMethodBeat.i(76520);
    oHC.o(paramRunnable, 2000L);
    AppMethodBeat.o(76520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.i
 * JD-Core Version:    0.7.0.1
 */