package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApiInterceptor;", "", "()V", "APIs", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "Lkotlin/collections/HashMap;", "TAG", "shouldIntercept", "", "context", "Landroid/content/Context;", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"})
public final class c
{
  private static final HashMap<String, b> lPe;
  public static final c lPf;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(189415);
    lPf = new c();
    HashMap localHashMap = new HashMap();
    b localb1 = (b)new e();
    b localb2 = (b)new f();
    b localb3 = (b)new g();
    while (i < 3)
    {
      b localb4 = new b[] { localb1, localb2, localb3 }[i];
      ((Map)localHashMap).put(localb4.bss(), localb4);
      i += 1;
    }
    lPe = localHashMap;
    AppMethodBeat.o(189415);
  }
  
  public static final boolean a(Context paramContext, WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, com.tencent.mm.plugin.appbrand.api.f paramf)
  {
    AppMethodBeat.i(189414);
    p.h(paramContext, "context");
    p.h(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    p.h(paramf, "appOpenBundle");
    paramContext = (b)((Map)lPe).get(paramWechatNativeExtraDataInvokeFunctionalPage.lOX);
    if (paramContext == null)
    {
      AppMethodBeat.o(189414);
      return false;
    }
    ad.i("MicroMsg.AppBrand.FunctionalDirectApiInterceptor", "intercept by directApi[" + paramContext.bss() + ']');
    paramContext.a(paramWechatNativeExtraDataInvokeFunctionalPage, paramf);
    AppMethodBeat.o(189414);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.c
 * JD-Core Version:    0.7.0.1
 */