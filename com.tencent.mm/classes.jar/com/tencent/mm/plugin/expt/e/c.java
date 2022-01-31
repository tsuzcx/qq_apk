package com.tencent.mm.plugin.expt.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.expt.a.a.b;
import com.tencent.mm.plugin.expt.d.a;
import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
{
  private static String TAG;
  private static c mdc;
  private static HashSet<String> mdd;
  
  static
  {
    AppMethodBeat.i(73622);
    TAG = "MicroMsg.ExptMMKV";
    long l = bo.yB();
    mdd = new HashSet();
    a.b[] arrayOfb = a.b.values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      a.b localb = arrayOfb[i];
      mdd.add(localb.name());
      i += 1;
    }
    ab.i(TAG, "get mulit expt enum cost time [%d]", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(73622);
  }
  
  public static String a(a.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(73617);
    parama = b.btj().b(parama.name(), paramString, paramBoolean, true);
    AppMethodBeat.o(73617);
    return parama;
  }
  
  private String bau()
  {
    AppMethodBeat.i(73621);
    String str = hashCode();
    AppMethodBeat.o(73621);
    return str;
  }
  
  public static as btk()
  {
    AppMethodBeat.i(73616);
    as localas = b.btj().btk();
    AppMethodBeat.o(73616);
    return localas;
  }
  
  public static c btm()
  {
    AppMethodBeat.i(73615);
    if (mdc == null) {
      mdc = new c();
    }
    c localc = mdc;
    AppMethodBeat.o(73615);
    return localc;
  }
  
  public final void bC(List<a> paramList)
  {
    AppMethodBeat.i(73618);
    if (!btn())
    {
      AppMethodBeat.o(73618);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(73618);
      return;
    }
    long l = bo.yB();
    as localas = b.btj().btk();
    if (localas == null)
    {
      AppMethodBeat.o(73618);
      return;
    }
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j = 0;
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null)
      {
        Object localObject = locala.bti();
        if (localObject == null) {
          break label290;
        }
        localObject = ((HashMap)localObject).keySet().iterator();
        int k = 0;
        while (((Iterator)localObject).hasNext())
        {
          localas.putInt((String)((Iterator)localObject).next(), locala.field_exptId);
          k = 1;
          j += 1;
        }
        if (k == 0) {
          break label287;
        }
        localas.putString(locala.field_exptId, locala.field_exptContent);
        i += 1;
      }
    }
    label287:
    label290:
    for (;;)
    {
      break;
      boolean bool = localas.commit();
      ab.i(TAG, "%s replace expt param[%d] [%d %d] cost[%d] flag[%b]", new Object[] { bau(), Integer.valueOf(paramList.size()), Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(bo.av(l)), Boolean.valueOf(bool) });
      AppMethodBeat.o(73618);
      return;
    }
  }
  
  public final void bD(List<Integer> paramList)
  {
    AppMethodBeat.i(73619);
    if (!btn())
    {
      AppMethodBeat.o(73619);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(73619);
      return;
    }
    long l = bo.yB();
    as localas = b.btj().btk();
    if (localas == null)
    {
      AppMethodBeat.o(73619);
      return;
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      j = ((Integer)localIterator.next()).intValue();
      if (!localas.contains(String.valueOf(j))) {
        break label299;
      }
      localas.remove(String.valueOf(j));
      localHashSet.add(Integer.valueOf(j));
      i += 1;
    }
    label296:
    label299:
    for (;;)
    {
      break;
      localIterator = mdd.iterator();
      j = 0;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        int k = localas.getInt(str, 0);
        if ((k <= 0) || (!localHashSet.contains(Integer.valueOf(k)))) {
          break label296;
        }
        localas.remove(str);
        j += 1;
      }
      for (;;)
      {
        break;
        boolean bool = localas.commit();
        ab.i(TAG, "%s delete expt params[%d] delete [%d %d] cost[%d] flag [%b]", new Object[] { bau(), Integer.valueOf(paramList.size()), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(bo.av(l)), Boolean.valueOf(bool) });
        AppMethodBeat.o(73619);
        return;
      }
    }
  }
  
  public final boolean btn()
  {
    AppMethodBeat.i(73620);
    if (ah.brt())
    {
      AppMethodBeat.o(73620);
      return true;
    }
    ab.b(TAG, "%s only mm process can write expt info", new Object[] { bau() });
    AppMethodBeat.o(73620);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.c
 * JD-Core Version:    0.7.0.1
 */