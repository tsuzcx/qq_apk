package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import org.json.JSONException;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApiOpenFeedback;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "()V", "NAME", "", "getNAME", "()Ljava/lang/String;", "invoke", "", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"})
public final class f
  implements b
{
  private final String NAME = "sdk_openFeedback";
  
  public final void a(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, Context paramContext)
  {
    AppMethodBeat.i(189424);
    p.h(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    b.a.b(paramWechatNativeExtraDataInvokeFunctionalPage, paramContext);
    AppMethodBeat.o(189424);
  }
  
  public final void a(final WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, com.tencent.mm.plugin.appbrand.api.f paramf)
  {
    AppMethodBeat.i(189423);
    p.h(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    p.h(paramf, "appOpenBundle");
    String str1;
    try
    {
      paramf = new JSONObject(paramWechatNativeExtraDataInvokeFunctionalPage.lOY);
      com.tencent.mm.cq.d.aYW("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
      str1 = paramf.optString("appId", null);
      if (str1 == null)
      {
        b.a.a(this, paramWechatNativeExtraDataInvokeFunctionalPage, null, 6);
        AppMethodBeat.o(189423);
        return;
      }
    }
    catch (JSONException paramf)
    {
      b.a.a(this, paramWechatNativeExtraDataInvokeFunctionalPage, null, 6);
      AppMethodBeat.o(189423);
      return;
    }
    String str2 = paramf.optString("pageId");
    int i = paramf.optInt("appVersion", 0);
    int j = paramf.optInt("versionType", 0);
    d.b(null, (d.g.a.b)new a(this, paramWechatNativeExtraDataInvokeFunctionalPage, new WxaExposedParams.a().NV(str1).NZ(str2).sg(i).sh(j).bet()));
    AppMethodBeat.o(189423);
  }
  
  public final String bss()
  {
    return this.NAME;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/MMActivity;", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<MMActivity, z>
  {
    a(f paramf, WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, WxaExposedParams paramWxaExposedParams)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.f
 * JD-Core Version:    0.7.0.1
 */