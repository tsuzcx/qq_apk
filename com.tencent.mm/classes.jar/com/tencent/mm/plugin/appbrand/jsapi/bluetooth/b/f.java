package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiRemoveBlePeripheralService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final f.a rLr;
  
  static
  {
    AppMethodBeat.i(144757);
    rLr = new f.a((byte)0);
    NAME = "removeBLEPeripheralService";
    CTRL_INDEX = 724;
    AppMethodBeat.o(144757);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144756);
    s.u(paramf, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10001, "fail:not available");
      Log.i("MicroMsg.BLE.JsApiRemoveBlePeripheralService", "invoke: Ble is not available");
      AppMethodBeat.o(144756);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("serverId")) || (!paramJSONObject.has("serviceId")))
    {
      Log.e("MicroMsg.BLE.JsApiRemoveBlePeripheralService", "invoke data is invalid");
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10013, "fail:invalid data");
      AppMethodBeat.o(144756);
      return;
    }
    int i = paramJSONObject.optInt("serverId");
    Object localObject = o.rLP;
    localObject = o.Aw(i);
    if (localObject == null)
    {
      Log.i("MicroMsg.BLE.JsApiRemoveBlePeripheralService", "invoke: retrieve a null server");
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10020, "fail: no server");
      AppMethodBeat.o(144756);
      return;
    }
    BluetoothGattService localBluetoothGattService;
    try
    {
      paramJSONObject = a.aas(paramJSONObject.optString("serviceId"));
      s.s(paramJSONObject, "fromString(data.optString(PARAMS_SERVICE_ID))");
      localBluetoothGattService = ((n)localObject).cqU().getService(paramJSONObject);
      if (localBluetoothGattService == null)
      {
        b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10004, "fail:no service");
        AppMethodBeat.o(144756);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10013, "fail:invalid data");
      AppMethodBeat.o(144756);
      return;
    }
    if (((n)localObject).cqU().removeService(localBluetoothGattService))
    {
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf);
      AppMethodBeat.o(144756);
      return;
    }
    b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10008, "fail: remove #" + paramJSONObject + " service fail");
    AppMethodBeat.o(144756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.f
 * JD-Core Version:    0.7.0.1
 */