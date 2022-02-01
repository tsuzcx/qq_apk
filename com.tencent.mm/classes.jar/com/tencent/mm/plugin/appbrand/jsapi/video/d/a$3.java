package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.ae;

final class a$3
  implements f.b
{
  a$3(a parama, e parame, AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(211247);
    h.d locald = h.KU(this.kFs.getAppId());
    ae.i("MicroMsg.JsApiInsertVideoPlayer", "VideoPlayer enter background, pause type:%s", new Object[] { locald.name() });
    if (locald == h.d.jzn)
    {
      this.lun.tt(2);
      AppMethodBeat.o(211247);
      return;
    }
    if (locald == h.d.jzj)
    {
      this.lun.tt(1);
      AppMethodBeat.o(211247);
      return;
    }
    this.lun.tt(3);
    AppMethodBeat.o(211247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.a.3
 * JD-Core Version:    0.7.0.1
 */