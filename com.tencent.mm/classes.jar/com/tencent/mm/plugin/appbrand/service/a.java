package com.tencent.mm.plugin.appbrand.service;

import com.tencent.luggage.sdk.b.a.c.a.a;
import com.tencent.luggage.sdk.b.a.c.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i.q;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends f<c>
{
  a(c paramc, q paramq)
  {
    super(paramc, paramq);
  }
  
  private String a(c paramc)
  {
    AppMethodBeat.i(143529);
    try
    {
      paramc = super.b(paramc);
      AppMethodBeat.o(143529);
      return paramc;
    }
    catch (a.a paramc)
    {
      h.qsU.idkeyStat(370L, 39L, 1L, false);
      e.b(((c)this.bEw).getAppId(), ((c)this.bEw).getRuntime().atR().hiX.gXf, ((c)this.bEw).getRuntime().atR().hiX.gXe, 370, 39);
      AppMethodBeat.o(143529);
      throw paramc;
    }
  }
  
  private String c(c paramc, String paramString)
  {
    AppMethodBeat.i(143530);
    try
    {
      paramc = super.a(paramc, paramString);
      AppMethodBeat.o(143530);
      return paramc;
    }
    catch (a.a paramc)
    {
      h.qsU.idkeyStat(370L, 48L, 1L, false);
      e.b(((c)this.bEw).getAppId(), ((c)this.bEw).getRuntime().atR().hiX.gXf, ((c)this.bEw).getRuntime().atR().hiX.gXe, 370, 48);
      AppMethodBeat.o(143530);
      throw paramc;
    }
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(143528);
    if ("WASubContext.js".equals(paramString1))
    {
      if ((paramBoolean) && ((((c)this.bEw).aud()) || (((c)this.bEw).isRunning())))
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.aLt();
        b.a(((c)this.bEw).aud(), ((c)this.bEw).getAppId(), paramLong1, paramString1, paramString2.length());
      }
      h.qsU.idkeyStat(370L, 40L, 1L, false);
      if (paramBoolean)
      {
        h.qsU.idkeyStat(370L, 41L, 1L, false);
        AppMethodBeat.o(143528);
        return;
      }
      h.qsU.idkeyStat(370L, 42L, 1L, false);
      if (((c)this.bEw).getRuntime() == null)
      {
        AppMethodBeat.o(143528);
        return;
      }
      e.b(((c)this.bEw).getAppId(), ((c)this.bEw).getRuntime().atR().hiX.gXf, ((c)this.bEw).getRuntime().atR().hiX.gXe, 370, 42);
      AppMethodBeat.o(143528);
      return;
    }
    if (paramString1.endsWith("app-service.js"))
    {
      o localo;
      String str;
      if ((paramBoolean) && ((((c)this.bEw).aud()) || (((c)this.bEw).isRunning())))
      {
        localo = ((c)this.bEw).getRuntime();
        if (localo == null) {
          break label367;
        }
        i = localo.hashCode();
        ab.i("MicroMsg.AppBrandJSContextInterfaceWC", "[QualitySystem] app-service.js runtime.hashCode = [%d]", new Object[] { Integer.valueOf(i) });
        str = ((c)this.bEw).getAppId();
        if (localo == null) {
          break label373;
        }
      }
      label367:
      label373:
      for (int i = localo.hashCode();; i = -1)
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.a(str, paramString1, paramString2, paramLong1, i);
        h.qsU.idkeyStat(370L, 44L, 1L, false);
        if (!paramBoolean) {
          break label379;
        }
        h.qsU.idkeyStat(370L, 45L, 1L, false);
        AppMethodBeat.o(143528);
        return;
        i = -1;
        break;
      }
      label379:
      h.qsU.idkeyStat(370L, 46L, 1L, false);
      e.b(((c)this.bEw).getAppId(), ((c)this.bEw).getRuntime().atR().hiX.gXf, ((c)this.bEw).getRuntime().atR().hiX.gXe, 370, 46);
    }
    AppMethodBeat.o(143528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.a
 * JD-Core Version:    0.7.0.1
 */