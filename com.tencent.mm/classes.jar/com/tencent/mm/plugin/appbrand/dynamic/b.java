package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

public final class b
{
  private static ap keH;
  private static ap keI;
  private static ap keJ;
  
  static
  {
    AppMethodBeat.i(121140);
    keH = new ap("DynamicPage#WorkerThread");
    keI = new ap("DynamicPage#IPCThread");
    keJ = new ap(Looper.getMainLooper());
    AppMethodBeat.o(121140);
  }
  
  public static boolean S(Runnable paramRunnable)
  {
    AppMethodBeat.i(121139);
    boolean bool = keJ.post(paramRunnable);
    AppMethodBeat.o(121139);
    return bool;
  }
  
  public static boolean k(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(121138);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(121138);
      return false;
    }
    boolean bool = keH.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(121138);
    return bool;
  }
  
  public static boolean postToWorker(Runnable paramRunnable)
  {
    AppMethodBeat.i(121137);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(121137);
      return false;
    }
    boolean bool = keH.post(paramRunnable);
    AppMethodBeat.o(121137);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b
 * JD-Core Version:    0.7.0.1
 */