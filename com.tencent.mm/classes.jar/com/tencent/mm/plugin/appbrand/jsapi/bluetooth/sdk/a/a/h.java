package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String rMT;
  private final Integer rMU;
  private final String riE;
  
  public h(String paramString1, String paramString2, Integer paramInteger)
  {
    this.riE = paramString1;
    this.rMT = paramString2;
    this.rMU = paramInteger;
  }
  
  public final void crh()
  {
    AppMethodBeat.i(144582);
    BluetoothGatt localBluetoothGatt = this.rNd.rMH;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      onResult(k.rNG);
      done();
      AppMethodBeat.o(144582);
      return;
    }
    if (!c.aar(this.riE))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", new Object[] { this });
      onResult(k.rNE);
      done();
      AppMethodBeat.o(144582);
      return;
    }
    Object localObject = localBluetoothGatt.getService(UUID.fromString(this.riE));
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      onResult(k.rNE);
      done();
      AppMethodBeat.o(144582);
      return;
    }
    if (!c.aar(this.rMT))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[] { this });
      onResult(k.rNF);
      done();
      AppMethodBeat.o(144582);
      return;
    }
    UUID localUUID = UUID.fromString(this.rMT);
    if (this.rMU != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s, handle: %d", new Object[] { this, this.rMU });
      Iterator localIterator = ((BluetoothGattService)localObject).getCharacteristics().iterator();
      do
      {
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
      AppMethodBeat.o(144582);
      return;
      localObject = null;
      continue;
      localObject = ((BluetoothGattService)localObject).getCharacteristic(localUUID);
    }
    if (!c.AB(((BluetoothGattCharacteristic)localObject).getProperties()))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support read", new Object[] { this });
      onResult(k.rNH);
      done();
      AppMethodBeat.o(144582);
      return;
    }
    if (!localBluetoothGatt.readCharacteristic((BluetoothGattCharacteristic)localObject))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.readCharacteristic fail", new Object[] { this });
      onResult(k.rNI);
      done();
      AppMethodBeat.o(144582);
      return;
    }
    onResult(k.rNz);
    AppMethodBeat.o(144582);
  }
  
  public final String getName()
  {
    return "ReadCharacteristicAction";
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144583);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onCharacteristicRead status:%s", new Object[] { this, f.Ay(paramInt) });
    done();
    AppMethodBeat.o(144583);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144584);
    String str = "ReadCharacteristicAction#" + this.rNk + "{serviceId='" + this.riE + '\'' + ", characteristicId='" + this.rMT + '\'' + ", debug=" + this.debug + ", mainThread=" + this.rMf + ", serial=" + this.rMh + '}';
    AppMethodBeat.o(144584);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.h
 * JD-Core Version:    0.7.0.1
 */