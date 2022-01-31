package com.tencent.mm.plugin.appbrand.report.model;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Pair;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class e
{
  public static void a(n paramn, JSONObject paramJSONObject)
  {
    try
    {
      b(paramn, paramJSONObject);
      paramJSONObject.put("referpagepath", a.d(paramn.aac().fPr));
      paramJSONObject.put("clickTimestamp", bk.UY());
      return;
    }
    catch (Exception paramn)
    {
      y.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillWxConfigLaunchInfo ex = %s", new Object[] { paramn });
    }
  }
  
  public static void b(n paramn, JSONObject paramJSONObject)
  {
    paramJSONObject.put("scene_note", paramn.aab().bFv);
    paramJSONObject.put("sessionId", paramn.aac().fJO);
    paramJSONObject.put("usedState", paramn.aab().gXG);
    paramJSONObject.put("prescene", paramn.aab().caB);
    paramJSONObject.put("prescene_note", paramn.aab().caC);
  }
  
  public static Pair<Integer, String> h(s params)
  {
    int i = 1;
    Intent localIntent;
    switch (e.1.fGn[com.tencent.mm.plugin.appbrand.g.qB(params.mAppId).ordinal()])
    {
    default: 
      localIntent = params.getRuntime().aad().getReporter().gXX;
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          y.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          params = "";
          if (!params.contains("WebViewUI")) {
            break label232;
          }
          i = 10;
          params = localIntent.getStringExtra(AppBrandProcessProxyUI.gdZ);
        }
      }
      break;
    }
    for (;;)
    {
      return Pair.create(Integer.valueOf(i), params);
      if (params.gUj.isLoading()) {}
      for (i = 4;; i = 3)
      {
        params = null;
        break;
      }
      if (params.gUj.isLoading()) {
        i = 5;
      }
      params = null;
      continue;
      i = 6;
      params = null;
      continue;
      i = 9;
      params = m.qH(params.mAppId).fzx + ":" + com.tencent.mm.compatible.util.q.encode(bk.pm(m.qH(params.mAppId).fzy));
      continue;
      params = localIntent.getComponent().getClassName();
      break;
      label232:
      params = bk.aM(localIntent.getStringExtra(AppBrandProcessProxyUI.gea), params);
      i = 8;
      continue;
      i = 7;
      params = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.e
 * JD-Core Version:    0.7.0.1
 */