package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class bi
  extends be<Pair<WxaPkgWrappingInfo, List<WxaAttributes.WxaPluginCodeInfo>>>
{
  public static volatile boolean lPL = false;
  private final String appId;
  private List<WxaAttributes.WxaPluginCodeInfo> cnk;
  private final int hSZ;
  private List<WxaAttributes.WxaWidgetInfo> kdC;
  final x lPM;
  private PBool lPN;
  private QualitySession lPO;
  private boolean lPP;
  
  bi(String paramString1, int paramInt1, String paramString2, int paramInt2, final WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean, ICommLibReader paramICommLibReader, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(180312);
    this.cnk = null;
    this.kdC = null;
    this.lPN = new PBool();
    this.lPP = false;
    this.appId = paramString1;
    this.hSZ = paramInt1;
    this.lPO = paramQualitySession;
    this.lPN.value = false;
    Object localObject1;
    Object localObject5;
    Object localObject4;
    Object localObject3;
    int j;
    if (j.a.rT(paramInt1)) {
      if ((paramWxaVersionInfo.kds) || ((lPL) && (!bu.ht(paramWxaVersionInfo.moduleList))))
      {
        i = 1;
        localObject1 = paramWxaVersionInfo.moduleList;
        localObject5 = paramWxaVersionInfo.kdt;
        localObject4 = paramWxaVersionInfo.kdq;
        localObject3 = paramWxaVersionInfo.irC;
        j = paramWxaVersionInfo.kdr;
      }
    }
    Object localObject6;
    for (;;)
    {
      localObject6 = w.a.lLW;
      if (!w.a.a.gY(paramBoolean)) {
        break label401;
      }
      ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgHandlerSeparatedPluginsCompatible appId:%s,versionType:%d,isGame:%b", new Object[] { paramString1, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
      if (j.a.rT(paramInt1)) {
        j.aZu().a(paramString1, paramWxaVersionInfo);
      }
      this.lPM = new ag(paramString1, paramInt1, paramBoolean, paramString2, paramWxaVersionInfo, paramICommLibReader, paramQualitySession)
      {
        public final void brx()
        {
          AppMethodBeat.i(47334);
          super.brx();
          bi.this.brx();
          AppMethodBeat.o(47334);
        }
        
        public final void onDownloadProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(47336);
          super.onDownloadProgress(paramAnonymousInt);
          bi.this.onDownloadProgress(paramAnonymousInt);
          AppMethodBeat.o(47336);
        }
      };
      AppMethodBeat.o(180312);
      return;
      i = 0;
      break;
      localObject1 = ((t)j.T(t.class)).bQ(paramString1, paramInt1);
      try
      {
        localObject3 = h.xs((String)localObject1);
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
        localObject6 = WxaAttributes.WxaVersionModuleInfo.Oz(((JSONObject)localObject3).optString("module_list"));
        localObject5 = WxaAttributes.WxaWidgetInfo.OA(((JSONObject)localObject3).optString("widget_list"));
        if (bu.ht((List)localObject6)) {
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
      if (!bu.ht((List)localObject3))
      {
        boolean bool = ((b)g.ab(b.class)).a(b.a.qzd, true);
        if (bool)
        {
          k = 1;
          ae.i("MicroMsg.PkgABTest", "openMultiPluginCodeDownload exp:%d", new Object[] { Integer.valueOf(k) });
          if (!bool) {
            break label664;
          }
          paramICommLibReader = ((List)localObject3).iterator();
          while (paramICommLibReader.hasNext())
          {
            localObject6 = (WxaAttributes.WxaWidgetInfo)paramICommLibReader.next();
            if ((((WxaAttributes.WxaWidgetInfo)localObject6).doK == 23) || (((WxaAttributes.WxaWidgetInfo)localObject6).doK == 22))
            {
              k = 1;
              if (k == 0) {
                break label818;
              }
              if (i == 0) {
                break label754;
              }
              ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckMultiPkgInfoModuleHandler");
              paramICommLibReader = ((List)localObject2).iterator();
              while (paramICommLibReader.hasNext())
              {
                paramString2 = (WxaAttributes.WxaVersionModuleInfo)paramICommLibReader.next();
                if ((!bu.isNullOrNil(paramString2.name)) && (paramString2.name.equals("__APP__")))
                {
                  this.kdC = paramString2.kdC;
                  if (this.kdC != null) {
                    break label670;
                  }
                  this.cnk = paramString2.kdB;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        this.lPM = new ad(paramString1, paramInt1, paramWxaVersionInfo.aDD, paramQualitySession.lIU, paramInt2, (List)localObject2, this.cnk, this.kdC, this.lPN)
        {
          public final void brG()
          {
            AppMethodBeat.i(47338);
            super.brG();
            bi.this.brG();
            AppMethodBeat.o(47338);
          }
          
          public final void brx()
          {
            AppMethodBeat.i(47337);
            super.brx();
            bi.this.brx();
            AppMethodBeat.o(47337);
          }
          
          public final void onDownloadProgress(int paramAnonymousInt)
          {
            AppMethodBeat.i(47339);
            bi.this.onDownloadProgress(paramAnonymousInt);
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
        paramICommLibReader = this.kdC.iterator();
        while (paramICommLibReader.hasNext())
        {
          localObject3 = (WxaAttributes.WxaWidgetInfo)paramICommLibReader.next();
          if (((WxaAttributes.WxaWidgetInfo)localObject3).doK == 23) {
            this.cnk = ((WxaAttributes.WxaWidgetInfo)localObject3).kdF;
          }
        }
        if (this.cnk == null) {
          this.cnk = paramString2.kdB;
        } else {
          ae.d("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "multiPkg module widgetInfo true");
        }
      }
      label754:
      ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckMultiPkgInfoHandler");
      this.cnk = ((List)localObject4);
      this.kdC = ((List)localObject3);
      this.lPM = new ac(paramString1, paramInt1, paramWxaVersionInfo.aDD, paramQualitySession.lIU, paramInt2, this.cnk, this.kdC, this.lPN)
      {
        public final void brG()
        {
          AppMethodBeat.i(47341);
          super.brG();
          bi.this.brG();
          AppMethodBeat.o(47341);
        }
        
        public final void brx()
        {
          AppMethodBeat.i(47340);
          super.brx();
          bi.this.brx();
          AppMethodBeat.o(47340);
        }
        
        public final void onDownloadProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(47342);
          bi.this.onDownloadProgress(paramAnonymousInt);
          AppMethodBeat.o(47342);
        }
      };
      AppMethodBeat.o(180312);
      return;
    }
    label519:
    label818:
    if ((paramBoolean) && (v.bas()) && (localObject4 != null) && (((List)localObject4).size() > 0))
    {
      if ((i != 0) && (!bu.ht((List)localObject2)))
      {
        ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgSplitPluginCodeModuleHandler");
        paramString2 = ((List)localObject2).iterator();
        while (paramString2.hasNext())
        {
          paramICommLibReader = (WxaAttributes.WxaVersionModuleInfo)paramString2.next();
          if ((!bu.isNullOrNil(paramICommLibReader.name)) && (paramICommLibReader.name.equals("__APP__"))) {
            this.cnk = paramICommLibReader.kdB;
          }
        }
        this.lPM = new ak(paramString1, paramInt1, paramWxaVersionInfo.aDD, paramQualitySession.lIU, paramInt2, (List)localObject2, this.cnk, this.lPN)
        {
          public final void brG()
          {
            AppMethodBeat.i(47344);
            super.brG();
            bi.this.brG();
            AppMethodBeat.o(47344);
          }
          
          public final void brx()
          {
            AppMethodBeat.i(47343);
            super.brx();
            bi.this.brx();
            AppMethodBeat.o(47343);
          }
          
          public final void onDownloadProgress(int paramAnonymousInt)
          {
            AppMethodBeat.i(47345);
            bi.this.onDownloadProgress(paramAnonymousInt);
            AppMethodBeat.o(47345);
          }
        };
        AppMethodBeat.o(180312);
        return;
      }
      ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgSplitPluginCodeHandler");
      this.cnk = ((List)localObject4);
      this.lPM = new aj(paramString1, paramInt1, paramWxaVersionInfo.aDD, paramQualitySession.lIU, paramInt2, (List)localObject4, this.lPN)
      {
        public final void brG()
        {
          AppMethodBeat.i(174998);
          super.brG();
          bi.this.brG();
          AppMethodBeat.o(174998);
        }
        
        public final void brx()
        {
          AppMethodBeat.i(174997);
          super.brx();
          bi.this.brx();
          AppMethodBeat.o(174997);
        }
        
        public final void onDownloadProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(174999);
          bi.this.onDownloadProgress(paramAnonymousInt);
          AppMethodBeat.o(174999);
        }
      };
      AppMethodBeat.o(180312);
      return;
    }
    if ((i != 0) && (!bu.ht((List)localObject2)) && (v.bar()))
    {
      ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "<init> use LaunchCheckPkgModularizingHandler");
      if (j.a.rT(paramInt1)) {
        j.aZu().a(paramString1, paramWxaVersionInfo);
      }
      this.lPM = new ai(paramString1, paramInt1, paramString2, paramInt2, paramWxaVersionInfo.aDD, j, (String)localObject5, (List)localObject2, paramQualitySession.lIU)
      {
        public final WxaPkgWrappingInfo bgP()
        {
          AppMethodBeat.i(180310);
          bi.R(this.appId, this.hSZ, paramWxaVersionInfo.aDD);
          WxaPkgWrappingInfo localWxaPkgWrappingInfo = super.bgP();
          AppMethodBeat.o(180310);
          return localWxaPkgWrappingInfo;
        }
        
        public final void brG()
        {
          AppMethodBeat.i(175001);
          super.brG();
          bi.this.brG();
          AppMethodBeat.o(175001);
        }
        
        public final void brx()
        {
          AppMethodBeat.i(175000);
          super.brx();
          bi.this.brx();
          AppMethodBeat.o(175000);
        }
        
        public final void onDownloadProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(175002);
          bi.this.onDownloadProgress(paramAnonymousInt);
          AppMethodBeat.o(175002);
        }
      };
      AppMethodBeat.o(180312);
      return;
    }
    ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgIntegratedHandler");
    this.lPM = new ah(paramString1, paramInt1, paramWxaVersionInfo.aDD, paramInt2, paramWxaVersionInfo, paramQualitySession.lIU)
    {
      public final WxaPkgWrappingInfo bgP()
      {
        AppMethodBeat.i(222789);
        bi.R(this.appId, this.hSZ, paramWxaVersionInfo.aDD);
        WxaPkgWrappingInfo localWxaPkgWrappingInfo = super.bgP();
        AppMethodBeat.o(222789);
        return localWxaPkgWrappingInfo;
      }
      
      public final void brG()
      {
        AppMethodBeat.i(222791);
        bi.this.brG();
        AppMethodBeat.o(222791);
      }
      
      public final void brx()
      {
        AppMethodBeat.i(222790);
        bi.this.brx();
        AppMethodBeat.o(222790);
      }
      
      public final void onDownloadProgress(int paramAnonymousInt)
      {
        AppMethodBeat.i(222792);
        bi.this.onDownloadProgress(paramAnonymousInt);
        AppMethodBeat.o(222792);
      }
    };
    AppMethodBeat.o(180312);
  }
  
  public void brG() {}
  
  public void brx()
  {
    AppMethodBeat.i(222794);
    this.lPP = true;
    if (j.a.rT(this.hSZ)) {
      aa.bax();
    }
    AppMethodBeat.o(222794);
  }
  
  public final Pair<WxaPkgWrappingInfo, List<WxaAttributes.WxaPluginCodeInfo>> bss()
  {
    AppMethodBeat.i(47348);
    long l1 = bu.fpO();
    ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "call() before call real checkHandler");
    Object localObject = (WxaPkgWrappingInfo)this.lPM.call();
    ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "call() finished split usePluginCode boolean:%b", new Object[] { Boolean.valueOf(this.lPN.value) });
    long l2 = bu.fpO();
    if (localObject != null) {
      if (this.lPP) {
        c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_Download, "", l1, l2);
      }
    }
    for (;;)
    {
      try
      {
        String str = this.lPO.lIU;
        if (localObject == null) {
          continue;
        }
        bool = true;
        av.b.b(str, bool, l2 - l1);
      }
      catch (Throwable localThrowable)
      {
        boolean bool;
        ae.e("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "call() reportUpdateResultAfterVersionFallbackIfNeed get exception %s", new Object[] { localThrowable });
        continue;
        localObject = Pair.create(localObject, null);
        AppMethodBeat.o(47348);
      }
      if (!this.lPN.value) {
        continue;
      }
      localObject = Pair.create(localObject, this.cnk);
      AppMethodBeat.o(47348);
      return localObject;
      c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_DB, "", l1, l2);
      continue;
      if (this.lPP)
      {
        c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_Download, "", "", l1, l2);
      }
      else
      {
        c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_DB, "", "", l1, l2);
        continue;
        bool = false;
      }
    }
    return localObject;
  }
  
  public final void gZ(boolean paramBoolean)
  {
    AppMethodBeat.i(180313);
    super.gZ(paramBoolean);
    if ((this.lPM instanceof x.b))
    {
      ((x.b)this.lPM).gZ(paramBoolean);
      AppMethodBeat.o(180313);
      return;
    }
    if ((this.lPM instanceof be)) {
      ((be)this.lPM).gZ(paramBoolean);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bi
 * JD-Core Version:    0.7.0.1
 */