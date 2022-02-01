package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigUtils;", "", "()V", "versionType", "", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getVersionType", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)I", "toLaunchParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i qYc;
  
  static
  {
    AppMethodBeat.i(50334);
    qYc = new i();
    AppMethodBeat.o(50334);
  }
  
  public static final LaunchParcel g(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(50333);
    s.u(paramAppBrandInitConfigWC, "<this>");
    LaunchParcel localLaunchParcel = new LaunchParcel();
    localLaunchParcel.username = paramAppBrandInitConfigWC.username;
    localLaunchParcel.appId = paramAppBrandInitConfigWC.appId;
    localLaunchParcel.version = paramAppBrandInitConfigWC.appVersion;
    s.u(paramAppBrandInitConfigWC, "<this>");
    localLaunchParcel.euz = paramAppBrandInitConfigWC.eul;
    localLaunchParcel.qAF = paramAppBrandInitConfigWC.qAF;
    localLaunchParcel.siB = paramAppBrandInitConfigWC.epn;
    localLaunchParcel.eoV = paramAppBrandInitConfigWC.eoV;
    LaunchParamsOptional localLaunchParamsOptional = new LaunchParamsOptional();
    localLaunchParamsOptional.eoU = paramAppBrandInitConfigWC.eoU;
    localLaunchParamsOptional.eoT = paramAppBrandInitConfigWC.eoT;
    localLaunchParamsOptional.eoW = paramAppBrandInitConfigWC.eoW;
    ah localah = ah.aiuX;
    localLaunchParcel.tdW = localLaunchParamsOptional;
    localLaunchParcel.qYh = paramAppBrandInitConfigWC.qYh;
    localLaunchParcel.qYg = paramAppBrandInitConfigWC.qYg;
    localLaunchParcel.qAQ = paramAppBrandInitConfigWC.qAQ;
    AppMethodBeat.o(50333);
    return localLaunchParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.i
 * JD-Core Version:    0.7.0.1
 */