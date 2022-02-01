package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsCommon;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsBase;", "()V", "action", "", "getAction", "()Ljava/lang/String;", "invoke", "", "env", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "privateData", "callbackId", "", "overrideErrMsg", "originErrMsg", "errCode", "preProcessExtInfo", "", "extInfoJsonObj", "provideOpenExtra", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
  extends c
{
  public d()
  {
    com.tencent.mm.plugin.appbrand.permission.c.afo(getName());
  }
  
  private static final void a(f paramf, int paramInt, d paramd, EnterFinderResult paramEnterFinderResult)
  {
    s.u(paramd, "this$0");
    if (paramEnterFinderResult == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsCommon", "onReceiveResult#IProcessResultReceiver, result is null");
      return;
    }
    int i = paramEnterFinderResult.errCode;
    Log.i("MicroMsg.AppBrand.JsApiOpenChannelsCommon", s.X("onReceiveResult#IProcessResultReceiver, errCode: ", Integer.valueOf(i)));
    if (i == 0) {}
    for (paramd = paramd.ZP("ok");; paramd = paramd.ZP(paramd.cF("fail:internal error", i)))
    {
      paramf.callback(paramInt, paramd);
      return;
    }
  }
  
  public final void a(f paramf, JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt)
  {
    if (paramf == null) {
      return;
    }
    Context localContext = paramf.getContext();
    if (localContext == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsCommon", "invoke, context is null");
      paramf.callback(paramInt, ZP("fail:internal error invalid android context"));
      return;
    }
    Log.i("MicroMsg.AppBrand.JsApiOpenChannelsCommon", s.X("invoke, data: ", paramJSONObject1));
    JSONObject localJSONObject = paramJSONObject1;
    if (paramJSONObject1 == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("action", getAction());
      String str1 = paramf.getAppId();
      if (paramJSONObject2 == null) {
        paramJSONObject1 = str1;
      }
      for (;;)
      {
        Log.i("MicroMsg.AppBrand.JsApiOpenChannelsCommon", "invoke, privateData: " + paramJSONObject2 + ", envAppId: " + str1 + ", appId: " + paramJSONObject1);
        localJSONObject.put("sourceId", paramJSONObject1);
        paramJSONObject1 = new JSONObject();
        paramJSONObject1.put("appid", paramf.getAppId());
        if (localJSONObject.has("reportExtraInfo")) {
          paramJSONObject1.put("passthrough", localJSONObject.opt("reportExtraInfo"));
        }
        paramJSONObject2 = new JSONObject();
        paramJSONObject2.put("weapp_info", paramJSONObject1);
        Log.i("MicroMsg.AppBrand.JsApiOpenChannelsCommon", s.X("invoke, reportExtInfo: ", paramJSONObject2));
        localJSONObject.put("reportExtraInfo", paramJSONObject2);
        if (ai(localJSONObject)) {
          break;
        }
        Log.w("MicroMsg.AppBrand.JsApiOpenChannelsCommon", "invoke, preProcessExtInfo fail");
        paramf.callback(paramInt, ZP("fail:internal error"));
        return;
        String str2 = paramJSONObject2.optString("appId", str1);
        paramJSONObject1 = str2;
        if (str2 == null) {
          paramJSONObject1 = str1;
        }
      }
      paramJSONObject1 = new JSONObject();
    }
    catch (Exception paramJSONObject1)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsCommon", s.X("invoke, put fail since ", paramJSONObject1));
      paramf.callback(paramInt, ZP("fail:internal error"));
      return;
    }
    try
    {
      paramJSONObject1.put("extInfo", localJSONObject);
      paramJSONObject1 = paramJSONObject1.toString();
      s.s(paramJSONObject1, "extInfoWrapperJsonObj.toString()");
      a.a(localContext, (AppBrandProxyUIProcessTask.ProcessRequest)new EnterFinderRequest(paramJSONObject1), new d..ExternalSyntheticLambda0(paramf, paramInt, this), eH(localContext));
      return;
    }
    catch (Exception paramJSONObject1)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsCommon", s.X("invoke, put extInfo fail since ", paramJSONObject1));
      paramf.callback(paramInt, ZP("fail:internal error"));
    }
  }
  
  public boolean ai(JSONObject paramJSONObject)
  {
    s.u(paramJSONObject, "extInfoJsonObj");
    return true;
  }
  
  public String cF(String paramString, int paramInt)
  {
    s.u(paramString, "originErrMsg");
    return paramString;
  }
  
  public Intent eH(Context paramContext)
  {
    s.u(paramContext, "context");
    return null;
  }
  
  public abstract String getAction();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.d
 * JD-Core Version:    0.7.0.1
 */