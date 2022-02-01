package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStopBlePeripheralAdvertising;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final h.a rLC;
  
  static
  {
    AppMethodBeat.i(144766);
    rLC = new h.a((byte)0);
    NAME = "stopBLEPeripheralAdvertising";
    CTRL_INDEX = 726;
    AppMethodBeat.o(144766);
  }
  
  private static final void a(JSONObject paramJSONObject, h paramh, int paramInt, f paramf)
  {
    AppMethodBeat.i(329648);
    s.u(paramh, "this$0");
    s.u(paramf, "$env");
    int i = paramJSONObject.optInt("serverId");
    paramJSONObject = o.rLP;
    paramJSONObject = o.Aw(i);
    if (paramJSONObject == null)
    {
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)paramh, paramInt, paramf, 10020, "fail: no server");
      AppMethodBeat.o(329648);
      return;
    }
    BluetoothAdapter localBluetoothAdapter = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.crs();
    if (localBluetoothAdapter == null)
    {
      Log.i("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "invoke: adapter is null");
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)paramh, paramInt, paramf, 10001, "fail:not available");
      AppMethodBeat.o(329648);
      return;
    }
    paramJSONObject.a(localBluetoothAdapter);
    b.a((com.tencent.mm.plugin.appbrand.jsapi.c)paramh, paramInt, paramf);
    AppMethodBeat.o(329648);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144765);
    s.u(paramf, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10001, "fail:not available");
      Log.i("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "invoke: Ble is not available");
      AppMethodBeat.o(144765);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("serverId")))
    {
      Log.e("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "createBLEPeripheralServer data is invalid");
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10013, "fail:invalid data");
      AppMethodBeat.o(144765);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new h..ExternalSyntheticLambda0(paramJSONObject, this, paramInt, paramf), "MicroMsg.BLE.Peripheral");
    AppMethodBeat.o(144765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.h
 * JD-Core Version:    0.7.0.1
 */