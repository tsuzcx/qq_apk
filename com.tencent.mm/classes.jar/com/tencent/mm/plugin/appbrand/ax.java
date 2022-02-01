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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/RuntimeLaunchTimeoutFallbackReloadTask;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask$PreInitCallback;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "prepareTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;)V", "TAG", "", "mCanceled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancel", "", "onResult", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "Companion", "plugin-appbrand-integration_release"})
public final class ax
  implements AppBrandPreInitTask.a
{
  public static final a kFF;
  private final String TAG;
  final AtomicBoolean kFD;
  private final AppBrandPrepareTask kFE;
  private final q kFk;
  
  static
  {
    AppMethodBeat.i(227953);
    kFF = new a((byte)0);
    AppMethodBeat.o(227953);
  }
  
  private ax(q paramq, AppBrandPrepareTask paramAppBrandPrepareTask)
  {
    AppMethodBeat.i(227952);
    this.kFk = paramq;
    this.kFE = paramAppBrandPrepareTask;
    this.TAG = ("MicroMsg.AppBrand.RuntimeLaunchTimeoutFallbackReloadTask[" + this.kFk.getAppId() + '|' + this.kFk.hashCode() + ']');
    this.kFD = new AtomicBoolean(false);
    AppMethodBeat.o(227952);
  }
  
  public static final ax a(q paramq, AppBrandPrepareTask paramAppBrandPrepareTask)
  {
    AppMethodBeat.i(227954);
    p.h(paramq, "rt");
    p.h(paramAppBrandPrepareTask, "prepareTask");
    Object localObject1 = paramq.getContext();
    if (localObject1 != null) {
      localObject1 = (Context)localObject1;
    }
    for (;;)
    {
      Object localObject2 = paramq.bsC();
      p.g(localObject2, "rt.initConfig");
      localObject2 = i.e((AppBrandInitConfigWC)localObject2);
      paramq = new ax(paramq, paramAppBrandPrepareTask);
      new AppBrandPreInitTask((Context)localObject1, (LaunchParcel)localObject2, true, (AppBrandPreInitTask.a)paramq).bNf();
      AppMethodBeat.o(227954);
      return paramq;
      localObject1 = paramq.getAppContext();
      p.g(localObject1, "rt.appContext");
    }
  }
  
  public final void a(final AppBrandInitConfigWC paramAppBrandInitConfigWC, final AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(227951);
    if (this.kFD.get())
    {
      Log.w(this.TAG, "onResult but canceled");
      AppMethodBeat.o(227951);
      return;
    }
    Log.i(this.TAG, "onResult with config:".concat(String.valueOf(paramAppBrandInitConfigWC)));
    this.kFE.interrupt();
    if (paramAppBrandInitConfigWC == null)
    {
      this.kFk.finish();
      AppMethodBeat.o(227951);
      return;
    }
    this.kFk.P((Runnable)new b(this, paramAppBrandInitConfigWC, paramAppBrandStatObject));
    AppMethodBeat.o(227951);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/RuntimeLaunchTimeoutFallbackReloadTask$Companion;", "", "()V", "start", "Lcom/tencent/mm/plugin/appbrand/RuntimeLaunchTimeoutFallbackReloadTask;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "prepareTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ax paramax, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(227950);
      paramAppBrandInitConfigWC.led = true;
      paramAppBrandInitConfigWC.a(paramAppBrandStatObject);
      paramAppBrandInitConfigWC.resetSession();
      AppBrandInitConfigWC localAppBrandInitConfigWC = paramAppBrandInitConfigWC;
      String str = ax.a(this.kFG).bsC().ldW.kEY;
      p.g(str, "rt.initConfig.qualityReportSession.instanceId");
      localAppBrandInitConfigWC.lef = new AppBrandRuntimeReloadReportBundle(str, "TimeoutFallback");
      ax.a(this.kFG).a((AppBrandInitConfig)paramAppBrandInitConfigWC, "TimeoutFallback");
      AppMethodBeat.o(227950);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ax
 * JD-Core Version:    0.7.0.1
 */