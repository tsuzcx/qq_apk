package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigUtils;", "", "()V", "versionType", "", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getVersionType", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)I", "toLaunchParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "plugin-appbrand-integration_release"})
public final class i
{
  public static final i nYa;
  
  static
  {
    AppMethodBeat.i(50334);
    nYa = new i();
    AppMethodBeat.o(50334);
  }
  
  public static final LaunchParcel e(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(50333);
    p.k(paramAppBrandInitConfigWC, "$this$toLaunchParcel");
    LaunchParcel localLaunchParcel = new LaunchParcel();
    localLaunchParcel.username = paramAppBrandInitConfigWC.username;
    localLaunchParcel.appId = paramAppBrandInitConfigWC.appId;
    localLaunchParcel.version = paramAppBrandInitConfigWC.appVersion;
    p.k(paramAppBrandInitConfigWC, "$this$versionType");
    localLaunchParcel.cBU = paramAppBrandInitConfigWC.cBI;
    localLaunchParcel.nBq = paramAppBrandInitConfigWC.nBq;
    localLaunchParcel.pdk = paramAppBrandInitConfigWC.Qu();
    localLaunchParcel.cwV = paramAppBrandInitConfigWC.cwV;
    LaunchParamsOptional localLaunchParamsOptional = new LaunchParamsOptional();
    localLaunchParamsOptional.cwU = paramAppBrandInitConfigWC.cwU;
    localLaunchParamsOptional.cwT = paramAppBrandInitConfigWC.cwT;
    localLaunchParamsOptional.cwW = paramAppBrandInitConfigWC.cwW;
    localLaunchParcel.pZj = localLaunchParamsOptional;
    localLaunchParcel.nYf = paramAppBrandInitConfigWC.nYf;
    localLaunchParcel.nYe = paramAppBrandInitConfigWC.nYe;
    localLaunchParcel.nBB = paramAppBrandInitConfigWC.nBB;
    AppMethodBeat.o(50333);
    return localLaunchParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.i
 * JD-Core Version:    0.7.0.1
 */