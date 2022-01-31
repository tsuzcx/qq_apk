package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(94188);
    c.kS(126);
    ab.i("MicroMsg.JsApiGetBluetoothAdapterState", "appId:%s getBluetoothAdapterState", new Object[] { paramc.getAppId() });
    paramJSONObject = a.BU(paramc.getAppId());
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiGetBluetoothAdapterState", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, j("fail:not init", paramJSONObject));
      c.df(128, 130);
      AppMethodBeat.o(94188);
      return;
    }
    boolean bool3 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCw();
    boolean bool1 = bool2;
    if (paramJSONObject.hFw != null)
    {
      paramJSONObject = paramJSONObject.hFw;
      bool1 = bool2;
      if (paramJSONObject.hGb != null) {
        bool1 = paramJSONObject.hGb.hHj.get();
      }
    }
    ab.i("MicroMsg.JsApiGetBluetoothAdapterState", "availableState : " + bool3 + ",discoveringState : " + bool1);
    paramJSONObject = new HashMap();
    paramJSONObject.put("available", Boolean.valueOf(bool3));
    paramJSONObject.put("discovering", Boolean.valueOf(bool1));
    paramc.h(paramInt, j("ok", paramJSONObject));
    c.kS(127);
    AppMethodBeat.o(94188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.i
 * JD-Core Version:    0.7.0.1
 */