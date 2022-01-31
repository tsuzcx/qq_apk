package com.tencent.mm.plugin.appbrand.game;

import android.content.SharedPreferences;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.debugger.t;
import com.tencent.mm.plugin.appbrand.i.y;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.b.1;
import com.tencent.mm.plugin.appbrand.report.b.2;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.h;
import com.tencent.mm.plugin.appbrand.report.quality.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.f;
import java.util.Map;

public class a
  extends com.tencent.luggage.game.e.a.a.a<com.tencent.mm.plugin.appbrand.service.c>
{
  private com.tencent.mm.plugin.appbrand.report.b hrV;
  private long hrW;
  
  public a(com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(143092);
    this.hrW = -1L;
    this.hrV = new com.tencent.mm.plugin.appbrand.report.b();
    AppMethodBeat.o(143092);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.i parami)
  {
    AppMethodBeat.i(143097);
    super.a(parami);
    ab.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: wc post runtime ready");
    com.tencent.mm.plugin.appbrand.report.b localb = this.hrV;
    a.1 local1 = new a.1(this, parami);
    localb.iFh.post(new b.1(localb, parami, local1));
    AppMethodBeat.o(143097);
  }
  
  public final void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    AppMethodBeat.i(143100);
    if ((((com.tencent.mm.plugin.appbrand.service.c)this.bDN).aud()) || (((com.tencent.mm.plugin.appbrand.service.c)this.bDN).isRunning()))
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.aLt();
      com.tencent.mm.plugin.appbrand.report.quality.b.a(paramBoolean, ((com.tencent.mm.plugin.appbrand.service.c)this.bDN).getAppId(), paramLong, "WAGame.js", paramInt);
    }
    super.a(paramBoolean, paramLong, paramInt);
    AppMethodBeat.o(143100);
  }
  
  public final String cf(String paramString)
  {
    AppMethodBeat.i(143103);
    if ((((com.tencent.mm.plugin.appbrand.service.c)this.bDN).getRuntime() != null) && (((com.tencent.mm.plugin.appbrand.service.c)this.bDN).getRuntime().wV()))
    {
      paramString = t.a(paramString, ((com.tencent.mm.plugin.appbrand.service.c)this.bDN).getRuntime());
      AppMethodBeat.o(143103);
      return paramString;
    }
    AppMethodBeat.o(143103);
    return "";
  }
  
  public final void onMainCanvasTypeDefined(int paramInt)
  {
    AppMethodBeat.i(143102);
    super.onMainCanvasTypeDefined(paramInt);
    Object localObject = com.tencent.mm.plugin.appbrand.report.quality.a.EM(((com.tencent.mm.plugin.appbrand.service.c)this.bDN).getRuntime().mAppId);
    if (localObject == null)
    {
      AppMethodBeat.o(143102);
      return;
    }
    h localh = ((QualitySessionRuntime)localObject).iIP;
    if (paramInt == 1) {}
    for (localObject = h.a.iIU;; localObject = h.a.iIV)
    {
      localh.iIS = ((h.a)localObject);
      AppMethodBeat.o(143102);
      return;
    }
  }
  
  public final void uP()
  {
    AppMethodBeat.i(143105);
    new com.tencent.mm.plugin.appbrand.game.c.c().uD();
    AppMethodBeat.o(143105);
  }
  
  public final com.tencent.mm.plugin.appbrand.i.i uR()
  {
    AppMethodBeat.i(143093);
    this.hrW = System.currentTimeMillis();
    com.tencent.mm.plugin.appbrand.i.i locali = super.uR();
    AppMethodBeat.o(143093);
    return locali;
  }
  
  public final void uS()
  {
    AppMethodBeat.i(143095);
    super.uS();
    com.tencent.mm.plugin.appbrand.report.quality.a.aLt();
    if (((com.tencent.mm.plugin.appbrand.service.c)this.bDN).aud()) {}
    for (com.tencent.mm.plugin.appbrand.task.g localg = com.tencent.mm.plugin.appbrand.task.g.iKT;; localg = null)
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.a(localg, ((com.tencent.mm.plugin.appbrand.service.c)this.bDN).getAppId(), this.hrW, com.tencent.mm.plugin.appbrand.report.c.iFz);
      AppMethodBeat.o(143095);
      return;
    }
  }
  
  public final void uT()
  {
    AppMethodBeat.i(143104);
    super.uT();
    com.tencent.mm.plugin.appbrand.report.b localb = this.hrV;
    localb.iFh.post(new b.2(localb));
    AppMethodBeat.o(143104);
  }
  
  public final String uV()
  {
    AppMethodBeat.i(143096);
    if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lUe, false))
    {
      String str = y.aAM();
      AppMethodBeat.o(143096);
      return str;
    }
    AppMethodBeat.o(143096);
    return null;
  }
  
  public final boolean uW()
  {
    AppMethodBeat.i(143098);
    boolean bool = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lUd, false);
    AppMethodBeat.o(143098);
    return bool;
  }
  
  public final boolean uY()
  {
    AppMethodBeat.i(143099);
    if (ah.dsR() != null)
    {
      int i = ah.dsR().getInt("appbrandgame_use_commandbuffer", -1);
      if (i != -1)
      {
        if (i != 0)
        {
          AppMethodBeat.o(143099);
          return true;
        }
        AppMethodBeat.o(143099);
        return false;
      }
    }
    if ((((com.tencent.mm.plugin.appbrand.service.c)this.bDN).getRuntime() != null) && (((com.tencent.mm.plugin.appbrand.service.c)this.bDN).getRuntime().getAppConfig().hgT))
    {
      bool = super.uY();
      AppMethodBeat.o(143099);
      return bool;
    }
    if ((f.IS_FLAVOR_RED) || (f.DEBUG))
    {
      AppMethodBeat.o(143099);
      return true;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lWd, false);
    AppMethodBeat.o(143099);
    return bool;
  }
  
  public final com.tencent.luggage.game.a.b uZ()
  {
    AppMethodBeat.i(143106);
    a.a locala = new a.a(this, ((com.tencent.mm.plugin.appbrand.service.c)this.bDN).getContext());
    AppMethodBeat.o(143106);
    return locala;
  }
  
  public final void vf()
  {
    AppMethodBeat.i(143101);
    super.vf();
    e.bq(((com.tencent.mm.plugin.appbrand.service.c)this.bDN).getAppId(), 24);
    int j = 0;
    int i = -1;
    o localo = ((com.tencent.mm.plugin.appbrand.service.c)this.bDN).getRuntime();
    if (localo != null)
    {
      j = localo.wR().hiX.gXf;
      i = localo.wR().hiX.gXe;
    }
    e.b(((com.tencent.mm.plugin.appbrand.service.c)this.bDN).getAppId(), j, i, 778, 14);
    AppMethodBeat.o(143101);
  }
  
  public final Map<String, m> wM()
  {
    AppMethodBeat.i(143094);
    Map localMap = com.tencent.mm.plugin.appbrand.game.e.b.aAD();
    AppMethodBeat.o(143094);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a
 * JD-Core Version:    0.7.0.1
 */