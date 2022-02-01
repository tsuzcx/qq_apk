package com.tencent.mm.plugin.expt.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.expt.e.d;
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
  private static c zNr;
  private static HashSet<String> zNs;
  
  static
  {
    AppMethodBeat.i(122460);
    TAG = "MicroMsg.ExptMMKV";
    long l = Util.currentTicks();
    zNs = new HashSet();
    c.a[] arrayOfa = c.a.values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      c.a locala = arrayOfa[i];
      zNs.add(locala.name());
      i += 1;
    }
    Log.i(TAG, "get mulit expt enum cost time [%d]", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(122460);
  }
  
  public static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(122454);
    MultiProcessMMKV localMultiProcessMMKV = d.dNI().atj();
    AppMethodBeat.o(122454);
    return localMultiProcessMMKV;
  }
  
  public static String c(c.a parama, String paramString)
  {
    AppMethodBeat.i(299430);
    parama = d.dNI().a(parama.name(), paramString, false, true);
    AppMethodBeat.o(299430);
    return parama;
  }
  
  public static c dNK()
  {
    AppMethodBeat.i(122453);
    if (zNr == null) {
      zNr = new c();
    }
    c localc = zNr;
    AppMethodBeat.o(122453);
    return localc;
  }
  
  public static String hx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(299436);
    paramString1 = d.dNI().a(paramString1, paramString2, false, true);
    AppMethodBeat.o(299436);
    return paramString1;
  }
  
  private String info()
  {
    AppMethodBeat.i(122459);
    String str = hashCode();
    AppMethodBeat.o(122459);
    return str;
  }
  
  public final boolean dNL()
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
  
  public final boolean fA(List<com.tencent.mm.plugin.expt.e.c> paramList)
  {
    AppMethodBeat.i(184400);
    if (!dNL())
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
    MultiProcessMMKV localMultiProcessMMKV = d.dNI().atj();
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
      com.tencent.mm.plugin.expt.e.c localc = (com.tencent.mm.plugin.expt.e.c)localIterator.next();
      if (localc != null)
      {
        Object localObject = localc.dNo();
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
  
  public final void fB(List<Integer> paramList)
  {
    AppMethodBeat.i(122457);
    if (!dNL())
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
    MultiProcessMMKV localMultiProcessMMKV = d.dNI().atj();
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
      localIterator = zNs.iterator();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.f.c
 * JD-Core Version:    0.7.0.1
 */