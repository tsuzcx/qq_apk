package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.g;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.sdk.platformtools.ad;
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
  static void a(boe paramboe, bob parambob, atz paramatz, chk paramchk)
  {
    AppMethodBeat.i(177401);
    afq(b(paramboe, parambob, paramchk));
    if ((paramatz == null) || (paramatz.Gsa.isEmpty()))
    {
      AppMethodBeat.o(177401);
      return;
    }
    afq(c.b(paramboe, paramatz));
    AppMethodBeat.o(177401);
  }
  
  private static void afq(String paramString)
  {
    AppMethodBeat.i(122244);
    String str2 = g.cqm();
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
      afr(str1);
      g.vb(System.currentTimeMillis());
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
  private static void afr(String paramString)
  {
    AppMethodBeat.i(122245);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122245);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionPageMergeReport", "FuzzyMergeReport, reportSessionPageMerge: %s", new Object[] { paramString });
    d.aR(17647, paramString);
    com.tencent.mm.plugin.expt.d.a.cng().qPn.adk(paramString);
    AppMethodBeat.o(122245);
  }
  
  private static String b(boe paramboe, bob parambob, chk paramchk)
  {
    AppMethodBeat.i(177402);
    parambob = j.d(parambob);
    paramchk = i.a(parambob, paramchk);
    i.X(paramchk);
    if ((parambob.isEmpty()) || (paramchk.isEmpty()))
    {
      ad.i("HABBYGE-MALI.HellSessionPageMergeReport", "SessionPageMerge, toJson, PageFlowMap Empty !!");
      AppMethodBeat.o(177402);
      return null;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = paramchk.entrySet().iterator();
    Object localObject3;
    label120:
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject2).hasNext())
    {
      parambob = (List)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if (!parambob.isEmpty())
      {
        localObject3 = parambob.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (dbk)((Iterator)localObject3).next();
            if (localObject4 != null)
            {
              localObject5 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(((dbk)localObject4).dyV);
              if (localObject5 != null)
              {
                if (!((Map)localObject1).containsKey(localObject5)) {
                  break label224;
                }
                paramchk = (List)((Map)localObject1).get(localObject5);
                parambob = paramchk;
                if (paramchk != null) {
                  break;
                }
              }
            }
          }
        }
        label224:
        for (parambob = new ArrayList();; parambob = new ArrayList())
        {
          parambob.add(localObject4);
          ((Map)localObject1).put(localObject5, parambob);
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
    paramboe = i.j(paramboe);
    if (paramboe == null)
    {
      AppMethodBeat.o(177402);
      return null;
    }
    parambob = new JSONArray();
    paramchk = ((Map)localObject1).entrySet().iterator();
    while (paramchk.hasNext())
    {
      localObject2 = (Map.Entry)paramchk.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject3 = (List)((Map.Entry)localObject2).getValue();
      localObject2 = new HashMap();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (dbk)((Iterator)localObject3).next();
        long l;
        if (((Map)localObject2).containsKey(Long.valueOf(((dbk)localObject4).Gsl)))
        {
          localObject5 = (com.tencent.mm.vending.j.c)((Map)localObject2).get(Long.valueOf(((dbk)localObject4).Gsl));
          if (localObject5 != null)
          {
            l = 0L;
            Iterator localIterator = ((dbk)localObject4).Hre.iterator();
            while (localIterator.hasNext()) {
              l += ((boc)localIterator.next()).duration;
            }
            ((Map)localObject2).put(Long.valueOf(((dbk)localObject4).Gsl), com.tencent.mm.vending.j.a.N(Integer.valueOf(((Integer)((com.tencent.mm.vending.j.b)localObject5).get(0)).intValue() + 1), Long.valueOf(((Long)((com.tencent.mm.vending.j.c)localObject5).get(1)).longValue() + l)));
          }
        }
        else
        {
          l = 0L;
          localObject5 = ((dbk)localObject4).Hre.iterator();
          while (((Iterator)localObject5).hasNext()) {
            l += ((boc)((Iterator)localObject5).next()).duration;
          }
          ((Map)localObject2).put(Long.valueOf(((dbk)localObject4).Gsl), com.tencent.mm.vending.j.a.N(Integer.valueOf(1), Long.valueOf(l)));
        }
      }
      ad.i("HABBYGE-MALI.HellSessionPageMergeReport", "SessionPageMerge, sid: %s, ppidInfoMap: %d", new Object[] { localObject1, Integer.valueOf(((Map)localObject2).size()) });
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
          parambob.put(localObject4);
        }
        catch (JSONException localJSONException)
        {
          ad.printErrStackTrace("HABBYGE-MALI.HellSessionPageMergeReport", localJSONException, "SessionPageMerge, jsonObject: %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    if (parambob.length() <= 0)
    {
      ad.i("HABBYGE-MALI.HellSessionPageMergeReport", "HellSessionPageMergeReport, content is NULL !!!");
      AppMethodBeat.o(177402);
      return null;
    }
    try
    {
      paramboe.put("content", parambob);
      paramboe = paramboe.toString();
      AppMethodBeat.o(177402);
      return paramboe;
    }
    catch (JSONException paramboe)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellSessionPageMergeReport", paramboe, "SessionPageMerge, jsonObject, crash: %s", new Object[] { paramboe.getMessage() });
      AppMethodBeat.o(177402);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.h
 * JD-Core Version:    0.7.0.1
 */