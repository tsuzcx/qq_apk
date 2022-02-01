package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiWriteBlePeripheralCharacteristicValue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class i
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  private static final int CTRL_INDEX = 727;
  private static final String NAME = "writeBLEPeripheralCharacteristicValue";
  public static final a jIs;
  
  static
  {
    AppMethodBeat.i(144768);
    jIs = new a((byte)0);
    NAME = "writeBLEPeripheralCharacteristicValue";
    CTRL_INDEX = 727;
    AppMethodBeat.o(144768);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144767);
    k.h(paramc, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aZd())
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      ad.i("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", "invoke: Ble is not available");
      AppMethodBeat.o(144767);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("serverId")))
    {
      b.a(this, paramInt, paramc, 10013, "fail:invalid data");
      AppMethodBeat.o(144767);
      return;
    }
    int i = paramJSONObject.optInt("serverId");
    Object localObject1 = o.jIG;
    localObject1 = o.rA(i);
    if (localObject1 == null)
    {
      b.a(this, paramInt, paramc, 10020, "fail: no server");
      AppMethodBeat.o(144767);
      return;
    }
    if (((n)localObject1).jIx != p.jIJ)
    {
      b.a(this, paramInt, paramc, 10000, "fail:not init");
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
      ad.i("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", "invoke: write = " + paramJSONObject + " serviceId = %s, characteristicId = %s, needNotify = %s, jCallbackId = %s", new Object[] { localObject3, localObject2, String.valueOf(bool), String.valueOf(i) });
      localObject3 = UUID.fromString((String)localObject3);
      k.g(localObject3, "UUID.fromString(serviceId)");
      localObject2 = UUID.fromString((String)localObject2);
      k.g(localObject2, "UUID.fromString(characteristicId)");
      k.g(paramJSONObject, "base64Value");
      ((n)localObject1).a((UUID)localObject3, (UUID)localObject2, bool, i, paramJSONObject);
      b.a(this, paramInt, paramc);
      AppMethodBeat.o(144767);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ad.e("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", "invoke: fail: ".concat(String.valueOf(paramJSONObject)));
      b.a(this, paramInt, paramc, 10013, "fail:invalid data");
      AppMethodBeat.o(144767);
      return;
    }
    catch (IllegalArgumentException paramJSONObject)
    {
      ad.e("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", "invoke: fail: ".concat(String.valueOf(paramJSONObject)));
      b.a(this, paramInt, paramc, 10013, "fail:invalid data");
      AppMethodBeat.o(144767);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiWriteBlePeripheralCharacteristicValue$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.i
 * JD-Core Version:    0.7.0.1
 */