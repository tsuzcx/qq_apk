package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.cqp;
import com.tencent.mm.protocal.protobuf.cqr;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.util.List<Lcom.tencent.mm.protocal.protobuf.bgc;>;>;
import java.util.Set;
import org.json.JSONObject;

public final class i
{
  static void U(Map<Long, List<cqr>> paramMap)
  {
    AppMethodBeat.i(177406);
    Object localObject = k.WY("mmkv_key_hellSPMatchSuche_");
    if ((localObject == null) || (((cqs)localObject).EjE.isEmpty()))
    {
      AppMethodBeat.o(177406);
      return;
    }
    Iterator localIterator = ((cqs)localObject).EjE.iterator();
    if (localIterator.hasNext())
    {
      cqr localcqr = (cqr)localIterator.next();
      if (paramMap.containsKey(Long.valueOf(localcqr.Doj)))
      {
        List localList = (List)paramMap.get(Long.valueOf(localcqr.Doj));
        localObject = localList;
        if (localList != null) {}
      }
      for (localObject = new ArrayList();; localObject = new ArrayList())
      {
        ((List)localObject).add(localcqr);
        paramMap.put(Long.valueOf(localcqr.Doj), localObject);
        break;
      }
    }
    AppMethodBeat.o(177406);
  }
  
  public static Map<Long, cqr> a(bgc parambgc, List<cqt> paramList)
  {
    AppMethodBeat.i(122248);
    HashSet localHashSet = new HashSet();
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambgc.DDP);
    if (str == null)
    {
      AppMethodBeat.o(122248);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    cqt localcqt;
    if (paramList.hasNext())
    {
      localcqt = (cqt)paramList.next();
      if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.Vy(((cqp)localcqt.EjF.get(localcqt.index + 1)).DDP)))
      {
        localcqt.index += 1;
        if (localcqt.index != localcqt.EjF.size() - 1) {
          break label338;
        }
        localcqt.index = -1;
      }
    }
    label338:
    for (boolean bool1 = true;; bool1 = false)
    {
      Object localObject = parambgc.Dod.iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        bgd localbgd = (bgd)((Iterator)localObject).next();
        if (localbgd != null) {
          localHashSet.add(localbgd.jOx);
        }
      }
      if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.Vy(((cqp)localcqt.EjF.get(0)).DDP))) {
        localcqt.index = 0;
      }
      for (boolean bool2 = false;; bool2 = false)
      {
        localObject = new cqr();
        ((cqr)localObject).index = localcqt.index;
        ((cqr)localObject).EjC = bool2;
        ((cqr)localObject).Doj = localcqt.Doj;
        ((cqr)localObject).dpw = parambgc.dpw;
        ((cqr)localObject).qHI = localcqt.qHI;
        ((cqr)localObject).Doi = localcqt.Doi;
        localHashMap.put(Long.valueOf(localcqt.Doj), localObject);
        break;
        localcqt.index = -1;
      }
      a.c(localHashSet);
      AppMethodBeat.o(122248);
      return localHashMap;
    }
  }
  
  static Map<Long, List<cqr>> a(Map<String, List<bgc>> paramMap, bxx parambxx)
  {
    AppMethodBeat.i(177404);
    ad.i("HellSessionReport", "HABBYGE-MALI, filter, filterBySessionPageCloudConfig: %d", new Object[] { Integer.valueOf(paramMap.size()) });
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator1 = paramMap.entrySet().iterator();
    Object localObject2;
    String str;
    Object localObject1;
    bgc localbgc;
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
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(str);
            paramMap = (Map<String, List<bgc>>)localObject1;
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric((String)localObject1)) {
              paramMap = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Ww(str);
            }
          } while (paramMap == null);
          localList = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WF(paramMap);
        } while ((localList == null) || (localList.isEmpty()));
        localIterator2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
      }
      localbgc = (bgc)localIterator2.next();
      paramMap = a(localbgc, localList);
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
        localObject2 = (cqr)paramMap.getValue();
        if (localHashMap2.containsKey(Long.valueOf(l)))
        {
          paramMap = (cqr)localHashMap2.get(Long.valueOf(l));
          localObject1 = paramMap;
          if (paramMap == null)
          {
            localObject1 = new cqr();
            ((cqr)localObject1).index = ((cqr)localObject2).index;
            ((cqr)localObject1).Doi = ((cqr)localObject2).Doi;
            ((cqr)localObject1).qHI = ((cqr)localObject2).qHI;
            ((cqr)localObject1).Doj = l;
            ((cqr)localObject1).dpw = str;
            localHashMap2.put(Long.valueOf(l), localObject1);
          }
          ((cqr)localObject1).EjD.add(localbgc);
          if (((cqr)localObject2).index < 0)
          {
            if (((cqr)localObject2).EjC)
            {
              if (!localHashMap1.containsKey(Long.valueOf(l))) {
                break label463;
              }
              localObject2 = (List)localHashMap1.get(Long.valueOf(l));
              paramMap = (Map<String, List<bgc>>)localObject2;
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
          if (((cqr)localObject2).index == 0)
          {
            ((cqr)localObject1).EjD.clear();
            ((cqr)localObject1).EjD.add(localbgc);
            continue;
          }
          if (((cqr)localObject1).EjD.isEmpty()) {
            break label886;
          }
          paramMap = (bgc)((cqr)localObject1).EjD.get(((cqr)localObject1).EjD.size() - 1);
          if ((!localbgc.DDP.equals(paramMap.DDP)) || (localbgc.startTime != paramMap.startTime)) {
            break label886;
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label889;
        }
        ((cqr)localObject1).EjD.add(localbgc);
        break label206;
        if (((cqr)localObject2).index >= 0)
        {
          paramMap = new cqr();
          paramMap.index = ((cqr)localObject2).index;
          paramMap.Doi = ((cqr)localObject2).Doi;
          paramMap.qHI = ((cqr)localObject2).qHI;
          paramMap.Doj = l;
          paramMap.dpw = str;
          paramMap.EjD.add(localbgc);
          localHashMap2.put(Long.valueOf(l), paramMap);
          break label206;
        }
        if (!((cqr)localObject2).EjC) {
          break label206;
        }
        if (localHashMap1.containsKey(Long.valueOf(l)))
        {
          localObject1 = (List)localHashMap1.get(Long.valueOf(l));
          paramMap = (Map<String, List<bgc>>)localObject1;
          if (localObject1 != null) {}
        }
        for (paramMap = new ArrayList();; paramMap = new ArrayList())
        {
          localObject1 = new cqr();
          ((cqr)localObject1).index = ((cqr)localObject2).index;
          ((cqr)localObject1).Doi = ((cqr)localObject2).Doi;
          ((cqr)localObject1).qHI = ((cqr)localObject2).qHI;
          ((cqr)localObject1).Doj = l;
          ((cqr)localObject1).dpw = str;
          ((cqr)localObject1).EjD.add(localbgc);
          paramMap.add(localObject1);
          localHashMap1.put(Long.valueOf(l), paramMap);
          break label206;
          break;
        }
        ad.i("HellSessionReport", "HABBYGE-MALI, filterBySessionPageCloudConfig, end: %d, %d", new Object[] { Integer.valueOf(localHashMap2.size()), Integer.valueOf(localHashMap1.size()) });
        if ((!localHashMap2.isEmpty()) && (parambxx != null)) {
          k.i(localHashMap2, parambxx.sessionId);
        }
        AppMethodBeat.o(177404);
        return localHashMap1;
      }
    }
  }
  
  static boolean am(String paramString, long paramLong)
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
  
  public static void c(bge parambge, bgb parambgb, bxx parambxx)
  {
    AppMethodBeat.i(177403);
    if ((parambge == null) || (parambgb == null))
    {
      AppMethodBeat.o(177403);
      return;
    }
    if ((parambge.DDV.isEmpty()) && (parambge.DDT.isEmpty()))
    {
      AppMethodBeat.o(177403);
      return;
    }
    if (parambgb.DDO.isEmpty())
    {
      AppMethodBeat.o(177403);
      return;
    }
    ad.i("HellSessionReport", "HABBYGE-MALI, reportWhenEvent8 BEGIN !!");
    j.a(parambgb, parambge, false);
    j.a(parambge, (bgc)parambgb.DDO.getFirst());
    j.d(parambge, parambgb, parambxx);
    AppMethodBeat.o(177403);
  }
  
  static JSONObject j(bge parambge)
  {
    AppMethodBeat.i(177405);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tbe", parambge.DDR);
      long l = parambge.DDS - parambge.DDR;
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
    catch (Exception parambge)
    {
      ad.printErrStackTrace("HellSessionReport", parambge, "HABBYGE-MALI, createJSONObjectHead, crash: %s", new Object[] { parambge.getMessage() });
      AppMethodBeat.o(177405);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.i
 * JD-Core Version:    0.7.0.1
 */