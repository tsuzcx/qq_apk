package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiReserveChannelsLive;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsBase;", "()V", "invoke", "", "env", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "privateData", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends c
{
  private static final int CTRL_INDEX = 1042;
  private static final String NAME = "reserveChannelsLive";
  public static final a rRP;
  
  static
  {
    AppMethodBeat.i(327907);
    rRP = new a((byte)0);
    AppMethodBeat.o(327907);
  }
  
  private static final void a(f paramf, int paramInt, l paraml, ReserveChannelsLiveResult paramReserveChannelsLiveResult)
  {
    AppMethodBeat.i(327900);
    s.u(paraml, "this$0");
    if (paramReserveChannelsLiveResult == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiReserveChannelsLive", "onReceiveResult#IProcessResultReceiver, result is null");
      AppMethodBeat.o(327900);
      return;
    }
    if (paramReserveChannelsLiveResult.success) {}
    for (paraml = paraml.m("ok", (Map)ak.g(new r[] { v.Y("state", Integer.valueOf(paramReserveChannelsLiveResult.rRT)) }));; paraml = paraml.m(paramReserveChannelsLiveResult, (Map)ak.g(new r[] { v.Y("state", Integer.valueOf(0)) })))
    {
      paramf.callback(paramInt, paraml);
      AppMethodBeat.o(327900);
      return;
      paramReserveChannelsLiveResult = String.format("fail:pre check fail, errCode=%d", Arrays.copyOf(new Object[] { Integer.valueOf(paramReserveChannelsLiveResult.rRT) }, 1));
      s.s(paramReserveChannelsLiveResult, "java.lang.String.format(this, *args)");
    }
  }
  
  public final void a(f paramf, JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt)
  {
    AppMethodBeat.i(327924);
    if (paramf == null)
    {
      AppMethodBeat.o(327924);
      return;
    }
    Context localContext = paramf.getContext();
    if (localContext == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiReserveChannelsLive", "invoke, context is null");
      paramf.callback(paramInt, ZP("fail:internal error invalid android context"));
      AppMethodBeat.o(327924);
      return;
    }
    JSONObject localJSONObject = paramJSONObject1;
    if (paramJSONObject1 == null) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        str1 = paramf.getAppId();
        if (paramJSONObject2 != null) {
          continue;
        }
        paramJSONObject1 = str1;
        Log.i("MicroMsg.AppBrand.JsApiReserveChannelsLive", "invoke, privateData: " + paramJSONObject2 + ", envAppId: " + str1 + ", appId: " + paramJSONObject1);
        localJSONObject.put("appId", paramJSONObject1);
      }
      catch (Exception paramJSONObject1)
      {
        String str1;
        String str2;
        continue;
      }
      Log.i("MicroMsg.AppBrand.JsApiReserveChannelsLive", s.X("invoke, paramsJsonObj: ", localJSONObject));
      paramJSONObject1 = localJSONObject.toString();
      s.s(paramJSONObject1, "paramsJsonObj.toString()");
      a.a(localContext, (AppBrandProxyUIProcessTask.ProcessRequest)new ReserveChannelsLiveRequest(paramJSONObject1), new l..ExternalSyntheticLambda0(paramf, paramInt, this));
      AppMethodBeat.o(327924);
      return;
      str2 = paramJSONObject2.optString("appId", str1);
      paramJSONObject1 = str2;
      if (str2 == null) {
        paramJSONObject1 = str1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiReserveChannelsLive$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_KEY_APP_ID", "PRE_CHECK_ERR_MSG_FORMAT", "RESULT_KEY_STATE", "RESULT_STATE_FAIL", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.l
 * JD-Core Version:    0.7.0.1
 */