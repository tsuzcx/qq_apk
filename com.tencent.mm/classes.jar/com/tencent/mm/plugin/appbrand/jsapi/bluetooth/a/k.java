package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

@TargetApi(18)
public final class k
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  private static final int CTRL_INDEX = 186;
  private static final String NAME = "notifyBLECharacteristicValueChanged";
  public static String lKU = "notification";
  public static String lKV = "indication";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144505);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(71);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "JsApiNotifyBLECharacteristicValueChanged data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramf.i(paramInt, n("fail:invalid data", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(73, 74);
      AppMethodBeat.o(144505);
      return;
    }
    final String str2 = paramf.getAppId();
    Log.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged data %s", new Object[] { str2, paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.ZC(paramf.getAppId());
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.i(paramInt, n("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(73, 76);
      AppMethodBeat.o(144505);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE())
    {
      Log.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.i(paramInt, n("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(73, 79);
      AppMethodBeat.o(144505);
      return;
    }
    String str1 = paramJSONObject.optString("deviceId");
    String str3 = paramJSONObject.optString("serviceId");
    String str4 = paramJSONObject.optString("characteristicId");
    boolean bool3 = paramJSONObject.optBoolean("state");
    String str5 = paramJSONObject.optString("type", lKV);
    boolean bool4 = paramJSONObject.optBoolean("debug", false);
    boolean bool5 = paramJSONObject.optBoolean("mainThread", false);
    boolean bool6 = paramJSONObject.optBoolean("serial", true);
    paramJSONObject = localb.bFg();
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.lMr;
      if (paramJSONObject.lMA == null) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristic, connectWorkers is null", new Object[0]);
      }
    }
    else
    {
      paramJSONObject = null;
    }
    for (;;)
    {
      if (paramJSONObject != null) {
        break label697;
      }
      Log.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleCharacteristic is null, may not connect");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10005));
      paramf.i(paramInt, n("fail:no characteristic", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(73);
      AppMethodBeat.o(144505);
      return;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d locald = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)paramJSONObject.lMA.get(str1);
      if (locald == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristic, connectWorker is null", new Object[0]);
        break;
      }
      paramJSONObject = locald.lMG;
      if (paramJSONObject == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.cDW, "[getCharacteristic] bluetoothGatt is null, err", new Object[0]);
        break;
      }
      if ((Util.isNullOrNil(str3)) || (Util.isNullOrNil(str4)))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.cDW, "[getCharacteristic] serviceId is null, err", new Object[0]);
        break;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.ZH(str3))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.cDW, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
        break;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.ZH(str4))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.cDW, "[getCharacteristics] characteristicId is illegal, err", new Object[0]);
        break;
      }
      paramJSONObject = paramJSONObject.getService(UUID.fromString(str3));
      if (paramJSONObject == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(locald.cDW, "[getCharacteristic] bluetoothGattServices is null, err", new Object[0]);
        break;
      }
      BluetoothGattCharacteristic localBluetoothGattCharacteristic = paramJSONObject.getCharacteristic(UUID.fromString(str4));
      if (localBluetoothGattCharacteristic == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(locald.cDW, "[getCharacteristic] characteristics is null, err", new Object[0]);
        break;
      }
      paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c();
      paramJSONObject.uuid = localBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
      int i = localBluetoothGattCharacteristic.getProperties();
      paramJSONObject.lNl = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.wU(i);
      paramJSONObject.lNm = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.wV(i);
      paramJSONObject.lNn = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.wW(i);
      paramJSONObject.iDl = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.wX(i);
      paramJSONObject.lNo = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.wY(i);
      if (locald.lMG == null) {
        break;
      }
    }
    label697:
    boolean bool1;
    if (((paramJSONObject.iDl) && (!paramJSONObject.lNo)) || ((paramJSONObject.iDl) && (paramJSONObject.lNo) && (str5.toLowerCase().equals(lKU))))
    {
      bool1 = true;
      if (((paramJSONObject.iDl) || (!paramJSONObject.lNo)) && ((!paramJSONObject.iDl) || (!paramJSONObject.lNo) || (!str5.toLowerCase().equals(lKV)))) {
        break label887;
      }
    }
    label887:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged isNotify:%b isIndicate:%b", new Object[] { str2, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!bool1) {
        break label893;
      }
      paramJSONObject = new e(str3, str4, bool3);
      paramJSONObject.aXs = bool4;
      paramJSONObject.lMh = bool5;
      paramJSONObject.lMj = bool6;
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
            paramf.i(paramInt, k.this.n(paramAnonymousj.errMsg, localHashMap));
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(43);
            AppMethodBeat.o(144503);
            return;
          }
          paramAnonymousj = new HashMap();
          paramAnonymousj.put("errCode", Integer.valueOf(0));
          paramf.i(paramInt, k.this.n("ok", paramAnonymousj));
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(42);
          AppMethodBeat.o(144503);
        }
      });
      AppMethodBeat.o(144505);
      return;
      bool1 = false;
      break;
    }
    label893:
    if (bool2)
    {
      paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.d(str3, str4, bool3);
      paramJSONObject.aXs = bool4;
      paramJSONObject.lMh = bool5;
      paramJSONObject.lMj = bool6;
      localb.a(str1, paramJSONObject, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
      {
        public final void a(j paramAnonymousj)
        {
          AppMethodBeat.i(144504);
          Log.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged result:%s", new Object[] { str2, paramAnonymousj });
          switch (paramAnonymousj.errCode)
          {
          default: 
            new HashMap().put("errCode", Integer.valueOf(paramAnonymousj.errCode));
            paramf.i(paramInt, k.this.h(paramAnonymousj.errMsg, null));
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(43);
            AppMethodBeat.o(144504);
            return;
          }
          new HashMap().put("errCode", Integer.valueOf(0));
          paramf.i(paramInt, k.this.h("ok", null));
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(42);
          AppMethodBeat.o(144504);
        }
      });
      AppMethodBeat.o(144505);
      return;
    }
    Log.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify and not support indicate...");
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(10007));
    paramf.i(paramInt, n("fail:internal error", paramJSONObject));
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(73, 82);
    AppMethodBeat.o(144505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.k
 * JD-Core Version:    0.7.0.1
 */