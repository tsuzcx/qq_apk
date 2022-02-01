package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "", "()V", "advertiseCallback", "Landroid/bluetooth/le/AdvertiseCallback;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "setComponent", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "gattServer", "Landroid/bluetooth/BluetoothGattServer;", "getGattServer", "()Landroid/bluetooth/BluetoothGattServer;", "setGattServer", "(Landroid/bluetooth/BluetoothGattServer;)V", "gattServerCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl;", "jsCallbacks", "", "Ljava/util/UUID;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsCallback;", "Ljava/util/Timer;", "getJsCallbacks", "()Ljava/util/Map;", "serverId", "", "getServerId", "()I", "setServerId", "(I)V", "status", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "getStatus", "()Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "setStatus", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;)V", "addService", "service", "Landroid/bluetooth/BluetoothGattService;", "callback", "checkBleIsWork", "handleCharacteristicWriteAction", "serviceId", "characteristicId", "needNotify", "callbackId", "base64Value", "", "onCreate", "onDestroy", "startBLEPeripheralAdvertising", "settings", "Landroid/bluetooth/le/AdvertiseSettings;", "advertiseData", "Landroid/bluetooth/le/AdvertiseData;", "scanResponse", "deviceName", "adapter", "Landroid/bluetooth/BluetoothAdapter;", "stopBLEPeripheralAdvertising", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class n
{
  public static final a jIC;
  int iyW;
  AdvertiseCallback jIA;
  private b jIB;
  p jIx;
  public BluetoothGattServer jIy;
  final Map<UUID, o<d.g.a.b<Boolean, y>, Timer>> jIz;
  public com.tencent.mm.plugin.appbrand.jsapi.c joJ;
  
  static
  {
    AppMethodBeat.i(144781);
    jIC = new a((byte)0);
    AppMethodBeat.o(144781);
  }
  
  public n()
  {
    AppMethodBeat.i(144780);
    this.jIx = p.jIH;
    this.iyW = -1;
    this.jIz = ((Map)new HashMap());
    AppMethodBeat.o(144780);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.c Dj()
  {
    AppMethodBeat.i(144776);
    com.tencent.mm.plugin.appbrand.jsapi.c localc = this.joJ;
    if (localc == null) {
      k.aPZ("component");
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
    if (this.jIA != null)
    {
      paramBluetoothAdapter.stopAdvertising(this.jIA);
      this.jIA = null;
    }
    AppMethodBeat.o(183549);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(144774);
    k.h(paramp, "<set-?>");
    this.jIx = paramp;
    AppMethodBeat.o(144774);
  }
  
  public final void a(UUID paramUUID1, UUID paramUUID2, boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(144779);
    k.h(paramUUID1, "serviceId");
    k.h(paramUUID2, "characteristicId");
    k.h(paramString, "base64Value");
    BluetoothGattServer localBluetoothGattServer = this.jIy;
    if (localBluetoothGattServer == null) {
      k.aPZ("gattServer");
    }
    paramUUID1 = localBluetoothGattServer.getService(paramUUID1);
    if (paramUUID1 == null)
    {
      ad.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: server == null");
      AppMethodBeat.o(144779);
      return;
    }
    paramUUID1 = paramUUID1.getCharacteristic(paramUUID2);
    if (paramUUID1 == null)
    {
      ad.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: characteristic == null");
      AppMethodBeat.o(144779);
      return;
    }
    paramUUID1.setValue(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.au(Base64.decode(paramString, 2)));
    if (paramBoolean)
    {
      paramUUID2 = this.jIB;
      if (paramUUID2 == null) {
        k.fvU();
      }
      paramUUID2 = ((Iterable)paramUUID2.jIc).iterator();
      while (paramUUID2.hasNext())
      {
        paramString = (BluetoothDevice)paramUUID2.next();
        localBluetoothGattServer = this.jIy;
        if (localBluetoothGattServer == null) {
          k.aPZ("gattServer");
        }
        ad.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(localBluetoothGattServer.notifyCharacteristicChanged(paramString, paramUUID1, false)) });
      }
    }
    paramUUID2 = this.jIB;
    if (paramUUID2 == null) {
      k.fvU();
    }
    paramUUID2 = ((Iterable)paramUUID2.jIc).iterator();
    while (paramUUID2.hasNext())
    {
      paramString = (BluetoothDevice)paramUUID2.next();
      localBluetoothGattServer = this.jIy;
      if (localBluetoothGattServer == null) {
        k.aPZ("gattServer");
      }
      ad.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(localBluetoothGattServer.notifyCharacteristicChanged(paramString, paramUUID1, true)) });
    }
    paramUUID2 = this.jIB;
    if (paramUUID2 == null) {
      k.fvU();
    }
    paramUUID2 = (m)paramUUID2.jId.get(Integer.valueOf(paramInt));
    if (paramUUID2 == null)
    {
      ad.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: #" + paramInt + " callbackId -> pendingResp is null");
      AppMethodBeat.o(144779);
      return;
    }
    ad.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: device = %s, requestId = %s", new Object[] { paramUUID2.jIw.toString(), String.valueOf(paramUUID2.requestId) });
    paramString = this.jIy;
    if (paramString == null) {
      k.aPZ("gattServer");
    }
    if (!paramString.sendResponse(paramUUID2.jIw, paramUUID2.requestId, 0, paramUUID2.offset, paramUUID1.getValue())) {
      ad.e("MicroMsg.BLE.PeripheralBleServer", "sendPendingRespFail");
    }
    paramUUID1 = this.jIB;
    if (paramUUID1 == null) {
      k.fvU();
    }
    paramUUID1.jId.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(144779);
  }
  
  public final BluetoothGattServer aYK()
  {
    AppMethodBeat.i(144775);
    BluetoothGattServer localBluetoothGattServer = this.jIy;
    if (localBluetoothGattServer == null) {
      k.aPZ("gattServer");
    }
    AppMethodBeat.o(144775);
    return localBluetoothGattServer;
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    AppMethodBeat.i(144777);
    k.h(paramc, "component");
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aZa();
    if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aZc() & true & com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aYY() & com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aZd())) && (localObject != null))
    {
      this.jIx = p.jII;
      this.joJ = paramc;
      this.iyW = paramInt;
      this.jIB = new b();
      paramc = ((BluetoothManager)localObject).openGattServer(aj.getContext(), (BluetoothGattServerCallback)this.jIB);
      k.g(paramc, "bluetoothManager.openGat…xt(), gattServerCallback)");
      this.jIy = paramc;
      paramc = this.jIB;
      if (paramc == null) {
        k.fvU();
      }
      localObject = (n)this;
      k.h(localObject, "<set-?>");
      paramc.jIe = ((n)localObject);
      AppMethodBeat.o(144777);
      return;
    }
    paramc = p.jIL;
    AppMethodBeat.o(144777);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(144778);
    this.jIz.clear();
    Object localObject = this.jIy;
    if (localObject == null) {
      k.aPZ("gattServer");
    }
    ((BluetoothGattServer)localObject).close();
    localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aZb();
    if (localObject != null)
    {
      k.g(localObject, "it");
      a((BluetoothAdapter)localObject);
    }
    localObject = this.jIB;
    if (localObject != null)
    {
      localObject = ((b)localObject).jId;
      if (localObject != null) {
        ((Map)localObject).clear();
      }
    }
    this.jIB = null;
    this.jIx = p.jIK;
    AppMethodBeat.o(144778);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer$Companion;", "", "()V", "TAG", "", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"})
  public static final class b
    extends TimerTask
  {
    public b(d.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(144773);
      TimerTask localTimerTask = (TimerTask)this;
      this.gAW.aA(Boolean.FALSE);
      localTimerTask.cancel();
      AppMethodBeat.o(144773);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n
 * JD-Core Version:    0.7.0.1
 */