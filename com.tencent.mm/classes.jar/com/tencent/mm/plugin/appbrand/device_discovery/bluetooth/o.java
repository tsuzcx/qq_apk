package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/OnMonitorBluetoothDeviceAuthorizeStateEvent;", "Lcom/tencent/mm/sdk/event/IEvent;", "appId", "", "authorized", "", "(Ljava/lang/String;Z)V", "getAppId", "()Ljava/lang/String;", "getAuthorized", "()Z", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends IEvent
{
  final String appId;
  final boolean rhq;
  
  public o(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(321610);
    this.appId = paramString;
    this.rhq = paramBoolean;
    AppMethodBeat.o(321610);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(321616);
    String str = "OnMonitorBluetoothDeviceAuthorizeStateEvent(appId='" + this.appId + "', authorized=" + this.rhq + ')';
    AppMethodBeat.o(321616);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.o
 * JD-Core Version:    0.7.0.1
 */