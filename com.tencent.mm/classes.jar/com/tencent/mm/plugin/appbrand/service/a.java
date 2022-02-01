package com.tencent.mm.plugin.appbrand.service;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.g.b.a.il;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends com.tencent.luggage.sdk.b.a.c.g<c>
{
  a(c paramc, t paramt)
  {
    super(paramc, paramt);
  }
  
  private String c(c paramc)
  {
    AppMethodBeat.i(48241);
    try
    {
      paramc = super.c(paramc);
      AppMethodBeat.o(48241);
      return paramc;
    }
    catch (ap paramc)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(370L, 39L, 1L, false);
      h.b(((c)Ew()).getAppId(), ((c)Ew()).getRuntime().aXb().jYh.pkgVersion, ((c)Ew()).getRuntime().aXb().jYh.jIU, 370, 39);
      AppMethodBeat.o(48241);
      throw paramc;
    }
  }
  
  private String d(c paramc, String paramString)
  {
    AppMethodBeat.i(48242);
    try
    {
      paramc = super.a(paramc, paramString);
      AppMethodBeat.o(48242);
      return paramc;
    }
    catch (ap paramc)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(370L, 48L, 1L, false);
      h.b(((c)Ew()).getAppId(), ((c)Ew()).getRuntime().aXb().jYh.pkgVersion, ((c)Ew()).getRuntime().aXb().jYh.jIU, 370, 48);
      AppMethodBeat.o(48242);
      throw paramc;
    }
  }
  
  public final int Da()
  {
    AppMethodBeat.i(48243);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDK, 0);
    AppMethodBeat.o(48243);
    return i;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(175063);
    Object localObject = parama.scriptName;
    ad.d("MicroMsg.AppBrandJSContextInterfaceWC", "reportBootstrapScriptEvaluateResult appId[%s] name[%s] succeed[%b]", new Object[] { ((c)Ew()).getAppId(), localObject, Boolean.valueOf(paramBoolean) });
    if ("WASubContext.js".equals(localObject))
    {
      if (((c)Ew()).getRuntime() != null)
      {
        if (paramBoolean) {
          com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)Ew()).getAppId(), KSProcessWeAppLaunch.stepInjectJSWASubContext, "WASubContext.js", paramLong1, paramLong2);
        }
      }
      else if ((paramBoolean) && ((((c)Ew()).aXu()) || (((c)Ew()).isRunning())))
      {
        if (!(paramObject instanceof m.c)) {
          break label359;
        }
        paramObject = (m.c)paramObject;
        label140:
        com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
        localObject = com.tencent.mm.plugin.appbrand.report.quality.b.j(Ew()).qY((String)localObject);
        ((il)localObject).evB = parama.cnw;
        if ((paramObject == null) || (paramObject.codeCacheStatus < 0) || (paramObject.codeCacheStatus >= v.lBM.length)) {
          break label365;
        }
        l = v.lBM[paramObject.codeCacheStatus];
        label205:
        ((il)localObject).evE = l;
        ((il)localObject).evF = 1L;
        if (paramObject == null) {
          break label373;
        }
        l = paramObject.flatJSCompileCost;
        label230:
        ((il)localObject).evG = l;
        if (paramObject == null) {
          break label379;
        }
      }
      label359:
      label365:
      label373:
      label379:
      for (long l = paramObject.cYK;; l = 0L)
      {
        ((il)localObject).evX = l;
        ((il)localObject).ob(paramLong1);
        ((il)localObject).oc(paramLong2);
        ((il)localObject).oa(((il)localObject).euc - ((il)localObject).eub);
        ((il)localObject).aLk();
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(370L, 40L, 1L, false);
        if (!paramBoolean) {
          break label385;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(370L, 41L, 1L, false);
        AppMethodBeat.o(175063);
        return;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)Ew()).getAppId(), KSProcessWeAppLaunch.stepInjectJSWASubContext, "", "WASubContext.js", paramLong1, paramLong2);
        break;
        paramObject = null;
        break label140;
        l = 4L;
        break label205;
        l = 0L;
        break label230;
      }
      label385:
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(370L, 42L, 1L, false);
      if (parama.cnw <= 0) {
        com.tencent.mm.plugin.report.service.g.yhR.dD(370, 74);
      }
      if (((c)Ew()).getRuntime() == null)
      {
        AppMethodBeat.o(175063);
        return;
      }
      h.b(((c)Ew()).getAppId(), ((c)Ew()).getRuntime().aXb().jYh.pkgVersion, ((c)Ew()).getRuntime().aXb().jYh.jIU, 370, 42);
      AppMethodBeat.o(175063);
      return;
    }
    if (((String)localObject).endsWith("app-service.js"))
    {
      if (((c)Ew()).getRuntime() != null)
      {
        if (paramBoolean)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)Ew()).getAppId(), KSProcessWeAppLaunch.stepInjectJSAppService, (String)localObject, paramLong1, paramLong2);
          com.tencent.mm.plugin.appbrand.keylogger.c.b(((c)Ew()).getAppId(), KSProcessWeAppLaunch.stepServiceInit);
        }
      }
      else if (paramBoolean)
      {
        if ((((c)Ew()).aXu()) || (((c)Ew()).isRunning()))
        {
          o localo = ((c)Ew()).getRuntime();
          if (!(paramObject instanceof m.c)) {
            break label908;
          }
          paramObject = (m.c)paramObject;
          label620:
          if (localo == null) {
            break label914;
          }
          i = localo.hashCode();
          label632:
          ad.i("MicroMsg.AppBrandJSContextInterfaceWC", "[QualitySystem] app-service.js runtime.hashCode = [%d]", new Object[] { Integer.valueOf(i) });
          q localq = this.cox;
          int j = parama.cnw;
          if (localo == null) {
            break label920;
          }
          i = localo.hashCode();
          label676:
          com.tencent.mm.plugin.appbrand.report.quality.a.a(localq, (String)localObject, j, "", 0, paramLong1, i, paramObject);
        }
        if (!((c)Ew()).aXv()) {
          break label926;
        }
        i = 1;
        label709:
        x.a(1, paramLong2 - paramLong1, i, ((c)this.cox).getAppId(), -1, 0, ((c)Ew()).aVF().aZp());
        parama = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(((c)this.cox).getAppId());
        if (parama != null)
        {
          paramLong1 = System.currentTimeMillis();
          paramLong2 = parama.mvB;
          if (!((c)Ew()).aXv()) {
            break label932;
          }
        }
      }
      label908:
      label914:
      label920:
      label926:
      label932:
      for (int i = 1;; i = 0)
      {
        x.a(7, paramLong1 - paramLong2, i, ((c)this.cox).getAppId(), -1, 0, ((c)Ew()).aVF().aZp());
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(370L, 44L, 1L, false);
        if (!paramBoolean) {
          break label938;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(370L, 45L, 1L, false);
        AppMethodBeat.o(175063);
        return;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)Ew()).getAppId(), KSProcessWeAppLaunch.stepInjectJSAppService, "", (String)localObject, paramLong1, paramLong2);
        com.tencent.mm.plugin.appbrand.keylogger.c.c(((c)Ew()).getAppId(), KSProcessWeAppLaunch.stepServiceInit);
        break;
        paramObject = null;
        break label620;
        i = -1;
        break label632;
        i = -1;
        break label676;
        i = 0;
        break label709;
      }
      label938:
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(370L, 46L, 1L, false);
      h.b(((c)Ew()).getAppId(), ((c)Ew()).getRuntime().aXb().jYh.pkgVersion, ((c)Ew()).getRuntime().aXb().jYh.jIU, 370, 46);
    }
    AppMethodBeat.o(175063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.a
 * JD-Core Version:    0.7.0.1
 */