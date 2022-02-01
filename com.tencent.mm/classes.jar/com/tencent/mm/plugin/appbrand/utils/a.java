package com.tencent.mm.plugin.appbrand.utils;

import android.system.ErrnoException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  implements com.tencent.mm.kernel.api.c, Runnable
{
  private final Runnable mRunnable;
  private volatile boolean rio;
  
  public a(Runnable paramRunnable)
  {
    AppMethodBeat.i(250569);
    this.rio = false;
    this.mRunnable = paramRunnable;
    com.tencent.mm.kernel.a.c.aHV().add(this);
    AppMethodBeat.o(250569);
  }
  
  public final void onAccountInitialized(f.c paramc) {}
  
  public final void onAccountRelease()
  {
    this.rio = true;
  }
  
  public final void run()
  {
    AppMethodBeat.i(250574);
    try
    {
      this.mRunnable.run();
      AppMethodBeat.o(250574);
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof ErrnoException))
      {
        AppMethodBeat.o(250574);
        return;
      }
      Log.printErrStackTrace("MicroMsg.AccountScopedRunnable", localThrowable, "caught exception inside AccountScopedRunnable", new Object[0]);
      if ((!h.aHE().kbT) || (this.rio))
      {
        AppMethodBeat.o(250574);
        return;
      }
      AppMethodBeat.o(250574);
      throw localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.a
 * JD-Core Version:    0.7.0.1
 */