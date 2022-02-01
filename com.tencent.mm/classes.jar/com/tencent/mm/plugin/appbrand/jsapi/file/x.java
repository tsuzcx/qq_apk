package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.m.o;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadLibFilesSync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "()V", "canHandleVarianceExecutable", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "executable", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "Companion", "luggage-wechat-full-sdk_release"})
public final class x
  extends aa<d>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "loadLibFiles";
  public static final x.a oSh;
  
  static
  {
    AppMethodBeat.i(251023);
    oSh = new x.a((byte)0);
    AppMethodBeat.o(251023);
  }
  
  public final boolean bPG()
  {
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadLibFilesSync$invoke$1$1"})
  static final class b
    extends q
    implements b<Object, kotlin.x>
  {
    b(x paramx, ICommLibReader paramICommLibReader, o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.x
 * JD-Core Version:    0.7.0.1
 */