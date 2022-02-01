package com.tencent.mm.plugin.expt.hellhound.ext.session.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.edge.d.a.5;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.ezd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.j.c;
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

final class g
{
  static String a(czw paramczw, String paramString)
  {
    AppMethodBeat.i(300225);
    Object localObject = paramczw.aaFn.iterator();
    while (((Iterator)localObject).hasNext())
    {
      eah localeah = (eah)((Iterator)localObject).next();
      if ((localeah != null) && (localeah.sessionId.equals(paramString)))
      {
        paramczw = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asE(localeah.qkQ);
        AppMethodBeat.o(300225);
        return paramczw;
      }
    }
    paramczw = paramczw.aaFo.iterator();
    while (paramczw.hasNext())
    {
      localObject = (ead)paramczw.next();
      if ((localObject != null) && ((((ead)localObject).hQR.equals(paramString)) || ((((ead)localObject).hJW + "_" + ((ead)localObject).startTime).equals(paramString))))
      {
        paramczw = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asE(((ead)localObject).qkQ);
        AppMethodBeat.o(300225);
        return paramczw;
      }
    }
    AppMethodBeat.o(300225);
    return null;
  }
  
  private static List<c<String, String>> a(czw paramczw, czt paramczt, eah parameah)
  {
    AppMethodBeat.i(177400);
    paramczt = j.d(paramczt);
    parameah = i.a(paramczt, parameah);
    i.ai(parameah);
    if ((paramczt.isEmpty()) || (parameah.isEmpty()))
    {
      Log.i("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, toJson, PageFlowMap Empty: %d", new Object[] { Integer.valueOf(parameah.size()) });
      AppMethodBeat.o(177400);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = parameah.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      paramczt = (List)((Map.Entry)localIterator1.next()).getValue();
      if (!paramczt.isEmpty())
      {
        ezd localezd1 = (ezd)paramczt.get(0);
        if (localezd1.lAr)
        {
          JSONObject localJSONObject1 = i.j(paramczw);
          if (localJSONObject1 != null)
          {
            JSONArray localJSONArray = new JSONArray();
            Iterator localIterator2 = paramczt.iterator();
            while (localIterator2.hasNext())
            {
              ezd localezd2 = (ezd)localIterator2.next();
              JSONObject localJSONObject2 = new JSONObject();
              try
              {
                localJSONObject2.put("pagePathId", localezd2.aajX);
                localJSONObject2.put("sessionId", localezd2.hQR);
                parameah = a(paramczw, localezd2.hQR);
                paramczt = parameah;
                if (parameah == null) {
                  paramczt = "";
                }
                localJSONObject2.put("lastSessionId", paramczt);
                localJSONObject2.put("pagePath", a(localezd2.abAj, localJSONObject2, localezd2.aajX));
                localJSONArray.put(localJSONObject2);
              }
              catch (Exception paramczt)
              {
                Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", paramczt, "toJson, crash-1: %s", new Object[] { paramczt.getMessage() });
              }
            }
            if (localJSONArray.length() > 0) {
              try
              {
                localJSONObject1.put("content", localJSONArray);
                if (!TextUtils.isEmpty(localezd1.aajW))
                {
                  Log.i("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, sidJSONObject: %s", new Object[] { localJSONObject1.toString() });
                  localArrayList.add(com.tencent.mm.vending.j.a.U(localezd1.aajW, localJSONObject1.toString()));
                }
              }
              catch (Exception paramczt)
              {
                Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", paramczt, "createJSONObjectHead, crash-2: %s", new Object[] { paramczt.getMessage() });
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(177400);
    return localArrayList;
  }
  
  private static JSONArray a(List<czu> paramList, JSONObject paramJSONObject, long paramLong)
  {
    AppMethodBeat.i(300229);
    JSONArray localJSONArray = new JSONArray();
    long l1 = 0L;
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        czu localczu = (czu)paramList.get(i);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("pageName", localczu.hJW);
        localJSONObject.put("tbe", localczu.startTime);
        long l2 = Math.max(localczu.duration, 0L);
        localJSONObject.put("in", l2);
        l1 += l2;
        if (i == 0) {
          paramJSONObject.put("tbe", localczu.startTime);
        }
        j.a(localJSONObject, localczu, false, paramLong);
        j.a(localJSONObject, localczu, paramLong);
        localJSONArray.put(localJSONObject);
        i += 1;
      }
      paramJSONObject.put("in", Math.max(l1, 0L));
    }
    catch (JSONException paramList)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", paramList, "createPagePathJsonArray json crash", new Object[0]);
      }
    }
    AppMethodBeat.o(300229);
    return localJSONArray;
  }
  
  static void a(czw paramczw, czt paramczt, cat paramcat, eah parameah)
  {
    AppMethodBeat.i(177399);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dIK()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      Log.e("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, report: fetchHellhoundConfig FALSE !!");
      AppMethodBeat.o(177399);
      return;
    }
    paramczt = a(paramczw, paramczt, parameah);
    if (paramczt == null) {
      Log.e("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, _reportSessionPage: logIdJsonList == null !!");
    }
    for (;;)
    {
      ft(b.a(paramczw, paramcat));
      AppMethodBeat.o(177399);
      return;
      ft(paramczt);
    }
  }
  
  private static void ft(List<c<String, String>> paramList)
  {
    AppMethodBeat.i(122238);
    if (fu(j(paramList, com.tencent.mm.plugin.expt.hellhound.ext.session.b.f.dMc()))) {
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.f.mh(System.currentTimeMillis());
    }
    AppMethodBeat.o(122238);
  }
  
  private static boolean fu(List<c<String, String>> paramList)
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
                com.tencent.mm.plugin.report.f.Ozc.b(19354, new Object[] { Integer.valueOf(9) });
              }
              i += 1;
            }
          }
          hu((String)localObject2, (String)((com.tencent.mm.vending.j.b)localObject1).get(0));
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", localException, "realReportFlow, crash: %s", new Object[] { localException.getMessage() });
        }
      }
      d.bo(Util.getInt((String)((com.tencent.mm.vending.j.b)localObject1).get(0), -1), (String)localObject2);
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c)((Iterator)localObject1).next();
        com.tencent.mm.plugin.expt.edge.d.a locala = com.tencent.mm.plugin.expt.edge.a.dHT().zxY;
        localObject3 = (String)((c)localObject2).get(1);
        i = Integer.parseInt((String)((com.tencent.mm.vending.j.b)localObject2).get(0));
        if (com.tencent.mm.plugin.expt.edge.b.dHV()) {
          if ((i <= 0) || (org.apache.commons.c.i.hm((String)localObject3)))
          {
            Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageSingle data or sessionPageID isEmpty!");
          }
          else
          {
            com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageSingle reportID : " + i + ", data : " + (String)localObject3);
            long l = System.currentTimeMillis();
            locala.zzP.post(new a.5(locala, i, l, (String)localObject3));
          }
        }
      }
    }
    AppMethodBeat.o(169361);
    return bool;
  }
  
  private static void hu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(300252);
    if (paramString1 == null)
    {
      AppMethodBeat.o(300252);
      return;
    }
    int j = paramString1.length();
    if (j >= 1900)
    {
      int k = j / 1900;
      int i = 0;
      while (i < k)
      {
        Log.i("HABBYGE-MALI.HellSessionPageDetailReport", "reportSessionPageDetail-item-%d: %s, %s", new Object[] { Integer.valueOf(i), paramString2, paramString1.substring(i * 1900, i * 1900 + 1900) });
        i += 1;
      }
      if (j % 1900 > 0) {
        Log.i("HABBYGE-MALI.HellSessionPageDetailReport", "reportSessionPageDetail-item-left: %s, %s", new Object[] { paramString2, paramString1.substring(k * 1900) });
      }
      AppMethodBeat.o(300252);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionPageDetailReport", "reportSessionPageDetail-item: %s, %s", new Object[] { paramString2, paramString1 });
    AppMethodBeat.o(300252);
  }
  
  private static List<c<String, String>> j(List<c<String, String>> paramList, String paramString)
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
            paramString.add(com.tencent.mm.vending.j.a.U(arrayOfString[0], arrayOfString[1]));
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
          paramString.add(com.tencent.mm.vending.j.a.U(localObject2[0], localObject2[1]));
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
    Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", paramList, "restoreSessionMap crash: %s", new Object[] { paramList.getMessage() });
    AppMethodBeat.o(184380);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.e.g
 * JD-Core Version:    0.7.0.1
 */