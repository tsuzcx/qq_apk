package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;

public final class j
{
  private static aq wap;
  
  static
  {
    AppMethodBeat.i(89420);
    wap = new aq("MMSightHandler");
    AppMethodBeat.o(89420);
  }
  
  public static void ad(Runnable paramRunnable)
  {
    AppMethodBeat.i(89418);
    wap.postToWorker(paramRunnable);
    AppMethodBeat.o(89418);
  }
  
  public static void ae(Runnable paramRunnable)
  {
    AppMethodBeat.i(89419);
    wap.postDelayed(paramRunnable, 2000L);
    AppMethodBeat.o(89419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.j
 * JD-Core Version:    0.7.0.1
 */