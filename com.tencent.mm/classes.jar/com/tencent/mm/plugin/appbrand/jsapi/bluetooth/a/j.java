package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import java.util.Arrays;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiMakeBluetoothPair;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class j
  extends c<e>
{
  public static final int CTRL_INDEX = 815;
  public static final String NAME = "makeBluetoothPair";
  public static final j.a oHi;
  
  static
  {
    AppMethodBeat.i(199094);
    oHi = new j.a((byte)0);
    AppMethodBeat.o(199094);
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(199093);
    if (parame == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "env is null", new Object[0]);
      AppMethodBeat.o(199093);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("deviceId")))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "data is null or do not have key: deviceId", new Object[0]);
      parame.j(paramInt, m("fail:invalid data", ae.f(new o[] { s.M("errCode", Integer.valueOf(10013)) })));
      AppMethodBeat.o(199093);
      return;
    }
    final String str1 = parame.getAppId();
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "appId: " + str1 + ", data: " + paramJSONObject, new Object[0]);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.ahq(str1);
    if (localb == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "bleWorker is null", new Object[0]);
      parame.j(paramInt, m("fail:not init", ae.f(new o[] { s.M("errCode", Integer.valueOf(10000)) })));
      AppMethodBeat.o(199093);
      return;
    }
    String str2 = paramJSONObject.optString("deviceId", null);
    if (str2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "deviceId is null", new Object[0]);
      parame.j(paramInt, m("fail:invalid data", ae.f(new o[] { s.M("errCode", Integer.valueOf(10013)) })));
      AppMethodBeat.o(199093);
      return;
    }
    Object localObject = paramJSONObject.optString("pin", null);
    long l;
    boolean bool1;
    boolean bool2;
    StringBuilder localStringBuilder;
    if (localObject == null)
    {
      localObject = null;
      l = paramJSONObject.optLong("timeout", 20000L);
      bool1 = paramJSONObject.optBoolean("forcePair", false);
      bool2 = paramJSONObject.optBoolean("useOldImpl", false);
      localStringBuilder = new StringBuilder("deviceId: ").append(str2).append(", pin: ");
      if (localObject == null) {
        break label521;
      }
      paramJSONObject = Arrays.toString((byte[])localObject);
      p.j(paramJSONObject, "java.util.Arrays.toString(this)");
    }
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiMakeBluetoothPair", paramJSONObject + ", timeoutMs: " + l + ", forcePair: " + bool1 + ", useOldImpl: " + bool2, new Object[0]);
        localb.a(str2, (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)new g(str2, (byte[])localObject, l, bool1, bool2), (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b)new b(this, str1, paramInt, parame));
        AppMethodBeat.o(199093);
        return;
        try
        {
          localObject = Base64.decode((String)localObject, 2);
        }
        catch (Exception paramJSONObject)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "decode pin fail since " + paramJSONObject.toString(), new Object[0]);
          parame.j(paramInt, m("fail:invalid data", ae.f(new o[] { s.M("errCode", Integer.valueOf(10013)) })));
          AppMethodBeat.o(199093);
          return;
        }
      }
      label521:
      paramJSONObject = null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "kotlin.jvm.PlatformType", "onResult"})
  static final class b
    implements com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b
  {
    b(j paramj, String paramString, int paramInt, e parame) {}
    
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j paramj)
    {
      AppMethodBeat.i(198885);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "appId: " + str1 + ", result: " + paramj, new Object[0]);
      switch (paramj.errCode)
      {
      default: 
        j localj = this.oHj;
        int i = paramInt;
        e locale = parame;
        int j = paramj.errCode;
        paramj = paramj.errMsg;
        p.j(paramj, "result.errMsg");
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(localj, i, locale, j, paramj);
        AppMethodBeat.o(198885);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.oHj, paramInt, parame);
      AppMethodBeat.o(198885);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.j
 * JD-Core Version:    0.7.0.1
 */