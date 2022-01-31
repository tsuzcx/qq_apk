package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class e$1
  implements a.a
{
  e$1(e parame, AppBrandLivePusherView paramAppBrandLivePusherView, String paramString) {}
  
  public final void ud(String paramString)
  {
    if (!bk.bl(paramString))
    {
      y.i("MicroMsg.JsApiOperateLivePusher.javayhu", "operatePlayBgm, local file path:%s", new Object[] { paramString });
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("BGMFilePath", paramString);
        if (!this.gsm.b("playBGM", localJSONObject))
        {
          y.e("MicroMsg.JsApiOperateLivePusher.javayhu", "operatePlayBgm, play bgm fail, url:%s", new Object[] { this.val$url });
          paramString = new HashMap();
          paramString.put("url", this.val$url);
          this.gsm.a(10003, "download file fail", paramString);
        }
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          y.e("MicroMsg.JsApiOperateLivePusher.javayhu", "operatePlayBgm, set param fail", new Object[] { paramString });
        }
      }
    }
    y.e("MicroMsg.JsApiOperateLivePusher.javayhu", "operatePlayBgm, download file fail, url:%s", new Object[] { this.val$url });
    paramString = new HashMap();
    paramString.put("url", this.val$url);
    this.gsm.a(10003, "download file fail", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.e.1
 * JD-Core Version:    0.7.0.1
 */