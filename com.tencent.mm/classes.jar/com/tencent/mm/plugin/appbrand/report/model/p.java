package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.z.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;

public final class p
{
  private static final p lsq;
  public int aAS;
  public String appId;
  public int apptype;
  public int dbs;
  public String dbt;
  public String dbu;
  public int dzS;
  public String dzT;
  public o iEx;
  public int lpL;
  private final boolean lrh;
  boolean lrj;
  public String lrk;
  public String lrl;
  public int lrm;
  public String lrn;
  public long lro;
  public int lrp;
  public int lrq;
  public String lrr;
  private String lsr;
  public final LinkedList<String> lss;
  public String lst;
  public boolean lsu;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48183);
    lsq = new p(true);
    AppMethodBeat.o(48183);
  }
  
  private p(boolean paramBoolean)
  {
    AppMethodBeat.i(48175);
    this.lsr = "";
    this.lss = new LinkedList();
    this.lrj = false;
    this.lsu = true;
    this.lrh = paramBoolean;
    AppMethodBeat.o(48175);
  }
  
  public static p a(o paramo, String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(48176);
    p localp = new p(false);
    localp.sessionId = paramString;
    paramString = paramo.DZ().cfo;
    localp.scene = paramString.scene;
    localp.dbt = paramString.dbt;
    localp.appId = paramo.mAppId;
    localp.iEx = paramo;
    if (paramo.aNb() == null) {
      localp.dbs = (paramo.iDx.iOP + 1);
    }
    for (localp.aAS = paramo.aNc().aAS;; localp.aAS = paramo.aNb().jdS.pkgVersion)
    {
      localp.lpL = paramString.lpL;
      localp.dzS = paramString.dzS;
      localp.dzT = paramString.dzT;
      localp.lss.addAll(paramLinkedList);
      AppMethodBeat.o(48176);
      return localp;
      localp.dbs = (paramo.aNb().jdS.iOQ + 1);
    }
  }
  
  private void b(ae paramae, a parama)
  {
    AppMethodBeat.i(48180);
    Object localObject = paramae.getRuntime().aNb();
    if (localObject != null) {
      this.aAS = ((k)localObject).jdS.pkgVersion;
    }
    localObject = paramae.aLC();
    if (localObject != null) {
      this.lrp = ((ICommLibReader)localObject).aPc();
    }
    this.lro = System.currentTimeMillis();
    localObject = parama.getWebView().getUrl();
    parama = (a)localObject;
    if (localObject == null) {
      parama = "";
    }
    this.lst = com.tencent.mm.compatible.util.p.encode(parama);
    this.dbu = paramae.jzm;
    this.lrr = paramae.kWX;
    this.lrk = com.tencent.mm.plugin.appbrand.report.h.getNetworkType(aj.getContext());
    int i;
    if (this.lsu)
    {
      i = 1;
      this.lrq = i;
      this.lsu = false;
      paramae = paramae.getRuntime();
      if (paramae != null) {
        break label179;
      }
      paramae = null;
      label144:
      if (paramae == null) {
        break label187;
      }
      this.apptype = paramae.cfd;
    }
    for (;;)
    {
      this.apptype += 1000;
      AppMethodBeat.o(48180);
      return;
      i = 0;
      break;
      label179:
      paramae = paramae.aNc();
      break label144;
      label187:
      this.apptype = i.Mu(this.appId);
      ad.i("MicroMsg.AppBrand.Report.kv_14992", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
  
  public static p bmK()
  {
    return lsq;
  }
  
  private void report()
  {
    AppMethodBeat.i(48182);
    if (this.lrh)
    {
      AppMethodBeat.o(48182);
      return;
    }
    ad.i("MicroMsg.AppBrand.Report.kv_14992", "report " + toString());
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48173);
        for (;;)
        {
          try
          {
            str = (String)this.lru[18];
            if (!bt.isNullOrNil(str))
            {
              i = str.indexOf('?');
              if (i >= 0) {
                continue;
              }
              str = "";
              this.lru[18] = str;
            }
          }
          catch (Exception localException)
          {
            String str;
            int i;
            this.lru[18] = "";
            continue;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(14992, com.tencent.mm.plugin.appbrand.report.p.k(this.lru));
          KVCommCrossProcessReceiver.dkK();
          AppMethodBeat.o(48173);
          return;
          str = com.tencent.mm.compatible.util.p.encode(str.substring(i + 1, str.length()));
        }
      }
    };
    if (this.lrj)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.dkK();
        AppMethodBeat.o(48182);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14992", localException, "sendKV", new Object[0]);
        AppMethodBeat.o(48182);
        return;
      }
    }
    e.bqm().postToWorker(localException);
    AppMethodBeat.o(48182);
  }
  
  public final void a(ae paramae, String paramString)
  {
    AppMethodBeat.i(48177);
    this.lrl = ((String)this.lss.peekFirst());
    this.lrm = 2;
    this.lrn = paramString;
    this.lss.push(paramae.jzm);
    this.lsr = paramae.jzm;
    w(paramae);
    AppMethodBeat.o(48177);
  }
  
  public final void a(ae paramae, boolean paramBoolean)
  {
    AppMethodBeat.i(48178);
    if (paramBoolean) {}
    for (int i = 1;; i = 7)
    {
      this.lrm = i;
      String str = (String)this.lss.pollFirst();
      this.lrn = str;
      this.lrl = str;
      if (!paramBoolean) {
        this.lrn = this.lsr;
      }
      w(paramae);
      AppMethodBeat.o(48178);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48181);
    String str = "kv_4992{scene=" + this.scene + ", sceneNote='" + this.dbt + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.aAS + ", appState=" + this.dbs + ", usedState=" + this.lpL + ", pagePath='" + this.dbu + '\'' + ", currentUrl='" + this.lst + '\'' + ", networkType='" + this.lrk + '\'' + ", referPagePath='" + this.lrl + '\'' + ", targetAction=" + this.lrm + ", targetPagePath='" + this.lrn + '\'' + ", clickTimestamp=" + this.lro + ", publicLibVersion=" + this.lrp + ", preScene=" + this.dzS + ", preSceneNote='" + this.dzT + '\'' + ", isEntrance=" + this.lrq + ", apptype=" + this.apptype + '}';
    AppMethodBeat.o(48181);
    return str;
  }
  
  public final void w(ae paramae)
  {
    AppMethodBeat.i(48179);
    a locala = paramae.bkd();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.p
 * JD-Core Version:    0.7.0.1
 */