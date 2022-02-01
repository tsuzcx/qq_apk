package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.sdk.platformtools.Log;

final class a$3
  implements i.b
{
  a$3(a parama, h paramh, AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(328192);
    k.d locald = k.Uo(this.rJh.getAppId());
    Log.i("MicroMsg.JsApiInsertVideoPlayer", "VideoPlayer enter background, pause type:%s", new Object[] { locald.name() });
    if (locald == k.d.qrM)
    {
      this.sEq.Bd(2);
      AppMethodBeat.o(328192);
      return;
    }
    if (locald == k.d.qrI)
    {
      this.sEq.Bd(1);
      AppMethodBeat.o(328192);
      return;
    }
    this.sEq.Bd(3);
    AppMethodBeat.o(328192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.a.3
 * JD-Core Version:    0.7.0.1
 */