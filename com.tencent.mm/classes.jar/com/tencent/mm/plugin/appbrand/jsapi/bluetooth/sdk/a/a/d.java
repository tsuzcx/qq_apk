package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothGatt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/GetBLEDeviceRSSIAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "()V", "myTag", "", "doActionImpl", "", "getName", "onReadRemoteRssi", "gatt", "Landroid/bluetooth/BluetoothGatt;", "rssi", "", "status", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String djQ;
  
  public d()
  {
    AppMethodBeat.i(183550);
    this.djQ = s.X("MicroMsg.Ble.Action#", Integer.valueOf(hashCode()));
    AppMethodBeat.o(183550);
  }
  
  public final void crh()
  {
    AppMethodBeat.i(175636);
    if (!c.cru())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.djQ, "Bluetooth is not enable.", new Object[0]);
      onResult(k.rND);
      done();
      AppMethodBeat.o(175636);
      return;
    }
    BluetoothGatt localBluetoothGatt = this.rNd.rMH;
    if (localBluetoothGatt == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.djQ, "bluetoothGatt is null", new Object[0]);
      onResult(k.rNG);
      done();
      AppMethodBeat.o(175636);
      return;
    }
    if (!localBluetoothGatt.readRemoteRssi())
    {
      onResult(k.rNI);
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
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.djQ, "onReadRemoteRssi, rssi: %d, status: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != 0)
    {
      onResult(k.rNB);
      done();
      AppMethodBeat.o(175637);
      return;
    }
    if (!s.p(this.rNd.rMH, paramBluetoothGatt))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.djQ, "bluetoothGatt is not match", new Object[0]);
      onResult(k.rNB);
      done();
      AppMethodBeat.o(175637);
      return;
    }
    onResult(k.ea(Integer.valueOf(paramInt1)));
    done();
    AppMethodBeat.o(175637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.d
 * JD-Core Version:    0.7.0.1
 */