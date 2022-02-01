package com.tencent.mm.plugin.appbrand.jsapi.ad.e;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.c.11;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c.13;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.sdk.platformtools.ae;

final class c$4
  implements c.a
{
  c$4(c paramc) {}
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(139556);
    if (paramString.equalsIgnoreCase(this.lDt.lCt))
    {
      ae.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onRunningStateChanged, state: ".concat(String.valueOf(paramb)));
      if (paramb == b.jOb)
      {
        if (this.lDt.lDr != null)
        {
          paramString = this.lDt.lDr;
          paramString.k(new c.13(paramString));
          AppMethodBeat.o(139556);
        }
      }
      else if ((paramb == b.jOa) && (this.lDt.lDr != null))
      {
        paramString = this.lDt.lDr;
        paramString.k(new c.11(paramString));
      }
    }
    AppMethodBeat.o(139556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.e.c.4
 * JD-Core Version:    0.7.0.1
 */