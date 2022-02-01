package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import com.tencent.mm.plugin.appbrand.aj.a.a.a;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "", "NAME", "", "getNAME", "()Ljava/lang/String;", "backToApp", "", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "context", "Landroid/content/Context;", "retMsg", "invoke", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public abstract void a(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, Context paramContext);
  
  public abstract void a(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, g paramg);
  
  public abstract String cBt();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(b paramb, WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, Context paramContext, String paramString)
    {
      AppMethodBeat.i(320071);
      s.u(paramb, "this");
      s.u(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
      paramString = new Bundle();
      paramb = new WXLaunchWxaRedirectingPage.Resp(Bundle.EMPTY);
      String str = paramWechatNativeExtraDataInvokeFunctionalPage.invokeTicket;
      s.checkNotNull(str);
      paramb.invokeTicket = str;
      paramb.callbackActivity = paramWechatNativeExtraDataInvokeFunctionalPage.callbackActivity;
      paramb.errStr = null;
      paramb.toBundle(paramString);
      u.bS(paramString);
      u.bT(paramString);
      paramb = a.a.uSD;
      paramb = paramWechatNativeExtraDataInvokeFunctionalPage.invokeTicket;
      s.checkNotNull(paramb);
      paramb = a.a.ahm(paramb);
      if (paramb != null) {
        paramb.overridePendingTransition(0, 0);
      }
      paramb = paramContext;
      if (paramContext == null) {
        paramb = MMApplicationContext.getContext();
      }
      paramContext = new MMessageActV2.Args();
      paramContext.targetPkgName = paramWechatNativeExtraDataInvokeFunctionalPage.packageName;
      paramContext.bundle = paramString;
      paramWechatNativeExtraDataInvokeFunctionalPage = ah.aiuX;
      MMessageActV2.send(paramb, paramContext);
      AppMethodBeat.o(320071);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.b
 * JD-Core Version:    0.7.0.1
 */