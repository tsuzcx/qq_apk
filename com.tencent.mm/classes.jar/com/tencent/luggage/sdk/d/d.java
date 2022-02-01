package com.tencent.luggage.sdk.d;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.luggage.sdk.c.a.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.appcache.AssetReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.p.h.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.permission.d.a;
import com.tencent.mm.plugin.appbrand.permission.d.b;
import com.tencent.mm.plugin.appbrand.permission.j;
import com.tencent.mm.plugin.appbrand.permission.k;
import com.tencent.mm.plugin.appbrand.permission.l;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.v.1;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.vfs.s;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import junit.framework.Assert;
import org.json.JSONObject;

public class d
  extends AppBrandRuntime
{
  public com.tencent.mm.plugin.appbrand.ui.v cCl;
  private Boolean cCm = null;
  public volatile com.tencent.mm.plugin.appbrand.permission.d cCn;
  
  static
  {
    AppMethodBeat.i(182987);
    bo.a(g.cCq);
    WxaPkgWrappingInfo.a(h.a.nho);
    AppMethodBeat.o(182987);
  }
  
  public d(ak paramak)
  {
    super(paramak);
  }
  
  protected d(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    super(paramc);
  }
  
  private static boolean c(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    AppMethodBeat.i(146913);
    if ((paramAppBrandInitConfigLU.cyp) && ((e(paramAppBrandInitConfigLU)) || (d(paramAppBrandInitConfigLU))))
    {
      AppMethodBeat.o(146913);
      return true;
    }
    AppMethodBeat.o(146913);
    return false;
  }
  
  private static boolean d(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    return paramAppBrandInitConfigLU.cyA.scene == 1101;
  }
  
  private static boolean e(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    paramAppBrandInitConfigLU = paramAppBrandInitConfigLU.cyA;
    return (paramAppBrandInitConfigLU.scene == 1011) || (paramAppBrandInitConfigLU.scene == 1012) || (paramAppBrandInitConfigLU.scene == 1013);
  }
  
  public final AppBrandStatObject Nz()
  {
    AppMethodBeat.i(146905);
    AppBrandStatObject localAppBrandStatObject = ON().cyA;
    AppMethodBeat.o(146905);
    return localAppBrandStatObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.d OI()
  {
    return this.cCn;
  }
  
  public final int OJ()
  {
    AppMethodBeat.i(146897);
    if (j.a.sE(this.kAq.eix))
    {
      AppMethodBeat.o(146897);
      return 0;
    }
    int i = ON().appVersion;
    AppMethodBeat.o(146897);
    return i;
  }
  
  public final at OK()
  {
    AppMethodBeat.i(146901);
    at localat = (at)super.getFileSystem();
    AppMethodBeat.o(146901);
    return localat;
  }
  
  public q OL()
  {
    AppMethodBeat.i(146902);
    Object localObject = OM();
    if (localObject == null) {
      Log.e("Luggage.WXA.AppBrandRuntimeLU", "createFileSystem but get NUL sysConfig, appId:%s", new Object[] { this.mAppId });
    }
    for (localObject = new com.tencent.mm.plugin.appbrand.jsapi.file.d();; localObject = f.a((AppBrandSysConfigLU)localObject))
    {
      localObject = new at(this, (com.tencent.mm.plugin.appbrand.jsapi.file.d)localObject);
      AppMethodBeat.o(146902);
      return localObject;
    }
  }
  
  public AppBrandSysConfigLU OM()
  {
    AppMethodBeat.i(146903);
    AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)d(AppBrandSysConfigLU.class, false);
    AppMethodBeat.o(146903);
    return localAppBrandSysConfigLU;
  }
  
  public AppBrandInitConfigLU ON()
  {
    AppMethodBeat.i(146904);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.OU();
    AppMethodBeat.o(146904);
    return localAppBrandInitConfigLU;
  }
  
  public void OO()
  {
    AppMethodBeat.i(146909);
    super.OO();
    if (af(ICommLibReader.class) == null) {
      b(ICommLibReader.class, AssetReader.kKj);
    }
    Object localObject = new aa((ICommLibReader)af(ICommLibReader.class), bg.M(this));
    this.kAA.add(localObject);
    if (this.cCn == null)
    {
      localObject = new IllegalStateException("Should ensure ApiPermissionController installed before init. Use #setApiPermissionController().");
      AppMethodBeat.o(146909);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(146909);
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.v OP()
  {
    AppMethodBeat.i(146911);
    com.tencent.mm.plugin.appbrand.ui.v localv = new com.tencent.mm.plugin.appbrand.ui.v(AndroidContextUtil.castActivityOrNull(this.mContext), this);
    AppMethodBeat.o(146911);
    return localv;
  }
  
  public boolean OQ()
  {
    AppMethodBeat.i(146912);
    if (this.cCm != null)
    {
      bool = this.cCm.booleanValue();
      AppMethodBeat.o(146912);
      return bool;
    }
    Boolean localBoolean = Boolean.valueOf(c(ON()));
    this.cCm = localBoolean;
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(146912);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.p.a OR()
  {
    AppMethodBeat.i(146914);
    if ((OM() != null) && ((!Util.isNullOrNil(OM().leE.kNZ)) || (ON().NA()))) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = new com.tencent.mm.plugin.appbrand.p.g(this);
      AppMethodBeat.o(146914);
      return localObject;
    }
    Object localObject = new a.a(this, (byte)0);
    AppMethodBeat.o(146914);
    return localObject;
  }
  
  public final boolean OS()
  {
    AppMethodBeat.i(229874);
    if (isDestroyed())
    {
      AppMethodBeat.o(229874);
      return false;
    }
    if (ON().cyz == b.cBC)
    {
      AppMethodBeat.o(229874);
      return true;
    }
    AppMethodBeat.o(229874);
    return false;
  }
  
  public final <T extends com.tencent.mm.kernel.c.a> T V(Class<T> paramClass)
  {
    AppMethodBeat.i(169457);
    if (k.class == paramClass)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(n.nxG);
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
    boolean bool1 = OQ();
    boolean bool2 = c((AppBrandInitConfigLU)paramAppBrandInitConfig);
    int i;
    if (((!bool1) && (bool2)) || ((bool1) && (!bool2) && (e((AppBrandInitConfigLU)paramAppBrandInitConfig))))
    {
      i = 1;
      if (i != 0)
      {
        this.cCm = null;
        brC();
      }
      if ((!this.kAJ) && (!isDestroyed())) {
        if ((j.a.vP(this.kAq.eix)) && (((AppBrandInitConfigLU)paramAppBrandInitConfig).appVersion != OM().leE.pkgVersion))
        {
          String str = String.format(Locale.ENGLISH, "Updated InitConfig.appVersion != getSysConfig().appVersion, appId:%s, @smoothieli", new Object[] { this.mAppId });
          Log.w("Luggage.WXA.AppBrandRuntimeLU", str);
          if (!this.kAU) {
            break label194;
          }
          Assert.fail(str);
        }
      }
    }
    for (;;)
    {
      if (b(paramAppBrandInitConfig)) {
        brE();
      }
      super.a(paramAppBrandInitConfig);
      AppMethodBeat.o(146899);
      return;
      i = 0;
      break;
      label194:
      brC();
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
        AppBrandInitConfigLU localAppBrandInitConfigLU = ON().NG();
        AppBrandLaunchReferrer localAppBrandLaunchReferrer1 = localAppBrandInitConfigLU.cys;
        localMiniProgramNavigationBackResult = (MiniProgramNavigationBackResult)paramObject;
        AppBrandLaunchReferrer localAppBrandLaunchReferrer2 = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer2.appId = paramAppBrandInitConfig.appId;
        localAppBrandLaunchReferrer2.leo = 3;
        if (localMiniProgramNavigationBackResult == null)
        {
          paramObject = null;
          localAppBrandLaunchReferrer2.dSJ = paramObject;
          if (localMiniProgramNavigationBackResult != null) {
            break label234;
          }
          paramObject = null;
          localAppBrandLaunchReferrer2.lep = paramObject;
          localAppBrandLaunchReferrer1.a(localAppBrandLaunchReferrer2);
          paramObject = new AppBrandStatObject();
          paramObject.scene = 1038;
          if ((paramAppBrandInitConfig instanceof AppBrandInitConfigLU)) {
            paramObject.dCw = (paramAppBrandInitConfig.appId + ':' + ((AppBrandInitConfigLU)paramAppBrandInitConfig).cym + ':' + (((AppBrandInitConfigLU)paramAppBrandInitConfig).cyo + 1000));
          }
          localAppBrandInitConfigLU.startTime = Util.nowMilliSecond();
          localAppBrandInitConfigLU.kHw = null;
          localAppBrandInitConfigLU.resetSession();
          localAppBrandInitConfigLU.cyA = paramObject;
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
      paramObject = localMiniProgramNavigationBackResult.kFg.toString();
      continue;
      label234:
      paramObject = localMiniProgramNavigationBackResult.kFh.toString();
    }
  }
  
  protected boolean b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(146900);
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.kHw))
    {
      AppMethodBeat.o(146900);
      return true;
    }
    AppMethodBeat.o(146900);
    return false;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(146910);
    super.onDestroy();
    if (this.cCl != null)
    {
      if ((this.cCl.getParent() instanceof ViewGroup))
      {
        ??? = this.cCl;
        AppBrandPerformanceManager.aei(((com.tencent.mm.plugin.appbrand.ui.v)???).cBE.mAppId);
        ((com.tencent.mm.plugin.appbrand.ui.v)???).animate().alpha(0.0F).setDuration(500L).setListener(new v.1((com.tencent.mm.plugin.appbrand.ui.v)???));
        ((ViewGroup)this.cCl.getParent()).removeView(this.cCl);
      }
      this.cCl = null;
    }
    Object localObject2;
    if (this.cCn != null) {
      localObject2 = this.cCn;
    }
    synchronized (((com.tencent.mm.plugin.appbrand.permission.d)localObject2).nxr)
    {
      ((com.tencent.mm.plugin.appbrand.permission.d)localObject2).nxr.clear();
      this.cCn = null;
      ??? = (at)super.getFileSystem();
      if (??? != null)
      {
        localObject2 = (o)((com.tencent.mm.plugin.appbrand.appstorage.v)???).az(o.class);
        if (localObject2 != null) {
          s.deleteFile(((o)localObject2).kSr + "/dir.lock");
        }
        ((com.tencent.mm.plugin.appbrand.appstorage.v)???).release();
      }
      AppMethodBeat.o(146910);
      return;
    }
  }
  
  public void onReady()
  {
    AppMethodBeat.i(146907);
    super.onReady();
    if ((AppBrandPerformanceManager.e(this)) && (this.cCl == null))
    {
      AppBrandPerformanceManager.d(this);
      this.cCl = OP();
      if (this.cCl != null)
      {
        this.kAt.addView(this.cCl);
        com.tencent.mm.plugin.appbrand.ui.v localv = this.cCl;
        AppBrandPerformanceManager.f(localv.cBE);
        localv.setVisibility(0);
        localv.setAlpha(0.0F);
        localv.animate().alpha(1.0F).setDuration(500L).setStartDelay(500L).setListener(null);
      }
    }
    AppMethodBeat.o(146907);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(146898);
    super.onResume();
    com.tencent.mm.plugin.appbrand.permission.d locald = this.cCn;
    LinkedList localLinkedList = new LinkedList();
    synchronized (locald.nxr)
    {
      localLinkedList.addAll(locald.nxr);
      locald.nxr.clear();
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((d.b)((Iterator)???).next()).a(d.a.bSY());
      }
    }
    AppMethodBeat.o(146898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.d
 * JD-Core Version:    0.7.0.1
 */