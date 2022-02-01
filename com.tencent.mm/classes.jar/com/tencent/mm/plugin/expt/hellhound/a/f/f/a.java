package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.e;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class a
{
  static void f(cbo paramcbo)
  {
    AppMethodBeat.i(122215);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cNo()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(122215);
      return;
    }
    paramcbo = g(paramcbo);
    if (TextUtils.isEmpty(paramcbo))
    {
      AppMethodBeat.o(122215);
      return;
    }
    Log.i("HABBYGE-MALI.AsyncBizReport", "doReport: %s", new Object[] { paramcbo });
    d.aV(17648, paramcbo);
    AppMethodBeat.o(122215);
  }
  
  private static String g(cbo paramcbo)
  {
    AppMethodBeat.i(122216);
    try
    {
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.aqJ(com.tencent.mm.plugin.expt.hellhound.a.f.c.a.cQi());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        boolean bool = "-1".equals(localObject);
        if (!bool) {
          break label63;
        }
      }
      label63:
      for (localObject = null;; localObject = new JSONArray((String)localObject))
      {
        localObject = w((JSONArray)localObject);
        if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
          break;
        }
        AppMethodBeat.o(122216);
        return null;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("tbe", paramcbo.Mhp);
        long l = paramcbo.Mhq - paramcbo.Mhp;
        if (l > 0L) {}
        for (;;)
        {
          localJSONObject.put("in", l);
          localJSONObject.put("vv", "2.0");
          localJSONObject.put("content", localObject);
          paramcbo = localJSONObject.toString();
          AppMethodBeat.o(122216);
          return paramcbo;
          l = 0L;
        }
        return null;
      }
      catch (JSONException paramcbo)
      {
        Log.printErrStackTrace("HABBYGE-MALI.AsyncBizReport", paramcbo, "AsyncBizReport, toJsons: %s", new Object[] { paramcbo.getMessage() });
        AppMethodBeat.o(122216);
      }
    }
    catch (JSONException paramcbo)
    {
      Log.printErrStackTrace("HABBYGE-MALI.AsyncBizReport", paramcbo, "AsyncBizReport, getParamsJSONArray: %s", new Object[] { paramcbo.getMessage() });
      AppMethodBeat.o(122216);
      return null;
    }
  }
  
  private static JSONArray w(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(122217);
    int j;
    if (paramJSONArray != null)
    {
      j = paramJSONArray.length();
      if (j > 0) {}
    }
    else
    {
      AppMethodBeat.o(122217);
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    List localList = com.tencent.mm.plugin.expt.hellhound.a.f.c.a.cQj();
    if ((localList == null) || (localList.isEmpty()))
    {
      Log.e("HABBYGE-MALI.AsyncBizReport", "AsyncBizReport, filterBySessionPage, bizIdOfCloudConfig is NULL !!");
      AppMethodBeat.o(122217);
      return null;
    }
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if (localJSONObject != null)
      {
        String str = localJSONObject.optString("businessId");
        if (!TextUtils.isEmpty(str))
        {
          e.cQg();
          if ((!e.cQc()) || (localList.contains(str)))
          {
            localJSONArray.put(localJSONObject);
            localList.remove(str);
          }
        }
      }
      i += 1;
    }
    if (localJSONArray.length() > 0)
    {
      if ((localList != null) && (!localList.isEmpty())) {
        break label201;
      }
      i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
      if (i != 0) {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_async_bizid_sid".concat(String.valueOf(i)), new byte[0]);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(122217);
      return localJSONArray;
      label201:
      com.tencent.mm.plugin.expt.hellhound.a.f.c.a.dq(localList);
      com.tencent.mm.plugin.expt.hellhound.a.f.c.a.dr(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.a
 * JD-Core Version:    0.7.0.1
 */