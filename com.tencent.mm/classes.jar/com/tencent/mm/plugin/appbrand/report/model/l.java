package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class l
{
  private static final l iHH;
  public String appId;
  public int cJb;
  public String cJc;
  public int cmE;
  public String cmF;
  public String cmG;
  public String cpW;
  public int iFX;
  private final boolean iHd;
  public String iHi;
  public int iHn;
  private final h ioE;
  public int scene;
  
  static
  {
    AppMethodBeat.i(132649);
    iHH = new l(true, h.iGQ);
    AppMethodBeat.o(132649);
  }
  
  private l(boolean paramBoolean, h paramh)
  {
    this.iHd = paramBoolean;
    this.ioE = paramh;
  }
  
  private static String EL(String paramString)
  {
    AppMethodBeat.i(143518);
    String str = paramString;
    if (bo.nullAsNil(paramString).length() > 1024) {
      str = paramString.substring(0, 1024);
    }
    AppMethodBeat.o(143518);
    return str;
  }
  
  private void IE()
  {
    AppMethodBeat.i(132647);
    if (this.iHd)
    {
      AppMethodBeat.o(132647);
      return;
    }
    this.cmG = EL(this.cmG);
    this.iHi = EL(this.iHi);
    czw localczw = new czw();
    localczw.jKs = 1;
    localczw.fKw = this.appId;
    localczw.ygx = this.cmG;
    localczw.qsk = 0;
    localczw.lGW = ((int)bo.aox());
    localczw.qsl = 1;
    localczw.ygy = "";
    localczw.ygz = this.cmE;
    localczw.wqN = this.cpW;
    localczw.ygA = e.cZ(ah.getContext());
    localczw.uPv = this.scene;
    localczw.ygB = this.iFX;
    localczw.ygC = this.cmF;
    localczw.iHi = this.iHi;
    localczw.cJb = this.cJb;
    localczw.cJc = this.cJc;
    localczw.iHn = this.iHn;
    AppBrandIDKeyBatchReport.a(localczw);
    ab.i("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
    AppMethodBeat.o(132647);
  }
  
  public static l aLq()
  {
    return iHH;
  }
  
  public static l b(o paramo, String paramString, h paramh)
  {
    AppMethodBeat.i(132645);
    paramh = new l(false, paramh);
    try
    {
      paramh.cpW = paramString;
      paramh.appId = paramo.mAppId;
      paramString = paramo.wS().bDh;
      paramh.scene = paramString.scene;
      paramh.cmF = paramString.cmF;
      paramh.cJb = paramString.cJb;
      paramh.cJc = paramString.cJc;
      paramh.iFX = paramString.iFX;
      paramh.cmE = (paramo.atS().gXd + 1);
      AppMethodBeat.o(132645);
      return paramh;
    }
    catch (Exception paramo)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14004", paramo, "Kv_14004 protect the npe", new Object[0]);
      }
    }
  }
  
  public final void m(z paramz)
  {
    AppMethodBeat.i(132646);
    this.cmG = paramz.iuB;
    paramz = this.ioE.h(paramz);
    if ((paramz != null) && (paramz.iGT != null))
    {
      paramz = paramz.iGT.path;
      this.iHi = paramz;
      if (!this.ioE.EH(this.cmG)) {
        break label86;
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      this.iHn = i;
      IE();
      AppMethodBeat.o(132646);
      return;
      paramz = null;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(132648);
    String str = "kv_14004{appId='" + this.appId + '\'' + ", sessionId='" + this.cpW + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.cmF + '\'' + ", preScene=" + this.cJb + ", preSceneNote='" + this.cJc + '\'' + ", pagePath='" + this.cmG + '\'' + ", usedState=" + this.iFX + ", appState=" + this.cmE + ", referPagePath='" + this.iHi + '\'' + ", isEntrance=" + this.iHn + '}';
    AppMethodBeat.o(132648);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.l
 * JD-Core Version:    0.7.0.1
 */