package com.tencent.mm.plugin.expt.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
{
  private static String TAG;
  private static c wrm;
  private static HashSet<String> wrn;
  
  static
  {
    AppMethodBeat.i(122460);
    TAG = "MicroMsg.ExptMMKV";
    long l = Util.currentTicks();
    wrn = new HashSet();
    b.a[] arrayOfa = b.a.values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      b.a locala = arrayOfa[i];
      wrn.add(locala.name());
      i += 1;
    }
    Log.i(TAG, "get mulit expt enum cost time [%d]", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(122460);
  }
  
  public static MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(122454);
    MultiProcessMMKV localMultiProcessMMKV = d.dgX().bcJ();
    AppMethodBeat.o(122454);
    return localMultiProcessMMKV;
  }
  
  public static String c(b.a parama, String paramString)
  {
    AppMethodBeat.i(254429);
    parama = d.dgX().a(parama.name(), paramString, false, true);
    AppMethodBeat.o(254429);
    return parama;
  }
  
  public static c dgZ()
  {
    AppMethodBeat.i(122453);
    if (wrm == null) {
      wrm = new c();
    }
    c localc = wrm;
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
  
  public final boolean dF(List<com.tencent.mm.plugin.expt.h.c> paramList)
  {
    AppMethodBeat.i(184400);
    if (!dha())
    {
      AppMethodBeat.o(184400);
      return false;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w(TAG, "%s replace expt but item is null!", new Object[] { info() });
      AppMethodBeat.o(184400);
      return false;
    }
    long l = Util.currentTicks();
    MultiProcessMMKV localMultiProcessMMKV = d.dgX().bcJ();
    if (localMultiProcessMMKV == null)
    {
      Log.w(TAG, "%s replace expt but mmkv is null!", new Object[] { info() });
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
        Object localObject = localc.dgD();
        if (localObject == null) {
          break label333;
        }
        localObject = ((HashMap)localObject).keySet().iterator();
        int k = 0;
        while (((Iterator)localObject).hasNext())
        {
          localMultiProcessMMKV.putInt((String)((Iterator)localObject).next(), localc.field_exptId);
          k = 1;
          j += 1;
        }
        if (k == 0) {
          break label330;
        }
        localMultiProcessMMKV.putString(localc.field_exptId, localc.field_exptContent);
        i += 1;
      }
    }
    label330:
    label333:
    for (;;)
    {
      break;
      boolean bool = localMultiProcessMMKV.commit();
      Log.i(TAG, "%s replace expt param[%d] [%d %d] cost[%d] flag[%b]", new Object[] { info(), Integer.valueOf(paramList.size()), Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool) });
      AppMethodBeat.o(184400);
      return bool;
    }
  }
  
  public final void dG(List<Integer> paramList)
  {
    AppMethodBeat.i(122457);
    if (!dha())
    {
      AppMethodBeat.o(122457);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(122457);
      return;
    }
    long l = Util.currentTicks();
    MultiProcessMMKV localMultiProcessMMKV = d.dgX().bcJ();
    if (localMultiProcessMMKV == null)
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
      if (!localMultiProcessMMKV.contains(String.valueOf(j))) {
        break label299;
      }
      localMultiProcessMMKV.remove(String.valueOf(j));
      localHashSet.add(Integer.valueOf(j));
      i += 1;
    }
    label296:
    label299:
    for (;;)
    {
      break;
      localIterator = wrn.iterator();
      j = 0;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        int k = localMultiProcessMMKV.getInt(str, 0);
        if ((k <= 0) || (!localHashSet.contains(Integer.valueOf(k)))) {
          break label296;
        }
        localMultiProcessMMKV.remove(str);
        j += 1;
      }
      for (;;)
      {
        break;
        boolean bool = localMultiProcessMMKV.commit();
        Log.i(TAG, "%s delete expt params[%d] delete [%d %d] cost[%d] flag [%b]", new Object[] { info(), Integer.valueOf(paramList.size()), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool) });
        AppMethodBeat.o(122457);
        return;
      }
    }
  }
  
  public final boolean dha()
  {
    AppMethodBeat.i(122458);
    if (MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(122458);
      return true;
    }
    Log.printInfoStack(TAG, "%s only mm process can write expt info", new Object[] { info() });
    AppMethodBeat.o(122458);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.i.c
 * JD-Core Version:    0.7.0.1
 */