package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.y;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "appService", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;"}, k=3, mv={1, 5, 1}, xi=48)
final class h$c
  extends u
  implements kotlin.g.a.b<y, ah>
{
  h$c(boolean paramBoolean, MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo)
  {
    super(1);
  }
  
  private static final void e(MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo)
  {
    AppMethodBeat.i(321729);
    Object localObject = AppBrandMonitoredBluetoothDeviceService.rgb;
    localObject = paramMonitoredBluetoothDeviceInfo.field_appId;
    s.s(localObject, "field_appId");
    AppBrandMonitoredBluetoothDeviceService.Yy((String)localObject);
    localObject = a.rgg;
    paramMonitoredBluetoothDeviceInfo = paramMonitoredBluetoothDeviceInfo.field_appId;
    s.s(paramMonitoredBluetoothDeviceInfo, "field_appId");
    a.Yz(paramMonitoredBluetoothDeviceInfo);
    AppMethodBeat.o(321729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.h.c
 * JD-Core Version:    0.7.0.1
 */