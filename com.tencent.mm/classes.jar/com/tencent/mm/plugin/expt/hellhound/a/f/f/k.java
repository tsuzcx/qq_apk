package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.e;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chk;
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
  private static JSONArray a(Map<String, List<boc>> paramMap, chg paramchg)
  {
    AppMethodBeat.i(184383);
    JSONArray localJSONArray = new JSONArray();
    if ((paramchg.dtL == null) || (paramchg.dtL.isEmpty()))
    {
      AppMethodBeat.o(184383);
      return localJSONArray;
    }
    Object localObject = paramchg.dtL + "_" + paramchg.startTime;
    ad.i("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForUnknowPage, unknonwSessionId: %s", new Object[] { localObject });
    localObject = (List)paramMap.get(localObject);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ad.e("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForUnknowPage, unknowPageFlow NULL");
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
          boc localboc = (boc)((Iterator)localObject).next();
          if (localboc == null) {
            continue;
          }
          paramMap = new JSONObject();
          paramMap.put("pageName", localboc.dtL);
          paramMap.put("tbe", localboc.startTime);
          paramMap.put("in", localboc.duration);
          l1 += localboc.duration;
          localJSONArray.put(paramMap);
          i += 1;
          continue;
        }
        l2 = paramchg.endTime - paramchg.startTime;
        if (l2 >= 5000L) {
          continue;
        }
        paramchg.endTime = (l1 + paramchg.startTime);
        ad.i("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForUnknowPage: %s", new Object[] { localJSONArray.toString() });
      }
      catch (JSONException paramMap)
      {
        int i;
        long l2;
        ad.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", paramMap, "pagePathJsonArrayForUnknowPage json crash", new Object[0]);
        continue;
      }
      AppMethodBeat.o(184383);
      return localJSONArray;
      if (i == 1) {
        paramMap.put("in", l2);
      }
    }
  }
  
  static void a(boe paramboe, bob parambob)
  {
    AppMethodBeat.i(122260);
    paramboe = b(paramboe, parambob);
    if (org.apache.commons.b.g.ea(paramboe))
    {
      AppMethodBeat.o(122260);
      return;
    }
    com.tencent.mm.plugin.expt.d.a.cng().qPn.adm(paramboe);
    e.cpW();
    boolean bool = e.cpS();
    ad.e("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(122260);
      return;
    }
    afs(paramboe);
    com.tencent.mm.plugin.expt.d.a.cng().qPn.adl(paramboe);
    AppMethodBeat.o(122260);
  }
  
  private static void afs(String paramString)
  {
    AppMethodBeat.i(184384);
    long l = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.afb(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cql());
    ad.i("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport, lastReportTime: %s", new Object[] { Long.valueOf(l) });
    if (l == -1L)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.afd(paramString);
      AppMethodBeat.o(184384);
      return;
    }
    if (l == 0L)
    {
      if (aft(paramString)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.c.g.afe(String.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(184384);
      return;
    }
    String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.afc(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cql());
    if ("-1".equals(str2))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.afd(paramString);
      AppMethodBeat.o(184384);
      return;
    }
    String str1;
    if ((str2 == null) || (str2.isEmpty())) {
      str1 = paramString;
    }
    while (i.ar(str1, l))
    {
      if (aft(str1)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.c.g.afe(String.valueOf(System.currentTimeMillis()));
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
    com.tencent.mm.plugin.expt.hellhound.a.f.c.g.afd(paramString);
    AppMethodBeat.o(184384);
  }
  
  private static boolean aft(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184385);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184385);
      return false;
    }
    ad.i("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport, reportSessionUBA: %s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.report.a.awA(paramString.replace(',', '#'));
    if (paramString != null)
    {
      ep localep1 = new ep();
      localep1.eij = Process.myPid();
      ep localep2 = localep1.nU(((h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName);
      localep2.egV = com.tencent.mm.plugin.report.a.dJZ();
      localep2.eil = paramString.size();
      while (i < paramString.size())
      {
        localep1.eik = i;
        localep1.nV((String)paramString.get(i)).aLk();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184385);
    return bool;
  }
  
  private static String b(boe paramboe, bob parambob)
  {
    AppMethodBeat.i(122261);
    parambob = j.c(parambob);
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
        localJSONObject.put("tbe", paramboe.GIK);
        l = paramboe.GIL - paramboe.GIK;
        if (l > 0L)
        {
          localJSONObject.put("in", l);
          localJSONObject.put("vv", "2.0");
          localJSONArray = new JSONArray();
          localObject1 = paramboe.GIM.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (chk)((Iterator)localObject1).next();
          ad.i("HABBYGE-MALI.HellSessionUBAReport", "toJsonOfSessionUBA, session: %s", new Object[] { ((chk)localObject2).sessionId });
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("sessionId", ((chk)localObject2).sessionId);
          ((JSONObject)localObject3).put("tbe", ((chk)localObject2).startTime);
          ((JSONObject)localObject3).put("pagePath", b(parambob, (chk)localObject2));
          l = ((chk)localObject2).endTime - ((chk)localObject2).startTime;
          if (l <= 0L) {
            break label252;
          }
          ((JSONObject)localObject3).put("in", l);
          localJSONArray.put(localObject3);
          continue;
        }
        l = 0L;
      }
      catch (JSONException paramboe)
      {
        ad.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", paramboe, "HellSessionUBAReport, crash: %s", new Object[] { paramboe.getMessage() });
        AppMethodBeat.o(122261);
        return null;
      }
      continue;
      label252:
      l = 0L;
    }
    paramboe = paramboe.GIO.iterator();
    if (paramboe.hasNext())
    {
      localObject1 = (chg)paramboe.next();
      localObject2 = new JSONObject();
      localObject3 = b.aeR(((chg)localObject1).dtL);
      ((JSONObject)localObject2).put("sessionId", (String)localObject3 + "_" + ((chg)localObject1).startTime);
      ((JSONObject)localObject2).put("tbe", ((chg)localObject1).startTime);
      ((JSONObject)localObject2).put("pagePath", a(parambob, (chg)localObject1));
      l = ((chg)localObject1).endTime - ((chg)localObject1).startTime;
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
        ad.e("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport content is NULL");
        AppMethodBeat.o(122261);
        return null;
      }
      localJSONObject.put("content", localJSONArray);
      paramboe = localJSONObject.toString();
      AppMethodBeat.o(122261);
      return paramboe;
      label456:
      l = 0L;
    }
  }
  
  private static JSONArray b(Map<String, List<boc>> paramMap, chk paramchk)
  {
    AppMethodBeat.i(184382);
    JSONArray localJSONArray = new JSONArray();
    Object localObject = (List)paramMap.get(paramchk.sessionId);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ad.e("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForSession: NULL");
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
        boc localboc = (boc)((Iterator)localObject).next();
        if (localboc != null)
        {
          paramMap = new JSONObject();
          paramMap.put("pageName", localboc.dtL);
          paramMap.put("tbe", localboc.startTime);
          paramMap.put("in", localboc.duration);
          l1 += localboc.duration;
          i += 1;
          j.a(paramMap, localboc, true, -1L);
          localJSONArray.put(paramMap);
          continue;
          AppMethodBeat.o(184382);
        }
      }
    }
    catch (JSONException paramMap)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", paramMap, "pagePathJsonArrayForSession json crash", new Object[0]);
    }
    for (;;)
    {
      return localJSONArray;
      long l2 = paramchk.endTime - paramchk.startTime;
      if (l2 < 5000L) {
        paramchk.endTime = (l1 + paramchk.startTime);
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