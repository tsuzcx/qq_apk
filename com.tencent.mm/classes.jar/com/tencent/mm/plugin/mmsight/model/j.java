package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

public final class j
{
  private static ap vOm;
  
  static
  {
    AppMethodBeat.i(89420);
    vOm = new ap("MMSightHandler");
    AppMethodBeat.o(89420);
  }
  
  public static void af(Runnable paramRunnable)
  {
    AppMethodBeat.i(89418);
    vOm.postToWorker(paramRunnable);
    AppMethodBeat.o(89418);
  }
  
  public static void ag(Runnable paramRunnable)
  {
    AppMethodBeat.i(89419);
    vOm.postDelayed(paramRunnable, 2000L);
    AppMethodBeat.o(89419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.j
 * JD-Core Version:    0.7.0.1
 */