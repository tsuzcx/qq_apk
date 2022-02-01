package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import d.a.ae;
import d.g.b.k;
import d.l;
import d.o;
import d.u;
import java.util.Arrays;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiMakeBluetoothPair;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class j
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 815;
  public static final String NAME = "makeBluetoothPair";
  public static final a kik;
  
  static
  {
    AppMethodBeat.i(204990);
    kik = new a((byte)0);
    AppMethodBeat.o(204990);
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(204989);
    if (paramc == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "env is null", new Object[0]);
      AppMethodBeat.o(204989);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("deviceId")))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "data is null or do not have key: deviceId", new Object[0]);
      paramc.h(paramInt, k("fail:invalid data", ae.b(new o[] { u.Q("errCode", Integer.valueOf(10013)) })));
      AppMethodBeat.o(204989);
      return;
    }
    final String str1 = paramc.getAppId();
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "appId: " + str1 + ", data: " + paramJSONObject, new Object[0]);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.LX(str1);
    if (localb == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "bleWorker is null", new Object[0]);
      paramc.h(paramInt, k("fail:not init", ae.b(new o[] { u.Q("errCode", Integer.valueOf(10000)) })));
    }
    String str2 = paramJSONObject.optString("deviceId", null);
    if (str2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "deviceId is null", new Object[0]);
      paramc.h(paramInt, k("fail:invalid data", ae.b(new o[] { u.Q("errCode", Integer.valueOf(10013)) })));
      AppMethodBeat.o(204989);
      return;
    }
    Object localObject1 = paramJSONObject.optString("pin", null);
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      long l = paramJSONObject.optLong("timeout", 20000L);
      StringBuilder localStringBuilder = new StringBuilder("deviceId: ").append(str2).append(", pin: ");
      paramJSONObject = localObject2;
      if (localObject1 != null)
      {
        paramJSONObject = Arrays.toString((byte[])localObject1);
        k.g(paramJSONObject, "java.util.Arrays.toString(this)");
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiMakeBluetoothPair", paramJSONObject + ", timeoutMs: " + l, new Object[0]);
      localb.a(str2, (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)new f(str2, (byte[])localObject1, l), (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b)new b(this, str1, paramInt, paramc));
      AppMethodBeat.o(204989);
      return;
      try
      {
        localObject1 = Base64.decode((String)localObject1, 2);
      }
      catch (Exception paramJSONObject)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "decode pin fail since " + paramJSONObject.toString(), new Object[0]);
        paramc.h(paramInt, k("fail:invalid data", ae.b(new o[] { u.Q("errCode", Integer.valueOf(10013)) })));
        AppMethodBeat.o(204989);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiMakeBluetoothPair$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_DEVICE_ID", "PARAM_PIN", "PARAM_TIMEOUT", "RESULT_ERROR_CODE", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "kotlin.jvm.PlatformType", "onResult"})
  static final class b
    implements com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b
  {
    b(j paramj, String paramString, int paramInt, c paramc) {}
    
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j paramj)
    {
      AppMethodBeat.i(204988);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "appId: " + str1 + ", result: " + paramj, new Object[0]);
      switch (paramj.errCode)
      {
      default: 
        j localj = this.kil;
        int i = paramInt;
        c localc = paramc;
        int j = paramj.errCode;
        paramj = paramj.errMsg;
        k.g(paramj, "result.errMsg");
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(localj, i, localc, j, paramj);
        AppMethodBeat.o(204988);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.kil, paramInt, paramc);
      AppMethodBeat.o(204988);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.j
 * JD-Core Version:    0.7.0.1
 */