package com.tencent.mm.plugin.lite.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private String mAppId;
  private long uYE;
  private long uYF;
  private long uYG;
  
  public b(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    this.mAppId = paramString;
    this.uYE = paramLong1;
    this.uYF = paramLong2;
    this.uYG = paramLong3;
  }
  
  public final void aB(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(214621);
    if (this.uYG < 0L)
    {
      AppMethodBeat.o(214621);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("result", true);
        localJSONObject.put("errMsg", "");
        if (paramJSONObject == null) {
          continue;
        }
        localJSONObject.put("data", paramJSONObject);
      }
      catch (JSONException paramJSONObject)
      {
        ad.printErrStackTrace("liteApp.LiteAppJsApiCallback", paramJSONObject, "callback", new Object[0]);
        continue;
      }
      LiteAppCenter.jsApiCallback(this.mAppId, this.uYE, this.uYF, this.uYG, localJSONObject.toString(), false);
      AppMethodBeat.o(214621);
      return;
      localJSONObject.put("data", new JSONObject());
    }
  }
  
  public final void aov(String paramString)
  {
    AppMethodBeat.i(214622);
    JSONObject localJSONObject;
    if (this.uYG >= 0L) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("result", false);
        localJSONObject.put("data", new JSONObject());
        if (paramString == null) {
          continue;
        }
        localJSONObject.put("errMsg", paramString);
      }
      catch (JSONException paramString)
      {
        ad.printErrStackTrace("liteApp.LiteAppJsApiCallback", paramString, "callback", new Object[0]);
        continue;
      }
      LiteAppCenter.jsApiCallback(this.mAppId, this.uYE, this.uYF, this.uYG, localJSONObject.toString(), false);
      AppMethodBeat.o(214622);
      return;
      localJSONObject.put("errMsg", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.b
 * JD-Core Version:    0.7.0.1
 */