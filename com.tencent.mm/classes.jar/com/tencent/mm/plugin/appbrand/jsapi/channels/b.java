package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsActivity;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsCommon;", "()V", "action", "", "getAction", "()Ljava/lang/String;", "preProcessExtInfo", "", "extInfoJsonObj", "Lorg/json/JSONObject;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends d
{
  private static final int CTRL_INDEX = 970;
  private static final String NAME = "openChannelsActivity";
  public static final a rRH;
  
  static
  {
    AppMethodBeat.i(327851);
    rRH = new a((byte)0);
    AppMethodBeat.o(327851);
  }
  
  public final boolean ai(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(327865);
    s.u(paramJSONObject, "extInfoJsonObj");
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
        Log.w("MicroMsg.AppBrand.JsApiOpenChannelsActivity", s.X("preProcessExtInfo, fail since ", paramJSONObject));
        boolean bool = false;
      }
    }
    AppMethodBeat.o(327865);
    return bool;
  }
  
  public final String getAction()
  {
    return "openFinderFeed";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsActivity$Companion;", "", "()V", "ACTION", "", "CTRL_INDEX", "", "NAME", "PARAM_KEY_SHARE_SCENE", "PARAM_VALUE_SHARE_SCENE", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.b
 * JD-Core Version:    0.7.0.1
 */