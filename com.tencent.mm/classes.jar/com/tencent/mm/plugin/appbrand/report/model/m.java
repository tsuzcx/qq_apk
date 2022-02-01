package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class m
{
  private static final m lTG;
  public String appId;
  public int cYO;
  public String cYP;
  public String cYQ;
  public int dxE;
  public String dxF;
  public int lRH;
  private final boolean lTc;
  public String lTg;
  public int lTl;
  private final h lqW;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48155);
    lTG = new m(true, h.lSO);
    AppMethodBeat.o(48155);
  }
  
  private m(boolean paramBoolean, h paramh)
  {
    this.lTc = paramBoolean;
    this.lqW = paramh;
  }
  
  private static String QL(String paramString)
  {
    AppMethodBeat.i(48153);
    String str = paramString;
    if (bs.nullAsNil(paramString).length() > 1024) {
      str = paramString.substring(0, 1024);
    }
    AppMethodBeat.o(48153);
    return str;
  }
  
  public static m b(o paramo, String paramString, h paramh)
  {
    AppMethodBeat.i(48150);
    paramh = new m(false, paramh);
    try
    {
      paramh.sessionId = paramString;
      paramh.appId = paramo.mAppId;
      paramString = paramo.DC().ccl;
      paramh.scene = paramString.scene;
      paramh.cYP = paramString.cYP;
      paramh.dxE = paramString.dxE;
      paramh.dxF = paramString.dxF;
      paramh.lRH = paramString.lRH;
      paramh.cYO = (paramo.aTS().joY + 1);
      AppMethodBeat.o(48150);
      return paramh;
    }
    catch (Exception paramo)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14004", paramo, "Kv_14004 protect the npe", new Object[0]);
      }
    }
  }
  
  public static m btx()
  {
    return lTG;
  }
  
  private void report()
  {
    AppMethodBeat.i(48152);
    if (this.lTc)
    {
      AppMethodBeat.o(48152);
      return;
    }
    this.cYQ = QL(this.cYQ);
    this.lTg = QL(this.lTg);
    ead localead = new ead();
    localead.ndI = 1;
    localead.hOf = this.appId;
    localead.Gga = this.cYQ;
    localead.wTD = 0;
    localead.pAS = ((int)bs.aNx());
    localead.wTE = 1;
    localead.Ggb = "";
    localead.EJL = this.cYO;
    localead.DSu = this.sessionId;
    localead.Ggc = g.getNetworkType(ai.getContext());
    localead.ChE = this.scene;
    localead.Ggd = this.lRH;
    localead.EvK = this.cYP;
    localead.lTg = this.lTg;
    localead.dxE = this.dxE;
    localead.dxF = this.dxF;
    localead.lTl = this.lTl;
    AppBrandIDKeyBatchReport.a(localead);
    ac.i("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
    AppMethodBeat.o(48152);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48154);
    String str = "kv_14004{appId='" + this.appId + '\'' + ", sessionId='" + this.sessionId + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.cYP + '\'' + ", preScene=" + this.dxE + ", preSceneNote='" + this.dxF + '\'' + ", pagePath='" + this.cYQ + '\'' + ", usedState=" + this.lRH + ", appState=" + this.cYO + ", referPagePath='" + this.lTg + '\'' + ", isEntrance=" + this.lTl + '}';
    AppMethodBeat.o(48154);
    return str;
  }
  
  public final void v(ae paramae)
  {
    AppMethodBeat.i(48151);
    this.cYQ = paramae.lyH;
    paramae = this.lqW.q(paramae);
    if ((paramae != null) && (paramae.lSR != null))
    {
      paramae = paramae.lSR.path;
      this.lTg = paramae;
      if (!this.lqW.QH(this.cYQ)) {
        break label88;
      }
    }
    label88:
    for (int i = 1;; i = 0)
    {
      this.lTl = i;
      report();
      AppMethodBeat.o(48151);
      return;
      paramae = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.m
 * JD-Core Version:    0.7.0.1
 */