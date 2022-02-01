package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.xwebutil.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApiOpenFeedback;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "()V", "NAME", "", "getNAME", "()Ljava/lang/String;", "invoke", "", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements b
{
  private final String NAME = "sdk_openFeedback";
  
  public final void a(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, Context paramContext)
  {
    AppMethodBeat.i(320135);
    b.a.a(this, paramWechatNativeExtraDataInvokeFunctionalPage, paramContext, null);
    AppMethodBeat.o(320135);
  }
  
  public final void a(final WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, g paramg)
  {
    AppMethodBeat.i(320128);
    s.u(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    s.u(paramg, "appOpenBundle");
    try
    {
      localObject = new JSONObject(paramWechatNativeExtraDataInvokeFunctionalPage.tgs);
      c.jQG();
      paramg = ((JSONObject)localObject).optString("appId", null);
      if (paramg == null)
      {
        b.a.a((b)this, paramWechatNativeExtraDataInvokeFunctionalPage, null, 6);
        AppMethodBeat.o(320128);
        return;
      }
    }
    catch (JSONException paramg)
    {
      b.a.a((b)this, paramWechatNativeExtraDataInvokeFunctionalPage, null, 6);
      AppMethodBeat.o(320128);
      return;
    }
    String str = ((JSONObject)localObject).optString("pageId");
    int i = ((JSONObject)localObject).optInt("appVersion", 0);
    int j = ((JSONObject)localObject).optInt("versionType", 0);
    Object localObject = new WxaExposedParams.a();
    ((WxaExposedParams.a)localObject).appId = paramg;
    ((WxaExposedParams.a)localObject).hUf = str;
    ((WxaExposedParams.a)localObject).pkgVersion = i;
    ((WxaExposedParams.a)localObject).qHO = j;
    ((WxaExposedParams.a)localObject).from = 16;
    d.b(null, (kotlin.g.a.b)new a(this, paramWechatNativeExtraDataInvokeFunctionalPage, ((WxaExposedParams.a)localObject).cll()));
    AppMethodBeat.o(320128);
  }
  
  public final String cBt()
  {
    return this.NAME;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/MMActivity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<MMActivity, ah>
  {
    a(f paramf, WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, WxaExposedParams paramWxaExposedParams)
    {
      super();
    }
    
    private static final void a(f paramf, WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(320065);
      s.u(paramf, "this$0");
      s.u(paramWechatNativeExtraDataInvokeFunctionalPage, "$invokeArgs");
      s.u(paramMMActivity, "$it");
      b.a.a((b)paramf, paramWechatNativeExtraDataInvokeFunctionalPage, (Context)paramMMActivity, 4);
      paramMMActivity.finish();
      AppMethodBeat.o(320065);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.f
 * JD-Core Version:    0.7.0.1
 */