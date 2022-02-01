package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.e;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class a
{
  static void f(bge parambge)
  {
    AppMethodBeat.i(122215);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cbn()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(122215);
      return;
    }
    parambge = g(parambge);
    if (TextUtils.isEmpty(parambge))
    {
      AppMethodBeat.o(122215);
      return;
    }
    ad.i("AsyncBizReport", "HABBYGE-MALI, doReport: %s", new Object[] { parambge });
    d.aL(17648, parambge);
    AppMethodBeat.o(122215);
  }
  
  private static String g(bge parambge)
  {
    AppMethodBeat.i(122216);
    try
    {
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.WS(com.tencent.mm.plugin.expt.hellhound.a.f.c.a.cdb());
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
        localJSONObject.put("tbe", parambge.DDR);
        long l = parambge.DDS - parambge.DDR;
        if (l > 0L) {}
        for (;;)
        {
          localJSONObject.put("in", l);
          localJSONObject.put("vv", "2.0");
          localJSONObject.put("content", localObject);
          parambge = localJSONObject.toString();
          AppMethodBeat.o(122216);
          return parambge;
          l = 0L;
        }
        return null;
      }
      catch (JSONException parambge)
      {
        ad.printErrStackTrace("AsyncBizReport", parambge, "HABBYGE-MALI, AsyncBizReport, toJsons: %s", new Object[] { parambge.getMessage() });
        AppMethodBeat.o(122216);
      }
    }
    catch (JSONException parambge)
    {
      ad.printErrStackTrace("AsyncBizReport", parambge, "HABBYGE-MALI, AsyncBizReport, getParamsJSONArray: %s", new Object[] { parambge.getMessage() });
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
    List localList = com.tencent.mm.plugin.expt.hellhound.a.f.c.a.cdc();
    if ((localList == null) || (localList.isEmpty()))
    {
      ad.e("AsyncBizReport", "HABBYGE-MALI, AsyncBizReport, filterBySessionPage, bizIdOfCloudConfig is NULL !!");
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
          e.ccZ();
          if ((!e.ccV()) || (localList.contains(str)))
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
      com.tencent.mm.plugin.expt.hellhound.a.f.c.a.cV(localList);
      com.tencent.mm.plugin.expt.hellhound.a.f.c.a.cW(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.a
 * JD-Core Version:    0.7.0.1
 */