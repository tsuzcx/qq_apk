package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au.a;
import org.json.JSONException;
import org.json.JSONObject;

final class AppBrandVideoView$7
  implements au.a
{
  AppBrandVideoView$7(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(194066);
    int j = this.kOS.getCacheTimeSec();
    int i = this.kOS.getDuration();
    b localb;
    if (i != 0)
    {
      j = (int)(j * 100.0F / i);
      if (j != AppBrandVideoView.L(this.kOS))
      {
        AppBrandVideoView.a(this.kOS, j);
        if (AppBrandVideoView.d(this.kOS) != null) {
          localb = AppBrandVideoView.d(this.kOS);
        }
      }
    }
    try
    {
      ac.i("MicroMsg.Video.JsApiVideoCallback", "onVideoCacheUpdate, percent:%d, duration:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      JSONObject localJSONObject = localb.bkx();
      localJSONObject.put("buffered", j);
      localJSONObject.put("duration", i);
      localb.a(new b.i((byte)0), localJSONObject);
      AppMethodBeat.o(194066);
      return true;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ac.e("MicroMsg.Video.JsApiVideoCallback", "onVideoCacheUpdate e=%s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.7
 * JD-Core Version:    0.7.0.1
 */