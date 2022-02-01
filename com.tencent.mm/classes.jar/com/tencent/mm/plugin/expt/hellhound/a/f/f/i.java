package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.dcc;
import com.tencent.mm.protocal.protobuf.dce;
import com.tencent.mm.protocal.protobuf.dcf;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.protocal.protobuf.dwy;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.util.List<Lcom.tencent.mm.protocal.protobuf.bou;>;>;
import java.util.Set;
import org.json.JSONObject;

public final class i
{
  public static Map<Long, dce> a(bou parambou, List<dcg> paramList)
  {
    AppMethodBeat.i(122248);
    HashSet localHashSet = new HashSet();
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.aer(parambou.duQ);
    if (str == null)
    {
      AppMethodBeat.o(122248);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    dcg localdcg;
    Object localObject;
    if (paramList.hasNext())
    {
      localdcg = (dcg)paramList.next();
      localObject = (dcc)localdcg.HKI.get(localdcg.index + 1);
      if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aer(((dcc)localObject).duQ)))
      {
        localdcg.index += 1;
        if (localdcg.index != localdcg.HKI.size() - 1) {
          break label368;
        }
        localdcg.index = -1;
      }
    }
    label368:
    for (boolean bool1 = true;; bool1 = false)
    {
      a(parambou, (dcc)localObject, localdcg.GLJ);
      localObject = parambou.GLC.iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        bov localbov = (bov)((Iterator)localObject).next();
        if (localbov != null) {
          localHashSet.add(localbov.kNn);
        }
      }
      localObject = (dcc)localdcg.HKI.get(0);
      if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aer(((dcc)localObject).duQ)))
      {
        localdcg.index = 0;
        a(parambou, (dcc)localObject, localdcg.GLJ);
      }
      for (boolean bool2 = false;; bool2 = false)
      {
        localObject = new dce();
        ((dce)localObject).index = localdcg.index;
        ((dce)localObject).HKF = bool2;
        ((dce)localObject).GLJ = localdcg.GLJ;
        ((dce)localObject).dAa = parambou.dAa;
        ((dce)localObject).sDg = localdcg.sDg;
        ((dce)localObject).GLI = localdcg.GLI;
        localHashMap.put(Long.valueOf(localdcg.GLJ), localObject);
        break;
        localdcg.index = -1;
      }
      a.h(localHashSet);
      AppMethodBeat.o(122248);
      return localHashMap;
    }
  }
  
  static Map<Long, List<dce>> a(Map<String, List<bou>> paramMap, cie paramcie)
  {
    AppMethodBeat.i(196154);
    ae.i("HABBYGE-MALI.HellSessionReport", "filter, filterBySessionPageCloudConfig: %d", new Object[] { Integer.valueOf(paramMap.size()) });
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator1 = paramMap.entrySet().iterator();
    Object localObject2;
    String str;
    Object localObject1;
    bou localbou;
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
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(str);
            paramMap = (Map<String, List<bou>>)localObject1;
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric((String)localObject1)) {
              paramMap = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afD(str);
            }
          } while (paramMap == null);
          localList = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afL(paramMap);
        } while ((localList == null) || (localList.isEmpty()));
        localIterator2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
      }
      localbou = (bou)localIterator2.next();
      paramMap = a(localbou, localList);
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
        localObject2 = (dce)paramMap.getValue();
        if (localHashMap2.containsKey(Long.valueOf(l)))
        {
          paramMap = (dce)localHashMap2.get(Long.valueOf(l));
          localObject1 = paramMap;
          if (paramMap == null)
          {
            localObject1 = new dce();
            ((dce)localObject1).index = ((dce)localObject2).index;
            ((dce)localObject1).GLI = ((dce)localObject2).GLI;
            ((dce)localObject1).sDg = ((dce)localObject2).sDg;
            ((dce)localObject1).GLJ = l;
            ((dce)localObject1).dAa = str;
            localHashMap2.put(Long.valueOf(l), localObject1);
          }
          ((dce)localObject1).HKG.add(localbou);
          if (((dce)localObject2).index < 0)
          {
            if (((dce)localObject2).HKF)
            {
              if (!localHashMap1.containsKey(Long.valueOf(l))) {
                break label463;
              }
              localObject2 = (List)localHashMap1.get(Long.valueOf(l));
              paramMap = (Map<String, List<bou>>)localObject2;
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
          if (((dce)localObject2).index == 0)
          {
            ((dce)localObject1).HKG.clear();
            ((dce)localObject1).HKG.add(localbou);
            continue;
          }
          if (((dce)localObject1).HKG.isEmpty()) {
            break label886;
          }
          paramMap = (bou)((dce)localObject1).HKG.get(((dce)localObject1).HKG.size() - 1);
          if ((!localbou.duQ.equals(paramMap.duQ)) || (localbou.startTime != paramMap.startTime)) {
            break label886;
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label889;
        }
        ((dce)localObject1).HKG.add(localbou);
        break label206;
        if (((dce)localObject2).index >= 0)
        {
          paramMap = new dce();
          paramMap.index = ((dce)localObject2).index;
          paramMap.GLI = ((dce)localObject2).GLI;
          paramMap.sDg = ((dce)localObject2).sDg;
          paramMap.GLJ = l;
          paramMap.dAa = str;
          paramMap.HKG.add(localbou);
          localHashMap2.put(Long.valueOf(l), paramMap);
          break label206;
        }
        if (!((dce)localObject2).HKF) {
          break label206;
        }
        if (localHashMap1.containsKey(Long.valueOf(l)))
        {
          localObject1 = (List)localHashMap1.get(Long.valueOf(l));
          paramMap = (Map<String, List<bou>>)localObject1;
          if (localObject1 != null) {}
        }
        for (paramMap = new ArrayList();; paramMap = new ArrayList())
        {
          localObject1 = new dce();
          ((dce)localObject1).index = ((dce)localObject2).index;
          ((dce)localObject1).GLI = ((dce)localObject2).GLI;
          ((dce)localObject1).sDg = ((dce)localObject2).sDg;
          ((dce)localObject1).GLJ = l;
          ((dce)localObject1).dAa = str;
          ((dce)localObject1).HKG.add(localbou);
          paramMap.add(localObject1);
          localHashMap1.put(Long.valueOf(l), paramMap);
          break label206;
          break;
        }
        ae.i("HABBYGE-MALI.HellSessionReport", "filterBySessionPageCloudConfig, end: %d, %d", new Object[] { Integer.valueOf(localHashMap2.size()), Integer.valueOf(localHashMap1.size()) });
        if ((!localHashMap2.isEmpty()) && (paramcie != null)) {
          k.j(localHashMap2, paramcie.sessionId);
        }
        AppMethodBeat.o(196154);
        return localHashMap1;
      }
    }
  }
  
  private static void a(bou parambou, dcc paramdcc, long paramLong)
  {
    AppMethodBeat.i(196155);
    parambou = parambou.GLD.iterator();
    while (parambou.hasNext())
    {
      dwx localdwx = (dwx)parambou.next();
      if (localdwx != null)
      {
        btk localbtk = new btk();
        localbtk.GbU = paramLong;
        Iterator localIterator = paramdcc.HKD.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (dwy)localIterator.next();
          if ((localObject != null) && ((((dwy)localObject).aQj.equals(localdwx.id)) || (((dwy)localObject).Icn.equals(localdwx.Icn))) && (g.fW(localdwx.Ico, ((dwy)localObject).Ict)))
          {
            ae.i("HABBYGE-MALI.HellSessionReport", "recordRealDataPath: id=%s, res=%s", new Object[] { localdwx.id, localdwx.Icn });
            localdwx.Ics = false;
            localObject = ((dwy)localObject).HKC.iterator();
            while (((Iterator)localObject).hasNext())
            {
              cid localcid = (cid)((Iterator)localObject).next();
              if (localcid != null) {
                localbtk.HgK.add(localcid.dGe);
              }
            }
          }
        }
        if (!localbtk.HgK.isEmpty()) {
          localdwx.Icr.add(localbtk);
        }
      }
    }
    AppMethodBeat.o(196155);
  }
  
  static void ad(Map<Long, List<dce>> paramMap)
  {
    AppMethodBeat.i(177406);
    Object localObject = k.age("mmkv_key_hellSPMatchSuche_");
    if ((localObject == null) || (((dcf)localObject).HKH.isEmpty()))
    {
      AppMethodBeat.o(177406);
      return;
    }
    Iterator localIterator = ((dcf)localObject).HKH.iterator();
    if (localIterator.hasNext())
    {
      dce localdce = (dce)localIterator.next();
      if (paramMap.containsKey(Long.valueOf(localdce.GLJ)))
      {
        List localList = (List)paramMap.get(Long.valueOf(localdce.GLJ));
        localObject = localList;
        if (localList != null) {}
      }
      for (localObject = new ArrayList();; localObject = new ArrayList())
      {
        ((List)localObject).add(localdce);
        paramMap.put(Long.valueOf(localdce.GLJ), localObject);
        break;
      }
    }
    AppMethodBeat.o(177406);
  }
  
  static boolean ar(String paramString, long paramLong)
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
  
  public static void c(bow parambow, bot parambot, cie paramcie)
  {
    AppMethodBeat.i(177403);
    if ((parambow == null) || (parambot == null))
    {
      AppMethodBeat.o(177403);
      return;
    }
    if ((parambow.Hcq.isEmpty()) && (parambow.Hco.isEmpty()))
    {
      AppMethodBeat.o(177403);
      return;
    }
    if (parambot.Hck.isEmpty())
    {
      AppMethodBeat.o(177403);
      return;
    }
    ae.i("HABBYGE-MALI.HellSessionReport", "reportWhenEvent8 BEGIN !!");
    j.a(parambot, parambow, false);
    j.a(parambow, (bou)parambot.Hck.getFirst());
    j.d(parambow, parambot, paramcie);
    AppMethodBeat.o(177403);
  }
  
  static JSONObject j(bow parambow)
  {
    AppMethodBeat.i(177405);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tbe", parambow.Hcm);
      long l = parambow.Hcn - parambow.Hcm;
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
    catch (Exception parambow)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellSessionReport", parambow, "createJSONObjectHead, crash: %s", new Object[] { parambow.getMessage() });
      AppMethodBeat.o(177405);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.i
 * JD-Core Version:    0.7.0.1
 */