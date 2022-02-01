package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class p$10
  implements Runnable
{
  p$10(p paramp, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(163900);
    if (this.jCE.isDestroyed())
    {
      ae.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, finished appId[%s]", new Object[] { this.jCE.mAppId });
      AppMethodBeat.o(163900);
      return;
    }
    p.a(this.jCE, new p.10.1(this), p.m(this.jCE));
    AppMethodBeat.o(163900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.10
 * JD-Core Version:    0.7.0.1
 */