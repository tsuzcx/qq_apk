package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseData.Builder;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.AdvertiseSettings.Builder;
import android.os.ParcelUuid;
import android.util.Base64;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.l;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "connectable", "", "deviceName", "", "manufacturerData", "", "Lkotlin/Pair;", "", "powerLevel", "serverId", "getServerId", "()I", "setServerId", "(I)V", "serviceUuids", "Landroid/os/ParcelUuid;", "getAdvertiseReqData", "Landroid/bluetooth/le/AdvertiseData;", "getAdvertiseRespData", "getAdvertiseSettings", "Landroid/bluetooth/le/AdvertiseSettings;", "getPowerInfo", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "parseData", "reset", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  private static final int CTRL_INDEX = 725;
  private static final String NAME = "startBLEPeripheralAdvertising";
  public static final g.a oHL;
  private String deviceName;
  private int nld;
  private boolean oHH;
  private final List<ParcelUuid> oHI;
  private final List<kotlin.o<Integer, String>> oHJ;
  private String oHK;
  
  static
  {
    AppMethodBeat.i(144764);
    oHL = new g.a((byte)0);
    NAME = "startBLEPeripheralAdvertising";
    CTRL_INDEX = 725;
    AppMethodBeat.o(144764);
  }
  
  public g()
  {
    AppMethodBeat.i(144763);
    this.nld = -1;
    this.oHH = true;
    this.oHI = ((List)new ArrayList());
    this.oHJ = ((List)new ArrayList());
    this.oHK = "medium";
    this.deviceName = "";
    AppMethodBeat.o(144763);
  }
  
  private final boolean U(JSONObject paramJSONObject)
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
      this.nld = paramJSONObject.optInt("serverId");
      localObject1 = paramJSONObject.optString("powerLevel", "medium");
      kotlin.g.b.p.j(localObject1, "data.optString(\"powerLevel\", \"medium\")");
      this.oHK = ((String)localObject1);
      paramJSONObject = paramJSONObject.optJSONObject("advertiseRequest");
      this.oHH = paramJSONObject.optBoolean("connectable", true);
      localObject1 = paramJSONObject.optString("deviceName", "");
      kotlin.g.b.p.j(localObject1, "jAdvertiseRequest.optString(\"deviceName\", \"\")");
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
            paramJSONObject = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(144761);
            throw paramJSONObject;
          }
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "parseData: error ", new Object[] { paramJSONObject });
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
        this.oHI.add(localObject2);
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
            paramJSONObject = new t("null cannot be cast to non-null type org.json.JSONObject");
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
            kotlin.g.b.p.j(localObject1, "manufacturerIdString");
            paramJSONObject = (JSONObject)localObject1;
            if (kotlin.n.n.M((String)localObject1, "0x", false))
            {
              paramJSONObject = kotlin.n.n.l((String)localObject1, "0x", "", false);
              j = 16;
            }
            try
            {
              j = Integer.parseInt(paramJSONObject, j);
              paramJSONObject = localObject3.optString("manufacturerSpecificData", "");
              this.oHJ.add(new kotlin.o(Integer.valueOf(j), paramJSONObject));
              i += 1;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "NumberFormatException: input = ".concat(String.valueOf(paramJSONObject)));
                j = 0;
              }
            }
          }
        }
      }
      bool = true;
    }
  }
  
  private final AdvertiseData bQL()
  {
    AppMethodBeat.i(144762);
    if (!kotlin.n.n.ba((CharSequence)this.deviceName)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new AdvertiseData.Builder().setIncludeDeviceName(bool);
      localIterator = ((Iterable)this.oHJ).iterator();
      while (localIterator.hasNext())
      {
        kotlin.o localo = (kotlin.o)localIterator.next();
        byte[] arrayOfByte = Base64.decode((String)localo.My, 2);
        ((AdvertiseData.Builder)localObject).addManufacturerData(((Number)localo.Mx).intValue(), com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aW(arrayOfByte));
      }
    }
    Iterator localIterator = ((Iterable)this.oHI).iterator();
    while (localIterator.hasNext()) {
      ((AdvertiseData.Builder)localObject).addServiceUuid((ParcelUuid)localIterator.next());
    }
    Object localObject = ((AdvertiseData.Builder)localObject).build();
    kotlin.g.b.p.j(localObject, "builder.build()");
    AppMethodBeat.o(144762);
    return localObject;
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144760);
    kotlin.g.b.p.k(parame, "env");
    this.oHJ.clear();
    this.oHI.clear();
    this.oHK = "medium";
    this.deviceName = "";
    this.oHH = true;
    this.nld = -1;
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRm())
    {
      b.a(this, paramInt, parame, 10001, "fail:not available");
      Log.i("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: Ble is not available");
      AppMethodBeat.o(144760);
      return;
    }
    if (!U(paramJSONObject))
    {
      Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "createBLEPeripheralServer data is invalid");
      b.a(this, paramInt, parame, 10013, "fail:invalid data");
      AppMethodBeat.o(144760);
      return;
    }
    paramJSONObject = o.oIk;
    paramJSONObject = o.Af(this.nld);
    if ((paramJSONObject == null) || (paramJSONObject.oHT != p.oIm))
    {
      Log.i("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: retrieve a null server");
      if ((paramJSONObject != null) && (paramJSONObject.oHT == p.oIn))
      {
        b.a(this, paramInt, parame, 10000, "fail:not init:already connected");
        AppMethodBeat.o(144760);
        return;
      }
      b.a(this, paramInt, parame, 10020, "fail: no server");
      AppMethodBeat.o(144760);
      return;
    }
    BluetoothAdapter localBluetoothAdapter = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRk();
    if (localBluetoothAdapter == null)
    {
      Log.i("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: adapter is null");
      b.a(this, paramInt, parame, 10001, "fail:not available");
      AppMethodBeat.o(144760);
      return;
    }
    kotlin.g.b.p.k(parame, "<set-?>");
    paramJSONObject.okQ = parame;
    Object localObject = this.oHK;
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
      localObject = new kotlin.o(Integer.valueOf(j), Integer.valueOf(i));
      i = ((Number)((kotlin.o)localObject).Mx).intValue();
      j = ((Number)((kotlin.o)localObject).My).intValue();
      localObject = new AdvertiseSettings.Builder().setAdvertiseMode(i).setTxPowerLevel(j).setTimeout(0).setConnectable(this.oHH).build();
      kotlin.g.b.p.j(localObject, "AdvertiseSettings.Builde…ble)\n            .build()");
      localAdvertiseData1 = bQL();
      localAdvertiseData2 = new AdvertiseData.Builder().setIncludeDeviceName(false).build();
      kotlin.g.b.p.j(localAdvertiseData2, "AdvertiseData.Builder()\n…lse)\n            .build()");
      str = this.deviceName;
      parame = (AdvertiseCallback)new b(this, paramInt, parame);
      kotlin.g.b.p.k(localObject, "settings");
      kotlin.g.b.p.k(localAdvertiseData1, "advertiseData");
      kotlin.g.b.p.k(localAdvertiseData2, "scanResponse");
      kotlin.g.b.p.k(str, "deviceName");
      kotlin.g.b.p.k(localBluetoothAdapter, "adapter");
      kotlin.g.b.p.k(parame, "userCallback");
      if (!paramJSONObject.bQN()) {
        break label566;
      }
      parame.onStartFailure(3);
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
    label566:
    paramJSONObject.oHX = parame;
    paramJSONObject.oHY.set(true);
    h.ZvG.be((Runnable)new n.d(paramJSONObject, localBluetoothAdapter, str, (AdvertiseSettings)localObject, localAdvertiseData1, localAdvertiseData2));
    AppMethodBeat.o(144760);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$invoke$1", "Landroid/bluetooth/le/AdvertiseCallback;", "onStartFailure", "", "errorCode", "", "onStartSuccess", "settingsInEffect", "Landroid/bluetooth/le/AdvertiseSettings;", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class b
    extends AdvertiseCallback
  {
    b(int paramInt, e parame) {}
    
    public final void onStartFailure(int paramInt)
    {
      AppMethodBeat.i(144759);
      super.onStartFailure(paramInt);
      Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "Not broadcasting: ".concat(String.valueOf(paramInt)));
      String str;
      switch (paramInt)
      {
      default: 
        str = "fail:Unhandled " + paramInt + " error";
      }
      for (;;)
      {
        Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "onStartFailure: error msg = ".concat(String.valueOf(str)));
        b.a(this.oHM, paramInt, parame, 10008, str);
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
      b.a(this.oHM, paramInt, parame);
      AppMethodBeat.o(144758);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.g
 * JD-Core Version:    0.7.0.1
 */