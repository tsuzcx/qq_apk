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
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.dip;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.a.j;
import d.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "Companion", "luggage-wechat-full-sdk_release"})
public final class k
  extends h
  implements f
{
  public static final int CTRL_INDEX = 79;
  public static final String NAME = "operateWXData";
  @Deprecated
  public static final g jEv;
  
  static
  {
    AppMethodBeat.i(169619);
    jEv = new g((byte)0);
    AppMethodBeat.o(169619);
  }
  
  public static com.tencent.mm.bx.b HP(String paramString)
  {
    AppMethodBeat.i(169620);
    d.g.b.k.h(paramString, "$this$toByteString");
    d.g.b.k.h(paramString, "$this$toByteString");
    paramString = paramString.getBytes(d.n.d.UTF_8);
    d.g.b.k.g(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = new com.tencent.mm.bx.b(paramString);
    AppMethodBeat.o(169620);
    return paramString;
  }
  
  public static dvc b(dvc paramdvc, com.tencent.mm.plugin.appbrand.jsapi.h paramh)
  {
    AppMethodBeat.i(169624);
    d.g.b.k.h(paramdvc, "$this$fill");
    d.g.b.k.h(paramh, "service");
    paramdvc = f.c.a(paramdvc, paramh);
    AppMethodBeat.o(169624);
    return paramdvc;
  }
  
  public static <R extends cld> com.tencent.mm.vending.g.c<R> b(com.tencent.mm.plugin.appbrand.jsapi.h paramh, String paramString, com.tencent.mm.bx.a parama, Class<R> paramClass)
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
    b(paramh, "/cgi-bin/mmbiz-bin/js-operatewxdata", (com.tencent.mm.bx.a)paramJSONObject.aYt(), bjf.class).d((com.tencent.mm.vending.c.a)new c(this, paramh, paramInt, paramJSONObject)).f((com.tencent.mm.vending.c.a)new d(this, paramh, paramInt)).a((d.b)new e(parame)).a((com.tencent.mm.vending.h.d)com.tencent.mm.vending.h.d.HQL, (d.a)new f(this, parame, paramh, paramInt));
    AppMethodBeat.o(169618);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(k paramk, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"createRequest", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataRequest;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<bje>
  {
    b(k paramk, com.tencent.mm.plugin.appbrand.jsapi.h paramh, String paramString)
    {
      super();
    }
    
    public final bje aYt()
    {
      AppMethodBeat.i(169606);
      bje localbje = new bje();
      localbje.hnC = paramh.getAppId();
      localbje.mAx = k.HP(paramJSONObject);
      AppBrandRuntime localAppBrandRuntime = paramh.getRuntime();
      d.g.b.k.g(localAppBrandRuntime, "service.runtime");
      localbje.DGx = localAppBrandRuntime.aLI();
      localbje.DGy = k.b(new dvc(), paramh);
      AppMethodBeat.o(169606);
      return localbje;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "response", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(k paramk, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt, k.b paramb) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(k paramk, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "onTerminate"})
  static final class e<T>
    implements d.b<Object>
  {
    e(e parame) {}
    
    public final void br(Object paramObject)
    {
      AppMethodBeat.i(169616);
      paramObject = this.jDR;
      if (paramObject != null)
      {
        paramObject.aYh();
        AppMethodBeat.o(169616);
        return;
      }
      AppMethodBeat.o(169616);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class f<T>
    implements d.a<Object>
  {
    f(k paramk, e parame, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(169617);
      Object localObject = parame;
      if (localObject != null) {
        ((e)localObject).aYh();
      }
      k.aYs();
      StringBuilder localStringBuilder = new StringBuilder("onInterrupt, appId[").append(paramh.getAppId()).append("], callbackId[").append(paramInt).append("], e[");
      if (paramObject != null) {}
      for (localObject = paramObject.toString();; localObject = null)
      {
        ad.i("Luggage.WXA.JsApiOperateWXDataLU", (String)localObject + ']');
        if (!(paramObject instanceof f.b)) {
          break;
        }
        AppMethodBeat.o(169617);
        return;
      }
      if ((paramObject instanceof f.a))
      {
        paramh.h(paramInt, this.jEw.HI("fail " + ((f.a)paramObject).getMessage()));
        AppMethodBeat.o(169617);
        return;
      }
      if ((paramObject instanceof Throwable))
      {
        paramh.h(paramInt, this.jEw.HI("fail " + ((Throwable)paramObject).getMessage()));
        AppMethodBeat.o(169617);
        return;
      }
      if (paramObject == null)
      {
        paramh.h(paramInt, this.jEw.HI("fail:internal error"));
        AppMethodBeat.o(169617);
        return;
      }
      paramh.h(paramInt, this.jEw.HI("fail ".concat(String.valueOf(paramObject))));
      AppMethodBeat.o(169617);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "URL", "luggage-wechat-full-sdk_release"})
  static final class g {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.k
 * JD-Core Version:    0.7.0.1
 */