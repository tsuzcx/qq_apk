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
  private final String jJz;
  private final String jiP;
  private final String value;
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    this.jiP = paramString1;
    this.jJz = paramString2;
    this.value = paramString3;
  }
  
  public final void aYR()
  {
    AppMethodBeat.i(144585);
    BluetoothGatt localBluetoothGatt = this.jJH.jJp;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.jKh);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if (!c.HX(this.jiP))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", new Object[] { this });
      a(j.jKf);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    Object localObject = localBluetoothGatt.getService(UUID.fromString(this.jiP));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      a(j.jKf);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if (!c.HX(this.jJz))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[] { this });
      a(j.jKg);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    localObject = ((BluetoothGattService)localObject).getCharacteristic(UUID.fromString(this.jJz));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", new Object[] { this });
      a(j.jKg);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if ((!c.rF(((BluetoothGattCharacteristic)localObject).getProperties())) && (!c.rG(((BluetoothGattCharacteristic)localObject).getProperties())))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support write & writeNoResponse", new Object[] { this });
      a(j.jKi);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    byte[] arrayOfByte = c.au(Base64.decode(this.value, 2));
    ((BluetoothGattCharacteristic)localObject).setValue(arrayOfByte);
    if (arrayOfByte != null) {}
    for (int i = arrayOfByte.length;; i = 0)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "dataToWrite's length:%d", new Object[] { Integer.valueOf(i) });
      if (this.aMt) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "dataToWrite:%s", new Object[] { Arrays.toString(arrayOfByte) });
      }
      if (localBluetoothGatt.writeCharacteristic((BluetoothGattCharacteristic)localObject)) {
        break;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeCharacteristic fail", new Object[] { this });
      a(j.jKj);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if ((!c.rF(((BluetoothGattCharacteristic)localObject).getProperties())) && (c.rG(((BluetoothGattCharacteristic)localObject).getProperties())))
    {
      a(j.jJZ);
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
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onCharacteristicWrite status:%s", new Object[] { this, f.rB(paramInt) });
    if (paramInt == 0) {
      a(j.jJZ);
    }
    done();
    AppMethodBeat.o(144586);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144587);
    String str = "WriteCharacteristicAction#" + this.jJO + "{serviceId='" + this.jiP + '\'' + ", characteristicId='" + this.jJz + '\'' + ", value='" + this.value + '\'' + ", debug=" + this.aMt + ", mainThread=" + this.jIS + ", serial=" + this.jIU + '}';
    AppMethodBeat.o(144587);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.i
 * JD-Core Version:    0.7.0.1
 */