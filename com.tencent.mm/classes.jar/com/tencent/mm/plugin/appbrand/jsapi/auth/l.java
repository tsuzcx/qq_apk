package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.a.v;
import d.g.b.p;
import d.g.b.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiLoginLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "invoke", "component", "cgiUrlStripForApiCallback", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class l
  extends i
  implements f
{
  public static final int CTRL_INDEX = 52;
  public static final String NAME = "login";
  @Deprecated
  public static final l.e kzc;
  
  static
  {
    AppMethodBeat.i(169600);
    kzc = new l.e((byte)0);
    AppMethodBeat.o(169600);
  }
  
  public static egx b(egx paramegx, h paramh)
  {
    AppMethodBeat.i(169602);
    p.h(paramegx, "$this$fill");
    p.h(paramh, "service");
    paramegx = f.c.a(paramegx, paramh);
    AppMethodBeat.o(169602);
    return paramegx;
  }
  
  public static <R extends cvp> com.tencent.mm.vending.g.c<R> b(h paramh, String paramString, com.tencent.mm.bx.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169601);
    p.h(paramh, "$this$runCgi");
    p.h(paramString, "url");
    p.h(parama, "request");
    p.h(paramClass, "clazz");
    paramh = f.c.a(paramh, paramString, parama, paramClass);
    AppMethodBeat.o(169601);
    return paramh;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(192349);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(192349);
      return;
    }
    try
    {
      if (!paramJSONObject.has("requestInQueue")) {
        paramJSONObject.put("requestInQueue", false);
      }
      super.a(paramd, paramJSONObject, paramInt);
      AppMethodBeat.o(192349);
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
  
  protected final void a(final com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, final int paramInt, final e parame)
  {
    AppMethodBeat.i(192350);
    if (paramd == null)
    {
      AppMethodBeat.o(192350);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(192350);
      return;
    }
    paramJSONObject = (h)paramd;
    bre localbre = new bre();
    localbre.iht = paramd.getAppId();
    AppBrandRuntime localAppBrandRuntime = paramd.getRuntime();
    p.g(localAppBrandRuntime, "service.runtime");
    localbre.GLq = localAppBrandRuntime.aVL();
    localbre.GLr = b(new egx(), (h)paramd);
    b(paramJSONObject, "/cgi-bin/mmbiz-bin/js-login", (com.tencent.mm.bx.a)localbre, brf.class).d((com.tencent.mm.vending.c.a)new a(this, paramd, paramInt)).f((com.tencent.mm.vending.c.a)new b(this, paramd, paramInt)).a((d.b)new c(parame)).a((d.a)new d(this, parame, paramd, paramInt));
    AppMethodBeat.o(192350);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSLoginResponse;", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(l paraml, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(l paraml, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "onTerminate"})
  static final class c<T>
    implements d.b<Object>
  {
    c(e parame) {}
    
    public final void bq(Object paramObject)
    {
      AppMethodBeat.i(169595);
      paramObject = this.kyW;
      if (paramObject != null)
      {
        paramObject.biH();
        AppMethodBeat.o(169595);
        return;
      }
      AppMethodBeat.o(169595);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class d<T>
    implements d.a<Object>
  {
    d(l paraml, e parame, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(169596);
      Object localObject = parame;
      if (localObject != null) {
        ((e)localObject).biH();
      }
      l.biP();
      StringBuilder localStringBuilder = new StringBuilder("onInterrupt, appId[").append(paramd.getAppId()).append("], callbackId[").append(paramInt).append("], e[");
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
        paramd.h(paramInt, this.kzd.Pg("fail " + ((f.a)paramObject).getMessage()));
        AppMethodBeat.o(169596);
        return;
      }
      if ((paramObject instanceof Throwable))
      {
        paramd.h(paramInt, this.kzd.Pg("fail " + ((Throwable)paramObject).getMessage()));
        AppMethodBeat.o(169596);
        return;
      }
      if (paramObject == null)
      {
        paramd.h(paramInt, this.kzd.Pg("fail:internal error"));
        AppMethodBeat.o(169596);
        return;
      }
      paramd.h(paramInt, this.kzd.Pg("fail ".concat(String.valueOf(paramObject))));
      AppMethodBeat.o(169596);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.l
 * JD-Core Version:    0.7.0.1
 */