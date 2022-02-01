package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiSetBLEMtu;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class n
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  private static final int CTRL_INDEX = 738;
  private static final String NAME = "setBLEMTU";
  public static final n.a oHt;
  
  static
  {
    AppMethodBeat.i(144733);
    oHt = new n.a((byte)0);
    AppMethodBeat.o(144733);
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144732);
    p.k(parame, "service");
    if ((paramJSONObject == null) || (!paramJSONObject.has("deviceId")) || (!paramJSONObject.has("mtu")))
    {
      Log.e("MicroMsg.JsApiSetBLEMtu", "createBLEConnection data is null, err");
      paramJSONObject = (Map)new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      parame.j(paramInt, m("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144732);
      return;
    }
    final String str1 = parame.getAppId();
    p.j(str1, "service.appId");
    Log.i("MicroMsg.JsApiSetBLEMtu", "appId:%s createBLEConnection data %s", new Object[] { str1, paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.ahq(parame.getAppId());
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiSetBLEMtu", "bleWorker is null, may not open ble");
      paramJSONObject = (Map)new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      parame.j(paramInt, m("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(27, 30);
      AppMethodBeat.o(144732);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.bQJ())
    {
      Log.e("MicroMsg.JsApiSetBLEMtu", "bleWorker is disable, may not open ble");
      paramJSONObject = (Map)new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      parame.j(paramInt, m("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(27, 32);
      AppMethodBeat.o(144732);
      return;
    }
    String str2 = paramJSONObject.optString("deviceId");
    int i = paramJSONObject.optInt("mtu");
    long l = paramJSONObject.optLong("timeout", 20000L);
    paramJSONObject = new i(Integer.valueOf(i), str2);
    paramJSONObject.oJt = l;
    localb.a(str2, (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)paramJSONObject, (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b)new b(this, str1, paramInt, parame));
    AppMethodBeat.o(144732);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "kotlin.jvm.PlatformType", "onResult"})
  static final class b
    implements com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b
  {
    b(n paramn, String paramString, int paramInt, e parame) {}
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(144731);
      Log.d("MicroMsg.JsApiSetBLEMtu", "invoke: appid %s setMtuSize result = %s", new Object[] { str1, paramj });
      switch (paramj.errCode)
      {
      default: 
        n localn = this.oHu;
        int i = paramInt;
        e locale = parame;
        int j = paramj.errCode;
        paramj = paramj.errMsg;
        p.j(paramj, "result.errMsg");
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(localn, i, locale, j, paramj);
        AppMethodBeat.o(144731);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.oHu, paramInt, parame);
      AppMethodBeat.o(144731);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.n
 * JD-Core Version:    0.7.0.1
 */