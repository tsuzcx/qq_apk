package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;
import d.o;
import d.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "", "()V", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "setComponent", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "gattServer", "Landroid/bluetooth/BluetoothGattServer;", "getGattServer", "()Landroid/bluetooth/BluetoothGattServer;", "setGattServer", "(Landroid/bluetooth/BluetoothGattServer;)V", "gattServerCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl;", "jsCallbacks", "", "Ljava/util/UUID;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsCallback;", "Ljava/util/Timer;", "getJsCallbacks", "()Ljava/util/Map;", "realAdvertiseCallback", "Landroid/bluetooth/le/AdvertiseCallback;", "serverId", "", "getServerId", "()I", "setServerId", "(I)V", "status", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "getStatus", "()Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "setStatus", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;)V", "userCallbackLock", "addService", "service", "Landroid/bluetooth/BluetoothGattService;", "callback", "checkBleIsWork", "handleCharacteristicWriteAction", "serviceId", "characteristicId", "needNotify", "callbackId", "base64Value", "", "onCreate", "onDestroy", "startBLEPeripheralAdvertising", "settings", "Landroid/bluetooth/le/AdvertiseSettings;", "advertiseData", "Landroid/bluetooth/le/AdvertiseData;", "scanResponse", "deviceName", "adapter", "Landroid/bluetooth/BluetoothAdapter;", "userCallback", "stopBLEPeripheralAdvertising", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class n
{
  public static final a kjc;
  int iYZ;
  public com.tencent.mm.plugin.appbrand.jsapi.c jOV;
  p kiW;
  public BluetoothGattServer kiX;
  final Map<UUID, o<d.g.a.b<Boolean, y>, Timer>> kiY;
  final AdvertiseCallback kiZ;
  AdvertiseCallback kja;
  private b kjb;
  
  static
  {
    AppMethodBeat.i(144781);
    kjc = new a((byte)0);
    AppMethodBeat.o(144781);
  }
  
  public n()
  {
    AppMethodBeat.i(144780);
    this.kiW = p.kji;
    this.iYZ = -1;
    this.kiY = ((Map)new HashMap());
    this.kiZ = ((AdvertiseCallback)new c(this));
    AppMethodBeat.o(144780);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.c CM()
  {
    AppMethodBeat.i(144776);
    com.tencent.mm.plugin.appbrand.jsapi.c localc = this.jOV;
    if (localc == null) {
      k.aVY("component");
    }
    AppMethodBeat.o(144776);
    return localc;
  }
  
  public final void a(BluetoothAdapter paramBluetoothAdapter)
  {
    AppMethodBeat.i(183549);
    k.h(paramBluetoothAdapter, "adapter");
    paramBluetoothAdapter = paramBluetoothAdapter.getBluetoothLeAdvertiser();
    if (paramBluetoothAdapter == null)
    {
      AppMethodBeat.o(183549);
      return;
    }
    paramBluetoothAdapter.stopAdvertising(this.kiZ);
    this.kja = null;
    AppMethodBeat.o(183549);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(144774);
    k.h(paramp, "<set-?>");
    this.kiW = paramp;
    AppMethodBeat.o(144774);
  }
  
  public final void a(UUID paramUUID1, UUID paramUUID2, boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(144779);
    k.h(paramUUID1, "serviceId");
    k.h(paramUUID2, "characteristicId");
    k.h(paramString, "base64Value");
    BluetoothGattServer localBluetoothGattServer = this.kiX;
    if (localBluetoothGattServer == null) {
      k.aVY("gattServer");
    }
    paramUUID1 = localBluetoothGattServer.getService(paramUUID1);
    if (paramUUID1 == null)
    {
      ac.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: server == null");
      AppMethodBeat.o(144779);
      return;
    }
    paramUUID1 = paramUUID1.getCharacteristic(paramUUID2);
    if (paramUUID1 == null)
    {
      ac.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: characteristic == null");
      AppMethodBeat.o(144779);
      return;
    }
    paramUUID1.setValue(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.at(Base64.decode(paramString, 2)));
    if (paramBoolean)
    {
      paramUUID2 = this.kjb;
      if (paramUUID2 == null) {
        k.fOy();
      }
      paramUUID2 = ((Iterable)paramUUID2.kiB).iterator();
      while (paramUUID2.hasNext())
      {
        paramString = (BluetoothDevice)paramUUID2.next();
        localBluetoothGattServer = this.kiX;
        if (localBluetoothGattServer == null) {
          k.aVY("gattServer");
        }
        ac.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(localBluetoothGattServer.notifyCharacteristicChanged(paramString, paramUUID1, false)) });
      }
    }
    paramUUID2 = this.kjb;
    if (paramUUID2 == null) {
      k.fOy();
    }
    paramUUID2 = ((Iterable)paramUUID2.kiB).iterator();
    while (paramUUID2.hasNext())
    {
      paramString = (BluetoothDevice)paramUUID2.next();
      localBluetoothGattServer = this.kiX;
      if (localBluetoothGattServer == null) {
        k.aVY("gattServer");
      }
      ac.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(localBluetoothGattServer.notifyCharacteristicChanged(paramString, paramUUID1, true)) });
    }
    paramUUID2 = this.kjb;
    if (paramUUID2 == null) {
      k.fOy();
    }
    paramUUID2 = (m)paramUUID2.kiC.get(Integer.valueOf(paramInt));
    if (paramUUID2 == null)
    {
      ac.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: #" + paramInt + " callbackId -> pendingResp is null");
      AppMethodBeat.o(144779);
      return;
    }
    ac.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: device = %s, requestId = %s", new Object[] { paramUUID2.kiV.toString(), String.valueOf(paramUUID2.requestId) });
    paramString = this.kiX;
    if (paramString == null) {
      k.aVY("gattServer");
    }
    if (!paramString.sendResponse(paramUUID2.kiV, paramUUID2.requestId, 0, paramUUID2.offset, paramUUID1.getValue())) {
      ac.e("MicroMsg.BLE.PeripheralBleServer", "sendPendingRespFail");
    }
    paramUUID1 = this.kjb;
    if (paramUUID1 == null) {
      k.fOy();
    }
    paramUUID1.kiC.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(144779);
  }
  
  public final BluetoothGattServer bfG()
  {
    AppMethodBeat.i(144775);
    BluetoothGattServer localBluetoothGattServer = this.kiX;
    if (localBluetoothGattServer == null) {
      k.aVY("gattServer");
    }
    AppMethodBeat.o(144775);
    return localBluetoothGattServer;
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    AppMethodBeat.i(144777);
    k.h(paramc, "component");
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfS();
    if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfU() & true & com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.bfQ() & com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfV())) && (localObject != null))
    {
      this.kiW = p.kjj;
      this.jOV = paramc;
      this.iYZ = paramInt;
      this.kjb = new b();
      paramc = ((BluetoothManager)localObject).openGattServer(ai.getContext(), (BluetoothGattServerCallback)this.kjb);
      k.g(paramc, "bluetoothManager.openGat…xt(), gattServerCallback)");
      this.kiX = paramc;
      paramc = this.kjb;
      if (paramc == null) {
        k.fOy();
      }
      localObject = (n)this;
      k.h(localObject, "<set-?>");
      paramc.kiD = ((n)localObject);
      AppMethodBeat.o(144777);
      return;
    }
    paramc = p.kjm;
    AppMethodBeat.o(144777);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(144778);
    this.kiY.clear();
    Object localObject = this.kiX;
    if (localObject == null) {
      k.aVY("gattServer");
    }
    ((BluetoothGattServer)localObject).close();
    localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfT();
    if (localObject != null)
    {
      k.g(localObject, "it");
      a((BluetoothAdapter)localObject);
    }
    localObject = this.kjb;
    if (localObject != null)
    {
      localObject = ((b)localObject).kiC;
      if (localObject != null) {
        ((Map)localObject).clear();
      }
    }
    this.kjb = null;
    this.kiW = p.kjl;
    AppMethodBeat.o(144778);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer$Companion;", "", "()V", "TAG", "", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"})
  public static final class b
    extends TimerTask
  {
    public b(d.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(144773);
      TimerTask localTimerTask = (TimerTask)this;
      this.hbs.ay(Boolean.FALSE);
      localTimerTask.cancel();
      AppMethodBeat.o(144773);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer$realAdvertiseCallback$1", "Landroid/bluetooth/le/AdvertiseCallback;", "onStartFailure", "", "errorCode", "", "onStartSuccess", "settingsInEffect", "Landroid/bluetooth/le/AdvertiseSettings;", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class c
    extends AdvertiseCallback
  {
    public final void onStartFailure(int paramInt)
    {
      AppMethodBeat.i(204992);
      super.onStartFailure(paramInt);
      AdvertiseCallback localAdvertiseCallback = n.a(this.kjd);
      if (localAdvertiseCallback == null) {
        k.fOy();
      }
      localAdvertiseCallback.onStartFailure(paramInt);
      n.b(this.kjd);
      AppMethodBeat.o(204992);
    }
    
    public final void onStartSuccess(AdvertiseSettings paramAdvertiseSettings)
    {
      AppMethodBeat.i(204991);
      super.onStartSuccess(paramAdvertiseSettings);
      if (n.a(this.kjd) != null)
      {
        AdvertiseCallback localAdvertiseCallback = n.a(this.kjd);
        if (localAdvertiseCallback == null) {
          k.fOy();
        }
        localAdvertiseCallback.onStartSuccess(paramAdvertiseSettings);
      }
      AppMethodBeat.o(204991);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n
 * JD-Core Version:    0.7.0.1
 */