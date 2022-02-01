package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.cqp;
import com.tencent.mm.protocal.protobuf.cqr;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class k
{
  public static cqs WY(String paramString)
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
    cqs localcqs = new cqs();
    try
    {
      localcqs.parseFrom(paramString);
      AppMethodBeat.o(177395);
      return localcqs;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("SessionPageMatchingCache", paramString, "HABBYGE-MALI, SessionPageMatchingCache.read: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(177395);
    }
    return null;
  }
  
  public static void a(bgc parambgc)
  {
    AppMethodBeat.i(177391);
    if (TextUtils.isEmpty(parambgc.dpw))
    {
      AppMethodBeat.o(177391);
      return;
    }
    Object localObject1 = parambgc.dpw;
    cqs localcqs;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localcqs = WY("mmkv_key_hellSPMatchinghe_");
      if ((localcqs == null) || (localcqs.EjE.isEmpty())) {
        localcqs = null;
      }
    }
    while (localcqs == null)
    {
      cdv();
      AppMethodBeat.o(177391);
      return;
      if (!((String)localObject1).equals(((cqr)localcqs.EjE.get(0)).dpw)) {
        localcqs = null;
      }
    }
    ad.i("SessionPageMatchingCache", "HABBYGE-MALI, SessionPageMatchingCache, addPage: %s", new Object[] { parambgc.dpw });
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(parambgc.dpw);
    if (localObject1 == null)
    {
      AppMethodBeat.o(177391);
      return;
    }
    List localList = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WF((String)localObject1);
    if ((localList == null) || (localList.isEmpty()))
    {
      cdv();
      AppMethodBeat.o(177391);
      return;
    }
    int i = localcqs.EjE.size() - 1;
    if (i >= 0)
    {
      cqr localcqr = (cqr)localcqs.EjE.get(i);
      Object localObject2 = null;
      Object localObject3 = localList.iterator();
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (cqt)((Iterator)localObject3).next();
      } while (((cqt)localObject1).Doj != localcqr.Doj);
      if (localObject1 != null) {
        if ((localcqr.index <= 0) || (localcqr.index >= ((cqt)localObject1).EjF.size() - 1)) {
          localcqs.EjE.remove(i);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(((bgc)localcqr.EjD.getLast()).DDP);
        if (localObject3 == null)
        {
          localcqs.EjE.remove(i);
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambgc.DDP);
          if (((String)localObject3).equals(localObject2))
          {
            ad.i("SessionPageMatchingCache", "HABBYGE-MALI, SessionPageMatchingCache, addPage, 7Event: %s", new Object[] { localObject2 });
          }
          else
          {
            localObject3 = (cqp)((cqt)localObject1).EjF.get(localcqr.index + 1);
            if (localObject3 == null)
            {
              localcqs.EjE.remove(i);
            }
            else
            {
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(((cqp)localObject3).DDP);
              if (localObject3 == null)
              {
                localcqs.EjE.remove(i);
              }
              else if (((String)localObject3).equals(localObject2))
              {
                ad.i("SessionPageMatchingCache", "HABBYGE-MALI, SessionPageMatchingCache, addPage, real: %s", new Object[] { localObject2 });
                localcqr.EjD.addLast(parambgc);
                localcqr.index += 1;
                if (localcqr.index == ((cqt)localObject1).EjF.size() - 1)
                {
                  localcqr.index = -1;
                  localcqr.EjC = true;
                  ad.i("SessionPageMatchingCache", "HABBYGE-MALI, move2SuccessCache: %s, %s, %s", new Object[] { localcqr.Doi, localcqr.dpw, Long.valueOf(localcqr.Doj) });
                  localObject2 = WY("mmkv_key_hellSPMatchSuche_");
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = new cqs();
                  }
                  ((cqs)localObject1).EjE.addLast(localcqr);
                  a((cqs)localObject1, "mmkv_key_hellSPMatchSuche_");
                  localcqs.EjE.remove(i);
                }
              }
              else
              {
                ad.i("SessionPageMatchingCache", "HABBYGE-MALI, SessionPageMatchingCache, addPage, misMatch: %s, %s", new Object[] { localObject2, localObject3 });
                localcqs.EjE.remove(i);
                continue;
                localcqs.EjE.remove(i);
              }
            }
          }
        }
      }
    }
    if (localcqs.EjE.isEmpty())
    {
      cdv();
      AppMethodBeat.o(177391);
      return;
    }
    a(localcqs, "mmkv_key_hellSPMatchinghe_");
    AppMethodBeat.o(177391);
  }
  
  private static void a(cqs paramcqs, String paramString)
  {
    AppMethodBeat.i(177394);
    if (paramcqs == null)
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
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o(paramString + i, paramcqs.toByteArray());
      AppMethodBeat.o(177394);
      return;
    }
    catch (Exception paramcqs)
    {
      ad.printErrStackTrace("SessionPageMatchingCache", paramcqs, "HABBYGE-MALI, SessionPageMatchingCache.write: %s", new Object[] { paramcqs.getMessage() });
      AppMethodBeat.o(177394);
    }
  }
  
  public static void cdv()
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
      ad.printErrStackTrace("SessionPageMatchingCache", localException, "HABBYGE-MALI, SessionPageMatchingCache.reset: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(177392);
    }
  }
  
  public static void cdw()
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
      ad.printErrStackTrace("SessionPageMatchingCache", localException, "HABBYGE-MALI, SessionPageMatchingCache.reset: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(177393);
    }
  }
  
  public static void i(Map<Long, cqr> paramMap, String paramString)
  {
    AppMethodBeat.i(177390);
    if ((TextUtils.isEmpty(paramString)) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(177390);
      return;
    }
    cqs localcqs = new cqs();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      cqr localcqr = (cqr)((Map.Entry)paramMap.next()).getValue();
      if ((localcqr.dpw.equals(paramString)) && (localcqr.index > 0)) {
        localcqs.EjE.addLast(localcqr);
      }
    }
    if (localcqs.EjE.isEmpty())
    {
      AppMethodBeat.o(177390);
      return;
    }
    a(localcqs, "mmkv_key_hellSPMatchinghe_");
    AppMethodBeat.o(177390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.k
 * JD-Core Version:    0.7.0.1
 */