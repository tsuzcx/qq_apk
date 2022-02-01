package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

public final class j
{
  private static ap tCJ;
  
  static
  {
    AppMethodBeat.i(89420);
    tCJ = new ap("MMSightHandler");
    AppMethodBeat.o(89420);
  }
  
  public static void ae(Runnable paramRunnable)
  {
    AppMethodBeat.i(89418);
    tCJ.postToWorker(paramRunnable);
    AppMethodBeat.o(89418);
  }
  
  public static void af(Runnable paramRunnable)
  {
    AppMethodBeat.i(89419);
    tCJ.postDelayed(paramRunnable, 2000L);
    AppMethodBeat.o(89419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.j
 * JD-Core Version:    0.7.0.1
 */