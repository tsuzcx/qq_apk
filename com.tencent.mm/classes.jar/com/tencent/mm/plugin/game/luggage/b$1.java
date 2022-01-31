package com.tencent.mm.plugin.game.luggage;

import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class b$1
  extends c
{
  public final String name()
  {
    return "onGetA8KeyUrl";
  }
  
  public final JSONObject tY()
  {
    AppMethodBeat.i(135807);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("url", b.nji);
        if (!b.njj) {
          continue;
        }
        i = 1;
        localJSONObject.put("set_cookie", i);
      }
      catch (Exception localException)
      {
        int i;
        ab.e("MicroMsg.LuggageGameUinKeyHolder", "onGetA8Key, e:" + localException.getMessage());
        continue;
      }
      AppMethodBeat.o(135807);
      return localJSONObject;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.1
 * JD-Core Version:    0.7.0.1
 */