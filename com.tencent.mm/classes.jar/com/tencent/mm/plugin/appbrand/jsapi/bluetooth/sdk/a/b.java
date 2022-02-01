package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b
  implements e
{
  public final Handler die;
  public volatile Queue<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a> oIK;
  private volatile com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a oIL;
  public volatile List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a> oIM;
  
  public b()
  {
    AppMethodBeat.i(144544);
    this.die = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(144544);
  }
  
  public final void bQS()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(144545);
        Object localObject = this.oIL;
        if ((localObject != null) && (!((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localObject).baT))
        {
          AppMethodBeat.o(144545);
          return;
        }
        localObject = this.oIK;
        if ((localObject == null) || (((Queue)localObject).size() <= 0)) {
          break label132;
        }
        localObject = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)((Queue)localObject).poll();
        if (localObject == null)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectDispatcher", "curSerialAction is null, err", new Object[0]);
          AppMethodBeat.o(144545);
          continue;
        }
        this.oIL = locala;
      }
      finally {}
      if (locala.oIw)
      {
        this.die.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(144543);
            locala.doAction();
            AppMethodBeat.o(144543);
          }
        }, locala.oJu);
        AppMethodBeat.o(144545);
      }
      else
      {
        locala.doAction();
        label132:
        AppMethodBeat.o(144545);
      }
    }
  }
  
  public final void init()
  {
    try
    {
      AppMethodBeat.i(199502);
      this.oIK = new ConcurrentLinkedQueue();
      this.oIM = new ArrayList();
      AppMethodBeat.o(199502);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    AppMethodBeat.i(144550);
    paramBluetoothGatt = this.oIL;
    paramBluetoothGatt = this.oIM;
    if (paramBluetoothGatt != null)
    {
      paramBluetoothGatt = paramBluetoothGatt.iterator();
      while (paramBluetoothGatt.hasNext()) {
        boolean bool = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)paramBluetoothGatt.next()).baT;
      }
    }
    AppMethodBeat.o(144550);
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144548);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = this.oIL;
    if (locala != null) {
      locala.onCharacteristicRead(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    }
    paramBluetoothGattCharacteristic = this.oIM;
    if (paramBluetoothGattCharacteristic != null)
    {
      paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.iterator();
      while (paramBluetoothGattCharacteristic.hasNext())
      {
        locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)paramBluetoothGattCharacteristic.next();
        if (!locala.baT) {
          locala.onServicesDiscovered(paramBluetoothGatt, paramInt);
        }
      }
    }
    AppMethodBeat.o(144548);
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144549);
    Object localObject = this.oIL;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localObject).onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    }
    localObject = this.oIM;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)((Iterator)localObject).next();
        if (!locala.baT) {
          locala.onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
        }
      }
    }
    AppMethodBeat.o(144549);
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144546);
    Object localObject = this.oIL;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localObject).onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
    }
    localObject = this.oIM;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)((Iterator)localObject).next();
        if (!locala.baT) {
          locala.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
        }
      }
    }
    AppMethodBeat.o(144546);
  }
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144551);
    paramBluetoothGatt = this.oIL;
    paramBluetoothGatt = this.oIM;
    if (paramBluetoothGatt != null)
    {
      paramBluetoothGatt = paramBluetoothGatt.iterator();
      while (paramBluetoothGatt.hasNext()) {
        boolean bool = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)paramBluetoothGatt.next()).baT;
      }
    }
    AppMethodBeat.o(144551);
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144552);
    Object localObject = this.oIL;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localObject).onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
    }
    localObject = this.oIM;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)((Iterator)localObject).next();
        if (!locala.baT) {
          locala.onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
        }
      }
    }
    AppMethodBeat.o(144552);
  }
  
  public final void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144555);
    Object localObject = this.oIL;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localObject).onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
    }
    localObject = this.oIM;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)((Iterator)localObject).next();
        if (!locala.baT) {
          locala.onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
        }
      }
    }
    AppMethodBeat.o(144555);
  }
  
  public final void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144554);
    Object localObject = this.oIL;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localObject).onReadRemoteRssi(paramBluetoothGatt, paramInt1, paramInt2);
    }
    localObject = this.oIM;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)((Iterator)localObject).next();
        if (!locala.baT) {
          locala.onServicesDiscovered(paramBluetoothGatt, paramInt2);
        }
      }
    }
    AppMethodBeat.o(144554);
  }
  
  public final void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(144553);
    paramBluetoothGatt = this.oIL;
    paramBluetoothGatt = this.oIM;
    if (paramBluetoothGatt != null)
    {
      paramBluetoothGatt = paramBluetoothGatt.iterator();
      while (paramBluetoothGatt.hasNext()) {
        boolean bool = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)paramBluetoothGatt.next()).baT;
      }
    }
    AppMethodBeat.o(144553);
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(144547);
    Object localObject = this.oIL;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)localObject).onServicesDiscovered(paramBluetoothGatt, paramInt);
    }
    localObject = this.oIM;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a)((Iterator)localObject).next();
        if (!locala.baT) {
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
      Object localObject1 = this.oIK;
      if (localObject1 != null)
      {
        ((Queue)localObject1).clear();
        this.oIK = null;
      }
      localObject1 = this.oIM;
      if (localObject1 != null)
      {
        ((List)localObject1).clear();
        this.oIM = null;
      }
      AppMethodBeat.o(183543);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b
 * JD-Core Version:    0.7.0.1
 */