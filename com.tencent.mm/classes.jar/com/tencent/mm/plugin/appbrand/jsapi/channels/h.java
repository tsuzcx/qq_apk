package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.EmptyResult;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsPostPage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends c<f>
{
  private static final int CTRL_INDEX = 984;
  private static final String NAME = "openChannelsPostPage";
  public static final a rRL;
  
  static
  {
    AppMethodBeat.i(327874);
    rRL = new a((byte)0);
    AppMethodBeat.o(327874);
  }
  
  private static final void b(EmptyResult paramEmptyResult) {}
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(327889);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsPostPage", "invoke, env is null");
      AppMethodBeat.o(327889);
      return;
    }
    paramJSONObject = paramf.getContext();
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsPostPage", "invoke, context is null");
      paramf.callback(paramInt, ZP("fail:internal error invalid android context"));
      AppMethodBeat.o(327889);
      return;
    }
    a.a(paramJSONObject, (AppBrandProxyUIProcessTask.ProcessRequest)new OpenChannelsPostPageRequest(), h..ExternalSyntheticLambda0.INSTANCE);
    paramf.callback(paramInt, ZP("ok"));
    AppMethodBeat.o(327889);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsPostPage$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.h
 * JD-Core Version:    0.7.0.1
 */