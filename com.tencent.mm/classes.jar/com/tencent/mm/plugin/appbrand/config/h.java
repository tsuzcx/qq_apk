package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigUtils;", "", "()V", "versionType", "", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getVersionType", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)I", "toLaunchParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "plugin-appbrand-integration_release"})
public final class h
{
  public static final h jXt;
  
  static
  {
    AppMethodBeat.i(50334);
    jXt = new h();
    AppMethodBeat.o(50334);
  }
  
  public static final LaunchParcel e(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(50333);
    p.h(paramAppBrandInitConfigWC, "$this$toLaunchParcel");
    LaunchParcel localLaunchParcel = new LaunchParcel();
    localLaunchParcel.username = paramAppBrandInitConfigWC.username;
    localLaunchParcel.appId = paramAppBrandInitConfigWC.appId;
    localLaunchParcel.version = paramAppBrandInitConfigWC.aDD;
    p.h(paramAppBrandInitConfigWC, "$this$versionType");
    localLaunchParcel.hQh = paramAppBrandInitConfigWC.dPf;
    localLaunchParcel.jCN = paramAppBrandInitConfigWC.jCN;
    localLaunchParcel.lMZ = paramAppBrandInitConfigWC.Ea();
    localLaunchParcel.cmv = paramAppBrandInitConfigWC.cmv;
    LaunchParamsOptional localLaunchParamsOptional = new LaunchParamsOptional();
    localLaunchParamsOptional.cmu = paramAppBrandInitConfigWC.cmu;
    localLaunchParamsOptional.cmt = paramAppBrandInitConfigWC.cmt;
    localLaunchParamsOptional.cmw = paramAppBrandInitConfigWC.cmw;
    localLaunchParcel.lNa = localLaunchParamsOptional;
    localLaunchParcel.jXy = paramAppBrandInitConfigWC.jXy;
    localLaunchParcel.jXx = paramAppBrandInitConfigWC.jXx;
    localLaunchParcel.jCZ = paramAppBrandInitConfigWC.jCZ;
    AppMethodBeat.o(50333);
    return localLaunchParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.h
 * JD-Core Version:    0.7.0.1
 */