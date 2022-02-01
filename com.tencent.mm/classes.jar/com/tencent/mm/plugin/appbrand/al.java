package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.k.a.a;
import com.tencent.mm.plugin.appbrand.k.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/EmbedHalfScreenWxaManager;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "currentEmbedWxaAppId", "", "markShouldReShowEmbedWxa", "Ljava/util/concurrent/atomic/AtomicBoolean;", "closeEmbedWxaBeforeHostDisappear", "", "host", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "resumeEmbedWxaWhenHostResumed", "afterCloseTask", "Ljava/lang/Runnable;", "onInitConfigUpdated", "", "initConfigWC", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "onRuntimeResume", "onStop", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
{
  public static final al.a qxB;
  final w qxC;
  String qxD;
  AtomicBoolean qxE;
  
  static
  {
    AppMethodBeat.i(316675);
    qxB = new al.a((byte)0);
    AppMethodBeat.o(316675);
  }
  
  public al(w paramw)
  {
    AppMethodBeat.i(316672);
    this.qxC = paramw;
    this.qxD = "";
    this.qxE = new AtomicBoolean(false);
    AppMethodBeat.o(316672);
  }
  
  public final boolean a(AppBrandRuntime paramAppBrandRuntime, boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(316678);
    s.u(paramAppBrandRuntime, "host");
    s.u(paramRunnable, "afterCloseTask");
    Object localObject = paramAppBrandRuntime.qsc;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((ap)localObject).getActiveRuntime())
    {
      AppMethodBeat.o(316678);
      return false;
    }
    a.a locala = a.ruh;
    if (a.a.F((w)paramAppBrandRuntime))
    {
      ((AppBrandRuntime)localObject).b(null, paramRunnable);
      Log.i("MicroMsg.EmbedHalfScreenWxaManager", "[onCloseEmbedWxaBeforeHostClose] mark down embedded wxa appid for re-show when host back to the front");
      if (paramBoolean)
      {
        paramAppBrandRuntime = ((AppBrandRuntime)localObject).mAppId;
        s.s(paramAppBrandRuntime, "activeRuntime.appId");
        this.qxD = paramAppBrandRuntime;
      }
      AppMethodBeat.o(316678);
      return true;
    }
    AppMethodBeat.o(316678);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.al
 * JD-Core Version:    0.7.0.1
 */