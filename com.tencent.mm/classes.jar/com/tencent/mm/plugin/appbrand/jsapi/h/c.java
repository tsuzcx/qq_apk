package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.b;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 221;
  private static final String NAME = "startBeaconDiscovery";
  k.c oIi = null;
  private a.a.a oTX;
  
  private static UUID[] aa(JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(144680);
    Object localObject2 = null;
    Object localObject3 = null;
    if (paramJSONObject.has("uuids"))
    {
      Object localObject1 = localObject3;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramJSONObject.optString("uuids"));
        localObject1 = localObject3;
        paramJSONObject = new UUID[localJSONArray.length()];
        for (;;)
        {
          localObject1 = paramJSONObject;
          localObject2 = paramJSONObject;
          if (i >= localJSONArray.length()) {
            break;
          }
          localObject1 = paramJSONObject;
          localObject2 = localJSONArray.getString(i);
          localObject1 = paramJSONObject;
          Log.d("MicroMsg.JsApiStartBeaconDiscovery", "uuid %s", new Object[] { localObject2 });
          localObject1 = paramJSONObject;
          paramJSONObject[i] = UUID.fromString((String)localObject2);
          i += 1;
        }
        AppMethodBeat.o(144680);
      }
      catch (JSONException paramJSONObject)
      {
        Log.e("MicroMsg.JsApiStartBeaconDiscovery", "get uuid error!");
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144679);
    Log.i("MicroMsg.JsApiStartBeaconDiscovery", "startBeaconDiscovery data %s", new Object[] { paramJSONObject });
    Object localObject1 = aa(paramJSONObject);
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      Log.e("MicroMsg.JsApiStartBeaconDiscovery", "serviceUuids is empty");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(11006));
      parame.j(paramInt, m("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144679);
      return;
    }
    Object localObject2 = parame.getAppId();
    paramJSONObject = a.ahC(parame.getAppId());
    if (paramJSONObject == null)
    {
      Log.i("MicroMsg.JsApiStartBeaconDiscovery", "beaconWorker init");
      paramJSONObject = new a.a();
      a.a((String)localObject2, paramJSONObject);
    }
    for (;;)
    {
      if (this.oTX == null)
      {
        Log.i("MicroMsg.JsApiStartBeaconDiscovery", "onBeaconScanCallback init");
        this.oTX = new c.1(this, parame);
      }
      if (this.oIi == null)
      {
        Log.i("MicroMsg.JsApiStartBeaconDiscovery", "listener init");
        this.oIi = new c.2(this, parame);
        k.a(parame.getAppId(), this.oIi);
      }
      paramJSONObject.oTW = ((UUID[])localObject1);
      paramJSONObject.oTX = this.oTX;
      Log.i("MicroMsg.BeaconManager", "BeaconWorker:%d start", new Object[] { Integer.valueOf(paramJSONObject.hashCode()) });
      if (paramJSONObject.isStart())
      {
        Log.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already start", new Object[] { Integer.valueOf(paramJSONObject.hashCode()) });
        paramJSONObject = com.tencent.mm.vending.j.c.J(Integer.valueOf(11003), "fail:already start");
        localObject1 = new HashMap();
        ((Map)localObject1).put("errCode", paramJSONObject.get(0));
        if (((Integer)paramJSONObject.get(0)).intValue() != 0) {
          break label608;
        }
      }
      label608:
      for (paramJSONObject = "ok";; paramJSONObject = (String)paramJSONObject.get(1))
      {
        parame.j(paramInt, m(paramJSONObject, (Map)localObject1));
        AppMethodBeat.o(144679);
        return;
        if (d.qW(18))
        {
          Log.e("MicroMsg.BeaconManager", "API version is below 18!");
          paramJSONObject = com.tencent.mm.vending.j.c.J(Integer.valueOf(11000), "fail:not support");
          break;
        }
        if (paramJSONObject.oTU == null)
        {
          Log.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
          paramJSONObject = com.tencent.mm.vending.j.c.J(Integer.valueOf(11001), "fail:bluetooth service is unavailable");
          break;
        }
        if (!paramJSONObject.oTU.isEnabled())
        {
          Log.e("MicroMsg.BeaconManager", "bluetoothAdapter is not enabled!");
          paramJSONObject = com.tencent.mm.vending.j.c.J(Integer.valueOf(11001), "fail:bluetooth service is unavailable");
          break;
        }
        if (paramJSONObject.oTU.isDiscovering())
        {
          Log.e("MicroMsg.BeaconManager", "bluetoothAdapter is Discovering!");
          paramJSONObject = com.tencent.mm.vending.j.c.J(Integer.valueOf(11003), "fail:already start");
          break;
        }
        paramJSONObject.oTV.clear();
        Log.i("MicroMsg.BeaconManager", "[BluetoothTrace] start scan");
        Log.printErrStackTrace("MicroMsg.BeaconManager", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
        localObject1 = paramJSONObject.oTU;
        localObject2 = paramJSONObject.oUa;
        boolean bool = ((Boolean)com.tencent.mm.hellhoundlib.a.a.a(localObject1, new com.tencent.mm.hellhoundlib.b.a().bm(localObject2).aFh(), "com/tencent/mm/plugin/appbrand/jsapi/ibeacon/BeaconManager$BeaconWorker", "start", "()Lcom/tencent/mm/vending/tuple/Tuple2;", "android/bluetooth/BluetoothAdapter", "startLeScan", "(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z")).booleanValue();
        Log.i("MicroMsg.BeaconManager", "startLeScan:%b", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          paramJSONObject = com.tencent.mm.vending.j.c.J(Integer.valueOf(11005), "fail:system error");
          break;
        }
        paramJSONObject.isStart = true;
        paramJSONObject = com.tencent.mm.vending.j.c.J(Integer.valueOf(0), "");
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.c
 * JD-Core Version:    0.7.0.1
 */