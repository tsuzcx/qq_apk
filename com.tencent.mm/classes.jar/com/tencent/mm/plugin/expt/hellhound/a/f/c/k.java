package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.dcc;
import com.tencent.mm.protocal.protobuf.dce;
import com.tencent.mm.protocal.protobuf.dcf;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class k
{
  public static void a(bou parambou)
  {
    AppMethodBeat.i(177391);
    if (TextUtils.isEmpty(parambou.dAa))
    {
      AppMethodBeat.o(177391);
      return;
    }
    Object localObject1 = parambou.dAa;
    dcf localdcf;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localdcf = age("mmkv_key_hellSPMatchinghe_");
      if ((localdcf == null) || (localdcf.HKH.isEmpty())) {
        localdcf = null;
      }
    }
    while (localdcf == null)
    {
      crT();
      AppMethodBeat.o(177391);
      return;
      if (!((String)localObject1).equals(((dce)localdcf.HKH.get(0)).dAa)) {
        localdcf = null;
      }
    }
    ae.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage: %s", new Object[] { parambou.dAa });
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(parambou.dAa);
    if (localObject1 == null)
    {
      AppMethodBeat.o(177391);
      return;
    }
    List localList = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afL((String)localObject1);
    if ((localList == null) || (localList.isEmpty()))
    {
      crT();
      AppMethodBeat.o(177391);
      return;
    }
    int i = localdcf.HKH.size() - 1;
    if (i >= 0)
    {
      dce localdce = (dce)localdcf.HKH.get(i);
      Object localObject2 = null;
      Object localObject3 = localList.iterator();
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (dcg)((Iterator)localObject3).next();
      } while (((dcg)localObject1).GLJ != localdce.GLJ);
      if (localObject1 != null) {
        if ((localdce.index <= 0) || (localdce.index >= ((dcg)localObject1).HKI.size() - 1)) {
          localdcf.HKH.remove(i);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(((bou)localdce.HKG.getLast()).duQ);
        if (localObject3 == null)
        {
          localdcf.HKH.remove(i);
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(parambou.duQ);
          if (((String)localObject3).equals(localObject2))
          {
            ae.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage, 7Event: %s", new Object[] { localObject2 });
          }
          else
          {
            localObject3 = (dcc)((dcg)localObject1).HKI.get(localdce.index + 1);
            if (localObject3 == null)
            {
              localdcf.HKH.remove(i);
            }
            else
            {
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(((dcc)localObject3).duQ);
              if (localObject3 == null)
              {
                localdcf.HKH.remove(i);
              }
              else if (((String)localObject3).equals(localObject2))
              {
                ae.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage, real: %s", new Object[] { localObject2 });
                localdce.HKG.addLast(parambou);
                localdce.index += 1;
                if (localdce.index == ((dcg)localObject1).HKI.size() - 1)
                {
                  localdce.index = -1;
                  localdce.HKF = true;
                  ae.i("HABBYGE-MALI.SessionPageMatchingCache", "move2SuccessCache: %s, %s, %s", new Object[] { localdce.GLI, localdce.dAa, Long.valueOf(localdce.GLJ) });
                  localObject2 = age("mmkv_key_hellSPMatchSuche_");
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = new dcf();
                  }
                  ((dcf)localObject1).HKH.addLast(localdce);
                  a((dcf)localObject1, "mmkv_key_hellSPMatchSuche_");
                  localdcf.HKH.remove(i);
                }
              }
              else
              {
                ae.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage, misMatch: %s, %s", new Object[] { localObject2, localObject3 });
                localdcf.HKH.remove(i);
                continue;
                localdcf.HKH.remove(i);
              }
            }
          }
        }
      }
    }
    if (localdcf.HKH.isEmpty())
    {
      crT();
      AppMethodBeat.o(177391);
      return;
    }
    a(localdcf, "mmkv_key_hellSPMatchinghe_");
    AppMethodBeat.o(177391);
  }
  
  private static void a(dcf paramdcf, String paramString)
  {
    AppMethodBeat.i(177394);
    if (paramdcf == null)
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
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p(paramString + i, paramdcf.toByteArray());
      AppMethodBeat.o(177394);
      return;
    }
    catch (Exception paramdcf)
    {
      ae.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", paramdcf, "SessionPageMatchingCache.write: %s", new Object[] { paramdcf.getMessage() });
      AppMethodBeat.o(177394);
    }
  }
  
  public static void a(dwx paramdwx, String paramString)
  {
    AppMethodBeat.i(196133);
    if ((paramdwx == null) || (paramString == null))
    {
      AppMethodBeat.o(196133);
      return;
    }
    a(paramdwx, paramString, age("mmkv_key_hellSPMatchSuche_"), false);
    a(paramdwx, paramString, age("mmkv_key_hellSPMatchinghe_"), true);
    AppMethodBeat.o(196133);
  }
  
  private static void a(dwx paramdwx, String paramString, dcf paramdcf, boolean paramBoolean)
  {
    AppMethodBeat.i(196134);
    if ((paramdcf == null) || (paramdcf.HKH.isEmpty()))
    {
      AppMethodBeat.o(196134);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString);
    Iterator localIterator = paramdcf.HKH.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (dce)localIterator.next();
      if ((localObject != null) && (!((dce)localObject).HKG.isEmpty()))
      {
        localObject = (bou)((dce)localObject).HKG.getLast();
        if (localObject != null)
        {
          String str = com.tencent.mm.plugin.expt.hellhound.core.b.aer(((bou)localObject).duQ);
          if ((str != null) && (str.equals(paramString)))
          {
            ((bou)localObject).GLD.add(paramdwx);
            i = 1;
          }
        }
      }
    }
    if (i != 0)
    {
      if (paramBoolean)
      {
        a(paramdcf, "mmkv_key_hellSPMatchinghe_");
        AppMethodBeat.o(196134);
        return;
      }
      a(paramdcf, "mmkv_key_hellSPMatchSuche_");
    }
    AppMethodBeat.o(196134);
  }
  
  public static dcf age(String paramString)
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
    dcf localdcf = new dcf();
    try
    {
      localdcf.parseFrom(paramString);
      AppMethodBeat.o(177395);
      return localdcf;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", paramString, "SessionPageMatchingCache.read: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(177395);
    }
    return null;
  }
  
  public static void crT()
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
      ae.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", localException, "SessionPageMatchingCache.reset: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(177392);
    }
  }
  
  public static void crU()
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
      ae.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", localException, "SessionPageMatchingCache.reset: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(177393);
    }
  }
  
  public static void j(Map<Long, dce> paramMap, String paramString)
  {
    AppMethodBeat.i(177390);
    if ((TextUtils.isEmpty(paramString)) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(177390);
      return;
    }
    dcf localdcf = new dcf();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      dce localdce = (dce)((Map.Entry)paramMap.next()).getValue();
      if ((localdce.dAa.equals(paramString)) && (localdce.index > 0)) {
        localdcf.HKH.addLast(localdce);
      }
    }
    if (localdcf.HKH.isEmpty())
    {
      AppMethodBeat.o(177390);
      return;
    }
    a(localdcf, "mmkv_key_hellSPMatchinghe_");
    AppMethodBeat.o(177390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.k
 * JD-Core Version:    0.7.0.1
 */