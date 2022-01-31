package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
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
  private final String gms;
  private final String gmt;
  private final String value;
  
  public f(String paramString1, String paramString2, String paramString3)
  {
    this.gms = paramString1;
    this.gmt = paramString2;
    this.value = paramString3;
  }
  
  public final void aiu()
  {
    BluetoothGatt localBluetoothGatt = this.gmv.gmp;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.gmW);
      done();
    }
    BluetoothGattCharacteristic localBluetoothGattCharacteristic;
    label593:
    label598:
    do
    {
      return;
      if (!b.tZ(this.gms))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", new Object[] { this });
        a(j.gmU);
        done();
        return;
      }
      Object localObject1 = localBluetoothGatt.getService(UUID.fromString(this.gms));
      if (localObject1 == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
        a(j.gmU);
        done();
        return;
      }
      if (!b.tZ(this.gmt))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[] { this });
        a(j.gmV);
        done();
        return;
      }
      localBluetoothGattCharacteristic = ((BluetoothGattService)localObject1).getCharacteristic(UUID.fromString(this.gmt));
      if (localBluetoothGattCharacteristic == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", new Object[] { this });
        a(j.gmV);
        done();
        return;
      }
      if ((!b.ln(localBluetoothGattCharacteristic.getProperties())) && (!b.lo(localBluetoothGattCharacteristic.getProperties())))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support write & writeNoResponse", new Object[] { this });
        a(j.gmX);
        done();
        return;
      }
      localObject1 = Base64.decode(this.value, 2);
      if ((localObject1 == null) || (localObject1.length == 0))
      {
        localObject1 = null;
        localBluetoothGattCharacteristic.setValue((byte[])localObject1);
        if (localObject1 == null) {
          break label593;
        }
      }
      for (int i = localObject1.length;; i = 0)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "dataToWrite's length:%d", new Object[] { Integer.valueOf(i) });
        if (this.apo) {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "dataToWrite:%s", new Object[] { Arrays.toString((byte[])localObject1) });
        }
        if (localBluetoothGatt.writeCharacteristic(localBluetoothGattCharacteristic)) {
          break label598;
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeCharacteristic fail", new Object[] { this });
        a(j.gmY);
        done();
        return;
        int j = localObject1.length;
        i = j;
        if (localObject1.length < j)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleHelper", "data length is shorter then print command length", new Object[0]);
          i = localObject1.length;
        }
        Object localObject2 = new StringBuilder();
        j = 0;
        int k;
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
        if ((localObject1 == null) || (((String)localObject1).equals("")))
        {
          localObject1 = new byte[0];
          break;
        }
        j = ((String)localObject1).toUpperCase().length() / 2;
        char[] arrayOfChar = ((String)localObject1).toCharArray();
        localObject2 = new byte[j];
        i = 0;
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
      }
    } while ((b.ln(localBluetoothGattCharacteristic.getProperties())) || (!b.lo(localBluetoothGattCharacteristic.getProperties())));
    a(j.gmO);
    done();
  }
  
  public final String getName()
  {
    return "WriteCharacteristicAction";
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onCharacteristicWrite status:%s", new Object[] { this, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f.lk(paramInt) });
    if (paramInt == 0) {
      a(j.gmO);
    }
    done();
  }
  
  public final String toString()
  {
    return "WriteCharacteristicAction{serviceId='" + this.gms + '\'' + ", characteristicId='" + this.gmt + '\'' + ", value='" + this.value + '\'' + ", debug=" + this.apo + ", mainThread=" + this.glS + ", serial=" + this.glU + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f
 * JD-Core Version:    0.7.0.1
 */