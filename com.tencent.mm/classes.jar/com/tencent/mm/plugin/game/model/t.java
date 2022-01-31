package com.tencent.mm.plugin.game.model;

import com.tencent.mm.h.a.gu;
import com.tencent.mm.h.a.gu.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  public static void a(gu paramgu)
  {
    paramgu = paramgu.bOC.bOx;
    y.d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", new Object[] { paramgu });
    if (paramgu != null) {
      try
      {
        paramgu = new JSONObject(paramgu);
        if ((paramgu.isNull("type")) || (bk.getInt(paramgu.optString("type"), 0) == 0))
        {
          new JSONArray();
          paramgu = paramgu.getJSONArray("localIdList");
          int j = paramgu.length();
          long[] arrayOfLong = new long[j];
          int i = 0;
          while (i < j)
          {
            arrayOfLong[i] = paramgu.getLong(i);
            i += 1;
          }
          ((c)g.r(c.class)).aYf().f(arrayOfLong);
          return;
        }
        if (bk.getInt(paramgu.optString("type"), 0) == 65536)
        {
          ((c)g.r(c.class)).aYf().gk("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
          return;
        }
      }
      catch (JSONException paramgu)
      {
        y.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[] { paramgu.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.t
 * JD-Core Version:    0.7.0.1
 */