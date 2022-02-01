package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.utils.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.concurrent.atomic.AtomicBoolean;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/RuntimeLaunchTimeoutFallbackReloadTask;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask$PreInitCallback;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "prepareTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;)V", "TAG", "", "mCanceled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancel", "", "onResult", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "Companion", "plugin-appbrand-integration_release"})
public final class am
  implements AppBrandPreInitTask.a
{
  public static final a jBl;
  private final String TAG;
  final AtomicBoolean jBi;
  private final o jBj;
  private final AppBrandPrepareTask jBk;
  
  static
  {
    AppMethodBeat.i(188960);
    jBl = new a((byte)0);
    AppMethodBeat.o(188960);
  }
  
  private am(o paramo, AppBrandPrepareTask paramAppBrandPrepareTask)
  {
    AppMethodBeat.i(188959);
    this.jBj = paramo;
    this.jBk = paramAppBrandPrepareTask;
    this.TAG = ("MicroMsg.AppBrand.RuntimeLaunchTimeoutFallbackReloadTask[" + this.jBj.getAppId() + '|' + this.jBj.hashCode() + ']');
    this.jBi = new AtomicBoolean(false);
    AppMethodBeat.o(188959);
  }
  
  public static final am a(o paramo, AppBrandPrepareTask paramAppBrandPrepareTask)
  {
    AppMethodBeat.i(188961);
    p.h(paramo, "rt");
    p.h(paramAppBrandPrepareTask, "prepareTask");
    Object localObject1 = paramo.getContext();
    if (localObject1 != null) {
      localObject1 = (Context)localObject1;
    }
    for (;;)
    {
      Object localObject2 = paramo.aXc();
      p.g(localObject2, "rt.initConfig");
      localObject2 = h.e((AppBrandInitConfigWC)localObject2);
      String str = a.vL(paramo.aXc().uin);
      paramo = new am(paramo, paramAppBrandPrepareTask);
      new AppBrandPreInitTask((Context)localObject1, (LaunchParcel)localObject2, str, true, (AppBrandPreInitTask.a)paramo).bqK();
      AppMethodBeat.o(188961);
      return paramo;
      localObject1 = paramo.getAppContext();
      p.g(localObject1, "rt.appContext");
    }
  }
  
  public final void a(final AppBrandInitConfigWC paramAppBrandInitConfigWC, final AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(188958);
    if (this.jBi.get())
    {
      ad.w(this.TAG, "onResult but canceled");
      AppMethodBeat.o(188958);
      return;
    }
    ad.i(this.TAG, "onResult with config:".concat(String.valueOf(paramAppBrandInitConfigWC)));
    this.jBk.interrupt();
    if (paramAppBrandInitConfigWC == null)
    {
      this.jBj.finish();
      AppMethodBeat.o(188958);
      return;
    }
    this.jBj.M((Runnable)new b(this, paramAppBrandInitConfigWC, paramAppBrandStatObject));
    AppMethodBeat.o(188958);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/RuntimeLaunchTimeoutFallbackReloadTask$Companion;", "", "()V", "start", "Lcom/tencent/mm/plugin/appbrand/RuntimeLaunchTimeoutFallbackReloadTask;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "prepareTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(am paramam, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(188957);
      paramAppBrandInitConfigWC.jXK = true;
      paramAppBrandInitConfigWC.a(paramAppBrandStatObject);
      paramAppBrandInitConfigWC.resetSession();
      AppBrandInitConfigWC localAppBrandInitConfigWC = paramAppBrandInitConfigWC;
      String str = am.a(this.jBm).aXc().jXD.lEv;
      p.g(str, "rt.initConfig.qualityReportSession.instanceId");
      localAppBrandInitConfigWC.jXM = new AppBrandRuntimeReloadReportBundle(str, "TimeoutFallback");
      am.a(this.jBm).a((AppBrandInitConfig)paramAppBrandInitConfigWC, "TimeoutFallback");
      AppMethodBeat.o(188957);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.am
 * JD-Core Version:    0.7.0.1
 */