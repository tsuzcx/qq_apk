package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ke;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.d.e.a.4;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.d;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

final class f
{
  private static boolean ayX(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184379);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184379);
      return false;
    }
    Log.i("HABBYGE-MALI.HellSessionMergeReport", "reportSessionMerge: %s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.report.a.aWX(paramString.replace(',', '#'));
    if (paramString != null)
    {
      ke localke1 = new ke();
      localke1.gMJ = Process.myPid();
      ke localke2 = localke1.Be(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).mProcessName);
      localke2.gKH = com.tencent.mm.plugin.report.a.fBn();
      localke2.gML = paramString.size();
      while (i < paramString.size())
      {
        localke1.gMK = i;
        localke1.Bf((String)paramString.get(i)).bpa();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184379);
    return bool;
  }
  
  private static JSONObject d(dht paramdht)
  {
    AppMethodBeat.i(122231);
    if (paramdht.startTime <= 0L)
    {
      AppMethodBeat.o(122231);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sid", com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayy(paramdht.fFe));
      long l = paramdht.endTime - paramdht.startTime;
      if (l > 0L) {}
      for (;;)
      {
        localJSONObject.put("in", l);
        localJSONObject.put("count", 1);
        AppMethodBeat.o(122231);
        return localJSONObject;
        l = 0L;
      }
      return null;
    }
    catch (Exception paramdht)
    {
      AppMethodBeat.o(122231);
    }
  }
  
  static void f(cjr paramcjr)
  {
    AppMethodBeat.i(122228);
    String str1 = i(paramcjr);
    long l = d.ayJ(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.dfs());
    Log.i("HABBYGE-MALI.HellSessionMergeReport", "doReportSessionMerge, lastReportTime: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (l != -1L) {
      if (l == 0L) {
        if (ayX(str1)) {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ayO(String.valueOf(System.currentTimeMillis()));
        }
      }
    }
    for (;;)
    {
      paramcjr = com.tencent.mm.plugin.expt.d.a.dbw().wcY;
      if (!com.tencent.mm.plugin.expt.d.b.dby()) {
        break label375;
      }
      if (!org.apache.commons.b.g.fK(str1)) {
        break label352;
      }
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionMerge data isEmpty!");
      AppMethodBeat.o(122228);
      return;
      String str2 = d.ayK(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.dfs());
      if (!"-1".equals(str2))
      {
        if ((str2 == null) || (str2.isEmpty())) {
          paramcjr = str1;
        }
        for (;;)
        {
          if (!i.ar(paramcjr, l)) {
            break label205;
          }
          if (!ayX(paramcjr)) {
            break;
          }
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ayO(String.valueOf(System.currentTimeMillis()));
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
      label205:
      if ((str1 != null) && (!str1.isEmpty()))
      {
        paramcjr = com.tencent.mm.plugin.expt.hellhound.a.f.c.g.dfs();
        if ((paramcjr == null) || (paramcjr.isEmpty()))
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ayO(System.currentTimeMillis() + "@" + str1);
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
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.ayO(paramcjr);
      break;
    }
    label352:
    l = System.currentTimeMillis();
    com.tencent.e.h.ZvG.be(new a.4(paramcjr, l, str1));
    label375:
    AppMethodBeat.o(122228);
  }
  
  private static String i(cjr paramcjr)
  {
    AppMethodBeat.i(184378);
    Object localObject1;
    Object localObject3;
    String str;
    JSONObject localJSONObject;
    label148:
    long l2;
    long l1;
    for (;;)
    {
      try
      {
        localObject1 = new HashMap();
        localObject2 = paramcjr.Trf.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (dhx)((Iterator)localObject2).next();
        str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(((dhx)localObject3).sessionId);
        if (str == null) {
          continue;
        }
        if (!((Map)localObject1).containsKey(str)) {
          break label229;
        }
        localJSONObject = (JSONObject)((Map)localObject1).get(str);
        if (localJSONObject != null) {
          break label148;
        }
        localObject3 = p((dhx)localObject3);
        if (localObject3 == null) {
          continue;
        }
        ((Map)localObject1).put(str, localObject3);
        continue;
        AppMethodBeat.o(184378);
      }
      catch (Exception paramcjr)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionMergeReport", paramcjr, "HellSessionMergereport crash: %s", new Object[] { paramcjr.getMessage() });
      }
      return null;
      if (((dhx)localObject3).startTime > 0L)
      {
        l2 = localJSONObject.optLong("in");
        l1 = ((dhx)localObject3).endTime - ((dhx)localObject3).startTime;
        if (l1 <= 0L) {
          break label641;
        }
        label185:
        localJSONObject.put("in", l1 + l2);
        localJSONObject.put("count", localJSONObject.optInt("count") + 1);
        ((Map)localObject1).put(str, localJSONObject);
        continue;
        label229:
        localObject3 = p((dhx)localObject3);
        if (localObject3 != null) {
          ((Map)localObject1).put(str, localObject3);
        }
      }
    }
    Object localObject2 = paramcjr.Trg.iterator();
    for (;;)
    {
      label265:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (dht)((Iterator)localObject2).next();
        str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayy(((dht)localObject3).fFe);
        if (str != null) {
          if (((Map)localObject1).containsKey(str))
          {
            localJSONObject = (JSONObject)((Map)localObject1).get(str);
            if (localJSONObject == null)
            {
              localObject3 = d((dht)localObject3);
              if (localObject3 == null) {
                continue;
              }
              ((Map)localObject1).put(str, localObject3);
              continue;
            }
            if (((dht)localObject3).startTime <= 0L) {
              continue;
            }
            l2 = localJSONObject.optLong("in");
            l1 = ((dht)localObject3).endTime - ((dht)localObject3).startTime;
            if (l1 <= 0L) {
              break label646;
            }
          }
        }
      }
    }
    for (;;)
    {
      localJSONObject.put("in", l1 + l2);
      localJSONObject.put("count", localJSONObject.optInt("count") + 1);
      ((Map)localObject1).put(str, localJSONObject);
      break label265;
      localObject3 = d((dht)localObject3);
      if (localObject3 == null) {
        break label265;
      }
      ((Map)localObject1).put(str, localObject3);
      break label265;
      localObject2 = new JSONArray();
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((JSONArray)localObject2).put(((Map.Entry)((Iterator)localObject1).next()).getValue());
      }
      int i = ((JSONArray)localObject2).length();
      if (i <= 0)
      {
        AppMethodBeat.o(184378);
        return null;
      }
      if (paramcjr.Trd <= 0L) {
        break;
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("tbe", paramcjr.Trd);
      l1 = paramcjr.Tre - paramcjr.Trd;
      if (l1 > 0L) {}
      for (;;)
      {
        ((JSONObject)localObject1).put("in", l1);
        ((JSONObject)localObject1).put("vv", "2.0");
        ((JSONObject)localObject1).put("content", localObject2);
        paramcjr = ((JSONObject)localObject1).toString();
        AppMethodBeat.o(184378);
        return paramcjr;
        l1 = 0L;
      }
      label641:
      l1 = 0L;
      break label185;
      label646:
      l1 = 0L;
    }
  }
  
  private static JSONObject p(dhx paramdhx)
  {
    AppMethodBeat.i(122230);
    if (paramdhx.startTime <= 0L)
    {
      AppMethodBeat.o(122230);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sid", com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(paramdhx.sessionId));
      long l = paramdhx.endTime - paramdhx.startTime;
      if (l > 0L) {}
      for (;;)
      {
        localJSONObject.put("in", l);
        localJSONObject.put("count", 1);
        AppMethodBeat.o(122230);
        return localJSONObject;
        l = 0L;
      }
      return null;
    }
    catch (Exception paramdhx)
    {
      AppMethodBeat.o(122230);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.f
 * JD-Core Version:    0.7.0.1
 */