package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.protocal.protobuf.epr;
import com.tencent.mm.vending.g.d.b;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiVerifyPlugin;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class cw
  extends d<s>
{
  public static final int CTRL_INDEX = 313;
  public static final String NAME = "verifyPlugin";
  @Deprecated
  public static final cw.a lCt;
  
  static
  {
    AppMethodBeat.i(147901);
    lCt = new cw.a((byte)0);
    AppMethodBeat.o(147901);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(cw paramcw, String paramString, s params, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "response", "Lcom/tencent/mm/protocal/protobuf/VerifyPluginResponse;", "kotlin.jvm.PlatformType", "onTerminate"})
  static final class c<T>
    implements d.b<epr>
  {
    c(cw paramcw, String paramString, s params, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cw
 * JD-Core Version:    0.7.0.1
 */