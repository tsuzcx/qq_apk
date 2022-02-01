package com.tencent.mm.plugin.finder.feed.model.internal;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "T", "A", "", "policy", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;", "name", "", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;Ljava/lang/String;)V", "buffer", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$PageData;", "empty", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "length", "", "getLength", "()I", "setLength", "(I)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "clear", "", "makeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "offer", "page", "take", "count", "expiredTimeMs", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Callback;", "Callback", "Companion", "PageData", "Policy", "plugin-finder_release"})
public final class d<T, A>
{
  public static final b KQT;
  public final Condition KQQ;
  public final LinkedList<c<T, A>> KQR;
  private final d KQS;
  public final ReentrantLock cHm;
  public int length;
  public final String name;
  
  static
  {
    AppMethodBeat.i(198365);
    KQT = new b((byte)0);
    AppMethodBeat.o(198365);
  }
  
  public d()
  {
    this(null, null, 3);
  }
  
  private d(d paramd, String paramString)
  {
    AppMethodBeat.i(198363);
    this.KQS = paramd;
    this.name = paramString;
    this.cHm = new ReentrantLock();
    this.KQQ = this.cHm.newCondition();
    this.KQR = new LinkedList();
    AppMethodBeat.o(198363);
  }
  
  public final c<T, A> a(int paramInt, long paramLong, a parama)
  {
    AppMethodBeat.i(198361);
    k.h(parama, "callback");
    ad.i("PageDataBuffer", "[take#begin] name=" + this.name + " count=" + paramInt + " expiredTimeMs=" + paramLong);
    long l1 = SystemClock.uptimeMillis();
    LinkedList localLinkedList = new LinkedList();
    c localc = new c(localLinkedList);
    this.cHm.lock();
    for (;;)
    {
      try
      {
        if ((paramInt > this.length) && (this.KQS == d.KQV))
        {
          parama.eDp();
          ad.i("PageDataBuffer", "[take#request] name=" + this.name + " count=" + paramInt + " expiredTimeMs=" + paramLong);
          this.KQQ.await();
          parama = this.KQR.iterator();
          k.g(parama, "buffer.iterator()");
          if ((!parama.hasNext()) || (localLinkedList.size() >= paramInt)) {
            break;
          }
          Object localObject = parama.next();
          k.g(localObject, "iterator.next()");
          localObject = (c)localObject;
          List localList = ((c)localObject).ahk(paramInt - localLinkedList.size());
          localLinkedList.addAll((Collection)localList);
          this.length -= localList.size();
          if (((c)localObject).fyl.size() <= 0) {
            parama.remove();
          }
          localc.KQU = ((c)localObject).KQU;
          continue;
        }
        if (this.length > 0) {
          continue;
        }
      }
      finally
      {
        this.cHm.unlock();
        AppMethodBeat.o(198361);
      }
      parama.eDp();
      ad.i("PageDataBuffer", "[take#request] name=" + this.name + " count=" + paramInt + " expiredTimeMs=" + paramLong);
      this.KQQ.await();
    }
    this.cHm.unlock();
    long l2 = paramLong - (SystemClock.uptimeMillis() - l1);
    if ((l2 > 0L) && (localLinkedList.size() > 0)) {
      SystemClock.sleep(l2);
    }
    ad.i("PageDataBuffer", "[take#end] name=" + this.name + ' ' + localc + " expiredTimeMs=" + paramLong + " length=" + this.length + " delay=" + l2 + " cost=" + (SystemClock.uptimeMillis() - l1) + "ms");
    AppMethodBeat.o(198361);
    return localc;
  }
  
  public final void a(c<T, A> paramc)
  {
    AppMethodBeat.i(198360);
    k.h(paramc, "page");
    this.cHm.lock();
    try
    {
      this.KQR.addLast(paramc);
      this.length += paramc.fyl.size();
      this.KQQ.signal();
      this.cHm.unlock();
      ad.i("PageDataBuffer", "[offer] name=" + this.name + " page=" + paramc + " length=" + this.length);
      AppMethodBeat.o(198360);
      return;
    }
    finally
    {
      this.cHm.unlock();
      AppMethodBeat.o(198360);
    }
  }
  
  public final ArrayList<T> fTA()
  {
    AppMethodBeat.i(198362);
    this.cHm.lock();
    try
    {
      ArrayList localArrayList = new ArrayList(this.length);
      Iterator localIterator = ((Iterable)this.KQR).iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll((Collection)((c)localIterator.next()).fyl);
      }
      this.cHm.unlock();
    }
    finally
    {
      this.cHm.unlock();
      AppMethodBeat.o(198362);
    }
    AppMethodBeat.o(198362);
    return localArrayList1;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Callback;", "", "request", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void eDp();
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$PageData;", "T", "A", "", "list", "Ljava/util/LinkedList;", "(Ljava/util/LinkedList;)V", "args", "getArgs", "()Ljava/lang/Object;", "setArgs", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getList", "()Ljava/util/LinkedList;", "component1", "copy", "decrement", "", "count", "", "equals", "", "other", "hashCode", "isEmpty", "size", "toString", "", "plugin-finder_release"})
  public static final class c<T, A>
  {
    public A KQU;
    public final LinkedList<T> fyl;
    
    public c(LinkedList<T> paramLinkedList)
    {
      AppMethodBeat.i(198354);
      this.fyl = paramLinkedList;
      AppMethodBeat.o(198354);
    }
    
    public final List<T> ahk(int paramInt)
    {
      AppMethodBeat.i(198352);
      Object localObject = new LinkedList();
      Iterator localIterator = this.fyl.iterator();
      k.g(localIterator, "list.iterator()");
      int i = 0;
      while ((localIterator.hasNext()) && (i < paramInt))
      {
        ((LinkedList)localObject).add(localIterator.next());
        localIterator.remove();
        i += 1;
      }
      localObject = (List)localObject;
      AppMethodBeat.o(198352);
      return localObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(198356);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if (!k.g(this.fyl, paramObject.fyl)) {}
        }
      }
      else
      {
        AppMethodBeat.o(198356);
        return true;
      }
      AppMethodBeat.o(198356);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(198355);
      LinkedList localLinkedList = this.fyl;
      if (localLinkedList != null)
      {
        int i = localLinkedList.hashCode();
        AppMethodBeat.o(198355);
        return i;
      }
      AppMethodBeat.o(198355);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(198353);
      StringBuilder localStringBuilder = new StringBuilder("PageData(size=").append(this.fyl.size()).append(" args=");
      Object localObject = this.KQU;
      if (localObject != null) {}
      for (localObject = Integer.valueOf(localObject.hashCode());; localObject = null)
      {
        localObject = localObject + ')';
        AppMethodBeat.o(198353);
        return localObject;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;", "", "(Ljava/lang/String;I)V", "GREEDY", "NORMAL", "plugin-finder_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(198357);
      d locald1 = new d("GREEDY", 0);
      KQV = locald1;
      d locald2 = new d("NORMAL", 1);
      KQW = locald2;
      KQX = new d[] { locald1, locald2 };
      AppMethodBeat.o(198357);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.d
 * JD-Core Version:    0.7.0.1
 */