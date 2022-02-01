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
import com.tencent.mm.protocal.protobuf.dum;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class m
{
  private static final m lrL;
  public String appId;
  public int dbs;
  public String dbt;
  public String dbu;
  public int dzS;
  public String dzT;
  private final h kPx;
  public int lpL;
  private final boolean lrh;
  public String lrl;
  public int lrq;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48155);
    lrL = new m(true, h.lqT);
    AppMethodBeat.o(48155);
  }
  
  private m(boolean paramBoolean, h paramh)
  {
    this.lrh = paramBoolean;
    this.kPx = paramh;
  }
  
  private static String MC(String paramString)
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
      paramString = paramo.DZ().cfo;
      paramh.scene = paramString.scene;
      paramh.dbt = paramString.dbt;
      paramh.dzS = paramString.dzS;
      paramh.dzT = paramString.dzT;
      paramh.lpL = paramString.lpL;
      paramh.dbs = (paramo.aNc().iOP + 1);
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
  
  public static m bmB()
  {
    return lrL;
  }
  
  private void report()
  {
    AppMethodBeat.i(48152);
    if (this.lrh)
    {
      AppMethodBeat.o(48152);
      return;
    }
    this.dbu = MC(this.dbu);
    this.lrl = MC(this.lrl);
    dum localdum = new dum();
    localdum.mBH = 1;
    localdum.hnC = this.appId;
    localdum.EIO = this.dbu;
    localdum.vJz = 0;
    localdum.oXH = ((int)bt.aGK());
    localdum.vJA = 1;
    localdum.EIP = "";
    localdum.DoL = this.dbs;
    localdum.CzY = this.sessionId;
    localdum.EIQ = com.tencent.mm.plugin.appbrand.report.h.getNetworkType(aj.getContext());
    localdum.APo = this.scene;
    localdum.EIR = this.lpL;
    localdum.DcD = this.dbt;
    localdum.lrl = this.lrl;
    localdum.dzS = this.dzS;
    localdum.dzT = this.dzT;
    localdum.lrq = this.lrq;
    AppBrandIDKeyBatchReport.a(localdum);
    ad.i("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
    AppMethodBeat.o(48152);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48154);
    String str = "kv_14004{appId='" + this.appId + '\'' + ", sessionId='" + this.sessionId + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.dbt + '\'' + ", preScene=" + this.dzS + ", preSceneNote='" + this.dzT + '\'' + ", pagePath='" + this.dbu + '\'' + ", usedState=" + this.lpL + ", appState=" + this.dbs + ", referPagePath='" + this.lrl + '\'' + ", isEntrance=" + this.lrq + '}';
    AppMethodBeat.o(48154);
    return str;
  }
  
  public final void v(ae paramae)
  {
    AppMethodBeat.i(48151);
    this.dbu = paramae.kWX;
    paramae = this.kPx.q(paramae);
    if ((paramae != null) && (paramae.lqW != null))
    {
      paramae = paramae.lqW.path;
      this.lrl = paramae;
      if (!this.kPx.My(this.dbu)) {
        break label88;
      }
    }
    label88:
    for (int i = 1;; i = 0)
    {
      this.lrq = i;
      report();
      AppMethodBeat.o(48151);
      return;
      paramae = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.m
 * JD-Core Version:    0.7.0.1
 */