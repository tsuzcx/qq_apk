package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.sdk.platformtools.ab;

final class a$3
  implements f.b
{
  a$3(a parama, com.tencent.mm.plugin.appbrand.jsapi.e parame, AppBrandLivePlayerView paramAppBrandLivePlayerView) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(96072);
    e.d locald = com.tencent.mm.plugin.appbrand.e.xX(this.hEL.getAppId());
    ab.i("MicroMsg.JsApiInsertLivePlayer", "LivePlayer enter background, pause type:%s", new Object[] { locald.name() });
    if (locald == e.d.gPk)
    {
      this.hNC.fx(2);
      AppMethodBeat.o(96072);
      return;
    }
    if (locald == e.d.gPg)
    {
      this.hNC.fx(1);
      AppMethodBeat.o(96072);
      return;
    }
    this.hNC.fx(3);
    AppMethodBeat.o(96072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a.3
 * JD-Core Version:    0.7.0.1
 */