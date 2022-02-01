package com.tencent.mm.plugin.appbrand.z;

import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

@Deprecated
public class m
{
  private static final Object mOt;
  private static volatile a mOu;
  
  static
  {
    AppMethodBeat.i(140849);
    mOt = new Object();
    mOu = null;
    AppMethodBeat.o(140849);
  }
  
  public static void bBo()
  {
    AppMethodBeat.i(140846);
    if (mOu != null) {
      try
      {
        if (mOu != null) {
          mOu.removeCallbacksAndMessages(null);
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
  
  public static a bBp()
  {
    AppMethodBeat.i(187740);
    if (mOu == null) {}
    try
    {
      if (mOu == null) {
        mOu = new a("Luggage.Common.ThreadUtil.WORKER_THREAD");
      }
      a locala = mOu;
      AppMethodBeat.o(187740);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(187740);
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
    h.LTJ.aP(paramRunnable);
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
      AppMethodBeat.i(187739);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(187739);
      throw localUnsupportedOperationException;
    }
    
    public final boolean k(Runnable paramRunnable, long paramLong)
    {
      AppMethodBeat.i(187738);
      boolean bool = super.postDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(187738);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.m
 * JD-Core Version:    0.7.0.1
 */