package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class d$12
  implements AppBrandLivePusherView.b
{
  d$12(d paramd, int paramInt, g paramg) {}
  
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
      localJSONObject.put("livePusherId", this.oGn);
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
    this.oGi.a(locale.agU(localJSONObject.toString()), null);
    AppMethodBeat.o(145876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.d.12
 * JD-Core Version:    0.7.0.1
 */