package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"TAG", "", "dispatchEvent", "", "event", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "data", "Lorg/json/JSONObject;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "jOnBLEPeripheralConnectionStateChanged", "deviceID", "serverID", "connected", "", "jOnCharacteristicReadRequest", "", "serviceUUID", "characteristicUUID", "callbackId", "jOnCharacteristicWriteRequest", "base64Value", "luggage-commons-jsapi-connectivity-ext_release"})
public final class a
{
  private static final void a(ar paramar, JSONObject paramJSONObject, c paramc)
  {
    AppMethodBeat.i(144737);
    paramar.LO(paramJSONObject.toString());
    paramar.h(paramc);
    paramar.beN();
    AppMethodBeat.o(144737);
  }
  
  public static final void a(c paramc, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(144734);
    d.g.b.k.h(paramc, "component");
    d.g.b.k.h(paramString1, "deviceID");
    d.g.b.k.h(paramString2, "serverID");
    ac.i("MicroMsg.BLE.BlePeripheralPublishEventFuns", "jOnBLEPeripheralConnectionStateChanged: connected = " + paramBoolean + ", deviceID = " + paramString1 + ", serverID = " + paramString2);
    try
    {
      j localj = new j();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("deviceId", paramString1);
      localJSONObject.put("serverId", paramString2);
      localJSONObject.put("connected", paramBoolean);
      a((ar)localj, localJSONObject, paramc);
      AppMethodBeat.o(144734);
      return;
    }
    catch (JSONException paramc)
    {
      ac.e("MicroMsg.BLE.BlePeripheralPublishEventFuns", "BlePeripheralPublishEventFuns fail", new Object[] { paramc });
      AppMethodBeat.o(144734);
    }
  }
  
  public static final boolean a(c paramc, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(144736);
    d.g.b.k.h(paramc, "component");
    d.g.b.k.h(paramString1, "serviceUUID");
    d.g.b.k.h(paramString2, "characteristicUUID");
    ac.i("MicroMsg.BLE.BlePeripheralPublishEventFuns", "jOnCharacteristicReadRequest: serverID = " + paramInt1 + ", serviceUUID = " + paramString1 + ",\" +\n        \" characteristicUUID = " + paramString2 + ", callbackId = " + paramInt2);
    try
    {
      k localk = new k();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("serverId", paramInt1);
      localJSONObject.put("serviceId", paramString1);
      localJSONObject.put("characteristicId", paramString2);
      localJSONObject.put("callbackId", paramInt2);
      a((ar)localk, localJSONObject, paramc);
      bool = true;
    }
    catch (JSONException paramc)
    {
      for (;;)
      {
        ac.e("MicroMsg.BLE.BlePeripheralPublishEventFuns", "OnCharacteristicReadRequest: fail", new Object[] { paramc });
        boolean bool = false;
      }
    }
    AppMethodBeat.o(144736);
    return bool;
  }
  
  public static final boolean a(c paramc, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(144735);
    d.g.b.k.h(paramc, "component");
    d.g.b.k.h(paramString1, "serviceUUID");
    d.g.b.k.h(paramString2, "characteristicUUID");
    d.g.b.k.h(paramString3, "base64Value");
    ac.i("MicroMsg.BLE.BlePeripheralPublishEventFuns", "jOnCharacteristicWriteRequest: serverID = " + paramInt1 + ", serviceUUID = " + paramString1 + ',' + " characteristicUUID = " + paramString2 + ", callbackId = " + paramInt2);
    try
    {
      l locall = new l();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("serverId", paramInt1);
      localJSONObject.put("serviceId", paramString1);
      localJSONObject.put("characteristicId", paramString2);
      localJSONObject.put("callbackId", paramInt2);
      localJSONObject.put("value", paramString3);
      a((ar)locall, localJSONObject, paramc);
      bool = true;
    }
    catch (JSONException paramc)
    {
      for (;;)
      {
        ac.e("MicroMsg.BLE.BlePeripheralPublishEventFuns", "BlePeripheralPublishEventFuns fail", new Object[] { paramc });
        boolean bool = false;
      }
    }
    AppMethodBeat.o(144735);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.a
 * JD-Core Version:    0.7.0.1
 */