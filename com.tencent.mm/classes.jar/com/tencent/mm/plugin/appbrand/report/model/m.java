package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.x;
import com.tencent.mm.plugin.appbrand.report.x.a;
import com.tencent.mm.protocal.protobuf.fcq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class m
{
  private static final m nJt;
  public String appId;
  public int dCv;
  public String dCw;
  public String dCx;
  public int ecU;
  public String ecV;
  public int nHt;
  private final boolean nIR;
  public String nIU;
  public int nIY;
  private final h nay;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48155);
    nJt = new m(true, h.nIG);
    AppMethodBeat.o(48155);
  }
  
  private m(boolean paramBoolean, h paramh)
  {
    this.nIR = paramBoolean;
    this.nay = paramh;
  }
  
  private static String aeR(String paramString)
  {
    AppMethodBeat.i(48153);
    String str = paramString;
    if (Util.nullAsNil(paramString).length() > 1024) {
      str = paramString.substring(0, 1024);
    }
    AppMethodBeat.o(48153);
    return str;
  }
  
  public static m b(q paramq, String paramString, h paramh)
  {
    AppMethodBeat.i(48150);
    paramh = new m(false, paramh);
    try
    {
      paramh.sessionId = paramString;
      paramh.appId = paramq.mAppId;
      paramString = paramq.ON().cyA;
      paramh.scene = paramString.scene;
      paramh.dCw = paramString.dCw;
      paramh.ecU = paramString.ecU;
      paramh.ecV = paramString.ecV;
      paramh.nHt = paramString.nHt;
      paramh.dCv = (paramq.bsC().eix + 1);
      AppMethodBeat.o(48150);
      return paramh;
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14004", paramq, "Kv_14004 protect the npe", new Object[0]);
      }
    }
  }
  
  public static m bUN()
  {
    return nJt;
  }
  
  private void report()
  {
    AppMethodBeat.i(48152);
    if (this.nIR)
    {
      AppMethodBeat.o(48152);
      return;
    }
    this.dCx = aeR(this.dCx);
    this.nIU = aeR(this.nIU);
    fcq localfcq = new fcq();
    localfcq.oUv = 1;
    localfcq.jfi = this.appId;
    localfcq.Nyw = this.dCx;
    localfcq.Cya = 0;
    localfcq.rBX = ((int)Util.nowSecond());
    localfcq.Cyb = 1;
    localfcq.Nyx = "";
    localfcq.LQr = this.dCv;
    localfcq.SessionId = this.sessionId;
    localfcq.Nyy = i.getNetworkType(MMApplicationContext.getContext());
    localfcq.IPh = this.scene;
    localfcq.Nyz = this.nHt;
    localfcq.Lru = this.dCw;
    localfcq.nIU = this.nIU;
    localfcq.ecU = this.ecU;
    localfcq.ecV = this.ecV;
    localfcq.nIY = this.nIY;
    x.a.bUB().a(localfcq);
    Log.i("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
    AppMethodBeat.o(48152);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48154);
    String str = "kv_14004{appId='" + this.appId + '\'' + ", sessionId='" + this.sessionId + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.dCw + '\'' + ", preScene=" + this.ecU + ", preSceneNote='" + this.ecV + '\'' + ", pagePath='" + this.dCx + '\'' + ", usedState=" + this.nHt + ", appState=" + this.dCv + ", referPagePath='" + this.nIU + '\'' + ", isEntrance=" + this.nIY + '}';
    AppMethodBeat.o(48154);
    return str;
  }
  
  public final void x(ag paramag)
  {
    AppMethodBeat.i(48151);
    this.dCx = paramag.nna;
    paramag = this.nay.s(paramag);
    if ((paramag != null) && (paramag.nII != null))
    {
      paramag = paramag.nII.path;
      this.nIU = paramag;
      if (!this.nay.aeN(this.dCx)) {
        break label88;
      }
    }
    label88:
    for (int i = 1;; i = 0)
    {
      this.nIY = i;
      report();
      AppMethodBeat.o(48151);
      return;
      paramag = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.m
 * JD-Core Version:    0.7.0.1
 */