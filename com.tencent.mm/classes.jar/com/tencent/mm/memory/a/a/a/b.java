package com.tencent.mm.memory.a.a.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b<T, V>
{
  private ConcurrentLinkedQueue<Pair<T, f<T, V>>> iup;
  private a iuq;
  a<T, V> iur;
  b<T, V> ius;
  
  public b(a parama, a<T, V> parama1, b<T, V> paramb)
  {
    AppMethodBeat.i(156510);
    this.iup = new ConcurrentLinkedQueue();
    this.iuq = null;
    this.iuq = parama;
    this.iur = parama1;
    this.ius = paramb;
    AppMethodBeat.o(156510);
  }
  
  public final boolean C(T paramT1, T paramT2)
  {
    AppMethodBeat.i(156511);
    Iterator localIterator = this.iup.iterator();
    Pair localPair;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localPair = (Pair)localIterator.next();
    } while ((localPair == null) || (localPair.first == null) || (!localPair.first.equals(paramT1)));
    for (paramT1 = (f)localPair.second; paramT1 != null; paramT1 = null)
    {
      boolean bool = paramT1.check(paramT2);
      AppMethodBeat.o(156511);
      return bool;
    }
    AppMethodBeat.o(156511);
    return false;
  }
  
  final f<T, V> cc(final T paramT)
  {
    AppMethodBeat.i(156512);
    Object localObject = this.iup.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((localPair != null) && (localPair.first != null) && (localPair.first.equals(paramT)))
      {
        paramT = (f)localPair.second;
        AppMethodBeat.o(156512);
        return paramT;
      }
    }
    if (this.iup.size() >= this.iuq.iuo)
    {
      localObject = (Pair)this.iup.poll();
      if ((localObject != null) && (((Pair)localObject).second != null)) {
        ((f)((Pair)localObject).second).trimToSize(-1);
      }
    }
    localObject = this.iuq;
    int i = (int)(((a)localObject).iun * ((a)localObject).iuk * 1.0D / ((a)localObject).iuo);
    Log.i("MicroMsg.ExtraLruMap", "handlerMap %s %s", new Object[] { paramT, Integer.valueOf(i) });
    paramT = new Pair(paramT, new h(i, new f.b()new f.c
    {
      public final void c(T paramAnonymousT, V paramAnonymousV1, V paramAnonymousV2)
      {
        AppMethodBeat.i(156508);
        if (b.this.iur != null) {
          b.this.iur.D(paramT, paramAnonymousT);
        }
        AppMethodBeat.o(156508);
      }
    }, new f.c()
    {
      public final int y(T paramAnonymousT, V paramAnonymousV)
      {
        AppMethodBeat.i(156509);
        if (b.this.ius != null)
        {
          int i = b.this.ius.e(paramT, paramAnonymousT, paramAnonymousV);
          AppMethodBeat.o(156509);
          return i;
        }
        AppMethodBeat.o(156509);
        return 0;
      }
    }));
    this.iup.add(paramT);
    paramT = (f)paramT.second;
    AppMethodBeat.o(156512);
    return paramT;
  }
  
  public static abstract interface a<K, O>
  {
    public abstract void D(K paramK1, K paramK2);
  }
  
  public static abstract interface b<K, O>
  {
    public abstract int e(K paramK1, K paramK2, O paramO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */