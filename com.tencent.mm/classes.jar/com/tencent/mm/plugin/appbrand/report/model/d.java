package com.tencent.mm.plugin.appbrand.report.model;

import android.content.ComponentName;
import android.content.Intent;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  public static void a(o paramo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48109);
    try
    {
      if ((j.a.on(paramo.aTS().joY)) && (!TextUtils.isEmpty(paramo.aTS().jDD))) {
        paramJSONObject.put("debugLaunchInfo", new JSONObject(paramo.aTS().jDD));
      }
      AppMethodBeat.o(48109);
      return;
    }
    catch (JSONException paramo)
    {
      ac.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillDebugLaunchInfo ex = %s", new Object[] { paramo });
      AppMethodBeat.o(48109);
    }
  }
  
  public static void b(o paramo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48110);
    try
    {
      c(paramo, paramJSONObject);
      paramJSONObject.put("referpagepath", d(paramo.aTS().cce));
      paramJSONObject.put("clickTimestamp", paramo.aTS().startTime);
      AppMethodBeat.o(48110);
      return;
    }
    catch (Exception paramo)
    {
      ac.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillWxConfigLaunchInfo ex = %s", new Object[] { paramo });
      AppMethodBeat.o(48110);
    }
  }
  
  public static void c(o paramo, JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(48111);
    paramJSONObject.put("scene", paramo.DC().ccl.scene);
    paramJSONObject.put("scene_note", paramo.DC().ccl.cYP);
    paramJSONObject.put("sessionId", paramo.aTS().CD());
    paramJSONObject.put("usedState", paramo.DC().ccl.lRH);
    paramJSONObject.put("prescene", paramo.DC().ccl.dxE);
    paramJSONObject.put("prescene_note", paramo.DC().ccl.dxF);
    Object localObject = paramo.aTS().jjp;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject.put("chatroomUsername", localObject);
    }
    if (!TextUtils.isEmpty(paramo.aTS().jDC)) {}
    try
    {
      paramJSONObject.put("nativeExtraData", new JSONObject(paramo.aTS().jDC));
      localObject = paramo.aTS().jDB;
      if ((localObject == null) || (((PersistableBundle)localObject).size() <= 0)) {}
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        paramJSONObject.put("transitExtraData", com.tencent.luggage.h.d.a(paramo.aTS().jDB));
        if (j.a.on(paramo.aTS().joY))
        {
          paramJSONObject.put("appversion", i);
          AppMethodBeat.o(48111);
          return;
          localJSONException1 = localJSONException1;
          ac.printErrStackTrace("MicroMsg.AppBrandPageVisitStatisticsHelper", localJSONException1, "", new Object[0]);
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.AppBrandPageVisitStatisticsHelper", localJSONException2, "", new Object[0]);
          continue;
          i = paramo.aTS().aBM;
        }
      }
    }
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
      if ((1 == paramAppBrandLaunchReferrer.jDQ) || (3 == paramAppBrandLaunchReferrer.jDQ)) {
        return paramAppBrandLaunchReferrer.appId;
      }
    } while (2 != paramAppBrandLaunchReferrer.jDQ);
    return paramAppBrandLaunchReferrer.url;
  }
  
  public static Pair<Integer, String> r(ae paramae)
  {
    int i = 7;
    AppMethodBeat.i(48112);
    Intent localIntent;
    switch (1.jrQ[com.tencent.mm.plugin.appbrand.g.Hg(paramae.getAppId()).ordinal()])
    {
    default: 
      localIntent = s(paramae).bot();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          paramae = "";
          ac.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          if ((!paramae.contains("WebViewUI")) && (!paramae.contains("WebviewMpUI"))) {
            break label249;
          }
          i = 10;
          paramae = x.getStringExtra(localIntent, AppBrandProcessProxyUI.jUQ);
        }
      }
      break;
    }
    for (;;)
    {
      paramae = Pair.create(Integer.valueOf(i), paramae);
      AppMethodBeat.o(48112);
      return paramae;
      if (paramae.lCV.isLoading()) {}
      for (i = 4;; i = 3)
      {
        paramae = null;
        break;
      }
      if (paramae.lCV.isLoading()) {
        i = 5;
      }
      paramae = null;
      continue;
      i = 6;
      paramae = null;
      continue;
      i = 9;
      paramae = n.Hr(paramae.getAppId()).jfR + ":" + p.encode(bs.nullAsNil(n.Hr(paramae.getAppId()).jfS));
      continue;
      paramae = localIntent.getComponent().getClassName();
      break;
      label249:
      paramae = bs.bG(x.getStringExtra(localIntent, AppBrandProcessProxyUI.jUR), paramae);
      i = 8;
      continue;
      paramae = null;
    }
  }
  
  private static f s(ae paramae)
  {
    AppMethodBeat.i(48113);
    paramae = paramae.getRuntime().aTT().getReporter();
    AppMethodBeat.o(48113);
    return paramae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.d
 * JD-Core Version:    0.7.0.1
 */