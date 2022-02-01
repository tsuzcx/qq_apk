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
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class m
{
  private static final m mtv;
  public String appId;
  public int dJQ;
  public String dJR;
  public int dkg;
  public String dkh;
  public String dki;
  private final h lOw;
  public int mrx;
  private final boolean msS;
  public String msW;
  public int mta;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48155);
    mtv = new m(true, h.msF);
    AppMethodBeat.o(48155);
  }
  
  private m(boolean paramBoolean, h paramh)
  {
    this.msS = paramBoolean;
    this.lOw = paramh;
  }
  
  private static String Ur(String paramString)
  {
    AppMethodBeat.i(48153);
    String str = paramString;
    if (bt.nullAsNil(paramString).length() > 1024) {
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
      paramString = paramo.Fb().cmC;
      paramh.scene = paramString.scene;
      paramh.dkh = paramString.dkh;
      paramh.dJQ = paramString.dJQ;
      paramh.dJR = paramString.dJR;
      paramh.mrx = paramString.mrx;
      paramh.dkg = (paramo.aXc().dPf + 1);
      AppMethodBeat.o(48150);
      return paramh;
    }
    catch (Exception paramo)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14004", paramo, "Kv_14004 protect the npe", new Object[0]);
      }
    }
  }
  
  public static m bxC()
  {
    return mtv;
  }
  
  private void report()
  {
    AppMethodBeat.i(48152);
    if (this.msS)
    {
      AppMethodBeat.o(48152);
      return;
    }
    this.dki = Ur(this.dki);
    this.msW = Ur(this.msW);
    egh localegh = new egh();
    localegh.nEf = 1;
    localegh.iht = this.appId;
    localegh.HRn = this.dki;
    localegh.yhn = 0;
    localegh.qex = ((int)bt.aQJ());
    localegh.yho = 1;
    localegh.HRo = "";
    localegh.GsN = this.dkg;
    localegh.FxN = this.sessionId;
    localegh.HRp = com.tencent.mm.plugin.appbrand.report.h.getNetworkType(aj.getContext());
    localegh.DKL = this.scene;
    localegh.HRq = this.mrx;
    localegh.Gdg = this.dkh;
    localegh.msW = this.msW;
    localegh.dJQ = this.dJQ;
    localegh.dJR = this.dJR;
    localegh.mta = this.mta;
    AppBrandIDKeyBatchReport.a(localegh);
    ad.i("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
    AppMethodBeat.o(48152);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48154);
    String str = "kv_14004{appId='" + this.appId + '\'' + ", sessionId='" + this.sessionId + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.dkh + '\'' + ", preScene=" + this.dJQ + ", preSceneNote='" + this.dJR + '\'' + ", pagePath='" + this.dki + '\'' + ", usedState=" + this.mrx + ", appState=" + this.dkg + ", referPagePath='" + this.msW + '\'' + ", isEntrance=" + this.mta + '}';
    AppMethodBeat.o(48154);
    return str;
  }
  
  public final void w(ae paramae)
  {
    AppMethodBeat.i(48151);
    this.dki = paramae.lYf;
    paramae = this.lOw.r(paramae);
    if ((paramae != null) && (paramae.msH != null))
    {
      paramae = paramae.msH.path;
      this.msW = paramae;
      if (!this.lOw.Un(this.dki)) {
        break label88;
      }
    }
    label88:
    for (int i = 1;; i = 0)
    {
      this.mta = i;
      report();
      AppMethodBeat.o(48151);
      return;
      paramae = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.m
 * JD-Core Version:    0.7.0.1
 */