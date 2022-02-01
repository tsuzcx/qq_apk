package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class b
{
  private static MMHandler rjW;
  private static MMHandler rjX;
  private static MMHandler rjY;
  
  static
  {
    AppMethodBeat.i(121140);
    rjW = new MMHandler("DynamicPage#WorkerThread");
    rjX = new MMHandler("DynamicPage#IPCThread");
    rjY = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(121140);
  }
  
  public static boolean ac(Runnable paramRunnable)
  {
    AppMethodBeat.i(121139);
    boolean bool = rjY.post(paramRunnable);
    AppMethodBeat.o(121139);
    return bool;
  }
  
  public static boolean j(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(121138);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(121138);
      return false;
    }
    boolean bool = rjW.postDelayed(paramRunnable, paramLong);
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
    boolean bool = rjW.post(paramRunnable);
    AppMethodBeat.o(121137);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b
 * JD-Core Version:    0.7.0.1
 */