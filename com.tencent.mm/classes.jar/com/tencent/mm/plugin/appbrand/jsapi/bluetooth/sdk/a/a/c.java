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
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import java.util.UUID;

@TargetApi(18)
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final boolean enable;
  private final String hGs;
  private final String hGt;
  
  public c(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.hGs = paramString1;
    this.hGt = paramString2;
    this.enable = paramBoolean;
  }
  
  public final void aCo()
  {
    AppMethodBeat.i(94264);
    BluetoothGatt localBluetoothGatt = this.hGv.hGn;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.hGV);
      done();
      AppMethodBeat.o(94264);
      return;
    }
    Object localObject = localBluetoothGatt.getService(UUID.fromString(this.hGs));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      a(j.hGT);
      done();
      AppMethodBeat.o(94264);
      return;
    }
    if (!b.BY(this.hGt))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[] { this });
      a(j.hGU);
      done();
      AppMethodBeat.o(94264);
      return;
    }
    localObject = ((BluetoothGattService)localObject).getCharacteristic(UUID.fromString(this.hGt));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", new Object[] { this });
      a(j.hGU);
      done();
      AppMethodBeat.o(94264);
      return;
    }
    if (!b.oa(((BluetoothGattCharacteristic)localObject).getProperties()))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support indicate", new Object[] { this });
      a(j.hGW);
      done();
      AppMethodBeat.o(94264);
      return;
    }
    if (!localBluetoothGatt.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, this.enable))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.setCharacteristicNotification fail", new Object[] { this });
      a(j.hGX);
      done();
      AppMethodBeat.o(94264);
      return;
    }
    BluetoothGattDescriptor localBluetoothGattDescriptor = ((BluetoothGattCharacteristic)localObject).getDescriptor(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b.a.hGu);
    if (localBluetoothGattDescriptor == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattCharacteristic.getDescriptor fail", new Object[] { this });
      a(j.hGZ);
      done();
      AppMethodBeat.o(94264);
      return;
    }
    if (this.enable) {}
    for (localObject = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE; !localBluetoothGattDescriptor.setValue((byte[])localObject); localObject = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattDescriptor.setValue fail", new Object[] { this });
      a(j.hHa);
      done();
      AppMethodBeat.o(94264);
      return;
    }
    if (!localBluetoothGatt.writeDescriptor(localBluetoothGattDescriptor))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeDescriptor fail", new Object[] { this });
      a(j.hHb);
      done();
      AppMethodBeat.o(94264);
      return;
    }
    a(j.hGN);
    AppMethodBeat.o(94264);
  }
  
  public final String getName()
  {
    return "IndicateCharacteristicAction";
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(94265);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onDescriptorWrite status:%s", new Object[] { this, f.nT(paramInt) });
    done();
    AppMethodBeat.o(94265);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94266);
    String str = "IndicateCharacteristicAction{serviceId='" + this.hGs + '\'' + ", characteristicId='" + this.hGt + '\'' + ", enable=" + this.enable + ", debug=" + this.arI + ", mainThread=" + this.hFR + ", serial=" + this.hFT + '}';
    AppMethodBeat.o(94266);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.c
 * JD-Core Version:    0.7.0.1
 */