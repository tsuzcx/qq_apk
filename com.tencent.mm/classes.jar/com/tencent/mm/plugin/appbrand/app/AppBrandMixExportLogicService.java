package com.tencent.mm.plugin.appbrand.app;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.b;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public final class AppBrandMixExportLogicService
  implements com.tencent.mm.plugin.appbrand.service.f
{
  public static com.tencent.mm.vending.g.e<Pair<String, String>> y(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44098);
    paramString = com.tencent.mm.co.g.j(paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(44098);
    return paramString;
  }
  
  public final String Ur(String paramString)
  {
    AppMethodBeat.i(226289);
    paramString = w.Ur(paramString);
    AppMethodBeat.o(226289);
    return paramString;
  }
  
  public final Pair<Integer, String> a(Context paramContext, WXLaunchWxaRedirectingPage.Req paramReq, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(226291);
    paramString2 = Uri.parse(paramString2);
    String str3 = paramString2.getQueryParameter("host_appid");
    int i = Util.getInt(paramString2.getQueryParameter("wxa_scene"), 1);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.leo = 7;
    localAppBrandLaunchReferrer.appId = str3;
    try
    {
      paramString2 = new JSONObject(new JSONObject(paramString3).optString("invokeData"));
      String str2 = paramString2.getString("miniprogramAppID");
      String str1 = paramString2.optString("path", "__wx__/open-api-redirecting-page");
      paramString2.put("invokeTicket", paramReq.invokeTicket);
      paramString2.put("wxa_scene", i);
      paramString2.put("packageName", paramString1);
      paramString2.put("callbackActivity", paramReq.callbackActivity);
      localWechatNativeExtraDataInvokeFunctionalPage = new WechatNativeExtraDataInvokeFunctionalPage(paramString2);
      paramString2 = localWechatNativeExtraDataInvokeFunctionalPage.nbb;
      paramString1 = str2;
      paramReq = str1;
    }
    catch (JSONException paramReq)
    {
      WechatNativeExtraDataInvokeFunctionalPage localWechatNativeExtraDataInvokeFunctionalPage;
      for (;;)
      {
        Log.e("MicroMsg.AppBrandMixExportLogicService", "openWeappFunctionalPageByDeepLink, get JSONException %s", new Object[] { paramReq });
        paramString2 = "";
        paramString1 = "";
        localWechatNativeExtraDataInvokeFunctionalPage = null;
        paramReq = "__wx__/open-api-redirecting-page";
      }
      paramString3 = new com.tencent.mm.plugin.appbrand.api.g();
      paramString3.appId = paramString1;
      paramString3.kHw = paramReq;
      paramString3.scene = 1111;
      paramString3.dCw = (str3 + ":" + paramString2);
      paramString3.kHF = localAppBrandLaunchReferrer;
      paramString3.kHx = localWechatNativeExtraDataInvokeFunctionalPage;
      paramString3.iOo = localWechatNativeExtraDataInvokeFunctionalPage.nbf;
      if (!com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.c.a(paramContext, localWechatNativeExtraDataInvokeFunctionalPage, paramString3)) {
        break label372;
      }
      paramContext = Pair.create(Integer.valueOf(0), "OK");
      AppMethodBeat.o(226291);
      return paramContext;
      label372:
      if (!((String)Objects.requireNonNull(paramString2)).endsWith("openUrl")) {
        break label393;
      }
      com.tencent.mm.cr.d.bpG("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
      label393:
      ((r)com.tencent.mm.kernel.g.af(r.class)).a(paramContext, paramString3);
      paramContext = Pair.create(Integer.valueOf(0), "OK");
      AppMethodBeat.o(226291);
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (localWechatNativeExtraDataInvokeFunctionalPage == null))
    {
      Log.e("MicroMsg.AppBrandMixExportLogicService", "openWeappFunctionalPageByDeepLink invalid apiName(%s) miniprogramAppID(%s) transferBuffer(%s)", new Object[] { paramString2, paramString1, paramString3 });
      paramContext = Pair.create(Integer.valueOf(-1), "Invalid transferJson");
      AppMethodBeat.o(226291);
      return paramContext;
    }
    return paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(174698);
    OpenFileRequest localOpenFileRequest = new OpenFileRequest();
    localOpenFileRequest.filePath = paramString1;
    localOpenFileRequest.gCr = paramString2;
    localOpenFileRequest.appId = paramString3;
    localOpenFileRequest.lwF = paramBoolean;
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, localOpenFileRequest, paramString4);
    AppMethodBeat.o(174698);
  }
  
  public final void a(z paramz)
  {
    AppMethodBeat.i(226284);
    com.tencent.mm.plugin.appbrand.task.h.bWb().e(paramz);
    AppMethodBeat.o(226284);
  }
  
  public final <T extends Parcelable> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(174695);
    com.tencent.mm.plugin.appbrand.ipc.e.b(paramString, paramT);
    AppMethodBeat.o(174695);
  }
  
  public final void b(z paramz)
  {
    AppMethodBeat.i(226285);
    com.tencent.mm.plugin.appbrand.task.h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.nPD, paramz);
    AppMethodBeat.o(226285);
  }
  
  public final void bui()
  {
    AppMethodBeat.i(44097);
    if ((com.tencent.mm.plugin.appbrand.ui.recommend.c.bYQ()) && (com.tencent.mm.plugin.appbrand.ui.recommend.c.bYS())) {
      a(z.nML);
    }
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44089);
        com.tencent.mm.plugin.appbrand.ui.recommend.d.ofe.bYV();
        AppMethodBeat.o(44089);
      }
    });
    AppMethodBeat.o(44097);
  }
  
  public final void buj()
  {
    AppMethodBeat.i(226287);
    com.tencent.mm.plugin.appbrand.l.brc();
    AppMethodBeat.o(226287);
  }
  
  public final void buk()
  {
    AppMethodBeat.i(226288);
    com.tencent.mm.plugin.appbrand.g.clean();
    AppMethodBeat.o(226288);
  }
  
  public final void c(z paramz)
  {
    AppMethodBeat.i(226286);
    com.tencent.mm.plugin.appbrand.task.h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.nPE, paramz);
    AppMethodBeat.o(226286);
  }
  
  public final Pair<String, Integer> vN(int paramInt)
  {
    AppMethodBeat.i(226290);
    Pair localPair = new Pair(com.tencent.mm.plugin.appbrand.appcache.e.vO(paramInt), Integer.valueOf(2131231041));
    AppMethodBeat.o(226290);
    return localPair;
  }
  
  public static final class AppBrandOnStartReportCanvasDataEvent
    implements Parcelable
  {
    public static final Parcelable.Creator<AppBrandOnStartReportCanvasDataEvent> CREATOR;
    public String appId;
    
    static
    {
      AppMethodBeat.i(44095);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44095);
    }
    
    AppBrandOnStartReportCanvasDataEvent() {}
    
    AppBrandOnStartReportCanvasDataEvent(Parcel paramParcel)
    {
      AppMethodBeat.i(44094);
      this.appId = paramParcel.readString();
      AppMethodBeat.o(44094);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44093);
      paramParcel.writeString(this.appId);
      AppMethodBeat.o(44093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService
 * JD-Core Version:    0.7.0.1
 */