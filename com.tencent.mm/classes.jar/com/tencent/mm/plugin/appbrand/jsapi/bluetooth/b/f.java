package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.UUID;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiRemoveBlePeripheralService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class f
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  private static final int CTRL_INDEX = 724;
  private static final String NAME = "removeBLEPeripheralService";
  public static final a kDB;
  
  static
  {
    AppMethodBeat.i(144757);
    kDB = new a((byte)0);
    NAME = "removeBLEPeripheralService";
    CTRL_INDEX = 724;
    AppMethodBeat.o(144757);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144756);
    p.h(paramc, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjz())
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      ad.i("MicroMsg.BLE.JsApiRemoveBlePeripheralService", "invoke: Ble is not available");
      AppMethodBeat.o(144756);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("serverId")) || (!paramJSONObject.has("serviceId")))
    {
      ad.e("MicroMsg.BLE.JsApiRemoveBlePeripheralService", "invoke data is invalid");
      b.a(this, paramInt, paramc, 10013, "fail:invalid data");
      AppMethodBeat.o(144756);
      return;
    }
    int i = paramJSONObject.optInt("serverId");
    Object localObject = o.kEf;
    localObject = o.sR(i);
    if (localObject == null)
    {
      ad.i("MicroMsg.BLE.JsApiRemoveBlePeripheralService", "invoke: retrieve a null server");
      b.a(this, paramInt, paramc, 10020, "fail: no server");
      AppMethodBeat.o(144756);
      return;
    }
    BluetoothGattService localBluetoothGattService;
    try
    {
      paramJSONObject = UUID.fromString(paramJSONObject.optString("serviceId"));
      p.g(paramJSONObject, "UUID.fromString(data.optString(PARAMS_SERVICE_ID))");
      localBluetoothGattService = ((n)localObject).bjj().getService(paramJSONObject);
      if (localBluetoothGattService == null)
      {
        b.a(this, paramInt, paramc, 10004, "fail:no service");
        AppMethodBeat.o(144756);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      b.a(this, paramInt, paramc, 10013, "fail:invalid data");
      AppMethodBeat.o(144756);
      return;
    }
    if (((n)localObject).bjj().removeService(localBluetoothGattService))
    {
      b.a(this, paramInt, paramc);
      AppMethodBeat.o(144756);
      return;
    }
    b.a(this, paramInt, paramc, 10008, "fail: remove #" + paramJSONObject + " service fail");
    AppMethodBeat.o(144756);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiRemoveBlePeripheralService$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.f
 * JD-Core Version:    0.7.0.1
 */