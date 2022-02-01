package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.kf;
import com.tencent.mm.plugin.expt.d.e.a.3;
import com.tencent.mm.plugin.expt.d.e.a.8;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.d;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class e
{
  private static boolean ayW(String paramString)
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
    paramString = com.tencent.mm.plugin.report.a.aWX(paramString.replace(',', '#'));
    if (paramString != null)
    {
      kf localkf1 = new kf();
      localkf1.gMJ = Process.myPid();
      kf localkf2 = localkf1.Bg(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).mProcessName);
      localkf2.gKH = com.tencent.mm.plugin.report.a.fBn();
      localkf2.gML = paramString.size();
      while (i < paramString.size())
      {
        localkf1.gMK = i;
        localkf1.Bh((String)paramString.get(i)).bpa();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184377);
    return bool;
  }
  
  static void f(cjr paramcjr)
  {
    AppMethodBeat.i(122225);
    if (paramcjr == null)
    {
      AppMethodBeat.o(122225);
      return;
    }
    String str1 = h(paramcjr);
    if (org.apache.commons.b.g.fK(str1))
    {
      AppMethodBeat.o(122225);
      return;
    }
    paramcjr = com.tencent.mm.plugin.expt.d.a.dbw().wcY;
    if (com.tencent.mm.plugin.expt.d.b.dby())
    {
      if (!org.apache.commons.b.g.fK(str1)) {
        break label98;
      }
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionSingleAll data isEmpty!");
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.expt.hellhound.a.dcg())
      {
        c.deU();
        if ((!c.deW()) && (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() != 0))
        {
          c.deU();
          if (c.deX()) {
            break;
          }
        }
      }
      AppMethodBeat.o(122225);
      return;
      label98:
      l = System.currentTimeMillis();
      com.tencent.e.h.ZvG.be(new a.8(paramcjr, l, str1));
    }
    long l = d.ayJ(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.dfr());
    Log.i("HABBYGE-MALI.HellSessionDetailReport", "doReportDetailWhenEvent8, lastReportTime: %s, %s", new Object[] { Long.valueOf(l), str1 });
    if (l != -1L) {
      if (l == 0L) {
        if (ayW(str1)) {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ayN(String.valueOf(System.currentTimeMillis()));
        }
      }
    }
    for (;;)
    {
      paramcjr = com.tencent.mm.plugin.expt.d.a.dbw().wcY;
      if (!com.tencent.mm.plugin.expt.d.b.dby()) {
        break label494;
      }
      if (!org.apache.commons.b.g.fK(str1)) {
        break label471;
      }
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionSingle data isEmpty!");
      AppMethodBeat.o(122225);
      return;
      String str2 = d.ayK(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.dfr());
      if (!"-1".equals(str2))
      {
        if ((str2 == null) || (str2.isEmpty())) {
          paramcjr = str1;
        }
        for (;;)
        {
          if (!i.ar(paramcjr, l)) {
            break label321;
          }
          if (!ayW(paramcjr)) {
            break;
          }
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ayN(String.valueOf(System.currentTimeMillis()));
          break;
          paramcjr = str2;
          if (str1 != null)
          {
            paramcjr = str2;
            if (!str1.isEmpty()) {
              paramcjr = str2 + "|" + str1;
            }
          }
        }
      }
      label321:
      if ((str1 != null) && (!str1.isEmpty()))
      {
        paramcjr = com.tencent.mm.plugin.expt.hellhound.a.f.c.g.dfr();
        if ((paramcjr == null) || (paramcjr.isEmpty()))
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ayN(System.currentTimeMillis() + "@" + str1);
        }
        else
        {
          if (!"-1".equals(paramcjr)) {
            break;
          }
          Log.e("HABBYGE-MALI.HellSessionReportCache", "storeSessionDetail not login");
        }
      }
    }
    if (paramcjr.split("@").length <= 1) {}
    for (paramcjr = paramcjr + "@" + str1;; paramcjr = paramcjr + "|" + str1)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ayN(paramcjr);
      break;
    }
    label471:
    l = System.currentTimeMillis();
    com.tencent.e.h.ZvG.be(new a.3(paramcjr, l, str1));
    label494:
    AppMethodBeat.o(122225);
  }
  
  private static String h(cjr paramcjr)
  {
    AppMethodBeat.i(122226);
    if (paramcjr.Trd <= 0L)
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
        localJSONObject1.put("tbe", paramcjr.Trd);
        l = paramcjr.Tre - paramcjr.Trd;
        if (l > 0L)
        {
          localJSONObject1.put("in", l);
          localJSONObject1.put("vv", "2.0");
          localJSONArray = new JSONArray();
          localObject3 = paramcjr.Trf.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (dhx)((Iterator)localObject3).next();
          if (((dhx)localObject4).startTime <= 0L) {
            continue;
          }
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("sessionId", ((dhx)localObject4).sessionId);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayz(((dhx)localObject4).nnJ);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localJSONObject2.put("lastSessionId", localObject1);
          localJSONObject2.put("tbe", ((dhx)localObject4).startTime);
          l = ((dhx)localObject4).endTime - ((dhx)localObject4).startTime;
          if (l <= 0L) {
            break label271;
          }
          localJSONObject2.put("in", l);
          localJSONArray.put(localJSONObject2);
          continue;
        }
        l = 0L;
      }
      catch (JSONException paramcjr)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionDetailReport", paramcjr, "HellSessionDetailReport.toJsonOfDetail crash", new Object[0]);
        AppMethodBeat.o(122226);
        return null;
      }
      continue;
      label271:
      l = 0L;
    }
    Object localObject2 = paramcjr.Trg.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (dht)((Iterator)localObject2).next();
      if (((dht)localObject3).startTime > 0L)
      {
        localObject4 = new JSONObject();
        paramcjr = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayy(((dht)localObject3).fFe);
        ((JSONObject)localObject4).put("sessionId", paramcjr + "_" + ((dht)localObject3).startTime);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayz(((dht)localObject3).nnJ);
        paramcjr = (cjr)localObject1;
        if (localObject1 == null) {
          paramcjr = "";
        }
        ((JSONObject)localObject4).put("lastSessionId", paramcjr);
        ((JSONObject)localObject4).put("tbe", ((dht)localObject3).startTime);
        l = ((dht)localObject3).endTime - ((dht)localObject3).startTime;
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
      paramcjr = localJSONObject1.toString();
      AppMethodBeat.o(122226);
      return paramcjr;
      label500:
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.e
 * JD-Core Version:    0.7.0.1
 */