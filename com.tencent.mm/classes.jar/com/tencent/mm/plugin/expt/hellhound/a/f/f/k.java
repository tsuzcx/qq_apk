package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.kg;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.d;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.protocal.protobuf.dhx;
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
  private static JSONArray a(Map<String, List<cjp>> paramMap, dht paramdht)
  {
    AppMethodBeat.i(184383);
    JSONArray localJSONArray = new JSONArray();
    if ((paramdht.fFe == null) || (paramdht.fFe.isEmpty()))
    {
      AppMethodBeat.o(184383);
      return localJSONArray;
    }
    Object localObject = paramdht.fFe + "_" + paramdht.startTime;
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
          cjp localcjp = (cjp)((Iterator)localObject).next();
          if (localcjp == null) {
            continue;
          }
          paramMap = new JSONObject();
          paramMap.put("pageName", localcjp.fFe);
          paramMap.put("tbe", localcjp.startTime);
          paramMap.put("in", localcjp.duration);
          l1 += localcjp.duration;
          localJSONArray.put(paramMap);
          i += 1;
          continue;
        }
        l2 = paramdht.endTime - paramdht.startTime;
        if (l2 >= 5000L) {
          continue;
        }
        paramdht.endTime = (l1 + paramdht.startTime);
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
  
  static void a(cjr paramcjr, cjo paramcjo)
  {
    AppMethodBeat.i(122260);
    paramcjr = b(paramcjr, paramcjo);
    if (org.apache.commons.b.g.fK(paramcjr))
    {
      AppMethodBeat.o(122260);
      return;
    }
    com.tencent.mm.plugin.expt.d.a.dbw().wcY.awp(paramcjr);
    com.tencent.mm.plugin.expt.hellhound.a.f.b.e.dfa();
    boolean bool = com.tencent.mm.plugin.expt.hellhound.a.f.b.e.deW();
    Log.e("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(122260);
      return;
    }
    aza(paramcjr);
    com.tencent.mm.plugin.expt.d.a.dbw().wcY.awo(paramcjr);
    AppMethodBeat.o(122260);
  }
  
  private static void aza(String paramString)
  {
    AppMethodBeat.i(184384);
    long l = d.ayJ(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.dfp());
    Log.i("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport, lastReportTime: %s", new Object[] { Long.valueOf(l) });
    if (l == -1L)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ayL(paramString);
      AppMethodBeat.o(184384);
      return;
    }
    if (l == 0L)
    {
      if (azb(paramString)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ayM(String.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(184384);
      return;
    }
    String str2 = d.ayK(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.dfp());
    if ("-1".equals(str2))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ayL(paramString);
      AppMethodBeat.o(184384);
      return;
    }
    String str1;
    if ((str2 == null) || (str2.isEmpty())) {
      str1 = paramString;
    }
    while (i.ar(str1, l))
    {
      if (azb(str1)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ayM(String.valueOf(System.currentTimeMillis()));
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
    com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ayL(paramString);
    AppMethodBeat.o(184384);
  }
  
  private static boolean azb(String paramString)
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
    paramString = com.tencent.mm.plugin.report.a.aWX(paramString.replace(',', '#'));
    if (paramString != null)
    {
      kg localkg1 = new kg();
      localkg1.gMJ = Process.myPid();
      kg localkg2 = localkg1.Bi(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).mProcessName);
      localkg2.gKH = com.tencent.mm.plugin.report.a.fBn();
      localkg2.gML = paramString.size();
      while (i < paramString.size())
      {
        localkg1.gMK = i;
        localkg1.Bj((String)paramString.get(i)).bpa();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184385);
    return bool;
  }
  
  private static String b(cjr paramcjr, cjo paramcjo)
  {
    AppMethodBeat.i(122261);
    paramcjo = j.c(paramcjo);
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
        localJSONObject.put("tbe", paramcjr.Trd);
        l = paramcjr.Tre - paramcjr.Trd;
        if (l > 0L)
        {
          localJSONObject.put("in", l);
          localJSONObject.put("vv", "2.0");
          localJSONArray = new JSONArray();
          localObject1 = paramcjr.Trf.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (dhx)((Iterator)localObject1).next();
          Log.i("HABBYGE-MALI.HellSessionUBAReport", "toJsonOfSessionUBA, session: %s", new Object[] { ((dhx)localObject2).sessionId });
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("sessionId", ((dhx)localObject2).sessionId);
          ((JSONObject)localObject3).put("tbe", ((dhx)localObject2).startTime);
          ((JSONObject)localObject3).put("pagePath", b(paramcjo, (dhx)localObject2));
          l = ((dhx)localObject2).endTime - ((dhx)localObject2).startTime;
          if (l <= 0L) {
            break label252;
          }
          ((JSONObject)localObject3).put("in", l);
          localJSONArray.put(localObject3);
          continue;
        }
        l = 0L;
      }
      catch (JSONException paramcjr)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", paramcjr, "HellSessionUBAReport, crash: %s", new Object[] { paramcjr.getMessage() });
        AppMethodBeat.o(122261);
        return null;
      }
      continue;
      label252:
      l = 0L;
    }
    paramcjr = paramcjr.Trg.iterator();
    if (paramcjr.hasNext())
    {
      localObject1 = (dht)paramcjr.next();
      localObject2 = new JSONObject();
      localObject3 = b.ayy(((dht)localObject1).fFe);
      ((JSONObject)localObject2).put("sessionId", (String)localObject3 + "_" + ((dht)localObject1).startTime);
      ((JSONObject)localObject2).put("tbe", ((dht)localObject1).startTime);
      ((JSONObject)localObject2).put("pagePath", a(paramcjo, (dht)localObject1));
      l = ((dht)localObject1).endTime - ((dht)localObject1).startTime;
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
      paramcjr = localJSONObject.toString();
      AppMethodBeat.o(122261);
      return paramcjr;
      label456:
      l = 0L;
    }
  }
  
  private static JSONArray b(Map<String, List<cjp>> paramMap, dhx paramdhx)
  {
    AppMethodBeat.i(184382);
    JSONArray localJSONArray = new JSONArray();
    Object localObject = (List)paramMap.get(paramdhx.sessionId);
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
        cjp localcjp = (cjp)((Iterator)localObject).next();
        if (localcjp != null)
        {
          paramMap = new JSONObject();
          paramMap.put("pageName", localcjp.fFe);
          paramMap.put("tbe", localcjp.startTime);
          paramMap.put("in", localcjp.duration);
          l1 += localcjp.duration;
          i += 1;
          j.a(paramMap, localcjp, true, -1L);
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
      long l2 = paramdhx.endTime - paramdhx.startTime;
      if (l2 < 5000L) {
        paramdhx.endTime = (l1 + paramdhx.startTime);
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