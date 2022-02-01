package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.i.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AppBrandMonitoredBluetoothDeviceService$deleteAppInfoAsync$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandMonitoredBluetoothDeviceService$a
  implements h
{
  AppBrandMonitoredBluetoothDeviceService$a(String paramString, int paramInt) {}
  
  public final String getKey()
  {
    AppMethodBeat.i(321669);
    String str = "DeleteMonitoredBluetoothDeviceInfoFor" + this.eug + '#' + this.qJR + '#' + hashCode();
    AppMethodBeat.o(321669);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(321678);
    a locala = a.rgg;
    a.ct(this.eug, this.qJR);
    AppMethodBeat.o(321678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.AppBrandMonitoredBluetoothDeviceService.a
 * JD-Core Version:    0.7.0.1
 */