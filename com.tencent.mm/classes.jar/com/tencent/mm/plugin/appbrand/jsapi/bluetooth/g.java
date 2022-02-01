package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/BluetoothStateChangeListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/AppBrandBleWorker$OnBluetoothStateChange;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/OnBleConnectionStateChange;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "isEnabled", "", "myTag", "", "disable", "", "enable", "onBleConnectionStateChange", "deviceId", "connected", "onConnectStateChange", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class g
  implements b.a, i
{
  public static final g.a rKo = new g.a((byte)0);
  final String djQ;
  final AppBrandRuntime qzz;
  volatile boolean rKp;
  
  public g(AppBrandRuntime paramAppBrandRuntime)
  {
    this.qzz = paramAppBrandRuntime;
    paramAppBrandRuntime = e.rKk;
    this.djQ = s.X("MicroMsg.AppBrand.BluetoothConnectStateChangeListener#", e.a.ah(this.qzz));
  }
  
  public final void aC(String paramString, boolean paramBoolean)
  {
    Log.i(this.djQ, "onBleConnectionStateChange, deviceId: " + paramString + ", connected: " + paramBoolean);
    if (paramString == null) {
      return;
    }
    onConnectStateChange(paramString, paramBoolean);
  }
  
  public abstract void onConnectStateChange(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.g
 * JD-Core Version:    0.7.0.1
 */