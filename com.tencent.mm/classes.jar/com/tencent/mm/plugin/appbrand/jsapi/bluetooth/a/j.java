package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import d.a.ae;
import d.g.b.p;
import d.l;
import d.o;
import d.u;
import java.util.Arrays;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiMakeBluetoothPair;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class j
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 815;
  public static final String NAME = "makeBluetoothPair";
  public static final a kDc;
  
  static
  {
    AppMethodBeat.i(195119);
    kDc = new a((byte)0);
    AppMethodBeat.o(195119);
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(195118);
    if (paramc == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "env is null", new Object[0]);
      AppMethodBeat.o(195118);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("deviceId")))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "data is null or do not have key: deviceId", new Object[0]);
      paramc.h(paramInt, m("fail:invalid data", ae.b(new o[] { u.S("errCode", Integer.valueOf(10013)) })));
      AppMethodBeat.o(195118);
      return;
    }
    final String str1 = paramc.getAppId();
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "appId: " + str1 + ", data: " + paramJSONObject, new Object[0]);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.Pt(str1);
    if (localb == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "bleWorker is null", new Object[0]);
      paramc.h(paramInt, m("fail:not init", ae.b(new o[] { u.S("errCode", Integer.valueOf(10000)) })));
      AppMethodBeat.o(195118);
      return;
    }
    String str2 = paramJSONObject.optString("deviceId", null);
    if (str2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "deviceId is null", new Object[0]);
      paramc.h(paramInt, m("fail:invalid data", ae.b(new o[] { u.S("errCode", Integer.valueOf(10013)) })));
      AppMethodBeat.o(195118);
      return;
    }
    Object localObject = paramJSONObject.optString("pin", null);
    long l;
    boolean bool;
    StringBuilder localStringBuilder;
    if (localObject == null)
    {
      localObject = null;
      l = paramJSONObject.optLong("timeout", 20000L);
      bool = paramJSONObject.optBoolean("forcePair", false);
      localStringBuilder = new StringBuilder("deviceId: ").append(str2).append(", pin: ");
      if (localObject == null) {
        break label500;
      }
      paramJSONObject = Arrays.toString((byte[])localObject);
      p.g(paramJSONObject, "java.util.Arrays.toString(this)");
    }
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiMakeBluetoothPair", paramJSONObject + ", timeoutMs: " + l + ", forcePair: " + bool, new Object[0]);
        localb.a(str2, (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)new f(str2, (byte[])localObject, l, bool), (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b)new b(this, str1, paramInt, paramc));
        AppMethodBeat.o(195118);
        return;
        try
        {
          localObject = Base64.decode((String)localObject, 2);
        }
        catch (Exception paramJSONObject)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "decode pin fail since " + paramJSONObject.toString(), new Object[0]);
          paramc.h(paramInt, m("fail:invalid data", ae.b(new o[] { u.S("errCode", Integer.valueOf(10013)) })));
          AppMethodBeat.o(195118);
          return;
        }
      }
      label500:
      paramJSONObject = null;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiMakeBluetoothPair$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_DEVICE_ID", "PARAM_FORCE_PAIR", "PARAM_PIN", "PARAM_TIMEOUT", "RESULT_ERROR_CODE", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "kotlin.jvm.PlatformType", "onResult"})
  static final class b
    implements com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b
  {
    b(j paramj, String paramString, int paramInt, c paramc) {}
    
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j paramj)
    {
      AppMethodBeat.i(195117);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "appId: " + str1 + ", result: " + paramj, new Object[0]);
      switch (paramj.errCode)
      {
      default: 
        j localj = this.kDd;
        int i = paramInt;
        c localc = paramc;
        int j = paramj.errCode;
        paramj = paramj.errMsg;
        p.g(paramj, "result.errMsg");
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(localj, i, localc, j, paramj);
        AppMethodBeat.o(195117);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.kDd, paramInt, paramc);
      AppMethodBeat.o(195117);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.j
 * JD-Core Version:    0.7.0.1
 */