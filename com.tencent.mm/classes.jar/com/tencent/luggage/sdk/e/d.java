package com.tencent.luggage.sdk.e;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.appcache.AssetReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appcache.bv;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.file.av;
import com.tencent.mm.plugin.appbrand.p.g.a;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.permission.d.a;
import com.tencent.mm.plugin.appbrand.permission.d.b;
import com.tencent.mm.plugin.appbrand.permission.j;
import com.tencent.mm.plugin.appbrand.permission.k;
import com.tencent.mm.plugin.appbrand.permission.l;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.u.1;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;
import org.json.JSONObject;

public class d
  extends AppBrandRuntime
{
  public com.tencent.mm.plugin.appbrand.ui.u cCO;
  private Boolean cCP = null;
  public volatile com.tencent.mm.plugin.appbrand.permission.d cCQ;
  
  static
  {
    AppMethodBeat.i(182987);
    bv.a(g.cCT);
    WxaPkgWrappingInfo.a(g.a.qhX);
    AppMethodBeat.o(182987);
  }
  
  public d(ak paramak)
  {
    super(paramak);
  }
  
  protected d(c paramc)
  {
    super(paramc);
  }
  
  private static boolean c(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    AppMethodBeat.i(146913);
    if ((paramAppBrandInitConfigLU.cwS) && ((e(paramAppBrandInitConfigLU)) || (d(paramAppBrandInitConfigLU))))
    {
      AppMethodBeat.o(146913);
      return true;
    }
    AppMethodBeat.o(146913);
    return false;
  }
  
  private static boolean d(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    return paramAppBrandInitConfigLU.cxf.scene == 1101;
  }
  
  private static boolean e(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    paramAppBrandInitConfigLU = paramAppBrandInitConfigLU.cxf;
    return (paramAppBrandInitConfigLU.scene == 1011) || (paramAppBrandInitConfigLU.scene == 1012) || (paramAppBrandInitConfigLU.scene == 1013);
  }
  
  public void NR()
  {
    AppMethodBeat.i(146907);
    super.NR();
    if ((AppBrandPerformanceManager.k(this)) && (this.cCO == null))
    {
      AppBrandPerformanceManager.j(this);
      this.cCO = Sm();
      if (this.cCO != null)
      {
        this.ntC.addView(this.cCO);
        com.tencent.mm.plugin.appbrand.ui.u localu = this.cCO;
        AppBrandPerformanceManager.l(localu.cBh);
        localu.setVisibility(0);
        localu.setAlpha(0.0F);
        localu.animate().alpha(1.0F).setDuration(500L).setStartDelay(500L).setListener(null);
      }
    }
    AppMethodBeat.o(146907);
  }
  
  public final AppBrandStatObject Qu()
  {
    AppMethodBeat.i(146905);
    AppBrandStatObject localAppBrandStatObject = Sk().cxf;
    AppMethodBeat.o(146905);
    return localAppBrandStatObject;
  }
  
  public boolean Rp()
  {
    AppMethodBeat.i(146912);
    if (this.cCP != null)
    {
      bool = this.cCP.booleanValue();
      AppMethodBeat.o(146912);
      return bool;
    }
    Boolean localBoolean = Boolean.valueOf(c(Sk()));
    this.cCP = localBoolean;
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(146912);
    return bool;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.d Sf()
  {
    return this.cCQ;
  }
  
  public final int Sg()
  {
    AppMethodBeat.i(146897);
    if (j.a.vB(this.ntz.cBI))
    {
      AppMethodBeat.o(146897);
      return 0;
    }
    int i = Sk().appVersion;
    AppMethodBeat.o(146897);
    return i;
  }
  
  public final av Sh()
  {
    AppMethodBeat.i(146901);
    av localav = (av)super.getFileSystem();
    AppMethodBeat.o(146901);
    return localav;
  }
  
  public r Si()
  {
    AppMethodBeat.i(146902);
    Object localObject = Sj();
    if (localObject == null) {
      Log.e("Luggage.WXA.AppBrandRuntimeLU", "createFileSystem but get NUL sysConfig, appId:%s", new Object[] { this.mAppId });
    }
    for (localObject = new com.tencent.mm.plugin.appbrand.jsapi.file.d();; localObject = com.tencent.mm.plugin.appbrand.config.f.a((AppBrandSysConfigLU)localObject))
    {
      localObject = new av(this, (com.tencent.mm.plugin.appbrand.jsapi.file.d)localObject);
      AppMethodBeat.o(146902);
      return localObject;
    }
  }
  
  public AppBrandSysConfigLU Sj()
  {
    AppMethodBeat.i(146903);
    AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)d(AppBrandSysConfigLU.class, false);
    AppMethodBeat.o(146903);
    return localAppBrandSysConfigLU;
  }
  
  public AppBrandInitConfigLU Sk()
  {
    AppMethodBeat.i(146904);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.Sq();
    AppMethodBeat.o(146904);
    return localAppBrandInitConfigLU;
  }
  
  public void Sl()
  {
    AppMethodBeat.i(146909);
    super.Sl();
    if (ae(ICommLibReader.class) == null) {
      b(ICommLibReader.class, AssetReader.nEa);
    }
    Object localObject = new ab((ICommLibReader)ae(ICommLibReader.class), bl.N(this));
    this.ntK.add(localObject);
    if (this.cCQ == null)
    {
      localObject = new IllegalStateException("Should ensure ApiPermissionController installed before init. Use #setApiPermissionController().");
      AppMethodBeat.o(146909);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(146909);
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.u Sm()
  {
    AppMethodBeat.i(146911);
    com.tencent.mm.plugin.appbrand.ui.u localu = new com.tencent.mm.plugin.appbrand.ui.u(AndroidContextUtil.castActivityOrNull(this.mContext), this);
    AppMethodBeat.o(146911);
    return localu;
  }
  
  public com.tencent.mm.plugin.appbrand.p.a Sn()
  {
    AppMethodBeat.i(146914);
    if ((Sj() != null) && ((!Util.isNullOrNil(Sj().nYR.nIb)) || (Sk().Qv()))) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = new com.tencent.mm.plugin.appbrand.p.f(this);
      AppMethodBeat.o(146914);
      return localObject;
    }
    Object localObject = new a.a(this, (byte)0);
    AppMethodBeat.o(146914);
    return localObject;
  }
  
  public final boolean So()
  {
    AppMethodBeat.i(246521);
    if (this.ntU.get())
    {
      AppMethodBeat.o(246521);
      return false;
    }
    if (Sk().cxe == com.tencent.luggage.sdk.launching.b.cBf)
    {
      AppMethodBeat.o(246521);
      return true;
    }
    AppMethodBeat.o(246521);
    return false;
  }
  
  public final <T extends com.tencent.mm.kernel.c.a> T V(Class<T> paramClass)
  {
    AppMethodBeat.i(169457);
    if (k.class == paramClass)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(n.qzK);
      AppMethodBeat.o(169457);
      return paramClass;
    }
    if (j.class == paramClass)
    {
      l locall = new l(this);
      b(j.class, locall);
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(locall);
      AppMethodBeat.o(169457);
      return paramClass;
    }
    paramClass = super.V(paramClass);
    AppMethodBeat.o(169457);
    return paramClass;
  }
  
  public void a(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(146899);
    if (!this.mInitialized)
    {
      AppMethodBeat.o(146899);
      return;
    }
    boolean bool1 = Rp();
    boolean bool2 = c((AppBrandInitConfigLU)paramAppBrandInitConfig);
    int i;
    if (((!bool1) && (bool2)) || ((bool1) && (!bool2) && (e((AppBrandInitConfigLU)paramAppBrandInitConfig))))
    {
      i = 1;
      if (i != 0)
      {
        this.cCP = null;
        bCs();
      }
      if ((!bCt()) && (!this.ntU.get())) {
        if ((j.a.za(this.ntz.cBI)) && (((AppBrandInitConfigLU)paramAppBrandInitConfig).appVersion != Sj().nYR.pkgVersion))
        {
          String str = String.format(Locale.ENGLISH, "Updated InitConfig.appVersion != getSysConfig().appVersion, appId:%s, @smoothieli", new Object[] { this.mAppId });
          Log.w("Luggage.WXA.AppBrandRuntimeLU", str);
          if (!this.nug) {
            break label197;
          }
          Assert.fail(str);
        }
      }
    }
    for (;;)
    {
      if (b(paramAppBrandInitConfig)) {
        bCu();
      }
      super.a(paramAppBrandInitConfig);
      AppMethodBeat.o(146899);
      return;
      i = 0;
      break;
      label197:
      bCs();
    }
  }
  
  public void a(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject)
  {
    AppMethodBeat.i(169456);
    for (;;)
    {
      MiniProgramNavigationBackResult localMiniProgramNavigationBackResult;
      try
      {
        MiniProgramNavigationBackResult.class.cast(paramObject);
        AppBrandInitConfigLU localAppBrandInitConfigLU = Sk().QB();
        AppBrandLaunchReferrer localAppBrandLaunchReferrer1 = localAppBrandInitConfigLU.cwV;
        localMiniProgramNavigationBackResult = (MiniProgramNavigationBackResult)paramObject;
        AppBrandLaunchReferrer localAppBrandLaunchReferrer2 = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer2.appId = paramAppBrandInitConfig.appId;
        localAppBrandLaunchReferrer2.nYB = 3;
        if (localMiniProgramNavigationBackResult == null)
        {
          paramObject = null;
          localAppBrandLaunchReferrer2.fMh = paramObject;
          if (localMiniProgramNavigationBackResult != null) {
            break label234;
          }
          paramObject = null;
          localAppBrandLaunchReferrer2.nYC = paramObject;
          localAppBrandLaunchReferrer1.a(localAppBrandLaunchReferrer2);
          paramObject = new AppBrandStatObject();
          paramObject.scene = 1038;
          if ((paramAppBrandInitConfig instanceof AppBrandInitConfigLU)) {
            paramObject.fvd = (paramAppBrandInitConfig.appId + ':' + ((AppBrandInitConfigLU)paramAppBrandInitConfig).cwP + ':' + (((AppBrandInitConfigLU)paramAppBrandInitConfig).cwR + 1000));
          }
          localAppBrandInitConfigLU.startTime = Util.nowMilliSecond();
          localAppBrandInitConfigLU.nBq = null;
          localAppBrandInitConfigLU.resetSession();
          localAppBrandInitConfigLU.cxf = paramObject;
          d(localAppBrandInitConfigLU);
          AppMethodBeat.o(169456);
          return;
        }
      }
      catch (ClassCastException paramAppBrandInitConfig)
      {
        paramAppBrandInitConfig = new IllegalStateException("Only data as MiniProgramNavigationBackResult acceptable here.", paramAppBrandInitConfig);
        AppMethodBeat.o(169456);
        throw paramAppBrandInitConfig;
      }
      paramObject = localMiniProgramNavigationBackResult.nyM.toString();
      continue;
      label234:
      paramObject = localMiniProgramNavigationBackResult.nyN.toString();
    }
  }
  
  protected boolean b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(146900);
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.nBq))
    {
      AppMethodBeat.o(146900);
      return true;
    }
    AppMethodBeat.o(146900);
    return false;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(146908);
    super.onCreate();
    com.tencent.luggage.sdk.processes.client.a locala = com.tencent.luggage.sdk.processes.client.a.cBZ;
    com.tencent.luggage.sdk.processes.client.a.b(this);
    com.tencent.mm.plugin.appbrand.ipc.b.bPe();
    AppMethodBeat.o(146908);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(146910);
    super.onDestroy();
    ??? = com.tencent.luggage.sdk.processes.client.a.cBZ;
    com.tencent.luggage.sdk.processes.client.a.c(this);
    if (this.cCO != null)
    {
      if ((this.cCO.getParent() instanceof ViewGroup))
      {
        ??? = this.cCO;
        AppBrandPerformanceManager.amc(((com.tencent.mm.plugin.appbrand.ui.u)???).cBh.mAppId);
        ((com.tencent.mm.plugin.appbrand.ui.u)???).animate().alpha(0.0F).setDuration(500L).setListener(new u.1((com.tencent.mm.plugin.appbrand.ui.u)???));
        ((ViewGroup)this.cCO.getParent()).removeView(this.cCO);
      }
      this.cCO = null;
    }
    Object localObject2;
    if (this.cCQ != null) {
      localObject2 = this.cCQ;
    }
    synchronized (((com.tencent.mm.plugin.appbrand.permission.d)localObject2).qzt)
    {
      ((com.tencent.mm.plugin.appbrand.permission.d)localObject2).qzt.clear();
      this.cCQ = null;
      ??? = (av)super.getFileSystem();
      if (??? != null)
      {
        localObject2 = (p)((x)???).ay(p.class);
        if (localObject2 != null) {
          com.tencent.mm.vfs.u.deleteFile(((p)localObject2).nMO + "/dir.lock");
        }
        ((x)???).release();
      }
      AppMethodBeat.o(146910);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(146898);
    super.onResume();
    com.tencent.mm.plugin.appbrand.permission.d locald = this.cCQ;
    LinkedList localLinkedList = new LinkedList();
    synchronized (locald.qzt)
    {
      localLinkedList.addAll(locald.qzt);
      locald.qzt.clear();
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((d.b)((Iterator)???).next()).a(d.a.cgb());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.d
 * JD-Core Version:    0.7.0.1
 */