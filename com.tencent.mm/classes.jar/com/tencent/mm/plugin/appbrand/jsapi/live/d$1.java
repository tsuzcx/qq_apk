package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class d$1
  implements b.a
{
  d$1(d paramd, AppBrandLivePusherView paramAppBrandLivePusherView, String paramString) {}
  
  public final void BO(String paramString)
  {
    AppMethodBeat.i(96112);
    if (!bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, local file path:%s", new Object[] { paramString });
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("BGMFilePath", paramString);
        if (!this.hNI.d("playBGM", localJSONObject))
        {
          ab.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, play bgm fail, url:%s", new Object[] { this.val$url });
          paramString = new HashMap();
          paramString.put("url", this.val$url);
          this.hNI.a(10003, "download file fail", paramString);
        }
        AppMethodBeat.o(96112);
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          ab.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, set param fail", new Object[] { paramString });
        }
      }
    }
    ab.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, download file fail, url:%s", new Object[] { this.val$url });
    paramString = new HashMap();
    paramString.put("url", this.val$url);
    this.hNI.a(10003, "download file fail", paramString);
    AppMethodBeat.o(96112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.d.1
 * JD-Core Version:    0.7.0.1
 */