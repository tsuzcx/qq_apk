package com.tencent.mm.plugin.appbrand.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ti.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI1;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI2;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI3;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI4;
import com.tencent.mm.plugin.appbrand.appstorage.af;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.task.h.c;
import com.tencent.mm.plugin.appbrand.task.l;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.plugin.expt.b.c.a;
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
  private static final Map<String, Class<? extends AppBrandAdUI>> qzv;
  private static Set<String> qzw;
  
  static
  {
    AppMethodBeat.i(44039);
    Object localObject = new HashMap();
    ((Map)localObject).put(":appbrand0", AppBrandAdUI.class);
    ((Map)localObject).put(":appbrand1", AppBrandAdUI1.class);
    ((Map)localObject).put(":appbrand2", AppBrandAdUI2.class);
    ((Map)localObject).put(":appbrand3", AppBrandAdUI3.class);
    ((Map)localObject).put(":appbrand4", AppBrandAdUI4.class);
    qzv = Collections.unmodifiableMap((Map)localObject);
    localObject = new HashSet();
    qzw = (Set)localObject;
    ((Set)localObject).add("shouldShowSplashAd");
    qzw.add("onSplashAdShow");
    qzw.add("onSplashAdHide");
    qzw.add("onSplashAdClose");
    qzw.add("onSplashAdButtonClicked");
    qzw.add("onTouchStart");
    qzw.add("onTouchEnd");
    qzw.add("onTouchCancel");
    qzw.add("onTouchMove");
    qzw.add("onLongPress");
    AppMethodBeat.o(44039);
  }
  
  public static boolean L(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44026);
    if (!b.cdO())
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, showad experiment closed");
      AppMethodBeat.o(44026);
      return false;
    }
    if (!(paramAppBrandRuntime instanceof com.tencent.mm.plugin.appbrand.w))
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, wrong runtime");
      AppMethodBeat.o(44026);
      return false;
    }
    paramAppBrandRuntime = (com.tencent.mm.plugin.appbrand.w)paramAppBrandRuntime;
    if (paramAppBrandRuntime.getInitConfig().qAT.isEnable())
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, do not show ad in half screen wxa");
      AppMethodBeat.o(44026);
      return false;
    }
    if (paramAppBrandRuntime.getInitConfig().aqE() == z.raW)
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, appId:%s, windowOpacity==TRANSPARENT, return false", new Object[] { paramAppBrandRuntime.mAppId });
      AppMethodBeat.o(44026);
      return false;
    }
    if (com.tencent.mm.plugin.appbrand.w.ccU() <= 0)
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, timeThreshold invalid");
      AppMethodBeat.o(44026);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yQp, 0) == 0)
    {
      if (com.tencent.mm.plugin.appbrand.task.h.i(l.kO(paramAppBrandRuntime.getInitConfig().aqJ())) != null) {}
      for (i = 1; i == 0; i = 0)
      {
        Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, process not preloaded");
        AppMethodBeat.o(44026);
        return false;
      }
    }
    if (paramAppBrandRuntime.ccB())
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, ignore plugin app, appId:%s", new Object[] { paramAppBrandRuntime.mAppId });
      AppMethodBeat.o(44026);
      return false;
    }
    int i = paramAppBrandRuntime.asA().epn.scene;
    if (!b.zf(i))
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, scene not fit:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(44026);
      return false;
    }
    if (!M(paramAppBrandRuntime))
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, not ad contact, appId:%s", new Object[] { paramAppBrandRuntime.mAppId });
      AppMethodBeat.o(44026);
      return false;
    }
    AppMethodBeat.o(44026);
    return true;
  }
  
  public static boolean M(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(162161);
    if (!b.cdO())
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, showad experiment closed");
      AppMethodBeat.o(162161);
      return false;
    }
    if ((paramAppBrandRuntime == null) || (!(paramAppBrandRuntime.asH() instanceof AppBrandInitConfigWC)))
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, null runtime or wrong initConfig");
      AppMethodBeat.o(162161);
      return false;
    }
    boolean bool = ((AppBrandInitConfigWC)paramAppBrandRuntime.asH()).qYo;
    if (b.cdQ())
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, set to all show ad");
      bool = true;
    }
    Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, appId:%s, canShowAd:%s", new Object[] { paramAppBrandRuntime.mAppId, Boolean.valueOf(bool) });
    AppMethodBeat.o(162161);
    return bool;
  }
  
  public static void N(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44030);
    if (!(paramAppBrandRuntime instanceof com.tencent.mm.plugin.appbrand.w))
    {
      AppMethodBeat.o(44030);
      return;
    }
    com.tencent.mm.plugin.appbrand.service.c localc = ((com.tencent.mm.plugin.appbrand.w)paramAppBrandRuntime).ccO();
    if ((paramAppBrandRuntime.cbO()) && (localc != null))
    {
      paramAppBrandRuntime = new com.tencent.mm.plugin.appbrand.ad.a.e();
      paramAppBrandRuntime.source = "launch";
      paramAppBrandRuntime.a(localc);
    }
    AppMethodBeat.o(44030);
  }
  
  public static void O(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44031);
    if (!(paramAppBrandRuntime instanceof com.tencent.mm.plugin.appbrand.w))
    {
      AppMethodBeat.o(44031);
      return;
    }
    if (paramAppBrandRuntime.cbO())
    {
      com.tencent.mm.plugin.appbrand.ad.a.d locald = new com.tencent.mm.plugin.appbrand.ad.a.d();
      locald.source = "launch";
      locald.a(((com.tencent.mm.plugin.appbrand.w)paramAppBrandRuntime).ccO());
    }
    AppMethodBeat.o(44031);
  }
  
  public static void R(String paramString, long paramLong)
  {
    AppMethodBeat.i(321356);
    if (u.Ux(paramString).quV.qzp == 0L) {
      u.Uy(paramString).quV.qzp = paramLong;
    }
    AppMethodBeat.o(321356);
  }
  
  public static void S(String paramString, long paramLong)
  {
    AppMethodBeat.i(321359);
    if (u.Ux(paramString).quV.qzq == 0L) {
      u.Uy(paramString).quV.qzq = paramLong;
    }
    AppMethodBeat.o(321359);
  }
  
  public static boolean UH(String paramString)
  {
    AppMethodBeat.i(44025);
    boolean bool = qzw.contains(paramString);
    AppMethodBeat.o(44025);
    return bool;
  }
  
  public static String UI(String paramString)
  {
    AppMethodBeat.i(44035);
    paramString = u.Ux(paramString).quV.name;
    AppMethodBeat.o(44035);
    return paramString;
  }
  
  public static String UJ(String paramString)
  {
    AppMethodBeat.i(44037);
    paramString = u.Ux(paramString).quV.icon;
    AppMethodBeat.o(44037);
    return paramString;
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.w paramw, h.c paramc, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(321302);
    int i;
    String str;
    int k;
    ti.a locala;
    int m;
    int n;
    switch (1.qzx[paramc.ordinal()])
    {
    default: 
      i = 1;
      paramw = new QualitySession("", paramw.getInitConfig(), paramw.asA().epn);
      paramc = com.tencent.mm.plugin.report.service.h.OAn;
      str = paramw.appId;
      k = paramw.tSh;
      locala = ti.a.oY(paramw.tQx);
      m = paramw.apptype;
      n = paramw.scene;
      if (!paramBoolean) {
        break;
      }
    }
    for (;;)
    {
      paramc.b(21052, new Object[] { str, Integer.valueOf(k), locala, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(321302);
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
  
  public static void am(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(44034);
    u.Uy(paramString).quV.qzb = paramBoolean;
    AppMethodBeat.o(44034);
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
        paramad = new Intent(localContext, (Class)qzv.get(str1.replaceFirst(str2, ""))).putExtra("appId", paramad.getAppId());
        if (!(localContext instanceof Activity)) {
          paramad.addFlags(268435456);
        }
        paramad = new com.tencent.mm.hellhoundlib.b.a().cG(paramad);
        com.tencent.mm.hellhoundlib.a.a.b(localContext, paramad.aYi(), "com/tencent/mm/plugin/appbrand/ad/AppBrandAdUtils", "openAdUIFromMenu", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)paramad.sb(0));
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
  
  public static void cH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44036);
    u.Uy(paramString1).quV.name = paramString2;
    AppMethodBeat.o(44036);
  }
  
  public static void cI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44038);
    u.Uy(paramString1).quV.icon = paramString2;
    AppMethodBeat.o(44038);
  }
  
  public static com.tencent.mm.plugin.appbrand.appstorage.w cdS()
  {
    AppMethodBeat.i(174694);
    af localaf = e.a.cdU();
    AppMethodBeat.o(174694);
    return localaf;
  }
  
  public static boolean cdT()
  {
    return true;
  }
  
  public static boolean d(ad paramad)
  {
    AppMethodBeat.i(44032);
    if ((u.Ux(paramad.getAppId()).quV.qzb) && (!Util.isNullOrNil(UI(paramad.getAppId()))))
    {
      AppMethodBeat.o(44032);
      return true;
    }
    AppMethodBeat.o(44032);
    return false;
  }
  
  public static boolean eu(Context paramContext)
  {
    return paramContext instanceof AppBrandAdUI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.e
 * JD-Core Version:    0.7.0.1
 */