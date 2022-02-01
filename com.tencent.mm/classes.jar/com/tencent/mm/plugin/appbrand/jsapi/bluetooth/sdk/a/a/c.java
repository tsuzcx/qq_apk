package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothGatt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/GetBLEDeviceRSSIAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "()V", "myTag", "", "doActionImpl", "", "getName", "onReadRemoteRssi", "gatt", "Landroid/bluetooth/BluetoothGatt;", "rssi", "", "status", "luggage-commons-jsapi-connectivity-ext_release"})
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String kEX;
  
  public c()
  {
    AppMethodBeat.i(183550);
    this.kEX = ("MicroMsg.AppBrand.GetBLEDeviceRSSIAction#" + hashCode());
    AppMethodBeat.o(183550);
  }
  
  public final void bjq()
  {
    AppMethodBeat.i(175636);
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjz())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kEX, "Bluetooth is not enable.", new Object[0]);
      a(j.kFD);
      done();
      AppMethodBeat.o(175636);
      return;
    }
    Object localObject = this.kFh;
    p.g(localObject, "worker");
    localObject = ((d)localObject).bjp();
    if (localObject == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kEX, "bluetoothGatt is null", new Object[0]);
      a(j.kFI);
      done();
      AppMethodBeat.o(175636);
      return;
    }
    if (!((BluetoothGatt)localObject).readRemoteRssi())
    {
      a(j.kFK);
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
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.kEX, "onReadRemoteRssi, rssi: %d, status: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != 0)
    {
      a(j.kFB);
      done();
      AppMethodBeat.o(175637);
      return;
    }
    d locald = this.kFh;
    p.g(locald, "worker");
    if ((p.i(locald.bjp(), paramBluetoothGatt) ^ true))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kEX, "bluetoothGatt is not match", new Object[0]);
      a(j.kFB);
      done();
      AppMethodBeat.o(175637);
      return;
    }
    a(j.cv(Integer.valueOf(paramInt1)));
    done();
    AppMethodBeat.o(175637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.c
 * JD-Core Version:    0.7.0.1
 */