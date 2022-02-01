package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.luggage.sdk.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.protocal.protobuf.doe;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.a.j;
import d.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "Companion", "luggage-wechat-full-sdk_release"})
public final class k
  extends h
  implements f
{
  public static final int CTRL_INDEX = 79;
  public static final String NAME = "operateWXData";
  @Deprecated
  public static final g keS;
  
  static
  {
    AppMethodBeat.i(169619);
    keS = new g((byte)0);
    AppMethodBeat.o(169619);
  }
  
  public static com.tencent.mm.bw.b LT(String paramString)
  {
    AppMethodBeat.i(169620);
    d.g.b.k.h(paramString, "$this$toByteString");
    d.g.b.k.h(paramString, "$this$toByteString");
    paramString = paramString.getBytes(d.n.d.UTF_8);
    d.g.b.k.g(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = new com.tencent.mm.bw.b(paramString);
    AppMethodBeat.o(169620);
    return paramString;
  }
  
  public static eat b(eat parameat, com.tencent.mm.plugin.appbrand.jsapi.h paramh)
  {
    AppMethodBeat.i(169624);
    d.g.b.k.h(parameat, "$this$fill");
    d.g.b.k.h(paramh, "service");
    parameat = f.c.a(parameat, paramh);
    AppMethodBeat.o(169624);
    return parameat;
  }
  
  public static <R extends cqk> com.tencent.mm.vending.g.c<R> b(com.tencent.mm.plugin.appbrand.jsapi.h paramh, String paramString, com.tencent.mm.bw.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169622);
    d.g.b.k.h(paramh, "$this$runCgi");
    d.g.b.k.h(paramString, "url");
    d.g.b.k.h(parama, "request");
    d.g.b.k.h(paramClass, "clazz");
    paramh = f.c.a(paramh, paramString, parama, paramClass);
    AppMethodBeat.o(169622);
    return paramh;
  }
  
  public static void b(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, i parami)
  {
    AppMethodBeat.i(169623);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(parami, "dialog");
    f.c.a(paramContext, paramBitmap, paramString1, paramString2, parami);
    AppMethodBeat.o(169623);
  }
  
  public static Context d(com.tencent.mm.plugin.appbrand.jsapi.h paramh)
  {
    AppMethodBeat.i(169621);
    d.g.b.k.h(paramh, "$this$notNullContext");
    paramh = f.c.a(paramh);
    AppMethodBeat.o(169621);
    return paramh;
  }
  
  protected final void a(final com.tencent.mm.plugin.appbrand.jsapi.h paramh, final JSONObject paramJSONObject, final int paramInt, final e parame)
  {
    AppMethodBeat.i(169618);
    if (paramh == null)
    {
      AppMethodBeat.o(169618);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(169618);
      return;
    }
    paramJSONObject = paramJSONObject.optString("data", null);
    if (paramJSONObject == null)
    {
      ((d.g.a.a)new a(this, paramh, paramInt)).invoke();
      AppMethodBeat.o(169618);
      return;
    }
    paramJSONObject = new b(this, paramh, paramJSONObject);
    b(paramh, "/cgi-bin/mmbiz-bin/js-operatewxdata", (com.tencent.mm.bw.a)paramJSONObject.bfq(), bmx.class).d((com.tencent.mm.vending.c.a)new c(this, paramh, paramInt, paramJSONObject)).f((com.tencent.mm.vending.c.a)new d(this, paramh, paramInt)).a((d.b)new e(parame)).a((com.tencent.mm.vending.h.d)com.tencent.mm.vending.h.d.Jrg, (d.a)new f(this, parame, paramh, paramInt));
    AppMethodBeat.o(169618);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(k paramk, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"createRequest", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataRequest;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<bmw>
  {
    b(k paramk, com.tencent.mm.plugin.appbrand.jsapi.h paramh, String paramString)
    {
      super();
    }
    
    public final bmw bfq()
    {
      AppMethodBeat.i(169606);
      bmw localbmw = new bmw();
      localbmw.hOf = paramh.getAppId();
      localbmw.ncy = k.LT(paramJSONObject);
      AppBrandRuntime localAppBrandRuntime = paramh.getRuntime();
      d.g.b.k.g(localAppBrandRuntime, "service.runtime");
      localbmw.FbR = localAppBrandRuntime.aSy();
      localbmw.FbS = k.b(new eat(), paramh);
      AppMethodBeat.o(169606);
      return localbmw;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "response", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(k paramk, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt, k.b paramb) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(k paramk, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "onTerminate"})
  static final class e<T>
    implements d.b<Object>
  {
    e(e parame) {}
    
    public final void bo(Object paramObject)
    {
      AppMethodBeat.i(169616);
      paramObject = this.ken;
      if (paramObject != null)
      {
        paramObject.bfe();
        AppMethodBeat.o(169616);
        return;
      }
      AppMethodBeat.o(169616);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class f<T>
    implements d.a<Object>
  {
    f(k paramk, e parame, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt) {}
    
    public final void cc(Object paramObject)
    {
      AppMethodBeat.i(169617);
      Object localObject = parame;
      if (localObject != null) {
        ((e)localObject).bfe();
      }
      k.bfp();
      StringBuilder localStringBuilder = new StringBuilder("onInterrupt, appId[").append(paramh.getAppId()).append("], callbackId[").append(paramInt).append("], e[");
      if (paramObject != null) {}
      for (localObject = paramObject.toString();; localObject = null)
      {
        ac.i("Luggage.WXA.JsApiOperateWXDataLU", (String)localObject + ']');
        if (!(paramObject instanceof f.b)) {
          break;
        }
        AppMethodBeat.o(169617);
        return;
      }
      if ((paramObject instanceof f.a))
      {
        paramh.h(paramInt, this.keT.LM("fail " + ((f.a)paramObject).getMessage()));
        AppMethodBeat.o(169617);
        return;
      }
      if ((paramObject instanceof Throwable))
      {
        paramh.h(paramInt, this.keT.LM("fail " + ((Throwable)paramObject).getMessage()));
        AppMethodBeat.o(169617);
        return;
      }
      if (paramObject == null)
      {
        paramh.h(paramInt, this.keT.LM("fail:internal error"));
        AppMethodBeat.o(169617);
        return;
      }
      paramh.h(paramInt, this.keT.LM("fail ".concat(String.valueOf(paramObject))));
      AppMethodBeat.o(169617);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "URL", "luggage-wechat-full-sdk_release"})
  static final class g {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.k
 * JD-Core Version:    0.7.0.1
 */