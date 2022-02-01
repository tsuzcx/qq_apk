package com.tencent.mm.plugin.appbrand.report.model;

import android.content.ComponentName;
import android.content.Intent;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.bj;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.g;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.jsapi.file.ax;
import com.tencent.mm.plugin.appbrand.launching.d.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.a;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.apache.commons.b.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  private static String Q(w paramw)
  {
    AppMethodBeat.i(321475);
    if (paramw.getInitConfig().qAT.isEnable())
    {
      if (paramw.getInitConfig().qAT.rac == HalfScreenConfig.g.raA)
      {
        AppMethodBeat.o(321475);
        return "embedded";
      }
      if (paramw.getInitConfig().qAT.height != -1)
      {
        AppMethodBeat.o(321475);
        return "halfPage";
      }
    }
    else if (bj.x(paramw))
    {
      AppMethodBeat.o(321475);
      return "singlePage";
    }
    AppMethodBeat.o(321475);
    return "default";
  }
  
  public static void a(w paramw, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48109);
    try
    {
      if ((k.a.vK(paramw.getInitConfig().eul)) && (!TextUtils.isEmpty(paramw.getInitConfig().qYi))) {
        paramJSONObject.put("debugLaunchInfo", new JSONObject(paramw.getInitConfig().qYi));
      }
      AppMethodBeat.o(48109);
      return;
    }
    catch (JSONException paramw)
    {
      Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillDebugLaunchInfo ex = %s", new Object[] { paramw });
      AppMethodBeat.o(48109);
    }
  }
  
  private static String b(w paramw, String paramString)
  {
    AppMethodBeat.i(321487);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(321487);
      return paramString;
    }
    Object localObject1 = a.aep(paramString);
    if (localObject1 == null)
    {
      AppMethodBeat.o(321487);
      return paramString;
    }
    Object localObject2 = ((a)localObject1).trT.trim();
    Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, originMaterialPath: ".concat(String.valueOf(localObject2)));
    if ((((String)localObject2).startsWith("http://")) || (((String)localObject2).startsWith("https://")))
    {
      AppMethodBeat.o(321487);
      return paramString;
    }
    String str1 = ((a)localObject1).mimeType;
    if ((!str1.startsWith("image")) && (!str1.startsWith("video"))) {}
    for (localObject1 = c.bei((String)localObject2);; localObject1 = "")
    {
      String str2 = c.bKZ((String)localObject2);
      com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u((String)localObject2);
      int i = (int)localu.length();
      Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, fileName: %s, fileExt: %s，fileSize: %d", new Object[] { localObject1, str2, Integer.valueOf(i) });
      localObject2 = new k();
      paramw = paramw.asx().a(localu, str2, false, (k)localObject2);
      Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, result: ".concat(String.valueOf(paramw)));
      if (com.tencent.mm.plugin.appbrand.appstorage.r.qML != paramw)
      {
        AppMethodBeat.o(321487);
        return paramString;
      }
      paramw = (String)((k)localObject2).value;
      Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, newMaterialPath: ".concat(String.valueOf(paramw)));
      paramw = new a(str1, paramw, (String)localObject1, i).toJsonString();
      AppMethodBeat.o(321487);
      return paramw;
    }
  }
  
  public static void b(w paramw, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48110);
    try
    {
      c(paramw, paramJSONObject);
      paramJSONObject.put("referpagepath", d(paramw.getInitConfig().eoV));
      paramJSONObject.put("clickTimestamp", paramw.getInitConfig().startTime);
      AppMethodBeat.o(48110);
      return;
    }
    catch (Exception paramw)
    {
      Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillWxConfigLaunchInfo ex = %s", new Object[] { paramw });
      AppMethodBeat.o(48110);
    }
  }
  
  private static String c(w paramw, String paramString)
  {
    AppMethodBeat.i(321490);
    JSONObject localJSONObject;
    k localk;
    try
    {
      localJSONObject = new JSONObject(paramString);
      String str1 = paramw.getInitConfig().aqF();
      String str2 = c.bKZ(str1);
      localk = new k();
      paramw = paramw.asx().a(new com.tencent.mm.vfs.u(str1), str2, false, localk);
      if (com.tencent.mm.plugin.appbrand.appstorage.r.qML != paramw)
      {
        AppMethodBeat.o(321490);
        return paramString;
      }
    }
    catch (JSONException paramw)
    {
      Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4WindowBackgroundImage parse nativeExtraDataStr get exception %s", new Object[] { paramw });
      AppMethodBeat.o(321490);
      return paramString;
    }
    paramw = (String)localk.value;
    try
    {
      localJSONObject.put("windowBackgroundImageFilePath", paramw);
      localJSONObject.put("isWindowTransparencyDisabledByCompatibilityIssues", ((t)com.tencent.mm.kernel.h.ax(t.class)).cAy());
      paramw = localJSONObject.toString();
      AppMethodBeat.o(321490);
      return paramw;
    }
    catch (JSONException paramw)
    {
      Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4WindowBackgroundImage put extra fields get exception %s", new Object[] { paramw });
      AppMethodBeat.o(321490);
    }
    return paramString;
  }
  
  public static void c(w paramw, JSONObject paramJSONObject)
  {
    int j = 0;
    AppMethodBeat.i(48111);
    paramJSONObject.put("scene", paramw.asA().epn.scene);
    paramJSONObject.put("scene_note", paramw.asA().epn.hzx);
    paramJSONObject.put("sessionId", paramw.getInitConfig().eoP);
    paramJSONObject.put("usedState", paramw.asA().epn.tOj);
    paramJSONObject.put("prescene", paramw.asA().epn.icZ);
    paramJSONObject.put("prescene_note", paramw.asA().epn.ida);
    Object localObject1 = paramw.getInitConfig().icX;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramJSONObject.put("chatroomUsername", localObject1);
    }
    localObject1 = paramw.getInitConfig().qAX;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramJSONObject.put("shortLink", localObject1);
    }
    int i = paramw.getInitConfig().epn.chatType;
    if (i != -1) {
      paramJSONObject.put("chatType", i);
    }
    i = paramw.getInitConfig().epn.tOn;
    if (d.a.uB(i)) {
      paramJSONObject.put("codeScene", i);
    }
    Object localObject2;
    if (!TextUtils.isEmpty(paramw.getInitConfig().qYh))
    {
      localObject2 = paramw.getInitConfig().qYh;
      localObject1 = localObject2;
      if (1173 == paramw.asA().epn.scene) {
        localObject1 = b(paramw, (String)localObject2);
      }
      localObject2 = localObject1;
      if (z.raW == paramw.getInitConfig().aqE())
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramw.getInitConfig().aqF())) {
          localObject2 = c(paramw, (String)localObject1);
        }
      }
    }
    for (;;)
    {
      try
      {
        paramJSONObject.put("nativeExtraData", new JSONObject((String)localObject2));
        localObject1 = paramw.getInitConfig().qYg;
        if ((localObject1 == null) || (((PersistableBundle)localObject1).size() <= 0)) {}
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          paramJSONObject.put("transitExtraData", com.tencent.luggage.l.d.a(paramw.getInitConfig().qYg));
          if (k.a.vK(paramw.getInitConfig().eul))
          {
            i = 0;
            paramJSONObject.put("appversion", i);
            localObject1 = Q(paramw);
            paramJSONObject.put("mode", localObject1);
            switch (((String)localObject1).hashCode())
            {
            default: 
              i = -1;
              switch (i)
              {
              default: 
                AppMethodBeat.o(48111);
                return;
                localJSONException1 = localJSONException1;
                Log.printErrStackTrace("MicroMsg.AppBrandPageVisitStatisticsHelper", localJSONException1, "", new Object[0]);
              }
              break;
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          Log.printErrStackTrace("MicroMsg.AppBrandPageVisitStatisticsHelper", localJSONException2, "", new Object[0]);
          continue;
          i = paramw.getInitConfig().appVersion;
          continue;
          if (!localJSONException2.equals("singlePage")) {
            continue;
          }
          i = j;
          continue;
          if (!localJSONException2.equals("embedded")) {
            continue;
          }
          i = 1;
          continue;
          if (!localJSONException2.equals("halfPage")) {
            continue;
          }
          i = 2;
          continue;
          if (!localJSONException2.equals("default")) {
            continue;
          }
          i = 3;
          continue;
          if (paramw.getInitConfig().opX == 0)
          {
            paramJSONObject.put("appearance", "default");
            AppMethodBeat.o(48111);
            return;
          }
          paramJSONObject.put("appearance", "banned");
          AppMethodBeat.o(48111);
          return;
        }
      }
      paramJSONObject.put("appearance", "default");
      AppMethodBeat.o(48111);
      return;
      if (!paramw.qvN.cQe())
      {
        paramJSONObject.put("appearance", "default");
        AppMethodBeat.o(48111);
        return;
      }
      paramJSONObject.put("appearance", "nativeFunctionalized");
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
      if ((1 == paramAppBrandLaunchReferrer.qYE) || (3 == paramAppBrandLaunchReferrer.qYE)) {
        return paramAppBrandLaunchReferrer.appId;
      }
    } while (2 != paramAppBrandLaunchReferrer.qYE);
    return paramAppBrandLaunchReferrer.url;
  }
  
  public static Pair<Integer, String> t(ah paramah)
  {
    int i = 7;
    AppMethodBeat.i(48112);
    Intent localIntent;
    switch (1.qLA[com.tencent.mm.plugin.appbrand.k.Uo(paramah.getAppId()).ordinal()])
    {
    default: 
      localIntent = u(paramah).cBl();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          paramah = "";
          Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          if ((!paramah.contains("WebViewUI")) && (!paramah.contains("WebviewMpUI"))) {
            break label253;
          }
          i = 10;
          paramah = IntentUtil.getStringExtra(localIntent, AppBrandProcessProxyUI.ruH);
        }
      }
      break;
    }
    for (;;)
    {
      paramah = Pair.create(Integer.valueOf(i), paramah);
      AppMethodBeat.o(48112);
      return paramah;
      if (paramah.txQ.isLoading()) {}
      for (i = 4;; i = 3)
      {
        paramah = null;
        break;
      }
      if (paramah.txQ.isLoading()) {
        i = 5;
      }
      paramah = null;
      continue;
      i = 6;
      paramah = null;
      continue;
      i = 9;
      paramah = com.tencent.mm.plugin.appbrand.u.Ux(paramah.getAppId()).qvb + ":" + com.tencent.mm.compatible.util.r.cg(Util.nullAsNil(com.tencent.mm.plugin.appbrand.u.Ux(paramah.getAppId()).qvc));
      continue;
      paramah = localIntent.getComponent().getClassName();
      break;
      label253:
      paramah = Util.nullAs(IntentUtil.getStringExtra(localIntent, AppBrandProcessProxyUI.ruI), paramah);
      i = 8;
      continue;
      paramah = null;
    }
  }
  
  private static h u(ah paramah)
  {
    AppMethodBeat.i(48113);
    paramah = paramah.getRuntime().ccN().getReporter();
    AppMethodBeat.o(48113);
    return paramah;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.e
 * JD-Core Version:    0.7.0.1
 */