package com.tencent.mm.plugin.expt.hellhound.ext.session.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.g;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.ezd;
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
  static void a(czw paramczw, czt paramczt, cat paramcat, eah parameah)
  {
    AppMethodBeat.i(177401);
    atd(b(paramczw, paramczt, parameah));
    if ((paramcat == null) || (paramcat.aajM.isEmpty()))
    {
      AppMethodBeat.o(177401);
      return;
    }
    atd(c.b(paramczw, paramcat));
    AppMethodBeat.o(177401);
  }
  
  private static void atd(String paramString)
  {
    AppMethodBeat.i(122244);
    String str2 = g.dMe();
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
      ate(str1);
      g.mi(System.currentTimeMillis());
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
  
  private static void ate(String paramString)
  {
    AppMethodBeat.i(122245);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122245);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionPageMergeReport", "FuzzyMergeReport, reportSessionPageMerge: %s", new Object[] { paramString });
    d.bo(17647, paramString);
    com.tencent.mm.plugin.expt.edge.a.dHT().zxY.aqo(paramString);
    AppMethodBeat.o(122245);
  }
  
  private static String b(czw paramczw, czt paramczt, eah parameah)
  {
    AppMethodBeat.i(177402);
    paramczt = j.d(paramczt);
    parameah = i.a(paramczt, parameah);
    i.ai(parameah);
    if ((paramczt.isEmpty()) || (parameah.isEmpty()))
    {
      Log.i("HABBYGE-MALI.HellSessionPageMergeReport", "SessionPageMerge, toJson, PageFlowMap Empty !!");
      AppMethodBeat.o(177402);
      return null;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = parameah.entrySet().iterator();
    Object localObject3;
    label120:
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject2).hasNext())
    {
      paramczt = (List)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if (!paramczt.isEmpty())
      {
        localObject3 = paramczt.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (ezd)((Iterator)localObject3).next();
            if (localObject4 != null)
            {
              localObject5 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(((ezd)localObject4).hQR);
              if (localObject5 != null)
              {
                if (!((Map)localObject1).containsKey(localObject5)) {
                  break label224;
                }
                parameah = (List)((Map)localObject1).get(localObject5);
                paramczt = parameah;
                if (parameah != null) {
                  break;
                }
              }
            }
          }
        }
        label224:
        for (paramczt = new ArrayList();; paramczt = new ArrayList())
        {
          paramczt.add(localObject4);
          ((Map)localObject1).put(localObject5, paramczt);
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
    paramczw = i.j(paramczw);
    if (paramczw == null)
    {
      AppMethodBeat.o(177402);
      return null;
    }
    paramczt = new JSONArray();
    parameah = ((Map)localObject1).entrySet().iterator();
    while (parameah.hasNext())
    {
      localObject2 = (Map.Entry)parameah.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject3 = (List)((Map.Entry)localObject2).getValue();
      localObject2 = new HashMap();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ezd)((Iterator)localObject3).next();
        long l;
        if (((Map)localObject2).containsKey(Long.valueOf(((ezd)localObject4).aajX)))
        {
          localObject5 = (com.tencent.mm.vending.j.c)((Map)localObject2).get(Long.valueOf(((ezd)localObject4).aajX));
          if (localObject5 != null)
          {
            l = 0L;
            Iterator localIterator = ((ezd)localObject4).abAj.iterator();
            while (localIterator.hasNext()) {
              l += ((czu)localIterator.next()).duration;
            }
            ((Map)localObject2).put(Long.valueOf(((ezd)localObject4).aajX), com.tencent.mm.vending.j.a.U(Integer.valueOf(((Integer)((com.tencent.mm.vending.j.b)localObject5).get(0)).intValue() + 1), Long.valueOf(((Long)((com.tencent.mm.vending.j.c)localObject5).get(1)).longValue() + l)));
          }
        }
        else
        {
          l = 0L;
          localObject5 = ((ezd)localObject4).abAj.iterator();
          while (((Iterator)localObject5).hasNext()) {
            l += ((czu)((Iterator)localObject5).next()).duration;
          }
          ((Map)localObject2).put(Long.valueOf(((ezd)localObject4).aajX), com.tencent.mm.vending.j.a.U(Integer.valueOf(1), Long.valueOf(l)));
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
          paramczt.put(localObject4);
        }
        catch (JSONException localJSONException)
        {
          Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageMergeReport", localJSONException, "SessionPageMerge, jsonObject: %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    if (paramczt.length() <= 0)
    {
      Log.i("HABBYGE-MALI.HellSessionPageMergeReport", "HellSessionPageMergeReport, content is NULL !!!");
      AppMethodBeat.o(177402);
      return null;
    }
    try
    {
      paramczw.put("content", paramczt);
      paramczw = paramczw.toString();
      AppMethodBeat.o(177402);
      return paramczw;
    }
    catch (JSONException paramczw)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageMergeReport", paramczw, "SessionPageMerge, jsonObject, crash: %s", new Object[] { paramczw.getMessage() });
      AppMethodBeat.o(177402);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.e.h
 * JD-Core Version:    0.7.0.1
 */