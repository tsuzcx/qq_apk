package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

@TargetApi(18)
public final class k
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 186;
  private static final String NAME = "notifyBLECharacteristicValueChanged";
  public static String kGt = "notification";
  public static String kGu = "indication";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144505);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.md(71);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "JsApiNotifyBLECharacteristicValueChanged data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.h(paramInt, n("fail:invalid data", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(73, 74);
      AppMethodBeat.o(144505);
      return;
    }
    final String str2 = paramc.getAppId();
    ae.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged data %s", new Object[] { str2, paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.Qb(paramc.getAppId());
    if (localb == null)
    {
      ae.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, n("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(73, 76);
      AppMethodBeat.o(144505);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bki())
    {
      ae.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, n("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(73, 79);
      AppMethodBeat.o(144505);
      return;
    }
    String str1 = paramJSONObject.optString("deviceId");
    String str3 = paramJSONObject.optString("serviceId");
    String str4 = paramJSONObject.optString("characteristicId");
    boolean bool3 = paramJSONObject.optBoolean("state");
    String str5 = paramJSONObject.optString("type", kGu);
    boolean bool4 = paramJSONObject.optBoolean("debug", false);
    boolean bool5 = paramJSONObject.optBoolean("mainThread", false);
    boolean bool6 = paramJSONObject.optBoolean("serial", true);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d locald;
    if (localb.kGl != null)
    {
      paramJSONObject = localb.kGl;
      if (paramJSONObject.kHP == null) {
        break label685;
      }
      locald = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)paramJSONObject.kHP.kHX.get(str1);
      if (locald != null) {
        break label425;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristic, connectWorker is null", new Object[0]);
    }
    for (;;)
    {
      paramJSONObject = null;
      for (;;)
      {
        if (paramJSONObject != null) {
          break label701;
        }
        ae.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleCharacteristic is null, may not connect");
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(10005));
        paramc.h(paramInt, n("fail:no characteristic", paramJSONObject));
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.md(73);
        AppMethodBeat.o(144505);
        return;
        label425:
        paramJSONObject = locald.kIc;
        if (paramJSONObject == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.crG, "[getCharacteristic] bluetoothGatt is null, err", new Object[0]);
          break;
        }
        if ((bu.isNullOrNil(str3)) || (bu.isNullOrNil(str4)))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.crG, "[getCharacteristic] serviceId is null, err", new Object[0]);
          break;
        }
        if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.Qg(str3))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.crG, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
          break;
        }
        if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.Qg(str4))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.crG, "[getCharacteristics] characteristicId is illegal, err", new Object[0]);
          break;
        }
        paramJSONObject = paramJSONObject.getService(UUID.fromString(str3));
        if (paramJSONObject == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(locald.crG, "[getCharacteristic] bluetoothGattServices is null, err", new Object[0]);
          break;
        }
        BluetoothGattCharacteristic localBluetoothGattCharacteristic = paramJSONObject.getCharacteristic(UUID.fromString(str4));
        if (localBluetoothGattCharacteristic == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(locald.crG, "[getCharacteristic] characteristics is null, err", new Object[0]);
          break;
        }
        paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c();
        paramJSONObject.uuid = localBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
        int i = localBluetoothGattCharacteristic.getProperties();
        paramJSONObject.kIG = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sY(i);
        paramJSONObject.kIH = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sZ(i);
        paramJSONObject.kII = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.ta(i);
        paramJSONObject.hIB = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.tb(i);
        paramJSONObject.kIJ = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.tc(i);
        if (locald.kIc == null) {
          break;
        }
      }
      label685:
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleManager", "getCharacteristic, bleConnectMgr is null", new Object[0]);
    }
    label701:
    boolean bool1;
    if (((paramJSONObject.hIB) && (!paramJSONObject.kIJ)) || ((paramJSONObject.hIB) && (paramJSONObject.kIJ) && (str5.toLowerCase().equals(kGt))))
    {
      bool1 = true;
      if (((paramJSONObject.hIB) || (!paramJSONObject.kIJ)) && ((!paramJSONObject.hIB) || (!paramJSONObject.kIJ) || (!str5.toLowerCase().equals(kGu)))) {
        break label891;
      }
    }
    label891:
    for (boolean bool2 = true;; bool2 = false)
    {
      ae.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged isNotify:%b isIndicate:%b", new Object[] { str2, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!bool1) {
        break label897;
      }
      paramJSONObject = new e(str3, str4, bool3);
      paramJSONObject.aXD = bool4;
      paramJSONObject.kHG = bool5;
      paramJSONObject.kHI = bool6;
      localb.a(str1, paramJSONObject, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
      {
        public final void a(j paramAnonymousj)
        {
          AppMethodBeat.i(144503);
          switch (paramAnonymousj.errCode)
          {
          default: 
            HashMap localHashMap = new HashMap();
            localHashMap.put("errCode", Integer.valueOf(paramAnonymousj.errCode));
            paramc.h(paramInt, k.this.n(paramAnonymousj.errMsg, localHashMap));
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.md(43);
            AppMethodBeat.o(144503);
            return;
          }
          paramAnonymousj = new HashMap();
          paramAnonymousj.put("errCode", Integer.valueOf(0));
          paramc.h(paramInt, k.this.n("ok", paramAnonymousj));
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.md(42);
          AppMethodBeat.o(144503);
        }
      });
      AppMethodBeat.o(144505);
      return;
      bool1 = false;
      break;
    }
    label897:
    if (bool2)
    {
      paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.d(str3, str4, bool3);
      paramJSONObject.aXD = bool4;
      paramJSONObject.kHG = bool5;
      paramJSONObject.kHI = bool6;
      localb.a(str1, paramJSONObject, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
      {
        public final void a(j paramAnonymousj)
        {
          AppMethodBeat.i(144504);
          ae.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged result:%s", new Object[] { str2, paramAnonymousj });
          switch (paramAnonymousj.errCode)
          {
          default: 
            new HashMap().put("errCode", Integer.valueOf(paramAnonymousj.errCode));
            paramc.h(paramInt, k.this.e(paramAnonymousj.errMsg, null));
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.md(43);
            AppMethodBeat.o(144504);
            return;
          }
          new HashMap().put("errCode", Integer.valueOf(0));
          paramc.h(paramInt, k.this.e("ok", null));
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.md(42);
          AppMethodBeat.o(144504);
        }
      });
      AppMethodBeat.o(144505);
      return;
    }
    ae.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify and not support indicate...");
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(10007));
    paramc.h(paramInt, n("fail:internal error", paramJSONObject));
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(73, 82);
    AppMethodBeat.o(144505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.k
 * JD-Core Version:    0.7.0.1
 */