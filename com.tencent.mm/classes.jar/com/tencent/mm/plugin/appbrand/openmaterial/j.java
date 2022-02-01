package com.tencent.mm.plugin.appbrand.openmaterial;

import android.os.Looper;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface j
{
  public static final j nlj = new j()
  {
    public final void ae(Runnable paramAnonymousRunnable)
    {
      AppMethodBeat.i(194341);
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        paramAnonymousRunnable.run();
        AppMethodBeat.o(194341);
        return;
      }
      h.RTc.aV(paramAnonymousRunnable);
      AppMethodBeat.o(194341);
    }
  };
  
  public abstract void ae(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.j
 * JD-Core Version:    0.7.0.1
 */