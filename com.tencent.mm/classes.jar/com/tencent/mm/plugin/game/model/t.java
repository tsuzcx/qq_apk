package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.kn;
import com.tencent.mm.autogen.a.kn.a;
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
  public static void a(kn paramkn)
  {
    AppMethodBeat.i(41500);
    paramkn = paramkn.hMg.param;
    Log.d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", new Object[] { paramkn });
    if (paramkn != null)
    {
      try
      {
        paramkn = new JSONObject(paramkn);
        if ((paramkn.isNull("type")) || (Util.getInt(paramkn.optString("type"), 0) == 0))
        {
          new JSONArray();
          paramkn = paramkn.getJSONArray("localIdList");
          int j = paramkn.length();
          long[] arrayOfLong = new long[j];
          int i = 0;
          while (i < j)
          {
            arrayOfLong[i] = paramkn.getLong(i);
            i += 1;
          }
          ((f)h.ax(f.class)).fCh().e(arrayOfLong);
          AppMethodBeat.o(41500);
          return;
        }
        if (Util.getInt(paramkn.optString("type"), 0) == 65536)
        {
          ((f)h.ax(f.class)).fCh().execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
          AppMethodBeat.o(41500);
          return;
        }
      }
      catch (JSONException paramkn)
      {
        Log.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramkn.getMessage() });
        AppMethodBeat.o(41500);
        return;
      }
      AppMethodBeat.o(41500);
      return;
    }
    AppMethodBeat.o(41500);
  }
  
  public static void b(kn paramkn)
  {
    AppMethodBeat.i(275409);
    paramkn = paramkn.hMg.param;
    Log.d("MicroMsg.GameJsapiProcessor", "deleteMessage param=%s", new Object[] { paramkn });
    if (paramkn != null) {
      try
      {
        paramkn = new JSONObject(paramkn);
        if (paramkn.optBoolean("deleteAll", false))
        {
          ((f)h.ax(f.class)).fCh().fGE();
          AppMethodBeat.o(275409);
          return;
        }
        paramkn = paramkn.optJSONArray("localIdList");
        if (paramkn != null)
        {
          int j = paramkn.length();
          long[] arrayOfLong = new long[j];
          int i = 0;
          while (i < j)
          {
            arrayOfLong[i] = paramkn.getLong(i);
            i += 1;
          }
          ((f)h.ax(f.class)).fCh().f(arrayOfLong);
        }
        AppMethodBeat.o(275409);
        return;
      }
      catch (JSONException paramkn)
      {
        Log.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramkn.getMessage() });
        AppMethodBeat.o(275409);
        return;
      }
    }
    AppMethodBeat.o(275409);
  }
  
  public static void c(kn paramkn)
  {
    AppMethodBeat.i(275413);
    Object localObject = paramkn.hMg.param;
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
            o localo = ((f)h.ax(f.class)).fCh().aGL(str);
            if (localo == null) {
              break label172;
            }
            localo.fGp();
            localJSONObject.put(str, c.aHq(localo.IEc.IEY));
            break label172;
          }
          paramkn.hMh.hMi = localJSONObject.toString();
        }
        AppMethodBeat.o(275413);
        return;
      }
      catch (JSONException paramkn)
      {
        Log.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramkn.getMessage() });
        AppMethodBeat.o(275413);
        return;
      }
      AppMethodBeat.o(275413);
      return;
      label172:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.t
 * JD-Core Version:    0.7.0.1
 */