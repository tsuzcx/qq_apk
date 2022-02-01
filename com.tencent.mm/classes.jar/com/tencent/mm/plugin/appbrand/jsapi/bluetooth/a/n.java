package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 185;
  private static final String NAME = "readBLECharacteristicValue";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144517);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h.rG(41);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiReadBLECharacteristicValue", "JsApiReadBLECharacteristicValue data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h.fr(43, 44);
      AppMethodBeat.o(144517);
      return;
    }
    Log.i("MicroMsg.JsApiReadBLECharacteristicValue", "appId:%s readBLECharacteristicValue data %s", new Object[] { paramf.getAppId(), paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = a.aan(paramf.getAppId());
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiReadBLECharacteristicValue", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.callback(paramInt, a(a.c.rUE, paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h.fr(43, 46);
      AppMethodBeat.o(144517);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      Log.e("MicroMsg.JsApiReadBLECharacteristicValue", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.callback(paramInt, a("fail:not available", a.c.rUF, paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h.fr(43, 48);
      AppMethodBeat.o(144517);
      return;
    }
    String str1 = paramJSONObject.optString("deviceId");
    String str2 = paramJSONObject.optString("serviceId");
    String str3 = paramJSONObject.optString("characteristicId");
    localObject3 = null;
    Object localObject1 = localObject3;
    if (paramJSONObject.has("handle")) {}
    try
    {
      int i = paramJSONObject.getInt("handle");
      localObject1 = Integer.valueOf(i);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1;
        boolean bool2;
        boolean bool3;
        Object localObject2 = localObject3;
      }
    }
    bool1 = paramJSONObject.optBoolean("debug", false);
    bool2 = paramJSONObject.optBoolean("mainThread", false);
    bool3 = paramJSONObject.optBoolean("serial", true);
    paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.h(str2, str3, (Integer)localObject1);
    paramJSONObject.debug = bool1;
    paramJSONObject.rMf = bool2;
    paramJSONObject.rMh = bool3;
    localb.a(str1, paramJSONObject, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
    {
      public final void onResult(k paramAnonymousk)
      {
        AppMethodBeat.i(144516);
        switch (paramAnonymousk.errCode)
        {
        default: 
          HashMap localHashMap = new HashMap();
          localHashMap.put("errCode", Integer.valueOf(paramAnonymousk.errCode));
          paramf.callback(paramInt, n.this.a(paramAnonymousk.errMsg, paramAnonymousk.rKn, localHashMap));
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h.rG(43);
          AppMethodBeat.o(144516);
          return;
        }
        paramAnonymousk = new HashMap();
        paramAnonymousk.put("errCode", Integer.valueOf(0));
        paramf.callback(paramInt, n.this.a(null, a.e.rVt, paramAnonymousk));
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h.rG(42);
        AppMethodBeat.o(144516);
      }
    });
    AppMethodBeat.o(144517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.n
 * JD-Core Version:    0.7.0.1
 */