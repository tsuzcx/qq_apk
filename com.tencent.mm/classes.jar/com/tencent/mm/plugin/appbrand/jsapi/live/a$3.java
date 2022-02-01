package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.sdk.platformtools.Log;

final class a$3
  implements i.b
{
  a$3(a parama, com.tencent.mm.plugin.appbrand.jsapi.h paramh, AppBrandLivePlayerView paramAppBrandLivePlayerView) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(145846);
    h.d locald = com.tencent.mm.plugin.appbrand.h.Uc(this.lJT.getAppId());
    Log.i("MicroMsg.JsApiInsertLivePlayer", "LivePlayer enter background, pause type:%s", new Object[] { locald.name() });
    if (locald == h.d.kzV)
    {
      this.lXN.hU(2);
      AppMethodBeat.o(145846);
      return;
    }
    if (locald == h.d.kzR)
    {
      this.lXN.hU(1);
      AppMethodBeat.o(145846);
      return;
    }
    this.lXN.hU(3);
    AppMethodBeat.o(145846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a.3
 * JD-Core Version:    0.7.0.1
 */