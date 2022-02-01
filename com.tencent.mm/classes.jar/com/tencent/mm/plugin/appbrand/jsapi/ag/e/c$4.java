package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.c.15;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c.17;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.sdk.platformtools.Log;

final class c$4
  implements c.a
{
  c$4(c paramc) {}
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(139556);
    if (paramString.equalsIgnoreCase(this.mLb.currentAppId))
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onRunningStateChanged, state: ".concat(String.valueOf(paramb)));
      if (paramb == b.kQI)
      {
        if (this.mLb.mKZ != null)
        {
          paramString = this.mLb.mKZ;
          paramString.k(new c.17(paramString));
          AppMethodBeat.o(139556);
        }
      }
      else if ((paramb == b.kQH) && (this.mLb.mKZ != null))
      {
        paramString = this.mLb.mKZ;
        paramString.k(new c.15(paramString));
      }
    }
    AppMethodBeat.o(139556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.4
 * JD-Core Version:    0.7.0.1
 */