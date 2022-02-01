package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class m
  extends d
{
  private static final int CTRL_INDEX = 185;
  private static final String NAME = "readBLECharacteristicValue";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144517);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(41);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiReadBLECharacteristicValue", "JsApiReadBLECharacteristicValue data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramf.i(paramInt, n("fail:invalid data", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(43, 44);
      AppMethodBeat.o(144517);
      return;
    }
    Log.i("MicroMsg.JsApiReadBLECharacteristicValue", "appId:%s readBLECharacteristicValue data %s", new Object[] { paramf.getAppId(), paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = a.ZC(paramf.getAppId());
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiReadBLECharacteristicValue", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.i(paramInt, n("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(43, 46);
      AppMethodBeat.o(144517);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE())
    {
      Log.e("MicroMsg.JsApiReadBLECharacteristicValue", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.i(paramInt, n("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(43, 48);
      AppMethodBeat.o(144517);
      return;
    }
    String str1 = paramJSONObject.optString("deviceId");
    String str2 = paramJSONObject.optString("serviceId");
    String str3 = paramJSONObject.optString("characteristicId");
    boolean bool1 = paramJSONObject.optBoolean("debug", false);
    boolean bool2 = paramJSONObject.optBoolean("mainThread", false);
    boolean bool3 = paramJSONObject.optBoolean("serial", true);
    paramJSONObject = new g(str2, str3);
    paramJSONObject.aXs = bool1;
    paramJSONObject.lMh = bool2;
    paramJSONObject.lMj = bool3;
    localb.a(str1, paramJSONObject, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
    {
      public final void a(j paramAnonymousj)
      {
        AppMethodBeat.i(144516);
        switch (paramAnonymousj.errCode)
        {
        default: 
          HashMap localHashMap = new HashMap();
          localHashMap.put("errCode", Integer.valueOf(paramAnonymousj.errCode));
          paramf.i(paramInt, m.this.n(paramAnonymousj.errMsg, localHashMap));
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(43);
          AppMethodBeat.o(144516);
          return;
        }
        paramAnonymousj = new HashMap();
        paramAnonymousj.put("errCode", Integer.valueOf(0));
        paramf.i(paramInt, m.this.n("ok", paramAnonymousj));
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(42);
        AppMethodBeat.o(144516);
      }
    });
    AppMethodBeat.o(144517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.m
 * JD-Core Version:    0.7.0.1
 */