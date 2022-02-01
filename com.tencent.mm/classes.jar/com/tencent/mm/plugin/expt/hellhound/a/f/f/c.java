package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.j.a;
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

final class c
{
  static String b(bge parambge, amz paramamz)
  {
    AppMethodBeat.i(122221);
    Object localObject2 = new HashMap();
    Object localObject3 = paramamz.DnZ.iterator();
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (anc)((Iterator)localObject3).next();
      localObject5 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(((anc)localObject4).dpw);
      if (localObject5 != null)
      {
        if (((Map)localObject2).containsKey(localObject5))
        {
          localObject1 = (List)((Map)localObject2).get(localObject5);
          paramamz = (amz)localObject1;
          if (localObject1 != null) {}
        }
        for (paramamz = new ArrayList();; paramamz = new ArrayList())
        {
          paramamz.add(localObject4);
          ((Map)localObject2).put(localObject5, paramamz);
          break;
        }
      }
    }
    ad.i("FuzzyMergeReport", "HABBYGE-MALI, FuzzyPageMerge, sidPathsMap: %d", new Object[] { Integer.valueOf(((Map)localObject2).size()) });
    if (((Map)localObject2).isEmpty())
    {
      AppMethodBeat.o(122221);
      return null;
    }
    parambge = i.j(parambge);
    if (parambge == null)
    {
      AppMethodBeat.o(122221);
      return null;
    }
    paramamz = new JSONArray();
    Object localObject1 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = (String)((Map.Entry)localObject3).getKey();
      localObject4 = (List)((Map.Entry)localObject3).getValue();
      localObject3 = new HashMap();
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (anc)((Iterator)localObject4).next();
        Object localObject6;
        long l;
        if (((Map)localObject3).containsKey(Long.valueOf(((anc)localObject5).Doj)))
        {
          localObject6 = (com.tencent.mm.vending.j.c)((Map)localObject3).get(Long.valueOf(((anc)localObject5).Doj));
          if (localObject6 != null)
          {
            l = 0L;
            Iterator localIterator = ((anc)localObject5).Dog.iterator();
            while (localIterator.hasNext()) {
              l += ((anb)localIterator.next()).Doc;
            }
            ((Map)localObject3).put(Long.valueOf(((anc)localObject5).Doj), a.L(Integer.valueOf(((Integer)((com.tencent.mm.vending.j.b)localObject6).get(0)).intValue() + 1), Long.valueOf(((Long)((com.tencent.mm.vending.j.c)localObject6).get(1)).longValue() + l)));
          }
        }
        else
        {
          l = 0L;
          localObject6 = ((anc)localObject5).Dog.iterator();
          while (((Iterator)localObject6).hasNext()) {
            l += ((anb)((Iterator)localObject6).next()).Doc;
          }
          ((Map)localObject3).put(Long.valueOf(((anc)localObject5).Doj), a.L(Integer.valueOf(1), Long.valueOf(l)));
        }
      }
      ad.i("FuzzyMergeReport", "HABBYGE-MALI, FuzzyPageMerge, sid: %s, ppidInfoMap: %d", new Object[] { localObject2, Integer.valueOf(((Map)localObject3).size()) });
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        localObject5 = new JSONObject();
        try
        {
          ((JSONObject)localObject5).put("sid", localObject2);
          ((JSONObject)localObject5).put("pagePathId", ((Map.Entry)localObject4).getKey());
          ((JSONObject)localObject5).put("count", ((com.tencent.mm.vending.j.c)((Map.Entry)localObject4).getValue()).get(0));
          ((JSONObject)localObject5).put("in", ((com.tencent.mm.vending.j.c)((Map.Entry)localObject4).getValue()).get(1));
          paramamz.put(localObject5);
        }
        catch (JSONException localJSONException)
        {
          ad.printErrStackTrace("FuzzyMergeReport", localJSONException, "HABBYGE-MALI, FuzzyPageMerge, jsonObject: %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    if (paramamz.length() <= 0)
    {
      ad.i("FuzzyMergeReport", "HABBYGE-MALI, FuzzyMergeReport, content is NULL !!!");
      AppMethodBeat.o(122221);
      return null;
    }
    try
    {
      parambge.put("content", paramamz);
      parambge = parambge.toString();
      AppMethodBeat.o(122221);
      return parambge;
    }
    catch (JSONException parambge)
    {
      ad.printErrStackTrace("FuzzyMergeReport", parambge, "HABBYGE-MALI, SessionPageMerge, content: %s", new Object[] { parambge.getMessage() });
      AppMethodBeat.o(122221);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.c
 * JD-Core Version:    0.7.0.1
 */