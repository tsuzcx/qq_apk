package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsLive;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsCommon;", "()V", "action", "", "getAction", "()Ljava/lang/String;", "overrideErrMsg", "originErrMsg", "errCode", "", "preProcessExtInfo", "", "extInfoJsonObj", "Lorg/json/JSONObject;", "provideOpenExtra", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "isClientErrCode", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends d
{
  private static final int CTRL_INDEX = 968;
  private static final String NAME = "openChannelsLive";
  public static final a rRJ;
  
  static
  {
    AppMethodBeat.i(327854);
    rRJ = new a((byte)0);
    AppMethodBeat.o(327854);
  }
  
  public final boolean ai(JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(327868);
    s.u(paramJSONObject, "extInfoJsonObj");
    try
    {
      paramJSONObject.put("feedID", paramJSONObject.optString("feedId"));
      paramJSONObject.put("nonceID", paramJSONObject.optString("nonceId"));
      paramJSONObject.put("showRecommend", paramJSONObject.optBoolean("showRecommend", false));
      paramJSONObject.put("commentScene", 15);
      bool = true;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.JsApiOpenChannelsLive", s.X("preProcessExtInfo, fail since ", paramJSONObject));
      }
    }
    AppMethodBeat.o(327868);
    return bool;
  }
  
  public final String cF(String paramString, int paramInt)
  {
    AppMethodBeat.i(327875);
    s.u(paramString, "originErrMsg");
    Log.i("MicroMsg.AppBrand.JsApiOpenChannelsLive", s.X("overrideErrMsg, errCode: ", Integer.valueOf(paramInt)));
    if ((-1000 == paramInt) || (-1001 == paramInt) || (-1002 == paramInt) || (-1003 == paramInt)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = super.cF(paramString, paramInt);
      AppMethodBeat.o(327875);
      return paramString;
    }
    paramString = String.format("fail:pre check fail, errCode=%d", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    s.s(paramString, "java.lang.String.format(this, *args)");
    Log.i("MicroMsg.AppBrand.JsApiOpenChannelsLive", s.X("overrideErrMsg, newErrMsg: ", paramString));
    AppMethodBeat.o(327875);
    return paramString;
  }
  
  public final Intent eH(Context paramContext)
  {
    AppMethodBeat.i(327883);
    s.u(paramContext, "context");
    paramContext = b.eD(paramContext);
    AppMethodBeat.o(327883);
    return paramContext;
  }
  
  public final String getAction()
  {
    return "openFinderLive";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/JsApiOpenChannelsLive$Companion;", "", "()V", "ACTION", "", "CTRL_INDEX", "", "NAME", "PARAM_KEY_COMMENT_SCENE", "PARAM_VALUE_COMMENT_SCENE", "PRE_CHECK_ERR_MSG_FORMAT", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.f
 * JD-Core Version:    0.7.0.1
 */