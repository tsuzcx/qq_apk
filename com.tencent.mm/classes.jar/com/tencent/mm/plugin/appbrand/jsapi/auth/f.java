package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ConstantsAppBrandJsApiMsg;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthConstants;", "Lcom/tencent/mm/wxaprotocol/ConstantsWxaProtocol;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "getWindowAndroid", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;)Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "setUserInfoListData", "", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "userNickName", "", "scope", "dialog", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "bridge", "_Var", "Lcom/tencent/mm/vending/pipeline/Mario;", "pipeable", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "fill", "Lcom/tencent/mm/protocal/protobuf/WxaExternalInfo;", "service", "notNullContext", "runCgi", "R", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "url", "request", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "clazz", "Ljava/lang/Class;", "toByteString", "Lcom/tencent/mm/protobuf/ByteString;", "ApiInvokeInterruptCallbackException", "ComponentInterruptedException", "luggage-wechat-full-sdk_release"})
public abstract interface f
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper$ComponentInterruptedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "luggage-wechat-full-sdk_release"})
  public static final class b
    extends Exception
  {
    public static final b oAZ;
    
    static
    {
      AppMethodBeat.i(169557);
      oAZ = new b();
      AppMethodBeat.o(169557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.f
 * JD-Core Version:    0.7.0.1
 */