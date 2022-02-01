package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.annotation.TargetApi;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.y;
import com.tencent.mm.plugin.appbrand.widget.dialog.g;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "getLocalPhoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getServePhoneItems", "Lcom/tencent/mm/vending/tuple/Tuple2;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "env", "apiName", "", "withCredentials", "", "localPhoneItems", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "invoke", "", "data", "Lorg/json/JSONObject;", "callbackId", "", "jumpToBindWxPhoneIfNeed", "tuple2", "needBindWxPhone", "phoneItems", "showPhoneNumberDialog", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "it", "progressDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandProgressDialog;", "dialog", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "showProgressDialog", "", "Companion", "Info", "luggage-wechat-full-sdk_release"})
@TargetApi(8)
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.a<aa>
{
  private static final int CTRL_INDEX = 209;
  private static final String NAME = "getPhoneNumber";
  public static final d.a kAs;
  
  static
  {
    AppMethodBeat.i(147931);
    kAs = new d.a((byte)0);
    NAME = "getPhoneNumber";
    CTRL_INDEX = 209;
    AppMethodBeat.o(147931);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "isSuccess", "", "errMsg", "", "phoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "info", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "invoke"})
  static final class c
    extends q
    implements d.g.a.r<Boolean, String, List<? extends PhoneItem>, d.b, d.z>
  {
    c(com.tencent.mm.vending.g.b paramb, List paramList)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(d paramd, g paramg, aa paramaa) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "it", "", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(d paramd) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "localPhoneItems", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(d paramd, aa paramaa, String paramString, boolean paramBoolean) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "it", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(d paramd, aa paramaa, String paramString, boolean paramBoolean) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "it", "call"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public static final h kAB;
    
    static
    {
      AppMethodBeat.i(147911);
      kAB = new h();
      AppMethodBeat.o(147911);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "it", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "call"})
  static final class i<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    i(d paramd, aa paramaa, g paramg) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "kotlin.jvm.PlatformType", "onTerminate"})
  static final class j<T>
    implements com.tencent.mm.vending.g.d.b<m.a>
  {
    j(d paramd, aa paramaa, int paramInt) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "res", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class k<T>
    implements com.tencent.mm.vending.g.d.a<Object>
  {
    k(d paramd, aa paramaa, int paramInt) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(147914);
      Object localObject1 = com.tencent.mm.plugin.appbrand.phonenumber.z.mlx;
      Object localObject2 = this.kAy.getAppId();
      p.g(localObject2, "env.appId");
      localObject1 = ((com.tencent.mm.plugin.appbrand.phonenumber.z)localObject1).TZ((String)localObject2);
      if (localObject1 != null) {
        ((y)localObject1).report();
      }
      localObject2 = com.tencent.mm.plugin.appbrand.phonenumber.z.mlx;
      localObject1 = this.kAy;
      if (localObject1 != null) {}
      for (localObject1 = ((aa)localObject1).getAppId();; localObject1 = null)
      {
        p.g(localObject1, "env?.appId");
        ((com.tencent.mm.plugin.appbrand.phonenumber.z)localObject2).Ua((String)localObject1);
        if (!(paramObject instanceof String)) {
          break label137;
        }
        ad.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:".concat(String.valueOf(paramObject)));
        localObject1 = this.kAy;
        if (localObject1 == null) {
          break;
        }
        ((aa)localObject1).h(this.krv, this.kAw.Pg("fail:".concat(String.valueOf(paramObject))));
        AppMethodBeat.o(147914);
        return;
      }
      AppMethodBeat.o(147914);
      return;
      label137:
      if ((paramObject instanceof Exception))
      {
        ad.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:{" + paramObject + ".message}");
        localObject1 = this.kAy;
        if (localObject1 != null)
        {
          ((aa)localObject1).h(this.krv, this.kAw.Pg("fail:{" + paramObject + ".message}"));
          AppMethodBeat.o(147914);
          return;
        }
        AppMethodBeat.o(147914);
        return;
      }
      ad.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail");
      paramObject = this.kAy;
      if (paramObject != null)
      {
        paramObject.h(this.krv, this.kAw.Pg("fail"));
        AppMethodBeat.o(147914);
        return;
      }
      AppMethodBeat.o(147914);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class l<T>
    implements com.tencent.mm.vending.g.d.a<Object>
  {
    l(aa paramaa, g paramg) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(147915);
      paramObject = this.kAy;
      if (paramObject != null)
      {
        paramObject = paramObject.aVE();
        if (paramObject != null)
        {
          paramObject.c((k)this.kAx);
          AppMethodBeat.o(147915);
          return;
        }
      }
      AppMethodBeat.o(147915);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.b<Integer, d.z>
  {
    m(y paramy, aa paramaa, String paramString, boolean paramBoolean, com.tencent.mm.vending.g.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements d.g.a.a<d.z>
  {
    p(y paramy, aa paramaa, com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements d.g.a.a<d.z>
  {
    q(y paramy, aa paramaa, com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "invoke"})
  static final class r
    extends q
    implements d.g.a.b<PhoneItem, d.z>
  {
    r(y paramy, aa paramaa, d.b paramb, com.tencent.mm.vending.g.b paramb1)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "isSuccess", "", "result", "", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$showPhoneNumberDialog$5$1$1"})
    static final class a
      extends q
      implements d.g.a.m<Boolean, Map<String, ? extends String>, d.z>
    {
      a(d.r paramr, PhoneItem paramPhoneItem)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class s
    extends q
    implements d.g.a.a<d.z>
  {
    s(y paramy, com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a parama, aa paramaa, d.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.d
 * JD-Core Version:    0.7.0.1
 */