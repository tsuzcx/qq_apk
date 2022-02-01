package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ao;

public final class j
{
  private static ao uLg;
  
  static
  {
    AppMethodBeat.i(89420);
    uLg = new ao("MMSightHandler");
    AppMethodBeat.o(89420);
  }
  
  public static void ag(Runnable paramRunnable)
  {
    AppMethodBeat.i(89418);
    uLg.postToWorker(paramRunnable);
    AppMethodBeat.o(89418);
  }
  
  public static void ah(Runnable paramRunnable)
  {
    AppMethodBeat.i(89419);
    uLg.postDelayed(paramRunnable, 2000L);
    AppMethodBeat.o(89419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.j
 * JD-Core Version:    0.7.0.1
 */