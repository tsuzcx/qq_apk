package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.jsapi.e.e;
import com.tencent.mm.sdk.platformtools.y;

final class d$3
  implements e.e
{
  d$3(d paramd, q paramq, d.b paramb, long paramLong) {}
  
  public final void onReady()
  {
    this.gza.b(this);
    this.gSH.run();
    y.i("MicroMsg.AppBrandMultiplePage", "Tab page onReady received, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.dhV) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d.3
 * JD-Core Version:    0.7.0.1
 */