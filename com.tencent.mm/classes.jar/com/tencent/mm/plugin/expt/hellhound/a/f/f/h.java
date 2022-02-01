package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.g;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.cqr;
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

final class h
{
  private static void Xf(String paramString)
  {
    AppMethodBeat.i(122244);
    String str2 = g.cdq();
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
      Xg(str1);
      g.pq(System.currentTimeMillis());
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
  private static void Xg(String paramString)
  {
    AppMethodBeat.i(122245);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122245);
      return;
    }
    ad.i("HellSessionPageMergeReport", "HABBYGE-MALI, FuzzyMergeReport, reportSessionPageMerge: %s", new Object[] { paramString });
    d.aL(17647, paramString);
    AppMethodBeat.o(122245);
  }
  
  static void a(bge parambge, bgb parambgb, amz paramamz, bxx parambxx)
  {
    AppMethodBeat.i(177401);
    Xf(b(parambge, parambgb, parambxx));
    if ((paramamz == null) || (paramamz.DnZ.isEmpty()))
    {
      AppMethodBeat.o(177401);
      return;
    }
    Xf(c.b(parambge, paramamz));
    AppMethodBeat.o(177401);
  }
  
  private static String b(bge parambge, bgb parambgb, bxx parambxx)
  {
    AppMethodBeat.i(177402);
    parambgb = j.d(parambgb);
    parambxx = i.a(parambgb, parambxx);
    i.U(parambxx);
    if ((parambgb.isEmpty()) || (parambxx.isEmpty()))
    {
      ad.i("HellSessionPageMergeReport", "HABBYGE-MALI, SessionPageMerge, toJson, PageFlowMap Empty !!");
      AppMethodBeat.o(177402);
      return null;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = parambxx.entrySet().iterator();
    Object localObject3;
    label120:
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject2).hasNext())
    {
      parambgb = (List)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if (!parambgb.isEmpty())
      {
        localObject3 = parambgb.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (cqr)((Iterator)localObject3).next();
            if (localObject4 != null)
            {
              localObject5 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(((cqr)localObject4).dpw);
              if (localObject5 != null)
              {
                if (!((Map)localObject1).containsKey(localObject5)) {
                  break label224;
                }
                parambxx = (List)((Map)localObject1).get(localObject5);
                parambgb = parambxx;
                if (parambxx != null) {
                  break;
                }
              }
            }
          }
        }
        label224:
        for (parambgb = new ArrayList();; parambgb = new ArrayList())
        {
          parambgb.add(localObject4);
          ((Map)localObject1).put(localObject5, parambgb);
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
    parambge = i.j(parambge);
    if (parambge == null)
    {
      AppMethodBeat.o(177402);
      return null;
    }
    parambgb = new JSONArray();
    parambxx = ((Map)localObject1).entrySet().iterator();
    while (parambxx.hasNext())
    {
      localObject2 = (Map.Entry)parambxx.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject3 = (List)((Map.Entry)localObject2).getValue();
      localObject2 = new HashMap();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (cqr)((Iterator)localObject3).next();
        long l;
        if (((Map)localObject2).containsKey(Long.valueOf(((cqr)localObject4).Doj)))
        {
          localObject5 = (com.tencent.mm.vending.j.c)((Map)localObject2).get(Long.valueOf(((cqr)localObject4).Doj));
          if (localObject5 != null)
          {
            l = 0L;
            Iterator localIterator = ((cqr)localObject4).EjD.iterator();
            while (localIterator.hasNext()) {
              l += ((bgc)localIterator.next()).duration;
            }
            ((Map)localObject2).put(Long.valueOf(((cqr)localObject4).Doj), a.L(Integer.valueOf(((Integer)((com.tencent.mm.vending.j.b)localObject5).get(0)).intValue() + 1), Long.valueOf(((Long)((com.tencent.mm.vending.j.c)localObject5).get(1)).longValue() + l)));
          }
        }
        else
        {
          l = 0L;
          localObject5 = ((cqr)localObject4).EjD.iterator();
          while (((Iterator)localObject5).hasNext()) {
            l += ((bgc)((Iterator)localObject5).next()).duration;
          }
          ((Map)localObject2).put(Long.valueOf(((cqr)localObject4).Doj), a.L(Integer.valueOf(1), Long.valueOf(l)));
        }
      }
      ad.i("HellSessionPageMergeReport", "HABBYGE-MALI, SessionPageMerge, sid: %s, ppidInfoMap: %d", new Object[] { localObject1, Integer.valueOf(((Map)localObject2).size()) });
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
          parambgb.put(localObject4);
        }
        catch (JSONException localJSONException)
        {
          ad.printErrStackTrace("HellSessionPageMergeReport", localJSONException, "HABBYGE-MALI, SessionPageMerge, jsonObject: %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    if (parambgb.length() <= 0)
    {
      ad.i("HellSessionPageMergeReport", "HABBYGE-MALI, HellSessionPageMergeReport, content is NULL !!!");
      AppMethodBeat.o(177402);
      return null;
    }
    try
    {
      parambge.put("content", parambgb);
      parambge = parambge.toString();
      AppMethodBeat.o(177402);
      return parambge;
    }
    catch (JSONException parambge)
    {
      ad.printErrStackTrace("HellSessionPageMergeReport", parambge, "HABBYGE-MALI, SessionPageMerge, jsonObject, crash: %s", new Object[] { parambge.getMessage() });
      AppMethodBeat.o(177402);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.h
 * JD-Core Version:    0.7.0.1
 */