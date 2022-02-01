package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApiInterceptor;", "", "()V", "APIs", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "Lkotlin/collections/HashMap;", "TAG", "shouldIntercept", "", "context", "Landroid/content/Context;", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"})
public final class c
{
  private static final HashMap<String, b> qbA;
  public static final c qbB;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(268239);
    qbB = new c();
    HashMap localHashMap = new HashMap();
    b localb1 = (b)new e();
    b localb2 = (b)new f();
    b localb3 = (b)new g();
    while (i < 3)
    {
      b localb4 = new b[] { localb1, localb2, localb3 }[i];
      ((Map)localHashMap).put(localb4.cba(), localb4);
      i += 1;
    }
    qbA = localHashMap;
    AppMethodBeat.o(268239);
  }
  
  public static final boolean a(Context paramContext, WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(268236);
    p.k(paramContext, "context");
    p.k(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    p.k(paramg, "appOpenBundle");
    paramContext = (b)((Map)qbA).get(paramWechatNativeExtraDataInvokeFunctionalPage.qbq);
    if (paramContext == null)
    {
      AppMethodBeat.o(268236);
      return false;
    }
    Log.i("MicroMsg.AppBrand.FunctionalDirectApiInterceptor", "intercept by directApi[" + paramContext.cba() + ']');
    paramContext.a(paramWechatNativeExtraDataInvokeFunctionalPage, paramg);
    AppMethodBeat.o(268236);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.c
 * JD-Core Version:    0.7.0.1
 */