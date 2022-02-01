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
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bn;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.m.g;
import com.tencent.mm.plugin.appbrand.m.h.a;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.permission.d.a;
import com.tencent.mm.plugin.appbrand.permission.d.b;
import com.tencent.mm.plugin.appbrand.permission.h;
import com.tencent.mm.plugin.appbrand.permission.i;
import com.tencent.mm.plugin.appbrand.permission.j;
import com.tencent.mm.plugin.appbrand.permission.l;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.p.1;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import junit.framework.Assert;
import org.json.JSONObject;

public class c
  extends AppBrandRuntime
{
  public com.tencent.mm.plugin.appbrand.ui.p cpp;
  private Boolean cpq = null;
  public volatile com.tencent.mm.plugin.appbrand.permission.d cpr;
  
  static
  {
    AppMethodBeat.i(182987);
    bn.a(d.cpu);
    WxaPkgWrappingInfo.a(h.a.lVd);
    AppMethodBeat.o(182987);
  }
  
  public c(ai paramai)
  {
    super(paramai);
  }
  
  private static boolean a(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    AppMethodBeat.i(146913);
    if ((paramAppBrandInitConfigLU.cms) && ((c(paramAppBrandInitConfigLU)) || (b(paramAppBrandInitConfigLU))))
    {
      AppMethodBeat.o(146913);
      return true;
    }
    AppMethodBeat.o(146913);
    return false;
  }
  
  private static boolean b(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    return paramAppBrandInitConfigLU.cmC.scene == 1101;
  }
  
  private static boolean c(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    paramAppBrandInitConfigLU = paramAppBrandInitConfigLU.cmC;
    return (paramAppBrandInitConfigLU.scene == 1011) || (paramAppBrandInitConfigLU.scene == 1012) || (paramAppBrandInitConfigLU.scene == 1013);
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.d EW()
  {
    return this.cpr;
  }
  
  public final int EX()
  {
    AppMethodBeat.i(146897);
    if (j.a.oN(this.jwG.dPf))
    {
      AppMethodBeat.o(146897);
      return 0;
    }
    int i = Fb().aDD;
    AppMethodBeat.o(146897);
    return i;
  }
  
  public final ar EY()
  {
    AppMethodBeat.i(146901);
    ar localar = (ar)super.Fg();
    AppMethodBeat.o(146901);
    return localar;
  }
  
  public com.tencent.mm.plugin.appbrand.appstorage.p EZ()
  {
    AppMethodBeat.i(146902);
    Object localObject = Fa();
    if (localObject == null) {
      ad.e("Luggage.WXA.AppBrandRuntimeLU", "createFileSystem but get NUL sysConfig, appId:%s", new Object[] { this.mAppId });
    }
    for (localObject = new com.tencent.mm.plugin.appbrand.jsapi.file.d();; localObject = e.a((AppBrandSysConfigLU)localObject))
    {
      localObject = new ar(this, (com.tencent.mm.plugin.appbrand.jsapi.file.d)localObject);
      AppMethodBeat.o(146902);
      return localObject;
    }
  }
  
  public final AppBrandStatObject Ea()
  {
    AppMethodBeat.i(146905);
    AppBrandStatObject localAppBrandStatObject = Fb().cmC;
    AppMethodBeat.o(146905);
    return localAppBrandStatObject;
  }
  
  public AppBrandSysConfigLU Fa()
  {
    AppMethodBeat.i(146903);
    AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)c(AppBrandSysConfigLU.class, false);
    AppMethodBeat.o(146903);
    return localAppBrandSysConfigLU;
  }
  
  public AppBrandInitConfigLU Fb()
  {
    AppMethodBeat.i(146904);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.Fi();
    AppMethodBeat.o(146904);
    return localAppBrandInitConfigLU;
  }
  
  public void Fc()
  {
    AppMethodBeat.i(146909);
    super.Fc();
    if (ab(ICommLibReader.class) == null) {
      b(ICommLibReader.class, AssetReader.jFo);
    }
    Object localObject = new y((ICommLibReader)ab(ICommLibReader.class), bf.O(this));
    this.jwO.add(localObject);
    if (this.cpr == null)
    {
      localObject = new IllegalStateException("Should ensure ApiPermissionController installed before init. Use #setApiPermissionController().");
      AppMethodBeat.o(146909);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(146909);
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.p Fd()
  {
    AppMethodBeat.i(146911);
    com.tencent.mm.plugin.appbrand.ui.p localp = new com.tencent.mm.plugin.appbrand.ui.p(com.tencent.mm.sdk.f.a.jq(this.mContext), this);
    AppMethodBeat.o(146911);
    return localp;
  }
  
  public boolean Fe()
  {
    AppMethodBeat.i(146912);
    if (this.cpq != null)
    {
      bool = this.cpq.booleanValue();
      AppMethodBeat.o(146912);
      return bool;
    }
    Boolean localBoolean = Boolean.valueOf(a(Fb()));
    this.cpq = localBoolean;
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(146912);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.m.a Ff()
  {
    AppMethodBeat.i(146914);
    if ((Fa() != null) && ((!bt.hj(Fa().jYh.jIX)) || (Fb().Eb()))) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = new g(this);
      AppMethodBeat.o(146914);
      return localObject;
    }
    Object localObject = new a.a(this, (byte)0);
    AppMethodBeat.o(146914);
    return localObject;
  }
  
  public final <T extends com.tencent.mm.kernel.c.a> T S(Class<T> paramClass)
  {
    AppMethodBeat.i(169457);
    if (i.class == paramClass)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(l.mii);
      AppMethodBeat.o(169457);
      return paramClass;
    }
    if (h.class == paramClass)
    {
      j localj = new j(this);
      b(h.class, localj);
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(localj);
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
    boolean bool1 = Fe();
    boolean bool2 = a((AppBrandInitConfigLU)paramAppBrandInitConfig);
    int i;
    if (((!bool1) && (bool2)) || ((bool1) && (!bool2) && (c((AppBrandInitConfigLU)paramAppBrandInitConfig))))
    {
      i = 1;
      if (i != 0)
      {
        this.cpq = null;
        aWg();
      }
      if ((!this.jwU) && (!isDestroyed())) {
        if ((j.a.rQ(this.jwG.dPf)) && (((AppBrandInitConfigLU)paramAppBrandInitConfig).aDD != Fa().jYh.pkgVersion))
        {
          String str = String.format(Locale.ENGLISH, "Updated InitConfig.appVersion != getSysConfig().appVersion, appId:%s, @smoothieli", new Object[] { this.mAppId });
          ad.w("Luggage.WXA.AppBrandRuntimeLU", str);
          if (!this.jxf) {
            break label194;
          }
          Assert.fail(str);
        }
      }
    }
    for (;;)
    {
      if (b(paramAppBrandInitConfig)) {
        aWh();
      }
      super.a(paramAppBrandInitConfig);
      AppMethodBeat.o(146899);
      return;
      i = 0;
      break;
      label194:
      aWg();
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
        AppBrandInitConfigLU localAppBrandInitConfigLU = Fb().Eg();
        AppBrandLaunchReferrer localAppBrandLaunchReferrer1 = localAppBrandInitConfigLU.cmv;
        localMiniProgramNavigationBackResult = (MiniProgramNavigationBackResult)paramObject;
        AppBrandLaunchReferrer localAppBrandLaunchReferrer2 = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer2.appId = paramAppBrandInitConfig.appId;
        localAppBrandLaunchReferrer2.jXR = 3;
        if (localMiniProgramNavigationBackResult == null)
        {
          paramObject = null;
          localAppBrandLaunchReferrer2.dzP = paramObject;
          if (localMiniProgramNavigationBackResult != null) {
            break label234;
          }
          paramObject = null;
          localAppBrandLaunchReferrer2.jXS = paramObject;
          localAppBrandLaunchReferrer1.a(localAppBrandLaunchReferrer2);
          paramObject = new AppBrandStatObject();
          paramObject.scene = 1038;
          if ((paramAppBrandInitConfig instanceof AppBrandInitConfigLU)) {
            paramObject.dkh = (paramAppBrandInitConfig.appId + ':' + ((AppBrandInitConfigLU)paramAppBrandInitConfig).Ec() + ':' + (((AppBrandInitConfigLU)paramAppBrandInitConfig).cmr + 1000));
          }
          localAppBrandInitConfigLU.startTime = bt.flT();
          localAppBrandInitConfigLU.jCN = null;
          localAppBrandInitConfigLU.resetSession();
          localAppBrandInitConfigLU.cmC = paramObject;
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
      paramObject = localMiniProgramNavigationBackResult.jBe.toString();
      continue;
      label234:
      paramObject = localMiniProgramNavigationBackResult.jBf.toString();
    }
  }
  
  protected boolean b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(146900);
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.jCN))
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
    if (this.cpp != null)
    {
      if ((this.cpp.getParent() instanceof ViewGroup))
      {
        ??? = this.cpp;
        AppBrandPerformanceManager.TL(((com.tencent.mm.plugin.appbrand.ui.p)???).cpg.mAppId);
        ((com.tencent.mm.plugin.appbrand.ui.p)???).animate().alpha(0.0F).setDuration(500L).setListener(new p.1((com.tencent.mm.plugin.appbrand.ui.p)???));
        ((ViewGroup)this.cpp.getParent()).removeView(this.cpp);
      }
      this.cpp = null;
    }
    com.tencent.mm.plugin.appbrand.permission.d locald;
    if (this.cpr != null) {
      locald = this.cpr;
    }
    synchronized (locald.mhT)
    {
      locald.mhT.clear();
      this.cpr = null;
      AppMethodBeat.o(146910);
      return;
    }
  }
  
  public void onReady()
  {
    AppMethodBeat.i(146907);
    super.onReady();
    if ((AppBrandPerformanceManager.e(this)) && (this.cpp == null))
    {
      AppBrandPerformanceManager.d(this);
      this.cpp = Fd();
      if (this.cpp != null)
      {
        this.jwJ.addView(this.cpp);
        com.tencent.mm.plugin.appbrand.ui.p localp = this.cpp;
        AppBrandPerformanceManager.f(localp.cpg);
        localp.setVisibility(0);
        localp.setAlpha(0.0F);
        localp.animate().alpha(1.0F).setDuration(500L).setStartDelay(500L).setListener(null);
      }
    }
    AppMethodBeat.o(146907);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(146898);
    super.onResume();
    com.tencent.mm.plugin.appbrand.permission.d locald = this.cpr;
    LinkedList localLinkedList = new LinkedList();
    synchronized (locald.mhT)
    {
      localLinkedList.addAll(locald.mhT);
      locald.mhT.clear();
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((d.b)((Iterator)???).next()).a(d.a.bvY());
      }
    }
    AppMethodBeat.o(146898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.c
 * JD-Core Version:    0.7.0.1
 */