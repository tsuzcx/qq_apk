package com.tencent.mm.plugin.expt.hellhound.a.b.e;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ak;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class d
{
  private static void MR(String paramString)
  {
    AppMethodBeat.i(152429);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(152429);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.bso();
    ab.i("HellSessionUBAReport", "habbyge-mali, doReportSessionUBAWhenEvent8, lastReportTime = ".concat(String.valueOf(l2)));
    if (l2 == -1L)
    {
      AppMethodBeat.o(152429);
      return;
    }
    if (l2 == 0L)
    {
      MS(paramString);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.MI(String.valueOf(l1));
      AppMethodBeat.o(152429);
      return;
    }
    if (l1 - l2 >= 3600000L)
    {
      String str2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.bsq();
      if ("-1".equals(str2))
      {
        AppMethodBeat.o(152429);
        return;
      }
      String str1 = paramString;
      if (str2 != null)
      {
        str1 = paramString;
        if (!str2.isEmpty()) {
          str1 = str2 + "|" + paramString;
        }
      }
      MS(str1);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.MI(String.valueOf(l1));
      AppMethodBeat.o(152429);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.b.b.c.MH(paramString);
    AppMethodBeat.o(152429);
  }
  
  private static void MS(String paramString)
  {
    AppMethodBeat.i(152430);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(152430);
      return;
    }
    ab.d("HellSessionUBAReport", "habbyge-mali, reportUBA, report: ".concat(String.valueOf(paramString)));
    paramString = a.Yq(paramString.replace(',', '#'));
    if (paramString != null)
    {
      ak localak1 = new ak();
      localak1.cUw = Process.myPid();
      ak localak2 = localak1.fP(((h)com.tencent.mm.kernel.g.RI().Rj()).mProcessName);
      localak2.cTR = a.chG();
      localak2.cUy = paramString.size();
      int i = 0;
      while (i < paramString.size())
      {
        localak1.cUx = i;
        localak1.fQ((String)paramString.get(i)).ake();
        i += 1;
      }
    }
    AppMethodBeat.o(152430);
  }
  
  private static JSONArray a(bke parambke, Map<String, List<auy>> paramMap)
  {
    AppMethodBeat.i(152428);
    JSONArray localJSONArray = new JSONArray();
    if ((parambke.xkf == null) || (parambke.xkf.isEmpty()))
    {
      AppMethodBeat.o(152428);
      return localJSONArray;
    }
    Object localObject = parambke.xkf + "_" + parambke.startTime;
    ab.d("HellSessionUBAReport", "HABBYGE-MALI, pagePathJsonArrayForUnknowPage, unknonwSession: ".concat(String.valueOf(localObject)));
    localObject = (List)paramMap.get(localObject);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ab.e("HellSessionUBAReport", "HABBYGE-MALI, pagePathJsonArrayForUnknowPage, unknowPageFlow NULL");
      AppMethodBeat.o(152428);
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
          auy localauy = (auy)((Iterator)localObject).next();
          if (localauy == null) {
            continue;
          }
          paramMap = new JSONObject();
          paramMap.put("pageName", localauy.xkf);
          paramMap.put("tbe", localauy.startTime);
          paramMap.put("in", localauy.duration);
          l1 += localauy.duration;
          localJSONArray.put(paramMap);
          i += 1;
          continue;
        }
        l2 = parambke.endTime - parambke.startTime;
        if (l2 >= 5000L) {
          continue;
        }
        parambke.endTime = (l1 + parambke.startTime);
        ab.i("HellSessionUBAReport", "HABBYGE-MALI, pagePathJsonArrayForUnknowPage: " + localJSONArray.toString());
      }
      catch (JSONException parambke)
      {
        int i;
        long l2;
        ab.printErrStackTrace("HellSessionUBAReport", parambke, "HABBYGE-MALI, pagePathJsonArrayForUnknowPage json crash", new Object[0]);
        continue;
      }
      AppMethodBeat.o(152428);
      return localJSONArray;
      if (i == 1) {
        paramMap.put("in", l2);
      }
    }
  }
  
  private static JSONArray a(bki parambki, Map<String, List<auy>> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(152426);
    JSONArray localJSONArray = new JSONArray();
    Object localObject = (List)paramMap.get(parambki.czq);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ab.e("HellSessionUBAReport", "HABBYGE-MALI, pagePathJsonArrayForSession: NULL");
      AppMethodBeat.o(152426);
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
        auy localauy = (auy)((Iterator)localObject).next();
        if (localauy != null)
        {
          paramMap = new JSONObject();
          paramMap.put("pageName", localauy.xkf);
          paramMap.put("tbe", localauy.startTime);
          paramMap.put("in", localauy.duration);
          l1 += localauy.duration;
          i += 1;
          if (!paramBoolean) {
            a(paramMap, localauy);
          }
          localJSONArray.put(paramMap);
          continue;
          AppMethodBeat.o(152426);
        }
      }
    }
    catch (JSONException parambki)
    {
      ab.printErrStackTrace("HellSessionUBAReport", parambki, "HABBYGE-MALI, pagePathJsonArrayForSession json crash", new Object[0]);
    }
    for (;;)
    {
      return localJSONArray;
      long l2 = parambki.endTime - parambki.startTime;
      if (l2 < 5000L) {
        parambki.endTime = (l1 + parambki.startTime);
      } else if (i == 1) {
        paramMap.put("in", l2);
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject, auy paramauy)
  {
    AppMethodBeat.i(152427);
    JSONArray localJSONArray = new JSONArray();
    if (paramauy.xkh.isEmpty())
    {
      paramJSONObject.put("businessParam", localJSONArray);
      AppMethodBeat.o(152427);
      return;
    }
    paramauy = paramauy.xkh.iterator();
    while (paramauy.hasNext())
    {
      auz localauz = (auz)paramauy.next();
      if (localauz != null)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("value", localauz.value);
        localJSONObject.put("dataPath", localauz.dataPath);
        localJSONArray.put(localJSONObject);
      }
    }
    paramJSONObject.put("businessParam", localJSONArray);
    AppMethodBeat.o(152427);
  }
  
  static void f(ava paramava, aux paramaux)
  {
    AppMethodBeat.i(152424);
    MR(g(paramava, paramaux));
    AppMethodBeat.o(152424);
  }
  
  private static String g(ava paramava, aux paramaux)
  {
    AppMethodBeat.i(152425);
    paramaux = c.c(paramaux);
    com.tencent.mm.plugin.expt.hellhound.a.b.a.d.bsf();
    boolean bool = com.tencent.mm.plugin.expt.hellhound.a.b.a.d.bsd();
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
        localJSONObject.put("tbe", paramava.xki);
        l = paramava.xkj - paramava.xki;
        if (l > 0L)
        {
          localJSONObject.put("in", l);
          localJSONArray = new JSONArray();
          localObject1 = paramava.xkk.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (bki)((Iterator)localObject1).next();
          ab.d("HellSessionUBAReport", "habbyge-mali, toJsonOfSessionUBA, session: " + ((bki)localObject2).czq);
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("sessionId", ((bki)localObject2).czq);
          ((JSONObject)localObject3).put("tbe", ((bki)localObject2).startTime);
          ((JSONObject)localObject3).put("pagePath", a((bki)localObject2, paramaux, bool));
          l = ((bki)localObject2).endTime - ((bki)localObject2).startTime;
          if (l <= 0L) {
            break label248;
          }
          ((JSONObject)localObject3).put("in", l);
          localJSONArray.put(localObject3);
          continue;
        }
        l = 0L;
      }
      catch (JSONException paramava)
      {
        ab.printErrStackTrace("HellSessionUBAReport", paramava, "HellSessionReport.toJsonOfSessionUBA crash", new Object[0]);
        AppMethodBeat.o(152425);
        return null;
      }
      continue;
      label248:
      l = 0L;
    }
    paramava = paramava.xkm.iterator();
    if (paramava.hasNext())
    {
      localObject1 = (bke)paramava.next();
      ab.d("HellSessionUBAReport", "habbyge-mali, toJsonOfSessionUBA, unknownPage: " + ((bke)localObject1).xkf + " | " + ((bke)localObject1).startTime);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("sessionId", ((bke)localObject1).xkf);
      ((JSONObject)localObject2).put("tbe", ((bke)localObject1).startTime);
      localObject3 = a((bke)localObject1, paramaux);
      ab.d("HellSessionUBAReport", "HABBYGE-MALI, toJsonOfFlow, unknowPagePath: " + ((JSONArray)localObject3).toString());
      ((JSONObject)localObject2).put("pagePath", localObject3);
      l = ((bke)localObject1).endTime - ((bke)localObject1).startTime;
      if (l <= 0L) {
        break label465;
      }
    }
    for (;;)
    {
      ((JSONObject)localObject2).put("in", l);
      localJSONArray.put(localObject2);
      break;
      localJSONObject.put("content", localJSONArray);
      paramava = localJSONObject.toString();
      AppMethodBeat.o(152425);
      return paramava;
      label465:
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.e.d
 * JD-Core Version:    0.7.0.1
 */