package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class AppBrandVideoView$9
  implements c.f
{
  AppBrandVideoView$9(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void du(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (AppBrandVideoView.b(this.gDS).isPlaying()) {
        AppBrandVideoView.c(this.gDS).show();
      }
    }
    for (;;)
    {
      j localj;
      int i;
      if (AppBrandVideoView.d(this.gDS) != null)
      {
        localj = AppBrandVideoView.d(this.gDS);
        i = AppBrandVideoView.e(this.gDS);
      }
      try
      {
        y.i("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn showDanmu=%b", new Object[] { Boolean.valueOf(paramBoolean) });
        JSONObject localJSONObject = localj.akU();
        localJSONObject.put("showDanmu", paramBoolean);
        localJSONObject.put("videoPlayerId", i);
        localj.a(new j.b((byte)0), localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        y.e("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn e=%s", new Object[] { localJSONException });
      }
      AppBrandVideoView.c(this.gDS).pause();
      continue;
      AppBrandVideoView.c(this.gDS).hide();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.9
 * JD-Core Version:    0.7.0.1
 */