package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import d.g.b.p;
import d.l;
import java.util.concurrent.atomic.AtomicBoolean;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/SetMtuAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "mtuSize", "", "deviceId", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "isTimeOut", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/Integer;", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "doActionImpl", "", "getName", "onMtuChanged", "gatt", "Landroid/bluetooth/BluetoothGatt;", "mtu", "status", "luggage-commons-jsapi-connectivity-ext_release"})
public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String cVh;
  final AtomicBoolean kIs;
  private final Integer kIt;
  private final aw timerHandler;
  
  public h(Integer paramInteger, String paramString)
  {
    AppMethodBeat.i(144794);
    this.kIt = paramInteger;
    this.cVh = paramString;
    this.timerHandler = new aw((aw.a)new a(this), false);
    this.kIs = new AtomicBoolean(false);
    AppMethodBeat.o(144794);
  }
  
  public final void bjZ()
  {
    AppMethodBeat.i(144792);
    if (c.bkg() == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.kIX);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if ((this.cVh == null) || (!BluetoothAdapter.checkBluetoothAddress(this.cVh)) || (this.kIt == null))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, unspecified deviceId", new Object[] { this });
      a(j.kJg);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (!c.bki())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "bluetooth is not enable.", new Object[0]);
      a(j.kIS);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    Object localObject = this.kIw;
    p.g(localObject, "worker");
    if (((d)localObject).bjY() == null)
    {
      a(j.kIX);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    localObject = this.kIw;
    p.g(localObject, "worker");
    localObject = ((d)localObject).bjY();
    if (this.kIt.intValue() > 512)
    {
      a(new j(10013, "fail:invalid data, DEFAULT_MAX_MTU = 512"));
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (this.kIt.intValue() < 23)
    {
      a(new j(10013, "fail:invalid data, DEFAULT_MIN_MTU = 23"));
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (!((BluetoothGatt)localObject).requestMtu(this.kIt.intValue()))
    {
      a(j.kIZ);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    this.timerHandler.ay(500L, 9223372036854775807L);
    AppMethodBeat.o(144792);
  }
  
  public final String getName()
  {
    return "SetMtuAction";
  }
  
  public final void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144793);
    p.h(paramBluetoothGatt, "gatt");
    super.onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
    if (this.kIs.get())
    {
      this.kIs.set(false);
      AppMethodBeat.o(144793);
      return;
    }
    ae.d("MicroMsg.Ble.Action", "onMtuChanged: mtu = %d, status = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramBluetoothGatt = this.kIt;
    if (paramBluetoothGatt == null) {}
    while ((paramInt1 != paramBluetoothGatt.intValue()) || (paramInt2 != 0))
    {
      a(j.kIQ);
      done();
      AppMethodBeat.o(144793);
      return;
    }
    a(j.kIP);
    done();
    AppMethodBeat.o(144793);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements aw.a
  {
    a(h paramh) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(144791);
      this.kIu.kIs.set(true);
      this.kIu.a(j.kJe);
      AppMethodBeat.o(144791);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.h
 * JD-Core Version:    0.7.0.1
 */