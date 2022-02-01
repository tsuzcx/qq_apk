package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class b
{
  private static MMHandler ogs;
  private static MMHandler ogt;
  private static MMHandler ogu;
  
  static
  {
    AppMethodBeat.i(121140);
    ogs = new MMHandler("DynamicPage#WorkerThread");
    ogt = new MMHandler("DynamicPage#IPCThread");
    ogu = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(121140);
  }
  
  public static boolean W(Runnable paramRunnable)
  {
    AppMethodBeat.i(121139);
    boolean bool = ogu.post(paramRunnable);
    AppMethodBeat.o(121139);
    return bool;
  }
  
  public static boolean i(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(121138);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(121138);
      return false;
    }
    boolean bool = ogs.postDelayed(paramRunnable, paramLong);
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
    boolean bool = ogs.post(paramRunnable);
    AppMethodBeat.o(121137);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b
 * JD-Core Version:    0.7.0.1
 */