package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public static String kDe = "notification";
  public static String kDf = "indication";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144505);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(71);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "JsApiNotifyBLECharacteristicValueChanged data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.h(paramInt, m("fail:invalid data", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(73, 74);
      AppMethodBeat.o(144505);
      return;
    }
    final String str2 = paramc.getAppId();
    ad.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged data %s", new Object[] { str2, paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.Pt(paramc.getAppId());
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, m("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(73, 76);
      AppMethodBeat.o(144505);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjz())
    {
      ad.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, m("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(73, 79);
      AppMethodBeat.o(144505);
      return;
    }
    String str1 = paramJSONObject.optString("deviceId");
    String str3 = paramJSONObject.optString("serviceId");
    String str4 = paramJSONObject.optString("characteristicId");
    boolean bool3 = paramJSONObject.optBoolean("state");
    String str5 = paramJSONObject.optString("type", kDf);
    boolean bool4 = paramJSONObject.optBoolean("debug", false);
    boolean bool5 = paramJSONObject.optBoolean("mainThread", false);
    boolean bool6 = paramJSONObject.optBoolean("serial", true);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d locald;
    if (localb.kCW != null)
    {
      paramJSONObject = localb.kCW;
      if (paramJSONObject.kEA == null) {
        break label685;
      }
      locald = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)paramJSONObject.kEA.kEI.get(str1);
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
        ad.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleCharacteristic is null, may not connect");
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(10005));
        paramc.h(paramInt, m("fail:no characteristic", paramJSONObject));
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(73);
        AppMethodBeat.o(144505);
        return;
        label425:
        paramJSONObject = locald.kEN;
        if (paramJSONObject == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.crd, "[getCharacteristic] bluetoothGatt is null, err", new Object[0]);
          break;
        }
        if ((bt.isNullOrNil(str3)) || (bt.isNullOrNil(str4)))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.crd, "[getCharacteristic] serviceId is null, err", new Object[0]);
          break;
        }
        if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.Py(str3))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.crd, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
          break;
        }
        if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.Py(str4))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.crd, "[getCharacteristics] characteristicId is illegal, err", new Object[0]);
          break;
        }
        paramJSONObject = paramJSONObject.getService(UUID.fromString(str3));
        if (paramJSONObject == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(locald.crd, "[getCharacteristic] bluetoothGattServices is null, err", new Object[0]);
          break;
        }
        BluetoothGattCharacteristic localBluetoothGattCharacteristic = paramJSONObject.getCharacteristic(UUID.fromString(str4));
        if (localBluetoothGattCharacteristic == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(locald.crd, "[getCharacteristic] characteristics is null, err", new Object[0]);
          break;
        }
        paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c();
        paramJSONObject.uuid = localBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
        int i = localBluetoothGattCharacteristic.getProperties();
        paramJSONObject.kFr = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sV(i);
        paramJSONObject.kFs = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sW(i);
        paramJSONObject.kFt = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sX(i);
        paramJSONObject.hFJ = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sY(i);
        paramJSONObject.kFu = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.sZ(i);
        if (locald.kEN == null) {
          break;
        }
      }
      label685:
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleManager", "getCharacteristic, bleConnectMgr is null", new Object[0]);
    }
    label701:
    boolean bool1;
    if (((paramJSONObject.hFJ) && (!paramJSONObject.kFu)) || ((paramJSONObject.hFJ) && (paramJSONObject.kFu) && (str5.toLowerCase().equals(kDe))))
    {
      bool1 = true;
      if (((paramJSONObject.hFJ) || (!paramJSONObject.kFu)) && ((!paramJSONObject.hFJ) || (!paramJSONObject.kFu) || (!str5.toLowerCase().equals(kDf)))) {
        break label891;
      }
    }
    label891:
    for (boolean bool2 = true;; bool2 = false)
    {
      ad.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged isNotify:%b isIndicate:%b", new Object[] { str2, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!bool1) {
        break label897;
      }
      paramJSONObject = new e(str3, str4, bool3);
      paramJSONObject.aXD = bool4;
      paramJSONObject.kEr = bool5;
      paramJSONObject.kEt = bool6;
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
            paramc.h(paramInt, k.this.m(paramAnonymousj.errMsg, localHashMap));
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(43);
            AppMethodBeat.o(144503);
            return;
          }
          paramAnonymousj = new HashMap();
          paramAnonymousj.put("errCode", Integer.valueOf(0));
          paramc.h(paramInt, k.this.m("ok", paramAnonymousj));
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(42);
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
      paramJSONObject.kEr = bool5;
      paramJSONObject.kEt = bool6;
      localb.a(str1, paramJSONObject, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
      {
        public final void a(j paramAnonymousj)
        {
          AppMethodBeat.i(144504);
          ad.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged result:%s", new Object[] { str2, paramAnonymousj });
          switch (paramAnonymousj.errCode)
          {
          default: 
            new HashMap().put("errCode", Integer.valueOf(paramAnonymousj.errCode));
            paramc.h(paramInt, k.this.e(paramAnonymousj.errMsg, null));
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(43);
            AppMethodBeat.o(144504);
            return;
          }
          new HashMap().put("errCode", Integer.valueOf(0));
          paramc.h(paramInt, k.this.e("ok", null));
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(42);
          AppMethodBeat.o(144504);
        }
      });
      AppMethodBeat.o(144505);
      return;
    }
    ad.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify and not support indicate...");
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(10007));
    paramc.h(paramInt, m("fail:internal error", paramJSONObject));
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(73, 82);
    AppMethodBeat.o(144505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.k
 * JD-Core Version:    0.7.0.1
 */