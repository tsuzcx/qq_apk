package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class p
  extends d
{
  private static final int CTRL_INDEX = 177;
  private static final String NAME = "stopBluetoothDevicesDiscovery";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144525);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(101);
    String str = paramf.getAppId();
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = "";
    }
    Log.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "appId:%s stopBluetoothDevicesDiscovery data:%s", new Object[] { str, localObject });
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.ZC(str);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.i(paramInt, n("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(103, 106);
      AppMethodBeat.o(144525);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE())
    {
      Log.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.i(paramInt, n("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(103, 108);
      AppMethodBeat.o(144525);
      return;
    }
    paramJSONObject = paramJSONObject.bFg();
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.lMs.bFv();; paramJSONObject = j.lNv)
    {
      Log.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "stopBleScan result:%s", new Object[] { paramJSONObject });
      localObject = new HashMap();
      switch (paramJSONObject.errCode)
      {
      default: 
        ((Map)localObject).put("isDiscovering", Boolean.FALSE);
        paramf.i(paramInt, n("fail", (Map)localObject));
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(103);
        AppMethodBeat.o(144525);
        return;
      }
    }
    ((Map)localObject).put("isDiscovering", Boolean.FALSE);
    paramf.i(paramInt, n("ok", (Map)localObject));
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(102);
    l.c.a(paramf, true, false);
    AppMethodBeat.o(144525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.p
 * JD-Core Version:    0.7.0.1
 */