package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApiInterceptor;", "", "()V", "APIs", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "Lkotlin/collections/HashMap;", "TAG", "shouldIntercept", "", "context", "Landroid/content/Context;", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"})
public final class c
{
  private static final HashMap<String, b> lTF;
  public static final c lTG;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(223675);
    lTG = new c();
    HashMap localHashMap = new HashMap();
    b localb1 = (b)new e();
    b localb2 = (b)new f();
    b localb3 = (b)new g();
    while (i < 3)
    {
      b localb4 = new b[] { localb1, localb2, localb3 }[i];
      ((Map)localHashMap).put(localb4.btd(), localb4);
      i += 1;
    }
    lTF = localHashMap;
    AppMethodBeat.o(223675);
  }
  
  public static final boolean a(Context paramContext, WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, com.tencent.mm.plugin.appbrand.api.f paramf)
  {
    AppMethodBeat.i(223674);
    p.h(paramContext, "context");
    p.h(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    p.h(paramf, "appOpenBundle");
    paramContext = (b)((Map)lTF).get(paramWechatNativeExtraDataInvokeFunctionalPage.lTy);
    if (paramContext == null)
    {
      AppMethodBeat.o(223674);
      return false;
    }
    ae.i("MicroMsg.AppBrand.FunctionalDirectApiInterceptor", "intercept by directApi[" + paramContext.btd() + ']');
    paramContext.a(paramWechatNativeExtraDataInvokeFunctionalPage, paramf);
    AppMethodBeat.o(223674);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.c
 * JD-Core Version:    0.7.0.1
 */