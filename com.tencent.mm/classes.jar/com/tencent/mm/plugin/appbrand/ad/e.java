package com.tencent.mm.plugin.appbrand.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.iu.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI1;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI2;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI3;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI4;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.task.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class e
{
  private static final Map<String, Class<? extends AppBrandAdUI>> jEY;
  private static Set<String> jEZ;
  
  static
  {
    AppMethodBeat.i(44039);
    Object localObject = new HashMap();
    ((Map)localObject).put(":appbrand0", AppBrandAdUI.class);
    ((Map)localObject).put(":appbrand1", AppBrandAdUI1.class);
    ((Map)localObject).put(":appbrand2", AppBrandAdUI2.class);
    ((Map)localObject).put(":appbrand3", AppBrandAdUI3.class);
    ((Map)localObject).put(":appbrand4", AppBrandAdUI4.class);
    jEY = Collections.unmodifiableMap((Map)localObject);
    localObject = new HashSet();
    jEZ = (Set)localObject;
    ((Set)localObject).add("shouldShowSplashAd");
    jEZ.add("onSplashAdShow");
    jEZ.add("onSplashAdHide");
    jEZ.add("onSplashAdClose");
    jEZ.add("onSplashAdButtonClicked");
    jEZ.add("onTouchStart");
    jEZ.add("onTouchEnd");
    jEZ.add("onTouchCancel");
    jEZ.add("onTouchMove");
    jEZ.add("onLongPress");
    AppMethodBeat.o(44039);
  }
  
  public static boolean H(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44026);
    if (!b.aYr())
    {
      ae.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, showad experiment closed");
      AppMethodBeat.o(44026);
      return false;
    }
    if (!(paramAppBrandRuntime instanceof p))
    {
      ae.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, wrong runtime");
      AppMethodBeat.o(44026);
      return false;
    }
    paramAppBrandRuntime = (p)paramAppBrandRuntime;
    if (p.aXF() <= 0)
    {
      ae.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, timeThreshold invalid");
      AppMethodBeat.o(44026);
      return false;
    }
    if (com.tencent.mm.plugin.appbrand.task.c.c(com.tencent.mm.plugin.appbrand.task.e.hB(paramAppBrandRuntime.aXx().Ee())) != null) {}
    for (int i = 1; i == 0; i = 0)
    {
      ae.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, process not preloaded");
      AppMethodBeat.o(44026);
      return false;
    }
    if (paramAppBrandRuntime.aXo())
    {
      ae.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, ignore plugin app, appId:%s", new Object[] { paramAppBrandRuntime.mAppId });
      AppMethodBeat.o(44026);
      return false;
    }
    i = paramAppBrandRuntime.Fg().cmE.scene;
    if (!b.rQ(i))
    {
      ae.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, scene not fit:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(44026);
      return false;
    }
    boolean bool;
    if (!b.aYr())
    {
      ae.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, showad experiment closed");
      bool = false;
    }
    while (!bool)
    {
      ae.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, not ad contact, appId:%s", new Object[] { paramAppBrandRuntime.mAppId });
      AppMethodBeat.o(44026);
      return false;
      if ((paramAppBrandRuntime == null) || (!(paramAppBrandRuntime.Fn() instanceof AppBrandInitConfigWC)))
      {
        ae.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, null runtime or wrong initConfig");
        bool = false;
      }
      else
      {
        bool = ((AppBrandInitConfigWC)paramAppBrandRuntime.Fn()).kaU;
        if (b.aYt())
        {
          ae.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, set to all show ad");
          bool = true;
        }
        ae.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, appId:%s, canShowAd:%s", new Object[] { paramAppBrandRuntime.mAppId, Boolean.valueOf(bool) });
      }
    }
    AppMethodBeat.o(44026);
    return true;
  }
  
  public static void I(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44030);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(44030);
      return;
    }
    if (paramAppBrandRuntime.aWP())
    {
      com.tencent.mm.plugin.appbrand.ad.a.e locale = new com.tencent.mm.plugin.appbrand.ad.a.e();
      locale.source = "launch";
      locale.c(paramAppBrandRuntime.Ey());
    }
    AppMethodBeat.o(44030);
  }
  
  public static void J(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44031);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(44031);
      return;
    }
    if (paramAppBrandRuntime.aWP())
    {
      com.tencent.mm.plugin.appbrand.ad.a.d locald = new com.tencent.mm.plugin.appbrand.ad.a.d();
      locald.source = "launch";
      locald.c(paramAppBrandRuntime.Ey());
    }
    AppMethodBeat.o(44031);
  }
  
  public static boolean Lo(String paramString)
  {
    AppMethodBeat.i(44025);
    boolean bool = jEZ.contains(paramString);
    AppMethodBeat.o(44025);
    return bool;
  }
  
  public static String Lp(String paramString)
  {
    AppMethodBeat.i(44035);
    paramString = o.Ld(paramString).jBS.name;
    AppMethodBeat.o(44035);
    return paramString;
  }
  
  public static String Lq(String paramString)
  {
    AppMethodBeat.i(44037);
    paramString = o.Ld(paramString).jBS.dEM;
    AppMethodBeat.o(44037);
    return paramString;
  }
  
  public static void M(String paramString, long paramLong)
  {
    AppMethodBeat.i(222057);
    if (o.Ld(paramString).jBS.jEU == 0L) {
      o.Le(paramString).jBS.jEU = paramLong;
    }
    AppMethodBeat.o(222057);
  }
  
  public static void N(String paramString, long paramLong)
  {
    AppMethodBeat.i(222058);
    if (o.Ld(paramString).jBS.jEV == 0L) {
      o.Le(paramString).jBS.jEV = paramLong;
    }
    AppMethodBeat.o(222058);
  }
  
  public static void a(p paramp, c.b paramb, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(222056);
    int i;
    String str;
    int k;
    iu.a locala;
    int m;
    int n;
    switch (1.jFa[paramb.ordinal()])
    {
    default: 
      i = 1;
      paramp = new QualitySession("", paramp.aXx(), paramp.Fg().cmE);
      paramb = g.yxI;
      str = paramp.appId;
      k = paramp.mAf;
      locala = iu.a.jz(paramp.myD);
      m = paramp.apptype;
      n = paramp.scene;
      if (!paramBoolean) {
        break;
      }
    }
    for (;;)
    {
      paramb.f(21052, new Object[] { str, Integer.valueOf(k), locala, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(222056);
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
  
  public static q aYv()
  {
    AppMethodBeat.i(174694);
    com.tencent.mm.plugin.appbrand.appstorage.z localz = a.aYw();
    AppMethodBeat.o(174694);
    return localz;
  }
  
  public static void ad(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(44034);
    o.Le(paramString).jBS.jEH = paramBoolean;
    AppMethodBeat.o(44034);
  }
  
  public static void bZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44036);
    o.Le(paramString1).jBS.name = paramString2;
    AppMethodBeat.o(44036);
  }
  
  public static void c(com.tencent.mm.plugin.appbrand.page.z paramz)
  {
    AppMethodBeat.i(44028);
    if (paramz != null) {}
    try
    {
      if (paramz.getContext() != null) {}
      for (Context localContext = paramz.getContext();; localContext = ak.getContext())
      {
        String str1 = ak.getProcessName();
        String str2 = ak.getPackageName();
        paramz = new Intent(localContext, (Class)jEY.get(str1.replaceFirst(str2, ""))).putExtra("appId", paramz.getAppId());
        if (!(localContext instanceof Activity)) {
          paramz.addFlags(268435456);
        }
        paramz = new com.tencent.mm.hellhoundlib.b.a().bc(paramz);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, paramz.ahE(), "com/tencent/mm/plugin/appbrand/ad/AppBrandAdUtils", "openAdUIFromMenu", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)paramz.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/appbrand/ad/AppBrandAdUtils", "openAdUIFromMenu", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(44028);
        return;
      }
      return;
    }
    catch (Exception paramz)
    {
      ae.printErrStackTrace("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", paramz, "openAdUIFromMenu fail", new Object[0]);
      AppMethodBeat.o(44028);
    }
  }
  
  public static void ca(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44038);
    o.Le(paramString1).jBS.dEM = paramString2;
    AppMethodBeat.o(44038);
  }
  
  public static boolean d(com.tencent.mm.plugin.appbrand.page.z paramz)
  {
    AppMethodBeat.i(44032);
    if ((o.Ld(paramz.getAppId()).jBS.jEH) && (!bu.isNullOrNil(Lp(paramz.getAppId()))))
    {
      AppMethodBeat.o(44032);
      return true;
    }
    AppMethodBeat.o(44032);
    return false;
  }
  
  public static boolean dj(Context paramContext)
  {
    return paramContext instanceof AppBrandAdUI;
  }
  
  static final class a
  {
    private static final com.tencent.mm.plugin.appbrand.appstorage.z jFb;
    
    static
    {
      AppMethodBeat.i(174693);
      com.tencent.mm.plugin.appbrand.appstorage.z localz = new com.tencent.mm.plugin.appbrand.appstorage.z(at.m(new String[] { "__ad" }), "wxfile://ad");
      jFb = localz;
      localz.jQA = 104857600L;
      AppMethodBeat.o(174693);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.e
 * JD-Core Version:    0.7.0.1
 */