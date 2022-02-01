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
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.m.h.a;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.permission.d.a;
import com.tencent.mm.plugin.appbrand.permission.d.b;
import com.tencent.mm.plugin.appbrand.permission.j;
import com.tencent.mm.plugin.appbrand.permission.k;
import com.tencent.mm.plugin.appbrand.permission.l;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.q.1;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import junit.framework.Assert;
import org.json.JSONObject;

public class d
  extends AppBrandRuntime
{
  public com.tencent.mm.plugin.appbrand.ui.q cpS;
  private Boolean cpT = null;
  public volatile com.tencent.mm.plugin.appbrand.permission.d cpU;
  
  static
  {
    AppMethodBeat.i(182987);
    bo.a(g.cpX);
    WxaPkgWrappingInfo.a(h.a.lZG);
    AppMethodBeat.o(182987);
  }
  
  public d(ai paramai)
  {
    super(paramai);
  }
  
  private static boolean c(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    AppMethodBeat.i(146913);
    if ((paramAppBrandInitConfigLU.cmu) && ((e(paramAppBrandInitConfigLU)) || (d(paramAppBrandInitConfigLU))))
    {
      AppMethodBeat.o(146913);
      return true;
    }
    AppMethodBeat.o(146913);
    return false;
  }
  
  private static boolean d(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    return paramAppBrandInitConfigLU.cmE.scene == 1101;
  }
  
  private static boolean e(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    paramAppBrandInitConfigLU = paramAppBrandInitConfigLU.cmE;
    return (paramAppBrandInitConfigLU.scene == 1011) || (paramAppBrandInitConfigLU.scene == 1012) || (paramAppBrandInitConfigLU.scene == 1013);
  }
  
  public final AppBrandStatObject Ed()
  {
    AppMethodBeat.i(146905);
    AppBrandStatObject localAppBrandStatObject = Fg().cmE;
    AppMethodBeat.o(146905);
    return localAppBrandStatObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.d Fb()
  {
    return this.cpU;
  }
  
  public final int Fc()
  {
    AppMethodBeat.i(146897);
    if (j.a.oQ(this.jzC.dQv))
    {
      AppMethodBeat.o(146897);
      return 0;
    }
    int i = Fg().aDD;
    AppMethodBeat.o(146897);
    return i;
  }
  
  public final at Fd()
  {
    AppMethodBeat.i(146901);
    at localat = (at)super.Fl();
    AppMethodBeat.o(146901);
    return localat;
  }
  
  public com.tencent.mm.plugin.appbrand.appstorage.q Fe()
  {
    AppMethodBeat.i(146902);
    Object localObject = Ff();
    if (localObject == null) {
      ae.e("Luggage.WXA.AppBrandRuntimeLU", "createFileSystem but get NUL sysConfig, appId:%s", new Object[] { this.mAppId });
    }
    for (localObject = new com.tencent.mm.plugin.appbrand.jsapi.file.d();; localObject = e.a((AppBrandSysConfigLU)localObject))
    {
      localObject = new at(this, (com.tencent.mm.plugin.appbrand.jsapi.file.d)localObject);
      AppMethodBeat.o(146902);
      return localObject;
    }
  }
  
  public AppBrandSysConfigLU Ff()
  {
    AppMethodBeat.i(146903);
    AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)c(AppBrandSysConfigLU.class, false);
    AppMethodBeat.o(146903);
    return localAppBrandSysConfigLU;
  }
  
  public AppBrandInitConfigLU Fg()
  {
    AppMethodBeat.i(146904);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.Fn();
    AppMethodBeat.o(146904);
    return localAppBrandInitConfigLU;
  }
  
  public void Fh()
  {
    AppMethodBeat.i(146909);
    super.Fh();
    if (ab(ICommLibReader.class) == null) {
      b(ICommLibReader.class, AssetReader.jIn);
    }
    Object localObject = new x((ICommLibReader)ab(ICommLibReader.class), bg.M(this));
    this.jzM.add(localObject);
    if (this.cpU == null)
    {
      localObject = new IllegalStateException("Should ensure ApiPermissionController installed before init. Use #setApiPermissionController().");
      AppMethodBeat.o(146909);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(146909);
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.q Fi()
  {
    AppMethodBeat.i(146911);
    com.tencent.mm.plugin.appbrand.ui.q localq = new com.tencent.mm.plugin.appbrand.ui.q(com.tencent.mm.sdk.f.a.jw(this.mContext), this);
    AppMethodBeat.o(146911);
    return localq;
  }
  
  public boolean Fj()
  {
    AppMethodBeat.i(146912);
    if (this.cpT != null)
    {
      bool = this.cpT.booleanValue();
      AppMethodBeat.o(146912);
      return bool;
    }
    Boolean localBoolean = Boolean.valueOf(c(Fg()));
    this.cpT = localBoolean;
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(146912);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.m.a Fk()
  {
    AppMethodBeat.i(146914);
    if ((Ff() != null) && ((!bu.ht(Ff().kbw.jLY)) || (Fg().Ee()))) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = new com.tencent.mm.plugin.appbrand.m.g(this);
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
    if (k.class == paramClass)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(n.mng);
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
    boolean bool1 = Fj();
    boolean bool2 = c((AppBrandInitConfigLU)paramAppBrandInitConfig);
    int i;
    if (((!bool1) && (bool2)) || ((bool1) && (!bool2) && (e((AppBrandInitConfigLU)paramAppBrandInitConfig))))
    {
      i = 1;
      if (i != 0)
      {
        this.cpT = null;
        aWH();
      }
      if ((!this.jzS) && (!isDestroyed())) {
        if ((j.a.rT(this.jzC.dQv)) && (((AppBrandInitConfigLU)paramAppBrandInitConfig).aDD != Ff().kbw.pkgVersion))
        {
          String str = String.format(Locale.ENGLISH, "Updated InitConfig.appVersion != getSysConfig().appVersion, appId:%s, @smoothieli", new Object[] { this.mAppId });
          ae.w("Luggage.WXA.AppBrandRuntimeLU", str);
          if (!this.jAe) {
            break label194;
          }
          Assert.fail(str);
        }
      }
    }
    for (;;)
    {
      if (b(paramAppBrandInitConfig)) {
        aWI();
      }
      super.a(paramAppBrandInitConfig);
      AppMethodBeat.o(146899);
      return;
      i = 0;
      break;
      label194:
      aWH();
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
        AppBrandInitConfigLU localAppBrandInitConfigLU = Fg().Ej();
        AppBrandLaunchReferrer localAppBrandLaunchReferrer1 = localAppBrandInitConfigLU.cmx;
        localMiniProgramNavigationBackResult = (MiniProgramNavigationBackResult)paramObject;
        AppBrandLaunchReferrer localAppBrandLaunchReferrer2 = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer2.appId = paramAppBrandInitConfig.appId;
        localAppBrandLaunchReferrer2.kbg = 3;
        if (localMiniProgramNavigationBackResult == null)
        {
          paramObject = null;
          localAppBrandLaunchReferrer2.dAU = paramObject;
          if (localMiniProgramNavigationBackResult != null) {
            break label234;
          }
          paramObject = null;
          localAppBrandLaunchReferrer2.kbh = paramObject;
          localAppBrandLaunchReferrer1.a(localAppBrandLaunchReferrer2);
          paramObject = new AppBrandStatObject();
          paramObject.scene = 1038;
          if ((paramAppBrandInitConfig instanceof AppBrandInitConfigLU)) {
            paramObject.dlj = (paramAppBrandInitConfig.appId + ':' + ((AppBrandInitConfigLU)paramAppBrandInitConfig).Ef() + ':' + (((AppBrandInitConfigLU)paramAppBrandInitConfig).cmt + 1000));
          }
          localAppBrandInitConfigLU.startTime = bu.fpO();
          localAppBrandInitConfigLU.jFL = null;
          localAppBrandInitConfigLU.resetSession();
          localAppBrandInitConfigLU.cmE = paramObject;
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
      paramObject = localMiniProgramNavigationBackResult.jDP.toString();
      continue;
      label234:
      paramObject = localMiniProgramNavigationBackResult.jDQ.toString();
    }
  }
  
  protected boolean b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(146900);
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.jFL))
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
    if (this.cpS != null)
    {
      if ((this.cpS.getParent() instanceof ViewGroup))
      {
        ??? = this.cpS;
        AppBrandPerformanceManager.Uu(((com.tencent.mm.plugin.appbrand.ui.q)???).cpk.mAppId);
        ((com.tencent.mm.plugin.appbrand.ui.q)???).animate().alpha(0.0F).setDuration(500L).setListener(new q.1((com.tencent.mm.plugin.appbrand.ui.q)???));
        ((ViewGroup)this.cpS.getParent()).removeView(this.cpS);
      }
      this.cpS = null;
    }
    Object localObject2;
    if (this.cpU != null) {
      localObject2 = this.cpU;
    }
    synchronized (((com.tencent.mm.plugin.appbrand.permission.d)localObject2).mmR)
    {
      ((com.tencent.mm.plugin.appbrand.permission.d)localObject2).mmR.clear();
      this.cpU = null;
      ??? = (at)super.Fl();
      if (??? != null)
      {
        localObject2 = (com.tencent.mm.plugin.appbrand.appstorage.o)((v)???).av(com.tencent.mm.plugin.appbrand.appstorage.o.class);
        if (localObject2 != null) {
          com.tencent.mm.vfs.o.deleteFile(((com.tencent.mm.plugin.appbrand.appstorage.o)localObject2).jPJ + "/dir.lock");
        }
        ((v)???).release();
      }
      AppMethodBeat.o(146910);
      return;
    }
  }
  
  public void onReady()
  {
    AppMethodBeat.i(146907);
    super.onReady();
    if ((AppBrandPerformanceManager.e(this)) && (this.cpS == null))
    {
      AppBrandPerformanceManager.d(this);
      this.cpS = Fi();
      if (this.cpS != null)
      {
        this.jzF.addView(this.cpS);
        com.tencent.mm.plugin.appbrand.ui.q localq = this.cpS;
        AppBrandPerformanceManager.f(localq.cpk);
        localq.setVisibility(0);
        localq.setAlpha(0.0F);
        localq.animate().alpha(1.0F).setDuration(500L).setStartDelay(500L).setListener(null);
      }
    }
    AppMethodBeat.o(146907);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(146898);
    super.onResume();
    com.tencent.mm.plugin.appbrand.permission.d locald = this.cpU;
    LinkedList localLinkedList = new LinkedList();
    synchronized (locald.mmR)
    {
      localLinkedList.addAll(locald.mmR);
      locald.mmR.clear();
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((d.b)((Iterator)???).next()).a(d.a.bwP());
      }
    }
    AppMethodBeat.o(146898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.d
 * JD-Core Version:    0.7.0.1
 */