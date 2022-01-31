package com.tencent.mm.plugin.downloader_app.detail;

import com.tencent.luggage.e.c;
import org.json.JSONException;
import org.json.JSONObject;

final class d$3
  extends c
{
  d$3(String paramString) {}
  
  public final String name()
  {
    return "onDataEnvReady";
  }
  
  public final JSONObject pV()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", this.gge);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.d.3
 * JD-Core Version:    0.7.0.1
 */