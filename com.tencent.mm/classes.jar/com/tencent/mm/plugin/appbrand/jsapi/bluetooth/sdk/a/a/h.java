package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/SetMtuAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "mtuSize", "", "deviceId", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "isTimeOut", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/Integer;", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "doActionImpl", "", "getName", "onMtuChanged", "gatt", "Landroid/bluetooth/BluetoothGatt;", "mtu", "status", "luggage-commons-jsapi-connectivity-ext_release"})
public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String dGL;
  final AtomicBoolean lMX;
  private final Integer lMY;
  private final MTimerHandler timerHandler;
  
  public h(Integer paramInteger, String paramString)
  {
    AppMethodBeat.i(144794);
    this.lMY = paramInteger;
    this.dGL = paramString;
    this.timerHandler = new MTimerHandler((MTimerHandler.CallBack)new a(this), false);
    this.lMX = new AtomicBoolean(false);
    AppMethodBeat.o(144794);
  }
  
  public final void bFt()
  {
    AppMethodBeat.i(144792);
    if (c.bFC() == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      a(j.lNC);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if ((this.dGL == null) || (!BluetoothAdapter.checkBluetoothAddress(this.dGL)) || (this.lMY == null))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, unspecified deviceId", new Object[] { this });
      a(j.lNL);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (!c.bFE())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "bluetooth is not enable.", new Object[0]);
      a(j.lNx);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    Object localObject = this.lNb;
    p.g(localObject, "worker");
    localObject = ((d)localObject).bFr();
    if (localObject == null)
    {
      a(j.lNC);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (this.lMY.intValue() > 512)
    {
      a(new j(10013, "fail:invalid data, DEFAULT_MAX_MTU = 512"));
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (this.lMY.intValue() < 23)
    {
      a(new j(10013, "fail:invalid data, DEFAULT_MIN_MTU = 23"));
      done();
      AppMethodBeat.o(144792);
      return;
    }
    if (!((BluetoothGatt)localObject).requestMtu(this.lMY.intValue()))
    {
      a(j.lNE);
      done();
      AppMethodBeat.o(144792);
      return;
    }
    this.timerHandler.startTimer(500L, 9223372036854775807L);
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
    if (this.lMX.get())
    {
      this.lMX.set(false);
      AppMethodBeat.o(144793);
      return;
    }
    Log.d("MicroMsg.Ble.Action", "onMtuChanged: mtu = %d, status = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramBluetoothGatt = this.lMY;
    if (paramBluetoothGatt == null) {}
    while ((paramInt1 != paramBluetoothGatt.intValue()) || (paramInt2 != 0))
    {
      a(j.lNv);
      done();
      AppMethodBeat.o(144793);
      return;
    }
    a(j.lNu);
    done();
    AppMethodBeat.o(144793);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements MTimerHandler.CallBack
  {
    a(h paramh) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(144791);
      this.lMZ.lMX.set(true);
      this.lMZ.a(j.lNJ);
      AppMethodBeat.o(144791);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.h
 * JD-Core Version:    0.7.0.1
 */