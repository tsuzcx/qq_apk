package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cvz;
import com.tencent.mm.protocal.protobuf.cwa;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class k
{
  public static void a(bju parambju)
  {
    AppMethodBeat.i(177391);
    if (TextUtils.isEmpty(parambju.dnh))
    {
      AppMethodBeat.o(177391);
      return;
    }
    Object localObject1 = parambju.dnh;
    cvz localcvz;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localcvz = abv("mmkv_key_hellSPMatchinghe_");
      if ((localcvz == null) || (localcvz.FGC.isEmpty())) {
        localcvz = null;
      }
    }
    while (localcvz == null)
    {
      cld();
      AppMethodBeat.o(177391);
      return;
      if (!((String)localObject1).equals(((cvy)localcvz.FGC.get(0)).dnh)) {
        localcvz = null;
      }
    }
    ac.i("SessionPageMatchingCache", "HABBYGE-MALI, SessionPageMatchingCache, addPage: %s", new Object[] { parambju.dnh });
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(parambju.dnh);
    if (localObject1 == null)
    {
      AppMethodBeat.o(177391);
      return;
    }
    List localList = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.abc((String)localObject1);
    if ((localList == null) || (localList.isEmpty()))
    {
      cld();
      AppMethodBeat.o(177391);
      return;
    }
    int i = localcvz.FGC.size() - 1;
    if (i >= 0)
    {
      cvy localcvy = (cvy)localcvz.FGC.get(i);
      Object localObject2 = null;
      Object localObject3 = localList.iterator();
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (cwa)((Iterator)localObject3).next();
      } while (((cwa)localObject1).EJj != localcvy.EJj);
      if (localObject1 != null) {
        if ((localcvy.index <= 0) || (localcvy.index >= ((cwa)localObject1).FGD.size() - 1)) {
          localcvz.FGC.remove(i);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(((bju)localcvy.FGB.getLast()).qoi);
        if (localObject3 == null)
        {
          localcvz.FGC.remove(i);
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(parambju.qoi);
          if (((String)localObject3).equals(localObject2))
          {
            ac.i("SessionPageMatchingCache", "HABBYGE-MALI, SessionPageMatchingCache, addPage, 7Event: %s", new Object[] { localObject2 });
          }
          else
          {
            localObject3 = (cvw)((cwa)localObject1).FGD.get(localcvy.index + 1);
            if (localObject3 == null)
            {
              localcvz.FGC.remove(i);
            }
            else
            {
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(((cvw)localObject3).qoi);
              if (localObject3 == null)
              {
                localcvz.FGC.remove(i);
              }
              else if (((String)localObject3).equals(localObject2))
              {
                ac.i("SessionPageMatchingCache", "HABBYGE-MALI, SessionPageMatchingCache, addPage, real: %s", new Object[] { localObject2 });
                localcvy.FGB.addLast(parambju);
                localcvy.index += 1;
                if (localcvy.index == ((cwa)localObject1).FGD.size() - 1)
                {
                  localcvy.index = -1;
                  localcvy.FGA = true;
                  ac.i("SessionPageMatchingCache", "HABBYGE-MALI, move2SuccessCache: %s, %s, %s", new Object[] { localcvy.EJi, localcvy.dnh, Long.valueOf(localcvy.EJj) });
                  localObject2 = abv("mmkv_key_hellSPMatchSuche_");
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = new cvz();
                  }
                  ((cvz)localObject1).FGC.addLast(localcvy);
                  a((cvz)localObject1, "mmkv_key_hellSPMatchSuche_");
                  localcvz.FGC.remove(i);
                }
              }
              else
              {
                ac.i("SessionPageMatchingCache", "HABBYGE-MALI, SessionPageMatchingCache, addPage, misMatch: %s, %s", new Object[] { localObject2, localObject3 });
                localcvz.FGC.remove(i);
                continue;
                localcvz.FGC.remove(i);
              }
            }
          }
        }
      }
    }
    if (localcvz.FGC.isEmpty())
    {
      cld();
      AppMethodBeat.o(177391);
      return;
    }
    a(localcvz, "mmkv_key_hellSPMatchinghe_");
    AppMethodBeat.o(177391);
  }
  
  private static void a(cvz paramcvz, String paramString)
  {
    AppMethodBeat.i(177394);
    if (paramcvz == null)
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
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o(paramString + i, paramcvz.toByteArray());
      AppMethodBeat.o(177394);
      return;
    }
    catch (Exception paramcvz)
    {
      ac.printErrStackTrace("SessionPageMatchingCache", paramcvz, "HABBYGE-MALI, SessionPageMatchingCache.write: %s", new Object[] { paramcvz.getMessage() });
      AppMethodBeat.o(177394);
    }
  }
  
  public static cvz abv(String paramString)
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
    cvz localcvz = new cvz();
    try
    {
      localcvz.parseFrom(paramString);
      AppMethodBeat.o(177395);
      return localcvz;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("SessionPageMatchingCache", paramString, "HABBYGE-MALI, SessionPageMatchingCache.read: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(177395);
    }
    return null;
  }
  
  public static void cld()
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
      ac.printErrStackTrace("SessionPageMatchingCache", localException, "HABBYGE-MALI, SessionPageMatchingCache.reset: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(177392);
    }
  }
  
  public static void cle()
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
      ac.printErrStackTrace("SessionPageMatchingCache", localException, "HABBYGE-MALI, SessionPageMatchingCache.reset: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(177393);
    }
  }
  
  public static void i(Map<Long, cvy> paramMap, String paramString)
  {
    AppMethodBeat.i(177390);
    if ((TextUtils.isEmpty(paramString)) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(177390);
      return;
    }
    cvz localcvz = new cvz();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      cvy localcvy = (cvy)((Map.Entry)paramMap.next()).getValue();
      if ((localcvy.dnh.equals(paramString)) && (localcvy.index > 0)) {
        localcvz.FGC.addLast(localcvy);
      }
    }
    if (localcvz.FGC.isEmpty())
    {
      AppMethodBeat.o(177390);
      return;
    }
    a(localcvz, "mmkv_key_hellSPMatchinghe_");
    AppMethodBeat.o(177390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.k
 * JD-Core Version:    0.7.0.1
 */