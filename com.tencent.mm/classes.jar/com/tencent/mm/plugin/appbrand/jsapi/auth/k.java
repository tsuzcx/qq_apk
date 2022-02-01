package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.luggage.sdk.g.a.a;
import com.tencent.luggage.sdk.g.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.permission.a.b.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.g.b;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorizeLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "cgiUrlStripForApiCallback", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class k
  extends i
  implements f
{
  public static final int CTRL_INDEX = 54;
  public static final String NAME = "authorize";
  @Deprecated
  public static final k.f oBS;
  
  static
  {
    AppMethodBeat.i(169581);
    oBS = new k.f((byte)0);
    AppMethodBeat.o(169581);
  }
  
  public static foh b(foh paramfoh, com.tencent.mm.plugin.appbrand.jsapi.j paramj)
  {
    AppMethodBeat.i(169585);
    p.k(paramfoh, "$this$fill");
    p.k(paramj, "service");
    paramfoh = f.c.a(paramfoh, paramj);
    AppMethodBeat.o(169585);
    return paramfoh;
  }
  
  public static <R extends dyy> com.tencent.mm.vending.g.c<R> b(com.tencent.mm.plugin.appbrand.jsapi.j paramj, String paramString, com.tencent.mm.cd.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169583);
    p.k(paramj, "$this$runCgi");
    p.k(paramString, "url");
    p.k(parama, "request");
    p.k(paramClass, "clazz");
    paramj = f.c.a(paramj, paramString, parama, paramClass);
    AppMethodBeat.o(169583);
    return paramj;
  }
  
  public static void b(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.permission.a.b paramb)
  {
    AppMethodBeat.i(239485);
    p.k(paramContext, "context");
    p.k(paramb, "dialog");
    f.c.a(paramContext, paramBitmap, paramString1, paramString2, paramb);
    AppMethodBeat.o(239485);
  }
  
  public static Context c(com.tencent.mm.plugin.appbrand.jsapi.j paramj)
  {
    AppMethodBeat.i(169582);
    p.k(paramj, "$this$notNullContext");
    paramj = f.c.a(paramj);
    AppMethodBeat.o(169582);
    return paramj;
  }
  
  protected final void a(final com.tencent.mm.plugin.appbrand.g paramg, JSONObject paramJSONObject, final int paramInt, final e parame)
  {
    AppMethodBeat.i(239477);
    if (paramg == null)
    {
      AppMethodBeat.o(239477);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(239477);
      return;
    }
    Object localObject1 = paramJSONObject.optJSONArray("scope");
    if (localObject1 == null)
    {
      ((kotlin.g.a.a)new a(this, paramg, paramInt)).invoke();
      AppMethodBeat.o(239477);
      return;
    }
    paramJSONObject = new LinkedList();
    int k = ((JSONArray)localObject1).length();
    if (k >= 0)
    {
      int i = 0;
      localObject2 = ((JSONArray)localObject1).optString(i, null);
      CharSequence localCharSequence = (CharSequence)localObject2;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          paramJSONObject.add(localObject2);
        }
        if (i == k) {
          break label155;
        }
        i += 1;
        break;
      }
    }
    label155:
    localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.j)paramg;
    Object localObject2 = new cni();
    ((cni)localObject2).lVG = paramg.getAppId();
    ((cni)localObject2).TuN.addAll((Collection)paramJSONObject);
    paramJSONObject = paramg.getRuntime();
    p.j(paramJSONObject, "service.runtime");
    ((cni)localObject2).TuP = paramJSONObject.bBV();
    ((cni)localObject2).TuQ = b(new foh(), (com.tencent.mm.plugin.appbrand.jsapi.j)paramg);
    b((com.tencent.mm.plugin.appbrand.jsapi.j)localObject1, "/cgi-bin/mmbiz-bin/js-authorize", (com.tencent.mm.cd.a)localObject2, cnj.class).d((com.tencent.mm.vending.c.a)new b(this, paramg, paramInt)).f((com.tencent.mm.vending.c.a)new c(this, paramg, paramInt)).a((d.b)new d(parame)).a((d.a)new e(this, parame, paramg, paramInt));
    AppMethodBeat.o(239477);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    a(k paramk, com.tencent.mm.plugin.appbrand.g paramg, int paramInt)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSAuthorizeResponse;", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(k paramk, com.tencent.mm.plugin.appbrand.g paramg, int paramInt) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(k paramk, com.tencent.mm.plugin.appbrand.g paramg, int paramInt) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onTerminate"})
  static final class d<T>
    implements d.b<Object>
  {
    d(e parame) {}
    
    public final void bz(Object paramObject)
    {
      AppMethodBeat.i(169578);
      paramObject = this.oCh;
      if (paramObject != null)
      {
        paramObject.bQe();
        AppMethodBeat.o(169578);
        return;
      }
      AppMethodBeat.o(169578);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class e<T>
    implements d.a<Object>
  {
    e(k paramk, e parame, com.tencent.mm.plugin.appbrand.g paramg, int paramInt) {}
    
    public final void cm(Object paramObject)
    {
      AppMethodBeat.i(169579);
      Object localObject = parame;
      if (localObject != null) {
        ((e)localObject).bQe();
      }
      k.bQk();
      StringBuilder localStringBuilder = new StringBuilder("onInterrupt, appId[").append(paramg.getAppId()).append("], callbackId[").append(paramInt).append("], e[");
      if (paramObject != null) {}
      for (localObject = paramObject.toString();; localObject = null)
      {
        Log.i("Luggage.WXA.JsApiAuthorizeLU", (String)localObject + ']');
        if (!(paramObject instanceof f.b)) {
          break;
        }
        AppMethodBeat.o(169579);
        return;
      }
      if ((paramObject instanceof f.a))
      {
        paramg.j(paramInt, this.oBT.agS("fail " + ((f.a)paramObject).getMessage()));
        AppMethodBeat.o(169579);
        return;
      }
      if ((paramObject instanceof Throwable))
      {
        paramg.j(paramInt, this.oBT.agS("fail " + ((Throwable)paramObject).getMessage()));
        AppMethodBeat.o(169579);
        return;
      }
      if (paramObject == null)
      {
        paramg.j(paramInt, this.oBT.agS("fail:internal error"));
        AppMethodBeat.o(169579);
        return;
      }
      paramg.j(paramInt, this.oBT.agS("fail ".concat(String.valueOf(paramObject))));
      AppMethodBeat.o(169579);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.k
 * JD-Core Version:    0.7.0.1
 */