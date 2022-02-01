package com.tencent.mm.plugin.appbrand.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.pp.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI1;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI2;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI3;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI4;
import com.tencent.mm.plugin.appbrand.appstorage.ab;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.task.h.c;
import com.tencent.mm.plugin.appbrand.task.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class e
{
  private static final Map<String, Class<? extends AppBrandAdUI>> nAp;
  private static Set<String> nAq;
  
  static
  {
    AppMethodBeat.i(44039);
    Object localObject = new HashMap();
    ((Map)localObject).put(":appbrand0", AppBrandAdUI.class);
    ((Map)localObject).put(":appbrand1", AppBrandAdUI1.class);
    ((Map)localObject).put(":appbrand2", AppBrandAdUI2.class);
    ((Map)localObject).put(":appbrand3", AppBrandAdUI3.class);
    ((Map)localObject).put(":appbrand4", AppBrandAdUI4.class);
    nAp = Collections.unmodifiableMap((Map)localObject);
    localObject = new HashSet();
    nAq = (Set)localObject;
    ((Set)localObject).add("shouldShowSplashAd");
    nAq.add("onSplashAdShow");
    nAq.add("onSplashAdHide");
    nAq.add("onSplashAdClose");
    nAq.add("onSplashAdButtonClicked");
    nAq.add("onTouchStart");
    nAq.add("onTouchEnd");
    nAq.add("onTouchCancel");
    nAq.add("onTouchMove");
    nAq.add("onLongPress");
    AppMethodBeat.o(44039);
  }
  
  public static boolean I(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44026);
    if (!b.bED())
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, showad experiment closed");
      AppMethodBeat.o(44026);
      return false;
    }
    if (!(paramAppBrandRuntime instanceof t))
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, wrong runtime");
      AppMethodBeat.o(44026);
      return false;
    }
    paramAppBrandRuntime = (t)paramAppBrandRuntime;
    if (t.bDH() <= 0)
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, timeThreshold invalid");
      AppMethodBeat.o(44026);
      return false;
    }
    if (com.tencent.mm.plugin.appbrand.task.h.i(n.jA(paramAppBrandRuntime.bDy().Qv())) != null) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, process not preloaded");
      AppMethodBeat.o(44026);
      return false;
    }
    if (paramAppBrandRuntime.bDl())
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, ignore plugin app, appId:%s", new Object[] { paramAppBrandRuntime.mAppId });
      AppMethodBeat.o(44026);
      return false;
    }
    i = paramAppBrandRuntime.Sk().cxf.scene;
    if (!b.yW(i))
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, scene not fit:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(44026);
      return false;
    }
    boolean bool;
    if (!b.bED())
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, showad experiment closed");
      bool = false;
    }
    while (!bool)
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, not ad contact, appId:%s", new Object[] { paramAppBrandRuntime.mAppId });
      AppMethodBeat.o(44026);
      return false;
      if ((paramAppBrandRuntime == null) || (!(paramAppBrandRuntime.Sq() instanceof AppBrandInitConfigWC)))
      {
        Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, null runtime or wrong initConfig");
        bool = false;
      }
      else
      {
        bool = ((AppBrandInitConfigWC)paramAppBrandRuntime.Sq()).nYm;
        if (b.bEF())
        {
          Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, set to all show ad");
          bool = true;
        }
        Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, appId:%s, canShowAd:%s", new Object[] { paramAppBrandRuntime.mAppId, Boolean.valueOf(bool) });
      }
    }
    AppMethodBeat.o(44026);
    return true;
  }
  
  public static void J(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44030);
    if (!(paramAppBrandRuntime instanceof t))
    {
      AppMethodBeat.o(44030);
      return;
    }
    com.tencent.mm.plugin.appbrand.service.c localc = ((t)paramAppBrandRuntime).bDA();
    if ((paramAppBrandRuntime.bCB()) && (localc != null))
    {
      paramAppBrandRuntime = new com.tencent.mm.plugin.appbrand.ad.a.e();
      paramAppBrandRuntime.source = "launch";
      paramAppBrandRuntime.a(localc);
    }
    AppMethodBeat.o(44030);
  }
  
  public static void K(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44031);
    if (!(paramAppBrandRuntime instanceof t))
    {
      AppMethodBeat.o(44031);
      return;
    }
    if (paramAppBrandRuntime.bCB())
    {
      com.tencent.mm.plugin.appbrand.ad.a.d locald = new com.tencent.mm.plugin.appbrand.ad.a.d();
      locald.source = "launch";
      locald.a(((t)paramAppBrandRuntime).bDA());
    }
    AppMethodBeat.o(44031);
  }
  
  public static void M(String paramString, long paramLong)
  {
    AppMethodBeat.i(283855);
    if (s.abV(paramString).nvY.nAl == 0L) {
      s.abW(paramString).nvY.nAl = paramLong;
    }
    AppMethodBeat.o(283855);
  }
  
  public static void N(String paramString, long paramLong)
  {
    AppMethodBeat.i(283856);
    if (s.abV(paramString).nvY.nAm == 0L) {
      s.abW(paramString).nvY.nAm = paramLong;
    }
    AppMethodBeat.o(283856);
  }
  
  public static void a(t paramt, h.c paramc, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(283852);
    int i;
    String str;
    int k;
    pp.a locala;
    int m;
    int n;
    switch (1.nAr[paramc.ordinal()])
    {
    default: 
      i = 1;
      paramt = new QualitySession("", paramt.bDy(), paramt.Sk().cxf);
      paramc = com.tencent.mm.plugin.report.service.h.IzE;
      str = paramt.appId;
      k = paramt.qNx;
      locala = pp.a.oM(paramt.qLQ);
      m = paramt.apptype;
      n = paramt.scene;
      if (!paramBoolean) {
        break;
      }
    }
    for (;;)
    {
      paramc.a(21052, new Object[] { str, Integer.valueOf(k), locala, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(283852);
      return;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      j = 0;
    }
  }
  
  public static boolean a(o paramo)
  {
    return paramo instanceof com.tencent.mm.plugin.appbrand.c;
  }
  
  public static boolean ach(String paramString)
  {
    AppMethodBeat.i(44025);
    boolean bool = nAq.contains(paramString);
    AppMethodBeat.o(44025);
    return bool;
  }
  
  public static String aci(String paramString)
  {
    AppMethodBeat.i(44035);
    paramString = s.abV(paramString).nvY.name;
    AppMethodBeat.o(44035);
    return paramString;
  }
  
  public static String acj(String paramString)
  {
    AppMethodBeat.i(44037);
    paramString = s.abV(paramString).nvY.icon;
    AppMethodBeat.o(44037);
    return paramString;
  }
  
  public static void ag(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(44034);
    s.abW(paramString).nvY.nzY = paramBoolean;
    AppMethodBeat.o(44034);
  }
  
  public static r bEH()
  {
    AppMethodBeat.i(174694);
    ab localab = e.a.bEJ();
    AppMethodBeat.o(174694);
    return localab;
  }
  
  public static boolean bEI()
  {
    return true;
  }
  
  public static void c(ad paramad)
  {
    AppMethodBeat.i(44028);
    if (paramad != null) {}
    try
    {
      if (paramad.getContext() != null) {}
      for (Context localContext = paramad.getContext();; localContext = MMApplicationContext.getContext())
      {
        String str1 = MMApplicationContext.getProcessName();
        String str2 = MMApplicationContext.getPackageName();
        paramad = new Intent(localContext, (Class)nAp.get(str1.replaceFirst(str2, ""))).putExtra("appId", paramad.getAppId());
        if (!(localContext instanceof Activity)) {
          paramad.addFlags(268435456);
        }
        paramad = new com.tencent.mm.hellhoundlib.b.a().bm(paramad);
        com.tencent.mm.hellhoundlib.a.a.b(localContext, paramad.aFh(), "com/tencent/mm/plugin/appbrand/ad/AppBrandAdUtils", "openAdUIFromMenu", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)paramad.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/appbrand/ad/AppBrandAdUtils", "openAdUIFromMenu", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(44028);
        return;
      }
      return;
    }
    catch (Exception paramad)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", paramad, "openAdUIFromMenu fail", new Object[0]);
      AppMethodBeat.o(44028);
    }
  }
  
  public static void cr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44036);
    s.abW(paramString1).nvY.name = paramString2;
    AppMethodBeat.o(44036);
  }
  
  public static void cs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44038);
    s.abW(paramString1).nvY.icon = paramString2;
    AppMethodBeat.o(44038);
  }
  
  public static boolean d(ad paramad)
  {
    AppMethodBeat.i(44032);
    if ((s.abV(paramad.getAppId()).nvY.nzY) && (!Util.isNullOrNil(aci(paramad.getAppId()))))
    {
      AppMethodBeat.o(44032);
      return true;
    }
    AppMethodBeat.o(44032);
    return false;
  }
  
  public static boolean dD(Context paramContext)
  {
    return paramContext instanceof AppBrandAdUI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.e
 * JD-Core Version:    0.7.0.1
 */