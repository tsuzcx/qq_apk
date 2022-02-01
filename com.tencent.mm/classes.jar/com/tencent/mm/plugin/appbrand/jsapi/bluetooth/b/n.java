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
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "", "()V", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "setComponent", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "gattServer", "Landroid/bluetooth/BluetoothGattServer;", "getGattServer", "()Landroid/bluetooth/BluetoothGattServer;", "setGattServer", "(Landroid/bluetooth/BluetoothGattServer;)V", "gattServerCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl;", "isPostingAdvertising", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "jsCallbacks", "", "Ljava/util/UUID;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsCallback;", "Ljava/util/Timer;", "getJsCallbacks", "()Ljava/util/Map;", "realAdvertiseCallback", "Landroid/bluetooth/le/AdvertiseCallback;", "serverId", "", "getServerId", "()I", "setServerId", "(I)V", "status", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "getStatus", "()Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "setStatus", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;)V", "userCallbackLock", "addService", "service", "Landroid/bluetooth/BluetoothGattService;", "callback", "checkBleIsWork", "handleCharacteristicWriteAction", "serviceId", "characteristicId", "needNotify", "callbackId", "base64Value", "", "isAdvertising", "offAdvertising", "onAdvertising", "onCreate", "onDestroy", "startBLEPeripheralAdvertising", "settings", "Landroid/bluetooth/le/AdvertiseSettings;", "advertiseData", "Landroid/bluetooth/le/AdvertiseData;", "scanResponse", "deviceName", "adapter", "Landroid/bluetooth/BluetoothAdapter;", "userCallback", "stopBLEPeripheralAdvertising", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class n
{
  public static final a lLL;
  int ktp;
  p lLE;
  public BluetoothGattServer lLF;
  final Map<UUID, o<kotlin.g.a.b<Boolean, x>, Timer>> lLG;
  private final AdvertiseCallback lLH;
  AdvertiseCallback lLI;
  final AtomicBoolean lLJ;
  private b lLK;
  public f lqg;
  
  static
  {
    AppMethodBeat.i(144781);
    lLL = new a((byte)0);
    AppMethodBeat.o(144781);
  }
  
  public n()
  {
    AppMethodBeat.i(144780);
    this.lLE = p.lLW;
    this.ktp = -1;
    this.lLG = ((Map)new HashMap());
    this.lLH = ((AdvertiseCallback)new c(this));
    this.lLJ = new AtomicBoolean(false);
    AppMethodBeat.o(144780);
  }
  
  public final f NN()
  {
    AppMethodBeat.i(144776);
    f localf = this.lqg;
    if (localf == null) {
      kotlin.g.b.p.btv("component");
    }
    AppMethodBeat.o(144776);
    return localf;
  }
  
  public final void a(BluetoothAdapter paramBluetoothAdapter)
  {
    AppMethodBeat.i(183549);
    kotlin.g.b.p.h(paramBluetoothAdapter, "adapter");
    paramBluetoothAdapter = paramBluetoothAdapter.getBluetoothLeAdvertiser();
    if (paramBluetoothAdapter == null)
    {
      AppMethodBeat.o(183549);
      return;
    }
    paramBluetoothAdapter.stopAdvertising(this.lLH);
    this.lLI = null;
    AppMethodBeat.o(183549);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(144774);
    kotlin.g.b.p.h(paramp, "<set-?>");
    this.lLE = paramp;
    AppMethodBeat.o(144774);
  }
  
  public final void a(UUID paramUUID1, UUID paramUUID2, boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(144779);
    kotlin.g.b.p.h(paramUUID1, "serviceId");
    kotlin.g.b.p.h(paramUUID2, "characteristicId");
    kotlin.g.b.p.h(paramString, "base64Value");
    BluetoothGattServer localBluetoothGattServer = this.lLF;
    if (localBluetoothGattServer == null) {
      kotlin.g.b.p.btv("gattServer");
    }
    paramUUID1 = localBluetoothGattServer.getService(paramUUID1);
    if (paramUUID1 == null)
    {
      Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: server == null");
      AppMethodBeat.o(144779);
      return;
    }
    paramUUID1 = paramUUID1.getCharacteristic(paramUUID2);
    if (paramUUID1 == null)
    {
      Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: characteristic == null");
      AppMethodBeat.o(144779);
      return;
    }
    paramUUID1.setValue(c.aK(Base64.decode(paramString, 2)));
    if (paramBoolean)
    {
      paramUUID2 = this.lLK;
      if (paramUUID2 == null) {
        kotlin.g.b.p.hyc();
      }
      paramUUID2 = ((Iterable)paramUUID2.lLj).iterator();
      while (paramUUID2.hasNext())
      {
        paramString = (BluetoothDevice)paramUUID2.next();
        localBluetoothGattServer = this.lLF;
        if (localBluetoothGattServer == null) {
          kotlin.g.b.p.btv("gattServer");
        }
        Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(localBluetoothGattServer.notifyCharacteristicChanged(paramString, paramUUID1, false)) });
      }
    }
    paramUUID2 = this.lLK;
    if (paramUUID2 == null) {
      kotlin.g.b.p.hyc();
    }
    paramUUID2 = ((Iterable)paramUUID2.lLj).iterator();
    while (paramUUID2.hasNext())
    {
      paramString = (BluetoothDevice)paramUUID2.next();
      localBluetoothGattServer = this.lLF;
      if (localBluetoothGattServer == null) {
        kotlin.g.b.p.btv("gattServer");
      }
      Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(localBluetoothGattServer.notifyCharacteristicChanged(paramString, paramUUID1, true)) });
    }
    paramUUID2 = this.lLK;
    if (paramUUID2 == null) {
      kotlin.g.b.p.hyc();
    }
    paramUUID2 = (m)paramUUID2.lLk.get(Integer.valueOf(paramInt));
    if (paramUUID2 == null)
    {
      Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: #" + paramInt + " callbackId -> pendingResp is null");
      AppMethodBeat.o(144779);
      return;
    }
    Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: device = %s, requestId = %s", new Object[] { paramUUID2.lLD.toString(), String.valueOf(paramUUID2.requestId) });
    paramString = this.lLF;
    if (paramString == null) {
      kotlin.g.b.p.btv("gattServer");
    }
    if (!paramString.sendResponse(paramUUID2.lLD, paramUUID2.requestId, 0, paramUUID2.offset, paramUUID1.getValue())) {
      Log.e("MicroMsg.BLE.PeripheralBleServer", "sendPendingRespFail");
    }
    paramUUID1 = this.lLK;
    if (paramUUID1 == null) {
      kotlin.g.b.p.hyc();
    }
    paramUUID1.lLk.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(144779);
  }
  
  public final BluetoothGattServer bFi()
  {
    AppMethodBeat.i(144775);
    BluetoothGattServer localBluetoothGattServer = this.lLF;
    if (localBluetoothGattServer == null) {
      kotlin.g.b.p.btv("gattServer");
    }
    AppMethodBeat.o(144775);
    return localBluetoothGattServer;
  }
  
  final boolean bFj()
  {
    return this.lLI != null;
  }
  
  public final void c(f paramf, int paramInt)
  {
    AppMethodBeat.i(144777);
    kotlin.g.b.p.h(paramf, "component");
    Object localObject = c.bFB();
    if (((c.bFD() & true & com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.bFz() & c.bFE())) && (localObject != null))
    {
      this.lLE = p.lLX;
      this.lqg = paramf;
      this.ktp = paramInt;
      this.lLK = new b();
      paramf = ((BluetoothManager)localObject).openGattServer(MMApplicationContext.getContext(), (BluetoothGattServerCallback)this.lLK);
      kotlin.g.b.p.g(paramf, "bluetoothManager.openGat…xt(), gattServerCallback)");
      this.lLF = paramf;
      paramf = this.lLK;
      if (paramf == null) {
        kotlin.g.b.p.hyc();
      }
      localObject = (n)this;
      kotlin.g.b.p.h(localObject, "<set-?>");
      paramf.lLl = ((n)localObject);
      AppMethodBeat.o(144777);
      return;
    }
    paramf = p.lMa;
    AppMethodBeat.o(144777);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(144778);
    this.lLG.clear();
    Object localObject = this.lLF;
    if (localObject == null) {
      kotlin.g.b.p.btv("gattServer");
    }
    ((BluetoothGattServer)localObject).close();
    localObject = c.bFC();
    if (localObject != null)
    {
      kotlin.g.b.p.g(localObject, "it");
      a((BluetoothAdapter)localObject);
    }
    localObject = this.lLK;
    if (localObject != null)
    {
      localObject = ((b)localObject).lLk;
      if (localObject != null) {
        ((Map)localObject).clear();
      }
    }
    this.lLK = null;
    this.lLE = p.lLZ;
    AppMethodBeat.o(144778);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer$Companion;", "", "()V", "TAG", "", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer$realAdvertiseCallback$1", "Landroid/bluetooth/le/AdvertiseCallback;", "onStartFailure", "", "errorCode", "", "onStartSuccess", "settingsInEffect", "Landroid/bluetooth/le/AdvertiseSettings;", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class c
    extends AdvertiseCallback
  {
    public final void onStartFailure(int paramInt)
    {
      AppMethodBeat.i(215125);
      super.onStartFailure(paramInt);
      AdvertiseCallback localAdvertiseCallback = n.c(this.lLM);
      if (localAdvertiseCallback == null) {
        kotlin.g.b.p.hyc();
      }
      localAdvertiseCallback.onStartFailure(paramInt);
      n.d(this.lLM);
      AppMethodBeat.o(215125);
    }
    
    public final void onStartSuccess(AdvertiseSettings paramAdvertiseSettings)
    {
      AppMethodBeat.i(215124);
      super.onStartSuccess(paramAdvertiseSettings);
      if (n.b(this.lLM))
      {
        AdvertiseCallback localAdvertiseCallback = n.c(this.lLM);
        if (localAdvertiseCallback == null) {
          kotlin.g.b.p.hyc();
        }
        localAdvertiseCallback.onStartSuccess(paramAdvertiseSettings);
      }
      AppMethodBeat.o(215124);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(n paramn, BluetoothAdapter paramBluetoothAdapter, String paramString, AdvertiseSettings paramAdvertiseSettings, AdvertiseData paramAdvertiseData1, AdvertiseData paramAdvertiseData2) {}
    
    public final void run()
    {
      AppMethodBeat.i(215126);
      if (!kotlin.n.n.aL((CharSequence)this.lLO)) {}
      for (int i = 1; (i != 0) && ((kotlin.g.b.p.j(this.lLN.getName(), this.lLO) ^ true)); i = 0)
      {
        if (!this.lLN.setName(this.lLO)) {
          Log.w("MicroMsg.BLE.PeripheralBleServer", "set BLE adapter name fail, may under wrong state! [%d]", new Object[] { Integer.valueOf(this.lLN.getState()) });
        }
        i = 0;
        while (i <= 20)
        {
          String str = this.lLN.getName();
          Log.i("MicroMsg.BLE.PeripheralBleServer", "round [%d] sys = [%s], want = [%s]", new Object[] { Integer.valueOf(i), str, this.lLO });
          if (kotlin.g.b.p.j(this.lLO, str)) {
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
            AppMethodBeat.o(215126);
            throw ((Throwable)localObject);
          }
        }
      }
      Object localObject = this.lLN.getBluetoothLeAdvertiser();
      if (localObject != null) {
        ((BluetoothLeAdvertiser)localObject).startAdvertising(this.lLP, this.lLQ, this.lLR, n.a(this.lLM));
      }
      this.lLM.lLJ.set(false);
      AppMethodBeat.o(215126);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n
 * JD-Core Version:    0.7.0.1
 */