package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class q
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 184;
  private static final String NAME = "writeBLECharacteristicValue";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    c.jdMethod_if(56);
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiWriteBLECharacteristicValue", "JsApiWriteBLECharacteristicValue data is null");
      paramc.C(paramInt, h("fail:invalid data", null));
      c.bU(58, 59);
      return;
    }
    y.i("MicroMsg.JsApiWriteBLECharacteristicValue", "appId:%s writeBLECharacteristicValue data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    b localb = a.tV(paramc.getAppId());
    if (localb == null)
    {
      y.e("MicroMsg.JsApiWriteBLECharacteristicValue", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.C(paramInt, h("fail:not init", paramJSONObject));
      c.bU(58, 61);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiB())
    {
      y.e("MicroMsg.JsApiWriteBLECharacteristicValue", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.C(paramInt, h("fail:not available", paramJSONObject));
      c.bU(58, 63);
      return;
    }
    String str1 = paramJSONObject.optString("deviceId");
    String str2 = paramJSONObject.optString("serviceId");
    String str3 = paramJSONObject.optString("characteristicId");
    String str4 = paramJSONObject.optString("value");
    boolean bool1 = paramJSONObject.optBoolean("debug", false);
    boolean bool2 = paramJSONObject.optBoolean("serial", true);
    paramJSONObject = new f(str2, str3, str4);
    paramJSONObject.apo = bool1;
    paramJSONObject.glS = false;
    paramJSONObject.glU = bool2;
    localb.a(str1, paramJSONObject, new q.1(this, paramc, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.q
 * JD-Core Version:    0.7.0.1
 */