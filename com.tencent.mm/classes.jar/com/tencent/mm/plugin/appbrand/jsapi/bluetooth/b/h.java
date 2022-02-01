package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStopBlePeripheralAdvertising;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class h
  extends d<f>
{
  private static final int CTRL_INDEX = 726;
  private static final String NAME = "stopBLEPeripheralAdvertising";
  public static final a lLy;
  
  static
  {
    AppMethodBeat.i(144766);
    lLy = new a((byte)0);
    NAME = "stopBLEPeripheralAdvertising";
    CTRL_INDEX = 726;
    AppMethodBeat.o(144766);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144765);
    p.h(paramf, "env");
    if (!c.bFE())
    {
      b.a(this, paramInt, paramf, 10001, "fail:not available");
      Log.i("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "invoke: Ble is not available");
      AppMethodBeat.o(144765);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("serverId")))
    {
      Log.e("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "createBLEPeripheralServer data is invalid");
      b.a(this, paramInt, paramf, 10013, "fail:invalid data");
      AppMethodBeat.o(144765);
      return;
    }
    int i = paramJSONObject.optInt("serverId");
    paramJSONObject = o.lLV;
    paramJSONObject = o.wQ(i);
    if (paramJSONObject == null)
    {
      b.a(this, paramInt, paramf, 10020, "fail: no server");
      AppMethodBeat.o(144765);
      return;
    }
    BluetoothAdapter localBluetoothAdapter = c.bFC();
    if (localBluetoothAdapter == null)
    {
      Log.i("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "invoke: adapter is null");
      b.a(this, paramInt, paramf, 10001, "fail:not available");
      AppMethodBeat.o(144765);
      return;
    }
    paramJSONObject.a(localBluetoothAdapter);
    if (paramJSONObject.lLJ.get())
    {
      b.a(this, paramInt, paramf, 10008, "fail:invoke stop before start response, may occur unexpected error!");
      AppMethodBeat.o(144765);
      return;
    }
    b.a(this, paramInt, paramf);
    AppMethodBeat.o(144765);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStopBlePeripheralAdvertising$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.h
 * JD-Core Version:    0.7.0.1
 */