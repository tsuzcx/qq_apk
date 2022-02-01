package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.g;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.cvy;
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

final class h
{
  static void a(bjw parambjw, bjt parambjt, aqd paramaqd, ccs paramccs)
  {
    AppMethodBeat.i(177401);
    abC(b(parambjw, parambjt, paramccs));
    if ((paramaqd == null) || (paramaqd.EIZ.isEmpty()))
    {
      AppMethodBeat.o(177401);
      return;
    }
    abC(c.b(parambjw, paramaqd));
    AppMethodBeat.o(177401);
  }
  
  private static void abC(String paramString)
  {
    AppMethodBeat.i(122244);
    String str2 = g.ckY();
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
      abD(str1);
      g.tf(System.currentTimeMillis());
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
  private static void abD(String paramString)
  {
    AppMethodBeat.i(122245);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122245);
      return;
    }
    ac.i("HellSessionPageMergeReport", "HABBYGE-MALI, FuzzyMergeReport, reportSessionPageMerge: %s", new Object[] { paramString });
    d.aO(17647, paramString);
    AppMethodBeat.o(122245);
  }
  
  private static String b(bjw parambjw, bjt parambjt, ccs paramccs)
  {
    AppMethodBeat.i(177402);
    parambjt = j.d(parambjt);
    paramccs = i.a(parambjt, paramccs);
    i.V(paramccs);
    if ((parambjt.isEmpty()) || (paramccs.isEmpty()))
    {
      ac.i("HellSessionPageMergeReport", "HABBYGE-MALI, SessionPageMerge, toJson, PageFlowMap Empty !!");
      AppMethodBeat.o(177402);
      return null;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = paramccs.entrySet().iterator();
    Object localObject3;
    label120:
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject2).hasNext())
    {
      parambjt = (List)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if (!parambjt.isEmpty())
      {
        localObject3 = parambjt.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (cvy)((Iterator)localObject3).next();
            if (localObject4 != null)
            {
              localObject5 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(((cvy)localObject4).dnh);
              if (localObject5 != null)
              {
                if (!((Map)localObject1).containsKey(localObject5)) {
                  break label224;
                }
                paramccs = (List)((Map)localObject1).get(localObject5);
                parambjt = paramccs;
                if (paramccs != null) {
                  break;
                }
              }
            }
          }
        }
        label224:
        for (parambjt = new ArrayList();; parambjt = new ArrayList())
        {
          parambjt.add(localObject4);
          ((Map)localObject1).put(localObject5, parambjt);
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
    parambjw = i.j(parambjw);
    if (parambjw == null)
    {
      AppMethodBeat.o(177402);
      return null;
    }
    parambjt = new JSONArray();
    paramccs = ((Map)localObject1).entrySet().iterator();
    while (paramccs.hasNext())
    {
      localObject2 = (Map.Entry)paramccs.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject3 = (List)((Map.Entry)localObject2).getValue();
      localObject2 = new HashMap();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (cvy)((Iterator)localObject3).next();
        long l;
        if (((Map)localObject2).containsKey(Long.valueOf(((cvy)localObject4).EJj)))
        {
          localObject5 = (com.tencent.mm.vending.j.c)((Map)localObject2).get(Long.valueOf(((cvy)localObject4).EJj));
          if (localObject5 != null)
          {
            l = 0L;
            Iterator localIterator = ((cvy)localObject4).FGB.iterator();
            while (localIterator.hasNext()) {
              l += ((bju)localIterator.next()).duration;
            }
            ((Map)localObject2).put(Long.valueOf(((cvy)localObject4).EJj), a.L(Integer.valueOf(((Integer)((com.tencent.mm.vending.j.b)localObject5).get(0)).intValue() + 1), Long.valueOf(((Long)((com.tencent.mm.vending.j.c)localObject5).get(1)).longValue() + l)));
          }
        }
        else
        {
          l = 0L;
          localObject5 = ((cvy)localObject4).FGB.iterator();
          while (((Iterator)localObject5).hasNext()) {
            l += ((bju)((Iterator)localObject5).next()).duration;
          }
          ((Map)localObject2).put(Long.valueOf(((cvy)localObject4).EJj), a.L(Integer.valueOf(1), Long.valueOf(l)));
        }
      }
      ac.i("HellSessionPageMergeReport", "HABBYGE-MALI, SessionPageMerge, sid: %s, ppidInfoMap: %d", new Object[] { localObject1, Integer.valueOf(((Map)localObject2).size()) });
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
          parambjt.put(localObject4);
        }
        catch (JSONException localJSONException)
        {
          ac.printErrStackTrace("HellSessionPageMergeReport", localJSONException, "HABBYGE-MALI, SessionPageMerge, jsonObject: %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    if (parambjt.length() <= 0)
    {
      ac.i("HellSessionPageMergeReport", "HABBYGE-MALI, HellSessionPageMergeReport, content is NULL !!!");
      AppMethodBeat.o(177402);
      return null;
    }
    try
    {
      parambjw.put("content", parambjt);
      parambjw = parambjw.toString();
      AppMethodBeat.o(177402);
      return parambjw;
    }
    catch (JSONException parambjw)
    {
      ac.printErrStackTrace("HellSessionPageMergeReport", parambjw, "HABBYGE-MALI, SessionPageMerge, jsonObject, crash: %s", new Object[] { parambjw.getMessage() });
      AppMethodBeat.o(177402);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.h
 * JD-Core Version:    0.7.0.1
 */