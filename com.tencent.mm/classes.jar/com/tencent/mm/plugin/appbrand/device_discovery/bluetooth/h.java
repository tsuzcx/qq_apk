package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import android.os.PersistableBundle;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.device_discovery.a;
import com.tencent.mm.plugin.appbrand.headless.e;
import com.tencent.mm.plugin.appbrand.w;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/DeliverOnMonitoredBluetoothDeviceFoundTask;", "Lcom/tencent/mm/plugin/appbrand/headless/ITaskOnHeadlessStartSuccess;", "()V", "deliverOnBluetoothDeviceFound", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "onHeadlessStartSuccess", "onFound", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo;", "isConnected", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements e
{
  public static final a rhc;
  
  static
  {
    AppMethodBeat.i(321605);
    rhc = new a((byte)0);
    AppMethodBeat.o(321605);
  }
  
  public final void b(w paramw, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    Object localObject2 = null;
    AppMethodBeat.i(321619);
    kotlin.g.b.s.u(paramw, "runtime");
    kotlin.g.b.s.u(paramAppBrandInitConfigWC, "config");
    Object localObject3;
    label55:
    label61:
    int i;
    label68:
    boolean bool;
    if (g.DEBUG)
    {
      localObject1 = a.rfZ;
      a.d("MicroMsg.AppBrand.DeliverOnMonitoredBluetoothDeviceFoundTask", kotlin.g.b.s.X("deliverOnBluetoothDeviceFound, runtime: ", paramw));
      localObject3 = paramAppBrandInitConfigWC.qYg;
      if (localObject3 != null) {
        break label210;
      }
      paramAppBrandInitConfigWC = null;
      if (paramAppBrandInitConfigWC != null) {
        break label221;
      }
      paramAppBrandInitConfigWC = null;
      if (localObject3 != null) {
        break label297;
      }
      i = 0;
      if (i == 0) {
        break label308;
      }
      bool = true;
      label75:
      localObject1 = a.rfZ;
      localObject3 = new StringBuilder("deliverOnBluetoothDeviceFound, appId: ");
      if (paramAppBrandInitConfigWC != null) {
        break label314;
      }
      localObject1 = null;
      label98:
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", deviceId: ");
      if (paramAppBrandInitConfigWC != null) {
        break label323;
      }
    }
    label297:
    label308:
    label314:
    label323:
    for (Object localObject1 = localObject2;; localObject1 = paramAppBrandInitConfigWC.field_bluetoothDeviceId)
    {
      a.i("MicroMsg.AppBrand.DeliverOnMonitoredBluetoothDeviceFoundTask", localObject1 + ", isConnected: " + bool);
      if ((paramAppBrandInitConfigWC != null) && (paramAppBrandInitConfigWC.isValid())) {
        break label332;
      }
      paramw = a.rfZ;
      a.w("MicroMsg.AppBrand.DeliverOnMonitoredBluetoothDeviceFoundTask", "deliverOnBluetoothDeviceFound, deviceInfo is invalid");
      AppMethodBeat.o(321619);
      return;
      localObject1 = a.rfZ;
      a.i("MicroMsg.AppBrand.DeliverOnMonitoredBluetoothDeviceFoundTask", "deliverOnBluetoothDeviceFound, runtime(" + paramw.mAppId + ')');
      break;
      label210:
      paramAppBrandInitConfigWC = ((PersistableBundle)localObject3).getPersistableBundle("DeviceDiscovery_bluetoothDeviceInfo");
      break label55;
      label221:
      localObject1 = new MonitoredBluetoothDeviceInfo();
      kotlin.g.b.s.u(paramAppBrandInitConfigWC, "bundle");
      ((MonitoredBluetoothDeviceInfo)localObject1).field_appId = paramAppBrandInitConfigWC.getString("appid");
      ((MonitoredBluetoothDeviceInfo)localObject1).field_bluetoothDeviceId = paramAppBrandInitConfigWC.getString("bluetoothDeviceId");
      ((MonitoredBluetoothDeviceInfo)localObject1).field_wechatToken = paramAppBrandInitConfigWC.getString("deviceId");
      ((MonitoredBluetoothDeviceInfo)localObject1).field_versionType = paramAppBrandInitConfigWC.getInt("envVersion");
      ((MonitoredBluetoothDeviceInfo)localObject1).field_entryPackage = paramAppBrandInitConfigWC.getString("entryPackage");
      paramAppBrandInitConfigWC = (AppBrandInitConfigWC)localObject1;
      break label61;
      i = ((PersistableBundle)localObject3).getInt("DeviceDiscovery_isBluetoothDeviceConnected");
      break label68;
      bool = false;
      break label75;
      localObject1 = paramAppBrandInitConfigWC.field_appId;
      break label98;
    }
    label332:
    g.a(paramAppBrandInitConfigWC, s.rhy, (m)new b(paramw));
    paramw = a.rfZ;
    a.i("MicroMsg.AppBrand.DeliverOnMonitoredBluetoothDeviceFoundTask", "onFound, appId: " + paramAppBrandInitConfigWC.field_appId + ", deviceId: " + paramAppBrandInitConfigWC.field_bluetoothDeviceId + ", isConnected: " + bool);
    new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.r(paramAppBrandInitConfigWC).Q((b)new h.c(bool, paramAppBrandInitConfigWC));
    AppMethodBeat.o(321619);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/DeliverOnMonitoredBluetoothDeviceFoundTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/DeliverOnMonitoredBluetoothDeviceFoundTask$deliverOnBluetoothDeviceFound$1", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/StatContext;", "appInstanceId", "", "getAppInstanceId", "()Ljava/lang/String;", "appSessionId", "getAppSessionId", "appStartErrCode", "", "getAppStartErrCode", "()Ljava/lang/Integer;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends r
  {
    private final int rgx;
    private final String rhd;
    private final String rhe;
    
    b(w paramw)
    {
      AppMethodBeat.i(321722);
      paramw = this.rhf.getInitConfig();
      if (paramw == null)
      {
        paramw = "";
        this.rhd = paramw;
        paramw = this.rhf.getInitConfig();
        if (paramw != null) {
          break label77;
        }
        paramw = "";
      }
      for (;;)
      {
        this.rhe = paramw;
        AppMethodBeat.o(321722);
        return;
        String str = paramw.eoQ;
        paramw = str;
        if (str != null) {
          break;
        }
        paramw = "";
        break;
        label77:
        str = paramw.eoP;
        paramw = str;
        if (str == null) {
          paramw = "";
        }
      }
    }
    
    public final Integer cmA()
    {
      AppMethodBeat.i(321728);
      int i = this.rgx;
      AppMethodBeat.o(321728);
      return Integer.valueOf(i);
    }
    
    public final String cmP()
    {
      return this.rhd;
    }
    
    public final String getAppInstanceId()
    {
      return this.rhe;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.h
 * JD-Core Version:    0.7.0.1
 */