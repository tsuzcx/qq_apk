package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.d.d.a.3;
import com.tencent.mm.plugin.expt.d.d.a.8;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.c;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class e
{
  private static boolean agk(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184377);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184377);
      return false;
    }
    ae.i("HABBYGE-MALI.HellSessionDetailReport", "reportSessionDetail: %s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.report.a.axP(paramString.replace(',', '#'));
    if (paramString != null)
    {
      eq localeq1 = new eq();
      localeq1.ejT = Process.myPid();
      eq localeq2 = localeq1.on(((h)com.tencent.mm.kernel.g.ajO().ajq()).mProcessName);
      localeq2.eiF = com.tencent.mm.plugin.report.a.dNr();
      localeq2.ejV = paramString.size();
      while (i < paramString.size())
      {
        localeq1.ejU = i;
        localeq1.oo((String)paramString.get(i)).aLH();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184377);
    return bool;
  }
  
  static void f(bow parambow)
  {
    AppMethodBeat.i(122225);
    if (parambow == null)
    {
      AppMethodBeat.o(122225);
      return;
    }
    String str1 = h(parambow);
    if (org.apache.commons.b.g.ef(str1))
    {
      AppMethodBeat.o(122225);
      return;
    }
    parambow = com.tencent.mm.plugin.expt.d.a.cow().qXi;
    if (com.tencent.mm.plugin.expt.d.b.coz())
    {
      if (!org.apache.commons.b.g.ef(str1)) {
        break label98;
      }
      ae.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionSingleAll data isEmpty!");
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.expt.hellhound.a.coV())
      {
        c.crs();
        if ((!c.cru()) && (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() != 0))
        {
          c.crs();
          if (c.crv()) {
            break;
          }
        }
      }
      AppMethodBeat.o(122225);
      return;
      label98:
      l = System.currentTimeMillis();
      parambow.qXo.execute(new a.8(parambow, l, str1));
    }
    long l = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.afX(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.crP());
    ae.i("HABBYGE-MALI.HellSessionDetailReport", "doReportDetailWhenEvent8, lastReportTime: %s, %s", new Object[] { Long.valueOf(l), str1 });
    if (l != -1L) {
      if (l == 0L) {
        if (agk(str1)) {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.agb(String.valueOf(System.currentTimeMillis()));
        }
      }
    }
    for (;;)
    {
      parambow = com.tencent.mm.plugin.expt.d.a.cow().qXi;
      if (!com.tencent.mm.plugin.expt.d.b.coz()) {
        break label490;
      }
      if (!org.apache.commons.b.g.ef(str1)) {
        break label469;
      }
      ae.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionSingle data isEmpty!");
      AppMethodBeat.o(122225);
      return;
      String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.afY(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.crP());
      if (!"-1".equals(str2))
      {
        if ((str2 == null) || (str2.isEmpty())) {
          parambow = str1;
        }
        for (;;)
        {
          if (!i.ar(parambow, l)) {
            break label319;
          }
          if (!agk(parambow)) {
            break;
          }
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.agb(String.valueOf(System.currentTimeMillis()));
          break;
          parambow = str2;
          if (str1 != null)
          {
            parambow = str2;
            if (!str1.isEmpty()) {
              parambow = str2 + "|" + str1;
            }
          }
        }
      }
      label319:
      if ((str1 != null) && (!str1.isEmpty()))
      {
        parambow = com.tencent.mm.plugin.expt.hellhound.a.f.c.g.crP();
        if ((parambow == null) || (parambow.isEmpty()))
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.agb(System.currentTimeMillis() + "@" + str1);
        }
        else
        {
          if (!"-1".equals(parambow)) {
            break;
          }
          ae.e("HABBYGE-MALI.HellSessionReportCache", "storeSessionDetail not login");
        }
      }
    }
    if (parambow.split("@").length <= 1) {}
    for (parambow = parambow + "@" + str1;; parambow = parambow + "|" + str1)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.agb(parambow);
      break;
    }
    label469:
    l = System.currentTimeMillis();
    parambow.qXo.execute(new a.3(parambow, l, str1));
    label490:
    AppMethodBeat.o(122225);
  }
  
  private static String h(bow parambow)
  {
    AppMethodBeat.i(122226);
    if (parambow.Hcm <= 0L)
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
        localJSONObject1.put("tbe", parambow.Hcm);
        l = parambow.Hcn - parambow.Hcm;
        if (l > 0L)
        {
          localJSONObject1.put("in", l);
          localJSONObject1.put("vv", "2.0");
          localJSONArray = new JSONArray();
          localObject3 = parambow.Hco.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (cie)((Iterator)localObject3).next();
          if (((cie)localObject4).startTime <= 0L) {
            continue;
          }
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("sessionId", ((cie)localObject4).sessionId);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afO(((cie)localObject4).sCx);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localJSONObject2.put("lastSessionId", localObject1);
          localJSONObject2.put("tbe", ((cie)localObject4).startTime);
          l = ((cie)localObject4).endTime - ((cie)localObject4).startTime;
          if (l <= 0L) {
            break label271;
          }
          localJSONObject2.put("in", l);
          localJSONArray.put(localJSONObject2);
          continue;
        }
        l = 0L;
      }
      catch (JSONException parambow)
      {
        ae.printErrStackTrace("HABBYGE-MALI.HellSessionDetailReport", parambow, "HellSessionDetailReport.toJsonOfDetail crash", new Object[0]);
        AppMethodBeat.o(122226);
        return null;
      }
      continue;
      label271:
      l = 0L;
    }
    Object localObject2 = parambow.Hcq.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (cia)((Iterator)localObject2).next();
      if (((cia)localObject3).startTime > 0L)
      {
        localObject4 = new JSONObject();
        parambow = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afN(((cia)localObject3).duQ);
        ((JSONObject)localObject4).put("sessionId", parambow + "_" + ((cia)localObject3).startTime);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afO(((cia)localObject3).sCx);
        parambow = (bow)localObject1;
        if (localObject1 == null) {
          parambow = "";
        }
        ((JSONObject)localObject4).put("lastSessionId", parambow);
        ((JSONObject)localObject4).put("tbe", ((cia)localObject3).startTime);
        l = ((cia)localObject3).endTime - ((cia)localObject3).startTime;
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
      parambow = localJSONObject1.toString();
      AppMethodBeat.o(122226);
      return parambow;
      label500:
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.e
 * JD-Core Version:    0.7.0.1
 */