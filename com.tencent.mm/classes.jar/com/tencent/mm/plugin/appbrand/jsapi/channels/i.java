package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsRewardedVideoAd;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends c<f>
{
  private static final int CTRL_INDEX = 1001;
  private static final String NAME = "openChannelsRewardedVideoAd";
  public static final a rRM;
  
  static
  {
    AppMethodBeat.i(327887);
    rRM = new a((byte)0);
    AppMethodBeat.o(327887);
  }
  
  private static final void a(f paramf, int paramInt, i parami, OpenChannelsRewardedVideoAdResult paramOpenChannelsRewardedVideoAdResult)
  {
    AppMethodBeat.i(327880);
    s.u(parami, "this$0");
    if (paramOpenChannelsRewardedVideoAdResult == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", "onReceiveResult#IProcessResultReceiver, result is null");
      AppMethodBeat.o(327880);
      return;
    }
    int i = paramOpenChannelsRewardedVideoAdResult.errCode;
    bzh localbzh = paramOpenChannelsRewardedVideoAdResult.rRS;
    Log.i("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", s.X("onReceiveResult#IProcessResultReceiver, errCode: ", Integer.valueOf(i)));
    if (i != 0)
    {
      paramf.callback(paramInt, parami.ZP("fail:internal error"));
      AppMethodBeat.o(327880);
      return;
    }
    if (localbzh == null) {}
    for (paramOpenChannelsRewardedVideoAdResult = null; paramOpenChannelsRewardedVideoAdResult == null; paramOpenChannelsRewardedVideoAdResult = localbzh.aaiy)
    {
      Log.i("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", "onReceiveResult#IProcessResultReceiver, feedbackInfo is null");
      paramf.callback(paramInt, parami.ZP("ok"));
      AppMethodBeat.o(327880);
      return;
    }
    try
    {
      paramOpenChannelsRewardedVideoAdResult = new JSONArray(localbzh.aaiy);
      if (paramOpenChannelsRewardedVideoAdResult == null)
      {
        paramf.callback(paramInt, parami.ZP("ok"));
        AppMethodBeat.o(327880);
        return;
      }
    }
    catch (Exception paramOpenChannelsRewardedVideoAdResult)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", s.X("onReceiveResult#IProcessResultReceiver, parse feedbackInfo fail since ", paramOpenChannelsRewardedVideoAdResult));
        paramOpenChannelsRewardedVideoAdResult = null;
      }
      paramf.callback(paramInt, parami.m("ok", (Map)ak.g(new r[] { v.Y("rewardedDuration", Integer.valueOf(localbzh.aaix)), v.Y("feedbackInfo", paramOpenChannelsRewardedVideoAdResult) })));
      AppMethodBeat.o(327880);
    }
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(327902);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", "invoke, env is null");
      AppMethodBeat.o(327902);
      return;
    }
    if (paramf.getContext() == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", "invoke, context is null");
      paramf.callback(paramInt, ZP("fail:internal error invalid android context"));
      AppMethodBeat.o(327902);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", "invoke, data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(327902);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("action", "openChannelsRewardedVideoAd");
      localJSONObject.put("extInfo", paramJSONObject);
      paramJSONObject = localJSONObject.toString();
      s.s(paramJSONObject, "openChannelsParamsJsonObj.toString()");
      a.a(paramf.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)new OpenChannelsRewardedVideoAdRequest(paramJSONObject), new i..ExternalSyntheticLambda0(paramf, paramInt, this));
      AppMethodBeat.o(327902);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsRewardedVideoAd", s.X("invoke, put fail since ", paramJSONObject));
      paramf.callback(paramInt, ZP("fail:internal error"));
      AppMethodBeat.o(327902);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsRewardedVideoAd$Companion;", "", "()V", "ACTION", "", "CTRL_INDEX", "", "NAME", "PARAM_KEY_ACTION", "PARAM_KEY_EXT_INFO", "RESULT_KEY_FEEDBACK_INFO", "RESULT_KEY_REWARDED_DURATION", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.i
 * JD-Core Version:    0.7.0.1
 */