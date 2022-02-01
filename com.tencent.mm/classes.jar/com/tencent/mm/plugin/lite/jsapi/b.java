package com.tencent.mm.plugin.lite.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private String mAppId;
  private long tVV;
  private long tVW;
  private long tVX;
  
  public b(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    this.mAppId = paramString;
    this.tVV = paramLong1;
    this.tVW = paramLong2;
    this.tVX = paramLong3;
  }
  
  private void ad(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(208156);
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    if (this.tVX >= 0L)
    {
      localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("result", false);
        localJSONObject2 = new JSONObject();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          localJSONObject2.put((String)localEntry.getKey(), localEntry.getValue());
          continue;
          LiteAppCenter.jsApiCallback(this.mAppId, this.tVV, this.tVW, this.tVX, localJSONObject1.toString(), false);
        }
      }
      catch (JSONException paramMap)
      {
        ac.printErrStackTrace("liteApp.LiteAppJsApiCallback", paramMap, "callback", new Object[0]);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(208156);
      return;
      localJSONObject1.put("data", localJSONObject2);
    }
  }
  
  public final void Vc(String paramString)
  {
    AppMethodBeat.i(208157);
    HashMap localHashMap = new HashMap();
    localHashMap.put("msg", paramString);
    ad(localHashMap);
    AppMethodBeat.o(208157);
  }
  
  public final void as(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(208155);
    if (this.tVX < 0L)
    {
      AppMethodBeat.o(208155);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("result", true);
        if (paramJSONObject == null) {
          continue;
        }
        localJSONObject.put("data", paramJSONObject);
      }
      catch (JSONException paramJSONObject)
      {
        ac.printErrStackTrace("liteApp.LiteAppJsApiCallback", paramJSONObject, "callback", new Object[0]);
        continue;
      }
      LiteAppCenter.jsApiCallback(this.mAppId, this.tVV, this.tVW, this.tVX, localJSONObject.toString(), false);
      AppMethodBeat.o(208155);
      return;
      localJSONObject.put("data", new JSONObject());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.b
 * JD-Core Version:    0.7.0.1
 */