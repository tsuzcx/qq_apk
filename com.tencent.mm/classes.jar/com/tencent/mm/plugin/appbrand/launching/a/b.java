package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.f.b.a.pu;
import com.tencent.mm.f.b.a.pu.b;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.launching.aj;
import com.tencent.mm.plugin.appbrand.launching.y;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.fnd;
import com.tencent.mm.protocal.protobuf.foc;
import com.tencent.mm.protocal.protobuf.fot;
import com.tencent.mm.protocal.protobuf.foy;
import com.tencent.mm.protocal.protobuf.fpd;
import com.tencent.mm.protocal.protobuf.fqa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public final class b
  extends com.tencent.mm.plugin.appbrand.networking.b<cqa>
{
  private final String cBH;
  final String cwP;
  private volatile boolean pWG;
  public volatile aj pYe;
  public y pYf;
  private final pu pYg;
  final com.tencent.mm.an.d rr;
  
  public b(String paramString1, boolean paramBoolean, fnd paramfnd, fqa paramfqa, fot paramfot, String paramString2, int paramInt1, QualitySession paramQualitySession, String paramString3, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer, String paramString4, ack paramack, int paramInt2)
  {
    super(paramString1, paramString3);
    AppMethodBeat.i(267063);
    this.pWG = false;
    this.cwP = paramString2;
    this.pYg = com.tencent.mm.plugin.appbrand.report.quality.g.d(paramQualitySession);
    pu localpu = this.pYg;
    pu.b localb;
    int i;
    if (paramBoolean)
    {
      localb = pu.b.hhS;
      localpu.hhM = localb;
      this.pYg.gHC = com.tencent.mm.plugin.appbrand.report.quality.g.getNetworkType();
      this.cBH = paramQualitySession.cBH;
      paramQualitySession = new cpz();
      paramQualitySession.lVG = paramString1;
      paramQualitySession.Txh = paramfnd;
      if (!paramBoolean) {
        break label385;
      }
      i = 1;
      label102:
      paramQualitySession.TkK = i;
      paramQualitySession.Txk = paramfqa;
      paramQualitySession.Txl = paramfot;
      paramQualitySession.Txp = paramString3;
      paramQualitySession.Txo = this.cBH;
      paramQualitySession.Txt = paramInt2;
      paramfnd = new foc();
      paramfnd.TBI = paramInt1;
      paramQualitySession.Txj = paramfnd;
      if ((paramQualitySession.Txh.CPw == 1162) && (paramAppBrandLaunchFromNotifyReferrer != null))
      {
        paramfnd = new fpd();
        paramfnd.UMW = paramAppBrandLaunchFromNotifyReferrer.nYy;
        paramQualitySession.Txq = paramfnd;
      }
      if (1173 == paramQualitySession.Txh.CPw)
      {
        if (!Util.isNullOrNil(paramString4)) {
          break label391;
        }
        Log.w("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "<init>, openMaterialMimeType is empty");
      }
    }
    for (;;)
    {
      paramQualitySession.RPD = ((ack)Objects.requireNonNull(paramack));
      paramfnd = new d.a();
      paramfnd.funcId = 1122;
      paramfnd.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
      paramfnd.lBU = paramQualitySession;
      paramfnd.lBV = new cqa();
      paramfnd = paramfnd.bgN();
      this.rr = paramfnd;
      c(paramfnd);
      Log.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "<init> cgiHash[%d], username[%s] appId[%s] sync[%b] sessionId[%s] instanceId[%s] libVersion[%d], source:%s", new Object[] { Integer.valueOf(hashCode()), paramString3, paramString1, Boolean.valueOf(paramBoolean), paramString2, this.cBH, Integer.valueOf(paramInt1), com.tencent.mm.ak.a.a(paramack) });
      AppMethodBeat.o(267063);
      return;
      localb = pu.b.hhT;
      break;
      label385:
      i = 2;
      break label102;
      label391:
      paramfnd = new foy();
      paramfnd.Thq = paramString4;
      paramQualitySession.Txs = paramfnd;
    }
  }
  
  public static void a(cpz paramcpz)
  {
    AppMethodBeat.i(47398);
    try
    {
      if (af.juQ.jnI)
      {
        Log.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "SrvDeviceInfo isLimit benchmarkLevel");
        paramcpz.Txn = -1;
        AppMethodBeat.o(47398);
        return;
      }
      paramcpz.Txn = com.tencent.mm.n.h.axc().getInt("ClientBenchmarkLevel", -1);
      if (paramcpz.Txn == 0) {
        Log.e("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "DynamicConfig performanceLevel 0 illegal");
      }
      AppMethodBeat.o(47398);
      return;
    }
    catch (Exception paramcpz)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", paramcpz, "read performanceLevel", new Object[0]);
      AppMethodBeat.o(47398);
    }
  }
  
  public static void b(cpz paramcpz)
  {
    AppMethodBeat.i(47399);
    int i = paramcpz.Txj.TBI;
    if (i > 0)
    {
      ah localah = m.bFV();
      if (localah != null)
      {
        ag localag = new ag();
        localag.field_key = "@LibraryAppId";
        localag.field_version = i;
        if (localah.get(localag, new String[] { "key", "version" }))
        {
          paramcpz.Txj.RIt = ((int)localag.field_updateTime);
          paramcpz.Txj.UMq = localag.field_scene;
        }
      }
      AppMethodBeat.o(47399);
      return;
    }
    paramcpz.Txj.TBI = 0;
    AppMethodBeat.o(47399);
  }
  
  private String getUserName()
  {
    AppMethodBeat.i(267065);
    String str = ((cpz)d.b.b(this.rr.lBR)).Txp;
    AppMethodBeat.o(267065);
    return str;
  }
  
  final int bBV()
  {
    AppMethodBeat.i(267066);
    int i = ((cpz)d.b.b(this.rr.lBR)).Txh.TuP;
    AppMethodBeat.o(267066);
    return i;
  }
  
  public final com.tencent.mm.cw.f<com.tencent.mm.an.c.a<cqa>> bLt()
  {
    AppMethodBeat.i(267071);
    if (!com.tencent.mm.plugin.appbrand.networking.a.eO(getAppId(), getUserName()))
    {
      com.tencent.mm.cw.f localf = com.tencent.mm.cw.g.c(new com.tencent.mm.vending.g.c.a() {});
      AppMethodBeat.o(267071);
      return localf;
    }
    AppMethodBeat.o(267071);
    return null;
  }
  
  public final com.tencent.mm.cw.f<com.tencent.mm.an.c.a<cqa>> bhW()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(47397);
        Object localObject1 = new a().a((cpz)d.b.b(this.rr.lBR), this.pWG, this);
        if (localObject1 != null)
        {
          AppMethodBeat.o(47397);
          return localObject1;
        }
        localObject1 = com.tencent.luggage.sdk.f.c.cDf;
        localObject1 = com.tencent.luggage.sdk.f.c.ej(this.cBH);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.appbrand.launching.d.c.a((com.tencent.luggage.sdk.f.b)localObject1);
          if (localObject1 != null)
          {
            final com.tencent.mm.an.c.a locala = ((com.tencent.mm.plugin.appbrand.launching.d.g)localObject1).BN(100);
            ((com.tencent.mm.plugin.appbrand.launching.d.g)localObject1).nip = this.pWG;
            if ((locala != null) && (locala.lBJ != null) && (locala.errType == 0) && (locala.errCode == 0))
            {
              ((com.tencent.luggage.sdk.f.a)localObject1).cCX = true;
              localObject1 = com.tencent.mm.cw.g.c(new com.tencent.mm.vending.g.c.a() {});
              AppMethodBeat.o(47397);
              continue;
            }
            localObject2.cCX = false;
          }
        }
      }
      finally {}
      b(cao());
      a(cao());
      long l = Util.nowMilliSecond();
      this.pYg.Df(l);
      com.tencent.mm.cw.f localf = super.bhW();
      AppMethodBeat.o(47397);
    }
  }
  
  final boolean cam()
  {
    AppMethodBeat.i(267067);
    if (((cpz)d.b.b(this.rr.lBR)).Txh.TBG > 0)
    {
      AppMethodBeat.o(267067);
      return true;
    }
    AppMethodBeat.o(267067);
    return false;
  }
  
  public final cqa can()
  {
    AppMethodBeat.i(267068);
    cqa localcqa = (cqa)d.c.b(this.rr.lBS);
    AppMethodBeat.o(267068);
    return localcqa;
  }
  
  protected final cpz cao()
  {
    AppMethodBeat.i(267069);
    cpz localcpz = (cpz)d.b.b(this.rr.lBR);
    AppMethodBeat.o(267069);
    return localcpz;
  }
  
  public final com.tencent.mm.an.c.a<cqa> cap()
  {
    AppMethodBeat.i(267070);
    this.pWG = true;
    com.tencent.mm.an.c.a locala = super.cap();
    AppMethodBeat.o(267070);
    return locala;
  }
  
  public final void caq()
  {
    AppMethodBeat.i(47396);
    com.tencent.mm.vending.h.d.LOGIC.arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47391);
        b.a(b.this);
        b.this.bhW();
        AppMethodBeat.o(47391);
      }
    });
    AppMethodBeat.o(47396);
  }
  
  final String getAppId()
  {
    AppMethodBeat.i(267064);
    String str = ((cpz)d.b.b(this.rr.lBR)).lVG;
    AppMethodBeat.o(267064);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.b
 * JD-Core Version:    0.7.0.1
 */