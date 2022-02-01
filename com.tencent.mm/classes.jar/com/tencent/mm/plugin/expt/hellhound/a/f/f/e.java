package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eo;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.d.d.a.3;
import com.tencent.mm.plugin.expt.d.d.a.8;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.c;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class e
{
  private static boolean afo(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184377);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184377);
      return false;
    }
    ad.i("HABBYGE-MALI.HellSessionDetailReport", "reportSessionDetail: %s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.report.a.awA(paramString.replace(',', '#'));
    if (paramString != null)
    {
      eo localeo1 = new eo();
      localeo1.eij = Process.myPid();
      eo localeo2 = localeo1.nS(((h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName);
      localeo2.egV = com.tencent.mm.plugin.report.a.dJZ();
      localeo2.eil = paramString.size();
      while (i < paramString.size())
      {
        localeo1.eik = i;
        localeo1.nT((String)paramString.get(i)).aLk();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184377);
    return bool;
  }
  
  static void f(boe paramboe)
  {
    AppMethodBeat.i(122225);
    if (paramboe == null)
    {
      AppMethodBeat.o(122225);
      return;
    }
    String str1 = h(paramboe);
    if (org.apache.commons.b.g.ea(str1))
    {
      AppMethodBeat.o(122225);
      return;
    }
    paramboe = com.tencent.mm.plugin.expt.d.a.cng().qPn;
    if (com.tencent.mm.plugin.expt.d.b.cni())
    {
      if (!org.apache.commons.b.g.ea(str1)) {
        break label98;
      }
      ad.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionSingleAll data isEmpty!");
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.expt.hellhound.a.cnt())
      {
        c.cpQ();
        if ((!c.cpS()) && (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() != 0))
        {
          c.cpQ();
          if (c.cpT()) {
            break;
          }
        }
      }
      AppMethodBeat.o(122225);
      return;
      label98:
      l = System.currentTimeMillis();
      paramboe.qPs.execute(new a.8(paramboe, l, str1));
    }
    long l = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.afb(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cqn());
    ad.i("HABBYGE-MALI.HellSessionDetailReport", "doReportDetailWhenEvent8, lastReportTime: %s, %s", new Object[] { Long.valueOf(l), str1 });
    if (l != -1L) {
      if (l == 0L) {
        if (afo(str1)) {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aff(String.valueOf(System.currentTimeMillis()));
        }
      }
    }
    for (;;)
    {
      paramboe = com.tencent.mm.plugin.expt.d.a.cng().qPn;
      if (!com.tencent.mm.plugin.expt.d.b.cni()) {
        break label490;
      }
      if (!org.apache.commons.b.g.ea(str1)) {
        break label469;
      }
      ad.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionSingle data isEmpty!");
      AppMethodBeat.o(122225);
      return;
      String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.afc(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cqn());
      if (!"-1".equals(str2))
      {
        if ((str2 == null) || (str2.isEmpty())) {
          paramboe = str1;
        }
        for (;;)
        {
          if (!i.ar(paramboe, l)) {
            break label319;
          }
          if (!afo(paramboe)) {
            break;
          }
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aff(String.valueOf(System.currentTimeMillis()));
          break;
          paramboe = str2;
          if (str1 != null)
          {
            paramboe = str2;
            if (!str1.isEmpty()) {
              paramboe = str2 + "|" + str1;
            }
          }
        }
      }
      label319:
      if ((str1 != null) && (!str1.isEmpty()))
      {
        paramboe = com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cqn();
        if ((paramboe == null) || (paramboe.isEmpty()))
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aff(System.currentTimeMillis() + "@" + str1);
        }
        else
        {
          if (!"-1".equals(paramboe)) {
            break;
          }
          ad.e("HABBYGE-MALI.HellSessionReportCache", "storeSessionDetail not login");
        }
      }
    }
    if (paramboe.split("@").length <= 1) {}
    for (paramboe = paramboe + "@" + str1;; paramboe = paramboe + "|" + str1)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aff(paramboe);
      break;
    }
    label469:
    l = System.currentTimeMillis();
    paramboe.qPs.execute(new a.3(paramboe, l, str1));
    label490:
    AppMethodBeat.o(122225);
  }
  
  private static String h(boe paramboe)
  {
    AppMethodBeat.i(122226);
    if (paramboe.GIK <= 0L)
    {
      AppMethodBeat.o(122226);
      return null;
    }
    JSONObject localJSONObject1;
    long l;
    JSONArray localJSONArray;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("tbe", paramboe.GIK);
        l = paramboe.GIL - paramboe.GIK;
        if (l > 0L)
        {
          localJSONObject1.put("in", l);
          localJSONObject1.put("vv", "2.0");
          localJSONArray = new JSONArray();
          localObject3 = paramboe.GIM.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (chk)((Iterator)localObject3).next();
          if (((chk)localObject4).startTime <= 0L) {
            continue;
          }
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("sessionId", ((chk)localObject4).sessionId);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeS(((chk)localObject4).ssn);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localJSONObject2.put("lastSessionId", localObject1);
          localJSONObject2.put("tbe", ((chk)localObject4).startTime);
          l = ((chk)localObject4).endTime - ((chk)localObject4).startTime;
          if (l <= 0L) {
            break label271;
          }
          localJSONObject2.put("in", l);
          localJSONArray.put(localJSONObject2);
          continue;
        }
        l = 0L;
      }
      catch (JSONException paramboe)
      {
        ad.printErrStackTrace("HABBYGE-MALI.HellSessionDetailReport", paramboe, "HellSessionDetailReport.toJsonOfDetail crash", new Object[0]);
        AppMethodBeat.o(122226);
        return null;
      }
      continue;
      label271:
      l = 0L;
    }
    Object localObject2 = paramboe.GIO.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (chg)((Iterator)localObject2).next();
      if (((chg)localObject3).startTime > 0L)
      {
        localObject4 = new JSONObject();
        paramboe = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeR(((chg)localObject3).dtL);
        ((JSONObject)localObject4).put("sessionId", paramboe + "_" + ((chg)localObject3).startTime);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeS(((chg)localObject3).ssn);
        paramboe = (boe)localObject1;
        if (localObject1 == null) {
          paramboe = "";
        }
        ((JSONObject)localObject4).put("lastSessionId", paramboe);
        ((JSONObject)localObject4).put("tbe", ((chg)localObject3).startTime);
        l = ((chg)localObject3).endTime - ((chg)localObject3).startTime;
        if (l <= 0L) {
          break label500;
        }
      }
    }
    for (;;)
    {
      ((JSONObject)localObject4).put("in", l);
      localJSONArray.put(localObject4);
      break;
      int i = localJSONArray.length();
      if (i <= 0)
      {
        AppMethodBeat.o(122226);
        return null;
      }
      localJSONObject1.put("content", localJSONArray);
      paramboe = localJSONObject1.toString();
      AppMethodBeat.o(122226);
      return paramboe;
      label500:
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.e
 * JD-Core Version:    0.7.0.1
 */