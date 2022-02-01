package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApiOpenAppProfile;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "()V", "NAME", "", "getNAME", "()Ljava/lang/String;", "invoke", "", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements b
{
  private final String NAME = "sdk_openAppProfile";
  
  public final void a(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, Context paramContext)
  {
    AppMethodBeat.i(320136);
    b.a.a(this, paramWechatNativeExtraDataInvokeFunctionalPage, paramContext, null);
    AppMethodBeat.o(320136);
  }
  
  public final void a(final WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, final g paramg)
  {
    AppMethodBeat.i(320129);
    s.u(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    s.u(paramg, "appOpenBundle");
    Object localObject;
    try
    {
      localObject = new JSONObject(paramWechatNativeExtraDataInvokeFunctionalPage.tgs);
      localObject = ((JSONObject)localObject).optString("username", null);
      if (localObject == null)
      {
        b.a.a((b)this, paramWechatNativeExtraDataInvokeFunctionalPage, null, 6);
        AppMethodBeat.o(320129);
        return;
      }
    }
    catch (JSONException paramg)
    {
      b.a.a((b)this, paramWechatNativeExtraDataInvokeFunctionalPage, null, 6);
      AppMethodBeat.o(320129);
      return;
    }
    d.b(null, (kotlin.g.a.b)new a((String)localObject, paramg, this, paramWechatNativeExtraDataInvokeFunctionalPage));
    AppMethodBeat.o(320129);
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
    a(String paramString, g paramg, e parame, WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage)
    {
      super();
    }
    
    private static final void a(e parame, WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(320085);
      s.u(parame, "this$0");
      s.u(paramWechatNativeExtraDataInvokeFunctionalPage, "$invokeArgs");
      s.u(paramMMActivity, "$it");
      b.a.a((b)parame, paramWechatNativeExtraDataInvokeFunctionalPage, (Context)paramMMActivity, 4);
      paramMMActivity.finish();
      AppMethodBeat.o(320085);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.e
 * JD-Core Version:    0.7.0.1
 */