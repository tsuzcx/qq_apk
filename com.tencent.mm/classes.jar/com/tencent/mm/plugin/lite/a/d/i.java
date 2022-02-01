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

public class i
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271536);
    Log.d("LiteAppJsApiOpenFinderTopicView", "Invoke openFinderTopicView");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271536);
      return;
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("extInfo", new JSONObject(paramJSONObject.optString("extInfo")));
      ((cn)h.az(cn.class)).enterFinderTopicUI(MMApplicationContext.getContext(), paramString.toString());
      this.JZj.fTW();
      AppMethodBeat.o(271536);
      return;
    }
    catch (JSONException paramString)
    {
      this.JZj.aJV("fail");
      AppMethodBeat.o(271536);
    }
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.d.i
 * JD-Core Version:    0.7.0.1
 */