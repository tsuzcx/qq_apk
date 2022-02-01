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
  public Handler aAO;
  public Queue<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a> kjF;
  com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a kjG;
  public List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a> kjH;
  
  public b()
  {
    AppMethodBeat.i(144544);
    this.aAO = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(144544);
  }
  
  public final void bfK()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(144545);
        if ((this.kjG != null) && (!this.kjG.bhc))
        {
          AppMethodBeat.o(144545);
          return;
        }
        if ((this.kjF == null) || (this.kjF.size() <= 0)) {
          break label146;
        }
        this.kjG = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)this.kjF.poll());
        if (this.kjG == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectDispatcher", "curSerialAction is null, err", new Object[0]);
          AppMethodBeat.o(144545);
          continue;
        }
        if (!this.kjG.kjt) {
          break label139;
        }
      }
      finally {}
      this.aAO.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(144543);
          b.this.kjG.doAction();
          AppMethodBeat.o(144543);
        }
      }, this.kjG.kkm);
      AppMethodBeat.o(144545);
      continue;
      label139:
      this.kjG.doAction();
      label146:
      AppMethodBeat.o(144545);
    }
  }
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    AppMethodBeat.i(144550);
    if (this.kjH != null)
    {
      paramBluetoothGatt = this.kjH.iterator();
      while (paramBluetoothGatt.hasNext()) {
        paramBluetoothGatt.next();
      }
    }
    AppMethodBeat.o(144550);
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144548);
    if (this.kjG != null) {
      this.kjG.onCharacteristicRead(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    }
    if (this.kjH != null)
    {
      paramBluetoothGattCharacteristic = this.kjH.iterator();
      while (paramBluetoothGattCharacteristic.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)paramBluetoothGattCharacteristic.next();
        if (locala.bhc) {
          locala.onServicesDiscovered(paramBluetoothGatt, paramInt);
        }
      }
    }
    AppMethodBeat.o(144548);
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144549);
    if (this.kjG != null) {
      this.kjG.onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    }
    if (this.kjH != null)
    {
      Iterator localIterator = this.kjH.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.bhc) {
          locala.onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
        }
      }
    }
    AppMethodBeat.o(144549);
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144546);
    if (this.kjG != null) {
      this.kjG.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
    }
    if (this.kjH != null)
    {
      Iterator localIterator = this.kjH.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.bhc) {
          locala.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
        }
      }
    }
    AppMethodBeat.o(144546);
  }
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144551);
    if (this.kjH != null)
    {
      paramBluetoothGatt = this.kjH.iterator();
      while (paramBluetoothGatt.hasNext()) {
        paramBluetoothGatt.next();
      }
    }
    AppMethodBeat.o(144551);
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144552);
    if (this.kjG != null) {
      this.kjG.onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
    }
    if (this.kjH != null)
    {
      Iterator localIterator = this.kjH.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.bhc) {
          locala.onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
        }
      }
    }
    AppMethodBeat.o(144552);
  }
  
  public final void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144555);
    if (this.kjG != null) {
      this.kjG.onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
    }
    if (this.kjH != null)
    {
      Iterator localIterator = this.kjH.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.bhc) {
          locala.onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
        }
      }
    }
    AppMethodBeat.o(144555);
  }
  
  public final void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144554);
    if (this.kjG != null) {
      this.kjG.onReadRemoteRssi(paramBluetoothGatt, paramInt1, paramInt2);
    }
    if (this.kjH != null)
    {
      Iterator localIterator = this.kjH.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.bhc) {
          locala.onServicesDiscovered(paramBluetoothGatt, paramInt2);
        }
      }
    }
    AppMethodBeat.o(144554);
  }
  
  public final void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(144553);
    if (this.kjH != null)
    {
      paramBluetoothGatt = this.kjH.iterator();
      while (paramBluetoothGatt.hasNext()) {
        paramBluetoothGatt.next();
      }
    }
    AppMethodBeat.o(144553);
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(144547);
    if (this.kjG != null) {
      this.kjG.onServicesDiscovered(paramBluetoothGatt, paramInt);
    }
    if (this.kjH != null)
    {
      Iterator localIterator = this.kjH.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.bhc) {
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
      if (this.kjF != null)
      {
        this.kjF.clear();
        this.kjF = null;
      }
      if (this.kjH != null)
      {
        this.kjH.clear();
        this.kjH = null;
      }
      AppMethodBeat.o(183543);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b
 * JD-Core Version:    0.7.0.1
 */