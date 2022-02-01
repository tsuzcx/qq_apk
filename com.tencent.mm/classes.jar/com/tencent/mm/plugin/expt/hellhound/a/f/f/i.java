package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cvz;
import com.tencent.mm.protocal.protobuf.cwa;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.util.List<Lcom.tencent.mm.protocal.protobuf.bju;>;>;
import java.util.Set;
import org.json.JSONObject;

public final class i
{
  static void V(Map<Long, List<cvy>> paramMap)
  {
    AppMethodBeat.i(177406);
    Object localObject = k.abv("mmkv_key_hellSPMatchSuche_");
    if ((localObject == null) || (((cvz)localObject).FGC.isEmpty()))
    {
      AppMethodBeat.o(177406);
      return;
    }
    Iterator localIterator = ((cvz)localObject).FGC.iterator();
    if (localIterator.hasNext())
    {
      cvy localcvy = (cvy)localIterator.next();
      if (paramMap.containsKey(Long.valueOf(localcvy.EJj)))
      {
        List localList = (List)paramMap.get(Long.valueOf(localcvy.EJj));
        localObject = localList;
        if (localList != null) {}
      }
      for (localObject = new ArrayList();; localObject = new ArrayList())
      {
        ((List)localObject).add(localcvy);
        paramMap.put(Long.valueOf(localcvy.EJj), localObject);
        break;
      }
    }
    AppMethodBeat.o(177406);
  }
  
  public static Map<Long, cvy> a(bju parambju, List<cwa> paramList)
  {
    AppMethodBeat.i(122248);
    HashSet localHashSet = new HashSet();
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(parambju.qoi);
    if (str == null)
    {
      AppMethodBeat.o(122248);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    cwa localcwa;
    if (paramList.hasNext())
    {
      localcwa = (cwa)paramList.next();
      if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.ZK(((cvw)localcwa.FGD.get(localcwa.index + 1)).qoi)))
      {
        localcwa.index += 1;
        if (localcwa.index != localcwa.FGD.size() - 1) {
          break label338;
        }
        localcwa.index = -1;
      }
    }
    label338:
    for (boolean bool1 = true;; bool1 = false)
    {
      Object localObject = parambju.EJd.iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        bjv localbjv = (bjv)((Iterator)localObject).next();
        if (localbjv != null) {
          localHashSet.add(localbjv.koY);
        }
      }
      if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.ZK(((cvw)localcwa.FGD.get(0)).qoi))) {
        localcwa.index = 0;
      }
      for (boolean bool2 = false;; bool2 = false)
      {
        localObject = new cvy();
        ((cvy)localObject).index = localcwa.index;
        ((cvy)localObject).FGA = bool2;
        ((cvy)localObject).EJj = localcwa.EJj;
        ((cvy)localObject).dnh = parambju.dnh;
        ((cvy)localObject).rAJ = localcwa.rAJ;
        ((cvy)localObject).EJi = localcwa.EJi;
        localHashMap.put(Long.valueOf(localcwa.EJj), localObject);
        break;
        localcwa.index = -1;
      }
      a.d(localHashSet);
      AppMethodBeat.o(122248);
      return localHashMap;
    }
  }
  
  static Map<Long, List<cvy>> a(Map<String, List<bju>> paramMap, ccs paramccs)
  {
    AppMethodBeat.i(177404);
    ac.i("HellSessionReport", "HABBYGE-MALI, filter, filterBySessionPageCloudConfig: %d", new Object[] { Integer.valueOf(paramMap.size()) });
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator1 = paramMap.entrySet().iterator();
    Object localObject2;
    String str;
    Object localObject1;
    bju localbju;
    do
    {
      List localList;
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        do
        {
          do
          {
            if (!localIterator1.hasNext()) {
              break;
            }
            localObject2 = (Map.Entry)localIterator1.next();
            str = (String)((Map.Entry)localObject2).getKey();
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(str);
            paramMap = (Map<String, List<bju>>)localObject1;
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric((String)localObject1)) {
              paramMap = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaT(str);
            }
          } while (paramMap == null);
          localList = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.abc(paramMap);
        } while ((localList == null) || (localList.isEmpty()));
        localIterator2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
      }
      localbju = (bju)localIterator2.next();
      paramMap = a(localbju, localList);
    } while (paramMap == null);
    Iterator localIterator3 = paramMap.entrySet().iterator();
    label206:
    label463:
    label886:
    label889:
    for (;;)
    {
      long l;
      if (localIterator3.hasNext())
      {
        paramMap = (Map.Entry)localIterator3.next();
        l = ((Long)paramMap.getKey()).longValue();
        localObject2 = (cvy)paramMap.getValue();
        if (localHashMap2.containsKey(Long.valueOf(l)))
        {
          paramMap = (cvy)localHashMap2.get(Long.valueOf(l));
          localObject1 = paramMap;
          if (paramMap == null)
          {
            localObject1 = new cvy();
            ((cvy)localObject1).index = ((cvy)localObject2).index;
            ((cvy)localObject1).EJi = ((cvy)localObject2).EJi;
            ((cvy)localObject1).rAJ = ((cvy)localObject2).rAJ;
            ((cvy)localObject1).EJj = l;
            ((cvy)localObject1).dnh = str;
            localHashMap2.put(Long.valueOf(l), localObject1);
          }
          ((cvy)localObject1).FGB.add(localbju);
          if (((cvy)localObject2).index < 0)
          {
            if (((cvy)localObject2).FGA)
            {
              if (!localHashMap1.containsKey(Long.valueOf(l))) {
                break label463;
              }
              localObject2 = (List)localHashMap1.get(Long.valueOf(l));
              paramMap = (Map<String, List<bju>>)localObject2;
              if (localObject2 != null) {}
            }
            for (paramMap = new ArrayList();; paramMap = new ArrayList())
            {
              paramMap.add(localObject1);
              localHashMap1.put(Long.valueOf(l), paramMap);
              localHashMap2.remove(Long.valueOf(l));
              break;
            }
          }
          if (((cvy)localObject2).index == 0)
          {
            ((cvy)localObject1).FGB.clear();
            ((cvy)localObject1).FGB.add(localbju);
            continue;
          }
          if (((cvy)localObject1).FGB.isEmpty()) {
            break label886;
          }
          paramMap = (bju)((cvy)localObject1).FGB.get(((cvy)localObject1).FGB.size() - 1);
          if ((!localbju.qoi.equals(paramMap.qoi)) || (localbju.startTime != paramMap.startTime)) {
            break label886;
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label889;
        }
        ((cvy)localObject1).FGB.add(localbju);
        break label206;
        if (((cvy)localObject2).index >= 0)
        {
          paramMap = new cvy();
          paramMap.index = ((cvy)localObject2).index;
          paramMap.EJi = ((cvy)localObject2).EJi;
          paramMap.rAJ = ((cvy)localObject2).rAJ;
          paramMap.EJj = l;
          paramMap.dnh = str;
          paramMap.FGB.add(localbju);
          localHashMap2.put(Long.valueOf(l), paramMap);
          break label206;
        }
        if (!((cvy)localObject2).FGA) {
          break label206;
        }
        if (localHashMap1.containsKey(Long.valueOf(l)))
        {
          localObject1 = (List)localHashMap1.get(Long.valueOf(l));
          paramMap = (Map<String, List<bju>>)localObject1;
          if (localObject1 != null) {}
        }
        for (paramMap = new ArrayList();; paramMap = new ArrayList())
        {
          localObject1 = new cvy();
          ((cvy)localObject1).index = ((cvy)localObject2).index;
          ((cvy)localObject1).EJi = ((cvy)localObject2).EJi;
          ((cvy)localObject1).rAJ = ((cvy)localObject2).rAJ;
          ((cvy)localObject1).EJj = l;
          ((cvy)localObject1).dnh = str;
          ((cvy)localObject1).FGB.add(localbju);
          paramMap.add(localObject1);
          localHashMap1.put(Long.valueOf(l), paramMap);
          break label206;
          break;
        }
        ac.i("HellSessionReport", "HABBYGE-MALI, filterBySessionPageCloudConfig, end: %d, %d", new Object[] { Integer.valueOf(localHashMap2.size()), Integer.valueOf(localHashMap1.size()) });
        if ((!localHashMap2.isEmpty()) && (paramccs != null)) {
          k.i(localHashMap2, paramccs.sessionId);
        }
        AppMethodBeat.o(177404);
        return localHashMap1;
      }
    }
  }
  
  static boolean ao(String paramString, long paramLong)
  {
    AppMethodBeat.i(184381);
    if (paramString == null)
    {
      AppMethodBeat.o(184381);
      return false;
    }
    try
    {
      i = paramString.getBytes().length;
      if ((i >= 20480) || (System.currentTimeMillis() - paramLong >= 3600000L))
      {
        AppMethodBeat.o(184381);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = paramString.length();
      }
      AppMethodBeat.o(184381);
    }
    return false;
  }
  
  public static void c(bjw parambjw, bjt parambjt, ccs paramccs)
  {
    AppMethodBeat.i(177403);
    if ((parambjw == null) || (parambjt == null))
    {
      AppMethodBeat.o(177403);
      return;
    }
    if ((parambjw.EZq.isEmpty()) && (parambjw.EZo.isEmpty()))
    {
      AppMethodBeat.o(177403);
      return;
    }
    if (parambjt.EZk.isEmpty())
    {
      AppMethodBeat.o(177403);
      return;
    }
    ac.i("HellSessionReport", "HABBYGE-MALI, reportWhenEvent8 BEGIN !!");
    j.a(parambjt, parambjw, false);
    j.a(parambjw, (bju)parambjt.EZk.getFirst());
    j.d(parambjw, parambjt, paramccs);
    AppMethodBeat.o(177403);
  }
  
  static JSONObject j(bjw parambjw)
  {
    AppMethodBeat.i(177405);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tbe", parambjw.EZm);
      long l = parambjw.EZn - parambjw.EZm;
      if (l > 0L) {}
      for (;;)
      {
        localJSONObject.put("in", l);
        localJSONObject.put("vv", "2.0");
        AppMethodBeat.o(177405);
        return localJSONObject;
        l = 0L;
      }
      return null;
    }
    catch (Exception parambjw)
    {
      ac.printErrStackTrace("HellSessionReport", parambjw, "HABBYGE-MALI, createJSONObjectHead, crash: %s", new Object[] { parambjw.getMessage() });
      AppMethodBeat.o(177405);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.i
 * JD-Core Version:    0.7.0.1
 */