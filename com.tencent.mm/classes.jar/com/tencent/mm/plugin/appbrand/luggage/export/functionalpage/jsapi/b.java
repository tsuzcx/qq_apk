package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import com.tencent.mm.plugin.appbrand.ac.a.a.a;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "", "NAME", "", "getNAME", "()Ljava/lang/String;", "backToApp", "", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "context", "Landroid/content/Context;", "retMsg", "invoke", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"})
public abstract interface b
{
  public abstract void a(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, Context paramContext);
  
  public abstract void a(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, f paramf);
  
  public abstract String btd();
  
  @l(gjZ={1, 1, 16})
  public static final class a
  {
    public static void b(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, Context paramContext)
    {
      AppMethodBeat.i(223672);
      p.h(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
      Bundle localBundle = new Bundle();
      Object localObject = new WXLaunchWxaRedirectingPage.Resp(Bundle.EMPTY);
      String str = paramWechatNativeExtraDataInvokeFunctionalPage.invokeTicket;
      if (str == null) {
        p.gkB();
      }
      ((WXLaunchWxaRedirectingPage.Resp)localObject).invokeTicket = str;
      ((WXLaunchWxaRedirectingPage.Resp)localObject).callbackActivity = paramWechatNativeExtraDataInvokeFunctionalPage.callbackActivity;
      ((WXLaunchWxaRedirectingPage.Resp)localObject).errStr = null;
      ((WXLaunchWxaRedirectingPage.Resp)localObject).toBundle(localBundle);
      q.bc(localBundle);
      q.bd(localBundle);
      localObject = a.a.nvx;
      localObject = paramWechatNativeExtraDataInvokeFunctionalPage.invokeTicket;
      if (localObject == null) {
        p.gkB();
      }
      localObject = a.a.Wt((String)localObject);
      if (localObject != null) {
        ((Activity)localObject).overridePendingTransition(0, 0);
      }
      localObject = paramContext;
      if (paramContext == null) {
        localObject = ak.getContext();
      }
      paramContext = new MMessageActV2.Args();
      paramContext.targetPkgName = paramWechatNativeExtraDataInvokeFunctionalPage.packageName;
      paramContext.bundle = localBundle;
      MMessageActV2.send((Context)localObject, paramContext);
      AppMethodBeat.o(223672);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.b
 * JD-Core Version:    0.7.0.1
 */