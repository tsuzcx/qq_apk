package com.tencent.mm.plugin.appbrand.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.mq.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI1;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI2;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI3;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI4;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.task.e.c;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.report.service.h;
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
  private static final Map<String, Class<? extends AppBrandAdUI>> kGI;
  private static Set<String> kGJ;
  
  static
  {
    AppMethodBeat.i(44039);
    Object localObject = new HashMap();
    ((Map)localObject).put(":appbrand0", AppBrandAdUI.class);
    ((Map)localObject).put(":appbrand1", AppBrandAdUI1.class);
    ((Map)localObject).put(":appbrand2", AppBrandAdUI2.class);
    ((Map)localObject).put(":appbrand3", AppBrandAdUI3.class);
    ((Map)localObject).put(":appbrand4", AppBrandAdUI4.class);
    kGI = Collections.unmodifiableMap((Map)localObject);
    localObject = new HashSet();
    kGJ = (Set)localObject;
    ((Set)localObject).add("shouldShowSplashAd");
    kGJ.add("onSplashAdShow");
    kGJ.add("onSplashAdHide");
    kGJ.add("onSplashAdClose");
    kGJ.add("onSplashAdButtonClicked");
    kGJ.add("onTouchStart");
    kGJ.add("onTouchEnd");
    kGJ.add("onTouchCancel");
    kGJ.add("onTouchMove");
    kGJ.add("onLongPress");
    AppMethodBeat.o(44039);
  }
  
  public static boolean H(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44026);
    if (!b.btF())
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, showad experiment closed");
      AppMethodBeat.o(44026);
      return false;
    }
    if (!(paramAppBrandRuntime instanceof com.tencent.mm.plugin.appbrand.q))
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, wrong runtime");
      AppMethodBeat.o(44026);
      return false;
    }
    paramAppBrandRuntime = (com.tencent.mm.plugin.appbrand.q)paramAppBrandRuntime;
    if (com.tencent.mm.plugin.appbrand.q.bsK() <= 0)
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, timeThreshold invalid");
      AppMethodBeat.o(44026);
      return false;
    }
    if (com.tencent.mm.plugin.appbrand.task.e.j(g.iD(paramAppBrandRuntime.bsC().NA())) != null) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, process not preloaded");
      AppMethodBeat.o(44026);
      return false;
    }
    if (paramAppBrandRuntime.bsr())
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, ignore plugin app, appId:%s", new Object[] { paramAppBrandRuntime.mAppId });
      AppMethodBeat.o(44026);
      return false;
    }
    i = paramAppBrandRuntime.ON().cyA.scene;
    if (!b.vL(i))
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, scene not fit:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(44026);
      return false;
    }
    boolean bool;
    if (!b.btF())
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, showad experiment closed");
      bool = false;
    }
    while (!bool)
    {
      Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, not ad contact, appId:%s", new Object[] { paramAppBrandRuntime.mAppId });
      AppMethodBeat.o(44026);
      return false;
      if ((paramAppBrandRuntime == null) || (!(paramAppBrandRuntime.OU() instanceof AppBrandInitConfigWC)))
      {
        Log.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, null runtime or wrong initConfig");
        bool = false;
      }
      else
      {
        bool = ((AppBrandInitConfigWC)paramAppBrandRuntime.OU()).ldY;
        if (b.btH())
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
  
  public static void I(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44030);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(44030);
      return;
    }
    if (paramAppBrandRuntime.brM())
    {
      com.tencent.mm.plugin.appbrand.ad.a.e locale = new com.tencent.mm.plugin.appbrand.ad.a.e();
      locale.source = "launch";
      locale.d(paramAppBrandRuntime.NY());
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
    if (paramAppBrandRuntime.brM())
    {
      com.tencent.mm.plugin.appbrand.ad.a.d locald = new com.tencent.mm.plugin.appbrand.ad.a.d();
      locald.source = "launch";
      locald.d(paramAppBrandRuntime.NY());
    }
    AppMethodBeat.o(44031);
  }
  
  public static void M(String paramString, long paramLong)
  {
    AppMethodBeat.i(226259);
    if (p.Um(paramString).kCO.kGE == 0L) {
      p.Un(paramString).kCO.kGE = paramLong;
    }
    AppMethodBeat.o(226259);
  }
  
  public static void N(String paramString, long paramLong)
  {
    AppMethodBeat.i(226260);
    if (p.Um(paramString).kCO.kGF == 0L) {
      p.Un(paramString).kCO.kGF = paramLong;
    }
    AppMethodBeat.o(226260);
  }
  
  public static boolean Ux(String paramString)
  {
    AppMethodBeat.i(44025);
    boolean bool = kGJ.contains(paramString);
    AppMethodBeat.o(44025);
    return bool;
  }
  
  public static String Uy(String paramString)
  {
    AppMethodBeat.i(44035);
    paramString = p.Um(paramString).kCO.name;
    AppMethodBeat.o(44035);
    return paramString;
  }
  
  public static String Uz(String paramString)
  {
    AppMethodBeat.i(44037);
    paramString = p.Um(paramString).kCO.icon;
    AppMethodBeat.o(44037);
    return paramString;
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.q paramq, e.c paramc, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(226258);
    int i;
    String str;
    int k;
    mq.a locala;
    int m;
    int n;
    switch (1.kGK[paramc.ordinal()])
    {
    default: 
      i = 1;
      paramq = new QualitySession("", paramq.bsC(), paramq.ON().cyA);
      paramc = h.CyF;
      str = paramq.appId;
      k = paramq.nLk;
      locala = mq.a.mB(paramq.nJE);
      m = paramq.apptype;
      n = paramq.scene;
      if (!paramBoolean) {
        break;
      }
    }
    for (;;)
    {
      paramc.a(21052, new Object[] { str, Integer.valueOf(k), locala, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(226258);
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
  
  public static void af(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(44034);
    p.Un(paramString).kCO.kGr = paramBoolean;
    AppMethodBeat.o(44034);
  }
  
  public static com.tencent.mm.plugin.appbrand.appstorage.q btJ()
  {
    AppMethodBeat.i(174694);
    z localz = a.btK();
    AppMethodBeat.o(174694);
    return localz;
  }
  
  public static void c(ac paramac)
  {
    AppMethodBeat.i(44028);
    if (paramac != null) {}
    try
    {
      if (paramac.getContext() != null) {}
      for (Context localContext = paramac.getContext();; localContext = MMApplicationContext.getContext())
      {
        String str1 = MMApplicationContext.getProcessName();
        String str2 = MMApplicationContext.getPackageName();
        paramac = new Intent(localContext, (Class)kGI.get(str1.replaceFirst(str2, ""))).putExtra("appId", paramac.getAppId());
        if (!(localContext instanceof Activity)) {
          paramac.addFlags(268435456);
        }
        paramac = new com.tencent.mm.hellhoundlib.b.a().bl(paramac);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, paramac.axQ(), "com/tencent/mm/plugin/appbrand/ad/AppBrandAdUtils", "openAdUIFromMenu", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)paramac.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/appbrand/ad/AppBrandAdUtils", "openAdUIFromMenu", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(44028);
        return;
      }
      return;
    }
    catch (Exception paramac)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", paramac, "openAdUIFromMenu fail", new Object[0]);
      AppMethodBeat.o(44028);
    }
  }
  
  public static void cm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44036);
    p.Un(paramString1).kCO.name = paramString2;
    AppMethodBeat.o(44036);
  }
  
  public static void cn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44038);
    p.Un(paramString1).kCO.icon = paramString2;
    AppMethodBeat.o(44038);
  }
  
  public static boolean d(ac paramac)
  {
    AppMethodBeat.i(44032);
    if ((p.Um(paramac.getAppId()).kCO.kGr) && (!Util.isNullOrNil(Uy(paramac.getAppId()))))
    {
      AppMethodBeat.o(44032);
      return true;
    }
    AppMethodBeat.o(44032);
    return false;
  }
  
  public static boolean dE(Context paramContext)
  {
    return paramContext instanceof AppBrandAdUI;
  }
  
  static final class a
  {
    private static final z kGL;
    
    static
    {
      AppMethodBeat.i(174693);
      z localz = new z(at.o(new String[] { "__ad" }), "wxfile://ad");
      kGL = localz;
      localz.kTk = 104857600L;
      AppMethodBeat.o(174693);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.e
 * JD-Core Version:    0.7.0.1
 */