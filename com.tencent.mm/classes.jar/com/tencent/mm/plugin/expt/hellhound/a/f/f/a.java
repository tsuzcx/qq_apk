package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.e;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class a
{
  static void f(bjw parambjw)
  {
    AppMethodBeat.i(122215);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.ciw()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(122215);
      return;
    }
    parambjw = g(parambjw);
    if (TextUtils.isEmpty(parambjw))
    {
      AppMethodBeat.o(122215);
      return;
    }
    ac.i("AsyncBizReport", "HABBYGE-MALI, doReport: %s", new Object[] { parambjw });
    d.aO(17648, parambjw);
    AppMethodBeat.o(122215);
  }
  
  private static String g(bjw parambjw)
  {
    AppMethodBeat.i(122216);
    try
    {
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.abp(com.tencent.mm.plugin.expt.hellhound.a.f.c.a.ckJ());
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
        localObject = u((JSONArray)localObject);
        if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
          break;
        }
        AppMethodBeat.o(122216);
        return null;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("tbe", parambjw.EZm);
        long l = parambjw.EZn - parambjw.EZm;
        if (l > 0L) {}
        for (;;)
        {
          localJSONObject.put("in", l);
          localJSONObject.put("vv", "2.0");
          localJSONObject.put("content", localObject);
          parambjw = localJSONObject.toString();
          AppMethodBeat.o(122216);
          return parambjw;
          l = 0L;
        }
        return null;
      }
      catch (JSONException parambjw)
      {
        ac.printErrStackTrace("AsyncBizReport", parambjw, "HABBYGE-MALI, AsyncBizReport, toJsons: %s", new Object[] { parambjw.getMessage() });
        AppMethodBeat.o(122216);
      }
    }
    catch (JSONException parambjw)
    {
      ac.printErrStackTrace("AsyncBizReport", parambjw, "HABBYGE-MALI, AsyncBizReport, getParamsJSONArray: %s", new Object[] { parambjw.getMessage() });
      AppMethodBeat.o(122216);
      return null;
    }
  }
  
  private static JSONArray u(JSONArray paramJSONArray)
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
    List localList = com.tencent.mm.plugin.expt.hellhound.a.f.c.a.ckK();
    if ((localList == null) || (localList.isEmpty()))
    {
      ac.e("AsyncBizReport", "HABBYGE-MALI, AsyncBizReport, filterBySessionPage, bizIdOfCloudConfig is NULL !!");
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
          e.ckH();
          if ((!e.ckD()) || (localList.contains(str)))
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
      com.tencent.mm.plugin.expt.hellhound.a.f.c.a.cX(localList);
      com.tencent.mm.plugin.expt.hellhound.a.f.c.a.cY(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.a
 * JD-Core Version:    0.7.0.1
 */