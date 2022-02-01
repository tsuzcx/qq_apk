package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import org.json.JSONException;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"TAG", "", "dispatchEvent", "", "event", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "data", "Lorg/json/JSONObject;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "jOnBLEPeripheralConnectionStateChanged", "deviceID", "serverID", "connected", "", "jOnCharacteristicReadRequest", "", "serviceUUID", "characteristicUUID", "callbackId", "jOnCharacteristicWriteRequest", "base64Value", "luggage-commons-jsapi-connectivity-ext_release"})
public final class a
{
  private static final void a(az paramaz, JSONObject paramJSONObject, e parame)
  {
    AppMethodBeat.i(144737);
    paramaz.agU(paramJSONObject.toString());
    paramaz.j(parame);
    paramaz.bPO();
    AppMethodBeat.o(144737);
  }
  
  public static final void a(e parame, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(144734);
    p.k(parame, "component");
    p.k(paramString1, "deviceID");
    p.k(paramString2, "serverID");
    Log.i("MicroMsg.BLE.BlePeripheralPublishEventFuns", "jOnBLEPeripheralConnectionStateChanged: connected = " + paramBoolean + ", deviceID = " + paramString1 + ", serverID = " + paramString2);
    try
    {
      j localj = new j();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("deviceId", paramString1);
      localJSONObject.put("serverId", paramString2);
      localJSONObject.put("connected", paramBoolean);
      a((az)localj, localJSONObject, parame);
      AppMethodBeat.o(144734);
      return;
    }
    catch (JSONException parame)
    {
      Log.e("MicroMsg.BLE.BlePeripheralPublishEventFuns", "BlePeripheralPublishEventFuns fail", new Object[] { parame });
      AppMethodBeat.o(144734);
    }
  }
  
  public static final boolean a(e parame, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(144736);
    p.k(parame, "component");
    p.k(paramString1, "serviceUUID");
    p.k(paramString2, "characteristicUUID");
    Log.i("MicroMsg.BLE.BlePeripheralPublishEventFuns", "jOnCharacteristicReadRequest: serverID = " + paramInt1 + ", serviceUUID = " + paramString1 + ",\" +\n        \" characteristicUUID = " + paramString2 + ", callbackId = " + paramInt2);
    try
    {
      k localk = new k();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("serverId", paramInt1);
      localJSONObject.put("serviceId", paramString1);
      localJSONObject.put("characteristicId", paramString2);
      localJSONObject.put("callbackId", paramInt2);
      a((az)localk, localJSONObject, parame);
      bool = true;
    }
    catch (JSONException parame)
    {
      for (;;)
      {
        Log.e("MicroMsg.BLE.BlePeripheralPublishEventFuns", "OnCharacteristicReadRequest: fail", new Object[] { parame });
        boolean bool = false;
      }
    }
    AppMethodBeat.o(144736);
    return bool;
  }
  
  public static final boolean a(e parame, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(144735);
    p.k(parame, "component");
    p.k(paramString1, "serviceUUID");
    p.k(paramString2, "characteristicUUID");
    p.k(paramString3, "base64Value");
    Log.i("MicroMsg.BLE.BlePeripheralPublishEventFuns", "jOnCharacteristicWriteRequest: serverID = " + paramInt1 + ", serviceUUID = " + paramString1 + ',' + " characteristicUUID = " + paramString2 + ", callbackId = " + paramInt2);
    try
    {
      l locall = new l();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("serverId", paramInt1);
      localJSONObject.put("serviceId", paramString1);
      localJSONObject.put("characteristicId", paramString2);
      localJSONObject.put("callbackId", paramInt2);
      localJSONObject.put("value", paramString3);
      a((az)locall, localJSONObject, parame);
      bool = true;
    }
    catch (JSONException parame)
    {
      for (;;)
      {
        Log.e("MicroMsg.BLE.BlePeripheralPublishEventFuns", "BlePeripheralPublishEventFuns fail", new Object[] { parame });
        boolean bool = false;
      }
    }
    AppMethodBeat.o(144735);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.a
 * JD-Core Version:    0.7.0.1
 */