package com.tencent.kinda.modularize;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class KindaDebugConfig
{
  private static volatile boolean sLibReloading = false;
  
  public static boolean isLibReloading()
  {
    return sLibReloading;
  }
  
  public static void markLibReloading()
  {
    AppMethodBeat.i(221823);
    ae.d("KindaHotReload", "mark reloading flag");
    AppMethodBeat.o(221823);
  }
  
  public static void resetLibReloading()
  {
    AppMethodBeat.i(221824);
    ae.d("KindaHotReload", "reset reloading flag");
    sLibReloading = false;
    AppMethodBeat.o(221824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.modularize.KindaDebugConfig
 * JD-Core Version:    0.7.0.1
 */