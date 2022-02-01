package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.i.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AppBrandMonitoredBluetoothDeviceService$getAllInfoAsync$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandMonitoredBluetoothDeviceService$e
  implements h
{
  AppBrandMonitoredBluetoothDeviceService$e(b<? super Result<? extends List<MonitoredBluetoothDeviceInfo>>, ah> paramb) {}
  
  public final String getKey()
  {
    AppMethodBeat.i(321704);
    String str = s.X("GetAllMonitoredBluetoothDeviceInfo#", Integer.valueOf(hashCode()));
    AppMethodBeat.o(321704);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(321709);
    b localb = this.$callback;
    Object localObject = Result.Companion;
    localObject = a.rgg;
    localb.invoke(Result.box-impl(Result.constructor-impl(a.cmq())));
    AppMethodBeat.o(321709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.AppBrandMonitoredBluetoothDeviceService.e
 * JD-Core Version:    0.7.0.1
 */