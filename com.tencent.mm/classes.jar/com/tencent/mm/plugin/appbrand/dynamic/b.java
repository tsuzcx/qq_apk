package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

public final class b
{
  private static ap jki;
  private static ap jkj;
  private static ap jkk;
  
  static
  {
    AppMethodBeat.i(121140);
    jki = new ap("DynamicPage#WorkerThread");
    jkj = new ap("DynamicPage#IPCThread");
    jkk = new ap(Looper.getMainLooper());
    AppMethodBeat.o(121140);
  }
  
  public static boolean R(Runnable paramRunnable)
  {
    AppMethodBeat.i(121139);
    boolean bool = jkk.post(paramRunnable);
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
    boolean bool = jki.postDelayed(paramRunnable, paramLong);
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
    boolean bool = jki.post(paramRunnable);
    AppMethodBeat.o(121137);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b
 * JD-Core Version:    0.7.0.1
 */