package com.tencent.mm.plugin.appbrand.z;

import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ao;

@Deprecated
public class l
{
  private static final Object mnR;
  private static volatile a mnS;
  
  static
  {
    AppMethodBeat.i(140849);
    mnR = new Object();
    mnS = null;
    AppMethodBeat.o(140849);
  }
  
  public static void bxi()
  {
    AppMethodBeat.i(140846);
    if (mnS != null) {
      try
      {
        if (mnS != null) {
          mnS.removeCallbacksAndMessages(null);
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
  
  public static a bxj()
  {
    AppMethodBeat.i(201065);
    if (mnS == null) {}
    try
    {
      if (mnS == null) {
        mnS = new a("Luggage.Common.ThreadUtil.WORKER_THREAD");
      }
      a locala = mnS;
      AppMethodBeat.o(201065);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(201065);
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
    h.JZN.aQ(paramRunnable);
    AppMethodBeat.o(140848);
  }
  
  @Deprecated
  public static final class a
    extends ao
  {
    a(String paramString)
    {
      super();
    }
    
    public final Looper getLooper()
    {
      AppMethodBeat.i(201064);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(201064);
      throw localUnsupportedOperationException;
    }
    
    public final boolean j(Runnable paramRunnable, long paramLong)
    {
      AppMethodBeat.i(201063);
      boolean bool = super.postDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(201063);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.l
 * JD-Core Version:    0.7.0.1
 */