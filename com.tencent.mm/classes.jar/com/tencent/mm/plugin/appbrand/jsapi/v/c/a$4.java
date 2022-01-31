package com.tencent.mm.plugin.appbrand.jsapi.v.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class a$4
  implements f.d
{
  a$4(a parama) {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(155139);
    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "onForeground");
    if (this.iiH.iiF != null) {
      this.iiH.iiF.onResume();
    }
    AppMethodBeat.o(155139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.c.a.4
 * JD-Core Version:    0.7.0.1
 */