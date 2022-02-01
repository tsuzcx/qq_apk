package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import d.g.b.k;
import d.l;
import java.util.concurrent.atomic.AtomicBoolean;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/SetMtuAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "mtuSize", "", "deviceId", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "isTimeOut", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/Integer;", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "doActionImpl", "", "getName", "onMtuChanged", "gatt", "Landroid/bluetooth/BluetoothGatt;", "mtu", "status", "luggage-commons-jsapi-connectivity-ext_release"})
public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String cIZ;
  final AtomicBoolean kkd;
  private final Integer kke;
  private final au timerHandler;
  
  public h(Integer paramInteger, String paramString)
  {
    AppMethodBeat.i(144794);
    this.kke = paramInteger;
    this.cIZ = paramString;
    this.timerHandler = new au((au.a)new a(this), false);
    this.kkd = new AtomicBoolean(false);
    AppMethodBeat.o(144794);
  }
  
  public final void bfM()
  {
    AppMethodBeat.i(144792);
    if (c.bfT() == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.kkI);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if ((this.cIZ == null) || (!BluetoothAdapter.checkBluetoothAddress(this.cIZ)) || (this.kke == null))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, unspecified deviceId", new Object[] { this });
      a(j.kkR);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (!c.bfV())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "bluetooth is not enable.", new Object[0]);
      a(j.kkD);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    Object localObject = this.kkh;
    k.g(localObject, "worker");
    if (((d)localObject).bfL() == null)
    {
      a(j.kkI);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    localObject = this.kkh;
    k.g(localObject, "worker");
    localObject = ((d)localObject).bfL();
    if (this.kke.intValue() > 512)
    {
      a(new j(10013, "fail:invalid data, DEFAULT_MAX_MTU = 512"));
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (this.kke.intValue() < 23)
    {
      a(new j(10013, "fail:invalid data, DEFAULT_MIN_MTU = 23"));
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (!((BluetoothGatt)localObject).requestMtu(this.kke.intValue()))
    {
      a(j.kkK);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    this.timerHandler.au(500L, 9223372036854775807L);
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
    if (this.kkd.get())
    {
      this.kkd.set(false);
      AppMethodBeat.o(144793);
      return;
    }
    ac.d("MicroMsg.Ble.Action", "onMtuChanged: mtu = %d, status = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramBluetoothGatt = this.kke;
    if (paramBluetoothGatt == null) {}
    while ((paramInt1 != paramBluetoothGatt.intValue()) || (paramInt2 != 0))
    {
      a(j.kkB);
      done();
      AppMethodBeat.o(144793);
      return;
    }
    a(j.kkA);
    done();
    AppMethodBeat.o(144793);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements au.a
  {
    a(h paramh) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(144791);
      this.kkf.kkd.set(true);
      this.kkf.a(j.kkP);
      AppMethodBeat.o(144791);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.h
 * JD-Core Version:    0.7.0.1
 */