package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.ab.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;

public final class p
{
  private static final p mub;
  public int aDD;
  public String appId;
  public int apptype;
  public int dJQ;
  public String dJR;
  public int dkg;
  public String dkh;
  public String dki;
  public o jxG;
  public long lFE;
  public int mrx;
  private final boolean msS;
  boolean msU;
  public String msV;
  public String msW;
  public int msX;
  public String msY;
  public int msZ;
  public int mta;
  public String mtb;
  private String muc;
  public final LinkedList<String> mud;
  public String mue;
  public boolean muf;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48183);
    mub = new p(true);
    AppMethodBeat.o(48183);
  }
  
  private p(boolean paramBoolean)
  {
    AppMethodBeat.i(48175);
    this.muc = "";
    this.mud = new LinkedList();
    this.msU = false;
    this.muf = true;
    this.msS = paramBoolean;
    AppMethodBeat.o(48175);
  }
  
  public static p a(o paramo, String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(48176);
    p localp = new p(false);
    localp.sessionId = paramString;
    paramString = paramo.Fb().cmC;
    localp.scene = paramString.scene;
    localp.dkh = paramString.dkh;
    localp.appId = paramo.mAppId;
    localp.jxG = paramo;
    if (paramo.aXb() == null) {
      localp.dkg = (paramo.jwG.dPf + 1);
    }
    for (localp.aDD = paramo.aXc().aDD;; localp.aDD = paramo.aXb().jYh.pkgVersion)
    {
      localp.mrx = paramString.mrx;
      localp.dJQ = paramString.dJQ;
      localp.dJR = paramString.dJR;
      localp.mud.addAll(paramLinkedList);
      AppMethodBeat.o(48176);
      return localp;
      localp.dkg = (paramo.aXb().jYh.jIU + 1);
    }
  }
  
  private void b(ae paramae, a parama)
  {
    AppMethodBeat.i(48180);
    Object localObject = paramae.getRuntime().aXb();
    if (localObject != null) {
      this.aDD = ((k)localObject).jYh.pkgVersion;
    }
    localObject = paramae.aVF();
    if (localObject != null) {
      this.msZ = ((ICommLibReader)localObject).aZp();
    }
    this.lFE = System.currentTimeMillis();
    localObject = parama.getWebView().getUrl();
    parama = (a)localObject;
    if (localObject == null) {
      parama = "";
    }
    this.mue = q.encode(parama);
    this.dki = paramae.kuf;
    this.mtb = paramae.lYf;
    this.msV = h.getNetworkType(aj.getContext());
    int i;
    if (this.muf)
    {
      i = 1;
      this.mta = i;
      this.muf = false;
      paramae = paramae.getRuntime();
      if (paramae != null) {
        break label179;
      }
      paramae = null;
      label144:
      if (paramae == null) {
        break label187;
      }
      this.apptype = paramae.cmr;
    }
    for (;;)
    {
      this.apptype += 1000;
      AppMethodBeat.o(48180);
      return;
      i = 0;
      break;
      label179:
      paramae = paramae.aXc();
      break label144;
      label187:
      this.apptype = i.Uj(this.appId);
      ad.i("MicroMsg.AppBrand.Report.kv_14992", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
  
  public static p bxL()
  {
    return mub;
  }
  
  private void report()
  {
    AppMethodBeat.i(48182);
    if (this.msS)
    {
      AppMethodBeat.o(48182);
      return;
    }
    ad.i("MicroMsg.AppBrand.Report.kv_14992", "report " + toString());
    p.1 local1 = new p.1(this, new Object[] { Integer.valueOf(this.scene), this.dkh, this.sessionId, this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dkg), Integer.valueOf(this.mrx), this.dki, this.mue, this.msV, this.msW, Integer.valueOf(this.msX), this.msY, Long.valueOf(this.lFE), Integer.valueOf(this.msZ), Integer.valueOf(this.dJQ), this.dJR, Integer.valueOf(this.mta), this.mtb, Integer.valueOf(this.apptype) });
    if (this.msU)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.dKl();
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
    e.bBp().postToWorker(localException);
    AppMethodBeat.o(48182);
  }
  
  public final void a(ae paramae, String paramString)
  {
    AppMethodBeat.i(48177);
    this.msW = ((String)this.mud.peekFirst());
    this.msX = 2;
    this.msY = paramString;
    this.mud.push(paramae.kuf);
    this.muc = paramae.kuf;
    x(paramae);
    AppMethodBeat.o(48177);
  }
  
  public final void a(ae paramae, boolean paramBoolean)
  {
    AppMethodBeat.i(48178);
    if (paramBoolean) {}
    for (int i = 1;; i = 7)
    {
      this.msX = i;
      String str = (String)this.mud.pollFirst();
      this.msY = str;
      this.msW = str;
      if (!paramBoolean) {
        this.msY = this.muc;
      }
      x(paramae);
      AppMethodBeat.o(48178);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48181);
    String str = "kv_4992{scene=" + this.scene + ", sceneNote='" + this.dkh + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.aDD + ", appState=" + this.dkg + ", usedState=" + this.mrx + ", pagePath='" + this.dki + '\'' + ", currentUrl='" + this.mue + '\'' + ", networkType='" + this.msV + '\'' + ", referPagePath='" + this.msW + '\'' + ", targetAction=" + this.msX + ", targetPagePath='" + this.msY + '\'' + ", clickTimestamp=" + this.lFE + ", publicLibVersion=" + this.msZ + ", preScene=" + this.dJQ + ", preSceneNote='" + this.dJR + '\'' + ", isEntrance=" + this.mta + ", apptype=" + this.apptype + '}';
    AppMethodBeat.o(48181);
    return str;
  }
  
  public final void x(ae paramae)
  {
    AppMethodBeat.i(48179);
    a locala = paramae.buV();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.p
 * JD-Core Version:    0.7.0.1
 */