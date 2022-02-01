package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.a;
import com.tencent.mm.protocal.protobuf.cnk;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.protocal.protobuf.cnn;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d;
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

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiLoginLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "invoke", "component", "cgiUrlStripForApiCallback", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class n
  extends i
  implements f
{
  public static final int CTRL_INDEX = 52;
  public static final String NAME = "login";
  @Deprecated
  public static final n.e oCs;
  
  static
  {
    AppMethodBeat.i(169600);
    oCs = new n.e((byte)0);
    AppMethodBeat.o(169600);
  }
  
  public static foh b(foh paramfoh, com.tencent.mm.plugin.appbrand.jsapi.j paramj)
  {
    AppMethodBeat.i(169602);
    p.k(paramfoh, "$this$fill");
    p.k(paramj, "service");
    paramfoh = f.c.a(paramfoh, paramj);
    AppMethodBeat.o(169602);
    return paramfoh;
  }
  
  public static <R extends dyy> com.tencent.mm.vending.g.c<R> b(com.tencent.mm.plugin.appbrand.jsapi.j paramj, String paramString, com.tencent.mm.cd.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169601);
    p.k(paramj, "$this$runCgi");
    p.k(paramString, "url");
    p.k(parama, "request");
    p.k(paramClass, "clazz");
    paramj = f.c.a(paramj, paramString, parama, paramClass);
    AppMethodBeat.o(169601);
    return paramj;
  }
  
  public final void a(g paramg, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(237949);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(237949);
      return;
    }
    try
    {
      if (!paramJSONObject.has("requestInQueue")) {
        paramJSONObject.put("requestInQueue", false);
      }
      super.a(paramg, paramJSONObject, paramInt);
      AppMethodBeat.o(237949);
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
  
  protected final void a(final g paramg, JSONObject paramJSONObject, final int paramInt, final e parame)
  {
    AppMethodBeat.i(237950);
    if (paramg == null)
    {
      AppMethodBeat.o(237950);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(237950);
      return;
    }
    paramJSONObject = (com.tencent.mm.plugin.appbrand.jsapi.j)paramg;
    cnm localcnm = new cnm();
    localcnm.lVG = paramg.getAppId();
    AppBrandRuntime localAppBrandRuntime = paramg.getRuntime();
    p.j(localAppBrandRuntime, "service.runtime");
    localcnm.TuP = localAppBrandRuntime.bBV();
    localcnm.TuQ = b(new foh(), (com.tencent.mm.plugin.appbrand.jsapi.j)paramg);
    b(paramJSONObject, "/cgi-bin/mmbiz-bin/js-login", (com.tencent.mm.cd.a)localcnm, cnn.class).d((com.tencent.mm.vending.c.a)new a(this, paramg, paramInt)).f((com.tencent.mm.vending.c.a)new b(this, paramg, paramInt)).a((d.b)new c(parame)).a((d.a)new d(this, parame, paramg, paramInt));
    AppMethodBeat.o(237950);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSLoginResponse;", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(n paramn, g paramg, int paramInt) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(n paramn, g paramg, int paramInt) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onTerminate"})
  static final class c<T>
    implements d.b<Object>
  {
    c(e parame) {}
    
    public final void bz(Object paramObject)
    {
      AppMethodBeat.i(169595);
      paramObject = this.oCh;
      if (paramObject != null)
      {
        paramObject.bQe();
        AppMethodBeat.o(169595);
        return;
      }
      AppMethodBeat.o(169595);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class d<T>
    implements d.a<Object>
  {
    d(n paramn, e parame, g paramg, int paramInt) {}
    
    public final void cm(Object paramObject)
    {
      AppMethodBeat.i(169596);
      Object localObject = parame;
      if (localObject != null) {
        ((e)localObject).bQe();
      }
      n.bQn();
      StringBuilder localStringBuilder = new StringBuilder("onInterrupt, appId[").append(paramg.getAppId()).append("], callbackId[").append(paramInt).append("], e[");
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
        paramg.j(paramInt, this.oCt.agS("fail " + ((f.a)paramObject).getMessage()));
        AppMethodBeat.o(169596);
        return;
      }
      if ((paramObject instanceof Throwable))
      {
        paramg.j(paramInt, this.oCt.agS("fail " + ((Throwable)paramObject).getMessage()));
        AppMethodBeat.o(169596);
        return;
      }
      if (paramObject == null)
      {
        paramg.j(paramInt, this.oCt.agS("fail:internal error"));
        AppMethodBeat.o(169596);
        return;
      }
      paramg.j(paramInt, this.oCt.agS("fail ".concat(String.valueOf(paramObject))));
      AppMethodBeat.o(169596);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.n
 * JD-Core Version:    0.7.0.1
 */