package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

@TargetApi(18)
public final class k
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 186;
  private static final String NAME = "notifyBLECharacteristicValueChanged";
  public static String oHk = "notification";
  public static String oHl = "indication";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144505);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rE(71);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "JsApiNotifyBLECharacteristicValueChanged data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      parame.j(paramInt, m("fail:invalid data", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(73, 74);
      AppMethodBeat.o(144505);
      return;
    }
    String str2 = parame.getAppId();
    Log.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged data %s", new Object[] { str2, paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.ahq(parame.getAppId());
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      parame.j(paramInt, m("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(73, 76);
      AppMethodBeat.o(144505);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRm())
    {
      Log.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      parame.j(paramInt, m("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(73, 79);
      AppMethodBeat.o(144505);
      return;
    }
    String str1 = paramJSONObject.optString("deviceId");
    String str3 = paramJSONObject.optString("serviceId");
    String str4 = paramJSONObject.optString("characteristicId");
    boolean bool3 = paramJSONObject.optBoolean("state");
    String str5 = paramJSONObject.optString("type", oHl);
    boolean bool4 = paramJSONObject.optBoolean("debug", false);
    boolean bool5 = paramJSONObject.optBoolean("mainThread", false);
    boolean bool6 = paramJSONObject.optBoolean("serial", true);
    paramJSONObject = localb.bQK();
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.oIH;
      if (paramJSONObject.oIQ == null) {
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
      parame.j(paramInt, m("fail:no characteristic", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rE(73);
      AppMethodBeat.o(144505);
      return;
      d locald = (d)paramJSONObject.oIQ.get(str1);
      if (locald == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristic, connectWorker is null", new Object[0]);
        break;
      }
      paramJSONObject = locald.oIW;
      if (paramJSONObject == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.cED, "[getCharacteristic] bluetoothGatt is null, err", new Object[0]);
        break;
      }
      if ((Util.isNullOrNil(str3)) || (Util.isNullOrNil(str4)))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.cED, "[getCharacteristic] serviceId is null, err", new Object[0]);
        break;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.ahv(str3))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.cED, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
        break;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.ahv(str4))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(locald.cED, "[getCharacteristics] characteristicId is illegal, err", new Object[0]);
        break;
      }
      paramJSONObject = paramJSONObject.getService(UUID.fromString(str3));
      if (paramJSONObject == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(locald.cED, "[getCharacteristic] bluetoothGattServices is null, err", new Object[0]);
        break;
      }
      BluetoothGattCharacteristic localBluetoothGattCharacteristic = paramJSONObject.getCharacteristic(UUID.fromString(str4));
      if (localBluetoothGattCharacteristic == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(locald.cED, "[getCharacteristic] characteristics is null, err", new Object[0]);
        break;
      }
      paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c();
      paramJSONObject.uuid = localBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
      int i = localBluetoothGattCharacteristic.getProperties();
      paramJSONObject.oJz = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.Ak(i);
      paramJSONObject.oJA = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.Al(i);
      paramJSONObject.oJB = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.Am(i);
      paramJSONObject.ltl = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.An(i);
      paramJSONObject.oJC = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.Ao(i);
      if (locald.oIW == null) {
        break;
      }
    }
    label697:
    boolean bool1;
    if (((paramJSONObject.ltl) && (!paramJSONObject.oJC)) || ((paramJSONObject.ltl) && (paramJSONObject.oJC) && (str5.toLowerCase().equals(oHk))))
    {
      bool1 = true;
      if (((paramJSONObject.ltl) || (!paramJSONObject.oJC)) && ((!paramJSONObject.ltl) || (!paramJSONObject.oJC) || (!str5.toLowerCase().equals(oHl)))) {
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
      paramJSONObject = new f(str3, str4, bool3);
      paramJSONObject.aGM = bool4;
      paramJSONObject.oIw = bool5;
      paramJSONObject.oIy = bool6;
      localb.a(str1, paramJSONObject, new k.1(this, parame, paramInt));
      AppMethodBeat.o(144505);
      return;
      bool1 = false;
      break;
    }
    label893:
    if (bool2)
    {
      paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.e(str3, str4, bool3);
      paramJSONObject.aGM = bool4;
      paramJSONObject.oIw = bool5;
      paramJSONObject.oIy = bool6;
      localb.a(str1, paramJSONObject, new k.2(this, str2, parame, paramInt));
      AppMethodBeat.o(144505);
      return;
    }
    Log.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify and not support indicate...");
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(10007));
    parame.j(paramInt, m("fail:internal error", paramJSONObject));
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(73, 82);
    AppMethodBeat.o(144505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.k
 * JD-Core Version:    0.7.0.1
 */