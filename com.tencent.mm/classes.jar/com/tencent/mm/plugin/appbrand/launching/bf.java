package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
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
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class bf
  extends bb<Pair<WxaPkgWrappingInfo, List<WxaAttributes.WxaPluginCodeInfo>>>
{
  public static volatile boolean kMw = false;
  private final String appId;
  private List<WxaAttributes.WxaPluginCodeInfo> cfV;
  private final int gXn;
  private List<WxaAttributes.WxaWidgetInfo> jfN;
  private boolean kMA;
  final x kMx;
  private PBool kMy;
  private QualitySession kMz;
  
  bf(String paramString1, int paramInt1, String paramString2, int paramInt2, final WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean, ICommLibReader paramICommLibReader, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(180312);
    this.cfV = null;
    this.jfN = null;
    this.kMy = new PBool();
    this.kMA = false;
    this.appId = paramString1;
    this.gXn = paramInt1;
    this.kMz = paramQualitySession;
    this.kMy.value = false;
    Object localObject1;
    Object localObject5;
    Object localObject4;
    Object localObject3;
    int j;
    if (j.a.qD(paramInt1)) {
      if ((paramWxaVersionInfo.jfD) || ((kMw) && (!bt.gL(paramWxaVersionInfo.moduleList))))
      {
        i = 1;
        localObject1 = paramWxaVersionInfo.moduleList;
        localObject5 = paramWxaVersionInfo.jfE;
        localObject4 = paramWxaVersionInfo.jfB;
        localObject3 = paramWxaVersionInfo.huK;
        j = paramWxaVersionInfo.jfC;
      }
    }
    Object localObject6;
    for (;;)
    {
      localObject6 = w.a.kIS;
      if (!w.a.a.gu(paramBoolean)) {
        break label384;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgHandlerSeparatedPluginsCompatible appId:%s,versionType:%d,isGame:%b", new Object[] { paramString1, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
      this.kMx = new ag(paramString1, paramInt1, paramBoolean, paramString2, paramWxaVersionInfo, paramICommLibReader, paramQualitySession)
      {
        public final void bgi()
        {
          AppMethodBeat.i(47334);
          super.bgi();
          bf.this.bgi();
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
      localObject1 = ((t)j.T(t.class)).bG(paramString1, paramInt1);
      try
      {
        localObject3 = h.qE((String)localObject1);
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
        localObject6 = WxaAttributes.WxaVersionModuleInfo.Gv(((JSONObject)localObject3).optString("module_list"));
        localObject5 = WxaAttributes.WxaWidgetInfo.Gw(((JSONObject)localObject3).optString("widget_list"));
        if (bt.gL((List)localObject6)) {
          break label371;
        }
      }
    }
    int i = 1;
    label322:
    if (i != 0) {}
    for (Object localObject2 = ((JSONObject)localObject3).optString("entrance_module");; localObject2 = "")
    {
      localObject3 = WxaAttributes.WxaPluginCodeInfo.a((List)localObject5, ((JSONObject)localObject3).optString("separated_plugin_list"), 22);
      localObject4 = localObject2;
      localObject2 = localObject5;
      localObject5 = localObject3;
      localObject3 = localObject6;
      break;
      label371:
      i = 0;
      break label322;
    }
    label384:
    if (paramBoolean)
    {
      int k;
      if (!bt.gL((List)localObject3))
      {
        boolean bool = ((b)g.ab(b.class)).a(b.a.pkY, true);
        if (bool)
        {
          k = 1;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PkgABTest", "openMultiPluginCodeDownload exp:%d", new Object[] { Integer.valueOf(k) });
          if (!bool) {
            break label646;
          }
          paramICommLibReader = ((List)localObject3).iterator();
          while (paramICommLibReader.hasNext())
          {
            localObject6 = (WxaAttributes.WxaWidgetInfo)paramICommLibReader.next();
            if ((((WxaAttributes.WxaWidgetInfo)localObject6).deP == 23) || (((WxaAttributes.WxaWidgetInfo)localObject6).deP == 22))
            {
              k = 1;
              label502:
              if (k == 0) {
                break label800;
              }
              if (i == 0) {
                break label736;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckMultiPkgInfoModuleHandler");
              paramICommLibReader = ((List)localObject2).iterator();
              while (paramICommLibReader.hasNext())
              {
                paramString2 = (WxaAttributes.WxaVersionModuleInfo)paramICommLibReader.next();
                if ((!bt.isNullOrNil(paramString2.name)) && (paramString2.name.equals("__APP__")))
                {
                  this.jfN = paramString2.jfN;
                  if (this.jfN != null) {
                    break label652;
                  }
                  this.cfV = paramString2.jfM;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        this.kMx = new ad(paramString1, paramInt1, paramWxaVersionInfo.aAS, paramQualitySession.kGa, paramInt2, (List)localObject2, this.cfV, this.jfN, this.kMy)
        {
          public final void bgi()
          {
            AppMethodBeat.i(47337);
            super.bgi();
            bf.this.bgi();
            AppMethodBeat.o(47337);
          }
          
          public final void bgq()
          {
            AppMethodBeat.i(47338);
            super.bgq();
            bf.this.bgq();
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
        label646:
        k = 0;
        break label502;
        label652:
        paramICommLibReader = this.jfN.iterator();
        while (paramICommLibReader.hasNext())
        {
          localObject3 = (WxaAttributes.WxaWidgetInfo)paramICommLibReader.next();
          if (((WxaAttributes.WxaWidgetInfo)localObject3).deP == 23) {
            this.cfV = ((WxaAttributes.WxaWidgetInfo)localObject3).jfQ;
          }
        }
        if (this.cfV == null) {
          this.cfV = paramString2.jfM;
        } else {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "multiPkg module widgetInfo true");
        }
      }
      label736:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckMultiPkgInfoHandler");
      this.cfV = ((List)localObject4);
      this.jfN = ((List)localObject3);
      this.kMx = new ac(paramString1, paramInt1, paramWxaVersionInfo.aAS, paramQualitySession.kGa, paramInt2, this.cfV, this.jfN, this.kMy)
      {
        public final void bgi()
        {
          AppMethodBeat.i(47340);
          super.bgi();
          bf.this.bgi();
          AppMethodBeat.o(47340);
        }
        
        public final void bgq()
        {
          AppMethodBeat.i(47341);
          super.bgq();
          bf.this.bgq();
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
    label800:
    if ((paramBoolean) && (u.aPG()) && (localObject4 != null) && (((List)localObject4).size() > 0))
    {
      if ((i != 0) && (!bt.gL((List)localObject2)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgSplitPluginCodeModuleHandler");
        paramString2 = ((List)localObject2).iterator();
        while (paramString2.hasNext())
        {
          paramICommLibReader = (WxaAttributes.WxaVersionModuleInfo)paramString2.next();
          if ((!bt.isNullOrNil(paramICommLibReader.name)) && (paramICommLibReader.name.equals("__APP__"))) {
            this.cfV = paramICommLibReader.jfM;
          }
        }
        this.kMx = new ak(paramString1, paramInt1, paramWxaVersionInfo.aAS, paramQualitySession.kGa, paramInt2, (List)localObject2, this.cfV, this.kMy)
        {
          public final void bgi()
          {
            AppMethodBeat.i(47343);
            super.bgi();
            bf.this.bgi();
            AppMethodBeat.o(47343);
          }
          
          public final void bgq()
          {
            AppMethodBeat.i(47344);
            super.bgq();
            bf.this.bgq();
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgSplitPluginCodeHandler");
      this.cfV = ((List)localObject4);
      this.kMx = new aj(paramString1, paramInt1, paramWxaVersionInfo.aAS, paramQualitySession.kGa, paramInt2, (List)localObject4, this.kMy)
      {
        public final void bgi()
        {
          AppMethodBeat.i(174997);
          super.bgi();
          bf.this.bgi();
          AppMethodBeat.o(174997);
        }
        
        public final void bgq()
        {
          AppMethodBeat.i(174998);
          super.bgq();
          bf.this.bgq();
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
    if ((i != 0) && (!bt.gL((List)localObject2)) && (u.aPF()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "<init> use LaunchCheckPkgModularizingHandler");
      if (j.a.qD(paramInt1)) {
        j.aOK().a(paramString1, paramWxaVersionInfo);
      }
      this.kMx = new ai(paramString1, paramInt1, paramString2, paramInt2, paramWxaVersionInfo.aAS, j, (String)localObject5, (List)localObject2, paramQualitySession.kGa)
      {
        public final WxaPkgWrappingInfo aVF()
        {
          AppMethodBeat.i(180310);
          bf.Q(this.appId, this.gXn, paramWxaVersionInfo.aAS);
          WxaPkgWrappingInfo localWxaPkgWrappingInfo = super.aVF();
          AppMethodBeat.o(180310);
          return localWxaPkgWrappingInfo;
        }
        
        public final void bgi()
        {
          AppMethodBeat.i(175000);
          super.bgi();
          bf.this.bgi();
          AppMethodBeat.o(175000);
        }
        
        public final void bgq()
        {
          AppMethodBeat.i(175001);
          super.bgq();
          bf.this.bgq();
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgIntegratedHandler");
    this.kMx = new ah(paramString1, paramInt1, paramWxaVersionInfo.aAS, paramInt2, paramWxaVersionInfo, paramQualitySession.kGa)
    {
      public final WxaPkgWrappingInfo aVF()
      {
        AppMethodBeat.i(196025);
        bf.Q(this.appId, this.gXn, paramWxaVersionInfo.aAS);
        WxaPkgWrappingInfo localWxaPkgWrappingInfo = super.aVF();
        AppMethodBeat.o(196025);
        return localWxaPkgWrappingInfo;
      }
      
      public final void bgi()
      {
        AppMethodBeat.i(196026);
        bf.this.bgi();
        AppMethodBeat.o(196026);
      }
      
      public final void bgq()
      {
        AppMethodBeat.i(196027);
        bf.this.bgq();
        AppMethodBeat.o(196027);
      }
      
      public final void onDownloadProgress(int paramAnonymousInt)
      {
        AppMethodBeat.i(196028);
        bf.this.onDownloadProgress(paramAnonymousInt);
        AppMethodBeat.o(196028);
      }
    };
    AppMethodBeat.o(180312);
  }
  
  public final Pair<WxaPkgWrappingInfo, List<WxaAttributes.WxaPluginCodeInfo>> bgV()
  {
    AppMethodBeat.i(47348);
    long l1 = bt.eGO();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "call() before call real checkHandler");
    Object localObject = (WxaPkgWrappingInfo)this.kMx.call();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "call() finished split usePluginCode boolean:%b", new Object[] { Boolean.valueOf(this.kMy.value) });
    long l2 = bt.eGO();
    if (localObject != null) {
      if (this.kMA) {
        c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_Download, "", l1, l2);
      }
    }
    while (this.kMy.value)
    {
      localObject = Pair.create(localObject, this.cfV);
      AppMethodBeat.o(47348);
      return localObject;
      c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_DB, "", l1, l2);
      continue;
      if (this.kMA) {
        c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_Download, "", "", l1, l2);
      } else {
        c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_DB, "", "", l1, l2);
      }
    }
    localObject = Pair.create(localObject, null);
    AppMethodBeat.o(47348);
    return localObject;
  }
  
  public void bgi()
  {
    AppMethodBeat.i(196030);
    this.kMA = true;
    if (j.a.qD(this.gXn)) {
      y.aPK();
    }
    AppMethodBeat.o(196030);
  }
  
  public void bgq() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper";
  }
  
  public final void gv(boolean paramBoolean)
  {
    AppMethodBeat.i(180313);
    super.gv(paramBoolean);
    if ((this.kMx instanceof x.b))
    {
      ((x.b)this.kMx).gv(paramBoolean);
      AppMethodBeat.o(180313);
      return;
    }
    if ((this.kMx instanceof bb)) {
      ((bb)this.kMx).gv(paramBoolean);
    }
    AppMethodBeat.o(180313);
  }
  
  public void onDownloadProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bf
 * JD-Core Version:    0.7.0.1
 */