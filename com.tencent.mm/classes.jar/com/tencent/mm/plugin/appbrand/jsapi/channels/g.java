package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.ipc.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsLiveCollection;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends c<f>
{
  private static final int CTRL_INDEX = 1044;
  private static final String NAME = "openChannelsLiveCollection";
  public static final a rRK;
  
  static
  {
    AppMethodBeat.i(327864);
    rRK = new a((byte)0);
    AppMethodBeat.o(327864);
  }
  
  private static final void a(f paramf, int paramInt, g paramg, OpenChannelsLiveCollectionResult paramOpenChannelsLiveCollectionResult)
  {
    AppMethodBeat.i(327858);
    s.u(paramg, "this$0");
    if (paramOpenChannelsLiveCollectionResult == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsLiveCollection", "onReceiveResult#IProcessResultReceiver, result is null");
      AppMethodBeat.o(327858);
      return;
    }
    int i = paramOpenChannelsLiveCollectionResult.errCode;
    Log.i("MicroMsg.AppBrand.JsApiOpenChannelsLiveCollection", s.X("onReceiveResult#IProcessResultReceiver, errCode: ", Integer.valueOf(i)));
    if (i == 0) {}
    for (paramg = paramg.ZP("ok");; paramg = paramg.ZP("fail:internal error"))
    {
      paramf.callback(paramInt, paramg);
      AppMethodBeat.o(327858);
      return;
    }
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(327879);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsLiveCollection", "invoke, env is null");
      AppMethodBeat.o(327879);
      return;
    }
    Context localContext = paramf.getContext();
    if (localContext == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsLiveCollection", "invoke, context is null");
      paramf.callback(paramInt, ZP("fail:internal error invalid android context"));
      AppMethodBeat.o(327879);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsLiveCollection", "invoke, data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(327879);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("action", "openFinderMultiMoreLive");
      localJSONObject.put("extInfo", paramJSONObject);
      paramJSONObject = localJSONObject.toString();
      s.s(paramJSONObject, "openChannelsParamsJsonObj.toString()");
      a.a(localContext, (AppBrandProxyUIProcessTask.ProcessRequest)new OpenChannelsLiveCollectionRequest(paramJSONObject), new g..ExternalSyntheticLambda0(paramf, paramInt, this), b.eD(localContext));
      AppMethodBeat.o(327879);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsLiveCollection", s.X("invoke, put fail since ", paramJSONObject));
      paramf.callback(paramInt, ZP("fail:internal error"));
      AppMethodBeat.o(327879);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsLiveCollection$Companion;", "", "()V", "ACTION", "", "CTRL_INDEX", "", "NAME", "PARAM_KEY_ACTION", "PARAM_KEY_EXT_INFO", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.g
 * JD-Core Version:    0.7.0.1
 */