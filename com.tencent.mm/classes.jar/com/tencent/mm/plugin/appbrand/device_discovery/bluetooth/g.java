package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ac;
import com.tencent.mm.compatible.util.r;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"DEBUG", "", "getDEBUG$annotations", "()V", "getDEBUG", "()Z", "stat", "", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo;", "event", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/StatEvent;", "context", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IStatContext;", "toReportString", "", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final boolean DEBUG = false;
  
  private static final String YG(String paramString)
  {
    AppMethodBeat.i(321615);
    if (paramString.length() > 1024)
    {
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(321615);
        throw paramString;
      }
      paramString = paramString.substring(0, 1024);
      kotlin.g.b.s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    while (n.i((CharSequence)paramString, (CharSequence)","))
    {
      paramString = r.as(paramString, "UTF-8");
      if (paramString == null)
      {
        AppMethodBeat.o(321615);
        return "";
      }
      else
      {
        AppMethodBeat.o(321615);
        return paramString;
      }
    }
    AppMethodBeat.o(321615);
    return paramString;
  }
  
  public static final void a(MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo, s params, m paramm)
  {
    AppMethodBeat.i(321602);
    kotlin.g.b.s.u(paramMonitoredBluetoothDeviceInfo, "<this>");
    kotlin.g.b.s.u(params, "event");
    kotlin.g.b.s.u(paramm, "context");
    Object localObject = new ac();
    ((ac)localObject).inc = params.rht;
    params = paramMonitoredBluetoothDeviceInfo.field_appId;
    kotlin.g.b.s.s(params, "field_appId");
    params = ((ac)localObject).ks(YG(params));
    params.ind = paramMonitoredBluetoothDeviceInfo.field_versionType;
    localObject = paramMonitoredBluetoothDeviceInfo.field_entryPackage;
    kotlin.g.b.s.s(localObject, "field_entryPackage");
    params = params.kv(YG((String)localObject));
    localObject = paramMonitoredBluetoothDeviceInfo.field_wechatToken;
    kotlin.g.b.s.s(localObject, "field_wechatToken");
    params = params.kt(YG((String)localObject));
    paramMonitoredBluetoothDeviceInfo = paramMonitoredBluetoothDeviceInfo.field_bluetoothDeviceId;
    kotlin.g.b.s.s(paramMonitoredBluetoothDeviceInfo, "field_bluetoothDeviceId");
    paramMonitoredBluetoothDeviceInfo = params.ku(YG(paramMonitoredBluetoothDeviceInfo));
    params = paramm.cmz();
    if (params != null) {
      paramMonitoredBluetoothDeviceInfo.ine = params.rht;
    }
    params = paramm.cmA();
    if (params != null) {
      paramMonitoredBluetoothDeviceInfo.ini = ((Number)params).intValue();
    }
    params = paramm.cmP();
    if (params != null) {
      paramMonitoredBluetoothDeviceInfo.kw(YG(params));
    }
    params = paramm.getAppInstanceId();
    if (params != null) {
      paramMonitoredBluetoothDeviceInfo.kx(YG(params));
    }
    paramMonitoredBluetoothDeviceInfo.bMH();
    AppMethodBeat.o(321602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.g
 * JD-Core Version:    0.7.0.1
 */