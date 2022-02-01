package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.g;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvi;
import com.tencent.mm.sdk.platformtools.Log;
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

final class h
{
  static void a(cbo paramcbo, cbl paramcbl, bfy parambfy, cyl paramcyl)
  {
    AppMethodBeat.i(177401);
    aqX(b(paramcbo, paramcbl, paramcyl));
    if ((parambfy == null) || (parambfy.LPC.isEmpty()))
    {
      AppMethodBeat.o(177401);
      return;
    }
    aqX(c.b(paramcbo, parambfy));
    AppMethodBeat.o(177401);
  }
  
  private static void aqX(String paramString)
  {
    AppMethodBeat.i(122244);
    String str2 = g.cQw();
    String str1 = paramString;
    if (str2 != null)
    {
      if (!str2.isEmpty()) {
        break label40;
      }
      str1 = paramString;
    }
    for (;;)
    {
      aqY(str1);
      g.Dw(System.currentTimeMillis());
      AppMethodBeat.o(122244);
      return;
      label40:
      if ((paramString == null) || (paramString.isEmpty())) {
        str1 = str2;
      } else {
        str1 = str2 + "|" + paramString;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private static void aqY(String paramString)
  {
    AppMethodBeat.i(122245);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122245);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionPageMergeReport", "FuzzyMergeReport, reportSessionPageMerge: %s", new Object[] { paramString });
    d.aV(17647, paramString);
    com.tencent.mm.plugin.expt.d.a.cMI().sxs.aoo(paramString);
    AppMethodBeat.o(122245);
  }
  
  private static String b(cbo paramcbo, cbl paramcbl, cyl paramcyl)
  {
    AppMethodBeat.i(177402);
    paramcbl = j.d(paramcbl);
    paramcyl = i.a(paramcbl, paramcyl);
    i.ag(paramcyl);
    if ((paramcbl.isEmpty()) || (paramcyl.isEmpty()))
    {
      Log.i("HABBYGE-MALI.HellSessionPageMergeReport", "SessionPageMerge, toJson, PageFlowMap Empty !!");
      AppMethodBeat.o(177402);
      return null;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = paramcyl.entrySet().iterator();
    Object localObject3;
    label120:
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject2).hasNext())
    {
      paramcbl = (List)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if (!paramcbl.isEmpty())
      {
        localObject3 = paramcbl.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (dvi)((Iterator)localObject3).next();
            if (localObject4 != null)
            {
              localObject5 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(((dvi)localObject4).dRM);
              if (localObject5 != null)
              {
                if (!((Map)localObject1).containsKey(localObject5)) {
                  break label224;
                }
                paramcyl = (List)((Map)localObject1).get(localObject5);
                paramcbl = paramcyl;
                if (paramcyl != null) {
                  break;
                }
              }
            }
          }
        }
        label224:
        for (paramcbl = new ArrayList();; paramcbl = new ArrayList())
        {
          paramcbl.add(localObject4);
          ((Map)localObject1).put(localObject5, paramcbl);
          break label120;
          break;
        }
      }
    }
    if (((Map)localObject1).isEmpty())
    {
      AppMethodBeat.o(177402);
      return null;
    }
    paramcbo = i.j(paramcbo);
    if (paramcbo == null)
    {
      AppMethodBeat.o(177402);
      return null;
    }
    paramcbl = new JSONArray();
    paramcyl = ((Map)localObject1).entrySet().iterator();
    while (paramcyl.hasNext())
    {
      localObject2 = (Map.Entry)paramcyl.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject3 = (List)((Map.Entry)localObject2).getValue();
      localObject2 = new HashMap();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (dvi)((Iterator)localObject3).next();
        long l;
        if (((Map)localObject2).containsKey(Long.valueOf(((dvi)localObject4).LPN)))
        {
          localObject5 = (com.tencent.mm.vending.j.c)((Map)localObject2).get(Long.valueOf(((dvi)localObject4).LPN));
          if (localObject5 != null)
          {
            l = 0L;
            Iterator localIterator = ((dvi)localObject4).MWp.iterator();
            while (localIterator.hasNext()) {
              l += ((cbm)localIterator.next()).duration;
            }
            ((Map)localObject2).put(Long.valueOf(((dvi)localObject4).LPN), com.tencent.mm.vending.j.a.Q(Integer.valueOf(((Integer)((com.tencent.mm.vending.j.b)localObject5).get(0)).intValue() + 1), Long.valueOf(((Long)((com.tencent.mm.vending.j.c)localObject5).get(1)).longValue() + l)));
          }
        }
        else
        {
          l = 0L;
          localObject5 = ((dvi)localObject4).MWp.iterator();
          while (((Iterator)localObject5).hasNext()) {
            l += ((cbm)((Iterator)localObject5).next()).duration;
          }
          ((Map)localObject2).put(Long.valueOf(((dvi)localObject4).LPN), com.tencent.mm.vending.j.a.Q(Integer.valueOf(1), Long.valueOf(l)));
        }
      }
      Log.i("HABBYGE-MALI.HellSessionPageMergeReport", "SessionPageMerge, sid: %s, ppidInfoMap: %d", new Object[] { localObject1, Integer.valueOf(((Map)localObject2).size()) });
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        localObject4 = new JSONObject();
        try
        {
          ((JSONObject)localObject4).put("sid", localObject1);
          ((JSONObject)localObject4).put("pagePathId", ((Map.Entry)localObject3).getKey());
          ((JSONObject)localObject4).put("count", ((com.tencent.mm.vending.j.c)((Map.Entry)localObject3).getValue()).get(0));
          ((JSONObject)localObject4).put("in", ((com.tencent.mm.vending.j.c)((Map.Entry)localObject3).getValue()).get(1));
          paramcbl.put(localObject4);
        }
        catch (JSONException localJSONException)
        {
          Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageMergeReport", localJSONException, "SessionPageMerge, jsonObject: %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    if (paramcbl.length() <= 0)
    {
      Log.i("HABBYGE-MALI.HellSessionPageMergeReport", "HellSessionPageMergeReport, content is NULL !!!");
      AppMethodBeat.o(177402);
      return null;
    }
    try
    {
      paramcbo.put("content", paramcbl);
      paramcbo = paramcbo.toString();
      AppMethodBeat.o(177402);
      return paramcbo;
    }
    catch (JSONException paramcbo)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageMergeReport", paramcbo, "SessionPageMerge, jsonObject, crash: %s", new Object[] { paramcbo.getMessage() });
      AppMethodBeat.o(177402);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.h
 * JD-Core Version:    0.7.0.1
 */