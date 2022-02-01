package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.luggage.sdk.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.permission.a.b.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.b;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.protocal.protobuf.eoq;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "Companion", "luggage-wechat-full-sdk_release"})
public final class m
  extends i
  implements f
{
  public static final int CTRL_INDEX = 79;
  public static final String NAME = "operateWXData";
  @Deprecated
  public static final m.g lHr;
  
  static
  {
    AppMethodBeat.i(169619);
    lHr = new m.g((byte)0);
    AppMethodBeat.o(169619);
  }
  
  public static com.tencent.mm.bw.b Zq(String paramString)
  {
    AppMethodBeat.i(169620);
    p.h(paramString, "$this$toByteString");
    p.h(paramString, "$this$toByteString");
    paramString = paramString.getBytes(kotlin.n.d.UTF_8);
    p.g(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = new com.tencent.mm.bw.b(paramString);
    AppMethodBeat.o(169620);
    return paramString;
  }
  
  public static fdg b(fdg paramfdg, com.tencent.mm.plugin.appbrand.jsapi.k paramk)
  {
    AppMethodBeat.i(169624);
    p.h(paramfdg, "$this$fill");
    p.h(paramk, "service");
    paramfdg = f.c.a(paramfdg, paramk);
    AppMethodBeat.o(169624);
    return paramfdg;
  }
  
  public static <R extends dpc> com.tencent.mm.vending.g.c<R> b(com.tencent.mm.plugin.appbrand.jsapi.k paramk, String paramString, com.tencent.mm.bw.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169622);
    p.h(paramk, "$this$runCgi");
    p.h(paramString, "url");
    p.h(parama, "request");
    p.h(paramClass, "clazz");
    paramk = f.c.a(paramk, paramString, parama, paramClass);
    AppMethodBeat.o(169622);
    return paramk;
  }
  
  public static void b(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.permission.a.b paramb)
  {
    AppMethodBeat.i(230076);
    p.h(paramContext, "context");
    p.h(paramb, "dialog");
    f.c.a(paramContext, paramBitmap, paramString1, paramString2, paramb);
    AppMethodBeat.o(230076);
  }
  
  public static Context c(com.tencent.mm.plugin.appbrand.jsapi.k paramk)
  {
    AppMethodBeat.i(169621);
    p.h(paramk, "$this$notNullContext");
    paramk = f.c.a(paramk);
    AppMethodBeat.o(169621);
    return paramk;
  }
  
  protected final void a(final com.tencent.mm.plugin.appbrand.d paramd, final JSONObject paramJSONObject, final int paramInt, final e parame)
  {
    AppMethodBeat.i(230075);
    if (paramd == null)
    {
      AppMethodBeat.o(230075);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(230075);
      return;
    }
    paramJSONObject = paramJSONObject.optString("data", null);
    if (paramJSONObject == null)
    {
      ((kotlin.g.a.a)new a(this, paramd, paramInt)).invoke();
      AppMethodBeat.o(230075);
      return;
    }
    paramJSONObject = new b(this, paramd, paramJSONObject);
    b((com.tencent.mm.plugin.appbrand.jsapi.k)paramd, "/cgi-bin/mmbiz-bin/js-operatewxdata", (com.tencent.mm.bw.a)paramJSONObject.bER(), cev.class).d((com.tencent.mm.vending.c.a)new c(this, paramd, paramInt, paramJSONObject)).f((com.tencent.mm.vending.c.a)new d(this, paramd, paramInt)).a((d.b)new e(parame)).a((com.tencent.mm.vending.h.d)com.tencent.mm.vending.h.d.UI, (d.a)new f(this, parame, paramd, paramInt));
    AppMethodBeat.o(230075);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(m paramm, com.tencent.mm.plugin.appbrand.d paramd, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"createRequest", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataRequest;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<ceu>
  {
    b(m paramm, com.tencent.mm.plugin.appbrand.d paramd, String paramString)
    {
      super();
    }
    
    public final ceu bER()
    {
      AppMethodBeat.i(169606);
      ceu localceu = new ceu();
      localceu.jfi = paramd.getAppId();
      localceu.oTm = m.Zq(paramJSONObject);
      AppBrandRuntime localAppBrandRuntime = paramd.getRuntime();
      p.g(localAppBrandRuntime, "service.runtime");
      localceu.MjZ = localAppBrandRuntime.brf();
      localceu.Mka = m.b(new fdg(), (com.tencent.mm.plugin.appbrand.jsapi.k)paramd);
      AppMethodBeat.o(169606);
      return localceu;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "response", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(m paramm, com.tencent.mm.plugin.appbrand.d paramd, int paramInt, m.b paramb) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(m paramm, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onTerminate"})
  static final class e<T>
    implements d.b<Object>
  {
    e(e parame) {}
    
    public final void bz(Object paramObject)
    {
      AppMethodBeat.i(169616);
      paramObject = this.lGE;
      if (paramObject != null)
      {
        paramObject.bEE();
        AppMethodBeat.o(169616);
        return;
      }
      AppMethodBeat.o(169616);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class f<T>
    implements d.a<Object>
  {
    f(m paramm, e parame, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
    
    public final void cn(Object paramObject)
    {
      AppMethodBeat.i(169617);
      Object localObject = parame;
      if (localObject != null) {
        ((e)localObject).bEE();
      }
      m.bEQ();
      StringBuilder localStringBuilder = new StringBuilder("onInterrupt, appId[").append(paramd.getAppId()).append("], callbackId[").append(paramInt).append("], e[");
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
        paramd.i(paramInt, this.lHs.Zf("fail " + ((f.a)paramObject).getMessage()));
        AppMethodBeat.o(169617);
        return;
      }
      if ((paramObject instanceof Throwable))
      {
        paramd.i(paramInt, this.lHs.Zf("fail " + ((Throwable)paramObject).getMessage()));
        AppMethodBeat.o(169617);
        return;
      }
      if (paramObject == null)
      {
        paramd.i(paramInt, this.lHs.Zf("fail:internal error"));
        AppMethodBeat.o(169617);
        return;
      }
      paramd.i(paramInt, this.lHs.Zf("fail ".concat(String.valueOf(paramObject))));
      AppMethodBeat.o(169617);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.m
 * JD-Core Version:    0.7.0.1
 */