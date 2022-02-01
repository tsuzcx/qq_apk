package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApiOpenAppProfile;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "()V", "NAME", "", "getNAME", "()Ljava/lang/String;", "invoke", "", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"})
public final class e
  implements b
{
  private final String NAME = "sdk_openAppProfile";
  
  public final void a(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, Context paramContext)
  {
    AppMethodBeat.i(228899);
    p.h(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    b.a.a(paramWechatNativeExtraDataInvokeFunctionalPage, paramContext, null);
    AppMethodBeat.o(228899);
  }
  
  public final void a(final WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, final g paramg)
  {
    AppMethodBeat.i(228898);
    p.h(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    p.h(paramg, "appOpenBundle");
    Object localObject;
    try
    {
      localObject = new JSONObject(paramWechatNativeExtraDataInvokeFunctionalPage.nbc);
      localObject = ((JSONObject)localObject).optString("username", null);
      if (localObject == null)
      {
        b.a.a(this, paramWechatNativeExtraDataInvokeFunctionalPage, null, 6);
        AppMethodBeat.o(228898);
        return;
      }
    }
    catch (JSONException paramg)
    {
      b.a.a(this, paramWechatNativeExtraDataInvokeFunctionalPage, null, 6);
      AppMethodBeat.o(228898);
      return;
    }
    d.b(null, (kotlin.g.a.b)new a(this, paramWechatNativeExtraDataInvokeFunctionalPage, (String)localObject, paramg));
    AppMethodBeat.o(228898);
  }
  
  public final String bOK()
  {
    return this.NAME;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/MMActivity;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<MMActivity, x>
  {
    a(e parame, WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, String paramString, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.e
 * JD-Core Version:    0.7.0.1
 */