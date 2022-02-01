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
    AppMethodBeat.i(194062);
    g.d locald = g.Dd(this.jGO.getAppId());
    ad.i("MicroMsg.JsApiInsertVideoPlayer", "VideoPlayer enter background, pause type:%s", new Object[] { locald.name() });
    if (locald == g.d.iDi)
    {
      this.krX.rV(2);
      AppMethodBeat.o(194062);
      return;
    }
    if (locald == g.d.iDe)
    {
      this.krX.rV(1);
      AppMethodBeat.o(194062);
      return;
    }
    this.krX.rV(3);
    AppMethodBeat.o(194062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.a.3
 * JD-Core Version:    0.7.0.1
 */