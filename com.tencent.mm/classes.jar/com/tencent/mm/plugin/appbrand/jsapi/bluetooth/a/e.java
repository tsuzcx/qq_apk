package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiGetBLEDeviceRSSI;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends c<f>
{
  public static final int CTRL_INDEX = 777;
  public static final String NAME = "getBLEDeviceRSSI";
  public static final e.a rKW;
  
  static
  {
    AppMethodBeat.i(175635);
    rKW = new e.a((byte)0);
    AppMethodBeat.o(175635);
  }
  
  private static final void a(String paramString, e parame, int paramInt, f paramf, k paramk)
  {
    AppMethodBeat.i(329659);
    s.u(parame, "this$0");
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "appId: " + paramString + ", result: " + paramk, new Object[0]);
    if (paramk.errCode == 0)
    {
      paramString = paramk.rNV;
      if ((paramString instanceof Integer)) {}
      for (paramString = (Integer)paramString; paramString == null; paramString = null)
      {
        paramf.callback(paramInt, parame.a("fail:internal error", a.c.rVf, ak.f(new r[] { v.Y("errCode", Integer.valueOf(-1)) })));
        AppMethodBeat.o(329659);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a((c)parame, paramInt, paramf, ak.g(new r[] { v.Y("RSSI", paramString) }));
      AppMethodBeat.o(329659);
      return;
    }
    paramf.callback(paramInt, parame.a(paramk.errMsg, paramk.rKn, ak.f(new r[] { v.Y("errCode", Integer.valueOf(paramk.errCode)) })));
    AppMethodBeat.o(329659);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(175634);
    if (paramf == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "env is null", new Object[0]);
      AppMethodBeat.o(175634);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("deviceId")))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "data is null or do not have key: deviceId", new Object[0]);
      paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, ak.f(new r[] { v.Y("errCode", Integer.valueOf(10013)) })));
      AppMethodBeat.o(175634);
      return;
    }
    String str = paramf.getAppId();
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "appId: " + str + ", data: " + paramJSONObject, new Object[0]);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.aan(str);
    if (localb == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "bleWorker is null", new Object[0]);
      paramf.callback(paramInt, a(a.c.rUE, ak.f(new r[] { v.Y("errCode", Integer.valueOf(10000)) })));
      AppMethodBeat.o(175634);
      return;
    }
    paramJSONObject = paramJSONObject.optString("deviceId");
    if (paramJSONObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "deviceId is null", new Object[0]);
      paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, ak.f(new r[] { v.Y("errCode", Integer.valueOf(10013)) })));
      AppMethodBeat.o(175634);
      return;
    }
    localb.a(paramJSONObject, (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)new d(), new e..ExternalSyntheticLambda0(str, this, paramInt, paramf));
    AppMethodBeat.o(175634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.e
 * JD-Core Version:    0.7.0.1
 */