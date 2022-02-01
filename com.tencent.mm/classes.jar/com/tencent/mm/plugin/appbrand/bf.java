package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.launching.report.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/RuntimeLaunchTimeoutFallbackReloadTask;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask$PreInitCallback;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "prepareTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;)V", "TAG", "", "mCanceled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancel", "", "onResult", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bf
  implements AppBrandPreInitTask.a
{
  public static final bf.a qyl;
  private final String TAG;
  private final w qxY;
  private final AppBrandPrepareTask qym;
  final AtomicBoolean qyn;
  
  static
  {
    AppMethodBeat.i(316632);
    qyl = new bf.a((byte)0);
    AppMethodBeat.o(316632);
  }
  
  private bf(w paramw, AppBrandPrepareTask paramAppBrandPrepareTask)
  {
    AppMethodBeat.i(316601);
    this.qxY = paramw;
    this.qym = paramAppBrandPrepareTask;
    this.TAG = ("MicroMsg.AppBrand.RuntimeLaunchTimeoutFallbackReloadTask[" + this.qxY.mAppId + '|' + this.qxY.hashCode() + ']');
    this.qyn = new AtomicBoolean(false);
    AppMethodBeat.o(316601);
  }
  
  public static final bf a(w paramw, AppBrandPrepareTask paramAppBrandPrepareTask)
  {
    AppMethodBeat.i(316623);
    s.u(paramw, "rt");
    s.u(paramAppBrandPrepareTask, "prepareTask");
    Object localObject1 = AndroidContextUtil.castActivityOrNull(paramw.mContext);
    if (localObject1 == null) {}
    for (localObject1 = paramw.mContext;; localObject1 = (Context)localObject1)
    {
      s.s(localObject1, "rt.context ?: rt.appContext");
      Object localObject2 = paramw.getInitConfig();
      s.s(localObject2, "rt.initConfig");
      localObject2 = i.g((AppBrandInitConfigWC)localObject2);
      String str = paramw.getInitConfig().qYm.eup;
      s.s(str, "rt.initConfig.qualityReportSession.instanceId");
      ((LaunchParcel)localObject2).ted = ((Parcelable)new AppBrandRuntimeReloadReportBundle(str, a.teV.stringValue));
      paramw = new bf(paramw, paramAppBrandPrepareTask);
      paramAppBrandPrepareTask = new AppBrandPreInitTask((Context)localObject1, (LaunchParcel)localObject2, true, (AppBrandPreInitTask.a)paramw);
      paramAppBrandPrepareTask.sWe = true;
      paramAppBrandPrepareTask.czH();
      AppMethodBeat.o(316623);
      return paramw;
    }
  }
  
  private static final void a(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject, bf parambf)
  {
    AppMethodBeat.i(316612);
    s.u(parambf, "this$0");
    paramAppBrandInitConfigWC.qYs = true;
    paramAppBrandInitConfigWC.epn = paramAppBrandStatObject;
    paramAppBrandInitConfigWC.aqI();
    paramAppBrandStatObject = parambf.qxY.getInitConfig().qYm.eup;
    s.s(paramAppBrandStatObject, "rt.initConfig.qualityReportSession.instanceId");
    paramAppBrandInitConfigWC.qYu = new AppBrandRuntimeReloadReportBundle(paramAppBrandStatObject, a.teV.stringValue);
    parambf.qxY.a((AppBrandInitConfig)paramAppBrandInitConfigWC, a.teV.stringValue);
    AppMethodBeat.o(316612);
  }
  
  public final void onResult(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(316649);
    if (this.qyn.get())
    {
      Log.w(this.TAG, "onResult but canceled");
      AppMethodBeat.o(316649);
      return;
    }
    Log.i(this.TAG, s.X("onResult with config:", paramAppBrandInitConfigWC));
    this.qym.interrupt();
    if (paramAppBrandInitConfigWC == null)
    {
      this.qxY.finish();
      AppMethodBeat.o(316649);
      return;
    }
    this.qxY.i(new bf..ExternalSyntheticLambda0(paramAppBrandInitConfigWC, paramAppBrandStatObject, this), 0L);
    AppMethodBeat.o(316649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bf
 * JD-Core Version:    0.7.0.1
 */