package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsLive;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsBase;", "()V", "action", "", "getAction", "()Ljava/lang/String;", "isParamValid", "", "extInfoJsonObj", "Lorg/json/JSONObject;", "overrideErrMsg", "originErrMsg", "errCode", "", "preProcessExtInfo", "isClientErrCode", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends c
{
  private static final int CTRL_INDEX = 968;
  private static final String NAME = "openChannelsLive";
  public static final a oNX;
  
  static
  {
    AppMethodBeat.i(279646);
    oNX = new a((byte)0);
    AppMethodBeat.o(279646);
  }
  
  public final boolean X(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(279640);
    p.k(paramJSONObject, "extInfoJsonObj");
    String str = paramJSONObject.optString("feedId");
    p.j(str, "extInfoJsonObj.optString(PARAM_KEY_FEED_ID)");
    if (((CharSequence)str).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label90;
      }
      paramJSONObject = paramJSONObject.optString("nonceId");
      p.j(paramJSONObject, "extInfoJsonObj.optString(PARAM_KEY_NONCE_ID)");
      if (((CharSequence)paramJSONObject).length() <= 0) {
        break label85;
      }
    }
    label85:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label90;
      }
      AppMethodBeat.o(279640);
      return true;
      i = 0;
      break;
    }
    label90:
    AppMethodBeat.o(279640);
    return false;
  }
  
  public final boolean Y(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(279642);
    p.k(paramJSONObject, "extInfoJsonObj");
    try
    {
      paramJSONObject.put("feedID", paramJSONObject.optString("feedId"));
      paramJSONObject.put("nonceID", paramJSONObject.optString("nonceId"));
      paramJSONObject.put("commentScene", 15);
      bool = true;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.JsApiOpenChannelsLive", "preProcessExtInfo, fail since ".concat(String.valueOf(paramJSONObject)));
        boolean bool = false;
      }
    }
    AppMethodBeat.o(279642);
    return bool;
  }
  
  public final String ch(String paramString, int paramInt)
  {
    AppMethodBeat.i(279644);
    p.k(paramString, "originErrMsg");
    Log.i("MicroMsg.AppBrand.JsApiOpenChannelsLive", "overrideErrMsg, errCode: ".concat(String.valueOf(paramInt)));
    if ((-1000 == paramInt) || (-1001 == paramInt) || (-1002 == paramInt) || (-1003 == paramInt)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = super.ch(paramString, paramInt);
      AppMethodBeat.o(279644);
      return paramString;
    }
    paramString = String.format("fail:pre check fail, errCode=%d", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    p.j(paramString, "java.lang.String.format(this, *args)");
    Log.i("MicroMsg.AppBrand.JsApiOpenChannelsLive", "overrideErrMsg, newErrMsg: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(279644);
    return paramString;
  }
  
  public final String getAction()
  {
    return "openFinderLive";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsLive$Companion;", "", "()V", "ACTION", "", "CTRL_INDEX", "", "NAME", "PARAM_KEY_COMMENT_SCENE", "PARAM_VALUE_COMMENT_SCENE", "PRE_CHECK_ERR_MSG_FORMAT", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.e
 * JD-Core Version:    0.7.0.1
 */