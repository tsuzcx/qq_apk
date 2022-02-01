package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl;", "Landroid/bluetooth/BluetoothGattServerCallback;", "()V", "bluetoothDevices", "Ljava/util/HashSet;", "Landroid/bluetooth/BluetoothDevice;", "getBluetoothDevices", "()Ljava/util/HashSet;", "pendingWriteReqList", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PendingRespStructure;", "getPendingWriteReqList", "()Ljava/util/Map;", "server", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "getServer", "()Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "setServer", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;)V", "deviceNotExist", "", "device", "onCharacteristicReadRequest", "", "requestId", "offset", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "onCharacteristicWriteRequest", "preparedWrite", "responseNeeded", "value", "", "onConnectionStateChange", "status", "newState", "onDescriptorReadRequest", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "onDescriptorWriteRequest", "onNotificationSent", "onServiceAdded", "service", "Landroid/bluetooth/BluetoothGattService;", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends BluetoothGattServerCallback
{
  public static final b.a rLj;
  final HashSet<BluetoothDevice> rLk;
  final Map<Integer, m> rLl;
  public n rLm;
  
  static
  {
    AppMethodBeat.i(144747);
    rLj = new b.a((byte)0);
    AppMethodBeat.o(144747);
  }
  
  public b()
  {
    AppMethodBeat.i(144746);
    this.rLk = new HashSet();
    this.rLl = ((Map)new ConcurrentHashMap());
    AppMethodBeat.o(144746);
  }
  
  private final boolean a(BluetoothDevice paramBluetoothDevice)
  {
    AppMethodBeat.i(144743);
    if (paramBluetoothDevice == null)
    {
      Log.i("MicroMsg.BLE.GattServerCallbackImpl", "deviceNotExist: device == null");
      AppMethodBeat.o(144743);
      return true;
    }
    Object localObject = (Iterable)this.rLk;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((BluetoothDevice)((Iterator)localObject).next()).getAddress());
    }
    if (!((List)localCollection).contains(paramBluetoothDevice.getAddress()))
    {
      Log.i("MicroMsg.BLE.GattServerCallbackImpl", "deviceNotExist: is not contain device");
      AppMethodBeat.o(144743);
      return true;
    }
    AppMethodBeat.o(144743);
    return false;
  }
  
  private n cqT()
  {
    AppMethodBeat.i(329649);
    n localn = this.rLm;
    if (localn != null)
    {
      AppMethodBeat.o(329649);
      return localn;
    }
    s.bIx("server");
    AppMethodBeat.o(329649);
    return null;
  }
  
  public final void onCharacteristicReadRequest(BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    AppMethodBeat.i(144742);
    s.u(paramBluetoothGattCharacteristic, "characteristic");
    super.onCharacteristicReadRequest(paramBluetoothDevice, paramInt1, paramInt2, paramBluetoothGattCharacteristic);
    Log.i("MicroMsg.BLE.GattServerCallbackImpl", s.X("Device tried to read characteristic: ", paramBluetoothGattCharacteristic.getUuid()));
    Log.i("MicroMsg.BLE.GattServerCallbackImpl", s.X("Value: ", Arrays.toString(paramBluetoothGattCharacteristic.getValue())));
    if (a(paramBluetoothDevice))
    {
      AppMethodBeat.o(144742);
      return;
    }
    if (paramInt2 != 0)
    {
      cqT().cqU().sendResponse(paramBluetoothDevice, paramInt1, 7, paramInt2, paramBluetoothGattCharacteristic.getValue());
      AppMethodBeat.o(144742);
      return;
    }
    int i;
    do
    {
      i = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.crq();
    } while (this.rLl.containsKey(Integer.valueOf(i)));
    Log.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicReadRequest: callbackId = %d", new Object[] { Integer.valueOf(i) });
    f localf = cqT().aqX();
    int j = cqT().qim;
    String str = paramBluetoothGattCharacteristic.getService().getUuid().toString();
    s.s(str, "characteristic.service.uuid.toString()");
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString();
    s.s(paramBluetoothGattCharacteristic, "characteristic.uuid.toString()");
    if (a.a(localf, j, str, paramBluetoothGattCharacteristic, i))
    {
      s.checkNotNull(paramBluetoothDevice);
      paramBluetoothDevice = new m(paramBluetoothDevice, paramInt1, paramInt2);
      paramBluetoothDevice = (m)this.rLl.put(Integer.valueOf(i), paramBluetoothDevice);
      Log.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicReadRequest: pendingWriteReqList ret = " + paramBluetoothDevice + " id = " + i);
    }
    AppMethodBeat.o(144742);
  }
  
  public final void onCharacteristicWriteRequest(BluetoothDevice paramBluetoothDevice, int paramInt1, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144741);
    s.u(paramBluetoothDevice, "device");
    s.u(paramBluetoothGattCharacteristic, "characteristic");
    s.u(paramArrayOfByte, "value");
    super.onCharacteristicWriteRequest(paramBluetoothDevice, paramInt1, paramBluetoothGattCharacteristic, paramBoolean1, paramBoolean2, paramInt2, paramArrayOfByte);
    Object localObject = Arrays.toString(paramArrayOfByte);
    s.s(localObject, "java.util.Arrays.toString(this)");
    Log.v("MicroMsg.BLE.GattServerCallbackImpl", s.X("Characteristic Write request: ", localObject));
    if (a(paramBluetoothDevice))
    {
      AppMethodBeat.o(144741);
      return;
    }
    if (paramInt2 != 0)
    {
      cqT().cqU().sendResponse(paramBluetoothDevice, paramInt1, 7, paramInt2, paramBluetoothGattCharacteristic.getValue());
      AppMethodBeat.o(144741);
      return;
    }
    int i;
    do
    {
      i = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.crq();
    } while (this.rLl.containsKey(Integer.valueOf(i)));
    Log.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicWriteRequest: callbackId = %d", new Object[] { Integer.valueOf(i) });
    paramArrayOfByte = Base64.encode(paramArrayOfByte, 2);
    localObject = cqT().aqX();
    int j = cqT().qim;
    String str = paramBluetoothGattCharacteristic.getService().getUuid().toString();
    s.s(str, "characteristic.service.uuid.toString()");
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString();
    s.s(paramBluetoothGattCharacteristic, "characteristic.uuid.toString()");
    s.s(paramArrayOfByte, "base64Value");
    if (a.a((f)localObject, j, str, paramBluetoothGattCharacteristic, i, new String(paramArrayOfByte, d.UTF_8)))
    {
      paramBluetoothDevice = new m(paramBluetoothDevice, paramInt1, paramInt2);
      paramBluetoothDevice = (m)this.rLl.put(Integer.valueOf(i), paramBluetoothDevice);
      Log.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicWriteRequest: pendingWriteReqList res = " + paramBluetoothDevice + ", id = " + i);
    }
    AppMethodBeat.o(144741);
  }
  
  public final void onConnectionStateChange(BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144744);
    s.u(paramBluetoothDevice, "device");
    super.onConnectionStateChange(paramBluetoothDevice, paramInt1, paramInt2);
    if (paramInt1 == 0)
    {
      switch (paramInt2)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(144744);
        return;
        this.rLk.add(paramBluetoothDevice);
        f localf = cqT().aqX();
        String str = paramBluetoothDevice.getAddress();
        s.s(str, "device.address");
        a.a(localf, str, String.valueOf(cqT().qim), true);
        cqT().a(p.rLW);
        Log.v("MicroMsg.BLE.GattServerCallbackImpl", s.X("Connected to device: ", paramBluetoothDevice.getAddress()));
        AppMethodBeat.o(144744);
        return;
        this.rLk.remove(paramBluetoothDevice);
        localf = cqT().aqX();
        paramBluetoothDevice = paramBluetoothDevice.getAddress();
        s.s(paramBluetoothDevice, "device.address");
        a.a(localf, paramBluetoothDevice, String.valueOf(cqT().qim), false);
        cqT().a(p.rLV);
        Log.v("MicroMsg.BLE.GattServerCallbackImpl", "Disconnected from device");
      }
    }
    this.rLk.remove(paramBluetoothDevice);
    Log.e("MicroMsg.BLE.GattServerCallbackImpl", s.X("Error when connecting: ", Integer.valueOf(paramInt1)));
    AppMethodBeat.o(144744);
  }
  
  public final void onDescriptorReadRequest(BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2, BluetoothGattDescriptor paramBluetoothGattDescriptor)
  {
    AppMethodBeat.i(144738);
    s.u(paramBluetoothGattDescriptor, "descriptor");
    super.onDescriptorReadRequest(paramBluetoothDevice, paramInt1, paramInt2, paramBluetoothGattDescriptor);
    Log.i("MicroMsg.BLE.GattServerCallbackImpl", s.X("Device tried to read descriptor: ", paramBluetoothGattDescriptor.getUuid()));
    Log.i("MicroMsg.BLE.GattServerCallbackImpl", s.X("Value: ", Arrays.toString(paramBluetoothGattDescriptor.getValue())));
    if (paramInt2 != 0)
    {
      cqT().cqU().sendResponse(paramBluetoothDevice, paramInt1, 7, paramInt2, null);
      AppMethodBeat.o(144738);
      return;
    }
    cqT().cqU().sendResponse(paramBluetoothDevice, paramInt1, 0, paramInt2, paramBluetoothGattDescriptor.getValue());
    AppMethodBeat.o(144738);
  }
  
  public final void onDescriptorWriteRequest(BluetoothDevice paramBluetoothDevice, int paramInt1, BluetoothGattDescriptor paramBluetoothGattDescriptor, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144745);
    s.u(paramBluetoothGattDescriptor, "descriptor");
    s.u(paramArrayOfByte, "value");
    super.onDescriptorWriteRequest(paramBluetoothDevice, paramInt1, paramBluetoothGattDescriptor, paramBoolean1, paramBoolean2, paramInt2, paramArrayOfByte);
    Log.v("MicroMsg.BLE.GattServerCallbackImpl", "Descriptor Write Request " + paramBluetoothGattDescriptor.getUuid() + ' ' + Arrays.toString(paramArrayOfByte));
    if (paramBoolean2) {
      cqT().cqU().sendResponse(paramBluetoothDevice, paramInt1, 0, 0, null);
    }
    AppMethodBeat.o(144745);
  }
  
  public final void onNotificationSent(BluetoothDevice paramBluetoothDevice, int paramInt)
  {
    AppMethodBeat.i(144739);
    super.onNotificationSent(paramBluetoothDevice, paramInt);
    Log.v("MicroMsg.BLE.GattServerCallbackImpl", s.X("Notification sent. Status: ", Integer.valueOf(paramInt)));
    AppMethodBeat.o(144739);
  }
  
  public final void onServiceAdded(int paramInt, BluetoothGattService paramBluetoothGattService)
  {
    AppMethodBeat.i(144740);
    super.onServiceAdded(paramInt, paramBluetoothGattService);
    if (paramBluetoothGattService == null)
    {
      AppMethodBeat.o(144740);
      return;
    }
    Log.i("MicroMsg.BLE.GattServerCallbackImpl", s.X("onServiceAdded: ", paramBluetoothGattService.getUuid()));
    Object localObject = (r)cqT().rLM.get(paramBluetoothGattService.getUuid());
    if (localObject != null)
    {
      localObject = (Timer)((r)localObject).bsD;
      if (localObject != null) {
        ((Timer)localObject).cancel();
      }
    }
    localObject = (r)cqT().rLM.get(paramBluetoothGattService.getUuid());
    if (localObject != null)
    {
      localObject = (kotlin.g.a.b)((r)localObject).bsC;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(Boolean.TRUE);
      }
    }
    cqT().rLM.remove(paramBluetoothGattService.getUuid());
    AppMethodBeat.o(144740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.b
 * JD-Core Version:    0.7.0.1
 */