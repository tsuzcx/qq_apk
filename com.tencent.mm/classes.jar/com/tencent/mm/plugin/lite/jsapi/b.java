package com.tencent.mm.plugin.lite.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private String mAppId;
  private long vkt;
  private long vku;
  private long vkv;
  
  public b(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    this.mAppId = paramString;
    this.vkt = paramLong1;
    this.vku = paramLong2;
    this.vkv = paramLong3;
  }
  
  public final void aB(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(212374);
    if (this.vkv < 0L)
    {
      AppMethodBeat.o(212374);
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
        ae.printErrStackTrace("liteApp.LiteAppJsApiCallback", paramJSONObject, "callback", new Object[0]);
        continue;
      }
      LiteAppCenter.jsApiCallback(this.mAppId, this.vkt, this.vku, this.vkv, localJSONObject.toString(), false);
      AppMethodBeat.o(212374);
      return;
      localJSONObject.put("data", new JSONObject());
    }
  }
  
  public final void apy(String paramString)
  {
    AppMethodBeat.i(212375);
    JSONObject localJSONObject;
    if (this.vkv >= 0L) {
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
        ae.printErrStackTrace("liteApp.LiteAppJsApiCallback", paramString, "callback", new Object[0]);
        continue;
      }
      LiteAppCenter.jsApiCallback(this.mAppId, this.vkt, this.vku, this.vkv, localJSONObject.toString(), false);
      AppMethodBeat.o(212375);
      return;
      localJSONObject.put("errMsg", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.b
 * JD-Core Version:    0.7.0.1
 */