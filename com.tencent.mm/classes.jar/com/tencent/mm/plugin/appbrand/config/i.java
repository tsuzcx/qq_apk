package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigUtils;", "", "()V", "versionType", "", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getVersionType", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)I", "toLaunchParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "plugin-appbrand-integration_release"})
public final class i
{
  public static final i ldM;
  
  static
  {
    AppMethodBeat.i(50334);
    ldM = new i();
    AppMethodBeat.o(50334);
  }
  
  public static final LaunchParcel e(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(50333);
    p.h(paramAppBrandInitConfigWC, "$this$toLaunchParcel");
    LaunchParcel localLaunchParcel = new LaunchParcel();
    localLaunchParcel.username = paramAppBrandInitConfigWC.username;
    localLaunchParcel.appId = paramAppBrandInitConfigWC.appId;
    localLaunchParcel.version = paramAppBrandInitConfigWC.appVersion;
    p.h(paramAppBrandInitConfigWC, "$this$versionType");
    localLaunchParcel.iOo = paramAppBrandInitConfigWC.eix;
    localLaunchParcel.kHw = paramAppBrandInitConfigWC.kHw;
    localLaunchParcel.mYK = paramAppBrandInitConfigWC.Nz();
    localLaunchParcel.cys = paramAppBrandInitConfigWC.cys;
    LaunchParamsOptional localLaunchParamsOptional = new LaunchParamsOptional();
    localLaunchParamsOptional.cyr = paramAppBrandInitConfigWC.cyr;
    localLaunchParamsOptional.cyq = paramAppBrandInitConfigWC.cyq;
    localLaunchParamsOptional.cyt = paramAppBrandInitConfigWC.cyt;
    localLaunchParcel.mYL = localLaunchParamsOptional;
    localLaunchParcel.ldR = paramAppBrandInitConfigWC.ldR;
    localLaunchParcel.ldQ = paramAppBrandInitConfigWC.ldQ;
    localLaunchParcel.kHI = paramAppBrandInitConfigWC.kHI;
    AppMethodBeat.o(50333);
    return localLaunchParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.i
 * JD-Core Version:    0.7.0.1
 */