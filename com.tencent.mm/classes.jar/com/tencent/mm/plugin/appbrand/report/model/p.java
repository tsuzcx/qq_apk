package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.af.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.s;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;

public final class p
{
  private static final p nJZ;
  public String appId;
  public int appVersion;
  public int apptype;
  public int dCv;
  public String dCw;
  public String dCx;
  public int ecU;
  public String ecV;
  public com.tencent.mm.plugin.appbrand.q kBw;
  public long mRS;
  public int nHt;
  private final boolean nIR;
  boolean nIT;
  public String nIU;
  public int nIV;
  public String nIW;
  public int nIX;
  public int nIY;
  public String nIZ;
  private String nKa;
  public final LinkedList<String> nKb;
  public String nKc;
  public boolean nKd;
  public String networkType;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48183);
    nJZ = new p(true);
    AppMethodBeat.o(48183);
  }
  
  private p(boolean paramBoolean)
  {
    AppMethodBeat.i(48175);
    this.nKa = "";
    this.nKb = new LinkedList();
    this.nIT = false;
    this.nKd = true;
    this.nIR = paramBoolean;
    AppMethodBeat.o(48175);
  }
  
  public static p a(com.tencent.mm.plugin.appbrand.q paramq, String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(48176);
    p localp = new p(false);
    localp.sessionId = paramString;
    paramString = paramq.ON().cyA;
    localp.scene = paramString.scene;
    localp.dCw = paramString.dCw;
    localp.appId = paramq.mAppId;
    localp.kBw = paramq;
    if (paramq.bsB() == null) {
      localp.dCv = (paramq.kAq.eix + 1);
    }
    for (localp.appVersion = paramq.bsC().appVersion;; localp.appVersion = paramq.bsB().leE.pkgVersion)
    {
      localp.nHt = paramString.nHt;
      localp.ecU = paramString.ecU;
      localp.ecV = paramString.ecV;
      localp.nKb.addAll(paramLinkedList);
      AppMethodBeat.o(48176);
      return localp;
      localp.dCv = (paramq.bsB().leE.kNW + 1);
    }
  }
  
  private void b(ag paramag, a parama)
  {
    AppMethodBeat.i(48180);
    Object localObject = paramag.getRuntime().bsB();
    if (localObject != null) {
      this.appVersion = ((l)localObject).leE.pkgVersion;
    }
    localObject = paramag.bqZ();
    if (localObject != null) {
      this.nIX = ((ICommLibReader)localObject).bvd();
    }
    this.mRS = System.currentTimeMillis();
    localObject = parama.getWebView().getUrl();
    parama = (a)localObject;
    if (localObject == null) {
      parama = "";
    }
    this.nKc = com.tencent.mm.compatible.util.q.encode(parama);
    this.dCx = paramag.lBI;
    this.nIZ = paramag.nna;
    this.networkType = i.getNetworkType(MMApplicationContext.getContext());
    int i;
    if (this.nKd)
    {
      i = 1;
      this.nIY = i;
      this.nKd = false;
      paramag = paramag.getRuntime();
      if (paramag != null) {
        break label179;
      }
      paramag = null;
      label144:
      if (paramag == null) {
        break label187;
      }
      this.apptype = paramag.cyo;
    }
    for (;;)
    {
      this.apptype += 1000;
      AppMethodBeat.o(48180);
      return;
      i = 0;
      break;
      label179:
      paramag = paramag.bsC();
      break label144;
      label187:
      this.apptype = j.aeJ(this.appId);
      Log.i("MicroMsg.AppBrand.Report.kv_14992", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
  
  public static p bUW()
  {
    return nJZ;
  }
  
  private void report()
  {
    AppMethodBeat.i(48182);
    if (this.nIR)
    {
      AppMethodBeat.o(48182);
      return;
    }
    Log.i("MicroMsg.AppBrand.Report.kv_14992", "report " + toString());
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48173);
        for (;;)
        {
          try
          {
            str = (String)this.nJc[18];
            if (!Util.isNullOrNil(str))
            {
              i = str.indexOf('?');
              if (i >= 0) {
                continue;
              }
              str = "";
              this.nJc[18] = str;
            }
          }
          catch (Exception localException)
          {
            String str;
            int i;
            this.nJc[18] = "";
            continue;
          }
          h.CyF.a(14992, s.k(this.nJc));
          KVCommCrossProcessReceiver.eOD();
          AppMethodBeat.o(48173);
          return;
          str = com.tencent.mm.compatible.util.q.encode(str.substring(i + 1, str.length()));
        }
      }
    };
    if (this.nIT)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.eOD();
        AppMethodBeat.o(48182);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14992", localException, "sendKV", new Object[0]);
        AppMethodBeat.o(48182);
        return;
      }
    }
    f.bZn().postToWorker(localException);
    AppMethodBeat.o(48182);
  }
  
  public final void a(ag paramag, String paramString)
  {
    AppMethodBeat.i(48177);
    this.nIU = ((String)this.nKb.peekFirst());
    this.nIV = 2;
    this.nIW = paramString;
    this.nKb.push(paramag.lBI);
    this.nKa = paramag.lBI;
    y(paramag);
    AppMethodBeat.o(48177);
  }
  
  public final void a(ag paramag, boolean paramBoolean)
  {
    AppMethodBeat.i(48178);
    if (paramBoolean) {}
    for (int i = 1;; i = 7)
    {
      this.nIV = i;
      String str = (String)this.nKb.pollFirst();
      this.nIW = str;
      this.nIU = str;
      if (!paramBoolean) {
        this.nIW = this.nKa;
      }
      y(paramag);
      AppMethodBeat.o(48178);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48181);
    String str = "kv_4992{scene=" + this.scene + ", sceneNote='" + this.dCw + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.dCv + ", usedState=" + this.nHt + ", pagePath='" + this.dCx + '\'' + ", currentUrl='" + this.nKc + '\'' + ", networkType='" + this.networkType + '\'' + ", referPagePath='" + this.nIU + '\'' + ", targetAction=" + this.nIV + ", targetPagePath='" + this.nIW + '\'' + ", clickTimestamp=" + this.mRS + ", publicLibVersion=" + this.nIX + ", preScene=" + this.ecU + ", preSceneNote='" + this.ecV + '\'' + ", isEntrance=" + this.nIY + ", apptype=" + this.apptype + '}';
    AppMethodBeat.o(48181);
    return str;
  }
  
  public final void y(ag paramag)
  {
    AppMethodBeat.i(48179);
    a locala = paramag.bRM();
    if (locala == null)
    {
      AppMethodBeat.o(48179);
      return;
    }
    b(paramag, locala);
    report();
    AppMethodBeat.o(48179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.p
 * JD-Core Version:    0.7.0.1
 */