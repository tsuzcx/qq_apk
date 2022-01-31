package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.f;

final class i$1
  implements a<Void, Void>
{
  i$1(i parami) {}
  
  private Void atf()
  {
    AppMethodBeat.i(129477);
    try
    {
      i.a(this.gXS);
      AppMethodBeat.o(129477);
      return null;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", localThrowable, "handleRetry()", new Object[0]);
        f.dQn().cK(null);
        synchronized (this.gXS)
        {
          i.b(this.gXS);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.i.1
 * JD-Core Version:    0.7.0.1
 */