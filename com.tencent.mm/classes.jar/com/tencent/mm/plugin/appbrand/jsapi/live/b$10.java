package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class b$10
  implements AppBrandLivePusherView.b
{
  b$10(b paramb, int paramInt, e parame) {}
  
  public final void a(int paramInt, String paramString, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(96101);
    ab.i("MicroMsg.JsApiInsertLivePusher", "onError, error:%s", new Object[] { Integer.valueOf(paramInt) });
    b.d locald = new b.d((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", bo.nullAsNil(paramString));
      localJSONObject.put("livePusherId", this.hEO);
      if ((paramHashMap != null) && (!paramHashMap.isEmpty())) {
        localJSONObject.put("data", new JSONObject(paramHashMap));
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiInsertLivePusher", "onError fail", new Object[] { paramString });
      }
    }
    this.hEL.b(locald.BN(localJSONObject.toString()));
    AppMethodBeat.o(96101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.10
 * JD-Core Version:    0.7.0.1
 */