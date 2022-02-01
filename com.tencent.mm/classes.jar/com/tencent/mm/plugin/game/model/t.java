package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.g.a.hs.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  public static void a(hs paramhs)
  {
    AppMethodBeat.i(41500);
    paramhs = paramhs.dls.dln;
    ad.d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", new Object[] { paramhs });
    if (paramhs != null)
    {
      try
      {
        paramhs = new JSONObject(paramhs);
        if ((paramhs.isNull("type")) || (bt.getInt(paramhs.optString("type"), 0) == 0))
        {
          new JSONArray();
          paramhs = paramhs.getJSONArray("localIdList");
          int j = paramhs.length();
          long[] arrayOfLong = new long[j];
          int i = 0;
          while (i < j)
          {
            arrayOfLong[i] = paramhs.getLong(i);
            i += 1;
          }
          ((e)g.ab(e.class)).cBd().c(arrayOfLong);
          AppMethodBeat.o(41500);
          return;
        }
        if (bt.getInt(paramhs.optString("type"), 0) == 65536)
        {
          ((e)g.ab(e.class)).cBd().execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
          AppMethodBeat.o(41500);
          return;
        }
      }
      catch (JSONException paramhs)
      {
        ad.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramhs.getMessage() });
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