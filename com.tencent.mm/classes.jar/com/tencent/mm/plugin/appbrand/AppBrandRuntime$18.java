package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.ConcurrentLinkedQueue;

final class AppBrandRuntime$18
  implements AppBrandRuntime.a
{
  AppBrandRuntime$18(AppBrandRuntime paramAppBrandRuntime, ConcurrentLinkedQueue paramConcurrentLinkedQueue, AppBrandRuntime.b paramb, AppBrandRuntime.a parama) {}
  
  public final void done()
  {
    AppMethodBeat.i(197175);
    if (!this.jxw.remove(this.jxx))
    {
      ad.e("MicroMsg.AppBrandRuntime", "AppBrandRuntime[%s].prepare() duplicate ready() called, PrepareProcess[%s]", new Object[] { this.jxm.mAppId, this.jxx });
      AppMethodBeat.o(197175);
      return;
    }
    ad.i("MicroMsg.AppBrandRuntime", "AppBrandRuntime[%s].prepare() PrepareProcess[%s] done", new Object[] { this.jxm.mAppId, this.jxx });
    if (this.jxw.isEmpty()) {
      this.jxy.done();
    }
    AppMethodBeat.o(197175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.18
 * JD-Core Version:    0.7.0.1
 */