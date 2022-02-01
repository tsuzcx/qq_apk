package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsActivity;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsBase;", "()V", "action", "", "getAction", "()Ljava/lang/String;", "isParamValid", "", "extInfoJsonObj", "Lorg/json/JSONObject;", "preProcessExtInfo", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends c
{
  private static final int CTRL_INDEX = 970;
  private static final String NAME = "openChannelsActivity";
  public static final a oNS;
  
  static
  {
    AppMethodBeat.i(269870);
    oNS = new a((byte)0);
    AppMethodBeat.o(269870);
  }
  
  public final boolean X(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(269865);
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
      AppMethodBeat.o(269865);
      return true;
      i = 0;
      break;
    }
    label90:
    AppMethodBeat.o(269865);
    return false;
  }
  
  public final boolean Y(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(269867);
    p.k(paramJSONObject, "extInfoJsonObj");
    try
    {
      paramJSONObject.put("feedID", paramJSONObject.optString("feedId"));
      paramJSONObject.put("nonceID", paramJSONObject.optString("nonceId"));
      paramJSONObject.put("shareScene", 18);
      bool = true;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.JsApiOpenChannelsActivity", "preProcessExtInfo, fail since ".concat(String.valueOf(paramJSONObject)));
        boolean bool = false;
      }
    }
    AppMethodBeat.o(269867);
    return bool;
  }
  
  public final String getAction()
  {
    return "openFinderFeed";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsActivity$Companion;", "", "()V", "ACTION", "", "CTRL_INDEX", "", "NAME", "PARAM_KEY_SHARE_SCENE", "PARAM_VALUE_SHARE_SCENE", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.b
 * JD-Core Version:    0.7.0.1
 */