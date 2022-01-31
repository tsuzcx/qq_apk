package com.tencent.luggage.sdk.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.luggage.sdk.c.a.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.file.an;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.permission.f;
import com.tencent.mm.plugin.appbrand.permission.h;
import com.tencent.mm.plugin.appbrand.permission.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.plugin.appbrand.ui.l.1;
import com.tencent.mm.sdk.platformtools.bo;

public class b
  extends i
{
  public l bFj;
  private Boolean bFk = null;
  
  public b(Context paramContext, ad paramad)
  {
    super(paramContext, paramad);
  }
  
  private static boolean a(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    AppMethodBeat.i(101697);
    if ((paramAppBrandInitConfigLU.bCW) && (b(paramAppBrandInitConfigLU)))
    {
      AppMethodBeat.o(101697);
      return true;
    }
    AppMethodBeat.o(101697);
    return false;
  }
  
  private static boolean b(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    paramAppBrandInitConfigLU = paramAppBrandInitConfigLU.bDh;
    return (paramAppBrandInitConfigLU.scene == 1011) || (paramAppBrandInitConfigLU.scene == 1012) || (paramAppBrandInitConfigLU.scene == 1013);
  }
  
  public void a(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(101686);
    if (!this.mInitialized)
    {
      AppMethodBeat.o(101686);
      return;
    }
    boolean bool1 = wV();
    boolean bool2 = a((AppBrandInitConfigLU)paramAppBrandInitConfig);
    if (((!bool1) && (bool2)) || ((bool1) && (!bool2) && (b((AppBrandInitConfigLU)paramAppBrandInitConfig)))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.bFk = null;
        aty();
      }
      if ((!this.gPN) && (b(paramAppBrandInitConfig)))
      {
        this.gPO = true;
        com.tencent.luggage.g.d.d("MicroMsg.AppBrandRuntime", "setWillRelaunch");
      }
      super.a(paramAppBrandInitConfig);
      AppMethodBeat.o(101686);
      return;
    }
  }
  
  protected boolean b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(140805);
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.hiw))
    {
      AppMethodBeat.o(140805);
      return true;
    }
    AppMethodBeat.o(140805);
    return false;
  }
  
  public final void c(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(101690);
    AppBrandInitConfigLU localAppBrandInitConfigLU = wS().wc();
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1038;
    if ((paramAppBrandInitConfig instanceof AppBrandInitConfigLU)) {
      localAppBrandStatObject.cmF = (paramAppBrandInitConfig.appId + ':' + ((AppBrandInitConfigLU)paramAppBrandInitConfig).vZ() + ':' + (((AppBrandInitConfigLU)paramAppBrandInitConfig).bCV + 1000));
    }
    localAppBrandInitConfigLU.startTime = bo.aoy();
    localAppBrandInitConfigLU.hiw = null;
    localAppBrandInitConfigLU.resetSession();
    localAppBrandInitConfigLU.bDh = localAppBrandStatObject;
    e(localAppBrandInitConfigLU);
    AppMethodBeat.o(101690);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(101692);
    super.onCreate();
    b(com.tencent.mm.plugin.appbrand.permission.g.class, j.iCe);
    b(f.class, new h(this));
    AppMethodBeat.o(101692);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(101694);
    super.onDestroy();
    if (this.bFj != null)
    {
      if ((this.bFj.getParent() instanceof ViewGroup))
      {
        l locall = this.bFj;
        AppBrandPerformanceManager.Eu(locall.bEZ.mAppId);
        locall.animate().alpha(0.0F).setDuration(500L).setListener(new l.1(locall));
        ((ViewGroup)this.bFj.getParent()).removeView(this.bFj);
      }
      this.bFj = null;
    }
    AppMethodBeat.o(101694);
  }
  
  public void onReady()
  {
    AppMethodBeat.i(101691);
    if ((AppBrandPerformanceManager.d(this)) && (this.bFj == null))
    {
      AppBrandPerformanceManager.c(this);
      this.bFj = wU();
      if (this.bFj != null)
      {
        this.gPC.addView(this.bFj);
        l locall = this.bFj;
        AppBrandPerformanceManager.e(locall.bEZ);
        locall.setVisibility(0);
        locall.setAlpha(0.0F);
        locall.animate().alpha(1.0F).setDuration(500L).setStartDelay(500L).setListener(null);
      }
    }
    AppMethodBeat.o(101691);
  }
  
  public final AppBrandStatObject vX()
  {
    AppMethodBeat.i(101689);
    AppBrandStatObject localAppBrandStatObject = wS().bDh;
    AppMethodBeat.o(101689);
    return localAppBrandStatObject;
  }
  
  public com.tencent.mm.plugin.appbrand.permission.e wO()
  {
    AppMethodBeat.i(101685);
    com.tencent.mm.plugin.appbrand.permission.e locale = new com.tencent.mm.plugin.appbrand.permission.e(this, -1, true);
    AppMethodBeat.o(101685);
    return locale;
  }
  
  public final an wP()
  {
    AppMethodBeat.i(140806);
    an localan = (an)super.wX();
    AppMethodBeat.o(140806);
    return localan;
  }
  
  public com.tencent.mm.plugin.appbrand.appstorage.o wQ()
  {
    AppMethodBeat.i(140807);
    an localan = new an(this, com.tencent.mm.plugin.appbrand.config.d.a(wR()));
    AppMethodBeat.o(140807);
    return localan;
  }
  
  public AppBrandSysConfigLU wR()
  {
    AppMethodBeat.i(101687);
    AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)d(AppBrandSysConfigLU.class, false);
    AppMethodBeat.o(101687);
    return localAppBrandSysConfigLU;
  }
  
  public AppBrandInitConfigLU wS()
  {
    AppMethodBeat.i(101688);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.wZ();
    AppMethodBeat.o(101688);
    return localAppBrandInitConfigLU;
  }
  
  public final void wT()
  {
    AppMethodBeat.i(101693);
    super.wT();
    ax.a(this, (com.tencent.mm.plugin.appbrand.appcache.o)com.tencent.luggage.a.e.q(n.class));
    AppMethodBeat.o(101693);
  }
  
  protected l wU()
  {
    AppMethodBeat.i(101695);
    l locall = new l(getContext(), this);
    AppMethodBeat.o(101695);
    return locall;
  }
  
  public boolean wV()
  {
    AppMethodBeat.i(101696);
    if (this.bFk != null)
    {
      bool = this.bFk.booleanValue();
      AppMethodBeat.o(101696);
      return bool;
    }
    Boolean localBoolean = Boolean.valueOf(a(wS()));
    this.bFk = localBoolean;
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(101696);
    return bool;
  }
  
  public a wW()
  {
    AppMethodBeat.i(140808);
    if ((wR() != null) && (!bo.es(wR().hiX.gXi))) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = new com.tencent.mm.plugin.appbrand.k.g(this);
      AppMethodBeat.o(140808);
      return localObject;
    }
    Object localObject = new a.a(this, (byte)0);
    AppMethodBeat.o(140808);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.b
 * JD-Core Version:    0.7.0.1
 */