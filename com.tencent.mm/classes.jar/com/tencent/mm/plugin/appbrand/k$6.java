package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$6
  implements Runnable
{
  k$6(k paramk, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(86715);
    k localk = this.gQD;
    i locali1 = this.gQE;
    d.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl entered appId[%s]", new Object[] { locali1.mAppId });
    k.7 local7 = new k.7(localk, locali1);
    if (!localk.g(locali1))
    {
      d.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl appId[%s], not in runtime stack, just cleanup", new Object[] { locali1.mAppId });
      local7.run();
      AppMethodBeat.o(86715);
      return;
    }
    i locali2 = localk.f(locali1);
    localk.b(locali2, locali1, new k.8(localk, locali1, locali2, local7));
    AppMethodBeat.o(86715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.6
 * JD-Core Version:    0.7.0.1
 */