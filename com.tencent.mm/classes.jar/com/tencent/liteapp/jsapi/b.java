package com.tencent.liteapp.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private long cqW;
  private long cqX;
  private long cqY;
  private String mAppId;
  
  public b(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    this.mAppId = paramString;
    this.cqW = paramLong1;
    this.cqX = paramLong2;
    this.cqY = paramLong3;
  }
  
  public final void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(197701);
    if (this.cqY < 0L)
    {
      AppMethodBeat.o(197701);
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
        com.tencent.liteapp.b.b.e("WxaLiteApp.LiteAppJsApiCallback", paramJSONObject.toString(), new Object[0]);
        continue;
      }
      LiteAppCenter.jsApiCallback(this.mAppId, this.cqW, this.cqX, this.cqY, localJSONObject.toString(), paramBoolean);
      AppMethodBeat.o(197701);
      return;
      localJSONObject.put("data", new JSONObject());
    }
  }
  
  public final void h(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197702);
    JSONObject localJSONObject;
    if (this.cqY >= 0L) {
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
        com.tencent.liteapp.b.b.e("WxaLiteApp.LiteAppJsApiCallback", paramString.toString(), new Object[0]);
        continue;
      }
      LiteAppCenter.jsApiCallback(this.mAppId, this.cqW, this.cqX, this.cqY, localJSONObject.toString(), paramBoolean);
      AppMethodBeat.o(197702);
      return;
      localJSONObject.put("errMsg", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.jsapi.b
 * JD-Core Version:    0.7.0.1
 */