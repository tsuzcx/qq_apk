package com.tencent.mm.plugin.expt.hellhound.ext.session.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.e;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class a
{
  static void f(czw paramczw)
  {
    AppMethodBeat.i(122215);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dIK()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(122215);
      return;
    }
    paramczw = g(paramczw);
    if (TextUtils.isEmpty(paramczw))
    {
      AppMethodBeat.o(122215);
      return;
    }
    Log.i("HABBYGE-MALI.AsyncBizReport", "doReport: %s", new Object[] { paramczw });
    d.bo(17648, paramczw);
    AppMethodBeat.o(122215);
  }
  
  private static String g(czw paramczw)
  {
    AppMethodBeat.i(122216);
    try
    {
      Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.b.d.asP(com.tencent.mm.plugin.expt.hellhound.ext.session.b.a.dLR());
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
        localObject = z((JSONArray)localObject);
        if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
          break;
        }
        AppMethodBeat.o(122216);
        return null;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("tbe", paramczw.aaFl);
        long l = paramczw.aaFm - paramczw.aaFl;
        if (l > 0L) {}
        for (;;)
        {
          localJSONObject.put("in", l);
          localJSONObject.put("vv", "2.0");
          localJSONObject.put("content", localObject);
          paramczw = localJSONObject.toString();
          AppMethodBeat.o(122216);
          return paramczw;
          l = 0L;
        }
        return null;
      }
      catch (JSONException paramczw)
      {
        Log.printErrStackTrace("HABBYGE-MALI.AsyncBizReport", paramczw, "AsyncBizReport, toJsons: %s", new Object[] { paramczw.getMessage() });
        AppMethodBeat.o(122216);
      }
    }
    catch (JSONException paramczw)
    {
      Log.printErrStackTrace("HABBYGE-MALI.AsyncBizReport", paramczw, "AsyncBizReport, getParamsJSONArray: %s", new Object[] { paramczw.getMessage() });
      AppMethodBeat.o(122216);
      return null;
    }
  }
  
  private static JSONArray z(JSONArray paramJSONArray)
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
    List localList = com.tencent.mm.plugin.expt.hellhound.ext.session.b.a.dLS();
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
          e.dLP();
          if ((!e.dLL()) || (localList.contains(str)))
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
        com.tencent.mm.plugin.expt.hellhound.core.a.b.u("mmkv_async_bizid_sid".concat(String.valueOf(i)), new byte[0]);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(122217);
      return localJSONArray;
      label201:
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.a.fr(localList);
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.a.fs(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.e.a
 * JD-Core Version:    0.7.0.1
 */