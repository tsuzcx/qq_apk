package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 175;
  private static final String NAME = "getBluetoothAdapterState";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool2 = false;
    c.jdMethod_if(126);
    y.i("MicroMsg.JsApiGetBluetoothAdapterState", "appId:%s getBluetoothAdapterState", new Object[] { paramc.getAppId() });
    paramJSONObject = a.tV(paramc.getAppId());
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiGetBluetoothAdapterState", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.C(paramInt, h("fail:not init", paramJSONObject));
      c.bU(128, 130);
      return;
    }
    boolean bool3 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiB();
    boolean bool1 = bool2;
    if (paramJSONObject.glx != null)
    {
      paramJSONObject = paramJSONObject.glx;
      bool1 = bool2;
      if (paramJSONObject.gmc != null) {
        bool1 = paramJSONObject.gmc.gnk.get();
      }
    }
    y.i("MicroMsg.JsApiGetBluetoothAdapterState", "availableState : " + bool3 + ",discoveringState : " + bool1);
    paramJSONObject = new HashMap();
    paramJSONObject.put("available", Boolean.valueOf(bool3));
    paramJSONObject.put("discovering", Boolean.valueOf(bool1));
    paramc.C(paramInt, h("ok", paramJSONObject));
    c.jdMethod_if(127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.i
 * JD-Core Version:    0.7.0.1
 */