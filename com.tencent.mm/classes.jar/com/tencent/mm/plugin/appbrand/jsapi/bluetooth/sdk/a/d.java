package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  public String bYu;
  public Context context;
  public h hGj;
  public g hGk;
  public b hGm;
  public BluetoothGatt hGn;
  public List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> hGo;
  public Map<String, List<c>> hGp;
  
  public d(Context paramContext, String paramString)
  {
    this.context = paramContext;
    this.bYu = paramString;
  }
  
  private void ai(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94248);
    if (this.hGj != null) {
      this.hGj.ah(paramString, paramBoolean);
    }
    AppMethodBeat.o(94248);
  }
  
  public final void ee(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(94246);
      if (this.hGn != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "deviceId:%s closeMyself", new Object[] { this.bYu });
        if (paramBoolean) {
          ai(this.bYu, false);
        }
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hFM.hFY) {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.a(this.hGn);
        }
        this.hGn.close();
        this.hGn = null;
      }
      AppMethodBeat.o(94246);
      return;
    }
    finally {}
  }
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    AppMethodBeat.i(94252);
    String str1;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattCharacteristic == null) {
        break label173;
      }
    }
    label173:
    for (String str2 = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();; str2 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onCharacteristicChanged]gatt deviceId:%s characteristicId:%s", new Object[] { str1, str2 });
      this.hGm.onCharacteristicChanged(paramBluetoothGatt, paramBluetoothGattCharacteristic);
      if (this.hGk != null)
      {
        str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
        paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
        str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
        paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[change]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
        this.hGk.f(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
      }
      AppMethodBeat.o(94252);
      return;
      str1 = "";
      break;
    }
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(94250);
    String str1;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattCharacteristic == null) {
        break label184;
      }
    }
    label184:
    for (String str2 = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();; str2 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onCharacteristicRead]gatt deviceId:%s characteristicId:%s status:%s", new Object[] { str1, str2, f.nT(paramInt) });
      this.hGm.onCharacteristicRead(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
      if (paramInt == 0)
      {
        str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
        paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
        str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
        paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[read]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
        this.hGk.f(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
      }
      AppMethodBeat.o(94250);
      return;
      str1 = "";
      break;
    }
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(94251);
    String str1;
    String str2;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattCharacteristic == null) {
        break label110;
      }
      str2 = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
      label34:
      if (paramBluetoothGattCharacteristic == null) {
        break label117;
      }
    }
    label110:
    label117:
    for (Object localObject = Arrays.asList(new byte[][] { paramBluetoothGattCharacteristic.getValue() });; localObject = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onCharacteristicWrite]gatt deviceId:%s characteristicId:%s value:%s, status:%s", new Object[] { str1, str2, localObject, f.nT(paramInt) });
      this.hGm.onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
      AppMethodBeat.o(94251);
      return;
      str1 = "";
      break;
      str2 = "";
      break label34;
    }
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94247);
    String str1;
    String str3;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      str3 = f.nT(paramInt1);
      if (paramInt2 != 2) {
        break label100;
      }
    }
    label100:
    for (String str2 = "CONNECTED";; str2 = "DISCONNECTED")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onConnectionStateChange]gatt deviceId:%s gattStatus:%s, newState:%s", new Object[] { str1, str3, str2 });
      this.hGm.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
      if ((paramInt1 != 0) || ((paramInt2 != 2) && (paramInt2 == 0))) {
        ee(true);
      }
      AppMethodBeat.o(94247);
      return;
      str1 = "";
      break;
    }
  }
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(94253);
    String str1;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattDescriptor == null) {
        break label78;
      }
    }
    label78:
    for (String str2 = paramBluetoothGattDescriptor.getUuid().toString().toUpperCase();; str2 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onDescriptorRead]gatt deviceId:%s descriptorId:%s", new Object[] { str1, str2 });
      this.hGm.onDescriptorRead(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
      AppMethodBeat.o(94253);
      return;
      str1 = "";
      break;
    }
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(94254);
    String str1;
    if (paramBluetoothGatt != null)
    {
      str1 = paramBluetoothGatt.getDevice().getAddress();
      if (paramBluetoothGattDescriptor == null) {
        break label78;
      }
    }
    label78:
    for (String str2 = paramBluetoothGattDescriptor.getUuid().toString().toUpperCase();; str2 = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onDescriptorWrite]gatt deviceId:%s descriptorId:%s", new Object[] { str1, str2 });
      this.hGm.onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
      AppMethodBeat.o(94254);
      return;
      str1 = "";
      break;
    }
  }
  
  public final void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94257);
    if (paramBluetoothGatt != null) {}
    for (String str = paramBluetoothGatt.getDevice().getAddress();; str = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onMtuChanged]gatt deviceId:%s mtu:%d status:%s", new Object[] { str, Integer.valueOf(paramInt1), f.nT(paramInt2) });
      this.hGm.onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
      AppMethodBeat.o(94257);
      return;
    }
  }
  
  public final void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94256);
    if (paramBluetoothGatt != null) {}
    for (String str = paramBluetoothGatt.getDevice().getAddress();; str = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onReadRemoteRssi]gatt deviceId:%s rssi:%d status:%s", new Object[] { str, Integer.valueOf(paramInt1), f.nT(paramInt2) });
      this.hGm.onReadRemoteRssi(paramBluetoothGatt, paramInt1, paramInt2);
      AppMethodBeat.o(94256);
      return;
    }
  }
  
  public final void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(94255);
    if (paramBluetoothGatt != null) {}
    for (String str = paramBluetoothGatt.getDevice().getAddress();; str = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onReliableWriteCompleted]gatt deviceId:%s status:%s", new Object[] { str, f.nT(paramInt) });
      this.hGm.onReliableWriteCompleted(paramBluetoothGatt, paramInt);
      AppMethodBeat.o(94255);
      return;
    }
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(94249);
    if (paramBluetoothGatt != null) {}
    for (String str = paramBluetoothGatt.getDevice().getAddress();; str = "")
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "[onServicesDiscovered]gatt deviceId:%s status:%s", new Object[] { str, f.nT(paramInt) });
      this.hGm.onServicesDiscovered(paramBluetoothGatt, paramInt);
      if (paramInt == 0) {
        ai(paramBluetoothGatt.getDevice().getAddress(), true);
      }
      AppMethodBeat.o(94249);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d
 * JD-Core Version:    0.7.0.1
 */