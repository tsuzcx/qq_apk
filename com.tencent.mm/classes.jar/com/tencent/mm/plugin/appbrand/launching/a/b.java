package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.mmdata.rpt.tn;
import com.tencent.mm.autogen.mmdata.rpt.tn.b;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.launching.aa;
import com.tencent.mm.plugin.appbrand.launching.ak;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.protocal.protobuf.gjw;
import com.tencent.mm.protocal.protobuf.glb;
import com.tencent.mm.protocal.protobuf.glu;
import com.tencent.mm.protocal.protobuf.gly;
import com.tencent.mm.protocal.protobuf.gmd;
import com.tencent.mm.protocal.protobuf.gnj;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.h;
import java.util.Objects;
import junit.framework.Assert;

public final class b
  extends com.tencent.mm.plugin.appbrand.networking.b<dgu>
{
  final String eoP;
  private final String eup;
  final com.tencent.mm.am.c rr;
  private volatile boolean tbv;
  public volatile ak tcU;
  public aa tcV;
  private final tn tcW;
  
  public b(String paramString1, boolean paramBoolean, gjw paramgjw, gnj paramgnj, glu paramglu, String paramString2, int paramInt1, QualitySession paramQualitySession, String paramString3, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer, String paramString4, aeo paramaeo, int paramInt2)
  {
    super(paramString1, paramString3);
    AppMethodBeat.i(321111);
    this.tbv = false;
    this.eoP = paramString2;
    this.tcW = com.tencent.mm.plugin.appbrand.report.quality.f.e(paramQualitySession);
    tn localtn = this.tcW;
    tn.b localb;
    int i;
    if (paramBoolean)
    {
      localb = tn.b.jDK;
      localtn.jDE = localb;
      this.tcW.iVU = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      this.tcW.zW(j.getNetworkType(MMApplicationContext.getContext()));
      this.eup = paramQualitySession.eup;
      if ((BuildInfo.DEBUG) && (Util.isNullOrNil(paramString1))) {
        Assert.fail("appId can not be Null Or Nil");
      }
      paramQualitySession = new dgt();
      paramQualitySession.oOI = paramString1;
      paramQualitySession.aaLM = paramgjw;
      if (!paramBoolean) {
        break label417;
      }
      i = 1;
      label134:
      paramQualitySession.aayr = i;
      paramQualitySession.aaLP = paramgnj;
      paramQualitySession.aaLQ = paramglu;
      paramQualitySession.aaLU = paramString3;
      paramQualitySession.aaLT = this.eup;
      paramQualitySession.aaLY = paramInt2;
      paramgjw = new glb();
      paramgjw.aaQX = paramInt1;
      paramQualitySession.aaLO = paramgjw;
      if ((paramQualitySession.aaLM.IJG == 1162) && (paramAppBrandLaunchFromNotifyReferrer != null))
      {
        paramgjw = new gmd();
        paramgjw.achs = paramAppBrandLaunchFromNotifyReferrer.qYA;
        paramQualitySession.aaLV = paramgjw;
      }
      if (1173 == paramQualitySession.aaLM.IJG)
      {
        if (!Util.isNullOrNil(paramString4)) {
          break label423;
        }
        Log.w("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "<init>, openMaterialMimeType is empty");
      }
    }
    for (;;)
    {
      paramQualitySession.YMR = ((aeo)Objects.requireNonNull(paramaeo));
      paramgjw = new com.tencent.mm.am.c.a();
      paramgjw.funcId = 1122;
      paramgjw.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
      paramgjw.otE = paramQualitySession;
      paramgjw.otF = new dgu();
      paramgjw = paramgjw.bEF();
      this.rr = paramgjw;
      c(paramgjw);
      Log.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "<init> cgiHash[%d], username[%s] appId[%s] sync[%b] sessionId[%s] instanceId[%s] libVersion[%d], source:%s", new Object[] { Integer.valueOf(hashCode()), paramString3, paramString1, Boolean.valueOf(paramBoolean), paramString2, this.eup, Integer.valueOf(paramInt1), com.tencent.mm.ak.a.b(paramaeo) });
      AppMethodBeat.o(321111);
      return;
      localb = tn.b.jDL;
      break;
      label417:
      i = 2;
      break label134;
      label423:
      paramgjw = new gly();
      paramgjw.aauG = paramString4;
      paramQualitySession.aaLX = paramgjw;
    }
  }
  
  public static void b(dgt paramdgt)
  {
    AppMethodBeat.i(47398);
    try
    {
      if (af.lYh.lQQ)
      {
        Log.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "SrvDeviceInfo isLimit benchmarkLevel");
        paramdgt.aaLS = -1;
        AppMethodBeat.o(47398);
        return;
      }
      paramdgt.aaLS = i.aRC().getInt("ClientBenchmarkLevel", -1);
      if (paramdgt.aaLS == 0) {
        Log.e("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "DynamicConfig performanceLevel 0 illegal");
      }
      AppMethodBeat.o(47398);
      return;
    }
    catch (Exception paramdgt)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", paramdgt, "read performanceLevel", new Object[0]);
      AppMethodBeat.o(47398);
    }
  }
  
  public static void c(dgt paramdgt)
  {
    AppMethodBeat.i(47399);
    int i = paramdgt.aaLO.aaQX;
    if (i > 0)
    {
      ai localai = n.cfs();
      if (localai != null)
      {
        ah localah = new ah();
        localah.field_key = "@LibraryAppId";
        localah.field_version = i;
        if (localai.get(localah, new String[] { "key", "version" }))
        {
          paramdgt.aaLO.YFv = ((int)localah.field_updateTime);
          paramdgt.aaLO.acgK = localah.field_scene;
        }
      }
      AppMethodBeat.o(47399);
      return;
    }
    paramdgt.aaLO.aaQX = 0;
    AppMethodBeat.o(47399);
  }
  
  private String getUserName()
  {
    AppMethodBeat.i(321115);
    String str = ((dgt)c.b.b(this.rr.otB)).aaLU;
    AppMethodBeat.o(321115);
    return str;
  }
  
  public final void asM()
  {
    AppMethodBeat.i(47396);
    d.LOGIC.arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47391);
        b.a(b.this);
        b.this.bFJ();
        AppMethodBeat.o(47391);
      }
    });
    AppMethodBeat.o(47396);
  }
  
  public final com.tencent.mm.cp.f<com.tencent.mm.am.b.a<dgu>> bFJ()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(47397);
        Object localObject1 = new a().a((dgt)c.b.b(this.rr.otB), this.tbv, this);
        if (localObject1 != null)
        {
          AppMethodBeat.o(47397);
          return localObject1;
        }
        localObject1 = com.tencent.luggage.sdk.f.c.evF;
        localObject1 = com.tencent.luggage.sdk.f.c.fC(this.eup);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.appbrand.launching.d.c.a((com.tencent.luggage.sdk.f.b)localObject1);
          if (localObject1 != null)
          {
            final com.tencent.mm.am.b.a locala = ((com.tencent.mm.plugin.appbrand.launching.d.g)localObject1).Cc(100);
            if ((locala != null) && (locala.ott != null) && (locala.errType == 0) && (locala.errCode == 0))
            {
              ((com.tencent.luggage.sdk.f.a)localObject1).evB = true;
              localObject1 = com.tencent.mm.cp.g.c(new com.tencent.mm.vending.g.c.a() {});
              AppMethodBeat.o(47397);
              continue;
            }
            localObject2.evB = false;
          }
        }
      }
      finally {}
      c(cAF());
      b(cAF());
      long l = Util.nowMilliSecond();
      this.tcW.gv(l);
      com.tencent.mm.cp.f localf = super.bFJ();
      AppMethodBeat.o(47397);
    }
  }
  
  final int cAC()
  {
    AppMethodBeat.i(321156);
    int i = ((dgt)c.b.b(this.rr.otB)).aaLM.aaJu;
    AppMethodBeat.o(321156);
    return i;
  }
  
  final boolean cAD()
  {
    AppMethodBeat.i(321160);
    if (((dgt)c.b.b(this.rr.otB)).aaLM.aaQV > 0)
    {
      AppMethodBeat.o(321160);
      return true;
    }
    AppMethodBeat.o(321160);
    return false;
  }
  
  public final dgu cAE()
  {
    AppMethodBeat.i(321166);
    dgu localdgu = (dgu)c.c.b(this.rr.otC);
    AppMethodBeat.o(321166);
    return localdgu;
  }
  
  protected final dgt cAF()
  {
    AppMethodBeat.i(321171);
    dgt localdgt = (dgt)c.b.b(this.rr.otB);
    AppMethodBeat.o(321171);
    return localdgt;
  }
  
  public final com.tencent.mm.am.b.a<dgu> cAG()
  {
    AppMethodBeat.i(321177);
    this.tbv = true;
    com.tencent.mm.am.b.a locala = super.cAG();
    AppMethodBeat.o(321177);
    return locala;
  }
  
  public final com.tencent.mm.cp.f<com.tencent.mm.am.b.a<dgu>> ckO()
  {
    AppMethodBeat.i(321193);
    if (!com.tencent.mm.plugin.appbrand.networking.a.ff(getAppId(), getUserName()))
    {
      com.tencent.mm.cp.f localf = com.tencent.mm.cp.g.c(new com.tencent.mm.vending.g.c.a() {});
      AppMethodBeat.o(321193);
      return localf;
    }
    AppMethodBeat.o(321193);
    return null;
  }
  
  final String getAppId()
  {
    AppMethodBeat.i(321151);
    String str = ((dgt)c.b.b(this.rr.otB)).oOI;
    AppMethodBeat.o(321151);
    return str;
  }
  
  public static final class a
    extends IEvent
  {
    public final ak tdb;
    
    public a(ak paramak)
    {
      this.tdb = paramak;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.b
 * JD-Core Version:    0.7.0.1
 */