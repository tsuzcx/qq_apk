package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.annotation.TargetApi;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.phonenumber.v;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import com.tencent.mm.plugin.appbrand.widget.dialog.g;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.g.a.m;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "getLocalPhoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getServePhoneItems", "Lcom/tencent/mm/vending/tuple/Tuple2;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "env", "apiName", "", "withCredentials", "", "localPhoneItems", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "invoke", "", "data", "Lorg/json/JSONObject;", "callbackId", "", "jumpToBindWxPhoneIfNeed", "tuple2", "needBindWxPhone", "phoneItems", "showPhoneNumberDialog", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "it", "progressDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandProgressDialog;", "dialog", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "showProgressDialog", "", "Companion", "Info", "luggage-wechat-full-sdk_release"})
@TargetApi(8)
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.a<aa>
{
  private static final int CTRL_INDEX = 209;
  private static final String NAME = "getPhoneNumber";
  public static final c.a jFh;
  
  static
  {
    AppMethodBeat.i(147931);
    jFh = new c.a((byte)0);
    NAME = "getPhoneNumber";
    CTRL_INDEX = 209;
    AppMethodBeat.o(147931);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "", "scopeInfo", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "alertPrivacyInfo", "Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "(Lcom/tencent/mm/protocal/protobuf/ScopeInfo;Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;)V", "getAlertPrivacyInfo", "()Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "getScopeInfo", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "luggage-wechat-full-sdk_release"})
  public static final class b
  {
    final cmy jFi;
    final dl jFj;
    
    public b(cmy paramcmy, dl paramdl)
    {
      this.jFi = paramcmy;
      this.jFj = paramdl;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(147904);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!k.g(this.jFi, paramObject.jFi)) || (!k.g(this.jFj, paramObject.jFj))) {}
        }
      }
      else
      {
        AppMethodBeat.o(147904);
        return true;
      }
      AppMethodBeat.o(147904);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(147903);
      Object localObject = this.jFi;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.jFj;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(147903);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(147902);
      String str = "Info(scopeInfo=" + this.jFi + ", alertPrivacyInfo=" + this.jFj + ")";
      AppMethodBeat.o(147902);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(c paramc, g paramg, aa paramaa) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "it", "", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(c paramc) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "localPhoneItems", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(c paramc, aa paramaa, String paramString, boolean paramBoolean) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "it", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(c paramc, aa paramaa, String paramString, boolean paramBoolean) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "it", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "call"})
  static final class i<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    i(c paramc, aa paramaa, g paramg, v paramv) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "kotlin.jvm.PlatformType", "onTerminate"})
  static final class j<T>
    implements d.b<m.a>
  {
    j(c paramc, aa paramaa, int paramInt) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "res", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class k<T>
    implements d.a<Object>
  {
    k(c paramc, aa paramaa, int paramInt) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(147914);
      Object localObject1 = z.llS;
      Object localObject2 = this.jFn.getAppId();
      k.g(localObject2, "env.appId");
      localObject1 = ((z)localObject1).Mn((String)localObject2);
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.appbrand.phonenumber.y)localObject1).report();
      }
      localObject2 = z.llS;
      localObject1 = this.jFn;
      if (localObject1 != null) {}
      for (localObject1 = ((aa)localObject1).getAppId();; localObject1 = null)
      {
        k.g(localObject1, "env?.appId");
        ((z)localObject2).Mo((String)localObject1);
        if (!(paramObject instanceof String)) {
          break label137;
        }
        ad.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:".concat(String.valueOf(paramObject)));
        localObject1 = this.jFn;
        if (localObject1 == null) {
          break;
        }
        ((aa)localObject1).h(this.jxb, this.jFl.HI("fail:".concat(String.valueOf(paramObject))));
        AppMethodBeat.o(147914);
        return;
      }
      AppMethodBeat.o(147914);
      return;
      label137:
      if ((paramObject instanceof Exception))
      {
        ad.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:{" + paramObject + ".message}");
        localObject1 = this.jFn;
        if (localObject1 != null)
        {
          ((aa)localObject1).h(this.jxb, this.jFl.HI("fail:{" + paramObject + ".message}"));
          AppMethodBeat.o(147914);
          return;
        }
        AppMethodBeat.o(147914);
        return;
      }
      ad.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail");
      paramObject = this.jFn;
      if (paramObject != null)
      {
        paramObject.h(this.jxb, this.jFl.HI("fail"));
        AppMethodBeat.o(147914);
        return;
      }
      AppMethodBeat.o(147914);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class p
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    p(com.tencent.mm.plugin.appbrand.phonenumber.y paramy, aa paramaa, v paramv)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    q(com.tencent.mm.plugin.appbrand.phonenumber.y paramy, aa paramaa, v paramv)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "invoke"})
  static final class r
    extends d.g.b.l
    implements d.g.a.b<PhoneItem, d.y>
  {
    r(com.tencent.mm.plugin.appbrand.phonenumber.y paramy, aa paramaa, c.b paramb, com.tencent.mm.vending.g.b paramb1)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "isSuccess", "", "result", "", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$showPhoneNumberDialog$5$1$1"})
    static final class a
      extends d.g.b.l
      implements m<Boolean, Map<String, ? extends String>, d.y>
    {
      a(c.r paramr, PhoneItem paramPhoneItem)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    s(com.tencent.mm.plugin.appbrand.phonenumber.y paramy, aa paramaa, c.b paramb, v paramv)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c
 * JD-Core Version:    0.7.0.1
 */