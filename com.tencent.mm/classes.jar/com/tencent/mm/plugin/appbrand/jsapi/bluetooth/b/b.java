package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.l;
import d.n.d;
import d.o;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl;", "Landroid/bluetooth/BluetoothGattServerCallback;", "()V", "bluetoothDevices", "Ljava/util/HashSet;", "Landroid/bluetooth/BluetoothDevice;", "getBluetoothDevices", "()Ljava/util/HashSet;", "pendingWriteReqList", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PendingRespStructure;", "getPendingWriteReqList", "()Ljava/util/Map;", "server", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "getServer", "()Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "setServer", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;)V", "deviceNotExist", "", "device", "onCharacteristicReadRequest", "", "requestId", "offset", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "onCharacteristicWriteRequest", "preparedWrite", "responseNeeded", "value", "", "onConnectionStateChange", "status", "newState", "onDescriptorReadRequest", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "onDescriptorWriteRequest", "onNotificationSent", "onServiceAdded", "service", "Landroid/bluetooth/BluetoothGattService;", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class b
  extends BluetoothGattServerCallback
{
  public static final a kDw;
  final HashSet<BluetoothDevice> kDt;
  final Map<Integer, m> kDu;
  public n kDv;
  
  static
  {
    AppMethodBeat.i(144747);
    kDw = new a((byte)0);
    AppMethodBeat.o(144747);
  }
  
  public b()
  {
    AppMethodBeat.i(144746);
    this.kDt = new HashSet();
    this.kDu = ((Map)new ConcurrentHashMap());
    AppMethodBeat.o(144746);
  }
  
  private final boolean a(BluetoothDevice paramBluetoothDevice)
  {
    AppMethodBeat.i(144743);
    if (paramBluetoothDevice == null)
    {
      ad.i("MicroMsg.BLE.GattServerCallbackImpl", "deviceNotExist: device == null");
      AppMethodBeat.o(144743);
      return true;
    }
    Object localObject = (Iterable)this.kDt;
    Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((BluetoothDevice)((Iterator)localObject).next()).getAddress());
    }
    if (!((List)localCollection).contains(paramBluetoothDevice.getAddress()))
    {
      ad.i("MicroMsg.BLE.GattServerCallbackImpl", "deviceNotExist: is not contain device");
      AppMethodBeat.o(144743);
      return true;
    }
    AppMethodBeat.o(144743);
    return false;
  }
  
  public final void onCharacteristicReadRequest(BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    AppMethodBeat.i(144742);
    d.g.b.p.h(paramBluetoothGattCharacteristic, "characteristic");
    super.onCharacteristicReadRequest(paramBluetoothDevice, paramInt1, paramInt2, paramBluetoothGattCharacteristic);
    ad.i("MicroMsg.BLE.GattServerCallbackImpl", "Device tried to read characteristic: " + paramBluetoothGattCharacteristic.getUuid());
    ad.i("MicroMsg.BLE.GattServerCallbackImpl", "Value: " + Arrays.toString(paramBluetoothGattCharacteristic.getValue()));
    if (a(paramBluetoothDevice))
    {
      AppMethodBeat.o(144742);
      return;
    }
    if (paramInt2 != 0)
    {
      localObject1 = this.kDv;
      if (localObject1 == null) {
        d.g.b.p.bcb("server");
      }
      ((n)localObject1).bjj().sendResponse(paramBluetoothDevice, paramInt1, 7, paramInt2, paramBluetoothGattCharacteristic.getValue());
      AppMethodBeat.o(144742);
      return;
    }
    int i;
    do
    {
      i = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.bjv();
    } while (this.kDu.containsKey(Integer.valueOf(i)));
    ad.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicReadRequest: callbackId = %d", new Object[] { Integer.valueOf(i) });
    Object localObject1 = this.kDv;
    if (localObject1 == null) {
      d.g.b.p.bcb("server");
    }
    localObject1 = ((n)localObject1).El();
    Object localObject2 = this.kDv;
    if (localObject2 == null) {
      d.g.b.p.bcb("server");
    }
    int j = ((n)localObject2).jsi;
    localObject2 = paramBluetoothGattCharacteristic.getService();
    d.g.b.p.g(localObject2, "characteristic.service");
    localObject2 = ((BluetoothGattService)localObject2).getUuid().toString();
    d.g.b.p.g(localObject2, "characteristic.service.uuid.toString()");
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString();
    d.g.b.p.g(paramBluetoothGattCharacteristic, "characteristic.uuid.toString()");
    if (a.a((c)localObject1, j, (String)localObject2, paramBluetoothGattCharacteristic, i))
    {
      if (paramBluetoothDevice == null) {
        d.g.b.p.gfZ();
      }
      paramBluetoothDevice = new m(paramBluetoothDevice, paramInt1, paramInt2);
      paramBluetoothDevice = (m)this.kDu.put(Integer.valueOf(i), paramBluetoothDevice);
      ad.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicReadRequest: pendingWriteReqList ret = " + paramBluetoothDevice + " id = " + i);
    }
    AppMethodBeat.o(144742);
  }
  
  public final void onCharacteristicWriteRequest(BluetoothDevice paramBluetoothDevice, int paramInt1, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144741);
    d.g.b.p.h(paramBluetoothDevice, "device");
    d.g.b.p.h(paramBluetoothGattCharacteristic, "characteristic");
    d.g.b.p.h(paramArrayOfByte, "value");
    super.onCharacteristicWriteRequest(paramBluetoothDevice, paramInt1, paramBluetoothGattCharacteristic, paramBoolean1, paramBoolean2, paramInt2, paramArrayOfByte);
    Object localObject1 = new StringBuilder("Characteristic Write request: ");
    Object localObject2 = Arrays.toString(paramArrayOfByte);
    d.g.b.p.g(localObject2, "java.util.Arrays.toString(this)");
    ad.v("MicroMsg.BLE.GattServerCallbackImpl", (String)localObject2);
    if (a(paramBluetoothDevice))
    {
      AppMethodBeat.o(144741);
      return;
    }
    if (paramInt2 != 0)
    {
      paramArrayOfByte = this.kDv;
      if (paramArrayOfByte == null) {
        d.g.b.p.bcb("server");
      }
      paramArrayOfByte.bjj().sendResponse(paramBluetoothDevice, paramInt1, 7, paramInt2, paramBluetoothGattCharacteristic.getValue());
      AppMethodBeat.o(144741);
      return;
    }
    int i;
    do
    {
      i = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.bjv();
    } while (this.kDu.containsKey(Integer.valueOf(i)));
    ad.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicWriteRequest: callbackId = %d", new Object[] { Integer.valueOf(i) });
    paramArrayOfByte = Base64.encode(paramArrayOfByte, 2);
    localObject1 = this.kDv;
    if (localObject1 == null) {
      d.g.b.p.bcb("server");
    }
    localObject1 = ((n)localObject1).El();
    localObject2 = this.kDv;
    if (localObject2 == null) {
      d.g.b.p.bcb("server");
    }
    int j = ((n)localObject2).jsi;
    localObject2 = paramBluetoothGattCharacteristic.getService();
    d.g.b.p.g(localObject2, "characteristic.service");
    localObject2 = ((BluetoothGattService)localObject2).getUuid().toString();
    d.g.b.p.g(localObject2, "characteristic.service.uuid.toString()");
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString();
    d.g.b.p.g(paramBluetoothGattCharacteristic, "characteristic.uuid.toString()");
    d.g.b.p.g(paramArrayOfByte, "base64Value");
    if (a.a((c)localObject1, j, (String)localObject2, paramBluetoothGattCharacteristic, i, new String(paramArrayOfByte, d.UTF_8)))
    {
      paramBluetoothDevice = new m(paramBluetoothDevice, paramInt1, paramInt2);
      paramBluetoothDevice = (m)this.kDu.put(Integer.valueOf(i), paramBluetoothDevice);
      ad.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicWriteRequest: pendingWriteReqList res = " + paramBluetoothDevice + ", id = " + i);
    }
    AppMethodBeat.o(144741);
  }
  
  public final void onConnectionStateChange(BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144744);
    d.g.b.p.h(paramBluetoothDevice, "device");
    super.onConnectionStateChange(paramBluetoothDevice, paramInt1, paramInt2);
    if (paramInt1 == 0)
    {
      Object localObject1;
      Object localObject2;
      if (paramInt2 == 2)
      {
        this.kDt.add(paramBluetoothDevice);
        localObject1 = this.kDv;
        if (localObject1 == null) {
          d.g.b.p.bcb("server");
        }
        localObject1 = ((n)localObject1).El();
        localObject2 = paramBluetoothDevice.getAddress();
        d.g.b.p.g(localObject2, "device.address");
        n localn = this.kDv;
        if (localn == null) {
          d.g.b.p.bcb("server");
        }
        a.a((c)localObject1, (String)localObject2, String.valueOf(localn.jsi), true);
        localObject1 = this.kDv;
        if (localObject1 == null) {
          d.g.b.p.bcb("server");
        }
        ((n)localObject1).a(p.kEi);
        ad.v("MicroMsg.BLE.GattServerCallbackImpl", "Connected to device: " + paramBluetoothDevice.getAddress());
        AppMethodBeat.o(144744);
        return;
      }
      if (paramInt2 == 0)
      {
        this.kDt.remove(paramBluetoothDevice);
        localObject1 = this.kDv;
        if (localObject1 == null) {
          d.g.b.p.bcb("server");
        }
        localObject1 = ((n)localObject1).El();
        paramBluetoothDevice = paramBluetoothDevice.getAddress();
        d.g.b.p.g(paramBluetoothDevice, "device.address");
        localObject2 = this.kDv;
        if (localObject2 == null) {
          d.g.b.p.bcb("server");
        }
        a.a((c)localObject1, paramBluetoothDevice, String.valueOf(((n)localObject2).jsi), false);
        paramBluetoothDevice = this.kDv;
        if (paramBluetoothDevice == null) {
          d.g.b.p.bcb("server");
        }
        paramBluetoothDevice.a(p.kEh);
        ad.v("MicroMsg.BLE.GattServerCallbackImpl", "Disconnected from device");
      }
      AppMethodBeat.o(144744);
      return;
    }
    this.kDt.remove(paramBluetoothDevice);
    ad.e("MicroMsg.BLE.GattServerCallbackImpl", "Error when connecting: ".concat(String.valueOf(paramInt1)));
    AppMethodBeat.o(144744);
  }
  
  public final void onDescriptorReadRequest(BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2, BluetoothGattDescriptor paramBluetoothGattDescriptor)
  {
    AppMethodBeat.i(144738);
    d.g.b.p.h(paramBluetoothGattDescriptor, "descriptor");
    super.onDescriptorReadRequest(paramBluetoothDevice, paramInt1, paramInt2, paramBluetoothGattDescriptor);
    ad.i("MicroMsg.BLE.GattServerCallbackImpl", "Device tried to read descriptor: " + paramBluetoothGattDescriptor.getUuid());
    ad.i("MicroMsg.BLE.GattServerCallbackImpl", "Value: " + Arrays.toString(paramBluetoothGattDescriptor.getValue()));
    if (paramInt2 != 0)
    {
      paramBluetoothGattDescriptor = this.kDv;
      if (paramBluetoothGattDescriptor == null) {
        d.g.b.p.bcb("server");
      }
      paramBluetoothGattDescriptor.bjj().sendResponse(paramBluetoothDevice, paramInt1, 7, paramInt2, null);
      AppMethodBeat.o(144738);
      return;
    }
    n localn = this.kDv;
    if (localn == null) {
      d.g.b.p.bcb("server");
    }
    localn.bjj().sendResponse(paramBluetoothDevice, paramInt1, 0, paramInt2, paramBluetoothGattDescriptor.getValue());
    AppMethodBeat.o(144738);
  }
  
  public final void onDescriptorWriteRequest(BluetoothDevice paramBluetoothDevice, int paramInt1, BluetoothGattDescriptor paramBluetoothGattDescriptor, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144745);
    d.g.b.p.h(paramBluetoothGattDescriptor, "descriptor");
    d.g.b.p.h(paramArrayOfByte, "value");
    super.onDescriptorWriteRequest(paramBluetoothDevice, paramInt1, paramBluetoothGattDescriptor, paramBoolean1, paramBoolean2, paramInt2, paramArrayOfByte);
    ad.v("MicroMsg.BLE.GattServerCallbackImpl", "Descriptor Write Request " + paramBluetoothGattDescriptor.getUuid() + " " + Arrays.toString(paramArrayOfByte));
    if (paramBoolean2)
    {
      paramBluetoothGattDescriptor = this.kDv;
      if (paramBluetoothGattDescriptor == null) {
        d.g.b.p.bcb("server");
      }
      paramBluetoothGattDescriptor.bjj().sendResponse(paramBluetoothDevice, paramInt1, 0, 0, null);
    }
    AppMethodBeat.o(144745);
  }
  
  public final void onNotificationSent(BluetoothDevice paramBluetoothDevice, int paramInt)
  {
    AppMethodBeat.i(144739);
    super.onNotificationSent(paramBluetoothDevice, paramInt);
    ad.v("MicroMsg.BLE.GattServerCallbackImpl", "Notification sent. Status: ".concat(String.valueOf(paramInt)));
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
    ad.i("MicroMsg.BLE.GattServerCallbackImpl", "onServiceAdded: " + paramBluetoothGattService.getUuid());
    Object localObject = this.kDv;
    if (localObject == null) {
      d.g.b.p.bcb("server");
    }
    localObject = (o)((n)localObject).kDQ.get(paramBluetoothGattService.getUuid());
    if (localObject != null)
    {
      localObject = (Timer)((o)localObject).second;
      if (localObject != null) {
        ((Timer)localObject).cancel();
      }
    }
    localObject = this.kDv;
    if (localObject == null) {
      d.g.b.p.bcb("server");
    }
    localObject = (o)((n)localObject).kDQ.get(paramBluetoothGattService.getUuid());
    if (localObject != null)
    {
      localObject = (d.g.a.b)((o)localObject).first;
      if (localObject != null) {
        ((d.g.a.b)localObject).invoke(Boolean.TRUE);
      }
    }
    localObject = this.kDv;
    if (localObject == null) {
      d.g.b.p.bcb("server");
    }
    ((n)localObject).kDQ.remove(paramBluetoothGattService.getUuid());
    AppMethodBeat.o(144740);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl$Companion;", "", "()V", "TAG", "", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.b
 * JD-Core Version:    0.7.0.1
 */