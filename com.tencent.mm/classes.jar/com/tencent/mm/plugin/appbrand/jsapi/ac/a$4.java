package com.tencent.mm.plugin.appbrand.jsapi.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.d.a;
import com.tencent.mm.sdk.platformtools.ae;

final class a$4
  extends d
{
  a$4(a parama) {}
  
  public final boolean tL(int paramInt)
  {
    AppMethodBeat.i(222694);
    if (a.b(this.lzL) == null) {}
    for (com.tencent.mm.plugin.appbrand.platform.window.d locald = null; locald != null; locald = a.b(this.lzL).getFullscreenImpl())
    {
      locald.rM(d.a.vf(paramInt));
      AppMethodBeat.o(222694);
      return true;
    }
    ae.w("MicroMsg.AppBrandHTMLWebView", "onSetRequestedOrientation hash[%d] NULL fullscreenImpl");
    AppMethodBeat.o(222694);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.a.4
 * JD-Core Version:    0.7.0.1
 */