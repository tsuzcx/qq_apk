package com.tencent.mm.plugin.expt.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.expt.a.b.b;
import com.tencent.mm.plugin.expt.e.a;
import com.tencent.mm.plugin.expt.e.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
{
  private static String TAG;
  private static c qsg;
  private static HashSet<String> qsh;
  
  static
  {
    AppMethodBeat.i(122460);
    TAG = "MicroMsg.ExptMMKV";
    long l = bs.Gn();
    qsh = new HashSet();
    b.b[] arrayOfb = b.b.values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b.b localb = arrayOfb[i];
      qsh.add(localb.name());
      i += 1;
    }
    ac.i(TAG, "get mulit expt enum cost time [%d]", new Object[] { Long.valueOf(bs.aO(l)) });
    AppMethodBeat.o(122460);
  }
  
  public static String b(b.a parama, String paramString)
  {
    AppMethodBeat.i(195315);
    parama = b.cmk().b(parama.name(), paramString, false, true);
    AppMethodBeat.o(195315);
    return parama;
  }
  
  public static aw bJa()
  {
    AppMethodBeat.i(122454);
    aw localaw = b.cmk().bJa();
    AppMethodBeat.o(122454);
    return localaw;
  }
  
  public static c cmm()
  {
    AppMethodBeat.i(122453);
    if (qsg == null) {
      qsg = new c();
    }
    c localc = qsg;
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
  
  public final boolean cmn()
  {
    AppMethodBeat.i(122458);
    if (ai.ciE())
    {
      AppMethodBeat.o(122458);
      return true;
    }
    ac.m(TAG, "%s only mm process can write expt info", new Object[] { info() });
    AppMethodBeat.o(122458);
    return false;
  }
  
  public final boolean dg(List<a> paramList)
  {
    AppMethodBeat.i(184400);
    if (!cmn())
    {
      AppMethodBeat.o(184400);
      return false;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ac.w(TAG, "%s replace expt but item is null!", new Object[] { info() });
      AppMethodBeat.o(184400);
      return false;
    }
    long l = bs.Gn();
    aw localaw = b.cmk().bJa();
    if (localaw == null)
    {
      ac.w(TAG, "%s replace expt but mmkv is null!", new Object[] { info() });
      AppMethodBeat.o(184400);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j = 0;
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null)
      {
        Object localObject = locala.cmj();
        if (localObject == null) {
          break label333;
        }
        localObject = ((HashMap)localObject).keySet().iterator();
        int k = 0;
        while (((Iterator)localObject).hasNext())
        {
          localaw.putInt((String)((Iterator)localObject).next(), locala.field_exptId);
          k = 1;
          j += 1;
        }
        if (k == 0) {
          break label330;
        }
        localaw.putString(locala.field_exptId, locala.field_exptContent);
        i += 1;
      }
    }
    label330:
    label333:
    for (;;)
    {
      break;
      boolean bool = localaw.commit();
      ac.i(TAG, "%s replace expt param[%d] [%d %d] cost[%d] flag[%b]", new Object[] { info(), Integer.valueOf(paramList.size()), Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(bs.aO(l)), Boolean.valueOf(bool) });
      AppMethodBeat.o(184400);
      return bool;
    }
  }
  
  public final void dh(List<Integer> paramList)
  {
    AppMethodBeat.i(122457);
    if (!cmn())
    {
      AppMethodBeat.o(122457);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(122457);
      return;
    }
    long l = bs.Gn();
    aw localaw = b.cmk().bJa();
    if (localaw == null)
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
      if (!localaw.contains(String.valueOf(j))) {
        break label299;
      }
      localaw.remove(String.valueOf(j));
      localHashSet.add(Integer.valueOf(j));
      i += 1;
    }
    label296:
    label299:
    for (;;)
    {
      break;
      localIterator = qsh.iterator();
      j = 0;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        int k = localaw.getInt(str, 0);
        if ((k <= 0) || (!localHashSet.contains(Integer.valueOf(k)))) {
          break label296;
        }
        localaw.remove(str);
        j += 1;
      }
      for (;;)
      {
        break;
        boolean bool = localaw.commit();
        ac.i(TAG, "%s delete expt params[%d] delete [%d %d] cost[%d] flag [%b]", new Object[] { info(), Integer.valueOf(paramList.size()), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(bs.aO(l)), Boolean.valueOf(bool) });
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