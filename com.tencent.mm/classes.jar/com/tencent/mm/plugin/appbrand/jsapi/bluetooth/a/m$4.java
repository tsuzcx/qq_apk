package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

final class m$4
  implements g
{
  m$4(m paramm, f paramf) {}
  
  public final void cE(String paramString, int paramInt)
  {
    AppMethodBeat.i(329682);
    m.c localc = new m.c((byte)0);
    f localf = this.erj;
    if (localf == null)
    {
      Log.w("MicroMsg.JsApiOpenBluetoothAdapter", "dispatch#OnBLEMTUChangeEvent, service is null");
      AppMethodBeat.o(329682);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("deviceId", paramString);
      localJSONObject.put("mtu", paramInt);
      paramString = localJSONObject.toString();
      localc.b(localf, localf.getComponentId()).ZR(paramString).cpV();
      Log.i("MicroMsg.JsApiOpenBluetoothAdapter", "dispatch#OnBLEMTUChangeEvent, paramsStr: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(329682);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Log.w("MicroMsg.JsApiOpenBluetoothAdapter", "dispatch#OnBLEMTUChangeEvent, put params fail since ".concat(String.valueOf(paramString)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.m.4
 * JD-Core Version:    0.7.0.1
 */