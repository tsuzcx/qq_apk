package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.vending.g.d.b;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiVerifyPlugin;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class ci
  extends a<com.tencent.mm.plugin.appbrand.q>
{
  public static final int CTRL_INDEX = 313;
  public static final String NAME = "verifyPlugin";
  @Deprecated
  public static final a kuQ;
  
  static
  {
    AppMethodBeat.i(147901);
    kuQ = new a((byte)0);
    AppMethodBeat.o(147901);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiVerifyPlugin$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wechat-full-sdk_release"})
  static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(ci paramci, String paramString, com.tencent.mm.plugin.appbrand.q paramq, int paramInt)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "response", "Lcom/tencent/mm/protocal/protobuf/VerifyPluginResponse;", "kotlin.jvm.PlatformType", "onTerminate"})
  static final class c<T>
    implements d.b<dus>
  {
    c(ci paramci, String paramString, com.tencent.mm.plugin.appbrand.q paramq, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ci
 * JD-Core Version:    0.7.0.1
 */