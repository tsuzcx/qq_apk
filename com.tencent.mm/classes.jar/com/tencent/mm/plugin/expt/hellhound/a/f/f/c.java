package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.sdk.platformtools.Log;
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
  static String b(cbo paramcbo, bfy parambfy)
  {
    AppMethodBeat.i(122221);
    Object localObject2 = new HashMap();
    Object localObject3 = parambfy.LPC.iterator();
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (bgb)((Iterator)localObject3).next();
      localObject5 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(((bgb)localObject4).dRM);
      if (localObject5 != null)
      {
        if (((Map)localObject2).containsKey(localObject5))
        {
          localObject1 = (List)((Map)localObject2).get(localObject5);
          parambfy = (bfy)localObject1;
          if (localObject1 != null) {}
        }
        for (parambfy = new ArrayList();; parambfy = new ArrayList())
        {
          parambfy.add(localObject4);
          ((Map)localObject2).put(localObject5, parambfy);
          break;
        }
      }
    }
    Log.i("HABBYGE-MALI.FuzzyMergeReport", "FuzzyPageMerge, sidPathsMap: %d", new Object[] { Integer.valueOf(((Map)localObject2).size()) });
    if (((Map)localObject2).isEmpty())
    {
      AppMethodBeat.o(122221);
      return null;
    }
    paramcbo = i.j(paramcbo);
    if (paramcbo == null)
    {
      AppMethodBeat.o(122221);
      return null;
    }
    parambfy = new JSONArray();
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
        localObject5 = (bgb)((Iterator)localObject4).next();
        Object localObject6;
        long l;
        if (((Map)localObject3).containsKey(Long.valueOf(((bgb)localObject5).LPN)))
        {
          localObject6 = (com.tencent.mm.vending.j.c)((Map)localObject3).get(Long.valueOf(((bgb)localObject5).LPN));
          if (localObject6 != null)
          {
            l = 0L;
            Iterator localIterator = ((bgb)localObject5).LPK.iterator();
            while (localIterator.hasNext()) {
              l += ((bga)localIterator.next()).LPF;
            }
            ((Map)localObject3).put(Long.valueOf(((bgb)localObject5).LPN), a.Q(Integer.valueOf(((Integer)((com.tencent.mm.vending.j.b)localObject6).get(0)).intValue() + 1), Long.valueOf(((Long)((com.tencent.mm.vending.j.c)localObject6).get(1)).longValue() + l)));
          }
        }
        else
        {
          l = 0L;
          localObject6 = ((bgb)localObject5).LPK.iterator();
          while (((Iterator)localObject6).hasNext()) {
            l += ((bga)((Iterator)localObject6).next()).LPF;
          }
          ((Map)localObject3).put(Long.valueOf(((bgb)localObject5).LPN), a.Q(Integer.valueOf(1), Long.valueOf(l)));
        }
      }
      Log.i("HABBYGE-MALI.FuzzyMergeReport", "FuzzyPageMerge, sid: %s, ppidInfoMap: %d", new Object[] { localObject2, Integer.valueOf(((Map)localObject3).size()) });
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
          parambfy.put(localObject5);
        }
        catch (JSONException localJSONException)
        {
          Log.printErrStackTrace("HABBYGE-MALI.FuzzyMergeReport", localJSONException, "FuzzyPageMerge, jsonObject: %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    if (parambfy.length() <= 0)
    {
      Log.i("HABBYGE-MALI.FuzzyMergeReport", "FuzzyMergeReport, content is NULL !!!");
      AppMethodBeat.o(122221);
      return null;
    }
    try
    {
      paramcbo.put("content", parambfy);
      paramcbo = paramcbo.toString();
      AppMethodBeat.o(122221);
      return paramcbo;
    }
    catch (JSONException paramcbo)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FuzzyMergeReport", paramcbo, "SessionPageMerge, content: %s", new Object[] { paramcbo.getMessage() });
      AppMethodBeat.o(122221);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.c
 * JD-Core Version:    0.7.0.1
 */