package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
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

@TargetApi(18)
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  private static final int CTRL_INDEX = 221;
  private static final String NAME = "startBeaconDiscovery";
  h.c lLT = null;
  private a.a.a lWm;
  
  private static UUID[] W(JSONObject paramJSONObject)
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
    UUID[] arrayOfUUID = W(paramJSONObject);
    if ((arrayOfUUID == null) || (arrayOfUUID.length <= 0))
    {
      Log.e("MicroMsg.JsApiStartBeaconDiscovery", "serviceUuids is empty");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(11006));
      paramf.i(paramInt, n("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144679);
      return;
    }
    String str = paramf.getAppId();
    Object localObject = a.ZM(paramf.getAppId());
    paramJSONObject = (JSONObject)localObject;
    if (localObject == null)
    {
      Log.i("MicroMsg.JsApiStartBeaconDiscovery", "beaconWorker init");
      paramJSONObject = new a.a();
      a.a(str, paramJSONObject);
    }
    if (this.lWm == null)
    {
      Log.i("MicroMsg.JsApiStartBeaconDiscovery", "onBeaconScanCallback init");
      this.lWm = new a.a.a()
      {
        c.b lWr;
        c.a lWs;
        
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
            this.lWr.b(paramf, paramf.getComponentId()).Zh(paramAnonymousMap.toString()).bEo();
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
        
        public final void ho(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(144677);
          Log.i("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("available", paramAnonymousBoolean);
            localJSONObject.put("discovering", false);
            Log.d("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[] { localJSONObject.toString() });
            this.lWs.b(paramf, paramf.getComponentId()).Zh(localJSONObject.toString()).bEo();
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
    if (this.lLT == null)
    {
      Log.i("MicroMsg.JsApiStartBeaconDiscovery", "listener init");
      this.lLT = new h.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(144678);
          Log.i("MicroMsg.JsApiStartBeaconDiscovery", "onDestroy");
          h.b(paramf.getAppId(), this);
          a.a locala = a.ZM(paramf.getAppId());
          if (locala != null)
          {
            locala.Qt();
            a.remove(paramf.getAppId());
          }
          c.this.lLT = null;
          AppMethodBeat.o(144678);
        }
      };
      h.a(paramf.getAppId(), this.lLT);
    }
    paramJSONObject.lWl = arrayOfUUID;
    paramJSONObject.lWm = this.lWm;
    Log.i("MicroMsg.BeaconManager", "BeaconWorker:%d start", new Object[] { Integer.valueOf(paramJSONObject.hashCode()) });
    if (paramJSONObject.isStart())
    {
      Log.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already start", new Object[] { Integer.valueOf(paramJSONObject.hashCode()) });
      paramJSONObject = com.tencent.mm.vending.j.c.Q(Integer.valueOf(11003), "fail:already start");
      localObject = new HashMap();
      ((Map)localObject).put("errCode", paramJSONObject.get(0));
      if (((Integer)paramJSONObject.get(0)).intValue() != 0) {
        break label568;
      }
    }
    label568:
    for (paramJSONObject = "ok";; paramJSONObject = (String)paramJSONObject.get(1))
    {
      paramf.i(paramInt, n(paramJSONObject, (Map)localObject));
      AppMethodBeat.o(144679);
      return;
      if (com.tencent.mm.compatible.util.d.oE(18))
      {
        Log.e("MicroMsg.BeaconManager", "API version is below 18!");
        paramJSONObject = com.tencent.mm.vending.j.c.Q(Integer.valueOf(11000), "fail:not support");
        break;
      }
      if (paramJSONObject.lWj == null)
      {
        Log.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
        paramJSONObject = com.tencent.mm.vending.j.c.Q(Integer.valueOf(11001), "fail:bluetooth service is unavailable");
        break;
      }
      if (!paramJSONObject.lWj.isEnabled())
      {
        Log.e("MicroMsg.BeaconManager", "bluetoothAdapter is not enabled!");
        paramJSONObject = com.tencent.mm.vending.j.c.Q(Integer.valueOf(11001), "fail:bluetooth service is unavailable");
        break;
      }
      if (paramJSONObject.lWj.isDiscovering())
      {
        Log.e("MicroMsg.BeaconManager", "bluetoothAdapter is Discovering!");
        paramJSONObject = com.tencent.mm.vending.j.c.Q(Integer.valueOf(11003), "fail:already start");
        break;
      }
      paramJSONObject.lWk.clear();
      Log.i("MicroMsg.BeaconManager", "[BluetoothTrace] start scan");
      Log.printErrStackTrace("MicroMsg.BeaconManager", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
      boolean bool = paramJSONObject.lWj.startLeScan(paramJSONObject.lWp);
      Log.i("MicroMsg.BeaconManager", "startLeScan:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramJSONObject = com.tencent.mm.vending.j.c.Q(Integer.valueOf(11005), "fail:system error");
        break;
      }
      paramJSONObject.isStart = true;
      paramJSONObject = com.tencent.mm.vending.j.c.Q(Integer.valueOf(0), "");
      break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.c
 * JD-Core Version:    0.7.0.1
 */