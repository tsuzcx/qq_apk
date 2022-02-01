package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.sdk.platformtools.ac;
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
  static String b(bjw parambjw, aqd paramaqd)
  {
    AppMethodBeat.i(122221);
    Object localObject2 = new HashMap();
    Object localObject3 = paramaqd.EIZ.iterator();
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (aqg)((Iterator)localObject3).next();
      localObject5 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(((aqg)localObject4).dnh);
      if (localObject5 != null)
      {
        if (((Map)localObject2).containsKey(localObject5))
        {
          localObject1 = (List)((Map)localObject2).get(localObject5);
          paramaqd = (aqd)localObject1;
          if (localObject1 != null) {}
        }
        for (paramaqd = new ArrayList();; paramaqd = new ArrayList())
        {
          paramaqd.add(localObject4);
          ((Map)localObject2).put(localObject5, paramaqd);
          break;
        }
      }
    }
    ac.i("FuzzyMergeReport", "HABBYGE-MALI, FuzzyPageMerge, sidPathsMap: %d", new Object[] { Integer.valueOf(((Map)localObject2).size()) });
    if (((Map)localObject2).isEmpty())
    {
      AppMethodBeat.o(122221);
      return null;
    }
    parambjw = i.j(parambjw);
    if (parambjw == null)
    {
      AppMethodBeat.o(122221);
      return null;
    }
    paramaqd = new JSONArray();
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
        localObject5 = (aqg)((Iterator)localObject4).next();
        Object localObject6;
        long l;
        if (((Map)localObject3).containsKey(Long.valueOf(((aqg)localObject5).EJj)))
        {
          localObject6 = (com.tencent.mm.vending.j.c)((Map)localObject3).get(Long.valueOf(((aqg)localObject5).EJj));
          if (localObject6 != null)
          {
            l = 0L;
            Iterator localIterator = ((aqg)localObject5).EJg.iterator();
            while (localIterator.hasNext()) {
              l += ((aqf)localIterator.next()).EJc;
            }
            ((Map)localObject3).put(Long.valueOf(((aqg)localObject5).EJj), a.L(Integer.valueOf(((Integer)((com.tencent.mm.vending.j.b)localObject6).get(0)).intValue() + 1), Long.valueOf(((Long)((com.tencent.mm.vending.j.c)localObject6).get(1)).longValue() + l)));
          }
        }
        else
        {
          l = 0L;
          localObject6 = ((aqg)localObject5).EJg.iterator();
          while (((Iterator)localObject6).hasNext()) {
            l += ((aqf)((Iterator)localObject6).next()).EJc;
          }
          ((Map)localObject3).put(Long.valueOf(((aqg)localObject5).EJj), a.L(Integer.valueOf(1), Long.valueOf(l)));
        }
      }
      ac.i("FuzzyMergeReport", "HABBYGE-MALI, FuzzyPageMerge, sid: %s, ppidInfoMap: %d", new Object[] { localObject2, Integer.valueOf(((Map)localObject3).size()) });
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
          paramaqd.put(localObject5);
        }
        catch (JSONException localJSONException)
        {
          ac.printErrStackTrace("FuzzyMergeReport", localJSONException, "HABBYGE-MALI, FuzzyPageMerge, jsonObject: %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    if (paramaqd.length() <= 0)
    {
      ac.i("FuzzyMergeReport", "HABBYGE-MALI, FuzzyMergeReport, content is NULL !!!");
      AppMethodBeat.o(122221);
      return null;
    }
    try
    {
      parambjw.put("content", paramaqd);
      parambjw = parambjw.toString();
      AppMethodBeat.o(122221);
      return parambjw;
    }
    catch (JSONException parambjw)
    {
      ac.printErrStackTrace("FuzzyMergeReport", parambjw, "HABBYGE-MALI, SessionPageMerge, content: %s", new Object[] { parambjw.getMessage() });
      AppMethodBeat.o(122221);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.c
 * JD-Core Version:    0.7.0.1
 */