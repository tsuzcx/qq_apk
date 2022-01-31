package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class i$d$1
  implements Runnable
{
  i$d$1(i.d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(141627);
    if (!this.gQm.gQl)
    {
      i locali = this.gQm.gPY;
      if (!locali.mFinished)
      {
        if (locali.mInitialized)
        {
          d.e("MicroMsg.AppBrandRuntime", "initRuntime, mInitialized TRUE !!!  go check callee %s", new Object[] { bo.l(new Throwable()) });
          AppMethodBeat.o(141627);
          return;
        }
        d.d("MicroMsg.AppBrandRuntime", "initRuntime %s", new Object[] { locali.mAppId });
        new i.10(locali).run();
      }
    }
    AppMethodBeat.o(141627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.d.1
 * JD-Core Version:    0.7.0.1
 */