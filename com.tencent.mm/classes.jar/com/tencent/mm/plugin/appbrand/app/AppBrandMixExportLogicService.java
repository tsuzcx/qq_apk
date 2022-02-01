package com.tencent.mm.plugin.appbrand.app;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public final class AppBrandMixExportLogicService
  implements com.tencent.mm.plugin.appbrand.service.f
{
  public static com.tencent.mm.vending.g.e<Pair<String, String>> y(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44098);
    paramString = com.tencent.mm.cn.g.j(paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(44098);
    return paramString;
  }
  
  public final String KJ(String paramString)
  {
    AppMethodBeat.i(187968);
    paramString = u.KJ(paramString);
    AppMethodBeat.o(187968);
    return paramString;
  }
  
  public final Pair<Integer, String> a(Context paramContext, WXLaunchWxaRedirectingPage.Req paramReq, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(187970);
    paramString2 = Uri.parse(paramString2);
    String str2 = paramString2.getQueryParameter("host_appid");
    int i = bt.getInt(paramString2.getQueryParameter("wxa_scene"), 1);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.jXR = 7;
    localAppBrandLaunchReferrer.appId = str2;
    try
    {
      paramString2 = new JSONObject(new JSONObject(paramString3).optString("invokeData"));
      String str1 = paramString2.getString("miniprogramAppID");
      paramString2.put("invokeTicket", paramReq.invokeTicket);
      paramString2.put("wxa_scene", i);
      paramString2.put("packageName", paramString1);
      paramString2.put("callbackActivity", paramReq.callbackActivity);
      paramString2 = new WechatNativeExtraDataInvokeFunctionalPage(paramString2);
      paramString1 = paramString2.lOX;
      paramReq = str1;
    }
    catch (JSONException paramReq)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrandMixExportLogicService", "openWeappFunctionalPageByDeepLink, get JSONException %s", new Object[] { paramReq });
        paramString1 = "";
        paramReq = "";
        paramString2 = null;
      }
      paramString3 = new com.tencent.mm.plugin.appbrand.api.f();
      paramString3.appId = paramReq;
      paramString3.jCN = "__wx__/open-api-redirecting-page";
      paramString3.scene = 1111;
      paramString3.dkh = (str2 + ":" + paramString1);
      paramString3.jCW = localAppBrandLaunchReferrer;
      paramString3.jCO = paramString2;
      if (!com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.c.a(paramContext, paramString2, paramString3)) {
        break label341;
      }
      paramContext = Pair.create(Integer.valueOf(0), "OK");
      AppMethodBeat.o(187970);
      return paramContext;
      label341:
      if (!((String)Objects.requireNonNull(paramString1)).endsWith("openUrl")) {
        break label361;
      }
      com.tencent.mm.cq.d.aYU("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
      label361:
      ((o)com.tencent.mm.kernel.g.ab(o.class)).a(paramContext, paramString3);
      paramContext = Pair.create(Integer.valueOf(0), "OK");
      AppMethodBeat.o(187970);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramReq)) || (paramString2 == null))
    {
      ad.e("MicroMsg.AppBrandMixExportLogicService", "openWeappFunctionalPageByDeepLink invalid apiName(%s) miniprogramAppID(%s) transferBuffer(%s)", new Object[] { paramString1, paramReq, paramString3 });
      paramContext = Pair.create(Integer.valueOf(-1), "Invalid transferJson");
      AppMethodBeat.o(187970);
      return paramContext;
    }
    return paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(174698);
    OpenFileRequest localOpenFileRequest = new OpenFileRequest();
    localOpenFileRequest.filePath = paramString1;
    localOpenFileRequest.fVf = paramString2;
    localOpenFileRequest.appId = paramString3;
    localOpenFileRequest.kpF = paramBoolean;
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, localOpenFileRequest, paramString4);
    AppMethodBeat.o(174698);
  }
  
  public final <T extends Parcelable> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(174695);
    com.tencent.mm.plugin.appbrand.ipc.e.b(paramString, paramT);
    AppMethodBeat.o(174695);
  }
  
  public final void aYx()
  {
    AppMethodBeat.i(44096);
    com.tencent.mm.plugin.appbrand.task.f.byE();
    AppMethodBeat.o(44096);
  }
  
  public final void aYy()
  {
    AppMethodBeat.i(44097);
    if ((com.tencent.mm.plugin.appbrand.ui.recommend.c.bAW()) && (com.tencent.mm.plugin.appbrand.ui.recommend.c.bAY())) {
      com.tencent.mm.plugin.appbrand.task.f.byE();
    }
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44089);
        com.tencent.mm.plugin.appbrand.ui.recommend.d locald = com.tencent.mm.plugin.appbrand.ui.recommend.d.mMY;
        com.tencent.mm.plugin.appbrand.ui.recommend.d.bAZ();
        AppMethodBeat.o(44089);
      }
    });
    AppMethodBeat.o(44097);
  }
  
  public final void aYz()
  {
    AppMethodBeat.i(187967);
    j.aVI();
    AppMethodBeat.o(187967);
  }
  
  public final Pair<String, Integer> rO(int paramInt)
  {
    AppMethodBeat.i(187969);
    Pair localPair = new Pair(com.tencent.mm.plugin.appbrand.appcache.e.rP(paramInt), Integer.valueOf(2131231009));
    AppMethodBeat.o(187969);
    return localPair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService
 * JD-Core Version:    0.7.0.1
 */