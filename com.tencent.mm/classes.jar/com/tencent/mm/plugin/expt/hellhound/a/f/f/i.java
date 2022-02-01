package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.dvi;
import com.tencent.mm.protocal.protobuf.dvj;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.util.List<Lcom.tencent.mm.protocal.protobuf.cbm;>;>;
import java.util.Set;
import org.json.JSONObject;

public final class i
{
  public static Map<Long, dvi> a(cbm paramcbm, List<dvk> paramList)
  {
    AppMethodBeat.i(122248);
    HashSet localHashSet = new HashSet();
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramcbm.dMl);
    if (str == null)
    {
      AppMethodBeat.o(122248);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    dvk localdvk;
    Object localObject;
    if (paramList.hasNext())
    {
      localdvk = (dvk)paramList.next();
      localObject = (dvg)localdvk.MWr.get(localdvk.index + 1);
      if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((dvg)localObject).dMl)))
      {
        localdvk.index += 1;
        if (localdvk.index != localdvk.MWr.size() - 1) {
          break label368;
        }
        localdvk.index = -1;
      }
    }
    label368:
    for (boolean bool1 = true;; bool1 = false)
    {
      a(paramcbm, (dvg)localObject, localdvk.LPN);
      localObject = paramcbm.LPG.iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        cbn localcbn = (cbn)((Iterator)localObject).next();
        if (localcbn != null) {
          localHashSet.add(localcbn.businessId);
        }
      }
      localObject = (dvg)localdvk.MWr.get(0);
      if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((dvg)localObject).dMl)))
      {
        localdvk.index = 0;
        a(paramcbm, (dvg)localObject, localdvk.LPN);
      }
      for (boolean bool2 = false;; bool2 = false)
      {
        localObject = new dvi();
        ((dvi)localObject).index = localdvk.index;
        ((dvi)localObject).MWo = bool2;
        ((dvi)localObject).LPN = localdvk.LPN;
        ((dvi)localObject).dRM = paramcbm.dRM;
        ((dvi)localObject).vtY = localdvk.vtY;
        ((dvi)localObject).LPM = localdvk.LPM;
        localHashMap.put(Long.valueOf(localdvk.LPN), localObject);
        break;
        localdvk.index = -1;
      }
      a.h(localHashSet);
      AppMethodBeat.o(122248);
      return localHashMap;
    }
  }
  
  static Map<Long, List<dvi>> a(Map<String, List<cbm>> paramMap, cyl paramcyl)
  {
    AppMethodBeat.i(220585);
    Log.i("HABBYGE-MALI.HellSessionReport", "filter, filterBySessionPageCloudConfig: %d", new Object[] { Integer.valueOf(paramMap.size()) });
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator1 = paramMap.entrySet().iterator();
    Object localObject2;
    String str;
    Object localObject1;
    cbm localcbm;
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
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(str);
            paramMap = (Map<String, List<cbm>>)localObject1;
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric((String)localObject1)) {
              paramMap = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqo(str);
            }
          } while (paramMap == null);
          localList = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqw(paramMap);
        } while ((localList == null) || (localList.isEmpty()));
        localIterator2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
      }
      localcbm = (cbm)localIterator2.next();
      paramMap = a(localcbm, localList);
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
        localObject2 = (dvi)paramMap.getValue();
        if (localHashMap2.containsKey(Long.valueOf(l)))
        {
          paramMap = (dvi)localHashMap2.get(Long.valueOf(l));
          localObject1 = paramMap;
          if (paramMap == null)
          {
            localObject1 = new dvi();
            ((dvi)localObject1).index = ((dvi)localObject2).index;
            ((dvi)localObject1).LPM = ((dvi)localObject2).LPM;
            ((dvi)localObject1).vtY = ((dvi)localObject2).vtY;
            ((dvi)localObject1).LPN = l;
            ((dvi)localObject1).dRM = str;
            localHashMap2.put(Long.valueOf(l), localObject1);
          }
          ((dvi)localObject1).MWp.add(localcbm);
          if (((dvi)localObject2).index < 0)
          {
            if (((dvi)localObject2).MWo)
            {
              if (!localHashMap1.containsKey(Long.valueOf(l))) {
                break label463;
              }
              localObject2 = (List)localHashMap1.get(Long.valueOf(l));
              paramMap = (Map<String, List<cbm>>)localObject2;
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
          if (((dvi)localObject2).index == 0)
          {
            ((dvi)localObject1).MWp.clear();
            ((dvi)localObject1).MWp.add(localcbm);
            continue;
          }
          if (((dvi)localObject1).MWp.isEmpty()) {
            break label886;
          }
          paramMap = (cbm)((dvi)localObject1).MWp.get(((dvi)localObject1).MWp.size() - 1);
          if ((!localcbm.dMl.equals(paramMap.dMl)) || (localcbm.startTime != paramMap.startTime)) {
            break label886;
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label889;
        }
        ((dvi)localObject1).MWp.add(localcbm);
        break label206;
        if (((dvi)localObject2).index >= 0)
        {
          paramMap = new dvi();
          paramMap.index = ((dvi)localObject2).index;
          paramMap.LPM = ((dvi)localObject2).LPM;
          paramMap.vtY = ((dvi)localObject2).vtY;
          paramMap.LPN = l;
          paramMap.dRM = str;
          paramMap.MWp.add(localcbm);
          localHashMap2.put(Long.valueOf(l), paramMap);
          break label206;
        }
        if (!((dvi)localObject2).MWo) {
          break label206;
        }
        if (localHashMap1.containsKey(Long.valueOf(l)))
        {
          localObject1 = (List)localHashMap1.get(Long.valueOf(l));
          paramMap = (Map<String, List<cbm>>)localObject1;
          if (localObject1 != null) {}
        }
        for (paramMap = new ArrayList();; paramMap = new ArrayList())
        {
          localObject1 = new dvi();
          ((dvi)localObject1).index = ((dvi)localObject2).index;
          ((dvi)localObject1).LPM = ((dvi)localObject2).LPM;
          ((dvi)localObject1).vtY = ((dvi)localObject2).vtY;
          ((dvi)localObject1).LPN = l;
          ((dvi)localObject1).dRM = str;
          ((dvi)localObject1).MWp.add(localcbm);
          paramMap.add(localObject1);
          localHashMap1.put(Long.valueOf(l), paramMap);
          break label206;
          break;
        }
        Log.i("HABBYGE-MALI.HellSessionReport", "filterBySessionPageCloudConfig, end: %d, %d", new Object[] { Integer.valueOf(localHashMap2.size()), Integer.valueOf(localHashMap1.size()) });
        if ((!localHashMap2.isEmpty()) && (paramcyl != null)) {
          k.k(localHashMap2, paramcyl.sessionId);
        }
        AppMethodBeat.o(220585);
        return localHashMap1;
      }
    }
  }
  
  private static void a(cbm paramcbm, dvg paramdvg, long paramLong)
  {
    AppMethodBeat.i(220586);
    paramcbm = paramcbm.LPH.iterator();
    while (paramcbm.hasNext())
    {
      erd localerd = (erd)paramcbm.next();
      if (localerd != null)
      {
        cgd localcgd = new cgd();
        localcgd.KVX = paramLong;
        Iterator localIterator = paramdvg.MWm.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (ere)localIterator.next();
          if ((localObject != null) && ((((ere)localObject).viewId.equals(localerd.id)) || (((ere)localObject).NoL.equals(localerd.NoL))) && (g.gp(localerd.NoM, ((ere)localObject).NoR)))
          {
            Log.i("HABBYGE-MALI.HellSessionReport", "recordRealDataPath: id=%s, res=%s", new Object[] { localerd.id, localerd.NoL });
            localerd.NoQ = false;
            localObject = ((ere)localObject).MWl.iterator();
            while (((Iterator)localObject).hasNext())
            {
              cyk localcyk = (cyk)((Iterator)localObject).next();
              if (localcyk != null) {
                localcgd.MlP.add(localcyk.dataPath);
              }
            }
          }
        }
        if (!localcgd.MlP.isEmpty()) {
          localerd.NoP.add(localcgd);
        }
      }
    }
    AppMethodBeat.o(220586);
  }
  
  static void ag(Map<Long, List<dvi>> paramMap)
  {
    AppMethodBeat.i(177406);
    Object localObject = k.aqP("mmkv_key_hellSPMatchSuche_");
    if ((localObject == null) || (((dvj)localObject).MWq.isEmpty()))
    {
      AppMethodBeat.o(177406);
      return;
    }
    Iterator localIterator = ((dvj)localObject).MWq.iterator();
    if (localIterator.hasNext())
    {
      dvi localdvi = (dvi)localIterator.next();
      if (paramMap.containsKey(Long.valueOf(localdvi.LPN)))
      {
        List localList = (List)paramMap.get(Long.valueOf(localdvi.LPN));
        localObject = localList;
        if (localList != null) {}
      }
      for (localObject = new ArrayList();; localObject = new ArrayList())
      {
        ((List)localObject).add(localdvi);
        paramMap.put(Long.valueOf(localdvi.LPN), localObject);
        break;
      }
    }
    AppMethodBeat.o(177406);
  }
  
  static boolean aq(String paramString, long paramLong)
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
  
  public static void c(cbo paramcbo, cbl paramcbl, cyl paramcyl)
  {
    AppMethodBeat.i(177403);
    if ((paramcbo == null) || (paramcbl == null))
    {
      AppMethodBeat.o(177403);
      return;
    }
    if ((paramcbo.Mht.isEmpty()) && (paramcbo.Mhr.isEmpty()))
    {
      AppMethodBeat.o(177403);
      return;
    }
    if (paramcbl.Mhn.isEmpty())
    {
      AppMethodBeat.o(177403);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionReport", "reportWhenEvent8 BEGIN !!");
    j.a(paramcbl, paramcbo, false);
    j.a(paramcbo, (cbm)paramcbl.Mhn.getFirst());
    j.d(paramcbo, paramcbl, paramcyl);
    AppMethodBeat.o(177403);
  }
  
  static JSONObject j(cbo paramcbo)
  {
    AppMethodBeat.i(177405);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tbe", paramcbo.Mhp);
      long l = paramcbo.Mhq - paramcbo.Mhp;
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
    catch (Exception paramcbo)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionReport", paramcbo, "createJSONObjectHead, crash: %s", new Object[] { paramcbo.getMessage() });
      AppMethodBeat.o(177405);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.i
 * JD-Core Version:    0.7.0.1
 */