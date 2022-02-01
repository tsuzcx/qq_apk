package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.luggage.sdk.f.a.a;
import com.tencent.luggage.sdk.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.permission.a.b.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.brt;
import com.tencent.mm.protocal.protobuf.bru;
import com.tencent.mm.protocal.protobuf.brv;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.a.j;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorizeLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "cgiUrlStripForApiCallback", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class k
  extends i
  implements f
{
  public static final int CTRL_INDEX = 54;
  public static final String NAME = "authorize";
  @Deprecated
  public static final k.f kBW;
  
  static
  {
    AppMethodBeat.i(169581);
    kBW = new k.f((byte)0);
    AppMethodBeat.o(169581);
  }
  
  public static eio b(eio parameio, h paramh)
  {
    AppMethodBeat.i(169585);
    p.h(parameio, "$this$fill");
    p.h(paramh, "service");
    parameio = f.c.a(parameio, paramh);
    AppMethodBeat.o(169585);
    return parameio;
  }
  
  public static <R extends cwj> com.tencent.mm.vending.g.c<R> b(h paramh, String paramString, com.tencent.mm.bw.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169583);
    p.h(paramh, "$this$runCgi");
    p.h(paramString, "url");
    p.h(parama, "request");
    p.h(paramClass, "clazz");
    paramh = f.c.a(paramh, paramString, parama, paramClass);
    AppMethodBeat.o(169583);
    return paramh;
  }
  
  public static void b(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.permission.a.b paramb)
  {
    AppMethodBeat.i(220949);
    p.h(paramContext, "context");
    p.h(paramb, "dialog");
    f.c.a(paramContext, paramBitmap, paramString1, paramString2, paramb);
    AppMethodBeat.o(220949);
  }
  
  public static Context c(h paramh)
  {
    AppMethodBeat.i(169582);
    p.h(paramh, "$this$notNullContext");
    paramh = f.c.a(paramh);
    AppMethodBeat.o(169582);
    return paramh;
  }
  
  protected final void a(final com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, final int paramInt, final e parame)
  {
    AppMethodBeat.i(220948);
    if (paramd == null)
    {
      AppMethodBeat.o(220948);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(220948);
      return;
    }
    Object localObject1 = paramJSONObject.optJSONArray("scope");
    if (localObject1 == null)
    {
      ((d.g.a.a)new a(this, paramd, paramInt)).invoke();
      AppMethodBeat.o(220948);
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
    localObject1 = (h)paramd;
    Object localObject2 = new bru();
    ((bru)localObject2).ikm = paramd.getAppId();
    ((bru)localObject2).HeP.addAll((Collection)paramJSONObject);
    paramJSONObject = paramd.getRuntime();
    p.g(paramJSONObject, "service.runtime");
    ((bru)localObject2).HeR = paramJSONObject.aWk();
    ((bru)localObject2).HeS = b(new eio(), (h)paramd);
    b((h)localObject1, "/cgi-bin/mmbiz-bin/js-authorize", (com.tencent.mm.bw.a)localObject2, brv.class).d((com.tencent.mm.vending.c.a)new b(this, paramd, paramInt)).f((com.tencent.mm.vending.c.a)new c(this, paramd, paramInt)).a((d.b)new d(parame)).a((d.a)new e(this, parame, paramd, paramInt));
    AppMethodBeat.o(220948);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    a(k paramk, com.tencent.mm.plugin.appbrand.d paramd, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSAuthorizeResponse;", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(k paramk, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(k paramk, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "onTerminate"})
  static final class d<T>
    implements d.b<Object>
  {
    d(e parame) {}
    
    public final void bq(Object paramObject)
    {
      AppMethodBeat.i(169578);
      paramObject = this.kCl;
      if (paramObject != null)
      {
        paramObject.bjq();
        AppMethodBeat.o(169578);
        return;
      }
      AppMethodBeat.o(169578);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class e<T>
    implements d.a<Object>
  {
    e(k paramk, e parame, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(169579);
      Object localObject = parame;
      if (localObject != null) {
        ((e)localObject).bjq();
      }
      k.bjw();
      StringBuilder localStringBuilder = new StringBuilder("onInterrupt, appId[").append(paramd.getAppId()).append("], callbackId[").append(paramInt).append("], e[");
      if (paramObject != null) {}
      for (localObject = paramObject.toString();; localObject = null)
      {
        ae.i("Luggage.WXA.JsApiAuthorizeLU", (String)localObject + ']');
        if (!(paramObject instanceof f.b)) {
          break;
        }
        AppMethodBeat.o(169579);
        return;
      }
      if ((paramObject instanceof f.a))
      {
        paramd.h(paramInt, this.kBX.PO("fail " + ((f.a)paramObject).getMessage()));
        AppMethodBeat.o(169579);
        return;
      }
      if ((paramObject instanceof Throwable))
      {
        paramd.h(paramInt, this.kBX.PO("fail " + ((Throwable)paramObject).getMessage()));
        AppMethodBeat.o(169579);
        return;
      }
      if (paramObject == null)
      {
        paramd.h(paramInt, this.kBX.PO("fail:internal error"));
        AppMethodBeat.o(169579);
        return;
      }
      paramd.h(paramInt, this.kBX.PO("fail ".concat(String.valueOf(paramObject))));
      AppMethodBeat.o(169579);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.k
 * JD-Core Version:    0.7.0.1
 */