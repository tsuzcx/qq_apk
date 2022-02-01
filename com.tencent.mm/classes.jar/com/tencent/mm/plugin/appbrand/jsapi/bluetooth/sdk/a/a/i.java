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
  private final String lMR;
  private final String lko;
  private final String value;
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    this.lko = paramString1;
    this.lMR = paramString2;
    this.value = paramString3;
  }
  
  public final void bFt()
  {
    AppMethodBeat.i(144585);
    BluetoothGatt localBluetoothGatt = this.lNb.lMG;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.lNC);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if (!c.ZH(this.lko))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", new Object[] { this });
      a(j.lNA);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    Object localObject = localBluetoothGatt.getService(UUID.fromString(this.lko));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      a(j.lNA);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if (!c.ZH(this.lMR))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[] { this });
      a(j.lNB);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    localObject = ((BluetoothGattService)localObject).getCharacteristic(UUID.fromString(this.lMR));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", new Object[] { this });
      a(j.lNB);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if ((!c.wV(((BluetoothGattCharacteristic)localObject).getProperties())) && (!c.wW(((BluetoothGattCharacteristic)localObject).getProperties())))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support write & writeNoResponse", new Object[] { this });
      a(j.lND);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    byte[] arrayOfByte = c.aK(Base64.decode(this.value, 2));
    ((BluetoothGattCharacteristic)localObject).setValue(arrayOfByte);
    if (arrayOfByte != null) {}
    for (int i = arrayOfByte.length;; i = 0)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "dataToWrite's length:%d", new Object[] { Integer.valueOf(i) });
      if (this.aXs) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "dataToWrite:%s", new Object[] { Arrays.toString(arrayOfByte) });
      }
      if (localBluetoothGatt.writeCharacteristic((BluetoothGattCharacteristic)localObject)) {
        break;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeCharacteristic fail", new Object[] { this });
      a(j.lNE);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if ((!c.wV(((BluetoothGattCharacteristic)localObject).getProperties())) && (c.wW(((BluetoothGattCharacteristic)localObject).getProperties())))
    {
      a(j.lNu);
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
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onCharacteristicWrite status:%s", new Object[] { this, f.wR(paramInt) });
    if (paramInt == 0) {
      a(j.lNu);
    }
    done();
    AppMethodBeat.o(144586);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144587);
    String str = "WriteCharacteristicAction#" + this.lNi + "{serviceId='" + this.lko + '\'' + ", characteristicId='" + this.lMR + '\'' + ", value='" + this.value + '\'' + ", debug=" + this.aXs + ", mainThread=" + this.lMh + ", serial=" + this.lMj + '}';
    AppMethodBeat.o(144587);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.i
 * JD-Core Version:    0.7.0.1
 */