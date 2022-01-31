package com.tencent.mm.plugin.appbrand.jsapi.a;

import a.f.b.j;
import a.l;
import android.annotation.TargetApi;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bn;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetPhoneNumberNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "getLocalPhoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getServePhoneItems", "Lcom/tencent/mm/vending/tuple/Tuple2;", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "env", "apiName", "", "withCredentials", "", "localPhoneItems", "report", "Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "invoke", "", "data", "Lorg/json/JSONObject;", "callbackId", "", "jumpToBindWxPhoneIfNeed", "tuple2", "needBindWxPhone", "phoneItems", "showPhoneNumberDialog", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "it", "progressDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandProgressDialog;", "dialog", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "context", "Landroid/content/Context;", "showProgressDialog", "", "Companion", "plugin-appbrand-integration_release"})
@TargetApi(8)
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.a<v>
{
  private static final int CTRL_INDEX = 209;
  private static final String NAME = "getPhoneNumber";
  public static final c.a hEg;
  
  static
  {
    AppMethodBeat.i(134663);
    hEg = new c.a((byte)0);
    NAME = "getPhoneNumber";
    CTRL_INDEX = 209;
    AppMethodBeat.o(134663);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "kotlin.jvm.PlatformType", "onTerminate"})
  static final class i<T>
    implements d.b<m.a>
  {
    i(c paramc, v paramv, int paramInt) {}
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "res", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class j<T>
    implements d.a<Object>
  {
    j(c paramc, v paramv, int paramInt) {}
    
    public final void aX(Object paramObject)
    {
      AppMethodBeat.i(143755);
      Object localObject1 = b.a.a.a.a.a.a.a.a.CKU;
      Object localObject2 = this.hEl.getAppId();
      j.p(localObject2, "env.appId");
      localObject1 = ((b.a.a.a.a.a.a.a.a)localObject1).azy((String)localObject2);
      if (localObject1 != null) {
        ((bn)localObject1).ake();
      }
      localObject2 = b.a.a.a.a.a.a.a.a.CKU;
      localObject1 = this.hEl;
      if (localObject1 != null) {}
      for (localObject1 = ((v)localObject1).getAppId();; localObject1 = null)
      {
        j.p(localObject1, "env?.appId");
        ((b.a.a.a.a.a.a.a.a)localObject2).azz((String)localObject1);
        if (!(paramObject instanceof String)) {
          break label138;
        }
        d.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:".concat(String.valueOf(paramObject)));
        localObject1 = this.hEl;
        if (localObject1 == null) {
          break;
        }
        ((v)localObject1).h(this.hAB, this.hEj.BL("fail:".concat(String.valueOf(paramObject))));
        AppMethodBeat.o(143755);
        return;
      }
      AppMethodBeat.o(143755);
      return;
      label138:
      if ((paramObject instanceof Exception))
      {
        d.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:{" + paramObject + ".message}");
        localObject1 = this.hEl;
        if (localObject1 != null)
        {
          ((v)localObject1).h(this.hAB, this.hEj.BL("fail:{" + paramObject + ".message}"));
          AppMethodBeat.o(143755);
          return;
        }
        AppMethodBeat.o(143755);
        return;
      }
      d.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail");
      paramObject = this.hEl;
      if (paramObject != null)
      {
        paramObject.h(this.hAB, this.hEj.BL("fail"));
        AppMethodBeat.o(143755);
        return;
      }
      AppMethodBeat.o(143755);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c
 * JD-Core Version:    0.7.0.1
 */