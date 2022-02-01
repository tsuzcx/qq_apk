package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.sdk.b.a.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.n.o;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadLibFilesSync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "()V", "canHandleVarianceExecutable", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "executable", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends ab<d>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "loadLibFiles";
  public static final x.a rXD;
  
  static
  {
    AppMethodBeat.i(329057);
    rXD = new x.a((byte)0);
    AppMethodBeat.o(329057);
  }
  
  public final boolean cpN()
  {
    return true;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<Object, ah>
  {
    b(ICommLibReader paramICommLibReader, o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.x
 * JD-Core Version:    0.7.0.1
 */