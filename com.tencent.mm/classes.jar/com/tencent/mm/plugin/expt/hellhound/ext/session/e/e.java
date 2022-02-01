package com.tencent.mm.plugin.expt.hellhound.ext.session.e;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mw;
import com.tencent.mm.plugin.expt.edge.d.a.3;
import com.tencent.mm.plugin.expt.edge.d.a.8;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.d;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.c;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class e
{
  private static boolean atb(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(184377);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184377);
      return false;
    }
    Log.i("HABBYGE-MALI.HellSessionDetailReport", "reportSessionDetail: %s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.report.a.aUn(paramString.replace(',', '#'));
    if (paramString != null)
    {
      mw localmw = new mw();
      localmw.jcB = Process.myPid();
      localmw.iAp = localmw.F("PName", ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName, true);
      localmw.iZX = com.tencent.mm.plugin.report.a.gNH();
      localmw.jcD = paramString.size();
      int i = 0;
      while (i < paramString.size())
      {
        localmw.jcC = i;
        localmw.jcE = localmw.F("DataContent", (String)paramString.get(i), false);
        localmw.bMH();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184377);
    return bool;
  }
  
  static void f(czw paramczw)
  {
    AppMethodBeat.i(122225);
    if (paramczw == null)
    {
      AppMethodBeat.o(122225);
      return;
    }
    String str1 = h(paramczw);
    if (org.apache.commons.c.i.hm(str1))
    {
      AppMethodBeat.o(122225);
      return;
    }
    paramczw = com.tencent.mm.plugin.expt.edge.a.dHT().zxY;
    if (com.tencent.mm.plugin.expt.edge.b.dHV())
    {
      if (!org.apache.commons.c.i.hm(str1)) {
        break label98;
      }
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionSingleAll data isEmpty!");
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.expt.hellhound.a.dIK())
      {
        c.dLJ();
        if ((!c.dLL()) && (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() != 0))
        {
          c.dLJ();
          if (c.dLM()) {
            break;
          }
        }
      }
      AppMethodBeat.o(122225);
      return;
      label98:
      com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionSingleAll data : ".concat(String.valueOf(str1)));
      l = System.currentTimeMillis();
      paramczw.zzP.post(new a.8(paramczw, l, str1));
    }
    long l = d.asO(com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.dMf());
    Log.i("HABBYGE-MALI.HellSessionDetailReport", "doReportDetailWhenEvent8, lastReportTime: %s, %s", new Object[] { Long.valueOf(l), str1 });
    if (l != -1L) {
      if (l == 0L) {
        if (atb(str1)) {
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.asS(String.valueOf(System.currentTimeMillis()));
        }
      }
    }
    for (;;)
    {
      paramczw = com.tencent.mm.plugin.expt.edge.a.dHT().zxY;
      if (!com.tencent.mm.plugin.expt.edge.b.dHV()) {
        break label523;
      }
      if (!org.apache.commons.c.i.hm(str1)) {
        break label486;
      }
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionSingle data isEmpty!");
      AppMethodBeat.o(122225);
      return;
      String str2 = d.asP(com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.dMf());
      if (!"-1".equals(str2))
      {
        if ((str2 == null) || (str2.isEmpty())) {
          paramczw = str1;
        }
        for (;;)
        {
          if (!i.az(paramczw, l)) {
            break label335;
          }
          if (!atb(paramczw)) {
            break;
          }
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.asS(String.valueOf(System.currentTimeMillis()));
          break;
          paramczw = str2;
          if (str1 != null)
          {
            paramczw = str2;
            if (!str1.isEmpty()) {
              paramczw = str2 + "|" + str1;
            }
          }
        }
      }
      label335:
      if ((str1 != null) && (!str1.isEmpty()))
      {
        paramczw = com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.dMf();
        if ((paramczw == null) || (paramczw.isEmpty()))
        {
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.asS(System.currentTimeMillis() + "@" + str1);
        }
        else
        {
          if (!"-1".equals(paramczw)) {
            break;
          }
          Log.e("HABBYGE-MALI.HellSessionReportCache", "storeSessionDetail not login");
        }
      }
    }
    if (paramczw.split("@").length <= 1) {}
    for (paramczw = paramczw + "@" + str1;; paramczw = paramczw + "|" + str1)
    {
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.asS(paramczw);
      break;
    }
    label486:
    com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionSingle data : ".concat(String.valueOf(str1)));
    l = System.currentTimeMillis();
    paramczw.zzP.post(new a.3(paramczw, l, str1));
    label523:
    AppMethodBeat.o(122225);
  }
  
  private static String h(czw paramczw)
  {
    AppMethodBeat.i(122226);
    if (paramczw.aaFl <= 0L)
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
        localJSONObject1.put("tbe", paramczw.aaFl);
        l = paramczw.aaFm - paramczw.aaFl;
        if (l > 0L)
        {
          localJSONObject1.put("in", l);
          localJSONObject1.put("vv", "2.0");
          localJSONArray = new JSONArray();
          localObject3 = paramczw.aaFn.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (eah)((Iterator)localObject3).next();
          if (((eah)localObject4).startTime <= 0L) {
            continue;
          }
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("sessionId", ((eah)localObject4).sessionId);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asE(((eah)localObject4).qkQ);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localJSONObject2.put("lastSessionId", localObject1);
          localJSONObject2.put("tbe", ((eah)localObject4).startTime);
          l = ((eah)localObject4).endTime - ((eah)localObject4).startTime;
          if (l <= 0L) {
            break label271;
          }
          localJSONObject2.put("in", l);
          localJSONArray.put(localJSONObject2);
          continue;
        }
        l = 0L;
      }
      catch (JSONException paramczw)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionDetailReport", paramczw, "HellSessionDetailReport.toJsonOfDetail crash", new Object[0]);
        AppMethodBeat.o(122226);
        return null;
      }
      continue;
      label271:
      l = 0L;
    }
    Object localObject2 = paramczw.aaFo.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ead)((Iterator)localObject2).next();
      if (((ead)localObject3).startTime > 0L)
      {
        localObject4 = new JSONObject();
        paramczw = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asD(((ead)localObject3).hJW);
        ((JSONObject)localObject4).put("sessionId", paramczw + "_" + ((ead)localObject3).startTime);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asE(((ead)localObject3).qkQ);
        paramczw = (czw)localObject1;
        if (localObject1 == null) {
          paramczw = "";
        }
        ((JSONObject)localObject4).put("lastSessionId", paramczw);
        ((JSONObject)localObject4).put("tbe", ((ead)localObject3).startTime);
        l = ((ead)localObject3).endTime - ((ead)localObject3).startTime;
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
      paramczw = localJSONObject1.toString();
      AppMethodBeat.o(122226);
      return paramczw;
      label500:
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.e.e
 * JD-Core Version:    0.7.0.1
 */