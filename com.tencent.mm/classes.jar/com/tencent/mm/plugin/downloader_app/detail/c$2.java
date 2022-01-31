package com.tencent.mm.plugin.downloader_app.detail;

import org.json.JSONObject;

final class c$2
  extends com.tencent.luggage.e.c
{
  c$2(c paramc, String paramString) {}
  
  public final String name()
  {
    return "activity:state_change";
  }
  
  public final JSONObject pV()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", this.iRA);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.c.2
 * JD-Core Version:    0.7.0.1
 */