package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import java.util.UUID;

@TargetApi(18)
public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final boolean enable;
  private final String jJc;
  private final String kjZ;
  
  public e(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jJc = paramString1;
    this.kjZ = paramString2;
    this.enable = paramBoolean;
  }
  
  public final void bfM()
  {
    AppMethodBeat.i(144579);
    BluetoothGatt localBluetoothGatt = this.kkh.kjP;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.kkI);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (!c.Mc(this.jJc))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", new Object[] { this });
      a(j.kkG);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    Object localObject = localBluetoothGatt.getService(UUID.fromString(this.jJc));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      a(j.kkG);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (!c.Mc(this.kjZ))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[] { this });
      a(j.kkH);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    localObject = ((BluetoothGattService)localObject).getCharacteristic(UUID.fromString(this.kjZ));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", new Object[] { this });
      a(j.kkH);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (!c.sw(((BluetoothGattCharacteristic)localObject).getProperties()))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support notify", new Object[] { this });
      a(j.kkJ);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (!localBluetoothGatt.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, this.enable))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.setCharacteristicNotification fail", new Object[] { this });
      a(j.kkK);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    BluetoothGattDescriptor localBluetoothGattDescriptor = ((BluetoothGattCharacteristic)localObject).getDescriptor(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b.a.kkg);
    if (localBluetoothGattDescriptor == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattCharacteristic.getDescriptor fail", new Object[] { this });
      a(j.kkM);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (this.enable) {}
    for (localObject = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE; !localBluetoothGattDescriptor.setValue((byte[])localObject); localObject = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattDescriptor.setValue fail", new Object[] { this });
      a(j.kkN);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (!localBluetoothGatt.writeDescriptor(localBluetoothGattDescriptor))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeDescriptor fail", new Object[] { this });
      a(j.kkO);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    a(j.kkA);
    AppMethodBeat.o(144579);
  }
  
  public final String getName()
  {
    return "NotifyCharacteristicAction";
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144580);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onDescriptorWrite status:%s", new Object[] { this, f.sq(paramInt) });
    done();
    AppMethodBeat.o(144580);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144581);
    String str = "NotifyCharacteristicAction#" + this.kko + "{serviceId='" + this.jJc + '\'' + ", characteristicId='" + this.kjZ + '\'' + ", enable=" + this.enable + ", debug=" + this.aNj + ", mainThread=" + this.kjt + ", serial=" + this.kjv + '}';
    AppMethodBeat.o(144581);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.e
 * JD-Core Version:    0.7.0.1
 */