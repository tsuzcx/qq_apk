package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class j
{
  private static final j iHe;
  public String appId;
  public int apptype;
  public int bDc;
  public int cJb;
  public String cJc;
  public int cmE;
  public String cmF;
  public String cmG;
  public String cpW;
  public i gRG;
  public int hiJ;
  public int iFX;
  public long iHc;
  private final boolean iHd;
  boolean iHf = false;
  public String iHg;
  public long iHh;
  public String iHi;
  public int iHj;
  public String iHk;
  public long iHl;
  public int iHm;
  public int iHn;
  public String iHo;
  public String iHp;
  private final h ioE;
  public int scene;
  
  static
  {
    AppMethodBeat.i(132636);
    iHe = new j(true, null);
    AppMethodBeat.o(132636);
  }
  
  private j(boolean paramBoolean, h paramh)
  {
    this.iHd = paramBoolean;
    this.ioE = paramh;
  }
  
  public static j a(o paramo, String paramString, h paramh)
  {
    AppMethodBeat.i(132631);
    paramh = new j(false, paramh);
    paramh.cpW = paramString;
    paramString = paramo.wS().bDh;
    paramh.scene = paramString.scene;
    paramh.cmF = paramString.cmF;
    paramh.appId = paramo.mAppId;
    paramh.gRG = paramo;
    paramh.cmE = (paramo.atS().gXd + 1);
    paramh.bDc = paramo.atS().bDc;
    paramh.iFX = paramString.iFX;
    paramh.cJb = paramString.cJb;
    paramh.cJc = paramString.cJc;
    AppMethodBeat.o(132631);
    return paramh;
  }
  
  public static j aLp()
  {
    return iHe;
  }
  
  final void IE()
  {
    AppMethodBeat.i(132635);
    if (this.iHd)
    {
      AppMethodBeat.o(132635);
      return;
    }
    j.1 local1 = new j.1(this, new Object[] { Integer.valueOf(this.scene), this.cmF, this.cpW, this.appId, Integer.valueOf(this.bDc), Integer.valueOf(this.cmE), Integer.valueOf(this.iFX), this.cmG, this.iHg, Long.valueOf(this.iHc), Long.valueOf(this.iHh), this.iHi, Integer.valueOf(this.iHj), this.iHk, Long.valueOf(this.iHl), Integer.valueOf(this.iHm), Integer.valueOf(this.cJb), this.cJc, Integer.valueOf(this.iHn), this.iHo, Integer.valueOf(this.apptype), Integer.valueOf(this.hiJ), this.iHp });
    if (this.iHf)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.chN();
        AppMethodBeat.o(132635);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.Report.kv_13536", localException, "sendKV", new Object[0]);
        AppMethodBeat.o(132635);
        return;
      }
    }
    com.tencent.mm.plugin.appbrand.t.e.aNS().ac(localException);
    AppMethodBeat.o(132635);
  }
  
  public final void k(z paramz)
  {
    AppMethodBeat.i(132632);
    l(paramz);
    IE();
    AppMethodBeat.o(132632);
  }
  
  final void l(z paramz)
  {
    Object localObject3 = null;
    AppMethodBeat.i(132633);
    Object localObject1 = paramz.getRuntime().atR();
    if (localObject1 != null)
    {
      this.bDc = ((com.tencent.mm.plugin.appbrand.config.h)localObject1).hiX.gXf;
      this.iHm = WxaCommLibRuntimeReader.avI().gXf;
    }
    this.iHl = paramz.ixF.iGC;
    this.iHc = paramz.ixF.aLe();
    this.iHh = paramz.ixF.aLg();
    this.cmG = paramz.hzM;
    this.iHo = paramz.iuB;
    this.iHg = com.tencent.mm.plugin.appbrand.report.e.cZ(ah.getContext());
    this.iFX = paramz.getRuntime().wS().bDh.iFX;
    localObject1 = this.ioE.h(paramz);
    Object localObject2;
    int i;
    if (localObject1 == null)
    {
      ab.e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", new Object[] { paramz.iuB });
      localObject2 = null;
      localObject1 = null;
      if (localObject2 != null) {
        break label309;
      }
      i = 0;
      label163:
      this.iHj = i;
      if (localObject2 != null) {
        break label318;
      }
      localObject2 = null;
      label176:
      this.iHk = ((String)localObject2);
      if (localObject1 != null) {
        break label328;
      }
      localObject1 = null;
      label188:
      this.iHi = ((String)localObject1);
      if (!this.ioE.EH(this.iHo)) {
        break label336;
      }
      i = 1;
      label211:
      this.iHn = i;
      localObject1 = paramz.getRuntime();
      if (localObject1 != null) {
        break label341;
      }
      localObject1 = localObject3;
      label228:
      if (localObject1 == null) {
        break label349;
      }
      this.apptype = ((AppBrandInitConfigWC)localObject1).bCV;
    }
    for (;;)
    {
      this.apptype += 1000;
      this.hiJ = paramz.getRuntime().atS().hiJ;
      paramz = n.yc(paramz.getAppId()).gRe;
      if (!bo.isNullOrNil(paramz)) {
        this.iHp = paramz;
      }
      AppMethodBeat.o(132633);
      return;
      localObject2 = ((h.a)localObject1).iGS;
      localObject1 = ((h.a)localObject1).iGT;
      break;
      label309:
      i = ((h.c)localObject2).type;
      break label163;
      label318:
      localObject2 = ((h.c)localObject2).path;
      break label176;
      label328:
      localObject1 = ((h.b)localObject1).path;
      break label188;
      label336:
      i = 0;
      break label211;
      label341:
      localObject1 = ((o)localObject1).atS();
      break label228;
      label349:
      this.apptype = f.EE(this.appId);
      ab.i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(132634);
    String str = "kv_13536{scene=" + this.scene + ", sceneNote='" + this.cmF + '\'' + ", sessionId='" + this.cpW + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.bDc + ", appState=" + this.cmE + ", usedState=" + this.iFX + ", pagePath='" + this.cmG + '\'' + ", networkType='" + this.iHg + '\'' + ", costTime=" + this.iHc + ", stayTime=" + this.iHh + ", referPagePath='" + this.iHi + '\'' + ", targetAction=" + this.iHj + ", targetPagePath='" + this.iHk + '\'' + ", clickTimestamp=" + this.iHl + ", publicLibVersion=" + this.iHm + ", preScene=" + this.cJb + ", preSceneNote='" + this.cJc + '\'' + ", isEntrance=" + this.iHn + ", apptype=" + this.apptype + ", systemRecentsReason=" + this.hiJ + ", referAction=" + this.iHp + '}';
    AppMethodBeat.o(132634);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.j
 * JD-Core Version:    0.7.0.1
 */