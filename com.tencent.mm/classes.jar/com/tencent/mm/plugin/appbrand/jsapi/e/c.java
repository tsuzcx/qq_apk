package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.sdk.platformtools.ad;
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
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 221;
  private static final String NAME = "startBeaconDiscovery";
  g.c kEd = null;
  private a.a.a kNI;
  
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
      ad.e("MicroMsg.JsApiStartBeaconDiscovery", "serviceUuids is empty");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(11006));
      paramc.h(paramInt, m("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144679);
      return;
    }
    String str = paramc.getAppId();
    Object localObject = a.PD(paramc.getAppId());
    paramJSONObject = (JSONObject)localObject;
    if (localObject == null)
    {
      ad.i("MicroMsg.JsApiStartBeaconDiscovery", "beaconWorker init");
      paramJSONObject = new a.a();
      a.a(str, paramJSONObject);
    }
    if (this.kNI == null)
    {
      ad.i("MicroMsg.JsApiStartBeaconDiscovery", "onBeaconScanCallback init");
      this.kNI = new a.a.a()
      {
        c.b kNN;
        c.a kNO;
        
        public final void E(Map<String, JSONObject> paramAnonymousMap)
        {
          AppMethodBeat.i(144676);
          ad.d("MicroMsg.JsApiStartBeaconDiscovery", "found device ibeacon %s", new Object[] { paramAnonymousMap });
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
            this.kNN.b(paramc, paramc.aXC()).Pi(paramAnonymousMap.toString()).bir();
            AppMethodBeat.o(144676);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              ad.e("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", new Object[] { localJSONException });
            }
          }
        }
        
        public final void gs(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(144677);
          ad.i("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("available", paramAnonymousBoolean);
            localJSONObject.put("discovering", false);
            ad.d("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[] { localJSONObject.toString() });
            this.kNO.b(paramc, paramc.aXC()).Pi(localJSONObject.toString()).bir();
            AppMethodBeat.o(144677);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              ad.e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
            }
          }
        }
      };
    }
    if (this.kEd == null)
    {
      ad.i("MicroMsg.JsApiStartBeaconDiscovery", "listener init");
      this.kEd = new g.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(144678);
          ad.i("MicroMsg.JsApiStartBeaconDiscovery", "onDestroy");
          g.b(paramc.getAppId(), this);
          a.a locala = a.PD(paramc.getAppId());
          if (locala != null)
          {
            locala.Gv();
            a.remove(paramc.getAppId());
          }
          c.this.kEd = null;
          AppMethodBeat.o(144678);
        }
      };
      g.a(paramc.getAppId(), this.kEd);
    }
    paramJSONObject.kNH = arrayOfUUID;
    paramJSONObject.kNI = this.kNI;
    ad.i("MicroMsg.BeaconManager", "BeaconWorker:%d start", new Object[] { Integer.valueOf(paramJSONObject.hashCode()) });
    if (paramJSONObject.isStart())
    {
      ad.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already start", new Object[] { Integer.valueOf(paramJSONObject.hashCode()) });
      paramJSONObject = com.tencent.mm.vending.j.c.N(Integer.valueOf(11003), "fail:already start");
      localObject = new HashMap();
      ((Map)localObject).put("errCode", paramJSONObject.get(0));
      if (((Integer)paramJSONObject.get(0)).intValue() != 0) {
        break label542;
      }
    }
    label542:
    for (paramJSONObject = "ok";; paramJSONObject = (String)paramJSONObject.get(1))
    {
      paramc.h(paramInt, m(paramJSONObject, (Map)localObject));
      AppMethodBeat.o(144679);
      return;
      if (d.lz(18))
      {
        ad.e("MicroMsg.BeaconManager", "API version is below 18!");
        paramJSONObject = com.tencent.mm.vending.j.c.N(Integer.valueOf(11000), "fail:not support");
        break;
      }
      if (paramJSONObject.kNF == null)
      {
        ad.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
        paramJSONObject = com.tencent.mm.vending.j.c.N(Integer.valueOf(11001), "fail:bluetooth service is unavailable");
        break;
      }
      if (!paramJSONObject.kNF.isEnabled())
      {
        ad.e("MicroMsg.BeaconManager", "bluetoothAdapter is not enabled!");
        paramJSONObject = com.tencent.mm.vending.j.c.N(Integer.valueOf(11001), "fail:bluetooth service is unavailable");
        break;
      }
      if (paramJSONObject.kNF.isDiscovering())
      {
        ad.e("MicroMsg.BeaconManager", "bluetoothAdapter is Discovering!");
        paramJSONObject = com.tencent.mm.vending.j.c.N(Integer.valueOf(11003), "fail:already start");
        break;
      }
      paramJSONObject.kNG.clear();
      boolean bool = paramJSONObject.kNF.startLeScan(paramJSONObject.kNL);
      ad.i("MicroMsg.BeaconManager", "startLeScan:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramJSONObject = com.tencent.mm.vending.j.c.N(Integer.valueOf(11005), "fail:system error");
        break;
      }
      paramJSONObject.isStart = true;
      paramJSONObject = com.tencent.mm.vending.j.c.N(Integer.valueOf(0), "");
      break;
    }
  }
  
  static final class a
    extends at
  {
    private static final int CTRL_INDEX = 225;
    private static final String NAME = "onBeaconServiceChanged";
  }
  
  static final class b
    extends at
  {
    private static final int CTRL_INDEX = 224;
    private static final String NAME = "onBeaconUpdated";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.c
 * JD-Core Version:    0.7.0.1
 */