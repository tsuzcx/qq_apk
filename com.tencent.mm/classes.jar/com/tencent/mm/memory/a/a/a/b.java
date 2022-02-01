package com.tencent.mm.memory.a.a.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.b.h;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b<T, V>
{
  private ConcurrentLinkedQueue<Pair<T, f<T, V>>> hAi;
  private a hAj;
  a<T, V> hAk;
  b<T, V> hAl;
  
  public b(a parama, a<T, V> parama1, b<T, V> paramb)
  {
    AppMethodBeat.i(156510);
    this.hAi = new ConcurrentLinkedQueue();
    this.hAj = null;
    this.hAj = parama;
    this.hAk = parama1;
    this.hAl = paramb;
    AppMethodBeat.o(156510);
  }
  
  final f<T, V> bS(final T paramT)
  {
    AppMethodBeat.i(156512);
    Object localObject = this.hAi.iterator();
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
    if (this.hAi.size() >= this.hAj.hAh)
    {
      localObject = (Pair)this.hAi.poll();
      if ((localObject != null) && (((Pair)localObject).second != null)) {
        ((f)((Pair)localObject).second).trimToSize(-1);
      }
    }
    localObject = this.hAj;
    int i = (int)(((a)localObject).hAg * ((a)localObject).hAd * 1.0D / ((a)localObject).hAh);
    ae.i("MicroMsg.ExtraLruMap", "handlerMap %s %s", new Object[] { paramT, Integer.valueOf(i) });
    paramT = new Pair(paramT, new h(i, new f.b()new f.c
    {
      public final void c(T paramAnonymousT, V paramAnonymousV1, V paramAnonymousV2)
      {
        AppMethodBeat.i(156508);
        if (b.this.hAk != null) {
          b.this.hAk.w(paramT, paramAnonymousT);
        }
        AppMethodBeat.o(156508);
      }
    }, new f.c()
    {
      public final int r(T paramAnonymousT, V paramAnonymousV)
      {
        AppMethodBeat.i(156509);
        if (b.this.hAl != null)
        {
          int i = b.this.hAl.e(paramT, paramAnonymousT, paramAnonymousV);
          AppMethodBeat.o(156509);
          return i;
        }
        AppMethodBeat.o(156509);
        return 0;
      }
    }));
    this.hAi.add(paramT);
    paramT = (f)paramT.second;
    AppMethodBeat.o(156512);
    return paramT;
  }
  
  public final boolean v(T paramT1, T paramT2)
  {
    AppMethodBeat.i(156511);
    Iterator localIterator = this.hAi.iterator();
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
      boolean bool = paramT1.aM(paramT2);
      AppMethodBeat.o(156511);
      return bool;
    }
    AppMethodBeat.o(156511);
    return false;
  }
  
  public static abstract interface a<K, O>
  {
    public abstract void w(K paramK1, K paramK2);
  }
  
  public static abstract interface b<K, O>
  {
    public abstract int e(K paramK1, K paramK2, O paramO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */