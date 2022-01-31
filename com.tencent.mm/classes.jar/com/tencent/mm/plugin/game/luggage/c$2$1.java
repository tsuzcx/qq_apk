package com.tencent.mm.plugin.game.luggage;

import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

final class c$2$1
  extends c
{
  c$2$1(c.2 param2) {}
  
  public final String name()
  {
    return "onGetA8KeyUrl";
  }
  
  public final JSONObject tY()
  {
    AppMethodBeat.i(135826);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.njt.njr);
      localJSONObject.put("set_cookie", 1);
      AppMethodBeat.o(135826);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.LuggageGetA8KeyUtil", "onGetA8Key, e:" + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.2.1
 * JD-Core Version:    0.7.0.1
 */