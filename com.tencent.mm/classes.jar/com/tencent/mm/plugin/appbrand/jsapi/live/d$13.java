package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class d$13
  implements AppBrandLivePusherView.b
{
  d$13(d paramd, int paramInt, h paramh) {}
  
  public final void a(int paramInt, String paramString, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(145876);
    Log.i("MicroMsg.JsApiInsertLivePusher", "onError, error:%s", new Object[] { Integer.valueOf(paramInt) });
    d.e locale = new d.e((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", Util.nullAsNil(paramString));
      localJSONObject.put("livePusherId", this.rJm);
      if ((paramHashMap != null) && (!paramHashMap.isEmpty())) {
        localJSONObject.put("data", new JSONObject(paramHashMap));
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiInsertLivePusher", "onError fail", new Object[] { paramString });
      }
    }
    this.rJh.a(locale.ZR(localJSONObject.toString()), null);
    AppMethodBeat.o(145876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.d.13
 * JD-Core Version:    0.7.0.1
 */