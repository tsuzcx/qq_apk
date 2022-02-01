package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiAddBlePeripheralService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "parseData", "Landroid/bluetooth/BluetoothGattService;", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final c.a rLn;
  
  static
  {
    AppMethodBeat.i(144751);
    rLn = new c.a((byte)0);
    NAME = "addBLEPeripheralService";
    CTRL_INDEX = 723;
    AppMethodBeat.o(144751);
  }
  
  private static BluetoothGattService ae(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(144750);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(144750);
      return null;
    }
    try
    {
      localObject1 = paramJSONObject.optJSONObject("service");
      paramJSONObject = new BluetoothGattService(a.aas(((JSONObject)localObject1).optString("uuid")), 0);
      localObject2 = ((JSONObject)localObject1).optJSONArray("characteristics");
      if (localObject2 != null) {
        break label89;
      }
      AppMethodBeat.o(144750);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.BLE.JsApiAddBlePeripheralService", "parseData: fail", new Object[] { paramJSONObject });
      paramJSONObject = null;
    }
    AppMethodBeat.o(144750);
    return paramJSONObject;
    label89:
    int j = ((JSONArray)localObject2).length();
    Object localObject1 = new JSONObject[j];
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject3 = ((JSONArray)localObject2).get(i);
      if (localObject3 == null)
      {
        paramJSONObject = new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        AppMethodBeat.o(144750);
        throw paramJSONObject;
      }
      localObject1[i] = ((JSONObject)localObject3);
      i += 1;
    }
    Object localObject2 = (Collection)new ArrayList(j);
    int n = localObject1.length;
    int k = 0;
    label174:
    Object localObject4;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    label267:
    label328:
    int m;
    Object localObject5;
    label491:
    Object localObject6;
    if (k < n)
    {
      JSONObject[] arrayOfJSONObject = localObject1[k];
      localObject3 = arrayOfJSONObject.optString("uuid");
      localObject4 = arrayOfJSONObject.optJSONObject("properties");
      bool1 = ((JSONObject)localObject4).optBoolean("write", false);
      bool2 = ((JSONObject)localObject4).optBoolean("read", false);
      bool3 = ((JSONObject)localObject4).optBoolean("notify", false);
      bool4 = ((JSONObject)localObject4).optBoolean("indicate", false);
      bool5 = ((JSONObject)localObject4).optBoolean("writeNoResponse", false);
      j = 0;
      if (!bool1) {
        break label711;
      }
      j = 8;
      break label711;
      localObject4 = arrayOfJSONObject.optJSONObject("permission");
      bool1 = ((JSONObject)localObject4).optBoolean("readable", false);
      bool2 = ((JSONObject)localObject4).optBoolean("writeable", false);
      bool3 = ((JSONObject)localObject4).optBoolean("readEncryptionRequired", false);
      bool4 = ((JSONObject)localObject4).optBoolean("writeEncryptionRequired", false);
      j = 0;
      if (!bool1) {
        break label759;
      }
      j = 1;
      break label759;
      localObject3 = new BluetoothGattCharacteristic(a.aas((String)localObject3), m, i);
      localObject4 = arrayOfJSONObject.optString("value");
      localObject5 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aW(Base64.decode((String)localObject4, 2));
      Log.i("MicroMsg.BLE.JsApiAddBlePeripheralService", "parseData characteristic : base64 = " + localObject4 + ", hex = " + localObject5);
      ((BluetoothGattCharacteristic)localObject3).setValue((byte[])localObject5);
      localObject4 = arrayOfJSONObject.optJSONArray("descriptors");
      if (localObject4 != null)
      {
        j = ((JSONArray)localObject4).length();
        arrayOfJSONObject = new JSONObject[j];
        i = 0;
        while (i < j)
        {
          localObject5 = ((JSONArray)localObject4).get(i);
          if (localObject5 == null)
          {
            paramJSONObject = new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            AppMethodBeat.o(144750);
            throw paramJSONObject;
          }
          arrayOfJSONObject[i] = ((JSONObject)localObject5);
          i += 1;
        }
        int i1 = arrayOfJSONObject.length;
        j = 0;
        if (j < i1)
        {
          localObject4 = arrayOfJSONObject[j];
          localObject5 = ((JSONObject)localObject4).optString("uuid");
          localObject6 = ((JSONObject)localObject4).optJSONObject("permission");
          localObject4 = ((JSONObject)localObject4).optString("value");
          bool1 = ((JSONObject)localObject6).optBoolean("write");
          bool2 = ((JSONObject)localObject6).optBoolean("read");
          i = 0;
          if (!bool2) {
            break label802;
          }
          i = 1;
          break label802;
        }
      }
    }
    for (;;)
    {
      localObject5 = new BluetoothGattDescriptor(a.aas((String)localObject5), m);
      localObject6 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aW(Base64.decode((String)localObject4, 2));
      Log.i("MicroMsg.BLE.JsApiAddBlePeripheralService", "parseData descriptor: base64 = " + localObject4 + ", hex = " + localObject6);
      ((BluetoothGattDescriptor)localObject5).setValue((byte[])localObject6);
      ((BluetoothGattCharacteristic)localObject3).addDescriptor((BluetoothGattDescriptor)localObject5);
      j += 1;
      break label491;
      ((Collection)localObject2).add(localObject3);
      k += 1;
      break label174;
      localObject1 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramJSONObject.addCharacteristic((BluetoothGattCharacteristic)((Iterator)localObject1).next());
      }
      break;
      label711:
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
      break label267;
      label759:
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
        break label328;
      }
      i = j | 0x2 | 0x4;
      break label328;
      label802:
      m = i;
      if (bool1) {
        m = i | 0x10;
      }
    }
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144749);
    s.u(paramf, "env");
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10001, "fail:not available");
      Log.i("MicroMsg.BLE.JsApiAddBlePeripheralService", "invoke: Ble is not open");
      AppMethodBeat.o(144749);
      return;
    }
    Object localObject = ae(paramJSONObject);
    if (localObject == null)
    {
      Log.e("MicroMsg.BLE.JsApiAddBlePeripheralService", "createBLEPeripheralService data is invalid");
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10013, "fail:invalid data");
      AppMethodBeat.o(144749);
      return;
    }
    s.checkNotNull(paramJSONObject);
    int i = paramJSONObject.optInt("serverId");
    paramJSONObject = o.rLP;
    paramJSONObject = o.Aw(i);
    if (paramJSONObject == null)
    {
      Log.i("MicroMsg.BLE.JsApiAddBlePeripheralService", s.X("invoke: retrieve a null server by #", Integer.valueOf(i)));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a((com.tencent.mm.plugin.appbrand.jsapi.c)this, paramInt, paramf, 10020, "fail: no server");
      AppMethodBeat.o(144749);
      return;
    }
    paramf = (kotlin.g.a.b)new b(this, paramInt, paramf);
    s.u(localObject, "service");
    s.u(paramf, "callback");
    if (!paramJSONObject.cqU().addService((BluetoothGattService)localObject)) {
      paramf.invoke(Boolean.FALSE);
    }
    paramJSONObject = paramJSONObject.rLM;
    localObject = ((BluetoothGattService)localObject).getUuid();
    s.s(localObject, "service.uuid");
    Timer localTimer = kotlin.c.b.bIw(null);
    localTimer.schedule((TimerTask)new n.b(paramf), 3000L, 9223372036854775807L);
    paramJSONObject.put(localObject, new r(paramf, localTimer));
    AppMethodBeat.o(144749);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(c paramc, int paramInt, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.c
 * JD-Core Version:    0.7.0.1
 */