package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.g.a.ih.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  public static void a(ih paramih)
  {
    AppMethodBeat.i(41500);
    paramih = paramih.dvR.param;
    ae.d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", new Object[] { paramih });
    if (paramih != null)
    {
      try
      {
        paramih = new JSONObject(paramih);
        if ((paramih.isNull("type")) || (bu.getInt(paramih.optString("type"), 0) == 0))
        {
          new JSONArray();
          paramih = paramih.getJSONArray("localIdList");
          int j = paramih.length();
          long[] arrayOfLong = new long[j];
          int i = 0;
          while (i < j)
          {
            arrayOfLong[i] = paramih.getLong(i);
            i += 1;
          }
          ((f)g.ab(f.class)).cZl().c(arrayOfLong);
          AppMethodBeat.o(41500);
          return;
        }
        if (bu.getInt(paramih.optString("type"), 0) == 65536)
        {
          ((f)g.ab(f.class)).cZl().execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
          AppMethodBeat.o(41500);
          return;
        }
      }
      catch (JSONException paramih)
      {
        ae.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramih.getMessage() });
        AppMethodBeat.o(41500);
        return;
      }
      AppMethodBeat.o(41500);
      return;
    }
    AppMethodBeat.o(41500);
  }
  
  public static void b(ih paramih)
  {
    AppMethodBeat.i(195653);
    paramih = paramih.dvR.param;
    ae.d("MicroMsg.GameJsapiProcessor", "deleteMessage param=%s", new Object[] { paramih });
    if (paramih != null) {
      try
      {
        paramih = new JSONObject(paramih);
        if (paramih.optBoolean("deleteAll", false))
        {
          ((f)g.ab(f.class)).cZl().dbT();
          AppMethodBeat.o(195653);
          return;
        }
        paramih = paramih.optJSONArray("localIdList");
        if (paramih != null)
        {
          int j = paramih.length();
          long[] arrayOfLong = new long[j];
          int i = 0;
          while (i < j)
          {
            arrayOfLong[i] = paramih.getLong(i);
            i += 1;
          }
          ((f)g.ab(f.class)).cZl().d(arrayOfLong);
        }
        AppMethodBeat.o(195653);
        return;
      }
      catch (JSONException paramih)
      {
        ae.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramih.getMessage() });
        AppMethodBeat.o(195653);
        return;
      }
    }
    AppMethodBeat.o(195653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.t
 * JD-Core Version:    0.7.0.1
 */