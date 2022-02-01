package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ds;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.sdk.platformtools.ac;
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
  private static boolean abB(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184379);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184379);
      return false;
    }
    ac.i("HellSessionMergeReport", "HABBYGE-MALI, reportSessionMerge: %s", new Object[] { paramString });
    paramString = a.arA(paramString.replace(',', '#'));
    if (paramString != null)
    {
      ds localds1 = new ds();
      localds1.dSD = Process.myPid();
      ds localds2 = localds1.lI(((h)com.tencent.mm.kernel.g.agO().agp()).mProcessName);
      localds2.dRy = a.dyH();
      localds2.dSF = paramString.size();
      while (i < paramString.size())
      {
        localds1.dSE = i;
        localds1.lJ((String)paramString.get(i)).aHZ();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184379);
    return bool;
  }
  
  private static JSONObject c(cco paramcco)
  {
    AppMethodBeat.i(122231);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sid", b.abe(paramcco.qoi));
      long l = paramcco.endTime - paramcco.startTime;
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
    catch (Exception paramcco)
    {
      AppMethodBeat.o(122231);
    }
  }
  
  static void f(bjw parambjw)
  {
    AppMethodBeat.i(122228);
    String str1 = i(parambjw);
    long l = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.abo(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cla());
    ac.i("HellSessionMergeReport", "HABBYGE-MALI, doReportSessionMerge, lastReportTime: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (l != -1L)
    {
      if (l == 0L)
      {
        if (abB(str1)) {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.abt(String.valueOf(System.currentTimeMillis()));
        }
        AppMethodBeat.o(122228);
        return;
      }
      String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.abp(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cla());
      if (!"-1".equals(str2))
      {
        if ((str2 == null) || (str2.isEmpty())) {
          parambjw = str1;
        }
        while (i.ao(parambjw, l))
        {
          if (abB(parambjw)) {
            com.tencent.mm.plugin.expt.hellhound.a.f.c.g.abt(String.valueOf(System.currentTimeMillis()));
          }
          AppMethodBeat.o(122228);
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
      AppMethodBeat.o(122228);
      return;
    }
    parambjw = com.tencent.mm.plugin.expt.hellhound.a.f.c.g.cla();
    if ((parambjw == null) || (parambjw.isEmpty()))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.abt(System.currentTimeMillis() + "@" + str1);
      AppMethodBeat.o(122228);
      return;
    }
    if ("-1".equals(parambjw))
    {
      ac.e("HellSessionReportCache", "HABBYGE-MALI, storeSessionDetail not login");
      AppMethodBeat.o(122228);
      return;
    }
    if (parambjw.split("@").length <= 1) {}
    for (parambjw = parambjw + "@" + str1;; parambjw = parambjw + "|" + str1)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.abt(parambjw);
      AppMethodBeat.o(122228);
      return;
    }
  }
  
  private static String i(bjw parambjw)
  {
    AppMethodBeat.i(184378);
    Object localObject1;
    Object localObject3;
    String str;
    JSONObject localJSONObject;
    long l2;
    long l1;
    for (;;)
    {
      try
      {
        localObject1 = new HashMap();
        localObject2 = parambjw.EZo.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (ccs)((Iterator)localObject2).next();
        str = b.aaS(((ccs)localObject3).sessionId);
        if (str == null) {
          continue;
        }
        if (!((Map)localObject1).containsKey(str)) {
          break label217;
        }
        localJSONObject = (JSONObject)((Map)localObject1).get(str);
        if (localJSONObject == null)
        {
          localObject3 = l((ccs)localObject3);
          if (localObject3 == null) {
            continue;
          }
          ((Map)localObject1).put(str, localObject3);
          continue;
        }
        l2 = localJSONObject.optLong("in");
      }
      catch (Exception parambjw)
      {
        ac.printErrStackTrace("HellSessionMergeReport", parambjw, "HABBYGE-MALI, HellSessionMergereport crash: %s", new Object[] { parambjw.getMessage() });
        AppMethodBeat.o(184378);
        return null;
      }
      l1 = ((ccs)localObject3).endTime - ((ccs)localObject3).startTime;
      if (l1 <= 0L) {
        break label608;
      }
      localJSONObject.put("in", l1 + l2);
      localJSONObject.put("count", localJSONObject.optInt("count") + 1);
      ((Map)localObject1).put(str, localJSONObject);
      continue;
      label217:
      localObject3 = l((ccs)localObject3);
      if (localObject3 != null) {
        ((Map)localObject1).put(str, localObject3);
      }
    }
    Object localObject2 = parambjw.EZq.iterator();
    for (;;)
    {
      label253:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (cco)((Iterator)localObject2).next();
        str = b.abe(((cco)localObject3).qoi);
        if (str != null) {
          if (((Map)localObject1).containsKey(str))
          {
            localJSONObject = (JSONObject)((Map)localObject1).get(str);
            if (localJSONObject == null)
            {
              localObject3 = c((cco)localObject3);
              if (localObject3 == null) {
                continue;
              }
              ((Map)localObject1).put(str, localObject3);
              continue;
            }
            l2 = localJSONObject.optLong("in");
            l1 = ((cco)localObject3).endTime - ((cco)localObject3).startTime;
            if (l1 <= 0L) {
              break label613;
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
      break label253;
      localObject3 = c((cco)localObject3);
      if (localObject3 == null) {
        break label253;
      }
      ((Map)localObject1).put(str, localObject3);
      break label253;
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
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("tbe", parambjw.EZm);
      l1 = parambjw.EZn - parambjw.EZm;
      if (l1 > 0L) {}
      for (;;)
      {
        ((JSONObject)localObject1).put("in", l1);
        ((JSONObject)localObject1).put("vv", "2.0");
        ((JSONObject)localObject1).put("content", localObject2);
        parambjw = ((JSONObject)localObject1).toString();
        AppMethodBeat.o(184378);
        return parambjw;
        l1 = 0L;
      }
      label608:
      l1 = 0L;
      break;
      label613:
      l1 = 0L;
    }
  }
  
  private static JSONObject l(ccs paramccs)
  {
    AppMethodBeat.i(122230);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sid", b.aaS(paramccs.sessionId));
      long l = paramccs.endTime - paramccs.startTime;
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
    catch (Exception paramccs)
    {
      AppMethodBeat.o(122230);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.f
 * JD-Core Version:    0.7.0.1
 */