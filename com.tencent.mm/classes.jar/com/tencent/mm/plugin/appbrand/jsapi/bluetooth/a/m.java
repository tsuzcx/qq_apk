package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class m
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 185;
  private static final String NAME = "readBLECharacteristicValue";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144517);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(41);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiReadBLECharacteristicValue", "JsApiReadBLECharacteristicValue data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.h(paramInt, m("fail:invalid data", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(43, 44);
      AppMethodBeat.o(144517);
      return;
    }
    ad.i("MicroMsg.JsApiReadBLECharacteristicValue", "appId:%s readBLECharacteristicValue data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.Pt(paramc.getAppId());
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiReadBLECharacteristicValue", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, m("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(43, 46);
      AppMethodBeat.o(144517);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjz())
    {
      ad.e("MicroMsg.JsApiReadBLECharacteristicValue", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, m("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(43, 48);
      AppMethodBeat.o(144517);
      return;
    }
    String str1 = paramJSONObject.optString("deviceId");
    String str2 = paramJSONObject.optString("serviceId");
    String str3 = paramJSONObject.optString("characteristicId");
    boolean bool1 = paramJSONObject.optBoolean("debug", false);
    boolean bool2 = paramJSONObject.optBoolean("serial", true);
    paramJSONObject = new g(str2, str3);
    paramJSONObject.aXD = bool1;
    paramJSONObject.kEr = false;
    paramJSONObject.kEt = bool2;
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
          paramc.h(paramInt, m.this.m(paramAnonymousj.errMsg, localHashMap));
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(43);
          AppMethodBeat.o(144516);
          return;
        }
        paramAnonymousj = new HashMap();
        paramAnonymousj.put("errCode", Integer.valueOf(0));
        paramc.h(paramInt, m.this.m("ok", paramAnonymousj));
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(42);
        AppMethodBeat.o(144516);
      }
    });
    AppMethodBeat.o(144517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.m
 * JD-Core Version:    0.7.0.1
 */