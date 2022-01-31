package com.tencent.mm.plugin.expt.hellhound.a.b.e;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ai;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.protocal.protobuf.cae;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

final class b
{
  private static void J(Map<String, List<auy>> paramMap)
  {
    AppMethodBeat.i(152414);
    Object localObject1 = new ArrayList();
    Object localObject2 = paramMap.entrySet().iterator();
    Object localObject3;
    int i;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        Object localObject4 = (String)((Map.Entry)localObject3).getKey();
        List localList = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.MB((String)localObject4);
        if ((localList == null) || (localList.isEmpty()))
        {
          ab.w("HellSessionMergeReport", "habbyge-mali, needDeleteSession sid: ".concat(String.valueOf(localObject4)));
          ((List)localObject1).add(localObject4);
        }
        else
        {
          localObject3 = (List)((Map.Entry)localObject3).getValue();
          i = ((List)localObject3).size() - 1;
          label131:
          if (i >= 0)
          {
            localObject4 = (auy)((List)localObject3).get(i);
            if (localObject4 != null)
            {
              Iterator localIterator = localList.iterator();
              cae localcae;
              do
              {
                if (!localIterator.hasNext()) {
                  break;
                }
                localcae = (cae)localIterator.next();
              } while (!((auy)localObject4).xkf.equals(localcae.xkf));
            }
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        ((List)localObject3).remove(i);
      }
      i -= 1;
      break label131;
      break;
      if (!((List)localObject1).isEmpty())
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          ab.w("HellSessionMergeReport", "habbyge-mali, pageFlowMap need delete sessoin: ".concat(String.valueOf(localObject2)));
          paramMap.remove(localObject2);
        }
      }
      ab.w("HellSessionMergeReport", "HABBYGE-MALI, filterSessionPageMergeByCloudConfig pageFlowMap: " + paramMap.size());
      AppMethodBeat.o(152414);
      return;
    }
  }
  
  private static void MQ(String paramString)
  {
    AppMethodBeat.i(152417);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(152417);
      return;
    }
    ab.i("HellSessionMergeReport", "habbyge-mali, reportMerge, report: ".concat(String.valueOf(paramString)));
    paramString = a.Yq(paramString.replace(',', '#'));
    if (paramString != null)
    {
      ai localai1 = new ai();
      localai1.cUw = Process.myPid();
      ai localai2 = localai1.fL(((h)com.tencent.mm.kernel.g.RI().Rj()).mProcessName);
      localai2.cTR = a.chG();
      localai2.cUy = paramString.size();
      int i = 0;
      while (i < paramString.size())
      {
        localai1.cUx = i;
        localai1.fM((String)paramString.get(i)).ake();
        i += 1;
      }
    }
    AppMethodBeat.o(152417);
  }
  
  private static JSONObject a(bke parambke, List<auy> paramList)
  {
    AppMethodBeat.i(152416);
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONObject1.put("sid", parambke.xkf);
      long l = parambke.endTime - parambke.startTime;
      if (l > 0L) {}
      for (;;)
      {
        localJSONObject1.put("in", l);
        localJSONObject1.put("count", 1);
        parambke = new JSONArray();
        if ((paramList != null) && (!paramList.isEmpty())) {
          break;
        }
        localJSONObject1.put("pagePath", parambke);
        AppMethodBeat.o(152416);
        return localJSONObject1;
        l = 0L;
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        auy localauy = (auy)localIterator.next();
        if (localauy != null)
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("in", localauy.duration);
          localJSONObject2.put("count", paramList.size());
          localJSONObject2.put("pagePathId", localauy.xkf);
          parambke.put(localJSONObject2);
        }
      }
      localJSONObject1.put("pagePath", parambke);
    }
    catch (Exception parambke)
    {
      AppMethodBeat.o(152416);
      return null;
    }
    AppMethodBeat.o(152416);
    return localJSONObject1;
  }
  
  private static JSONObject a(bki parambki, List<auy> paramList)
  {
    AppMethodBeat.i(152415);
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONObject1.put("sid", com.tencent.mm.plugin.expt.hellhound.a.b.a.b.Mv(parambki.czq));
      long l = parambki.endTime - parambki.startTime;
      if (l > 0L) {}
      for (;;)
      {
        localJSONObject1.put("in", l);
        localJSONObject1.put("count", 1);
        parambki = new JSONArray();
        if ((paramList != null) && (!paramList.isEmpty())) {
          break;
        }
        localJSONObject1.put("pagePath", parambki);
        AppMethodBeat.o(152415);
        return localJSONObject1;
        l = 0L;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        auy localauy = (auy)paramList.next();
        if (localauy != null)
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("in", localauy.duration);
          localJSONObject2.put("count", localauy.count);
          localJSONObject2.put("pagePathId", localauy.xkf);
          parambki.put(localJSONObject2);
        }
      }
      localJSONObject1.put("pagePath", parambki);
    }
    catch (Exception parambki)
    {
      AppMethodBeat.o(152415);
      return null;
    }
    AppMethodBeat.o(152415);
    return localJSONObject1;
  }
  
  static void c(ava paramava, aux paramaux)
  {
    AppMethodBeat.i(152412);
    paramaux = d(paramava, paramaux);
    ab.i("HellSessionMergeReport", "habbyge-mali, HellSessionMergeReport, report: ".concat(String.valueOf(paramaux)));
    if (!TextUtils.isEmpty(paramaux))
    {
      long l2 = System.currentTimeMillis();
      paramava = c.bss();
      long l1;
      if ((paramava == null) || (paramava.isEmpty())) {
        l1 = 0L;
      }
      for (;;)
      {
        ab.i("HellSessionMergeReport", "habbyge-mali, doReportFlowWhenEvent8, lastReportTime = ".concat(String.valueOf(l1)));
        if (l1 == -1L) {
          break label442;
        }
        if (l1 != 0L) {
          break;
        }
        MQ(paramaux);
        c.MK(String.valueOf(l2));
        AppMethodBeat.o(152412);
        return;
        if ("-1".equals(paramava)) {
          l1 = -1L;
        } else {
          l1 = Long.valueOf(paramava.split("@")[0]).longValue();
        }
      }
      if (l2 - l1 >= 3600000L)
      {
        paramava = c.bss();
        if ((paramava == null) || (paramava.isEmpty()))
        {
          paramava = null;
          if ("-1".equals(paramava)) {
            break label442;
          }
          if ((paramava == null) || (paramava.isEmpty())) {
            break label301;
          }
        }
        label301:
        for (paramava = paramava + "|" + paramaux;; paramava = paramaux)
        {
          MQ(paramava);
          c.MK(String.valueOf(l2));
          AppMethodBeat.o(152412);
          return;
          if ("-1".equals(paramava))
          {
            paramava = "-1";
            break;
          }
          paramava = paramava.split("@");
          ab.i("HellSessionReportCache", "habbyge-mali, getJsonsOfMerge, args = " + paramava[0]);
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
          AppMethodBeat.o(152412);
          return;
        }
        paramava = c.bss();
        if ((paramava == null) || (paramava.isEmpty()))
        {
          c.MK(System.currentTimeMillis() + "@" + paramaux);
          AppMethodBeat.o(152412);
          return;
        }
        if ("-1".equals(paramava))
        {
          ab.e("HellSessionReportCache", "habbyge-mali, storeMerge not login");
          AppMethodBeat.o(152412);
          return;
        }
        if (paramava.split("@").length > 1) {
          break label449;
        }
      }
    }
    label442:
    label449:
    for (paramava = paramava + "@" + paramaux;; paramava = paramava + "|" + paramaux)
    {
      c.MK(paramava);
      AppMethodBeat.o(152412);
      return;
    }
  }
  
  private static String d(ava paramava, aux paramaux)
  {
    AppMethodBeat.i(152413);
    Object localObject1 = new HashMap();
    paramaux = paramaux.fjy.iterator();
    Object localObject3;
    Object localObject4;
    Object localObject5;
    int i;
    label237:
    long l1;
    while (paramaux.hasNext())
    {
      localObject2 = (auy)paramaux.next();
      if (localObject2 != null) {
        if ((((auy)localObject2).czq != null) && (!((auy)localObject2).czq.isEmpty()))
        {
          localObject3 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.Mv(((auy)localObject2).czq);
          if ((localObject3 != null) && (!((String)localObject3).isEmpty())) {
            if (((Map)localObject1).containsKey(localObject3))
            {
              localObject4 = (List)((Map)localObject1).get(localObject3);
              if (localObject4 == null)
              {
                localObject4 = new ArrayList();
                ((List)localObject4).add(localObject2);
                ((Map)localObject1).put(localObject3, localObject4);
              }
              else
              {
                localObject3 = ((List)localObject4).iterator();
                do
                {
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  localObject5 = (auy)((Iterator)localObject3).next();
                } while ((localObject5 == null) || (!((auy)localObject5).xkf.equals(((auy)localObject2).xkf)));
                ((auy)localObject5).duration += ((auy)localObject2).duration;
                ((auy)localObject5).count += 1;
                i = 1;
                if (i != 0) {
                  break label1083;
                }
                ((List)localObject4).add(localObject2);
              }
            }
            else
            {
              localObject4 = new ArrayList();
              ((List)localObject4).add(localObject2);
              ((Map)localObject1).put(localObject3, localObject4);
            }
          }
        }
        else if (((Map)localObject1).containsKey(((auy)localObject2).xkf))
        {
          localObject3 = (List)((Map)localObject1).get(((auy)localObject2).xkf);
          if (localObject3 == null)
          {
            localObject3 = new ArrayList();
            ((List)localObject3).add(localObject2);
            ((Map)localObject1).put(((auy)localObject2).xkf, localObject3);
          }
          else
          {
            localObject3 = (auy)((List)localObject3).get(0);
            l1 = ((auy)localObject3).duration;
            ((auy)localObject2).duration += l1;
          }
        }
        else
        {
          localObject3 = new ArrayList();
          ((List)localObject3).add(localObject2);
          ((Map)localObject1).put(((auy)localObject2).xkf, localObject3);
        }
      }
    }
    J((Map)localObject1);
    ab.i("HellSessionMergeReport", "habbyge-mali, pageFlowMap: " + ((Map)localObject1).size());
    JSONObject localJSONObject;
    long l2;
    for (;;)
    {
      try
      {
        paramaux = new HashMap();
        localObject2 = paramava.xkk.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject4 = (bki)((Iterator)localObject2).next();
        localObject3 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.Mv(((bki)localObject4).czq);
        if (localObject3 == null) {
          continue;
        }
        ab.i("HellSessionMergeReport", "habbyge-mali, generateJsonOfMerge, sid = ".concat(String.valueOf(localObject3)));
        localObject5 = (List)((Map)localObject1).get(localObject3);
        if (!paramaux.containsKey(localObject3)) {
          break label699;
        }
        localJSONObject = (JSONObject)paramaux.get(localObject3);
        if (localJSONObject == null)
        {
          localObject4 = a((bki)localObject4, (List)localObject5);
          if (localObject4 == null) {
            continue;
          }
          paramaux.put(localObject3, localObject4);
          continue;
        }
        l2 = localJSONObject.optLong("in");
      }
      catch (Exception paramava)
      {
        ab.printErrStackTrace("HellSessionMergeReport", paramava, "HellSessionReport.generateJason crash", new Object[0]);
        AppMethodBeat.o(152413);
        return null;
      }
      l1 = ((bki)localObject4).endTime - ((bki)localObject4).startTime;
      if (l1 <= 0L) {
        break label1085;
      }
      label656:
      localJSONObject.put("in", l1 + l2);
      localJSONObject.put("count", localJSONObject.optInt("count") + 1);
      paramaux.put(localObject3, localJSONObject);
      continue;
      label699:
      localObject4 = a((bki)localObject4, (List)localObject5);
      if (localObject4 != null) {
        paramaux.put(localObject3, localObject4);
      }
    }
    Object localObject2 = paramava.xkm.iterator();
    for (;;)
    {
      label736:
      if (((Iterator)localObject2).hasNext())
      {
        localObject4 = (bke)((Iterator)localObject2).next();
        localObject3 = ((bke)localObject4).xkf;
        if (localObject3 != null)
        {
          localObject5 = (List)((Map)localObject1).get(localObject3);
          ab.i("HellSessionMergeReport", "habbyge-mali, generateJsonOfMerge, unknownSid = ".concat(String.valueOf(localObject3)));
          if (paramaux.containsKey(localObject3))
          {
            localJSONObject = (JSONObject)paramaux.get(localObject3);
            if (localJSONObject == null)
            {
              localObject4 = a((bke)localObject4, (List)localObject5);
              if (localObject4 == null) {
                continue;
              }
              paramaux.put(localObject3, localObject4);
              continue;
            }
            l2 = localJSONObject.optLong("in");
            l1 = ((bke)localObject4).endTime - ((bke)localObject4).startTime;
            if (l1 <= 0L) {
              break label1090;
            }
          }
        }
      }
    }
    for (;;)
    {
      localJSONObject.put("in", l1 + l2);
      localJSONObject.put("count", localJSONObject.optInt("count") + 1);
      paramaux.put(localObject3, localJSONObject);
      break label736;
      localObject4 = a((bke)localObject4, (List)localObject5);
      if (localObject4 == null) {
        break label736;
      }
      paramaux.put(localObject3, localObject4);
      break label736;
      localObject1 = new JSONArray();
      paramaux = paramaux.entrySet().iterator();
      while (paramaux.hasNext()) {
        ((JSONArray)localObject1).put(((Map.Entry)paramaux.next()).getValue());
      }
      paramaux = new JSONObject();
      paramaux.put("tbe", paramava.xki);
      l1 = paramava.xkj - paramava.xki;
      if (l1 > 0L) {}
      for (;;)
      {
        paramaux.put("in", l1);
        paramaux.put("content", localObject1);
        paramava = paramaux.toString();
        AppMethodBeat.o(152413);
        return paramava;
        l1 = 0L;
      }
      i = 0;
      break label237;
      label1083:
      break;
      label1085:
      l1 = 0L;
      break label656;
      label1090:
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.e.b
 * JD-Core Version:    0.7.0.1
 */