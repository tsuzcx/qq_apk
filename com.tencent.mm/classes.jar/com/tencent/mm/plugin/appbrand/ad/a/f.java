package com.tencent.mm.plugin.appbrand.ad.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.x.f.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.al;
import java.util.HashMap;
import java.util.Random;

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.p
{
  private static final int CTRL_INDEX = 750;
  public static final String NAME = "shouldShowSplashAd";
  public String source = "launch";
  
  private static String Lv(String paramString)
  {
    AppMethodBeat.i(222077);
    int i = a.ajc();
    if (i != 0)
    {
      long l = i;
      paramString = (l & 0xFFFFFFFF) + "_" + paramString;
      AppMethodBeat.o(222077);
      return paramString;
    }
    AppMethodBeat.o(222077);
    return paramString;
  }
  
  public final void a(r paramr, Context paramContext)
  {
    AppMethodBeat.i(44050);
    HashMap localHashMap = new HashMap();
    localHashMap.put("appId", paramr.getAppId());
    localHashMap.put("appName", paramr.getRuntime().Fn().dpI);
    localHashMap.put("appIcon", paramr.getRuntime().Fn().iconUrl);
    if ((paramr.getRuntime() instanceof com.tencent.mm.plugin.appbrand.p)) {
      localHashMap.put("scene", Integer.valueOf(((com.tencent.mm.plugin.appbrand.p)paramr.getRuntime()).Fg().cmE.scene));
    }
    localHashMap.put("source", bu.bI(this.source, "launch"));
    boolean bool2 = al.isDarkMode();
    localHashMap.put("isDarkMode", Boolean.valueOf(bool2));
    boolean bool1 = false;
    if ((paramr.getRuntime() instanceof com.tencent.mm.plugin.appbrand.p)) {
      bool1 = ((com.tencent.mm.plugin.appbrand.p)paramr.getRuntime()).Ee();
    }
    localHashMap.put("isGame", Boolean.valueOf(bool1));
    int i = b.aXG();
    localHashMap.put("timeThreshold", Integer.valueOf(i));
    String str = Lv(String.format("%s_%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(new Random().nextInt(10000)) }));
    localHashMap.put("instanceId", str);
    localHashMap.put("weixinVersion", k.aD(null, j.IwD));
    localHashMap.put("osType", Integer.valueOf(2));
    localHashMap.put("osVersion", "Android " + Build.VERSION.RELEASE);
    localHashMap.put("model", Build.MODEL);
    Object localObject;
    if (paramContext == null)
    {
      localObject = ak.getContext();
      localObject = com.tencent.mm.plugin.appbrand.jsapi.x.f.dx((Context)localObject);
      localHashMap.put("networkType", ((f.c)localObject).value);
      if (paramContext == null) {
        break label548;
      }
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      paramContext = new int[2];
      paramContext[0] = localDisplayMetrics.widthPixels;
      paramContext[1] = localDisplayMetrics.heightPixels;
    }
    for (;;)
    {
      int k = paramContext[0];
      int j = paramContext[1];
      k = g.vM(k);
      j = g.vM(j);
      localHashMap.put("screenWidth", Integer.valueOf(k));
      localHashMap.put("screenHeight", Integer.valueOf(j));
      localHashMap.put("pixelRatio", Float.valueOf(g.bCg()));
      ae.i("MicroMsg.JsApiEventShouldShowSplashAd[AppBrandSplashAd]", "dispatch, instanceId:%s, timeThreshold:%s, screenSize[%s, %s], pixelRatio:%s, isDarkMode:%s, isGame:%s, networkType:%s", new Object[] { str, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Float.valueOf(g.bCg()), Boolean.valueOf(bool2), Boolean.valueOf(bool1), localObject });
      o.Le(paramr.getAppId()).jBS.jEI = bu.fpO();
      H(localHashMap).g(paramr).bja();
      AppMethodBeat.o(44050);
      return;
      localObject = paramContext;
      break;
      label548:
      paramContext = ai.f(paramr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.f
 * JD-Core Version:    0.7.0.1
 */