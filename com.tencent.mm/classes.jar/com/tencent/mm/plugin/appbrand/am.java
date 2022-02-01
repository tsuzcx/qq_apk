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
import com.tencent.mm.plugin.appbrand.utils.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.util.concurrent.atomic.AtomicBoolean;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/RuntimeLaunchTimeoutFallbackReloadTask;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask$PreInitCallback;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "prepareTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;)V", "TAG", "", "mCanceled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancel", "", "onResult", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "Companion", "plugin-appbrand-integration_release"})
public final class am
  implements AppBrandPreInitTask.a
{
  public static final a jDW;
  private final String TAG;
  final AtomicBoolean jDT;
  private final p jDU;
  private final AppBrandPrepareTask jDV;
  
  static
  {
    AppMethodBeat.i(223195);
    jDW = new a((byte)0);
    AppMethodBeat.o(223195);
  }
  
  private am(p paramp, AppBrandPrepareTask paramAppBrandPrepareTask)
  {
    AppMethodBeat.i(223194);
    this.jDU = paramp;
    this.jDV = paramAppBrandPrepareTask;
    this.TAG = ("MicroMsg.AppBrand.RuntimeLaunchTimeoutFallbackReloadTask[" + this.jDU.getAppId() + '|' + this.jDU.hashCode() + ']');
    this.jDT = new AtomicBoolean(false);
    AppMethodBeat.o(223194);
  }
  
  public static final am a(p paramp, AppBrandPrepareTask paramAppBrandPrepareTask)
  {
    AppMethodBeat.i(223196);
    d.g.b.p.h(paramp, "rt");
    d.g.b.p.h(paramAppBrandPrepareTask, "prepareTask");
    Object localObject1 = paramp.getContext();
    if (localObject1 != null) {
      localObject1 = (Context)localObject1;
    }
    for (;;)
    {
      Object localObject2 = paramp.aXx();
      d.g.b.p.g(localObject2, "rt.initConfig");
      localObject2 = h.e((AppBrandInitConfigWC)localObject2);
      String str = b.vQ(paramp.aXx().uin);
      paramp = new am(paramp, paramAppBrandPrepareTask);
      new AppBrandPreInitTask((Context)localObject1, (LaunchParcel)localObject2, str, true, (AppBrandPreInitTask.a)paramp).bru();
      AppMethodBeat.o(223196);
      return paramp;
      localObject1 = paramp.getAppContext();
      d.g.b.p.g(localObject1, "rt.appContext");
    }
  }
  
  public final void a(final AppBrandInitConfigWC paramAppBrandInitConfigWC, final AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(223193);
    if (this.jDT.get())
    {
      ae.w(this.TAG, "onResult but canceled");
      AppMethodBeat.o(223193);
      return;
    }
    ae.i(this.TAG, "onResult with config:".concat(String.valueOf(paramAppBrandInitConfigWC)));
    this.jDV.interrupt();
    if (paramAppBrandInitConfigWC == null)
    {
      this.jDU.finish();
      AppMethodBeat.o(223193);
      return;
    }
    this.jDU.K((Runnable)new b(this, paramAppBrandInitConfigWC, paramAppBrandStatObject));
    AppMethodBeat.o(223193);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/RuntimeLaunchTimeoutFallbackReloadTask$Companion;", "", "()V", "start", "Lcom/tencent/mm/plugin/appbrand/RuntimeLaunchTimeoutFallbackReloadTask;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "prepareTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(am paramam, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(223192);
      paramAppBrandInitConfigWC.kaZ = true;
      paramAppBrandInitConfigWC.a(paramAppBrandStatObject);
      paramAppBrandInitConfigWC.resetSession();
      AppBrandInitConfigWC localAppBrandInitConfigWC = paramAppBrandInitConfigWC;
      String str = am.a(this.jDX).aXx().kaS.lIU;
      d.g.b.p.g(str, "rt.initConfig.qualityReportSession.instanceId");
      localAppBrandInitConfigWC.kbb = new AppBrandRuntimeReloadReportBundle(str, "TimeoutFallback");
      am.a(this.jDX).a((AppBrandInitConfig)paramAppBrandInitConfigWC, "TimeoutFallback");
      AppMethodBeat.o(223192);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.am
 * JD-Core Version:    0.7.0.1
 */