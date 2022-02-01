package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

final class f
{
  private static boolean Xe(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184379);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184379);
      return false;
    }
    ad.i("HellSessionMergeReport", "HABBYGE-MALI, reportSessionMerge: %s", new Object[] { paramString });
    paramString = a.amt(paramString.replace(',', '#'));
    if (paramString != null)
    {
      ce localce1 = new ce();
      localce1.dQO = Process.myPid();
      ce localce2 = localce1.iS(((h)com.tencent.mm.kernel.g.afy().aeZ()).mProcessName);
      localce2.dPH = a.dkE();
      localce2.dQQ = paramString.size();
      while (i < paramString.size())
      {
        localce1.dQP = i;
        localce1.iT((String)paramString.get(i)).aBj();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184379);
    return bool;
  }
  
  private static JSONObject c(bxt parambxt)
  {
    AppMethodBeat.i(122231);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sid", b.WH(parambxt.DDP));
      long l = parambxt.endTime - parambxt.startTime;
      if (l > 0L) {}
      for (;;)
      {
        localJSONObject.put("in", l);
        localJSONObject.put("count", 1);
        AppMethodBeat.o(122231);
        return localJSONObject;
        l = 0L;
      }
      return null;
    }
    catch (Exception parambxt)
    {
      AppMethodBeat.o(122231);
    }
  }
  
  static void f(bge parambge)
  {
    AppMethodBeat.i(122228);
    String str1 = i(parambge);
    long l = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.WR(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cds());
    ad.i("HellSessionMergeReport", "HABBYGE-MALI, doReportSessionMerge, lastReportTime: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (l != -1L)
    {
      if (l == 0L)
      {
        if (Xe(str1)) {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.WW(String.valueOf(System.currentTimeMillis()));
        }
        AppMethodBeat.o(122228);
        return;
      }
      String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.WS(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cds());
      if (!"-1".equals(str2))
      {
        if ((str2 == null) || (str2.isEmpty())) {
          parambge = str1;
        }
        while (i.am(parambge, l))
        {
          if (Xe(parambge)) {
            com.tencent.mm.plugin.expt.hellhound.a.f.c.g.WW(String.valueOf(System.currentTimeMillis()));
          }
          AppMethodBeat.o(122228);
          return;
          parambge = str2;
          if (str1 != null)
          {
            parambge = str2;
            if (!str1.isEmpty()) {
              parambge = str2 + "|" + str1;
            }
          }
        }
      }
    }
    if ((str1 == null) || (str1.isEmpty()))
    {
      AppMethodBeat.o(122228);
      return;
    }
    parambge = com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cds();
    if ((parambge == null) || (parambge.isEmpty()))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.WW(System.currentTimeMillis() + "@" + str1);
      AppMethodBeat.o(122228);
      return;
    }
    if ("-1".equals(parambge))
    {
      ad.e("HellSessionReportCache", "HABBYGE-MALI, storeSessionDetail not login");
      AppMethodBeat.o(122228);
      return;
    }
    if (parambge.split("@").length <= 1) {}
    for (parambge = parambge + "@" + str1;; parambge = parambge + "|" + str1)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.WW(parambge);
      AppMethodBeat.o(122228);
      return;
    }
  }
  
  private static String i(bge parambge)
  {
    AppMethodBeat.i(184378);
    Object localObject1;
    Object localObject3;
    String str;
    JSONObject localJSONObject;
    long l2;
    long l1;
    for (;;)
    {
      try
      {
        localObject1 = new HashMap();
        localObject2 = parambge.DDT.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (bxx)((Iterator)localObject2).next();
        str = b.Wv(((bxx)localObject3).sessionId);
        if (str == null) {
          continue;
        }
        if (!((Map)localObject1).containsKey(str)) {
          break label217;
        }
        localJSONObject = (JSONObject)((Map)localObject1).get(str);
        if (localJSONObject == null)
        {
          localObject3 = k((bxx)localObject3);
          if (localObject3 == null) {
            continue;
          }
          ((Map)localObject1).put(str, localObject3);
          continue;
        }
        l2 = localJSONObject.optLong("in");
      }
      catch (Exception parambge)
      {
        ad.printErrStackTrace("HellSessionMergeReport", parambge, "HABBYGE-MALI, HellSessionMergereport crash: %s", new Object[] { parambge.getMessage() });
        AppMethodBeat.o(184378);
        return null;
      }
      l1 = ((bxx)localObject3).endTime - ((bxx)localObject3).startTime;
      if (l1 <= 0L) {
        break label608;
      }
      localJSONObject.put("in", l1 + l2);
      localJSONObject.put("count", localJSONObject.optInt("count") + 1);
      ((Map)localObject1).put(str, localJSONObject);
      continue;
      label217:
      localObject3 = k((bxx)localObject3);
      if (localObject3 != null) {
        ((Map)localObject1).put(str, localObject3);
      }
    }
    Object localObject2 = parambge.DDV.iterator();
    for (;;)
    {
      label253:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bxt)((Iterator)localObject2).next();
        str = b.WH(((bxt)localObject3).DDP);
        if (str != null) {
          if (((Map)localObject1).containsKey(str))
          {
            localJSONObject = (JSONObject)((Map)localObject1).get(str);
            if (localJSONObject == null)
            {
              localObject3 = c((bxt)localObject3);
              if (localObject3 == null) {
                continue;
              }
              ((Map)localObject1).put(str, localObject3);
              continue;
            }
            l2 = localJSONObject.optLong("in");
            l1 = ((bxt)localObject3).endTime - ((bxt)localObject3).startTime;
            if (l1 <= 0L) {
              break label613;
            }
          }
        }
      }
    }
    for (;;)
    {
      localJSONObject.put("in", l1 + l2);
      localJSONObject.put("count", localJSONObject.optInt("count") + 1);
      ((Map)localObject1).put(str, localJSONObject);
      break label253;
      localObject3 = c((bxt)localObject3);
      if (localObject3 == null) {
        break label253;
      }
      ((Map)localObject1).put(str, localObject3);
      break label253;
      localObject2 = new JSONArray();
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((JSONArray)localObject2).put(((Map.Entry)((Iterator)localObject1).next()).getValue());
      }
      int i = ((JSONArray)localObject2).length();
      if (i <= 0)
      {
        AppMethodBeat.o(184378);
        return null;
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("tbe", parambge.DDR);
      l1 = parambge.DDS - parambge.DDR;
      if (l1 > 0L) {}
      for (;;)
      {
        ((JSONObject)localObject1).put("in", l1);
        ((JSONObject)localObject1).put("vv", "2.0");
        ((JSONObject)localObject1).put("content", localObject2);
        parambge = ((JSONObject)localObject1).toString();
        AppMethodBeat.o(184378);
        return parambge;
        l1 = 0L;
      }
      label608:
      l1 = 0L;
      break;
      label613:
      l1 = 0L;
    }
  }
  
  private static JSONObject k(bxx parambxx)
  {
    AppMethodBeat.i(122230);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sid", b.Wv(parambxx.sessionId));
      long l = parambxx.endTime - parambxx.startTime;
      if (l > 0L) {}
      for (;;)
      {
        localJSONObject.put("in", l);
        localJSONObject.put("count", 1);
        AppMethodBeat.o(122230);
        return localJSONObject;
        l = 0L;
      }
      return null;
    }
    catch (Exception parambxx)
    {
      AppMethodBeat.o(122230);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.f
 * JD-Core Version:    0.7.0.1
 */