package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/StatContext;", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IStatContext;", "()V", "appInstanceId", "", "getAppInstanceId", "()Ljava/lang/String;", "appRunningStateWhenStart", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/WeAppRunningState;", "getAppRunningStateWhenStart", "()Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/WeAppRunningState;", "appSessionId", "getAppSessionId", "appStartErrCode", "", "getAppStartErrCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class r
  implements m
{
  private final t rgt;
  private final String rhd;
  private final String rhe;
  private final Integer rhk;
  
  public Integer cmA()
  {
    return this.rhk;
  }
  
  public String cmP()
  {
    return this.rhd;
  }
  
  public t cmz()
  {
    return this.rgt;
  }
  
  public String getAppInstanceId()
  {
    return this.rhe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.r
 * JD-Core Version:    0.7.0.1
 */