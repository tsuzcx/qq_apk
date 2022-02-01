package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import d.g.b.k;
import d.l;
import java.util.concurrent.atomic.AtomicBoolean;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/SetMtuAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "mtuSize", "", "deviceId", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "isTimeOut", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/Integer;", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "doActionImpl", "", "getName", "onMtuChanged", "gatt", "Landroid/bluetooth/BluetoothGatt;", "mtu", "status", "luggage-commons-jsapi-connectivity-ext_release"})
public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String cLR;
  final AtomicBoolean jJD;
  private final Integer jJE;
  private final av timerHandler;
  
  public h(Integer paramInteger, String paramString)
  {
    AppMethodBeat.i(144794);
    this.jJE = paramInteger;
    this.cLR = paramString;
    this.timerHandler = new av((av.a)new a(this), false);
    this.jJD = new AtomicBoolean(false);
    AppMethodBeat.o(144794);
  }
  
  public final void aYR()
  {
    AppMethodBeat.i(144792);
    if (c.aZb() == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.jKh);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if ((this.cLR == null) || (!BluetoothAdapter.checkBluetoothAddress(this.cLR)) || (this.jJE == null))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, unspecified deviceId", new Object[] { this });
      a(j.jKq);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (!c.aZd())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "bluetooth is not enable.", new Object[0]);
      a(j.jKc);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    Object localObject = this.jJH;
    k.g(localObject, "worker");
    localObject = ((d)localObject).aYP();
    if (localObject == null)
    {
      a(j.jKh);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (this.jJE.intValue() > 512)
    {
      a(new j(10013, "fail:invalid data, DEFAULT_MAX_MTU = 512"));
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (this.jJE.intValue() < 23)
    {
      a(new j(10013, "fail:invalid data, DEFAULT_MIN_MTU = 23"));
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (!((BluetoothGatt)localObject).requestMtu(this.jJE.intValue()))
    {
      a(j.jKj);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    this.timerHandler.av(500L, 9223372036854775807L);
    AppMethodBeat.o(144792);
  }
  
  public final String getName()
  {
    return "SetMtuAction";
  }
  
  public final void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144793);
    k.h(paramBluetoothGatt, "gatt");
    super.onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
    if (this.jJD.get())
    {
      this.jJD.set(false);
      AppMethodBeat.o(144793);
      return;
    }
    ad.d("MicroMsg.Ble.Action", "onMtuChanged: mtu = %d, status = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramBluetoothGatt = this.jJE;
    if (paramBluetoothGatt == null) {}
    while ((paramInt1 != paramBluetoothGatt.intValue()) || (paramInt2 != 0))
    {
      a(j.jKa);
      done();
      AppMethodBeat.o(144793);
      return;
    }
    a(j.jJZ);
    done();
    AppMethodBeat.o(144793);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements av.a
  {
    a(h paramh) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(144791);
      this.jJF.jJD.set(true);
      this.jJF.a(j.jKo);
      AppMethodBeat.o(144791);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.h
 * JD-Core Version:    0.7.0.1
 */