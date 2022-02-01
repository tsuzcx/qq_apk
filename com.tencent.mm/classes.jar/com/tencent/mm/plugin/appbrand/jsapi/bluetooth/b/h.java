package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStopBlePeripheralAdvertising;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class h
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  private static final int CTRL_INDEX = 726;
  private static final String NAME = "stopBLEPeripheralAdvertising";
  public static final a kiQ;
  
  static
  {
    AppMethodBeat.i(144766);
    kiQ = new a((byte)0);
    NAME = "stopBLEPeripheralAdvertising";
    CTRL_INDEX = 726;
    AppMethodBeat.o(144766);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144765);
    k.h(paramc, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfV())
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      ac.i("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "invoke: Ble is not available");
      AppMethodBeat.o(144765);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("serverId")))
    {
      ac.e("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "createBLEPeripheralServer data is invalid");
      b.a(this, paramInt, paramc, 10013, "fail:invalid data");
      AppMethodBeat.o(144765);
      return;
    }
    int i = paramJSONObject.optInt("serverId");
    paramJSONObject = o.kjh;
    paramJSONObject = o.sp(i);
    if (paramJSONObject == null)
    {
      b.a(this, paramInt, paramc, 10020, "fail: no server");
      AppMethodBeat.o(144765);
      return;
    }
    BluetoothAdapter localBluetoothAdapter = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfT();
    if (localBluetoothAdapter == null)
    {
      ac.i("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "invoke: adapter is null");
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      AppMethodBeat.o(144765);
      return;
    }
    paramJSONObject.a(localBluetoothAdapter);
    b.a(this, paramInt, paramc);
    AppMethodBeat.o(144765);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStopBlePeripheralAdvertising$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.h
 * JD-Core Version:    0.7.0.1
 */