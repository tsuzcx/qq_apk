package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothGatt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/GetBLEDeviceRSSIAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "()V", "myTag", "", "doActionImpl", "", "getName", "onReadRemoteRssi", "gatt", "Landroid/bluetooth/BluetoothGatt;", "rssi", "", "status", "luggage-commons-jsapi-connectivity-ext_release"})
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String lMQ;
  
  public c()
  {
    AppMethodBeat.i(183550);
    this.lMQ = ("MicroMsg.AppBrand.GetBLEDeviceRSSIAction#" + hashCode());
    AppMethodBeat.o(183550);
  }
  
  public final void bFt()
  {
    AppMethodBeat.i(175636);
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "Bluetooth is not enable.", new Object[0]);
      a(j.lNx);
      done();
      AppMethodBeat.o(175636);
      return;
    }
    Object localObject = this.lNb;
    p.g(localObject, "worker");
    localObject = ((d)localObject).bFr();
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "bluetoothGatt is null", new Object[0]);
      a(j.lNC);
      done();
      AppMethodBeat.o(175636);
      return;
    }
    if (!((BluetoothGatt)localObject).readRemoteRssi())
    {
      a(j.lNE);
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
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.lMQ, "onReadRemoteRssi, rssi: %d, status: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != 0)
    {
      a(j.lNv);
      done();
      AppMethodBeat.o(175637);
      return;
    }
    d locald = this.lNb;
    p.g(locald, "worker");
    if ((p.j(locald.bFr(), paramBluetoothGatt) ^ true))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "bluetoothGatt is not match", new Object[0]);
      a(j.lNv);
      done();
      AppMethodBeat.o(175637);
      return;
    }
    a(j.cF(Integer.valueOf(paramInt1)));
    done();
    AppMethodBeat.o(175637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.c
 * JD-Core Version:    0.7.0.1
 */