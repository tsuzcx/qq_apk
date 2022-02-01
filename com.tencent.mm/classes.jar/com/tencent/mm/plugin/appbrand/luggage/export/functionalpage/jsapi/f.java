package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.xwebutil.c;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApiOpenFeedback;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "()V", "NAME", "", "getNAME", "()Ljava/lang/String;", "invoke", "", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"})
public final class f
  implements b
{
  private final String NAME = "sdk_openFeedback";
  
  public final void a(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, Context paramContext)
  {
    AppMethodBeat.i(254990);
    p.k(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    b.a.a(paramWechatNativeExtraDataInvokeFunctionalPage, paramContext, null);
    AppMethodBeat.o(254990);
  }
  
  public final void a(final WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, g paramg)
  {
    AppMethodBeat.i(254987);
    p.k(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    p.k(paramg, "appOpenBundle");
    String str1;
    try
    {
      paramg = new JSONObject(paramWechatNativeExtraDataInvokeFunctionalPage.qbr);
      c.bCF("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
      str1 = paramg.optString("appId", null);
      if (str1 == null)
      {
        b.a.a(this, paramWechatNativeExtraDataInvokeFunctionalPage, null, 6);
        AppMethodBeat.o(254987);
        return;
      }
    }
    catch (JSONException paramg)
    {
      b.a.a(this, paramWechatNativeExtraDataInvokeFunctionalPage, null, 6);
      AppMethodBeat.o(254987);
      return;
    }
    String str2 = paramg.optString("pageId");
    int i = paramg.optInt("appVersion", 0);
    int j = paramg.optInt("versionType", 0);
    d.b(null, (kotlin.g.a.b)new a(this, paramWechatNativeExtraDataInvokeFunctionalPage, new WxaExposedParams.a().afz(str1).afD(str2).zs(i).zt(j).zu(16).bLN()));
    AppMethodBeat.o(254987);
  }
  
  public final String cba()
  {
    return this.NAME;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/MMActivity;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<MMActivity, x>
  {
    a(f paramf, WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, WxaExposedParams paramWxaExposedParams)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.f
 * JD-Core Version:    0.7.0.1
 */