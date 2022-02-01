package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.g.b.a.gb;
import com.tencent.mm.g.b.a.gb.b;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.launching.au;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.dty;
import com.tencent.mm.protocal.protobuf.dux;
import com.tencent.mm.protocal.protobuf.dvo;
import com.tencent.mm.protocal.protobuf.dvx;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends com.tencent.mm.al.c<bkx>
{
  final String cfb;
  private String kGa;
  public volatile boolean kLF;
  public volatile au kNi;
  private final gb kNj;
  final com.tencent.mm.al.b rr;
  
  public b(String paramString1, boolean paramBoolean, dty paramdty, dws paramdws, dvo paramdvo, String paramString2, int paramInt, QualitySession paramQualitySession, String paramString3, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer)
  {
    AppMethodBeat.i(196032);
    this.kLF = false;
    this.cfb = paramString2;
    this.kNj = com.tencent.mm.plugin.appbrand.report.quality.f.f(paramQualitySession);
    gb localgb = this.kNj;
    if (paramBoolean)
    {
      paramString2 = gb.b.efF;
      localgb.efz = paramString2;
      this.kNj.dON = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      this.kGa = paramQualitySession.kGa;
      paramString2 = new bkw();
      paramString2.hnC = paramString1;
      paramString2.DIA = paramdty;
      if (!paramBoolean) {
        break label256;
      }
    }
    label256:
    for (int i = 1;; i = 2)
    {
      paramString2.Dym = i;
      paramString2.DID = paramdws;
      paramString2.DIE = paramdvo;
      paramString2.DII = paramString3;
      paramString1 = new dux();
      paramString1.DKZ = paramInt;
      paramString2.DIC = paramString1;
      if ((paramString2.DIA.Scene == 1162) && (paramAppBrandLaunchFromNotifyReferrer != null))
      {
        paramString1 = new dvx();
        paramString1.EJL = paramAppBrandLaunchFromNotifyReferrer.jdA;
        paramString2.DIJ = paramString1;
      }
      paramString1 = new b.a();
      paramString1.funcId = 1122;
      paramString1.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
      paramString1.gUU = paramString2;
      paramString1.gUV = new bkx();
      paramString1 = paramString1.atI();
      this.rr = paramString1;
      this.rr = paramString1;
      AppMethodBeat.o(196032);
      return;
      paramString2 = gb.b.efG;
      break;
    }
  }
  
  public static void a(bkw parambkw)
  {
    AppMethodBeat.i(47398);
    try
    {
      if (com.tencent.mm.compatible.deviceinfo.ae.fFF.fzk)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "SrvDeviceInfo isLimit benchmarkLevel");
        parambkw.DIG = -1;
        AppMethodBeat.o(47398);
        return;
      }
      parambkw.DIG = com.tencent.mm.m.g.Zd().getInt("ClientBenchmarkLevel", -1);
      if (parambkw.DIG == 0) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "DynamicConfig performanceLevel 0 illegal");
      }
      AppMethodBeat.o(47398);
      return;
    }
    catch (Exception parambkw)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", parambkw, "read performanceLevel", new Object[0]);
      AppMethodBeat.o(47398);
    }
  }
  
  public static void b(bkw parambkw)
  {
    AppMethodBeat.i(47399);
    int i = parambkw.DIC.DKZ;
    if (i > 0)
    {
      com.tencent.mm.plugin.appbrand.appcache.ae localae = j.aOP();
      if (localae != null)
      {
        com.tencent.mm.plugin.appbrand.appcache.ad localad = new com.tencent.mm.plugin.appbrand.appcache.ad();
        localad.field_key = "@LibraryAppId";
        localad.field_version = i;
        if (localae.get(localad, new String[] { "key", "version" }))
        {
          parambkw.DIC.Cxn = ((int)localad.field_updateTime);
          parambkw.DIC.EJd = localad.field_scene;
        }
      }
    }
    AppMethodBeat.o(47399);
  }
  
  final int aLI()
  {
    return ((bkw)this.rr.gUS.gUX).DIA.DGx;
  }
  
  public final com.tencent.mm.co.f<com.tencent.mm.al.c.a<bkx>> auK()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(47397);
        Object localObject1 = new a().a((bkw)this.rr.gUS.gUX, this.kLF, this);
        if (localObject1 != null)
        {
          AppMethodBeat.o(47397);
          return localObject1;
        }
        localObject1 = com.tencent.luggage.sdk.e.c.ciu;
        localObject1 = com.tencent.luggage.sdk.e.c.cx(this.kGa);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.appbrand.launching.d.c.a((com.tencent.luggage.sdk.e.b)localObject1);
          if (localObject1 != null)
          {
            final com.tencent.mm.al.c.a locala = ((com.tencent.mm.plugin.appbrand.launching.d.g)localObject1).sT(100);
            ((com.tencent.mm.plugin.appbrand.launching.d.g)localObject1).iwh = this.kLF;
            if ((locala != null) && (locala.gUK != null) && (locala.errType == 0) && (locala.errCode == 0))
            {
              localObject1 = com.tencent.mm.co.g.c(new com.tencent.mm.vending.g.c.a() {});
              AppMethodBeat.o(47397);
              continue;
            }
          }
        }
        b(bhb());
      }
      finally {}
      a(bhb());
      long l = bt.eGO();
      this.kNj.jH(l);
      com.tencent.mm.co.f localf = super.auK();
      AppMethodBeat.o(47397);
    }
  }
  
  final boolean bha()
  {
    return ((bkw)this.rr.gUS.gUX).DIA.DKX > 0;
  }
  
  protected final bkw bhb()
  {
    return (bkw)this.rr.gUS.gUX;
  }
  
  public final void bhc()
  {
    AppMethodBeat.i(47396);
    com.tencent.mm.plugin.appbrand.utils.e.bqm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47391);
        b.this.kLF = false;
        b.this.auK();
        AppMethodBeat.o(47391);
      }
    });
    AppMethodBeat.o(47396);
  }
  
  final String getAppId()
  {
    return ((bkw)this.rr.gUS.gUX).hnC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.b
 * JD-Core Version:    0.7.0.1
 */