package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiCreateBlePeripheralServer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class e
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  private static final int CTRL_INDEX = 721;
  private static final String NAME = "createBLEPeripheralServer";
  public static final a kDA;
  
  static
  {
    AppMethodBeat.i(144755);
    kDA = new a((byte)0);
    NAME = "createBLEPeripheralServer";
    CTRL_INDEX = 721;
    AppMethodBeat.o(144755);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144754);
    d.g.b.p.h(paramc, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjz())
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      ad.i("MicroMsg.BLE.JsApiCreateBLEPeripheralServer", "invoke: Ble is not available");
      AppMethodBeat.o(144754);
      return;
    }
    paramJSONObject = new HashMap();
    Object localObject = o.kEf;
    if (o.bjl())
    {
      ad.i("MicroMsg.BLE.JsApiCreateBLEPeripheralServer", "invoke: out of bound");
      b.a(this, paramInt, paramc, 10008, "fail: servers count overflow");
      AppMethodBeat.o(144754);
      return;
    }
    int i = o.kEf.n(paramc);
    localObject = o.kEf;
    localObject = o.sR(i);
    if ((localObject == null) || (((n)localObject).kDO != p.kEh))
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      AppMethodBeat.o(144754);
      return;
    }
    ad.i("MicroMsg.BLE.JsApiCreateBLEPeripheralServer", "invoke: serverId = ".concat(String.valueOf(i)));
    ((Map)paramJSONObject).put("serverId", Integer.valueOf(i));
    b.a(this, paramInt, paramc, paramJSONObject);
    AppMethodBeat.o(144754);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiCreateBlePeripheralServer$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.e
 * JD-Core Version:    0.7.0.1
 */