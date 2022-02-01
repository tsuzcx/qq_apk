package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class b$12
  implements AppBrandLivePusherView.b
{
  b$12(b paramb, int paramInt, e parame) {}
  
  public final void a(int paramInt, String paramString, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(145876);
    ad.i("MicroMsg.JsApiInsertLivePusher", "onError, error:%s", new Object[] { Integer.valueOf(paramInt) });
    b.e locale = new b.e((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", bt.nullAsNil(paramString));
      localJSONObject.put("livePusherId", this.kCh);
      if ((paramHashMap != null) && (!paramHashMap.isEmpty())) {
        localJSONObject.put("data", new JSONObject(paramHashMap));
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiInsertLivePusher", "onError fail", new Object[] { paramString });
      }
    }
    this.kCd.b(locale.Pi(localJSONObject.toString()));
    AppMethodBeat.o(145876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.12
 * JD-Core Version:    0.7.0.1
 */