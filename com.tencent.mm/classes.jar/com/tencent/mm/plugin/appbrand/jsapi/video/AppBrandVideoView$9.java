package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

final class AppBrandVideoView$9
  implements d.f
{
  AppBrandVideoView$9(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void ez(boolean paramBoolean)
  {
    AppMethodBeat.i(126451);
    if (paramBoolean) {
      if (AppBrandVideoView.b(this.icX).isPlaying()) {
        AppBrandVideoView.c(this.icX).show();
      }
    }
    for (;;)
    {
      if (AppBrandVideoView.d(this.icX) == null) {
        break label164;
      }
      k localk = AppBrandVideoView.d(this.icX);
      int i = AppBrandVideoView.e(this.icX);
      try
      {
        ab.i("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn showDanmu=%b", new Object[] { Boolean.valueOf(paramBoolean) });
        JSONObject localJSONObject = localk.aFD();
        localJSONObject.put("showDanmu", paramBoolean);
        localJSONObject.put("videoPlayerId", i);
        localk.a(new k.b((byte)0), localJSONObject);
        AppMethodBeat.o(126451);
        return;
      }
      catch (JSONException localJSONException)
      {
        ab.e("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn e=%s", new Object[] { localJSONException });
      }
      AppBrandVideoView.c(this.icX).pause();
      continue;
      AppBrandVideoView.c(this.icX).hide();
    }
    label164:
    AppMethodBeat.o(126451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.9
 * JD-Core Version:    0.7.0.1
 */