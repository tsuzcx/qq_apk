package com.tencent.mm.plugin.expt.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.b.b.b;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
{
  private static String TAG;
  private static c rjO;
  private static HashSet<String> rjP;
  
  static
  {
    AppMethodBeat.i(122460);
    TAG = "MicroMsg.ExptMMKV";
    long l = bu.HQ();
    rjP = new HashSet();
    b.b[] arrayOfb = b.b.values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b.b localb = arrayOfb[i];
      rjP.add(localb.name());
      i += 1;
    }
    ae.i(TAG, "get mulit expt enum cost time [%d]", new Object[] { Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(122460);
  }
  
  public static String b(b.a parama, String paramString)
  {
    AppMethodBeat.i(196208);
    parama = d.ctr().b(parama.name(), paramString, false, true);
    AppMethodBeat.o(196208);
    return parama;
  }
  
  public static ay bOc()
  {
    AppMethodBeat.i(122454);
    ay localay = d.ctr().bOc();
    AppMethodBeat.o(122454);
    return localay;
  }
  
  public static c ctt()
  {
    AppMethodBeat.i(122453);
    if (rjO == null) {
      rjO = new c();
    }
    c localc = rjO;
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
  
  public final boolean ctu()
  {
    AppMethodBeat.i(122458);
    if (ak.cpe())
    {
      AppMethodBeat.o(122458);
      return true;
    }
    ae.m(TAG, "%s only mm process can write expt info", new Object[] { info() });
    AppMethodBeat.o(122458);
    return false;
  }
  
  public final boolean dl(List<com.tencent.mm.plugin.expt.h.c> paramList)
  {
    AppMethodBeat.i(184400);
    if (!ctu())
    {
      AppMethodBeat.o(184400);
      return false;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ae.w(TAG, "%s replace expt but item is null!", new Object[] { info() });
      AppMethodBeat.o(184400);
      return false;
    }
    long l = bu.HQ();
    ay localay = d.ctr().bOc();
    if (localay == null)
    {
      ae.w(TAG, "%s replace expt but mmkv is null!", new Object[] { info() });
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
        Object localObject = localc.cta();
        if (localObject == null) {
          break label333;
        }
        localObject = ((HashMap)localObject).keySet().iterator();
        int k = 0;
        while (((Iterator)localObject).hasNext())
        {
          localay.putInt((String)((Iterator)localObject).next(), localc.field_exptId);
          k = 1;
          j += 1;
        }
        if (k == 0) {
          break label330;
        }
        localay.putString(localc.field_exptId, localc.field_exptContent);
        i += 1;
      }
    }
    label330:
    label333:
    for (;;)
    {
      break;
      boolean bool = localay.commit();
      ae.i(TAG, "%s replace expt param[%d] [%d %d] cost[%d] flag[%b]", new Object[] { info(), Integer.valueOf(paramList.size()), Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(bu.aO(l)), Boolean.valueOf(bool) });
      AppMethodBeat.o(184400);
      return bool;
    }
  }
  
  public final void dm(List<Integer> paramList)
  {
    AppMethodBeat.i(122457);
    if (!ctu())
    {
      AppMethodBeat.o(122457);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(122457);
      return;
    }
    long l = bu.HQ();
    ay localay = d.ctr().bOc();
    if (localay == null)
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
      if (!localay.contains(String.valueOf(j))) {
        break label299;
      }
      localay.remove(String.valueOf(j));
      localHashSet.add(Integer.valueOf(j));
      i += 1;
    }
    label296:
    label299:
    for (;;)
    {
      break;
      localIterator = rjP.iterator();
      j = 0;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        int k = localay.getInt(str, 0);
        if ((k <= 0) || (!localHashSet.contains(Integer.valueOf(k)))) {
          break label296;
        }
        localay.remove(str);
        j += 1;
      }
      for (;;)
      {
        break;
        boolean bool = localay.commit();
        ae.i(TAG, "%s delete expt params[%d] delete [%d %d] cost[%d] flag [%b]", new Object[] { info(), Integer.valueOf(paramList.size()), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(bu.aO(l)), Boolean.valueOf(bool) });
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