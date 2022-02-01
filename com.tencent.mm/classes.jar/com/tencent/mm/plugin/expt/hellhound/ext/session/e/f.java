package com.tencent.mm.plugin.expt.hellhound.ext.session.e;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mv;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.edge.d.a.4;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.d;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
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
  private static boolean atc(String paramString)
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
    paramString = com.tencent.mm.plugin.report.a.aUn(paramString.replace(',', '#'));
    if (paramString != null)
    {
      mv localmv1 = new mv();
      localmv1.jcB = Process.myPid();
      mv localmv2 = localmv1.vl(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName);
      localmv2.iZX = com.tencent.mm.plugin.report.a.gNH();
      localmv2.jcD = paramString.size();
      while (i < paramString.size())
      {
        localmv1.jcC = i;
        localmv1.vm((String)paramString.get(i)).bMH();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184379);
    return bool;
  }
  
  private static JSONObject d(ead paramead)
  {
    AppMethodBeat.i(122231);
    if (paramead.startTime <= 0L)
    {
      AppMethodBeat.o(122231);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sid", com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asD(paramead.hJW));
      long l = paramead.endTime - paramead.startTime;
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
    catch (Exception paramead)
    {
      AppMethodBeat.o(122231);
    }
  }
  
  static void f(czw paramczw)
  {
    AppMethodBeat.i(122228);
    String str1 = i(paramczw);
    long l = d.asO(com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.dMg());
    Log.i("HABBYGE-MALI.HellSessionMergeReport", "doReportSessionMerge, lastReportTime: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (l != -1L) {
      if (l == 0L) {
        if (atc(str1)) {
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.asT(String.valueOf(System.currentTimeMillis()));
        }
      }
    }
    for (;;)
    {
      paramczw = com.tencent.mm.plugin.expt.edge.a.dHT().zxY;
      if (!com.tencent.mm.plugin.expt.edge.b.dHV()) {
        break label389;
      }
      if (!org.apache.commons.c.i.hm(str1)) {
        break label352;
      }
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionMerge data isEmpty!");
      AppMethodBeat.o(122228);
      return;
      String str2 = d.asP(com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.dMg());
      if (!"-1".equals(str2))
      {
        if ((str2 == null) || (str2.isEmpty())) {
          paramczw = str1;
        }
        for (;;)
        {
          if (!i.az(paramczw, l)) {
            break label205;
          }
          if (!atc(paramczw)) {
            break;
          }
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.asT(String.valueOf(System.currentTimeMillis()));
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
      label205:
      if ((str1 != null) && (!str1.isEmpty()))
      {
        paramczw = com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.dMg();
        if ((paramczw == null) || (paramczw.isEmpty()))
        {
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.asT(System.currentTimeMillis() + "@" + str1);
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
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.asT(paramczw);
      break;
    }
    label352:
    com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionMerge data : ".concat(String.valueOf(str1)));
    l = System.currentTimeMillis();
    paramczw.zzP.post(new a.4(paramczw, l, str1));
    label389:
    AppMethodBeat.o(122228);
  }
  
  private static String i(czw paramczw)
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
        localObject2 = paramczw.aaFn.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (eah)((Iterator)localObject2).next();
        str = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(((eah)localObject3).sessionId);
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
        localObject3 = n((eah)localObject3);
        if (localObject3 == null) {
          continue;
        }
        ((Map)localObject1).put(str, localObject3);
        continue;
        AppMethodBeat.o(184378);
      }
      catch (Exception paramczw)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionMergeReport", paramczw, "HellSessionMergereport crash: %s", new Object[] { paramczw.getMessage() });
      }
      return null;
      if (((eah)localObject3).startTime > 0L)
      {
        l2 = localJSONObject.optLong("in");
        l1 = ((eah)localObject3).endTime - ((eah)localObject3).startTime;
        if (l1 <= 0L) {
          break label641;
        }
        label185:
        localJSONObject.put("in", l1 + l2);
        localJSONObject.put("count", localJSONObject.optInt("count") + 1);
        ((Map)localObject1).put(str, localJSONObject);
        continue;
        label229:
        localObject3 = n((eah)localObject3);
        if (localObject3 != null) {
          ((Map)localObject1).put(str, localObject3);
        }
      }
    }
    Object localObject2 = paramczw.aaFo.iterator();
    for (;;)
    {
      label265:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ead)((Iterator)localObject2).next();
        str = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asD(((ead)localObject3).hJW);
        if (str != null) {
          if (((Map)localObject1).containsKey(str))
          {
            localJSONObject = (JSONObject)((Map)localObject1).get(str);
            if (localJSONObject == null)
            {
              localObject3 = d((ead)localObject3);
              if (localObject3 == null) {
                continue;
              }
              ((Map)localObject1).put(str, localObject3);
              continue;
            }
            if (((ead)localObject3).startTime <= 0L) {
              continue;
            }
            l2 = localJSONObject.optLong("in");
            l1 = ((ead)localObject3).endTime - ((ead)localObject3).startTime;
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
      localObject3 = d((ead)localObject3);
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
      if (paramczw.aaFl <= 0L) {
        break;
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("tbe", paramczw.aaFl);
      l1 = paramczw.aaFm - paramczw.aaFl;
      if (l1 > 0L) {}
      for (;;)
      {
        ((JSONObject)localObject1).put("in", l1);
        ((JSONObject)localObject1).put("vv", "2.0");
        ((JSONObject)localObject1).put("content", localObject2);
        paramczw = ((JSONObject)localObject1).toString();
        AppMethodBeat.o(184378);
        return paramczw;
        l1 = 0L;
      }
      label641:
      l1 = 0L;
      break label185;
      label646:
      l1 = 0L;
    }
  }
  
  private static JSONObject n(eah parameah)
  {
    AppMethodBeat.i(122230);
    if (parameah.startTime <= 0L)
    {
      AppMethodBeat.o(122230);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sid", com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(parameah.sessionId));
      long l = parameah.endTime - parameah.startTime;
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
    catch (Exception parameah)
    {
      AppMethodBeat.o(122230);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.e.f
 * JD-Core Version:    0.7.0.1
 */