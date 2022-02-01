package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiRecordOperateUserDataInWa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cs
  extends c<f>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final a rAq;
  
  static
  {
    AppMethodBeat.i(325469);
    rAq = new a((byte)0);
    NAME = "recordOperateUserDataInWa";
    CTRL_INDEX = 1088;
    AppMethodBeat.o(325469);
  }
  
  private static final void h(IPCString paramIPCString, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(325462);
    Log.i("MicroMsg.AppBrand.JsApiRecordOperateUserDataInWa", s.X("ipc invoke. data:", paramIPCString));
    try
    {
      com.tencent.luggage.sdk.h.c.a((JSONArray)new com.tencent.mm.ad.f(paramIPCString.value), (b)b.rAr);
      AppMethodBeat.o(325462);
      return;
    }
    catch (Exception paramIPCString)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.JsApiRecordOperateUserDataInWa", (Throwable)paramIPCString, null, new Object[0]);
      AppMethodBeat.o(325462);
    }
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(325481);
    Log.i("MicroMsg.AppBrand.JsApiRecordOperateUserDataInWa", s.X("invoke data ", paramJSONObject));
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.getString("datalist");
      if (paramJSONObject != null) {
        a.a(new IPCString(paramJSONObject), (d)cs..ExternalSyntheticLambda0.INSTANCE, null);
      }
    }
    if (paramf != null) {
      paramf.callback(paramInt, ZP("ok"));
    }
    AppMethodBeat.o(325481);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiRecordOperateUserDataInWa$Companion;", "", "()V", "CTRL_INDEX", "", "getCTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "getNAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lorg/json/JSONObject;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<JSONObject, ah>
  {
    public static final b rAr;
    
    static
    {
      AppMethodBeat.i(325822);
      rAr = new b();
      AppMethodBeat.o(325822);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cs
 * JD-Core Version:    0.7.0.1
 */