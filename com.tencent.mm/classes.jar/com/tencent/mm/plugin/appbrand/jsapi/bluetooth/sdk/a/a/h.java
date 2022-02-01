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
import d.g.b.p;
import d.l;
import java.util.concurrent.atomic.AtomicBoolean;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/SetMtuAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "mtuSize", "", "deviceId", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "isTimeOut", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/Integer;", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "doActionImpl", "", "getName", "onMtuChanged", "gatt", "Landroid/bluetooth/BluetoothGatt;", "mtu", "status", "luggage-commons-jsapi-connectivity-ext_release"})
public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String cUi;
  final AtomicBoolean kFd;
  private final Integer kFe;
  private final av timerHandler;
  
  public h(Integer paramInteger, String paramString)
  {
    AppMethodBeat.i(144794);
    this.kFe = paramInteger;
    this.cUi = paramString;
    this.timerHandler = new av((av.a)new a(this), false);
    this.kFd = new AtomicBoolean(false);
    AppMethodBeat.o(144794);
  }
  
  public final void bjq()
  {
    AppMethodBeat.i(144792);
    if (c.bjx() == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.kFI);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if ((this.cUi == null) || (!BluetoothAdapter.checkBluetoothAddress(this.cUi)) || (this.kFe == null))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, unspecified deviceId", new Object[] { this });
      a(j.kFR);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (!c.bjz())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "bluetooth is not enable.", new Object[0]);
      a(j.kFD);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    Object localObject = this.kFh;
    p.g(localObject, "worker");
    if (((d)localObject).bjp() == null)
    {
      a(j.kFI);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    localObject = this.kFh;
    p.g(localObject, "worker");
    localObject = ((d)localObject).bjp();
    if (this.kFe.intValue() > 512)
    {
      a(new j(10013, "fail:invalid data, DEFAULT_MAX_MTU = 512"));
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (this.kFe.intValue() < 23)
    {
      a(new j(10013, "fail:invalid data, DEFAULT_MIN_MTU = 23"));
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (!((BluetoothGatt)localObject).requestMtu(this.kFe.intValue()))
    {
      a(j.kFK);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    this.timerHandler.az(500L, 9223372036854775807L);
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
    if (this.kFd.get())
    {
      this.kFd.set(false);
      AppMethodBeat.o(144793);
      return;
    }
    ad.d("MicroMsg.Ble.Action", "onMtuChanged: mtu = %d, status = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramBluetoothGatt = this.kFe;
    if (paramBluetoothGatt == null) {}
    while ((paramInt1 != paramBluetoothGatt.intValue()) || (paramInt2 != 0))
    {
      a(j.kFB);
      done();
      AppMethodBeat.o(144793);
      return;
    }
    a(j.kFA);
    done();
    AppMethodBeat.o(144793);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements av.a
  {
    a(h paramh) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(144791);
      this.kFf.kFd.set(true);
      this.kFf.a(j.kFP);
      AppMethodBeat.o(144791);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.h
 * JD-Core Version:    0.7.0.1
 */