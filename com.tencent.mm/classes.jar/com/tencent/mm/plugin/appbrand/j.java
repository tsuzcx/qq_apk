package com.tencent.mm.plugin.appbrand;

import android.system.ErrnoException;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.d;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
{
  private static final com.tencent.mm.sdk.b.c<d> iDr;
  
  static
  {
    AppMethodBeat.i(43798);
    iDr = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(43798);
  }
  
  public static void aLG()
  {
    AppMethodBeat.i(195519);
    h.Iye.f(new a(new j.2()), "MicroMsg.AppBrandPruner");
    AppMethodBeat.o(195519);
  }
  
  public static void release()
  {
    AppMethodBeat.i(43797);
    iDr.dead();
    AppMethodBeat.o(43797);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(43796);
    iDr.alive();
    AppMethodBeat.o(43796);
  }
  
  final class a
    implements com.tencent.mm.kernel.api.c, Runnable
  {
    private volatile boolean iDs;
    
    a()
    {
      AppMethodBeat.i(195516);
      this.iDs = false;
      com.tencent.mm.kernel.a.c.afO().add(this);
      AppMethodBeat.o(195516);
    }
    
    public final void onAccountInitialized(e.c paramc) {}
    
    public final void onAccountRelease()
    {
      this.iDs = true;
    }
    
    public final void run()
    {
      AppMethodBeat.i(195517);
      try
      {
        j.this.run();
        AppMethodBeat.o(195517);
        return;
      }
      catch (Throwable localThrowable)
      {
        if ((localThrowable instanceof ErrnoException))
        {
          AppMethodBeat.o(195517);
          return;
        }
        ad.printErrStackTrace("MicroMsg.AppBrandPruner", localThrowable, "caught exception while prune", new Object[0]);
        if (!this.iDs)
        {
          AppMethodBeat.o(195517);
          throw localThrowable;
        }
        AppMethodBeat.o(195517);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j
 * JD-Core Version:    0.7.0.1
 */