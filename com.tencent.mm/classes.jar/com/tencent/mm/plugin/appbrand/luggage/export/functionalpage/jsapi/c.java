package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApiInterceptor;", "", "()V", "APIs", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "Lkotlin/collections/HashMap;", "TAG", "shouldIntercept", "", "context", "Landroid/content/Context;", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c tgA;
  private static final HashMap<String, b> tgB;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(320133);
    tgA = new c();
    HashMap localHashMap = new HashMap();
    b localb1 = (b)new e();
    b localb2 = (b)new f();
    b localb3 = (b)new g();
    while (i < 3)
    {
      b localb4 = new b[] { localb1, localb2, localb3 }[i];
      ((Map)localHashMap).put(localb4.cBt(), localb4);
      i += 1;
    }
    tgB = localHashMap;
    AppMethodBeat.o(320133);
  }
  
  public static final boolean a(Context paramContext, WechatNativeExtraDataInvokeFunctionalPage paramWechatNativeExtraDataInvokeFunctionalPage, com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(320126);
    s.u(paramContext, "context");
    s.u(paramWechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
    s.u(paramg, "appOpenBundle");
    paramContext = (b)((Map)tgB).get(paramWechatNativeExtraDataInvokeFunctionalPage.efV);
    if (paramContext == null)
    {
      AppMethodBeat.o(320126);
      return false;
    }
    Log.i("MicroMsg.AppBrand.FunctionalDirectApiInterceptor", "intercept by directApi[" + paramContext.cBt() + ']');
    paramContext.a(paramWechatNativeExtraDataInvokeFunctionalPage, paramg);
    AppMethodBeat.o(320126);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.c
 * JD-Core Version:    0.7.0.1
 */