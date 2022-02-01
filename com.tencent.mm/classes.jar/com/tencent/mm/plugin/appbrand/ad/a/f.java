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
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.ad.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.z.f.c;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.Random;

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.s
{
  private static final int CTRL_INDEX = 750;
  public static final String NAME = "shouldShowSplashAd";
  public String source = "launch";
  
  private static String UE(String paramString)
  {
    AppMethodBeat.i(226279);
    int i = a.azs();
    if (i != 0)
    {
      long l = i;
      paramString = (l & 0xFFFFFFFF) + "_" + paramString;
      AppMethodBeat.o(226279);
      return paramString;
    }
    AppMethodBeat.o(226279);
    return paramString;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.s params, Context paramContext)
  {
    AppMethodBeat.i(44050);
    HashMap localHashMap = new HashMap();
    localHashMap.put("appId", params.getAppId());
    localHashMap.put("appName", params.getRuntime().OU().brandName);
    localHashMap.put("appIcon", params.getRuntime().OU().iconUrl);
    if ((params.getRuntime() instanceof q)) {
      localHashMap.put("scene", Integer.valueOf(((q)params.getRuntime()).ON().cyA.scene));
    }
    localHashMap.put("source", Util.nullAs(this.source, "launch"));
    boolean bool2 = ao.isDarkMode();
    localHashMap.put("isDarkMode", Boolean.valueOf(bool2));
    boolean bool1 = false;
    if ((params.getRuntime() instanceof q)) {
      bool1 = ((q)params.getRuntime()).NA();
    }
    localHashMap.put("isGame", Boolean.valueOf(bool1));
    int i = b.bsL();
    localHashMap.put("timeThreshold", Integer.valueOf(i));
    String str = UE(String.format("%s_%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(new Random().nextInt(10000)) }));
    localHashMap.put("instanceId", str);
    localHashMap.put("weixinVersion", ChannelUtil.formatVersion(null, BuildInfo.CLIENT_VERSION_INT));
    localHashMap.put("osType", Integer.valueOf(2));
    localHashMap.put("osVersion", "Android " + Build.VERSION.RELEASE);
    localHashMap.put("model", Build.MODEL);
    Object localObject;
    if (paramContext == null)
    {
      localObject = MMApplicationContext.getContext();
      localObject = com.tencent.mm.plugin.appbrand.jsapi.z.f.dS((Context)localObject);
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
      k = g.zB(k);
      j = g.zB(j);
      localHashMap.put("screenWidth", Integer.valueOf(k));
      localHashMap.put("screenHeight", Integer.valueOf(j));
      localHashMap.put("pixelRatio", Float.valueOf(g.bZk()));
      Log.i("MicroMsg.JsApiEventShouldShowSplashAd[AppBrandSplashAd]", "dispatch, instanceId:%s, timeThreshold:%s, screenSize[%s, %s], pixelRatio:%s, isDarkMode:%s, isGame:%s, networkType:%s", new Object[] { str, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Float.valueOf(g.bZk()), Boolean.valueOf(bool2), Boolean.valueOf(bool1), localObject });
      p.Un(params.getAppId()).kCO.kGs = Util.nowMilliSecond();
      K(localHashMap).g(params).bEo();
      AppMethodBeat.o(44050);
      return;
      localObject = paramContext;
      break;
      label548:
      paramContext = ai.f(params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.f
 * JD-Core Version:    0.7.0.1
 */