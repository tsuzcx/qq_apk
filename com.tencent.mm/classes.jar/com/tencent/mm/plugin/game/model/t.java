package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.g.a.ig.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  public static void a(ig paramig)
  {
    AppMethodBeat.i(41500);
    paramig = paramig.duM.param;
    ad.d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", new Object[] { paramig });
    if (paramig != null)
    {
      try
      {
        paramig = new JSONObject(paramig);
        if ((paramig.isNull("type")) || (bt.getInt(paramig.optString("type"), 0) == 0))
        {
          new JSONArray();
          paramig = paramig.getJSONArray("localIdList");
          int j = paramig.length();
          long[] arrayOfLong = new long[j];
          int i = 0;
          while (i < j)
          {
            arrayOfLong[i] = paramig.getLong(i);
            i += 1;
          }
          ((f)g.ab(f.class)).cWH().c(arrayOfLong);
          AppMethodBeat.o(41500);
          return;
        }
        if (bt.getInt(paramig.optString("type"), 0) == 65536)
        {
          ((f)g.ab(f.class)).cWH().execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
          AppMethodBeat.o(41500);
          return;
        }
      }
      catch (JSONException paramig)
      {
        ad.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramig.getMessage() });
        AppMethodBeat.o(41500);
        return;
      }
      AppMethodBeat.o(41500);
      return;
    }
    AppMethodBeat.o(41500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.t
 * JD-Core Version:    0.7.0.1
 */