package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.coz;
import com.tencent.mm.protocal.protobuf.dhw;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.efi;
import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.protocal.protobuf.efl;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.protocal.protobuf.fbo;
import com.tencent.mm.protocal.protobuf.fbp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.util.List<Lcom.tencent.mm.protocal.protobuf.cjp;>;>;
import java.util.Set;
import org.json.JSONObject;

public final class i
{
  static void Y(Map<Long, List<efk>> paramMap)
  {
    AppMethodBeat.i(177406);
    Object localObject = k.ayQ("mmkv_key_hellSPMatchSuche_");
    if ((localObject == null) || (((efl)localObject).UiL.isEmpty()))
    {
      AppMethodBeat.o(177406);
      return;
    }
    Iterator localIterator = ((efl)localObject).UiL.iterator();
    if (localIterator.hasNext())
    {
      efk localefk = (efk)localIterator.next();
      if (paramMap.containsKey(Long.valueOf(localefk.SYb)))
      {
        List localList = (List)paramMap.get(Long.valueOf(localefk.SYb));
        localObject = localList;
        if (localList != null) {}
      }
      for (localObject = new ArrayList();; localObject = new ArrayList())
      {
        ((List)localObject).add(localefk);
        paramMap.put(Long.valueOf(localefk.SYb), localObject);
        break;
      }
    }
    AppMethodBeat.o(177406);
  }
  
  public static Map<Long, efk> a(cjp paramcjp, List<efm> paramList)
  {
    AppMethodBeat.i(122248);
    HashSet localHashSet = new HashSet();
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramcjp.fFe);
    if (str == null)
    {
      AppMethodBeat.o(122248);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    efm localefm;
    Object localObject;
    if (paramList.hasNext())
    {
      localefm = (efm)paramList.next();
      localObject = (efi)localefm.UiM.get(localefm.index + 1);
      if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.awD(((efi)localObject).fFe)))
      {
        localefm.index += 1;
        if (localefm.index != localefm.UiM.size() - 1) {
          break label368;
        }
        localefm.index = -1;
      }
    }
    label368:
    for (boolean bool1 = true;; bool1 = false)
    {
      a(paramcjp, (efi)localObject, localefm.SYb);
      localObject = paramcjp.SXU.iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        cjq localcjq = (cjq)((Iterator)localObject).next();
        if (localcjq != null) {
          localHashSet.add(localcjq.businessId);
        }
      }
      localObject = (efi)localefm.UiM.get(0);
      if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.awD(((efi)localObject).fFe)))
      {
        localefm.index = 0;
        a(paramcjp, (efi)localObject, localefm.SYb);
      }
      for (boolean bool2 = false;; bool2 = false)
      {
        localObject = new efk();
        ((efk)localObject).index = localefm.index;
        ((efk)localObject).UiJ = bool2;
        ((efk)localObject).SYb = localefm.SYb;
        ((efk)localObject).fLj = paramcjp.fLj;
        ((efk)localObject).Aaj = localefm.Aaj;
        ((efk)localObject).SYa = localefm.SYa;
        localHashMap.put(Long.valueOf(localefm.SYb), localObject);
        break;
        localefm.index = -1;
      }
      a.h(localHashSet);
      AppMethodBeat.o(122248);
      return localHashMap;
    }
  }
  
  static Map<Long, List<efk>> a(Map<String, List<cjp>> paramMap, dhx paramdhx)
  {
    AppMethodBeat.i(251459);
    Log.i("HABBYGE-MALI.HellSessionReport", "filter, filterBySessionPageCloudConfig: %d", new Object[] { Integer.valueOf(paramMap.size()) });
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator1 = paramMap.entrySet().iterator();
    Object localObject2;
    String str;
    Object localObject1;
    cjp localcjp;
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
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(str);
            paramMap = (Map<String, List<cjp>>)localObject1;
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric((String)localObject1)) {
              paramMap = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayo(str);
            }
          } while (paramMap == null);
          localList = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayw(paramMap);
        } while ((localList == null) || (localList.isEmpty()));
        localIterator2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
      }
      localcjp = (cjp)localIterator2.next();
      paramMap = a(localcjp, localList);
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
        localObject2 = (efk)paramMap.getValue();
        if (localHashMap2.containsKey(Long.valueOf(l)))
        {
          paramMap = (efk)localHashMap2.get(Long.valueOf(l));
          localObject1 = paramMap;
          if (paramMap == null)
          {
            localObject1 = new efk();
            ((efk)localObject1).index = ((efk)localObject2).index;
            ((efk)localObject1).SYa = ((efk)localObject2).SYa;
            ((efk)localObject1).Aaj = ((efk)localObject2).Aaj;
            ((efk)localObject1).SYb = l;
            ((efk)localObject1).fLj = str;
            localHashMap2.put(Long.valueOf(l), localObject1);
          }
          ((efk)localObject1).UiK.add(localcjp);
          if (((efk)localObject2).index < 0)
          {
            if (((efk)localObject2).UiJ)
            {
              if (!localHashMap1.containsKey(Long.valueOf(l))) {
                break label463;
              }
              localObject2 = (List)localHashMap1.get(Long.valueOf(l));
              paramMap = (Map<String, List<cjp>>)localObject2;
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
          if (((efk)localObject2).index == 0)
          {
            ((efk)localObject1).UiK.clear();
            ((efk)localObject1).UiK.add(localcjp);
            continue;
          }
          if (((efk)localObject1).UiK.isEmpty()) {
            break label886;
          }
          paramMap = (cjp)((efk)localObject1).UiK.get(((efk)localObject1).UiK.size() - 1);
          if ((!localcjp.fFe.equals(paramMap.fFe)) || (localcjp.startTime != paramMap.startTime)) {
            break label886;
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label889;
        }
        ((efk)localObject1).UiK.add(localcjp);
        break label206;
        if (((efk)localObject2).index >= 0)
        {
          paramMap = new efk();
          paramMap.index = ((efk)localObject2).index;
          paramMap.SYa = ((efk)localObject2).SYa;
          paramMap.Aaj = ((efk)localObject2).Aaj;
          paramMap.SYb = l;
          paramMap.fLj = str;
          paramMap.UiK.add(localcjp);
          localHashMap2.put(Long.valueOf(l), paramMap);
          break label206;
        }
        if (!((efk)localObject2).UiJ) {
          break label206;
        }
        if (localHashMap1.containsKey(Long.valueOf(l)))
        {
          localObject1 = (List)localHashMap1.get(Long.valueOf(l));
          paramMap = (Map<String, List<cjp>>)localObject1;
          if (localObject1 != null) {}
        }
        for (paramMap = new ArrayList();; paramMap = new ArrayList())
        {
          localObject1 = new efk();
          ((efk)localObject1).index = ((efk)localObject2).index;
          ((efk)localObject1).SYa = ((efk)localObject2).SYa;
          ((efk)localObject1).Aaj = ((efk)localObject2).Aaj;
          ((efk)localObject1).SYb = l;
          ((efk)localObject1).fLj = str;
          ((efk)localObject1).UiK.add(localcjp);
          paramMap.add(localObject1);
          localHashMap1.put(Long.valueOf(l), paramMap);
          break label206;
          break;
        }
        Log.i("HABBYGE-MALI.HellSessionReport", "filterBySessionPageCloudConfig, end: %d, %d", new Object[] { Integer.valueOf(localHashMap2.size()), Integer.valueOf(localHashMap1.size()) });
        if ((!localHashMap2.isEmpty()) && (paramdhx != null)) {
          k.k(localHashMap2, paramdhx.sessionId);
        }
        AppMethodBeat.o(251459);
        return localHashMap1;
      }
    }
  }
  
  private static void a(cjp paramcjp, efi paramefi, long paramLong)
  {
    AppMethodBeat.i(251462);
    paramcjp = paramcjp.SXV.iterator();
    while (paramcjp.hasNext())
    {
      fbo localfbo = (fbo)paramcjp.next();
      if (localfbo != null)
      {
        coz localcoz = new coz();
        localcoz.RXl = paramLong;
        Iterator localIterator = paramefi.UiH.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (fbp)localIterator.next();
          if ((localObject != null) && ((((fbp)localObject).viewId.equals(localfbo.id)) || (((fbp)localObject).UBI.equals(localfbo.UBI))) && (g.gD(localfbo.UBJ, ((fbp)localObject).UBN)))
          {
            Log.i("HABBYGE-MALI.HellSessionReport", "recordRealDataPath: id=%s, res=%s", new Object[] { localfbo.id, localfbo.UBI });
            localfbo.UBM = false;
            localObject = ((fbp)localObject).UiG.iterator();
            while (((Iterator)localObject).hasNext())
            {
              dhw localdhw = (dhw)((Iterator)localObject).next();
              if (localdhw != null) {
                localcoz.TwJ.add(localdhw.dataPath);
              }
            }
          }
        }
        if (!localcoz.TwJ.isEmpty()) {
          localfbo.UBL.add(localcoz);
        }
      }
    }
    AppMethodBeat.o(251462);
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
  
  public static void c(cjr paramcjr, cjo paramcjo, dhx paramdhx)
  {
    AppMethodBeat.i(177403);
    if ((paramcjr == null) || (paramcjo == null))
    {
      AppMethodBeat.o(177403);
      return;
    }
    if ((paramcjr.Trg.isEmpty()) && (paramcjr.Trf.isEmpty()))
    {
      AppMethodBeat.o(177403);
      return;
    }
    if (paramcjo.Trb.isEmpty())
    {
      AppMethodBeat.o(177403);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionReport", "reportWhenEvent8 BEGIN !!");
    j.a(paramcjo, paramcjr, false);
    j.a(paramcjr, (cjp)paramcjo.Trb.getFirst());
    j.d(paramcjr, paramcjo, paramdhx);
    AppMethodBeat.o(177403);
  }
  
  static JSONObject j(cjr paramcjr)
  {
    AppMethodBeat.i(177405);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tbe", paramcjr.Trd);
      long l = paramcjr.Tre - paramcjr.Trd;
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
    catch (Exception paramcjr)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionReport", paramcjr, "createJSONObjectHead, crash: %s", new Object[] { paramcjr.getMessage() });
      AppMethodBeat.o(177405);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.i
 * JD-Core Version:    0.7.0.1
 */