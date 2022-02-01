package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import org.json.JSONException;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"TAG", "", "dispatchEvent", "", "event", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "data", "Lorg/json/JSONObject;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "jOnBLEPeripheralConnectionStateChanged", "deviceID", "serverID", "connected", "", "jOnCharacteristicReadRequest", "", "serviceUUID", "characteristicUUID", "callbackId", "jOnCharacteristicWriteRequest", "base64Value", "luggage-commons-jsapi-connectivity-ext_release"})
public final class a
{
  private static final void a(bc parambc, JSONObject paramJSONObject, f paramf)
  {
    AppMethodBeat.i(144737);
    parambc.Zh(paramJSONObject.toString());
    parambc.h(paramf);
    parambc.bEo();
    AppMethodBeat.o(144737);
  }
  
  public static final void a(f paramf, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(144734);
    p.h(paramf, "component");
    p.h(paramString1, "deviceID");
    p.h(paramString2, "serverID");
    Log.i("MicroMsg.BLE.BlePeripheralPublishEventFuns", "jOnBLEPeripheralConnectionStateChanged: connected = " + paramBoolean + ", deviceID = " + paramString1 + ", serverID = " + paramString2);
    try
    {
      j localj = new j();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("deviceId", paramString1);
      localJSONObject.put("serverId", paramString2);
      localJSONObject.put("connected", paramBoolean);
      a((bc)localj, localJSONObject, paramf);
      AppMethodBeat.o(144734);
      return;
    }
    catch (JSONException paramf)
    {
      Log.e("MicroMsg.BLE.BlePeripheralPublishEventFuns", "BlePeripheralPublishEventFuns fail", new Object[] { paramf });
      AppMethodBeat.o(144734);
    }
  }
  
  public static final boolean a(f paramf, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(144736);
    p.h(paramf, "component");
    p.h(paramString1, "serviceUUID");
    p.h(paramString2, "characteristicUUID");
    Log.i("MicroMsg.BLE.BlePeripheralPublishEventFuns", "jOnCharacteristicReadRequest: serverID = " + paramInt1 + ", serviceUUID = " + paramString1 + ",\" +\n        \" characteristicUUID = " + paramString2 + ", callbackId = " + paramInt2);
    try
    {
      k localk = new k();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("serverId", paramInt1);
      localJSONObject.put("serviceId", paramString1);
      localJSONObject.put("characteristicId", paramString2);
      localJSONObject.put("callbackId", paramInt2);
      a((bc)localk, localJSONObject, paramf);
      bool = true;
    }
    catch (JSONException paramf)
    {
      for (;;)
      {
        Log.e("MicroMsg.BLE.BlePeripheralPublishEventFuns", "OnCharacteristicReadRequest: fail", new Object[] { paramf });
        boolean bool = false;
      }
    }
    AppMethodBeat.o(144736);
    return bool;
  }
  
  public static final boolean a(f paramf, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(144735);
    p.h(paramf, "component");
    p.h(paramString1, "serviceUUID");
    p.h(paramString2, "characteristicUUID");
    p.h(paramString3, "base64Value");
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
      a((bc)locall, localJSONObject, paramf);
      bool = true;
    }
    catch (JSONException paramf)
    {
      for (;;)
      {
        Log.e("MicroMsg.BLE.BlePeripheralPublishEventFuns", "BlePeripheralPublishEventFuns fail", new Object[] { paramf });
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