package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.UUID;
import kotlin.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiWriteBlePeripheralCharacteristicValue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  private static final int CTRL_INDEX = 727;
  private static final String NAME = "writeBLEPeripheralCharacteristicValue";
  public static final i.a oHO;
  
  static
  {
    AppMethodBeat.i(144768);
    oHO = new i.a((byte)0);
    NAME = "writeBLEPeripheralCharacteristicValue";
    CTRL_INDEX = 727;
    AppMethodBeat.o(144768);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144767);
    kotlin.g.b.p.k(parame, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRm())
    {
      b.a(this, paramInt, parame, 10001, "fail:not available");
      Log.i("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", "invoke: Ble is not available");
      AppMethodBeat.o(144767);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("serverId")))
    {
      b.a(this, paramInt, parame, 10013, "fail:invalid data");
      AppMethodBeat.o(144767);
      return;
    }
    int i = paramJSONObject.optInt("serverId");
    Object localObject1 = o.oIk;
    localObject1 = o.Af(i);
    if (localObject1 == null)
    {
      b.a(this, paramInt, parame, 10020, "fail: no server");
      AppMethodBeat.o(144767);
      return;
    }
    if (((n)localObject1).oHT != p.oIn)
    {
      b.a(this, paramInt, parame, 10000, "fail:not init");
      AppMethodBeat.o(144767);
      return;
    }
    try
    {
      Object localObject3 = paramJSONObject.optString("serviceId", "");
      Object localObject2 = paramJSONObject.optString("characteristicId", "");
      boolean bool = paramJSONObject.optBoolean("needNotify", false);
      i = paramJSONObject.optInt("callbackId", -1);
      paramJSONObject = paramJSONObject.optString("value");
      Log.i("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", "invoke: write = " + paramJSONObject + " serviceId = %s, characteristicId = %s, needNotify = %s, jCallbackId = %s", new Object[] { localObject3, localObject2, String.valueOf(bool), String.valueOf(i) });
      localObject3 = UUID.fromString((String)localObject3);
      kotlin.g.b.p.j(localObject3, "UUID.fromString(serviceId)");
      localObject2 = UUID.fromString((String)localObject2);
      kotlin.g.b.p.j(localObject2, "UUID.fromString(characteristicId)");
      kotlin.g.b.p.j(paramJSONObject, "base64Value");
      ((n)localObject1).a((UUID)localObject3, (UUID)localObject2, bool, i, paramJSONObject);
      b.a(this, paramInt, parame);
      AppMethodBeat.o(144767);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.e("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", "invoke: fail: ".concat(String.valueOf(paramJSONObject)));
      b.a(this, paramInt, parame, 10013, "fail:invalid data");
      AppMethodBeat.o(144767);
      return;
    }
    catch (IllegalArgumentException paramJSONObject)
    {
      Log.e("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", "invoke: fail: ".concat(String.valueOf(paramJSONObject)));
      b.a(this, paramInt, parame, 10013, "fail:invalid data");
      AppMethodBeat.o(144767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.i
 * JD-Core Version:    0.7.0.1
 */