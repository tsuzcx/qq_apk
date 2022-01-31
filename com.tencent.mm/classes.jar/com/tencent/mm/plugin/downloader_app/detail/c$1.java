package com.tencent.mm.plugin.downloader_app.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class c$1
  extends com.tencent.luggage.d.c
{
  c$1(c paramc, String paramString) {}
  
  public final String name()
  {
    return "activity:state_change";
  }
  
  public final JSONObject tY()
  {
    AppMethodBeat.i(136043);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", this.lai);
      label24:
      AppMethodBeat.o(136043);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.c.1
 * JD-Core Version:    0.7.0.1
 */