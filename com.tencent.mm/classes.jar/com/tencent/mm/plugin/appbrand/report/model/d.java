package com.tencent.mm.plugin.appbrand.report.model;

import android.content.ComponentName;
import android.content.Intent;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.k.e;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.bd;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.jsapi.file.av;
import com.tencent.mm.plugin.appbrand.openmaterial.model.a;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.apache.commons.a.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static String G(t paramt)
  {
    AppMethodBeat.i(279489);
    if (paramt.bDy().nBE.isEnable())
    {
      AppMethodBeat.o(279489);
      return "halfPage";
    }
    if (bd.s(paramt))
    {
      AppMethodBeat.o(279489);
      return "singlePage";
    }
    AppMethodBeat.o(279489);
    return "default";
  }
  
  public static void a(t paramt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48109);
    try
    {
      if ((j.a.vB(paramt.bDy().cBI)) && (!TextUtils.isEmpty(paramt.bDy().nYg))) {
        paramJSONObject.put("debugLaunchInfo", new JSONObject(paramt.bDy().nYg));
      }
      AppMethodBeat.o(48109);
      return;
    }
    catch (JSONException paramt)
    {
      Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillDebugLaunchInfo ex = %s", new Object[] { paramt });
      AppMethodBeat.o(48109);
    }
  }
  
  private static String b(t paramt, String paramString)
  {
    AppMethodBeat.i(279490);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(279490);
      return paramString;
    }
    Object localObject1 = a.ali(paramString);
    if (localObject1 == null)
    {
      AppMethodBeat.o(279490);
      return paramString;
    }
    Object localObject2 = ((a)localObject1).qnl.trim();
    Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, originMaterialPath: ".concat(String.valueOf(localObject2)));
    if ((((String)localObject2).startsWith("http://")) || (((String)localObject2).startsWith("https://")))
    {
      AppMethodBeat.o(279490);
      return paramString;
    }
    String str1 = ((a)localObject1).mimeType;
    if ((!str1.startsWith("image")) && (!str1.startsWith("video"))) {}
    for (localObject1 = c.beJ((String)localObject2);; localObject1 = "")
    {
      String str2 = c.bIf((String)localObject2);
      com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q((String)localObject2);
      int i = (int)localq.length();
      Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, fileName: %s, fileExt: %s，fileSize: %d", new Object[] { localObject1, str2, Integer.valueOf(i) });
      localObject2 = new com.tencent.mm.plugin.appbrand.ac.i();
      paramt = paramt.Sh().a(localq, str2, false, (com.tencent.mm.plugin.appbrand.ac.i)localObject2);
      Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, result: ".concat(String.valueOf(paramt)));
      if (m.nMR != paramt)
      {
        AppMethodBeat.o(279490);
        return paramString;
      }
      paramt = (String)((com.tencent.mm.plugin.appbrand.ac.i)localObject2).value;
      Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, newMaterialPath: ".concat(String.valueOf(paramt)));
      paramt = new a(str1, paramt, (String)localObject1, i).bFa();
      AppMethodBeat.o(279490);
      return paramt;
    }
  }
  
  public static void b(t paramt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48110);
    try
    {
      c(paramt, paramJSONObject);
      paramJSONObject.put("referpagepath", d(paramt.bDy().cwV));
      paramJSONObject.put("clickTimestamp", paramt.bDy().startTime);
      AppMethodBeat.o(48110);
      return;
    }
    catch (Exception paramt)
    {
      Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillWxConfigLaunchInfo ex = %s", new Object[] { paramt });
      AppMethodBeat.o(48110);
    }
  }
  
  public static void c(t paramt, JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(48111);
    paramJSONObject.put("scene", paramt.Sk().cxf.scene);
    paramJSONObject.put("scene_note", paramt.Sk().cxf.fvd);
    paramJSONObject.put("sessionId", paramt.bDy().cwP);
    paramJSONObject.put("usedState", paramt.Sk().cxf.qJF);
    paramJSONObject.put("prescene", paramt.Sk().cxf.fXa);
    paramJSONObject.put("prescene_note", paramt.Sk().cxf.fXb);
    Object localObject = paramt.bDy().fWY;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject.put("chatroomUsername", localObject);
    }
    localObject = paramt.bDy().nBJ;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject.put("shortLink", localObject);
    }
    int j = paramt.bDy().cxf.chatType;
    if (j != -1) {
      paramJSONObject.put("chatType", j);
    }
    if (!TextUtils.isEmpty(paramt.bDy().nYf))
    {
      String str = paramt.bDy().nYf;
      localObject = str;
      if (1173 == paramt.Sk().cxf.scene) {
        localObject = b(paramt, str);
      }
    }
    try
    {
      paramJSONObject.put("nativeExtraData", new JSONObject((String)localObject));
      localObject = paramt.bDy().nYe;
      if ((localObject == null) || (((PersistableBundle)localObject).size() <= 0)) {}
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        paramJSONObject.put("transitExtraData", e.a(paramt.bDy().nYe));
        if (j.a.vB(paramt.bDy().cBI))
        {
          paramJSONObject.put("appversion", i);
          paramJSONObject.put("mode", G(paramt));
          AppMethodBeat.o(48111);
          return;
          localJSONException1 = localJSONException1;
          Log.printErrStackTrace("MicroMsg.AppBrandPageVisitStatisticsHelper", localJSONException1, "", new Object[0]);
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppBrandPageVisitStatisticsHelper", localJSONException2, "", new Object[0]);
          continue;
          i = paramt.bDy().appVersion;
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
      if ((1 == paramAppBrandLaunchReferrer.nYB) || (3 == paramAppBrandLaunchReferrer.nYB)) {
        return paramAppBrandLaunchReferrer.appId;
      }
    } while (2 != paramAppBrandLaunchReferrer.nYB);
    return paramAppBrandLaunchReferrer.url;
  }
  
  public static Pair<Integer, String> r(ah paramah)
  {
    int i = 7;
    AppMethodBeat.i(48112);
    Intent localIntent;
    switch (1.nLM[com.tencent.mm.plugin.appbrand.k.abM(paramah.getAppId()).ordinal()])
    {
    default: 
      localIntent = s(paramah).caR();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          paramah = "";
          Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          if ((!paramah.contains("WebViewUI")) && (!paramah.contains("WebviewMpUI"))) {
            break label253;
          }
          i = 10;
          paramah = IntentUtil.getStringExtra(localIntent, AppBrandProcessProxyUI.oqN);
        }
      }
      break;
    }
    for (;;)
    {
      paramah = Pair.create(Integer.valueOf(i), paramah);
      AppMethodBeat.o(48112);
      return paramah;
      if (paramah.qtk.isLoading()) {}
      for (i = 4;; i = 3)
      {
        paramah = null;
        break;
      }
      if (paramah.qtk.isLoading()) {
        i = 5;
      }
      paramah = null;
      continue;
      i = 6;
      paramah = null;
      continue;
      i = 9;
      paramah = s.abV(paramah.getAppId()).nwe + ":" + com.tencent.mm.compatible.util.q.aT(Util.nullAsNil(s.abV(paramah.getAppId()).nwf));
      continue;
      paramah = localIntent.getComponent().getClassName();
      break;
      label253:
      paramah = Util.nullAs(IntentUtil.getStringExtra(localIntent, AppBrandProcessProxyUI.oqO), paramah);
      i = 8;
      continue;
      paramah = null;
    }
  }
  
  private static f s(ah paramah)
  {
    AppMethodBeat.i(48113);
    paramah = paramah.getRuntime().bDz().getReporter();
    AppMethodBeat.o(48113);
    return paramah;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.d
 * JD-Core Version:    0.7.0.1
 */