package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cg;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.e;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class k
{
  private static void Xh(String paramString)
  {
    AppMethodBeat.i(184384);
    long l = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.WR(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cdp());
    ad.i("HellSessionUBAReport", "HABBYGE-MALI, HellSessionUBAReport, lastReportTime: %s", new Object[] { Long.valueOf(l) });
    if (l == -1L)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.WT(paramString);
      AppMethodBeat.o(184384);
      return;
    }
    if (l == 0L)
    {
      if (Xi(paramString)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.c.g.WU(String.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(184384);
      return;
    }
    String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.WS(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cdp());
    if ("-1".equals(str2))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.WT(paramString);
      AppMethodBeat.o(184384);
      return;
    }
    String str1;
    if ((str2 == null) || (str2.isEmpty())) {
      str1 = paramString;
    }
    while (i.am(str1, l))
    {
      if (Xi(str1)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.c.g.WU(String.valueOf(System.currentTimeMillis()));
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
    com.tencent.mm.plugin.expt.hellhound.a.f.c.g.WT(paramString);
    AppMethodBeat.o(184384);
  }
  
  private static boolean Xi(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184385);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184385);
      return false;
    }
    ad.i("HellSessionUBAReport", "HABBYGE-MALI, HellSessionUBAReport, reportSessionUBA: %s", new Object[] { paramString });
    paramString = a.amt(paramString.replace(',', '#'));
    if (paramString != null)
    {
      cg localcg1 = new cg();
      localcg1.dQO = Process.myPid();
      cg localcg2 = localcg1.iW(((h)com.tencent.mm.kernel.g.afy().aeZ()).mProcessName);
      localcg2.dPH = a.dkE();
      localcg2.dQQ = paramString.size();
      while (i < paramString.size())
      {
        localcg1.dQP = i;
        localcg1.iX((String)paramString.get(i)).aBj();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184385);
    return bool;
  }
  
  private static JSONArray a(Map<String, List<bgc>> paramMap, bxt parambxt)
  {
    AppMethodBeat.i(184383);
    JSONArray localJSONArray = new JSONArray();
    if ((parambxt.DDP == null) || (parambxt.DDP.isEmpty()))
    {
      AppMethodBeat.o(184383);
      return localJSONArray;
    }
    Object localObject = parambxt.DDP + "_" + parambxt.startTime;
    ad.i("HellSessionUBAReport", "HABBYGE-MALI, pagePathJsonArrayForUnknowPage, unknonwSessionId: %s", new Object[] { localObject });
    localObject = (List)paramMap.get(localObject);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ad.e("HellSessionUBAReport", "HABBYGE-MALI, pagePathJsonArrayForUnknowPage, unknowPageFlow NULL");
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
          bgc localbgc = (bgc)((Iterator)localObject).next();
          if (localbgc == null) {
            continue;
          }
          paramMap = new JSONObject();
          paramMap.put("pageName", localbgc.DDP);
          paramMap.put("tbe", localbgc.startTime);
          paramMap.put("in", localbgc.duration);
          l1 += localbgc.duration;
          localJSONArray.put(paramMap);
          i += 1;
          continue;
        }
        l2 = parambxt.endTime - parambxt.startTime;
        if (l2 >= 5000L) {
          continue;
        }
        parambxt.endTime = (l1 + parambxt.startTime);
        ad.i("HellSessionUBAReport", "HABBYGE-MALI, pagePathJsonArrayForUnknowPage: %s", new Object[] { localJSONArray.toString() });
      }
      catch (JSONException paramMap)
      {
        int i;
        long l2;
        ad.printErrStackTrace("HellSessionUBAReport", paramMap, "HABBYGE-MALI, pagePathJsonArrayForUnknowPage json crash", new Object[0]);
        continue;
      }
      AppMethodBeat.o(184383);
      return localJSONArray;
      if (i == 1) {
        paramMap.put("in", l2);
      }
    }
  }
  
  static void a(bge parambge, bgb parambgb)
  {
    AppMethodBeat.i(122260);
    e.ccZ();
    boolean bool = e.ccV();
    ad.e("HellSessionUBAReport", "HABBYGE-MALI, HellSessionUBAReport: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(122260);
      return;
    }
    Xh(b(parambge, parambgb));
    AppMethodBeat.o(122260);
  }
  
  private static String b(bge parambge, bgb parambgb)
  {
    AppMethodBeat.i(122261);
    parambgb = j.c(parambgb);
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
        localJSONObject.put("tbe", parambge.DDR);
        l = parambge.DDS - parambge.DDR;
        if (l > 0L)
        {
          localJSONObject.put("in", l);
          localJSONObject.put("vv", "2.0");
          localJSONArray = new JSONArray();
          localObject1 = parambge.DDT.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (bxx)((Iterator)localObject1).next();
          ad.i("HellSessionUBAReport", "HABBYGE-MALI, toJsonOfSessionUBA, session: %s", new Object[] { ((bxx)localObject2).sessionId });
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("sessionId", ((bxx)localObject2).sessionId);
          ((JSONObject)localObject3).put("tbe", ((bxx)localObject2).startTime);
          ((JSONObject)localObject3).put("pagePath", b(parambgb, (bxx)localObject2));
          l = ((bxx)localObject2).endTime - ((bxx)localObject2).startTime;
          if (l <= 0L) {
            break label252;
          }
          ((JSONObject)localObject3).put("in", l);
          localJSONArray.put(localObject3);
          continue;
        }
        l = 0L;
      }
      catch (JSONException parambge)
      {
        ad.printErrStackTrace("HellSessionUBAReport", parambge, "HABBYGE-MALI, HellSessionUBAReport, crash: %s", new Object[] { parambge.getMessage() });
        AppMethodBeat.o(122261);
        return null;
      }
      continue;
      label252:
      l = 0L;
    }
    parambge = parambge.DDV.iterator();
    if (parambge.hasNext())
    {
      localObject1 = (bxt)parambge.next();
      localObject2 = new JSONObject();
      localObject3 = b.WH(((bxt)localObject1).DDP);
      ((JSONObject)localObject2).put("sessionId", (String)localObject3 + "_" + ((bxt)localObject1).startTime);
      ((JSONObject)localObject2).put("tbe", ((bxt)localObject1).startTime);
      ((JSONObject)localObject2).put("pagePath", a(parambgb, (bxt)localObject1));
      l = ((bxt)localObject1).endTime - ((bxt)localObject1).startTime;
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
        ad.e("HellSessionUBAReport", "HABBYGE-MALI, HellSessionUBAReport content is NULL");
        AppMethodBeat.o(122261);
        return null;
      }
      localJSONObject.put("content", localJSONArray);
      parambge = localJSONObject.toString();
      AppMethodBeat.o(122261);
      return parambge;
      label456:
      l = 0L;
    }
  }
  
  private static JSONArray b(Map<String, List<bgc>> paramMap, bxx parambxx)
  {
    AppMethodBeat.i(184382);
    JSONArray localJSONArray = new JSONArray();
    Object localObject = (List)paramMap.get(parambxx.sessionId);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ad.e("HellSessionUBAReport", "HABBYGE-MALI, pagePathJsonArrayForSession: NULL");
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
        bgc localbgc = (bgc)((Iterator)localObject).next();
        if (localbgc != null)
        {
          paramMap = new JSONObject();
          paramMap.put("pageName", localbgc.DDP);
          paramMap.put("tbe", localbgc.startTime);
          paramMap.put("in", localbgc.duration);
          l1 += localbgc.duration;
          i += 1;
          j.a(paramMap, localbgc, true);
          localJSONArray.put(paramMap);
          continue;
          AppMethodBeat.o(184382);
        }
      }
    }
    catch (JSONException paramMap)
    {
      ad.printErrStackTrace("HellSessionUBAReport", paramMap, "HABBYGE-MALI, pagePathJsonArrayForSession json crash", new Object[0]);
    }
    for (;;)
    {
      return localJSONArray;
      long l2 = parambxx.endTime - parambxx.startTime;
      if (l2 < 5000L) {
        parambxx.endTime = (l1 + parambxx.startTime);
      } else if (i == 1) {
        paramMap.put("in", l2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.k
 * JD-Core Version:    0.7.0.1
 */