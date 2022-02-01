package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.EmptyResult;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsCreateContact;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  private static final int CTRL_INDEX = 985;
  private static final String NAME = "openChannelsCreateContact";
  public static final a rRI;
  
  static
  {
    AppMethodBeat.i(327896);
    rRI = new a((byte)0);
    AppMethodBeat.o(327896);
  }
  
  public e()
  {
    AppMethodBeat.i(327873);
    com.tencent.mm.plugin.appbrand.permission.c.afo("openChannelsCreateContact");
    AppMethodBeat.o(327873);
  }
  
  private static final void b(EmptyResult paramEmptyResult) {}
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(327919);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsCreateContact", "invoke, env is null");
      AppMethodBeat.o(327919);
      return;
    }
    Context localContext = paramf.getContext();
    if (localContext == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsCreateContact", "invoke, context is null");
      paramf.callback(paramInt, ZP("fail:internal error invalid android context"));
      AppMethodBeat.o(327919);
      return;
    }
    if (paramJSONObject == null) {
      paramJSONObject = "";
    }
    for (;;)
    {
      a.a(localContext, (AppBrandProxyUIProcessTask.ProcessRequest)new OpenChannelsCreateContactRequest(paramJSONObject), e..ExternalSyntheticLambda0.INSTANCE);
      paramf.callback(paramInt, ZP("ok"));
      AppMethodBeat.o(327919);
      return;
      String str = paramJSONObject.toString();
      paramJSONObject = str;
      if (str == null) {
        paramJSONObject = "";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsCreateContact$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.e
 * JD-Core Version:    0.7.0.1
 */