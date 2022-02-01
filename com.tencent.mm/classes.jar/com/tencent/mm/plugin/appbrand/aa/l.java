package com.tencent.mm.plugin.appbrand.aa;

import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

@Deprecated
public class l
{
  private static final Object lLU;
  private static volatile a lLV;
  
  static
  {
    AppMethodBeat.i(140849);
    lLU = new Object();
    lLV = null;
    AppMethodBeat.o(140849);
  }
  
  public static void bql()
  {
    AppMethodBeat.i(140846);
    if (lLV != null) {
      try
      {
        if (lLV != null) {
          lLV.removeCallbacksAndMessages(null);
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
  
  public static a bqm()
  {
    AppMethodBeat.i(194910);
    if (lLV == null) {}
    try
    {
      if (lLV == null) {
        lLV = new a("Luggage.Common.ThreadUtil.WORKER_THREAD");
      }
      a locala = lLV;
      AppMethodBeat.o(194910);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(194910);
    }
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(140848);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(140848);
      return;
    }
    h.Iye.aN(paramRunnable);
    AppMethodBeat.o(140848);
  }
  
  @Deprecated
  public static final class a
    extends ap
  {
    a(String paramString)
    {
      super();
    }
    
    public final Looper getLooper()
    {
      AppMethodBeat.i(194909);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(194909);
      throw localUnsupportedOperationException;
    }
    
    public final boolean j(Runnable paramRunnable, long paramLong)
    {
      AppMethodBeat.i(194908);
      boolean bool = super.postDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(194908);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.l
 * JD-Core Version:    0.7.0.1
 */