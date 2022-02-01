package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.e;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class a
{
  static void f(bow parambow)
  {
    AppMethodBeat.i(122215);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.coV()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(122215);
      return;
    }
    parambow = g(parambow);
    if (TextUtils.isEmpty(parambow))
    {
      AppMethodBeat.o(122215);
      return;
    }
    ae.i("HABBYGE-MALI.AsyncBizReport", "doReport: %s", new Object[] { parambow });
    d.aQ(17648, parambow);
    AppMethodBeat.o(122215);
  }
  
  private static String g(bow parambow)
  {
    AppMethodBeat.i(122216);
    try
    {
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.afY(com.tencent.mm.plugin.expt.hellhound.a.f.c.a.crA());
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
        localJSONObject.put("tbe", parambow.Hcm);
        long l = parambow.Hcn - parambow.Hcm;
        if (l > 0L) {}
        for (;;)
        {
          localJSONObject.put("in", l);
          localJSONObject.put("vv", "2.0");
          localJSONObject.put("content", localObject);
          parambow = localJSONObject.toString();
          AppMethodBeat.o(122216);
          return parambow;
          l = 0L;
        }
        return null;
      }
      catch (JSONException parambow)
      {
        ae.printErrStackTrace("HABBYGE-MALI.AsyncBizReport", parambow, "AsyncBizReport, toJsons: %s", new Object[] { parambow.getMessage() });
        AppMethodBeat.o(122216);
      }
    }
    catch (JSONException parambow)
    {
      ae.printErrStackTrace("HABBYGE-MALI.AsyncBizReport", parambow, "AsyncBizReport, getParamsJSONArray: %s", new Object[] { parambow.getMessage() });
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
    List localList = com.tencent.mm.plugin.expt.hellhound.a.f.c.a.crB();
    if ((localList == null) || (localList.isEmpty()))
    {
      ae.e("HABBYGE-MALI.AsyncBizReport", "AsyncBizReport, filterBySessionPage, bizIdOfCloudConfig is NULL !!");
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
          e.cry();
          if ((!e.cru()) || (localList.contains(str)))
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
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_async_bizid_sid".concat(String.valueOf(i)), new byte[0]);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(122217);
      return localJSONArray;
      label201:
      com.tencent.mm.plugin.expt.hellhound.a.f.c.a.dc(localList);
      com.tencent.mm.plugin.expt.hellhound.a.f.c.a.dd(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.a
 * JD-Core Version:    0.7.0.1
 */