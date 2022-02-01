package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.j.b;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 221;
  private static final String NAME = "startBeaconDiscovery";
  g.c jIE = null;
  private a.a.a jRA;
  
  private static UUID[] N(JSONObject paramJSONObject)
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
          ad.d("MicroMsg.JsApiStartBeaconDiscovery", "uuid %s", new Object[] { localObject2 });
          localObject1 = paramJSONObject;
          paramJSONObject[i] = UUID.fromString((String)localObject2);
          i += 1;
        }
        AppMethodBeat.o(144680);
      }
      catch (JSONException paramJSONObject)
      {
        ad.e("MicroMsg.JsApiStartBeaconDiscovery", "get uuid error!");
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144679);
    ad.i("MicroMsg.JsApiStartBeaconDiscovery", "startBeaconDiscovery data %s", new Object[] { paramJSONObject });
    UUID[] arrayOfUUID = N(paramJSONObject);
    if ((arrayOfUUID == null) || (arrayOfUUID.length <= 0))
    {
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(11006));
      paramc.h(paramInt, k("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144679);
      return;
    }
    String str = paramc.getAppId();
    Object localObject = a.Ic(paramc.getAppId());
    paramJSONObject = (JSONObject)localObject;
    if (localObject == null)
    {
      ad.i("MicroMsg.JsApiStartBeaconDiscovery", "beaconWorker init");
      paramJSONObject = new a.a();
      a.a(str, paramJSONObject);
    }
    if (this.jRA == null)
    {
      ad.i("MicroMsg.JsApiStartBeaconDiscovery", "onBeaconScanCallback init");
      this.jRA = new c.1(this, paramc);
    }
    if (this.jIE == null)
    {
      ad.i("MicroMsg.JsApiStartBeaconDiscovery", "listener init");
      this.jIE = new g.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(144678);
          ad.i("MicroMsg.JsApiStartBeaconDiscovery", "onDestroy");
          g.b(paramc.getAppId(), this);
          a.a locala = a.Ic(paramc.getAppId());
          if (locala != null)
          {
            locala.Ft();
            a.remove(paramc.getAppId());
          }
          c.this.jIE = null;
          AppMethodBeat.o(144678);
        }
      };
      g.a(paramc.getAppId(), this.jIE);
    }
    paramJSONObject.jRz = arrayOfUUID;
    paramJSONObject.jRA = this.jRA;
    ad.i("MicroMsg.BeaconManager", "BeaconWorker:%d start", new Object[] { Integer.valueOf(paramJSONObject.hashCode()) });
    if (paramJSONObject.isStart())
    {
      ad.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already start", new Object[] { Integer.valueOf(paramJSONObject.hashCode()) });
      paramJSONObject = com.tencent.mm.vending.j.c.L(Integer.valueOf(11003), "fail:already start");
      localObject = new HashMap();
      ((Map)localObject).put("errCode", paramJSONObject.get(0));
      if (((Integer)paramJSONObject.get(0)).intValue() != 0) {
        break label535;
      }
    }
    label535:
    for (paramJSONObject = "ok";; paramJSONObject = (String)paramJSONObject.get(1))
    {
      paramc.h(paramInt, k(paramJSONObject, (Map)localObject));
      AppMethodBeat.o(144679);
      return;
      if (d.lg(18))
      {
        ad.e("MicroMsg.BeaconManager", "API version is below 18!");
        paramJSONObject = com.tencent.mm.vending.j.c.L(Integer.valueOf(11000), "fail:not support");
        break;
      }
      if (paramJSONObject.jRx == null)
      {
        ad.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
        paramJSONObject = com.tencent.mm.vending.j.c.L(Integer.valueOf(11001), "fail:bluetooth service is unavailable");
        break;
      }
      if (!paramJSONObject.jRx.isEnabled())
      {
        ad.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
        paramJSONObject = com.tencent.mm.vending.j.c.L(Integer.valueOf(11001), "fail:bluetooth service is unavailable");
        break;
      }
      if (paramJSONObject.jRx.isDiscovering())
      {
        ad.e("MicroMsg.BeaconManager", "bluetoothAdapter is Discovering!");
        paramJSONObject = com.tencent.mm.vending.j.c.L(Integer.valueOf(11003), "fail:already start");
        break;
      }
      paramJSONObject.jRy.clear();
      boolean bool = paramJSONObject.jRx.startLeScan(paramJSONObject.jRD);
      ad.i("MicroMsg.BeaconManager", "startLeScan:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramJSONObject = com.tencent.mm.vending.j.c.L(Integer.valueOf(11005), "fail:system error");
        break;
      }
      paramJSONObject.isStart = true;
      paramJSONObject = com.tencent.mm.vending.j.c.L(Integer.valueOf(0), "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.c
 * JD-Core Version:    0.7.0.1
 */