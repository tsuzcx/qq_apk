package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.luggage.sdk.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.permission.a.b.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.protocal.protobuf.bsa;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "Companion", "luggage-wechat-full-sdk_release"})
public final class m
  extends i
  implements f
{
  public static final int CTRL_INDEX = 79;
  public static final String NAME = "operateWXData";
  @Deprecated
  public static final m.g kCQ;
  
  static
  {
    AppMethodBeat.i(169619);
    kCQ = new m.g((byte)0);
    AppMethodBeat.o(169619);
  }
  
  public static com.tencent.mm.bw.b PW(String paramString)
  {
    AppMethodBeat.i(169620);
    p.h(paramString, "$this$toByteString");
    p.h(paramString, "$this$toByteString");
    paramString = paramString.getBytes(d.n.d.UTF_8);
    p.g(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = new com.tencent.mm.bw.b(paramString);
    AppMethodBeat.o(169620);
    return paramString;
  }
  
  public static eio b(eio parameio, h paramh)
  {
    AppMethodBeat.i(169624);
    p.h(parameio, "$this$fill");
    p.h(paramh, "service");
    parameio = f.c.a(parameio, paramh);
    AppMethodBeat.o(169624);
    return parameio;
  }
  
  public static <R extends cwj> com.tencent.mm.vending.g.c<R> b(h paramh, String paramString, com.tencent.mm.bw.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169622);
    p.h(paramh, "$this$runCgi");
    p.h(paramString, "url");
    p.h(parama, "request");
    p.h(paramClass, "clazz");
    paramh = f.c.a(paramh, paramString, parama, paramClass);
    AppMethodBeat.o(169622);
    return paramh;
  }
  
  public static void b(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.permission.a.b paramb)
  {
    AppMethodBeat.i(220953);
    p.h(paramContext, "context");
    p.h(paramb, "dialog");
    f.c.a(paramContext, paramBitmap, paramString1, paramString2, paramb);
    AppMethodBeat.o(220953);
  }
  
  public static Context c(h paramh)
  {
    AppMethodBeat.i(169621);
    p.h(paramh, "$this$notNullContext");
    paramh = f.c.a(paramh);
    AppMethodBeat.o(169621);
    return paramh;
  }
  
  protected final void a(final com.tencent.mm.plugin.appbrand.d paramd, final JSONObject paramJSONObject, final int paramInt, final e parame)
  {
    AppMethodBeat.i(220952);
    if (paramd == null)
    {
      AppMethodBeat.o(220952);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(220952);
      return;
    }
    paramJSONObject = paramJSONObject.optString("data", null);
    if (paramJSONObject == null)
    {
      ((d.g.a.a)new a(this, paramd, paramInt)).invoke();
      AppMethodBeat.o(220952);
      return;
    }
    paramJSONObject = new b(this, paramd, paramJSONObject);
    b((h)paramd, "/cgi-bin/mmbiz-bin/js-operatewxdata", (com.tencent.mm.bw.a)paramJSONObject.bjC(), bsb.class).d((com.tencent.mm.vending.c.a)new c(this, paramd, paramInt, paramJSONObject)).f((com.tencent.mm.vending.c.a)new d(this, paramd, paramInt)).a((d.b)new e(parame)).a((com.tencent.mm.vending.h.d)com.tencent.mm.vending.h.d.LFn, (d.a)new f(this, parame, paramd, paramInt));
    AppMethodBeat.o(220952);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(m paramm, com.tencent.mm.plugin.appbrand.d paramd, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"createRequest", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataRequest;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<bsa>
  {
    b(m paramm, com.tencent.mm.plugin.appbrand.d paramd, String paramString)
    {
      super();
    }
    
    public final bsa bjC()
    {
      AppMethodBeat.i(169606);
      bsa localbsa = new bsa();
      localbsa.ikm = paramd.getAppId();
      localbsa.nIq = m.PW(paramJSONObject);
      AppBrandRuntime localAppBrandRuntime = paramd.getRuntime();
      p.g(localAppBrandRuntime, "service.runtime");
      localbsa.HeR = localAppBrandRuntime.aWk();
      localbsa.HeS = m.b(new eio(), (h)paramd);
      AppMethodBeat.o(169606);
      return localbsa;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "response", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(m paramm, com.tencent.mm.plugin.appbrand.d paramd, int paramInt, m.b paramb) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(m paramm, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "onTerminate"})
  static final class e<T>
    implements d.b<Object>
  {
    e(e parame) {}
    
    public final void bq(Object paramObject)
    {
      AppMethodBeat.i(169616);
      paramObject = this.kCl;
      if (paramObject != null)
      {
        paramObject.bjq();
        AppMethodBeat.o(169616);
        return;
      }
      AppMethodBeat.o(169616);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class f<T>
    implements d.a<Object>
  {
    f(m paramm, e parame, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(169617);
      Object localObject = parame;
      if (localObject != null) {
        ((e)localObject).bjq();
      }
      m.bjB();
      StringBuilder localStringBuilder = new StringBuilder("onInterrupt, appId[").append(paramd.getAppId()).append("], callbackId[").append(paramInt).append("], e[");
      if (paramObject != null) {}
      for (localObject = paramObject.toString();; localObject = null)
      {
        ae.i("Luggage.WXA.JsApiOperateWXDataLU", (String)localObject + ']');
        if (!(paramObject instanceof f.b)) {
          break;
        }
        AppMethodBeat.o(169617);
        return;
      }
      if ((paramObject instanceof f.a))
      {
        paramd.h(paramInt, this.kCR.PO("fail " + ((f.a)paramObject).getMessage()));
        AppMethodBeat.o(169617);
        return;
      }
      if ((paramObject instanceof Throwable))
      {
        paramd.h(paramInt, this.kCR.PO("fail " + ((Throwable)paramObject).getMessage()));
        AppMethodBeat.o(169617);
        return;
      }
      if (paramObject == null)
      {
        paramd.h(paramInt, this.kCR.PO("fail:internal error"));
        AppMethodBeat.o(169617);
        return;
      }
      paramd.h(paramInt, this.kCR.PO("fail ".concat(String.valueOf(paramObject))));
      AppMethodBeat.o(169617);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.m
 * JD-Core Version:    0.7.0.1
 */