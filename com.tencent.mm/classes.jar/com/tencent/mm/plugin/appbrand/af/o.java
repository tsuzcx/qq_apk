package com.tencent.mm.plugin.appbrand.af;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public class o
{
  private static final Object uqi;
  private static volatile a uqj;
  
  static
  {
    AppMethodBeat.i(140849);
    uqi = new Object();
    uqj = null;
    AppMethodBeat.o(140849);
  }
  
  @Deprecated
  public static void cNl()
  {
    AppMethodBeat.i(140846);
    if (uqj != null) {
      try
      {
        if (uqj != null) {
          uqj.removeCallbacksAndMessages(null);
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
  
  @Deprecated
  public static a cNm()
  {
    AppMethodBeat.i(318720);
    if (uqj == null) {}
    try
    {
      if (uqj == null) {
        uqj = new a("Luggage.Common.ThreadUtil.WORKER_THREAD");
      }
      a locala = uqj;
      AppMethodBeat.o(318720);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(318720);
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
    h.ahAA.bk(paramRunnable);
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
      AppMethodBeat.i(318725);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(318725);
      throw localUnsupportedOperationException;
    }
    
    public final boolean j(Runnable paramRunnable, long paramLong)
    {
      AppMethodBeat.i(318724);
      boolean bool = super.postDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(318724);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.o
 * JD-Core Version:    0.7.0.1
 */