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
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
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
  private static final Map<String, Class<? extends AppBrandAdUI>> iIB;
  private static Set<String> iIC;
  
  static
  {
    AppMethodBeat.i(44039);
    Object localObject = new HashMap();
    ((Map)localObject).put(":appbrand0", AppBrandAdUI.class);
    ((Map)localObject).put(":appbrand1", AppBrandAdUI1.class);
    ((Map)localObject).put(":appbrand2", AppBrandAdUI2.class);
    ((Map)localObject).put(":appbrand3", AppBrandAdUI3.class);
    ((Map)localObject).put(":appbrand4", AppBrandAdUI4.class);
    iIB = Collections.unmodifiableMap((Map)localObject);
    localObject = new HashSet();
    iIC = (Set)localObject;
    ((Set)localObject).add("shouldShowSplashAd");
    iIC.add("onSplashAdShow");
    iIC.add("onSplashAdHide");
    iIC.add("onSplashAdClose");
    iIC.add("onSplashAdButtonClicked");
    iIC.add("onTouchStart");
    iIC.add("onTouchEnd");
    iIC.add("onTouchCancel");
    iIC.add("onTouchMove");
    iIC.add("onLongPress");
    AppMethodBeat.o(44039);
  }
  
  public static String DA(String paramString)
  {
    AppMethodBeat.i(44037);
    paramString = n.Do(paramString).iFK.dub;
    AppMethodBeat.o(44037);
    return paramString;
  }
  
  public static boolean Dy(String paramString)
  {
    AppMethodBeat.i(44025);
    boolean bool = iIC.contains(paramString);
    AppMethodBeat.o(44025);
    return bool;
  }
  
  public static String Dz(String paramString)
  {
    AppMethodBeat.i(44035);
    paramString = n.Do(paramString).iFK.name;
    AppMethodBeat.o(44035);
    return paramString;
  }
  
  public static void F(String paramString, long paramLong)
  {
    AppMethodBeat.i(195582);
    n.Dp(paramString).iFK.iIz = paramLong;
    AppMethodBeat.o(195582);
  }
  
  public static boolean N(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(162161);
    if (!a.aNV())
    {
      ad.i("MicroMsg.AppBrandAdUtils", "isAdContact, showad experiment closed");
      AppMethodBeat.o(162161);
      return false;
    }
    if ((paramAppBrandRuntime == null) || (!(paramAppBrandRuntime.Eg() instanceof AppBrandInitConfigWC)))
    {
      ad.i("MicroMsg.AppBrandAdUtils", "isAdContact, null runtime or wrong initConfig");
      AppMethodBeat.o(162161);
      return false;
    }
    boolean bool = ((AppBrandInitConfigWC)paramAppBrandRuntime.Eg()).jdw;
    if (a.aNX())
    {
      ad.i("MicroMsg.AppBrandAdUtils", "isAdContact, set to all show ad");
      bool = true;
    }
    ad.i("MicroMsg.AppBrandAdUtils", "isAdContact, appId:%s, canShow:%s", new Object[] { paramAppBrandRuntime.Eg().appId, Boolean.valueOf(bool) });
    AppMethodBeat.o(162161);
    return bool;
  }
  
  public static boolean O(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44026);
    if (!a.aNV())
    {
      ad.i("MicroMsg.AppBrandAdUtils", "checkCanShowAd, showad experiment closed");
      AppMethodBeat.o(44026);
      return false;
    }
    if (!(paramAppBrandRuntime instanceof o))
    {
      ad.i("MicroMsg.AppBrandAdUtils", "checkCanShowAd, wrong runtime");
      AppMethodBeat.o(44026);
      return false;
    }
    if (!com.tencent.mm.plugin.appbrand.task.c.bnw())
    {
      ad.i("MicroMsg.AppBrandAdUtils", "checkCanShowAd, process not preloaded");
      AppMethodBeat.o(44026);
      return false;
    }
    paramAppBrandRuntime = (o)paramAppBrandRuntime;
    if (paramAppBrandRuntime.aMT())
    {
      ad.i("MicroMsg.AppBrandAdUtils", "checkCanShowAd, ignore plugin app, appId:%s", new Object[] { paramAppBrandRuntime.mAppId });
      AppMethodBeat.o(44026);
      return false;
    }
    int i = paramAppBrandRuntime.DZ().cfo.scene;
    ad.i("MicroMsg.AppBrandAdUtils", "checkCanShowAd, scene:%s", new Object[] { Integer.valueOf(i) });
    if (!a.qz(i))
    {
      ad.i("MicroMsg.AppBrandAdUtils", "checkCanShowAd, scene not fit:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(44026);
      return false;
    }
    if (!N(paramAppBrandRuntime))
    {
      ad.i("MicroMsg.AppBrandAdUtils", "checkCanShowAd, not ad contact, appId:%s", new Object[] { paramAppBrandRuntime.mAppId });
      AppMethodBeat.o(44026);
      return false;
    }
    AppMethodBeat.o(44026);
    return true;
  }
  
  public static boolean P(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44029);
    if ((paramAppBrandRuntime != null) && (paramAppBrandRuntime.aMm() != null))
    {
      e locale = paramAppBrandRuntime.aMm();
      if ((paramAppBrandRuntime.iDA.indexOfChild(locale) >= 0) && (locale.getVisibility() == 0) && (n.Do(paramAppBrandRuntime.mAppId).iFK.iIp))
      {
        AppMethodBeat.o(44029);
        return true;
      }
    }
    AppMethodBeat.o(44029);
    return false;
  }
  
  public static void Q(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44030);
    if (P(paramAppBrandRuntime))
    {
      com.tencent.mm.plugin.appbrand.ad.a.e locale = new com.tencent.mm.plugin.appbrand.ad.a.e();
      locale.source = "launch";
      locale.c(paramAppBrandRuntime.Du());
    }
    AppMethodBeat.o(44030);
  }
  
  public static void R(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44031);
    if (P(paramAppBrandRuntime))
    {
      com.tencent.mm.plugin.appbrand.ad.a.d locald = new com.tencent.mm.plugin.appbrand.ad.a.d();
      locald.source = "launch";
      locald.c(paramAppBrandRuntime.Du());
    }
    AppMethodBeat.o(44031);
  }
  
  public static p aNY()
  {
    AppMethodBeat.i(174694);
    x localx = a.aNZ();
    AppMethodBeat.o(174694);
    return localx;
  }
  
  public static void ab(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(44034);
    n.Dp(paramString).iFK.iIq = paramBoolean;
    AppMethodBeat.o(44034);
  }
  
  public static void bP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44036);
    n.Dp(paramString1).iFK.name = paramString2;
    AppMethodBeat.o(44036);
  }
  
  public static void bQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44038);
    n.Dp(paramString1).iFK.dub = paramString2;
    AppMethodBeat.o(44038);
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
        paramaa = new Intent(localContext, (Class)iIB.get(str1.replaceFirst(str2, ""))).putExtra("appId", paramaa.getAppId());
        if (!(localContext instanceof Activity)) {
          paramaa.addFlags(268435456);
        }
        paramaa = new com.tencent.mm.hellhoundlib.b.a().bd(paramaa);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, paramaa.adn(), "com/tencent/mm/plugin/appbrand/ad/AppBrandAdUtils", "openAdUIFromMenu", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)paramaa.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/appbrand/ad/AppBrandAdUtils", "openAdUIFromMenu", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(44028);
        return;
      }
      return;
    }
    catch (Exception paramaa)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandAdUtils", paramaa, "openAdUIFromMenu fail", new Object[0]);
      AppMethodBeat.o(44028);
    }
  }
  
  public static boolean d(aa paramaa)
  {
    AppMethodBeat.i(44032);
    if ((n.Do(paramaa.getAppId()).iFK.iIq) && (!bt.isNullOrNil(Dz(paramaa.getAppId()))))
    {
      AppMethodBeat.o(44032);
      return true;
    }
    AppMethodBeat.o(44032);
    return false;
  }
  
  public static boolean da(Context paramContext)
  {
    return paramContext instanceof AppBrandAdUI;
  }
  
  static final class a
  {
    private static final x iID;
    
    static
    {
      AppMethodBeat.i(174693);
      x localx = new x(ar.n(new String[] { "__ad" }), "wxfile://ad");
      iID = localx;
      localx.iTe = 104857600L;
      AppMethodBeat.o(174693);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.d
 * JD-Core Version:    0.7.0.1
 */