package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public final class j
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String rMT;
  private final Integer rMU;
  private final int rNb;
  private final String riE;
  private final String value;
  
  public j(String paramString1, String paramString2, Integer paramInteger, int paramInt, String paramString3)
  {
    this.riE = paramString1;
    this.rMT = paramString2;
    this.rMU = paramInteger;
    this.rNb = paramInt;
    this.value = paramString3;
  }
  
  public final void crh()
  {
    AppMethodBeat.i(144585);
    BluetoothGatt localBluetoothGatt = this.rNd.rMH;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      onResult(k.rNG);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if (!c.aar(this.riE))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", new Object[] { this });
      onResult(k.rNE);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    Object localObject = localBluetoothGatt.getService(UUID.fromString(this.riE));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      onResult(k.rNE);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if (!c.aar(this.rMT))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[] { this });
      onResult(k.rNF);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    byte[] arrayOfByte = null;
    UUID localUUID = UUID.fromString(this.rMT);
    if (this.rMU != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s, handle: %d", new Object[] { this, this.rMU });
      Iterator localIterator = ((BluetoothGattService)localObject).getCharacteristics().iterator();
      do
      {
        localObject = arrayOfByte;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (BluetoothGattCharacteristic)localIterator.next();
      } while ((!localUUID.equals(((BluetoothGattCharacteristic)localObject).getUuid())) || (this.rMU.intValue() != ((BluetoothGattCharacteristic)localObject).getInstanceId()));
    }
    while (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", new Object[] { this });
      onResult(k.rNF);
      done();
      AppMethodBeat.o(144585);
      return;
      localObject = ((BluetoothGattService)localObject).getCharacteristic(localUUID);
    }
    boolean bool1 = c.AC(((BluetoothGattCharacteristic)localObject).getProperties());
    boolean bool2 = c.AD(((BluetoothGattCharacteristic)localObject).getProperties());
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, writeType: %d, supportWrite: %b, supportWriteNoResponse: %b", new Object[] { this, Integer.valueOf(this.rNb), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((!bool1) && (!bool2))
    {
      onResult(k.rNH);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    if (((1 == this.rNb) && (!bool1)) || ((2 == this.rNb) && (!bool2)))
    {
      onResult(k.rNU);
      done();
      AppMethodBeat.o(144585);
      return;
    }
    int j = ((BluetoothGattCharacteristic)localObject).getWriteType();
    switch (this.rNb)
    {
    default: 
      arrayOfByte = c.aW(Base64.decode(this.value, 2));
      ((BluetoothGattCharacteristic)localObject).setValue(arrayOfByte);
      if (arrayOfByte == null) {
        break;
      }
    }
    for (int i = arrayOfByte.length;; i = 0)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "dataToWrite's length:%d", new Object[] { Integer.valueOf(i) });
      if (this.debug) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "dataToWrite:%s", new Object[] { Arrays.toString(arrayOfByte) });
      }
      if (localBluetoothGatt.writeCharacteristic((BluetoothGattCharacteristic)localObject)) {
        break label645;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeCharacteristic fail", new Object[] { this });
      ((BluetoothGattCharacteristic)localObject).setWriteType(j);
      onResult(k.rNI);
      done();
      AppMethodBeat.o(144585);
      return;
      ((BluetoothGattCharacteristic)localObject).setWriteType(2);
      break;
      ((BluetoothGattCharacteristic)localObject).setWriteType(1);
      break;
    }
    label645:
    ((BluetoothGattCharacteristic)localObject).setWriteType(j);
    AppMethodBeat.o(144585);
  }
  
  public final String getName()
  {
    return "WriteCharacteristicAction";
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144586);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onCharacteristicWrite status:%s", new Object[] { this, f.Ay(paramInt) });
    if (paramInt == 0) {
      onResult(k.rNz);
    }
    done();
    AppMethodBeat.o(144586);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144587);
    String str = "WriteCharacteristicAction#" + this.rNk + "{serviceId='" + this.riE + '\'' + ", characteristicId='" + this.rMT + '\'' + ", value='" + this.value + '\'' + ", debug=" + this.debug + ", mainThread=" + this.rMf + ", serial=" + this.rMh + '}';
    AppMethodBeat.o(144587);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.j
 * JD-Core Version:    0.7.0.1
 */