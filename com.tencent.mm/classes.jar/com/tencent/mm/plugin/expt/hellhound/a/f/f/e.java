package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dt;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.c;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class e
{
  private static boolean abA(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184377);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184377);
      return false;
    }
    ac.i("HellSessionDetailReport", "HABBYGE-MALI, reportSessionDetail: %s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.report.a.arA(paramString.replace(',', '#'));
    if (paramString != null)
    {
      dt localdt1 = new dt();
      localdt1.dSD = Process.myPid();
      dt localdt2 = localdt1.lK(((h)com.tencent.mm.kernel.g.agO().agp()).mProcessName);
      localdt2.dRy = com.tencent.mm.plugin.report.a.dyH();
      localdt2.dSF = paramString.size();
      while (i < paramString.size())
      {
        localdt1.dSE = i;
        localdt1.lL((String)paramString.get(i)).aHZ();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184377);
    return bool;
  }
  
  static void f(bjw parambjw)
  {
    AppMethodBeat.i(122225);
    if (com.tencent.mm.plugin.expt.hellhound.a.ciw())
    {
      c.ckB();
      if ((!c.ckD()) && (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() != 0))
      {
        c.ckB();
        if (c.ckE()) {
          break label43;
        }
      }
    }
    AppMethodBeat.o(122225);
    return;
    label43:
    String str1 = h(parambjw);
    long l = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.abo(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ckZ());
    ac.i("HellSessionDetailReport", "HABBYGE-MALI, doReportDetailWhenEvent8, lastReportTime: %s, %s", new Object[] { Long.valueOf(l), str1 });
    if (l != -1L)
    {
      if (l == 0L)
      {
        if (abA(str1)) {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.abs(String.valueOf(System.currentTimeMillis()));
        }
        AppMethodBeat.o(122225);
        return;
      }
      String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.abp(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ckZ());
      if (!"-1".equals(str2))
      {
        if ((str2 == null) || (str2.isEmpty())) {
          parambjw = str1;
        }
        while (i.ao(parambjw, l))
        {
          if (abA(parambjw)) {
            com.tencent.mm.plugin.expt.hellhound.a.f.c.g.abs(String.valueOf(System.currentTimeMillis()));
          }
          AppMethodBeat.o(122225);
          return;
          parambjw = str2;
          if (str1 != null)
          {
            parambjw = str2;
            if (!str1.isEmpty()) {
              parambjw = str2 + "|" + str1;
            }
          }
        }
      }
    }
    if ((str1 == null) || (str1.isEmpty()))
    {
      AppMethodBeat.o(122225);
      return;
    }
    parambjw = com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ckZ();
    if ((parambjw == null) || (parambjw.isEmpty()))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.abs(System.currentTimeMillis() + "@" + str1);
      AppMethodBeat.o(122225);
      return;
    }
    if ("-1".equals(parambjw))
    {
      ac.e("HellSessionReportCache", "HABBYGE-MALI, storeSessionDetail not login");
      AppMethodBeat.o(122225);
      return;
    }
    if (parambjw.split("@").length <= 1) {}
    for (parambjw = parambjw + "@" + str1;; parambjw = parambjw + "|" + str1)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.abs(parambjw);
      AppMethodBeat.o(122225);
      return;
    }
  }
  
  private static String h(bjw parambjw)
  {
    AppMethodBeat.i(122226);
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
        localJSONObject1.put("tbe", parambjw.EZm);
        l = parambjw.EZn - parambjw.EZm;
        if (l > 0L)
        {
          localJSONObject1.put("in", l);
          localJSONObject1.put("vv", "2.0");
          localJSONArray = new JSONArray();
          localObject3 = parambjw.EZo.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (ccs)((Iterator)localObject3).next();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("sessionId", ((ccs)localObject4).sessionId);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.abf(((ccs)localObject4).FqZ);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localJSONObject2.put("lastSessionId", localObject1);
          localJSONObject2.put("tbe", ((ccs)localObject4).startTime);
          l = ((ccs)localObject4).endTime - ((ccs)localObject4).startTime;
          if (l <= 0L) {
            break label236;
          }
          localJSONObject2.put("in", l);
          localJSONArray.put(localJSONObject2);
          continue;
        }
        l = 0L;
      }
      catch (JSONException parambjw)
      {
        ac.printErrStackTrace("HellSessionDetailReport", parambjw, "HABBYGE-MALI, HellSessionDetailReport.toJsonOfDetail crash", new Object[0]);
        AppMethodBeat.o(122226);
        return null;
      }
      continue;
      label236:
      l = 0L;
    }
    Object localObject2 = parambjw.EZq.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (cco)((Iterator)localObject2).next();
      localObject4 = new JSONObject();
      parambjw = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.abe(((cco)localObject3).qoi);
      ((JSONObject)localObject4).put("sessionId", parambjw + "_" + ((cco)localObject3).startTime);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.abf(((cco)localObject3).FqZ);
      parambjw = (bjw)localObject1;
      if (localObject1 == null) {
        parambjw = "";
      }
      ((JSONObject)localObject4).put("lastSessionId", parambjw);
      ((JSONObject)localObject4).put("tbe", ((cco)localObject3).startTime);
      l = ((cco)localObject3).endTime - ((cco)localObject3).startTime;
      if (l <= 0L) {
        break label451;
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
      parambjw = localJSONObject1.toString();
      AppMethodBeat.o(122226);
      return parambjw;
      label451:
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.e
 * JD-Core Version:    0.7.0.1
 */