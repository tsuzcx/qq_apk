package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

@TargetApi(18)
public final class l
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 186;
  private static final String NAME = "notifyBLECharacteristicValueChanged";
  public static String glB = "notification";
  public static String glC = "indication";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    c.jdMethod_if(71);
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "JsApiNotifyBLECharacteristicValueChanged data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.C(paramInt, h("fail:invalid data", paramJSONObject));
      c.bU(73, 74);
      return;
    }
    String str2 = paramc.getAppId();
    y.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged data %s", new Object[] { str2, paramJSONObject.toString() });
    b localb = a.tV(paramc.getAppId());
    if (localb == null)
    {
      y.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.C(paramInt, h("fail:not init", paramJSONObject));
      c.bU(73, 76);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiB())
    {
      y.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.C(paramInt, h("fail:not available", paramJSONObject));
      c.bU(73, 79);
      return;
    }
    String str1 = paramJSONObject.optString("deviceId");
    String str3 = paramJSONObject.optString("serviceId");
    String str4 = paramJSONObject.optString("characteristicId");
    boolean bool3 = paramJSONObject.optBoolean("state");
    String str5 = paramJSONObject.optString("type", glC);
    boolean bool4 = paramJSONObject.optBoolean("debug", false);
    boolean bool5 = paramJSONObject.optBoolean("mainThread", false);
    boolean bool6 = paramJSONObject.optBoolean("serial", true);
    if (localb.glx != null)
    {
      paramJSONObject = localb.glx;
      if (paramJSONObject.gmb != null)
      {
        paramJSONObject = paramJSONObject.gmb;
        if (paramJSONObject.gmk.get(str1) != null)
        {
          paramJSONObject = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)paramJSONObject.gmk.get(str1);
          if (paramJSONObject.gmp != null) {
            break label417;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] bluetoothGatt is null, err", new Object[0]);
        }
      }
      paramJSONObject = null;
    }
    for (;;)
    {
      if (paramJSONObject != null) {
        break label635;
      }
      y.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleCharacteristic is null, may not connect");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10005));
      paramc.C(paramInt, h("fail:no characteristic", paramJSONObject));
      c.jdMethod_if(73);
      return;
      label417:
      if ((bk.bl(str3)) || (bk.bl(str4)))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] serviceId is null, err", new Object[0]);
        break;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.tZ(str3))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] serviceId is illegal, err", new Object[0]);
        break;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.tZ(str4))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] characteristicId is illegal, err", new Object[0]);
        break;
      }
      paramJSONObject = paramJSONObject.gmp.getService(UUID.fromString(str3));
      if (paramJSONObject == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] bluetoothGattServices is null, err", new Object[0]);
        break;
      }
      BluetoothGattCharacteristic localBluetoothGattCharacteristic = paramJSONObject.getCharacteristic(UUID.fromString(str4));
      if (localBluetoothGattCharacteristic == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] characteristics is null, err", new Object[0]);
        break;
      }
      paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c();
      paramJSONObject.dCX = localBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
      int i = localBluetoothGattCharacteristic.getProperties();
      paramJSONObject.gmE = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.lm(i);
      paramJSONObject.gmF = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.ln(i);
      paramJSONObject.gmG = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.lo(i);
      paramJSONObject.dVu = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.lp(i);
      paramJSONObject.gmH = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.lq(i);
      continue;
      paramJSONObject = null;
    }
    label635:
    boolean bool1;
    if (((paramJSONObject.dVu) && (!paramJSONObject.gmH)) || ((paramJSONObject.dVu) && (paramJSONObject.gmH) && (str5.toLowerCase().equals(glB))))
    {
      bool1 = true;
      if (((paramJSONObject.dVu) || (!paramJSONObject.gmH)) && ((!paramJSONObject.dVu) || (!paramJSONObject.gmH) || (!str5.toLowerCase().equals(glC)))) {
        break label820;
      }
    }
    label820:
    for (boolean bool2 = true;; bool2 = false)
    {
      y.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged isNotify:%b isIndicate:%b", new Object[] { str2, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!bool1) {
        break label826;
      }
      paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.d(str3, str4, bool3);
      paramJSONObject.apo = bool4;
      paramJSONObject.glS = bool5;
      paramJSONObject.glU = bool6;
      localb.a(str1, paramJSONObject, new l.1(this, paramc, paramInt));
      return;
      bool1 = false;
      break;
    }
    label826:
    if (bool2)
    {
      paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.c(str3, str4, bool3);
      paramJSONObject.apo = bool4;
      paramJSONObject.glS = bool5;
      paramJSONObject.glU = bool6;
      localb.a(str1, paramJSONObject, new l.2(this, str2, paramc, paramInt));
      return;
    }
    y.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify and not support indicate...");
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(10007));
    paramc.C(paramInt, h("fail:internal error", paramJSONObject));
    c.bU(73, 82);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.l
 * JD-Core Version:    0.7.0.1
 */