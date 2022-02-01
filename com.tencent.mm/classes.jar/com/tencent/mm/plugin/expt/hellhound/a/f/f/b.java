package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.bod;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.dbi;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.protocal.protobuf.of;
import com.tencent.mm.sdk.platformtools.ad;
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
  static List<c<String, String>> a(boe paramboe, atz paramatz)
  {
    AppMethodBeat.i(122218);
    if ((paramatz == null) || (paramatz.Gsa.isEmpty()))
    {
      ad.e("HABBYGE-MALI.FuzzyDetailReport", "reportFuzzyMatch，toJson: cache == null");
      AppMethodBeat.o(122218);
      return null;
    }
    Object localObject3 = new HashMap();
    Object localObject2 = paramatz.Gsa.iterator();
    Object localObject4;
    Object localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (auc)((Iterator)localObject2).next();
      if (((Map)localObject3).containsKey(Long.valueOf(((auc)localObject4).Gsl)))
      {
        localObject1 = (List)((Map)localObject3).get(Long.valueOf(((auc)localObject4).Gsl));
        paramatz = (atz)localObject1;
        if (localObject1 != null) {}
      }
      for (paramatz = new ArrayList();; paramatz = new ArrayList())
      {
        paramatz.add(localObject4);
        ((Map)localObject3).put(Long.valueOf(((auc)localObject4).Gsl), paramatz);
        break;
      }
    }
    if (((Map)localObject3).isEmpty())
    {
      ad.e("HABBYGE-MALI.FuzzyDetailReport", "reportFuzzyMatch，toJson: ppidPathsMap == null");
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
        auc localauc1 = (auc)((List)localObject4).get(0);
        if (localauc1.ssW)
        {
          JSONObject localJSONObject1 = i.j(paramboe);
          if (localJSONObject1 != null)
          {
            JSONArray localJSONArray = new JSONArray();
            int i = 0;
            for (;;)
            {
              if (i >= ((List)localObject4).size()) {
                break label439;
              }
              auc localauc2 = (auc)((List)localObject4).get(i);
              JSONObject localJSONObject2 = new JSONObject();
              try
              {
                localJSONObject2.put("pagePathId", localauc2.Gsl);
                localJSONObject2.put("sessionId", localauc2.dyV);
                localObject1 = g.a(paramboe, localauc2.dyV);
                paramatz = (atz)localObject1;
                if (localObject1 == null) {
                  paramatz = "";
                }
                localJSONObject2.put("lastSessionId", paramatz);
                localJSONObject2.put("pagePath", a(localauc2, localJSONObject2));
                localJSONArray.put(localJSONObject2);
              }
              catch (Exception paramatz)
              {
                for (;;)
                {
                  ad.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", paramatz, "toJson, crash-FuzzyPath-1: %s", new Object[] { paramatz.getMessage() });
                }
              }
              i += 1;
            }
            label439:
            if (localJSONArray.length() <= 0) {
              ad.e("HABBYGE-MALI.FuzzyDetailReport", "content is NULL !!");
            } else {
              try
              {
                localJSONObject1.put("content", localJSONArray);
                ((List)localObject2).add(a.N(localauc1.Gsk, localJSONObject1.toString()));
              }
              catch (JSONException paramatz)
              {
                ad.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", paramatz, "toJson, crash-FuzzyPath-2: %s", new Object[] { paramatz.getMessage() });
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(122218);
    return localObject2;
  }
  
  private static JSONArray a(auc paramauc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(169359);
    JSONArray localJSONArray1 = new JSONArray();
    if ((paramauc == null) || (paramauc.Gsi.isEmpty()))
    {
      AppMethodBeat.o(169359);
      return localJSONArray1;
    }
    int j = paramauc.Gsi.size();
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      aub localaub;
      JSONObject localJSONObject;
      JSONArray localJSONArray2;
      if (i < j) {
        for (;;)
        {
          try
          {
            localaub = (aub)paramauc.Gsi.get(i);
            localJSONObject = new JSONObject();
            localJSONObject.put("pageName", localaub.name);
            localJSONObject.put("tbe", localaub.startTime);
            localJSONObject.put("in", localaub.Gsd);
            long l2 = localaub.Gsd;
            l1 += l2;
            if (i == 0) {}
            try
            {
              paramJSONObject.put("tbe", localaub.startTime);
            }
            catch (Exception localException)
            {
              ad.m("HABBYGE-MALI.FuzzyDetailReport", "createFuzzyPathJsonArray, exception: %s", new Object[] { localException.getMessage() });
            }
          }
          catch (JSONException paramauc)
          {
            ad.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", paramauc, "createFuzzyPathJsonArray crash: %s", new Object[] { paramauc.getMessage() });
          }
          try
          {
            localJSONArray2 = new JSONArray();
            if (localaub != null) {
              break label240;
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
              ad.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", localJSONException, "_getBizParams crash: %s", new Object[] { localJSONException.getMessage() });
              break;
              Object localObject1 = null;
              continue;
              if ((localObject2 == null) || (!((String)localObject2).equals(str2))) {
                break label451;
              }
              ad.i("HABBYGE-MALI.FuzzyDetailReport", "sCurPageName: %s, %s", new Object[] { localObject2, str2 });
              a(localaub, localJSONArray2, paramauc.Gsl);
            }
            ad.e("HABBYGE-MALI.FuzzyDetailReport", "Neither prePage nor curPage !!");
            localJSONObject.put("businessParam", localJSONArray2);
            continue;
          }
          a(localJSONObject, paramauc, localaub);
          localJSONArray1.put(localJSONObject);
          break label497;
          AppMethodBeat.o(169359);
          return localJSONArray1;
          label240:
          localObject2 = paramauc.Gsh;
          if ((paramauc.Gsg.isEmpty()) || (paramauc.Gsg.size() != 1)) {
            break;
          }
          str1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(((dbi)paramauc.Gsg.get(0)).dtL);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(((dbi)localObject2).dtL);
          str2 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(localaub.name);
          if ((str1 == null) || (!str1.equals(str2))) {
            break label400;
          }
          ad.i("HABBYGE-MALI.FuzzyDetailReport", "sPrePageName: %s, %s", new Object[] { str1, str2 });
          a(localaub, localJSONArray2, paramauc.Gsl);
          localJSONObject.put("businessParam", localJSONArray2);
        }
      }
      label400:
      label451:
      if (l1 > 0L) {}
      for (;;)
      {
        paramJSONObject.put("in", l1);
        break;
        l1 = 0L;
      }
      label497:
      i += 1;
    }
  }
  
  private static void a(aub paramaub, JSONArray paramJSONArray, long paramLong)
  {
    AppMethodBeat.i(210483);
    if (!paramaub.Gse.isEmpty())
    {
      j.a(paramJSONArray, paramaub, paramLong);
      AppMethodBeat.o(210483);
      return;
    }
    paramaub = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramaub.name);
    if (paramaub != null) {
      j.d(paramaub, false, paramLong);
    }
    AppMethodBeat.o(210483);
  }
  
  private static void a(JSONObject paramJSONObject, auc paramauc, aub paramaub)
  {
    AppMethodBeat.i(210481);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramaub.Gsf.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (dwc)localIterator.next();
      if ((localObject2 != null) && (a((dwc)localObject2, paramaub, paramauc)))
      {
        i = 1;
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("viewId", ((dwc)localObject2).HIB);
        localJSONObject1.put("type", ((dwc)localObject2).type);
        localJSONObject1.put("action", ((dwc)localObject2).dtK);
        localJSONObject1.put("timestamp", ((dwc)localObject2).timestamp);
        Object localObject1;
        if (!((dwc)localObject2).FJw.isEmpty())
        {
          localObject1 = new JSONArray();
          localObject2 = ((dwc)localObject2).FJw.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (of)((Iterator)localObject2).next();
            if ((localObject3 != null) && (((of)localObject3).FJv == paramauc.Gsl))
            {
              localObject3 = ((of)localObject3).FJw.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                bod localbod = (bod)((Iterator)localObject3).next();
                if ((localbod != null) && (localbod.dEZ != null))
                {
                  JSONObject localJSONObject2 = new JSONObject();
                  localJSONObject2.put("dataPath", localbod.dEZ);
                  localJSONObject2.put("value", localbod.value);
                  ((JSONArray)localObject1).put(localJSONObject2);
                }
              }
            }
          }
          if (((JSONArray)localObject1).length() > 0)
          {
            localJSONObject1.put("businessParam", localObject1);
            l.w(paramauc.Gsl, 4);
          }
        }
        for (;;)
        {
          localJSONArray.put(localJSONObject1);
          break;
          l.w(paramauc.Gsl, 5);
          continue;
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramaub.name);
          if (localObject1 != null) {
            j.g(((dwc)localObject2).HIB, (String)localObject1, paramauc.Gsl);
          }
        }
      }
    }
    paramJSONObject.put("viewOp", localJSONArray);
    if (i == 0)
    {
      AppMethodBeat.o(210481);
      return;
    }
    if (paramaub.Gsf.isEmpty())
    {
      paramJSONObject = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramaub.name);
      if (paramJSONObject != null) {
        j.as(paramJSONObject, paramauc.Gsl);
      }
      AppMethodBeat.o(210481);
      return;
    }
    if (localJSONArray.length() > 0) {}
    for (i = 2;; i = 3)
    {
      l.w(paramauc.Gsl, i);
      AppMethodBeat.o(210481);
      return;
    }
  }
  
  private static boolean a(dwc paramdwc, aub paramaub, auc paramauc)
  {
    AppMethodBeat.i(210482);
    paramaub = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramaub.name);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramauc.Gsh.dtL);
    Object localObject2;
    if ((localObject1 != null) && (((String)localObject1).equals(paramaub)))
    {
      localObject1 = paramauc.Gsh.Hrb.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (dwd)((Iterator)localObject1).next();
        if (com.tencent.mm.plugin.expt.hellhound.core.b.c.g.a(paramdwc, (dwd)localObject2))
        {
          ad.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: entry: viewNode=%s, %s", new Object[] { ((dwd)localObject2).aQj, ((dwd)localObject2).HIB });
          AppMethodBeat.o(210482);
          return true;
        }
      }
    }
    do
    {
      paramauc = paramauc.Gsg.iterator();
      while (!((Iterator)localObject1).hasNext())
      {
        do
        {
          if (!paramauc.hasNext()) {
            break;
          }
          localObject1 = (dbi)paramauc.next();
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(((dbi)localObject1).dtL);
        } while ((localObject2 == null) || (!((String)localObject2).equals(paramaub)));
        localObject1 = ((dbi)localObject1).Hrb.iterator();
      }
      localObject2 = (dwd)((Iterator)localObject1).next();
    } while (!com.tencent.mm.plugin.expt.hellhound.core.b.c.g.a(paramdwc, (dwd)localObject2));
    ad.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: prePage=%s, %s", new Object[] { ((dwd)localObject2).aQj, ((dwd)localObject2).HIB });
    AppMethodBeat.o(210482);
    return true;
    ad.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: false: %s, %s", new Object[] { paramdwc.id, paramdwc.HIB });
    AppMethodBeat.o(210482);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.b
 * JD-Core Version:    0.7.0.1
 */