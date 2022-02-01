package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.luggage.sdk.g.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.permission.a.b.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.g.b;
import com.tencent.mm.protocal.protobuf.cno;
import com.tencent.mm.protocal.protobuf.cnp;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.protocal.protobuf.eyy;
import com.tencent.mm.protocal.protobuf.eyz;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "Companion", "luggage-wechat-full-sdk_release"})
public final class o
  extends i
  implements f
{
  public static final int CTRL_INDEX = 79;
  public static final String NAME = "operateWXData";
  @Deprecated
  public static final o.g oDa;
  
  static
  {
    AppMethodBeat.i(169619);
    oDa = new o.g((byte)0);
    AppMethodBeat.o(169619);
  }
  
  public static com.tencent.mm.cd.b ahe(String paramString)
  {
    AppMethodBeat.i(169620);
    p.k(paramString, "$this$toByteString");
    p.k(paramString, "$this$toByteString");
    paramString = paramString.getBytes(kotlin.n.d.UTF_8);
    p.j(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = new com.tencent.mm.cd.b(paramString);
    AppMethodBeat.o(169620);
    return paramString;
  }
  
  public static foh b(foh paramfoh, com.tencent.mm.plugin.appbrand.jsapi.j paramj)
  {
    AppMethodBeat.i(169624);
    p.k(paramfoh, "$this$fill");
    p.k(paramj, "service");
    paramfoh = f.c.a(paramfoh, paramj);
    AppMethodBeat.o(169624);
    return paramfoh;
  }
  
  public static <R extends dyy> com.tencent.mm.vending.g.c<R> b(com.tencent.mm.plugin.appbrand.jsapi.j paramj, String paramString, com.tencent.mm.cd.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169622);
    p.k(paramj, "$this$runCgi");
    p.k(paramString, "url");
    p.k(parama, "request");
    p.k(paramClass, "clazz");
    paramj = f.c.a(paramj, paramString, parama, paramClass);
    AppMethodBeat.o(169622);
    return paramj;
  }
  
  public static void b(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.permission.a.b paramb)
  {
    AppMethodBeat.i(235477);
    p.k(paramContext, "context");
    p.k(paramb, "dialog");
    f.c.a(paramContext, paramBitmap, paramString1, paramString2, paramb);
    AppMethodBeat.o(235477);
  }
  
  public static Context c(com.tencent.mm.plugin.appbrand.jsapi.j paramj)
  {
    AppMethodBeat.i(169621);
    p.k(paramj, "$this$notNullContext");
    paramj = f.c.a(paramj);
    AppMethodBeat.o(169621);
    return paramj;
  }
  
  protected final void a(final com.tencent.mm.plugin.appbrand.g paramg, final JSONObject paramJSONObject, final int paramInt, final e parame)
  {
    AppMethodBeat.i(235463);
    if (paramg == null)
    {
      AppMethodBeat.o(235463);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(235463);
      return;
    }
    paramJSONObject = paramJSONObject.optString("data", null);
    if (paramJSONObject == null)
    {
      ((kotlin.g.a.a)new a(this, paramg, paramInt)).invoke();
      AppMethodBeat.o(235463);
      return;
    }
    paramJSONObject = new b(this, paramg, paramJSONObject);
    b((com.tencent.mm.plugin.appbrand.jsapi.j)paramg, "/cgi-bin/mmbiz-bin/js-operatewxdata", (com.tencent.mm.cd.a)paramJSONObject.bQs(), cnp.class).d((com.tencent.mm.vending.c.a)new c(this, paramg, paramInt, paramJSONObject)).f((com.tencent.mm.vending.c.a)new d(this, paramg, paramInt)).a((d.b)new e(parame)).a((com.tencent.mm.vending.h.d)com.tencent.mm.vending.h.d.UI, (d.a)new f(this, parame, paramg, paramInt));
    AppMethodBeat.o(235463);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(o paramo, com.tencent.mm.plugin.appbrand.g paramg, int paramInt)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"createRequest", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataRequest;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<cno>
  {
    b(o paramo, com.tencent.mm.plugin.appbrand.g paramg, String paramString)
    {
      super();
    }
    
    public final cno bQs()
    {
      AppMethodBeat.i(169606);
      cno localcno = new cno();
      localcno.lVG = paramg.getAppId();
      localcno.rVk = o.ahe(paramJSONObject);
      AppBrandRuntime localAppBrandRuntime = paramg.getRuntime();
      p.j(localAppBrandRuntime, "service.runtime");
      localcno.TuP = localAppBrandRuntime.bBV();
      localcno.TuQ = o.b(new foh(), (com.tencent.mm.plugin.appbrand.jsapi.j)paramg);
      AppMethodBeat.o(169606);
      return localcno;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "response", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(o paramo, com.tencent.mm.plugin.appbrand.g paramg, int paramInt, o.b paramb) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(o paramo, com.tencent.mm.plugin.appbrand.g paramg, int paramInt) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onTerminate"})
  static final class e<T>
    implements d.b<Object>
  {
    e(e parame) {}
    
    public final void bz(Object paramObject)
    {
      AppMethodBeat.i(169616);
      paramObject = this.oCh;
      if (paramObject != null)
      {
        paramObject.bQe();
        AppMethodBeat.o(169616);
        return;
      }
      AppMethodBeat.o(169616);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class f<T>
    implements d.a<Object>
  {
    f(o paramo, e parame, com.tencent.mm.plugin.appbrand.g paramg, int paramInt) {}
    
    public final void cm(Object paramObject)
    {
      AppMethodBeat.i(169617);
      Object localObject = parame;
      if (localObject != null) {
        ((e)localObject).bQe();
      }
      o.bQr();
      StringBuilder localStringBuilder = new StringBuilder("onInterrupt, appId[").append(paramg.getAppId()).append("], callbackId[").append(paramInt).append("], e[");
      if (paramObject != null) {}
      for (localObject = paramObject.toString();; localObject = null)
      {
        Log.i("Luggage.WXA.JsApiOperateWXDataLU", (String)localObject + ']');
        if (!(paramObject instanceof f.b)) {
          break;
        }
        AppMethodBeat.o(169617);
        return;
      }
      if ((paramObject instanceof f.a))
      {
        paramg.j(paramInt, this.oDb.agS("fail " + ((f.a)paramObject).getMessage()));
        AppMethodBeat.o(169617);
        return;
      }
      if ((paramObject instanceof Throwable))
      {
        paramg.j(paramInt, this.oDb.agS("fail " + ((Throwable)paramObject).getMessage()));
        AppMethodBeat.o(169617);
        return;
      }
      if (paramObject == null)
      {
        paramg.j(paramInt, this.oDb.agS("fail:internal error"));
        AppMethodBeat.o(169617);
        return;
      }
      paramg.j(paramInt, this.oDb.agS("fail ".concat(String.valueOf(paramObject))));
      AppMethodBeat.o(169617);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.o
 * JD-Core Version:    0.7.0.1
 */