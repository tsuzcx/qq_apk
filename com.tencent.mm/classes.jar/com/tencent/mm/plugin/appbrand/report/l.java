package com.tencent.mm.plugin.appbrand.report;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.f.b.a.qj;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.r;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceWCScriptReporter;", "", "()V", "TAG", "", "reportEvaluateResult", "", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "scriptInfo", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "succeed", "", "startTimeMs", "", "endTimeMs", "extraParams", "reportJSError", "message", "stackTrace", "plugin-appbrand-integration_release"})
public final class l
{
  public static final l qJC;
  
  static
  {
    AppMethodBeat.i(51009);
    qJC = new l();
    AppMethodBeat.o(51009);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.service.c paramc, d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(175210);
    p.k(paramc, "service");
    p.k(parama, "scriptInfo");
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
      Log.e("MicroMsg.AppBrandServiceWCScriptReporter", "reportEvaluateResult, !succeed name[" + (String)localObject1 + "], appId[" + paramc.getAppId() + ']');
      if ((parama.cyw <= 0) && (localObject1 != null)) {}
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
      if (n.pu((String)localObject1, "/app-service.js"))
      {
        h.IzE.el(370, 30);
        if (paramBoolean)
        {
          h.IzE.el(370, 31);
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
            h.IzE.el(370, 73);
            break;
          case 2071195020: 
            if (!((String)localObject1).equals("WAService.js")) {
              break;
            }
            h.IzE.el(370, 72);
            break;
            switch (((String)localObject1).hashCode())
            {
            default: 
              break;
            case -979125780: 
              if (((String)localObject1).equals("WAServiceMainContext.js"))
              {
                Log.i("MicroMsg.AppBrandServiceWCScriptReporter", "reportEvaluateResult, service_lib_script[" + (String)localObject1 + "], succeed[" + paramBoolean + ']');
                if (paramc.getRuntime() != null)
                {
                  if (paramBoolean) {
                    com.tencent.mm.plugin.appbrand.keylogger.c.a(paramc.getAppId(), KSProcessWeAppLaunch.stepInjectJSWAMainContext, "", paramLong1, paramLong2);
                  }
                }
                else
                {
                  b.cik();
                  com.tencent.mm.plugin.appbrand.report.quality.c.a(paramc, (String)localObject1, parama.cyw, paramLong1, paramLong2, paramObject);
                  switch (((String)localObject1).hashCode())
                  {
                  default: 
                    parama = new r(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    i = ((Number)parama.Mx).intValue();
                    k = ((Number)parama.My).intValue();
                    j = ((Number)parama.aazK).intValue();
                    h.IzE.el(370, i);
                    if (paramBoolean)
                    {
                      h.IzE.el(370, j);
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
                  j.cE(paramc.getAppId(), 24);
                  parama = paramc.getAppId();
                  paramObject = paramc.getRuntime();
                  p.j(paramObject, "service.runtime");
                  i = paramObject.Sg();
                  paramObject = paramc.getRuntime();
                  p.j(paramObject, "service.runtime");
                  j.b(parama, i, paramObject.bBV(), 778, 14);
                  if (paramc.getRuntime() == null) {
                    break label1215;
                  }
                  if (!paramBoolean) {
                    break label1152;
                  }
                  com.tencent.mm.plugin.appbrand.keylogger.c.a(paramc.getAppId(), KSProcessWeAppLaunch.stepInjectWAGameContext, "WAGame.js", paramLong1, paramLong2);
                  AppMethodBeat.o(175210);
                }
              }
              break;
            case 293174862: 
              label424:
              label444:
              label589:
              if (((String)localObject1).equals("app-service.js"))
              {
                h.IzE.el(370, 9);
                if (paramBoolean) {
                  if ((paramc.bDU()) || (paramc.isRunning()))
                  {
                    localObject2 = (AppBrandRuntime)paramc.getRuntime();
                    if ((paramObject instanceof m.c)) {
                      break label1221;
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
    label698:
    label1215:
    label1221:
    for (;;)
    {
      m.c localc = (m.c)paramObject;
      if (localc != null)
      {
        paramLong1 = localc.fiR;
        if (localObject2 == null) {
          break label1022;
        }
        paramObject = ((AppBrandRuntime)localObject2).getAppId();
        label710:
        if (localObject2 == null) {
          break label1028;
        }
        localObject1 = Integer.valueOf(((AppBrandRuntime)localObject2).hashCode());
        label725:
        Log.i("MicroMsg.AppBrandServiceWCScriptReporter", "[QualitySystem] app-service.js runtime.appId=[%s], runtime.hashCode = [%d]", new Object[] { paramObject, localObject1 });
        paramc = (g)paramc;
        j = parama.cyw;
        if (localObject2 == null) {
          break label1037;
        }
      }
      for (i = ((AppBrandRuntime)localObject2).hashCode();; i = -1)
      {
        b.a(paramc, "app-service.js", j, "", 0, paramLong1, i, localc);
        h.IzE.el(370, 11);
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
        parama = new r(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7));
        break label444;
        if (!((String)localObject1).equals("WAServiceMainContext.js")) {
          break label424;
        }
        parama = new r(Integer.valueOf(61), Integer.valueOf(62), Integer.valueOf(63));
        break label444;
        h.IzE.el(370, k);
        j.cE(paramc.getAppId(), 24);
        if (paramc.getRuntime() != null)
        {
          parama = paramc.getRuntime();
          p.j(parama, "runtime");
          i = parama.bDx().nYR.pkgVersion;
          if (paramc.getRuntime() == null) {
            break label1013;
          }
          parama = paramc.getRuntime();
          p.j(parama, "runtime");
        }
        label1013:
        for (j = parama.bDx().bLq();; j = -1)
        {
          j.b(paramc.getAppId(), i, j, 370, k);
          AppMethodBeat.o(175210);
          return;
          i = 0;
          break;
        }
        break label698;
        label1022:
        paramObject = null;
        break label710;
        localObject1 = Integer.valueOf(-1);
        break label725;
      }
      try
      {
        h.IzE.el(370, 10);
        j.cE(paramc.getAppId(), 24);
        j.b(paramc.getAppId(), paramc.getRuntime().bDx().nYR.pkgVersion, paramc.getRuntime().bDx().nYR.nHY, 370, 10);
        AppMethodBeat.o(175210);
        return;
      }
      catch (NullPointerException paramc)
      {
        Log.e("MicroMsg.AppBrandServiceWCScriptReporter", "Inject External Service Script Failed, report npe = %s", new Object[] { paramc });
        AppMethodBeat.o(175210);
        return;
      }
      b.cik();
      com.tencent.mm.plugin.appbrand.report.quality.c.a(paramc, (String)localObject1, parama.cyw, paramLong1, paramLong2, paramObject);
      break label589;
      com.tencent.mm.plugin.appbrand.keylogger.c.a(paramc.getAppId(), KSProcessWeAppLaunch.stepInjectWAGameContext, "", "WAGame.js", paramLong1, paramLong2);
      AppMethodBeat.o(175210);
      return;
      Log.e("MicroMsg.AppBrandServiceWCScriptReporter", "inject module(" + (String)localObject1 + ") script failed");
      h.IzE.el(370, 32);
      AppMethodBeat.o(175210);
      return;
    }
  }
  
  public static final void b(com.tencent.mm.plugin.appbrand.service.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(51008);
    p.k(paramc, "service");
    QualitySessionRuntime localQualitySessionRuntime = b.amO(paramc.getAppId());
    if (localQualitySessionRuntime != null)
    {
      qj localqj = new qj();
      localqj.He(localQualitySessionRuntime.appId);
      localqj.DI(localQualitySessionRuntime.qNx);
      localqj.DJ(localQualitySessionRuntime.qLQ);
      localqj.aoW();
      localqj.Hf(paramString1);
      localqj.Hg(paramString2);
      paramString1 = paramc.bBP();
      if (paramString1 == null) {
        p.iCn();
      }
      localqj.Hh(paramString1.bGg());
      localqj.DK(localQualitySessionRuntime.apptype);
      localqj.DL(localQualitySessionRuntime.qNK.get());
      paramString1 = paramc.bDv();
      p.j(paramString1, "page");
      paramc = paramString1.btD();
      paramString1 = paramString1.cec();
      p.j(paramString1, "page.urlWithQuery");
      int i = paramc.length();
      if (paramString1 == null)
      {
        paramc = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(51008);
        throw paramc;
      }
      paramString1 = paramString1.substring(i);
      p.j(paramString1, "(this as java.lang.String).substring(startIndex)");
      localqj.Hi(paramc);
      localqj.Hj(paramString1);
      localqj.Hk(u.chI());
      localqj.bpa();
      AppMethodBeat.o(51008);
      return;
    }
    AppMethodBeat.o(51008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.l
 * JD-Core Version:    0.7.0.1
 */