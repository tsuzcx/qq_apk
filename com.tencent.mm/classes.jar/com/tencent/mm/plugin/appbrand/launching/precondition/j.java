package com.tencent.mm.plugin.appbrand.launching.precondition;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.b;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.api.f.a;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.v;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/precondition/PreRenderPreconditionProcess;", "", "requestId", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "onSuccess", "Lkotlin/Function3;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramProcess;", "", "onError", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "(ILcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;Lkotlin/jvm/functions/Function3;Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "start", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  private static final j.a teN;
  private final int requestId;
  private final com.tencent.mm.plugin.appbrand.api.f teL;
  private final g teO;
  private final q<AppBrandInitConfigWC, AppBrandStatObject, com.tencent.mm.plugin.appbrand.task.d, ah> teP;
  
  static
  {
    AppMethodBeat.i(321026);
    teN = new j.a((byte)0);
    AppMethodBeat.o(321026);
  }
  
  public j(int paramInt, g paramg, q<? super AppBrandInitConfigWC, ? super AppBrandStatObject, ? super com.tencent.mm.plugin.appbrand.task.d, ah> paramq, com.tencent.mm.plugin.appbrand.api.f paramf)
  {
    AppMethodBeat.i(321021);
    this.requestId = paramInt;
    this.teO = paramg;
    this.teP = paramq;
    this.teL = paramf;
    AppMethodBeat.o(321021);
  }
  
  public final void start()
  {
    AppMethodBeat.i(321033);
    try
    {
      Object localObject1 = v.sZx;
      v.b(this.teO);
      localObject1 = v.sZx;
      localLaunchParcel = v.c(this.teO);
      localLaunchParcel.epm = com.tencent.luggage.sdk.launching.e.etJ;
      localLaunchParcel.tdX = Util.nowMilliSecond();
      localObject1 = (CharSequence)this.teO.appId;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label432;
        }
        localObject1 = this.teO.appId;
        str = com.tencent.mm.plugin.appbrand.report.quality.f.c(localLaunchParcel, (String)localObject1);
        localObject3 = (CharSequence)localObject1;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label441;
        }
        i = 1;
        if ((i != 0) || (!k.a.zn(this.teO.euz))) {
          break label462;
        }
        localObject3 = com.tencent.mm.plugin.appbrand.task.i.tWq;
        localObject3 = i.a.cJV();
        s.s(localObject1, "appId");
        if (!((com.tencent.mm.plugin.appbrand.task.i)localObject3).C((String)localObject1, this.teO.euz)) {
          break label462;
        }
        AppBrandInitConfigWC localAppBrandInitConfigWC = com.tencent.mm.plugin.appbrand.config.h.ckG().Xo((String)localObject1);
        localLaunchParcel.f((AppBrandInitConfigLU)localAppBrandInitConfigWC);
        localAppBrandInitConfigWC.qYh = localLaunchParcel.qYh;
        localAppBrandInitConfigWC.qYg = localLaunchParcel.qYg;
        localAppBrandInitConfigWC.qAQ = localLaunchParcel.qAQ;
        localAppBrandInitConfigWC.qAS = localLaunchParcel.qAS;
        localObject3 = localLaunchParcel.tdW;
        if (localObject3 != null) {
          break label446;
        }
        i = 0;
        localAppBrandInitConfigWC.opX = i;
        localObject3 = localLaunchParcel.tdW;
        if (localObject3 != null) {
          break label454;
        }
        localObject3 = null;
        localAppBrandInitConfigWC.eoY = ((String)localObject3);
        localAppBrandInitConfigWC.launchMode = localLaunchParcel.launchMode;
        localAppBrandInitConfigWC.qYm = new QualitySession(str, localAppBrandInitConfigWC, localLaunchParcel.siB);
        localAppBrandInitConfigWC.fk(str);
        localAppBrandInitConfigWC.qYm.tSj = false;
        localAppBrandInitConfigWC.epl = false;
        localAppBrandInitConfigWC.qAX = localLaunchParcel.qAX;
        localAppBrandInitConfigWC.epk = b.iRp();
        localAppBrandInitConfigWC.epi = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
        com.tencent.mm.plugin.appbrand.launching.e.a(localAppBrandInitConfigWC, localLaunchParcel.siB);
        localObject3 = com.tencent.mm.plugin.appbrand.task.i.tWq;
        i.a.cJV().a((String)localObject1, (m)new j.b(this, localAppBrandInitConfigWC, localLaunchParcel));
        AppMethodBeat.o(321033);
      }
    }
    catch (Exception localException)
    {
      LaunchParcel localLaunchParcel;
      String str;
      Object localObject2;
      for (;;)
      {
        int i;
        Object localObject3;
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
        {
          AppMethodBeat.o(321033);
          throw localException;
        }
        localObject2 = this.teL;
        if (localObject2 != null)
        {
          f.a.a((com.tencent.mm.plugin.appbrand.api.f)localObject2, -1);
          continue;
          i = 0;
          continue;
          label432:
          localObject2 = i.a(localLaunchParcel);
          continue;
          label441:
          i = 0;
          continue;
          label446:
          i = ((LaunchParamsOptional)localObject3).opX;
          continue;
          label454:
          localObject3 = ((LaunchParamsOptional)localObject3).eoY;
        }
      }
      label462:
      com.tencent.threadpool.h.ahAA.bo((Runnable)new h(this.requestId, localLaunchParcel, str, (m)new j.c((String)localObject2, this), this.teL));
      AppMethodBeat.o(321033);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.j
 * JD-Core Version:    0.7.0.1
 */