package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class b
{
  static List<c<String, String>> a(bjw parambjw, aqd paramaqd)
  {
    AppMethodBeat.i(122218);
    if ((paramaqd == null) || (paramaqd.EIZ.isEmpty()))
    {
      ac.e("FuzzyDetailReport", "HABBYGE-MALI, reportFuzzyMatch，toJson: cache == null");
      AppMethodBeat.o(122218);
      return null;
    }
    ac.i("FuzzyDetailReport", "HABBYGE-MALI, FuzzyDetailReport, toJson: %d", new Object[] { Integer.valueOf(paramaqd.EIZ.size()) });
    Object localObject3 = new HashMap();
    Object localObject2 = paramaqd.EIZ.iterator();
    Object localObject4;
    Object localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (aqg)((Iterator)localObject2).next();
      if (((Map)localObject3).containsKey(Long.valueOf(((aqg)localObject4).EJj)))
      {
        localObject1 = (List)((Map)localObject3).get(Long.valueOf(((aqg)localObject4).EJj));
        paramaqd = (aqd)localObject1;
        if (localObject1 != null) {}
      }
      for (paramaqd = new ArrayList();; paramaqd = new ArrayList())
      {
        paramaqd.add(localObject4);
        ((Map)localObject3).put(Long.valueOf(((aqg)localObject4).EJj), paramaqd);
        break;
      }
    }
    if (((Map)localObject3).isEmpty())
    {
      ac.e("FuzzyDetailReport", "HABBYGE-MALI, reportFuzzyMatch，toJson: ppidPathsMap == null");
      AppMethodBeat.o(122218);
      return null;
    }
    localObject2 = new ArrayList();
    localObject3 = ((Map)localObject3).entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (List)((Map.Entry)((Iterator)localObject3).next()).getValue();
      if ((localObject4 != null) && (!((List)localObject4).isEmpty()))
      {
        aqg localaqg1 = (aqg)((List)localObject4).get(0);
        if (localaqg1.rAJ)
        {
          JSONObject localJSONObject1 = i.j(parambjw);
          if (localJSONObject1 != null)
          {
            JSONArray localJSONArray = new JSONArray();
            int i = 0;
            for (;;)
            {
              if (i >= ((List)localObject4).size()) {
                break label463;
              }
              aqg localaqg2 = (aqg)((List)localObject4).get(i);
              JSONObject localJSONObject2 = new JSONObject();
              try
              {
                localJSONObject2.put("pagePathId", localaqg2.EJj);
                localJSONObject2.put("sessionId", localaqg2.dnh);
                localObject1 = g.a(parambjw, localaqg2.dnh);
                paramaqd = (aqd)localObject1;
                if (localObject1 == null) {
                  paramaqd = "";
                }
                localJSONObject2.put("lastSessionId", paramaqd);
                localJSONObject2.put("pagePath", a(localaqg2, localJSONObject2));
                localJSONArray.put(localJSONObject2);
              }
              catch (Exception paramaqd)
              {
                for (;;)
                {
                  ac.printErrStackTrace("FuzzyDetailReport", paramaqd, "HABBYGE-MALI, toJson, crash-FuzzyPath-1: %s", new Object[] { paramaqd.getMessage() });
                }
              }
              i += 1;
            }
            label463:
            if (localJSONArray.length() <= 0) {
              ac.e("FuzzyDetailReport", "HABBYGE-MALI, FuzzyDetailReport, content is NULL !!");
            } else {
              try
              {
                localJSONObject1.put("content", localJSONArray);
                ac.i("FuzzyDetailReport", "HABBYGE-MALI, reportFuzzyMatch，sidJSONObject: %s, %s", new Object[] { localaqg1.EJi, localJSONObject1.toString() });
                ((List)localObject2).add(a.L(localaqg1.EJi, localJSONObject1.toString()));
              }
              catch (JSONException paramaqd)
              {
                ac.printErrStackTrace("FuzzyDetailReport", paramaqd, "HABBYGE-MALI, toJson, crash-FuzzyPath-2: %s", new Object[] { paramaqd.getMessage() });
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(122218);
    return localObject2;
  }
  
  private static JSONArray a(aqg paramaqg, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(169359);
    JSONArray localJSONArray1 = new JSONArray();
    if ((paramaqg == null) || (paramaqg.EJg.isEmpty()))
    {
      AppMethodBeat.o(169359);
      return localJSONArray1;
    }
    int j = paramaqg.EJg.size();
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      aqf localaqf;
      JSONObject localJSONObject;
      JSONArray localJSONArray2;
      if (i < j) {
        for (;;)
        {
          try
          {
            localaqf = (aqf)paramaqg.EJg.get(i);
            localJSONObject = new JSONObject();
            localJSONObject.put("pageName", localaqf.name);
            localJSONObject.put("tbe", localaqf.startTime);
            localJSONObject.put("in", localaqf.EJc);
            long l2 = localaqf.EJc;
            l1 += l2;
            if (i == 0) {}
            try
            {
              paramJSONObject.put("tbe", localaqf.startTime);
            }
            catch (Exception localException)
            {
              ac.m("FuzzyDetailReport", "createFuzzyPathJsonArray, exception: %s", new Object[] { localException.getMessage() });
            }
          }
          catch (JSONException paramaqg)
          {
            ac.printErrStackTrace("FuzzyDetailReport", paramaqg, "HABBYGE-MALI, createFuzzyPathJsonArray crash: %s", new Object[] { paramaqg.getMessage() });
          }
          try
          {
            localJSONArray2 = new JSONArray();
            if (localaqf != null) {
              break label232;
            }
            localJSONObject.put("businessParam", localJSONArray2);
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Object localObject2;
              String str1;
              String str2;
              ac.printErrStackTrace("FuzzyDetailReport", localJSONException, "HABBYGE-MALI, _getBizParams crash: %s", new Object[] { localJSONException.getMessage() });
              break;
              Object localObject1 = null;
              continue;
              if ((localObject2 == null) || (!((String)localObject2).equals(str2))) {
                break label435;
              }
              ac.i("FuzzyDetailReport", "HABBYGE-MALI, FuzzyDetailReport, sCurPageName: %s, %s", new Object[] { localObject2, str2 });
              a(localaqf, localJSONArray2);
            }
            ac.e("FuzzyDetailReport", "HABBYGE-MALI, FuzzyDetailReport, Neither prePage nor curPage !!");
            localJSONObject.put("businessParam", localJSONArray2);
            continue;
          }
          localJSONArray1.put(localJSONObject);
          break label481;
          AppMethodBeat.o(169359);
          return localJSONArray1;
          label232:
          localObject2 = paramaqg.EJf;
          if ((paramaqg.EJe.isEmpty()) || (paramaqg.EJe.size() != 1)) {
            break;
          }
          str1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(((cvw)paramaqg.EJe.get(0)).qoi);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(((cvw)localObject2).qoi);
          str2 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(localaqf.name);
          if ((str1 == null) || (!str1.equals(str2))) {
            break label388;
          }
          ac.i("FuzzyDetailReport", "HABBYGE-MALI, FuzzyDetailReport, sPrePageName: %s, %s", new Object[] { str1, str2 });
          a(localaqf, localJSONArray2);
          localJSONObject.put("businessParam", localJSONArray2);
        }
      }
      label388:
      label435:
      if (l1 > 0L) {}
      for (;;)
      {
        paramJSONObject.put("in", l1);
        break;
        l1 = 0L;
      }
      label481:
      i += 1;
    }
  }
  
  private static void a(aqf paramaqf, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(122220);
    ac.i("FuzzyDetailReport", "HABBYGE-MALI, FuzzyDetailReport, _getParams: %s, %d", new Object[] { paramaqf.name, Integer.valueOf(paramaqf.EJd.size()) });
    if (!paramaqf.EJd.isEmpty()) {
      j.a(paramJSONArray, paramaqf);
    }
    AppMethodBeat.o(122220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.b
 * JD-Core Version:    0.7.0.1
 */