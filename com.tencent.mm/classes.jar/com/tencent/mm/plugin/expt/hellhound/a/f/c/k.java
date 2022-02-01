package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.dbi;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class k
{
  public static void a(boc paramboc)
  {
    AppMethodBeat.i(177391);
    if (TextUtils.isEmpty(paramboc.dyV))
    {
      AppMethodBeat.o(177391);
      return;
    }
    Object localObject1 = paramboc.dyV;
    dbl localdbl;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localdbl = afi("mmkv_key_hellSPMatchinghe_");
      if ((localdbl == null) || (localdbl.Hrf.isEmpty())) {
        localdbl = null;
      }
    }
    while (localdbl == null)
    {
      cqr();
      AppMethodBeat.o(177391);
      return;
      if (!((String)localObject1).equals(((dbk)localdbl.Hrf.get(0)).dyV)) {
        localdbl = null;
      }
    }
    ad.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage: %s", new Object[] { paramboc.dyV });
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(paramboc.dyV);
    if (localObject1 == null)
    {
      AppMethodBeat.o(177391);
      return;
    }
    List localList = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeP((String)localObject1);
    if ((localList == null) || (localList.isEmpty()))
    {
      cqr();
      AppMethodBeat.o(177391);
      return;
    }
    int i = localdbl.Hrf.size() - 1;
    if (i >= 0)
    {
      dbk localdbk = (dbk)localdbl.Hrf.get(i);
      Object localObject2 = null;
      Object localObject3 = localList.iterator();
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (dbm)((Iterator)localObject3).next();
      } while (((dbm)localObject1).Gsl != localdbk.Gsl);
      if (localObject1 != null) {
        if ((localdbk.index <= 0) || (localdbk.index >= ((dbm)localObject1).Hrg.size() - 1)) {
          localdbl.Hrf.remove(i);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(((boc)localdbk.Hre.getLast()).dtL);
        if (localObject3 == null)
        {
          localdbl.Hrf.remove(i);
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramboc.dtL);
          if (((String)localObject3).equals(localObject2))
          {
            ad.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage, 7Event: %s", new Object[] { localObject2 });
          }
          else
          {
            localObject3 = (dbi)((dbm)localObject1).Hrg.get(localdbk.index + 1);
            if (localObject3 == null)
            {
              localdbl.Hrf.remove(i);
            }
            else
            {
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(((dbi)localObject3).dtL);
              if (localObject3 == null)
              {
                localdbl.Hrf.remove(i);
              }
              else if (((String)localObject3).equals(localObject2))
              {
                ad.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage, real: %s", new Object[] { localObject2 });
                localdbk.Hre.addLast(paramboc);
                localdbk.index += 1;
                if (localdbk.index == ((dbm)localObject1).Hrg.size() - 1)
                {
                  localdbk.index = -1;
                  localdbk.Hrd = true;
                  ad.i("HABBYGE-MALI.SessionPageMatchingCache", "move2SuccessCache: %s, %s, %s", new Object[] { localdbk.Gsk, localdbk.dyV, Long.valueOf(localdbk.Gsl) });
                  localObject2 = afi("mmkv_key_hellSPMatchSuche_");
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = new dbl();
                  }
                  ((dbl)localObject1).Hrf.addLast(localdbk);
                  a((dbl)localObject1, "mmkv_key_hellSPMatchSuche_");
                  localdbl.Hrf.remove(i);
                }
              }
              else
              {
                ad.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage, misMatch: %s, %s", new Object[] { localObject2, localObject3 });
                localdbl.Hrf.remove(i);
                continue;
                localdbl.Hrf.remove(i);
              }
            }
          }
        }
      }
    }
    if (localdbl.Hrf.isEmpty())
    {
      cqr();
      AppMethodBeat.o(177391);
      return;
    }
    a(localdbl, "mmkv_key_hellSPMatchinghe_");
    AppMethodBeat.o(177391);
  }
  
  private static void a(dbl paramdbl, String paramString)
  {
    AppMethodBeat.i(177394);
    if (paramdbl == null)
    {
      AppMethodBeat.o(177394);
      return;
    }
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(177394);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p(paramString + i, paramdbl.toByteArray());
      AppMethodBeat.o(177394);
      return;
    }
    catch (Exception paramdbl)
    {
      ad.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", paramdbl, "SessionPageMatchingCache.write: %s", new Object[] { paramdbl.getMessage() });
      AppMethodBeat.o(177394);
    }
  }
  
  public static void a(dwc paramdwc, String paramString)
  {
    AppMethodBeat.i(210466);
    if ((paramdwc == null) || (paramString == null))
    {
      AppMethodBeat.o(210466);
      return;
    }
    a(paramdwc, paramString, afi("mmkv_key_hellSPMatchSuche_"), false);
    a(paramdwc, paramString, afi("mmkv_key_hellSPMatchinghe_"), true);
    AppMethodBeat.o(210466);
  }
  
  private static void a(dwc paramdwc, String paramString, dbl paramdbl, boolean paramBoolean)
  {
    AppMethodBeat.i(210467);
    if ((paramdbl == null) || (paramdbl.Hrf.isEmpty()))
    {
      AppMethodBeat.o(210467);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramString);
    Iterator localIterator = paramdbl.Hrf.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (dbk)localIterator.next();
      if ((localObject != null) && (!((dbk)localObject).Hre.isEmpty()))
      {
        localObject = (boc)((dbk)localObject).Hre.getLast();
        if (localObject != null)
        {
          String str = com.tencent.mm.plugin.expt.hellhound.core.b.adx(((boc)localObject).dtL);
          if ((str != null) && (str.equals(paramString)))
          {
            ((boc)localObject).Gsf.add(paramdwc);
            i = 1;
          }
        }
      }
    }
    if (i != 0)
    {
      if (paramBoolean)
      {
        a(paramdbl, "mmkv_key_hellSPMatchinghe_");
        AppMethodBeat.o(210467);
        return;
      }
      a(paramdbl, "mmkv_key_hellSPMatchSuche_");
    }
    AppMethodBeat.o(210467);
  }
  
  public static dbl afi(String paramString)
  {
    AppMethodBeat.i(177395);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(177395);
      return null;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes(paramString + i);
    if ((paramString == null) || (paramString.length <= 0))
    {
      AppMethodBeat.o(177395);
      return null;
    }
    dbl localdbl = new dbl();
    try
    {
      localdbl.parseFrom(paramString);
      AppMethodBeat.o(177395);
      return localdbl;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", paramString, "SessionPageMatchingCache.read: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(177395);
    }
    return null;
  }
  
  public static void cqr()
  {
    AppMethodBeat.i(177392);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(177392);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_key_hellSPMatchinghe_".concat(String.valueOf(i)), new byte[0]);
      AppMethodBeat.o(177392);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", localException, "SessionPageMatchingCache.reset: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(177392);
    }
  }
  
  public static void cqs()
  {
    AppMethodBeat.i(177393);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(177393);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_key_hellSPMatchSuche_".concat(String.valueOf(i)), new byte[0]);
      AppMethodBeat.o(177393);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", localException, "SessionPageMatchingCache.reset: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(177393);
    }
  }
  
  public static void j(Map<Long, dbk> paramMap, String paramString)
  {
    AppMethodBeat.i(177390);
    if ((TextUtils.isEmpty(paramString)) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(177390);
      return;
    }
    dbl localdbl = new dbl();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      dbk localdbk = (dbk)((Map.Entry)paramMap.next()).getValue();
      if ((localdbk.dyV.equals(paramString)) && (localdbk.index > 0)) {
        localdbl.Hrf.addLast(localdbk);
      }
    }
    if (localdbl.Hrf.isEmpty())
    {
      AppMethodBeat.o(177390);
      return;
    }
    a(localdbl, "mmkv_key_hellSPMatchinghe_");
    AppMethodBeat.o(177390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.k
 * JD-Core Version:    0.7.0.1
 */