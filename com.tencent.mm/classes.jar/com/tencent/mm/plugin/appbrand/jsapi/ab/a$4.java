package com.tencent.mm.plugin.appbrand.jsapi.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.r.a.d.a;
import com.tencent.mm.sdk.platformtools.ad;

final class a$4
  extends d
{
  a$4(a parama) {}
  
  public final boolean tG(int paramInt)
  {
    AppMethodBeat.i(188535);
    if (a.b(this.lvn) == null) {}
    for (com.tencent.mm.plugin.appbrand.r.a.d locald = null; locald != null; locald = a.b(this.lvn).getFullscreenImpl())
    {
      locald.rK(d.a.va(paramInt));
      AppMethodBeat.o(188535);
      return true;
    }
    ad.w("MicroMsg.AppBrandHTMLWebView", "onSetRequestedOrientation hash[%d] NULL fullscreenImpl");
    AppMethodBeat.o(188535);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.a.4
 * JD-Core Version:    0.7.0.1
 */