package com.tencent.mm.plugin.expt.hellhound.a.b.e;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.aj;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.expt.hellhound.a.b.a.b;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.protocal.protobuf.cae;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class a
{
  private static void MP(String paramString)
  {
    AppMethodBeat.i(152411);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(152411);
      return;
    }
    ab.d("HellSessionFlowReport", "habbyge-mali, reportFlow, report: ".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.report.a.Yq(paramString.replace(',', '#'));
    if (paramString != null)
    {
      aj localaj1 = new aj();
      localaj1.cUw = Process.myPid();
      aj localaj2 = localaj1.fN(((h)com.tencent.mm.kernel.g.RI().Rj()).mProcessName);
      localaj2.cTR = com.tencent.mm.plugin.report.a.chG();
      localaj2.cUy = paramString.size();
      int i = 0;
      while (i < paramString.size())
      {
        localaj1.cUx = i;
        localaj1.fO((String)paramString.get(i)).ake();
        i += 1;
      }
    }
    AppMethodBeat.o(152411);
  }
  
  private static JSONArray a(bke parambke, Map<String, List<auy>> paramMap)
  {
    AppMethodBeat.i(152408);
    JSONArray localJSONArray1 = new JSONArray();
    if ((parambke.xkf == null) || (parambke.xkf.isEmpty()))
    {
      AppMethodBeat.o(152408);
      return localJSONArray1;
    }
    parambke = parambke.xkf + "_" + parambke.startTime;
    ab.d("HellSessionFlowReport", "HABBYGE-MALI, pagePathJsonArrayForUnknowPage, unknonwSession: ".concat(String.valueOf(parambke)));
    parambke = (List)paramMap.get(parambke);
    if ((parambke == null) || (parambke.isEmpty()))
    {
      ab.e("HellSessionFlowReport", "HABBYGE-MALI, pagePathJsonArrayForUnknowPage, unknowPageFlow NULL");
      AppMethodBeat.o(152408);
      return localJSONArray1;
    }
    try
    {
      parambke = parambke.iterator();
      while (parambke.hasNext())
      {
        paramMap = (auy)parambke.next();
        if (paramMap != null)
        {
          JSONObject localJSONObject1 = new JSONObject();
          JSONArray localJSONArray2 = new JSONArray();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("pageName", paramMap.xkf);
          localJSONObject2.put("tbe", paramMap.startTime);
          localJSONObject2.put("in", paramMap.duration);
          localJSONArray2.put(localJSONObject2);
          localJSONObject1.put("pagePathInfo", localJSONArray2);
          localJSONArray1.put(localJSONObject1);
          continue;
          AppMethodBeat.o(152408);
        }
      }
    }
    catch (JSONException parambke)
    {
      ab.printErrStackTrace("HellSessionFlowReport", parambke, "HABBYGE-MALI, pagePathJsonArrayForUnknowPage json crash", new Object[0]);
    }
    for (;;)
    {
      return localJSONArray1;
      ab.i("HellSessionFlowReport", "HABBYGE-MALI, pagePathJsonArrayForUnknowPage: " + localJSONArray1.toString());
    }
  }
  
  private static JSONArray a(bki parambki, Map<String, List<auy>> paramMap)
  {
    AppMethodBeat.i(152409);
    localJSONArray1 = new JSONArray();
    parambki = (List)paramMap.get(parambki.czq);
    if ((parambki == null) || (parambki.isEmpty()))
    {
      ab.e("HellSessionFlowReport", "HABBYGE-MALI, pagePathJsonArrayForSession: NULL");
      AppMethodBeat.o(152409);
      return localJSONArray1;
    }
    try
    {
      parambki = parambki.iterator();
      while (parambki.hasNext())
      {
        paramMap = (auy)parambki.next();
        if (paramMap != null)
        {
          JSONObject localJSONObject1 = new JSONObject();
          JSONArray localJSONArray2 = new JSONArray();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("pageName", paramMap.xkf);
          localJSONObject2.put("tbe", paramMap.startTime);
          localJSONObject2.put("in", paramMap.duration);
          a(localJSONObject2, paramMap);
          localJSONArray2.put(localJSONObject2);
          localJSONObject1.put("pagePathInfo", localJSONArray2);
          localJSONArray1.put(localJSONObject1);
        }
      }
      return localJSONArray1;
    }
    catch (JSONException parambki)
    {
      ab.printErrStackTrace("HellSessionFlowReport", parambki, "HABBYGE-MALI, pagePathJsonArrayForSession json crash", new Object[0]);
      AppMethodBeat.o(152409);
    }
  }
  
  static void a(ava paramava, aux paramaux)
  {
    AppMethodBeat.i(152406);
    paramaux = b(paramava, paramaux);
    ab.d("HellSessionFlowReport", "habbyge-mali, HellSessionFlowReport, report: ".concat(String.valueOf(paramaux)));
    if (!TextUtils.isEmpty(paramaux))
    {
      long l2 = System.currentTimeMillis();
      paramava = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.bsr();
      long l1;
      if ((paramava == null) || (paramava.isEmpty())) {
        l1 = 0L;
      }
      for (;;)
      {
        ab.i("HellSessionFlowReport", "habbyge-mali, doReportFlowWhenEvent8, lastReportTime = ".concat(String.valueOf(l1)));
        if (l1 == -1L) {
          break label435;
        }
        if (l1 != 0L) {
          break;
        }
        MP(paramaux);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.MJ(String.valueOf(l2));
        AppMethodBeat.o(152406);
        return;
        if ("-1".equals(paramava)) {
          l1 = -1L;
        } else {
          l1 = Long.valueOf(paramava.split("@")[0]).longValue();
        }
      }
      if (l2 - l1 >= 3600000L)
      {
        paramava = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.bsr();
        if ((paramava == null) || (paramava.isEmpty()))
        {
          paramava = null;
          if ("-1".equals(paramava)) {
            break label435;
          }
          if ((paramava == null) || (paramava.isEmpty())) {
            break label297;
          }
        }
        label297:
        for (paramava = paramava + "|" + paramaux;; paramava = paramaux)
        {
          MP(paramava);
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.MJ(String.valueOf(l2));
          AppMethodBeat.o(152406);
          return;
          if ("-1".equals(paramava))
          {
            paramava = "-1";
            break;
          }
          paramava = paramava.split("@");
          ab.i("HellSessionReportCache", "habbyge-mali, getJsonsOfFlow, args = " + paramava[0]);
          if (paramava.length <= 1)
          {
            paramava = null;
            break;
          }
          paramava = paramava[1];
          break;
        }
      }
      else
      {
        if ((paramaux == null) || (paramaux.isEmpty()))
        {
          AppMethodBeat.o(152406);
          return;
        }
        paramava = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.bsr();
        if ((paramava == null) || (paramava.isEmpty()))
        {
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.MJ(System.currentTimeMillis() + "@" + paramaux);
          AppMethodBeat.o(152406);
          return;
        }
        if ("-1".equals(paramava))
        {
          ab.e("HellSessionReportCache", "habbyge-mali, storeFlow not login");
          AppMethodBeat.o(152406);
          return;
        }
        if (paramava.split("@").length > 1) {
          break label441;
        }
      }
    }
    label435:
    label441:
    for (paramava = paramava + "@" + paramaux;; paramava = paramava + "|" + paramaux)
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.MJ(paramava);
      AppMethodBeat.o(152406);
      return;
    }
  }
  
  private static void a(JSONObject paramJSONObject, auy paramauy)
  {
    AppMethodBeat.i(152410);
    JSONArray localJSONArray = new JSONArray();
    if (paramauy.xkg.isEmpty())
    {
      paramJSONObject.put("businessParam", localJSONArray);
      AppMethodBeat.o(152410);
      return;
    }
    paramauy = paramauy.xkg.iterator();
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
    AppMethodBeat.o(152410);
  }
  
  private static String b(ava paramava, aux paramaux)
  {
    AppMethodBeat.i(152407);
    paramaux = c.c(paramaux);
    Object localObject1 = new ArrayList();
    Object localObject2 = paramaux.entrySet().iterator();
    Object localObject4;
    Object localObject3;
    Object localObject5;
    int j;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject2).next();
      localObject3 = b.MB(b.Mv((String)((Map.Entry)localObject4).getKey()));
      if ((localObject3 == null) || (((List)localObject3).isEmpty()))
      {
        ((List)localObject1).add(((Map.Entry)localObject4).getKey());
      }
      else
      {
        localObject4 = (List)((Map.Entry)localObject4).getValue();
        int i = ((List)localObject4).size() - 1;
        while (i >= 0)
        {
          localObject5 = (auy)((List)localObject4).get(i);
          if (localObject5 != null)
          {
            Iterator localIterator = ((List)localObject3).iterator();
            cae localcae;
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localcae = (cae)localIterator.next();
            } while (!((auy)localObject5).xkf.equals(localcae.xkf));
            j = 1;
            if (j == 0) {
              ((List)localObject4).remove(i);
            }
          }
          i -= 1;
        }
      }
    }
    if (!((List)localObject1).isEmpty())
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramaux.remove((String)((Iterator)localObject1).next());
      }
    }
    ab.w("HellSessionFlowReport", "HABBYGE-MALI, filterSessionPageByCloudConfig pageFlowMap: " + paramaux.size());
    long l;
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("tbe", paramava.xki);
        l = paramava.xkj - paramava.xki;
        if (l > 0L)
        {
          ((JSONObject)localObject1).put("in", l);
          localObject2 = new JSONArray();
          localObject3 = paramava.xkk.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (bki)((Iterator)localObject3).next();
          ab.d("HellSessionFlowReport", "habbyge-mali, generateJsonOfFlow, sid: " + ((bki)localObject4).czq);
          localObject5 = new JSONObject();
          ((JSONObject)localObject5).put("sessionId", ((bki)localObject4).czq);
          ((JSONObject)localObject5).put("tbe", ((bki)localObject4).startTime);
          l = ((bki)localObject4).endTime - ((bki)localObject4).startTime;
          if (l <= 0L) {
            break label530;
          }
          ((JSONObject)localObject5).put("in", l);
          ((JSONObject)localObject5).put("pagePath", a((bki)localObject4, paramaux));
          ((JSONArray)localObject2).put(localObject5);
          continue;
        }
        l = 0L;
      }
      catch (JSONException paramava)
      {
        ab.printErrStackTrace("HellSessionFlowReport", paramava, "HellSessionReport.toJsonOfFlow crash", new Object[0]);
        AppMethodBeat.o(152407);
        return null;
      }
      continue;
      label530:
      l = 0L;
    }
    paramava = paramava.xkm.iterator();
    label544:
    if (paramava.hasNext())
    {
      localObject4 = (bke)paramava.next();
      ab.d("HellSessionFlowReport", "habbyge-mali, generateJsonOfFlow, unknownPage: " + ((bke)localObject4).xkf + " | " + ((bke)localObject4).startTime);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("sessionId", ((bke)localObject4).xkf);
      ((JSONObject)localObject3).put("tbe", ((bke)localObject4).startTime);
      l = ((bke)localObject4).endTime - ((bke)localObject4).startTime;
      if (l <= 0L) {
        break label756;
      }
    }
    for (;;)
    {
      ((JSONObject)localObject3).put("in", l);
      localObject4 = a((bke)localObject4, paramaux);
      ab.d("HellSessionFlowReport", "HABBYGE-MALI, toJsonOfFlow, unknowPagePath: " + ((JSONArray)localObject4).toString());
      ((JSONObject)localObject3).put("pagePath", localObject4);
      ((JSONArray)localObject2).put(localObject3);
      break label544;
      ((JSONObject)localObject1).put("content", localObject2);
      paramava = ((JSONObject)localObject1).toString();
      AppMethodBeat.o(152407);
      return paramava;
      j = 0;
      break;
      label756:
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.e.a
 * JD-Core Version:    0.7.0.1
 */