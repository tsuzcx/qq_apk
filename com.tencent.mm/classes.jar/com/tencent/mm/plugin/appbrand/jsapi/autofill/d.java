package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.annotation.TargetApi;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.phonenumber.y;
import com.tencent.mm.plugin.appbrand.widget.dialog.g;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.g.d.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "getLocalPhoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getServePhoneItems", "Lcom/tencent/mm/vending/tuple/Tuple2;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "env", "apiName", "", "withCredentials", "", "localPhoneItems", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "invoke", "", "data", "Lorg/json/JSONObject;", "callbackId", "", "jumpToBindWxPhoneIfNeed", "tuple2", "needBindWxPhone", "phoneItems", "showPhoneNumberDialog", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "it", "progressDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandProgressDialog;", "dialog", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "showProgressDialog", "", "Companion", "Info", "luggage-wechat-full-sdk_release"})
@TargetApi(8)
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.page.z>
{
  private static final int CTRL_INDEX = 209;
  private static final String NAME = "getPhoneNumber";
  public static final d.a kDH;
  
  static
  {
    AppMethodBeat.i(147931);
    kDH = new d.a((byte)0);
    NAME = "getPhoneNumber";
    CTRL_INDEX = 209;
    AppMethodBeat.o(147931);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(d paramd, g paramg, com.tencent.mm.plugin.appbrand.page.z paramz) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "it", "", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(d paramd) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "localPhoneItems", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(d paramd, com.tencent.mm.plugin.appbrand.page.z paramz, String paramString, boolean paramBoolean) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "it", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(d paramd, com.tencent.mm.plugin.appbrand.page.z paramz, String paramString, boolean paramBoolean) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "it", "call"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public static final h kDQ;
    
    static
    {
      AppMethodBeat.i(147911);
      kDQ = new h();
      AppMethodBeat.o(147911);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "it", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "call"})
  static final class i<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    i(d paramd, com.tencent.mm.plugin.appbrand.page.z paramz, g paramg) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "kotlin.jvm.PlatformType", "onTerminate"})
  static final class j<T>
    implements d.b<m.a>
  {
    j(d paramd, com.tencent.mm.plugin.appbrand.page.z paramz, int paramInt) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "res", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class k<T>
    implements com.tencent.mm.vending.g.d.a<Object>
  {
    k(d paramd, com.tencent.mm.plugin.appbrand.page.z paramz, int paramInt) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(147914);
      Object localObject1 = com.tencent.mm.plugin.appbrand.phonenumber.z.mqu;
      Object localObject2 = this.kDN.getAppId();
      p.g(localObject2, "env.appId");
      localObject1 = ((com.tencent.mm.plugin.appbrand.phonenumber.z)localObject1).UJ((String)localObject2);
      if (localObject1 != null) {
        ((y)localObject1).report();
      }
      localObject2 = com.tencent.mm.plugin.appbrand.phonenumber.z.mqu;
      localObject1 = this.kDN;
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.plugin.appbrand.page.z)localObject1).getAppId();; localObject1 = null)
      {
        p.g(localObject1, "env?.appId");
        ((com.tencent.mm.plugin.appbrand.phonenumber.z)localObject2).UK((String)localObject1);
        if (!(paramObject instanceof String)) {
          break label137;
        }
        ae.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:".concat(String.valueOf(paramObject)));
        localObject1 = this.kDN;
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.appbrand.page.z)localObject1).h(this.kuL, this.kDL.PO("fail:".concat(String.valueOf(paramObject))));
        AppMethodBeat.o(147914);
        return;
      }
      AppMethodBeat.o(147914);
      return;
      label137:
      if ((paramObject instanceof Exception))
      {
        ae.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:{" + paramObject + ".message}");
        localObject1 = this.kDN;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.appbrand.page.z)localObject1).h(this.kuL, this.kDL.PO("fail:{" + paramObject + ".message}"));
          AppMethodBeat.o(147914);
          return;
        }
        AppMethodBeat.o(147914);
        return;
      }
      ae.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail");
      paramObject = this.kDN;
      if (paramObject != null)
      {
        paramObject.h(this.kuL, this.kDL.PO("fail"));
        AppMethodBeat.o(147914);
        return;
      }
      AppMethodBeat.o(147914);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class l<T>
    implements com.tencent.mm.vending.g.d.a<Object>
  {
    l(com.tencent.mm.plugin.appbrand.page.z paramz, g paramg) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(147915);
      paramObject = this.kDN;
      if (paramObject != null)
      {
        paramObject = paramObject.aWd();
        if (paramObject != null)
        {
          paramObject.c((k)this.kDM);
          AppMethodBeat.o(147915);
          return;
        }
      }
      AppMethodBeat.o(147915);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements d.g.a.a<d.z>
  {
    p(y paramy, com.tencent.mm.plugin.appbrand.page.z paramz, com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements d.g.a.a<d.z>
  {
    q(y paramy, com.tencent.mm.plugin.appbrand.page.z paramz, com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.d
 * JD-Core Version:    0.7.0.1
 */