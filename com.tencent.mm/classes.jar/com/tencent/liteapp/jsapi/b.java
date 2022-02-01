package com.tencent.liteapp.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private long coK;
  private long coL;
  private long coM;
  private boolean coN;
  private String mAppId;
  
  public b(String paramString, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    this.mAppId = paramString;
    this.coK = paramLong1;
    this.coL = paramLong2;
    this.coM = paramLong3;
    this.coN = paramBoolean;
  }
  
  public final void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(258518);
    if (this.coM < 0L)
    {
      AppMethodBeat.o(258518);
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
      LiteAppCenter.jsApiCallback(this.mAppId, this.coK, this.coL, this.coM, localJSONObject.toString(), paramBoolean, this.coN);
      AppMethodBeat.o(258518);
      return;
      localJSONObject.put("data", new JSONObject());
    }
  }
  
  public final void i(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(258519);
    JSONObject localJSONObject;
    if (this.coM >= 0L) {
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
      LiteAppCenter.jsApiCallback(this.mAppId, this.coK, this.coL, this.coM, localJSONObject.toString(), paramBoolean, this.coN);
      AppMethodBeat.o(258519);
      return;
      localJSONObject.put("errMsg", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.jsapi.b
 * JD-Core Version:    0.7.0.1
 */