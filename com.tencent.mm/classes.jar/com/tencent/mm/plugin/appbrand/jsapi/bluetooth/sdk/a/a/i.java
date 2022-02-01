package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import java.util.Arrays;
import java.util.UUID;

@TargetApi(18)
public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String jJc;
  private final String kjZ;
  private final String value;
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    this.jJc = paramString1;
    this.kjZ = paramString2;
    this.value = paramString3;
  }
  
  public final void bfM()
  {
    AppMethodBeat.i(144585);
    BluetoothGatt localBluetoothGatt = this.kkh.kjP;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.kkI);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if (!c.Mc(this.jJc))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", new Object[] { this });
      a(j.kkG);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    Object localObject = localBluetoothGatt.getService(UUID.fromString(this.jJc));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      a(j.kkG);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if (!c.Mc(this.kjZ))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[] { this });
      a(j.kkH);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    localObject = ((BluetoothGattService)localObject).getCharacteristic(UUID.fromString(this.kjZ));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", new Object[] { this });
      a(j.kkH);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if ((!c.su(((BluetoothGattCharacteristic)localObject).getProperties())) && (!c.sv(((BluetoothGattCharacteristic)localObject).getProperties())))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support write & writeNoResponse", new Object[] { this });
      a(j.kkJ);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    byte[] arrayOfByte = c.at(Base64.decode(this.value, 2));
    ((BluetoothGattCharacteristic)localObject).setValue(arrayOfByte);
    if (arrayOfByte != null) {}
    for (int i = arrayOfByte.length;; i = 0)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "dataToWrite's length:%d", new Object[] { Integer.valueOf(i) });
      if (this.aNj) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "dataToWrite:%s", new Object[] { Arrays.toString(arrayOfByte) });
      }
      if (localBluetoothGatt.writeCharacteristic((BluetoothGattCharacteristic)localObject)) {
        break;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeCharacteristic fail", new Object[] { this });
      a(j.kkK);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if ((!c.su(((BluetoothGattCharacteristic)localObject).getProperties())) && (c.sv(((BluetoothGattCharacteristic)localObject).getProperties())))
    {
      a(j.kkA);
      done();
    }
    AppMethodBeat.o(144585);
  }
  
  public final String getName()
  {
    return "WriteCharacteristicAction";
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144586);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onCharacteristicWrite status:%s", new Object[] { this, f.sq(paramInt) });
    if (paramInt == 0) {
      a(j.kkA);
    }
    done();
    AppMethodBeat.o(144586);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144587);
    String str = "WriteCharacteristicAction#" + this.kko + "{serviceId='" + this.jJc + '\'' + ", characteristicId='" + this.kjZ + '\'' + ", value='" + this.value + '\'' + ", debug=" + this.aNj + ", mainThread=" + this.kjt + ", serial=" + this.kjv + '}';
    AppMethodBeat.o(144587);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.i
 * JD-Core Version:    0.7.0.1
 */