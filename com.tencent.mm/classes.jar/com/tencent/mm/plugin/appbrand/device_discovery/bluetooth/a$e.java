package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.f;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AppBrandMonitoredBluetoothDeviceServiceCore$startWeAppOnBluetoothDeviceFound$4", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$e
  implements f
{
  a$e(String paramString, a.a parama, MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo) {}
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(321723);
    com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", "startWeApp fail, deviceId: " + this.rgv + ", errCode: " + paramInt + ", errMsg: " + paramString);
    g.a(this.rgr, s.rhz, (m)new a(paramInt));
    a.cmr().clear();
    paramString = a.rgg;
    a.cmt();
    paramString = a.rgg;
    a.YE(this.rgw.appId);
    AppMethodBeat.o(321723);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(321713);
    Object localObject1 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrandMonitoredBluetoothDeviceServiceCore", kotlin.g.b.s.X("startWeApp success, deviceId: ", this.rgv));
    Object localObject2 = (Iterable)a.cmr();
    localObject1 = this.rgw;
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((a.a)localObject1).d((MonitoredBluetoothDeviceInfo)((Iterator)localObject2).next());
    }
    a.cms().add(this.rgw);
    a.cmr().clear();
    localObject1 = a.rgg;
    a.cmt();
    AppMethodBeat.o(321713);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AppBrandMonitoredBluetoothDeviceServiceCore$startWeAppOnBluetoothDeviceFound$4$onError$1", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/StatContext;", "appStartErrCode", "", "getAppStartErrCode", "()Ljava/lang/Integer;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends r
  {
    private final int rgx;
    
    a(int paramInt)
    {
      AppMethodBeat.i(321697);
      this.rgx = this.lxP;
      AppMethodBeat.o(321697);
    }
    
    public final Integer cmA()
    {
      AppMethodBeat.i(321708);
      int i = this.rgx;
      AppMethodBeat.o(321708);
      return Integer.valueOf(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.a.e
 * JD-Core Version:    0.7.0.1
 */