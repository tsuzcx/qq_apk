package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class j
{
  private static MMHandler zuu;
  
  static
  {
    AppMethodBeat.i(89420);
    zuu = new MMHandler("MMSightHandler");
    AppMethodBeat.o(89420);
  }
  
  public static void aj(Runnable paramRunnable)
  {
    AppMethodBeat.i(89418);
    zuu.postToWorker(paramRunnable);
    AppMethodBeat.o(89418);
  }
  
  public static void ak(Runnable paramRunnable)
  {
    AppMethodBeat.i(89419);
    zuu.postDelayed(paramRunnable, 2000L);
    AppMethodBeat.o(89419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.j
 * JD-Core Version:    0.7.0.1
 */