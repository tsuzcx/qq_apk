package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.g;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.dce;
import com.tencent.mm.sdk.platformtools.ae;
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
  static void a(bow parambow, bot parambot, aup paramaup, cie paramcie)
  {
    AppMethodBeat.i(177401);
    agm(b(parambow, parambot, paramcie));
    if ((paramaup == null) || (paramaup.GLy.isEmpty()))
    {
      AppMethodBeat.o(177401);
      return;
    }
    agm(c.b(parambow, paramaup));
    AppMethodBeat.o(177401);
  }
  
  private static void agm(String paramString)
  {
    AppMethodBeat.i(122244);
    String str2 = g.crO();
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
      agn(str1);
      g.vs(System.currentTimeMillis());
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
  private static void agn(String paramString)
  {
    AppMethodBeat.i(122245);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122245);
      return;
    }
    ae.i("HABBYGE-MALI.HellSessionPageMergeReport", "FuzzyMergeReport, reportSessionPageMerge: %s", new Object[] { paramString });
    d.aQ(17647, paramString);
    com.tencent.mm.plugin.expt.d.a.cow().qXi.aee(paramString);
    AppMethodBeat.o(122245);
  }
  
  private static String b(bow parambow, bot parambot, cie paramcie)
  {
    AppMethodBeat.i(177402);
    parambot = j.d(parambot);
    paramcie = i.a(parambot, paramcie);
    i.ad(paramcie);
    if ((parambot.isEmpty()) || (paramcie.isEmpty()))
    {
      ae.i("HABBYGE-MALI.HellSessionPageMergeReport", "SessionPageMerge, toJson, PageFlowMap Empty !!");
      AppMethodBeat.o(177402);
      return null;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = paramcie.entrySet().iterator();
    Object localObject3;
    label120:
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject2).hasNext())
    {
      parambot = (List)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if (!parambot.isEmpty())
      {
        localObject3 = parambot.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (dce)((Iterator)localObject3).next();
            if (localObject4 != null)
            {
              localObject5 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(((dce)localObject4).dAa);
              if (localObject5 != null)
              {
                if (!((Map)localObject1).containsKey(localObject5)) {
                  break label224;
                }
                paramcie = (List)((Map)localObject1).get(localObject5);
                parambot = paramcie;
                if (paramcie != null) {
                  break;
                }
              }
            }
          }
        }
        label224:
        for (parambot = new ArrayList();; parambot = new ArrayList())
        {
          parambot.add(localObject4);
          ((Map)localObject1).put(localObject5, parambot);
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
    parambow = i.j(parambow);
    if (parambow == null)
    {
      AppMethodBeat.o(177402);
      return null;
    }
    parambot = new JSONArray();
    paramcie = ((Map)localObject1).entrySet().iterator();
    while (paramcie.hasNext())
    {
      localObject2 = (Map.Entry)paramcie.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject3 = (List)((Map.Entry)localObject2).getValue();
      localObject2 = new HashMap();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (dce)((Iterator)localObject3).next();
        long l;
        if (((Map)localObject2).containsKey(Long.valueOf(((dce)localObject4).GLJ)))
        {
          localObject5 = (com.tencent.mm.vending.j.c)((Map)localObject2).get(Long.valueOf(((dce)localObject4).GLJ));
          if (localObject5 != null)
          {
            l = 0L;
            Iterator localIterator = ((dce)localObject4).HKG.iterator();
            while (localIterator.hasNext()) {
              l += ((bou)localIterator.next()).duration;
            }
            ((Map)localObject2).put(Long.valueOf(((dce)localObject4).GLJ), com.tencent.mm.vending.j.a.N(Integer.valueOf(((Integer)((com.tencent.mm.vending.j.b)localObject5).get(0)).intValue() + 1), Long.valueOf(((Long)((com.tencent.mm.vending.j.c)localObject5).get(1)).longValue() + l)));
          }
        }
        else
        {
          l = 0L;
          localObject5 = ((dce)localObject4).HKG.iterator();
          while (((Iterator)localObject5).hasNext()) {
            l += ((bou)((Iterator)localObject5).next()).duration;
          }
          ((Map)localObject2).put(Long.valueOf(((dce)localObject4).GLJ), com.tencent.mm.vending.j.a.N(Integer.valueOf(1), Long.valueOf(l)));
        }
      }
      ae.i("HABBYGE-MALI.HellSessionPageMergeReport", "SessionPageMerge, sid: %s, ppidInfoMap: %d", new Object[] { localObject1, Integer.valueOf(((Map)localObject2).size()) });
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
          parambot.put(localObject4);
        }
        catch (JSONException localJSONException)
        {
          ae.printErrStackTrace("HABBYGE-MALI.HellSessionPageMergeReport", localJSONException, "SessionPageMerge, jsonObject: %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    if (parambot.length() <= 0)
    {
      ae.i("HABBYGE-MALI.HellSessionPageMergeReport", "HellSessionPageMergeReport, content is NULL !!!");
      AppMethodBeat.o(177402);
      return null;
    }
    try
    {
      parambow.put("content", parambot);
      parambow = parambow.toString();
      AppMethodBeat.o(177402);
      return parambow;
    }
    catch (JSONException parambow)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellSessionPageMergeReport", parambow, "SessionPageMerge, jsonObject, crash: %s", new Object[] { parambow.getMessage() });
      AppMethodBeat.o(177402);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.h
 * JD-Core Version:    0.7.0.1
 */