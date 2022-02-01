package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.ad;
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
    AppMethodBeat.i(144525);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lI(101);
    String str = paramc.getAppId();
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = "";
    }
    ad.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "appId:%s stopBluetoothDevicesDiscovery data:%s", new Object[] { str, localObject });
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.HS(str);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, k("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(103, 106);
      AppMethodBeat.o(144525);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aZd())
    {
      ad.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, k("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(103, 108);
      AppMethodBeat.o(144525);
      return;
    }
    paramJSONObject = paramJSONObject.aYI();
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.jJc.aYU();; paramJSONObject = j.jKa)
    {
      ad.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "stopBleScan result:%s", new Object[] { paramJSONObject });
      localObject = new HashMap();
      switch (paramJSONObject.errCode)
      {
      default: 
        ((Map)localObject).put("isDiscovering", Boolean.FALSE);
        paramc.h(paramInt, k("fail", (Map)localObject));
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lI(103);
        AppMethodBeat.o(144525);
        return;
      }
    }
    ((Map)localObject).put("isDiscovering", Boolean.FALSE);
    paramc.h(paramInt, k("ok", (Map)localObject));
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lI(102);
    l.c.a(paramc, true, false);
    AppMethodBeat.o(144525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.p
 * JD-Core Version:    0.7.0.1
 */