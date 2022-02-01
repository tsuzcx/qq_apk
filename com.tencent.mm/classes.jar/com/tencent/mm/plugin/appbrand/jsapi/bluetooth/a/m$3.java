package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

final class m$3
  implements h
{
  m$3(m paramm, f paramf) {}
  
  public final void i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(144508);
    f localf = this.erj;
    if (localf == null)
    {
      Log.e("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLECharacteristicValueChangeEvent dispatch fail, service is null");
      AppMethodBeat.o(144508);
      return;
    }
    m.a locala = new m.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.remove("value");
      localJSONObject.put("value", paramString4);
      localJSONObject.remove("deviceId");
      localJSONObject.put("deviceId", paramString1);
      localJSONObject.remove("serviceId");
      localJSONObject.put("serviceId", paramString2);
      localJSONObject.remove("characteristicId");
      localJSONObject.put("characteristicId", paramString3);
      locala.b(localf, localf.getComponentId()).ZR(localJSONObject.toString()).cpV();
      Log.i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLECharacteristicValueChangeEvent %s", new Object[] { localJSONObject.toString() });
      AppMethodBeat.o(144508);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", new Object[] { paramString1 });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.m.3
 * JD-Core Version:    0.7.0.1
 */