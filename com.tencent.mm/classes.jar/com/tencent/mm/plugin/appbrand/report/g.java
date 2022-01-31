package com.tencent.mm.plugin.appbrand.report;

import a.f.b.j;
import a.l;
import a.l.m;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.db;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.atomic.AtomicInteger;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceWCScriptReporter;", "", "()V", "TAG", "", "reportEvaluateResult", "", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "name", "source", "succeed", "", "startTimeMs", "", "endTimeMs", "reportJSError", "message", "stackTrace", "plugin-appbrand-integration_release"})
public final class g
{
  public static final g iFU;
  
  static
  {
    AppMethodBeat.i(143975);
    iFU = new g();
    AppMethodBeat.o(143975);
  }
  
  public static final void a(c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(143974);
    j.q(paramc, "service");
    QualitySessionRuntime localQualitySessionRuntime = a.EM(paramc.getAppId());
    if (localQualitySessionRuntime != null)
    {
      db localdb = new db();
      localdb.in(localQualitySessionRuntime.appId);
      localdb.fF(localQualitySessionRuntime.iIG);
      localdb.fG(localQualitySessionRuntime.iIF);
      localdb.Hk();
      localdb.io(paramString1);
      localdb.ip(paramString2);
      paramString1 = paramc.asY();
      if (paramString1 == null) {
        j.ebi();
      }
      localdb.iq(paramString1.avc());
      localdb.fH(localQualitySessionRuntime.apptype);
      localdb.fI(localQualitySessionRuntime.iIO.get());
      paramString1 = paramc.aLy();
      j.p(paramString1, "page");
      paramc = paramString1.getURL();
      paramString1 = paramString1.aJn();
      j.p(paramString1, "page.urlWithQuery");
      int i = paramc.length();
      if (paramString1 == null)
      {
        paramc = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(143974);
        throw paramc;
      }
      paramString1 = paramString1.substring(i);
      j.p(paramString1, "(this as java.lang.String).substring(startIndex)");
      localdb.ir(paramc);
      localdb.is(paramString1);
      localdb.ake();
      AppMethodBeat.o(143974);
      return;
    }
    AppMethodBeat.o(143974);
  }
  
  public static void a(c paramc, String paramString1, String paramString2, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(143973);
    j.q(paramc, "service");
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(143973);
      return;
    }
    if (!paramBoolean) {
      ab.e("MicroMsg.AppBrandServiceWCScriptReporter", "reportEvaluateResult, !succeed name[" + paramString1 + "], appId[" + paramc.getAppId() + ']');
    }
    if (paramString1 == null) {}
    for (;;)
    {
      if (m.jx(paramString1, "/app-service.js"))
      {
        h.qsU.cT(370, 30);
        if (paramBoolean)
        {
          h.qsU.cT(370, 31);
          AppMethodBeat.o(143973);
          return;
          switch (paramString1.hashCode())
          {
          default: 
            break;
          case 293174862: 
            if (paramString1.equals("app-service.js"))
            {
              h.qsU.cT(370, 9);
              if (paramBoolean) {
                if (paramString2 != null) {
                  break label746;
                }
              }
            }
            break;
          }
        }
      }
    }
    label588:
    label594:
    label599:
    label608:
    label746:
    for (paramString1 = "";; paramString1 = paramString2)
    {
      i locali;
      if ((paramc.aud()) || (paramc.isRunning()))
      {
        locali = (i)paramc.getRuntime();
        if (locali == null) {
          break label594;
        }
        paramString2 = locali.getAppId();
        label236:
        if (locali == null) {
          break label599;
        }
        localObject = Integer.valueOf(locali.hashCode());
        label251:
        ab.i("MicroMsg.AppBrandServiceWCScriptReporter", "[QualitySystem] app-service.js runtime.appId=[%s], runtime.hashCode = [%d]", new Object[] { paramString2, localObject });
        paramc = paramc.getAppId();
        if (locali == null) {
          break label608;
        }
      }
      for (i = locali.hashCode();; i = -1)
      {
        a.a(paramc, "app-service.js", paramString1, paramLong, i);
        h.qsU.cT(370, 11);
        AppMethodBeat.o(143973);
        return;
        if (!paramString1.equals("WAService.js")) {
          break;
        }
        h.qsU.cT(370, 5);
        paramString1 = paramc.asY();
        if (paramString1 != null)
        {
          localObject = paramString1.avc();
          paramString1 = (String)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramString1 = "invalid";
        }
        j.p(paramString1, "service.libReader?.versionName() ?: \"invalid\"");
        if (paramBoolean)
        {
          ab.i("MicroMsg.AppBrandServiceWCScriptReporter", "Inject SDK Service Script Succeed wx.version = ".concat(String.valueOf(paramString1)));
          if (paramString2 != null) {}
          for (i = paramString2.length();; i = -1)
          {
            long l = i;
            if ((paramc.aud()) || (paramc.isRunning()))
            {
              a.aLt();
              b.a(paramc.aud(), paramc.getAppId(), paramLong, "WAService.js", l);
            }
            h.qsU.cT(370, 7);
            AppMethodBeat.o(143973);
            return;
          }
        }
        ab.e("MicroMsg.AppBrandServiceWCScriptReporter", "Inject SDK Service Script Failed wx.version = ".concat(String.valueOf(paramString1)));
        h.qsU.cT(370, 6);
        e.bq(paramc.getAppId(), 24);
        if (paramc.getRuntime() != null)
        {
          paramString1 = paramc.getRuntime();
          j.p(paramString1, "runtime");
          i = paramString1.atR().hiX.gXf;
          if (paramc.getRuntime() == null) {
            break label588;
          }
          paramString1 = paramc.getRuntime();
          j.p(paramString1, "runtime");
        }
        for (int j = paramString1.atR().ayy();; j = -1)
        {
          e.b(paramc.getAppId(), i, j, 370, 6);
          AppMethodBeat.o(143973);
          return;
          i = 0;
          break;
        }
        paramString2 = null;
        break label236;
        localObject = Integer.valueOf(-1);
        break label251;
      }
      try
      {
        h.qsU.cT(370, 10);
        e.bq(paramc.getAppId(), 24);
        e.b(paramc.getAppId(), paramc.getRuntime().atR().hiX.gXf, paramc.getRuntime().atR().hiX.gXe, 370, 10);
        AppMethodBeat.o(143973);
        return;
      }
      catch (NullPointerException paramc)
      {
        ab.e("MicroMsg.AppBrandServiceWCScriptReporter", "Inject External Service Script Failed, report npe = %s", new Object[] { paramc });
        AppMethodBeat.o(143973);
        return;
      }
      ab.e("MicroMsg.AppBrandServiceWCScriptReporter", "inject module(" + paramString1 + ") script failed");
      h.qsU.cT(370, 32);
      AppMethodBeat.o(143973);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.g
 * JD-Core Version:    0.7.0.1
 */