package com.tencent.mm.plugin.appbrand.service;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.g.b.a.in;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends com.tencent.luggage.sdk.b.a.c.h<c>
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
    catch (aq paramc)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(370L, 39L, 1L, false);
      com.tencent.mm.plugin.appbrand.report.h.b(((c)Ey()).getAppId(), ((c)Ey()).getRuntime().aXw().kbw.pkgVersion, ((c)Ey()).getRuntime().aXw().kbw.jLV, 370, 39);
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
    catch (aq paramc)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(370L, 48L, 1L, false);
      com.tencent.mm.plugin.appbrand.report.h.b(((c)Ey()).getAppId(), ((c)Ey()).getRuntime().aXw().kbw.pkgVersion, ((c)Ey()).getRuntime().aXw().kbw.jLV, 370, 48);
      AppMethodBeat.o(48242);
      throw paramc;
    }
  }
  
  public final int Dd()
  {
    AppMethodBeat.i(48243);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLp, 0);
    AppMethodBeat.o(48243);
    return i;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(175063);
    Object localObject = parama.scriptName;
    ae.d("MicroMsg.AppBrandJSContextInterfaceWC", "reportBootstrapScriptEvaluateResult appId[%s] name[%s] succeed[%b]", new Object[] { ((c)Ey()).getAppId(), localObject, Boolean.valueOf(paramBoolean) });
    if ("WASubContext.js".equals(localObject))
    {
      if (((c)Ey()).getRuntime() != null)
      {
        if (paramBoolean) {
          com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)Ey()).getAppId(), KSProcessWeAppLaunch.stepInjectJSWASubContext, "WASubContext.js", paramLong1, paramLong2);
        }
      }
      else if ((paramBoolean) && ((((c)Ey()).aXP()) || (((c)Ey()).isRunning())))
      {
        if (!(paramObject instanceof m.c)) {
          break label359;
        }
        paramObject = (m.c)paramObject;
        label140:
        com.tencent.mm.plugin.appbrand.report.quality.a.byG();
        localObject = com.tencent.mm.plugin.appbrand.report.quality.b.l(Ey()).rt((String)localObject);
        ((in)localObject).exi = parama.cny;
        if ((paramObject == null) || (paramObject.codeCacheStatus < 0) || (paramObject.codeCacheStatus >= v.lGl.length)) {
          break label365;
        }
        l = v.lGl[paramObject.codeCacheStatus];
        label205:
        ((in)localObject).exl = l;
        ((in)localObject).exm = 1L;
        if (paramObject == null) {
          break label373;
        }
        l = paramObject.flatJSCompileCost;
        label230:
        ((in)localObject).exn = l;
        if (paramObject == null) {
          break label379;
        }
      }
      label359:
      label365:
      label373:
      label379:
      for (long l = paramObject.cZI;; l = 0L)
      {
        ((in)localObject).exE = l;
        ((in)localObject).on(paramLong1);
        ((in)localObject).oo(paramLong2);
        ((in)localObject).om(((in)localObject).evJ - ((in)localObject).evI);
        ((in)localObject).aLH();
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(370L, 40L, 1L, false);
        if (!paramBoolean) {
          break label385;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(370L, 41L, 1L, false);
        AppMethodBeat.o(175063);
        return;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)Ey()).getAppId(), KSProcessWeAppLaunch.stepInjectJSWASubContext, "", "WASubContext.js", paramLong1, paramLong2);
        break;
        paramObject = null;
        break label140;
        l = 4L;
        break label205;
        l = 0L;
        break label230;
      }
      label385:
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(370L, 42L, 1L, false);
      if (parama.cny <= 0) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(370, 74);
      }
      if (((c)Ey()).getRuntime() == null)
      {
        AppMethodBeat.o(175063);
        return;
      }
      com.tencent.mm.plugin.appbrand.report.h.b(((c)Ey()).getAppId(), ((c)Ey()).getRuntime().aXw().kbw.pkgVersion, ((c)Ey()).getRuntime().aXw().kbw.jLV, 370, 42);
      AppMethodBeat.o(175063);
      return;
    }
    if (((String)localObject).endsWith("app-service.js"))
    {
      if (((c)Ey()).getRuntime() != null)
      {
        if (paramBoolean)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)Ey()).getAppId(), KSProcessWeAppLaunch.stepInjectJSAppService, (String)localObject, paramLong1, paramLong2);
          com.tencent.mm.plugin.appbrand.keylogger.c.b(((c)Ey()).getAppId(), KSProcessWeAppLaunch.stepServiceInit);
        }
      }
      else if (paramBoolean)
      {
        if ((((c)Ey()).aXP()) || (((c)Ey()).isRunning()))
        {
          p localp = ((c)Ey()).getRuntime();
          if (!(paramObject instanceof m.c)) {
            break label908;
          }
          paramObject = (m.c)paramObject;
          label620:
          if (localp == null) {
            break label914;
          }
          i = localp.hashCode();
          label632:
          ae.i("MicroMsg.AppBrandJSContextInterfaceWC", "[QualitySystem] app-service.js runtime.hashCode = [%d]", new Object[] { Integer.valueOf(i) });
          r localr = this.coz;
          int j = parama.cny;
          if (localp == null) {
            break label920;
          }
          i = localp.hashCode();
          label676:
          com.tencent.mm.plugin.appbrand.report.quality.a.a(localr, (String)localObject, j, "", 0, paramLong1, i, paramObject);
        }
        if (!((c)Ey()).aXQ()) {
          break label926;
        }
        i = 1;
        label709:
        x.a(1, paramLong2 - paramLong1, i, ((c)this.coz).getAppId(), -1, 0, ((c)Ey()).aWe().aZM());
        parama = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(((c)this.coz).getAppId());
        if (parama != null)
        {
          paramLong1 = System.currentTimeMillis();
          paramLong2 = parama.mAy;
          if (!((c)Ey()).aXQ()) {
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
        x.a(7, paramLong1 - paramLong2, i, ((c)this.coz).getAppId(), -1, 0, ((c)Ey()).aWe().aZM());
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(370L, 44L, 1L, false);
        if (!paramBoolean) {
          break label938;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(370L, 45L, 1L, false);
        AppMethodBeat.o(175063);
        return;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)Ey()).getAppId(), KSProcessWeAppLaunch.stepInjectJSAppService, "", (String)localObject, paramLong1, paramLong2);
        com.tencent.mm.plugin.appbrand.keylogger.c.c(((c)Ey()).getAppId(), KSProcessWeAppLaunch.stepServiceInit);
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
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(370L, 46L, 1L, false);
      com.tencent.mm.plugin.appbrand.report.h.b(((c)Ey()).getAppId(), ((c)Ey()).getRuntime().aXw().kbw.pkgVersion, ((c)Ey()).getRuntime().aXw().kbw.jLV, 370, 46);
    }
    AppMethodBeat.o(175063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.a
 * JD-Core Version:    0.7.0.1
 */