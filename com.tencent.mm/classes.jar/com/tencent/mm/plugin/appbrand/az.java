package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/RuntimeLaunchTimeoutFallbackReloadTask;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask$PreInitCallback;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "prepareTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;)V", "TAG", "", "mCanceled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancel", "", "onResult", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "Companion", "plugin-appbrand-integration_release"})
public final class az
  implements AppBrandPreInitTask.a
{
  public static final az.a nzl;
  private final String TAG;
  private final t nyQ;
  final AtomicBoolean nzj;
  private final AppBrandPrepareTask nzk;
  
  static
  {
    AppMethodBeat.i(272541);
    nzl = new az.a((byte)0);
    AppMethodBeat.o(272541);
  }
  
  private az(t paramt, AppBrandPrepareTask paramAppBrandPrepareTask)
  {
    AppMethodBeat.i(272540);
    this.nyQ = paramt;
    this.nzk = paramAppBrandPrepareTask;
    this.TAG = ("MicroMsg.AppBrand.RuntimeLaunchTimeoutFallbackReloadTask[" + this.nyQ.getAppId() + '|' + this.nyQ.hashCode() + ']');
    this.nzj = new AtomicBoolean(false);
    AppMethodBeat.o(272540);
  }
  
  public static final az a(t paramt, AppBrandPrepareTask paramAppBrandPrepareTask)
  {
    AppMethodBeat.i(272542);
    p.k(paramt, "rt");
    p.k(paramAppBrandPrepareTask, "prepareTask");
    Object localObject1 = paramt.getContext();
    if (localObject1 != null) {
      localObject1 = (Context)localObject1;
    }
    for (;;)
    {
      Object localObject2 = paramt.bDy();
      p.j(localObject2, "rt.initConfig");
      localObject2 = i.e((AppBrandInitConfigWC)localObject2);
      paramt = new az(paramt, paramAppBrandPrepareTask);
      new AppBrandPreInitTask((Context)localObject1, (LaunchParcel)localObject2, true, (AppBrandPreInitTask.a)paramt).bZw();
      AppMethodBeat.o(272542);
      return paramt;
      localObject1 = paramt.getAppContext();
      p.j(localObject1, "rt.appContext");
    }
  }
  
  public final void a(final AppBrandInitConfigWC paramAppBrandInitConfigWC, final AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(272539);
    if (this.nzj.get())
    {
      Log.w(this.TAG, "onResult but canceled");
      AppMethodBeat.o(272539);
      return;
    }
    Log.i(this.TAG, "onResult with config:".concat(String.valueOf(paramAppBrandInitConfigWC)));
    this.nzk.interrupt();
    if (paramAppBrandInitConfigWC == null)
    {
      this.nyQ.finish();
      AppMethodBeat.o(272539);
      return;
    }
    this.nyQ.P((Runnable)new b(this, paramAppBrandInitConfigWC, paramAppBrandStatObject));
    AppMethodBeat.o(272539);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(az paramaz, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(279890);
      paramAppBrandInitConfigWC.nYr = true;
      paramAppBrandInitConfigWC.a(paramAppBrandStatObject);
      paramAppBrandInitConfigWC.resetSession();
      AppBrandInitConfigWC localAppBrandInitConfigWC = paramAppBrandInitConfigWC;
      String str = az.a(this.nzm).bDy().nYk.cBH;
      p.j(str, "rt.initConfig.qualityReportSession.instanceId");
      localAppBrandInitConfigWC.nYt = new AppBrandRuntimeReloadReportBundle(str, "TimeoutFallback");
      az.a(this.nzm).a((AppBrandInitConfig)paramAppBrandInitConfigWC, "TimeoutFallback");
      AppMethodBeat.o(279890);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.az
 * JD-Core Version:    0.7.0.1
 */