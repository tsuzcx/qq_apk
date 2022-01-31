package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.o;
import com.tencent.mm.sdk.platformtools.ab;

final class u$2
  implements b.o
{
  u$2(u paramu, c paramc, int paramInt, b paramb) {}
  
  public final void ei(boolean paramBoolean)
  {
    AppMethodBeat.i(93873);
    ab.i("MicroMsg.JsApiTranslateMapMarker", "onMarkerTranslate result::%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      u.a(this.hOf, this.hKB, this.bAX, "ok", this.hNX.aDx());
      AppMethodBeat.o(93873);
      return;
    }
    u.a(this.hOf, this.hKB, this.bAX, "fail", this.hNX.aDx());
    AppMethodBeat.o(93873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.u.2
 * JD-Core Version:    0.7.0.1
 */