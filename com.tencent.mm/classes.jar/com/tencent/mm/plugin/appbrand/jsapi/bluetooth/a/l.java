package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class l
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 186;
  private static final String NAME = "notifyBLECharacteristicValueChanged";
  public static String rLb = "notification";
  public static String rLc = "indication";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144505);
    h.rG(71);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "JsApiNotifyBLECharacteristicValueChanged data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, paramJSONObject));
      h.fr(73, 74);
      AppMethodBeat.o(144505);
      return;
    }
    final String str4 = paramf.getAppId();
    Log.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged data %s", new Object[] { str4, paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = a.aan(paramf.getAppId());
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.callback(paramInt, a(a.c.rUE, paramJSONObject));
      h.fr(73, 76);
      AppMethodBeat.o(144505);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      Log.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.callback(paramInt, a("fail:not available", a.c.rUF, paramJSONObject));
      h.fr(73, 79);
      AppMethodBeat.o(144505);
      return;
    }
    String str3 = paramJSONObject.optString("deviceId");
    String str5 = paramJSONObject.optString("serviceId");
    String str6 = paramJSONObject.optString("characteristicId");
    str2 = null;
    Object localObject = str2;
    if (paramJSONObject.has("handle")) {}
    try
    {
      int i = paramJSONObject.getInt("handle");
      localObject = Integer.valueOf(i);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool3;
        boolean bool4;
        boolean bool5;
        boolean bool6;
        boolean bool1;
        boolean bool2;
        String str1 = str2;
      }
    }
    bool3 = paramJSONObject.optBoolean("state");
    str2 = paramJSONObject.optString("type", rLc);
    bool4 = paramJSONObject.optBoolean("debug", false);
    bool5 = paramJSONObject.optBoolean("mainThread", false);
    bool6 = paramJSONObject.optBoolean("serial", true);
    paramJSONObject = localb.a(str3, str5, str6, (Integer)localObject);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleCharacteristic is null, may not connect");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10005));
      paramf.callback(paramInt, a("fail:no characteristic", a.c.rVh, paramJSONObject));
      h.rG(73);
      AppMethodBeat.o(144505);
      return;
    }
    if (((paramJSONObject.okL) && (!paramJSONObject.rNq)) || ((paramJSONObject.okL) && (paramJSONObject.rNq) && (str2.toLowerCase().equals(rLb))))
    {
      bool1 = true;
      if (((paramJSONObject.okL) || (!paramJSONObject.rNq)) && ((!paramJSONObject.okL) || (!paramJSONObject.rNq) || (!str2.toLowerCase().equals(rLc)))) {
        break label613;
      }
    }
    label613:
    for (bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged isNotify:%b isIndicate:%b", new Object[] { str4, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!bool1) {
        break label619;
      }
      paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f(str5, str6, (Integer)localObject, bool3);
      paramJSONObject.debug = bool4;
      paramJSONObject.rMf = bool5;
      paramJSONObject.rMh = bool6;
      localb.a(str3, paramJSONObject, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
      {
        public final void onResult(k paramAnonymousk)
        {
          AppMethodBeat.i(144503);
          switch (paramAnonymousk.errCode)
          {
          default: 
            HashMap localHashMap = new HashMap();
            localHashMap.put("errCode", Integer.valueOf(paramAnonymousk.errCode));
            paramf.callback(paramInt, l.this.a(paramAnonymousk.errMsg, paramAnonymousk.rKn, localHashMap));
            h.rG(43);
            AppMethodBeat.o(144503);
            return;
          }
          paramAnonymousk = new HashMap();
          paramAnonymousk.put("errCode", Integer.valueOf(0));
          paramf.callback(paramInt, l.this.a(null, a.e.rVt, paramAnonymousk));
          h.rG(42);
          AppMethodBeat.o(144503);
        }
      });
      AppMethodBeat.o(144505);
      return;
      bool1 = false;
      break;
    }
    label619:
    if (bool2)
    {
      paramJSONObject = new e(str5, str6, bool3);
      paramJSONObject.debug = bool4;
      paramJSONObject.rMf = bool5;
      paramJSONObject.rMh = bool6;
      localb.a(str3, paramJSONObject, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
      {
        public final void onResult(k paramAnonymousk)
        {
          AppMethodBeat.i(144504);
          Log.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged result:%s", new Object[] { str4, paramAnonymousk });
          switch (paramAnonymousk.errCode)
          {
          default: 
            new HashMap().put("errCode", Integer.valueOf(paramAnonymousk.errCode));
            paramf.callback(paramInt, l.this.a(paramAnonymousk.errMsg, paramAnonymousk.rKn, null));
            h.rG(43);
            AppMethodBeat.o(144504);
            return;
          }
          new HashMap().put("errCode", Integer.valueOf(0));
          paramf.callback(paramInt, l.this.a(null, a.e.rVt, null));
          h.rG(42);
          AppMethodBeat.o(144504);
        }
      });
      AppMethodBeat.o(144505);
      return;
    }
    Log.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify and not support indicate...");
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(10007));
    paramf.callback(paramInt, a("fail:internal error", a.c.rVj, paramJSONObject));
    h.fr(73, 82);
    AppMethodBeat.o(144505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.l
 * JD-Core Version:    0.7.0.1
 */