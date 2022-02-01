package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiMakeBluetoothPair;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends c<f>
{
  public static final int CTRL_INDEX = 815;
  public static final String NAME = "makeBluetoothPair";
  public static final k.a rLa;
  
  static
  {
    AppMethodBeat.i(329675);
    rLa = new k.a((byte)0);
    AppMethodBeat.o(329675);
  }
  
  private static final void a(String paramString, k paramk, int paramInt, f paramf, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k paramk1)
  {
    AppMethodBeat.i(329674);
    s.u(paramk, "this$0");
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "appId: " + paramString + ", result: " + paramk1, new Object[0]);
    if (paramk1.errCode == 0)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a((c)paramk, paramInt, paramf);
      AppMethodBeat.o(329674);
      return;
    }
    paramf.callback(paramInt, paramk.a(paramk1.errMsg, paramk1.rKn, ak.f(new r[] { v.Y("errCode", Integer.valueOf(paramk1.errCode)) })));
    AppMethodBeat.o(329674);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(329679);
    if (paramf == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "env is null", new Object[0]);
      AppMethodBeat.o(329679);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("deviceId")))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "data is null or do not have key: deviceId", new Object[0]);
      paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, ak.f(new r[] { v.Y("errCode", Integer.valueOf(10013)) })));
      AppMethodBeat.o(329679);
      return;
    }
    String str1 = paramf.getAppId();
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "appId: " + str1 + ", data: " + paramJSONObject, new Object[0]);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.aan(str1);
    if (localb == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "bleWorker is null", new Object[0]);
      paramf.callback(paramInt, a(a.c.rUE, ak.f(new r[] { v.Y("errCode", Integer.valueOf(10000)) })));
      AppMethodBeat.o(329679);
      return;
    }
    String str2 = paramJSONObject.optString("deviceId", null);
    if (str2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "deviceId is null", new Object[0]);
      paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, ak.f(new r[] { v.Y("errCode", Integer.valueOf(10013)) })));
      AppMethodBeat.o(329679);
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
      if (localObject != null) {
        break label506;
      }
      paramJSONObject = null;
    }
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.AppBrand.JsApiMakeBluetoothPair", paramJSONObject + ", timeoutMs: " + l + ", forcePair: " + bool1 + ", useOldImpl: " + bool2, new Object[0]);
        localb.a(str2, (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)new g(str2, (byte[])localObject, l, bool1, bool2), new k..ExternalSyntheticLambda0(str1, this, paramInt, paramf));
        AppMethodBeat.o(329679);
        return;
        try
        {
          localObject = Base64.decode((String)localObject, 2);
        }
        catch (Exception paramJSONObject)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.AppBrand.JsApiMakeBluetoothPair", s.X("decode pin fail since ", paramJSONObject), new Object[0]);
          paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, ak.f(new r[] { v.Y("errCode", Integer.valueOf(10013)) })));
          AppMethodBeat.o(329679);
          return;
        }
      }
      label506:
      paramJSONObject = Arrays.toString((byte[])localObject);
      s.s(paramJSONObject, "java.util.Arrays.toString(this)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.k
 * JD-Core Version:    0.7.0.1
 */