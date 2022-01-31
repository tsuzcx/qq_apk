package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  public static String hFA = "notification";
  public static String hFB = "indication";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(94193);
    c.kS(71);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "JsApiNotifyBLECharacteristicValueChanged data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.h(paramInt, j("fail:invalid data", paramJSONObject));
      c.df(73, 74);
      AppMethodBeat.o(94193);
      return;
    }
    String str2 = paramc.getAppId();
    ab.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged data %s", new Object[] { str2, paramJSONObject.toString() });
    b localb = a.BU(paramc.getAppId());
    if (localb == null)
    {
      ab.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, j("fail:not init", paramJSONObject));
      c.df(73, 76);
      AppMethodBeat.o(94193);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCw())
    {
      ab.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, j("fail:not available", paramJSONObject));
      c.df(73, 79);
      AppMethodBeat.o(94193);
      return;
    }
    String str1 = paramJSONObject.optString("deviceId");
    String str3 = paramJSONObject.optString("serviceId");
    String str4 = paramJSONObject.optString("characteristicId");
    boolean bool3 = paramJSONObject.optBoolean("state");
    String str5 = paramJSONObject.optString("type", hFB);
    boolean bool4 = paramJSONObject.optBoolean("debug", false);
    boolean bool5 = paramJSONObject.optBoolean("mainThread", false);
    boolean bool6 = paramJSONObject.optBoolean("serial", true);
    if (localb.hFw != null)
    {
      paramJSONObject = localb.hFw;
      if (paramJSONObject.hGa != null)
      {
        paramJSONObject = paramJSONObject.hGa;
        if (paramJSONObject.hGi.get(str1) != null)
        {
          paramJSONObject = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)paramJSONObject.hGi.get(str1);
          if (paramJSONObject.hGn != null) {
            break label442;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] bluetoothGatt is null, err", new Object[0]);
        }
      }
      paramJSONObject = null;
    }
    for (;;)
    {
      if (paramJSONObject != null) {
        break label660;
      }
      ab.e("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleCharacteristic is null, may not connect");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10005));
      paramc.h(paramInt, j("fail:no characteristic", paramJSONObject));
      c.kS(73);
      AppMethodBeat.o(94193);
      return;
      label442:
      if ((bo.isNullOrNil(str3)) || (bo.isNullOrNil(str4)))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] serviceId is null, err", new Object[0]);
        break;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.BY(str3))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] serviceId is illegal, err", new Object[0]);
        break;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.BY(str4))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] characteristicId is illegal, err", new Object[0]);
        break;
      }
      paramJSONObject = paramJSONObject.hGn.getService(UUID.fromString(str3));
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
      paramJSONObject.eAx = localBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
      int i = localBluetoothGattCharacteristic.getProperties();
      paramJSONObject.hGE = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.nW(i);
      paramJSONObject.hGF = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.nX(i);
      paramJSONObject.hGG = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.nY(i);
      paramJSONObject.flD = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.nZ(i);
      paramJSONObject.hGH = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.oa(i);
      continue;
      paramJSONObject = null;
    }
    label660:
    boolean bool1;
    if (((paramJSONObject.flD) && (!paramJSONObject.hGH)) || ((paramJSONObject.flD) && (paramJSONObject.hGH) && (str5.toLowerCase().equals(hFA))))
    {
      bool1 = true;
      if (((paramJSONObject.flD) || (!paramJSONObject.hGH)) && ((!paramJSONObject.flD) || (!paramJSONObject.hGH) || (!str5.toLowerCase().equals(hFB)))) {
        break label850;
      }
    }
    label850:
    for (boolean bool2 = true;; bool2 = false)
    {
      ab.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged isNotify:%b isIndicate:%b", new Object[] { str2, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!bool1) {
        break label856;
      }
      paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.d(str3, str4, bool3);
      paramJSONObject.arI = bool4;
      paramJSONObject.hFR = bool5;
      paramJSONObject.hFT = bool6;
      localb.a(str1, paramJSONObject, new l.1(this, paramc, paramInt));
      AppMethodBeat.o(94193);
      return;
      bool1 = false;
      break;
    }
    label856:
    if (bool2)
    {
      paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.c(str3, str4, bool3);
      paramJSONObject.arI = bool4;
      paramJSONObject.hFR = bool5;
      paramJSONObject.hFT = bool6;
      localb.a(str1, paramJSONObject, new l.2(this, str2, paramc, paramInt));
      AppMethodBeat.o(94193);
      return;
    }
    ab.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify and not support indicate...");
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(10007));
    paramc.h(paramInt, j("fail:internal error", paramJSONObject));
    c.df(73, 82);
    AppMethodBeat.o(94193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.l
 * JD-Core Version:    0.7.0.1
 */