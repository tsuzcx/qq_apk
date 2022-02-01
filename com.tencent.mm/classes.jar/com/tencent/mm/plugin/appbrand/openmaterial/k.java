package com.tencent.mm.plugin.appbrand.openmaterial;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public abstract interface k
{
  public static final k trz = new k()
  {
    public final void an(Runnable paramAnonymousRunnable)
    {
      AppMethodBeat.i(323650);
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        paramAnonymousRunnable.run();
        AppMethodBeat.o(323650);
        return;
      }
      h.ahAA.bk(paramAnonymousRunnable);
      AppMethodBeat.o(323650);
    }
  };
  
  public abstract void an(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.k
 * JD-Core Version:    0.7.0.1
 */