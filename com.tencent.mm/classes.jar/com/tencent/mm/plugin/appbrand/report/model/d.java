package com.tencent.mm.plugin.appbrand.report.model;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class d
{
  public static void a(o paramo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(132606);
    try
    {
      b(paramo, paramJSONObject);
      paramJSONObject.put("referpagepath", d(paramo.atS().hiz));
      paramJSONObject.put("clickTimestamp", paramo.atS().startTime);
      AppMethodBeat.o(132606);
      return;
    }
    catch (Exception paramo)
    {
      ab.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillWxConfigLaunchInfo ex = %s", new Object[] { paramo });
      AppMethodBeat.o(132606);
    }
  }
  
  public static void b(o paramo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(132607);
    paramJSONObject.put("scene", paramo.wS().bDh.scene);
    paramJSONObject.put("scene_note", paramo.wS().bDh.cmF);
    paramJSONObject.put("sessionId", paramo.atS().vZ());
    paramJSONObject.put("usedState", paramo.wS().bDh.iFX);
    paramJSONObject.put("prescene", paramo.wS().bDh.cJb);
    paramJSONObject.put("prescene_note", paramo.wS().bDh.cJc);
    AppMethodBeat.o(132607);
  }
  
  public static String d(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    String str;
    if (paramAppBrandLaunchReferrer == null) {
      str = null;
    }
    do
    {
      return str;
      str = "";
      if ((1 == paramAppBrandLaunchReferrer.hiK) || (3 == paramAppBrandLaunchReferrer.hiK)) {
        return paramAppBrandLaunchReferrer.appId;
      }
    } while (2 != paramAppBrandLaunchReferrer.hiK);
    return paramAppBrandLaunchReferrer.url;
  }
  
  public static Pair<Integer, String> i(z paramz)
  {
    int i = 7;
    AppMethodBeat.i(132608);
    Intent localIntent;
    switch (d.1.gYU[com.tencent.mm.plugin.appbrand.e.xX(paramz.getAppId()).ordinal()])
    {
    default: 
      localIntent = j(paramz).aHF();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          paramz = "";
          ab.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          if ((!paramz.contains("WebViewUI")) && (!paramz.contains("WebviewMpUI"))) {
            break label248;
          }
          i = 10;
          paramz = localIntent.getStringExtra(AppBrandProcessProxyUI.hvW);
        }
      }
      break;
    }
    for (;;)
    {
      paramz = Pair.create(Integer.valueOf(i), paramz);
      AppMethodBeat.o(132608);
      return paramz;
      if (paramz.ixF.isLoading()) {}
      for (i = 4;; i = 3)
      {
        paramz = null;
        break;
      }
      if (paramz.ixF.isLoading()) {
        i = 5;
      }
      paramz = null;
      continue;
      i = 6;
      paramz = null;
      continue;
      i = 9;
      paramz = n.yc(paramz.getAppId()).gQZ + ":" + q.encode(bo.nullAsNil(n.yc(paramz.getAppId()).gRa));
      continue;
      paramz = localIntent.getComponent().getClassName();
      break;
      label248:
      paramz = bo.bf(localIntent.getStringExtra(AppBrandProcessProxyUI.hvX), paramz);
      i = 8;
      continue;
      paramz = null;
    }
  }
  
  private static f j(z paramz)
  {
    AppMethodBeat.i(132609);
    paramz = paramz.getRuntime().atT().getReporter();
    AppMethodBeat.o(132609);
    return paramz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.d
 * JD-Core Version:    0.7.0.1
 */