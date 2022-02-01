package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.du;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.e;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class k
{
  private static JSONArray a(Map<String, List<bju>> paramMap, cco paramcco)
  {
    AppMethodBeat.i(184383);
    JSONArray localJSONArray = new JSONArray();
    if ((paramcco.qoi == null) || (paramcco.qoi.isEmpty()))
    {
      AppMethodBeat.o(184383);
      return localJSONArray;
    }
    Object localObject = paramcco.qoi + "_" + paramcco.startTime;
    ac.i("HellSessionUBAReport", "HABBYGE-MALI, pagePathJsonArrayForUnknowPage, unknonwSessionId: %s", new Object[] { localObject });
    localObject = (List)paramMap.get(localObject);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ac.e("HellSessionUBAReport", "HABBYGE-MALI, pagePathJsonArrayForUnknowPage, unknowPageFlow NULL");
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
          bju localbju = (bju)((Iterator)localObject).next();
          if (localbju == null) {
            continue;
          }
          paramMap = new JSONObject();
          paramMap.put("pageName", localbju.qoi);
          paramMap.put("tbe", localbju.startTime);
          paramMap.put("in", localbju.duration);
          l1 += localbju.duration;
          localJSONArray.put(paramMap);
          i += 1;
          continue;
        }
        l2 = paramcco.endTime - paramcco.startTime;
        if (l2 >= 5000L) {
          continue;
        }
        paramcco.endTime = (l1 + paramcco.startTime);
        ac.i("HellSessionUBAReport", "HABBYGE-MALI, pagePathJsonArrayForUnknowPage: %s", new Object[] { localJSONArray.toString() });
      }
      catch (JSONException paramMap)
      {
        int i;
        long l2;
        ac.printErrStackTrace("HellSessionUBAReport", paramMap, "HABBYGE-MALI, pagePathJsonArrayForUnknowPage json crash", new Object[0]);
        continue;
      }
      AppMethodBeat.o(184383);
      return localJSONArray;
      if (i == 1) {
        paramMap.put("in", l2);
      }
    }
  }
  
  static void a(bjw parambjw, bjt parambjt)
  {
    AppMethodBeat.i(122260);
    e.ckH();
    boolean bool = e.ckD();
    ac.e("HellSessionUBAReport", "HABBYGE-MALI, HellSessionUBAReport: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(122260);
      return;
    }
    abE(b(parambjw, parambjt));
    AppMethodBeat.o(122260);
  }
  
  private static void abE(String paramString)
  {
    AppMethodBeat.i(184384);
    long l = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.abo(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ckX());
    ac.i("HellSessionUBAReport", "HABBYGE-MALI, HellSessionUBAReport, lastReportTime: %s", new Object[] { Long.valueOf(l) });
    if (l == -1L)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.abq(paramString);
      AppMethodBeat.o(184384);
      return;
    }
    if (l == 0L)
    {
      if (abF(paramString)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.c.g.abr(String.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(184384);
      return;
    }
    String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.abp(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ckX());
    if ("-1".equals(str2))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.abq(paramString);
      AppMethodBeat.o(184384);
      return;
    }
    String str1;
    if ((str2 == null) || (str2.isEmpty())) {
      str1 = paramString;
    }
    while (i.ao(str1, l))
    {
      if (abF(str1)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.c.g.abr(String.valueOf(System.currentTimeMillis()));
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
    com.tencent.mm.plugin.expt.hellhound.a.f.c.g.abq(paramString);
    AppMethodBeat.o(184384);
  }
  
  private static boolean abF(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184385);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184385);
      return false;
    }
    ac.i("HellSessionUBAReport", "HABBYGE-MALI, HellSessionUBAReport, reportSessionUBA: %s", new Object[] { paramString });
    paramString = a.arA(paramString.replace(',', '#'));
    if (paramString != null)
    {
      du localdu1 = new du();
      localdu1.dSD = Process.myPid();
      du localdu2 = localdu1.lM(((h)com.tencent.mm.kernel.g.agO().agp()).mProcessName);
      localdu2.dRy = a.dyH();
      localdu2.dSF = paramString.size();
      while (i < paramString.size())
      {
        localdu1.dSE = i;
        localdu1.lN((String)paramString.get(i)).aHZ();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184385);
    return bool;
  }
  
  private static String b(bjw parambjw, bjt parambjt)
  {
    AppMethodBeat.i(122261);
    parambjt = j.c(parambjt);
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
        localJSONObject.put("tbe", parambjw.EZm);
        l = parambjw.EZn - parambjw.EZm;
        if (l > 0L)
        {
          localJSONObject.put("in", l);
          localJSONObject.put("vv", "2.0");
          localJSONArray = new JSONArray();
          localObject1 = parambjw.EZo.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ccs)((Iterator)localObject1).next();
          ac.i("HellSessionUBAReport", "HABBYGE-MALI, toJsonOfSessionUBA, session: %s", new Object[] { ((ccs)localObject2).sessionId });
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("sessionId", ((ccs)localObject2).sessionId);
          ((JSONObject)localObject3).put("tbe", ((ccs)localObject2).startTime);
          ((JSONObject)localObject3).put("pagePath", b(parambjt, (ccs)localObject2));
          l = ((ccs)localObject2).endTime - ((ccs)localObject2).startTime;
          if (l <= 0L) {
            break label252;
          }
          ((JSONObject)localObject3).put("in", l);
          localJSONArray.put(localObject3);
          continue;
        }
        l = 0L;
      }
      catch (JSONException parambjw)
      {
        ac.printErrStackTrace("HellSessionUBAReport", parambjw, "HABBYGE-MALI, HellSessionUBAReport, crash: %s", new Object[] { parambjw.getMessage() });
        AppMethodBeat.o(122261);
        return null;
      }
      continue;
      label252:
      l = 0L;
    }
    parambjw = parambjw.EZq.iterator();
    if (parambjw.hasNext())
    {
      localObject1 = (cco)parambjw.next();
      localObject2 = new JSONObject();
      localObject3 = b.abe(((cco)localObject1).qoi);
      ((JSONObject)localObject2).put("sessionId", (String)localObject3 + "_" + ((cco)localObject1).startTime);
      ((JSONObject)localObject2).put("tbe", ((cco)localObject1).startTime);
      ((JSONObject)localObject2).put("pagePath", a(parambjt, (cco)localObject1));
      l = ((cco)localObject1).endTime - ((cco)localObject1).startTime;
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
        ac.e("HellSessionUBAReport", "HABBYGE-MALI, HellSessionUBAReport content is NULL");
        AppMethodBeat.o(122261);
        return null;
      }
      localJSONObject.put("content", localJSONArray);
      parambjw = localJSONObject.toString();
      AppMethodBeat.o(122261);
      return parambjw;
      label456:
      l = 0L;
    }
  }
  
  private static JSONArray b(Map<String, List<bju>> paramMap, ccs paramccs)
  {
    AppMethodBeat.i(184382);
    JSONArray localJSONArray = new JSONArray();
    Object localObject = (List)paramMap.get(paramccs.sessionId);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ac.e("HellSessionUBAReport", "HABBYGE-MALI, pagePathJsonArrayForSession: NULL");
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
        bju localbju = (bju)((Iterator)localObject).next();
        if (localbju != null)
        {
          paramMap = new JSONObject();
          paramMap.put("pageName", localbju.qoi);
          paramMap.put("tbe", localbju.startTime);
          paramMap.put("in", localbju.duration);
          l1 += localbju.duration;
          i += 1;
          j.a(paramMap, localbju, true);
          localJSONArray.put(paramMap);
          continue;
          AppMethodBeat.o(184382);
        }
      }
    }
    catch (JSONException paramMap)
    {
      ac.printErrStackTrace("HellSessionUBAReport", paramMap, "HABBYGE-MALI, pagePathJsonArrayForSession json crash", new Object[0]);
    }
    for (;;)
    {
      return localJSONArray;
      long l2 = paramccs.endTime - paramccs.startTime;
      if (l2 < 5000L) {
        paramccs.endTime = (l1 + paramccs.startTime);
      } else if (i == 1) {
        paramMap.put("in", l2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.k
 * JD-Core Version:    0.7.0.1
 */