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
  public Handler bTu;
  public Queue<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a> hGd;
  com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a hGe;
  public List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a> hGf;
  
  public b()
  {
    AppMethodBeat.i(94232);
    this.bTu = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(94232);
  }
  
  public final void aCn()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(94233);
        if ((this.hGe != null) && (!this.hGe.aKX))
        {
          AppMethodBeat.o(94233);
          return;
        }
        if ((this.hGd == null) || (this.hGd.size() <= 0)) {
          break label146;
        }
        this.hGe = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)this.hGd.poll());
        if (this.hGe == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectDispatcher", "curSerialAction is null, err", new Object[0]);
          AppMethodBeat.o(94233);
          continue;
        }
        if (!this.hGe.hFR) {
          break label139;
        }
      }
      finally {}
      this.bTu.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(94231);
          b.this.hGe.aCp();
          AppMethodBeat.o(94231);
        }
      }, this.hGe.hGA);
      AppMethodBeat.o(94233);
      continue;
      label139:
      this.hGe.aCp();
      label146:
      AppMethodBeat.o(94233);
    }
  }
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    AppMethodBeat.i(94238);
    if (this.hGf != null)
    {
      paramBluetoothGatt = this.hGf.iterator();
      while (paramBluetoothGatt.hasNext()) {
        paramBluetoothGatt.next();
      }
    }
    AppMethodBeat.o(94238);
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(94236);
    if (this.hGe != null) {
      this.hGe.onCharacteristicRead(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    }
    if (this.hGf != null)
    {
      paramBluetoothGattCharacteristic = this.hGf.iterator();
      while (paramBluetoothGattCharacteristic.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)paramBluetoothGattCharacteristic.next();
        if (locala.aKX) {
          locala.onServicesDiscovered(paramBluetoothGatt, paramInt);
        }
      }
    }
    AppMethodBeat.o(94236);
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(94237);
    if (this.hGe != null) {
      this.hGe.onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    }
    if (this.hGf != null)
    {
      Iterator localIterator = this.hGf.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.aKX) {
          locala.onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
        }
      }
    }
    AppMethodBeat.o(94237);
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94234);
    if (this.hGe != null) {
      this.hGe.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
    }
    if (this.hGf != null)
    {
      Iterator localIterator = this.hGf.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.aKX) {
          locala.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
        }
      }
    }
    AppMethodBeat.o(94234);
  }
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(94239);
    if (this.hGf != null)
    {
      paramBluetoothGatt = this.hGf.iterator();
      while (paramBluetoothGatt.hasNext()) {
        paramBluetoothGatt.next();
      }
    }
    AppMethodBeat.o(94239);
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(94240);
    if (this.hGe != null) {
      this.hGe.onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
    }
    if (this.hGf != null)
    {
      Iterator localIterator = this.hGf.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.aKX) {
          locala.onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
        }
      }
    }
    AppMethodBeat.o(94240);
  }
  
  public final void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94243);
    if (this.hGf != null)
    {
      paramBluetoothGatt = this.hGf.iterator();
      while (paramBluetoothGatt.hasNext()) {
        paramBluetoothGatt.next();
      }
    }
    AppMethodBeat.o(94243);
  }
  
  public final void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94242);
    if (this.hGf != null)
    {
      Iterator localIterator = this.hGf.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.aKX) {
          locala.onServicesDiscovered(paramBluetoothGatt, paramInt2);
        }
      }
    }
    AppMethodBeat.o(94242);
  }
  
  public final void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(94241);
    if (this.hGf != null)
    {
      paramBluetoothGatt = this.hGf.iterator();
      while (paramBluetoothGatt.hasNext()) {
        paramBluetoothGatt.next();
      }
    }
    AppMethodBeat.o(94241);
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(94235);
    if (this.hGe != null) {
      this.hGe.onServicesDiscovered(paramBluetoothGatt, paramInt);
    }
    if (this.hGf != null)
    {
      Iterator localIterator = this.hGf.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localIterator.next();
        if (locala.aKX) {
          locala.onServicesDiscovered(paramBluetoothGatt, paramInt);
        }
      }
    }
    AppMethodBeat.o(94235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b
 * JD-Core Version:    0.7.0.1
 */