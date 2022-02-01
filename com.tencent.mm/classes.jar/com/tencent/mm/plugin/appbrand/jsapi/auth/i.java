package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.luggage.sdk.f.a.a;
import com.tencent.luggage.sdk.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.biy;
import com.tencent.mm.protocal.protobuf.biz;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.a.j;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorizeLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "cgiUrlStripForApiCallback", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class i
  extends h
  implements f
{
  public static final int CTRL_INDEX = 54;
  public static final String NAME = "authorize";
  @Deprecated
  public static final f jDD;
  
  static
  {
    AppMethodBeat.i(169581);
    jDD = new f((byte)0);
    AppMethodBeat.o(169581);
  }
  
  public static dvc b(dvc paramdvc, com.tencent.mm.plugin.appbrand.jsapi.h paramh)
  {
    AppMethodBeat.i(169585);
    d.g.b.k.h(paramdvc, "$this$fill");
    d.g.b.k.h(paramh, "service");
    paramdvc = f.c.a(paramdvc, paramh);
    AppMethodBeat.o(169585);
    return paramdvc;
  }
  
  public static <R extends cld> com.tencent.mm.vending.g.c<R> b(com.tencent.mm.plugin.appbrand.jsapi.h paramh, String paramString, com.tencent.mm.bx.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169583);
    d.g.b.k.h(paramh, "$this$runCgi");
    d.g.b.k.h(paramString, "url");
    d.g.b.k.h(parama, "request");
    d.g.b.k.h(paramClass, "clazz");
    paramh = f.c.a(paramh, paramString, parama, paramClass);
    AppMethodBeat.o(169583);
    return paramh;
  }
  
  public static void b(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.widget.dialog.i parami)
  {
    AppMethodBeat.i(169584);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(parami, "dialog");
    f.c.a(paramContext, paramBitmap, paramString1, paramString2, parami);
    AppMethodBeat.o(169584);
  }
  
  public static Context d(com.tencent.mm.plugin.appbrand.jsapi.h paramh)
  {
    AppMethodBeat.i(169582);
    d.g.b.k.h(paramh, "$this$notNullContext");
    paramh = f.c.a(paramh);
    AppMethodBeat.o(169582);
    return paramh;
  }
  
  protected final void a(final com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, final int paramInt, final e parame)
  {
    AppMethodBeat.i(169580);
    if (paramh == null)
    {
      AppMethodBeat.o(169580);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(169580);
      return;
    }
    Object localObject = paramJSONObject.optJSONArray("scope");
    if (localObject == null)
    {
      ((d.g.a.a)new a(this, paramh, paramInt)).invoke();
      AppMethodBeat.o(169580);
      return;
    }
    paramJSONObject = new LinkedList();
    int k = ((JSONArray)localObject).length();
    if (k >= 0)
    {
      int i = 0;
      String str = ((JSONArray)localObject).optString(i, null);
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          paramJSONObject.add(str);
        }
        if (i == k) {
          break label155;
        }
        i += 1;
        break;
      }
    }
    label155:
    localObject = new biy();
    ((biy)localObject).hnC = paramh.getAppId();
    ((biy)localObject).DGv.addAll((Collection)paramJSONObject);
    paramJSONObject = paramh.getRuntime();
    d.g.b.k.g(paramJSONObject, "service.runtime");
    ((biy)localObject).DGx = paramJSONObject.aLI();
    ((biy)localObject).DGy = b(new dvc(), paramh);
    b(paramh, "/cgi-bin/mmbiz-bin/js-authorize", (com.tencent.mm.bx.a)localObject, biz.class).d((com.tencent.mm.vending.c.a)new b(this, paramh, paramInt)).f((com.tencent.mm.vending.c.a)new c(this, paramh, paramInt)).a((d.b)new d(parame)).a((d.a)new e(this, parame, paramh, paramInt));
    AppMethodBeat.o(169580);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(i parami, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSAuthorizeResponse;", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(i parami, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(i parami, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "onTerminate"})
  static final class d<T>
    implements d.b<Object>
  {
    d(e parame) {}
    
    public final void br(Object paramObject)
    {
      AppMethodBeat.i(169578);
      paramObject = this.jDR;
      if (paramObject != null)
      {
        paramObject.aYh();
        AppMethodBeat.o(169578);
        return;
      }
      AppMethodBeat.o(169578);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class e<T>
    implements d.a<Object>
  {
    e(i parami, e parame, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(169579);
      Object localObject = parame;
      if (localObject != null) {
        ((e)localObject).aYh();
      }
      i.aYn();
      StringBuilder localStringBuilder = new StringBuilder("onInterrupt, appId[").append(paramh.getAppId()).append("], callbackId[").append(paramInt).append("], e[");
      if (paramObject != null) {}
      for (localObject = paramObject.toString();; localObject = null)
      {
        ad.i("Luggage.WXA.JsApiAuthorizeLU", (String)localObject + ']');
        if (!(paramObject instanceof f.b)) {
          break;
        }
        AppMethodBeat.o(169579);
        return;
      }
      if ((paramObject instanceof f.a))
      {
        paramh.h(paramInt, this.jDE.HI("fail " + ((f.a)paramObject).getMessage()));
        AppMethodBeat.o(169579);
        return;
      }
      if ((paramObject instanceof Throwable))
      {
        paramh.h(paramInt, this.jDE.HI("fail " + ((Throwable)paramObject).getMessage()));
        AppMethodBeat.o(169579);
        return;
      }
      if (paramObject == null)
      {
        paramh.h(paramInt, this.jDE.HI("fail:internal error"));
        AppMethodBeat.o(169579);
        return;
      }
      paramh.h(paramInt, this.jDE.HI("fail ".concat(String.valueOf(paramObject))));
      AppMethodBeat.o(169579);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorizeLU$Companion;", "", "()V", "CONFIRM_URL", "", "CTRL_INDEX", "", "NAME", "QUERY_URL", "TAG", "luggage-wechat-full-sdk_release"})
  static final class f {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.i
 * JD-Core Version:    0.7.0.1
 */