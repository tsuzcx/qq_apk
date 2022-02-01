package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hx;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.d.d.a.4;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONObject;

final class f
{
  private static boolean aqW(String paramString)
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
    paramString = com.tencent.mm.plugin.report.a.aMr(paramString.replace(',', '#'));
    if (paramString != null)
    {
      hx localhx1 = new hx();
      localhx1.eMF = Process.myPid();
      hx localhx2 = localhx1.vF(((h)com.tencent.mm.kernel.g.aAe().azG()).mProcessName);
      localhx2.eLd = com.tencent.mm.plugin.report.a.eOr();
      localhx2.eMH = paramString.size();
      while (i < paramString.size())
      {
        localhx1.eMG = i;
        localhx1.vG((String)paramString.get(i)).bfK();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184379);
    return bool;
  }
  
  private static JSONObject d(cyh paramcyh)
  {
    AppMethodBeat.i(122231);
    if (paramcyh.startTime <= 0L)
    {
      AppMethodBeat.o(122231);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sid", com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqy(paramcyh.dMl));
      long l = paramcyh.endTime - paramcyh.startTime;
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
    catch (Exception paramcyh)
    {
      AppMethodBeat.o(122231);
    }
  }
  
  static void f(cbo paramcbo)
  {
    AppMethodBeat.i(122228);
    String str1 = i(paramcbo);
    long l = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.aqI(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cQy());
    Log.i("HABBYGE-MALI.HellSessionMergeReport", "doReportSessionMerge, lastReportTime: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (l != -1L) {
      if (l == 0L) {
        if (aqW(str1)) {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqN(String.valueOf(System.currentTimeMillis()));
        }
      }
    }
    for (;;)
    {
      paramcbo = com.tencent.mm.plugin.expt.d.a.cMI().sxs;
      if (!com.tencent.mm.plugin.expt.d.b.cML()) {
        break label373;
      }
      if (!org.apache.commons.b.g.eP(str1)) {
        break label352;
      }
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionMerge data isEmpty!");
      AppMethodBeat.o(122228);
      return;
      String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.aqJ(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cQy());
      if (!"-1".equals(str2))
      {
        if ((str2 == null) || (str2.isEmpty())) {
          paramcbo = str1;
        }
        for (;;)
        {
          if (!i.aq(paramcbo, l)) {
            break label205;
          }
          if (!aqW(paramcbo)) {
            break;
          }
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqN(String.valueOf(System.currentTimeMillis()));
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
      label205:
      if ((str1 != null) && (!str1.isEmpty()))
      {
        paramcbo = com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cQy();
        if ((paramcbo == null) || (paramcbo.isEmpty()))
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqN(System.currentTimeMillis() + "@" + str1);
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
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.aqN(paramcbo);
      break;
    }
    label352:
    l = System.currentTimeMillis();
    paramcbo.sxy.execute(new a.4(paramcbo, l, str1));
    label373:
    AppMethodBeat.o(122228);
  }
  
  private static String i(cbo paramcbo)
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
        localObject2 = paramcbo.Mhr.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (cyl)((Iterator)localObject2).next();
        str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(((cyl)localObject3).sessionId);
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
        localObject3 = p((cyl)localObject3);
        if (localObject3 == null) {
          continue;
        }
        ((Map)localObject1).put(str, localObject3);
        continue;
        AppMethodBeat.o(184378);
      }
      catch (Exception paramcbo)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionMergeReport", paramcbo, "HellSessionMergereport crash: %s", new Object[] { paramcbo.getMessage() });
      }
      return null;
      if (((cyl)localObject3).startTime > 0L)
      {
        l2 = localJSONObject.optLong("in");
        l1 = ((cyl)localObject3).endTime - ((cyl)localObject3).startTime;
        if (l1 <= 0L) {
          break label641;
        }
        label185:
        localJSONObject.put("in", l1 + l2);
        localJSONObject.put("count", localJSONObject.optInt("count") + 1);
        ((Map)localObject1).put(str, localJSONObject);
        continue;
        label229:
        localObject3 = p((cyl)localObject3);
        if (localObject3 != null) {
          ((Map)localObject1).put(str, localObject3);
        }
      }
    }
    Object localObject2 = paramcbo.Mht.iterator();
    for (;;)
    {
      label265:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (cyh)((Iterator)localObject2).next();
        str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqy(((cyh)localObject3).dMl);
        if (str != null) {
          if (((Map)localObject1).containsKey(str))
          {
            localJSONObject = (JSONObject)((Map)localObject1).get(str);
            if (localJSONObject == null)
            {
              localObject3 = d((cyh)localObject3);
              if (localObject3 == null) {
                continue;
              }
              ((Map)localObject1).put(str, localObject3);
              continue;
            }
            if (((cyh)localObject3).startTime <= 0L) {
              continue;
            }
            l2 = localJSONObject.optLong("in");
            l1 = ((cyh)localObject3).endTime - ((cyh)localObject3).startTime;
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
      localObject3 = d((cyh)localObject3);
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
      if (paramcbo.Mhp <= 0L) {
        break;
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("tbe", paramcbo.Mhp);
      l1 = paramcbo.Mhq - paramcbo.Mhp;
      if (l1 > 0L) {}
      for (;;)
      {
        ((JSONObject)localObject1).put("in", l1);
        ((JSONObject)localObject1).put("vv", "2.0");
        ((JSONObject)localObject1).put("content", localObject2);
        paramcbo = ((JSONObject)localObject1).toString();
        AppMethodBeat.o(184378);
        return paramcbo;
        l1 = 0L;
      }
      label641:
      l1 = 0L;
      break label185;
      label646:
      l1 = 0L;
    }
  }
  
  private static JSONObject p(cyl paramcyl)
  {
    AppMethodBeat.i(122230);
    if (paramcyl.startTime <= 0L)
    {
      AppMethodBeat.o(122230);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sid", com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(paramcyl.sessionId));
      long l = paramcyl.endTime - paramcyl.startTime;
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
    catch (Exception paramcyl)
    {
      AppMethodBeat.o(122230);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.f
 * JD-Core Version:    0.7.0.1
 */