package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hy;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.d.d.a.3;
import com.tencent.mm.plugin.expt.d.d.a.8;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.c;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class e
{
  private static boolean aqV(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184377);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184377);
      return false;
    }
    Log.i("HABBYGE-MALI.HellSessionDetailReport", "reportSessionDetail: %s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.report.a.aMr(paramString.replace(',', '#'));
    if (paramString != null)
    {
      hy localhy1 = new hy();
      localhy1.eMF = Process.myPid();
      hy localhy2 = localhy1.vH(((h)com.tencent.mm.kernel.g.aAe().azG()).mProcessName);
      localhy2.eLd = com.tencent.mm.plugin.report.a.eOr();
      localhy2.eMH = paramString.size();
      while (i < paramString.size())
      {
        localhy1.eMG = i;
        localhy1.vI((String)paramString.get(i)).bfK();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184377);
    return bool;
  }
  
  static void f(cbo paramcbo)
  {
    AppMethodBeat.i(122225);
    if (paramcbo == null)
    {
      AppMethodBeat.o(122225);
      return;
    }
    String str1 = h(paramcbo);
    if (org.apache.commons.b.g.eP(str1))
    {
      AppMethodBeat.o(122225);
      return;
    }
    paramcbo = com.tencent.mm.plugin.expt.d.a.cMI().sxs;
    if (com.tencent.mm.plugin.expt.d.b.cML())
    {
      if (!org.apache.commons.b.g.eP(str1)) {
        break label98;
      }
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionSingleAll data isEmpty!");
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.expt.hellhound.a.cNo())
      {
        c.cQa();
        if ((!c.cQc()) && (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() != 0))
        {
          c.cQa();
          if (c.cQd()) {
            break;
          }
        }
      }
      AppMethodBeat.o(122225);
      return;
      label98:
      l = System.currentTimeMillis();
      paramcbo.sxy.execute(new a.8(paramcbo, l, str1));
    }
    long l = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.aqI(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cQx());
    Log.i("HABBYGE-MALI.HellSessionDetailReport", "doReportDetailWhenEvent8, lastReportTime: %s, %s", new Object[] { Long.valueOf(l), str1 });
    if (l != -1L) {
      if (l == 0L) {
        if (aqV(str1)) {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqM(String.valueOf(System.currentTimeMillis()));
        }
      }
    }
    for (;;)
    {
      paramcbo = com.tencent.mm.plugin.expt.d.a.cMI().sxs;
      if (!com.tencent.mm.plugin.expt.d.b.cML()) {
        break label490;
      }
      if (!org.apache.commons.b.g.eP(str1)) {
        break label469;
      }
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionSingle data isEmpty!");
      AppMethodBeat.o(122225);
      return;
      String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.aqJ(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cQx());
      if (!"-1".equals(str2))
      {
        if ((str2 == null) || (str2.isEmpty())) {
          paramcbo = str1;
        }
        for (;;)
        {
          if (!i.aq(paramcbo, l)) {
            break label319;
          }
          if (!aqV(paramcbo)) {
            break;
          }
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqM(String.valueOf(System.currentTimeMillis()));
          break;
          paramcbo = str2;
          if (str1 != null)
          {
            paramcbo = str2;
            if (!str1.isEmpty()) {
              paramcbo = str2 + "|" + str1;
            }
          }
        }
      }
      label319:
      if ((str1 != null) && (!str1.isEmpty()))
      {
        paramcbo = com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cQx();
        if ((paramcbo == null) || (paramcbo.isEmpty()))
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqM(System.currentTimeMillis() + "@" + str1);
        }
        else
        {
          if (!"-1".equals(paramcbo)) {
            break;
          }
          Log.e("HABBYGE-MALI.HellSessionReportCache", "storeSessionDetail not login");
        }
      }
    }
    if (paramcbo.split("@").length <= 1) {}
    for (paramcbo = paramcbo + "@" + str1;; paramcbo = paramcbo + "|" + str1)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqM(paramcbo);
      break;
    }
    label469:
    l = System.currentTimeMillis();
    paramcbo.sxy.execute(new a.3(paramcbo, l, str1));
    label490:
    AppMethodBeat.o(122225);
  }
  
  private static String h(cbo paramcbo)
  {
    AppMethodBeat.i(122226);
    if (paramcbo.Mhp <= 0L)
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
        localJSONObject1.put("tbe", paramcbo.Mhp);
        l = paramcbo.Mhq - paramcbo.Mhp;
        if (l > 0L)
        {
          localJSONObject1.put("in", l);
          localJSONObject1.put("vv", "2.0");
          localJSONArray = new JSONArray();
          localObject3 = paramcbo.Mhr.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (cyl)((Iterator)localObject3).next();
          if (((cyl)localObject4).startTime <= 0L) {
            continue;
          }
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("sessionId", ((cyl)localObject4).sessionId);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqz(((cyl)localObject4).kvy);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localJSONObject2.put("lastSessionId", localObject1);
          localJSONObject2.put("tbe", ((cyl)localObject4).startTime);
          l = ((cyl)localObject4).endTime - ((cyl)localObject4).startTime;
          if (l <= 0L) {
            break label271;
          }
          localJSONObject2.put("in", l);
          localJSONArray.put(localJSONObject2);
          continue;
        }
        l = 0L;
      }
      catch (JSONException paramcbo)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionDetailReport", paramcbo, "HellSessionDetailReport.toJsonOfDetail crash", new Object[0]);
        AppMethodBeat.o(122226);
        return null;
      }
      continue;
      label271:
      l = 0L;
    }
    Object localObject2 = paramcbo.Mht.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (cyh)((Iterator)localObject2).next();
      if (((cyh)localObject3).startTime > 0L)
      {
        localObject4 = new JSONObject();
        paramcbo = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqy(((cyh)localObject3).dMl);
        ((JSONObject)localObject4).put("sessionId", paramcbo + "_" + ((cyh)localObject3).startTime);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqz(((cyh)localObject3).kvy);
        paramcbo = (cbo)localObject1;
        if (localObject1 == null) {
          paramcbo = "";
        }
        ((JSONObject)localObject4).put("lastSessionId", paramcbo);
        ((JSONObject)localObject4).put("tbe", ((cyh)localObject3).startTime);
        l = ((cyh)localObject3).endTime - ((cyh)localObject3).startTime;
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
      paramcbo = localJSONObject1.toString();
      AppMethodBeat.o(122226);
      return paramcbo;
      label500:
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.e
 * JD-Core Version:    0.7.0.1
 */