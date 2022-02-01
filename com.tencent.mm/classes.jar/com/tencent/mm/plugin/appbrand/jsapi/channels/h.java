package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsUserProfile;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsBase;", "()V", "action", "", "getAction", "()Ljava/lang/String;", "preProcessExtInfo", "", "extInfoJsonObj", "Lorg/json/JSONObject;", "Companion", "plugin-appbrand-integration_release"})
public final class h
  extends c
{
  private static final int CTRL_INDEX = 969;
  private static final String NAME = "openChannelsUserProfile";
  public static final a oOc;
  
  static
  {
    AppMethodBeat.i(269071);
    oOc = new a((byte)0);
    AppMethodBeat.o(269071);
  }
  
  public final boolean Y(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(269070);
    p.k(paramJSONObject, "extInfoJsonObj");
    try
    {
      paramJSONObject.put("commentScene", 15);
      bool = true;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.JsApiOpenChannelsUserProfile", "preProcessExtInfo, fail since ".concat(String.valueOf(paramJSONObject)));
        boolean bool = false;
      }
    }
    AppMethodBeat.o(269070);
    return bool;
  }
  
  public final String getAction()
  {
    return "openFinderProfile";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsUserProfile$Companion;", "", "()V", "ACTION", "", "CTRL_INDEX", "", "NAME", "PARAM_KEY_COMMENT_SCENE", "PARAM_VALUE_COMMENT_SCENE", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.h
 * JD-Core Version:    0.7.0.1
 */