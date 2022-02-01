package com.tencent.mm.plugin.appbrand.service;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.c.i;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.f.b.a.ph;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;
import java.util.UUID;

public final class a
  extends i<c>
{
  a(c paramc, com.tencent.mm.plugin.appbrand.m.t paramt)
  {
    super(paramc, paramt);
  }
  
  private String e(c paramc, String paramString)
  {
    AppMethodBeat.i(48242);
    try
    {
      paramc = super.a(paramc, paramString);
      AppMethodBeat.o(48242);
      return paramc;
    }
    catch (ar paramc)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(370L, 48L, 1L, false);
      j.b(((c)QW()).getAppId(), ((c)QW()).getRuntime().bDx().nYR.pkgVersion, ((c)QW()).getRuntime().bDx().nYR.nHY, 370, 48);
      AppMethodBeat.o(48242);
      throw paramc;
    }
  }
  
  private String f(c paramc)
  {
    AppMethodBeat.i(48241);
    String str = "";
    try
    {
      if ((paramc instanceof y))
      {
        str = "" + Util.nullAsNil(((y)paramc).qOM);
        str = str + '\n';
      }
      paramc = str + super.c(paramc);
      AppMethodBeat.o(48241);
      return paramc;
    }
    catch (ar paramc)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(370L, 39L, 1L, false);
      j.b(((c)QW()).getAppId(), ((c)QW()).getRuntime().bDx().nYR.pkgVersion, ((c)QW()).getRuntime().bDx().nYR.nHY, 370, 39);
      AppMethodBeat.o(48241);
      throw paramc;
    }
  }
  
  public final int Pr()
  {
    AppMethodBeat.i(48243);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRD, 0);
    AppMethodBeat.o(48243);
    return i;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(175063);
    Object localObject = parama.scriptName;
    Log.i("MicroMsg.AppBrandJSContextInterfaceWC", "reportBootstrapScriptEvaluateResult appId[%s] name[%s] succeed[%b]", new Object[] { ((c)QW()).getAppId(), localObject, Boolean.valueOf(paramBoolean) });
    if ("WASubContext.js".equals(localObject))
    {
      if (((c)QW()).getRuntime() != null)
      {
        if (paramBoolean) {
          com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)QW()).getAppId(), KSProcessWeAppLaunch.stepInjectJSWASubContext, "WASubContext.js", paramLong1, paramLong2);
        }
      }
      else if ((paramBoolean) && ((((c)QW()).bDU()) || (((c)QW()).isRunning())))
      {
        if (!(paramObject instanceof m.c)) {
          break label358;
        }
        paramObject = (m.c)paramObject;
        label140:
        localObject = com.tencent.mm.plugin.appbrand.report.quality.b.cik().p(QW()).Ge((String)localObject);
        ((ph)localObject).heu = parama.cyw;
        if ((paramObject == null) || (paramObject.codeCacheStatus < 0) || (paramObject.codeCacheStatus >= com.tencent.mm.plugin.appbrand.m.v.pON.length)) {
          break label364;
        }
        l = com.tencent.mm.plugin.appbrand.m.v.pON[paramObject.codeCacheStatus];
        label204:
        ((ph)localObject).hex = l;
        ((ph)localObject).hey = 1L;
        if (paramObject == null) {
          break label372;
        }
        l = paramObject.flatJSCompileCost;
        label229:
        ((ph)localObject).hez = l;
        if (paramObject == null) {
          break label378;
        }
      }
      label358:
      label364:
      label372:
      label378:
      for (long l = paramObject.fiT;; l = 0L)
      {
        ((ph)localObject).heR = l;
        ((ph)localObject).BS(paramLong1);
        ((ph)localObject).BT(paramLong2);
        ((ph)localObject).BR(((ph)localObject).hcV - ((ph)localObject).hcU);
        ((ph)localObject).bpa();
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(370L, 40L, 1L, false);
        if (!paramBoolean) {
          break label384;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(370L, 41L, 1L, false);
        AppMethodBeat.o(175063);
        return;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)QW()).getAppId(), KSProcessWeAppLaunch.stepInjectJSWASubContext, "", "WASubContext.js", paramLong1, paramLong2);
        break;
        paramObject = null;
        break label140;
        l = 4L;
        break label204;
        l = 0L;
        break label229;
      }
      label384:
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(370L, 42L, 1L, false);
      if (parama.cyw <= 0) {
        com.tencent.mm.plugin.report.service.h.IzE.el(370, 74);
      }
      if (((c)QW()).getRuntime() == null)
      {
        AppMethodBeat.o(175063);
        return;
      }
      j.b(((c)QW()).getAppId(), ((c)QW()).getRuntime().bDx().nYR.pkgVersion, ((c)QW()).getRuntime().bDx().nYR.nHY, 370, 42);
      AppMethodBeat.o(175063);
      return;
    }
    if (((String)localObject).endsWith("app-service.js"))
    {
      if (((c)QW()).getRuntime() != null)
      {
        if (paramBoolean)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)QW()).getAppId(), KSProcessWeAppLaunch.stepInjectJSAppService, (String)localObject, paramLong1, paramLong2);
          com.tencent.mm.plugin.appbrand.keylogger.c.b(((c)QW()).getAppId(), KSProcessWeAppLaunch.stepServiceInit);
        }
      }
      else if (paramBoolean)
      {
        if ((((c)QW()).bDU()) || (((c)QW()).isRunning()))
        {
          com.tencent.mm.plugin.appbrand.t localt = ((c)QW()).getRuntime();
          if (!(paramObject instanceof m.c)) {
            break label907;
          }
          paramObject = (m.c)paramObject;
          label619:
          if (localt == null) {
            break label913;
          }
          i = localt.hashCode();
          label631:
          Log.i("MicroMsg.AppBrandJSContextInterfaceWC", "[QualitySystem] app-service.js runtime.hashCode = [%d]", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.plugin.appbrand.v localv = this.czP;
          int j = parama.cyw;
          if (localt == null) {
            break label919;
          }
          i = localt.hashCode();
          label675:
          com.tencent.mm.plugin.appbrand.report.quality.b.a(localv, (String)localObject, j, "", 0, paramLong1, i, paramObject);
        }
        if (!((c)QW()).bDV()) {
          break label925;
        }
        i = 1;
        label708:
        x.a(1, paramLong2 - paramLong1, i, ((c)this.czP).getAppId(), -1, 0, ((c)QW()).bBP().bGi());
        parama = com.tencent.mm.plugin.appbrand.report.quality.b.amO(((c)this.czP).getAppId());
        if (parama != null)
        {
          paramLong1 = System.currentTimeMillis();
          paramLong2 = parama.qNQ;
          if (!((c)QW()).bDV()) {
            break label931;
          }
        }
      }
      label907:
      label913:
      label919:
      label925:
      label931:
      for (int i = 1;; i = 0)
      {
        x.a(7, paramLong1 - paramLong2, i, ((c)this.czP).getAppId(), -1, 0, ((c)QW()).bBP().bGi());
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(370L, 44L, 1L, false);
        if (!paramBoolean) {
          break label937;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(370L, 45L, 1L, false);
        AppMethodBeat.o(175063);
        return;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)QW()).getAppId(), KSProcessWeAppLaunch.stepInjectJSAppService, "", (String)localObject, paramLong1, paramLong2);
        com.tencent.mm.plugin.appbrand.keylogger.c.c(((c)QW()).getAppId(), KSProcessWeAppLaunch.stepServiceInit);
        break;
        paramObject = null;
        break label619;
        i = -1;
        break label631;
        i = -1;
        break label675;
        i = 0;
        break label708;
      }
      label937:
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(370L, 46L, 1L, false);
      j.b(((c)QW()).getAppId(), ((c)QW()).getRuntime().bDx().nYR.pkgVersion, ((c)QW()).getRuntime().bDx().nYR.nHY, 370, 46);
    }
    AppMethodBeat.o(175063);
  }
  
  public final void a(String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(277081);
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (BuildInfo.DEBUG) {
        str = UUID.randomUUID().toString();
      }
    }
    if ((TextUtils.isEmpty(str)) || (paramArrayOfa.length == 0) || (paramArrayOfBoolean.length == 0))
    {
      AppMethodBeat.o(277081);
      return;
    }
    paramArrayOfBoolean = ((c)this.czP).getRuntime();
    int i = 0;
    if (paramArrayOfa.length == 1) {
      if ((paramArrayOfObject[0] instanceof m.c))
      {
        paramString = (m.c)paramArrayOfObject[0];
        if (paramString == null) {
          break label159;
        }
        i = paramString.sourceLength;
        label106:
        paramArrayOfa = this.czP;
        paramArrayOfObject = (String)Objects.requireNonNull(str);
        if (paramArrayOfBoolean == null) {
          break label416;
        }
      }
    }
    label159:
    label416:
    for (int j = paramArrayOfBoolean.hashCode();; j = -1)
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.a(paramArrayOfa, paramArrayOfObject, i, "", 0, paramLong1, j, paramString);
      AppMethodBeat.o(277081);
      return;
      paramString = null;
      break;
      if (paramArrayOfa[0] != null)
      {
        i = paramArrayOfa[0].cyw;
        break label106;
      }
      AppMethodBeat.o(277081);
      return;
      long l2 = 0L;
      long l1 = 0L;
      int m = 0;
      int i1 = 0;
      int k = 0;
      if (k < paramArrayOfa.length)
      {
        long l3;
        long l4;
        int n;
        int i2;
        if ((paramArrayOfObject[k] instanceof m.c))
        {
          paramString = (m.c)paramArrayOfObject[k];
          j = i + paramString.sourceLength;
          l3 = l2 + paramString.flatJSCompileCost;
          l4 = l1 + paramString.flatJSRunCost;
          n = paramString.codeCacheStatus;
          i2 = paramString.fiT;
        }
        for (;;)
        {
          k += 1;
          i1 = i2;
          m = n;
          l1 = l4;
          l2 = l3;
          i = j;
          break;
          i2 = i1;
          n = m;
          l4 = l1;
          l3 = l2;
          j = i;
          if (paramArrayOfa[k] != null)
          {
            j = i + paramArrayOfa[k].cyw;
            i2 = i1;
            n = m;
            l4 = l1;
            l3 = l2;
          }
        }
      }
      if (l1 > 0L)
      {
        paramString = new m.c();
        paramString.fiR = paramLong1;
        paramString.fiS = paramLong2;
        paramString.codeCacheStatus = m;
        paramString.fiT = i1;
        paramString.flatJSCompileCost = l2;
        paramString.flatJSRunCost = l1;
        paramString.sourceLength = i;
        break label106;
      }
      paramString = null;
      break label106;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.a
 * JD-Core Version:    0.7.0.1
 */