package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiSetBLEMtu;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class n
  extends d<f>
{
  private static final int CTRL_INDEX = 738;
  private static final String NAME = "setBLEMTU";
  public static final a lLd;
  
  static
  {
    AppMethodBeat.i(144733);
    lLd = new a((byte)0);
    AppMethodBeat.o(144733);
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144732);
    p.h(paramf, "service");
    if ((paramJSONObject == null) || (!paramJSONObject.has("deviceId")) || (!paramJSONObject.has("mtu")))
    {
      Log.e("MicroMsg.JsApiSetBLEMtu", "createBLEConnection data is null, err");
      paramJSONObject = (Map)new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramf.i(paramInt, n("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144732);
      return;
    }
    final String str1 = paramf.getAppId();
    p.g(str1, "service.appId");
    Log.i("MicroMsg.JsApiSetBLEMtu", "appId:%s createBLEConnection data %s", new Object[] { str1, paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.ZC(paramf.getAppId());
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiSetBLEMtu", "bleWorker is null, may not open ble");
      paramJSONObject = (Map)new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.i(paramInt, n("fail:not init", paramJSONObject));
      c.dY(27, 30);
      AppMethodBeat.o(144732);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.bFf())
    {
      Log.e("MicroMsg.JsApiSetBLEMtu", "bleWorker is disable, may not open ble");
      paramJSONObject = (Map)new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.i(paramInt, n("fail:not available", paramJSONObject));
      c.dY(27, 32);
      AppMethodBeat.o(144732);
      return;
    }
    String str2 = paramJSONObject.optString("deviceId");
    localb.a(str2, (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)new h(Integer.valueOf(paramJSONObject.optInt("mtu")), str2), (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b)new b(this, str1, paramInt, paramf));
    AppMethodBeat.o(144732);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiSetBLEMtu$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "kotlin.jvm.PlatformType", "onResult"})
  static final class b
    implements com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b
  {
    b(n paramn, String paramString, int paramInt, f paramf) {}
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(144731);
      Log.d("MicroMsg.JsApiSetBLEMtu", "invoke: appid %s setMtuSize result = %s", new Object[] { str1, paramj });
      switch (paramj.errCode)
      {
      default: 
        n localn = this.lLe;
        int i = paramInt;
        f localf = paramf;
        int j = paramj.errCode;
        paramj = paramj.errMsg;
        p.g(paramj, "result.errMsg");
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(localn, i, localf, j, paramj);
        AppMethodBeat.o(144731);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.lLe, paramInt, paramf);
      AppMethodBeat.o(144731);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.n
 * JD-Core Version:    0.7.0.1
 */