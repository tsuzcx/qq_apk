package com.tencent.mm.plugin.lite.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271519);
    Log.d("LiteAppJsApiOpenChannelsActivity", "Invoke openChannelsActivity");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271519);
      return;
    }
    paramString = new JSONObject();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("action", "openFinderFeed");
      localJSONObject.put("feedID", paramJSONObject.optString("feedId"));
      localJSONObject.put("nonceID", paramJSONObject.optString("nonceId"));
      localJSONObject.put("notGetReleatedList", paramJSONObject.optInt("notGetReleatedList"));
      localJSONObject.put("shareScene", paramJSONObject.optInt("shareScene"));
      localJSONObject.put("sessionId", paramJSONObject.optString(""));
      localJSONObject.put("requestScene", paramJSONObject.optInt("requestScene", 3));
      localJSONObject.put("reportExtraInfo", paramJSONObject.optString("reportExtraInfo"));
      localJSONObject.put("commentScene", paramJSONObject.optInt("commentScene"));
      localJSONObject.put("userName", paramJSONObject.optString("finderUserName"));
      paramString.put("extInfo", localJSONObject);
      ((cn)h.az(cn.class)).enterFinderUI(MMApplicationContext.getContext(), paramString.toString());
      this.JZj.fTW();
      AppMethodBeat.o(271519);
      return;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("LiteAppJsApiOpenChannelsActivity", paramString, "", new Object[0]);
      this.JZj.aJV("fail");
      AppMethodBeat.o(271519);
    }
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.d.c
 * JD-Core Version:    0.7.0.1
 */