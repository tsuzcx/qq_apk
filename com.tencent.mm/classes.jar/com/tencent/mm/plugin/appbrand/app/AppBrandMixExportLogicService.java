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
import com.tencent.mm.plugin.appbrand.ac;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.m.a;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOnWebPageUrlExposed;
import com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel.JsApiOpenWebViewUseFastLoad;
import com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public final class AppBrandMixExportLogicService
  implements com.tencent.mm.plugin.appbrand.service.g
{
  public final String UC(String paramString)
  {
    AppMethodBeat.i(317816);
    paramString = ac.UC(paramString);
    AppMethodBeat.o(317816);
    return paramString;
  }
  
  public final Pair<Integer, String> a(Context paramContext, WXLaunchWxaRedirectingPage.Req paramReq, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(317831);
    paramString2 = Uri.parse(paramString2);
    String str3 = paramString2.getQueryParameter("host_appid");
    int i = Util.getInt(paramString2.getQueryParameter("wxa_scene"), 1);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
    localAppBrandLaunchReferrer.qYE = 7;
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
      paramString2 = localWechatNativeExtraDataInvokeFunctionalPage.efV;
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
      paramString3.qAF = paramReq;
      paramString3.scene = 1111;
      paramString3.hzx = (str3 + ":" + paramString2);
      paramString3.qAO = localAppBrandLaunchReferrer;
      paramString3.qAG = localWechatNativeExtraDataInvokeFunctionalPage;
      paramString3.euz = localWechatNativeExtraDataInvokeFunctionalPage.tgv;
      if (!com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.c.a(paramContext, localWechatNativeExtraDataInvokeFunctionalPage, paramString3)) {
        break label372;
      }
      paramContext = Pair.create(Integer.valueOf(0), "OK");
      AppMethodBeat.o(317831);
      return paramContext;
      label372:
      if (!((String)Objects.requireNonNull(paramString2)).endsWith("openUrl")) {
        break label393;
      }
      com.tencent.mm.xwebutil.c.bFh("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
      label393:
      ((t)com.tencent.mm.kernel.h.ax(t.class)).a(paramContext, paramString3);
      paramContext = Pair.create(Integer.valueOf(0), "OK");
      AppMethodBeat.o(317831);
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (localWechatNativeExtraDataInvokeFunctionalPage == null))
    {
      Log.e("MicroMsg.AppBrandMixExportLogicService", "openWeappFunctionalPageByDeepLink invalid apiName(%s) miniprogramAppID(%s) transferBuffer(%s)", new Object[] { paramString2, paramString1, paramString3 });
      paramContext = Pair.create(Integer.valueOf(-1), "Invalid transferJson");
      AppMethodBeat.o(317831);
      return paramContext;
    }
    return paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(174698);
    OpenFileRequest localOpenFileRequest = new OpenFileRequest();
    localOpenFileRequest.filePath = paramString1;
    localOpenFileRequest.lPJ = paramString2;
    localOpenFileRequest.appId = paramString3;
    localOpenFileRequest.rvh = paramBoolean;
    a.a(paramContext, localOpenFileRequest, paramString4);
    AppMethodBeat.o(174698);
  }
  
  public final void a(ab paramab)
  {
    AppMethodBeat.i(317789);
    com.tencent.mm.plugin.appbrand.task.i.cJV().a(LuggageServiceType.euv, paramab);
    AppMethodBeat.o(317789);
  }
  
  public final <T extends Parcelable> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(174695);
    com.tencent.mm.plugin.appbrand.ipc.f.b(paramString, paramT);
    AppMethodBeat.o(174695);
  }
  
  public final void b(ab paramab)
  {
    AppMethodBeat.i(317790);
    com.tencent.mm.plugin.appbrand.task.i.cJV().a(LuggageServiceType.euv, paramab);
    AppMethodBeat.o(317790);
  }
  
  public final void c(ab paramab)
  {
    AppMethodBeat.i(317791);
    com.tencent.mm.plugin.appbrand.task.i.cJV().a(LuggageServiceType.euw, paramab);
    AppMethodBeat.o(317791);
  }
  
  public final void cew()
  {
    AppMethodBeat.i(44097);
    if ((com.tencent.mm.plugin.appbrand.ui.recommend.c.cMX()) && (com.tencent.mm.plugin.appbrand.ui.recommend.c.cMY())) {
      a(ab.tTU);
    }
    com.tencent.threadpool.h.ahAA.bm(new AppBrandMixExportLogicService.1(this));
    AppMethodBeat.o(44097);
  }
  
  public final void cex()
  {
    AppMethodBeat.i(317797);
    o.cbp();
    m.a locala = m.qMD;
    m.a.cig();
    AppMethodBeat.o(317797);
  }
  
  public final void cey()
  {
    AppMethodBeat.i(317801);
    j.clean();
    AppMethodBeat.o(317801);
  }
  
  public final p zk(int paramInt)
  {
    AppMethodBeat.i(317806);
    Object localObject;
    if (paramInt == 968)
    {
      localObject = new com.tencent.mm.plugin.appbrand.jsapi.channels.f();
      AppMethodBeat.o(317806);
      return localObject;
    }
    if (paramInt == 764)
    {
      localObject = new JsApiOpenWebViewUseFastLoad();
      AppMethodBeat.o(317806);
      return localObject;
    }
    if (paramInt == 865)
    {
      localObject = new JsApiOnWebPageUrlExposed();
      AppMethodBeat.o(317806);
      return localObject;
    }
    AppMethodBeat.o(317806);
    return null;
  }
  
  public final Pair<String, Integer> zl(int paramInt)
  {
    AppMethodBeat.i(317819);
    Pair localPair = new Pair(e.zm(paramInt), Integer.valueOf(ba.e.app_brand_recents_item_type_tag));
    AppMethodBeat.o(317819);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService
 * JD-Core Version:    0.7.0.1
 */