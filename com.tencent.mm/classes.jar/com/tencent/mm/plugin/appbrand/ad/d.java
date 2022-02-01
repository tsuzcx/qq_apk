package com.tencent.mm.plugin.appbrand.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI1;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI2;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI3;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI4;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class d
{
  private static final Map<String, Class<? extends AppBrandAdUI>> jCb;
  private static Set<String> jCc;
  
  static
  {
    AppMethodBeat.i(44039);
    Object localObject = new HashMap();
    ((Map)localObject).put(":appbrand0", AppBrandAdUI.class);
    ((Map)localObject).put(":appbrand1", AppBrandAdUI1.class);
    ((Map)localObject).put(":appbrand2", AppBrandAdUI2.class);
    ((Map)localObject).put(":appbrand3", AppBrandAdUI3.class);
    ((Map)localObject).put(":appbrand4", AppBrandAdUI4.class);
    jCb = Collections.unmodifiableMap((Map)localObject);
    localObject = new HashSet();
    jCc = (Set)localObject;
    ((Set)localObject).add("shouldShowSplashAd");
    jCc.add("onSplashAdShow");
    jCc.add("onSplashAdHide");
    jCc.add("onSplashAdClose");
    jCc.add("onSplashAdButtonClicked");
    jCc.add("onTouchStart");
    jCc.add("onTouchEnd");
    jCc.add("onTouchCancel");
    jCc.add("onTouchMove");
    jCc.add("onLongPress");
    AppMethodBeat.o(44039);
  }
  
  public static boolean J(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44026);
    if (!a.aXX())
    {
      ad.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, showad experiment closed");
      AppMethodBeat.o(44026);
      return false;
    }
    if (!(paramAppBrandRuntime instanceof o))
    {
      ad.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, wrong runtime");
      AppMethodBeat.o(44026);
      return false;
    }
    paramAppBrandRuntime = (o)paramAppBrandRuntime;
    if (o.aXk() <= 0)
    {
      ad.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, timeThreshold invalid");
      AppMethodBeat.o(44026);
      return false;
    }
    if (com.tencent.mm.plugin.appbrand.task.c.c(com.tencent.mm.plugin.appbrand.task.e.hA(paramAppBrandRuntime.aXc().Eb())) != null) {}
    for (int i = 1; i == 0; i = 0)
    {
      ad.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, process not preloaded");
      AppMethodBeat.o(44026);
      return false;
    }
    if (paramAppBrandRuntime.aWT())
    {
      ad.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, ignore plugin app, appId:%s", new Object[] { paramAppBrandRuntime.mAppId });
      AppMethodBeat.o(44026);
      return false;
    }
    i = paramAppBrandRuntime.Fb().cmC.scene;
    if (!a.rN(i))
    {
      ad.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, scene not fit:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(44026);
      return false;
    }
    boolean bool;
    if (!a.aXX())
    {
      ad.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, showad experiment closed");
      bool = false;
    }
    while (!bool)
    {
      ad.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "checkCanShowAd, not ad contact, appId:%s", new Object[] { paramAppBrandRuntime.mAppId });
      AppMethodBeat.o(44026);
      return false;
      if ((paramAppBrandRuntime == null) || (!(paramAppBrandRuntime.Fi() instanceof AppBrandInitConfigWC)))
      {
        ad.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, null runtime or wrong initConfig");
        bool = false;
      }
      else
      {
        bool = ((AppBrandInitConfigWC)paramAppBrandRuntime.Fi()).jXF;
        if (a.aXZ())
        {
          ad.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, set to all show ad");
          bool = true;
        }
        ad.i("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", "isAdContact, appId:%s, canShowAd:%s", new Object[] { paramAppBrandRuntime.mAppId, Boolean.valueOf(bool) });
      }
    }
    AppMethodBeat.o(44026);
    return true;
  }
  
  public static void K(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44030);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(44030);
      return;
    }
    if (paramAppBrandRuntime.aWo())
    {
      com.tencent.mm.plugin.appbrand.ad.a.e locale = new com.tencent.mm.plugin.appbrand.ad.a.e();
      locale.source = "launch";
      locale.c(paramAppBrandRuntime.Ew());
    }
    AppMethodBeat.o(44030);
  }
  
  public static boolean KO(String paramString)
  {
    AppMethodBeat.i(44025);
    boolean bool = jCc.contains(paramString);
    AppMethodBeat.o(44025);
    return bool;
  }
  
  public static String KP(String paramString)
  {
    AppMethodBeat.i(44035);
    paramString = n.KE(paramString).jyS.name;
    AppMethodBeat.o(44035);
    return paramString;
  }
  
  public static String KQ(String paramString)
  {
    AppMethodBeat.i(44037);
    paramString = n.KE(paramString).jyS.dDH;
    AppMethodBeat.o(44037);
    return paramString;
  }
  
  public static void L(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44031);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(44031);
      return;
    }
    if (paramAppBrandRuntime.aWo())
    {
      com.tencent.mm.plugin.appbrand.ad.a.d locald = new com.tencent.mm.plugin.appbrand.ad.a.d();
      locald.source = "launch";
      locald.c(paramAppBrandRuntime.Ew());
    }
    AppMethodBeat.o(44031);
  }
  
  public static void M(String paramString, long paramLong)
  {
    AppMethodBeat.i(187945);
    if (n.KE(paramString).jyS.jBX == 0L) {
      n.KF(paramString).jyS.jBX = paramLong;
    }
    AppMethodBeat.o(187945);
  }
  
  public static void N(String paramString, long paramLong)
  {
    AppMethodBeat.i(187946);
    if (n.KE(paramString).jyS.jBY == 0L) {
      n.KF(paramString).jyS.jBY = paramLong;
    }
    AppMethodBeat.o(187946);
  }
  
  public static p aYb()
  {
    AppMethodBeat.i(174694);
    x localx = a.aYc();
    AppMethodBeat.o(174694);
    return localx;
  }
  
  public static void ad(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(44034);
    n.KF(paramString).jyS.jBK = paramBoolean;
    AppMethodBeat.o(44034);
  }
  
  public static void bZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44036);
    n.KF(paramString1).jyS.name = paramString2;
    AppMethodBeat.o(44036);
  }
  
  public static void c(aa paramaa)
  {
    AppMethodBeat.i(44028);
    if (paramaa != null) {}
    try
    {
      if (paramaa.getContext() != null) {}
      for (Context localContext = paramaa.getContext();; localContext = aj.getContext())
      {
        String str1 = aj.getProcessName();
        String str2 = aj.getPackageName();
        paramaa = new Intent(localContext, (Class)jCb.get(str1.replaceFirst(str2, ""))).putExtra("appId", paramaa.getAppId());
        if (!(localContext instanceof Activity)) {
          paramaa.addFlags(268435456);
        }
        paramaa = new com.tencent.mm.hellhoundlib.b.a().bc(paramaa);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, paramaa.ahp(), "com/tencent/mm/plugin/appbrand/ad/AppBrandAdUtils", "openAdUIFromMenu", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)paramaa.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/appbrand/ad/AppBrandAdUtils", "openAdUIFromMenu", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(44028);
        return;
      }
      return;
    }
    catch (Exception paramaa)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandAdUtils[AppBrandSplashAd]", paramaa, "openAdUIFromMenu fail", new Object[0]);
      AppMethodBeat.o(44028);
    }
  }
  
  public static void ca(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44038);
    n.KF(paramString1).jyS.dDH = paramString2;
    AppMethodBeat.o(44038);
  }
  
  public static boolean d(aa paramaa)
  {
    AppMethodBeat.i(44032);
    if ((n.KE(paramaa.getAppId()).jyS.jBK) && (!bt.isNullOrNil(KP(paramaa.getAppId()))))
    {
      AppMethodBeat.o(44032);
      return true;
    }
    AppMethodBeat.o(44032);
    return false;
  }
  
  public static boolean dh(Context paramContext)
  {
    return paramContext instanceof AppBrandAdUI;
  }
  
  static final class a
  {
    private static final x jCd;
    
    static
    {
      AppMethodBeat.i(174693);
      x localx = new x(ar.m(new String[] { "__ad" }), "wxfile://ad");
      jCd = localx;
      localx.jNj = 104857600L;
      AppMethodBeat.o(174693);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.d
 * JD-Core Version:    0.7.0.1
 */