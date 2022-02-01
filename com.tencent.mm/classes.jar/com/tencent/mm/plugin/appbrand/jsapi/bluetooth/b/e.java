package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiCreateBlePeripheralServer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class e
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  private static final int CTRL_INDEX = 721;
  private static final String NAME = "createBLEPeripheralServer";
  public static final a kGP;
  
  static
  {
    AppMethodBeat.i(144755);
    kGP = new a((byte)0);
    NAME = "createBLEPeripheralServer";
    CTRL_INDEX = 721;
    AppMethodBeat.o(144755);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144754);
    d.g.b.p.h(paramc, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bki())
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      ae.i("MicroMsg.BLE.JsApiCreateBLEPeripheralServer", "invoke: Ble is not available");
      AppMethodBeat.o(144754);
      return;
    }
    paramJSONObject = new HashMap();
    Object localObject = o.kHu;
    if (o.bjU())
    {
      ae.i("MicroMsg.BLE.JsApiCreateBLEPeripheralServer", "invoke: out of bound");
      b.a(this, paramInt, paramc, 10008, "fail: servers count overflow");
      AppMethodBeat.o(144754);
      return;
    }
    int i = o.kHu.n(paramc);
    localObject = o.kHu;
    localObject = o.sU(i);
    if ((localObject == null) || (((n)localObject).kHd != p.kHw))
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      AppMethodBeat.o(144754);
      return;
    }
    ae.i("MicroMsg.BLE.JsApiCreateBLEPeripheralServer", "invoke: serverId = ".concat(String.valueOf(i)));
    ((Map)paramJSONObject).put("serverId", Integer.valueOf(i));
    b.a(this, paramInt, paramc, paramJSONObject);
    AppMethodBeat.o(144754);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiCreateBlePeripheralServer$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.e
 * JD-Core Version:    0.7.0.1
 */