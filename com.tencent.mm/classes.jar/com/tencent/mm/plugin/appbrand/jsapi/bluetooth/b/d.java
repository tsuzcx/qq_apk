package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiCloseBlePeripheralServer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final d.a rLp;
  
  static
  {
    AppMethodBeat.i(144753);
    rLp = new d.a((byte)0);
    NAME = "closeBLEPeripheralServer";
    CTRL_INDEX = 722;
    AppMethodBeat.o(144753);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144752);
    s.u(paramf, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10001, "fail:not available");
      Log.i("MicroMsg.BLE.JsApiCloseBlePeripheralServer", "invoke: Ble is not available");
      AppMethodBeat.o(144752);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("serverId")))
    {
      Log.e("MicroMsg.BLE.JsApiCloseBlePeripheralServer", "createBLEPeripheralServer data is invalid");
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10013, "fail:invalid data");
      AppMethodBeat.o(144752);
      return;
    }
    int i = paramJSONObject.optInt("serverId");
    paramJSONObject = o.rLP;
    if (o.Av(i))
    {
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf);
      AppMethodBeat.o(144752);
      return;
    }
    Log.i("MicroMsg.BLE.JsApiCloseBlePeripheralServer", "invoke: fail: #" + i + " server is not exists");
    b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10020, "fail: no server");
    AppMethodBeat.o(144752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.d
 * JD-Core Version:    0.7.0.1
 */