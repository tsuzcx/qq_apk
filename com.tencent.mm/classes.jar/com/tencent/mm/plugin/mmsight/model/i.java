package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class i
{
  private static MMHandler KVF;
  
  static
  {
    AppMethodBeat.i(89420);
    KVF = new MMHandler("MMSightHandler");
    AppMethodBeat.o(89420);
  }
  
  public static void au(Runnable paramRunnable)
  {
    AppMethodBeat.i(89418);
    KVF.postToWorker(paramRunnable);
    AppMethodBeat.o(89418);
  }
  
  public static void ax(Runnable paramRunnable)
  {
    AppMethodBeat.i(89419);
    KVF.postDelayed(paramRunnable, 2000L);
    AppMethodBeat.o(89419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.i
 * JD-Core Version:    0.7.0.1
 */