package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.s.a.d.a;
import com.tencent.mm.sdk.platformtools.ad;

final class a$4
  extends d
{
  a$4(a parama) {}
  
  public final boolean sn(int paramInt)
  {
    AppMethodBeat.i(195950);
    if (a.b(this.kwX) == null) {}
    for (com.tencent.mm.plugin.appbrand.s.a.d locald = null; locald != null; locald = a.b(this.kwX).getFullscreenImpl())
    {
      locald.qw(d.a.tE(paramInt));
      AppMethodBeat.o(195950);
      return true;
    }
    ad.w("MicroMsg.AppBrandHTMLWebView", "onSetRequestedOrientation hash[%d] NULL fullscreenImpl");
    AppMethodBeat.o(195950);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.a.4
 * JD-Core Version:    0.7.0.1
 */