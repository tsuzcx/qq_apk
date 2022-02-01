package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;
import d.o;
import d.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "", "()V", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "setComponent", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "gattServer", "Landroid/bluetooth/BluetoothGattServer;", "getGattServer", "()Landroid/bluetooth/BluetoothGattServer;", "setGattServer", "(Landroid/bluetooth/BluetoothGattServer;)V", "gattServerCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl;", "isPostingAdvertising", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "jsCallbacks", "", "Ljava/util/UUID;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsCallback;", "Ljava/util/Timer;", "getJsCallbacks", "()Ljava/util/Map;", "realAdvertiseCallback", "Landroid/bluetooth/le/AdvertiseCallback;", "serverId", "", "getServerId", "()I", "setServerId", "(I)V", "status", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "getStatus", "()Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "setStatus", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;)V", "userCallbackLock", "addService", "service", "Landroid/bluetooth/BluetoothGattService;", "callback", "checkBleIsWork", "handleCharacteristicWriteAction", "serviceId", "characteristicId", "needNotify", "callbackId", "base64Value", "", "isAdvertising", "offAdvertising", "onAdvertising", "onCreate", "onDestroy", "startBLEPeripheralAdvertising", "settings", "Landroid/bluetooth/le/AdvertiseSettings;", "advertiseData", "Landroid/bluetooth/le/AdvertiseData;", "scanResponse", "deviceName", "adapter", "Landroid/bluetooth/BluetoothAdapter;", "userCallback", "stopBLEPeripheralAdvertising", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class n
{
  public static final a kDV;
  int jsi;
  p kDO;
  public BluetoothGattServer kDP;
  final Map<UUID, o<d.g.a.b<Boolean, z>, Timer>> kDQ;
  private final AdvertiseCallback kDR;
  AdvertiseCallback kDS;
  final AtomicBoolean kDT;
  private b kDU;
  public com.tencent.mm.plugin.appbrand.jsapi.c kjg;
  
  static
  {
    AppMethodBeat.i(144781);
    kDV = new a((byte)0);
    AppMethodBeat.o(144781);
  }
  
  public n()
  {
    AppMethodBeat.i(144780);
    this.kDO = p.kEg;
    this.jsi = -1;
    this.kDQ = ((Map)new HashMap());
    this.kDR = ((AdvertiseCallback)new c(this));
    this.kDT = new AtomicBoolean(false);
    AppMethodBeat.o(144780);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.c El()
  {
    AppMethodBeat.i(144776);
    com.tencent.mm.plugin.appbrand.jsapi.c localc = this.kjg;
    if (localc == null) {
      d.g.b.p.bcb("component");
    }
    AppMethodBeat.o(144776);
    return localc;
  }
  
  public final void a(BluetoothAdapter paramBluetoothAdapter)
  {
    AppMethodBeat.i(183549);
    d.g.b.p.h(paramBluetoothAdapter, "adapter");
    paramBluetoothAdapter = paramBluetoothAdapter.getBluetoothLeAdvertiser();
    if (paramBluetoothAdapter == null)
    {
      AppMethodBeat.o(183549);
      return;
    }
    paramBluetoothAdapter.stopAdvertising(this.kDR);
    this.kDS = null;
    AppMethodBeat.o(183549);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(144774);
    d.g.b.p.h(paramp, "<set-?>");
    this.kDO = paramp;
    AppMethodBeat.o(144774);
  }
  
  public final void a(UUID paramUUID1, UUID paramUUID2, boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(144779);
    d.g.b.p.h(paramUUID1, "serviceId");
    d.g.b.p.h(paramUUID2, "characteristicId");
    d.g.b.p.h(paramString, "base64Value");
    BluetoothGattServer localBluetoothGattServer = this.kDP;
    if (localBluetoothGattServer == null) {
      d.g.b.p.bcb("gattServer");
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
    paramUUID1.setValue(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.at(Base64.decode(paramString, 2)));
    if (paramBoolean)
    {
      paramUUID2 = this.kDU;
      if (paramUUID2 == null) {
        d.g.b.p.gfZ();
      }
      paramUUID2 = ((Iterable)paramUUID2.kDt).iterator();
      while (paramUUID2.hasNext())
      {
        paramString = (BluetoothDevice)paramUUID2.next();
        localBluetoothGattServer = this.kDP;
        if (localBluetoothGattServer == null) {
          d.g.b.p.bcb("gattServer");
        }
        ad.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(localBluetoothGattServer.notifyCharacteristicChanged(paramString, paramUUID1, false)) });
      }
    }
    paramUUID2 = this.kDU;
    if (paramUUID2 == null) {
      d.g.b.p.gfZ();
    }
    paramUUID2 = ((Iterable)paramUUID2.kDt).iterator();
    while (paramUUID2.hasNext())
    {
      paramString = (BluetoothDevice)paramUUID2.next();
      localBluetoothGattServer = this.kDP;
      if (localBluetoothGattServer == null) {
        d.g.b.p.bcb("gattServer");
      }
      ad.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(localBluetoothGattServer.notifyCharacteristicChanged(paramString, paramUUID1, true)) });
    }
    paramUUID2 = this.kDU;
    if (paramUUID2 == null) {
      d.g.b.p.gfZ();
    }
    paramUUID2 = (m)paramUUID2.kDu.get(Integer.valueOf(paramInt));
    if (paramUUID2 == null)
    {
      ad.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: #" + paramInt + " callbackId -> pendingResp is null");
      AppMethodBeat.o(144779);
      return;
    }
    ad.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: device = %s, requestId = %s", new Object[] { paramUUID2.kDN.toString(), String.valueOf(paramUUID2.requestId) });
    paramString = this.kDP;
    if (paramString == null) {
      d.g.b.p.bcb("gattServer");
    }
    if (!paramString.sendResponse(paramUUID2.kDN, paramUUID2.requestId, 0, paramUUID2.offset, paramUUID1.getValue())) {
      ad.e("MicroMsg.BLE.PeripheralBleServer", "sendPendingRespFail");
    }
    paramUUID1 = this.kDU;
    if (paramUUID1 == null) {
      d.g.b.p.gfZ();
    }
    paramUUID1.kDu.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(144779);
  }
  
  public final BluetoothGattServer bjj()
  {
    AppMethodBeat.i(144775);
    BluetoothGattServer localBluetoothGattServer = this.kDP;
    if (localBluetoothGattServer == null) {
      d.g.b.p.bcb("gattServer");
    }
    AppMethodBeat.o(144775);
    return localBluetoothGattServer;
  }
  
  final boolean bjk()
  {
    return this.kDS != null;
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    AppMethodBeat.i(144777);
    d.g.b.p.h(paramc, "component");
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjw();
    if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjy() & true & com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.bju() & com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjz())) && (localObject != null))
    {
      this.kDO = p.kEh;
      this.kjg = paramc;
      this.jsi = paramInt;
      this.kDU = new b();
      paramc = ((BluetoothManager)localObject).openGattServer(aj.getContext(), (BluetoothGattServerCallback)this.kDU);
      d.g.b.p.g(paramc, "bluetoothManager.openGat…xt(), gattServerCallback)");
      this.kDP = paramc;
      paramc = this.kDU;
      if (paramc == null) {
        d.g.b.p.gfZ();
      }
      localObject = (n)this;
      d.g.b.p.h(localObject, "<set-?>");
      paramc.kDv = ((n)localObject);
      AppMethodBeat.o(144777);
      return;
    }
    paramc = p.kEk;
    AppMethodBeat.o(144777);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(144778);
    this.kDQ.clear();
    Object localObject = this.kDP;
    if (localObject == null) {
      d.g.b.p.bcb("gattServer");
    }
    ((BluetoothGattServer)localObject).close();
    localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjx();
    if (localObject != null)
    {
      d.g.b.p.g(localObject, "it");
      a((BluetoothAdapter)localObject);
    }
    localObject = this.kDU;
    if (localObject != null)
    {
      localObject = ((b)localObject).kDu;
      if (localObject != null) {
        ((Map)localObject).clear();
      }
    }
    this.kDU = null;
    this.kDO = p.kEj;
    AppMethodBeat.o(144778);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer$Companion;", "", "()V", "TAG", "", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"})
  public static final class b
    extends TimerTask
  {
    public b(d.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(144773);
      TimerTask localTimerTask = (TimerTask)this;
      this.htA.invoke(Boolean.FALSE);
      localTimerTask.cancel();
      AppMethodBeat.o(144773);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer$realAdvertiseCallback$1", "Landroid/bluetooth/le/AdvertiseCallback;", "onStartFailure", "", "errorCode", "", "onStartSuccess", "settingsInEffect", "Landroid/bluetooth/le/AdvertiseSettings;", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class c
    extends AdvertiseCallback
  {
    public final void onStartFailure(int paramInt)
    {
      AppMethodBeat.i(195121);
      super.onStartFailure(paramInt);
      AdvertiseCallback localAdvertiseCallback = n.c(this.kDW);
      if (localAdvertiseCallback == null) {
        d.g.b.p.gfZ();
      }
      localAdvertiseCallback.onStartFailure(paramInt);
      n.d(this.kDW);
      AppMethodBeat.o(195121);
    }
    
    public final void onStartSuccess(AdvertiseSettings paramAdvertiseSettings)
    {
      AppMethodBeat.i(195120);
      super.onStartSuccess(paramAdvertiseSettings);
      if (n.b(this.kDW))
      {
        AdvertiseCallback localAdvertiseCallback = n.c(this.kDW);
        if (localAdvertiseCallback == null) {
          d.g.b.p.gfZ();
        }
        localAdvertiseCallback.onStartSuccess(paramAdvertiseSettings);
      }
      AppMethodBeat.o(195120);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(n paramn, BluetoothAdapter paramBluetoothAdapter, String paramString, AdvertiseSettings paramAdvertiseSettings, AdvertiseData paramAdvertiseData1, AdvertiseData paramAdvertiseData2) {}
    
    public final void run()
    {
      AppMethodBeat.i(195122);
      if (!d.n.n.aE((CharSequence)this.kDY)) {}
      for (int i = 1; (i != 0) && ((d.g.b.p.i(this.kDX.getName(), this.kDY) ^ true)); i = 0)
      {
        if (!this.kDX.setName(this.kDY)) {
          ad.w("MicroMsg.BLE.PeripheralBleServer", "set BLE adapter name fail, may under wrong state! [%d]", new Object[] { Integer.valueOf(this.kDX.getState()) });
        }
        i = 0;
        while (i <= 20)
        {
          String str = this.kDX.getName();
          ad.i("MicroMsg.BLE.PeripheralBleServer", "round [%d] sys = [%s], want = [%s]", new Object[] { Integer.valueOf(i), str, this.kDY });
          if (d.g.b.p.i(this.kDY, str)) {
            break;
          }
          try
          {
            Thread.sleep(50L);
            i += 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            localObject = (Throwable)localInterruptedException;
            AppMethodBeat.o(195122);
            throw ((Throwable)localObject);
          }
        }
      }
      Object localObject = this.kDX.getBluetoothLeAdvertiser();
      if (localObject != null) {
        ((BluetoothLeAdvertiser)localObject).startAdvertising(this.kDZ, this.kEa, this.kEb, n.a(this.kDW));
      }
      this.kDW.kDT.set(false);
      AppMethodBeat.o(195122);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n
 * JD-Core Version:    0.7.0.1
 */