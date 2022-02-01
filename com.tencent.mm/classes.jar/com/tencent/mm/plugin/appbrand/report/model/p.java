package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.z;
import com.tencent.mm.plugin.appbrand.report.z.a;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.protocal.protobuf.gkq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class p
{
  private static final p tQn;
  public String appId;
  public int hzw;
  public String hzx;
  public String hzy;
  public int icZ;
  public String ida;
  public int scene;
  public String sessionId;
  public int tOj;
  private final boolean tPL;
  public String tPO;
  public int tPS;
  private final j tfT;
  
  static
  {
    AppMethodBeat.i(48155);
    tQn = new p(true, j.tPx);
    AppMethodBeat.o(48155);
  }
  
  private p(boolean paramBoolean, j paramj)
  {
    this.tPL = paramBoolean;
    this.tfT = paramj;
  }
  
  private static String afX(String paramString)
  {
    AppMethodBeat.i(48153);
    String str = paramString;
    if (Util.nullAsNil(paramString).length() > 1024) {
      str = paramString.substring(0, 1024);
    }
    AppMethodBeat.o(48153);
    return str;
  }
  
  public static p b(w paramw, String paramString, j paramj)
  {
    AppMethodBeat.i(48150);
    paramj = new p(false, paramj);
    try
    {
      paramj.sessionId = paramString;
      paramj.appId = paramw.mAppId;
      paramString = paramw.asA().epn;
      paramj.scene = paramString.scene;
      paramj.hzx = paramString.hzx;
      paramj.icZ = paramString.icZ;
      paramj.ida = paramString.ida;
      paramj.tOj = paramString.tOj;
      paramj.hzw = (paramw.getInitConfig().eul + 1);
      AppMethodBeat.o(48150);
      return paramj;
    }
    catch (Exception paramw)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14004", paramw, "Kv_14004 protect the npe", new Object[0]);
      }
    }
  }
  
  public static p cIV()
  {
    return tQn;
  }
  
  private void report()
  {
    AppMethodBeat.i(48152);
    if (this.tPL)
    {
      AppMethodBeat.o(48152);
      return;
    }
    this.hzy = afX(this.hzy);
    this.tPO = afX(this.tPO);
    gkq localgkq = new gkq();
    localgkq.vhJ = 1;
    localgkq.oOI = this.appId;
    localgkq.acgt = this.hzy;
    localgkq.OzG = 0;
    localgkq.crm = ((int)Util.nowSecond());
    localgkq.OzH = 1;
    localgkq.acgu = "";
    localgkq.aalm = this.hzw;
    localgkq.SessionId = this.sessionId;
    localgkq.acgv = com.tencent.mm.plugin.appbrand.report.j.getNetworkType(MMApplicationContext.getContext());
    localgkq.WBK = this.scene;
    localgkq.acgw = this.tOj;
    localgkq.Zsa = this.hzx;
    localgkq.tPO = this.tPO;
    localgkq.icZ = this.icZ;
    localgkq.ida = this.ida;
    localgkq.tPS = this.tPS;
    z.a.cIG().a(localgkq);
    Log.i("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
    AppMethodBeat.o(48152);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48154);
    String str = "kv_14004{appId='" + this.appId + '\'' + ", sessionId='" + this.sessionId + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.hzx + '\'' + ", preScene=" + this.icZ + ", preSceneNote='" + this.ida + '\'' + ", pagePath='" + this.hzy + '\'' + ", usedState=" + this.tOj + ", appState=" + this.hzw + ", referPagePath='" + this.tPO + '\'' + ", isEntrance=" + this.tPS + '}';
    AppMethodBeat.o(48154);
    return str;
  }
  
  public final void x(ah paramah)
  {
    AppMethodBeat.i(48151);
    this.hzy = paramah.cEE();
    paramah = this.tfT.s(paramah);
    if ((paramah != null) && (paramah.tPz != null))
    {
      paramah = paramah.tPz.path;
      this.tPO = paramah;
      if (!this.tfT.afT(this.hzy)) {
        break label88;
      }
    }
    label88:
    for (int i = 1;; i = 0)
    {
      this.tPS = i;
      report();
      AppMethodBeat.o(48151);
      return;
      paramah = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.p
 * JD-Core Version:    0.7.0.1
 */