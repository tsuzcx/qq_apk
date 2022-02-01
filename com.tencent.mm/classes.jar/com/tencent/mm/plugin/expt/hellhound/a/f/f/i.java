package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.bod;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dbi;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.util.List<Lcom.tencent.mm.protocal.protobuf.boc;>;>;
import java.util.Set;
import org.json.JSONObject;

public final class i
{
  static void X(Map<Long, List<dbk>> paramMap)
  {
    AppMethodBeat.i(177406);
    Object localObject = k.afi("mmkv_key_hellSPMatchSuche_");
    if ((localObject == null) || (((dbl)localObject).Hrf.isEmpty()))
    {
      AppMethodBeat.o(177406);
      return;
    }
    Iterator localIterator = ((dbl)localObject).Hrf.iterator();
    if (localIterator.hasNext())
    {
      dbk localdbk = (dbk)localIterator.next();
      if (paramMap.containsKey(Long.valueOf(localdbk.Gsl)))
      {
        List localList = (List)paramMap.get(Long.valueOf(localdbk.Gsl));
        localObject = localList;
        if (localList != null) {}
      }
      for (localObject = new ArrayList();; localObject = new ArrayList())
      {
        ((List)localObject).add(localdbk);
        paramMap.put(Long.valueOf(localdbk.Gsl), localObject);
        break;
      }
    }
    AppMethodBeat.o(177406);
  }
  
  public static Map<Long, dbk> a(boc paramboc, List<dbm> paramList)
  {
    AppMethodBeat.i(122248);
    HashSet localHashSet = new HashSet();
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramboc.dtL);
    if (str == null)
    {
      AppMethodBeat.o(122248);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    dbm localdbm;
    Object localObject;
    if (paramList.hasNext())
    {
      localdbm = (dbm)paramList.next();
      localObject = (dbi)localdbm.Hrg.get(localdbm.index + 1);
      if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.adx(((dbi)localObject).dtL)))
      {
        localdbm.index += 1;
        if (localdbm.index != localdbm.Hrg.size() - 1) {
          break label368;
        }
        localdbm.index = -1;
      }
    }
    label368:
    for (boolean bool1 = true;; bool1 = false)
    {
      a(paramboc, (dbi)localObject, localdbm.Gsl);
      localObject = paramboc.Gse.iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        bod localbod = (bod)((Iterator)localObject).next();
        if (localbod != null) {
          localHashSet.add(localbod.kJY);
        }
      }
      localObject = (dbi)localdbm.Hrg.get(0);
      if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.adx(((dbi)localObject).dtL)))
      {
        localdbm.index = 0;
        a(paramboc, (dbi)localObject, localdbm.Gsl);
      }
      for (boolean bool2 = false;; bool2 = false)
      {
        localObject = new dbk();
        ((dbk)localObject).index = localdbm.index;
        ((dbk)localObject).Hrd = bool2;
        ((dbk)localObject).Gsl = localdbm.Gsl;
        ((dbk)localObject).dyV = paramboc.dyV;
        ((dbk)localObject).ssW = localdbm.ssW;
        ((dbk)localObject).Gsk = localdbm.Gsk;
        localHashMap.put(Long.valueOf(localdbm.Gsl), localObject);
        break;
        localdbm.index = -1;
      }
      a.h(localHashSet);
      AppMethodBeat.o(122248);
      return localHashMap;
    }
  }
  
  static Map<Long, List<dbk>> a(Map<String, List<boc>> paramMap, chk paramchk)
  {
    AppMethodBeat.i(210487);
    ad.i("HABBYGE-MALI.HellSessionReport", "filter, filterBySessionPageCloudConfig: %d", new Object[] { Integer.valueOf(paramMap.size()) });
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator1 = paramMap.entrySet().iterator();
    Object localObject2;
    String str;
    Object localObject1;
    boc localboc;
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
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(str);
            paramMap = (Map<String, List<boc>>)localObject1;
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric((String)localObject1)) {
              paramMap = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeH(str);
            }
          } while (paramMap == null);
          localList = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeP(paramMap);
        } while ((localList == null) || (localList.isEmpty()));
        localIterator2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
      }
      localboc = (boc)localIterator2.next();
      paramMap = a(localboc, localList);
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
        localObject2 = (dbk)paramMap.getValue();
        if (localHashMap2.containsKey(Long.valueOf(l)))
        {
          paramMap = (dbk)localHashMap2.get(Long.valueOf(l));
          localObject1 = paramMap;
          if (paramMap == null)
          {
            localObject1 = new dbk();
            ((dbk)localObject1).index = ((dbk)localObject2).index;
            ((dbk)localObject1).Gsk = ((dbk)localObject2).Gsk;
            ((dbk)localObject1).ssW = ((dbk)localObject2).ssW;
            ((dbk)localObject1).Gsl = l;
            ((dbk)localObject1).dyV = str;
            localHashMap2.put(Long.valueOf(l), localObject1);
          }
          ((dbk)localObject1).Hre.add(localboc);
          if (((dbk)localObject2).index < 0)
          {
            if (((dbk)localObject2).Hrd)
            {
              if (!localHashMap1.containsKey(Long.valueOf(l))) {
                break label463;
              }
              localObject2 = (List)localHashMap1.get(Long.valueOf(l));
              paramMap = (Map<String, List<boc>>)localObject2;
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
          if (((dbk)localObject2).index == 0)
          {
            ((dbk)localObject1).Hre.clear();
            ((dbk)localObject1).Hre.add(localboc);
            continue;
          }
          if (((dbk)localObject1).Hre.isEmpty()) {
            break label886;
          }
          paramMap = (boc)((dbk)localObject1).Hre.get(((dbk)localObject1).Hre.size() - 1);
          if ((!localboc.dtL.equals(paramMap.dtL)) || (localboc.startTime != paramMap.startTime)) {
            break label886;
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label889;
        }
        ((dbk)localObject1).Hre.add(localboc);
        break label206;
        if (((dbk)localObject2).index >= 0)
        {
          paramMap = new dbk();
          paramMap.index = ((dbk)localObject2).index;
          paramMap.Gsk = ((dbk)localObject2).Gsk;
          paramMap.ssW = ((dbk)localObject2).ssW;
          paramMap.Gsl = l;
          paramMap.dyV = str;
          paramMap.Hre.add(localboc);
          localHashMap2.put(Long.valueOf(l), paramMap);
          break label206;
        }
        if (!((dbk)localObject2).Hrd) {
          break label206;
        }
        if (localHashMap1.containsKey(Long.valueOf(l)))
        {
          localObject1 = (List)localHashMap1.get(Long.valueOf(l));
          paramMap = (Map<String, List<boc>>)localObject1;
          if (localObject1 != null) {}
        }
        for (paramMap = new ArrayList();; paramMap = new ArrayList())
        {
          localObject1 = new dbk();
          ((dbk)localObject1).index = ((dbk)localObject2).index;
          ((dbk)localObject1).Gsk = ((dbk)localObject2).Gsk;
          ((dbk)localObject1).ssW = ((dbk)localObject2).ssW;
          ((dbk)localObject1).Gsl = l;
          ((dbk)localObject1).dyV = str;
          ((dbk)localObject1).Hre.add(localboc);
          paramMap.add(localObject1);
          localHashMap1.put(Long.valueOf(l), paramMap);
          break label206;
          break;
        }
        ad.i("HABBYGE-MALI.HellSessionReport", "filterBySessionPageCloudConfig, end: %d, %d", new Object[] { Integer.valueOf(localHashMap2.size()), Integer.valueOf(localHashMap1.size()) });
        if ((!localHashMap2.isEmpty()) && (paramchk != null)) {
          k.j(localHashMap2, paramchk.sessionId);
        }
        AppMethodBeat.o(210487);
        return localHashMap1;
      }
    }
  }
  
  private static void a(boc paramboc, dbi paramdbi, long paramLong)
  {
    AppMethodBeat.i(210488);
    paramboc = paramboc.Gsf.iterator();
    while (paramboc.hasNext())
    {
      dwc localdwc = (dwc)paramboc.next();
      if (localdwc != null)
      {
        bsq localbsq = new bsq();
        localbsq.FJv = paramLong;
        Iterator localIterator = paramdbi.Hrb.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (dwd)localIterator.next();
          if ((localObject != null) && ((((dwd)localObject).aQj.equals(localdwc.id)) || (((dwd)localObject).HIB.equals(localdwc.HIB))) && (g.fR(localdwc.HIC, ((dwd)localObject).HIH)))
          {
            ad.i("HABBYGE-MALI.HellSessionReport", "recordRealDataPath: id=%s, res=%s", new Object[] { localdwc.id, localdwc.HIB });
            localdwc.HIG = false;
            localObject = ((dwd)localObject).Hra.iterator();
            while (((Iterator)localObject).hasNext())
            {
              chj localchj = (chj)((Iterator)localObject).next();
              if (localchj != null) {
                localbsq.GNk.add(localchj.dEZ);
              }
            }
          }
        }
        if (!localbsq.GNk.isEmpty()) {
          localdwc.HIF.add(localbsq);
        }
      }
    }
    AppMethodBeat.o(210488);
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
  
  public static void c(boe paramboe, bob parambob, chk paramchk)
  {
    AppMethodBeat.i(177403);
    if ((paramboe == null) || (parambob == null))
    {
      AppMethodBeat.o(177403);
      return;
    }
    if ((paramboe.GIO.isEmpty()) && (paramboe.GIM.isEmpty()))
    {
      AppMethodBeat.o(177403);
      return;
    }
    if (parambob.GII.isEmpty())
    {
      AppMethodBeat.o(177403);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionReport", "reportWhenEvent8 BEGIN !!");
    j.a(parambob, paramboe, false);
    j.a(paramboe, (boc)parambob.GII.getFirst());
    j.d(paramboe, parambob, paramchk);
    AppMethodBeat.o(177403);
  }
  
  static JSONObject j(boe paramboe)
  {
    AppMethodBeat.i(177405);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tbe", paramboe.GIK);
      long l = paramboe.GIL - paramboe.GIK;
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
    catch (Exception paramboe)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellSessionReport", paramboe, "createJSONObjectHead, crash: %s", new Object[] { paramboe.getMessage() });
      AppMethodBeat.o(177405);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.i
 * JD-Core Version:    0.7.0.1
 */