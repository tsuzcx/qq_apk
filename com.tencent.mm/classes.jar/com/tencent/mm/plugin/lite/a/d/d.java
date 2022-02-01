package com.tencent.mm.plugin.lite.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271529);
    Log.d("LiteAppJsApiOpenFinderCreateAcctView", "Invoke openFinderCreateAcctView");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271529);
      return;
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("scene", paramJSONObject.optInt("scene"));
      paramString.put("tipsWording", paramJSONObject.optJSONObject("tipsWording"));
      return;
    }
    catch (JSONException paramString)
    {
      try
      {
        ((cn)h.az(cn.class)).createAccount(MMApplicationContext.getContext(), null, paramString.toString(), new ca.a() {});
        AppMethodBeat.o(271529);
        return;
      }
      catch (Exception paramString)
      {
        this.JZj.aJV("fail");
        Log.printErrStackTrace("LiteAppJsApiOpenFinderCreateAcctView", paramString, "", new Object[0]);
        AppMethodBeat.o(271529);
      }
      paramString = paramString;
      this.JZj.aJV("fail");
      Log.printErrStackTrace("LiteAppJsApiOpenFinderCreateAcctView", paramString, "", new Object[0]);
      AppMethodBeat.o(271529);
      return;
    }
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.d.d
 * JD-Core Version:    0.7.0.1
 */