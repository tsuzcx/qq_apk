package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiWriteBlePeripheralCharacteristicValue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final i.a rLD;
  
  static
  {
    AppMethodBeat.i(144768);
    rLD = new i.a((byte)0);
    NAME = "writeBLEPeripheralCharacteristicValue";
    CTRL_INDEX = 727;
    AppMethodBeat.o(144768);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144767);
    s.u(paramf, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10001, "fail:not available");
      Log.i("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", "invoke: Ble is not available");
      AppMethodBeat.o(144767);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("serverId")))
    {
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10013, "fail:invalid data");
      AppMethodBeat.o(144767);
      return;
    }
    int i = paramJSONObject.optInt("serverId");
    Object localObject1 = o.rLP;
    localObject1 = o.Aw(i);
    if (localObject1 == null)
    {
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10020, "fail: no server");
      AppMethodBeat.o(144767);
      return;
    }
    if (((n)localObject1).rLJ != p.rLW)
    {
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10000, "fail:not init");
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
      localObject3 = a.aas((String)localObject3);
      s.s(localObject3, "fromString(serviceId)");
      localObject2 = a.aas((String)localObject2);
      s.s(localObject2, "fromString(characteristicId)");
      s.s(paramJSONObject, "base64Value");
      ((n)localObject1).a((UUID)localObject3, (UUID)localObject2, bool, i, paramJSONObject);
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf);
      AppMethodBeat.o(144767);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.e("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", s.X("invoke: fail: ", paramJSONObject));
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10013, "fail:invalid data");
      AppMethodBeat.o(144767);
      return;
    }
    catch (IllegalArgumentException paramJSONObject)
    {
      Log.e("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", s.X("invoke: fail: ", paramJSONObject));
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10013, "fail:invalid data");
      AppMethodBeat.o(144767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.i
 * JD-Core Version:    0.7.0.1
 */