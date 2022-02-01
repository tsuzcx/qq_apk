package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.g;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.efk;
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
  static void a(cjr paramcjr, cjo paramcjo, bmz parambmz, dhx paramdhx)
  {
    AppMethodBeat.i(177401);
    ayY(b(paramcjr, paramcjo, paramdhx));
    if ((parambmz == null) || (parambmz.SXQ.isEmpty()))
    {
      AppMethodBeat.o(177401);
      return;
    }
    ayY(c.b(paramcjr, parambmz));
    AppMethodBeat.o(177401);
  }
  
  private static void ayY(String paramString)
  {
    AppMethodBeat.i(122244);
    String str2 = g.dfq();
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
      ayZ(str1);
      g.JK(System.currentTimeMillis());
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
  private static void ayZ(String paramString)
  {
    AppMethodBeat.i(122245);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122245);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionPageMergeReport", "FuzzyMergeReport, reportSessionPageMerge: %s", new Object[] { paramString });
    d.aU(17647, paramString);
    com.tencent.mm.plugin.expt.d.a.dbw().wcY.awn(paramString);
    AppMethodBeat.o(122245);
  }
  
  private static String b(cjr paramcjr, cjo paramcjo, dhx paramdhx)
  {
    AppMethodBeat.i(177402);
    paramcjo = j.d(paramcjo);
    paramdhx = i.a(paramcjo, paramdhx);
    i.Y(paramdhx);
    if ((paramcjo.isEmpty()) || (paramdhx.isEmpty()))
    {
      Log.i("HABBYGE-MALI.HellSessionPageMergeReport", "SessionPageMerge, toJson, PageFlowMap Empty !!");
      AppMethodBeat.o(177402);
      return null;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = paramdhx.entrySet().iterator();
    Object localObject3;
    label120:
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject2).hasNext())
    {
      paramcjo = (List)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if (!paramcjo.isEmpty())
      {
        localObject3 = paramcjo.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (efk)((Iterator)localObject3).next();
            if (localObject4 != null)
            {
              localObject5 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(((efk)localObject4).fLj);
              if (localObject5 != null)
              {
                if (!((Map)localObject1).containsKey(localObject5)) {
                  break label224;
                }
                paramdhx = (List)((Map)localObject1).get(localObject5);
                paramcjo = paramdhx;
                if (paramdhx != null) {
                  break;
                }
              }
            }
          }
        }
        label224:
        for (paramcjo = new ArrayList();; paramcjo = new ArrayList())
        {
          paramcjo.add(localObject4);
          ((Map)localObject1).put(localObject5, paramcjo);
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
    paramcjr = i.j(paramcjr);
    if (paramcjr == null)
    {
      AppMethodBeat.o(177402);
      return null;
    }
    paramcjo = new JSONArray();
    paramdhx = ((Map)localObject1).entrySet().iterator();
    while (paramdhx.hasNext())
    {
      localObject2 = (Map.Entry)paramdhx.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject3 = (List)((Map.Entry)localObject2).getValue();
      localObject2 = new HashMap();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (efk)((Iterator)localObject3).next();
        long l;
        if (((Map)localObject2).containsKey(Long.valueOf(((efk)localObject4).SYb)))
        {
          localObject5 = (com.tencent.mm.vending.j.c)((Map)localObject2).get(Long.valueOf(((efk)localObject4).SYb));
          if (localObject5 != null)
          {
            l = 0L;
            Iterator localIterator = ((efk)localObject4).UiK.iterator();
            while (localIterator.hasNext()) {
              l += ((cjp)localIterator.next()).duration;
            }
            ((Map)localObject2).put(Long.valueOf(((efk)localObject4).SYb), com.tencent.mm.vending.j.a.J(Integer.valueOf(((Integer)((com.tencent.mm.vending.j.b)localObject5).get(0)).intValue() + 1), Long.valueOf(((Long)((com.tencent.mm.vending.j.c)localObject5).get(1)).longValue() + l)));
          }
        }
        else
        {
          l = 0L;
          localObject5 = ((efk)localObject4).UiK.iterator();
          while (((Iterator)localObject5).hasNext()) {
            l += ((cjp)((Iterator)localObject5).next()).duration;
          }
          ((Map)localObject2).put(Long.valueOf(((efk)localObject4).SYb), com.tencent.mm.vending.j.a.J(Integer.valueOf(1), Long.valueOf(l)));
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
          paramcjo.put(localObject4);
        }
        catch (JSONException localJSONException)
        {
          Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageMergeReport", localJSONException, "SessionPageMerge, jsonObject: %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    if (paramcjo.length() <= 0)
    {
      Log.i("HABBYGE-MALI.HellSessionPageMergeReport", "HellSessionPageMergeReport, content is NULL !!!");
      AppMethodBeat.o(177402);
      return null;
    }
    try
    {
      paramcjr.put("content", paramcjo);
      paramcjr = paramcjr.toString();
      AppMethodBeat.o(177402);
      return paramcjr;
    }
    catch (JSONException paramcjr)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageMergeReport", paramcjr, "SessionPageMerge, jsonObject, crash: %s", new Object[] { paramcjr.getMessage() });
      AppMethodBeat.o(177402);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.h
 * JD-Core Version:    0.7.0.1
 */