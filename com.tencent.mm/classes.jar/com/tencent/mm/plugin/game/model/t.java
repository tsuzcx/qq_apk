package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.hz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  public static void a(hz paramhz)
  {
    AppMethodBeat.i(41500);
    paramhz = paramhz.dja.param;
    ac.d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", new Object[] { paramhz });
    if (paramhz != null)
    {
      try
      {
        paramhz = new JSONObject(paramhz);
        if ((paramhz.isNull("type")) || (bs.getInt(paramhz.optString("type"), 0) == 0))
        {
          new JSONArray();
          paramhz = paramhz.getJSONArray("localIdList");
          int j = paramhz.length();
          long[] arrayOfLong = new long[j];
          int i = 0;
          while (i < j)
          {
            arrayOfLong[i] = paramhz.getLong(i);
            i += 1;
          }
          ((e)g.ab(e.class)).cOm().c(arrayOfLong);
          AppMethodBeat.o(41500);
          return;
        }
        if (bs.getInt(paramhz.optString("type"), 0) == 65536)
        {
          ((e)g.ab(e.class)).cOm().execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
          AppMethodBeat.o(41500);
          return;
        }
      }
      catch (JSONException paramhz)
      {
        ac.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramhz.getMessage() });
        AppMethodBeat.o(41500);
        return;
      }
      AppMethodBeat.o(41500);
      return;
    }
    AppMethodBeat.o(41500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.t
 * JD-Core Version:    0.7.0.1
 */