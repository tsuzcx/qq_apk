package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.g.b.v.f;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiAddBlePeripheralService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "parseData", "Landroid/bluetooth/BluetoothGattService;", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class c
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  private static final int CTRL_INDEX = 723;
  private static final String NAME = "addBLEPeripheralService";
  public static final a kiF;
  
  static
  {
    AppMethodBeat.i(144751);
    kiF = new a((byte)0);
    NAME = "addBLEPeripheralService";
    CTRL_INDEX = 723;
    AppMethodBeat.o(144751);
  }
  
  private static BluetoothGattService I(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(144750);
    v.f localf = new v.f();
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(144750);
      return null;
    }
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("service");
      localf.KUQ = new BluetoothGattService(UUID.fromString(paramJSONObject.optString("uuid")), 0);
      localObject1 = paramJSONObject.optJSONArray("characteristics");
      if (localObject1 != null) {
        break label121;
      }
      paramJSONObject = (BluetoothGattService)localf.KUQ;
      AppMethodBeat.o(144750);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      ac.e("MicroMsg.BLE.JsApiAddBlePeripheralService", "parseData: fail", new Object[] { paramJSONObject });
      localf.KUQ = null;
    }
    paramJSONObject = (BluetoothGattService)localf.KUQ;
    AppMethodBeat.o(144750);
    return paramJSONObject;
    label121:
    int j = ((JSONArray)localObject1).length();
    paramJSONObject = new JSONObject[j];
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = ((JSONArray)localObject1).get(i);
      if (localObject2 == null)
      {
        paramJSONObject = new v("null cannot be cast to non-null type org.json.JSONObject");
        AppMethodBeat.o(144750);
        throw paramJSONObject;
      }
      paramJSONObject[i] = ((JSONObject)localObject2);
      i += 1;
    }
    Object localObject1 = (Collection)new ArrayList(paramJSONObject.length);
    int n = paramJSONObject.length;
    int k = 0;
    label204:
    Object localObject3;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    label296:
    label357:
    int m;
    Object localObject4;
    label520:
    Object localObject5;
    if (k < n)
    {
      JSONObject[] arrayOfJSONObject = paramJSONObject[k];
      localObject2 = arrayOfJSONObject.optString("uuid");
      localObject3 = arrayOfJSONObject.optJSONObject("properties");
      bool1 = ((JSONObject)localObject3).optBoolean("write", false);
      bool2 = ((JSONObject)localObject3).optBoolean("read", false);
      bool3 = ((JSONObject)localObject3).optBoolean("notify", false);
      bool4 = ((JSONObject)localObject3).optBoolean("indicate", false);
      bool5 = ((JSONObject)localObject3).optBoolean("writeNoResponse", false);
      j = 0;
      if (!bool1) {
        break label757;
      }
      j = 8;
      break label757;
      localObject3 = arrayOfJSONObject.optJSONObject("permission");
      bool1 = ((JSONObject)localObject3).optBoolean("readable", false);
      bool2 = ((JSONObject)localObject3).optBoolean("writeable", false);
      bool3 = ((JSONObject)localObject3).optBoolean("readEncryptionRequired", false);
      bool4 = ((JSONObject)localObject3).optBoolean("writeEncryptionRequired", false);
      j = 0;
      if (!bool1) {
        break label805;
      }
      j = 1;
      break label805;
      localObject2 = new BluetoothGattCharacteristic(UUID.fromString((String)localObject2), m, i);
      localObject3 = arrayOfJSONObject.optString("value");
      localObject4 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.at(Base64.decode((String)localObject3, 2));
      ac.i("MicroMsg.BLE.JsApiAddBlePeripheralService", "parseData characteristic : base64 = " + (String)localObject3 + ", hex = " + localObject4);
      ((BluetoothGattCharacteristic)localObject2).setValue((byte[])localObject4);
      localObject3 = arrayOfJSONObject.optJSONArray("descriptors");
      if (localObject3 != null)
      {
        j = ((JSONArray)localObject3).length();
        arrayOfJSONObject = new JSONObject[j];
        i = 0;
        while (i < j)
        {
          localObject4 = ((JSONArray)localObject3).get(i);
          if (localObject4 == null)
          {
            paramJSONObject = new v("null cannot be cast to non-null type org.json.JSONObject");
            AppMethodBeat.o(144750);
            throw paramJSONObject;
          }
          arrayOfJSONObject[i] = ((JSONObject)localObject4);
          i += 1;
        }
        int i1 = arrayOfJSONObject.length;
        j = 0;
        if (j < i1)
        {
          localObject3 = arrayOfJSONObject[j];
          localObject4 = ((JSONObject)localObject3).optString("uuid");
          localObject5 = ((JSONObject)localObject3).optJSONObject("permission");
          localObject3 = ((JSONObject)localObject3).optString("value");
          bool1 = ((JSONObject)localObject5).optBoolean("write");
          bool2 = ((JSONObject)localObject5).optBoolean("read");
          i = 0;
          if (!bool2) {
            break label848;
          }
          i = 1;
          break label848;
        }
      }
    }
    for (;;)
    {
      localObject4 = new BluetoothGattDescriptor(UUID.fromString((String)localObject4), m);
      localObject5 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.at(Base64.decode((String)localObject3, 2));
      ac.i("MicroMsg.BLE.JsApiAddBlePeripheralService", "parseData descriptor: base64 = " + (String)localObject3 + ", hex = " + localObject5);
      ((BluetoothGattDescriptor)localObject4).setValue((byte[])localObject5);
      ((BluetoothGattCharacteristic)localObject2).addDescriptor((BluetoothGattDescriptor)localObject4);
      j += 1;
      break label520;
      ((Collection)localObject1).add(localObject2);
      k += 1;
      break label204;
      paramJSONObject = ((Iterable)localObject1).iterator();
      while (paramJSONObject.hasNext())
      {
        localObject1 = (BluetoothGattCharacteristic)paramJSONObject.next();
        localObject2 = (BluetoothGattService)localf.KUQ;
        if (localObject2 == null) {
          k.fOy();
        }
        ((BluetoothGattService)localObject2).addCharacteristic((BluetoothGattCharacteristic)localObject1);
      }
      break;
      label757:
      do
      {
        m = i;
        break;
        i = j;
        if (bool2) {
          i = j | 0x2;
        }
        j = i;
        if (bool3) {
          j = i | 0x10;
        }
        i = j;
        if (bool4) {
          i = j | 0x20;
        }
      } while (!bool5);
      m = i | 0x4;
      break label296;
      label805:
      i = j;
      if (bool2) {
        i = j | 0x10;
      }
      j = i;
      if (bool4) {
        j = i | 0x20 | 0x40;
      }
      i = j;
      if (!bool3) {
        break label357;
      }
      i = j | 0x2 | 0x4;
      break label357;
      label848:
      m = i;
      if (bool1) {
        m = i | 0x10;
      }
    }
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144749);
    k.h(paramc, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfV())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this, paramInt, paramc, 10001, "fail:not available");
      ac.i("MicroMsg.BLE.JsApiAddBlePeripheralService", "invoke: Ble is not open");
      AppMethodBeat.o(144749);
      return;
    }
    Object localObject1 = I(paramJSONObject);
    if (localObject1 == null)
    {
      ac.e("MicroMsg.BLE.JsApiAddBlePeripheralService", "createBLEPeripheralService data is invalid");
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this, paramInt, paramc, 10013, "fail:invalid data");
      AppMethodBeat.o(144749);
      return;
    }
    if (paramJSONObject == null) {
      k.fOy();
    }
    int i = paramJSONObject.optInt("serverId");
    paramJSONObject = o.kjh;
    paramJSONObject = o.sp(i);
    if (paramJSONObject == null)
    {
      ac.i("MicroMsg.BLE.JsApiAddBlePeripheralService", "invoke: retrieve a null server by #".concat(String.valueOf(i)));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this, paramInt, paramc, 10020, "fail: no server");
      AppMethodBeat.o(144749);
      return;
    }
    paramc = (d.g.a.b)new b(this, paramInt, paramc);
    k.h(localObject1, "service");
    k.h(paramc, "callback");
    Object localObject2 = paramJSONObject.kiX;
    if (localObject2 == null) {
      k.aVY("gattServer");
    }
    if (!((BluetoothGattServer)localObject2).addService((BluetoothGattService)localObject1)) {
      paramc.ay(Boolean.FALSE);
    }
    paramJSONObject = paramJSONObject.kiY;
    localObject1 = ((BluetoothGattService)localObject1).getUuid();
    k.g(localObject1, "service.uuid");
    localObject2 = d.c.b.aVX(null);
    ((Timer)localObject2).schedule((TimerTask)new n.b(paramc), 3000L, 9223372036854775807L);
    paramJSONObject.put(localObject1, new d.o(paramc, localObject2));
    AppMethodBeat.o(144749);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiAddBlePeripheralService$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "success", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    b(c paramc, int paramInt, com.tencent.mm.plugin.appbrand.jsapi.c paramc1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.c
 * JD-Core Version:    0.7.0.1
 */