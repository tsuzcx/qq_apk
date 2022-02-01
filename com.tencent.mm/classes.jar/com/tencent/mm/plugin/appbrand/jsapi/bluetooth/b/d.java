package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiCloseBlePeripheralServer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  private static final int CTRL_INDEX = 722;
  private static final String NAME = "closeBLEPeripheralServer";
  public static final d.a oHE;
  
  static
  {
    AppMethodBeat.i(144753);
    oHE = new d.a((byte)0);
    NAME = "closeBLEPeripheralServer";
    CTRL_INDEX = 722;
    AppMethodBeat.o(144753);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144752);
    p.k(parame, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRm())
    {
      b.a(this, paramInt, parame, 10001, "fail:not available");
      Log.i("MicroMsg.BLE.JsApiCloseBlePeripheralServer", "invoke: Ble is not available");
      AppMethodBeat.o(144752);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("serverId")))
    {
      Log.e("MicroMsg.BLE.JsApiCloseBlePeripheralServer", "createBLEPeripheralServer data is invalid");
      b.a(this, paramInt, parame, 10013, "fail:invalid data");
      AppMethodBeat.o(144752);
      return;
    }
    int i = paramJSONObject.optInt("serverId");
    paramJSONObject = o.oIk;
    if (o.Ae(i))
    {
      b.a(this, paramInt, parame);
      AppMethodBeat.o(144752);
      return;
    }
    Log.i("MicroMsg.BLE.JsApiCloseBlePeripheralServer", "invoke: fail: #" + i + " server is not exists");
    b.a(this, paramInt, parame, 10020, "fail: no server");
    AppMethodBeat.o(144752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.d
 * JD-Core Version:    0.7.0.1
 */