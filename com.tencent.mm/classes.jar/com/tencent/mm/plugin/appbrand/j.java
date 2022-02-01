package com.tencent.mm.plugin.appbrand;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.f.a;
import com.tencent.mm.plugin.appbrand.api.f.b;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/AppBrandPreRenderColdStartService;", "", "()V", "TAG", "", "start", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "callback", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "startInternal", "requestId", "", "plugin-appbrand-integration_release"})
public final class j
{
  public static final j kAc;
  
  static
  {
    AppMethodBeat.i(227892);
    kAc = new j();
    AppMethodBeat.o(227892);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.api.g paramg, f paramf)
  {
    AppMethodBeat.i(227891);
    p.h(paramg, "bundle");
    int j = paramg.hashCode();
    final long l = Util.currentTicks();
    Log.i("MicroMsg.AppBrandPreRenderColdStartService", "start with id:" + j + " username:" + paramg.username + " appId:" + paramg.appId + " versionType:" + paramg.iOo + " path:" + paramg.kHw + " scene:" + paramg.scene);
    com.tencent.mm.plugin.report.service.h.CyF.dN(1519, 0);
    paramf = (f)new a(j, l, paramf);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rUq, 1) <= 0)
    {
      f.a.a(paramf, -8);
      AppMethodBeat.o(227891);
      return;
    }
    try
    {
      Object localObject = u.mTD;
      u.a(paramg);
      localObject = u.mTD;
      localObject = u.b(paramg);
      CharSequence localCharSequence = (CharSequence)paramg.appId;
      if ((localCharSequence == null) || (localCharSequence.length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label313;
        }
        paramg = paramg.appId;
        paramg = com.tencent.mm.plugin.appbrand.report.quality.g.c((LaunchParcel)localObject, paramg);
        ((LaunchParcel)localObject).cyz = com.tencent.luggage.sdk.launching.b.cBC;
        ((LaunchParcel)localObject).mYM = Util.nowMilliSecond();
        com.tencent.f.h.RTc.aZ((Runnable)new am(j, (LaunchParcel)localObject, paramg, paramf));
        AppMethodBeat.o(227891);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
        {
          paramg = (Throwable)localException;
          AppMethodBeat.o(227891);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/AppBrandPreRenderColdStartService$start$1", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "plugin-appbrand-integration_release"})
  public static final class a
    implements f
  {
    a(int paramInt, long paramLong, f paramf) {}
    
    public final void onError(int paramInt, String paramString)
    {
      AppMethodBeat.i(227890);
      Object localObject = new StringBuilder("onError, requestId:").append(this.kAd).append(", errCode:");
      f.b localb = f.b.kHv;
      Log.e("MicroMsg.AppBrandPreRenderColdStartService", f.b.vM(paramInt) + ", errMsg:" + paramString + ", cost:" + Util.ticksToNow(l));
      localObject = this.kAf;
      if (localObject != null) {
        ((f)localObject).onError(paramInt, paramString);
      }
      paramString = com.tencent.mm.plugin.report.service.h.CyF;
      localObject = as.kFm;
      paramString.dN(1519, as.vD(paramInt));
      AppMethodBeat.o(227890);
    }
    
    public final void onSuccess()
    {
      AppMethodBeat.i(227889);
      Log.i("MicroMsg.AppBrandPreRenderColdStartService", "onSuccess, requestId:" + this.kAd + ", cost:" + Util.ticksToNow(l));
      f localf = this.kAf;
      if (localf != null) {
        localf.onSuccess();
      }
      com.tencent.mm.plugin.report.service.h.CyF.dN(1519, 1);
      AppMethodBeat.o(227889);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j
 * JD-Core Version:    0.7.0.1
 */