package com.tencent.mm.plugin.finder.feed.model.internal;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "T", "A", "", "policy", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;", "name", "", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;Ljava/lang/String;)V", "buffer", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$PageData;", "empty", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "length", "", "getLength", "()I", "setLength", "(I)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "clear", "", "makeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "offer", "page", "take", "count", "expiredTimeMs", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Callback;", "Callback", "Companion", "PageData", "Policy", "plugin-finder_release"})
public final class k<T, A>
{
  public static final b sde;
  public final ReentrantLock cPz;
  public int length;
  public final String name;
  public final Condition sdb;
  public final LinkedList<c<T, A>> sdc;
  private final k.d sdd;
  
  static
  {
    AppMethodBeat.i(202602);
    sde = new b((byte)0);
    AppMethodBeat.o(202602);
  }
  
  public k()
  {
    this(null, null, 3);
  }
  
  private k(k.d paramd, String paramString)
  {
    AppMethodBeat.i(202600);
    this.sdd = paramd;
    this.name = paramString;
    this.cPz = new ReentrantLock();
    this.sdb = this.cPz.newCondition();
    this.sdc = new LinkedList();
    AppMethodBeat.o(202600);
  }
  
  public final c<T, A> a(int paramInt, long paramLong, a parama)
  {
    AppMethodBeat.i(202598);
    p.h(parama, "callback");
    ad.i("PageDataBuffer", "[take#begin] name=" + this.name + " count=" + paramInt + " expiredTimeMs=" + paramLong);
    long l1 = SystemClock.uptimeMillis();
    LinkedList localLinkedList = new LinkedList();
    c localc = new c(localLinkedList);
    this.cPz.lock();
    for (;;)
    {
      try
      {
        if ((paramInt > this.length) && (this.sdd == k.d.sdf))
        {
          parama.cyR();
          ad.i("PageDataBuffer", "[take#request] name=" + this.name + " count=" + paramInt + " expiredTimeMs=" + paramLong);
          this.sdb.await();
          parama = this.sdc.iterator();
          p.g(parama, "buffer.iterator()");
          if ((!parama.hasNext()) || (localLinkedList.size() >= paramInt)) {
            break;
          }
          Object localObject = parama.next();
          p.g(localObject, "iterator.next()");
          localObject = (c)localObject;
          List localList = ((c)localObject).EE(paramInt - localLinkedList.size());
          localLinkedList.addAll((Collection)localList);
          this.length -= localList.size();
          if (((c)localObject).fVg.size() <= 0) {
            parama.remove();
          }
          localc.igb = ((c)localObject).igb;
          continue;
        }
        if (this.length > 0) {
          continue;
        }
      }
      finally
      {
        this.cPz.unlock();
        AppMethodBeat.o(202598);
      }
      parama.cyR();
      ad.i("PageDataBuffer", "[take#request] name=" + this.name + " count=" + paramInt + " expiredTimeMs=" + paramLong);
      this.sdb.await();
    }
    this.cPz.unlock();
    long l2 = paramLong - (SystemClock.uptimeMillis() - l1);
    if ((l2 > 0L) && (localLinkedList.size() > 0)) {
      SystemClock.sleep(l2);
    }
    ad.i("PageDataBuffer", "[take#end] name=" + this.name + ' ' + localc + " expiredTimeMs=" + paramLong + " length=" + this.length + " delay=" + l2 + " cost=" + (SystemClock.uptimeMillis() - l1) + "ms");
    AppMethodBeat.o(202598);
    return localc;
  }
  
  public final void a(c<T, A> paramc)
  {
    AppMethodBeat.i(202597);
    p.h(paramc, "page");
    this.cPz.lock();
    try
    {
      this.sdc.addLast(paramc);
      this.length += paramc.fVg.size();
      this.sdb.signal();
      this.cPz.unlock();
      ad.i("PageDataBuffer", "[offer] name=" + this.name + " page=" + paramc + " length=" + this.length);
      AppMethodBeat.o(202597);
      return;
    }
    finally
    {
      this.cPz.unlock();
      AppMethodBeat.o(202597);
    }
  }
  
  public final ArrayList<T> cBW()
  {
    AppMethodBeat.i(202599);
    this.cPz.lock();
    try
    {
      ArrayList localArrayList = new ArrayList(this.length);
      Iterator localIterator = ((Iterable)this.sdc).iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll((Collection)((c)localIterator.next()).fVg);
      }
      this.cPz.unlock();
    }
    finally
    {
      this.cPz.unlock();
      AppMethodBeat.o(202599);
    }
    AppMethodBeat.o(202599);
    return localArrayList1;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Callback;", "", "request", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void cyR();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$PageData;", "T", "A", "", "list", "Ljava/util/LinkedList;", "(Ljava/util/LinkedList;)V", "args", "getArgs", "()Ljava/lang/Object;", "setArgs", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getList", "()Ljava/util/LinkedList;", "component1", "copy", "decrement", "", "count", "", "equals", "", "other", "hashCode", "isEmpty", "size", "toString", "", "plugin-finder_release"})
  public static final class c<T, A>
  {
    public final LinkedList<T> fVg;
    public A igb;
    
    public c(LinkedList<T> paramLinkedList)
    {
      AppMethodBeat.i(202591);
      this.fVg = paramLinkedList;
      AppMethodBeat.o(202591);
    }
    
    public final List<T> EE(int paramInt)
    {
      AppMethodBeat.i(202589);
      Object localObject = new LinkedList();
      Iterator localIterator = this.fVg.iterator();
      p.g(localIterator, "list.iterator()");
      int i = 0;
      while ((localIterator.hasNext()) && (i < paramInt))
      {
        ((LinkedList)localObject).add(localIterator.next());
        localIterator.remove();
        i += 1;
      }
      localObject = (List)localObject;
      AppMethodBeat.o(202589);
      return localObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(202593);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if (!p.i(this.fVg, paramObject.fVg)) {}
        }
      }
      else
      {
        AppMethodBeat.o(202593);
        return true;
      }
      AppMethodBeat.o(202593);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(202592);
      LinkedList localLinkedList = this.fVg;
      if (localLinkedList != null)
      {
        int i = localLinkedList.hashCode();
        AppMethodBeat.o(202592);
        return i;
      }
      AppMethodBeat.o(202592);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(202590);
      StringBuilder localStringBuilder = new StringBuilder("PageData(size=").append(this.fVg.size()).append(" args=");
      Object localObject = this.igb;
      if (localObject != null) {}
      for (localObject = Integer.valueOf(localObject.hashCode());; localObject = null)
      {
        localObject = localObject + ')';
        AppMethodBeat.o(202590);
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.k
 * JD-Core Version:    0.7.0.1
 */