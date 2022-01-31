package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class p
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 177;
  private static final String NAME = "stopBluetoothDevicesDiscovery";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    c.jdMethod_if(101);
    String str = paramc.getAppId();
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = "";
    }
    y.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "appId:%s stopBluetoothDevicesDiscovery data:%s", new Object[] { str, localObject });
    paramJSONObject = a.tV(str);
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.C(paramInt, h("fail:not init", paramJSONObject));
      c.bU(103, 106);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiB())
    {
      y.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.C(paramInt, h("fail:not available", paramJSONObject));
      c.bU(103, 108);
      return;
    }
    if (paramJSONObject.glx != null)
    {
      paramJSONObject = paramJSONObject.glx;
      if (paramJSONObject.gmc != null) {
        paramJSONObject = paramJSONObject.gmc.aiw();
      }
    }
    for (;;)
    {
      y.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "stopBleScan result:%s", new Object[] { paramJSONObject });
      localObject = new HashMap();
      switch (paramJSONObject.errCode)
      {
      default: 
        ((Map)localObject).put("isDiscovering", Boolean.valueOf(false));
        paramc.C(paramInt, h("fail", (Map)localObject));
        c.jdMethod_if(103);
        return;
        paramJSONObject = j.gmP;
        continue;
        paramJSONObject = j.gmP;
      }
    }
    ((Map)localObject).put("isDiscovering", Boolean.valueOf(false));
    paramc.C(paramInt, h("ok", (Map)localObject));
    c.jdMethod_if(102);
    m.c.a(paramc, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.p
 * JD-Core Version:    0.7.0.1
 */