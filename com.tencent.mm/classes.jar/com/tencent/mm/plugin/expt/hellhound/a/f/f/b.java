package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.dcc;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.protocal.protobuf.dwy;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.sdk.platformtools.ae;
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
  static List<c<String, String>> a(bow parambow, aup paramaup)
  {
    AppMethodBeat.i(122218);
    if ((paramaup == null) || (paramaup.GLy.isEmpty()))
    {
      ae.e("HABBYGE-MALI.FuzzyDetailReport", "reportFuzzyMatch，toJson: cache == null");
      AppMethodBeat.o(122218);
      return null;
    }
    Object localObject3 = new HashMap();
    Object localObject2 = paramaup.GLy.iterator();
    Object localObject4;
    Object localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (aus)((Iterator)localObject2).next();
      if (((Map)localObject3).containsKey(Long.valueOf(((aus)localObject4).GLJ)))
      {
        localObject1 = (List)((Map)localObject3).get(Long.valueOf(((aus)localObject4).GLJ));
        paramaup = (aup)localObject1;
        if (localObject1 != null) {}
      }
      for (paramaup = new ArrayList();; paramaup = new ArrayList())
      {
        paramaup.add(localObject4);
        ((Map)localObject3).put(Long.valueOf(((aus)localObject4).GLJ), paramaup);
        break;
      }
    }
    if (((Map)localObject3).isEmpty())
    {
      ae.e("HABBYGE-MALI.FuzzyDetailReport", "reportFuzzyMatch，toJson: ppidPathsMap == null");
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
        aus localaus1 = (aus)((List)localObject4).get(0);
        if (localaus1.sDg)
        {
          JSONObject localJSONObject1 = i.j(parambow);
          if (localJSONObject1 != null)
          {
            JSONArray localJSONArray = new JSONArray();
            int i = 0;
            for (;;)
            {
              if (i >= ((List)localObject4).size()) {
                break label439;
              }
              aus localaus2 = (aus)((List)localObject4).get(i);
              JSONObject localJSONObject2 = new JSONObject();
              try
              {
                localJSONObject2.put("pagePathId", localaus2.GLJ);
                localJSONObject2.put("sessionId", localaus2.dAa);
                localObject1 = g.a(parambow, localaus2.dAa);
                paramaup = (aup)localObject1;
                if (localObject1 == null) {
                  paramaup = "";
                }
                localJSONObject2.put("lastSessionId", paramaup);
                localJSONObject2.put("pagePath", a(localaus2, localJSONObject2));
                localJSONArray.put(localJSONObject2);
              }
              catch (Exception paramaup)
              {
                for (;;)
                {
                  ae.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", paramaup, "toJson, crash-FuzzyPath-1: %s", new Object[] { paramaup.getMessage() });
                }
              }
              i += 1;
            }
            label439:
            if (localJSONArray.length() <= 0) {
              ae.e("HABBYGE-MALI.FuzzyDetailReport", "content is NULL !!");
            } else {
              try
              {
                localJSONObject1.put("content", localJSONArray);
                ((List)localObject2).add(a.N(localaus1.GLI, localJSONObject1.toString()));
              }
              catch (JSONException paramaup)
              {
                ae.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", paramaup, "toJson, crash-FuzzyPath-2: %s", new Object[] { paramaup.getMessage() });
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(122218);
    return localObject2;
  }
  
  private static JSONArray a(aus paramaus, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(169359);
    JSONArray localJSONArray1 = new JSONArray();
    if ((paramaus == null) || (paramaus.GLG.isEmpty()))
    {
      AppMethodBeat.o(169359);
      return localJSONArray1;
    }
    int j = paramaus.GLG.size();
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      aur localaur;
      JSONObject localJSONObject;
      JSONArray localJSONArray2;
      if (i < j) {
        for (;;)
        {
          try
          {
            localaur = (aur)paramaus.GLG.get(i);
            localJSONObject = new JSONObject();
            localJSONObject.put("pageName", localaur.name);
            localJSONObject.put("tbe", localaur.startTime);
            localJSONObject.put("in", localaur.GLB);
            long l2 = localaur.GLB;
            l1 += l2;
            if (i == 0) {}
            try
            {
              paramJSONObject.put("tbe", localaur.startTime);
            }
            catch (Exception localException)
            {
              ae.m("HABBYGE-MALI.FuzzyDetailReport", "createFuzzyPathJsonArray, exception: %s", new Object[] { localException.getMessage() });
            }
          }
          catch (JSONException paramaus)
          {
            ae.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", paramaus, "createFuzzyPathJsonArray crash: %s", new Object[] { paramaus.getMessage() });
          }
          try
          {
            localJSONArray2 = new JSONArray();
            if (localaur != null) {
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
              ae.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", localJSONException, "_getBizParams crash: %s", new Object[] { localJSONException.getMessage() });
              break;
              Object localObject1 = null;
              continue;
              if ((localObject2 == null) || (!((String)localObject2).equals(str2))) {
                break label451;
              }
              ae.i("HABBYGE-MALI.FuzzyDetailReport", "sCurPageName: %s, %s", new Object[] { localObject2, str2 });
              a(localaur, localJSONArray2, paramaus.GLJ);
            }
            ae.e("HABBYGE-MALI.FuzzyDetailReport", "Neither prePage nor curPage !!");
            localJSONObject.put("businessParam", localJSONArray2);
            continue;
          }
          a(localJSONObject, paramaus, localaur);
          localJSONArray1.put(localJSONObject);
          break label497;
          AppMethodBeat.o(169359);
          return localJSONArray1;
          label240:
          localObject2 = paramaus.GLF;
          if ((paramaus.GLE.isEmpty()) || (paramaus.GLE.size() != 1)) {
            break;
          }
          str1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(((dcc)paramaus.GLE.get(0)).duQ);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(((dcc)localObject2).duQ);
          str2 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(localaur.name);
          if ((str1 == null) || (!str1.equals(str2))) {
            break label400;
          }
          ae.i("HABBYGE-MALI.FuzzyDetailReport", "sPrePageName: %s, %s", new Object[] { str1, str2 });
          a(localaur, localJSONArray2, paramaus.GLJ);
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
  
  private static void a(aur paramaur, JSONArray paramJSONArray, long paramLong)
  {
    AppMethodBeat.i(196150);
    if (!paramaur.GLC.isEmpty())
    {
      j.a(paramJSONArray, paramaur, paramLong);
      AppMethodBeat.o(196150);
      return;
    }
    paramaur = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramaur.name);
    if (paramaur != null) {
      j.d(paramaur, false, paramLong);
    }
    AppMethodBeat.o(196150);
  }
  
  private static void a(JSONObject paramJSONObject, aus paramaus, aur paramaur)
  {
    AppMethodBeat.i(196148);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramaur.GLD.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (dwx)localIterator.next();
      if ((localObject2 != null) && (a((dwx)localObject2, paramaur, paramaus)))
      {
        i = 1;
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("viewId", ((dwx)localObject2).Icn);
        localJSONObject1.put("type", ((dwx)localObject2).type);
        localJSONObject1.put("action", ((dwx)localObject2).duP);
        localJSONObject1.put("timestamp", ((dwx)localObject2).timestamp);
        Object localObject1;
        if (!((dwx)localObject2).GbV.isEmpty())
        {
          localObject1 = new JSONArray();
          localObject2 = ((dwx)localObject2).GbV.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (oh)((Iterator)localObject2).next();
            if ((localObject3 != null) && (((oh)localObject3).GbU == paramaus.GLJ))
            {
              localObject3 = ((oh)localObject3).GbV.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                bov localbov = (bov)((Iterator)localObject3).next();
                if ((localbov != null) && (localbov.dGe != null))
                {
                  JSONObject localJSONObject2 = new JSONObject();
                  localJSONObject2.put("dataPath", localbov.dGe);
                  localJSONObject2.put("value", localbov.value);
                  ((JSONArray)localObject1).put(localJSONObject2);
                }
              }
            }
          }
          if (((JSONArray)localObject1).length() > 0)
          {
            localJSONObject1.put("businessParam", localObject1);
            l.w(paramaus.GLJ, 4);
          }
        }
        for (;;)
        {
          localJSONArray.put(localJSONObject1);
          break;
          l.w(paramaus.GLJ, 5);
          continue;
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramaur.name);
          if (localObject1 != null) {
            j.g(((dwx)localObject2).Icn, (String)localObject1, paramaus.GLJ);
          }
        }
      }
    }
    paramJSONObject.put("viewOp", localJSONArray);
    if (i == 0)
    {
      AppMethodBeat.o(196148);
      return;
    }
    if (paramaur.GLD.isEmpty())
    {
      paramJSONObject = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramaur.name);
      if (paramJSONObject != null) {
        j.as(paramJSONObject, paramaus.GLJ);
      }
      AppMethodBeat.o(196148);
      return;
    }
    if (localJSONArray.length() > 0) {}
    for (i = 2;; i = 3)
    {
      l.w(paramaus.GLJ, i);
      AppMethodBeat.o(196148);
      return;
    }
  }
  
  private static boolean a(dwx paramdwx, aur paramaur, aus paramaus)
  {
    AppMethodBeat.i(196149);
    paramaur = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramaur.name);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramaus.GLF.duQ);
    Object localObject2;
    if ((localObject1 != null) && (((String)localObject1).equals(paramaur)))
    {
      localObject1 = paramaus.GLF.HKD.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (dwy)((Iterator)localObject1).next();
        if (com.tencent.mm.plugin.expt.hellhound.core.b.c.g.a(paramdwx, (dwy)localObject2))
        {
          ae.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: entry: viewNode=%s, %s", new Object[] { ((dwy)localObject2).aQj, ((dwy)localObject2).Icn });
          AppMethodBeat.o(196149);
          return true;
        }
      }
    }
    do
    {
      paramaus = paramaus.GLE.iterator();
      while (!((Iterator)localObject1).hasNext())
      {
        do
        {
          if (!paramaus.hasNext()) {
            break;
          }
          localObject1 = (dcc)paramaus.next();
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(((dcc)localObject1).duQ);
        } while ((localObject2 == null) || (!((String)localObject2).equals(paramaur)));
        localObject1 = ((dcc)localObject1).HKD.iterator();
      }
      localObject2 = (dwy)((Iterator)localObject1).next();
    } while (!com.tencent.mm.plugin.expt.hellhound.core.b.c.g.a(paramdwx, (dwy)localObject2));
    ae.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: prePage=%s, %s", new Object[] { ((dwy)localObject2).aQj, ((dwy)localObject2).Icn });
    AppMethodBeat.o(196149);
    return true;
    ae.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: false: %s, %s", new Object[] { paramdwx.id, paramdwx.Icn });
    AppMethodBeat.o(196149);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.b
 * JD-Core Version:    0.7.0.1
 */