package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiSetBLEMtu;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  private static final int CTRL_INDEX = 738;
  private static final String NAME = "setBLEMTU";
  public static final o.a rLg;
  
  static
  {
    AppMethodBeat.i(144733);
    rLg = new o.a((byte)0);
    AppMethodBeat.o(144733);
  }
  
  private static final void a(String paramString, o paramo, int paramInt, f paramf, k paramk)
  {
    AppMethodBeat.i(329672);
    s.u(paramString, "$appId");
    s.u(paramo, "this$0");
    s.u(paramf, "$service");
    Log.d("MicroMsg.JsApiSetBLEMtu", "invoke: appid %s setMtuSize result = %s", new Object[] { paramString, paramk });
    paramString = paramk.rNV;
    if ((paramString instanceof Integer)) {
      paramString = (Integer)paramString;
    }
    while (paramk.errCode == 0) {
      if (paramString != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a((com.tencent.mm.plugin.appbrand.jsapi.c)paramo, paramInt, paramf, ak.g(new r[] { v.Y("mtu", paramString) }));
        AppMethodBeat.o(329672);
        return;
        paramString = null;
      }
      else
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a((com.tencent.mm.plugin.appbrand.jsapi.c)paramo, paramInt, paramf);
        AppMethodBeat.o(329672);
        return;
      }
    }
    if (paramString != null) {}
    for (paramString = paramo.a(paramk.errMsg, paramk.rKn, ak.f(new r[] { v.Y("errCode", Integer.valueOf(paramk.errCode)) }));; paramString = paramo.a(paramk.errMsg, paramk.rKn, (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(paramk.errCode)), v.Y("mtu", paramString) })))
    {
      paramf.callback(paramInt, paramString);
      AppMethodBeat.o(329672);
      return;
    }
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144732);
    s.u(paramf, "service");
    if ((paramJSONObject == null) || (!paramJSONObject.has("deviceId")) || (!paramJSONObject.has("mtu")))
    {
      Log.e("MicroMsg.JsApiSetBLEMtu", "createBLEConnection data is null, err");
      paramJSONObject = (Map)new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, paramJSONObject));
      AppMethodBeat.o(144732);
      return;
    }
    String str1 = paramf.getAppId();
    s.s(str1, "service.appId");
    Log.i("MicroMsg.JsApiSetBLEMtu", "appId:%s createBLEConnection data %s", new Object[] { str1, paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.aan(paramf.getAppId());
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiSetBLEMtu", "bleWorker is null, may not open ble");
      paramJSONObject = (Map)new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.callback(paramInt, a(a.c.rUE, paramJSONObject));
      h.fr(27, 30);
      AppMethodBeat.o(144732);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      Log.e("MicroMsg.JsApiSetBLEMtu", "bleWorker is disable, may not open ble");
      paramJSONObject = (Map)new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.callback(paramInt, a("fail:not available", a.c.rUF, paramJSONObject));
      h.fr(27, 32);
      AppMethodBeat.o(144732);
      return;
    }
    String str2 = paramJSONObject.optString("deviceId");
    int i = paramJSONObject.optInt("mtu");
    long l = paramJSONObject.optLong("timeout", 20000L);
    paramJSONObject = new i(Integer.valueOf(i), str2);
    paramJSONObject.rNh = l;
    localb.a(str2, (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)paramJSONObject, new o..ExternalSyntheticLambda0(str1, this, paramInt, paramf));
    AppMethodBeat.o(144732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.o
 * JD-Core Version:    0.7.0.1
 */