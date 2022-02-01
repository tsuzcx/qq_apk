package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.g.a.iw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  public static void a(iw paramiw)
  {
    AppMethodBeat.i(41500);
    paramiw = paramiw.dNy.param;
    Log.d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", new Object[] { paramiw });
    if (paramiw != null)
    {
      try
      {
        paramiw = new JSONObject(paramiw);
        if ((paramiw.isNull("type")) || (Util.getInt(paramiw.optString("type"), 0) == 0))
        {
          new JSONArray();
          paramiw = paramiw.getJSONArray("localIdList");
          int j = paramiw.length();
          long[] arrayOfLong = new long[j];
          int i = 0;
          while (i < j)
          {
            arrayOfLong[i] = paramiw.getLong(i);
            i += 1;
          }
          ((f)g.af(f.class)).dSK().c(arrayOfLong);
          AppMethodBeat.o(41500);
          return;
        }
        if (Util.getInt(paramiw.optString("type"), 0) == 65536)
        {
          ((f)g.af(f.class)).dSK().execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
          AppMethodBeat.o(41500);
          return;
        }
      }
      catch (JSONException paramiw)
      {
        Log.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramiw.getMessage() });
        AppMethodBeat.o(41500);
        return;
      }
      AppMethodBeat.o(41500);
      return;
    }
    AppMethodBeat.o(41500);
  }
  
  public static void b(iw paramiw)
  {
    AppMethodBeat.i(204172);
    paramiw = paramiw.dNy.param;
    Log.d("MicroMsg.GameJsapiProcessor", "deleteMessage param=%s", new Object[] { paramiw });
    if (paramiw != null) {
      try
      {
        paramiw = new JSONObject(paramiw);
        if (paramiw.optBoolean("deleteAll", false))
        {
          ((f)g.af(f.class)).dSK().dVA();
          AppMethodBeat.o(204172);
          return;
        }
        paramiw = paramiw.optJSONArray("localIdList");
        if (paramiw != null)
        {
          int j = paramiw.length();
          long[] arrayOfLong = new long[j];
          int i = 0;
          while (i < j)
          {
            arrayOfLong[i] = paramiw.getLong(i);
            i += 1;
          }
          ((f)g.af(f.class)).dSK().d(arrayOfLong);
        }
        AppMethodBeat.o(204172);
        return;
      }
      catch (JSONException paramiw)
      {
        Log.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramiw.getMessage() });
        AppMethodBeat.o(204172);
        return;
      }
    }
    AppMethodBeat.o(204172);
  }
  
  public static void c(iw paramiw)
  {
    AppMethodBeat.i(204173);
    Object localObject = paramiw.dNy.param;
    if (localObject != null) {}
    for (;;)
    {
      int i;
      try
      {
        localObject = new JSONObject((String)localObject).optJSONArray("msgIdList");
        if (localObject != null)
        {
          JSONObject localJSONObject = new JSONObject();
          int j = ((JSONArray)localObject).length();
          i = 0;
          if (i < j)
          {
            String str = ((JSONArray)localObject).getString(i);
            if (Util.isNullOrNil(str)) {
              break label172;
            }
            o localo = ((f)g.af(f.class)).dSK().aAk(str);
            if (localo == null) {
              break label172;
            }
            localo.dVl();
            localJSONObject.put(str, c.aAN(localo.xFQ.xGN));
            break label172;
          }
          paramiw.dNz.dNA = localJSONObject.toString();
        }
        AppMethodBeat.o(204173);
        return;
      }
      catch (JSONException paramiw)
      {
        Log.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramiw.getMessage() });
        AppMethodBeat.o(204173);
        return;
      }
      AppMethodBeat.o(204173);
      return;
      label172:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.t
 * JD-Core Version:    0.7.0.1
 */