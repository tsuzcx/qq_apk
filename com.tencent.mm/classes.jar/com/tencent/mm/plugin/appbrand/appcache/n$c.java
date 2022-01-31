package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.atomic.AtomicBoolean;

public final class n$c
{
  private static final n.d gUl;
  
  static
  {
    AppMethodBeat.i(129339);
    gUl = new n.d();
    AppMethodBeat.o(129339);
  }
  
  public static n avp()
  {
    AppMethodBeat.i(129337);
    if (r.avy())
    {
      localObject = gUl;
      AppMethodBeat.o(129337);
      return localObject;
    }
    Object localObject = au.gWC;
    AppMethodBeat.o(129337);
    return localObject;
  }
  
  public static void interrupt()
  {
    AppMethodBeat.i(129338);
    n.d locald = gUl;
    try
    {
      h.qsU.cT(1007, 2);
      locald.gUm.set(true);
      AppMethodBeat.o(129338);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", localThrowable, "cleanup interrupted report", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.n.c
 * JD-Core Version:    0.7.0.1
 */