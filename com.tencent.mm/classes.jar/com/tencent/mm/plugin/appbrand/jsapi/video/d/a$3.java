package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.Log;

final class a$3
  implements i.b
{
  a$3(a parama, com.tencent.mm.plugin.appbrand.jsapi.h paramh, AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(234916);
    h.d locald = com.tencent.mm.plugin.appbrand.h.Uc(this.lJT.getAppId());
    Log.i("MicroMsg.JsApiInsertVideoPlayer", "VideoPlayer enter background, pause type:%s", new Object[] { locald.name() });
    if (locald == h.d.kzV)
    {
      this.mAP.xr(2);
      AppMethodBeat.o(234916);
      return;
    }
    if (locald == h.d.kzR)
    {
      this.mAP.xr(1);
      AppMethodBeat.o(234916);
      return;
    }
    this.mAP.xr(3);
    AppMethodBeat.o(234916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.a.3
 * JD-Core Version:    0.7.0.1
 */