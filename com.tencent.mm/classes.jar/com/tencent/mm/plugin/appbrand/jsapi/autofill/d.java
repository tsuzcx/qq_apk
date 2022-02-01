package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.v;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import com.tencent.mm.plugin.appbrand.widget.dialog.g;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "getLocalPhoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getServePhoneItems", "Lcom/tencent/mm/vending/tuple/Tuple2;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "env", "apiName", "", "withCredentials", "", "localPhoneItems", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "invoke", "", "data", "Lorg/json/JSONObject;", "callbackId", "", "jumpToBindWxPhoneIfNeed", "tuple2", "needBindWxPhone", "phoneItems", "showPhoneNumberDialog", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "it", "progressDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandProgressDialog;", "dialog", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "showProgressDialog", "", "Companion", "Info", "luggage-wechat-full-sdk_release"})
@TargetApi(8)
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.a<aa>
{
  private static final int CTRL_INDEX = 209;
  private static final String NAME = "getPhoneNumber";
  public static final a kfE;
  
  static
  {
    AppMethodBeat.i(147931);
    kfE = new a((byte)0);
    NAME = "getPhoneNumber";
    CTRL_INDEX = 209;
    AppMethodBeat.o(147931);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "NAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "", "scopeInfo", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "alertPrivacyInfo", "Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "(Lcom/tencent/mm/protocal/protobuf/ScopeInfo;Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;)V", "getAlertPrivacyInfo", "()Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "getScopeInfo", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "luggage-wechat-full-sdk_release"})
  public static final class b
  {
    final csf kfF;
    final dn kfG;
    
    public b(csf paramcsf, dn paramdn)
    {
      this.kfF = paramcsf;
      this.kfG = paramdn;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(147904);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!d.g.b.k.g(this.kfF, paramObject.kfF)) || (!d.g.b.k.g(this.kfG, paramObject.kfG))) {}
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
      Object localObject = this.kfF;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.kfG;
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
      String str = "Info(scopeInfo=" + this.kfF + ", alertPrivacyInfo=" + this.kfG + ")";
      AppMethodBeat.o(147902);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "isSuccess", "", "errMsg", "", "phoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "info", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.r<Boolean, String, List<? extends PhoneItem>, d.b, d.y>
  {
    c(com.tencent.mm.vending.g.b paramb, List paramList)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(d paramd, g paramg, aa paramaa) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "it", "", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(d paramd) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "localPhoneItems", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(d paramd, aa paramaa, String paramString, boolean paramBoolean) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "it", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(d paramd, aa paramaa, String paramString, boolean paramBoolean) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "it", "call"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public static final h kfN;
    
    static
    {
      AppMethodBeat.i(147911);
      kfN = new h();
      AppMethodBeat.o(147911);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "it", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "call"})
  static final class i<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    i(d paramd, aa paramaa, g paramg, v paramv) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "kotlin.jvm.PlatformType", "onTerminate"})
  static final class j<T>
    implements com.tencent.mm.vending.g.d.b<m.a>
  {
    j(d paramd, aa paramaa, int paramInt) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "res", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class k<T>
    implements com.tencent.mm.vending.g.d.a<Object>
  {
    k(d paramd, aa paramaa, int paramInt) {}
    
    public final void cc(Object paramObject)
    {
      AppMethodBeat.i(147914);
      Object localObject1 = z.lLJ;
      Object localObject2 = this.kfK.getAppId();
      d.g.b.k.g(localObject2, "env.appId");
      localObject1 = ((z)localObject1).Qu((String)localObject2);
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.appbrand.phonenumber.y)localObject1).report();
      }
      localObject2 = z.lLJ;
      localObject1 = this.kfK;
      if (localObject1 != null) {}
      for (localObject1 = ((aa)localObject1).getAppId();; localObject1 = null)
      {
        d.g.b.k.g(localObject1, "env?.appId");
        ((z)localObject2).Qv((String)localObject1);
        if (!(paramObject instanceof String)) {
          break label137;
        }
        ac.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:".concat(String.valueOf(paramObject)));
        localObject1 = this.kfK;
        if (localObject1 == null) {
          break;
        }
        ((aa)localObject1).h(this.jXx, this.kfI.LM("fail:".concat(String.valueOf(paramObject))));
        AppMethodBeat.o(147914);
        return;
      }
      AppMethodBeat.o(147914);
      return;
      label137:
      if ((paramObject instanceof Exception))
      {
        ac.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:{" + paramObject + ".message}");
        localObject1 = this.kfK;
        if (localObject1 != null)
        {
          ((aa)localObject1).h(this.jXx, this.kfI.LM("fail:{" + paramObject + ".message}"));
          AppMethodBeat.o(147914);
          return;
        }
        AppMethodBeat.o(147914);
        return;
      }
      ac.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail");
      paramObject = this.kfK;
      if (paramObject != null)
      {
        paramObject.h(this.jXx, this.kfI.LM("fail"));
        AppMethodBeat.o(147914);
        return;
      }
      AppMethodBeat.o(147914);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class l<T>
    implements com.tencent.mm.vending.g.d.a<Object>
  {
    l(aa paramaa, g paramg) {}
    
    public final void cc(Object paramObject)
    {
      AppMethodBeat.i(147915);
      paramObject = this.kfK;
      if (paramObject != null)
      {
        paramObject = paramObject.aSs();
        if (paramObject != null)
        {
          paramObject.c((com.tencent.mm.plugin.appbrand.widget.dialog.k)this.kfJ);
          AppMethodBeat.o(147915);
          return;
        }
      }
      AppMethodBeat.o(147915);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.b<Integer, d.y>
  {
    m(com.tencent.mm.plugin.appbrand.phonenumber.y paramy, aa paramaa, String paramString, boolean paramBoolean, com.tencent.mm.vending.g.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    n(com.tencent.mm.plugin.appbrand.phonenumber.y paramy, com.tencent.mm.vending.g.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    o(com.tencent.mm.plugin.appbrand.phonenumber.y paramy, com.tencent.mm.vending.g.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class p
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    p(com.tencent.mm.plugin.appbrand.phonenumber.y paramy, aa paramaa, v paramv)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    q(com.tencent.mm.plugin.appbrand.phonenumber.y paramy, aa paramaa, v paramv)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "invoke"})
  static final class r
    extends d.g.b.l
    implements d.g.a.b<PhoneItem, d.y>
  {
    r(com.tencent.mm.plugin.appbrand.phonenumber.y paramy, aa paramaa, d.b paramb, com.tencent.mm.vending.g.b paramb1)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "isSuccess", "", "result", "", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$showPhoneNumberDialog$5$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.m<Boolean, Map<String, ? extends String>, d.y>
    {
      a(d.r paramr, PhoneItem paramPhoneItem)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    s(com.tencent.mm.plugin.appbrand.phonenumber.y paramy, aa paramaa, d.b paramb, v paramv)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class t
    implements DialogInterface.OnCancelListener
  {
    t(com.tencent.mm.vending.g.b paramb) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(147929);
      this.kdr.eb("user cancel");
      AppMethodBeat.o(147929);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.d
 * JD-Core Version:    0.7.0.1
 */