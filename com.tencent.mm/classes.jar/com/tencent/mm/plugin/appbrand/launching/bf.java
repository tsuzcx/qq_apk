package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.u;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class bf
  extends bb<Pair<WxaPkgWrappingInfo, List<WxaAttributes.WxaPluginCodeInfo>>>
{
  public static volatile boolean lnT = false;
  private final String appId;
  private List<WxaAttributes.WxaPluginCodeInfo> ccS;
  private final int hxM;
  private List<WxaAttributes.WxaWidgetInfo> jGc;
  final x lnU;
  private PBool lnV;
  private QualitySession lnW;
  private boolean lnX;
  
  bf(String paramString1, int paramInt1, String paramString2, int paramInt2, final WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean, ICommLibReader paramICommLibReader, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(180312);
    this.ccS = null;
    this.jGc = null;
    this.lnV = new PBool();
    this.lnX = false;
    this.appId = paramString1;
    this.hxM = paramInt1;
    this.lnW = paramQualitySession;
    this.lnV.value = false;
    Object localObject1;
    Object localObject5;
    Object localObject4;
    Object localObject3;
    int j;
    if (j.a.rq(paramInt1)) {
      if ((paramWxaVersionInfo.jFS) || ((lnT) && (!bs.gY(paramWxaVersionInfo.moduleList))))
      {
        i = 1;
        localObject1 = paramWxaVersionInfo.moduleList;
        localObject5 = paramWxaVersionInfo.jFT;
        localObject4 = paramWxaVersionInfo.jFQ;
        localObject3 = paramWxaVersionInfo.hVm;
        j = paramWxaVersionInfo.jFR;
      }
    }
    Object localObject6;
    for (;;)
    {
      localObject6 = w.a.lko;
      if (!w.a.a.gR(paramBoolean)) {
        break label401;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgHandlerSeparatedPluginsCompatible appId:%s,versionType:%d,isGame:%b", new Object[] { paramString1, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
      if (j.a.rq(paramInt1)) {
        j.aVC().a(paramString1, paramWxaVersionInfo);
      }
      this.lnU = new ag(paramString1, paramInt1, paramBoolean, paramString2, paramWxaVersionInfo, paramICommLibReader, paramQualitySession)
      {
        public final void bnc()
        {
          AppMethodBeat.i(47334);
          super.bnc();
          bf.this.bnc();
          AppMethodBeat.o(47334);
        }
        
        public final void onDownloadProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(47336);
          super.onDownloadProgress(paramAnonymousInt);
          bf.this.onDownloadProgress(paramAnonymousInt);
          AppMethodBeat.o(47336);
        }
      };
      AppMethodBeat.o(180312);
      return;
      i = 0;
      break;
      localObject1 = ((t)j.T(t.class)).bK(paramString1, paramInt1);
      try
      {
        localObject3 = h.tT((String)localObject1);
        if (localObject3 == null)
        {
          i = 0;
          localObject3 = null;
          localObject4 = null;
          localObject5 = null;
          localObject1 = null;
          j = 0;
          localObject6 = localObject4;
          localObject4 = localObject3;
          localObject3 = localObject1;
          localObject1 = localObject4;
          localObject4 = localObject5;
          localObject5 = localObject6;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject3 = null;
        }
        localObject6 = WxaAttributes.WxaVersionModuleInfo.Kz(((JSONObject)localObject3).optString("module_list"));
        localObject5 = WxaAttributes.WxaWidgetInfo.KA(((JSONObject)localObject3).optString("widget_list"));
        if (bs.gY((List)localObject6)) {
          break label388;
        }
      }
    }
    int i = 1;
    label339:
    if (i != 0) {}
    for (Object localObject2 = ((JSONObject)localObject3).optString("entrance_module");; localObject2 = "")
    {
      localObject3 = WxaAttributes.WxaPluginCodeInfo.a((List)localObject5, ((JSONObject)localObject3).optString("separated_plugin_list"), 22);
      localObject4 = localObject2;
      localObject2 = localObject5;
      localObject5 = localObject3;
      localObject3 = localObject6;
      break;
      label388:
      i = 0;
      break label339;
    }
    label401:
    if (paramBoolean)
    {
      int k;
      if (!bs.gY((List)localObject3))
      {
        boolean bool = ((b)g.ab(b.class)).a(b.a.pOp, true);
        if (bool)
        {
          k = 1;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.PkgABTest", "openMultiPluginCodeDownload exp:%d", new Object[] { Integer.valueOf(k) });
          if (!bool) {
            break label664;
          }
          paramICommLibReader = ((List)localObject3).iterator();
          while (paramICommLibReader.hasNext())
          {
            localObject6 = (WxaAttributes.WxaWidgetInfo)paramICommLibReader.next();
            if ((((WxaAttributes.WxaWidgetInfo)localObject6).dcj == 23) || (((WxaAttributes.WxaWidgetInfo)localObject6).dcj == 22))
            {
              k = 1;
              if (k == 0) {
                break label818;
              }
              if (i == 0) {
                break label754;
              }
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckMultiPkgInfoModuleHandler");
              paramICommLibReader = ((List)localObject2).iterator();
              while (paramICommLibReader.hasNext())
              {
                paramString2 = (WxaAttributes.WxaVersionModuleInfo)paramICommLibReader.next();
                if ((!bs.isNullOrNil(paramString2.name)) && (paramString2.name.equals("__APP__")))
                {
                  this.jGc = paramString2.jGc;
                  if (this.jGc != null) {
                    break label670;
                  }
                  this.ccS = paramString2.jGb;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        this.lnU = new ad(paramString1, paramInt1, paramWxaVersionInfo.aBM, paramQualitySession.lht, paramInt2, (List)localObject2, this.ccS, this.jGc, this.lnV)
        {
          public final void bnc()
          {
            AppMethodBeat.i(47337);
            super.bnc();
            bf.this.bnc();
            AppMethodBeat.o(47337);
          }
          
          public final void bnk()
          {
            AppMethodBeat.i(47338);
            super.bnk();
            bf.this.bnk();
            AppMethodBeat.o(47338);
          }
          
          public final void onDownloadProgress(int paramAnonymousInt)
          {
            AppMethodBeat.i(47339);
            bf.this.onDownloadProgress(paramAnonymousInt);
            AppMethodBeat.o(47339);
          }
        };
        AppMethodBeat.o(180312);
        return;
        k = 0;
        break;
        label664:
        k = 0;
        break label519;
        label670:
        paramICommLibReader = this.jGc.iterator();
        while (paramICommLibReader.hasNext())
        {
          localObject3 = (WxaAttributes.WxaWidgetInfo)paramICommLibReader.next();
          if (((WxaAttributes.WxaWidgetInfo)localObject3).dcj == 23) {
            this.ccS = ((WxaAttributes.WxaWidgetInfo)localObject3).jGf;
          }
        }
        if (this.ccS == null) {
          this.ccS = paramString2.jGb;
        } else {
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "multiPkg module widgetInfo true");
        }
      }
      label754:
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckMultiPkgInfoHandler");
      this.ccS = ((List)localObject4);
      this.jGc = ((List)localObject3);
      this.lnU = new ac(paramString1, paramInt1, paramWxaVersionInfo.aBM, paramQualitySession.lht, paramInt2, this.ccS, this.jGc, this.lnV)
      {
        public final void bnc()
        {
          AppMethodBeat.i(47340);
          super.bnc();
          bf.this.bnc();
          AppMethodBeat.o(47340);
        }
        
        public final void bnk()
        {
          AppMethodBeat.i(47341);
          super.bnk();
          bf.this.bnk();
          AppMethodBeat.o(47341);
        }
        
        public final void onDownloadProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(47342);
          bf.this.onDownloadProgress(paramAnonymousInt);
          AppMethodBeat.o(47342);
        }
      };
      AppMethodBeat.o(180312);
      return;
    }
    label519:
    label818:
    if ((paramBoolean) && (u.aWy()) && (localObject4 != null) && (((List)localObject4).size() > 0))
    {
      if ((i != 0) && (!bs.gY((List)localObject2)))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgSplitPluginCodeModuleHandler");
        paramString2 = ((List)localObject2).iterator();
        while (paramString2.hasNext())
        {
          paramICommLibReader = (WxaAttributes.WxaVersionModuleInfo)paramString2.next();
          if ((!bs.isNullOrNil(paramICommLibReader.name)) && (paramICommLibReader.name.equals("__APP__"))) {
            this.ccS = paramICommLibReader.jGb;
          }
        }
        this.lnU = new ak(paramString1, paramInt1, paramWxaVersionInfo.aBM, paramQualitySession.lht, paramInt2, (List)localObject2, this.ccS, this.lnV)
        {
          public final void bnc()
          {
            AppMethodBeat.i(47343);
            super.bnc();
            bf.this.bnc();
            AppMethodBeat.o(47343);
          }
          
          public final void bnk()
          {
            AppMethodBeat.i(47344);
            super.bnk();
            bf.this.bnk();
            AppMethodBeat.o(47344);
          }
          
          public final void onDownloadProgress(int paramAnonymousInt)
          {
            AppMethodBeat.i(47345);
            bf.this.onDownloadProgress(paramAnonymousInt);
            AppMethodBeat.o(47345);
          }
        };
        AppMethodBeat.o(180312);
        return;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgSplitPluginCodeHandler");
      this.ccS = ((List)localObject4);
      this.lnU = new aj(paramString1, paramInt1, paramWxaVersionInfo.aBM, paramQualitySession.lht, paramInt2, (List)localObject4, this.lnV)
      {
        public final void bnc()
        {
          AppMethodBeat.i(174997);
          super.bnc();
          bf.this.bnc();
          AppMethodBeat.o(174997);
        }
        
        public final void bnk()
        {
          AppMethodBeat.i(174998);
          super.bnk();
          bf.this.bnk();
          AppMethodBeat.o(174998);
        }
        
        public final void onDownloadProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(174999);
          bf.this.onDownloadProgress(paramAnonymousInt);
          AppMethodBeat.o(174999);
        }
      };
      AppMethodBeat.o(180312);
      return;
    }
    if ((i != 0) && (!bs.gY((List)localObject2)) && (u.aWx()))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "<init> use LaunchCheckPkgModularizingHandler");
      if (j.a.rq(paramInt1)) {
        j.aVC().a(paramString1, paramWxaVersionInfo);
      }
      this.lnU = new ai(paramString1, paramInt1, paramString2, paramInt2, paramWxaVersionInfo.aBM, j, (String)localObject5, (List)localObject2, paramQualitySession.lht)
      {
        public final WxaPkgWrappingInfo bcD()
        {
          AppMethodBeat.i(180310);
          bf.P(this.appId, this.hxM, paramWxaVersionInfo.aBM);
          WxaPkgWrappingInfo localWxaPkgWrappingInfo = super.bcD();
          AppMethodBeat.o(180310);
          return localWxaPkgWrappingInfo;
        }
        
        public final void bnc()
        {
          AppMethodBeat.i(175000);
          super.bnc();
          bf.this.bnc();
          AppMethodBeat.o(175000);
        }
        
        public final void bnk()
        {
          AppMethodBeat.i(175001);
          super.bnk();
          bf.this.bnk();
          AppMethodBeat.o(175001);
        }
        
        public final void onDownloadProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(175002);
          bf.this.onDownloadProgress(paramAnonymousInt);
          AppMethodBeat.o(175002);
        }
      };
      AppMethodBeat.o(180312);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgIntegratedHandler");
    this.lnU = new ah(paramString1, paramInt1, paramWxaVersionInfo.aBM, paramInt2, paramWxaVersionInfo, paramQualitySession.lht)
    {
      public final WxaPkgWrappingInfo bcD()
      {
        AppMethodBeat.i(186849);
        bf.P(this.appId, this.hxM, paramWxaVersionInfo.aBM);
        WxaPkgWrappingInfo localWxaPkgWrappingInfo = super.bcD();
        AppMethodBeat.o(186849);
        return localWxaPkgWrappingInfo;
      }
      
      public final void bnc()
      {
        AppMethodBeat.i(186850);
        bf.this.bnc();
        AppMethodBeat.o(186850);
      }
      
      public final void bnk()
      {
        AppMethodBeat.i(186851);
        bf.this.bnk();
        AppMethodBeat.o(186851);
      }
      
      public final void onDownloadProgress(int paramAnonymousInt)
      {
        AppMethodBeat.i(186852);
        bf.this.onDownloadProgress(paramAnonymousInt);
        AppMethodBeat.o(186852);
      }
    };
    AppMethodBeat.o(180312);
  }
  
  public final Pair<WxaPkgWrappingInfo, List<WxaAttributes.WxaPluginCodeInfo>> bnP()
  {
    AppMethodBeat.i(47348);
    long l1 = bs.eWj();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "call() before call real checkHandler");
    Object localObject = (WxaPkgWrappingInfo)this.lnU.call();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "call() finished split usePluginCode boolean:%b", new Object[] { Boolean.valueOf(this.lnV.value) });
    long l2 = bs.eWj();
    if (localObject != null) {
      if (this.lnX) {
        c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_Download, "", l1, l2);
      }
    }
    while (this.lnV.value)
    {
      localObject = Pair.create(localObject, this.ccS);
      AppMethodBeat.o(47348);
      return localObject;
      c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_DB, "", l1, l2);
      continue;
      if (this.lnX) {
        c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_Download, "", "", l1, l2);
      } else {
        c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_DB, "", "", l1, l2);
      }
    }
    localObject = Pair.create(localObject, null);
    AppMethodBeat.o(47348);
    return localObject;
  }
  
  public void bnc()
  {
    AppMethodBeat.i(186854);
    this.lnX = true;
    if (j.a.rq(this.hxM)) {
      y.aWC();
    }
    AppMethodBeat.o(186854);
  }
  
  public void bnk() {}
  
  public final void gS(boolean paramBoolean)
  {
    AppMethodBeat.i(180313);
    super.gS(paramBoolean);
    if ((this.lnU instanceof x.b))
    {
      ((x.b)this.lnU).gS(paramBoolean);
      AppMethodBeat.o(180313);
      return;
    }
    if ((this.lnU instanceof bb)) {
      ((bb)this.lnU).gS(paramBoolean);
    }
    AppMethodBeat.o(180313);
  }
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper";
  }
  
  public void onDownloadProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bf
 * JD-Core Version:    0.7.0.1
 */