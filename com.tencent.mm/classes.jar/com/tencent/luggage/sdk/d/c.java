package com.tencent.luggage.sdk.d;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.luggage.sdk.c.a.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.ai;
import com.tencent.mm.plugin.appbrand.appcache.AssetReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.n.h.a;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.permission.e.a;
import com.tencent.mm.plugin.appbrand.permission.e.b;
import com.tencent.mm.plugin.appbrand.permission.h;
import com.tencent.mm.plugin.appbrand.permission.i;
import com.tencent.mm.plugin.appbrand.permission.k;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.o;
import com.tencent.mm.plugin.appbrand.ui.o.1;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import junit.framework.Assert;
import org.json.JSONObject;

public class c
  extends AppBrandRuntime
{
  public o ceY;
  private Boolean ceZ = null;
  public volatile com.tencent.mm.plugin.appbrand.permission.e cfa;
  
  static
  {
    AppMethodBeat.i(182987);
    bm.a(d.cfd);
    WxaPkgWrappingInfo.a(h.a.lvQ);
    AppMethodBeat.o(182987);
  }
  
  public c(ai paramai)
  {
    super(paramai);
  }
  
  private static boolean a(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    AppMethodBeat.i(146913);
    if ((paramAppBrandInitConfigLU.ccb) && ((c(paramAppBrandInitConfigLU)) || (b(paramAppBrandInitConfigLU))))
    {
      AppMethodBeat.o(146913);
      return true;
    }
    AppMethodBeat.o(146913);
    return false;
  }
  
  private static boolean b(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    return paramAppBrandInitConfigLU.ccl.scene == 1101;
  }
  
  private static boolean c(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    paramAppBrandInitConfigLU = paramAppBrandInitConfigLU.ccl;
    return (paramAppBrandInitConfigLU.scene == 1011) || (paramAppBrandInitConfigLU.scene == 1012) || (paramAppBrandInitConfigLU.scene == 1013);
  }
  
  public final AppBrandStatObject CB()
  {
    AppMethodBeat.i(146905);
    AppBrandStatObject localAppBrandStatObject = DC().ccl;
    AppMethodBeat.o(146905);
    return localAppBrandStatObject;
  }
  
  public p DA()
  {
    AppMethodBeat.i(146902);
    Object localObject = DB();
    if (localObject == null) {
      ac.e("Luggage.WXA.AppBrandRuntimeLU", "createFileSystem but get NUL sysConfig, appId:%s", new Object[] { this.mAppId });
    }
    for (localObject = new com.tencent.mm.plugin.appbrand.jsapi.file.d();; localObject = com.tencent.mm.plugin.appbrand.config.e.a((AppBrandSysConfigLU)localObject))
    {
      localObject = new ar(this, (com.tencent.mm.plugin.appbrand.jsapi.file.d)localObject);
      AppMethodBeat.o(146902);
      return localObject;
    }
  }
  
  public AppBrandSysConfigLU DB()
  {
    AppMethodBeat.i(146903);
    AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)c(AppBrandSysConfigLU.class, false);
    AppMethodBeat.o(146903);
    return localAppBrandSysConfigLU;
  }
  
  public AppBrandInitConfigLU DC()
  {
    AppMethodBeat.i(146904);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.DJ();
    AppMethodBeat.o(146904);
    return localAppBrandInitConfigLU;
  }
  
  public void DD()
  {
    AppMethodBeat.i(146909);
    super.DD();
    if (ab(ICommLibReader.class) == null) {
      b(ICommLibReader.class, AssetReader.jly);
    }
    Object localObject = new y((ICommLibReader)ab(ICommLibReader.class), be.U(this));
    this.jdG.add(localObject);
    if (this.cfa == null)
    {
      localObject = new IllegalStateException("Should ensure ApiPermissionController installed before init. Use #setApiPermissionController().");
      AppMethodBeat.o(146909);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(146909);
  }
  
  protected o DE()
  {
    AppMethodBeat.i(146911);
    o localo = new o(com.tencent.mm.sdk.f.a.jg(this.mContext), this);
    AppMethodBeat.o(146911);
    return localo;
  }
  
  public boolean DF()
  {
    AppMethodBeat.i(146912);
    if (this.ceZ != null)
    {
      bool = this.ceZ.booleanValue();
      AppMethodBeat.o(146912);
      return bool;
    }
    Boolean localBoolean = Boolean.valueOf(a(DC()));
    this.ceZ = localBoolean;
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(146912);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.n.a DG()
  {
    AppMethodBeat.i(146914);
    if ((DB() != null) && (!bs.gY(DB().jEg.jpd))) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = new com.tencent.mm.plugin.appbrand.n.g(this);
      AppMethodBeat.o(146914);
      return localObject;
    }
    Object localObject = new a.a(this, (byte)0);
    AppMethodBeat.o(146914);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.e Dx()
  {
    return this.cfa;
  }
  
  public final int Dy()
  {
    AppMethodBeat.i(146897);
    if (j.a.on(this.jdx.joY))
    {
      AppMethodBeat.o(146897);
      return 0;
    }
    int i = DC().aBM;
    AppMethodBeat.o(146897);
    return i;
  }
  
  public final ar Dz()
  {
    AppMethodBeat.i(146901);
    ar localar = (ar)super.DH();
    AppMethodBeat.o(146901);
    return localar;
  }
  
  public final <T extends com.tencent.mm.kernel.c.a> T S(Class<T> paramClass)
  {
    AppMethodBeat.i(169457);
    if (h.class == paramClass)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(k.lIV);
      AppMethodBeat.o(169457);
      return paramClass;
    }
    if (com.tencent.mm.plugin.appbrand.permission.g.class == paramClass)
    {
      i locali = new i(this);
      b(com.tencent.mm.plugin.appbrand.permission.g.class, locali);
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(locali);
      AppMethodBeat.o(169457);
      return paramClass;
    }
    paramClass = super.S(paramClass);
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
    boolean bool1 = DF();
    boolean bool2 = a((AppBrandInitConfigLU)paramAppBrandInitConfig);
    int i;
    if (((!bool1) && (bool2)) || ((bool1) && (!bool2) && (c((AppBrandInitConfigLU)paramAppBrandInitConfig))))
    {
      i = 1;
      if (i != 0)
      {
        this.ceZ = null;
        aSS();
      }
      if ((!this.jdM) && (!isDestroyed())) {
        if ((j.a.rq(this.jdx.joY)) && (((AppBrandInitConfigLU)paramAppBrandInitConfig).aBM != DB().jEg.pkgVersion))
        {
          String str = String.format(Locale.ENGLISH, "Updated InitConfig.appVersion != getSysConfig().appVersion, appId:%s, @smoothieli", new Object[] { this.mAppId });
          ac.w("Luggage.WXA.AppBrandRuntimeLU", str);
          if (!this.jdX) {
            break label194;
          }
          Assert.fail(str);
        }
      }
    }
    for (;;)
    {
      if (b(paramAppBrandInitConfig)) {
        aST();
      }
      super.a(paramAppBrandInitConfig);
      AppMethodBeat.o(146899);
      return;
      i = 0;
      break;
      label194:
      aSS();
    }
  }
  
  public final void a(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject)
  {
    AppMethodBeat.i(169456);
    for (;;)
    {
      MiniProgramNavigationBackResult localMiniProgramNavigationBackResult;
      try
      {
        MiniProgramNavigationBackResult.class.cast(paramObject);
        AppBrandInitConfigLU localAppBrandInitConfigLU = DC().CH();
        AppBrandLaunchReferrer localAppBrandLaunchReferrer1 = localAppBrandInitConfigLU.cce;
        localMiniProgramNavigationBackResult = (MiniProgramNavigationBackResult)paramObject;
        AppBrandLaunchReferrer localAppBrandLaunchReferrer2 = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer2.appId = paramAppBrandInitConfig.appId;
        localAppBrandLaunchReferrer2.jDQ = 3;
        if (localMiniProgramNavigationBackResult == null)
        {
          paramObject = null;
          localAppBrandLaunchReferrer2.dob = paramObject;
          if (localMiniProgramNavigationBackResult != null) {
            break label234;
          }
          paramObject = null;
          localAppBrandLaunchReferrer2.jDR = paramObject;
          localAppBrandLaunchReferrer1.a(localAppBrandLaunchReferrer2);
          paramObject = new AppBrandStatObject();
          paramObject.scene = 1038;
          if ((paramAppBrandInitConfig instanceof AppBrandInitConfigLU)) {
            paramObject.cYP = (paramAppBrandInitConfig.appId + ':' + ((AppBrandInitConfigLU)paramAppBrandInitConfig).CD() + ':' + (((AppBrandInitConfigLU)paramAppBrandInitConfig).cca + 1000));
          }
          localAppBrandInitConfigLU.startTime = bs.eWj();
          localAppBrandInitConfigLU.jjf = null;
          localAppBrandInitConfigLU.resetSession();
          localAppBrandInitConfigLU.ccl = paramObject;
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
      paramObject = localMiniProgramNavigationBackResult.jhV.toString();
      continue;
      label234:
      paramObject = localMiniProgramNavigationBackResult.jhW.toString();
    }
  }
  
  protected boolean b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(146900);
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.jjf))
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
    if (this.ceY != null)
    {
      if ((this.ceY.getParent() instanceof ViewGroup))
      {
        ??? = this.ceY;
        AppBrandPerformanceManager.Qg(((o)???).ceP.mAppId);
        ((o)???).animate().alpha(0.0F).setDuration(500L).setListener(new o.1((o)???));
        ((ViewGroup)this.ceY.getParent()).removeView(this.ceY);
      }
      this.ceY = null;
    }
    com.tencent.mm.plugin.appbrand.permission.e locale;
    if (this.cfa != null) {
      locale = this.cfa;
    }
    synchronized (locale.lIG)
    {
      locale.lIG.clear();
      this.cfa = null;
      AppMethodBeat.o(146910);
      return;
    }
  }
  
  public void onReady()
  {
    AppMethodBeat.i(146907);
    super.onReady();
    if ((AppBrandPerformanceManager.d(this)) && (this.ceY == null))
    {
      AppBrandPerformanceManager.c(this);
      this.ceY = DE();
      if (this.ceY != null)
      {
        this.jdA.addView(this.ceY);
        o localo = this.ceY;
        AppBrandPerformanceManager.e(localo.ceP);
        localo.setVisibility(0);
        localo.setAlpha(0.0F);
        localo.animate().alpha(1.0F).setDuration(500L).setStartDelay(500L).setListener(null);
      }
    }
    AppMethodBeat.o(146907);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(146898);
    super.onResume();
    com.tencent.mm.plugin.appbrand.permission.e locale = this.cfa;
    LinkedList localLinkedList = new LinkedList();
    synchronized (locale.lIG)
    {
      localLinkedList.addAll(locale.lIG);
      locale.lIG.clear();
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((e.b)((Iterator)???).next()).a(e.a.bsa());
      }
    }
    AppMethodBeat.o(146898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.c
 * JD-Core Version:    0.7.0.1
 */