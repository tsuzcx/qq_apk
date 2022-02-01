package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/DiscoverServicesAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "deviceId", "", "(Ljava/lang/String;)V", "doActionImpl", "", "getName", "onServicesDiscovered", "gatt", "Landroid/bluetooth/BluetoothGatt;", "status", "", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String hEl;
  
  public c(String paramString)
  {
    AppMethodBeat.i(329718);
    this.hEl = paramString;
    AppMethodBeat.o(329718);
  }
  
  public final void crh()
  {
    AppMethodBeat.i(329724);
    if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.crs() == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, bluetoothAdapter is null", new Object[] { this });
      onResult(k.rND);
      done();
      AppMethodBeat.o(329724);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, bluetooth is not enable", new Object[] { this });
      onResult(k.rND);
      done();
      AppMethodBeat.o(329724);
      return;
    }
    if (!BluetoothAdapter.checkBluetoothAddress(this.hEl))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, unspecified deviceId", new Object[] { this });
      onResult(k.rNP);
      done();
      AppMethodBeat.o(329724);
      return;
    }
    BluetoothGatt localBluetoothGatt = this.rNd.rMH;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      onResult(k.rNG);
      done();
      AppMethodBeat.o(329724);
      return;
    }
    if (!localBluetoothGatt.discoverServices())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, discoverServices fail", new Object[] { this });
      onResult(k.rNI);
      done();
    }
    AppMethodBeat.o(329724);
  }
  
  public final String getName()
  {
    return "DiscoverServicesAction";
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(329725);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "[onServicesDiscovered] status:%s", new Object[] { f.Ay(paramInt) });
    if (paramInt == 0) {
      onResult(k.rNz);
    }
    for (;;)
    {
      done();
      AppMethodBeat.o(329725);
      return;
      onResult(k.rNQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.c
 * JD-Core Version:    0.7.0.1
 */