package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.e.a;

final class AppBrandRuntime$c
  implements AppBrandRuntime.a, a
{
  private final String jxD;
  volatile boolean jxE;
  
  private AppBrandRuntime$c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134470);
    this.jxD = "MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify";
    ad.i("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "<init> appId[%s] hash[%d]", new Object[] { this.jxm.mAppId, Integer.valueOf(hashCode()) });
    this.jxm.keep(this);
    this.jxE = false;
    AppMethodBeat.o(134470);
  }
  
  public final void dead()
  {
    this.jxE = true;
  }
  
  public final void done()
  {
    AppMethodBeat.i(134471);
    if (!this.jxE)
    {
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134469);
          if (!AppBrandRuntime.c.this.jxE)
          {
            AppBrandRuntime.g(AppBrandRuntime.c.this.jxm);
            AppBrandRuntime.h(AppBrandRuntime.c.this.jxm);
            AppMethodBeat.o(134469);
            return;
          }
          ad.e("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check2 dead appId[%s]", new Object[] { Integer.valueOf(hashCode()), AppBrandRuntime.c.this.jxm.mAppId });
          AppMethodBeat.o(134469);
        }
      };
      this.jxm.j(local1, 0L);
      AppMethodBeat.o(134471);
      return;
    }
    ad.e("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check1 dead appId[%s]", new Object[] { Integer.valueOf(hashCode()), this.jxm.mAppId });
    AppMethodBeat.o(134471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.c
 * JD-Core Version:    0.7.0.1
 */