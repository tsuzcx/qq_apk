package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class m$d
  extends bc
{
  private static final int CTRL_INDEX = 189;
  private static final String NAME = "onBluetoothAdapterStateChange";
  
  public static void a(f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(144513);
    if (paramf == null)
    {
      Log.e("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
      AppMethodBeat.o(144513);
      return;
    }
    d locald = new d();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.remove("available");
      localJSONObject.put("available", paramBoolean1);
      localJSONObject.remove("discovering");
      localJSONObject.put("discovering", paramBoolean2);
      locald.b(paramf, paramf.getComponentId()).ZR(localJSONObject.toString()).cpV();
      Log.i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChange %s", new Object[] { localJSONObject.toString() });
      AppMethodBeat.o(144513);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.m.d
 * JD-Core Version:    0.7.0.1
 */