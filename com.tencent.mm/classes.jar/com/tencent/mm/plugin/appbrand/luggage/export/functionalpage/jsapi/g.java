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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApiOpenGrowthCare;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "()V", "NAME", "", "getNAME", "()Ljava/lang/String;", "invoke", "", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"})
public final class g
  implements b
{
  private final String NAME = "sdk_openGrowthCare";
  
  public final void a(WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, Context paramContext)
  {
    AppMethodBeat.i(223688);
    p.h(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    b.a.b(paramWechatNativeExtraDataInvokeFunctionalPage, paramContext);
    AppMethodBeat.o(223688);
  }
  
  public final void a(final WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, f paramf)
  {
    AppMethodBeat.i(223687);
    p.h(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    p.h(paramf, "appOpenBundle");
    com.tencent.mm.cp.d.baz("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
    d.b(null, (d.g.a.b)new a(this, paramWechatNativeExtraDataInvokeFunctionalPage, "https://jiazhang.qq.com/wap/family/dist/main/index.html?_wv=1&source=h5_wx_sdk#/Index"));
    AppMethodBeat.o(223687);
  }
  
  public final String btd()
  {
    return this.NAME;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/MMActivity;", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<MMActivity, z>
  {
    a(g paramg, WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.g
 * JD-Core Version:    0.7.0.1
 */