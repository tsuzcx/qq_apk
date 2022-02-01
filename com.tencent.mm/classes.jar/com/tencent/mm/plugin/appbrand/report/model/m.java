package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.ehy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class m
{
  private static final m mys;
  public String appId;
  public int dLf;
  public String dLg;
  public int dli;
  public String dlj;
  public String dlk;
  private final h lSX;
  public int mwv;
  private final boolean mxP;
  public String mxT;
  public int mxX;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48155);
    mys = new m(true, h.mxC);
    AppMethodBeat.o(48155);
  }
  
  private m(boolean paramBoolean, h paramh)
  {
    this.mxP = paramBoolean;
    this.lSX = paramh;
  }
  
  private static String Vc(String paramString)
  {
    AppMethodBeat.i(48153);
    String str = paramString;
    if (bu.nullAsNil(paramString).length() > 1024) {
      str = paramString.substring(0, 1024);
    }
    AppMethodBeat.o(48153);
    return str;
  }
  
  public static m b(p paramp, String paramString, h paramh)
  {
    AppMethodBeat.i(48150);
    paramh = new m(false, paramh);
    try
    {
      paramh.sessionId = paramString;
      paramh.appId = paramp.mAppId;
      paramString = paramp.Fg().cmE;
      paramh.scene = paramString.scene;
      paramh.dlj = paramString.dlj;
      paramh.dLf = paramString.dLf;
      paramh.dLg = paramString.dLg;
      paramh.mwv = paramString.mwv;
      paramh.dli = (paramp.aXx().dQv + 1);
      AppMethodBeat.o(48150);
      return paramh;
    }
    catch (Exception paramp)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14004", paramp, "Kv_14004 protect the npe", new Object[0]);
      }
    }
  }
  
  public static m byv()
  {
    return mys;
  }
  
  private void report()
  {
    AppMethodBeat.i(48152);
    if (this.mxP)
    {
      AppMethodBeat.o(48152);
      return;
    }
    this.dlk = Vc(this.dlk);
    this.mxT = Vc(this.mxT);
    ehy localehy = new ehy();
    localehy.nJA = 1;
    localehy.ikm = this.appId;
    localehy.Ilu = this.dlk;
    localehy.yxe = 0;
    localehy.qlc = ((int)bu.aRi());
    localehy.yxf = 1;
    localehy.Ilv = "";
    localehy.GMl = this.dli;
    localehy.FQl = this.sessionId;
    localehy.Ilw = com.tencent.mm.plugin.appbrand.report.h.getNetworkType(ak.getContext());
    localehy.EcJ = this.scene;
    localehy.Ilx = this.mwv;
    localehy.GvN = this.dlj;
    localehy.mxT = this.mxT;
    localehy.dLf = this.dLf;
    localehy.dLg = this.dLg;
    localehy.mxX = this.mxX;
    AppBrandIDKeyBatchReport.a(localehy);
    ae.i("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
    AppMethodBeat.o(48152);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48154);
    String str = "kv_14004{appId='" + this.appId + '\'' + ", sessionId='" + this.sessionId + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.dlj + '\'' + ", preScene=" + this.dLf + ", preSceneNote='" + this.dLg + '\'' + ", pagePath='" + this.dlk + '\'' + ", usedState=" + this.mwv + ", appState=" + this.dli + ", referPagePath='" + this.mxT + '\'' + ", isEntrance=" + this.mxX + '}';
    AppMethodBeat.o(48154);
    return str;
  }
  
  public final void x(ad paramad)
  {
    AppMethodBeat.i(48151);
    this.dlk = paramad.mcM;
    paramad = this.lSX.s(paramad);
    if ((paramad != null) && (paramad.mxE != null))
    {
      paramad = paramad.mxE.path;
      this.mxT = paramad;
      if (!this.lSX.UY(this.dlk)) {
        break label88;
      }
    }
    label88:
    for (int i = 1;; i = 0)
    {
      this.mxX = i;
      report();
      AppMethodBeat.o(48151);
      return;
      paramad = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.m
 * JD-Core Version:    0.7.0.1
 */