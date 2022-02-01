package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class i
{
  private static MMHandler EZT;
  
  static
  {
    AppMethodBeat.i(89420);
    EZT = new MMHandler("MMSightHandler");
    AppMethodBeat.o(89420);
  }
  
  public static void am(Runnable paramRunnable)
  {
    AppMethodBeat.i(89418);
    EZT.postToWorker(paramRunnable);
    AppMethodBeat.o(89418);
  }
  
  public static void ap(Runnable paramRunnable)
  {
    AppMethodBeat.i(89419);
    EZT.postDelayed(paramRunnable, 2000L);
    AppMethodBeat.o(89419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.i
 * JD-Core Version:    0.7.0.1
 */