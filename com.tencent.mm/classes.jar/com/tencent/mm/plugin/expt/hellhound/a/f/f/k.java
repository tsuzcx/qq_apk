package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.er;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.e;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class k
{
  private static JSONArray a(Map<String, List<bou>> paramMap, cia paramcia)
  {
    AppMethodBeat.i(184383);
    JSONArray localJSONArray = new JSONArray();
    if ((paramcia.duQ == null) || (paramcia.duQ.isEmpty()))
    {
      AppMethodBeat.o(184383);
      return localJSONArray;
    }
    Object localObject = paramcia.duQ + "_" + paramcia.startTime;
    ae.i("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForUnknowPage, unknonwSessionId: %s", new Object[] { localObject });
    localObject = (List)paramMap.get(localObject);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ae.e("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForUnknowPage, unknowPageFlow NULL");
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
          bou localbou = (bou)((Iterator)localObject).next();
          if (localbou == null) {
            continue;
          }
          paramMap = new JSONObject();
          paramMap.put("pageName", localbou.duQ);
          paramMap.put("tbe", localbou.startTime);
          paramMap.put("in", localbou.duration);
          l1 += localbou.duration;
          localJSONArray.put(paramMap);
          i += 1;
          continue;
        }
        l2 = paramcia.endTime - paramcia.startTime;
        if (l2 >= 5000L) {
          continue;
        }
        paramcia.endTime = (l1 + paramcia.startTime);
        ae.i("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForUnknowPage: %s", new Object[] { localJSONArray.toString() });
      }
      catch (JSONException paramMap)
      {
        int i;
        long l2;
        ae.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", paramMap, "pagePathJsonArrayForUnknowPage json crash", new Object[0]);
        continue;
      }
      AppMethodBeat.o(184383);
      return localJSONArray;
      if (i == 1) {
        paramMap.put("in", l2);
      }
    }
  }
  
  static void a(bow parambow, bot parambot)
  {
    AppMethodBeat.i(122260);
    parambow = b(parambow, parambot);
    if (org.apache.commons.b.g.ef(parambow))
    {
      AppMethodBeat.o(122260);
      return;
    }
    com.tencent.mm.plugin.expt.d.a.cow().qXi.aeg(parambow);
    e.cry();
    boolean bool = e.cru();
    ae.e("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(122260);
      return;
    }
    ago(parambow);
    com.tencent.mm.plugin.expt.d.a.cow().qXi.aef(parambow);
    AppMethodBeat.o(122260);
  }
  
  private static void ago(String paramString)
  {
    AppMethodBeat.i(184384);
    long l = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.afX(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.crN());
    ae.i("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport, lastReportTime: %s", new Object[] { Long.valueOf(l) });
    if (l == -1L)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.afZ(paramString);
      AppMethodBeat.o(184384);
      return;
    }
    if (l == 0L)
    {
      if (agp(paramString)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aga(String.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(184384);
      return;
    }
    String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.afY(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.crN());
    if ("-1".equals(str2))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.afZ(paramString);
      AppMethodBeat.o(184384);
      return;
    }
    String str1;
    if ((str2 == null) || (str2.isEmpty())) {
      str1 = paramString;
    }
    while (i.ar(str1, l))
    {
      if (agp(str1)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aga(String.valueOf(System.currentTimeMillis()));
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
    com.tencent.mm.plugin.expt.hellhound.a.f.c.g.afZ(paramString);
    AppMethodBeat.o(184384);
  }
  
  private static boolean agp(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184385);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184385);
      return false;
    }
    ae.i("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport, reportSessionUBA: %s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.report.a.axP(paramString.replace(',', '#'));
    if (paramString != null)
    {
      er localer1 = new er();
      localer1.ejT = Process.myPid();
      er localer2 = localer1.op(((h)com.tencent.mm.kernel.g.ajO().ajq()).mProcessName);
      localer2.eiF = com.tencent.mm.plugin.report.a.dNr();
      localer2.ejV = paramString.size();
      while (i < paramString.size())
      {
        localer1.ejU = i;
        localer1.oq((String)paramString.get(i)).aLH();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184385);
    return bool;
  }
  
  private static String b(bow parambow, bot parambot)
  {
    AppMethodBeat.i(122261);
    parambot = j.c(parambot);
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
        localJSONObject.put("tbe", parambow.Hcm);
        l = parambow.Hcn - parambow.Hcm;
        if (l > 0L)
        {
          localJSONObject.put("in", l);
          localJSONObject.put("vv", "2.0");
          localJSONArray = new JSONArray();
          localObject1 = parambow.Hco.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (cie)((Iterator)localObject1).next();
          ae.i("HABBYGE-MALI.HellSessionUBAReport", "toJsonOfSessionUBA, session: %s", new Object[] { ((cie)localObject2).sessionId });
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("sessionId", ((cie)localObject2).sessionId);
          ((JSONObject)localObject3).put("tbe", ((cie)localObject2).startTime);
          ((JSONObject)localObject3).put("pagePath", b(parambot, (cie)localObject2));
          l = ((cie)localObject2).endTime - ((cie)localObject2).startTime;
          if (l <= 0L) {
            break label252;
          }
          ((JSONObject)localObject3).put("in", l);
          localJSONArray.put(localObject3);
          continue;
        }
        l = 0L;
      }
      catch (JSONException parambow)
      {
        ae.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", parambow, "HellSessionUBAReport, crash: %s", new Object[] { parambow.getMessage() });
        AppMethodBeat.o(122261);
        return null;
      }
      continue;
      label252:
      l = 0L;
    }
    parambow = parambow.Hcq.iterator();
    if (parambow.hasNext())
    {
      localObject1 = (cia)parambow.next();
      localObject2 = new JSONObject();
      localObject3 = b.afN(((cia)localObject1).duQ);
      ((JSONObject)localObject2).put("sessionId", (String)localObject3 + "_" + ((cia)localObject1).startTime);
      ((JSONObject)localObject2).put("tbe", ((cia)localObject1).startTime);
      ((JSONObject)localObject2).put("pagePath", a(parambot, (cia)localObject1));
      l = ((cia)localObject1).endTime - ((cia)localObject1).startTime;
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
        ae.e("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport content is NULL");
        AppMethodBeat.o(122261);
        return null;
      }
      localJSONObject.put("content", localJSONArray);
      parambow = localJSONObject.toString();
      AppMethodBeat.o(122261);
      return parambow;
      label456:
      l = 0L;
    }
  }
  
  private static JSONArray b(Map<String, List<bou>> paramMap, cie paramcie)
  {
    AppMethodBeat.i(184382);
    JSONArray localJSONArray = new JSONArray();
    Object localObject = (List)paramMap.get(paramcie.sessionId);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ae.e("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForSession: NULL");
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
        bou localbou = (bou)((Iterator)localObject).next();
        if (localbou != null)
        {
          paramMap = new JSONObject();
          paramMap.put("pageName", localbou.duQ);
          paramMap.put("tbe", localbou.startTime);
          paramMap.put("in", localbou.duration);
          l1 += localbou.duration;
          i += 1;
          j.a(paramMap, localbou, true, -1L);
          localJSONArray.put(paramMap);
          continue;
          AppMethodBeat.o(184382);
        }
      }
    }
    catch (JSONException paramMap)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", paramMap, "pagePathJsonArrayForSession json crash", new Object[0]);
    }
    for (;;)
    {
      return localJSONArray;
      long l2 = paramcie.endTime - paramcie.startTime;
      if (l2 < 5000L) {
        paramcie.endTime = (l1 + paramcie.startTime);
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