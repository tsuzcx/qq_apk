package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.jm;
import com.tencent.mm.f.a.jm.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  public static void a(jm paramjm)
  {
    AppMethodBeat.i(41500);
    paramjm = paramjm.fGK.param;
    Log.d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", new Object[] { paramjm });
    if (paramjm != null)
    {
      try
      {
        paramjm = new JSONObject(paramjm);
        if ((paramjm.isNull("type")) || (Util.getInt(paramjm.optString("type"), 0) == 0))
        {
          new JSONArray();
          paramjm = paramjm.getJSONArray("localIdList");
          int j = paramjm.length();
          long[] arrayOfLong = new long[j];
          int i = 0;
          while (i < j)
          {
            arrayOfLong[i] = paramjm.getLong(i);
            i += 1;
          }
          ((f)h.ae(f.class)).evo().c(arrayOfLong);
          AppMethodBeat.o(41500);
          return;
        }
        if (Util.getInt(paramjm.optString("type"), 0) == 65536)
        {
          ((f)h.ae(f.class)).evo().execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
          AppMethodBeat.o(41500);
          return;
        }
      }
      catch (JSONException paramjm)
      {
        Log.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramjm.getMessage() });
        AppMethodBeat.o(41500);
        return;
      }
      AppMethodBeat.o(41500);
      return;
    }
    AppMethodBeat.o(41500);
  }
  
  public static void b(jm paramjm)
  {
    AppMethodBeat.i(192532);
    paramjm = paramjm.fGK.param;
    Log.d("MicroMsg.GameJsapiProcessor", "deleteMessage param=%s", new Object[] { paramjm });
    if (paramjm != null) {
      try
      {
        paramjm = new JSONObject(paramjm);
        if (paramjm.optBoolean("deleteAll", false))
        {
          ((f)h.ae(f.class)).evo().eyI();
          AppMethodBeat.o(192532);
          return;
        }
        paramjm = paramjm.optJSONArray("localIdList");
        if (paramjm != null)
        {
          int j = paramjm.length();
          long[] arrayOfLong = new long[j];
          int i = 0;
          while (i < j)
          {
            arrayOfLong[i] = paramjm.getLong(i);
            i += 1;
          }
          ((f)h.ae(f.class)).evo().d(arrayOfLong);
        }
        AppMethodBeat.o(192532);
        return;
      }
      catch (JSONException paramjm)
      {
        Log.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramjm.getMessage() });
        AppMethodBeat.o(192532);
        return;
      }
    }
    AppMethodBeat.o(192532);
  }
  
  public static void c(jm paramjm)
  {
    AppMethodBeat.i(192537);
    Object localObject = paramjm.fGK.param;
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
            o localo = ((f)h.ae(f.class)).evo().aJW(str);
            if (localo == null) {
              break label172;
            }
            localo.eyt();
            localJSONObject.put(str, c.aKz(localo.CJR.CKQ));
            break label172;
          }
          paramjm.fGL.fGM = localJSONObject.toString();
        }
        AppMethodBeat.o(192537);
        return;
      }
      catch (JSONException paramjm)
      {
        Log.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramjm.getMessage() });
        AppMethodBeat.o(192537);
        return;
      }
      AppMethodBeat.o(192537);
      return;
      label172:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.t
 * JD-Core Version:    0.7.0.1
 */