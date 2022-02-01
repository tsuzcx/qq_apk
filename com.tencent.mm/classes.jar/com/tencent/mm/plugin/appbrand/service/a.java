package com.tencent.mm.plugin.appbrand.service;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.g.b.a.mj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.m.t;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;
import java.util.UUID;

public final class a
  extends com.tencent.luggage.sdk.b.a.c.i<c>
{
  a(c paramc, t paramt)
  {
    super(paramc, paramt);
  }
  
  private String e(c paramc)
  {
    AppMethodBeat.i(48241);
    String str = "";
    try
    {
      if ((paramc instanceof y))
      {
        str = "" + Util.nullAsNil(((y)paramc).nMu);
        str = str + '\n';
      }
      paramc = str + super.c(paramc);
      AppMethodBeat.o(48241);
      return paramc;
    }
    catch (aq paramc)
    {
      h.CyF.idkeyStat(370L, 39L, 1L, false);
      com.tencent.mm.plugin.appbrand.report.i.b(((c)NY()).getAppId(), ((c)NY()).getRuntime().bsB().leE.pkgVersion, ((c)NY()).getRuntime().bsB().leE.kNW, 370, 39);
      AppMethodBeat.o(48241);
      throw paramc;
    }
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
    catch (aq paramc)
    {
      h.CyF.idkeyStat(370L, 48L, 1L, false);
      com.tencent.mm.plugin.appbrand.report.i.b(((c)NY()).getAppId(), ((c)NY()).getRuntime().bsB().leE.pkgVersion, ((c)NY()).getRuntime().bsB().leE.kNW, 370, 48);
      AppMethodBeat.o(48242);
      throw paramc;
    }
  }
  
  public final int Mz()
  {
    AppMethodBeat.i(48243);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shG, 0);
    AppMethodBeat.o(48243);
    return i;
  }
  
  public final void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(175063);
    Object localObject = parama.scriptName;
    Log.i("MicroMsg.AppBrandJSContextInterfaceWC", "reportBootstrapScriptEvaluateResult appId[%s] name[%s] succeed[%b]", new Object[] { ((c)NY()).getAppId(), localObject, Boolean.valueOf(paramBoolean) });
    if ("WASubContext.js".equals(localObject))
    {
      if (((c)NY()).getRuntime() != null)
      {
        if (paramBoolean) {
          com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)NY()).getAppId(), KSProcessWeAppLaunch.stepInjectJSWASubContext, "WASubContext.js", paramLong1, paramLong2);
        }
      }
      else if ((paramBoolean) && ((((c)NY()).bsW()) || (((c)NY()).isRunning())))
      {
        if (!(paramObject instanceof m.c)) {
          break label358;
        }
        paramObject = (m.c)paramObject;
        label140:
        localObject = com.tencent.mm.plugin.appbrand.report.quality.b.bUZ().l(NY()).zy((String)localObject);
        ((mj)localObject).fbD = parama.czA;
        if ((paramObject == null) || (paramObject.codeCacheStatus < 0) || (paramObject.codeCacheStatus >= v.mNV.length)) {
          break label364;
        }
        l = v.mNV[paramObject.codeCacheStatus];
        label204:
        ((mj)localObject).fbG = l;
        ((mj)localObject).fbH = 1L;
        if (paramObject == null) {
          break label372;
        }
        l = paramObject.flatJSCompileCost;
        label229:
        ((mj)localObject).fbI = l;
        if (paramObject == null) {
          break label378;
        }
      }
      label358:
      label364:
      label372:
      label378:
      for (long l = paramObject.dqm;; l = 0L)
      {
        ((mj)localObject).fca = l;
        ((mj)localObject).vX(paramLong1);
        ((mj)localObject).vY(paramLong2);
        ((mj)localObject).vW(((mj)localObject).fae - ((mj)localObject).fad);
        ((mj)localObject).bfK();
        h.CyF.idkeyStat(370L, 40L, 1L, false);
        if (!paramBoolean) {
          break label384;
        }
        h.CyF.idkeyStat(370L, 41L, 1L, false);
        AppMethodBeat.o(175063);
        return;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)NY()).getAppId(), KSProcessWeAppLaunch.stepInjectJSWASubContext, "", "WASubContext.js", paramLong1, paramLong2);
        break;
        paramObject = null;
        break label140;
        l = 4L;
        break label204;
        l = 0L;
        break label229;
      }
      label384:
      h.CyF.idkeyStat(370L, 42L, 1L, false);
      if (parama.czA <= 0) {
        h.CyF.dN(370, 74);
      }
      if (((c)NY()).getRuntime() == null)
      {
        AppMethodBeat.o(175063);
        return;
      }
      com.tencent.mm.plugin.appbrand.report.i.b(((c)NY()).getAppId(), ((c)NY()).getRuntime().bsB().leE.pkgVersion, ((c)NY()).getRuntime().bsB().leE.kNW, 370, 42);
      AppMethodBeat.o(175063);
      return;
    }
    if (((String)localObject).endsWith("app-service.js"))
    {
      if (((c)NY()).getRuntime() != null)
      {
        if (paramBoolean)
        {
          com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)NY()).getAppId(), KSProcessWeAppLaunch.stepInjectJSAppService, (String)localObject, paramLong1, paramLong2);
          com.tencent.mm.plugin.appbrand.keylogger.c.b(((c)NY()).getAppId(), KSProcessWeAppLaunch.stepServiceInit);
        }
      }
      else if (paramBoolean)
      {
        if ((((c)NY()).bsW()) || (((c)NY()).isRunning()))
        {
          q localq = ((c)NY()).getRuntime();
          if (!(paramObject instanceof m.c)) {
            break label907;
          }
          paramObject = (m.c)paramObject;
          label619:
          if (localq == null) {
            break label913;
          }
          i = localq.hashCode();
          label631:
          Log.i("MicroMsg.AppBrandJSContextInterfaceWC", "[QualitySystem] app-service.js runtime.hashCode = [%d]", new Object[] { Integer.valueOf(i) });
          s locals = this.cAJ;
          int j = parama.czA;
          if (localq == null) {
            break label919;
          }
          i = localq.hashCode();
          label675:
          com.tencent.mm.plugin.appbrand.report.quality.b.a(locals, (String)localObject, j, "", 0, paramLong1, i, paramObject);
        }
        if (!((c)NY()).bsX()) {
          break label925;
        }
        i = 1;
        label708:
        x.a(1, paramLong2 - paramLong1, i, ((c)this.cAJ).getAppId(), -1, 0, ((c)NY()).bqZ().bvd());
        parama = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(((c)this.cAJ).getAppId());
        if (parama != null)
        {
          paramLong1 = System.currentTimeMillis();
          paramLong2 = parama.nLD;
          if (!((c)NY()).bsX()) {
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
        x.a(7, paramLong1 - paramLong2, i, ((c)this.cAJ).getAppId(), -1, 0, ((c)NY()).bqZ().bvd());
        h.CyF.idkeyStat(370L, 44L, 1L, false);
        if (!paramBoolean) {
          break label937;
        }
        h.CyF.idkeyStat(370L, 45L, 1L, false);
        AppMethodBeat.o(175063);
        return;
        com.tencent.mm.plugin.appbrand.keylogger.c.a(((c)NY()).getAppId(), KSProcessWeAppLaunch.stepInjectJSAppService, "", (String)localObject, paramLong1, paramLong2);
        com.tencent.mm.plugin.appbrand.keylogger.c.c(((c)NY()).getAppId(), KSProcessWeAppLaunch.stepServiceInit);
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
      h.CyF.idkeyStat(370L, 46L, 1L, false);
      com.tencent.mm.plugin.appbrand.report.i.b(((c)NY()).getAppId(), ((c)NY()).getRuntime().bsB().leE.pkgVersion, ((c)NY()).getRuntime().bsB().leE.kNW, 370, 46);
    }
    AppMethodBeat.o(175063);
  }
  
  public final void a(String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227414);
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
      AppMethodBeat.o(227414);
      return;
    }
    paramArrayOfBoolean = ((c)this.cAJ).getRuntime();
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
        paramArrayOfa = this.cAJ;
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
      AppMethodBeat.o(227414);
      return;
      paramString = null;
      break;
      if (paramArrayOfa[0] != null)
      {
        i = paramArrayOfa[0].czA;
        break label106;
      }
      AppMethodBeat.o(227414);
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
          i2 = paramString.dqm;
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
            j = i + paramArrayOfa[k].czA;
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
        paramString.dqk = paramLong1;
        paramString.dql = paramLong2;
        paramString.codeCacheStatus = m;
        paramString.dqm = i1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.a
 * JD-Core Version:    0.7.0.1
 */