package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.dvi;
import com.tencent.mm.protocal.protobuf.dvj;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class k
{
  public static void a(cbm paramcbm)
  {
    AppMethodBeat.i(177391);
    if (TextUtils.isEmpty(paramcbm.dRM))
    {
      AppMethodBeat.o(177391);
      return;
    }
    Object localObject1 = paramcbm.dRM;
    dvj localdvj;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localdvj = aqP("mmkv_key_hellSPMatchinghe_");
      if ((localdvj == null) || (localdvj.MWq.isEmpty())) {
        localdvj = null;
      }
    }
    while (localdvj == null)
    {
      cQB();
      AppMethodBeat.o(177391);
      return;
      if (!((String)localObject1).equals(((dvi)localdvj.MWq.get(0)).dRM)) {
        localdvj = null;
      }
    }
    Log.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage: %s", new Object[] { paramcbm.dRM });
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(paramcbm.dRM);
    if (localObject1 == null)
    {
      AppMethodBeat.o(177391);
      return;
    }
    List localList = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqw((String)localObject1);
    if ((localList == null) || (localList.isEmpty()))
    {
      cQB();
      AppMethodBeat.o(177391);
      return;
    }
    int i = localdvj.MWq.size() - 1;
    if (i >= 0)
    {
      dvi localdvi = (dvi)localdvj.MWq.get(i);
      Object localObject2 = null;
      Object localObject3 = localList.iterator();
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (dvk)((Iterator)localObject3).next();
      } while (((dvk)localObject1).LPN != localdvi.LPN);
      if (localObject1 != null) {
        if ((localdvi.index <= 0) || (localdvi.index >= ((dvk)localObject1).MWr.size() - 1)) {
          localdvj.MWq.remove(i);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((cbm)localdvi.MWp.getLast()).dMl);
        if (localObject3 == null)
        {
          localdvj.MWq.remove(i);
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramcbm.dMl);
          if (((String)localObject3).equals(localObject2))
          {
            Log.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage, 7Event: %s", new Object[] { localObject2 });
          }
          else
          {
            localObject3 = (dvg)((dvk)localObject1).MWr.get(localdvi.index + 1);
            if (localObject3 == null)
            {
              localdvj.MWq.remove(i);
            }
            else
            {
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((dvg)localObject3).dMl);
              if (localObject3 == null)
              {
                localdvj.MWq.remove(i);
              }
              else if (((String)localObject3).equals(localObject2))
              {
                Log.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage, real: %s", new Object[] { localObject2 });
                localdvi.MWp.addLast(paramcbm);
                localdvi.index += 1;
                if (localdvi.index == ((dvk)localObject1).MWr.size() - 1)
                {
                  localdvi.index = -1;
                  localdvi.MWo = true;
                  Log.i("HABBYGE-MALI.SessionPageMatchingCache", "move2SuccessCache: %s, %s, %s", new Object[] { localdvi.LPM, localdvi.dRM, Long.valueOf(localdvi.LPN) });
                  localObject2 = aqP("mmkv_key_hellSPMatchSuche_");
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = new dvj();
                  }
                  ((dvj)localObject1).MWq.addLast(localdvi);
                  a((dvj)localObject1, "mmkv_key_hellSPMatchSuche_");
                  localdvj.MWq.remove(i);
                }
              }
              else
              {
                Log.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage, misMatch: %s, %s", new Object[] { localObject2, localObject3 });
                localdvj.MWq.remove(i);
                continue;
                localdvj.MWq.remove(i);
              }
            }
          }
        }
      }
    }
    if (localdvj.MWq.isEmpty())
    {
      cQB();
      AppMethodBeat.o(177391);
      return;
    }
    a(localdvj, "mmkv_key_hellSPMatchinghe_");
    AppMethodBeat.o(177391);
  }
  
  private static void a(dvj paramdvj, String paramString)
  {
    AppMethodBeat.i(177394);
    if (paramdvj == null)
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
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o(paramString + i, paramdvj.toByteArray());
      AppMethodBeat.o(177394);
      return;
    }
    catch (Exception paramdvj)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", paramdvj, "SessionPageMatchingCache.write: %s", new Object[] { paramdvj.getMessage() });
      AppMethodBeat.o(177394);
    }
  }
  
  public static void a(erd paramerd, String paramString)
  {
    AppMethodBeat.i(220564);
    if ((paramerd == null) || (paramString == null))
    {
      AppMethodBeat.o(220564);
      return;
    }
    a(paramerd, paramString, aqP("mmkv_key_hellSPMatchSuche_"), false);
    a(paramerd, paramString, aqP("mmkv_key_hellSPMatchinghe_"), true);
    AppMethodBeat.o(220564);
  }
  
  private static void a(erd paramerd, String paramString, dvj paramdvj, boolean paramBoolean)
  {
    AppMethodBeat.i(220565);
    if ((paramdvj == null) || (paramdvj.MWq.isEmpty()))
    {
      AppMethodBeat.o(220565);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString);
    Iterator localIterator = paramdvj.MWq.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (dvi)localIterator.next();
      if ((localObject != null) && (!((dvi)localObject).MWp.isEmpty()))
      {
        localObject = (cbm)((dvi)localObject).MWp.getLast();
        if (localObject != null)
        {
          String str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((cbm)localObject).dMl);
          if ((str != null) && (str.equals(paramString)))
          {
            ((cbm)localObject).LPH.add(paramerd);
            i = 1;
          }
        }
      }
    }
    if (i != 0)
    {
      if (paramBoolean)
      {
        a(paramdvj, "mmkv_key_hellSPMatchinghe_");
        AppMethodBeat.o(220565);
        return;
      }
      a(paramdvj, "mmkv_key_hellSPMatchSuche_");
    }
    AppMethodBeat.o(220565);
  }
  
  public static dvj aqP(String paramString)
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
    dvj localdvj = new dvj();
    try
    {
      localdvj.parseFrom(paramString);
      AppMethodBeat.o(177395);
      return localdvj;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", paramString, "SessionPageMatchingCache.read: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(177395);
    }
    return null;
  }
  
  public static void cQB()
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
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hellSPMatchinghe_".concat(String.valueOf(i)), new byte[0]);
      AppMethodBeat.o(177392);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", localException, "SessionPageMatchingCache.reset: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(177392);
    }
  }
  
  public static void cQC()
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
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hellSPMatchSuche_".concat(String.valueOf(i)), new byte[0]);
      AppMethodBeat.o(177393);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", localException, "SessionPageMatchingCache.reset: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(177393);
    }
  }
  
  public static void k(Map<Long, dvi> paramMap, String paramString)
  {
    AppMethodBeat.i(177390);
    if ((TextUtils.isEmpty(paramString)) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(177390);
      return;
    }
    dvj localdvj = new dvj();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      dvi localdvi = (dvi)((Map.Entry)paramMap.next()).getValue();
      if ((localdvi.dRM.equals(paramString)) && (localdvi.index > 0)) {
        localdvj.MWq.addLast(localdvi);
      }
    }
    if (localdvj.MWq.isEmpty())
    {
      AppMethodBeat.o(177390);
      return;
    }
    a(localdvj, "mmkv_key_hellSPMatchinghe_");
    AppMethodBeat.o(177390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.k
 * JD-Core Version:    0.7.0.1
 */