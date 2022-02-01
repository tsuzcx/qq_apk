package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.i.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AppBrandMonitoredBluetoothDeviceService$disableMonitorAsync$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandMonitoredBluetoothDeviceService$c
  implements h
{
  public final String getKey()
  {
    AppMethodBeat.i(321670);
    String str = s.X("DisableMonitorBluetoothDevice#", Integer.valueOf(hashCode()));
    AppMethodBeat.o(321670);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(321677);
    a locala = a.rgg;
    a.cmp();
    AppMethodBeat.o(321677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.AppBrandMonitoredBluetoothDeviceService.c
 * JD-Core Version:    0.7.0.1
 */