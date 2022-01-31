package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.sdk.platformtools.y;
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
  private a.a.a gra;
  g.b grf = null;
  
  private static UUID[] w(JSONObject paramJSONObject)
  {
    int i = 0;
    localObject2 = null;
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
          y.d("MicroMsg.JsApiStartBeaconDiscovery", "uuid %s", new Object[] { localObject2 });
          localObject1 = paramJSONObject;
          paramJSONObject[i] = UUID.fromString((String)localObject2);
          i += 1;
        }
        return localObject2;
      }
      catch (JSONException paramJSONObject)
      {
        y.e("MicroMsg.JsApiStartBeaconDiscovery", "get uuid error!");
        localObject2 = localObject1;
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.i("MicroMsg.JsApiStartBeaconDiscovery", "startBeaconDiscovery data %s", new Object[] { paramJSONObject });
    UUID[] arrayOfUUID = w(paramJSONObject);
    if ((arrayOfUUID == null) || (arrayOfUUID.length <= 0))
    {
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(11006));
      paramc.C(paramInt, h("fail:invalid data", paramJSONObject));
      return;
    }
    String str = paramc.getAppId();
    Object localObject = a.ub(paramc.getAppId());
    paramJSONObject = (JSONObject)localObject;
    if (localObject == null)
    {
      y.i("MicroMsg.JsApiStartBeaconDiscovery", "beaconWorker init");
      paramJSONObject = new a.a();
      a.a(str, paramJSONObject);
    }
    if (this.gra == null)
    {
      y.i("MicroMsg.JsApiStartBeaconDiscovery", "onBeaconScanCallback init");
      this.gra = new c.1(this, paramc);
    }
    if (this.grf == null)
    {
      y.i("MicroMsg.JsApiStartBeaconDiscovery", "listener init");
      this.grf = new c.2(this, paramc);
      g.a(paramc.getAppId(), this.grf);
    }
    paramJSONObject.gqZ = arrayOfUUID;
    paramJSONObject.gra = this.gra;
    y.i("MicroMsg.BeaconManager", "BeaconWorker:%d start", new Object[] { Integer.valueOf(paramJSONObject.hashCode()) });
    if (paramJSONObject.aiS())
    {
      y.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already start", new Object[] { Integer.valueOf(paramJSONObject.hashCode()) });
      paramJSONObject = com.tencent.mm.vending.j.c.r(Integer.valueOf(11003), "fail:already start");
      localObject = new HashMap();
      ((Map)localObject).put("errCode", paramJSONObject.get(0));
      if (((Integer)paramJSONObject.get(0)).intValue() != 0) {
        break label518;
      }
    }
    label518:
    for (paramJSONObject = "ok";; paramJSONObject = (String)paramJSONObject.get(1))
    {
      paramc.C(paramInt, h(paramJSONObject, (Map)localObject));
      return;
      if (d.gG(18))
      {
        y.e("MicroMsg.BeaconManager", "API version is below 18!");
        paramJSONObject = com.tencent.mm.vending.j.c.r(Integer.valueOf(11000), "fail:not support");
        break;
      }
      if (paramJSONObject.gqX == null)
      {
        y.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
        paramJSONObject = com.tencent.mm.vending.j.c.r(Integer.valueOf(11001), "fail:bluetooth service is unavailable");
        break;
      }
      if (!paramJSONObject.gqX.isEnabled())
      {
        y.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
        paramJSONObject = com.tencent.mm.vending.j.c.r(Integer.valueOf(11001), "fail:bluetooth service is unavailable");
        break;
      }
      if (paramJSONObject.gqX.isDiscovering())
      {
        y.e("MicroMsg.BeaconManager", "bluetoothAdapter is Discovering!");
        paramJSONObject = com.tencent.mm.vending.j.c.r(Integer.valueOf(11003), "fail:already start");
        break;
      }
      paramJSONObject.gqY.clear();
      boolean bool = paramJSONObject.gqX.startLeScan(paramJSONObject.grd);
      y.i("MicroMsg.BeaconManager", "startLeScan:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramJSONObject = com.tencent.mm.vending.j.c.r(Integer.valueOf(11005), "fail:system error");
        break;
      }
      paramJSONObject.bSr = true;
      paramJSONObject = com.tencent.mm.vending.j.c.r(Integer.valueOf(0), "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.c
 * JD-Core Version:    0.7.0.1
 */