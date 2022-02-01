package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigUtils;", "", "()V", "versionType", "", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getVersionType", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)I", "toLaunchParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "plugin-appbrand-integration_release"})
public final class h
{
  public static final h jdk;
  
  static
  {
    AppMethodBeat.i(50334);
    jdk = new h();
    AppMethodBeat.o(50334);
  }
  
  public static final LaunchParcel e(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(50333);
    k.h(paramAppBrandInitConfigWC, "$this$toLaunchParcel");
    LaunchParcel localLaunchParcel = new LaunchParcel();
    localLaunchParcel.username = paramAppBrandInitConfigWC.username;
    localLaunchParcel.appId = paramAppBrandInitConfigWC.appId;
    localLaunchParcel.version = paramAppBrandInitConfigWC.aAS;
    k.h(paramAppBrandInitConfigWC, "$this$versionType");
    localLaunchParcel.gXn = paramAppBrandInitConfigWC.iOP;
    localLaunchParcel.iJb = paramAppBrandInitConfigWC.iJb;
    localLaunchParcel.kOh = paramAppBrandInitConfigWC.CY();
    localLaunchParcel.cfi = paramAppBrandInitConfigWC.cfi;
    LaunchParamsOptional localLaunchParamsOptional = new LaunchParamsOptional();
    localLaunchParamsOptional.cfh = paramAppBrandInitConfigWC.cfh;
    localLaunchParamsOptional.cff = paramAppBrandInitConfigWC.cff;
    localLaunchParamsOptional.cfj = paramAppBrandInitConfigWC.cfj;
    localLaunchParcel.kOi = localLaunchParamsOptional;
    localLaunchParcel.jdp = paramAppBrandInitConfigWC.jdp;
    localLaunchParcel.jdo = paramAppBrandInitConfigWC.jdo;
    localLaunchParcel.iJn = paramAppBrandInitConfigWC.iJn;
    AppMethodBeat.o(50333);
    return localLaunchParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.h
 * JD-Core Version:    0.7.0.1
 */