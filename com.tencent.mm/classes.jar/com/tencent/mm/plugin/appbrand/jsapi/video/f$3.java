package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.sdk.platformtools.ab;

final class f$3
  implements f.b
{
  f$3(f paramf, com.tencent.mm.plugin.appbrand.jsapi.e parame, AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(126551);
    e.d locald = com.tencent.mm.plugin.appbrand.e.xX(this.hEL.getAppId());
    ab.i("MicroMsg.JsApiInsertVideoPlayer", "VideoPlayer enter background, pause type:%s", new Object[] { locald.name() });
    if (locald == e.d.gPk)
    {
      this.idM.oj(2);
      AppMethodBeat.o(126551);
      return;
    }
    if (locald == e.d.gPg)
    {
      this.idM.oj(1);
      AppMethodBeat.o(126551);
      return;
    }
    this.idM.oj(3);
    AppMethodBeat.o(126551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.f.3
 * JD-Core Version:    0.7.0.1
 */