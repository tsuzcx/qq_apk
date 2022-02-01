package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 175;
  private static final String NAME = "getBluetoothAdapterState";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(144500);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(126);
    ad.i("MicroMsg.JsApiGetBluetoothAdapterState", "appId:%s getBluetoothAdapterState", new Object[] { paramc.getAppId() });
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.Pt(paramc.getAppId());
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiGetBluetoothAdapterState", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, m("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(128, 130);
      AppMethodBeat.o(144500);
      return;
    }
    boolean bool3 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjz();
    boolean bool1 = bool2;
    if (paramJSONObject.kCW != null)
    {
      paramJSONObject = paramJSONObject.kCW;
      bool1 = bool2;
      if (paramJSONObject.kEB != null) {
        bool1 = paramJSONObject.kEB.kFW.get();
      }
    }
    ad.i("MicroMsg.JsApiGetBluetoothAdapterState", "availableState : " + bool3 + ",discoveringState : " + bool1);
    paramJSONObject = new HashMap();
    paramJSONObject.put("available", Boolean.valueOf(bool3));
    paramJSONObject.put("discovering", Boolean.valueOf(bool1));
    paramc.h(paramInt, m("ok", paramJSONObject));
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(127);
    AppMethodBeat.o(144500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.g
 * JD-Core Version:    0.7.0.1
 */