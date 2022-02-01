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
  public o cid;
  private Boolean cie = null;
  public volatile com.tencent.mm.plugin.appbrand.permission.e cif;
  
  static
  {
    AppMethodBeat.i(182987);
    bm.a(d.cii);
    AppMethodBeat.o(182987);
  }
  
  public c(ai paramai)
  {
    super(paramai);
  }
  
  private static boolean a(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    AppMethodBeat.i(146913);
    if ((paramAppBrandInitConfigLU.cfe) && ((c(paramAppBrandInitConfigLU)) || (b(paramAppBrandInitConfigLU))))
    {
      AppMethodBeat.o(146913);
      return true;
    }
    AppMethodBeat.o(146913);
    return false;
  }
  
  private static boolean b(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    return paramAppBrandInitConfigLU.cfo.scene == 1101;
  }
  
  private static boolean c(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    paramAppBrandInitConfigLU = paramAppBrandInitConfigLU.cfo;
    return (paramAppBrandInitConfigLU.scene == 1011) || (paramAppBrandInitConfigLU.scene == 1012) || (paramAppBrandInitConfigLU.scene == 1013);
  }
  
  public final AppBrandStatObject CY()
  {
    AppMethodBeat.i(146905);
    AppBrandStatObject localAppBrandStatObject = DZ().cfo;
    AppMethodBeat.o(146905);
    return localAppBrandStatObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.e DU()
  {
    return this.cif;
  }
  
  public final int DV()
  {
    AppMethodBeat.i(146897);
    if (j.a.nz(this.iDx.iOP))
    {
      AppMethodBeat.o(146897);
      return 0;
    }
    int i = DZ().aAS;
    AppMethodBeat.o(146897);
    return i;
  }
  
  public final ar DW()
  {
    AppMethodBeat.i(146901);
    ar localar = (ar)super.Ee();
    AppMethodBeat.o(146901);
    return localar;
  }
  
  public p DX()
  {
    AppMethodBeat.i(146902);
    Object localObject = DY();
    if (localObject == null) {
      ad.e("Luggage.WXA.AppBrandRuntimeLU", "createFileSystem but get NUL sysConfig, appId:%s", new Object[] { this.mAppId });
    }
    for (localObject = new com.tencent.mm.plugin.appbrand.jsapi.file.d();; localObject = com.tencent.mm.plugin.appbrand.config.e.a((AppBrandSysConfigLU)localObject))
    {
      localObject = new ar(this, (com.tencent.mm.plugin.appbrand.jsapi.file.d)localObject);
      AppMethodBeat.o(146902);
      return localObject;
    }
  }
  
  public AppBrandSysConfigLU DY()
  {
    AppMethodBeat.i(146903);
    AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)c(AppBrandSysConfigLU.class, false);
    AppMethodBeat.o(146903);
    return localAppBrandSysConfigLU;
  }
  
  public AppBrandInitConfigLU DZ()
  {
    AppMethodBeat.i(146904);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.Eg();
    AppMethodBeat.o(146904);
    return localAppBrandInitConfigLU;
  }
  
  public void Ea()
  {
    AppMethodBeat.i(146909);
    super.Ea();
    if (ab(ICommLibReader.class) == null) {
      b(ICommLibReader.class, AssetReader.iLr);
    }
    Object localObject = new y((ICommLibReader)ab(ICommLibReader.class), be.U(this));
    this.iDG.add(localObject);
    if (this.cif == null)
    {
      localObject = new IllegalStateException("Should ensure ApiPermissionController installed before init. Use #setApiPermissionController().");
      AppMethodBeat.o(146909);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(146909);
  }
  
  protected o Eb()
  {
    AppMethodBeat.i(146911);
    o localo = new o(com.tencent.mm.sdk.f.a.iV(this.mContext), this);
    AppMethodBeat.o(146911);
    return localo;
  }
  
  public boolean Ec()
  {
    AppMethodBeat.i(146912);
    if (this.cie != null)
    {
      bool = this.cie.booleanValue();
      AppMethodBeat.o(146912);
      return bool;
    }
    Boolean localBoolean = Boolean.valueOf(a(DZ()));
    this.cie = localBoolean;
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(146912);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.o.a Ed()
  {
    AppMethodBeat.i(146914);
    if ((DY() != null) && (!bt.gL(DY().jdS.iOT))) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = new com.tencent.mm.plugin.appbrand.o.g(this);
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
    if (h.class == paramClass)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(k.ljd);
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
    boolean bool1 = Ec();
    boolean bool2 = a((AppBrandInitConfigLU)paramAppBrandInitConfig);
    int i;
    if (((!bool1) && (bool2)) || ((bool1) && (!bool2) && (c((AppBrandInitConfigLU)paramAppBrandInitConfig))))
    {
      i = 1;
      if (i != 0)
      {
        this.cie = null;
        aMc();
      }
      if ((!this.iDM) && (!isDestroyed())) {
        if ((j.a.qD(this.iDx.iOP)) && (((AppBrandInitConfigLU)paramAppBrandInitConfig).aAS != DY().jdS.pkgVersion))
        {
          String str = String.format(Locale.ENGLISH, "Updated InitConfig.appVersion != getSysConfig().appVersion, appId:%s, @smoothieli", new Object[] { this.mAppId });
          ad.w("Luggage.WXA.AppBrandRuntimeLU", str);
          if (!this.iDV) {
            break label194;
          }
          Assert.fail(str);
        }
      }
    }
    for (;;)
    {
      if (b(paramAppBrandInitConfig)) {
        aMd();
      }
      super.a(paramAppBrandInitConfig);
      AppMethodBeat.o(146899);
      return;
      i = 0;
      break;
      label194:
      aMc();
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
        AppBrandInitConfigLU localAppBrandInitConfigLU = DZ().De();
        AppBrandLaunchReferrer localAppBrandLaunchReferrer1 = localAppBrandInitConfigLU.cfi;
        localMiniProgramNavigationBackResult = (MiniProgramNavigationBackResult)paramObject;
        AppBrandLaunchReferrer localAppBrandLaunchReferrer2 = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer2.appId = paramAppBrandInitConfig.appId;
        localAppBrandLaunchReferrer2.jdC = 3;
        if (localMiniProgramNavigationBackResult == null)
        {
          paramObject = null;
          localAppBrandLaunchReferrer2.dqq = paramObject;
          if (localMiniProgramNavigationBackResult != null) {
            break label234;
          }
          paramObject = null;
          localAppBrandLaunchReferrer2.jdD = paramObject;
          localAppBrandLaunchReferrer1.a(localAppBrandLaunchReferrer2);
          paramObject = new AppBrandStatObject();
          paramObject.scene = 1038;
          if ((paramAppBrandInitConfig instanceof AppBrandInitConfigLU)) {
            paramObject.dbt = (paramAppBrandInitConfig.appId + ':' + ((AppBrandInitConfigLU)paramAppBrandInitConfig).Da() + ':' + (((AppBrandInitConfigLU)paramAppBrandInitConfig).cfd + 1000));
          }
          localAppBrandInitConfigLU.startTime = bt.eGO();
          localAppBrandInitConfigLU.iJb = null;
          localAppBrandInitConfigLU.resetSession();
          localAppBrandInitConfigLU.cfo = paramObject;
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
      paramObject = localMiniProgramNavigationBackResult.iHT.toString();
      continue;
      label234:
      paramObject = localMiniProgramNavigationBackResult.iHU.toString();
    }
  }
  
  protected boolean b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(146900);
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.iJb))
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
    if (this.cid != null)
    {
      if ((this.cid.getParent() instanceof ViewGroup))
      {
        ??? = this.cid;
        AppBrandPerformanceManager.Ma(((o)???).chU.mAppId);
        ((o)???).animate().alpha(0.0F).setDuration(500L).setListener(new o.1((o)???));
        ((ViewGroup)this.cid.getParent()).removeView(this.cid);
      }
      this.cid = null;
    }
    com.tencent.mm.plugin.appbrand.permission.e locale;
    if (this.cif != null) {
      locale = this.cif;
    }
    synchronized (locale.liO)
    {
      locale.liO.clear();
      this.cif = null;
      AppMethodBeat.o(146910);
      return;
    }
  }
  
  public void onReady()
  {
    AppMethodBeat.i(146907);
    super.onReady();
    if ((AppBrandPerformanceManager.d(this)) && (this.cid == null))
    {
      AppBrandPerformanceManager.c(this);
      this.cid = Eb();
      if (this.cid != null)
      {
        this.iDA.addView(this.cid);
        o localo = this.cid;
        AppBrandPerformanceManager.e(localo.chU);
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
    com.tencent.mm.plugin.appbrand.permission.e locale = this.cif;
    LinkedList localLinkedList = new LinkedList();
    synchronized (locale.liO)
    {
      localLinkedList.addAll(locale.liO);
      locale.liO.clear();
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((e.b)((Iterator)???).next()).a(e.a.bll());
      }
    }
    AppMethodBeat.o(146898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.c
 * JD-Core Version:    0.7.0.1
 */