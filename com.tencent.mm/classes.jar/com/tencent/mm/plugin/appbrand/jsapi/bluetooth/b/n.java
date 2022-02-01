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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "", "()V", "advertiseCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/bluetooth/le/AdvertiseCallback;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "setComponent", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "gattServer", "Landroid/bluetooth/BluetoothGattServer;", "getGattServer", "()Landroid/bluetooth/BluetoothGattServer;", "setGattServer", "(Landroid/bluetooth/BluetoothGattServer;)V", "gattServerCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl;", "jsCallbacks", "", "Ljava/util/UUID;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsCallback;", "Ljava/util/Timer;", "getJsCallbacks", "()Ljava/util/Map;", "serverId", "", "getServerId", "()I", "setServerId", "(I)V", "status", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "getStatus", "()Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "setStatus", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;)V", "addService", "service", "Landroid/bluetooth/BluetoothGattService;", "callback", "checkBleIsWork", "handleCharacteristicWriteAction", "serviceId", "characteristicId", "needNotify", "callbackId", "base64Value", "", "onCreate", "onDestroy", "startBLEPeripheralAdvertising", "settings", "Landroid/bluetooth/le/AdvertiseSettings;", "advertiseData", "Landroid/bluetooth/le/AdvertiseData;", "scanResponse", "deviceName", "adapter", "Landroid/bluetooth/BluetoothAdapter;", "advertiser", "Landroid/bluetooth/le/BluetoothLeAdvertiser;", "advertiseCallback", "stopBLEPeripheralAdvertising", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n.a rLI;
  int qim;
  p rLJ;
  public BluetoothGattServer rLK;
  private final CopyOnWriteArrayList<AdvertiseCallback> rLL;
  final Map<UUID, r<kotlin.g.a.b<Boolean, ah>, Timer>> rLM;
  private b rLN;
  public f rot;
  
  static
  {
    AppMethodBeat.i(144781);
    rLI = new n.a((byte)0);
    AppMethodBeat.o(144781);
  }
  
  public n()
  {
    AppMethodBeat.i(144780);
    this.rLJ = p.rLU;
    this.qim = -1;
    this.rLL = new CopyOnWriteArrayList();
    this.rLM = ((Map)new HashMap());
    AppMethodBeat.o(144780);
  }
  
  public final void a(BluetoothAdapter paramBluetoothAdapter)
  {
    AppMethodBeat.i(183549);
    s.u(paramBluetoothAdapter, "adapter");
    paramBluetoothAdapter = paramBluetoothAdapter.getBluetoothLeAdvertiser();
    if (paramBluetoothAdapter == null)
    {
      AppMethodBeat.o(183549);
      return;
    }
    Object localObject = new ArrayList();
    Iterator localIterator = ((Iterable)this.rLL).iterator();
    while (localIterator.hasNext())
    {
      AdvertiseCallback localAdvertiseCallback = (AdvertiseCallback)localIterator.next();
      paramBluetoothAdapter.stopAdvertising(localAdvertiseCallback);
      ((ArrayList)localObject).add(localAdvertiseCallback);
    }
    paramBluetoothAdapter = ((Iterable)localObject).iterator();
    while (paramBluetoothAdapter.hasNext())
    {
      localObject = (AdvertiseCallback)paramBluetoothAdapter.next();
      this.rLL.remove(localObject);
    }
    AppMethodBeat.o(183549);
  }
  
  public final void a(AdvertiseSettings paramAdvertiseSettings, AdvertiseData paramAdvertiseData1, AdvertiseData paramAdvertiseData2, String paramString, BluetoothAdapter paramBluetoothAdapter, BluetoothLeAdvertiser paramBluetoothLeAdvertiser, AdvertiseCallback paramAdvertiseCallback)
  {
    AppMethodBeat.i(329671);
    s.u(paramAdvertiseSettings, "settings");
    s.u(paramAdvertiseData1, "advertiseData");
    s.u(paramAdvertiseData2, "scanResponse");
    s.u(paramString, "deviceName");
    s.u(paramBluetoothAdapter, "adapter");
    s.u(paramBluetoothLeAdvertiser, "advertiser");
    s.u(paramAdvertiseCallback, "advertiseCallback");
    this.rLL.add(paramAdvertiseCallback);
    if (!kotlin.n.n.bp((CharSequence)paramString))
    {
      i = 1;
      if ((i != 0) && (!s.p(paramBluetoothAdapter.getName(), paramString))) {
        if (!paramBluetoothAdapter.setName(paramString)) {
          Log.w("MicroMsg.BLE.PeripheralBleServer", "set BLE adapter name fail, may under wrong state! [%d]", new Object[] { Integer.valueOf(paramBluetoothAdapter.getState()) });
        }
      }
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      String str = paramBluetoothAdapter.getName();
      Log.i("MicroMsg.BLE.PeripheralBleServer", "round [%d] sys = [%s], want = [%s]", new Object[] { Integer.valueOf(i), str, paramString });
      if (!s.p(paramString, str)) {}
      try
      {
        Thread.sleep(50L);
        if (j <= 20) {
          continue;
        }
        paramBluetoothLeAdvertiser.startAdvertising(paramAdvertiseSettings, paramAdvertiseData1, paramAdvertiseData2, paramAdvertiseCallback);
        AppMethodBeat.o(329671);
        return;
      }
      catch (InterruptedException paramAdvertiseSettings)
      {
        AppMethodBeat.o(329671);
        throw paramAdvertiseSettings;
      }
      i = 0;
      break;
    }
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(144774);
    s.u(paramp, "<set-?>");
    this.rLJ = paramp;
    AppMethodBeat.o(144774);
  }
  
  public final void a(UUID paramUUID1, UUID paramUUID2, boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(144779);
    s.u(paramUUID1, "serviceId");
    s.u(paramUUID2, "characteristicId");
    s.u(paramString, "base64Value");
    paramUUID1 = cqU().getService(paramUUID1);
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
      paramUUID2 = this.rLN;
      s.checkNotNull(paramUUID2);
      paramUUID2 = ((Iterable)paramUUID2.rLk).iterator();
      while (paramUUID2.hasNext())
      {
        paramString = (BluetoothDevice)paramUUID2.next();
        Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(cqU().notifyCharacteristicChanged(paramString, paramUUID1, false)) });
      }
    }
    paramUUID2 = this.rLN;
    s.checkNotNull(paramUUID2);
    paramUUID2 = ((Iterable)paramUUID2.rLk).iterator();
    while (paramUUID2.hasNext())
    {
      paramString = (BluetoothDevice)paramUUID2.next();
      Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(cqU().notifyCharacteristicChanged(paramString, paramUUID1, true)) });
    }
    paramUUID2 = this.rLN;
    s.checkNotNull(paramUUID2);
    paramUUID2 = (m)paramUUID2.rLl.get(Integer.valueOf(paramInt));
    if (paramUUID2 == null)
    {
      Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: #" + paramInt + " callbackId -> pendingResp is null");
      AppMethodBeat.o(144779);
      return;
    }
    Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: device = %s, requestId = %s", new Object[] { paramUUID2.rLH.toString(), String.valueOf(paramUUID2.requestId) });
    if (!cqU().sendResponse(paramUUID2.rLH, paramUUID2.requestId, 0, paramUUID2.offset, paramUUID1.getValue())) {
      Log.e("MicroMsg.BLE.PeripheralBleServer", "sendPendingRespFail");
    }
    paramUUID1 = this.rLN;
    s.checkNotNull(paramUUID1);
    paramUUID1.rLl.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(144779);
  }
  
  public final f aqX()
  {
    AppMethodBeat.i(144776);
    f localf = this.rot;
    if (localf != null)
    {
      AppMethodBeat.o(144776);
      return localf;
    }
    s.bIx("component");
    AppMethodBeat.o(144776);
    return null;
  }
  
  public final void c(f paramf, int paramInt)
  {
    AppMethodBeat.i(144777);
    s.u(paramf, "component");
    BluetoothManager localBluetoothManager = c.crr();
    if (((c.crt() & true & com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.crp() & c.cru())) && (localBluetoothManager != null))
    {
      this.rLJ = p.rLV;
      setComponent(paramf);
      this.qim = paramInt;
      this.rLN = new b();
      paramf = localBluetoothManager.openGattServer(MMApplicationContext.getContext(), (BluetoothGattServerCallback)this.rLN);
      s.s(paramf, "bluetoothManager.openGat…xt(), gattServerCallback)");
      s.u(paramf, "<set-?>");
      this.rLK = paramf;
      paramf = this.rLN;
      s.checkNotNull(paramf);
      s.u(this, "<set-?>");
      paramf.rLm = this;
      AppMethodBeat.o(144777);
      return;
    }
    paramf = p.rLY;
    AppMethodBeat.o(144777);
  }
  
  public final BluetoothGattServer cqU()
  {
    AppMethodBeat.i(144775);
    BluetoothGattServer localBluetoothGattServer = this.rLK;
    if (localBluetoothGattServer != null)
    {
      AppMethodBeat.o(144775);
      return localBluetoothGattServer;
    }
    s.bIx("gattServer");
    AppMethodBeat.o(144775);
    return null;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(144778);
    this.rLM.clear();
    cqU().close();
    Object localObject = c.crs();
    if (localObject != null) {
      a((BluetoothAdapter)localObject);
    }
    localObject = this.rLN;
    if (localObject != null)
    {
      localObject = ((b)localObject).rLl;
      if (localObject != null) {
        ((Map)localObject).clear();
      }
    }
    this.rLN = null;
    this.rLJ = p.rLX;
    AppMethodBeat.o(144778);
  }
  
  public final void setComponent(f paramf)
  {
    AppMethodBeat.i(329664);
    s.u(paramf, "<set-?>");
    this.rot = paramf;
    AppMethodBeat.o(329664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n
 * JD-Core Version:    0.7.0.1
 */