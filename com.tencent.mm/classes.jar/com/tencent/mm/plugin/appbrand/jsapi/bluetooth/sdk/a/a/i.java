package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/SetMtuAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "mtuSize", "", "deviceId", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "Ljava/lang/Integer;", "doActionImpl", "", "getName", "onMtuChanged", "gatt", "Landroid/bluetooth/BluetoothGatt;", "mtu", "status", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String hEl;
  private final Integer rNa;
  
  public i(Integer paramInteger, String paramString)
  {
    AppMethodBeat.i(144794);
    this.rNa = paramInteger;
    this.hEl = paramString;
    AppMethodBeat.o(144794);
  }
  
  public final void crh()
  {
    AppMethodBeat.i(144792);
    if (c.crs() == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothAdapter is null", new Object[] { this });
      onResult(k.rND);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if ((this.hEl == null) || (!BluetoothAdapter.checkBluetoothAddress(this.hEl)) || (this.rNa == null))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, unspecified deviceId", new Object[] { this });
      onResult(k.rNP);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (!c.cru())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "bluetooth is not enable.", new Object[0]);
      onResult(k.rND);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    BluetoothGatt localBluetoothGatt = this.rNd.rMH;
    if (localBluetoothGatt == null)
    {
      onResult(k.rNG);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (this.rNa.intValue() > 512)
    {
      onResult(new k(10013, "fail:invalid data, DEFAULT_MAX_MTU = 512", a.e.rVz));
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (this.rNa.intValue() < 23)
    {
      onResult(new k(10013, "fail:invalid data, DEFAULT_MIN_MTU = 23", a.e.rVz));
      done();
      AppMethodBeat.o(144792);
      return;
    }
    int i = this.rNd.rML;
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:" + this + ", mtuSize: " + this.rNa + ", curMtu: " + i, new Object[0]);
    Integer localInteger = this.rNa;
    if (localInteger == null) {}
    while (!localBluetoothGatt.requestMtu(this.rNa.intValue()))
    {
      onResult(k.rNI);
      done();
      AppMethodBeat.o(144792);
      return;
      if (localInteger.intValue() == i)
      {
        onResult(k.ea(Integer.valueOf(i)));
        done();
        AppMethodBeat.o(144792);
        return;
      }
    }
    AppMethodBeat.o(144792);
  }
  
  public final String getName()
  {
    return "SetMtuAction";
  }
  
  public final void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144793);
    s.u(paramBluetoothGatt, "gatt");
    super.onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
    Log.d("MicroMsg.Ble.Action", "onMtuChanged: mtu = %d, status = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == 0)
    {
      paramBluetoothGatt = this.rNa;
      if (paramBluetoothGatt == null) {
        onResult(k.eb(Integer.valueOf(paramInt1)));
      }
    }
    for (;;)
    {
      done();
      AppMethodBeat.o(144793);
      return;
      if (paramInt1 != paramBluetoothGatt.intValue()) {
        break;
      }
      onResult(k.ea(Integer.valueOf(paramInt1)));
      continue;
      onResult(k.rNB);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.i
 * JD-Core Version:    0.7.0.1
 */