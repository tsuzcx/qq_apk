package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothGatt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/GetBLEDeviceRSSIAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "()V", "myTag", "", "doActionImpl", "", "getName", "onReadRemoteRssi", "gatt", "Landroid/bluetooth/BluetoothGatt;", "rssi", "", "status", "luggage-commons-jsapi-connectivity-ext_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String bqj;
  
  public d()
  {
    AppMethodBeat.i(183550);
    this.bqj = ("MicroMsg.AppBrand.GetBLEDeviceRSSIAction#" + hashCode());
    AppMethodBeat.o(183550);
  }
  
  public final void bQZ()
  {
    AppMethodBeat.i(175636);
    if (!c.bRm())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.bqj, "Bluetooth is not enable.", new Object[0]);
      a(j.oJL);
      done();
      AppMethodBeat.o(175636);
      return;
    }
    Object localObject = this.oJp;
    p.j(localObject, "worker");
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)localObject).bQV();
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.bqj, "bluetoothGatt is null", new Object[0]);
      a(j.oJQ);
      done();
      AppMethodBeat.o(175636);
      return;
    }
    if (!((BluetoothGatt)localObject).readRemoteRssi())
    {
      a(j.oJS);
      done();
    }
    AppMethodBeat.o(175636);
  }
  
  public final String getName()
  {
    return "GetBLEDeviceRSSIAction";
  }
  
  public final void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175637);
    super.onReadRemoteRssi(paramBluetoothGatt, paramInt1, paramInt2);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.bqj, "onReadRemoteRssi, rssi: %d, status: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != 0)
    {
      a(j.oJJ);
      done();
      AppMethodBeat.o(175637);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d locald = this.oJp;
    p.j(locald, "worker");
    if ((p.h(locald.bQV(), paramBluetoothGatt) ^ true))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.bqj, "bluetoothGatt is not match", new Object[0]);
      a(j.oJJ);
      done();
      AppMethodBeat.o(175637);
      return;
    }
    a(j.cF(Integer.valueOf(paramInt1)));
    done();
    AppMethodBeat.o(175637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.d
 * JD-Core Version:    0.7.0.1
 */