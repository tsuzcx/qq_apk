package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigUtils;", "", "()V", "versionType", "", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getVersionType", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)I", "toLaunchParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "plugin-appbrand-integration_release"})
public final class h
{
  public static final h jDx;
  
  static
  {
    AppMethodBeat.i(50334);
    jDx = new h();
    AppMethodBeat.o(50334);
  }
  
  public static final LaunchParcel e(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(50333);
    k.h(paramAppBrandInitConfigWC, "$this$toLaunchParcel");
    LaunchParcel localLaunchParcel = new LaunchParcel();
    localLaunchParcel.username = paramAppBrandInitConfigWC.username;
    localLaunchParcel.appId = paramAppBrandInitConfigWC.appId;
    localLaunchParcel.version = paramAppBrandInitConfigWC.aBM;
    k.h(paramAppBrandInitConfigWC, "$this$versionType");
    localLaunchParcel.hxM = paramAppBrandInitConfigWC.joY;
    localLaunchParcel.jjf = paramAppBrandInitConfigWC.jjf;
    localLaunchParcel.lpG = paramAppBrandInitConfigWC.CB();
    localLaunchParcel.cce = paramAppBrandInitConfigWC.cce;
    LaunchParamsOptional localLaunchParamsOptional = new LaunchParamsOptional();
    localLaunchParamsOptional.ccd = paramAppBrandInitConfigWC.ccd;
    localLaunchParamsOptional.ccc = paramAppBrandInitConfigWC.ccc;
    localLaunchParamsOptional.ccf = paramAppBrandInitConfigWC.ccf;
    localLaunchParcel.lpH = localLaunchParamsOptional;
    localLaunchParcel.jDC = paramAppBrandInitConfigWC.jDC;
    localLaunchParcel.jDB = paramAppBrandInitConfigWC.jDB;
    localLaunchParcel.jjr = paramAppBrandInitConfigWC.jjr;
    AppMethodBeat.o(50333);
    return localLaunchParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.h
 * JD-Core Version:    0.7.0.1
 */