package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiCreateBlePeripheralServer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class e
  extends d<f>
{
  private static final int CTRL_INDEX = 721;
  private static final String NAME = "createBLEPeripheralServer";
  public static final a lLq;
  
  static
  {
    AppMethodBeat.i(144755);
    lLq = new a((byte)0);
    NAME = "createBLEPeripheralServer";
    CTRL_INDEX = 721;
    AppMethodBeat.o(144755);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144754);
    kotlin.g.b.p.h(paramf, "env");
    if (!c.bFE())
    {
      b.a(this, paramInt, paramf, 10001, "fail:not available");
      Log.i("MicroMsg.BLE.JsApiCreateBLEPeripheralServer", "invoke: Ble is not available");
      AppMethodBeat.o(144754);
      return;
    }
    paramJSONObject = new HashMap();
    Object localObject = o.lLV;
    if (o.bFk())
    {
      Log.i("MicroMsg.BLE.JsApiCreateBLEPeripheralServer", "invoke: out of bound");
      b.a(this, paramInt, paramf, 10008, "fail: servers count overflow");
      AppMethodBeat.o(144754);
      return;
    }
    int i = o.lLV.n(paramf);
    localObject = o.lLV;
    localObject = o.wQ(i);
    if ((localObject == null) || (((n)localObject).lLE != p.lLX))
    {
      b.a(this, paramInt, paramf, 10001, "fail:not available");
      AppMethodBeat.o(144754);
      return;
    }
    Log.i("MicroMsg.BLE.JsApiCreateBLEPeripheralServer", "invoke: serverId = ".concat(String.valueOf(i)));
    ((Map)paramJSONObject).put("serverId", Integer.valueOf(i));
    b.a(this, paramInt, paramf, paramJSONObject);
    AppMethodBeat.o(144754);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiCreateBlePeripheralServer$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.e
 * JD-Core Version:    0.7.0.1
 */