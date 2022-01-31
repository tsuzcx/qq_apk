package com.tencent.mm.plugin.appbrand.launching.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.g.b.a.cs;
import com.tencent.mm.g.b.a.cs.b;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.dah;
import com.tencent.mm.protocal.protobuf.das;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  extends com.tencent.mm.ai.a<azn>
{
  final String bCU;
  public volatile boolean imf;
  public volatile com.tencent.mm.plugin.appbrand.launching.ab ind;
  private final cs ine;
  final com.tencent.mm.ai.b rr;
  
  public a(String paramString1, boolean paramBoolean, czi paramczi, dbs paramdbs, das paramdas, String paramString2, int paramInt, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(132022);
    this.imf = false;
    this.bCU = paramString2;
    this.ine = com.tencent.mm.plugin.appbrand.report.quality.f.b(paramQualitySession);
    paramQualitySession = this.ine;
    if (paramBoolean) {
      paramString2 = cs.b.dcV;
    }
    for (;;)
    {
      paramQualitySession.dcP = paramString2;
      this.ine.cTb = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      paramString2 = new azm();
      paramString2.fKw = paramString1;
      paramString2.xoM = paramczi;
      int i;
      if (paramBoolean)
      {
        i = 1;
        label90:
        paramString2.xfs = i;
        paramString2.xoP = paramdbs;
        paramString2.xoQ = paramdas;
        paramString1 = new dah();
        paramString1.xqO = paramInt;
        if (paramInt > 0)
        {
          paramczi = com.tencent.mm.plugin.appbrand.app.g.auR();
          if (paramczi != null)
          {
            paramdbs = new aa();
            paramdbs.field_key = "@LibraryAppId";
            paramdbs.field_version = paramInt;
            if (paramczi.get(paramdbs, new String[] { "key", "version" }))
            {
              paramString1.woF = ((int)paramdbs.field_updateTime);
              paramString1.ygN = paramdbs.field_scene;
            }
          }
        }
        paramString2.xoO = paramString1;
      }
      try
      {
        if (ac.erD.emB) {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "SrvDeviceInfo isLimit benchmarkLevel");
        }
        for (paramString2.xoS = -2;; paramString2.xoS = com.tencent.mm.m.g.Nq().getInt("ClientBenchmarkLevel", 0))
        {
          paramString1 = new b.a();
          paramString1.funcId = 1122;
          paramString1.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
          paramString1.fsX = paramString2;
          paramString1.fsY = new azn();
          paramString1 = paramString1.ado();
          this.rr = paramString1;
          this.rr = paramString1;
          AppMethodBeat.o(132022);
          return;
          paramString2 = cs.b.dcW;
          break;
          i = 2;
          break label90;
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", paramString1, "read performanceLevel", new Object[0]);
        }
      }
    }
  }
  
  final boolean aHk()
  {
    return ((azm)this.rr.fsV.fta).xoM.xqM > 0;
  }
  
  final int aHl()
  {
    return ((azm)this.rr.fsV.fta).xoM.Scene;
  }
  
  final azm aHm()
  {
    return (azm)this.rr.fsV.fta;
  }
  
  public final void aHn()
  {
    AppMethodBeat.i(132023);
    com.tencent.mm.plugin.appbrand.t.e.aNS().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132017);
        a.this.imf = false;
        a.this.adl();
        AppMethodBeat.o(132017);
      }
    });
    AppMethodBeat.o(132023);
  }
  
  public final com.tencent.mm.cm.f<a.a<azn>> adl()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(132024);
        Object localObject1 = ((com.tencent.mm.plugin.appbrand.appcache.b.e.e)com.tencent.mm.plugin.appbrand.app.g.w(com.tencent.mm.plugin.appbrand.appcache.b.e.e.class)).aA(getAppId(), aHl());
        com.tencent.mm.plugin.appbrand.appcache.b.c.a locala;
        if (((Pair)localObject1).first != null)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "before run, get issued data by appId(%s) scene(%d)", new Object[] { getAppId(), Integer.valueOf(aHl()) });
          locala = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(((Long)((Pair)localObject1).second).longValue(), 106L);
          localObject1 = com.tencent.mm.cm.g.c(new a.2(this, (Pair)localObject1));
          AppMethodBeat.o(132024);
          return localObject1;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "run() appId[%s], scene[%d], libVersion[%d] performanceLevel[%d]", new Object[] { getAppId(), Integer.valueOf(aHl()), Integer.valueOf(((azm)this.rr.fsV.fta).xoO.xqO), Integer.valueOf(aHm().xoS) });
        if (aHm().xoS == 0) {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "run() appId[%s] invalid performanceLevel[%d]", new Object[] { getAppId(), Integer.valueOf(aHm().xoS) });
        }
        if (!this.imf)
        {
          localObject1 = ((com.tencent.mm.plugin.appbrand.appcache.b.e.b)com.tencent.mm.plugin.appbrand.app.g.w(com.tencent.mm.plugin.appbrand.appcache.b.e.b.class)).I(getAppId(), 2, aHl());
          if (((Boolean)((Pair)localObject1).first).booleanValue())
          {
            locala = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(((Integer)((Pair)localObject1).second).intValue(), 168L);
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "async launch with appid(%s) scene(%d) blocked", new Object[] { getAppId(), Integer.valueOf(aHl()) });
            localObject1 = com.tencent.mm.cm.g.c(new a.3(this));
            AppMethodBeat.o(132024);
            continue;
          }
        }
        l = bo.aoy();
      }
      finally {}
      long l;
      this.ine.fr(l);
      com.tencent.mm.cm.f localf = super.adl();
      AppMethodBeat.o(132024);
    }
  }
  
  final int ath()
  {
    return ((azm)this.rr.fsV.fta).xoM.xmQ;
  }
  
  final String getAppId()
  {
    return ((azm)this.rr.fsV.fta).fKw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.a
 * JD-Core Version:    0.7.0.1
 */