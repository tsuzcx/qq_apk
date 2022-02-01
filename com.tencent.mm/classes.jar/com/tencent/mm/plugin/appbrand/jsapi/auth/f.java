package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.g;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ConstantsAppBrandJsApiMsg;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthConstants;", "Lcom/tencent/mm/wxaprotocol/ConstantsWxaProtocol;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "getWindowAndroid", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;)Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "setUserInfoListData", "", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "userNickName", "", "scope", "dialog", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "bridge", "_Var", "Lcom/tencent/mm/vending/pipeline/Mario;", "pipeable", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "fill", "Lcom/tencent/mm/protocal/protobuf/WxaExternalInfo;", "service", "notNullContext", "runCgi", "R", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "url", "request", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "clazz", "Ljava/lang/Class;", "toByteString", "Lcom/tencent/mm/protobuf/ByteString;", "ApiInvokeInterruptCallbackException", "ComponentInterruptedException", "luggage-wechat-full-sdk_release"})
public abstract interface f
{
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper$ComponentInterruptedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "luggage-wechat-full-sdk_release"})
  public static final class b
    extends Exception
  {
    public static final b kBg;
    
    static
    {
      AppMethodBeat.i(169557);
      kBg = new b();
      AppMethodBeat.o(169557);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "_Var", "it", "kotlin.jvm.PlatformType", "onTerminate", "(Ljava/lang/Object;)V"})
  static final class c$a<T>
    implements d.b<_Var>
  {
    c$a(b paramb) {}
    
    public final void bq(_Var param_Var)
    {
      AppMethodBeat.i(169564);
      g.a(this.kBh, new Object[] { param_Var });
      AppMethodBeat.o(169564);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "_Var", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class c$b<T>
    implements d.a<Object>
  {
    c$b(b paramb) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(169565);
      this.kBh.ef(paramObject);
      AppMethodBeat.o(169565);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.f
 * JD-Core Version:    0.7.0.1
 */