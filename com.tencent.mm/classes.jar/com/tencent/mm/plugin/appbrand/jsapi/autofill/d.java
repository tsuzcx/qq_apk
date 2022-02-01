package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.annotation.TargetApi;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.y;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import com.tencent.mm.plugin.appbrand.widget.dialog.g;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "getLocalPhoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getServePhoneItems", "Lcom/tencent/mm/vending/tuple/Tuple2;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "env", "apiName", "", "withCredentials", "", "localPhoneItems", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "invoke", "", "data", "Lorg/json/JSONObject;", "callbackId", "", "jumpToBindWxPhoneIfNeed", "tuple2", "needBindWxPhone", "phoneItems", "showPhoneNumberDialog", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "it", "progressDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandProgressDialog;", "dialog", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "showProgressDialog", "", "Companion", "Info", "luggage-wechat-full-sdk_release"})
@TargetApi(8)
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.d<ac>
{
  private static final int CTRL_INDEX = 209;
  private static final String NAME = "getPhoneNumber";
  public static final d.a lIh;
  
  static
  {
    AppMethodBeat.i(147931);
    lIh = new d.a((byte)0);
    NAME = "getPhoneNumber";
    CTRL_INDEX = 209;
    AppMethodBeat.o(147931);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "", "scopeInfo", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "alertPrivacyInfo", "Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "(Lcom/tencent/mm/protocal/protobuf/ScopeInfo;Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;)V", "getAlertPrivacyInfo", "()Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "getScopeInfo", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "luggage-wechat-full-sdk_release"})
  public static final class b
  {
    final drb lIi;
    final dy lIj;
    
    public b(drb paramdrb, dy paramdy)
    {
      this.lIi = paramdrb;
      this.lIj = paramdy;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(147904);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.j(this.lIi, paramObject.lIi)) || (!p.j(this.lIj, paramObject.lIj))) {}
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
      Object localObject = this.lIi;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.lIj;
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
      String str = "Info(scopeInfo=" + this.lIi + ", alertPrivacyInfo=" + this.lIj + ")";
      AppMethodBeat.o(147902);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isSuccess", "", "errMsg", "", "phoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "info", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.r<Boolean, String, List<? extends PhoneItem>, d.b, x>
  {
    c(com.tencent.mm.vending.g.b paramb, List paramList)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(d paramd, g paramg, ac paramac) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "it", "", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(d paramd) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "localPhoneItems", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(d paramd, ac paramac, String paramString, boolean paramBoolean) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "it", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(d paramd, ac paramac, String paramString, boolean paramBoolean) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "it", "call"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public static final h lIq;
    
    static
    {
      AppMethodBeat.i(147911);
      lIq = new h();
      AppMethodBeat.o(147911);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "it", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "call"})
  static final class i<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    i(d paramd, ac paramac, g paramg) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "kotlin.jvm.PlatformType", "onTerminate"})
  static final class j<T>
    implements com.tencent.mm.vending.g.d.b<p.a>
  {
    j(d paramd, ac paramac, int paramInt) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "res", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class k<T>
    implements com.tencent.mm.vending.g.d.a<Object>
  {
    k(d paramd, ac paramac, int paramInt) {}
    
    public final void cn(Object paramObject)
    {
      AppMethodBeat.i(147914);
      Object localObject1 = z.nBg;
      Object localObject2 = this.lIn.getAppId();
      p.g(localObject2, "env.appId");
      localObject1 = ((z)localObject1).aex((String)localObject2);
      if (localObject1 != null) {
        ((y)localObject1).report();
      }
      localObject2 = z.nBg;
      localObject1 = this.lIn;
      if (localObject1 != null) {}
      for (localObject1 = ((ac)localObject1).getAppId();; localObject1 = null)
      {
        p.g(localObject1, "env?.appId");
        ((z)localObject2).aey((String)localObject1);
        if (!(paramObject instanceof String)) {
          break label137;
        }
        Log.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:".concat(String.valueOf(paramObject)));
        localObject1 = this.lIn;
        if (localObject1 == null) {
          break;
        }
        ((ac)localObject1).i(this.lyo, this.lIl.Zf("fail:".concat(String.valueOf(paramObject))));
        AppMethodBeat.o(147914);
        return;
      }
      AppMethodBeat.o(147914);
      return;
      label137:
      if ((paramObject instanceof Exception))
      {
        Log.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:{" + paramObject + ".message}");
        localObject1 = this.lIn;
        if (localObject1 != null)
        {
          ((ac)localObject1).i(this.lyo, this.lIl.Zf("fail:{" + paramObject + ".message}"));
          AppMethodBeat.o(147914);
          return;
        }
        AppMethodBeat.o(147914);
        return;
      }
      Log.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail");
      paramObject = this.lIn;
      if (paramObject != null)
      {
        paramObject.i(this.lyo, this.lIl.Zf("fail"));
        AppMethodBeat.o(147914);
        return;
      }
      AppMethodBeat.o(147914);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class l<T>
    implements com.tencent.mm.vending.g.d.a<Object>
  {
    l(ac paramac, g paramg) {}
    
    public final void cn(Object paramObject)
    {
      AppMethodBeat.i(147915);
      paramObject = this.lIn;
      if (paramObject != null)
      {
        paramObject = paramObject.getDialogContainer();
        if (paramObject != null)
        {
          paramObject.c((k)this.lIm);
          AppMethodBeat.o(147915);
          return;
        }
      }
      AppMethodBeat.o(147915);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    m(y paramy, ac paramac, String paramString, boolean paramBoolean, com.tencent.mm.vending.g.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<x>
  {
    n(y paramy, com.tencent.mm.vending.g.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<x>
  {
    o(y paramy, com.tencent.mm.vending.g.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<x>
  {
    p(y paramy, ac paramac, com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<x>
  {
    q(y paramy, ac paramac, com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.b<PhoneItem, x>
  {
    r(y paramy, ac paramac, d.b paramb, com.tencent.mm.vending.g.b paramb1)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isSuccess", "", "result", "", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$showPhoneNumberDialog$5$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.m<Boolean, Map<String, ? extends String>, x>
    {
      a(d.r paramr, PhoneItem paramPhoneItem)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<x>
  {
    s(y paramy, com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a parama, ac paramac, d.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.d
 * JD-Core Version:    0.7.0.1
 */