package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import java.util.UUID;

@TargetApi(18)
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final boolean enable;
  private final String jJc;
  private final String kjZ;
  
  public d(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jJc = paramString1;
    this.kjZ = paramString2;
    this.enable = paramBoolean;
  }
  
  public final void bfM()
  {
    AppMethodBeat.i(144576);
    BluetoothGatt localBluetoothGatt = this.kkh.kjP;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.kkI);
      done();
      AppMethodBeat.o(144576);
      return;
    }
    Object localObject = localBluetoothGatt.getService(UUID.fromString(this.jJc));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      a(j.kkG);
      done();
      AppMethodBeat.o(144576);
      return;
    }
    if (!c.Mc(this.kjZ))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[] { this });
      a(j.kkH);
      done();
      AppMethodBeat.o(144576);
      return;
    }
    localObject = ((BluetoothGattService)localObject).getCharacteristic(UUID.fromString(this.kjZ));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", new Object[] { this });
      a(j.kkH);
      done();
      AppMethodBeat.o(144576);
      return;
    }
    if (!c.sx(((BluetoothGattCharacteristic)localObject).getProperties()))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support indicate", new Object[] { this });
      a(j.kkJ);
      done();
      AppMethodBeat.o(144576);
      return;
    }
    if (!localBluetoothGatt.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, this.enable))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.setCharacteristicNotification fail", new Object[] { this });
      a(j.kkK);
      done();
      AppMethodBeat.o(144576);
      return;
    }
    BluetoothGattDescriptor localBluetoothGattDescriptor = ((BluetoothGattCharacteristic)localObject).getDescriptor(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b.a.kkg);
    if (localBluetoothGattDescriptor == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattCharacteristic.getDescriptor fail", new Object[] { this });
      a(j.kkM);
      done();
      AppMethodBeat.o(144576);
      return;
    }
    if (this.enable) {}
    for (localObject = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE; !localBluetoothGattDescriptor.setValue((byte[])localObject); localObject = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattDescriptor.setValue fail", new Object[] { this });
      a(j.kkN);
      done();
      AppMethodBeat.o(144576);
      return;
    }
    if (!localBluetoothGatt.writeDescriptor(localBluetoothGattDescriptor))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeDescriptor fail", new Object[] { this });
      a(j.kkO);
      done();
      AppMethodBeat.o(144576);
      return;
    }
    a(j.kkA);
    AppMethodBeat.o(144576);
  }
  
  public final String getName()
  {
    return "IndicateCharacteristicAction";
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144577);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onDescriptorWrite status:%s", new Object[] { this, f.sq(paramInt) });
    done();
    AppMethodBeat.o(144577);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144578);
    String str = "IndicateCharacteristicAction#" + this.kko + "{serviceId='" + this.jJc + '\'' + ", characteristicId='" + this.kjZ + '\'' + ", enable=" + this.enable + ", debug=" + this.aNj + ", mainThread=" + this.kjt + ", serial=" + this.kjv + '}';
    AppMethodBeat.o(144578);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.d
 * JD-Core Version:    0.7.0.1
 */