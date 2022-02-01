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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "", "()V", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "setComponent", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "gattServer", "Landroid/bluetooth/BluetoothGattServer;", "getGattServer", "()Landroid/bluetooth/BluetoothGattServer;", "setGattServer", "(Landroid/bluetooth/BluetoothGattServer;)V", "gattServerCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl;", "isPostingAdvertising", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "jsCallbacks", "", "Ljava/util/UUID;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsCallback;", "Ljava/util/Timer;", "getJsCallbacks", "()Ljava/util/Map;", "realAdvertiseCallback", "Landroid/bluetooth/le/AdvertiseCallback;", "serverId", "", "getServerId", "()I", "setServerId", "(I)V", "status", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "getStatus", "()Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "setStatus", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;)V", "userCallbackLock", "addService", "service", "Landroid/bluetooth/BluetoothGattService;", "callback", "checkBleIsWork", "handleCharacteristicWriteAction", "serviceId", "characteristicId", "needNotify", "callbackId", "base64Value", "", "isAdvertising", "offAdvertising", "onAdvertising", "onCreate", "onDestroy", "startBLEPeripheralAdvertising", "settings", "Landroid/bluetooth/le/AdvertiseSettings;", "advertiseData", "Landroid/bluetooth/le/AdvertiseData;", "scanResponse", "deviceName", "adapter", "Landroid/bluetooth/BluetoothAdapter;", "userCallback", "stopBLEPeripheralAdvertising", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class n
{
  public static final a kHk;
  int jvb;
  p kHd;
  public BluetoothGattServer kHe;
  final Map<UUID, o<d.g.a.b<Boolean, z>, Timer>> kHf;
  private final AdvertiseCallback kHg;
  AdvertiseCallback kHh;
  final AtomicBoolean kHi;
  private b kHj;
  public com.tencent.mm.plugin.appbrand.jsapi.c kmw;
  
  static
  {
    AppMethodBeat.i(144781);
    kHk = new a((byte)0);
    AppMethodBeat.o(144781);
  }
  
  public n()
  {
    AppMethodBeat.i(144780);
    this.kHd = p.kHv;
    this.jvb = -1;
    this.kHf = ((Map)new HashMap());
    this.kHg = ((AdvertiseCallback)new c(this));
    this.kHi = new AtomicBoolean(false);
    AppMethodBeat.o(144780);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.c Eo()
  {
    AppMethodBeat.i(144776);
    com.tencent.mm.plugin.appbrand.jsapi.c localc = this.kmw;
    if (localc == null) {
      d.g.b.p.bdF("component");
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
    paramBluetoothAdapter.stopAdvertising(this.kHg);
    this.kHh = null;
    AppMethodBeat.o(183549);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(144774);
    d.g.b.p.h(paramp, "<set-?>");
    this.kHd = paramp;
    AppMethodBeat.o(144774);
  }
  
  public final void a(UUID paramUUID1, UUID paramUUID2, boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(144779);
    d.g.b.p.h(paramUUID1, "serviceId");
    d.g.b.p.h(paramUUID2, "characteristicId");
    d.g.b.p.h(paramString, "base64Value");
    BluetoothGattServer localBluetoothGattServer = this.kHe;
    if (localBluetoothGattServer == null) {
      d.g.b.p.bdF("gattServer");
    }
    paramUUID1 = localBluetoothGattServer.getService(paramUUID1);
    if (paramUUID1 == null)
    {
      ae.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: server == null");
      AppMethodBeat.o(144779);
      return;
    }
    paramUUID1 = paramUUID1.getCharacteristic(paramUUID2);
    if (paramUUID1 == null)
    {
      ae.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: characteristic == null");
      AppMethodBeat.o(144779);
      return;
    }
    paramUUID1.setValue(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.at(Base64.decode(paramString, 2)));
    if (paramBoolean)
    {
      paramUUID2 = this.kHj;
      if (paramUUID2 == null) {
        d.g.b.p.gkB();
      }
      paramUUID2 = ((Iterable)paramUUID2.kGI).iterator();
      while (paramUUID2.hasNext())
      {
        paramString = (BluetoothDevice)paramUUID2.next();
        localBluetoothGattServer = this.kHe;
        if (localBluetoothGattServer == null) {
          d.g.b.p.bdF("gattServer");
        }
        ae.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(localBluetoothGattServer.notifyCharacteristicChanged(paramString, paramUUID1, false)) });
      }
    }
    paramUUID2 = this.kHj;
    if (paramUUID2 == null) {
      d.g.b.p.gkB();
    }
    paramUUID2 = ((Iterable)paramUUID2.kGI).iterator();
    while (paramUUID2.hasNext())
    {
      paramString = (BluetoothDevice)paramUUID2.next();
      localBluetoothGattServer = this.kHe;
      if (localBluetoothGattServer == null) {
        d.g.b.p.bdF("gattServer");
      }
      ae.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(localBluetoothGattServer.notifyCharacteristicChanged(paramString, paramUUID1, true)) });
    }
    paramUUID2 = this.kHj;
    if (paramUUID2 == null) {
      d.g.b.p.gkB();
    }
    paramUUID2 = (m)paramUUID2.kGJ.get(Integer.valueOf(paramInt));
    if (paramUUID2 == null)
    {
      ae.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: #" + paramInt + " callbackId -> pendingResp is null");
      AppMethodBeat.o(144779);
      return;
    }
    ae.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: device = %s, requestId = %s", new Object[] { paramUUID2.kHc.toString(), String.valueOf(paramUUID2.requestId) });
    paramString = this.kHe;
    if (paramString == null) {
      d.g.b.p.bdF("gattServer");
    }
    if (!paramString.sendResponse(paramUUID2.kHc, paramUUID2.requestId, 0, paramUUID2.offset, paramUUID1.getValue())) {
      ae.e("MicroMsg.BLE.PeripheralBleServer", "sendPendingRespFail");
    }
    paramUUID1 = this.kHj;
    if (paramUUID1 == null) {
      d.g.b.p.gkB();
    }
    paramUUID1.kGJ.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(144779);
  }
  
  public final BluetoothGattServer bjS()
  {
    AppMethodBeat.i(144775);
    BluetoothGattServer localBluetoothGattServer = this.kHe;
    if (localBluetoothGattServer == null) {
      d.g.b.p.bdF("gattServer");
    }
    AppMethodBeat.o(144775);
    return localBluetoothGattServer;
  }
  
  final boolean bjT()
  {
    return this.kHh != null;
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    AppMethodBeat.i(144777);
    d.g.b.p.h(paramc, "component");
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bkf();
    if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bkh() & true & com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.bkd() & com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bki())) && (localObject != null))
    {
      this.kHd = p.kHw;
      this.kmw = paramc;
      this.jvb = paramInt;
      this.kHj = new b();
      paramc = ((BluetoothManager)localObject).openGattServer(ak.getContext(), (BluetoothGattServerCallback)this.kHj);
      d.g.b.p.g(paramc, "bluetoothManager.openGat…xt(), gattServerCallback)");
      this.kHe = paramc;
      paramc = this.kHj;
      if (paramc == null) {
        d.g.b.p.gkB();
      }
      localObject = (n)this;
      d.g.b.p.h(localObject, "<set-?>");
      paramc.kGK = ((n)localObject);
      AppMethodBeat.o(144777);
      return;
    }
    paramc = p.kHz;
    AppMethodBeat.o(144777);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(144778);
    this.kHf.clear();
    Object localObject = this.kHe;
    if (localObject == null) {
      d.g.b.p.bdF("gattServer");
    }
    ((BluetoothGattServer)localObject).close();
    localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bkg();
    if (localObject != null)
    {
      d.g.b.p.g(localObject, "it");
      a((BluetoothAdapter)localObject);
    }
    localObject = this.kHj;
    if (localObject != null)
    {
      localObject = ((b)localObject).kGJ;
      if (localObject != null) {
        ((Map)localObject).clear();
      }
    }
    this.kHj = null;
    this.kHd = p.kHy;
    AppMethodBeat.o(144778);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer$Companion;", "", "()V", "TAG", "", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"})
  public static final class b
    extends TimerTask
  {
    public b(d.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(144773);
      TimerTask localTimerTask = (TimerTask)this;
      this.hwo.invoke(Boolean.FALSE);
      localTimerTask.cancel();
      AppMethodBeat.o(144773);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer$realAdvertiseCallback$1", "Landroid/bluetooth/le/AdvertiseCallback;", "onStartFailure", "", "errorCode", "", "onStartSuccess", "settingsInEffect", "Landroid/bluetooth/le/AdvertiseSettings;", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class c
    extends AdvertiseCallback
  {
    public final void onStartFailure(int paramInt)
    {
      AppMethodBeat.i(208370);
      super.onStartFailure(paramInt);
      AdvertiseCallback localAdvertiseCallback = n.c(this.kHl);
      if (localAdvertiseCallback == null) {
        d.g.b.p.gkB();
      }
      localAdvertiseCallback.onStartFailure(paramInt);
      n.d(this.kHl);
      AppMethodBeat.o(208370);
    }
    
    public final void onStartSuccess(AdvertiseSettings paramAdvertiseSettings)
    {
      AppMethodBeat.i(208369);
      super.onStartSuccess(paramAdvertiseSettings);
      if (n.b(this.kHl))
      {
        AdvertiseCallback localAdvertiseCallback = n.c(this.kHl);
        if (localAdvertiseCallback == null) {
          d.g.b.p.gkB();
        }
        localAdvertiseCallback.onStartSuccess(paramAdvertiseSettings);
      }
      AppMethodBeat.o(208369);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(n paramn, BluetoothAdapter paramBluetoothAdapter, String paramString, AdvertiseSettings paramAdvertiseSettings, AdvertiseData paramAdvertiseData1, AdvertiseData paramAdvertiseData2) {}
    
    public final void run()
    {
      AppMethodBeat.i(208371);
      if (!d.n.n.aD((CharSequence)this.kHn)) {}
      for (int i = 1; (i != 0) && ((d.g.b.p.i(this.kHm.getName(), this.kHn) ^ true)); i = 0)
      {
        if (!this.kHm.setName(this.kHn)) {
          ae.w("MicroMsg.BLE.PeripheralBleServer", "set BLE adapter name fail, may under wrong state! [%d]", new Object[] { Integer.valueOf(this.kHm.getState()) });
        }
        i = 0;
        while (i <= 20)
        {
          String str = this.kHm.getName();
          ae.i("MicroMsg.BLE.PeripheralBleServer", "round [%d] sys = [%s], want = [%s]", new Object[] { Integer.valueOf(i), str, this.kHn });
          if (d.g.b.p.i(this.kHn, str)) {
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
            AppMethodBeat.o(208371);
            throw ((Throwable)localObject);
          }
        }
      }
      Object localObject = this.kHm.getBluetoothLeAdvertiser();
      if (localObject != null) {
        ((BluetoothLeAdvertiser)localObject).startAdvertising(this.kHo, this.kHp, this.kHq, n.a(this.kHl));
      }
      this.kHl.kHi.set(false);
      AppMethodBeat.o(208371);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n
 * JD-Core Version:    0.7.0.1
 */