package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.sdk.platformtools.ae;
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
  static String b(bow parambow, aup paramaup)
  {
    AppMethodBeat.i(122221);
    Object localObject2 = new HashMap();
    Object localObject3 = paramaup.GLy.iterator();
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (aus)((Iterator)localObject3).next();
      localObject5 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(((aus)localObject4).dAa);
      if (localObject5 != null)
      {
        if (((Map)localObject2).containsKey(localObject5))
        {
          localObject1 = (List)((Map)localObject2).get(localObject5);
          paramaup = (aup)localObject1;
          if (localObject1 != null) {}
        }
        for (paramaup = new ArrayList();; paramaup = new ArrayList())
        {
          paramaup.add(localObject4);
          ((Map)localObject2).put(localObject5, paramaup);
          break;
        }
      }
    }
    ae.i("HABBYGE-MALI.FuzzyMergeReport", "FuzzyPageMerge, sidPathsMap: %d", new Object[] { Integer.valueOf(((Map)localObject2).size()) });
    if (((Map)localObject2).isEmpty())
    {
      AppMethodBeat.o(122221);
      return null;
    }
    parambow = i.j(parambow);
    if (parambow == null)
    {
      AppMethodBeat.o(122221);
      return null;
    }
    paramaup = new JSONArray();
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
        localObject5 = (aus)((Iterator)localObject4).next();
        Object localObject6;
        long l;
        if (((Map)localObject3).containsKey(Long.valueOf(((aus)localObject5).GLJ)))
        {
          localObject6 = (com.tencent.mm.vending.j.c)((Map)localObject3).get(Long.valueOf(((aus)localObject5).GLJ));
          if (localObject6 != null)
          {
            l = 0L;
            Iterator localIterator = ((aus)localObject5).GLG.iterator();
            while (localIterator.hasNext()) {
              l += ((aur)localIterator.next()).GLB;
            }
            ((Map)localObject3).put(Long.valueOf(((aus)localObject5).GLJ), a.N(Integer.valueOf(((Integer)((com.tencent.mm.vending.j.b)localObject6).get(0)).intValue() + 1), Long.valueOf(((Long)((com.tencent.mm.vending.j.c)localObject6).get(1)).longValue() + l)));
          }
        }
        else
        {
          l = 0L;
          localObject6 = ((aus)localObject5).GLG.iterator();
          while (((Iterator)localObject6).hasNext()) {
            l += ((aur)((Iterator)localObject6).next()).GLB;
          }
          ((Map)localObject3).put(Long.valueOf(((aus)localObject5).GLJ), a.N(Integer.valueOf(1), Long.valueOf(l)));
        }
      }
      ae.i("HABBYGE-MALI.FuzzyMergeReport", "FuzzyPageMerge, sid: %s, ppidInfoMap: %d", new Object[] { localObject2, Integer.valueOf(((Map)localObject3).size()) });
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
          paramaup.put(localObject5);
        }
        catch (JSONException localJSONException)
        {
          ae.printErrStackTrace("HABBYGE-MALI.FuzzyMergeReport", localJSONException, "FuzzyPageMerge, jsonObject: %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    if (paramaup.length() <= 0)
    {
      ae.i("HABBYGE-MALI.FuzzyMergeReport", "FuzzyMergeReport, content is NULL !!!");
      AppMethodBeat.o(122221);
      return null;
    }
    try
    {
      parambow.put("content", paramaup);
      parambow = parambow.toString();
      AppMethodBeat.o(122221);
      return parambow;
    }
    catch (JSONException parambow)
    {
      ae.printErrStackTrace("HABBYGE-MALI.FuzzyMergeReport", parambow, "SessionPageMerge, content: %s", new Object[] { parambow.getMessage() });
      AppMethodBeat.o(122221);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.c
 * JD-Core Version:    0.7.0.1
 */