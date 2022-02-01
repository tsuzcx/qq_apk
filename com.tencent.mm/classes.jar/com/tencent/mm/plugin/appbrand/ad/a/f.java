package com.tencent.mm.plugin.appbrand.ad.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import java.util.HashMap;

public final class f
  extends p
{
  private static final int CTRL_INDEX = 750;
  public static final String NAME = "shouldShowSplashAd";
  public String source = "launch";
  
  public final void a(q paramq, Context paramContext)
  {
    AppMethodBeat.i(44050);
    HashMap localHashMap = new HashMap();
    localHashMap.put("appId", paramq.getAppId());
    localHashMap.put("appName", paramq.getRuntime().DJ().ddh);
    localHashMap.put("appIcon", paramq.getRuntime().DJ().iconUrl);
    if ((paramq.getRuntime() instanceof o)) {
      localHashMap.put("scene", Integer.valueOf(((o)paramq.getRuntime()).DC().ccl.scene));
    }
    localHashMap.put("source", bs.bG(this.source, "launch"));
    boolean bool2 = aj.DT();
    localHashMap.put("isDarkMode", Boolean.valueOf(bool2));
    if ((paramq.getRuntime() instanceof o)) {}
    for (boolean bool1 = ((o)paramq.getRuntime()).CC();; bool1 = false)
    {
      localHashMap.put("isGame", Boolean.valueOf(bool1));
      Object localObject = a.QN(paramq.getAppId());
      if ((localObject != null) && (!bs.isNullOrNil(((QualitySession)localObject).lht)))
      {
        localObject = ((QualitySession)localObject).lht;
        localHashMap.put("instanceId", localObject);
        if (paramContext == null) {
          break label397;
        }
        localObject = paramContext.getResources().getDisplayMetrics();
        paramContext = new int[2];
        paramContext[0] = ((DisplayMetrics)localObject).widthPixels;
        paramContext[1] = ((DisplayMetrics)localObject).heightPixels;
      }
      for (;;)
      {
        int j = paramContext[0];
        int i = paramContext[1];
        j = g.vc(j);
        i = g.vc(i);
        localHashMap.put("screenWidth", Integer.valueOf(j));
        localHashMap.put("screenHeight", Integer.valueOf(i));
        localHashMap.put("pixelRatio", Float.valueOf(g.bxg()));
        ac.i("MicroMsg.JsApiEventShouldShowSplashAd", "dispatch, screenSize[%s, %s], pixelRatio:%s, isDarkMode:%s, isGame:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(g.bxg()), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        n.Hs(paramq.getAppId()).jfM.jiv = bs.eWj();
        A(localHashMap).g(paramq).beN();
        AppMethodBeat.o(44050);
        return;
        localObject = "";
        break;
        label397:
        paramContext = ad.g(paramq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a.f
 * JD-Core Version:    0.7.0.1
 */