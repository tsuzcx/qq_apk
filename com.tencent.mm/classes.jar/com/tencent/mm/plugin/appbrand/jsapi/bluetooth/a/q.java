package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class q
  extends d
{
  private static final int CTRL_INDEX = 184;
  private static final String NAME = "writeBLECharacteristicValue";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144527);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(56);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiWriteBLECharacteristicValue", "JsApiWriteBLECharacteristicValue data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(58, 59);
      AppMethodBeat.o(144527);
      return;
    }
    Log.i("MicroMsg.JsApiWriteBLECharacteristicValue", "appId:%s writeBLECharacteristicValue data %s", new Object[] { paramf.getAppId(), paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = a.ZC(paramf.getAppId());
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiWriteBLECharacteristicValue", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.i(paramInt, n("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(58, 61);
      AppMethodBeat.o(144527);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE())
    {
      Log.e("MicroMsg.JsApiWriteBLECharacteristicValue", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.i(paramInt, n("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(58, 63);
      AppMethodBeat.o(144527);
      return;
    }
    String str1 = paramJSONObject.optString("deviceId");
    String str2 = paramJSONObject.optString("serviceId");
    String str3 = paramJSONObject.optString("characteristicId");
    String str4 = paramJSONObject.optString("value");
    boolean bool1 = paramJSONObject.optBoolean("debug", false);
    boolean bool2 = paramJSONObject.optBoolean("mainThread", false);
    boolean bool3 = paramJSONObject.optBoolean("serial", true);
    paramJSONObject = new i(str2, str3, str4);
    paramJSONObject.aXs = bool1;
    paramJSONObject.lMh = bool2;
    paramJSONObject.lMj = bool3;
    localb.a(str1, paramJSONObject, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
    {
      public final void a(j paramAnonymousj)
      {
        AppMethodBeat.i(144526);
        switch (paramAnonymousj.errCode)
        {
        default: 
          HashMap localHashMap = new HashMap();
          localHashMap.put("errCode", Integer.valueOf(paramAnonymousj.errCode));
          paramf.i(paramInt, q.this.n(paramAnonymousj.errMsg, localHashMap));
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(58);
          AppMethodBeat.o(144526);
          return;
        }
        paramAnonymousj = new HashMap();
        paramAnonymousj.put("errCode", Integer.valueOf(0));
        paramf.i(paramInt, q.this.n("ok", paramAnonymousj));
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(58);
        AppMethodBeat.o(144526);
      }
    });
    AppMethodBeat.o(144527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.q
 * JD-Core Version:    0.7.0.1
 */