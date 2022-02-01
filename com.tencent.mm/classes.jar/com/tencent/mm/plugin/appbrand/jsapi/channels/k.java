package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsUserProfile;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsCommon;", "()V", "action", "", "getAction", "()Ljava/lang/String;", "preProcessExtInfo", "", "extInfoJsonObj", "Lorg/json/JSONObject;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends d
{
  private static final int CTRL_INDEX = 969;
  private static final String NAME = "openChannelsUserProfile";
  public static final a rRO;
  
  static
  {
    AppMethodBeat.i(327862);
    rRO = new a((byte)0);
    AppMethodBeat.o(327862);
  }
  
  public final boolean ai(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(327872);
    s.u(paramJSONObject, "extInfoJsonObj");
    try
    {
      paramJSONObject.put("commentScene", 15);
      bool = true;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.JsApiOpenChannelsUserProfile", s.X("preProcessExtInfo, fail since ", paramJSONObject));
        boolean bool = false;
      }
    }
    AppMethodBeat.o(327872);
    return bool;
  }
  
  public final String getAction()
  {
    return "openFinderProfile";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsUserProfile$Companion;", "", "()V", "ACTION", "", "CTRL_INDEX", "", "NAME", "PARAM_KEY_COMMENT_SCENE", "PARAM_VALUE_COMMENT_SCENE", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.k
 * JD-Core Version:    0.7.0.1
 */