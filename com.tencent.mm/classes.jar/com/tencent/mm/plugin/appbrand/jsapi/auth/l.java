package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import org.json.JSONException;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiLoginLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "invoke", "component", "cgiUrlStripForApiCallback", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class l
  extends i
  implements f
{
  public static final int CTRL_INDEX = 52;
  public static final String NAME = "login";
  @Deprecated
  public static final l.e lGK;
  
  static
  {
    AppMethodBeat.i(169600);
    lGK = new l.e((byte)0);
    AppMethodBeat.o(169600);
  }
  
  public static fdg b(fdg paramfdg, com.tencent.mm.plugin.appbrand.jsapi.k paramk)
  {
    AppMethodBeat.i(169602);
    p.h(paramfdg, "$this$fill");
    p.h(paramk, "service");
    paramfdg = f.c.a(paramfdg, paramk);
    AppMethodBeat.o(169602);
    return paramfdg;
  }
  
  public static <R extends dpc> com.tencent.mm.vending.g.c<R> b(com.tencent.mm.plugin.appbrand.jsapi.k paramk, String paramString, com.tencent.mm.bw.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169601);
    p.h(paramk, "$this$runCgi");
    p.h(paramString, "url");
    p.h(parama, "request");
    p.h(paramClass, "clazz");
    paramk = f.c.a(paramk, paramString, parama, paramClass);
    AppMethodBeat.o(169601);
    return paramk;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(230073);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(230073);
      return;
    }
    try
    {
      if (!paramJSONObject.has("requestInQueue")) {
        paramJSONObject.put("requestInQueue", false);
      }
      super.a(paramd, paramJSONObject, paramInt);
      AppMethodBeat.o(230073);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("Luggage.WXA.JsApiLoginLU", "invoke put KEY_IN_QUEUE e=" + localJSONException.getMessage());
      }
    }
  }
  
  protected final void a(final com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, final int paramInt, final e parame)
  {
    AppMethodBeat.i(230074);
    if (paramd == null)
    {
      AppMethodBeat.o(230074);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(230074);
      return;
    }
    paramJSONObject = (com.tencent.mm.plugin.appbrand.jsapi.k)paramd;
    ces localces = new ces();
    localces.jfi = paramd.getAppId();
    AppBrandRuntime localAppBrandRuntime = paramd.getRuntime();
    p.g(localAppBrandRuntime, "service.runtime");
    localces.MjZ = localAppBrandRuntime.brf();
    localces.Mka = b(new fdg(), (com.tencent.mm.plugin.appbrand.jsapi.k)paramd);
    b(paramJSONObject, "/cgi-bin/mmbiz-bin/js-login", (com.tencent.mm.bw.a)localces, cet.class).d((com.tencent.mm.vending.c.a)new a(this, paramd, paramInt)).f((com.tencent.mm.vending.c.a)new b(this, paramd, paramInt)).a((d.b)new c(parame)).a((d.a)new d(this, parame, paramd, paramInt));
    AppMethodBeat.o(230074);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSLoginResponse;", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(l paraml, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(l paraml, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onTerminate"})
  static final class c<T>
    implements d.b<Object>
  {
    c(e parame) {}
    
    public final void bz(Object paramObject)
    {
      AppMethodBeat.i(169595);
      paramObject = this.lGE;
      if (paramObject != null)
      {
        paramObject.bEE();
        AppMethodBeat.o(169595);
        return;
      }
      AppMethodBeat.o(169595);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class d<T>
    implements d.a<Object>
  {
    d(l paraml, e parame, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
    
    public final void cn(Object paramObject)
    {
      AppMethodBeat.i(169596);
      Object localObject = parame;
      if (localObject != null) {
        ((e)localObject).bEE();
      }
      l.bEM();
      StringBuilder localStringBuilder = new StringBuilder("onInterrupt, appId[").append(paramd.getAppId()).append("], callbackId[").append(paramInt).append("], e[");
      if (paramObject != null) {}
      for (localObject = paramObject.toString();; localObject = null)
      {
        Log.i("Luggage.WXA.JsApiLoginLU", (String)localObject + ']');
        if (!(paramObject instanceof f.b)) {
          break;
        }
        AppMethodBeat.o(169596);
        return;
      }
      if ((paramObject instanceof f.a))
      {
        paramd.i(paramInt, this.lGL.Zf("fail " + ((f.a)paramObject).getMessage()));
        AppMethodBeat.o(169596);
        return;
      }
      if ((paramObject instanceof Throwable))
      {
        paramd.i(paramInt, this.lGL.Zf("fail " + ((Throwable)paramObject).getMessage()));
        AppMethodBeat.o(169596);
        return;
      }
      if (paramObject == null)
      {
        paramd.i(paramInt, this.lGL.Zf("fail:internal error"));
        AppMethodBeat.o(169596);
        return;
      }
      paramd.i(paramInt, this.lGL.Zf("fail ".concat(String.valueOf(paramObject))));
      AppMethodBeat.o(169596);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.l
 * JD-Core Version:    0.7.0.1
 */