package com.tencent.mm.plugin.appbrand.ad.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.ab.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.utils.ak;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.HashMap;
import java.util.Random;

public final class f
  extends r
{
  private static final int CTRL_INDEX = 750;
  public static final String NAME = "shouldShowSplashAd";
  public String source = "launch";
  
  private static String aco(String paramString)
  {
    AppMethodBeat.i(272175);
    int i = com.tencent.mm.kernel.b.aGP();
    if (i != 0)
    {
      long l = i;
      paramString = (l & 0xFFFFFFFF) + "_" + paramString;
      AppMethodBeat.o(272175);
      return paramString;
    }
    AppMethodBeat.o(272175);
    return paramString;
  }
  
  public final void a(v paramv, Context paramContext, o paramo)
  {
    AppMethodBeat.i(272174);
    HashMap localHashMap = new HashMap();
    t localt = (t)paramv.getRuntime();
    localHashMap.put("appId", localt.mAppId);
    localHashMap.put("appName", localt.bDy().fzM);
    localHashMap.put("appIcon", localt.bDy().iconUrl);
    if ((localt instanceof t)) {
      localHashMap.put("scene", Integer.valueOf(localt.Sk().cxf.scene));
    }
    localHashMap.put("source", Util.nullAs(this.source, "launch"));
    boolean bool2 = ar.isDarkMode();
    localHashMap.put("isDarkMode", Boolean.valueOf(bool2));
    boolean bool1 = false;
    if ((localt instanceof t)) {
      bool1 = localt.Qv();
    }
    localHashMap.put("isGame", Boolean.valueOf(bool1));
    int i = com.tencent.mm.plugin.appbrand.ad.b.bDI();
    localHashMap.put("timeThreshold", Integer.valueOf(i));
    String str = aco(String.format("%s_%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(new Random().nextInt(10000)) }));
    localHashMap.put("instanceId", str);
    localHashMap.put("weixinVersion", ChannelUtil.formatVersion(null, BuildInfo.CLIENT_VERSION_INT));
    localHashMap.put("osType", Integer.valueOf(2));
    localHashMap.put("osVersion", "Android " + Build.VERSION.RELEASE);
    localHashMap.put("model", Build.MODEL);
    Object localObject;
    if (paramContext == null)
    {
      localObject = MMApplicationContext.getContext();
      localObject = com.tencent.mm.plugin.appbrand.jsapi.ab.g.dR((Context)localObject);
      localHashMap.put("networkType", ((g.c)localObject).value);
      if (paramContext == null) {
        break label545;
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
      k = com.tencent.mm.plugin.appbrand.ac.g.Dg(k);
      j = com.tencent.mm.plugin.appbrand.ac.g.Dg(j);
      localHashMap.put("screenWidth", Integer.valueOf(k));
      localHashMap.put("screenHeight", Integer.valueOf(j));
      localHashMap.put("pixelRatio", Float.valueOf(com.tencent.mm.plugin.appbrand.ac.g.clS()));
      Log.i("MicroMsg.JsApiEventShouldShowSplashAd[AppBrandSplashAd]", "dispatch, instanceId:%s, timeThreshold:%s, screenSize[%s, %s], pixelRatio:%s, isDarkMode:%s, isGame:%s, networkType:%s", new Object[] { str, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Float.valueOf(com.tencent.mm.plugin.appbrand.ac.g.clS()), Boolean.valueOf(bool2), Boolean.valueOf(bool1), localObject });
      s.abW(localt.mAppId).nvY.nzZ = Util.nowMilliSecond();
      D(localHashMap).i(paramv).b(paramo);
      AppMethodBeat.o(272174);
      return;
      localObject = paramContext;
      break;
      label545:
      paramContext = ak.f(paramv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.f
 * JD-Core Version:    0.7.0.1
 */