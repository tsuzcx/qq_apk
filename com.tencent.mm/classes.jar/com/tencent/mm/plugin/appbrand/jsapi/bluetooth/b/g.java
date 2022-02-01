package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseData.Builder;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.AdvertiseSettings.Builder;
import android.os.ParcelUuid;
import android.util.Base64;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "connectable", "", "deviceName", "", "manufacturerData", "", "Lkotlin/Pair;", "", "powerLevel", "serverId", "getServerId", "()I", "setServerId", "(I)V", "serviceUuids", "Landroid/os/ParcelUuid;", "getAdvertiseReqData", "Landroid/bluetooth/le/AdvertiseData;", "getAdvertiseRespData", "getAdvertiseSettings", "Landroid/bluetooth/le/AdvertiseSettings;", "getPowerInfo", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "parseData", "reset", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class g
  extends d<f>
{
  private static final int CTRL_INDEX = 725;
  private static final String NAME = "startBLEPeripheralAdvertising";
  public static final a lLw;
  private String deviceName;
  private int ktp;
  private boolean lLs;
  private final List<ParcelUuid> lLt;
  private final List<kotlin.o<Integer, String>> lLu;
  private String lLv;
  
  static
  {
    AppMethodBeat.i(144764);
    lLw = new a((byte)0);
    NAME = "startBLEPeripheralAdvertising";
    CTRL_INDEX = 725;
    AppMethodBeat.o(144764);
  }
  
  public g()
  {
    AppMethodBeat.i(144763);
    this.ktp = -1;
    this.lLs = true;
    this.lLt = ((List)new ArrayList());
    this.lLu = ((List)new ArrayList());
    this.lLv = "medium";
    this.deviceName = "";
    AppMethodBeat.o(144763);
  }
  
  private final boolean Q(JSONObject paramJSONObject)
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
      this.ktp = paramJSONObject.optInt("serverId");
      localObject1 = paramJSONObject.optString("powerLevel", "medium");
      kotlin.g.b.p.g(localObject1, "data.optString(\"powerLevel\", \"medium\")");
      this.lLv = ((String)localObject1);
      paramJSONObject = paramJSONObject.optJSONObject("advertiseRequest");
      this.lLs = paramJSONObject.optBoolean("connectable", true);
      localObject1 = paramJSONObject.optString("deviceName", "");
      kotlin.g.b.p.g(localObject1, "jAdvertiseRequest.optString(\"deviceName\", \"\")");
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
        this.lLt.add(localObject2);
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
            kotlin.g.b.p.g(localObject1, "manufacturerIdString");
            paramJSONObject = (JSONObject)localObject1;
            if (kotlin.n.n.J((String)localObject1, "0x", false))
            {
              paramJSONObject = kotlin.n.n.j((String)localObject1, "0x", "", false);
              j = 16;
            }
            try
            {
              j = Integer.parseInt(paramJSONObject, j);
              paramJSONObject = localObject3.optString("manufacturerSpecificData", "");
              this.lLu.add(new kotlin.o(Integer.valueOf(j), paramJSONObject));
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
  
  private final AdvertiseData bFh()
  {
    AppMethodBeat.i(144762);
    if (!kotlin.n.n.aL((CharSequence)this.deviceName)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new AdvertiseData.Builder().setIncludeDeviceName(bool);
      localIterator = ((Iterable)this.lLu).iterator();
      while (localIterator.hasNext())
      {
        kotlin.o localo = (kotlin.o)localIterator.next();
        byte[] arrayOfByte = Base64.decode((String)localo.second, 2);
        ((AdvertiseData.Builder)localObject).addManufacturerData(((Number)localo.first).intValue(), c.aK(arrayOfByte));
      }
    }
    Iterator localIterator = ((Iterable)this.lLt).iterator();
    while (localIterator.hasNext()) {
      ((AdvertiseData.Builder)localObject).addServiceUuid((ParcelUuid)localIterator.next());
    }
    Object localObject = ((AdvertiseData.Builder)localObject).build();
    kotlin.g.b.p.g(localObject, "builder.build()");
    AppMethodBeat.o(144762);
    return localObject;
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144760);
    kotlin.g.b.p.h(paramf, "env");
    this.lLu.clear();
    this.lLt.clear();
    this.lLv = "medium";
    this.deviceName = "";
    this.lLs = true;
    this.ktp = -1;
    if (!c.bFE())
    {
      b.a(this, paramInt, paramf, 10001, "fail:not available");
      Log.i("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: Ble is not available");
      AppMethodBeat.o(144760);
      return;
    }
    if (!Q(paramJSONObject))
    {
      Log.e("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "createBLEPeripheralServer data is invalid");
      b.a(this, paramInt, paramf, 10013, "fail:invalid data");
      AppMethodBeat.o(144760);
      return;
    }
    paramJSONObject = o.lLV;
    paramJSONObject = o.wQ(this.ktp);
    if ((paramJSONObject == null) || (paramJSONObject.lLE != p.lLX))
    {
      Log.i("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: retrieve a null server");
      if ((paramJSONObject != null) && (paramJSONObject.lLE == p.lLY))
      {
        b.a(this, paramInt, paramf, 10000, "fail:not init:already connected");
        AppMethodBeat.o(144760);
        return;
      }
      b.a(this, paramInt, paramf, 10020, "fail: no server");
      AppMethodBeat.o(144760);
      return;
    }
    BluetoothAdapter localBluetoothAdapter = c.bFC();
    if (localBluetoothAdapter == null)
    {
      Log.i("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: adapter is null");
      b.a(this, paramInt, paramf, 10001, "fail:not available");
      AppMethodBeat.o(144760);
      return;
    }
    kotlin.g.b.p.h(paramf, "<set-?>");
    paramJSONObject.lqg = paramf;
    Object localObject = this.lLv;
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
      i = ((Number)((kotlin.o)localObject).first).intValue();
      j = ((Number)((kotlin.o)localObject).second).intValue();
      localObject = new AdvertiseSettings.Builder().setAdvertiseMode(i).setTxPowerLevel(j).setTimeout(0).setConnectable(this.lLs).build();
      kotlin.g.b.p.g(localObject, "AdvertiseSettings.Builde…ble)\n            .build()");
      localAdvertiseData1 = bFh();
      localAdvertiseData2 = new AdvertiseData.Builder().setIncludeDeviceName(false).build();
      kotlin.g.b.p.g(localAdvertiseData2, "AdvertiseData.Builder()\n…lse)\n            .build()");
      str = this.deviceName;
      paramf = (AdvertiseCallback)new b(this, paramInt, paramf);
      kotlin.g.b.p.h(localObject, "settings");
      kotlin.g.b.p.h(localAdvertiseData1, "advertiseData");
      kotlin.g.b.p.h(localAdvertiseData2, "scanResponse");
      kotlin.g.b.p.h(str, "deviceName");
      kotlin.g.b.p.h(localBluetoothAdapter, "adapter");
      kotlin.g.b.p.h(paramf, "userCallback");
      if (!paramJSONObject.bFj()) {
        break label566;
      }
      paramf.onStartFailure(3);
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
    paramJSONObject.lLI = paramf;
    paramJSONObject.lLJ.set(true);
    h.RTc.aX((Runnable)new n.d(paramJSONObject, localBluetoothAdapter, str, (AdvertiseSettings)localObject, localAdvertiseData1, localAdvertiseData2));
    AppMethodBeat.o(144760);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$invoke$1", "Landroid/bluetooth/le/AdvertiseCallback;", "onStartFailure", "", "errorCode", "", "onStartSuccess", "settingsInEffect", "Landroid/bluetooth/le/AdvertiseSettings;", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class b
    extends AdvertiseCallback
  {
    b(int paramInt, f paramf) {}
    
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
        b.a(this.lLx, paramInt, paramf, 10008, str);
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
      b.a(this.lLx, paramInt, paramf);
      AppMethodBeat.o(144758);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.g
 * JD-Core Version:    0.7.0.1
 */