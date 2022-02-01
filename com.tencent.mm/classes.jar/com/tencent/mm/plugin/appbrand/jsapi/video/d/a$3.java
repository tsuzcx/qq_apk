package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.ac;

final class a$3
  implements f.b
{
  a$3(a parama, e parame, AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(194407);
    g.d locald = g.Hg(this.khm.getAppId());
    ac.i("MicroMsg.JsApiInsertVideoPlayer", "VideoPlayer enter background, pause type:%s", new Object[] { locald.name() });
    if (locald == g.d.jdi)
    {
      this.kTn.sM(2);
      AppMethodBeat.o(194407);
      return;
    }
    if (locald == g.d.jde)
    {
      this.kTn.sM(1);
      AppMethodBeat.o(194407);
      return;
    }
    this.kTn.sM(3);
    AppMethodBeat.o(194407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.a.3
 * JD-Core Version:    0.7.0.1
 */