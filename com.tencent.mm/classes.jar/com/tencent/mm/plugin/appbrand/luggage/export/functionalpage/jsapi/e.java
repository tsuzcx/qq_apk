package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import org.json.JSONException;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApiOpenAppProfile;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "()V", "NAME", "", "getNAME", "()Ljava/lang/String;", "invoke", "", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"})
public final class e
  implements b
{
  private final String NAME = "sdk_openAppProfile";
  
  public final void a(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, Context paramContext)
  {
    AppMethodBeat.i(189420);
    p.h(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    b.a.b(paramWechatNativeExtraDataInvokeFunctionalPage, paramContext);
    AppMethodBeat.o(189420);
  }
  
  public final void a(final WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, final f paramf)
  {
    AppMethodBeat.i(189419);
    p.h(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    p.h(paramf, "appOpenBundle");
    Object localObject;
    try
    {
      localObject = new JSONObject(paramWechatNativeExtraDataInvokeFunctionalPage.lOY);
      localObject = ((JSONObject)localObject).optString("username", null);
      if (localObject == null)
      {
        b.a.a(this, paramWechatNativeExtraDataInvokeFunctionalPage, null, 6);
        AppMethodBeat.o(189419);
        return;
      }
    }
    catch (JSONException paramf)
    {
      b.a.a(this, paramWechatNativeExtraDataInvokeFunctionalPage, null, 6);
      AppMethodBeat.o(189419);
      return;
    }
    d.b(null, (d.g.a.b)new a(this, paramWechatNativeExtraDataInvokeFunctionalPage, (String)localObject, paramf));
    AppMethodBeat.o(189419);
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
    a(e parame, WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, String paramString, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.e
 * JD-Core Version:    0.7.0.1
 */