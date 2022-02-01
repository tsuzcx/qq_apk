package com.tencent.mm.plugin.appbrand;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.f.a;
import com.tencent.mm.plugin.appbrand.api.f.b;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/AppBrandPreRenderColdStartService;", "", "()V", "TAG", "", "start", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "callback", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "startInternal", "requestId", "", "plugin-appbrand-integration_release"})
public final class m
{
  public static final m ntn;
  
  static
  {
    AppMethodBeat.i(279056);
    ntn = new m();
    AppMethodBeat.o(279056);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.api.g paramg, f paramf)
  {
    AppMethodBeat.i(279055);
    p.k(paramg, "bundle");
    int j = paramg.hashCode();
    final long l = Util.currentTicks();
    Log.i("MicroMsg.AppBrandPreRenderColdStartService", "start with id:" + j + " username:" + paramg.username + " appId:" + paramg.appId + " versionType:" + paramg.cBU + " path:" + paramg.nBq + " scene:" + paramg.scene);
    com.tencent.mm.plugin.report.service.h.IzE.el(1519, 0);
    paramf = (f)new a(j, l, paramf);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBa, 1) <= 0)
    {
      f.a.a(paramf, -8);
      AppMethodBeat.o(279055);
      return;
    }
    try
    {
      Object localObject = t.pUE;
      t.a(paramg);
      localObject = t.pUE;
      localObject = t.b(paramg);
      CharSequence localCharSequence = (CharSequence)paramg.appId;
      if ((localCharSequence == null) || (localCharSequence.length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label313;
        }
        paramg = paramg.appId;
        paramg = com.tencent.mm.plugin.appbrand.report.quality.g.c((LaunchParcel)localObject, paramg);
        ((LaunchParcel)localObject).cxe = com.tencent.luggage.sdk.launching.b.cBf;
        ((LaunchParcel)localObject).pZk = Util.nowMilliSecond();
        com.tencent.e.h.ZvG.bg((Runnable)new an(j, (LaunchParcel)localObject, paramg, paramf));
        AppMethodBeat.o(279055);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
        {
          paramg = (Throwable)localException;
          AppMethodBeat.o(279055);
          throw paramg;
        }
        f.a.a(paramf, -1);
        continue;
        int i = 0;
        continue;
        label313:
        paramg = com.tencent.mm.plugin.appbrand.launching.e.h.a(localException);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/AppBrandPreRenderColdStartService$start$1", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "plugin-appbrand-integration_release"})
  public static final class a
    implements f
  {
    a(int paramInt, long paramLong, f paramf) {}
    
    public final void onError(int paramInt, String paramString)
    {
      AppMethodBeat.i(271574);
      Object localObject = new StringBuilder("onError, requestId:").append(this.nto).append(", errCode:");
      f.b localb = f.b.nBp;
      Log.e("MicroMsg.AppBrandPreRenderColdStartService", f.b.yX(paramInt) + ", errMsg:" + paramString + ", cost:" + Util.ticksToNow(l));
      localObject = this.ntq;
      if (localObject != null) {
        ((f)localObject).onError(paramInt, paramString);
      }
      paramString = com.tencent.mm.plugin.report.service.h.IzE;
      localObject = at.nyS;
      paramString.el(1519, at.yO(paramInt));
      AppMethodBeat.o(271574);
    }
    
    public final void onSuccess()
    {
      AppMethodBeat.i(271573);
      Log.i("MicroMsg.AppBrandPreRenderColdStartService", "onSuccess, requestId:" + this.nto + ", cost:" + Util.ticksToNow(l));
      f localf = this.ntq;
      if (localf != null) {
        localf.onSuccess();
      }
      com.tencent.mm.plugin.report.service.h.IzE.el(1519, 1);
      AppMethodBeat.o(271573);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m
 * JD-Core Version:    0.7.0.1
 */