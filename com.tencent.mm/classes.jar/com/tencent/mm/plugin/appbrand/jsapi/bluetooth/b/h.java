package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStopBlePeripheralAdvertising;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  private static final int CTRL_INDEX = 726;
  private static final String NAME = "stopBLEPeripheralAdvertising";
  public static final h.a oHN;
  
  static
  {
    AppMethodBeat.i(144766);
    oHN = new h.a((byte)0);
    NAME = "stopBLEPeripheralAdvertising";
    CTRL_INDEX = 726;
    AppMethodBeat.o(144766);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144765);
    p.k(parame, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRm())
    {
      b.a(this, paramInt, parame, 10001, "fail:not available");
      Log.i("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "invoke: Ble is not available");
      AppMethodBeat.o(144765);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("serverId")))
    {
      Log.e("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "createBLEPeripheralServer data is invalid");
      b.a(this, paramInt, parame, 10013, "fail:invalid data");
      AppMethodBeat.o(144765);
      return;
    }
    int i = paramJSONObject.optInt("serverId");
    paramJSONObject = o.oIk;
    paramJSONObject = o.Af(i);
    if (paramJSONObject == null)
    {
      b.a(this, paramInt, parame, 10020, "fail: no server");
      AppMethodBeat.o(144765);
      return;
    }
    BluetoothAdapter localBluetoothAdapter = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRk();
    if (localBluetoothAdapter == null)
    {
      Log.i("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "invoke: adapter is null");
      b.a(this, paramInt, parame, 10001, "fail:not available");
      AppMethodBeat.o(144765);
      return;
    }
    paramJSONObject.a(localBluetoothAdapter);
    if (paramJSONObject.oHY.get())
    {
      b.a(this, paramInt, parame, 10008, "fail:invoke stop before start response, may occur unexpected error!");
      AppMethodBeat.o(144765);
      return;
    }
    b.a(this, paramInt, parame);
    AppMethodBeat.o(144765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.h
 * JD-Core Version:    0.7.0.1
 */