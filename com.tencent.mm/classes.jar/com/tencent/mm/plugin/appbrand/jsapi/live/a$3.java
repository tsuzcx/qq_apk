package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.sdk.platformtools.ad;

final class a$3
  implements f.b
{
  a$3(a parama, e parame, AppBrandLivePlayerView paramAppBrandLivePlayerView) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(145846);
    g.d locald = g.Dd(this.jGO.getAppId());
    ad.i("MicroMsg.JsApiInsertLivePlayer", "LivePlayer enter background, pause type:%s", new Object[] { locald.name() });
    if (locald == g.d.iDi)
    {
      this.jSS.gP(2);
      AppMethodBeat.o(145846);
      return;
    }
    if (locald == g.d.iDe)
    {
      this.jSS.gP(1);
      AppMethodBeat.o(145846);
      return;
    }
    this.jSS.gP(3);
    AppMethodBeat.o(145846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a.3
 * JD-Core Version:    0.7.0.1
 */