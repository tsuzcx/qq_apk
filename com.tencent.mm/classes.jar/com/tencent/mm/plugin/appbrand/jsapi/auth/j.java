package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bjd;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.a.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiLoginLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "invoke", "component", "cgiUrlStripForApiCallback", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class j
  extends h
  implements f
{
  public static final int CTRL_INDEX = 52;
  public static final String NAME = "login";
  @Deprecated
  public static final e jDW;
  
  static
  {
    AppMethodBeat.i(169600);
    jDW = new e((byte)0);
    AppMethodBeat.o(169600);
  }
  
  public static dvc b(dvc paramdvc, com.tencent.mm.plugin.appbrand.jsapi.h paramh)
  {
    AppMethodBeat.i(169602);
    d.g.b.k.h(paramdvc, "$this$fill");
    d.g.b.k.h(paramh, "service");
    paramdvc = f.c.a(paramdvc, paramh);
    AppMethodBeat.o(169602);
    return paramdvc;
  }
  
  public static <R extends cld> com.tencent.mm.vending.g.c<R> b(com.tencent.mm.plugin.appbrand.jsapi.h paramh, String paramString, com.tencent.mm.bx.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169601);
    d.g.b.k.h(paramh, "$this$runCgi");
    d.g.b.k.h(paramString, "url");
    d.g.b.k.h(parama, "request");
    d.g.b.k.h(paramClass, "clazz");
    paramh = f.c.a(paramh, paramString, parama, paramClass);
    AppMethodBeat.o(169601);
    return paramh;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(169597);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(169597);
      return;
    }
    try
    {
      if (!paramJSONObject.has("requestInQueue")) {
        paramJSONObject.put("requestInQueue", false);
      }
      super.a(paramh, paramJSONObject, paramInt);
      AppMethodBeat.o(169597);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ad.e("Luggage.WXA.JsApiLoginLU", "invoke put KEY_IN_QUEUE e=" + localJSONException.getMessage());
      }
    }
  }
  
  protected final void a(final com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, final int paramInt, final e parame)
  {
    AppMethodBeat.i(169599);
    if (paramh == null)
    {
      AppMethodBeat.o(169599);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(169599);
      return;
    }
    paramJSONObject = new bjc();
    paramJSONObject.hnC = paramh.getAppId();
    AppBrandRuntime localAppBrandRuntime = paramh.getRuntime();
    d.g.b.k.g(localAppBrandRuntime, "service.runtime");
    paramJSONObject.DGx = localAppBrandRuntime.aLI();
    paramJSONObject.DGy = b(new dvc(), paramh);
    b(paramh, "/cgi-bin/mmbiz-bin/js-login", (com.tencent.mm.bx.a)paramJSONObject, bjd.class).d((com.tencent.mm.vending.c.a)new a(this, paramh, paramInt)).f((com.tencent.mm.vending.c.a)new b(this, paramh, paramInt)).a((d.b)new c(parame)).a((d.a)new d(this, parame, paramh, paramInt));
    AppMethodBeat.o(169599);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSLoginResponse;", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(j paramj, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(j paramj, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "onTerminate"})
  static final class c<T>
    implements d.b<Object>
  {
    c(e parame) {}
    
    public final void br(Object paramObject)
    {
      AppMethodBeat.i(169595);
      paramObject = this.jDR;
      if (paramObject != null)
      {
        paramObject.aYh();
        AppMethodBeat.o(169595);
        return;
      }
      AppMethodBeat.o(169595);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class d<T>
    implements d.a<Object>
  {
    d(j paramj, e parame, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(169596);
      Object localObject = parame;
      if (localObject != null) {
        ((e)localObject).aYh();
      }
      j.aYp();
      StringBuilder localStringBuilder = new StringBuilder("onInterrupt, appId[").append(paramh.getAppId()).append("], callbackId[").append(paramInt).append("], e[");
      if (paramObject != null) {}
      for (localObject = paramObject.toString();; localObject = null)
      {
        ad.i("Luggage.WXA.JsApiLoginLU", (String)localObject + ']');
        if (!(paramObject instanceof f.b)) {
          break;
        }
        AppMethodBeat.o(169596);
        return;
      }
      if ((paramObject instanceof f.a))
      {
        paramh.h(paramInt, this.jDX.HI("fail " + ((f.a)paramObject).getMessage()));
        AppMethodBeat.o(169596);
        return;
      }
      if ((paramObject instanceof Throwable))
      {
        paramh.h(paramInt, this.jDX.HI("fail " + ((Throwable)paramObject).getMessage()));
        AppMethodBeat.o(169596);
        return;
      }
      if (paramObject == null)
      {
        paramh.h(paramInt, this.jDX.HI("fail:internal error"));
        AppMethodBeat.o(169596);
        return;
      }
      paramh.h(paramInt, this.jDX.HI("fail ".concat(String.valueOf(paramObject))));
      AppMethodBeat.o(169596);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiLoginLU$Companion;", "", "()V", "CONFIRM_URL", "", "CTRL_INDEX", "", "NAME", "QUERY_URL", "TAG", "luggage-wechat-full-sdk_release"})
  static final class e {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.j
 * JD-Core Version:    0.7.0.1
 */