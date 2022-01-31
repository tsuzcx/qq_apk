package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.u.a;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;

public final class o
{
  private static final o iId;
  public String appId;
  public int apptype;
  public int bDc;
  public int cJb;
  public String cJc;
  public int cmE;
  public String cmF;
  public String cmG;
  public String cpW;
  public com.tencent.mm.plugin.appbrand.o gQn;
  public int iFX;
  private final boolean iHd;
  boolean iHf;
  public String iHg;
  public String iHi;
  public int iHj;
  public String iHk;
  public long iHl;
  public int iHm;
  public int iHn;
  public String iHo;
  private String iIe;
  public final LinkedList<String> iIf;
  public String iIg;
  public boolean iIh;
  public int scene;
  
  static
  {
    AppMethodBeat.i(132674);
    iId = new o(true);
    AppMethodBeat.o(132674);
  }
  
  private o(boolean paramBoolean)
  {
    AppMethodBeat.i(132666);
    this.iIe = "";
    this.iIf = new LinkedList();
    this.iHf = false;
    this.iIh = true;
    this.iHd = paramBoolean;
    AppMethodBeat.o(132666);
  }
  
  private void IE()
  {
    AppMethodBeat.i(132673);
    if (this.iHd)
    {
      AppMethodBeat.o(132673);
      return;
    }
    ab.i("MicroMsg.AppBrand.Report.kv_14992", "report " + toString());
    o.1 local1 = new o.1(this, new Object[] { Integer.valueOf(this.scene), this.cmF, this.cpW, this.appId, Integer.valueOf(this.bDc), Integer.valueOf(this.cmE), Integer.valueOf(this.iFX), this.cmG, this.iIg, this.iHg, this.iHi, Integer.valueOf(this.iHj), this.iHk, Long.valueOf(this.iHl), Integer.valueOf(this.iHm), Integer.valueOf(this.cJb), this.cJc, Integer.valueOf(this.iHn), this.iHo, Integer.valueOf(this.apptype) });
    if (this.iHf)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.chN();
        AppMethodBeat.o(132673);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14992", localException, "sendKV", new Object[0]);
        AppMethodBeat.o(132673);
        return;
      }
    }
    com.tencent.mm.plugin.appbrand.t.e.aNS().ac(localException);
    AppMethodBeat.o(132673);
  }
  
  public static o a(com.tencent.mm.plugin.appbrand.o paramo, String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(132667);
    o localo = new o(false);
    localo.cpW = paramString;
    paramString = paramo.wS().bDh;
    localo.scene = paramString.scene;
    localo.cmF = paramString.cmF;
    localo.appId = paramo.mAppId;
    localo.gQn = paramo;
    if (paramo.atR() == null) {
      localo.cmE = (paramo.gPz.gXd + 1);
    }
    for (localo.bDc = paramo.atS().bDc;; localo.bDc = paramo.atR().hiX.gXf)
    {
      localo.iFX = paramString.iFX;
      localo.cJb = paramString.cJb;
      localo.cJc = paramString.cJc;
      localo.iIf.addAll(paramLinkedList);
      AppMethodBeat.o(132667);
      return localo;
      localo.cmE = (paramo.atR().hiX.gXe + 1);
    }
  }
  
  private void a(z paramz, a parama)
  {
    AppMethodBeat.i(132671);
    Object localObject = paramz.getRuntime().atR();
    if (localObject != null)
    {
      this.bDc = ((h)localObject).hiX.gXf;
      this.iHm = WxaCommLibRuntimeReader.avI().gXf;
    }
    this.iHl = System.currentTimeMillis();
    localObject = parama.getWebView().getUrl();
    parama = (a)localObject;
    if (localObject == null) {
      parama = "";
    }
    this.iIg = q.encode(parama);
    this.cmG = paramz.hzM;
    this.iHo = paramz.iuB;
    this.iHg = com.tencent.mm.plugin.appbrand.report.e.cZ(ah.getContext());
    int i;
    if (this.iIh)
    {
      i = 1;
      this.iHn = i;
      this.iIh = false;
      paramz = paramz.getRuntime();
      if (paramz != null) {
        break label169;
      }
      paramz = null;
      label133:
      if (paramz == null) {
        break label177;
      }
      this.apptype = paramz.bCV;
    }
    for (;;)
    {
      this.apptype += 1000;
      AppMethodBeat.o(132671);
      return;
      i = 0;
      break;
      label169:
      paramz = paramz.atS();
      break label133;
      label177:
      this.apptype = f.EE(this.appId);
      ab.i("MicroMsg.AppBrand.Report.kv_14992", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
  
  public static o aLs()
  {
    return iId;
  }
  
  public final void a(z paramz, String paramString)
  {
    AppMethodBeat.i(132668);
    this.iHi = ((String)this.iIf.peekFirst());
    this.iHj = 2;
    this.iHk = paramString;
    this.iIf.push(paramz.hzM);
    this.iIe = paramz.hzM;
    n(paramz);
    AppMethodBeat.o(132668);
  }
  
  public final void a(z paramz, boolean paramBoolean)
  {
    AppMethodBeat.i(132669);
    if (paramBoolean) {}
    for (int i = 1;; i = 7)
    {
      this.iHj = i;
      String str = (String)this.iIf.pollFirst();
      this.iHk = str;
      this.iHi = str;
      if (!paramBoolean) {
        this.iHk = this.iIe;
      }
      n(paramz);
      AppMethodBeat.o(132669);
      return;
    }
  }
  
  public final void n(z paramz)
  {
    AppMethodBeat.i(132670);
    a locala = paramz.aJz();
    if (locala == null)
    {
      AppMethodBeat.o(132670);
      return;
    }
    a(paramz, locala);
    IE();
    AppMethodBeat.o(132670);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(132672);
    String str = "kv_4992{scene=" + this.scene + ", sceneNote='" + this.cmF + '\'' + ", sessionId='" + this.cpW + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.bDc + ", appState=" + this.cmE + ", usedState=" + this.iFX + ", pagePath='" + this.cmG + '\'' + ", currentUrl='" + this.iIg + '\'' + ", networkType='" + this.iHg + '\'' + ", referPagePath='" + this.iHi + '\'' + ", targetAction=" + this.iHj + ", targetPagePath='" + this.iHk + '\'' + ", clickTimestamp=" + this.iHl + ", publicLibVersion=" + this.iHm + ", preScene=" + this.cJb + ", preSceneNote='" + this.cJc + '\'' + ", isEntrance=" + this.iHn + ", apptype=" + this.apptype + '}';
    AppMethodBeat.o(132672);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.o
 * JD-Core Version:    0.7.0.1
 */