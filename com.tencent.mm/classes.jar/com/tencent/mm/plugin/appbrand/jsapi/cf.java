package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.protocal.protobuf.djm;
import com.tencent.mm.vending.g.d.b;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiVerifyPlugin;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class cf
  extends a<q>
{
  public static final int CTRL_INDEX = 313;
  public static final String NAME = "verifyPlugin";
  @Deprecated
  public static final a jzY;
  
  static
  {
    AppMethodBeat.i(147901);
    jzY = new a((byte)0);
    AppMethodBeat.o(147901);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiVerifyPlugin$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wechat-full-sdk_release"})
  static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(cf paramcf, String paramString, q paramq, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "response", "Lcom/tencent/mm/protocal/protobuf/VerifyPluginResponse;", "kotlin.jvm.PlatformType", "onTerminate"})
  static final class c<T>
    implements d.b<djm>
  {
    c(cf paramcf, String paramString, q paramq, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cf
 * JD-Core Version:    0.7.0.1
 */