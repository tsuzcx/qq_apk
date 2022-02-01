package com.tencent.mm.plugin.expt.hellhound.ext.session.e;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mx;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.d;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.b;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class k
{
  private static JSONArray a(Map<String, List<czu>> paramMap, ead paramead)
  {
    AppMethodBeat.i(184383);
    JSONArray localJSONArray = new JSONArray();
    if ((paramead.hJW == null) || (paramead.hJW.isEmpty()))
    {
      AppMethodBeat.o(184383);
      return localJSONArray;
    }
    Object localObject = paramead.hJW + "_" + paramead.startTime;
    Log.i("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForUnknowPage, unknonwSessionId: %s", new Object[] { localObject });
    localObject = (List)paramMap.get(localObject);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      Log.e("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForUnknowPage, unknowPageFlow NULL");
      AppMethodBeat.o(184383);
      return localJSONArray;
    }
    paramMap = null;
    long l1 = 0L;
    for (;;)
    {
      try
      {
        localObject = ((List)localObject).iterator();
        i = 0;
        if (((Iterator)localObject).hasNext())
        {
          czu localczu = (czu)((Iterator)localObject).next();
          if (localczu == null) {
            continue;
          }
          paramMap = new JSONObject();
          paramMap.put("pageName", localczu.hJW);
          paramMap.put("tbe", localczu.startTime);
          paramMap.put("in", localczu.duration);
          l1 += localczu.duration;
          localJSONArray.put(paramMap);
          i += 1;
          continue;
        }
        l2 = paramead.endTime - paramead.startTime;
        if (l2 >= 5000L) {
          continue;
        }
        paramead.endTime = (l1 + paramead.startTime);
        Log.i("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForUnknowPage: %s", new Object[] { localJSONArray.toString() });
      }
      catch (JSONException paramMap)
      {
        int i;
        long l2;
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", paramMap, "pagePathJsonArrayForUnknowPage json crash", new Object[0]);
        continue;
      }
      AppMethodBeat.o(184383);
      return localJSONArray;
      if (i == 1) {
        paramMap.put("in", l2);
      }
    }
  }
  
  static void a(czw paramczw, czt paramczt)
  {
    AppMethodBeat.i(122260);
    paramczw = b(paramczw, paramczt);
    if (org.apache.commons.c.i.hm(paramczw))
    {
      AppMethodBeat.o(122260);
      return;
    }
    com.tencent.mm.plugin.expt.edge.a.dHT().zxY.aqq(paramczw);
    com.tencent.mm.plugin.expt.hellhound.ext.session.config.e.dLP();
    boolean bool = com.tencent.mm.plugin.expt.hellhound.ext.session.config.e.dLL();
    Log.e("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(122260);
      return;
    }
    atf(paramczw);
    com.tencent.mm.plugin.expt.edge.a.dHT().zxY.aqp(paramczw);
    AppMethodBeat.o(122260);
  }
  
  private static void atf(String paramString)
  {
    AppMethodBeat.i(184384);
    long l = d.asO(com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.dMd());
    Log.i("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport, lastReportTime: %s", new Object[] { Long.valueOf(l) });
    if (l == -1L)
    {
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.asQ(paramString);
      AppMethodBeat.o(184384);
      return;
    }
    if (l == 0L)
    {
      if (atg(paramString)) {
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.asR(String.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(184384);
      return;
    }
    String str2 = d.asP(com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.dMd());
    if ("-1".equals(str2))
    {
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.asQ(paramString);
      AppMethodBeat.o(184384);
      return;
    }
    String str1;
    if ((str2 == null) || (str2.isEmpty())) {
      str1 = paramString;
    }
    while (i.az(str1, l))
    {
      if (atg(str1)) {
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.asR(String.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(184384);
      return;
      str1 = str2;
      if (paramString != null)
      {
        str1 = str2;
        if (!paramString.isEmpty()) {
          str1 = str2 + "|" + paramString;
        }
      }
    }
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.g.asQ(paramString);
    AppMethodBeat.o(184384);
  }
  
  private static boolean atg(String paramString)
  {
    boolean bool = false;
    int i = 0;
    AppMethodBeat.i(184385);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184385);
      return false;
    }
    Log.i("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport, reportSessionUBA: %s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.report.a.aUn(paramString.replace(',', '#'));
    if (paramString != null)
    {
      mx localmx1 = new mx();
      localmx1.jcB = Process.myPid();
      mx localmx2 = localmx1.vn(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName);
      localmx2.iZX = com.tencent.mm.plugin.report.a.gNH();
      localmx2.jcD = paramString.size();
      while (i < paramString.size())
      {
        localmx1.jcC = i;
        localmx1.vo((String)paramString.get(i)).bMH();
        i += 1;
      }
      bool = true;
    }
    AppMethodBeat.o(184385);
    return bool;
  }
  
  private static String b(czw paramczw, czt paramczt)
  {
    AppMethodBeat.i(122261);
    paramczt = j.c(paramczt);
    JSONObject localJSONObject;
    long l;
    JSONArray localJSONArray;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("tbe", paramczw.aaFl);
        l = paramczw.aaFm - paramczw.aaFl;
        if (l > 0L)
        {
          localJSONObject.put("in", l);
          localJSONObject.put("vv", "2.0");
          localJSONArray = new JSONArray();
          localObject1 = paramczw.aaFn.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (eah)((Iterator)localObject1).next();
          Log.i("HABBYGE-MALI.HellSessionUBAReport", "toJsonOfSessionUBA, session: %s", new Object[] { ((eah)localObject2).sessionId });
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("sessionId", ((eah)localObject2).sessionId);
          ((JSONObject)localObject3).put("tbe", ((eah)localObject2).startTime);
          ((JSONObject)localObject3).put("pagePath", b(paramczt, (eah)localObject2));
          l = ((eah)localObject2).endTime - ((eah)localObject2).startTime;
          if (l <= 0L) {
            break label252;
          }
          ((JSONObject)localObject3).put("in", l);
          localJSONArray.put(localObject3);
          continue;
        }
        l = 0L;
      }
      catch (JSONException paramczw)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", paramczw, "HellSessionUBAReport, crash: %s", new Object[] { paramczw.getMessage() });
        AppMethodBeat.o(122261);
        return null;
      }
      continue;
      label252:
      l = 0L;
    }
    paramczw = paramczw.aaFo.iterator();
    if (paramczw.hasNext())
    {
      localObject1 = (ead)paramczw.next();
      localObject2 = new JSONObject();
      localObject3 = b.asD(((ead)localObject1).hJW);
      ((JSONObject)localObject2).put("sessionId", (String)localObject3 + "_" + ((ead)localObject1).startTime);
      ((JSONObject)localObject2).put("tbe", ((ead)localObject1).startTime);
      ((JSONObject)localObject2).put("pagePath", a(paramczt, (ead)localObject1));
      l = ((ead)localObject1).endTime - ((ead)localObject1).startTime;
      if (l <= 0L) {
        break label456;
      }
    }
    for (;;)
    {
      ((JSONObject)localObject2).put("in", l);
      localJSONArray.put(localObject2);
      break;
      if (localJSONArray.length() <= 0)
      {
        Log.e("HABBYGE-MALI.HellSessionUBAReport", "HellSessionUBAReport content is NULL");
        AppMethodBeat.o(122261);
        return null;
      }
      localJSONObject.put("content", localJSONArray);
      paramczw = localJSONObject.toString();
      AppMethodBeat.o(122261);
      return paramczw;
      label456:
      l = 0L;
    }
  }
  
  private static JSONArray b(Map<String, List<czu>> paramMap, eah parameah)
  {
    AppMethodBeat.i(184382);
    JSONArray localJSONArray = new JSONArray();
    Object localObject = (List)paramMap.get(parameah.sessionId);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      Log.e("HABBYGE-MALI.HellSessionUBAReport", "pagePathJsonArrayForSession: NULL");
      AppMethodBeat.o(184382);
      return localJSONArray;
    }
    paramMap = null;
    long l1 = 0L;
    int i;
    try
    {
      localObject = ((List)localObject).iterator();
      i = 0;
      while (((Iterator)localObject).hasNext())
      {
        czu localczu = (czu)((Iterator)localObject).next();
        if (localczu != null)
        {
          paramMap = new JSONObject();
          paramMap.put("pageName", localczu.hJW);
          paramMap.put("tbe", localczu.startTime);
          paramMap.put("in", localczu.duration);
          l1 += localczu.duration;
          i += 1;
          j.a(paramMap, localczu, true, -1L);
          localJSONArray.put(paramMap);
          continue;
          AppMethodBeat.o(184382);
        }
      }
    }
    catch (JSONException paramMap)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBAReport", paramMap, "pagePathJsonArrayForSession json crash", new Object[0]);
    }
    for (;;)
    {
      return localJSONArray;
      long l2 = parameah.endTime - parameah.startTime;
      if (l2 < 5000L) {
        parameah.endTime = (l1 + parameah.startTime);
      } else if (i == 1) {
        paramMap.put("in", l2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.e.k
 * JD-Core Version:    0.7.0.1
 */