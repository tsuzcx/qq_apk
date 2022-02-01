package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.cqp;
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
  static List<c<String, String>> a(bge parambge, amz paramamz)
  {
    AppMethodBeat.i(122218);
    if ((paramamz == null) || (paramamz.DnZ.isEmpty()))
    {
      ad.e("FuzzyDetailReport", "HABBYGE-MALI, reportFuzzyMatch，toJson: cache == null");
      AppMethodBeat.o(122218);
      return null;
    }
    ad.i("FuzzyDetailReport", "HABBYGE-MALI, FuzzyDetailReport, toJson: %d", new Object[] { Integer.valueOf(paramamz.DnZ.size()) });
    Object localObject3 = new HashMap();
    Object localObject2 = paramamz.DnZ.iterator();
    Object localObject4;
    Object localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (anc)((Iterator)localObject2).next();
      if (((Map)localObject3).containsKey(Long.valueOf(((anc)localObject4).Doj)))
      {
        localObject1 = (List)((Map)localObject3).get(Long.valueOf(((anc)localObject4).Doj));
        paramamz = (amz)localObject1;
        if (localObject1 != null) {}
      }
      for (paramamz = new ArrayList();; paramamz = new ArrayList())
      {
        paramamz.add(localObject4);
        ((Map)localObject3).put(Long.valueOf(((anc)localObject4).Doj), paramamz);
        break;
      }
    }
    if (((Map)localObject3).isEmpty())
    {
      ad.e("FuzzyDetailReport", "HABBYGE-MALI, reportFuzzyMatch，toJson: ppidPathsMap == null");
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
        anc localanc1 = (anc)((List)localObject4).get(0);
        if (localanc1.qHI)
        {
          JSONObject localJSONObject1 = i.j(parambge);
          if (localJSONObject1 != null)
          {
            JSONArray localJSONArray = new JSONArray();
            int i = 0;
            for (;;)
            {
              if (i >= ((List)localObject4).size()) {
                break label463;
              }
              anc localanc2 = (anc)((List)localObject4).get(i);
              JSONObject localJSONObject2 = new JSONObject();
              try
              {
                localJSONObject2.put("pagePathId", localanc2.Doj);
                localJSONObject2.put("sessionId", localanc2.dpw);
                localObject1 = g.a(parambge, localanc2.dpw);
                paramamz = (amz)localObject1;
                if (localObject1 == null) {
                  paramamz = "";
                }
                localJSONObject2.put("lastSessionId", paramamz);
                localJSONObject2.put("pagePath", a(localanc2, localJSONObject2));
                localJSONArray.put(localJSONObject2);
              }
              catch (Exception paramamz)
              {
                for (;;)
                {
                  ad.printErrStackTrace("FuzzyDetailReport", paramamz, "HABBYGE-MALI, toJson, crash-FuzzyPath-1: %s", new Object[] { paramamz.getMessage() });
                }
              }
              i += 1;
            }
            label463:
            if (localJSONArray.length() <= 0) {
              ad.e("FuzzyDetailReport", "HABBYGE-MALI, FuzzyDetailReport, content is NULL !!");
            } else {
              try
              {
                localJSONObject1.put("content", localJSONArray);
                ad.i("FuzzyDetailReport", "HABBYGE-MALI, reportFuzzyMatch，sidJSONObject: %s, %s", new Object[] { localanc1.Doi, localJSONObject1.toString() });
                ((List)localObject2).add(a.L(localanc1.Doi, localJSONObject1.toString()));
              }
              catch (JSONException paramamz)
              {
                ad.printErrStackTrace("FuzzyDetailReport", paramamz, "HABBYGE-MALI, toJson, crash-FuzzyPath-2: %s", new Object[] { paramamz.getMessage() });
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(122218);
    return localObject2;
  }
  
  private static JSONArray a(anc paramanc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(169359);
    JSONArray localJSONArray1 = new JSONArray();
    if ((paramanc == null) || (paramanc.Dog.isEmpty()))
    {
      AppMethodBeat.o(169359);
      return localJSONArray1;
    }
    int j = paramanc.Dog.size();
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      anb localanb;
      JSONObject localJSONObject;
      JSONArray localJSONArray2;
      if (i < j) {
        for (;;)
        {
          try
          {
            localanb = (anb)paramanc.Dog.get(i);
            localJSONObject = new JSONObject();
            localJSONObject.put("pageName", localanb.name);
            localJSONObject.put("tbe", localanb.startTime);
            localJSONObject.put("in", localanb.Doc);
            long l2 = localanb.Doc;
            l1 += l2;
            if (i == 0) {}
            try
            {
              paramJSONObject.put("tbe", localanb.startTime);
            }
            catch (Exception localException)
            {
              ad.m("FuzzyDetailReport", "createFuzzyPathJsonArray, exception: %s", new Object[] { localException.getMessage() });
            }
          }
          catch (JSONException paramanc)
          {
            ad.printErrStackTrace("FuzzyDetailReport", paramanc, "HABBYGE-MALI, createFuzzyPathJsonArray crash: %s", new Object[] { paramanc.getMessage() });
          }
          try
          {
            localJSONArray2 = new JSONArray();
            if (localanb != null) {
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
              ad.printErrStackTrace("FuzzyDetailReport", localJSONException, "HABBYGE-MALI, _getBizParams crash: %s", new Object[] { localJSONException.getMessage() });
              break;
              Object localObject1 = null;
              continue;
              if ((localObject2 == null) || (!((String)localObject2).equals(str2))) {
                break label435;
              }
              ad.i("FuzzyDetailReport", "HABBYGE-MALI, FuzzyDetailReport, sCurPageName: %s, %s", new Object[] { localObject2, str2 });
              a(localanb, localJSONArray2);
            }
            ad.e("FuzzyDetailReport", "HABBYGE-MALI, FuzzyDetailReport, Neither prePage nor curPage !!");
            localJSONObject.put("businessParam", localJSONArray2);
            continue;
          }
          localJSONArray1.put(localJSONObject);
          break label481;
          AppMethodBeat.o(169359);
          return localJSONArray1;
          label232:
          localObject2 = paramanc.Dof;
          if ((paramanc.Doe.isEmpty()) || (paramanc.Doe.size() != 1)) {
            break;
          }
          str1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(((cqp)paramanc.Doe.get(0)).DDP);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(((cqp)localObject2).DDP);
          str2 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(localanb.name);
          if ((str1 == null) || (!str1.equals(str2))) {
            break label388;
          }
          ad.i("FuzzyDetailReport", "HABBYGE-MALI, FuzzyDetailReport, sPrePageName: %s, %s", new Object[] { str1, str2 });
          a(localanb, localJSONArray2);
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
  
  private static void a(anb paramanb, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(122220);
    ad.i("FuzzyDetailReport", "HABBYGE-MALI, FuzzyDetailReport, _getParams: %s, %d", new Object[] { paramanb.name, Integer.valueOf(paramanb.Dod.size()) });
    if (!paramanb.Dod.isEmpty()) {
      j.a(paramJSONArray, paramanb);
    }
    AppMethodBeat.o(122220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.b
 * JD-Core Version:    0.7.0.1
 */