package com.tencent.mm.plugin.appbrand.launching.precondition;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.f.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.g;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/precondition/Loader;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "loaderId", "", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "instanceId", "", "onSuccess", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "", "onError", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "(ILcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "getKey", "run", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class h
  implements com.tencent.threadpool.i.h
{
  private static final h.a teI;
  private final String eup;
  private final int qxw;
  private final LaunchParcel teJ;
  private final m<AppBrandInitConfigWC, AppBrandStatObject, ah> teK;
  private final f teL;
  
  static
  {
    AppMethodBeat.i(321031);
    teI = new h.a((byte)0);
    AppMethodBeat.o(321031);
  }
  
  public h(int paramInt, LaunchParcel paramLaunchParcel, String paramString, m<? super AppBrandInitConfigWC, ? super AppBrandStatObject, ah> paramm, f paramf)
  {
    AppMethodBeat.i(321023);
    this.qxw = paramInt;
    this.teJ = paramLaunchParcel;
    this.eup = paramString;
    this.teK = paramm;
    this.teL = paramf;
    AppMethodBeat.o(321023);
  }
  
  private static final void a(h paramh)
  {
    AppMethodBeat.i(321029);
    s.u(paramh, "this$0");
    Log.i("MicroMsg.AppBrandPreRenderColdStartService.Loader", s.X("run()-showPrompt, id:", Integer.valueOf(paramh.qxw)));
    AppMethodBeat.o(321029);
  }
  
  private static final void a(h paramh, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject, int paramInt)
  {
    AppMethodBeat.i(321027);
    s.u(paramh, "this$0");
    Log.i("MicroMsg.AppBrandPreRenderColdStartService.Loader", "run()-OnPreLaunchResultListener.onResult, result:" + paramInt + " config:" + paramAppBrandInitConfigWC);
    if (paramAppBrandInitConfigWC == null)
    {
      paramh = paramh.teL;
      if (paramh != null)
      {
        f.a.a(paramh, -3);
        AppMethodBeat.o(321027);
      }
    }
    else
    {
      paramh.teJ.f((AppBrandInitConfigLU)paramAppBrandInitConfigWC);
      paramAppBrandInitConfigWC.qYh = paramh.teJ.qYh;
      paramAppBrandInitConfigWC.qYg = paramh.teJ.qYg;
      paramAppBrandInitConfigWC.qAQ = paramh.teJ.qAQ;
      paramAppBrandInitConfigWC.qAS = paramh.teJ.qAS;
      localObject = paramh.teJ.tdW;
      if (localObject != null) {
        break label200;
      }
      paramInt = 0;
      paramAppBrandInitConfigWC.opX = paramInt;
      localObject = paramh.teJ.tdW;
      if (localObject != null) {
        break label209;
      }
    }
    label200:
    label209:
    for (Object localObject = null;; localObject = ((LaunchParamsOptional)localObject).eoY)
    {
      paramAppBrandInitConfigWC.eoY = ((String)localObject);
      com.tencent.mm.plugin.appbrand.launching.e.a(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      paramh = paramh.teK;
      if (paramh != null)
      {
        s.s(paramAppBrandStatObject, "stat");
        paramh.invoke(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      }
      AppMethodBeat.o(321027);
      return;
      paramInt = ((LaunchParamsOptional)localObject).opX;
      break;
    }
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(321038);
    String str = s.X("AppBrandPreRenderColdStartService.Loader-", Integer.valueOf(this.qxw));
    AppMethodBeat.o(321038);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(321039);
    Log.i("MicroMsg.AppBrandPreRenderColdStartService.Loader", "run()-start, id:" + this.qxw + ", username:" + this.teJ.username + ", appId:" + this.teJ.appId + ", versionType:" + this.teJ.euz + ", instanceId:" + this.eup + ", path:" + this.teJ.qAF);
    g localg = new g(this.teJ, this.eup, new h..ExternalSyntheticLambda0(this), new h..ExternalSyntheticLambda1(this));
    localg.sWq = com.tencent.luggage.sdk.launching.e.etJ;
    localg.sWo.epm = localg.sWq;
    localg.run();
    AppMethodBeat.o(321039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.h
 * JD-Core Version:    0.7.0.1
 */