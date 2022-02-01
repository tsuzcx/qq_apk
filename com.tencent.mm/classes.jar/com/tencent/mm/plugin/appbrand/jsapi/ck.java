package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiPredownloadMiniProgramPackage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class ck
  extends d<com.tencent.mm.plugin.appbrand.d>
{
  public static final int CTRL_INDEX = 678;
  public static final String NAME = "predownloadMiniProgramPackage";
  @Deprecated
  public static final a lBt;
  
  static
  {
    AppMethodBeat.i(50409);
    lBt = new a((byte)0);
    AppMethodBeat.o(50409);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiPredownloadMiniProgramPackage$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(ck paramck, com.tencent.mm.plugin.appbrand.d paramd, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class c<T>
    implements com.tencent.mm.ipcinvoker.d<ResultType>
  {
    c(ck paramck, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ck
 * JD-Core Version:    0.7.0.1
 */