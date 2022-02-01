package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 175;
  private static final String NAME = "getBluetoothAdapterState";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(144500);
    h.rG(126);
    Log.i("MicroMsg.JsApiGetBluetoothAdapterState", "appId:%s getBluetoothAdapterState", new Object[] { paramf.getAppId() });
    paramJSONObject = a.aan(paramf.getAppId());
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetBluetoothAdapterState", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.callback(paramInt, a(a.c.rUE, paramJSONObject));
      h.fr(128, 130);
      AppMethodBeat.o(144500);
      return;
    }
    boolean bool2 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru();
    paramJSONObject = paramJSONObject.cqF();
    if (paramJSONObject != null) {
      bool1 = paramJSONObject.rMs.rNX.get();
    }
    Log.i("MicroMsg.JsApiGetBluetoothAdapterState", "availableState : " + bool2 + ",discoveringState : " + bool1);
    paramJSONObject = new HashMap();
    paramJSONObject.put("available", Boolean.valueOf(bool2));
    paramJSONObject.put("discovering", Boolean.valueOf(bool1));
    paramf.callback(paramInt, a(a.e.rVt, paramJSONObject));
    h.rG(127);
    AppMethodBeat.o(144500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.g
 * JD-Core Version:    0.7.0.1
 */