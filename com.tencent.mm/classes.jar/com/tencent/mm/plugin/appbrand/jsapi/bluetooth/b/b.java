package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
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
import kotlin.a.j;
import kotlin.l;
import kotlin.n.d;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl;", "Landroid/bluetooth/BluetoothGattServerCallback;", "()V", "bluetoothDevices", "Ljava/util/HashSet;", "Landroid/bluetooth/BluetoothDevice;", "getBluetoothDevices", "()Ljava/util/HashSet;", "pendingWriteReqList", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PendingRespStructure;", "getPendingWriteReqList", "()Ljava/util/Map;", "server", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "getServer", "()Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "setServer", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;)V", "deviceNotExist", "", "device", "onCharacteristicReadRequest", "", "requestId", "offset", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "onCharacteristicWriteRequest", "preparedWrite", "responseNeeded", "value", "", "onConnectionStateChange", "status", "newState", "onDescriptorReadRequest", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "onDescriptorWriteRequest", "onNotificationSent", "onServiceAdded", "service", "Landroid/bluetooth/BluetoothGattService;", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class b
  extends BluetoothGattServerCallback
{
  public static final b.a oHB;
  public n oHA;
  final HashSet<BluetoothDevice> oHy;
  final Map<Integer, m> oHz;
  
  static
  {
    AppMethodBeat.i(144747);
    oHB = new b.a((byte)0);
    AppMethodBeat.o(144747);
  }
  
  public b()
  {
    AppMethodBeat.i(144746);
    this.oHy = new HashSet();
    this.oHz = ((Map)new ConcurrentHashMap());
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
    Object localObject = (Iterable)this.oHy;
    Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
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
  
  public final void onCharacteristicReadRequest(BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    AppMethodBeat.i(144742);
    kotlin.g.b.p.k(paramBluetoothGattCharacteristic, "characteristic");
    super.onCharacteristicReadRequest(paramBluetoothDevice, paramInt1, paramInt2, paramBluetoothGattCharacteristic);
    Log.i("MicroMsg.BLE.GattServerCallbackImpl", "Device tried to read characteristic: " + paramBluetoothGattCharacteristic.getUuid());
    Log.i("MicroMsg.BLE.GattServerCallbackImpl", "Value: " + Arrays.toString(paramBluetoothGattCharacteristic.getValue()));
    if (a(paramBluetoothDevice))
    {
      AppMethodBeat.o(144742);
      return;
    }
    if (paramInt2 != 0)
    {
      localObject1 = this.oHA;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("server");
      }
      ((n)localObject1).bQM().sendResponse(paramBluetoothDevice, paramInt1, 7, paramInt2, paramBluetoothGattCharacteristic.getValue());
      AppMethodBeat.o(144742);
      return;
    }
    int i;
    do
    {
      i = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.bRi();
    } while (this.oHz.containsKey(Integer.valueOf(i)));
    Log.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicReadRequest: callbackId = %d", new Object[] { Integer.valueOf(i) });
    Object localObject1 = this.oHA;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("server");
    }
    localObject1 = ((n)localObject1).QK();
    Object localObject2 = this.oHA;
    if (localObject2 == null) {
      kotlin.g.b.p.bGy("server");
    }
    int j = ((n)localObject2).nld;
    localObject2 = paramBluetoothGattCharacteristic.getService();
    kotlin.g.b.p.j(localObject2, "characteristic.service");
    localObject2 = ((BluetoothGattService)localObject2).getUuid().toString();
    kotlin.g.b.p.j(localObject2, "characteristic.service.uuid.toString()");
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString();
    kotlin.g.b.p.j(paramBluetoothGattCharacteristic, "characteristic.uuid.toString()");
    if (a.a((e)localObject1, j, (String)localObject2, paramBluetoothGattCharacteristic, i))
    {
      if (paramBluetoothDevice == null) {
        kotlin.g.b.p.iCn();
      }
      paramBluetoothDevice = new m(paramBluetoothDevice, paramInt1, paramInt2);
      paramBluetoothDevice = (m)this.oHz.put(Integer.valueOf(i), paramBluetoothDevice);
      Log.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicReadRequest: pendingWriteReqList ret = " + paramBluetoothDevice + " id = " + i);
    }
    AppMethodBeat.o(144742);
  }
  
  public final void onCharacteristicWriteRequest(BluetoothDevice paramBluetoothDevice, int paramInt1, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144741);
    kotlin.g.b.p.k(paramBluetoothDevice, "device");
    kotlin.g.b.p.k(paramBluetoothGattCharacteristic, "characteristic");
    kotlin.g.b.p.k(paramArrayOfByte, "value");
    super.onCharacteristicWriteRequest(paramBluetoothDevice, paramInt1, paramBluetoothGattCharacteristic, paramBoolean1, paramBoolean2, paramInt2, paramArrayOfByte);
    Object localObject1 = new StringBuilder("Characteristic Write request: ");
    Object localObject2 = Arrays.toString(paramArrayOfByte);
    kotlin.g.b.p.j(localObject2, "java.util.Arrays.toString(this)");
    Log.v("MicroMsg.BLE.GattServerCallbackImpl", (String)localObject2);
    if (a(paramBluetoothDevice))
    {
      AppMethodBeat.o(144741);
      return;
    }
    if (paramInt2 != 0)
    {
      paramArrayOfByte = this.oHA;
      if (paramArrayOfByte == null) {
        kotlin.g.b.p.bGy("server");
      }
      paramArrayOfByte.bQM().sendResponse(paramBluetoothDevice, paramInt1, 7, paramInt2, paramBluetoothGattCharacteristic.getValue());
      AppMethodBeat.o(144741);
      return;
    }
    int i;
    do
    {
      i = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.bRi();
    } while (this.oHz.containsKey(Integer.valueOf(i)));
    Log.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicWriteRequest: callbackId = %d", new Object[] { Integer.valueOf(i) });
    paramArrayOfByte = Base64.encode(paramArrayOfByte, 2);
    localObject1 = this.oHA;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("server");
    }
    localObject1 = ((n)localObject1).QK();
    localObject2 = this.oHA;
    if (localObject2 == null) {
      kotlin.g.b.p.bGy("server");
    }
    int j = ((n)localObject2).nld;
    localObject2 = paramBluetoothGattCharacteristic.getService();
    kotlin.g.b.p.j(localObject2, "characteristic.service");
    localObject2 = ((BluetoothGattService)localObject2).getUuid().toString();
    kotlin.g.b.p.j(localObject2, "characteristic.service.uuid.toString()");
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString();
    kotlin.g.b.p.j(paramBluetoothGattCharacteristic, "characteristic.uuid.toString()");
    kotlin.g.b.p.j(paramArrayOfByte, "base64Value");
    if (a.a((e)localObject1, j, (String)localObject2, paramBluetoothGattCharacteristic, i, new String(paramArrayOfByte, d.UTF_8)))
    {
      paramBluetoothDevice = new m(paramBluetoothDevice, paramInt1, paramInt2);
      paramBluetoothDevice = (m)this.oHz.put(Integer.valueOf(i), paramBluetoothDevice);
      Log.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicWriteRequest: pendingWriteReqList res = " + paramBluetoothDevice + ", id = " + i);
    }
    AppMethodBeat.o(144741);
  }
  
  public final void onConnectionStateChange(BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144744);
    kotlin.g.b.p.k(paramBluetoothDevice, "device");
    super.onConnectionStateChange(paramBluetoothDevice, paramInt1, paramInt2);
    if (paramInt1 == 0)
    {
      Object localObject1;
      Object localObject2;
      if (paramInt2 == 2)
      {
        this.oHy.add(paramBluetoothDevice);
        localObject1 = this.oHA;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("server");
        }
        localObject1 = ((n)localObject1).QK();
        localObject2 = paramBluetoothDevice.getAddress();
        kotlin.g.b.p.j(localObject2, "device.address");
        n localn = this.oHA;
        if (localn == null) {
          kotlin.g.b.p.bGy("server");
        }
        a.a((e)localObject1, (String)localObject2, String.valueOf(localn.nld), true);
        localObject1 = this.oHA;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("server");
        }
        ((n)localObject1).a(p.oIn);
        Log.v("MicroMsg.BLE.GattServerCallbackImpl", "Connected to device: " + paramBluetoothDevice.getAddress());
        AppMethodBeat.o(144744);
        return;
      }
      if (paramInt2 == 0)
      {
        this.oHy.remove(paramBluetoothDevice);
        localObject1 = this.oHA;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("server");
        }
        localObject1 = ((n)localObject1).QK();
        paramBluetoothDevice = paramBluetoothDevice.getAddress();
        kotlin.g.b.p.j(paramBluetoothDevice, "device.address");
        localObject2 = this.oHA;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("server");
        }
        a.a((e)localObject1, paramBluetoothDevice, String.valueOf(((n)localObject2).nld), false);
        paramBluetoothDevice = this.oHA;
        if (paramBluetoothDevice == null) {
          kotlin.g.b.p.bGy("server");
        }
        paramBluetoothDevice.a(p.oIm);
        Log.v("MicroMsg.BLE.GattServerCallbackImpl", "Disconnected from device");
      }
      AppMethodBeat.o(144744);
      return;
    }
    this.oHy.remove(paramBluetoothDevice);
    Log.e("MicroMsg.BLE.GattServerCallbackImpl", "Error when connecting: ".concat(String.valueOf(paramInt1)));
    AppMethodBeat.o(144744);
  }
  
  public final void onDescriptorReadRequest(BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2, BluetoothGattDescriptor paramBluetoothGattDescriptor)
  {
    AppMethodBeat.i(144738);
    kotlin.g.b.p.k(paramBluetoothGattDescriptor, "descriptor");
    super.onDescriptorReadRequest(paramBluetoothDevice, paramInt1, paramInt2, paramBluetoothGattDescriptor);
    Log.i("MicroMsg.BLE.GattServerCallbackImpl", "Device tried to read descriptor: " + paramBluetoothGattDescriptor.getUuid());
    Log.i("MicroMsg.BLE.GattServerCallbackImpl", "Value: " + Arrays.toString(paramBluetoothGattDescriptor.getValue()));
    if (paramInt2 != 0)
    {
      paramBluetoothGattDescriptor = this.oHA;
      if (paramBluetoothGattDescriptor == null) {
        kotlin.g.b.p.bGy("server");
      }
      paramBluetoothGattDescriptor.bQM().sendResponse(paramBluetoothDevice, paramInt1, 7, paramInt2, null);
      AppMethodBeat.o(144738);
      return;
    }
    n localn = this.oHA;
    if (localn == null) {
      kotlin.g.b.p.bGy("server");
    }
    localn.bQM().sendResponse(paramBluetoothDevice, paramInt1, 0, paramInt2, paramBluetoothGattDescriptor.getValue());
    AppMethodBeat.o(144738);
  }
  
  public final void onDescriptorWriteRequest(BluetoothDevice paramBluetoothDevice, int paramInt1, BluetoothGattDescriptor paramBluetoothGattDescriptor, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144745);
    kotlin.g.b.p.k(paramBluetoothGattDescriptor, "descriptor");
    kotlin.g.b.p.k(paramArrayOfByte, "value");
    super.onDescriptorWriteRequest(paramBluetoothDevice, paramInt1, paramBluetoothGattDescriptor, paramBoolean1, paramBoolean2, paramInt2, paramArrayOfByte);
    Log.v("MicroMsg.BLE.GattServerCallbackImpl", "Descriptor Write Request " + paramBluetoothGattDescriptor.getUuid() + " " + Arrays.toString(paramArrayOfByte));
    if (paramBoolean2)
    {
      paramBluetoothGattDescriptor = this.oHA;
      if (paramBluetoothGattDescriptor == null) {
        kotlin.g.b.p.bGy("server");
      }
      paramBluetoothGattDescriptor.bQM().sendResponse(paramBluetoothDevice, paramInt1, 0, 0, null);
    }
    AppMethodBeat.o(144745);
  }
  
  public final void onNotificationSent(BluetoothDevice paramBluetoothDevice, int paramInt)
  {
    AppMethodBeat.i(144739);
    super.onNotificationSent(paramBluetoothDevice, paramInt);
    Log.v("MicroMsg.BLE.GattServerCallbackImpl", "Notification sent. Status: ".concat(String.valueOf(paramInt)));
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
    Log.i("MicroMsg.BLE.GattServerCallbackImpl", "onServiceAdded: " + paramBluetoothGattService.getUuid());
    Object localObject = this.oHA;
    if (localObject == null) {
      kotlin.g.b.p.bGy("server");
    }
    localObject = (o)((n)localObject).oHV.get(paramBluetoothGattService.getUuid());
    if (localObject != null)
    {
      localObject = (Timer)((o)localObject).My;
      if (localObject != null) {
        ((Timer)localObject).cancel();
      }
    }
    localObject = this.oHA;
    if (localObject == null) {
      kotlin.g.b.p.bGy("server");
    }
    localObject = (o)((n)localObject).oHV.get(paramBluetoothGattService.getUuid());
    if (localObject != null)
    {
      localObject = (kotlin.g.a.b)((o)localObject).Mx;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(Boolean.TRUE);
      }
    }
    localObject = this.oHA;
    if (localObject == null) {
      kotlin.g.b.p.bGy("server");
    }
    ((n)localObject).oHV.remove(paramBluetoothGattService.getUuid());
    AppMethodBeat.o(144740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.b
 * JD-Core Version:    0.7.0.1
 */