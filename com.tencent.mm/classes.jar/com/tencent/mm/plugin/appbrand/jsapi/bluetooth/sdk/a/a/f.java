package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final boolean enable;
  private final String rMT;
  private final Integer rMU;
  private final String riE;
  
  public f(String paramString1, String paramString2, Integer paramInteger, boolean paramBoolean)
  {
    this.riE = paramString1;
    this.rMT = paramString2;
    this.rMU = paramInteger;
    this.enable = paramBoolean;
  }
  
  public final void crh()
  {
    AppMethodBeat.i(144579);
    BluetoothGatt localBluetoothGatt = this.rNd.rMH;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      onResult(k.rNG);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (!c.aar(this.riE))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", new Object[] { this });
      onResult(k.rNE);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    Object localObject1 = localBluetoothGatt.getService(UUID.fromString(this.riE));
    if (localObject1 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      onResult(k.rNE);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (!c.aar(this.rMT))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[] { this });
      onResult(k.rNF);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    Object localObject2 = UUID.fromString(this.rMT);
    if (this.rMU != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s, handle: %d", new Object[] { this, this.rMU });
      Iterator localIterator = ((BluetoothGattService)localObject1).getCharacteristics().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (BluetoothGattCharacteristic)localIterator.next();
      } while ((!((UUID)localObject2).equals(((BluetoothGattCharacteristic)localObject1).getUuid())) || (this.rMU.intValue() != ((BluetoothGattCharacteristic)localObject1).getInstanceId()));
    }
    while (localObject1 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", new Object[] { this });
      onResult(k.rNF);
      done();
      AppMethodBeat.o(144579);
      return;
      localObject1 = null;
      continue;
      localObject1 = ((BluetoothGattService)localObject1).getCharacteristic((UUID)localObject2);
    }
    if (!c.AE(((BluetoothGattCharacteristic)localObject1).getProperties()))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support notify", new Object[] { this });
      onResult(k.rNH);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (!localBluetoothGatt.setCharacteristicNotification((BluetoothGattCharacteristic)localObject1, this.enable))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.setCharacteristicNotification fail", new Object[] { this });
      onResult(k.rNI);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    localObject2 = ((BluetoothGattCharacteristic)localObject1).getDescriptor(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b.a.rNc);
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattCharacteristic.getDescriptor fail", new Object[] { this });
      onResult(k.rNK);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (this.enable) {}
    for (localObject1 = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE; !((BluetoothGattDescriptor)localObject2).setValue((byte[])localObject1); localObject1 = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattDescriptor.setValue fail", new Object[] { this });
      onResult(k.rNL);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (!localBluetoothGatt.writeDescriptor((BluetoothGattDescriptor)localObject2))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeDescriptor fail", new Object[] { this });
      onResult(k.rNM);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    onResult(k.rNz);
    AppMethodBeat.o(144579);
  }
  
  public final String getName()
  {
    return "NotifyCharacteristicAction";
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144580);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onDescriptorWrite status:%s", new Object[] { this, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f.Ay(paramInt) });
    done();
    AppMethodBeat.o(144580);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144581);
    String str = "NotifyCharacteristicAction#" + this.rNk + "{serviceId='" + this.riE + '\'' + ", characteristicId='" + this.rMT + '\'' + ", enable=" + this.enable + ", debug=" + this.debug + ", mainThread=" + this.rMf + ", serial=" + this.rMh + '}';
    AppMethodBeat.o(144581);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f
 * JD-Core Version:    0.7.0.1
 */