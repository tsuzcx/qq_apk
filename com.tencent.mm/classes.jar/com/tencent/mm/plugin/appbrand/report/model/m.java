package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.y;
import com.tencent.mm.plugin.appbrand.report.y.a;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.protocal.protobuf.fnr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class m
{
  private static final m qLG;
  public String appId;
  public int fXa;
  public String fXb;
  public int fvc;
  public String fvd;
  public String fve;
  public int qJF;
  private final boolean qLe;
  public String qLh;
  public int qLl;
  private final h qaN;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48155);
    qLG = new m(true, h.qKS);
    AppMethodBeat.o(48155);
  }
  
  private m(boolean paramBoolean, h paramh)
  {
    this.qLe = paramBoolean;
    this.qaN = paramh;
  }
  
  private static String amM(String paramString)
  {
    AppMethodBeat.i(48153);
    String str = paramString;
    if (Util.nullAsNil(paramString).length() > 1024) {
      str = paramString.substring(0, 1024);
    }
    AppMethodBeat.o(48153);
    return str;
  }
  
  public static m b(t paramt, String paramString, h paramh)
  {
    AppMethodBeat.i(48150);
    paramh = new m(false, paramh);
    try
    {
      paramh.sessionId = paramString;
      paramh.appId = paramt.mAppId;
      paramString = paramt.Sk().cxf;
      paramh.scene = paramString.scene;
      paramh.fvd = paramString.fvd;
      paramh.fXa = paramString.fXa;
      paramh.fXb = paramString.fXb;
      paramh.qJF = paramString.qJF;
      paramh.fvc = (paramt.bDy().cBI + 1);
      AppMethodBeat.o(48150);
      return paramh;
    }
    catch (Exception paramt)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14004", paramt, "Kv_14004 protect the npe", new Object[0]);
      }
    }
  }
  
  public static m chY()
  {
    return qLG;
  }
  
  private void report()
  {
    AppMethodBeat.i(48152);
    if (this.qLe)
    {
      AppMethodBeat.o(48152);
      return;
    }
    this.fve = amM(this.fve);
    this.qLh = amM(this.qLh);
    fnr localfnr = new fnr();
    localfnr.rWu = 1;
    localfnr.lVG = this.appId;
    localfnr.ULZ = this.fve;
    localfnr.IyZ = 0;
    localfnr.vhF = ((int)Util.nowSecond());
    localfnr.Iza = 1;
    localfnr.UMa = "";
    localfnr.SYQ = this.fvc;
    localfnr.SessionId = this.sessionId;
    localfnr.UMb = j.getNetworkType(MMApplicationContext.getContext());
    localfnr.PLx = this.scene;
    localfnr.UMc = this.qJF;
    localfnr.SsR = this.fvd;
    localfnr.qLh = this.qLh;
    localfnr.fXa = this.fXa;
    localfnr.fXb = this.fXb;
    localfnr.qLl = this.qLl;
    y.a.chL().a(localfnr);
    Log.i("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
    AppMethodBeat.o(48152);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48154);
    String str = "kv_14004{appId='" + this.appId + '\'' + ", sessionId='" + this.sessionId + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.fvd + '\'' + ", preScene=" + this.fXa + ", preSceneNote='" + this.fXb + '\'' + ", pagePath='" + this.fve + '\'' + ", usedState=" + this.qJF + ", appState=" + this.fvc + ", referPagePath='" + this.qLh + '\'' + ", isEntrance=" + this.qLl + '}';
    AppMethodBeat.o(48154);
    return str;
  }
  
  public final void v(ah paramah)
  {
    AppMethodBeat.i(48151);
    this.fve = paramah.qoI;
    paramah = this.qaN.q(paramah);
    if ((paramah != null) && (paramah.qKU != null))
    {
      paramah = paramah.qKU.path;
      this.qLh = paramah;
      if (!this.qaN.amH(this.fve)) {
        break label88;
      }
    }
    label88:
    for (int i = 1;; i = 0)
    {
      this.qLl = i;
      report();
      AppMethodBeat.o(48151);
      return;
      paramah = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.m
 * JD-Core Version:    0.7.0.1
 */