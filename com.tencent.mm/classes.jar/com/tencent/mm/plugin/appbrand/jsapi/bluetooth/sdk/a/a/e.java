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
  private final String kEY;
  private final String kdo;
  
  public e(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.kdo = paramString1;
    this.kEY = paramString2;
    this.enable = paramBoolean;
  }
  
  public final void bjq()
  {
    AppMethodBeat.i(144579);
    BluetoothGatt localBluetoothGatt = this.kFh.kEN;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.kFI);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (!c.Py(this.kdo))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", new Object[] { this });
      a(j.kFG);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    Object localObject = localBluetoothGatt.getService(UUID.fromString(this.kdo));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      a(j.kFG);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (!c.Py(this.kEY))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[] { this });
      a(j.kFH);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    localObject = ((BluetoothGattService)localObject).getCharacteristic(UUID.fromString(this.kEY));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", new Object[] { this });
      a(j.kFH);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (!c.sY(((BluetoothGattCharacteristic)localObject).getProperties()))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support notify", new Object[] { this });
      a(j.kFJ);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (!localBluetoothGatt.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, this.enable))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.setCharacteristicNotification fail", new Object[] { this });
      a(j.kFK);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    BluetoothGattDescriptor localBluetoothGattDescriptor = ((BluetoothGattCharacteristic)localObject).getDescriptor(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b.a.kFg);
    if (localBluetoothGattDescriptor == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattCharacteristic.getDescriptor fail", new Object[] { this });
      a(j.kFM);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (this.enable) {}
    for (localObject = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE; !localBluetoothGattDescriptor.setValue((byte[])localObject); localObject = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattDescriptor.setValue fail", new Object[] { this });
      a(j.kFN);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    if (!localBluetoothGatt.writeDescriptor(localBluetoothGattDescriptor))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeDescriptor fail", new Object[] { this });
      a(j.kFO);
      done();
      AppMethodBeat.o(144579);
      return;
    }
    a(j.kFA);
    AppMethodBeat.o(144579);
  }
  
  public final String getName()
  {
    return "NotifyCharacteristicAction";
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144580);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onDescriptorWrite status:%s", new Object[] { this, f.sS(paramInt) });
    done();
    AppMethodBeat.o(144580);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144581);
    String str = "NotifyCharacteristicAction#" + this.kFo + "{serviceId='" + this.kdo + '\'' + ", characteristicId='" + this.kEY + '\'' + ", enable=" + this.enable + ", debug=" + this.aXD + ", mainThread=" + this.kEr + ", serial=" + this.kEt + '}';
    AppMethodBeat.o(144581);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.e
 * JD-Core Version:    0.7.0.1
 */