package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import com.tencent.mm.plugin.appbrand.ah.a.a.a;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "", "NAME", "", "getNAME", "()Ljava/lang/String;", "backToApp", "", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "context", "Landroid/content/Context;", "retMsg", "invoke", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"})
public abstract interface b
{
  public abstract void a(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, Context paramContext);
  
  public abstract void a(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, g paramg);
  
  public abstract String bOK();
  
  @l(hxD={1, 1, 16})
  public static final class a
  {
    public static void a(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, Context paramContext, String paramString)
    {
      AppMethodBeat.i(228891);
      p.h(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
      Bundle localBundle = new Bundle();
      paramString = new WXLaunchWxaRedirectingPage.Resp(Bundle.EMPTY);
      String str = paramWechatNativeExtraDataInvokeFunctionalPage.invokeTicket;
      if (str == null) {
        p.hyc();
      }
      paramString.invokeTicket = str;
      paramString.callbackActivity = paramWechatNativeExtraDataInvokeFunctionalPage.callbackActivity;
      paramString.errStr = null;
      paramString.toBundle(localBundle);
      q.bo(localBundle);
      q.bp(localBundle);
      paramString = a.a.oFy;
      paramString = paramWechatNativeExtraDataInvokeFunctionalPage.invokeTicket;
      if (paramString == null) {
        p.hyc();
      }
      paramString = a.a.agm(paramString);
      if (paramString != null) {
        paramString.overridePendingTransition(0, 0);
      }
      paramString = paramContext;
      if (paramContext == null) {
        paramString = MMApplicationContext.getContext();
      }
      paramContext = new MMessageActV2.Args();
      paramContext.targetPkgName = paramWechatNativeExtraDataInvokeFunctionalPage.packageName;
      paramContext.bundle = localBundle;
      MMessageActV2.send(paramString, paramContext);
      AppMethodBeat.o(228891);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.b
 * JD-Core Version:    0.7.0.1
 */