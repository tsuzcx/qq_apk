package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/DiscoverServicesAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "deviceId", "", "(Ljava/lang/String;)V", "doActionImpl", "", "getName", "onServicesDiscovered", "gatt", "Landroid/bluetooth/BluetoothGatt;", "status", "", "luggage-commons-jsapi-connectivity-ext_release"})
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String fzB;
  
  public c(String paramString)
  {
    AppMethodBeat.i(200000);
    this.fzB = paramString;
    AppMethodBeat.o(200000);
  }
  
  public final void bQZ()
  {
    AppMethodBeat.i(199992);
    if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRk() == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, bluetoothAdapter is null", new Object[] { this });
      a(j.oJL);
      done();
      AppMethodBeat.o(199992);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRm())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, bluetooth is not enable", new Object[] { this });
      a(j.oJL);
      done();
      AppMethodBeat.o(199992);
      return;
    }
    if (!BluetoothAdapter.checkBluetoothAddress(this.fzB))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, unspecified deviceId", new Object[] { this });
      a(j.oJZ);
      done();
      AppMethodBeat.o(199992);
      return;
    }
    Object localObject = this.oJp;
    p.j(localObject, "worker");
    localObject = ((d)localObject).bQV();
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      a(j.oJQ);
      done();
      AppMethodBeat.o(199992);
      return;
    }
    if (!((BluetoothGatt)localObject).discoverServices())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, discoverServices fail", new Object[] { this });
      a(j.oJS);
      done();
    }
    AppMethodBeat.o(199992);
  }
  
  public final String getName()
  {
    return "DiscoverServicesAction";
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(199997);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "[onServicesDiscovered] status:%s", new Object[] { f.Ah(paramInt) });
    if (paramInt == 0) {
      a(j.oJI);
    }
    for (;;)
    {
      done();
      AppMethodBeat.o(199997);
      return;
      a(j.oKa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.c
 * JD-Core Version:    0.7.0.1
 */