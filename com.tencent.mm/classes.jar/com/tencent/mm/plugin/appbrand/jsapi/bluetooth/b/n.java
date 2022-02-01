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
import com.tencent.mm.plugin.appbrand.jsapi.e;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "", "()V", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "setComponent", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "gattServer", "Landroid/bluetooth/BluetoothGattServer;", "getGattServer", "()Landroid/bluetooth/BluetoothGattServer;", "setGattServer", "(Landroid/bluetooth/BluetoothGattServer;)V", "gattServerCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl;", "isPostingAdvertising", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "jsCallbacks", "", "Ljava/util/UUID;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsCallback;", "Ljava/util/Timer;", "getJsCallbacks", "()Ljava/util/Map;", "realAdvertiseCallback", "Landroid/bluetooth/le/AdvertiseCallback;", "serverId", "", "getServerId", "()I", "setServerId", "(I)V", "status", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "getStatus", "()Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "setStatus", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;)V", "userCallbackLock", "addService", "service", "Landroid/bluetooth/BluetoothGattService;", "callback", "checkBleIsWork", "handleCharacteristicWriteAction", "serviceId", "characteristicId", "needNotify", "callbackId", "base64Value", "", "isAdvertising", "offAdvertising", "onAdvertising", "onCreate", "onDestroy", "startBLEPeripheralAdvertising", "settings", "Landroid/bluetooth/le/AdvertiseSettings;", "advertiseData", "Landroid/bluetooth/le/AdvertiseData;", "scanResponse", "deviceName", "adapter", "Landroid/bluetooth/BluetoothAdapter;", "userCallback", "stopBLEPeripheralAdvertising", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class n
{
  public static final n.a oIa;
  int nld;
  p oHT;
  public BluetoothGattServer oHU;
  final Map<UUID, o<kotlin.g.a.b<Boolean, x>, Timer>> oHV;
  private final AdvertiseCallback oHW;
  AdvertiseCallback oHX;
  final AtomicBoolean oHY;
  private b oHZ;
  public e okQ;
  
  static
  {
    AppMethodBeat.i(144781);
    oIa = new n.a((byte)0);
    AppMethodBeat.o(144781);
  }
  
  public n()
  {
    AppMethodBeat.i(144780);
    this.oHT = p.oIl;
    this.nld = -1;
    this.oHV = ((Map)new HashMap());
    this.oHW = ((AdvertiseCallback)new c(this));
    this.oHY = new AtomicBoolean(false);
    AppMethodBeat.o(144780);
  }
  
  public final e QK()
  {
    AppMethodBeat.i(144776);
    e locale = this.okQ;
    if (locale == null) {
      kotlin.g.b.p.bGy("component");
    }
    AppMethodBeat.o(144776);
    return locale;
  }
  
  public final void a(BluetoothAdapter paramBluetoothAdapter)
  {
    AppMethodBeat.i(183549);
    kotlin.g.b.p.k(paramBluetoothAdapter, "adapter");
    paramBluetoothAdapter = paramBluetoothAdapter.getBluetoothLeAdvertiser();
    if (paramBluetoothAdapter == null)
    {
      AppMethodBeat.o(183549);
      return;
    }
    paramBluetoothAdapter.stopAdvertising(this.oHW);
    this.oHX = null;
    AppMethodBeat.o(183549);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(144774);
    kotlin.g.b.p.k(paramp, "<set-?>");
    this.oHT = paramp;
    AppMethodBeat.o(144774);
  }
  
  public final void a(UUID paramUUID1, UUID paramUUID2, boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(144779);
    kotlin.g.b.p.k(paramUUID1, "serviceId");
    kotlin.g.b.p.k(paramUUID2, "characteristicId");
    kotlin.g.b.p.k(paramString, "base64Value");
    BluetoothGattServer localBluetoothGattServer = this.oHU;
    if (localBluetoothGattServer == null) {
      kotlin.g.b.p.bGy("gattServer");
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
    paramUUID1.setValue(c.aW(Base64.decode(paramString, 2)));
    if (paramBoolean)
    {
      paramUUID2 = this.oHZ;
      if (paramUUID2 == null) {
        kotlin.g.b.p.iCn();
      }
      paramUUID2 = ((Iterable)paramUUID2.oHy).iterator();
      while (paramUUID2.hasNext())
      {
        paramString = (BluetoothDevice)paramUUID2.next();
        localBluetoothGattServer = this.oHU;
        if (localBluetoothGattServer == null) {
          kotlin.g.b.p.bGy("gattServer");
        }
        Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(localBluetoothGattServer.notifyCharacteristicChanged(paramString, paramUUID1, false)) });
      }
    }
    paramUUID2 = this.oHZ;
    if (paramUUID2 == null) {
      kotlin.g.b.p.iCn();
    }
    paramUUID2 = ((Iterable)paramUUID2.oHy).iterator();
    while (paramUUID2.hasNext())
    {
      paramString = (BluetoothDevice)paramUUID2.next();
      localBluetoothGattServer = this.oHU;
      if (localBluetoothGattServer == null) {
        kotlin.g.b.p.bGy("gattServer");
      }
      Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(localBluetoothGattServer.notifyCharacteristicChanged(paramString, paramUUID1, true)) });
    }
    paramUUID2 = this.oHZ;
    if (paramUUID2 == null) {
      kotlin.g.b.p.iCn();
    }
    paramUUID2 = (m)paramUUID2.oHz.get(Integer.valueOf(paramInt));
    if (paramUUID2 == null)
    {
      Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: #" + paramInt + " callbackId -> pendingResp is null");
      AppMethodBeat.o(144779);
      return;
    }
    Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: device = %s, requestId = %s", new Object[] { paramUUID2.oHS.toString(), String.valueOf(paramUUID2.requestId) });
    paramString = this.oHU;
    if (paramString == null) {
      kotlin.g.b.p.bGy("gattServer");
    }
    if (!paramString.sendResponse(paramUUID2.oHS, paramUUID2.requestId, 0, paramUUID2.offset, paramUUID1.getValue())) {
      Log.e("MicroMsg.BLE.PeripheralBleServer", "sendPendingRespFail");
    }
    paramUUID1 = this.oHZ;
    if (paramUUID1 == null) {
      kotlin.g.b.p.iCn();
    }
    paramUUID1.oHz.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(144779);
  }
  
  public final BluetoothGattServer bQM()
  {
    AppMethodBeat.i(144775);
    BluetoothGattServer localBluetoothGattServer = this.oHU;
    if (localBluetoothGattServer == null) {
      kotlin.g.b.p.bGy("gattServer");
    }
    AppMethodBeat.o(144775);
    return localBluetoothGattServer;
  }
  
  final boolean bQN()
  {
    return this.oHX != null;
  }
  
  public final void c(e parame, int paramInt)
  {
    AppMethodBeat.i(144777);
    kotlin.g.b.p.k(parame, "component");
    Object localObject = c.bRj();
    if (((c.bRl() & true & com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.bRh() & c.bRm())) && (localObject != null))
    {
      this.oHT = p.oIm;
      this.okQ = parame;
      this.nld = paramInt;
      this.oHZ = new b();
      parame = ((BluetoothManager)localObject).openGattServer(MMApplicationContext.getContext(), (BluetoothGattServerCallback)this.oHZ);
      kotlin.g.b.p.j(parame, "bluetoothManager.openGat…xt(), gattServerCallback)");
      this.oHU = parame;
      parame = this.oHZ;
      if (parame == null) {
        kotlin.g.b.p.iCn();
      }
      localObject = (n)this;
      kotlin.g.b.p.k(localObject, "<set-?>");
      parame.oHA = ((n)localObject);
      AppMethodBeat.o(144777);
      return;
    }
    parame = p.oIp;
    AppMethodBeat.o(144777);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(144778);
    this.oHV.clear();
    Object localObject = this.oHU;
    if (localObject == null) {
      kotlin.g.b.p.bGy("gattServer");
    }
    ((BluetoothGattServer)localObject).close();
    localObject = c.bRk();
    if (localObject != null)
    {
      kotlin.g.b.p.j(localObject, "it");
      a((BluetoothAdapter)localObject);
    }
    localObject = this.oHZ;
    if (localObject != null)
    {
      localObject = ((b)localObject).oHz;
      if (localObject != null) {
        ((Map)localObject).clear();
      }
    }
    this.oHZ = null;
    this.oHT = p.oIo;
    AppMethodBeat.o(144778);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer$realAdvertiseCallback$1", "Landroid/bluetooth/le/AdvertiseCallback;", "onStartFailure", "", "errorCode", "", "onStartSuccess", "settingsInEffect", "Landroid/bluetooth/le/AdvertiseSettings;", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class c
    extends AdvertiseCallback
  {
    public final void onStartFailure(int paramInt)
    {
      AppMethodBeat.i(200035);
      super.onStartFailure(paramInt);
      AdvertiseCallback localAdvertiseCallback = n.c(this.oIb);
      if (localAdvertiseCallback == null) {
        kotlin.g.b.p.iCn();
      }
      localAdvertiseCallback.onStartFailure(paramInt);
      n.d(this.oIb);
      AppMethodBeat.o(200035);
    }
    
    public final void onStartSuccess(AdvertiseSettings paramAdvertiseSettings)
    {
      AppMethodBeat.i(200033);
      super.onStartSuccess(paramAdvertiseSettings);
      if (n.b(this.oIb))
      {
        AdvertiseCallback localAdvertiseCallback = n.c(this.oIb);
        if (localAdvertiseCallback == null) {
          kotlin.g.b.p.iCn();
        }
        localAdvertiseCallback.onStartSuccess(paramAdvertiseSettings);
      }
      AppMethodBeat.o(200033);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(n paramn, BluetoothAdapter paramBluetoothAdapter, String paramString, AdvertiseSettings paramAdvertiseSettings, AdvertiseData paramAdvertiseData1, AdvertiseData paramAdvertiseData2) {}
    
    public final void run()
    {
      AppMethodBeat.i(199074);
      if (!kotlin.n.n.ba((CharSequence)this.oId)) {}
      for (int i = 1; (i != 0) && ((kotlin.g.b.p.h(this.oIc.getName(), this.oId) ^ true)); i = 0)
      {
        if (!this.oIc.setName(this.oId)) {
          Log.w("MicroMsg.BLE.PeripheralBleServer", "set BLE adapter name fail, may under wrong state! [%d]", new Object[] { Integer.valueOf(this.oIc.getState()) });
        }
        i = 0;
        while (i <= 20)
        {
          String str = this.oIc.getName();
          Log.i("MicroMsg.BLE.PeripheralBleServer", "round [%d] sys = [%s], want = [%s]", new Object[] { Integer.valueOf(i), str, this.oId });
          if (kotlin.g.b.p.h(this.oId, str)) {
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
            AppMethodBeat.o(199074);
            throw ((Throwable)localObject);
          }
        }
      }
      Object localObject = this.oIc.getBluetoothLeAdvertiser();
      if (localObject != null) {
        ((BluetoothLeAdvertiser)localObject).startAdvertising(this.oIe, this.oIf, this.oIg, n.a(this.oIb));
      }
      this.oIb.oHY.set(false);
      AppMethodBeat.o(199074);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n
 * JD-Core Version:    0.7.0.1
 */