package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.y.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;

public final class p
{
  private static final p lUk;
  public int aBM;
  public String appId;
  public int apptype;
  public int cYO;
  public String cYP;
  public String cYQ;
  public int dxE;
  public String dxF;
  public com.tencent.mm.plugin.appbrand.o jez;
  public int lRH;
  private final boolean lTc;
  boolean lTe;
  public String lTf;
  public String lTg;
  public int lTh;
  public String lTi;
  public long lTj;
  public int lTk;
  public int lTl;
  public String lTm;
  private String lUl;
  public final LinkedList<String> lUm;
  public String lUn;
  public boolean lUo;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48183);
    lUk = new p(true);
    AppMethodBeat.o(48183);
  }
  
  private p(boolean paramBoolean)
  {
    AppMethodBeat.i(48175);
    this.lUl = "";
    this.lUm = new LinkedList();
    this.lTe = false;
    this.lUo = true;
    this.lTc = paramBoolean;
    AppMethodBeat.o(48175);
  }
  
  public static p a(com.tencent.mm.plugin.appbrand.o paramo, String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(48176);
    p localp = new p(false);
    localp.sessionId = paramString;
    paramString = paramo.DC().ccl;
    localp.scene = paramString.scene;
    localp.cYP = paramString.cYP;
    localp.appId = paramo.mAppId;
    localp.jez = paramo;
    if (paramo.aTR() == null) {
      localp.cYO = (paramo.jdx.joY + 1);
    }
    for (localp.aBM = paramo.aTS().aBM;; localp.aBM = paramo.aTR().jEg.pkgVersion)
    {
      localp.lRH = paramString.lRH;
      localp.dxE = paramString.dxE;
      localp.dxF = paramString.dxF;
      localp.lUm.addAll(paramLinkedList);
      AppMethodBeat.o(48176);
      return localp;
      localp.cYO = (paramo.aTR().jEg.jpa + 1);
    }
  }
  
  private void b(ae paramae, a parama)
  {
    AppMethodBeat.i(48180);
    Object localObject = paramae.getRuntime().aTR();
    if (localObject != null) {
      this.aBM = ((k)localObject).jEg.pkgVersion;
    }
    localObject = paramae.aSt();
    if (localObject != null) {
      this.lTk = ((ICommLibReader)localObject).aVU();
    }
    this.lTj = System.currentTimeMillis();
    localObject = parama.getWebView().getUrl();
    parama = (a)localObject;
    if (localObject == null) {
      parama = "";
    }
    this.lUn = com.tencent.mm.compatible.util.p.encode(parama);
    this.cYQ = paramae.jZJ;
    this.lTm = paramae.lyH;
    this.lTf = g.getNetworkType(ai.getContext());
    int i;
    if (this.lUo)
    {
      i = 1;
      this.lTl = i;
      this.lUo = false;
      paramae = paramae.getRuntime();
      if (paramae != null) {
        break label179;
      }
      paramae = null;
      label144:
      if (paramae == null) {
        break label187;
      }
      this.apptype = paramae.cca;
    }
    for (;;)
    {
      this.apptype += 1000;
      AppMethodBeat.o(48180);
      return;
      i = 0;
      break;
      label179:
      paramae = paramae.aTS();
      break label144;
      label187:
      this.apptype = com.tencent.mm.plugin.appbrand.report.h.QD(this.appId);
      ac.i("MicroMsg.AppBrand.Report.kv_14992", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
  
  public static p btG()
  {
    return lUk;
  }
  
  private void report()
  {
    AppMethodBeat.i(48182);
    if (this.lTc)
    {
      AppMethodBeat.o(48182);
      return;
    }
    ac.i("MicroMsg.AppBrand.Report.kv_14992", "report " + toString());
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48173);
        for (;;)
        {
          try
          {
            str = (String)this.lTp[18];
            if (!bs.isNullOrNil(str))
            {
              i = str.indexOf('?');
              if (i >= 0) {
                continue;
              }
              str = "";
              this.lTp[18] = str;
            }
          }
          catch (Exception localException)
          {
            String str;
            int i;
            this.lTp[18] = "";
            continue;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(14992, com.tencent.mm.plugin.appbrand.report.o.l(this.lTp));
          KVCommCrossProcessReceiver.dyN();
          AppMethodBeat.o(48173);
          return;
          str = com.tencent.mm.compatible.util.p.encode(str.substring(i + 1, str.length()));
        }
      }
    };
    if (this.lTe)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.dyN();
        AppMethodBeat.o(48182);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14992", localException, "sendKV", new Object[0]);
        AppMethodBeat.o(48182);
        return;
      }
    }
    e.bxj().postToWorker(localException);
    AppMethodBeat.o(48182);
  }
  
  public final void a(ae paramae, String paramString)
  {
    AppMethodBeat.i(48177);
    this.lTg = ((String)this.lUm.peekFirst());
    this.lTh = 2;
    this.lTi = paramString;
    this.lUm.push(paramae.jZJ);
    this.lUl = paramae.jZJ;
    w(paramae);
    AppMethodBeat.o(48177);
  }
  
  public final void a(ae paramae, boolean paramBoolean)
  {
    AppMethodBeat.i(48178);
    if (paramBoolean) {}
    for (int i = 1;; i = 7)
    {
      this.lTh = i;
      String str = (String)this.lUm.pollFirst();
      this.lTi = str;
      this.lTg = str;
      if (!paramBoolean) {
        this.lTi = this.lUl;
      }
      w(paramae);
      AppMethodBeat.o(48178);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48181);
    String str = "kv_4992{scene=" + this.scene + ", sceneNote='" + this.cYP + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.aBM + ", appState=" + this.cYO + ", usedState=" + this.lRH + ", pagePath='" + this.cYQ + '\'' + ", currentUrl='" + this.lUn + '\'' + ", networkType='" + this.lTf + '\'' + ", referPagePath='" + this.lTg + '\'' + ", targetAction=" + this.lTh + ", targetPagePath='" + this.lTi + '\'' + ", clickTimestamp=" + this.lTj + ", publicLibVersion=" + this.lTk + ", preScene=" + this.dxE + ", preSceneNote='" + this.dxF + '\'' + ", isEntrance=" + this.lTl + ", apptype=" + this.apptype + '}';
    AppMethodBeat.o(48181);
    return str;
  }
  
  public final void w(ae paramae)
  {
    AppMethodBeat.i(48179);
    a locala = paramae.bqU();
    if (locala == null)
    {
      AppMethodBeat.o(48179);
      return;
    }
    b(paramae, locala);
    report();
    AppMethodBeat.o(48179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.p
 * JD-Core Version:    0.7.0.1
 */