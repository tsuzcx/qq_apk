package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseData.Builder;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.AdvertiseSettings.Builder;
import android.os.ParcelUuid;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "getAdvertiseReqData", "Landroid/bluetooth/le/AdvertiseData;", "data", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$AppBrandStartBlePeripheralData;", "getAdvertiseRespData", "getAdvertiseSettings", "Landroid/bluetooth/le/AdvertiseSettings;", "getBeaconAdvertiseReqData", "beacon", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$Beacon;", "getPowerInfo", "Lkotlin/Pair;", "", "invoke", "", "env", "Lorg/json/JSONObject;", "callbackId", "parseData", "startBleAdvertising", "jsonObj", "AppBrandStartBlePeripheralData", "Beacon", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final g.c rLs;
  
  static
  {
    AppMethodBeat.i(144764);
    rLs = new g.c((byte)0);
    NAME = "startBLEPeripheralAdvertising";
    CTRL_INDEX = 725;
    AppMethodBeat.o(144764);
  }
  
  public g()
  {
    AppMethodBeat.i(144763);
    AppMethodBeat.o(144763);
  }
  
  private static AdvertiseData a(a parama)
  {
    AppMethodBeat.i(329655);
    if (!kotlin.n.n.bp((CharSequence)parama.deviceName)) {}
    AdvertiseData.Builder localBuilder;
    for (boolean bool = true;; bool = false)
    {
      localBuilder = new AdvertiseData.Builder().setIncludeDeviceName(bool);
      Iterator localIterator = ((Iterable)parama.rLv).iterator();
      while (localIterator.hasNext())
      {
        r localr = (r)localIterator.next();
        byte[] arrayOfByte = Base64.decode((String)localr.bsD, 2);
        localBuilder.addManufacturerData(((Number)localr.bsC).intValue(), com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aW(arrayOfByte));
      }
    }
    parama = ((Iterable)parama.rLu).iterator();
    while (parama.hasNext()) {
      localBuilder.addServiceUuid((ParcelUuid)parama.next());
    }
    parama = localBuilder.build();
    s.s(parama, "builder.build()");
    AppMethodBeat.o(329655);
    return parama;
  }
  
  private static final void a(g paramg, JSONObject paramJSONObject, final int paramInt, final f paramf)
  {
    AppMethodBeat.i(329660);
    s.u(paramg, "this$0");
    s.u(paramf, "$env");
    a locala = af(paramJSONObject);
    if (locala == null)
    {
      Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "createBLEPeripheralServer data is invalid");
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)paramg, paramInt, paramf, 10013, "fail:invalid data");
      AppMethodBeat.o(329660);
      return;
    }
    paramJSONObject = o.rLP;
    n localn = o.Aw(locala.qim);
    if (localn == null)
    {
      Log.i("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: retrieve a null server");
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)paramg, paramInt, paramf, 10020, "fail: no server");
      AppMethodBeat.o(329660);
      return;
    }
    BluetoothAdapter localBluetoothAdapter = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.crs();
    if (localBluetoothAdapter == null) {}
    for (paramJSONObject = null; (localBluetoothAdapter == null) || (paramJSONObject == null); paramJSONObject = localBluetoothAdapter.getBluetoothLeAdvertiser())
    {
      Log.i("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: adapter is null");
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)paramg, paramInt, paramf, 10001, "fail:not available");
      AppMethodBeat.o(329660);
      return;
    }
    localn.setComponent(paramf);
    Object localObject2 = locala.rLx;
    Object localObject1;
    int i;
    int j;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject1 = new AdvertiseData.Builder();
      i = ((g.b)localObject2).rid;
      j = ((g.b)localObject2).rie;
      int k = ((g.b)localObject2).rLA;
      localObject2 = ((g.b)localObject2).rLz;
      localObject3 = new byte[23];
      localObject3[0] = 2;
      localObject3[1] = 21;
      localObject3[2] = 0;
      localObject3[3] = 0;
      localObject3[4] = 0;
      localObject3[5] = 0;
      localObject3[6] = 0;
      localObject3[7] = 0;
      localObject3[8] = 0;
      localObject3[9] = 0;
      localObject3[10] = 0;
      localObject3[11] = 0;
      localObject3[12] = 0;
      localObject3[13] = 0;
      localObject3[14] = 0;
      localObject3[15] = 0;
      localObject3[16] = 0;
      localObject3[17] = 0;
      localObject3[18] = ((byte)(i >>> 8));
      localObject3[19] = ((byte)i);
      localObject3[20] = ((byte)(j >>> 8));
      localObject3[21] = ((byte)j);
      localObject3[22] = ((byte)k);
      System.arraycopy(localObject2, 0, localObject3, 2, 16);
      ((AdvertiseData.Builder)localObject1).setIncludeTxPowerLevel(false).setIncludeDeviceName(false).addManufacturerData(76, (byte[])localObject3);
      localObject1 = ((AdvertiseData.Builder)localObject1).build();
      s.s(localObject1, "builder.build()");
      j = 2;
      i = 3;
      localObject2 = locala.rLw;
      switch (((String)localObject2).hashCode())
      {
      }
    }
    for (;;)
    {
      localObject2 = new r(Integer.valueOf(j), Integer.valueOf(i));
      i = ((Number)((r)localObject2).bsC).intValue();
      j = ((Number)((r)localObject2).bsD).intValue();
      localObject2 = new AdvertiseSettings.Builder().setAdvertiseMode(i).setTxPowerLevel(j).setTimeout(0).setConnectable(locala.rLt).build();
      s.s(localObject2, "Builder()\n            .s…ble)\n            .build()");
      localObject3 = new AdvertiseData.Builder().setIncludeDeviceName(false).build();
      s.s(localObject3, "Builder()\n            .s…lse)\n            .build()");
      localn.a((AdvertiseSettings)localObject2, (AdvertiseData)localObject1, (AdvertiseData)localObject3, locala.deviceName, localBluetoothAdapter, paramJSONObject, (AdvertiseCallback)new d(paramg, paramInt, paramf));
      AppMethodBeat.o(329660);
      return;
      localObject1 = a(locala);
      break;
      if (((String)localObject2).equals("high"))
      {
        j = 2;
        i = 3;
        continue;
        if (((String)localObject2).equals("low"))
        {
          j = 0;
          i = 1;
          continue;
          if (((String)localObject2).equals("medium"))
          {
            j = 1;
            i = 2;
          }
        }
      }
    }
  }
  
  private static a af(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(329653);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(329653);
      return null;
    }
    a locala = new a((List)new ArrayList(), (List)new ArrayList(), "medium", "");
    Object localObject1;
    Object localObject3;
    label474:
    do
    {
      for (;;)
      {
        try
        {
          locala.qim = paramJSONObject.optInt("serverId");
          localObject1 = paramJSONObject.optString("powerLevel", "medium");
          s.s(localObject1, "data.optString(\"powerLevel\", \"medium\")");
          s.u(localObject1, "<set-?>");
          locala.rLw = ((String)localObject1);
          paramJSONObject = paramJSONObject.optJSONObject("advertiseRequest");
          s.checkNotNull(paramJSONObject);
          localObject1 = paramJSONObject.optJSONObject("beacon");
          if (localObject1 != null)
          {
            paramJSONObject = g.b.rLy;
            s.u(localObject1, "json");
            paramJSONObject = ((JSONObject)localObject1).optString("uuid");
            s.s(paramJSONObject, "json.optString(\"uuid\")");
            locala.rLx = new g.b(g.c.hexStringToBytes(kotlin.n.n.bV(paramJSONObject, "-", "")), ((JSONObject)localObject1).optInt("major"), ((JSONObject)localObject1).optInt("minor"), ((JSONObject)localObject1).optInt("measuredPower"));
            AppMethodBeat.o(329653);
            return locala;
          }
          locala.rLt = paramJSONObject.optBoolean("connectable", true);
          localObject1 = paramJSONObject.optString("deviceName", "");
          s.s(localObject1, "jAdvertiseRequest.optString(\"deviceName\", \"\")");
          s.u(localObject1, "<set-?>");
          locala.deviceName = ((String)localObject1);
          localObject2 = paramJSONObject.optJSONArray("serviceUuids");
          if (localObject2 == null) {
            break label474;
          }
          j = ((JSONArray)localObject2).length();
          localObject1 = new String[j];
          i = 0;
          if (i >= j) {
            break;
          }
          localObject3 = ((JSONArray)localObject2).get(i);
          if (localObject3 == null)
          {
            paramJSONObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(329653);
            throw paramJSONObject;
          }
        }
        catch (Exception paramJSONObject)
        {
          Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "parseData: error ", new Object[] { paramJSONObject });
          AppMethodBeat.o(329653);
          return null;
        }
        localObject1[i] = ((String)localObject3);
        i += 1;
      }
      localObject2 = (Collection)new ArrayList(localObject1.length);
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        ((Collection)localObject2).add(new ParcelUuid(a.aas(localObject1[i])));
        i += 1;
      }
      localObject1 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ParcelUuid)((Iterator)localObject1).next();
        locala.rLu.add(localObject2);
      }
      paramJSONObject = paramJSONObject.optJSONArray("manufacturerData");
    } while (paramJSONObject == null);
    int j = paramJSONObject.length();
    Object localObject2 = new JSONObject[j];
    int i = 0;
    while (i < j)
    {
      localObject1 = paramJSONObject.get(i);
      if (localObject1 == null)
      {
        paramJSONObject = new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        AppMethodBeat.o(329653);
        throw paramJSONObject;
      }
      localObject2[i] = ((JSONObject)localObject1);
      i += 1;
    }
    int k = localObject2.length;
    i = 0;
    while (i < k)
    {
      localObject3 = localObject2[i];
      localObject1 = localObject3.optString("manufacturerId");
      j = 10;
      s.s(localObject1, "manufacturerIdString");
      paramJSONObject = (JSONObject)localObject1;
      if (kotlin.n.n.U((String)localObject1, "0x", false))
      {
        s.s(localObject1, "manufacturerIdString");
        paramJSONObject = kotlin.n.n.bV((String)localObject1, "0x", "");
        j = 16;
      }
      try
      {
        j = Integer.parseInt(paramJSONObject, j);
        paramJSONObject = localObject3.optString("manufacturerSpecificData", "");
        locala.rLv.add(new r(Integer.valueOf(j), paramJSONObject));
        i += 1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", s.X("NumberFormatException: input = ", paramJSONObject));
          j = 0;
        }
      }
    }
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144760);
    s.u(paramf, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10001, "fail:not available");
      Log.i("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: Ble is not available");
      AppMethodBeat.o(144760);
      return;
    }
    h.ahAA.g(new g..ExternalSyntheticLambda0(this, paramJSONObject, paramInt, paramf), "MicroMsg.BLE.Peripheral");
    AppMethodBeat.o(144760);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$AppBrandStartBlePeripheralData;", "", "serverId", "", "connectable", "", "serviceUuids", "", "Landroid/os/ParcelUuid;", "manufacturerData", "Lkotlin/Pair;", "", "powerLevel", "deviceName", "beacon", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$Beacon;", "(IZLjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$Beacon;)V", "getBeacon", "()Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$Beacon;", "setBeacon", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$Beacon;)V", "getConnectable", "()Z", "setConnectable", "(Z)V", "getDeviceName", "()Ljava/lang/String;", "setDeviceName", "(Ljava/lang/String;)V", "getManufacturerData", "()Ljava/util/List;", "setManufacturerData", "(Ljava/util/List;)V", "getPowerLevel", "setPowerLevel", "getServerId", "()I", "setServerId", "(I)V", "getServiceUuids", "setServiceUuids", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    String deviceName;
    int qim;
    boolean rLt;
    List<ParcelUuid> rLu;
    List<r<Integer, String>> rLv;
    String rLw;
    g.b rLx;
    
    public a(List<ParcelUuid> paramList, List<r<Integer, String>> paramList1, String paramString1, String paramString2)
    {
      AppMethodBeat.i(329636);
      this.qim = -1;
      this.rLt = true;
      this.rLu = paramList;
      this.rLv = paramList1;
      this.rLw = paramString1;
      this.deviceName = paramString2;
      this.rLx = null;
      AppMethodBeat.o(329636);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$startBleAdvertising$1", "Landroid/bluetooth/le/AdvertiseCallback;", "onStartFailure", "", "errorCode", "", "onStartSuccess", "settingsInEffect", "Landroid/bluetooth/le/AdvertiseSettings;", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends AdvertiseCallback
  {
    d(g paramg, int paramInt, f paramf) {}
    
    public final void onStartFailure(int paramInt)
    {
      AppMethodBeat.i(329646);
      super.onStartFailure(paramInt);
      Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", s.X("Not broadcasting: ", Integer.valueOf(paramInt)));
      String str;
      switch (paramInt)
      {
      default: 
        str = "fail:Unhandled " + paramInt + " error";
      }
      for (;;)
      {
        Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", s.X("onStartFailure: error msg = ", str));
        b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this.rLB, paramInt, paramf, 10008, str);
        AppMethodBeat.o(329646);
        return;
        str = "fail:already started";
        continue;
        str = "fail:data too large";
        continue;
        str = "fail:feature unsupported";
        continue;
        str = "fail:internal error";
        continue;
        str = "fail:too many advertisers";
      }
    }
    
    public final void onStartSuccess(AdvertiseSettings paramAdvertiseSettings)
    {
      AppMethodBeat.i(329642);
      super.onStartSuccess(paramAdvertiseSettings);
      b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this.rLB, paramInt, paramf);
      AppMethodBeat.o(329642);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.g
 * JD-Core Version:    0.7.0.1
 */