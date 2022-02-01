package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.d.d.a.4;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.sdk.platformtools.ae;
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
  private static boolean agl(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184379);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184379);
      return false;
    }
    ae.i("HABBYGE-MALI.HellSessionMergeReport", "reportSessionMerge: %s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.report.a.axP(paramString.replace(',', '#'));
    if (paramString != null)
    {
      ep localep1 = new ep();
      localep1.ejT = Process.myPid();
      ep localep2 = localep1.ol(((h)com.tencent.mm.kernel.g.ajO().ajq()).mProcessName);
      localep2.eiF = com.tencent.mm.plugin.report.a.dNr();
      localep2.ejV = paramString.size();
      while (i < paramString.size())
      {
        localep1.ejU = i;
        localep1.om((String)paramString.get(i)).aLH();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184379);
    return bool;
  }
  
  private static JSONObject d(cia paramcia)
  {
    AppMethodBeat.i(122231);
    if (paramcia.startTime <= 0L)
    {
      AppMethodBeat.o(122231);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sid", com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afN(paramcia.duQ));
      long l = paramcia.endTime - paramcia.startTime;
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
    catch (Exception paramcia)
    {
      AppMethodBeat.o(122231);
    }
  }
  
  static void f(bow parambow)
  {
    AppMethodBeat.i(122228);
    String str1 = i(parambow);
    long l = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.afX(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.crQ());
    ae.i("HABBYGE-MALI.HellSessionMergeReport", "doReportSessionMerge, lastReportTime: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (l != -1L) {
      if (l == 0L) {
        if (agl(str1)) {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.agc(String.valueOf(System.currentTimeMillis()));
        }
      }
    }
    for (;;)
    {
      parambow = com.tencent.mm.plugin.expt.d.a.cow().qXi;
      if (!com.tencent.mm.plugin.expt.d.b.coz()) {
        break label373;
      }
      if (!org.apache.commons.b.g.ef(str1)) {
        break label352;
      }
      ae.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionMerge data isEmpty!");
      AppMethodBeat.o(122228);
      return;
      String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.d.afY(com.tencent.mm.plugin.expt.hellhound.a.f.c.g.crQ());
      if (!"-1".equals(str2))
      {
        if ((str2 == null) || (str2.isEmpty())) {
          parambow = str1;
        }
        for (;;)
        {
          if (!i.ar(parambow, l)) {
            break label205;
          }
          if (!agl(parambow)) {
            break;
          }
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.agc(String.valueOf(System.currentTimeMillis()));
          break;
          parambow = str2;
          if (str1 != null)
          {
            parambow = str2;
            if (!str1.isEmpty()) {
              parambow = str2 + "|" + str1;
            }
          }
        }
      }
      label205:
      if ((str1 != null) && (!str1.isEmpty()))
      {
        parambow = com.tencent.mm.plugin.expt.hellhound.a.f.c.g.crQ();
        if ((parambow == null) || (parambow.isEmpty()))
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.g.agc(System.currentTimeMillis() + "@" + str1);
        }
        else
        {
          if (!"-1".equals(parambow)) {
            break;
          }
          ae.e("HABBYGE-MALI.HellSessionReportCache", "storeSessionDetail not login");
        }
      }
    }
    if (parambow.split("@").length <= 1) {}
    for (parambow = parambow + "@" + str1;; parambow = parambow + "|" + str1)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.g.agc(parambow);
      break;
    }
    label352:
    l = System.currentTimeMillis();
    parambow.qXo.execute(new a.4(parambow, l, str1));
    label373:
    AppMethodBeat.o(122228);
  }
  
  private static String i(bow parambow)
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
        localObject2 = parambow.Hco.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (cie)((Iterator)localObject2).next();
        str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(((cie)localObject3).sessionId);
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
        localObject3 = p((cie)localObject3);
        if (localObject3 == null) {
          continue;
        }
        ((Map)localObject1).put(str, localObject3);
        continue;
        AppMethodBeat.o(184378);
      }
      catch (Exception parambow)
      {
        ae.printErrStackTrace("HABBYGE-MALI.HellSessionMergeReport", parambow, "HellSessionMergereport crash: %s", new Object[] { parambow.getMessage() });
      }
      return null;
      if (((cie)localObject3).startTime > 0L)
      {
        l2 = localJSONObject.optLong("in");
        l1 = ((cie)localObject3).endTime - ((cie)localObject3).startTime;
        if (l1 <= 0L) {
          break label641;
        }
        label185:
        localJSONObject.put("in", l1 + l2);
        localJSONObject.put("count", localJSONObject.optInt("count") + 1);
        ((Map)localObject1).put(str, localJSONObject);
        continue;
        label229:
        localObject3 = p((cie)localObject3);
        if (localObject3 != null) {
          ((Map)localObject1).put(str, localObject3);
        }
      }
    }
    Object localObject2 = parambow.Hcq.iterator();
    for (;;)
    {
      label265:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (cia)((Iterator)localObject2).next();
        str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afN(((cia)localObject3).duQ);
        if (str != null) {
          if (((Map)localObject1).containsKey(str))
          {
            localJSONObject = (JSONObject)((Map)localObject1).get(str);
            if (localJSONObject == null)
            {
              localObject3 = d((cia)localObject3);
              if (localObject3 == null) {
                continue;
              }
              ((Map)localObject1).put(str, localObject3);
              continue;
            }
            if (((cia)localObject3).startTime <= 0L) {
              continue;
            }
            l2 = localJSONObject.optLong("in");
            l1 = ((cia)localObject3).endTime - ((cia)localObject3).startTime;
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
      localObject3 = d((cia)localObject3);
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
      if (parambow.Hcm <= 0L) {
        break;
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("tbe", parambow.Hcm);
      l1 = parambow.Hcn - parambow.Hcm;
      if (l1 > 0L) {}
      for (;;)
      {
        ((JSONObject)localObject1).put("in", l1);
        ((JSONObject)localObject1).put("vv", "2.0");
        ((JSONObject)localObject1).put("content", localObject2);
        parambow = ((JSONObject)localObject1).toString();
        AppMethodBeat.o(184378);
        return parambow;
        l1 = 0L;
      }
      label641:
      l1 = 0L;
      break label185;
      label646:
      l1 = 0L;
    }
  }
  
  private static JSONObject p(cie paramcie)
  {
    AppMethodBeat.i(122230);
    if (paramcie.startTime <= 0L)
    {
      AppMethodBeat.o(122230);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sid", com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(paramcie.sessionId));
      long l = paramcie.endTime - paramcie.startTime;
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
    catch (Exception paramcie)
    {
      AppMethodBeat.o(122230);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.f
 * JD-Core Version:    0.7.0.1
 */