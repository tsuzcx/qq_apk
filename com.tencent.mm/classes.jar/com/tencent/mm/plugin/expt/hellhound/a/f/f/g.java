package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.d.a.5;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.f;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.dce;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class g
{
  static String a(bow parambow, String paramString)
  {
    AppMethodBeat.i(196151);
    Object localObject = parambow.Hco.iterator();
    while (((Iterator)localObject).hasNext())
    {
      cie localcie = (cie)((Iterator)localObject).next();
      if ((localcie != null) && (localcie.sessionId.equals(paramString)))
      {
        parambow = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afO(localcie.sCx);
        AppMethodBeat.o(196151);
        return parambow;
      }
    }
    parambow = parambow.Hcq.iterator();
    while (parambow.hasNext())
    {
      localObject = (cia)parambow.next();
      if ((localObject != null) && ((((cia)localObject).dAa.equals(paramString)) || ((((cia)localObject).duQ + "_" + ((cia)localObject).startTime).equals(paramString))))
      {
        parambow = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afO(((cia)localObject).sCx);
        AppMethodBeat.o(196151);
        return parambow;
      }
    }
    AppMethodBeat.o(196151);
    return null;
  }
  
  private static List<c<String, String>> a(bow parambow, bot parambot, cie paramcie)
  {
    AppMethodBeat.i(177400);
    parambot = j.d(parambot);
    paramcie = i.a(parambot, paramcie);
    i.ad(paramcie);
    if ((parambot.isEmpty()) || (paramcie.isEmpty()))
    {
      ae.i("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, toJson, PageFlowMap Empty: %d", new Object[] { Integer.valueOf(paramcie.size()) });
      AppMethodBeat.o(177400);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramcie.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      parambot = (List)((Map.Entry)localIterator1.next()).getValue();
      if (!parambot.isEmpty())
      {
        dce localdce1 = (dce)parambot.get(0);
        if (localdce1.sDg)
        {
          JSONObject localJSONObject1 = i.j(parambow);
          if (localJSONObject1 != null)
          {
            JSONArray localJSONArray = new JSONArray();
            Iterator localIterator2 = parambot.iterator();
            while (localIterator2.hasNext())
            {
              dce localdce2 = (dce)localIterator2.next();
              JSONObject localJSONObject2 = new JSONObject();
              try
              {
                localJSONObject2.put("pagePathId", localdce2.GLJ);
                localJSONObject2.put("sessionId", localdce2.dAa);
                paramcie = a(parambow, localdce2.dAa);
                parambot = paramcie;
                if (paramcie == null) {
                  parambot = "";
                }
                localJSONObject2.put("lastSessionId", parambot);
                localJSONObject2.put("pagePath", a(localdce2.HKG, localJSONObject2, localdce2.GLJ));
                localJSONArray.put(localJSONObject2);
              }
              catch (Exception parambot)
              {
                ae.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", parambot, "toJson, crash-1: %s", new Object[] { parambot.getMessage() });
              }
            }
            if (localJSONArray.length() > 0) {
              try
              {
                localJSONObject1.put("content", localJSONArray);
                if (!TextUtils.isEmpty(localdce1.GLI))
                {
                  ae.i("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, sidJSONObject: %s", new Object[] { localJSONObject1.toString() });
                  localArrayList.add(com.tencent.mm.vending.j.a.N(localdce1.GLI, localJSONObject1.toString()));
                }
              }
              catch (Exception parambot)
              {
                ae.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", parambot, "createJSONObjectHead, crash-2: %s", new Object[] { parambot.getMessage() });
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(177400);
    return localArrayList;
  }
  
  private static JSONArray a(List<bou> paramList, JSONObject paramJSONObject, long paramLong)
  {
    AppMethodBeat.i(196152);
    JSONArray localJSONArray = new JSONArray();
    long l1 = 0L;
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        bou localbou = (bou)paramList.get(i);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("pageName", localbou.duQ);
        localJSONObject.put("tbe", localbou.startTime);
        long l2 = Math.max(localbou.duration, 0L);
        localJSONObject.put("in", l2);
        l1 += l2;
        if (i == 0) {
          paramJSONObject.put("tbe", localbou.startTime);
        }
        j.a(localJSONObject, localbou, false, paramLong);
        j.a(localJSONObject, localbou, paramLong);
        localJSONArray.put(localJSONObject);
        i += 1;
      }
      paramJSONObject.put("in", Math.max(l1, 0L));
    }
    catch (JSONException paramList)
    {
      for (;;)
      {
        ae.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", paramList, "createPagePathJsonArray json crash", new Object[0]);
      }
    }
    AppMethodBeat.o(196152);
    return localJSONArray;
  }
  
  static void a(bow parambow, bot parambot, aup paramaup, cie paramcie)
  {
    AppMethodBeat.i(177399);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.coV()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      ae.e("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, report: fetchHellhoundConfig FALSE !!");
      AppMethodBeat.o(177399);
      return;
    }
    parambot = a(parambow, parambot, paramcie);
    if (parambot == null) {
      ae.e("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, _reportSessionPage: logIdJsonList == null !!");
    }
    for (;;)
    {
      de(b.a(parambow, paramaup));
      AppMethodBeat.o(177399);
      return;
      de(parambot);
    }
  }
  
  private static void de(List<c<String, String>> paramList)
  {
    AppMethodBeat.i(122238);
    if (df(h(paramList, f.crM()))) {
      f.vr(System.currentTimeMillis());
    }
    AppMethodBeat.o(122238);
  }
  
  private static boolean df(List<c<String, String>> paramList)
  {
    AppMethodBeat.i(169361);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(169361);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = true)
    {
      Object localObject1 = (c)localIterator.next();
      Object localObject2 = (String)((c)localObject1).get(1);
      int i;
      Object localObject3;
      if (localObject2 != null) {
        try
        {
          JSONArray localJSONArray = new JSONObject((String)localObject2).optJSONArray("content");
          if (localJSONArray.length() > 0)
          {
            i = 0;
            while (i < localJSONArray.length())
            {
              localObject3 = localJSONArray.optJSONObject(i);
              if ((localObject3 != null) && (((JSONObject)localObject3).optLong("pagePathId", 0L) == 1179880L)) {
                e.ywz.f(19354, new Object[] { Integer.valueOf(9) });
              }
              i += 1;
            }
          }
          ge((String)localObject2, (String)((com.tencent.mm.vending.j.b)localObject1).get(0));
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", localException, "realReportFlow, crash: %s", new Object[] { localException.getMessage() });
        }
      }
      d.aQ(bu.getInt((String)((com.tencent.mm.vending.j.b)localObject1).get(0), -1), (String)localObject2);
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c)((Iterator)localObject1).next();
        com.tencent.mm.plugin.expt.d.d.a locala = com.tencent.mm.plugin.expt.d.a.cow().qXi;
        localObject3 = (String)((c)localObject2).get(1);
        i = Integer.parseInt((String)((com.tencent.mm.vending.j.b)localObject2).get(0));
        if (com.tencent.mm.plugin.expt.d.b.coz()) {
          if ((i <= 0) || (org.apache.commons.b.g.ef((String)localObject3)))
          {
            ae.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageSingle data or sessionPageID isEmpty!");
          }
          else
          {
            long l = System.currentTimeMillis();
            locala.qXo.execute(new a.5(locala, i, l, (String)localObject3));
          }
        }
      }
    }
    AppMethodBeat.o(169361);
    return bool;
  }
  
  private static void ge(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196153);
    if (paramString1 == null)
    {
      AppMethodBeat.o(196153);
      return;
    }
    int j = paramString1.length();
    if (j >= 1900)
    {
      int k = j / 1900;
      int i = 0;
      while (i < k)
      {
        ae.i("HABBYGE-MALI.HellSessionPageDetailReport", "reportSessionPageDetail-item-%d: %s, %s", new Object[] { Integer.valueOf(i), paramString2, paramString1.substring(i * 1900, i * 1900 + 1900) });
        i += 1;
      }
      if (j % 1900 > 0) {
        ae.i("HABBYGE-MALI.HellSessionPageDetailReport", "reportSessionPageDetail-item-left: %s, %s", new Object[] { paramString2, paramString1.substring(k * 1900) });
      }
      AppMethodBeat.o(196153);
      return;
    }
    ae.i("HABBYGE-MALI.HellSessionPageDetailReport", "reportSessionPageDetail-item: %s, %s", new Object[] { paramString2, paramString1 });
    AppMethodBeat.o(196153);
  }
  
  private static List<c<String, String>> h(List<c<String, String>> paramList, String paramString)
  {
    AppMethodBeat.i(184380);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(184380);
      return paramList;
    }
    Object localObject1 = paramList;
    for (;;)
    {
      int i;
      Object localObject2;
      try
      {
        String[] arrayOfString = paramString.split("\\|");
        localObject1 = paramList;
        i = arrayOfString.length;
        if (i <= 0)
        {
          AppMethodBeat.o(184380);
          return paramList;
        }
        localObject1 = paramList;
        if (arrayOfString.length == 1)
        {
          localObject1 = paramList;
          arrayOfString = arrayOfString[0].split("-");
          paramString = paramList;
          localObject1 = paramList;
          if (arrayOfString.length == 2)
          {
            paramString = paramList;
            if (paramList == null)
            {
              localObject1 = paramList;
              paramString = new ArrayList();
            }
            localObject1 = paramString;
            paramString.add(com.tencent.mm.vending.j.a.N(arrayOfString[0], arrayOfString[1]));
          }
          AppMethodBeat.o(184380);
          return paramString;
        }
        localObject1 = paramList;
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          localObject2 = arrayOfString[i];
          paramString = paramList;
          if (localObject2 != null) {
            localObject1 = paramList;
          }
        }
      }
      catch (Exception paramList) {}
      try
      {
        localObject2 = ((String)localObject2).split("-");
        paramString = paramList;
        localObject1 = paramList;
        if (localObject2.length == 2)
        {
          paramString = paramList;
          if (paramList == null)
          {
            localObject1 = paramList;
            paramString = new ArrayList();
          }
          localObject1 = paramString;
          paramString.add(com.tencent.mm.vending.j.a.N(localObject2[0], localObject2[1]));
        }
        i += 1;
        paramList = paramString;
      }
      catch (Exception paramList)
      {
        break label247;
      }
    }
    AppMethodBeat.o(184380);
    return paramList;
    label247:
    ae.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", paramList, "restoreSessionMap crash: %s", new Object[] { paramList.getMessage() });
    AppMethodBeat.o(184380);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.g
 * JD-Core Version:    0.7.0.1
 */