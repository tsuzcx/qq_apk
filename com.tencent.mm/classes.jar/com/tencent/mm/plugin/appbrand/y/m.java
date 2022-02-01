package com.tencent.mm.plugin.appbrand.y;

import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;

@Deprecated
public class m
{
  private static final Object mTx;
  private static volatile a mTy;
  
  static
  {
    AppMethodBeat.i(140849);
    mTx = new Object();
    mTy = null;
    AppMethodBeat.o(140849);
  }
  
  public static void bCi()
  {
    AppMethodBeat.i(140846);
    if (mTy != null) {
      try
      {
        if (mTy != null) {
          mTy.removeCallbacksAndMessages(null);
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
  
  public static a bCj()
  {
    AppMethodBeat.i(201307);
    if (mTy == null) {}
    try
    {
      if (mTy == null) {
        mTy = new a("Luggage.Common.ThreadUtil.WORKER_THREAD");
      }
      a locala = mTy;
      AppMethodBeat.o(201307);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(201307);
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
    h.MqF.aM(paramRunnable);
    AppMethodBeat.o(140848);
  }
  
  @Deprecated
  public static final class a
    extends aq
  {
    a(String paramString)
    {
      super();
    }
    
    public final Looper getLooper()
    {
      AppMethodBeat.i(201306);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(201306);
      throw localUnsupportedOperationException;
    }
    
    public final boolean k(Runnable paramRunnable, long paramLong)
    {
      AppMethodBeat.i(201305);
      boolean bool = super.postDelayed(paramRunnable, paramLong);
      AppMethodBeat.o(201305);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.y.m
 * JD-Core Version:    0.7.0.1
 */