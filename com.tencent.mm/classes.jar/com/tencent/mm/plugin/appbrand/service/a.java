package com.tencent.mm.plugin.appbrand.service;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.g.b.a.hh;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

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
    catch (ao paramc)
    {
      h.wUl.idkeyStat(370L, 39L, 1L, false);
      com.tencent.mm.plugin.appbrand.report.g.b(((c)CX()).getAppId(), ((c)CX()).getRuntime().aTR().jEg.pkgVersion, ((c)CX()).getRuntime().aTR().jEg.jpa, 370, 39);
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
    catch (ao paramc)
    {
      h.wUl.idkeyStat(370L, 48L, 1L, false);
      com.tencent.mm.plugin.appbrand.report.g.b(((c)CX()).getAppId(), ((c)CX()).getRuntime().aTR().jEg.pkgVersion, ((c)CX()).getRuntime().aTR().jEg.jpa, 370, 48);
      AppMethodBeat.o(48242);
      throw paramc;
    }
  }
  
  public final int BB()
  {
    AppMethodBeat.i(48243);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYz, 0);
    AppMethodBeat.o(48243);
    return i;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(175063);
    Object localObject = parama.scriptName;
    ac.d("MicroMsg.AppBrandJSContextInterfaceWC", "reportBootstrapScriptEvaluateResult appId[%s] name[%s] succeed[%b]", new Object[] { ((c)CX()).getAppId(), localObject, Boolean.valueOf(paramBoolean) });
    if ("WASubContext.js".equals(localObject))
    {
      if (((c)CX()).getRuntime() != null)
      {
        if (paramBoolean) {
          com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)CX()).getAppId(), KSProcessWeAppLaunch.stepInjectJSWASubContext, "WASubContext.js", paramLong1, paramLong2);
        }
      }
      else if ((paramBoolean) && ((((c)CX()).aUl()) || (((c)CX()).isRunning())))
      {
        if (!(paramObject instanceof m.c)) {
          break label359;
        }
        paramObject = (m.c)paramObject;
        label140:
        com.tencent.mm.plugin.appbrand.report.quality.a.btI();
        localObject = com.tencent.mm.plugin.appbrand.report.quality.b.g(CX()).ou((String)localObject);
        ((hh)localObject).eeO = parama.cdf;
        if ((paramObject == null) || (paramObject.codeCacheStatus < 0) || (paramObject.codeCacheStatus >= v.leN.length)) {
          break label365;
        }
        l = v.leN[paramObject.codeCacheStatus];
        label205:
        ((hh)localObject).eeR = l;
        ((hh)localObject).eeS = 1L;
        if (paramObject == null) {
          break label373;
        }
        l = paramObject.flatJSCompileCost;
        label230:
        ((hh)localObject).eeT = l;
        if (paramObject == null) {
          break label379;
        }
      }
      label359:
      label365:
      label373:
      label379:
      for (long l = paramObject.cNu;; l = 0L)
      {
        ((hh)localObject).efl = l;
        ((hh)localObject).md(paramLong1);
        ((hh)localObject).me(paramLong2);
        ((hh)localObject).mc(((hh)localObject).edx - ((hh)localObject).edw);
        ((hh)localObject).aHZ();
        h.wUl.idkeyStat(370L, 40L, 1L, false);
        if (!paramBoolean) {
          break label385;
        }
        h.wUl.idkeyStat(370L, 41L, 1L, false);
        AppMethodBeat.o(175063);
        return;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)CX()).getAppId(), KSProcessWeAppLaunch.stepInjectJSWASubContext, "", "WASubContext.js", paramLong1, paramLong2);
        break;
        paramObject = null;
        break label140;
        l = 4L;
        break label205;
        l = 0L;
        break label230;
      }
      label385:
      h.wUl.idkeyStat(370L, 42L, 1L, false);
      if (parama.cdf <= 0) {
        h.wUl.dB(370, 74);
      }
      if (((c)CX()).getRuntime() == null)
      {
        AppMethodBeat.o(175063);
        return;
      }
      com.tencent.mm.plugin.appbrand.report.g.b(((c)CX()).getAppId(), ((c)CX()).getRuntime().aTR().jEg.pkgVersion, ((c)CX()).getRuntime().aTR().jEg.jpa, 370, 42);
      AppMethodBeat.o(175063);
      return;
    }
    if (((String)localObject).endsWith("app-service.js"))
    {
      if (((c)CX()).getRuntime() != null)
      {
        if (paramBoolean)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)CX()).getAppId(), KSProcessWeAppLaunch.stepInjectJSAppService, (String)localObject, paramLong1, paramLong2);
          com.tencent.mm.plugin.appbrand.keylogger.c.b(((c)CX()).getAppId(), KSProcessWeAppLaunch.stepServiceInit);
        }
      }
      else if (paramBoolean)
      {
        if ((((c)CX()).aUl()) || (((c)CX()).isRunning()))
        {
          o localo = ((c)CX()).getRuntime();
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
          ac.i("MicroMsg.AppBrandJSContextInterfaceWC", "[QualitySystem] app-service.js runtime.hashCode = [%d]", new Object[] { Integer.valueOf(i) });
          q localq = this.ceh;
          int j = parama.cdf;
          if (localo == null) {
            break label920;
          }
          i = localo.hashCode();
          label676:
          com.tencent.mm.plugin.appbrand.report.quality.a.a(localq, (String)localObject, j, "", 0, paramLong1, i, paramObject);
        }
        if (!((c)CX()).aUm()) {
          break label926;
        }
        i = 1;
        label709:
        x.a(1, paramLong2 - paramLong1, i, ((c)this.ceh).getAppId(), -1, 0, ((c)CX()).aSt().aVU());
        parama = com.tencent.mm.plugin.appbrand.report.quality.a.QN(((c)this.ceh).getAppId());
        if (parama != null)
        {
          paramLong1 = System.currentTimeMillis();
          paramLong2 = parama.lVL;
          if (!((c)CX()).aUm()) {
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
        x.a(7, paramLong1 - paramLong2, i, ((c)this.ceh).getAppId(), -1, 0, ((c)CX()).aSt().aVU());
        h.wUl.idkeyStat(370L, 44L, 1L, false);
        if (!paramBoolean) {
          break label938;
        }
        h.wUl.idkeyStat(370L, 45L, 1L, false);
        AppMethodBeat.o(175063);
        return;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)CX()).getAppId(), KSProcessWeAppLaunch.stepInjectJSAppService, "", (String)localObject, paramLong1, paramLong2);
        com.tencent.mm.plugin.appbrand.keylogger.c.c(((c)CX()).getAppId(), KSProcessWeAppLaunch.stepServiceInit);
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
      h.wUl.idkeyStat(370L, 46L, 1L, false);
      com.tencent.mm.plugin.appbrand.report.g.b(((c)CX()).getAppId(), ((c)CX()).getRuntime().aTR().jEg.pkgVersion, ((c)CX()).getRuntime().aTR().jEg.jpa, 370, 46);
    }
    AppMethodBeat.o(175063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.a
 * JD-Core Version:    0.7.0.1
 */