package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

@TargetApi(18)
public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String hGs;
  private final String hGt;
  private final String value;
  
  public f(String paramString1, String paramString2, String paramString3)
  {
    this.hGs = paramString1;
    this.hGt = paramString2;
    this.value = paramString3;
  }
  
  public final void aCo()
  {
    AppMethodBeat.i(94273);
    BluetoothGatt localBluetoothGatt = this.hGv.hGn;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.hGV);
      done();
      AppMethodBeat.o(94273);
      return;
    }
    if (!b.BY(this.hGs))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", new Object[] { this });
      a(j.hGT);
      done();
      AppMethodBeat.o(94273);
      return;
    }
    Object localObject1 = localBluetoothGatt.getService(UUID.fromString(this.hGs));
    if (localObject1 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      a(j.hGT);
      done();
      AppMethodBeat.o(94273);
      return;
    }
    if (!b.BY(this.hGt))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[] { this });
      a(j.hGU);
      done();
      AppMethodBeat.o(94273);
      return;
    }
    BluetoothGattCharacteristic localBluetoothGattCharacteristic = ((BluetoothGattService)localObject1).getCharacteristic(UUID.fromString(this.hGt));
    if (localBluetoothGattCharacteristic == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", new Object[] { this });
      a(j.hGU);
      done();
      AppMethodBeat.o(94273);
      return;
    }
    if ((!b.nX(localBluetoothGattCharacteristic.getProperties())) && (!b.nY(localBluetoothGattCharacteristic.getProperties())))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support write & writeNoResponse", new Object[] { this });
      a(j.hGW);
      done();
      AppMethodBeat.o(94273);
      return;
    }
    localObject1 = Base64.decode(this.value, 2);
    if ((localObject1 == null) || (localObject1.length == 0)) {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleHelper", "data is null", new Object[0]);
    }
    int k;
    for (localObject1 = new byte[0];; localObject1 = new byte[0])
    {
      localBluetoothGattCharacteristic.setValue((byte[])localObject1);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "dataToWrite's length:%d", new Object[] { Integer.valueOf(localObject1.length) });
      if (this.arI) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "dataToWrite:%s", new Object[] { Arrays.toString((byte[])localObject1) });
      }
      if (localBluetoothGatt.writeCharacteristic(localBluetoothGattCharacteristic)) {
        break label639;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeCharacteristic fail", new Object[] { this });
      a(j.hGX);
      done();
      AppMethodBeat.o(94273);
      return;
      j = localObject1.length;
      i = j;
      if (localObject1.length < j)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleHelper", "data length is shorter then print command length", new Object[0]);
        i = localObject1.length;
      }
      localObject2 = new StringBuilder();
      j = 0;
      while (j < i)
      {
        k = localObject1[j] & 0xFF;
        if (k < 16) {
          ((StringBuilder)localObject2).append("0");
        }
        ((StringBuilder)localObject2).append(Integer.toHexString(k));
        j += 1;
      }
      localObject1 = ((StringBuilder)localObject2).toString().toUpperCase(Locale.US);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.d("MicroMsg.Ble.BleHelper", "write data = %s", new Object[] { localObject1 });
      if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
        break;
      }
    }
    int j = ((String)localObject1).toUpperCase().length() / 2;
    char[] arrayOfChar = ((String)localObject1).toCharArray();
    Object localObject2 = new byte[j];
    int i = 0;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= j) {
        break;
      }
      k = i * 2;
      int m = (byte)"0123456789ABCDEF".indexOf(arrayOfChar[k]);
      localObject2[i] = ((byte)((byte)"0123456789ABCDEF".indexOf(arrayOfChar[(k + 1)]) | m << 4));
      i += 1;
    }
    label639:
    if ((!b.nX(localBluetoothGattCharacteristic.getProperties())) && (b.nY(localBluetoothGattCharacteristic.getProperties())))
    {
      a(j.hGN);
      done();
    }
    AppMethodBeat.o(94273);
  }
  
  public final String getName()
  {
    return "WriteCharacteristicAction";
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(94274);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onCharacteristicWrite status:%s", new Object[] { this, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f.nT(paramInt) });
    if (paramInt == 0) {
      a(j.hGN);
    }
    done();
    AppMethodBeat.o(94274);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94275);
    String str = "WriteCharacteristicAction{serviceId='" + this.hGs + '\'' + ", characteristicId='" + this.hGt + '\'' + ", value='" + this.value + '\'' + ", debug=" + this.arI + ", mainThread=" + this.hFR + ", serial=" + this.hFT + '}';
    AppMethodBeat.o(94275);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f
 * JD-Core Version:    0.7.0.1
 */