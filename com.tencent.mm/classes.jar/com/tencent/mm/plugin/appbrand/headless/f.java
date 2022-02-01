package com.tencent.mm.plugin.appbrand.headless;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.b.d.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.q.a.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i.h;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/headless/RemoteLoader;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "data", "Lcom/tencent/mm/plugin/appbrand/headless/BindRemoteServiceData;", "callback", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "(Lcom/tencent/mm/plugin/appbrand/headless/BindRemoteServiceData;Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "requestId", "", "taskOnStartSuccess", "Lcom/tencent/mm/plugin/appbrand/headless/ITaskOnHeadlessStartSuccess;", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;ILcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;Lcom/tencent/mm/plugin/appbrand/headless/ITaskOnHeadlessStartSuccess;)V", "getKey", "", "run", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class f
  implements h
{
  private static final f.a rup;
  private final AppBrandStatObject qxv;
  private final AppBrandInitConfigWC qyb;
  private final com.tencent.mm.plugin.appbrand.api.f qyc;
  private final int requestId;
  private final e ruq;
  
  static
  {
    AppMethodBeat.i(317596);
    rup = new f.a((byte)0);
    AppMethodBeat.o(317596);
  }
  
  private f(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject, int paramInt, com.tencent.mm.plugin.appbrand.api.f paramf, e parame)
  {
    AppMethodBeat.i(317555);
    this.qyb = paramAppBrandInitConfigWC;
    this.qxv = paramAppBrandStatObject;
    this.requestId = paramInt;
    this.qyc = paramf;
    this.ruq = parame;
    AppMethodBeat.o(317555);
  }
  
  public f(BindRemoteServiceData paramBindRemoteServiceData, com.tencent.mm.plugin.appbrand.api.f paramf) {}
  
  private static final void a(f paramf, w paramw, a.d paramd)
  {
    AppMethodBeat.i(317580);
    s.u(paramf, "this$0");
    s.u(paramw, "$this_ensureEntryModuleLoadedAndCallback");
    Log.i("MicroMsg.AppBrandHeadlessStartService.RemoteLoader", "run()-ensureEntryModuleLoadedAndCallback, appId:" + paramf.qyb.appId + ", instanceId:" + paramf.qyb.eoQ + ", sessionId:" + paramf.qyb.eoP + ", loadModuleResult:" + paramd);
    if (a.d.tma == paramd)
    {
      paramw.qsB.qKC.a(d.a.qLc);
      paramd = paramf.ruq;
      if (paramd != null) {
        paramd.b(paramw, paramf.qyb);
      }
      paramf = paramf.qyc;
      if (paramf != null)
      {
        paramf.onSuccess();
        AppMethodBeat.o(317580);
      }
    }
    else
    {
      paramf = paramf.qyc;
      if (paramf != null) {
        com.tencent.mm.plugin.appbrand.api.f.a.a(paramf, -9);
      }
    }
    AppMethodBeat.o(317580);
  }
  
  private static final void a(w paramw, f paramf)
  {
    AppMethodBeat.i(317588);
    Object localObject = (CharSequence)paramf.qyb.eoR;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label70;
      }
    }
    label70:
    for (localObject = "__APP__";; localObject = paramf.qyb.eoR)
    {
      paramw.qsC.a((String)localObject, new f..ExternalSyntheticLambda0(paramf, paramw), null, true);
      AppMethodBeat.o(317588);
      return;
      i = 0;
      break;
    }
  }
  
  private static final void b(w paramw, f paramf)
  {
    AppMethodBeat.i(317594);
    s.u(paramw, "$this_apply");
    s.u(paramf, "this$0");
    AppBrandRuntimeContainerWC.f(paramw);
    n.c(paramw);
    a(paramw, paramf);
    AppMethodBeat.o(317594);
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(317614);
    String str = s.X("AppBrandHeadlessStartService.RemoteLoader-", Integer.valueOf(this.requestId));
    AppMethodBeat.o(317614);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(317617);
    Log.i("MicroMsg.AppBrandHeadlessStartService.RemoteLoader", "run()-start, id:" + this.requestId + ", appId:" + this.qyb.appId + ", instanceId:" + this.qyb.eoQ + ", sessionId:" + this.qyb.eoP);
    this.qyb.epn = this.qxv;
    w localw = com.tencent.mm.plugin.appbrand.d.Uc(this.qyb.appId);
    if ((localw == null) || (localw.ccV) || (localw.qsE.get()))
    {
      localw = new w((com.tencent.mm.plugin.appbrand.platform.window.c)new com.tencent.mm.plugin.appbrand.platform.window.b.a());
      AppBrandRuntimeContainerWC.a(localw, this.qyb);
      localw.U(new f..ExternalSyntheticLambda1(localw, this));
      AppMethodBeat.o(317617);
      return;
    }
    a(localw, this);
    AppMethodBeat.o(317617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.headless.f
 * JD-Core Version:    0.7.0.1
 */