package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

final class AppBrandVideoView$9
  implements e.g
{
  AppBrandVideoView$9(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void gK(boolean paramBoolean)
  {
    AppMethodBeat.i(194069);
    if (paramBoolean) {
      if (AppBrandVideoView.b(this.kOS).isPlaying()) {
        AppBrandVideoView.c(this.kOS).show();
      }
    }
    for (;;)
    {
      if (AppBrandVideoView.d(this.kOS) == null) {
        break label164;
      }
      b localb = AppBrandVideoView.d(this.kOS);
      int i = AppBrandVideoView.e(this.kOS);
      try
      {
        ac.i("MicroMsg.Video.JsApiVideoCallback", "onVideoClickDanmuBtn showDanmu=%b", new Object[] { Boolean.valueOf(paramBoolean) });
        JSONObject localJSONObject = localb.bkx();
        localJSONObject.put("showDanmu", paramBoolean);
        localJSONObject.put("videoPlayerId", i);
        localb.a(new b.b((byte)0), localJSONObject);
        AppMethodBeat.o(194069);
        return;
      }
      catch (JSONException localJSONException)
      {
        ac.e("MicroMsg.Video.JsApiVideoCallback", "onVideoClickDanmuBtn e=%s", new Object[] { localJSONException });
      }
      AppBrandVideoView.c(this.kOS).pause();
      continue;
      AppBrandVideoView.c(this.kOS).hide();
    }
    label164:
    AppMethodBeat.o(194069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.9
 * JD-Core Version:    0.7.0.1
 */