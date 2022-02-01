package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import d.a.ae;
import d.g.b.p;
import d.l;
import d.o;
import d.u;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiGetBLEDeviceRSSI;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 777;
  public static final String NAME = "getBLEDeviceRSSI";
  public static final a kGp;
  
  static
  {
    AppMethodBeat.i(175635);
    kGp = new a((byte)0);
    AppMethodBeat.o(175635);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(175634);
    if (paramc == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "env is null", new Object[0]);
      AppMethodBeat.o(175634);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("deviceId")))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "data is null or do not have key: deviceId", new Object[0]);
      paramc.h(paramInt, n("fail:invalid data", ae.b(new o[] { u.R("errCode", Integer.valueOf(10013)) })));
      AppMethodBeat.o(175634);
      return;
    }
    final String str = paramc.getAppId();
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "appId: " + str + ", data: " + paramJSONObject, new Object[0]);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.Qb(str);
    if (localb == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "bleWorker is null", new Object[0]);
      paramc.h(paramInt, n("fail:not init", ae.b(new o[] { u.R("errCode", Integer.valueOf(10000)) })));
      AppMethodBeat.o(175634);
      return;
    }
    paramJSONObject = paramJSONObject.optString("deviceId");
    if (paramJSONObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "deviceId is null", new Object[0]);
      paramc.h(paramInt, n("fail:invalid data", ae.b(new o[] { u.R("errCode", Integer.valueOf(10013)) })));
      AppMethodBeat.o(175634);
      return;
    }
    localb.a(paramJSONObject, (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.c(), (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b)new b(this, str, paramInt, paramc));
    AppMethodBeat.o(175634);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiGetBLEDeviceRSSI$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_DEVICE_ID", "RESULT_ERROR_CODE", "RESULT_RSSI", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "kotlin.jvm.PlatformType", "onResult"})
  static final class b
    implements com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b
  {
    b(e parame, String paramString, int paramInt, com.tencent.mm.plugin.appbrand.jsapi.c paramc) {}
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(175633);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "appId: " + str + ", result: " + paramj, new Object[0]);
      int i;
      Object localObject2;
      int j;
      switch (paramj.errCode)
      {
      default: 
        localObject1 = this.kGq;
        i = paramInt;
        localObject2 = paramc;
        j = paramj.errCode;
        paramj = paramj.errMsg;
        p.g(paramj, "result.errMsg");
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a((com.tencent.mm.plugin.appbrand.jsapi.a)localObject1, i, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject2, j, paramj);
        AppMethodBeat.o(175633);
        return;
      }
      Object localObject1 = paramj.kJj;
      paramj = (j)localObject1;
      if (!(localObject1 instanceof Integer)) {
        paramj = null;
      }
      paramj = (Integer)paramj;
      if (paramj == null)
      {
        paramj = this.kGq;
        i = paramInt;
        localObject1 = paramc;
        j = j.kIQ.errCode;
        localObject2 = j.kIQ.errMsg;
        p.g(localObject2, "Result.FAIL.errMsg");
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(paramj, i, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject1, j, (String)localObject2);
        AppMethodBeat.o(175633);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.kGq, paramInt, paramc, ae.c(new o[] { u.R("RSSI", paramj) }));
      AppMethodBeat.o(175633);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.e
 * JD-Core Version:    0.7.0.1
 */