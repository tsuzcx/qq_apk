package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.ad;

final class a$3
  implements f.b
{
  a$3(a parama, e parame, AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(206219);
    g.d locald = g.Kv(this.kCd.getAppId());
    ad.i("MicroMsg.JsApiInsertVideoPlayer", "VideoPlayer enter background, pause type:%s", new Object[] { locald.name() });
    if (locald == g.d.jwr)
    {
      this.lpQ.tp(2);
      AppMethodBeat.o(206219);
      return;
    }
    if (locald == g.d.jwn)
    {
      this.lpQ.tp(1);
      AppMethodBeat.o(206219);
      return;
    }
    this.lpQ.tp(3);
    AppMethodBeat.o(206219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.a.3
 * JD-Core Version:    0.7.0.1
 */