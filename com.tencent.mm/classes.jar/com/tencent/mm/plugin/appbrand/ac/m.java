package com.tencent.mm.plugin.appbrand.ac;

import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

@Deprecated
public class m
{
  private static final Object rim;
  private static volatile a rin;
  
  static
  {
    AppMethodBeat.i(140849);
    rim = new Object();
    rin = null;
    AppMethodBeat.o(140849);
  }
  
  public static void clU()
  {
    AppMethodBeat.i(140846);
    if (rin != null) {
      try
      {
        if (rin != null) {
          rin.removeCallbacksAndMessages(null);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(140846);
      }
    }
    AppMethodBeat.o(140846);
  }
  
  public static a clV()
  {
    AppMethodBeat.i(209002);
    if (rin == null) {}
    try
    {
      if (rin == null) {
        rin = new a("Luggage.Common.ThreadUtil.WORKER_THREAD");
      }
      a locala = rin;
      AppMethodBeat.o(209002);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(209002);
    }
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(140848);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(140848);
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(140848);
      return;
    }
    h.ZvG.bc(paramRunnable);
    AppMethodBeat.o(140848);
  }
  
  @Deprecated
  public static final class a
    extends MMHandler
  {
    a(String paramString)
    {
      super();
    }
    
    public final Looper getLooper()
    {
      AppMethodBeat.i(207486);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(207486);
      throw localUnsupportedOperationException;
    }
    
    public final boolean i(Runnable paramRunnable, long paramLong)
    {
      AppMethodBeat.i(207485);
      boolean bool = super.postDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(207485);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.m
 * JD-Core Version:    0.7.0.1
 */