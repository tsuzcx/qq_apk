package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.AppBrandMonitoredBluetoothDeviceService;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/JsApiCreateBLEConnectionWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiCreateBLEConnection;", "()V", "onCreateConnectionDone", "", "env", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "deviceId", "", "isSuccess", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends c
{
  public static final a rKt;
  
  static
  {
    AppMethodBeat.i(329532);
    rKt = new a((byte)0);
    AppMethodBeat.o(329532);
  }
  
  public final void a(f paramf, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(329543);
    s.u(paramf, "env");
    s.u(paramString, "deviceId");
    Log.i("MicroMsg.AppBrand.JsApiCreateBLEConnectionWC", "onCreateConnectionDone, deviceId: " + paramString + ", isSuccess: " + paramBoolean);
    if (!paramBoolean)
    {
      AppMethodBeat.o(329543);
      return;
    }
    paramf = paramf.getAppId();
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiCreateBLEConnectionWC", "onCreateConnectionDone, appId is null");
      AppMethodBeat.o(329543);
      return;
    }
    AppBrandMonitoredBluetoothDeviceService localAppBrandMonitoredBluetoothDeviceService = AppBrandMonitoredBluetoothDeviceService.rgb;
    AppBrandMonitoredBluetoothDeviceService.dv(paramf, paramString);
    AppMethodBeat.o(329543);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/JsApiCreateBLEConnectionWC$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.n
 * JD-Core Version:    0.7.0.1
 */