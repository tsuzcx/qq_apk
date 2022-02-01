package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.ConcurrentLinkedQueue;

final class AppBrandRuntime$24
  implements AppBrandRuntime.a
{
  AppBrandRuntime$24(AppBrandRuntime paramAppBrandRuntime, ConcurrentLinkedQueue paramConcurrentLinkedQueue, AppBrandRuntime.b paramb, AppBrandRuntime.a parama) {}
  
  public final void done()
  {
    AppMethodBeat.i(134466);
    if (!this.iEo.remove(this.iEp))
    {
      ad.e("MicroMsg.AppBrandRuntime", "AppBrandRuntime[%s].prepare() duplicate ready() called, PrepareProcess[%s]", new Object[] { this.iEc.mAppId, this.iEp });
      AppMethodBeat.o(134466);
      return;
    }
    ad.i("MicroMsg.AppBrandRuntime", "AppBrandRuntime[%s].prepare() PrepareProcess[%s] done", new Object[] { this.iEc.mAppId, this.iEp });
    if (this.iEo.isEmpty()) {
      this.iEq.done();
    }
    AppMethodBeat.o(134466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.24
 * JD-Core Version:    0.7.0.1
 */