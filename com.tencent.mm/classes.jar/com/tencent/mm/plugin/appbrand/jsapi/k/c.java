package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 221;
  private static final String NAME = "startBeaconDiscovery";
  private a.a.a rZl;
  k.c rZq = null;
  
  private static UUID[] ak(JSONObject paramJSONObject)
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
  
  public final void a(final f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144679);
    Log.i("MicroMsg.JsApiStartBeaconDiscovery", "startBeaconDiscovery data %s", new Object[] { paramJSONObject });
    Object localObject1 = ak(paramJSONObject);
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      Log.e("MicroMsg.JsApiStartBeaconDiscovery", "serviceUuids is empty");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(11006));
      paramf.callback(paramInt, m("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144679);
      return;
    }
    Object localObject2 = paramf.getAppId();
    paramJSONObject = a.aaz(paramf.getAppId());
    if (paramJSONObject == null)
    {
      Log.i("MicroMsg.JsApiStartBeaconDiscovery", "beaconWorker init");
      paramJSONObject = new a.a();
      a.a((String)localObject2, paramJSONObject);
    }
    for (;;)
    {
      if (this.rZl == null)
      {
        Log.i("MicroMsg.JsApiStartBeaconDiscovery", "onBeaconScanCallback init");
        this.rZl = new a.a.a()
        {
          c.b rZr;
          c.a rZs;
          
          public final void O(Map<String, JSONObject> paramAnonymousMap)
          {
            AppMethodBeat.i(144676);
            Log.d("MicroMsg.JsApiStartBeaconDiscovery", "found device ibeacon %s", new Object[] { paramAnonymousMap });
            JSONArray localJSONArray = new JSONArray();
            paramAnonymousMap = paramAnonymousMap.values().iterator();
            while (paramAnonymousMap.hasNext())
            {
              JSONObject localJSONObject = (JSONObject)paramAnonymousMap.next();
              if (localJSONObject != null) {
                localJSONArray.put(localJSONObject);
              }
            }
            paramAnonymousMap = new JSONObject();
            try
            {
              paramAnonymousMap.put("beacons", localJSONArray);
              this.rZr.b(paramf, paramf.getComponentId()).ZR(paramAnonymousMap.toString()).cpV();
              AppMethodBeat.o(144676);
              return;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                Log.e("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", new Object[] { localJSONException });
              }
            }
          }
          
          public final void onBluetoothStateChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(144677);
            Log.i("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("available", paramAnonymousBoolean);
              localJSONObject.put("discovering", false);
              Log.d("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[] { localJSONObject.toString() });
              this.rZs.b(paramf, paramf.getComponentId()).ZR(localJSONObject.toString()).cpV();
              AppMethodBeat.o(144677);
              return;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                Log.e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
              }
            }
          }
        };
      }
      if (this.rZq == null)
      {
        Log.i("MicroMsg.JsApiStartBeaconDiscovery", "listener init");
        this.rZq = new k.c()
        {
          public final void onDestroy()
          {
            AppMethodBeat.i(144678);
            Log.i("MicroMsg.JsApiStartBeaconDiscovery", "onDestroy");
            k.b(paramf.getAppId(), this);
            a.a locala = a.aaz(paramf.getAppId());
            if (locala != null)
            {
              locala.stop();
              a.remove(paramf.getAppId());
            }
            c.this.rZq = null;
            AppMethodBeat.o(144678);
          }
        };
        k.a(paramf.getAppId(), this.rZq);
      }
      paramJSONObject.rZk = ((UUID[])localObject1);
      paramJSONObject.rZl = this.rZl;
      Log.i("MicroMsg.BeaconManager", "BeaconWorker:%d start", new Object[] { Integer.valueOf(paramJSONObject.hashCode()) });
      if (paramJSONObject.isStart())
      {
        Log.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already start", new Object[] { Integer.valueOf(paramJSONObject.hashCode()) });
        paramJSONObject = com.tencent.mm.vending.j.c.U(Integer.valueOf(11003), "fail:already start");
        localObject1 = new HashMap();
        ((Map)localObject1).put("errCode", paramJSONObject.get(0));
        if (((Integer)paramJSONObject.get(0)).intValue() != 0) {
          break label608;
        }
      }
      label608:
      for (paramJSONObject = "ok";; paramJSONObject = (String)paramJSONObject.get(1))
      {
        paramf.callback(paramInt, m(paramJSONObject, (Map)localObject1));
        AppMethodBeat.o(144679);
        return;
        if (d.rc(18))
        {
          Log.e("MicroMsg.BeaconManager", "API version is below 18!");
          paramJSONObject = com.tencent.mm.vending.j.c.U(Integer.valueOf(11000), "fail:not support");
          break;
        }
        if (paramJSONObject.rZi == null)
        {
          Log.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
          paramJSONObject = com.tencent.mm.vending.j.c.U(Integer.valueOf(11001), "fail:bluetooth service is unavailable");
          break;
        }
        if (!paramJSONObject.rZi.isEnabled())
        {
          Log.e("MicroMsg.BeaconManager", "bluetoothAdapter is not enabled!");
          paramJSONObject = com.tencent.mm.vending.j.c.U(Integer.valueOf(11001), "fail:bluetooth service is unavailable");
          break;
        }
        if (paramJSONObject.rZi.isDiscovering())
        {
          Log.e("MicroMsg.BeaconManager", "bluetoothAdapter is Discovering!");
          paramJSONObject = com.tencent.mm.vending.j.c.U(Integer.valueOf(11003), "fail:already start");
          break;
        }
        paramJSONObject.rZj.clear();
        Log.i("MicroMsg.BeaconManager", "[BluetoothTrace] start scan");
        Log.printErrStackTrace("MicroMsg.BeaconManager", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
        localObject1 = paramJSONObject.rZi;
        localObject2 = paramJSONObject.rZo;
        boolean bool = ((Boolean)com.tencent.mm.hellhoundlib.a.a.a(localObject1, new com.tencent.mm.hellhoundlib.b.a().cG(localObject2).aYi(), "com/tencent/mm/plugin/appbrand/jsapi/ibeacon/BeaconManager$BeaconWorker", "start", "()Lcom/tencent/mm/vending/tuple/Tuple2;", "android/bluetooth/BluetoothAdapter", "startLeScan", "(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z")).booleanValue();
        Log.i("MicroMsg.BeaconManager", "startLeScan:%b", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          paramJSONObject = com.tencent.mm.vending.j.c.U(Integer.valueOf(11005), "fail:system error");
          break;
        }
        paramJSONObject.isStart = true;
        paramJSONObject = com.tencent.mm.vending.j.c.U(Integer.valueOf(0), "");
        break;
      }
    }
  }
  
  static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 225;
    private static final String NAME = "onBeaconServiceChanged";
  }
  
  static final class b
    extends bc
  {
    private static final int CTRL_INDEX = 224;
    private static final String NAME = "onBeaconUpdated";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.c
 * JD-Core Version:    0.7.0.1
 */