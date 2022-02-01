package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.en;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.d.d.a.4;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.sdk.platformtools.ad;
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
  private static boolean afp(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184379);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184379);
      return false;
    }
    ad.i("HABBYGE-MALI.HellSessionMergeReport", "reportSessionMerge: %s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.report.a.awA(paramString.replace(',', '#'));
    if (paramString != null)
    {
      en localen1 = new en();
      localen1.eij = Process.myPid();
      en localen2 = localen1.nQ(((h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName);
      localen2.egV = com.tencent.mm.plugin.report.a.dJZ();
      localen2.eil = paramString.size();
      while (i < paramString.size())
      {
        localen1.eik = i;
        localen1.nR((String)paramString.get(i)).aLk();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184379);
    return bool;
  }
  
  private static JSONObject d(chg paramchg)
  {
    AppMethodBeat.i(122231);
    if (paramchg.startTime <= 0L)
    {
      AppMethodBeat.o(122231);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sid", com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeR(paramchg.dtL));
      long l = paramchg.endTime - paramchg.startTime;
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
    catch (Exception paramchg)
    {
      AppMethodBeat.o(122231);
    }
  }
  
  static void f(boe paramboe)
  {
    AppMethodBeat.i(122228);
    String str1 = i(paramboe);
    long l = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.afb(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cqo());
    ad.i("HABBYGE-MALI.HellSessionMergeReport", "doReportSessionMerge, lastReportTime: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (l != -1L) {
      if (l == 0L) {
        if (afp(str1)) {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.afg(String.valueOf(System.currentTimeMillis()));
        }
      }
    }
    for (;;)
    {
      paramboe = com.tencent.mm.plugin.expt.d.a.cng().qPn;
      if (!com.tencent.mm.plugin.expt.d.b.cni()) {
        break label373;
      }
      if (!org.apache.commons.b.g.ea(str1)) {
        break label352;
      }
      ad.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionMerge data isEmpty!");
      AppMethodBeat.o(122228);
      return;
      String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.afc(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cqo());
      if (!"-1".equals(str2))
      {
        if ((str2 == null) || (str2.isEmpty())) {
          paramboe = str1;
        }
        for (;;)
        {
          if (!i.ar(paramboe, l)) {
            break label205;
          }
          if (!afp(paramboe)) {
            break;
          }
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.afg(String.valueOf(System.currentTimeMillis()));
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
      label205:
      if ((str1 != null) && (!str1.isEmpty()))
      {
        paramboe = com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cqo();
        if ((paramboe == null) || (paramboe.isEmpty()))
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.afg(System.currentTimeMillis() + "@" + str1);
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
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.afg(paramboe);
      break;
    }
    label352:
    l = System.currentTimeMillis();
    paramboe.qPs.execute(new a.4(paramboe, l, str1));
    label373:
    AppMethodBeat.o(122228);
  }
  
  private static String i(boe paramboe)
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
        localObject2 = paramboe.GIM.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (chk)((Iterator)localObject2).next();
        str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(((chk)localObject3).sessionId);
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
        localObject3 = l((chk)localObject3);
        if (localObject3 == null) {
          continue;
        }
        ((Map)localObject1).put(str, localObject3);
        continue;
        AppMethodBeat.o(184378);
      }
      catch (Exception paramboe)
      {
        ad.printErrStackTrace("HABBYGE-MALI.HellSessionMergeReport", paramboe, "HellSessionMergereport crash: %s", new Object[] { paramboe.getMessage() });
      }
      return null;
      if (((chk)localObject3).startTime > 0L)
      {
        l2 = localJSONObject.optLong("in");
        l1 = ((chk)localObject3).endTime - ((chk)localObject3).startTime;
        if (l1 <= 0L) {
          break label641;
        }
        label185:
        localJSONObject.put("in", l1 + l2);
        localJSONObject.put("count", localJSONObject.optInt("count") + 1);
        ((Map)localObject1).put(str, localJSONObject);
        continue;
        label229:
        localObject3 = l((chk)localObject3);
        if (localObject3 != null) {
          ((Map)localObject1).put(str, localObject3);
        }
      }
    }
    Object localObject2 = paramboe.GIO.iterator();
    for (;;)
    {
      label265:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (chg)((Iterator)localObject2).next();
        str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeR(((chg)localObject3).dtL);
        if (str != null) {
          if (((Map)localObject1).containsKey(str))
          {
            localJSONObject = (JSONObject)((Map)localObject1).get(str);
            if (localJSONObject == null)
            {
              localObject3 = d((chg)localObject3);
              if (localObject3 == null) {
                continue;
              }
              ((Map)localObject1).put(str, localObject3);
              continue;
            }
            if (((chg)localObject3).startTime <= 0L) {
              continue;
            }
            l2 = localJSONObject.optLong("in");
            l1 = ((chg)localObject3).endTime - ((chg)localObject3).startTime;
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
      localObject3 = d((chg)localObject3);
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
      if (paramboe.GIK <= 0L) {
        break;
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("tbe", paramboe.GIK);
      l1 = paramboe.GIL - paramboe.GIK;
      if (l1 > 0L) {}
      for (;;)
      {
        ((JSONObject)localObject1).put("in", l1);
        ((JSONObject)localObject1).put("vv", "2.0");
        ((JSONObject)localObject1).put("content", localObject2);
        paramboe = ((JSONObject)localObject1).toString();
        AppMethodBeat.o(184378);
        return paramboe;
        l1 = 0L;
      }
      label641:
      l1 = 0L;
      break label185;
      label646:
      l1 = 0L;
    }
  }
  
  private static JSONObject l(chk paramchk)
  {
    AppMethodBeat.i(122230);
    if (paramchk.startTime <= 0L)
    {
      AppMethodBeat.o(122230);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sid", com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(paramchk.sessionId));
      long l = paramchk.endTime - paramchk.startTime;
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
    catch (Exception paramchk)
    {
      AppMethodBeat.o(122230);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.f
 * JD-Core Version:    0.7.0.1
 */