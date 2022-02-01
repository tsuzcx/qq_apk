package com.tencent.mm.plugin.appbrand.report;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.g.b.a.jj;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.n.n;
import d.t;
import d.v;
import java.util.concurrent.atomic.AtomicInteger;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceWCScriptReporter;", "", "()V", "TAG", "", "reportEvaluateResult", "", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "scriptInfo", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "succeed", "", "startTimeMs", "", "endTimeMs", "extraParams", "reportJSError", "message", "stackTrace", "plugin-appbrand-integration_release"})
public final class j
{
  public static final j mru;
  
  static
  {
    AppMethodBeat.i(51009);
    mru = new j();
    AppMethodBeat.o(51009);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.service.c paramc, d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(175210);
    p.h(paramc, "service");
    p.h(parama, "scriptInfo");
    Object localObject1 = parama.scriptName;
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(175210);
      return;
    }
    if (!paramBoolean)
    {
      ad.e("MicroMsg.AppBrandServiceWCScriptReporter", "reportEvaluateResult, !succeed name[" + (String)localObject1 + "], appId[" + paramc.getAppId() + ']');
      if ((parama.cnw <= 0) && (localObject1 != null)) {}
    }
    else
    {
      if (localObject1 != null) {
        break label251;
      }
    }
    label251:
    int k;
    label313:
    label375:
    int j;
    for (;;)
    {
      if (n.nA((String)localObject1, "/app-service.js"))
      {
        g.yhR.dD(370, 30);
        if (paramBoolean)
        {
          g.yhR.dD(370, 31);
          AppMethodBeat.o(175210);
          return;
          switch (((String)localObject1).hashCode())
          {
          default: 
            break;
          case -979125780: 
            if (!((String)localObject1).equals("WAServiceMainContext.js")) {
              break;
            }
            g.yhR.dD(370, 73);
            break;
          case 2071195020: 
            if (!((String)localObject1).equals("WAService.js")) {
              break;
            }
            g.yhR.dD(370, 72);
            break;
            switch (((String)localObject1).hashCode())
            {
            default: 
              break;
            case -979125780: 
              if (((String)localObject1).equals("WAServiceMainContext.js"))
              {
                ad.i("MicroMsg.AppBrandServiceWCScriptReporter", "reportEvaluateResult, service_lib_script[" + (String)localObject1 + "], succeed[" + paramBoolean + ']');
                if (paramc.getRuntime() != null)
                {
                  if (paramBoolean) {
                    com.tencent.mm.plugin.appbrand.keylogger.c.a(paramc.getAppId(), KSProcessWeAppLaunch.stepInjectJSWAMainContext, "", paramLong1, paramLong2);
                  }
                }
                else
                {
                  a.bxN();
                  b.a(paramc, (String)localObject1, parama.cnw, paramLong1, paramLong2, paramObject);
                  switch (((String)localObject1).hashCode())
                  {
                  default: 
                    parama = new t(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    i = ((Number)parama.first).intValue();
                    k = ((Number)parama.second).intValue();
                    j = ((Number)parama.MKl).intValue();
                    g.yhR.dD(370, i);
                    if (paramBoolean)
                    {
                      g.yhR.dD(370, j);
                      AppMethodBeat.o(175210);
                      return;
                    }
                    break;
                  }
                }
              }
              break;
            case 452806299: 
              if (((String)localObject1).equals("WAGame.js")) {
                if (!paramBoolean)
                {
                  h.bS(paramc.getAppId(), 24);
                  parama = paramc.getAppId();
                  paramObject = paramc.getRuntime();
                  p.g(paramObject, "service.runtime");
                  i = paramObject.EX();
                  paramc = paramc.getRuntime();
                  p.g(paramc, "service.runtime");
                  h.b(parama, i, paramc.aVL(), 778, 14);
                  AppMethodBeat.o(175210);
                  return;
                }
              }
              break;
            case 293174862: 
              label424:
              label444:
              if (((String)localObject1).equals("app-service.js"))
              {
                g.yhR.dD(370, 9);
                if (paramBoolean) {
                  if ((paramc.aXu()) || (paramc.isRunning()))
                  {
                    localObject2 = (AppBrandRuntime)paramc.getRuntime();
                    if ((paramObject instanceof m.c)) {
                      break label1172;
                    }
                    paramObject = null;
                  }
                }
              }
              break;
            }
            break;
          }
        }
      }
    }
    label1172:
    for (;;)
    {
      m.c localc = (m.c)paramObject;
      if (localc != null)
      {
        paramLong1 = localc.cYI;
        label669:
        if (localObject2 == null) {
          break label993;
        }
        paramObject = ((AppBrandRuntime)localObject2).getAppId();
        label681:
        if (localObject2 == null) {
          break label999;
        }
        localObject1 = Integer.valueOf(((AppBrandRuntime)localObject2).hashCode());
        label696:
        ad.i("MicroMsg.AppBrandServiceWCScriptReporter", "[QualitySystem] app-service.js runtime.appId=[%s], runtime.hashCode = [%d]", new Object[] { paramObject, localObject1 });
        paramc = (d)paramc;
        j = parama.cnw;
        if (localObject2 == null) {
          break label1008;
        }
      }
      label984:
      label993:
      label999:
      label1008:
      for (i = ((AppBrandRuntime)localObject2).hashCode();; i = -1)
      {
        a.a(paramc, "app-service.js", j, "", 0, paramLong1, i, localc);
        g.yhR.dD(370, 11);
        AppMethodBeat.o(175210);
        return;
        if (!((String)localObject1).equals("WAService.js")) {
          break;
        }
        break label313;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(paramc.getAppId(), KSProcessWeAppLaunch.stepInjectJSWAMainContext, "", "", paramLong1, paramLong2);
        break label375;
        if (!((String)localObject1).equals("WAService.js")) {
          break label424;
        }
        parama = new t(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7));
        break label444;
        if (!((String)localObject1).equals("WAServiceMainContext.js")) {
          break label424;
        }
        parama = new t(Integer.valueOf(61), Integer.valueOf(62), Integer.valueOf(63));
        break label444;
        g.yhR.dD(370, k);
        h.bS(paramc.getAppId(), 24);
        if (paramc.getRuntime() != null)
        {
          parama = paramc.getRuntime();
          p.g(parama, "runtime");
          i = parama.aXb().jYh.pkgVersion;
          if (paramc.getRuntime() == null) {
            break label984;
          }
          parama = paramc.getRuntime();
          p.g(parama, "runtime");
        }
        for (j = parama.aXb().bee();; j = -1)
        {
          h.b(paramc.getAppId(), i, j, 370, k);
          AppMethodBeat.o(175210);
          return;
          i = 0;
          break;
        }
        break label669;
        paramObject = null;
        break label681;
        localObject1 = Integer.valueOf(-1);
        break label696;
      }
      try
      {
        g.yhR.dD(370, 10);
        h.bS(paramc.getAppId(), 24);
        h.b(paramc.getAppId(), paramc.getRuntime().aXb().jYh.pkgVersion, paramc.getRuntime().aXb().jYh.jIU, 370, 10);
        AppMethodBeat.o(175210);
        return;
      }
      catch (NullPointerException paramc)
      {
        ad.e("MicroMsg.AppBrandServiceWCScriptReporter", "Inject External Service Script Failed, report npe = %s", new Object[] { paramc });
        AppMethodBeat.o(175210);
        return;
      }
      a.bxN();
      b.a(paramc, (String)localObject1, parama.cnw, paramLong1, paramLong2, paramObject);
      AppMethodBeat.o(175210);
      return;
      ad.e("MicroMsg.AppBrandServiceWCScriptReporter", "inject module(" + (String)localObject1 + ") script failed");
      g.yhR.dD(370, 32);
      AppMethodBeat.o(175210);
      return;
    }
  }
  
  public static final void b(com.tencent.mm.plugin.appbrand.service.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(51008);
    p.h(paramc, "service");
    QualitySessionRuntime localQualitySessionRuntime = a.Ut(paramc.getAppId());
    if (localQualitySessionRuntime != null)
    {
      jj localjj = new jj();
      localjj.rN(localQualitySessionRuntime.appId);
      localjj.pG(localQualitySessionRuntime.mvi);
      localjj.pH(localQualitySessionRuntime.mtG);
      localjj.Vr();
      localjj.rO(paramString1);
      localjj.rP(paramString2);
      paramString1 = paramc.aVF();
      if (paramString1 == null) {
        p.gfZ();
      }
      localjj.rQ(paramString1.aZn());
      localjj.pI(localQualitySessionRuntime.apptype);
      localjj.pJ(localQualitySessionRuntime.mvv.get());
      paramString1 = paramc.aWZ();
      p.g(paramString1, "page");
      paramc = paramString1.getURL();
      paramString1 = paramString1.buA();
      p.g(paramString1, "page.urlWithQuery");
      int i = paramc.length();
      if (paramString1 == null)
      {
        paramc = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(51008);
        throw paramc;
      }
      paramString1 = paramString1.substring(i);
      p.g(paramString1, "(this as java.lang.String).substring(startIndex)");
      localjj.rR(paramc);
      localjj.rS(paramString1);
      localjj.aLk();
      AppMethodBeat.o(51008);
      return;
    }
    AppMethodBeat.o(51008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.j
 * JD-Core Version:    0.7.0.1
 */