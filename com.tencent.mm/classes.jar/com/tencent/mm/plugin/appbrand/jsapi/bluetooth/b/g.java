package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseData.Builder;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.AdvertiseSettings.Builder;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.os.ParcelUuid;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "connectable", "", "deviceName", "", "manufacturerData", "", "Lkotlin/Pair;", "", "powerLevel", "serverId", "getServerId", "()I", "setServerId", "(I)V", "serviceUuids", "Landroid/os/ParcelUuid;", "getAdvertiseReqData", "Landroid/bluetooth/le/AdvertiseData;", "getAdvertiseRespData", "getAdvertiseSettings", "Landroid/bluetooth/le/AdvertiseSettings;", "getPowerInfo", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "parseData", "reset", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class g
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  private static final int CTRL_INDEX = 725;
  private static final String NAME = "startBLEPeripheralAdvertising";
  public static final a kiO;
  private String deviceName;
  private int iYZ;
  private boolean kiK;
  private final List<ParcelUuid> kiL;
  private final List<d.o<Integer, String>> kiM;
  private String kiN;
  
  static
  {
    AppMethodBeat.i(144764);
    kiO = new a((byte)0);
    NAME = "startBLEPeripheralAdvertising";
    CTRL_INDEX = 725;
    AppMethodBeat.o(144764);
  }
  
  public g()
  {
    AppMethodBeat.i(144763);
    this.iYZ = -1;
    this.kiK = true;
    this.kiL = ((List)new ArrayList());
    this.kiM = ((List)new ArrayList());
    this.kiN = "medium";
    this.deviceName = "";
    AppMethodBeat.o(144763);
  }
  
  private final boolean J(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(144761);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(144761);
      return false;
    }
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    Object localObject3;
    boolean bool;
    try
    {
      this.iYZ = paramJSONObject.optInt("serverId");
      localObject1 = paramJSONObject.optString("powerLevel", "medium");
      k.g(localObject1, "data.optString(\"powerLevel\", \"medium\")");
      this.kiN = ((String)localObject1);
      paramJSONObject = paramJSONObject.optJSONObject("advertiseRequest");
      this.kiK = paramJSONObject.optBoolean("connectable", true);
      localObject1 = paramJSONObject.optString("deviceName", "");
      k.g(localObject1, "jAdvertiseRequest.optString(\"deviceName\", \"\")");
      this.deviceName = ((String)localObject1);
      localObject2 = paramJSONObject.optJSONArray("serviceUuids");
      if (localObject2 != null)
      {
        j = ((JSONArray)localObject2).length();
        localObject1 = new String[j];
        i = 0;
        if (i < j)
        {
          localObject3 = ((JSONArray)localObject2).get(i);
          if (localObject3 == null)
          {
            paramJSONObject = new v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(144761);
            throw paramJSONObject;
          }
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      ac.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "parseData: error ", new Object[] { paramJSONObject });
      bool = false;
    }
    for (;;)
    {
      AppMethodBeat.o(144761);
      return bool;
      localObject1[i] = ((String)localObject3);
      i += 1;
      break;
      localObject2 = (Collection)new ArrayList(localObject1.length);
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        ((Collection)localObject2).add(new ParcelUuid(UUID.fromString(localObject1[i])));
        i += 1;
      }
      localObject1 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ParcelUuid)((Iterator)localObject1).next();
        this.kiL.add(localObject2);
      }
      paramJSONObject = paramJSONObject.optJSONArray("manufacturerData");
      if (paramJSONObject != null)
      {
        j = paramJSONObject.length();
        localObject2 = new JSONObject[j];
        i = 0;
        while (i < j)
        {
          localObject1 = paramJSONObject.get(i);
          if (localObject1 == null)
          {
            paramJSONObject = new v("null cannot be cast to non-null type org.json.JSONObject");
            AppMethodBeat.o(144761);
            throw paramJSONObject;
          }
          localObject2[i] = ((JSONObject)localObject1);
          i += 1;
        }
        int k = localObject2.length;
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            localObject3 = localObject2[i];
            localObject1 = localObject3.optString("manufacturerId");
            j = 10;
            k.g(localObject1, "manufacturerIdString");
            paramJSONObject = (JSONObject)localObject1;
            if (d.n.n.nb((String)localObject1, "0x"))
            {
              paramJSONObject = d.n.n.h((String)localObject1, "0x", "", false);
              j = 16;
            }
            try
            {
              j = Integer.parseInt(paramJSONObject, j);
              paramJSONObject = localObject3.optString("manufacturerSpecificData", "");
              this.kiM.add(new d.o(Integer.valueOf(j), paramJSONObject));
              i += 1;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                ac.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "NumberFormatException: input = ".concat(String.valueOf(paramJSONObject)));
                j = 0;
              }
            }
          }
        }
      }
      bool = true;
    }
  }
  
  private final AdvertiseData bfF()
  {
    AppMethodBeat.i(144762);
    if (!d.n.n.aD((CharSequence)this.deviceName)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new AdvertiseData.Builder().setIncludeDeviceName(bool);
      localIterator = ((Iterable)this.kiM).iterator();
      while (localIterator.hasNext())
      {
        d.o localo = (d.o)localIterator.next();
        byte[] arrayOfByte = Base64.decode((String)localo.second, 2);
        ((AdvertiseData.Builder)localObject).addManufacturerData(((Number)localo.first).intValue(), com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.at(arrayOfByte));
      }
    }
    Iterator localIterator = ((Iterable)this.kiL).iterator();
    while (localIterator.hasNext()) {
      ((AdvertiseData.Builder)localObject).addServiceUuid((ParcelUuid)localIterator.next());
    }
    Object localObject = ((AdvertiseData.Builder)localObject).build();
    k.g(localObject, "builder.build()");
    AppMethodBeat.o(144762);
    return localObject;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(144760);
    k.h(paramc, "env");
    this.kiM.clear();
    this.kiL.clear();
    this.kiN = "medium";
    this.deviceName = "";
    this.kiK = true;
    this.iYZ = -1;
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfV())
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      ac.i("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: Ble is not available");
      AppMethodBeat.o(144760);
      return;
    }
    if (!J(paramJSONObject))
    {
      ac.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "createBLEPeripheralServer data is invalid");
      b.a(this, paramInt, paramc, 10013, "fail:invalid data");
      AppMethodBeat.o(144760);
      return;
    }
    paramJSONObject = o.kjh;
    paramJSONObject = o.sp(this.iYZ);
    if ((paramJSONObject == null) || (paramJSONObject.kiW != p.kjj))
    {
      ac.i("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: retrieve a null server");
      if ((paramJSONObject != null) && (paramJSONObject.kiW == p.kjk))
      {
        b.a(this, paramInt, paramc, 10000, "fail:not init:already connected");
        AppMethodBeat.o(144760);
        return;
      }
      b.a(this, paramInt, paramc, 10020, "fail: no server");
      AppMethodBeat.o(144760);
      return;
    }
    BluetoothAdapter localBluetoothAdapter = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfT();
    if (localBluetoothAdapter == null)
    {
      ac.i("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: adapter is null");
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      AppMethodBeat.o(144760);
      return;
    }
    k.h(paramc, "<set-?>");
    paramJSONObject.jOV = paramc;
    Object localObject = this.kiN;
    int i;
    int j;
    switch (((String)localObject).hashCode())
    {
    default: 
      i = 3;
      j = 2;
    }
    AdvertiseData localAdvertiseData1;
    AdvertiseData localAdvertiseData2;
    String str;
    for (;;)
    {
      localObject = new d.o(Integer.valueOf(j), Integer.valueOf(i));
      i = ((Number)((d.o)localObject).first).intValue();
      j = ((Number)((d.o)localObject).second).intValue();
      localObject = new AdvertiseSettings.Builder().setAdvertiseMode(i).setTxPowerLevel(j).setTimeout(0).setConnectable(this.kiK).build();
      k.g(localObject, "AdvertiseSettings.Builde…ble)\n            .build()");
      localAdvertiseData1 = bfF();
      localAdvertiseData2 = new AdvertiseData.Builder().setIncludeDeviceName(false).build();
      k.g(localAdvertiseData2, "AdvertiseData.Builder()\n…lse)\n            .build()");
      str = this.deviceName;
      paramc = (AdvertiseCallback)new b(this, paramInt, paramc);
      k.h(localObject, "settings");
      k.h(localAdvertiseData1, "advertiseData");
      k.h(localAdvertiseData2, "scanResponse");
      k.h(str, "deviceName");
      k.h(localBluetoothAdapter, "adapter");
      k.h(paramc, "userCallback");
      if (paramJSONObject.kja == null) {
        break label570;
      }
      paramc.onStartFailure(3);
      AppMethodBeat.o(144760);
      return;
      if (!((String)localObject).equals("high")) {
        break;
      }
      i = 3;
      j = 2;
      continue;
      if (!((String)localObject).equals("low")) {
        break;
      }
      i = 1;
      j = 0;
      continue;
      if (!((String)localObject).equals("medium")) {
        break;
      }
      i = 2;
      j = 1;
    }
    label570:
    paramJSONObject.kja = paramc;
    if (!d.n.n.aD((CharSequence)str)) {}
    for (paramInt = k;; paramInt = 0)
    {
      if (paramInt != 0) {
        localBluetoothAdapter.setName(str);
      }
      paramc = localBluetoothAdapter.getBluetoothLeAdvertiser();
      if (paramc != null) {
        break;
      }
      AppMethodBeat.o(144760);
      return;
    }
    paramc.startAdvertising((AdvertiseSettings)localObject, localAdvertiseData1, localAdvertiseData2, paramJSONObject.kiZ);
    AppMethodBeat.o(144760);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$invoke$1", "Landroid/bluetooth/le/AdvertiseCallback;", "onStartFailure", "", "errorCode", "", "onStartSuccess", "settingsInEffect", "Landroid/bluetooth/le/AdvertiseSettings;", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class b
    extends AdvertiseCallback
  {
    b(int paramInt, com.tencent.mm.plugin.appbrand.jsapi.c paramc) {}
    
    public final void onStartFailure(int paramInt)
    {
      AppMethodBeat.i(144759);
      super.onStartFailure(paramInt);
      ac.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "Not broadcasting: ".concat(String.valueOf(paramInt)));
      String str;
      switch (paramInt)
      {
      default: 
        str = "fail:Unhandled " + paramInt + " error";
      }
      for (;;)
      {
        ac.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "onStartFailure: error msg = ".concat(String.valueOf(str)));
        b.a(this.kiP, paramInt, paramc, 10008, str);
        AppMethodBeat.o(144759);
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
      AppMethodBeat.i(144758);
      super.onStartSuccess(paramAdvertiseSettings);
      b.a(this.kiP, paramInt, paramc);
      AppMethodBeat.o(144758);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.g
 * JD-Core Version:    0.7.0.1
 */