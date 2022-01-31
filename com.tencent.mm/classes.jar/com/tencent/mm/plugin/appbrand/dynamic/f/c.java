package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.aa.b.c
{
  public String data;
  
  public c()
  {
    super("onDataPush");
  }
  
  c(int paramInt)
  {
    super("onDataPush", paramInt);
  }
  
  public final JSONObject rB()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", bk.pm(this.data));
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.c
 * JD-Core Version:    0.7.0.1
 */