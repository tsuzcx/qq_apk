package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.luggage.sdk.f.a.a;
import com.tencent.luggage.sdk.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.permission.a.b.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorizeLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "cgiUrlStripForApiCallback", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class k
  extends i
  implements f
{
  public static final int CTRL_INDEX = 54;
  public static final String NAME = "authorize";
  @Deprecated
  public static final k.f lGp;
  
  static
  {
    AppMethodBeat.i(169581);
    lGp = new k.f((byte)0);
    AppMethodBeat.o(169581);
  }
  
  public static fdg b(fdg paramfdg, com.tencent.mm.plugin.appbrand.jsapi.k paramk)
  {
    AppMethodBeat.i(169585);
    p.h(paramfdg, "$this$fill");
    p.h(paramk, "service");
    paramfdg = f.c.a(paramfdg, paramk);
    AppMethodBeat.o(169585);
    return paramfdg;
  }
  
  public static <R extends dpc> com.tencent.mm.vending.g.c<R> b(com.tencent.mm.plugin.appbrand.jsapi.k paramk, String paramString, com.tencent.mm.bw.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169583);
    p.h(paramk, "$this$runCgi");
    p.h(paramString, "url");
    p.h(parama, "request");
    p.h(paramClass, "clazz");
    paramk = f.c.a(paramk, paramString, parama, paramClass);
    AppMethodBeat.o(169583);
    return paramk;
  }
  
  public static void b(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.permission.a.b paramb)
  {
    AppMethodBeat.i(230072);
    p.h(paramContext, "context");
    p.h(paramb, "dialog");
    f.c.a(paramContext, paramBitmap, paramString1, paramString2, paramb);
    AppMethodBeat.o(230072);
  }
  
  public static Context c(com.tencent.mm.plugin.appbrand.jsapi.k paramk)
  {
    AppMethodBeat.i(169582);
    p.h(paramk, "$this$notNullContext");
    paramk = f.c.a(paramk);
    AppMethodBeat.o(169582);
    return paramk;
  }
  
  protected final void a(final com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, final int paramInt, final e parame)
  {
    AppMethodBeat.i(230071);
    if (paramd == null)
    {
      AppMethodBeat.o(230071);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(230071);
      return;
    }
    Object localObject1 = paramJSONObject.optJSONArray("scope");
    if (localObject1 == null)
    {
      ((kotlin.g.a.a)new a(this, paramd, paramInt)).invoke();
      AppMethodBeat.o(230071);
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
    localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.k)paramd;
    Object localObject2 = new ceo();
    ((ceo)localObject2).jfi = paramd.getAppId();
    ((ceo)localObject2).MjX.addAll((Collection)paramJSONObject);
    paramJSONObject = paramd.getRuntime();
    p.g(paramJSONObject, "service.runtime");
    ((ceo)localObject2).MjZ = paramJSONObject.brf();
    ((ceo)localObject2).Mka = b(new fdg(), (com.tencent.mm.plugin.appbrand.jsapi.k)paramd);
    b((com.tencent.mm.plugin.appbrand.jsapi.k)localObject1, "/cgi-bin/mmbiz-bin/js-authorize", (com.tencent.mm.bw.a)localObject2, cep.class).d((com.tencent.mm.vending.c.a)new b(this, paramd, paramInt)).f((com.tencent.mm.vending.c.a)new c(this, paramd, paramInt)).a((d.b)new d(parame)).a((d.a)new e(this, parame, paramd, paramInt));
    AppMethodBeat.o(230071);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    a(k paramk, com.tencent.mm.plugin.appbrand.d paramd, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSAuthorizeResponse;", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(k paramk, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(k paramk, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onTerminate"})
  static final class d<T>
    implements d.b<Object>
  {
    d(e parame) {}
    
    public final void bz(Object paramObject)
    {
      AppMethodBeat.i(169578);
      paramObject = this.lGE;
      if (paramObject != null)
      {
        paramObject.bEE();
        AppMethodBeat.o(169578);
        return;
      }
      AppMethodBeat.o(169578);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class e<T>
    implements d.a<Object>
  {
    e(k paramk, e parame, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
    
    public final void cn(Object paramObject)
    {
      AppMethodBeat.i(169579);
      Object localObject = parame;
      if (localObject != null) {
        ((e)localObject).bEE();
      }
      k.bEK();
      StringBuilder localStringBuilder = new StringBuilder("onInterrupt, appId[").append(paramd.getAppId()).append("], callbackId[").append(paramInt).append("], e[");
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
        paramd.i(paramInt, this.lGq.Zf("fail " + ((f.a)paramObject).getMessage()));
        AppMethodBeat.o(169579);
        return;
      }
      if ((paramObject instanceof Throwable))
      {
        paramd.i(paramInt, this.lGq.Zf("fail " + ((Throwable)paramObject).getMessage()));
        AppMethodBeat.o(169579);
        return;
      }
      if (paramObject == null)
      {
        paramd.i(paramInt, this.lGq.Zf("fail:internal error"));
        AppMethodBeat.o(169579);
        return;
      }
      paramd.i(paramInt, this.lGq.Zf("fail ".concat(String.valueOf(paramObject))));
      AppMethodBeat.o(169579);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.k
 * JD-Core Version:    0.7.0.1
 */