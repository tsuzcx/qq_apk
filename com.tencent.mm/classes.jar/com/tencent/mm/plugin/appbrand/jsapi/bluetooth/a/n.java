package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiSetBLEMtu;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class n
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  private static final int CTRL_INDEX = 738;
  private static final String NAME = "setBLEMTU";
  public static final a kiv;
  
  static
  {
    AppMethodBeat.i(144733);
    kiv = new a((byte)0);
    AppMethodBeat.o(144733);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144732);
    k.h(paramc, "service");
    if ((paramJSONObject == null) || (!paramJSONObject.has("deviceId")) || (!paramJSONObject.has("mtu")))
    {
      ac.e("MicroMsg.JsApiSetBLEMtu", "createBLEConnection data is null, err");
      paramJSONObject = (Map)new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.h(paramInt, k("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144732);
      return;
    }
    final String str1 = paramc.getAppId();
    k.g(str1, "service.appId");
    ac.i("MicroMsg.JsApiSetBLEMtu", "appId:%s createBLEConnection data %s", new Object[] { str1, paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.LX(paramc.getAppId());
    if (localb == null)
    {
      ac.e("MicroMsg.JsApiSetBLEMtu", "bleWorker is null, may not open ble");
      paramJSONObject = (Map)new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, k("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(27, 30);
      AppMethodBeat.o(144732);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.bfE())
    {
      ac.e("MicroMsg.JsApiSetBLEMtu", "bleWorker is disable, may not open ble");
      paramJSONObject = (Map)new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, k("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(27, 32);
      AppMethodBeat.o(144732);
      return;
    }
    String str2 = paramJSONObject.optString("deviceId");
    localb.a(str2, (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)new h(Integer.valueOf(paramJSONObject.optInt("mtu")), str2), (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b)new b(this, str1, paramInt, paramc));
    AppMethodBeat.o(144732);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiSetBLEMtu$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "kotlin.jvm.PlatformType", "onResult"})
  static final class b
    implements com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b
  {
    b(n paramn, String paramString, int paramInt, com.tencent.mm.plugin.appbrand.jsapi.c paramc) {}
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(144731);
      ac.d("MicroMsg.JsApiSetBLEMtu", "invoke: appid %s setMtuSize result = %s", new Object[] { str1, paramj });
      switch (paramj.errCode)
      {
      default: 
        n localn = this.kiw;
        int i = paramInt;
        com.tencent.mm.plugin.appbrand.jsapi.c localc = paramc;
        int j = paramj.errCode;
        paramj = paramj.errMsg;
        k.g(paramj, "result.errMsg");
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(localn, i, localc, j, paramj);
        AppMethodBeat.o(144731);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.kiw, paramInt, paramc);
      AppMethodBeat.o(144731);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.n
 * JD-Core Version:    0.7.0.1
 */