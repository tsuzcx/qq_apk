package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import java.util.UUID;

@TargetApi(18)
public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String kIn;
  private final String kgF;
  
  public g(String paramString1, String paramString2)
  {
    this.kgF = paramString1;
    this.kIn = paramString2;
  }
  
  public final void bjZ()
  {
    AppMethodBeat.i(144582);
    BluetoothGatt localBluetoothGatt = this.kIw.kIc;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.kIX);
      done();
      AppMethodBeat.o(144582);
      return;
    }
    if (!c.Qg(this.kgF))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", new Object[] { this });
      a(j.kIV);
      done();
      AppMethodBeat.o(144582);
      return;
    }
    Object localObject = localBluetoothGatt.getService(UUID.fromString(this.kgF));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      a(j.kIV);
      done();
      AppMethodBeat.o(144582);
      return;
    }
    if (!c.Qg(this.kIn))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[] { this });
      a(j.kIW);
      done();
      AppMethodBeat.o(144582);
      return;
    }
    localObject = ((BluetoothGattService)localObject).getCharacteristic(UUID.fromString(this.kIn));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", new Object[] { this });
      a(j.kIW);
      done();
      AppMethodBeat.o(144582);
      return;
    }
    if (!c.sY(((BluetoothGattCharacteristic)localObject).getProperties()))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support read", new Object[] { this });
      a(j.kIY);
      done();
      AppMethodBeat.o(144582);
      return;
    }
    if (!localBluetoothGatt.readCharacteristic((BluetoothGattCharacteristic)localObject))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.readCharacteristic fail", new Object[] { this });
      a(j.kIZ);
      done();
      AppMethodBeat.o(144582);
      return;
    }
    a(j.kIP);
    AppMethodBeat.o(144582);
  }
  
  public final String getName()
  {
    return "ReadCharacteristicAction";
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144583);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onCharacteristicRead status:%s", new Object[] { this, f.sV(paramInt) });
    done();
    AppMethodBeat.o(144583);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144584);
    String str = "ReadCharacteristicAction#" + this.kID + "{serviceId='" + this.kgF + '\'' + ", characteristicId='" + this.kIn + '\'' + ", debug=" + this.aXD + ", mainThread=" + this.kHG + ", serial=" + this.kHI + '}';
    AppMethodBeat.o(144584);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.g
 * JD-Core Version:    0.7.0.1
 */