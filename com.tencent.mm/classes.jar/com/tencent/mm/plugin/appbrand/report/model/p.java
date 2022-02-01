package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.ac.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;

public final class p
{
  private static final p myY;
  public int aDD;
  public String appId;
  public int apptype;
  public int dLf;
  public String dLg;
  public int dli;
  public String dlj;
  public String dlk;
  public com.tencent.mm.plugin.appbrand.p jAF;
  public long lKd;
  public int mwv;
  private final boolean mxP;
  boolean mxR;
  public String mxS;
  public String mxT;
  public int mxU;
  public String mxV;
  public int mxW;
  public int mxX;
  public String mxY;
  private String myZ;
  public final LinkedList<String> mza;
  public String mzb;
  public boolean mzc;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48183);
    myY = new p(true);
    AppMethodBeat.o(48183);
  }
  
  private p(boolean paramBoolean)
  {
    AppMethodBeat.i(48175);
    this.myZ = "";
    this.mza = new LinkedList();
    this.mxR = false;
    this.mzc = true;
    this.mxP = paramBoolean;
    AppMethodBeat.o(48175);
  }
  
  public static p a(com.tencent.mm.plugin.appbrand.p paramp, String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(48176);
    p localp = new p(false);
    localp.sessionId = paramString;
    paramString = paramp.Fg().cmE;
    localp.scene = paramString.scene;
    localp.dlj = paramString.dlj;
    localp.appId = paramp.mAppId;
    localp.jAF = paramp;
    if (paramp.aXw() == null) {
      localp.dli = (paramp.jzC.dQv + 1);
    }
    for (localp.aDD = paramp.aXx().aDD;; localp.aDD = paramp.aXw().kbw.pkgVersion)
    {
      localp.mwv = paramString.mwv;
      localp.dLf = paramString.dLf;
      localp.dLg = paramString.dLg;
      localp.mza.addAll(paramLinkedList);
      AppMethodBeat.o(48176);
      return localp;
      localp.dli = (paramp.aXw().kbw.jLV + 1);
    }
  }
  
  private void b(ad paramad, a parama)
  {
    AppMethodBeat.i(48180);
    Object localObject = paramad.getRuntime().aXw();
    if (localObject != null) {
      this.aDD = ((k)localObject).kbw.pkgVersion;
    }
    localObject = paramad.aWe();
    if (localObject != null) {
      this.mxW = ((ICommLibReader)localObject).aZM();
    }
    this.lKd = System.currentTimeMillis();
    localObject = parama.getWebView().getUrl();
    parama = (a)localObject;
    if (localObject == null) {
      parama = "";
    }
    this.mzb = q.encode(parama);
    this.dlk = paramad.kxv;
    this.mxY = paramad.mcM;
    this.mxS = h.getNetworkType(ak.getContext());
    int i;
    if (this.mzc)
    {
      i = 1;
      this.mxX = i;
      this.mzc = false;
      paramad = paramad.getRuntime();
      if (paramad != null) {
        break label179;
      }
      paramad = null;
      label144:
      if (paramad == null) {
        break label187;
      }
      this.apptype = paramad.cmt;
    }
    for (;;)
    {
      this.apptype += 1000;
      AppMethodBeat.o(48180);
      return;
      i = 0;
      break;
      label179:
      paramad = paramad.aXx();
      break label144;
      label187:
      this.apptype = i.UU(this.appId);
      ae.i("MicroMsg.AppBrand.Report.kv_14992", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
  
  public static p byE()
  {
    return myY;
  }
  
  private void report()
  {
    AppMethodBeat.i(48182);
    if (this.mxP)
    {
      AppMethodBeat.o(48182);
      return;
    }
    ae.i("MicroMsg.AppBrand.Report.kv_14992", "report " + toString());
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48173);
        for (;;)
        {
          try
          {
            str = (String)this.myb[18];
            if (!bu.isNullOrNil(str))
            {
              i = str.indexOf('?');
              if (i >= 0) {
                continue;
              }
              str = "";
              this.myb[18] = str;
            }
          }
          catch (Exception localException)
          {
            String str;
            int i;
            this.myb[18] = "";
            continue;
          }
          g.yxI.f(14992, com.tencent.mm.plugin.appbrand.report.p.k(this.myb));
          KVCommCrossProcessReceiver.dND();
          AppMethodBeat.o(48173);
          return;
          str = q.encode(str.substring(i + 1, str.length()));
        }
      }
    };
    if (this.mxR)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.dND();
        AppMethodBeat.o(48182);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14992", localException, "sendKV", new Object[0]);
        AppMethodBeat.o(48182);
        return;
      }
    }
    f.bCj().postToWorker(localException);
    AppMethodBeat.o(48182);
  }
  
  public final void a(ad paramad, String paramString)
  {
    AppMethodBeat.i(48177);
    this.mxT = ((String)this.mza.peekFirst());
    this.mxU = 2;
    this.mxV = paramString;
    this.mza.push(paramad.kxv);
    this.myZ = paramad.kxv;
    y(paramad);
    AppMethodBeat.o(48177);
  }
  
  public final void a(ad paramad, boolean paramBoolean)
  {
    AppMethodBeat.i(48178);
    if (paramBoolean) {}
    for (int i = 1;; i = 7)
    {
      this.mxU = i;
      String str = (String)this.mza.pollFirst();
      this.mxV = str;
      this.mxT = str;
      if (!paramBoolean) {
        this.mxV = this.myZ;
      }
      y(paramad);
      AppMethodBeat.o(48178);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48181);
    String str = "kv_4992{scene=" + this.scene + ", sceneNote='" + this.dlj + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.aDD + ", appState=" + this.dli + ", usedState=" + this.mwv + ", pagePath='" + this.dlk + '\'' + ", currentUrl='" + this.mzb + '\'' + ", networkType='" + this.mxS + '\'' + ", referPagePath='" + this.mxT + '\'' + ", targetAction=" + this.mxU + ", targetPagePath='" + this.mxV + '\'' + ", clickTimestamp=" + this.lKd + ", publicLibVersion=" + this.mxW + ", preScene=" + this.dLf + ", preSceneNote='" + this.dLg + '\'' + ", isEntrance=" + this.mxX + ", apptype=" + this.apptype + '}';
    AppMethodBeat.o(48181);
    return str;
  }
  
  public final void y(ad paramad)
  {
    AppMethodBeat.i(48179);
    a locala = paramad.bvG();
    if (locala == null)
    {
      AppMethodBeat.o(48179);
      return;
    }
    b(paramad, locala);
    report();
    AppMethodBeat.o(48179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.p
 * JD-Core Version:    0.7.0.1
 */