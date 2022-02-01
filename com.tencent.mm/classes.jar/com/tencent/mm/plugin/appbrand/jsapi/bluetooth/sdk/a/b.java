package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public final class b
  implements e
{
  public Handler aCF;
  public Queue<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a> kHS;
  com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a kHT;
  public List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a> kHU;
  
  public b()
  {
    AppMethodBeat.i(144544);
    this.aCF = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(144544);
  }
  
  public final void bjX()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(144545);
        if ((this.kHT != null) && (!this.kHT.brw))
        {
          AppMethodBeat.o(144545);
          return;
        }
        if ((this.kHS == null) || (this.kHS.size() <= 0)) {
          break label146;
        }
        this.kHT = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)this.kHS.poll());
        if (this.kHT == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectDispatcher", "curSerialAction is null, err", new Object[0]);
          AppMethodBeat.o(144545);
          continue;
        }
        if (!this.kHT.kHG) {
          break label139;
        }
      }
      finally {}
      this.aCF.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(144543);
          b.this.kHT.doAction();
          AppMethodBeat.o(144543);
        }
      }, this.kHT.kIB);
      AppMethodBeat.o(144545);
      continue;
      label139:
      this.kHT.doAction();
      label146:
      AppMethodBeat.o(144545);
    }
  }
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    AppMethodBeat.i(144550);
    if (this.kHU != null)
    {
      paramBluetoothGatt = this.kHU.iterator();
      while (paramBluetoothGatt.hasNext()) {
        paramBluetoothGatt.next();
      }
    }
    AppMethodBeat.o(144550);
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144548);
    if (this.kHT != null) {
      this.kHT.onCharacteristicRead(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    }
    if (this.kHU != null)
    {
      paramBluetoothGattCharacteristic = this.kHU.iterator();
      while (paramBluetoothGattCharacteristic.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)paramBluetoothGattCharacteristic.next();
        if (locala.brw) {
          locala.onServicesDiscovered(paramBluetoothGatt, paramInt);
        }
      }
    }
    AppMethodBeat.o(144548);
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144549);
    if (this.kHT != null) {
      this.kHT.onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    }
    if (this.kHU != null)
    {
      Iterator localIterator = this.kHU.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.brw) {
          locala.onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
        }
      }
    }
    AppMethodBeat.o(144549);
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144546);
    if (this.kHT != null) {
      this.kHT.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
    }
    if (this.kHU != null)
    {
      Iterator localIterator = this.kHU.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.brw) {
          locala.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
        }
      }
    }
    AppMethodBeat.o(144546);
  }
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144551);
    if (this.kHU != null)
    {
      paramBluetoothGatt = this.kHU.iterator();
      while (paramBluetoothGatt.hasNext()) {
        paramBluetoothGatt.next();
      }
    }
    AppMethodBeat.o(144551);
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144552);
    if (this.kHT != null) {
      this.kHT.onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
    }
    if (this.kHU != null)
    {
      Iterator localIterator = this.kHU.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.brw) {
          locala.onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
        }
      }
    }
    AppMethodBeat.o(144552);
  }
  
  public final void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144555);
    if (this.kHT != null) {
      this.kHT.onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
    }
    if (this.kHU != null)
    {
      Iterator localIterator = this.kHU.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.brw) {
          locala.onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
        }
      }
    }
    AppMethodBeat.o(144555);
  }
  
  public final void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144554);
    if (this.kHT != null) {
      this.kHT.onReadRemoteRssi(paramBluetoothGatt, paramInt1, paramInt2);
    }
    if (this.kHU != null)
    {
      Iterator localIterator = this.kHU.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.brw) {
          locala.onServicesDiscovered(paramBluetoothGatt, paramInt2);
        }
      }
    }
    AppMethodBeat.o(144554);
  }
  
  public final void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(144553);
    if (this.kHU != null)
    {
      paramBluetoothGatt = this.kHU.iterator();
      while (paramBluetoothGatt.hasNext()) {
        paramBluetoothGatt.next();
      }
    }
    AppMethodBeat.o(144553);
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(144547);
    if (this.kHT != null) {
      this.kHT.onServicesDiscovered(paramBluetoothGatt, paramInt);
    }
    if (this.kHU != null)
    {
      Iterator localIterator = this.kHU.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.brw) {
          locala.onServicesDiscovered(paramBluetoothGatt, paramInt);
        }
      }
    }
    AppMethodBeat.o(144547);
  }
  
  public final void uninit()
  {
    try
    {
      AppMethodBeat.i(183543);
      if (this.kHS != null)
      {
        this.kHS.clear();
        this.kHS = null;
      }
      if (this.kHU != null)
      {
        this.kHU.clear();
        this.kHU = null;
      }
      AppMethodBeat.o(183543);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b
 * JD-Core Version:    0.7.0.1
 */