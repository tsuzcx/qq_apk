package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.u;
import com.tencent.mm.plugin.appbrand.appcache.z;
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
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class bi
  extends be<Pair<WxaPkgWrappingInfo, List<WxaAttributes.WxaPluginCodeInfo>>>
{
  public static volatile boolean lLl = false;
  private final String appId;
  private List<WxaAttributes.WxaPluginCodeInfo> cni;
  private final int hQh;
  private List<WxaAttributes.WxaWidgetInfo> kal;
  final x lLm;
  private PBool lLn;
  private QualitySession lLo;
  private boolean lLp;
  
  bi(String paramString1, int paramInt1, String paramString2, int paramInt2, final WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean, ICommLibReader paramICommLibReader, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(180312);
    this.cni = null;
    this.kal = null;
    this.lLn = new PBool();
    this.lLp = false;
    this.appId = paramString1;
    this.hQh = paramInt1;
    this.lLo = paramQualitySession;
    this.lLn.value = false;
    Object localObject1;
    Object localObject5;
    Object localObject4;
    Object localObject3;
    int j;
    if (j.a.rQ(paramInt1)) {
      if ((paramWxaVersionInfo.kab) || ((lLl) && (!bt.hj(paramWxaVersionInfo.moduleList))))
      {
        i = 1;
        localObject1 = paramWxaVersionInfo.moduleList;
        localObject5 = paramWxaVersionInfo.kac;
        localObject4 = paramWxaVersionInfo.jZZ;
        localObject3 = paramWxaVersionInfo.ioH;
        j = paramWxaVersionInfo.kaa;
      }
    }
    Object localObject6;
    for (;;)
    {
      localObject6 = w.a.lHw;
      if (!w.a.a.gY(paramBoolean)) {
        break label401;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgHandlerSeparatedPluginsCompatible appId:%s,versionType:%d,isGame:%b", new Object[] { paramString1, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
      if (j.a.rQ(paramInt1)) {
        j.aYX().a(paramString1, paramWxaVersionInfo);
      }
      this.lLm = new ag(paramString1, paramInt1, paramBoolean, paramString2, paramWxaVersionInfo, paramICommLibReader, paramQualitySession)
      {
        public final void bqN()
        {
          AppMethodBeat.i(47334);
          super.bqN();
          bi.this.bqN();
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
      localObject1 = ((t)j.T(t.class)).bN(paramString1, paramInt1);
      try
      {
        localObject3 = h.wJ((String)localObject1);
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
        localObject6 = WxaAttributes.WxaVersionModuleInfo.NS(((JSONObject)localObject3).optString("module_list"));
        localObject5 = WxaAttributes.WxaWidgetInfo.NT(((JSONObject)localObject3).optString("widget_list"));
        if (bt.hj((List)localObject6)) {
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
      if (!bt.hj((List)localObject3))
      {
        boolean bool = ((b)g.ab(b.class)).a(b.a.qso, true);
        if (bool)
        {
          k = 1;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PkgABTest", "openMultiPluginCodeDownload exp:%d", new Object[] { Integer.valueOf(k) });
          if (!bool) {
            break label664;
          }
          paramICommLibReader = ((List)localObject3).iterator();
          while (paramICommLibReader.hasNext())
          {
            localObject6 = (WxaAttributes.WxaWidgetInfo)paramICommLibReader.next();
            if ((((WxaAttributes.WxaWidgetInfo)localObject6).dnF == 23) || (((WxaAttributes.WxaWidgetInfo)localObject6).dnF == 22))
            {
              k = 1;
              if (k == 0) {
                break label818;
              }
              if (i == 0) {
                break label754;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckMultiPkgInfoModuleHandler");
              paramICommLibReader = ((List)localObject2).iterator();
              while (paramICommLibReader.hasNext())
              {
                paramString2 = (WxaAttributes.WxaVersionModuleInfo)paramICommLibReader.next();
                if ((!bt.isNullOrNil(paramString2.name)) && (paramString2.name.equals("__APP__")))
                {
                  this.kal = paramString2.kal;
                  if (this.kal != null) {
                    break label670;
                  }
                  this.cni = paramString2.kak;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        this.lLm = new ad(paramString1, paramInt1, paramWxaVersionInfo.aDD, paramQualitySession.lEv, paramInt2, (List)localObject2, this.cni, this.kal, this.lLn)
        {
          public final void bqN()
          {
            AppMethodBeat.i(47337);
            super.bqN();
            bi.this.bqN();
            AppMethodBeat.o(47337);
          }
          
          public final void bqW()
          {
            AppMethodBeat.i(47338);
            super.bqW();
            bi.this.bqW();
            AppMethodBeat.o(47338);
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
        paramICommLibReader = this.kal.iterator();
        while (paramICommLibReader.hasNext())
        {
          localObject3 = (WxaAttributes.WxaWidgetInfo)paramICommLibReader.next();
          if (((WxaAttributes.WxaWidgetInfo)localObject3).dnF == 23) {
            this.cni = ((WxaAttributes.WxaWidgetInfo)localObject3).kao;
          }
        }
        if (this.cni == null) {
          this.cni = paramString2.kak;
        } else {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "multiPkg module widgetInfo true");
        }
      }
      label754:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckMultiPkgInfoHandler");
      this.cni = ((List)localObject4);
      this.kal = ((List)localObject3);
      this.lLm = new ac(paramString1, paramInt1, paramWxaVersionInfo.aDD, paramQualitySession.lEv, paramInt2, this.cni, this.kal, this.lLn)
      {
        public final void bqN()
        {
          AppMethodBeat.i(47340);
          super.bqN();
          bi.this.bqN();
          AppMethodBeat.o(47340);
        }
        
        public final void bqW()
        {
          AppMethodBeat.i(47341);
          super.bqW();
          bi.this.bqW();
          AppMethodBeat.o(47341);
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
    if ((paramBoolean) && (u.aZT()) && (localObject4 != null) && (((List)localObject4).size() > 0))
    {
      if ((i != 0) && (!bt.hj((List)localObject2)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgSplitPluginCodeModuleHandler");
        paramString2 = ((List)localObject2).iterator();
        while (paramString2.hasNext())
        {
          paramICommLibReader = (WxaAttributes.WxaVersionModuleInfo)paramString2.next();
          if ((!bt.isNullOrNil(paramICommLibReader.name)) && (paramICommLibReader.name.equals("__APP__"))) {
            this.cni = paramICommLibReader.kak;
          }
        }
        this.lLm = new ak(paramString1, paramInt1, paramWxaVersionInfo.aDD, paramQualitySession.lEv, paramInt2, (List)localObject2, this.cni, this.lLn)
        {
          public final void bqN()
          {
            AppMethodBeat.i(47343);
            super.bqN();
            bi.this.bqN();
            AppMethodBeat.o(47343);
          }
          
          public final void bqW()
          {
            AppMethodBeat.i(47344);
            super.bqW();
            bi.this.bqW();
            AppMethodBeat.o(47344);
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgSplitPluginCodeHandler");
      this.cni = ((List)localObject4);
      this.lLm = new aj(paramString1, paramInt1, paramWxaVersionInfo.aDD, paramQualitySession.lEv, paramInt2, (List)localObject4, this.lLn)
      {
        public final void bqN()
        {
          AppMethodBeat.i(174997);
          super.bqN();
          bi.this.bqN();
          AppMethodBeat.o(174997);
        }
        
        public final void bqW()
        {
          AppMethodBeat.i(174998);
          super.bqW();
          bi.this.bqW();
          AppMethodBeat.o(174998);
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
    if ((i != 0) && (!bt.hj((List)localObject2)) && (u.aZS()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "<init> use LaunchCheckPkgModularizingHandler");
      if (j.a.rQ(paramInt1)) {
        j.aYX().a(paramString1, paramWxaVersionInfo);
      }
      this.lLm = new ai(paramString1, paramInt1, paramString2, paramInt2, paramWxaVersionInfo.aDD, j, (String)localObject5, (List)localObject2, paramQualitySession.lEv)
      {
        public final WxaPkgWrappingInfo bgh()
        {
          AppMethodBeat.i(180310);
          bi.R(this.appId, this.hQh, paramWxaVersionInfo.aDD);
          WxaPkgWrappingInfo localWxaPkgWrappingInfo = super.bgh();
          AppMethodBeat.o(180310);
          return localWxaPkgWrappingInfo;
        }
        
        public final void bqN()
        {
          AppMethodBeat.i(175000);
          super.bqN();
          bi.this.bqN();
          AppMethodBeat.o(175000);
        }
        
        public final void bqW()
        {
          AppMethodBeat.i(175001);
          super.bqW();
          bi.this.bqW();
          AppMethodBeat.o(175001);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgIntegratedHandler");
    this.lLm = new ah(paramString1, paramInt1, paramWxaVersionInfo.aDD, paramInt2, paramWxaVersionInfo, paramQualitySession.lEv)
    {
      public final WxaPkgWrappingInfo bgh()
      {
        AppMethodBeat.i(188630);
        bi.R(this.appId, this.hQh, paramWxaVersionInfo.aDD);
        WxaPkgWrappingInfo localWxaPkgWrappingInfo = super.bgh();
        AppMethodBeat.o(188630);
        return localWxaPkgWrappingInfo;
      }
      
      public final void bqN()
      {
        AppMethodBeat.i(188631);
        bi.this.bqN();
        AppMethodBeat.o(188631);
      }
      
      public final void bqW()
      {
        AppMethodBeat.i(188632);
        bi.this.bqW();
        AppMethodBeat.o(188632);
      }
      
      public final void onDownloadProgress(int paramAnonymousInt)
      {
        AppMethodBeat.i(188633);
        bi.this.onDownloadProgress(paramAnonymousInt);
        AppMethodBeat.o(188633);
      }
    };
    AppMethodBeat.o(180312);
  }
  
  public void bqN()
  {
    AppMethodBeat.i(188635);
    this.lLp = true;
    if (j.a.rQ(this.hQh)) {
      z.aZY();
    }
    AppMethodBeat.o(188635);
  }
  
  public void bqW() {}
  
  public final Pair<WxaPkgWrappingInfo, List<WxaAttributes.WxaPluginCodeInfo>> brH()
  {
    AppMethodBeat.i(47348);
    long l1 = bt.flT();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "call() before call real checkHandler");
    Object localObject = (WxaPkgWrappingInfo)this.lLm.call();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "call() finished split usePluginCode boolean:%b", new Object[] { Boolean.valueOf(this.lLn.value) });
    long l2 = bt.flT();
    if (localObject != null) {
      if (this.lLp) {
        c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_Download, "", l1, l2);
      }
    }
    for (;;)
    {
      try
      {
        String str = this.lLo.lEv;
        if (localObject == null) {
          continue;
        }
        bool = true;
        av.b.b(str, bool, l2 - l1);
      }
      catch (Throwable localThrowable)
      {
        boolean bool;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "call() reportUpdateResultAfterVersionFallbackIfNeed get exception %s", new Object[] { localThrowable });
        continue;
        localObject = Pair.create(localObject, null);
        AppMethodBeat.o(47348);
      }
      if (!this.lLn.value) {
        continue;
      }
      localObject = Pair.create(localObject, this.cni);
      AppMethodBeat.o(47348);
      return localObject;
      c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_DB, "", l1, l2);
      continue;
      if (this.lLp)
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
    if ((this.lLm instanceof x.b))
    {
      ((x.b)this.lLm).gZ(paramBoolean);
      AppMethodBeat.o(180313);
      return;
    }
    if ((this.lLm instanceof be)) {
      ((be)this.lLm).gZ(paramBoolean);
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