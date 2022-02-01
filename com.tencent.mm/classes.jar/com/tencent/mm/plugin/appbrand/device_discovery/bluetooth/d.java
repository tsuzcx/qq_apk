package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AutoConnectGattStrategyFactory;", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IAutoConnectGattStrategy$IFactory;", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IAutoConnectGattStrategy;", "deviceId", "", "gattConnectListener", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IGattConnectListener;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d rgI;
  
  static
  {
    AppMethodBeat.i(321649);
    rgI = new d();
    AppMethodBeat.o(321649);
  }
  
  public static j a(String paramString, l paraml)
  {
    AppMethodBeat.i(321645);
    s.u(paramString, "deviceId");
    s.u(paraml, "gattConnectListener");
    e locale = e.rgJ;
    if (e.cmE())
    {
      paramString = (j)new b(paramString, paraml);
      AppMethodBeat.o(321645);
      return paramString;
    }
    paramString = (j)new c(paramString, paraml);
    AppMethodBeat.o(321645);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.d
 * JD-Core Version:    0.7.0.1
 */