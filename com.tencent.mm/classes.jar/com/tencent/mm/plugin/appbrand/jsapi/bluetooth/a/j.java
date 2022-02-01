package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiIsBluetoothDevicePaired;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  public static final int CTRL_INDEX = 1059;
  public static final String NAME = "isBluetoothDevicePaired";
  public static final j.a rKZ;
  
  static
  {
    AppMethodBeat.i(329667);
    rKZ = new j.a((byte)0);
    AppMethodBeat.o(329667);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    Iterator localIterator = null;
    AppMethodBeat.i(329669);
    if (paramf == null)
    {
      AppMethodBeat.o(329669);
      return;
    }
    if (paramJSONObject == null)
    {
      a.w("MicroMsg.AppBrand.JsApiIsBluetoothDevicePaired", "invoke, data is null", new Object[0]);
      paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, null));
      AppMethodBeat.o(329669);
      return;
    }
    if (!paramJSONObject.has("deviceId"))
    {
      a.w("MicroMsg.AppBrand.JsApiIsBluetoothDevicePaired", "invoke, do not have key: deviceId", new Object[0]);
      paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, null));
      AppMethodBeat.o(329669);
      return;
    }
    String str = paramJSONObject.optString("deviceId");
    a.i("MicroMsg.AppBrand.JsApiIsBluetoothDevicePaired", s.X("invoke, deviceId: ", str), new Object[0]);
    if (!BluetoothAdapter.checkBluetoothAddress(str))
    {
      a.w("MicroMsg.AppBrand.JsApiIsBluetoothDevicePaired", "invoke, deviceId is illegal", new Object[0]);
      paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, null));
      AppMethodBeat.o(329669);
      return;
    }
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.crs();
    if ((paramJSONObject == null) || (!paramJSONObject.isEnabled()))
    {
      a.w("MicroMsg.AppBrand.JsApiIsBluetoothDevicePaired", "invoke, bluetoothAdapter is null or disabled", new Object[0]);
      paramf.callback(paramInt, a("fail:not available", a.c.rUF, null));
      AppMethodBeat.o(329669);
      return;
    }
    paramJSONObject = paramJSONObject.getBondedDevices();
    if (paramJSONObject == null)
    {
      paramJSONObject = localIterator;
      if (paramJSONObject == null) {
        break label349;
      }
    }
    label349:
    for (boolean bool = true;; bool = false)
    {
      a.i("MicroMsg.AppBrand.JsApiIsBluetoothDevicePaired", s.X("invoke, isPaired: ", Boolean.valueOf(bool)), new Object[0]);
      paramf.callback(paramInt, a(a.e.rVt, ak.f(new r[] { v.Y("isPaired", Boolean.valueOf(bool)) })));
      AppMethodBeat.o(329669);
      return;
      localIterator = ((Iterable)paramJSONObject).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramJSONObject = localIterator.next();
      } while (!s.p(str, ((BluetoothDevice)paramJSONObject).getAddress()));
      for (;;)
      {
        paramJSONObject = (BluetoothDevice)paramJSONObject;
        break;
        paramJSONObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.j
 * JD-Core Version:    0.7.0.1
 */