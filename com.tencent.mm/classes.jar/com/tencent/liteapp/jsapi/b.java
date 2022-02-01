package com.tencent.liteapp.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public long efW;
  public long efX;
  public long efY;
  private boolean efZ;
  public String mAppId;
  
  public b(String paramString, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    this.mAppId = paramString;
    this.efW = paramLong1;
    this.efX = paramLong2;
    this.efY = paramLong3;
    this.efZ = paramBoolean;
  }
  
  public final void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(219071);
    if (this.efY < 0L)
    {
      AppMethodBeat.o(219071);
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
      LiteAppCenter.jsApiCallback(this.mAppId, this.efW, this.efX, this.efY, localJSONObject.toString(), paramBoolean, this.efZ);
      AppMethodBeat.o(219071);
      return;
      localJSONObject.put("data", new JSONObject());
    }
  }
  
  public final void i(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(219080);
    if (this.efY < 0L)
    {
      AppMethodBeat.o(219080);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
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
      LiteAppCenter.jsApiCallback(this.mAppId, this.efW, this.efX, this.efY, localJSONObject.toString(), paramBoolean, this.efZ);
      AppMethodBeat.o(219080);
      return;
      localJSONObject.put("errMsg", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.jsapi.b
 * JD-Core Version:    0.7.0.1
 */