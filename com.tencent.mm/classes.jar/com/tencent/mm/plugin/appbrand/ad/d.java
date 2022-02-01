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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class d
{
  private static final Map<String, Class<? extends AppBrandAdUI>> jiF;
  private static Set<String> jiG;
  
  static
  {
    AppMethodBeat.i(44039);
    Object localObject = new HashMap();
    ((Map)localObject).put(":appbrand0", AppBrandAdUI.class);
    ((Map)localObject).put(":appbrand1", AppBrandAdUI1.class);
    ((Map)localObject).put(":appbrand2", AppBrandAdUI2.class);
    ((Map)localObject).put(":appbrand3", AppBrandAdUI3.class);
    ((Map)localObject).put(":appbrand4", AppBrandAdUI4.class);
    jiF = Collections.unmodifiableMap((Map)localObject);
    localObject = new HashSet();
    jiG = (Set)localObject;
    ((Set)localObject).add("shouldShowSplashAd");
    jiG.add("onSplashAdShow");
    jiG.add("onSplashAdHide");
    jiG.add("onSplashAdClose");
    jiG.add("onSplashAdButtonClicked");
    jiG.add("onTouchStart");
    jiG.add("onTouchEnd");
    jiG.add("onTouchCancel");
    jiG.add("onTouchMove");
    jiG.add("onLongPress");
    AppMethodBeat.o(44039);
  }
  
  public static void G(String paramString, long paramLong)
  {
    AppMethodBeat.i(186282);
    n.Hs(paramString).jfM.jiD = paramLong;
    AppMethodBeat.o(186282);
  }
  
  public static boolean HB(String paramString)
  {
    AppMethodBeat.i(44025);
    boolean bool = jiG.contains(paramString);
    AppMethodBeat.o(44025);
    return bool;
  }
  
  public static String HC(String paramString)
  {
    AppMethodBeat.i(44035);
    paramString = n.Hr(paramString).jfM.name;
    AppMethodBeat.o(44035);
    return paramString;
  }
  
  public static String HD(String paramString)
  {
    AppMethodBeat.i(44037);
    paramString = n.Hr(paramString).jfM.drM;
    AppMethodBeat.o(44037);
    return paramString;
  }
  
  public static boolean N(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(162161);
    if (!a.aUL())
    {
      ac.i("MicroMsg.AppBrandAdUtils", "isAdContact, showad experiment closed");
      AppMethodBeat.o(162161);
      return false;
    }
    if ((paramAppBrandRuntime == null) || (!(paramAppBrandRuntime.DJ() instanceof AppBrandInitConfigWC)))
    {
      ac.i("MicroMsg.AppBrandAdUtils", "isAdContact, null runtime or wrong initConfig");
      AppMethodBeat.o(162161);
      return false;
    }
    boolean bool = ((AppBrandInitConfigWC)paramAppBrandRuntime.DJ()).jDJ;
    if (a.aUN())
    {
      ac.i("MicroMsg.AppBrandAdUtils", "isAdContact, set to all show ad");
      bool = true;
    }
    ac.i("MicroMsg.AppBrandAdUtils", "isAdContact, appId:%s, canShow:%s", new Object[] { paramAppBrandRuntime.DJ().appId, Boolean.valueOf(bool) });
    AppMethodBeat.o(162161);
    return bool;
  }
  
  public static boolean O(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44026);
    if (!a.aUL())
    {
      ac.i("MicroMsg.AppBrandAdUtils", "checkCanShowAd, showad experiment closed");
      AppMethodBeat.o(44026);
      return false;
    }
    if (!(paramAppBrandRuntime instanceof o))
    {
      ac.i("MicroMsg.AppBrandAdUtils", "checkCanShowAd, wrong runtime");
      AppMethodBeat.o(44026);
      return false;
    }
    if (!com.tencent.mm.plugin.appbrand.task.c.bus())
    {
      ac.i("MicroMsg.AppBrandAdUtils", "checkCanShowAd, process not preloaded");
      AppMethodBeat.o(44026);
      return false;
    }
    paramAppBrandRuntime = (o)paramAppBrandRuntime;
    if (paramAppBrandRuntime.aTJ())
    {
      ac.i("MicroMsg.AppBrandAdUtils", "checkCanShowAd, ignore plugin app, appId:%s", new Object[] { paramAppBrandRuntime.mAppId });
      AppMethodBeat.o(44026);
      return false;
    }
    int i = paramAppBrandRuntime.DC().ccl.scene;
    ac.i("MicroMsg.AppBrandAdUtils", "checkCanShowAd, scene:%s", new Object[] { Integer.valueOf(i) });
    if (!a.rm(i))
    {
      ac.i("MicroMsg.AppBrandAdUtils", "checkCanShowAd, scene not fit:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(44026);
      return false;
    }
    if (!N(paramAppBrandRuntime))
    {
      ac.i("MicroMsg.AppBrandAdUtils", "checkCanShowAd, not ad contact, appId:%s", new Object[] { paramAppBrandRuntime.mAppId });
      AppMethodBeat.o(44026);
      return false;
    }
    AppMethodBeat.o(44026);
    return true;
  }
  
  public static boolean P(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44029);
    if ((paramAppBrandRuntime != null) && (paramAppBrandRuntime.aTc() != null))
    {
      e locale = paramAppBrandRuntime.aTc();
      if ((paramAppBrandRuntime.jdA.indexOfChild(locale) >= 0) && (locale.getVisibility() == 0) && (n.Hr(paramAppBrandRuntime.mAppId).jfM.jit))
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
      locale.c(paramAppBrandRuntime.CX());
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
      locald.c(paramAppBrandRuntime.CX());
    }
    AppMethodBeat.o(44031);
  }
  
  public static p aUO()
  {
    AppMethodBeat.i(174694);
    x localx = a.aUP();
    AppMethodBeat.o(174694);
    return localx;
  }
  
  public static void ad(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(44034);
    n.Hs(paramString).jfM.jiu = paramBoolean;
    AppMethodBeat.o(44034);
  }
  
  public static void bX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44036);
    n.Hs(paramString1).jfM.name = paramString2;
    AppMethodBeat.o(44036);
  }
  
  public static void bY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44038);
    n.Hs(paramString1).jfM.drM = paramString2;
    AppMethodBeat.o(44038);
  }
  
  public static void c(aa paramaa)
  {
    AppMethodBeat.i(44028);
    if (paramaa != null) {}
    try
    {
      if (paramaa.getContext() != null) {}
      for (Context localContext = paramaa.getContext();; localContext = ai.getContext())
      {
        String str1 = ai.getProcessName();
        String str2 = ai.getPackageName();
        paramaa = new Intent(localContext, (Class)jiF.get(str1.replaceFirst(str2, ""))).putExtra("appId", paramaa.getAppId());
        if (!(localContext instanceof Activity)) {
          paramaa.addFlags(268435456);
        }
        paramaa = new com.tencent.mm.hellhoundlib.b.a().ba(paramaa);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, paramaa.aeD(), "com/tencent/mm/plugin/appbrand/ad/AppBrandAdUtils", "openAdUIFromMenu", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)paramaa.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/appbrand/ad/AppBrandAdUtils", "openAdUIFromMenu", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(44028);
        return;
      }
      return;
    }
    catch (Exception paramaa)
    {
      ac.printErrStackTrace("MicroMsg.AppBrandAdUtils", paramaa, "openAdUIFromMenu fail", new Object[0]);
      AppMethodBeat.o(44028);
    }
  }
  
  public static boolean d(aa paramaa)
  {
    AppMethodBeat.i(44032);
    if ((n.Hr(paramaa.getAppId()).jfM.jiu) && (!bs.isNullOrNil(HC(paramaa.getAppId()))))
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
    private static final x jiH;
    
    static
    {
      AppMethodBeat.i(174693);
      x localx = new x(ar.m(new String[] { "__ad" }), "wxfile://ad");
      jiH = localx;
      localx.jtp = 104857600L;
      AppMethodBeat.o(174693);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.d
 * JD-Core Version:    0.7.0.1
 */