package com.tencent.mm.plugin.appbrand.app;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.appstorage.h.a;
import com.tencent.mm.plugin.appbrand.appstorage.h.a.a;
import com.tencent.mm.plugin.appbrand.au.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.ui.recommend.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public final class AppBrandMixExportLogicService
  implements f
{
  public final Pair<Integer, String> a(Context paramContext, WXLaunchWxaRedirectingPage.Req paramReq, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(283808);
    paramString2 = Uri.parse(paramString2);
    String str3 = paramString2.getQueryParameter("host_appid");
    int i = Util.getInt(paramString2.getQueryParameter("wxa_scene"), 1);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.nYB = 7;
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
      paramString2 = localWechatNativeExtraDataInvokeFunctionalPage.qbq;
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
      paramString3 = new g();
      paramString3.appId = paramString1;
      paramString3.nBq = paramReq;
      paramString3.scene = 1111;
      paramString3.fvd = (str3 + ":" + paramString2);
      paramString3.nBz = localAppBrandLaunchReferrer;
      paramString3.nBr = localWechatNativeExtraDataInvokeFunctionalPage;
      paramString3.cBU = localWechatNativeExtraDataInvokeFunctionalPage.qbu;
      if (!com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.c.a(paramContext, localWechatNativeExtraDataInvokeFunctionalPage, paramString3)) {
        break label372;
      }
      paramContext = Pair.create(Integer.valueOf(0), "OK");
      AppMethodBeat.o(283808);
      return paramContext;
      label372:
      if (!((String)Objects.requireNonNull(paramString2)).endsWith("openUrl")) {
        break label393;
      }
      com.tencent.mm.xwebutil.c.bCD("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
      label393:
      ((r)com.tencent.mm.kernel.h.ae(r.class)).a(paramContext, paramString3);
      paramContext = Pair.create(Integer.valueOf(0), "OK");
      AppMethodBeat.o(283808);
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (localWechatNativeExtraDataInvokeFunctionalPage == null))
    {
      Log.e("MicroMsg.AppBrandMixExportLogicService", "openWeappFunctionalPageByDeepLink invalid apiName(%s) miniprogramAppID(%s) transferBuffer(%s)", new Object[] { paramString2, paramString1, paramString3 });
      paramContext = Pair.create(Integer.valueOf(-1), "Invalid transferJson");
      AppMethodBeat.o(283808);
      return paramContext;
    }
    return paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(174698);
    OpenFileRequest localOpenFileRequest = new OpenFileRequest();
    localOpenFileRequest.filePath = paramString1;
    localOpenFileRequest.jmx = paramString2;
    localOpenFileRequest.appId = paramString3;
    localOpenFileRequest.orn = paramBoolean;
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, localOpenFileRequest, paramString4);
    AppMethodBeat.o(174698);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.service.z paramz)
  {
    AppMethodBeat.i(283801);
    com.tencent.mm.plugin.appbrand.task.i.cjb().a(LuggageServiceType.cBP, paramz);
    AppMethodBeat.o(283801);
  }
  
  public final <T extends Parcelable> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(174695);
    com.tencent.mm.plugin.appbrand.ipc.e.b(paramString, paramT);
    AppMethodBeat.o(174695);
  }
  
  public final String aca(String paramString)
  {
    AppMethodBeat.i(283806);
    paramString = com.tencent.mm.plugin.appbrand.z.aca(paramString);
    AppMethodBeat.o(283806);
    return paramString;
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.service.z paramz)
  {
    AppMethodBeat.i(283802);
    com.tencent.mm.plugin.appbrand.task.i.cjb().a(LuggageServiceType.cBP, paramz);
    AppMethodBeat.o(283802);
  }
  
  public final void bFi()
  {
    AppMethodBeat.i(44097);
    if ((com.tencent.mm.plugin.appbrand.ui.recommend.c.clA()) && (com.tencent.mm.plugin.appbrand.ui.recommend.c.clB())) {
      a(com.tencent.mm.plugin.appbrand.service.z.qPd);
    }
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44089);
        d.rgQ.clE();
        AppMethodBeat.o(44089);
      }
    });
    AppMethodBeat.o(44097);
  }
  
  public final void bFj()
  {
    AppMethodBeat.i(283804);
    o.bBS();
    h.a locala = com.tencent.mm.plugin.appbrand.appstorage.h.nMI;
    com.tencent.e.h.ZvG.be((Runnable)new com.tencent.mm.plugin.appbrand.utils.a((Runnable)h.a.a.nMK));
    AppMethodBeat.o(283804);
  }
  
  public final void bFk()
  {
    AppMethodBeat.i(283805);
    j.clean();
    AppMethodBeat.o(283805);
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.service.z paramz)
  {
    AppMethodBeat.i(283803);
    com.tencent.mm.plugin.appbrand.task.i.cjb().a(LuggageServiceType.cBQ, paramz);
    AppMethodBeat.o(283803);
  }
  
  public final Pair<String, Integer> yY(int paramInt)
  {
    AppMethodBeat.i(283807);
    Pair localPair = new Pair(com.tencent.mm.plugin.appbrand.appcache.e.yZ(paramInt), Integer.valueOf(au.e.app_brand_recents_item_type_tag));
    AppMethodBeat.o(283807);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService
 * JD-Core Version:    0.7.0.1
 */