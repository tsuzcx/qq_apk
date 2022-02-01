package com.tencent.mm.plugin.appbrand.openmaterial;

import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface l
{
  public static final l qmQ = new l()
  {
    public final void ah(Runnable paramAnonymousRunnable)
    {
      AppMethodBeat.i(191768);
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        paramAnonymousRunnable.run();
        AppMethodBeat.o(191768);
        return;
      }
      h.ZvG.bc(paramAnonymousRunnable);
      AppMethodBeat.o(191768);
    }
  };
  
  public abstract void ah(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.l
 * JD-Core Version:    0.7.0.1
 */