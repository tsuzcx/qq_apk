package com.tencent.mm.plugin.expt.hellhound.ext.session.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.a;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.k;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.dft;
import com.tencent.mm.protocal.protobuf.eag;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.ezb;
import com.tencent.mm.protocal.protobuf.ezd;
import com.tencent.mm.protocal.protobuf.eze;
import com.tencent.mm.protocal.protobuf.ezf;
import com.tencent.mm.protocal.protobuf.fxz;
import com.tencent.mm.protocal.protobuf.fya;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.util.List<Lcom.tencent.mm.protocal.protobuf.czu;>;>;
import java.util.Set;
import org.json.JSONObject;

public final class i
{
  public static Map<Long, ezd> a(czu paramczu, List<ezf> paramList)
  {
    AppMethodBeat.i(122248);
    HashSet localHashSet = new HashSet();
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramczu.hJW);
    if (str == null)
    {
      AppMethodBeat.o(122248);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    ezf localezf;
    Object localObject;
    if (paramList.hasNext())
    {
      localezf = (ezf)paramList.next();
      localObject = (ezb)localezf.abAl.get(localezf.index + 1);
      if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aqH(((ezb)localObject).hJW)))
      {
        localezf.index += 1;
        if (localezf.index != localezf.abAl.size() - 1) {
          break label368;
        }
        localezf.index = -1;
      }
    }
    label368:
    for (boolean bool1 = true;; bool1 = false)
    {
      a(paramczu, (ezb)localObject, localezf.aajX);
      localObject = paramczu.aajQ.iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        czv localczv = (czv)((Iterator)localObject).next();
        if (localczv != null) {
          localHashSet.add(localczv.businessId);
        }
      }
      localObject = (ezb)localezf.abAl.get(0);
      if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aqH(((ezb)localObject).hJW)))
      {
        localezf.index = 0;
        a(paramczu, (ezb)localObject, localezf.aajX);
      }
      for (boolean bool2 = false;; bool2 = false)
      {
        localObject = new ezd();
        ((ezd)localObject).index = localezf.index;
        ((ezd)localObject).abAi = bool2;
        ((ezd)localObject).aajX = localezf.aajX;
        ((ezd)localObject).hQR = paramczu.hQR;
        ((ezd)localObject).lAr = localezf.lAr;
        ((ezd)localObject).aajW = localezf.aajW;
        localHashMap.put(Long.valueOf(localezf.aajX), localObject);
        break;
        localezf.index = -1;
      }
      a.o(localHashSet);
      AppMethodBeat.o(122248);
      return localHashMap;
    }
  }
  
  static Map<Long, List<ezd>> a(Map<String, List<czu>> paramMap, eah parameah)
  {
    AppMethodBeat.i(300220);
    Log.i("HABBYGE-MALI.HellSessionReport", "filter, filterBySessionPageCloudConfig: %d", new Object[] { Integer.valueOf(paramMap.size()) });
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator1 = paramMap.entrySet().iterator();
    Object localObject2;
    String str;
    Object localObject1;
    czu localczu;
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
            localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(str);
            paramMap = (Map<String, List<czu>>)localObject1;
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric((String)localObject1)) {
              paramMap = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ast(str);
            }
          } while (paramMap == null);
          localList = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asB(paramMap);
        } while ((localList == null) || (localList.isEmpty()));
        localIterator2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
      }
      localczu = (czu)localIterator2.next();
      paramMap = a(localczu, localList);
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
        localObject2 = (ezd)paramMap.getValue();
        if (localHashMap2.containsKey(Long.valueOf(l)))
        {
          paramMap = (ezd)localHashMap2.get(Long.valueOf(l));
          localObject1 = paramMap;
          if (paramMap == null)
          {
            localObject1 = new ezd();
            ((ezd)localObject1).index = ((ezd)localObject2).index;
            ((ezd)localObject1).aajW = ((ezd)localObject2).aajW;
            ((ezd)localObject1).lAr = ((ezd)localObject2).lAr;
            ((ezd)localObject1).aajX = l;
            ((ezd)localObject1).hQR = str;
            localHashMap2.put(Long.valueOf(l), localObject1);
          }
          ((ezd)localObject1).abAj.add(localczu);
          if (((ezd)localObject2).index < 0)
          {
            if (((ezd)localObject2).abAi)
            {
              if (!localHashMap1.containsKey(Long.valueOf(l))) {
                break label463;
              }
              localObject2 = (List)localHashMap1.get(Long.valueOf(l));
              paramMap = (Map<String, List<czu>>)localObject2;
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
          if (((ezd)localObject2).index == 0)
          {
            ((ezd)localObject1).abAj.clear();
            ((ezd)localObject1).abAj.add(localczu);
            continue;
          }
          if (((ezd)localObject1).abAj.isEmpty()) {
            break label886;
          }
          paramMap = (czu)((ezd)localObject1).abAj.get(((ezd)localObject1).abAj.size() - 1);
          if ((!localczu.hJW.equals(paramMap.hJW)) || (localczu.startTime != paramMap.startTime)) {
            break label886;
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label889;
        }
        ((ezd)localObject1).abAj.add(localczu);
        break label206;
        if (((ezd)localObject2).index >= 0)
        {
          paramMap = new ezd();
          paramMap.index = ((ezd)localObject2).index;
          paramMap.aajW = ((ezd)localObject2).aajW;
          paramMap.lAr = ((ezd)localObject2).lAr;
          paramMap.aajX = l;
          paramMap.hQR = str;
          paramMap.abAj.add(localczu);
          localHashMap2.put(Long.valueOf(l), paramMap);
          break label206;
        }
        if (!((ezd)localObject2).abAi) {
          break label206;
        }
        if (localHashMap1.containsKey(Long.valueOf(l)))
        {
          localObject1 = (List)localHashMap1.get(Long.valueOf(l));
          paramMap = (Map<String, List<czu>>)localObject1;
          if (localObject1 != null) {}
        }
        for (paramMap = new ArrayList();; paramMap = new ArrayList())
        {
          localObject1 = new ezd();
          ((ezd)localObject1).index = ((ezd)localObject2).index;
          ((ezd)localObject1).aajW = ((ezd)localObject2).aajW;
          ((ezd)localObject1).lAr = ((ezd)localObject2).lAr;
          ((ezd)localObject1).aajX = l;
          ((ezd)localObject1).hQR = str;
          ((ezd)localObject1).abAj.add(localczu);
          paramMap.add(localObject1);
          localHashMap1.put(Long.valueOf(l), paramMap);
          break label206;
          break;
        }
        Log.i("HABBYGE-MALI.HellSessionReport", "filterBySessionPageCloudConfig, end: %d, %d", new Object[] { Integer.valueOf(localHashMap2.size()), Integer.valueOf(localHashMap1.size()) });
        if ((!localHashMap2.isEmpty()) && (parameah != null)) {
          k.m(localHashMap2, parameah.sessionId);
        }
        AppMethodBeat.o(300220);
        return localHashMap1;
      }
    }
  }
  
  private static void a(czu paramczu, ezb paramezb, long paramLong)
  {
    AppMethodBeat.i(300223);
    paramczu = paramczu.aajR.iterator();
    while (paramczu.hasNext())
    {
      fxz localfxz = (fxz)paramczu.next();
      if (localfxz != null)
      {
        dft localdft = new dft();
        localdft.YVd = paramLong;
        Iterator localIterator = paramezb.abAg.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (fya)localIterator.next();
          if ((localObject != null) && ((((fya)localObject).viewId.equals(localfxz.id)) || (((fya)localObject).abVR.equals(localfxz.abVR))) && (g.hk(localfxz.abVS, ((fya)localObject).abVW)))
          {
            Log.i("HABBYGE-MALI.HellSessionReport", "recordRealDataPath: id=%s, res=%s", new Object[] { localfxz.id, localfxz.abVR });
            localfxz.abVV = false;
            localObject = ((fya)localObject).abAf.iterator();
            while (((Iterator)localObject).hasNext())
            {
              eag localeag = (eag)((Iterator)localObject).next();
              if (localeag != null) {
                localdft.aaLq.add(localeag.dataPath);
              }
            }
          }
        }
        if (!localdft.aaLq.isEmpty()) {
          localfxz.abVU.add(localdft);
        }
      }
    }
    AppMethodBeat.o(300223);
  }
  
  static void ai(Map<Long, List<ezd>> paramMap)
  {
    AppMethodBeat.i(177406);
    Object localObject = k.asV("mmkv_key_hellSPMatchSuche_");
    if ((localObject == null) || (((eze)localObject).abAk.isEmpty()))
    {
      AppMethodBeat.o(177406);
      return;
    }
    Iterator localIterator = ((eze)localObject).abAk.iterator();
    if (localIterator.hasNext())
    {
      ezd localezd = (ezd)localIterator.next();
      if (paramMap.containsKey(Long.valueOf(localezd.aajX)))
      {
        List localList = (List)paramMap.get(Long.valueOf(localezd.aajX));
        localObject = localList;
        if (localList != null) {}
      }
      for (localObject = new ArrayList();; localObject = new ArrayList())
      {
        ((List)localObject).add(localezd);
        paramMap.put(Long.valueOf(localezd.aajX), localObject);
        break;
      }
    }
    AppMethodBeat.o(177406);
  }
  
  static boolean az(String paramString, long paramLong)
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
  
  public static void c(czw paramczw, czt paramczt, eah parameah)
  {
    AppMethodBeat.i(177403);
    if ((paramczw == null) || (paramczt == null))
    {
      AppMethodBeat.o(177403);
      return;
    }
    if ((paramczw.aaFo.isEmpty()) && (paramczw.aaFn.isEmpty()))
    {
      AppMethodBeat.o(177403);
      return;
    }
    if (paramczt.aaFj.isEmpty())
    {
      AppMethodBeat.o(177403);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionReport", "reportWhenEvent8 BEGIN !!");
    j.a(paramczt, paramczw, false);
    j.a(paramczw, (czu)paramczt.aaFj.getFirst());
    j.d(paramczw, paramczt, parameah);
    AppMethodBeat.o(177403);
  }
  
  static JSONObject j(czw paramczw)
  {
    AppMethodBeat.i(177405);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tbe", paramczw.aaFl);
      long l = paramczw.aaFm - paramczw.aaFl;
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
    catch (Exception paramczw)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionReport", paramczw, "createJSONObjectHead, crash: %s", new Object[] { paramczw.getMessage() });
      AppMethodBeat.o(177405);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.e.i
 * JD-Core Version:    0.7.0.1
 */