package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.r.a.d.a;
import com.tencent.mm.sdk.platformtools.ac;

final class a$4
  extends d
{
  a$4(a parama) {}
  
  public final boolean td(int paramInt)
  {
    AppMethodBeat.i(186772);
    if (a.b(this.kYl) == null) {}
    for (com.tencent.mm.plugin.appbrand.r.a.d locald = null; locald != null; locald = a.b(this.kYl).getFullscreenImpl())
    {
      locald.rj(d.a.uw(paramInt));
      AppMethodBeat.o(186772);
      return true;
    }
    ac.w("MicroMsg.AppBrandHTMLWebView", "onSetRequestedOrientation hash[%d] NULL fullscreenImpl");
    AppMethodBeat.o(186772);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.a.4
 * JD-Core Version:    0.7.0.1
 */