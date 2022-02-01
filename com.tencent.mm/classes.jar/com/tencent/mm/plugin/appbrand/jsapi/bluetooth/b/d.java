package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiCloseBlePeripheralServer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class d
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  private static final int CTRL_INDEX = 722;
  private static final String NAME = "closeBLEPeripheralServer";
  public static final a jIi;
  
  static
  {
    AppMethodBeat.i(144753);
    jIi = new a((byte)0);
    NAME = "closeBLEPeripheralServer";
    CTRL_INDEX = 722;
    AppMethodBeat.o(144753);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144752);
    k.h(paramc, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aZd())
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      ad.i("MicroMsg.BLE.JsApiCloseBlePeripheralServer", "invoke: Ble is not available");
      AppMethodBeat.o(144752);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("serverId")))
    {
      ad.e("MicroMsg.BLE.JsApiCloseBlePeripheralServer", "createBLEPeripheralServer data is invalid");
      b.a(this, paramInt, paramc, 10013, "fail:invalid data");
      AppMethodBeat.o(144752);
      return;
    }
    int i = paramJSONObject.optInt("serverId");
    paramJSONObject = o.jIG;
    if (o.rz(i))
    {
      b.a(this, paramInt, paramc);
      AppMethodBeat.o(144752);
      return;
    }
    ad.i("MicroMsg.BLE.JsApiCloseBlePeripheralServer", "invoke: fail: #" + i + " server is not exists");
    b.a(this, paramInt, paramc, 10020, "fail: no server");
    AppMethodBeat.o(144752);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiCloseBlePeripheralServer$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.d
 * JD-Core Version:    0.7.0.1
 */