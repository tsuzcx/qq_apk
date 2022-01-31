package com.tencent.mm.plugin.downloader_app.detail;

import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class c$2$1
  extends c
{
  c$2$1(c.2 param2, String paramString) {}
  
  public final String name()
  {
    return "onDataEnvReady";
  }
  
  public final JSONObject tY()
  {
    AppMethodBeat.i(136044);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", this.hye);
      label24:
      AppMethodBeat.o(136044);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label24;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.c.2.1
 * JD-Core Version:    0.7.0.1
 */