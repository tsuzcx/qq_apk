package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.gy.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s
{
  public static void a(gy paramgy)
  {
    AppMethodBeat.i(111335);
    paramgy = paramgy.cvT.cvO;
    ab.d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", new Object[] { paramgy });
    if (paramgy != null)
    {
      try
      {
        paramgy = new JSONObject(paramgy);
        if ((paramgy.isNull("type")) || (bo.getInt(paramgy.optString("type"), 0) == 0))
        {
          new JSONArray();
          paramgy = paramgy.getJSONArray("localIdList");
          int j = paramgy.length();
          long[] arrayOfLong = new long[j];
          int i = 0;
          while (i < j)
          {
            arrayOfLong[i] = paramgy.getLong(i);
            i += 1;
          }
          ((e)g.E(e.class)).bES().d(arrayOfLong);
          AppMethodBeat.o(111335);
          return;
        }
        if (bo.getInt(paramgy.optString("type"), 0) == 65536)
        {
          ((e)g.E(e.class)).bES().execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
          AppMethodBeat.o(111335);
          return;
        }
      }
      catch (JSONException paramgy)
      {
        ab.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramgy.getMessage() });
        AppMethodBeat.o(111335);
        return;
      }
      AppMethodBeat.o(111335);
      return;
    }
    AppMethodBeat.o(111335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.s
 * JD-Core Version:    0.7.0.1
 */