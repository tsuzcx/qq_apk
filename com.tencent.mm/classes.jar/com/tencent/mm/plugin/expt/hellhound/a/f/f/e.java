package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cf;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.c;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class e
{
  private static boolean Xd(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184377);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184377);
      return false;
    }
    ad.i("HellSessionDetailReport", "HABBYGE-MALI, reportSessionDetail: %s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.report.a.amt(paramString.replace(',', '#'));
    if (paramString != null)
    {
      cf localcf1 = new cf();
      localcf1.dQO = Process.myPid();
      cf localcf2 = localcf1.iU(((h)com.tencent.mm.kernel.g.afy().aeZ()).mProcessName);
      localcf2.dPH = com.tencent.mm.plugin.report.a.dkE();
      localcf2.dQQ = paramString.size();
      while (i < paramString.size())
      {
        localcf1.dQP = i;
        localcf1.iV((String)paramString.get(i)).aBj();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184377);
    return bool;
  }
  
  static void f(bge parambge)
  {
    AppMethodBeat.i(122225);
    if (com.tencent.mm.plugin.expt.hellhound.a.cbn())
    {
      c.ccT();
      if ((!c.ccV()) && (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() != 0))
      {
        c.ccT();
        if (c.ccW()) {
          break label43;
        }
      }
    }
    AppMethodBeat.o(122225);
    return;
    label43:
    String str1 = h(parambge);
    long l = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.WR(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cdr());
    ad.i("HellSessionDetailReport", "HABBYGE-MALI, doReportDetailWhenEvent8, lastReportTime: %s, %s", new Object[] { Long.valueOf(l), str1 });
    if (l != -1L)
    {
      if (l == 0L)
      {
        if (Xd(str1)) {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.WV(String.valueOf(System.currentTimeMillis()));
        }
        AppMethodBeat.o(122225);
        return;
      }
      String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.WS(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cdr());
      if (!"-1".equals(str2))
      {
        if ((str2 == null) || (str2.isEmpty())) {
          parambge = str1;
        }
        while (i.am(parambge, l))
        {
          if (Xd(parambge)) {
            com.tencent.mm.plugin.expt.hellhound.a.f.c.g.WV(String.valueOf(System.currentTimeMillis()));
          }
          AppMethodBeat.o(122225);
          return;
          parambge = str2;
          if (str1 != null)
          {
            parambge = str2;
            if (!str1.isEmpty()) {
              parambge = str2 + "|" + str1;
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
    parambge = com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cdr();
    if ((parambge == null) || (parambge.isEmpty()))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.WV(System.currentTimeMillis() + "@" + str1);
      AppMethodBeat.o(122225);
      return;
    }
    if ("-1".equals(parambge))
    {
      ad.e("HellSessionReportCache", "HABBYGE-MALI, storeSessionDetail not login");
      AppMethodBeat.o(122225);
      return;
    }
    if (parambge.split("@").length <= 1) {}
    for (parambge = parambge + "@" + str1;; parambge = parambge + "|" + str1)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.WV(parambge);
      AppMethodBeat.o(122225);
      return;
    }
  }
  
  private static String h(bge parambge)
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
        localJSONObject1.put("tbe", parambge.DDR);
        l = parambge.DDS - parambge.DDR;
        if (l > 0L)
        {
          localJSONObject1.put("in", l);
          localJSONObject1.put("vv", "2.0");
          localJSONArray = new JSONArray();
          localObject3 = parambge.DDT.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (bxx)((Iterator)localObject3).next();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("sessionId", ((bxx)localObject4).sessionId);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WI(((bxx)localObject4).DUm);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localJSONObject2.put("lastSessionId", localObject1);
          localJSONObject2.put("tbe", ((bxx)localObject4).startTime);
          l = ((bxx)localObject4).endTime - ((bxx)localObject4).startTime;
          if (l <= 0L) {
            break label236;
          }
          localJSONObject2.put("in", l);
          localJSONArray.put(localJSONObject2);
          continue;
        }
        l = 0L;
      }
      catch (JSONException parambge)
      {
        ad.printErrStackTrace("HellSessionDetailReport", parambge, "HABBYGE-MALI, HellSessionDetailReport.toJsonOfDetail crash", new Object[0]);
        AppMethodBeat.o(122226);
        return null;
      }
      continue;
      label236:
      l = 0L;
    }
    Object localObject2 = parambge.DDV.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (bxt)((Iterator)localObject2).next();
      localObject4 = new JSONObject();
      parambge = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WH(((bxt)localObject3).DDP);
      ((JSONObject)localObject4).put("sessionId", parambge + "_" + ((bxt)localObject3).startTime);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WI(((bxt)localObject3).DUm);
      parambge = (bge)localObject1;
      if (localObject1 == null) {
        parambge = "";
      }
      ((JSONObject)localObject4).put("lastSessionId", parambge);
      ((JSONObject)localObject4).put("tbe", ((bxt)localObject3).startTime);
      l = ((bxt)localObject3).endTime - ((bxt)localObject3).startTime;
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
      parambge = localJSONObject1.toString();
      AppMethodBeat.o(122226);
      return parambge;
      label451:
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.e
 * JD-Core Version:    0.7.0.1
 */