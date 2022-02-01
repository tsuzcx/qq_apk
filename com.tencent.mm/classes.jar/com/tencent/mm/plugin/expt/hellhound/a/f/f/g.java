package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.d.a.5;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.f;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  static String a(cbo paramcbo, String paramString)
  {
    AppMethodBeat.i(220582);
    Object localObject = paramcbo.Mhr.iterator();
    while (((Iterator)localObject).hasNext())
    {
      cyl localcyl = (cyl)((Iterator)localObject).next();
      if ((localcyl != null) && (localcyl.sessionId.equals(paramString)))
      {
        paramcbo = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqz(localcyl.kvy);
        AppMethodBeat.o(220582);
        return paramcbo;
      }
    }
    paramcbo = paramcbo.Mht.iterator();
    while (paramcbo.hasNext())
    {
      localObject = (cyh)paramcbo.next();
      if ((localObject != null) && ((((cyh)localObject).dRM.equals(paramString)) || ((((cyh)localObject).dMl + "_" + ((cyh)localObject).startTime).equals(paramString))))
      {
        paramcbo = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqz(((cyh)localObject).kvy);
        AppMethodBeat.o(220582);
        return paramcbo;
      }
    }
    AppMethodBeat.o(220582);
    return null;
  }
  
  private static List<c<String, String>> a(cbo paramcbo, cbl paramcbl, cyl paramcyl)
  {
    AppMethodBeat.i(177400);
    paramcbl = j.d(paramcbl);
    paramcyl = i.a(paramcbl, paramcyl);
    i.ag(paramcyl);
    if ((paramcbl.isEmpty()) || (paramcyl.isEmpty()))
    {
      Log.i("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, toJson, PageFlowMap Empty: %d", new Object[] { Integer.valueOf(paramcyl.size()) });
      AppMethodBeat.o(177400);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramcyl.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      paramcbl = (List)((Map.Entry)localIterator1.next()).getValue();
      if (!paramcbl.isEmpty())
      {
        dvi localdvi1 = (dvi)paramcbl.get(0);
        if (localdvi1.vtY)
        {
          JSONObject localJSONObject1 = i.j(paramcbo);
          if (localJSONObject1 != null)
          {
            JSONArray localJSONArray = new JSONArray();
            Iterator localIterator2 = paramcbl.iterator();
            while (localIterator2.hasNext())
            {
              dvi localdvi2 = (dvi)localIterator2.next();
              JSONObject localJSONObject2 = new JSONObject();
              try
              {
                localJSONObject2.put("pagePathId", localdvi2.LPN);
                localJSONObject2.put("sessionId", localdvi2.dRM);
                paramcyl = a(paramcbo, localdvi2.dRM);
                paramcbl = paramcyl;
                if (paramcyl == null) {
                  paramcbl = "";
                }
                localJSONObject2.put("lastSessionId", paramcbl);
                localJSONObject2.put("pagePath", a(localdvi2.MWp, localJSONObject2, localdvi2.LPN));
                localJSONArray.put(localJSONObject2);
              }
              catch (Exception paramcbl)
              {
                Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", paramcbl, "toJson, crash-1: %s", new Object[] { paramcbl.getMessage() });
              }
            }
            if (localJSONArray.length() > 0) {
              try
              {
                localJSONObject1.put("content", localJSONArray);
                if (!TextUtils.isEmpty(localdvi1.LPM))
                {
                  Log.i("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, sidJSONObject: %s", new Object[] { localJSONObject1.toString() });
                  localArrayList.add(com.tencent.mm.vending.j.a.Q(localdvi1.LPM, localJSONObject1.toString()));
                }
              }
              catch (Exception paramcbl)
              {
                Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", paramcbl, "createJSONObjectHead, crash-2: %s", new Object[] { paramcbl.getMessage() });
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(177400);
    return localArrayList;
  }
  
  private static JSONArray a(List<cbm> paramList, JSONObject paramJSONObject, long paramLong)
  {
    AppMethodBeat.i(220583);
    JSONArray localJSONArray = new JSONArray();
    long l1 = 0L;
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        cbm localcbm = (cbm)paramList.get(i);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("pageName", localcbm.dMl);
        localJSONObject.put("tbe", localcbm.startTime);
        long l2 = Math.max(localcbm.duration, 0L);
        localJSONObject.put("in", l2);
        l1 += l2;
        if (i == 0) {
          paramJSONObject.put("tbe", localcbm.startTime);
        }
        j.a(localJSONObject, localcbm, false, paramLong);
        j.a(localJSONObject, localcbm, paramLong);
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
    AppMethodBeat.o(220583);
    return localJSONArray;
  }
  
  static void a(cbo paramcbo, cbl paramcbl, bfy parambfy, cyl paramcyl)
  {
    AppMethodBeat.i(177399);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cNo()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      Log.e("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, report: fetchHellhoundConfig FALSE !!");
      AppMethodBeat.o(177399);
      return;
    }
    paramcbl = a(paramcbo, paramcbl, paramcyl);
    if (paramcbl == null) {
      Log.e("HABBYGE-MALI.HellSessionPageDetailReport", "SessionPageDetail, _reportSessionPage: logIdJsonList == null !!");
    }
    for (;;)
    {
      ds(b.a(paramcbo, parambfy));
      AppMethodBeat.o(177399);
      return;
      ds(paramcbl);
    }
  }
  
  private static void ds(List<c<String, String>> paramList)
  {
    AppMethodBeat.i(122238);
    if (dt(h(paramList, f.cQu()))) {
      f.Dv(System.currentTimeMillis());
    }
    AppMethodBeat.o(122238);
  }
  
  private static boolean dt(List<c<String, String>> paramList)
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
                e.Cxv.a(19354, new Object[] { Integer.valueOf(9) });
              }
              i += 1;
            }
          }
          gy((String)localObject2, (String)((com.tencent.mm.vending.j.b)localObject1).get(0));
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageDetailReport", localException, "realReportFlow, crash: %s", new Object[] { localException.getMessage() });
        }
      }
      d.aV(Util.getInt((String)((com.tencent.mm.vending.j.b)localObject1).get(0), -1), (String)localObject2);
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c)((Iterator)localObject1).next();
        com.tencent.mm.plugin.expt.d.d.a locala = com.tencent.mm.plugin.expt.d.a.cMI().sxs;
        localObject3 = (String)((c)localObject2).get(1);
        i = Integer.parseInt((String)((com.tencent.mm.vending.j.b)localObject2).get(0));
        if (com.tencent.mm.plugin.expt.d.b.cML()) {
          if ((i <= 0) || (org.apache.commons.b.g.eP((String)localObject3)))
          {
            Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageSingle data or sessionPageID isEmpty!");
          }
          else
          {
            long l = System.currentTimeMillis();
            locala.sxy.execute(new a.5(locala, i, l, (String)localObject3));
          }
        }
      }
    }
    AppMethodBeat.o(169361);
    return bool;
  }
  
  private static void gy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220584);
    if (paramString1 == null)
    {
      AppMethodBeat.o(220584);
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
      AppMethodBeat.o(220584);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionPageDetailReport", "reportSessionPageDetail-item: %s, %s", new Object[] { paramString2, paramString1 });
    AppMethodBeat.o(220584);
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
            paramString.add(com.tencent.mm.vending.j.a.Q(arrayOfString[0], arrayOfString[1]));
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
          paramString.add(com.tencent.mm.vending.j.a.Q(localObject2[0], localObject2[1]));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.g
 * JD-Core Version:    0.7.0.1
 */