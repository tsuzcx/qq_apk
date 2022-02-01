package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import java.util.Arrays;
import java.util.UUID;

@TargetApi(18)
public final class j
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String oJh;
  private final String oeZ;
  private final String value;
  
  public j(String paramString1, String paramString2, String paramString3)
  {
    this.oeZ = paramString1;
    this.oJh = paramString2;
    this.value = paramString3;
  }
  
  public final void bQZ()
  {
    AppMethodBeat.i(144585);
    BluetoothGatt localBluetoothGatt = this.oJp.oIW;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j.oJQ);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if (!c.ahv(this.oeZ))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", new Object[] { this });
      a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j.oJO);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    Object localObject = localBluetoothGatt.getService(UUID.fromString(this.oeZ));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j.oJO);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if (!c.ahv(this.oJh))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[] { this });
      a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j.oJP);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    localObject = ((BluetoothGattService)localObject).getCharacteristic(UUID.fromString(this.oJh));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", new Object[] { this });
      a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j.oJP);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if ((!c.Al(((BluetoothGattCharacteristic)localObject).getProperties())) && (!c.Am(((BluetoothGattCharacteristic)localObject).getProperties())))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support write & writeNoResponse", new Object[] { this });
      a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j.oJR);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    byte[] arrayOfByte = c.aW(Base64.decode(this.value, 2));
    ((BluetoothGattCharacteristic)localObject).setValue(arrayOfByte);
    if (arrayOfByte != null) {}
    for (int i = arrayOfByte.length;; i = 0)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "dataToWrite's length:%d", new Object[] { Integer.valueOf(i) });
      if (this.aGM) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "dataToWrite:%s", new Object[] { Arrays.toString(arrayOfByte) });
      }
      if (localBluetoothGatt.writeCharacteristic((BluetoothGattCharacteristic)localObject)) {
        break;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeCharacteristic fail", new Object[] { this });
      a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j.oJS);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if ((!c.Al(((BluetoothGattCharacteristic)localObject).getProperties())) && (c.Am(((BluetoothGattCharacteristic)localObject).getProperties())))
    {
      a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j.oJI);
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
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onCharacteristicWrite status:%s", new Object[] { this, f.Ah(paramInt) });
    if (paramInt == 0) {
      a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j.oJI);
    }
    done();
    AppMethodBeat.o(144586);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144587);
    String str = "WriteCharacteristicAction#" + this.oJw + "{serviceId='" + this.oeZ + '\'' + ", characteristicId='" + this.oJh + '\'' + ", value='" + this.value + '\'' + ", debug=" + this.aGM + ", mainThread=" + this.oIw + ", serial=" + this.oIy + '}';
    AppMethodBeat.o(144587);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.j
 * JD-Core Version:    0.7.0.1
 */