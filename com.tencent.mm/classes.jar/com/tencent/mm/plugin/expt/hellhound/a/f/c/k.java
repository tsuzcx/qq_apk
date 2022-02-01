package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.efi;
import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.protocal.protobuf.efl;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.protocal.protobuf.fbo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class k
{
  public static void a(cjp paramcjp)
  {
    AppMethodBeat.i(177391);
    if (TextUtils.isEmpty(paramcjp.fLj))
    {
      AppMethodBeat.o(177391);
      return;
    }
    Object localObject1 = paramcjp.fLj;
    efl localefl;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localefl = ayQ("mmkv_key_hellSPMatchinghe_");
      if ((localefl == null) || (localefl.UiL.isEmpty())) {
        localefl = null;
      }
    }
    while (localefl == null)
    {
      dfv();
      AppMethodBeat.o(177391);
      return;
      if (!((String)localObject1).equals(((efk)localefl.UiL.get(0)).fLj)) {
        localefl = null;
      }
    }
    Log.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage: %s", new Object[] { paramcjp.fLj });
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(paramcjp.fLj);
    if (localObject1 == null)
    {
      AppMethodBeat.o(177391);
      return;
    }
    List localList = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayw((String)localObject1);
    if ((localList == null) || (localList.isEmpty()))
    {
      dfv();
      AppMethodBeat.o(177391);
      return;
    }
    int i = localefl.UiL.size() - 1;
    if (i >= 0)
    {
      efk localefk = (efk)localefl.UiL.get(i);
      Object localObject2 = null;
      Object localObject3 = localList.iterator();
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (efm)((Iterator)localObject3).next();
      } while (((efm)localObject1).SYb != localefk.SYb);
      if (localObject1 != null) {
        if ((localefk.index <= 0) || (localefk.index >= ((efm)localObject1).UiM.size() - 1)) {
          localefl.UiL.remove(i);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(((cjp)localefk.UiK.getLast()).fFe);
        if (localObject3 == null)
        {
          localefl.UiL.remove(i);
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramcjp.fFe);
          if (((String)localObject3).equals(localObject2))
          {
            Log.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage, 7Event: %s", new Object[] { localObject2 });
          }
          else
          {
            localObject3 = (efi)((efm)localObject1).UiM.get(localefk.index + 1);
            if (localObject3 == null)
            {
              localefl.UiL.remove(i);
            }
            else
            {
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(((efi)localObject3).fFe);
              if (localObject3 == null)
              {
                localefl.UiL.remove(i);
              }
              else if (((String)localObject3).equals(localObject2))
              {
                Log.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage, real: %s", new Object[] { localObject2 });
                localefk.UiK.addLast(paramcjp);
                localefk.index += 1;
                if (localefk.index == ((efm)localObject1).UiM.size() - 1)
                {
                  localefk.index = -1;
                  localefk.UiJ = true;
                  Log.i("HABBYGE-MALI.SessionPageMatchingCache", "move2SuccessCache: %s, %s, %s", new Object[] { localefk.SYa, localefk.fLj, Long.valueOf(localefk.SYb) });
                  localObject2 = ayQ("mmkv_key_hellSPMatchSuche_");
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = new efl();
                  }
                  ((efl)localObject1).UiL.addLast(localefk);
                  a((efl)localObject1, "mmkv_key_hellSPMatchSuche_");
                  localefl.UiL.remove(i);
                }
              }
              else
              {
                Log.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage, misMatch: %s, %s", new Object[] { localObject2, localObject3 });
                localefl.UiL.remove(i);
                continue;
                localefl.UiL.remove(i);
              }
            }
          }
        }
      }
    }
    if (localefl.UiL.isEmpty())
    {
      dfv();
      AppMethodBeat.o(177391);
      return;
    }
    a(localefl, "mmkv_key_hellSPMatchinghe_");
    AppMethodBeat.o(177391);
  }
  
  private static void a(efl paramefl, String paramString)
  {
    AppMethodBeat.i(177394);
    if (paramefl == null)
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
      com.tencent.mm.plugin.expt.hellhound.core.a.b.r(paramString + i, paramefl.toByteArray());
      AppMethodBeat.o(177394);
      return;
    }
    catch (Exception paramefl)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", paramefl, "SessionPageMatchingCache.write: %s", new Object[] { paramefl.getMessage() });
      AppMethodBeat.o(177394);
    }
  }
  
  public static void a(fbo paramfbo, String paramString)
  {
    AppMethodBeat.i(252923);
    if ((paramfbo == null) || (paramString == null))
    {
      AppMethodBeat.o(252923);
      return;
    }
    a(paramfbo, paramString, ayQ("mmkv_key_hellSPMatchSuche_"), false);
    a(paramfbo, paramString, ayQ("mmkv_key_hellSPMatchinghe_"), true);
    AppMethodBeat.o(252923);
  }
  
  private static void a(fbo paramfbo, String paramString, efl paramefl, boolean paramBoolean)
  {
    AppMethodBeat.i(252926);
    if ((paramefl == null) || (paramefl.UiL.isEmpty()))
    {
      AppMethodBeat.o(252926);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString);
    Iterator localIterator = paramefl.UiL.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (efk)localIterator.next();
      if ((localObject != null) && (!((efk)localObject).UiK.isEmpty()))
      {
        localObject = (cjp)((efk)localObject).UiK.getLast();
        if (localObject != null)
        {
          String str = com.tencent.mm.plugin.expt.hellhound.core.b.awD(((cjp)localObject).fFe);
          if ((str != null) && (str.equals(paramString)))
          {
            ((cjp)localObject).SXV.add(paramfbo);
            i = 1;
          }
        }
      }
    }
    if (i != 0)
    {
      if (paramBoolean)
      {
        a(paramefl, "mmkv_key_hellSPMatchinghe_");
        AppMethodBeat.o(252926);
        return;
      }
      a(paramefl, "mmkv_key_hellSPMatchSuche_");
    }
    AppMethodBeat.o(252926);
  }
  
  public static efl ayQ(String paramString)
  {
    AppMethodBeat.i(177395);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(177395);
      return null;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.a.b.awZ(paramString + i);
    if ((paramString == null) || (paramString.length <= 0))
    {
      AppMethodBeat.o(177395);
      return null;
    }
    efl localefl = new efl();
    try
    {
      localefl.parseFrom(paramString);
      AppMethodBeat.o(177395);
      return localefl;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", paramString, "SessionPageMatchingCache.read: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(177395);
    }
    return null;
  }
  
  public static void dfv()
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
      com.tencent.mm.plugin.expt.hellhound.core.a.b.r("mmkv_key_hellSPMatchinghe_".concat(String.valueOf(i)), new byte[0]);
      AppMethodBeat.o(177392);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", localException, "SessionPageMatchingCache.reset: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(177392);
    }
  }
  
  public static void dfw()
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
      com.tencent.mm.plugin.expt.hellhound.core.a.b.r("mmkv_key_hellSPMatchSuche_".concat(String.valueOf(i)), new byte[0]);
      AppMethodBeat.o(177393);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", localException, "SessionPageMatchingCache.reset: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(177393);
    }
  }
  
  public static void k(Map<Long, efk> paramMap, String paramString)
  {
    AppMethodBeat.i(177390);
    if ((TextUtils.isEmpty(paramString)) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(177390);
      return;
    }
    efl localefl = new efl();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      efk localefk = (efk)((Map.Entry)paramMap.next()).getValue();
      if ((localefk.fLj.equals(paramString)) && (localefk.index > 0)) {
        localefl.UiL.addLast(localefk);
      }
    }
    if (localefl.UiL.isEmpty())
    {
      AppMethodBeat.o(177390);
      return;
    }
    a(localefl, "mmkv_key_hellSPMatchinghe_");
    AppMethodBeat.o(177390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.k
 * JD-Core Version:    0.7.0.1
 */