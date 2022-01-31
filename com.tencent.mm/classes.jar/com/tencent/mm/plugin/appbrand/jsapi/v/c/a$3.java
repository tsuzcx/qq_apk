package com.tencent.mm.plugin.appbrand.jsapi.v.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class a$3
  implements f.b
{
  a$3(a parama) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(155138);
    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "onBackground");
    if (this.iiH.iiF != null) {
      this.iiH.iiF.onPause();
    }
    AppMethodBeat.o(155138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.c.a.3
 * JD-Core Version:    0.7.0.1
 */