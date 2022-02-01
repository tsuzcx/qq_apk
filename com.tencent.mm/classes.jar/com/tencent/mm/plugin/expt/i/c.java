package com.tencent.mm.plugin.expt.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.b.b.b;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
{
  private static String TAG;
  private static c rbI;
  private static HashSet<String> rbJ;
  
  static
  {
    AppMethodBeat.i(122460);
    TAG = "MicroMsg.ExptMMKV";
    long l = bt.HI();
    rbJ = new HashSet();
    b.b[] arrayOfb = b.b.values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b.b localb = arrayOfb[i];
      rbJ.add(localb.name());
      i += 1;
    }
    ad.i(TAG, "get mulit expt enum cost time [%d]", new Object[] { Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(122460);
  }
  
  public static String b(b.a parama, String paramString)
  {
    AppMethodBeat.i(210541);
    parama = d.crP().b(parama.name(), paramString, false, true);
    AppMethodBeat.o(210541);
    return parama;
  }
  
  public static ax bNe()
  {
    AppMethodBeat.i(122454);
    ax localax = d.crP().bNe();
    AppMethodBeat.o(122454);
    return localax;
  }
  
  public static c crR()
  {
    AppMethodBeat.i(122453);
    if (rbI == null) {
      rbI = new c();
    }
    c localc = rbI;
    AppMethodBeat.o(122453);
    return localc;
  }
  
  private String info()
  {
    AppMethodBeat.i(122459);
    String str = hashCode();
    AppMethodBeat.o(122459);
    return str;
  }
  
  public final boolean crS()
  {
    AppMethodBeat.i(122458);
    if (aj.cnC())
    {
      AppMethodBeat.o(122458);
      return true;
    }
    ad.m(TAG, "%s only mm process can write expt info", new Object[] { info() });
    AppMethodBeat.o(122458);
    return false;
  }
  
  public final boolean di(List<com.tencent.mm.plugin.expt.h.c> paramList)
  {
    AppMethodBeat.i(184400);
    if (!crS())
    {
      AppMethodBeat.o(184400);
      return false;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.w(TAG, "%s replace expt but item is null!", new Object[] { info() });
      AppMethodBeat.o(184400);
      return false;
    }
    long l = bt.HI();
    ax localax = d.crP().bNe();
    if (localax == null)
    {
      ad.w(TAG, "%s replace expt but mmkv is null!", new Object[] { info() });
      AppMethodBeat.o(184400);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j = 0;
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.expt.h.c localc = (com.tencent.mm.plugin.expt.h.c)localIterator.next();
      if (localc != null)
      {
        Object localObject = localc.cry();
        if (localObject == null) {
          break label333;
        }
        localObject = ((HashMap)localObject).keySet().iterator();
        int k = 0;
        while (((Iterator)localObject).hasNext())
        {
          localax.putInt((String)((Iterator)localObject).next(), localc.field_exptId);
          k = 1;
          j += 1;
        }
        if (k == 0) {
          break label330;
        }
        localax.putString(localc.field_exptId, localc.field_exptContent);
        i += 1;
      }
    }
    label330:
    label333:
    for (;;)
    {
      break;
      boolean bool = localax.commit();
      ad.i(TAG, "%s replace expt param[%d] [%d %d] cost[%d] flag[%b]", new Object[] { info(), Integer.valueOf(paramList.size()), Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(bt.aO(l)), Boolean.valueOf(bool) });
      AppMethodBeat.o(184400);
      return bool;
    }
  }
  
  public final void dj(List<Integer> paramList)
  {
    AppMethodBeat.i(122457);
    if (!crS())
    {
      AppMethodBeat.o(122457);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(122457);
      return;
    }
    long l = bt.HI();
    ax localax = d.crP().bNe();
    if (localax == null)
    {
      AppMethodBeat.o(122457);
      return;
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      j = ((Integer)localIterator.next()).intValue();
      if (!localax.contains(String.valueOf(j))) {
        break label299;
      }
      localax.remove(String.valueOf(j));
      localHashSet.add(Integer.valueOf(j));
      i += 1;
    }
    label296:
    label299:
    for (;;)
    {
      break;
      localIterator = rbJ.iterator();
      j = 0;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        int k = localax.getInt(str, 0);
        if ((k <= 0) || (!localHashSet.contains(Integer.valueOf(k)))) {
          break label296;
        }
        localax.remove(str);
        j += 1;
      }
      for (;;)
      {
        break;
        boolean bool = localax.commit();
        ad.i(TAG, "%s delete expt params[%d] delete [%d %d] cost[%d] flag [%b]", new Object[] { info(), Integer.valueOf(paramList.size()), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(bt.aO(l)), Boolean.valueOf(bool) });
        AppMethodBeat.o(122457);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.i.c
 * JD-Core Version:    0.7.0.1
 */