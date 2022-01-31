package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.mm.sdk.platformtools.ab;

final class h$6
  implements f.e
{
  h$6(h paramh, v paramv, h.b paramb, long paramLong, String paramString) {}
  
  public final void onReady()
  {
    AppMethodBeat.i(141657);
    this.hVQ.b(this);
    this.ivS.run();
    long l1 = System.currentTimeMillis();
    long l2 = this.dZo;
    ab.i("MicroMsg.AppBrandMultiplePage", "Tab[%s][%s] onReady received, time: %d", new Object[] { this.ivQ.getAppId(), this.val$url, Long.valueOf(l1 - l2) });
    AppMethodBeat.o(141657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.h.6
 * JD-Core Version:    0.7.0.1
 */