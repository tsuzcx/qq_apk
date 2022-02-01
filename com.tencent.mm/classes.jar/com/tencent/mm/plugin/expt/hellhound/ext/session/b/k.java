package com.tencent.mm.plugin.expt.hellhound.ext.session.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.ezb;
import com.tencent.mm.protocal.protobuf.ezd;
import com.tencent.mm.protocal.protobuf.eze;
import com.tencent.mm.protocal.protobuf.ezf;
import com.tencent.mm.protocal.protobuf.fxz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class k
{
  public static void a(czu paramczu)
  {
    AppMethodBeat.i(177391);
    if (TextUtils.isEmpty(paramczu.hQR))
    {
      AppMethodBeat.o(177391);
      return;
    }
    Object localObject1 = paramczu.hQR;
    eze localeze;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localeze = asV("mmkv_key_hellSPMatchinghe_");
      if ((localeze == null) || (localeze.abAk.isEmpty())) {
        localeze = null;
      }
    }
    while (localeze == null)
    {
      dMj();
      AppMethodBeat.o(177391);
      return;
      if (!((String)localObject1).equals(((ezd)localeze.abAk.get(0)).hQR)) {
        localeze = null;
      }
    }
    Log.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage: %s", new Object[] { paramczu.hQR });
    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(paramczu.hQR);
    if (localObject1 == null)
    {
      AppMethodBeat.o(177391);
      return;
    }
    List localList = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asB((String)localObject1);
    if ((localList == null) || (localList.isEmpty()))
    {
      dMj();
      AppMethodBeat.o(177391);
      return;
    }
    int i = localeze.abAk.size() - 1;
    if (i >= 0)
    {
      ezd localezd = (ezd)localeze.abAk.get(i);
      Object localObject2 = null;
      Object localObject3 = localList.iterator();
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (ezf)((Iterator)localObject3).next();
      } while (((ezf)localObject1).aajX != localezd.aajX);
      if (localObject1 != null) {
        if ((localezd.index <= 0) || (localezd.index >= ((ezf)localObject1).abAl.size() - 1)) {
          localeze.abAk.remove(i);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(((czu)localezd.abAj.getLast()).hJW);
        if (localObject3 == null)
        {
          localeze.abAk.remove(i);
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramczu.hJW);
          if (((String)localObject3).equals(localObject2))
          {
            Log.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage, 7Event: %s", new Object[] { localObject2 });
          }
          else
          {
            localObject3 = (ezb)((ezf)localObject1).abAl.get(localezd.index + 1);
            if (localObject3 == null)
            {
              localeze.abAk.remove(i);
            }
            else
            {
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(((ezb)localObject3).hJW);
              if (localObject3 == null)
              {
                localeze.abAk.remove(i);
              }
              else if (((String)localObject3).equals(localObject2))
              {
                Log.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage, real: %s", new Object[] { localObject2 });
                localezd.abAj.addLast(paramczu);
                localezd.index += 1;
                if (localezd.index == ((ezf)localObject1).abAl.size() - 1)
                {
                  localezd.index = -1;
                  localezd.abAi = true;
                  Log.i("HABBYGE-MALI.SessionPageMatchingCache", "move2SuccessCache: %s, %s, %s", new Object[] { localezd.aajW, localezd.hQR, Long.valueOf(localezd.aajX) });
                  localObject2 = asV("mmkv_key_hellSPMatchSuche_");
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = new eze();
                  }
                  ((eze)localObject1).abAk.addLast(localezd);
                  a((eze)localObject1, "mmkv_key_hellSPMatchSuche_");
                  localeze.abAk.remove(i);
                }
              }
              else
              {
                Log.i("HABBYGE-MALI.SessionPageMatchingCache", "SessionPageMatchingCache, addPage, misMatch: %s, %s", new Object[] { localObject2, localObject3 });
                localeze.abAk.remove(i);
                continue;
                localeze.abAk.remove(i);
              }
            }
          }
        }
      }
    }
    if (localeze.abAk.isEmpty())
    {
      dMj();
      AppMethodBeat.o(177391);
      return;
    }
    a(localeze, "mmkv_key_hellSPMatchinghe_");
    AppMethodBeat.o(177391);
  }
  
  private static void a(eze parameze, String paramString)
  {
    AppMethodBeat.i(177394);
    if (parameze == null)
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
      com.tencent.mm.plugin.expt.hellhound.core.a.b.u(paramString + i, parameze.toByteArray());
      AppMethodBeat.o(177394);
      return;
    }
    catch (Exception parameze)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", parameze, "SessionPageMatchingCache.write: %s", new Object[] { parameze.getMessage() });
      AppMethodBeat.o(177394);
    }
  }
  
  public static void a(fxz paramfxz, String paramString, eze parameze, boolean paramBoolean)
  {
    AppMethodBeat.i(300178);
    if ((parameze == null) || (parameze.abAk.isEmpty()))
    {
      AppMethodBeat.o(300178);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString);
    Iterator localIterator = parameze.abAk.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (ezd)localIterator.next();
      if ((localObject != null) && (!((ezd)localObject).abAj.isEmpty()))
      {
        localObject = (czu)((ezd)localObject).abAj.getLast();
        if (localObject != null)
        {
          String str = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(((czu)localObject).hJW);
          if ((str != null) && (str.equals(paramString)))
          {
            ((czu)localObject).aajR.add(paramfxz);
            i = 1;
          }
        }
      }
    }
    if (i != 0)
    {
      if (paramBoolean)
      {
        a(parameze, "mmkv_key_hellSPMatchinghe_");
        AppMethodBeat.o(300178);
        return;
      }
      a(parameze, "mmkv_key_hellSPMatchSuche_");
    }
    AppMethodBeat.o(300178);
  }
  
  public static eze asV(String paramString)
  {
    AppMethodBeat.i(177395);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(177395);
      return null;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.a.b.ard(paramString + i);
    if ((paramString == null) || (paramString.length <= 0))
    {
      AppMethodBeat.o(177395);
      return null;
    }
    eze localeze = new eze();
    try
    {
      localeze.parseFrom(paramString);
      AppMethodBeat.o(177395);
      return localeze;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", paramString, "SessionPageMatchingCache.read: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(177395);
    }
    return null;
  }
  
  public static void dMj()
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
      com.tencent.mm.plugin.expt.hellhound.core.a.b.u("mmkv_key_hellSPMatchinghe_".concat(String.valueOf(i)), new byte[0]);
      AppMethodBeat.o(177392);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", localException, "SessionPageMatchingCache.reset: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(177392);
    }
  }
  
  public static void dMk()
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
      com.tencent.mm.plugin.expt.hellhound.core.a.b.u("mmkv_key_hellSPMatchSuche_".concat(String.valueOf(i)), new byte[0]);
      AppMethodBeat.o(177393);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", localException, "SessionPageMatchingCache.reset: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(177393);
    }
  }
  
  public static void m(Map<Long, ezd> paramMap, String paramString)
  {
    AppMethodBeat.i(177390);
    if ((TextUtils.isEmpty(paramString)) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(177390);
      return;
    }
    eze localeze = new eze();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      ezd localezd = (ezd)((Map.Entry)paramMap.next()).getValue();
      if ((localezd.hQR.equals(paramString)) && (localezd.index > 0)) {
        localeze.abAk.addLast(localezd);
      }
    }
    if (localeze.abAk.isEmpty())
    {
      AppMethodBeat.o(177390);
      return;
    }
    a(localeze, "mmkv_key_hellSPMatchinghe_");
    AppMethodBeat.o(177390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.b.k
 * JD-Core Version:    0.7.0.1
 */