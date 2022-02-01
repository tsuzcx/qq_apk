package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hz;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.e;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class k
{
  private static JSONArray a(Map<String, List<cbm>> paramMap, cyh paramcyh)
  {
    AppMethodBeat.i(184383);
    JSONArray localJSONArray = new JSONArray();
    if ((paramcyh.dMl == null) || (paramcyh.dMl.isEmpty()))
    {
      AppMethodBeat.o(184383);
      return localJSONArray;
    }
    Object localObject = paramcyh.dMl + "_" + paramcyh.startTime;
    Log.i("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForUnknowPage, unknonwSessionId: %s", new Object[] { localObject });
    localObject = (List)paramMap.get(localObject);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      Log.e("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForUnknowPage, unknowPageFlow NULL");
      AppMethodBeat.o(184383);
      return localJSONArray;
    }
    paramMap = null;
    long l1 = 0L;
    for (;;)
    {
      try
      {
        localObject = ((List)localObject).iterator();
        i = 0;
        if (((Iterator)localObject).hasNext())
        {
          cbm localcbm = (cbm)((Iterator)localObject).next();
          if (localcbm == null) {
            continue;
          }
          paramMap = new JSONObject();
          paramMap.put("pageName", localcbm.dMl);
          paramMap.put("tbe", localcbm.startTime);
          paramMap.put("in", localcbm.duration);
          l1 += localcbm.duration;
          localJSONArray.put(paramMap);
          i += 1;
          continue;
        }
        l2 = paramcyh.endTime - paramcyh.startTime;
        if (l2 >= 5000L) {
          continue;
        }
        paramcyh.endTime = (l1 + paramcyh.startTime);
        Log.i("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForUnknowPage: %s", new Object[] { localJSONArray.toString() });
      }
      catch (JSONException paramMap)
      {
        int i;
        long l2;
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", paramMap, "pagePathJsonArrayForUnknowPage json crash", new Object[0]);
        continue;
      }
      AppMethodBeat.o(184383);
      return localJSONArray;
      if (i == 1) {
        paramMap.put("in", l2);
      }
    }
  }
  
  static void a(cbo paramcbo, cbl paramcbl)
  {
    AppMethodBeat.i(122260);
    paramcbo = b(paramcbo, paramcbl);
    if (org.apache.commons.b.g.eP(paramcbo))
    {
      AppMethodBeat.o(122260);
      return;
    }
    com.tencent.mm.plugin.expt.d.a.cMI().sxs.aoq(paramcbo);
    e.cQg();
    boolean bool = e.cQc();
    Log.e("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(122260);
      return;
    }
    aqZ(paramcbo);
    com.tencent.mm.plugin.expt.d.a.cMI().sxs.aop(paramcbo);
    AppMethodBeat.o(122260);
  }
  
  private static void aqZ(String paramString)
  {
    AppMethodBeat.i(184384);
    long l = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.aqI(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cQv());
    Log.i("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport, lastReportTime: %s", new Object[] { Long.valueOf(l) });
    if (l == -1L)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqK(paramString);
      AppMethodBeat.o(184384);
      return;
    }
    if (l == 0L)
    {
      if (ara(paramString)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqL(String.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(184384);
      return;
    }
    String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.aqJ(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cQv());
    if ("-1".equals(str2))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqK(paramString);
      AppMethodBeat.o(184384);
      return;
    }
    String str1;
    if ((str2 == null) || (str2.isEmpty())) {
      str1 = paramString;
    }
    while (i.aq(str1, l))
    {
      if (ara(str1)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqL(String.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(184384);
      return;
      str1 = str2;
      if (paramString != null)
      {
        str1 = str2;
        if (!paramString.isEmpty()) {
          str1 = str2 + "|" + paramString;
        }
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqK(paramString);
    AppMethodBeat.o(184384);
  }
  
  private static boolean ara(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184385);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184385);
      return false;
    }
    Log.i("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport, reportSessionUBA: %s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.report.a.aMr(paramString.replace(',', '#'));
    if (paramString != null)
    {
      hz localhz1 = new hz();
      localhz1.eMF = Process.myPid();
      hz localhz2 = localhz1.vJ(((h)com.tencent.mm.kernel.g.aAe().azG()).mProcessName);
      localhz2.eLd = com.tencent.mm.plugin.report.a.eOr();
      localhz2.eMH = paramString.size();
      while (i < paramString.size())
      {
        localhz1.eMG = i;
        localhz1.vK((String)paramString.get(i)).bfK();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184385);
    return bool;
  }
  
  private static String b(cbo paramcbo, cbl paramcbl)
  {
    AppMethodBeat.i(122261);
    paramcbl = j.c(paramcbl);
    JSONObject localJSONObject;
    long l;
    JSONArray localJSONArray;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("tbe", paramcbo.Mhp);
        l = paramcbo.Mhq - paramcbo.Mhp;
        if (l > 0L)
        {
          localJSONObject.put("in", l);
          localJSONObject.put("vv", "2.0");
          localJSONArray = new JSONArray();
          localObject1 = paramcbo.Mhr.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (cyl)((Iterator)localObject1).next();
          Log.i("HABBYGE-MALI.HellSessionUBAReport", "toJsonOfSessionUBA, session: %s", new Object[] { ((cyl)localObject2).sessionId });
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("sessionId", ((cyl)localObject2).sessionId);
          ((JSONObject)localObject3).put("tbe", ((cyl)localObject2).startTime);
          ((JSONObject)localObject3).put("pagePath", b(paramcbl, (cyl)localObject2));
          l = ((cyl)localObject2).endTime - ((cyl)localObject2).startTime;
          if (l <= 0L) {
            break label252;
          }
          ((JSONObject)localObject3).put("in", l);
          localJSONArray.put(localObject3);
          continue;
        }
        l = 0L;
      }
      catch (JSONException paramcbo)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", paramcbo, "HellSessionUBAReport, crash: %s", new Object[] { paramcbo.getMessage() });
        AppMethodBeat.o(122261);
        return null;
      }
      continue;
      label252:
      l = 0L;
    }
    paramcbo = paramcbo.Mht.iterator();
    if (paramcbo.hasNext())
    {
      localObject1 = (cyh)paramcbo.next();
      localObject2 = new JSONObject();
      localObject3 = b.aqy(((cyh)localObject1).dMl);
      ((JSONObject)localObject2).put("sessionId", (String)localObject3 + "_" + ((cyh)localObject1).startTime);
      ((JSONObject)localObject2).put("tbe", ((cyh)localObject1).startTime);
      ((JSONObject)localObject2).put("pagePath", a(paramcbl, (cyh)localObject1));
      l = ((cyh)localObject1).endTime - ((cyh)localObject1).startTime;
      if (l <= 0L) {
        break label456;
      }
    }
    for (;;)
    {
      ((JSONObject)localObject2).put("in", l);
      localJSONArray.put(localObject2);
      break;
      if (localJSONArray.length() <= 0)
      {
        Log.e("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport content is NULL");
        AppMethodBeat.o(122261);
        return null;
      }
      localJSONObject.put("content", localJSONArray);
      paramcbo = localJSONObject.toString();
      AppMethodBeat.o(122261);
      return paramcbo;
      label456:
      l = 0L;
    }
  }
  
  private static JSONArray b(Map<String, List<cbm>> paramMap, cyl paramcyl)
  {
    AppMethodBeat.i(184382);
    JSONArray localJSONArray = new JSONArray();
    Object localObject = (List)paramMap.get(paramcyl.sessionId);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      Log.e("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForSession: NULL");
      AppMethodBeat.o(184382);
      return localJSONArray;
    }
    paramMap = null;
    long l1 = 0L;
    int i;
    try
    {
      localObject = ((List)localObject).iterator();
      i = 0;
      while (((Iterator)localObject).hasNext())
      {
        cbm localcbm = (cbm)((Iterator)localObject).next();
        if (localcbm != null)
        {
          paramMap = new JSONObject();
          paramMap.put("pageName", localcbm.dMl);
          paramMap.put("tbe", localcbm.startTime);
          paramMap.put("in", localcbm.duration);
          l1 += localcbm.duration;
          i += 1;
          j.a(paramMap, localcbm, true, -1L);
          localJSONArray.put(paramMap);
          continue;
          AppMethodBeat.o(184382);
        }
      }
    }
    catch (JSONException paramMap)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", paramMap, "pagePathJsonArrayForSession json crash", new Object[0]);
    }
    for (;;)
    {
      return localJSONArray;
      long l2 = paramcyl.endTime - paramcyl.startTime;
      if (l2 < 5000L) {
        paramcyl.endTime = (l1 + paramcyl.startTime);
      } else if (i == 1) {
        paramMap.put("in", l2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.k
 * JD-Core Version:    0.7.0.1
 */