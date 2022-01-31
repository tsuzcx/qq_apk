package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.util.Base64;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@TargetApi(18)
public final class d
  implements e
{
  public String bwK;
  public Context context;
  public h gml;
  public g gmm;
  public b gmo;
  public BluetoothGatt gmp;
  public List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> gmq;
  public Map<String, List<c>> gmr;
  
  public d(Context paramContext, String paramString)
  {
    this.context = paramContext;
    this.bwK = paramString;
  }
  
  private void ac(String paramString, boolean paramBoolean)
  {
    if (this.gml != null) {
      this.gml.ab(paramString, paramBoolean);
    }
  }
  
  public final void da(boolean paramBoolean)
  {
    try
    {
      if (this.gmp != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "deviceId:%s closeMyself", new Object[] { this.bwK });
        if (paramBoolean) {
          ac(this.bwK, false);
        }
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.glN.glZ) {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.gmp);
        }
        this.gmp.close();
        this.gmp = null;
      }
      return;
    }
    finally {}
  }
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    String str1;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattCharacteristic == null) {
        break label163;
      }
    }
    label163:
    for (String str2 = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();; str2 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onCharacteristicChanged]gatt deviceId:%s characteristicId:%s", new Object[] { str1, str2 });
      this.gmo.onCharacteristicChanged(paramBluetoothGatt, paramBluetoothGattCharacteristic);
      if (this.gmm != null)
      {
        str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
        paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
        str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
        paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[change]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
        this.gmm.g(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
      }
      return;
      str1 = "";
      break;
    }
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    String str1;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattCharacteristic == null) {
        break label174;
      }
    }
    label174:
    for (String str2 = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();; str2 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onCharacteristicRead]gatt deviceId:%s characteristicId:%s status:%s", new Object[] { str1, str2, f.lk(paramInt) });
      this.gmo.onCharacteristicRead(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
      if (paramInt == 0)
      {
        str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
        paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
        str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
        paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[read]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
        this.gmm.g(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
      }
      return;
      str1 = "";
      break;
    }
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    String str1;
    String str2;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattCharacteristic == null) {
        break label100;
      }
      str2 = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
      label29:
      if (paramBluetoothGattCharacteristic == null) {
        break label107;
      }
    }
    label100:
    label107:
    for (Object localObject = Arrays.asList(new byte[][] { paramBluetoothGattCharacteristic.getValue() });; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onCharacteristicWrite]gatt deviceId:%s characteristicId:%s value:%s, status:%s", new Object[] { str1, str2, localObject, f.lk(paramInt) });
      this.gmo.onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
      return;
      str1 = "";
      break;
      str2 = "";
      break label29;
    }
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    String str1;
    String str3;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      str3 = f.lk(paramInt1);
      if (paramInt2 != 2) {
        break label90;
      }
    }
    label90:
    for (String str2 = "CONNECTED";; str2 = "DISCONNECTED")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onConnectionStateChange]gatt deviceId:%s gattStatus:%s, newState:%s", new Object[] { str1, str3, str2 });
      this.gmo.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
      if ((paramInt1 != 0) || ((paramInt2 != 2) && (paramInt2 == 0))) {
        da(true);
      }
      return;
      str1 = "";
      break;
    }
  }
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    String str1;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattDescriptor == null) {
        break label68;
      }
    }
    label68:
    for (String str2 = paramBluetoothGattDescriptor.getUuid().toString().toUpperCase();; str2 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onDescriptorRead]gatt deviceId:%s descriptorId:%s", new Object[] { str1, str2 });
      this.gmo.onDescriptorRead(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
      return;
      str1 = "";
      break;
    }
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    String str1;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattDescriptor == null) {
        break label68;
      }
    }
    label68:
    for (String str2 = paramBluetoothGattDescriptor.getUuid().toString().toUpperCase();; str2 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onDescriptorWrite]gatt deviceId:%s descriptorId:%s", new Object[] { str1, str2 });
      this.gmo.onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
      return;
      str1 = "";
      break;
    }
  }
  
  public final void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    if (paramBluetoothGatt != null) {}
    for (String str = paramBluetoothGatt.getDevice().getAddress();; str = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onMtuChanged]gatt deviceId:%s mtu:%d status:%s", new Object[] { str, Integer.valueOf(paramInt1), f.lk(paramInt2) });
      this.gmo.onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
      return;
    }
  }
  
  public final void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    if (paramBluetoothGatt != null) {}
    for (String str = paramBluetoothGatt.getDevice().getAddress();; str = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onReadRemoteRssi]gatt deviceId:%s rssi:%d status:%s", new Object[] { str, Integer.valueOf(paramInt1), f.lk(paramInt2) });
      this.gmo.onReadRemoteRssi(paramBluetoothGatt, paramInt1, paramInt2);
      return;
    }
  }
  
  public final void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    if (paramBluetoothGatt != null) {}
    for (String str = paramBluetoothGatt.getDevice().getAddress();; str = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onReliableWriteCompleted]gatt deviceId:%s status:%s", new Object[] { str, f.lk(paramInt) });
      this.gmo.onReliableWriteCompleted(paramBluetoothGatt, paramInt);
      return;
    }
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    if (paramBluetoothGatt != null) {}
    for (String str = paramBluetoothGatt.getDevice().getAddress();; str = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onServicesDiscovered]gatt deviceId:%s status:%s", new Object[] { str, f.lk(paramInt) });
      this.gmo.onServicesDiscovered(paramBluetoothGatt, paramInt);
      if (paramInt == 0) {
        ac(paramBluetoothGatt.getDevice().getAddress(), true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d
 * JD-Core Version:    0.7.0.1
 */