package com.tencent.mm.plugin.appbrand.jsapi.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.platform.window.d.a;
import com.tencent.mm.sdk.platformtools.Log;

final class a$4
  extends d
{
  a$4(a parama) {}
  
  public final boolean xJ(int paramInt)
  {
    AppMethodBeat.i(227005);
    if (a.b(this.mGZ) == null) {}
    for (com.tencent.mm.plugin.appbrand.platform.window.d locald = null; locald != null; locald = a.b(this.mGZ).getFullscreenImpl())
    {
      locald.vH(d.a.yX(paramInt));
      AppMethodBeat.o(227005);
      return true;
    }
    Log.w("MicroMsg.AppBrandHTMLWebView", "onSetRequestedOrientation hash[%d] NULL fullscreenImpl");
    AppMethodBeat.o(227005);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.a.4
 * JD-Core Version:    0.7.0.1
 */