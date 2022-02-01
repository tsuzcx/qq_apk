package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStopBlePeripheralAdvertising;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class h
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  private static final int CTRL_INDEX = 726;
  private static final String NAME = "stopBLEPeripheralAdvertising";
  public static final a kGX;
  
  static
  {
    AppMethodBeat.i(144766);
    kGX = new a((byte)0);
    NAME = "stopBLEPeripheralAdvertising";
    CTRL_INDEX = 726;
    AppMethodBeat.o(144766);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144765);
    p.h(paramc, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bki())
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      ae.i("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "invoke: Ble is not available");
      AppMethodBeat.o(144765);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("serverId")))
    {
      ae.e("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "createBLEPeripheralServer data is invalid");
      b.a(this, paramInt, paramc, 10013, "fail:invalid data");
      AppMethodBeat.o(144765);
      return;
    }
    int i = paramJSONObject.optInt("serverId");
    paramJSONObject = o.kHu;
    paramJSONObject = o.sU(i);
    if (paramJSONObject == null)
    {
      b.a(this, paramInt, paramc, 10020, "fail: no server");
      AppMethodBeat.o(144765);
      return;
    }
    BluetoothAdapter localBluetoothAdapter = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bkg();
    if (localBluetoothAdapter == null)
    {
      ae.i("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "invoke: adapter is null");
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      AppMethodBeat.o(144765);
      return;
    }
    paramJSONObject.a(localBluetoothAdapter);
    if (paramJSONObject.kHi.get())
    {
      b.a(this, paramInt, paramc, 10008, "invoke stop before start response, may occur unexpected error!");
      AppMethodBeat.o(144765);
      return;
    }
    b.a(this, paramInt, paramc);
    AppMethodBeat.o(144765);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStopBlePeripheralAdvertising$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.h
 * JD-Core Version:    0.7.0.1
 */