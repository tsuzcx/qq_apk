package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public final class b
  implements e
{
  public Queue<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a> gme;
  com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a gmf;
  public List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a> gmg;
  public Handler gmh = new Handler(Looper.getMainLooper());
  
  public final void ait()
  {
    for (;;)
    {
      try
      {
        if (this.gmf != null)
        {
          boolean bool = this.gmf.aEm;
          if (!bool) {
            return;
          }
        }
        if ((this.gme == null) || (this.gme.size() <= 0)) {
          continue;
        }
        this.gmf = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)this.gme.poll());
        if (this.gmf == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectDispatcher", "curSerialAction is null, err", new Object[0]);
          continue;
        }
        if (!this.gmf.glS) {
          break label121;
        }
      }
      finally {}
      this.gmh.postDelayed(new b.2(this), this.gmf.gmA);
      continue;
      label121:
      this.gmf.aiv();
    }
  }
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    if (this.gmg != null)
    {
      paramBluetoothGatt = this.gmg.iterator();
      while (paramBluetoothGatt.hasNext()) {
        paramBluetoothGatt.next();
      }
    }
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    if (this.gmf != null) {
      this.gmf.onCharacteristicRead(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    }
    if (this.gmg != null)
    {
      paramBluetoothGattCharacteristic = this.gmg.iterator();
      while (paramBluetoothGattCharacteristic.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)paramBluetoothGattCharacteristic.next();
        if (locala.aEm) {
          locala.onServicesDiscovered(paramBluetoothGatt, paramInt);
        }
      }
    }
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    if (this.gmf != null) {
      this.gmf.onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    }
    if (this.gmg != null)
    {
      Iterator localIterator = this.gmg.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.aEm) {
          locala.onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
        }
      }
    }
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    if (this.gmf != null) {
      this.gmf.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
    }
    if (this.gmg != null)
    {
      Iterator localIterator = this.gmg.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.aEm) {
          locala.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
        }
      }
    }
  }
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    if (this.gmg != null)
    {
      paramBluetoothGatt = this.gmg.iterator();
      while (paramBluetoothGatt.hasNext()) {
        paramBluetoothGatt.next();
      }
    }
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    if (this.gmf != null) {
      this.gmf.onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
    }
    if (this.gmg != null)
    {
      Iterator localIterator = this.gmg.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.aEm) {
          locala.onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
        }
      }
    }
  }
  
  public final void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    if (this.gmg != null)
    {
      paramBluetoothGatt = this.gmg.iterator();
      while (paramBluetoothGatt.hasNext()) {
        paramBluetoothGatt.next();
      }
    }
  }
  
  public final void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    if (this.gmg != null)
    {
      Iterator localIterator = this.gmg.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.aEm) {
          locala.onServicesDiscovered(paramBluetoothGatt, paramInt2);
        }
      }
    }
  }
  
  public final void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    if (this.gmg != null)
    {
      paramBluetoothGatt = this.gmg.iterator();
      while (paramBluetoothGatt.hasNext()) {
        paramBluetoothGatt.next();
      }
    }
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    if (this.gmf != null) {
      this.gmf.onServicesDiscovered(paramBluetoothGatt, paramInt);
    }
    if (this.gmg != null)
    {
      Iterator localIterator = this.gmg.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.aEm) {
          locala.onServicesDiscovered(paramBluetoothGatt, paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b
 * JD-Core Version:    0.7.0.1
 */