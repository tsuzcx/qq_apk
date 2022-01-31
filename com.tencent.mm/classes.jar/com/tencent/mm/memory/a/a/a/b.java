package com.tencent.mm.memory.a.a.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.b;
import com.tencent.mm.a.f.c;
import com.tencent.mm.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b<T, V>
{
  private ConcurrentLinkedQueue<Pair<T, f<T, V>>> feB;
  private a feC;
  a<T, V> feD;
  b<T, V> feE;
  
  public b(a parama, a<T, V> parama1, b<T, V> paramb)
  {
    AppMethodBeat.i(115464);
    this.feB = new ConcurrentLinkedQueue();
    this.feC = null;
    this.feC = parama;
    this.feD = parama1;
    this.feE = paramb;
    AppMethodBeat.o(115464);
  }
  
  final f<T, V> aN(final T paramT)
  {
    AppMethodBeat.i(115466);
    Object localObject = this.feB.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((localPair != null) && (localPair.first != null) && (localPair.first.equals(paramT)))
      {
        paramT = (f)localPair.second;
        AppMethodBeat.o(115466);
        return paramT;
      }
    }
    if (this.feB.size() >= this.feC.fez)
    {
      localObject = (Pair)this.feB.poll();
      if ((localObject != null) && (((Pair)localObject).second != null)) {
        ((f)((Pair)localObject).second).trimToSize(-1);
      }
    }
    localObject = this.feC;
    int i = (int)(((a)localObject).fey * ((a)localObject).fev * 1.0D / ((a)localObject).fez);
    ab.i("MicroMsg.ExtraLruMap", "handlerMap %s %s", new Object[] { paramT, Integer.valueOf(i) });
    paramT = new Pair(paramT, new h(i, new f.b()new f.c
    {
      public final void c(T paramAnonymousT, V paramAnonymousV1, V paramAnonymousV2)
      {
        AppMethodBeat.i(115462);
        if (b.this.feD != null) {
          b.this.feD.m(paramT, paramAnonymousT);
        }
        AppMethodBeat.o(115462);
      }
    }, new f.c()
    {
      public final int g(T paramAnonymousT, V paramAnonymousV)
      {
        AppMethodBeat.i(115463);
        if (b.this.feE != null)
        {
          int i = b.this.feE.e(paramT, paramAnonymousT, paramAnonymousV);
          AppMethodBeat.o(115463);
          return i;
        }
        AppMethodBeat.o(115463);
        return 0;
      }
    }));
    this.feB.add(paramT);
    paramT = (f)paramT.second;
    AppMethodBeat.o(115466);
    return paramT;
  }
  
  public final boolean l(T paramT1, T paramT2)
  {
    AppMethodBeat.i(115465);
    Iterator localIterator = this.feB.iterator();
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
      boolean bool = paramT1.Z(paramT2);
      AppMethodBeat.o(115465);
      return bool;
    }
    AppMethodBeat.o(115465);
    return false;
  }
  
  public static abstract interface a<K, O>
  {
    public abstract void m(K paramK1, K paramK2);
  }
  
  public static abstract interface b<K, O>
  {
    public abstract int e(K paramK1, K paramK2, O paramO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */