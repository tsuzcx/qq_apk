package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class c$10
  implements AppBrandLivePusherView.a
{
  c$10(c paramc, int paramInt, e parame) {}
  
  public final void a(int paramInt, String paramString, HashMap<String, Object> paramHashMap)
  {
    y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "onError, error:%s", new Object[] { Integer.valueOf(paramInt) });
    c.d locald = new c.d((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", bk.pm(paramString));
      localJSONObject.put("livePusherId", this.gkY);
      if ((paramHashMap != null) && (!paramHashMap.isEmpty())) {
        localJSONObject.put("data", new JSONObject(paramHashMap));
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiInsertLivePusher.javayhu", "onError fail", new Object[] { paramString });
      }
    }
    this.gkV.b(locald.tM(localJSONObject.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c.10
 * JD-Core Version:    0.7.0.1
 */