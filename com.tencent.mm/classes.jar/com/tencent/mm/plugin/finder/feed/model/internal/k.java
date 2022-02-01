package com.tencent.mm.plugin.finder.feed.model.internal;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "T", "A", "", "policy", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;", "name", "", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;Ljava/lang/String;)V", "buffer", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$PageData;", "empty", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "length", "", "getLength", "()I", "setLength", "(I)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "clear", "", "makeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "offer", "page", "take", "count", "expiredTimeMs", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Callback;", "Callback", "Companion", "PageData", "Policy", "plugin-finder_release"})
public final class k<T, A>
{
  public static final b slV;
  public final ReentrantLock cQj;
  public int length;
  public final String name;
  public final Condition slS;
  public final LinkedList<c<T, A>> slT;
  private final k.d slU;
  
  static
  {
    AppMethodBeat.i(203078);
    slV = new b((byte)0);
    AppMethodBeat.o(203078);
  }
  
  public k()
  {
    this(null, null, 3);
  }
  
  private k(k.d paramd, String paramString)
  {
    AppMethodBeat.i(203076);
    this.slU = paramd;
    this.name = paramString;
    this.cQj = new ReentrantLock();
    this.slS = this.cQj.newCondition();
    this.slT = new LinkedList();
    AppMethodBeat.o(203076);
  }
  
  public final c<T, A> a(int paramInt, long paramLong, a parama)
  {
    AppMethodBeat.i(203074);
    p.h(parama, "callback");
    ae.i("PageDataBuffer", "[take#begin] name=" + this.name + " count=" + paramInt + " expiredTimeMs=" + paramLong);
    long l1 = SystemClock.uptimeMillis();
    LinkedList localLinkedList = new LinkedList();
    c localc = new c(localLinkedList);
    this.cQj.lock();
    for (;;)
    {
      try
      {
        if ((paramInt > this.length) && (this.slU == k.d.slW))
        {
          parama.cAs();
          ae.i("PageDataBuffer", "[take#request] name=" + this.name + " count=" + paramInt + " expiredTimeMs=" + paramLong);
          this.slS.await();
          parama = this.slT.iterator();
          p.g(parama, "buffer.iterator()");
          if ((!parama.hasNext()) || (localLinkedList.size() >= paramInt)) {
            break;
          }
          Object localObject = parama.next();
          p.g(localObject, "iterator.next()");
          localObject = (c)localObject;
          List localList = ((c)localObject).ER(paramInt - localLinkedList.size());
          localLinkedList.addAll((Collection)localList);
          this.length -= localList.size();
          if (((c)localObject).fXm.size() <= 0) {
            parama.remove();
          }
          localc.iiU = ((c)localObject).iiU;
          continue;
        }
        if (this.length > 0) {
          continue;
        }
      }
      finally
      {
        this.cQj.unlock();
        AppMethodBeat.o(203074);
      }
      parama.cAs();
      ae.i("PageDataBuffer", "[take#request] name=" + this.name + " count=" + paramInt + " expiredTimeMs=" + paramLong);
      this.slS.await();
    }
    this.cQj.unlock();
    long l2 = paramLong - (SystemClock.uptimeMillis() - l1);
    if ((l2 > 0L) && (localLinkedList.size() > 0)) {
      SystemClock.sleep(l2);
    }
    ae.i("PageDataBuffer", "[take#end] name=" + this.name + ' ' + localc + " expiredTimeMs=" + paramLong + " length=" + this.length + " delay=" + l2 + " cost=" + (SystemClock.uptimeMillis() - l1) + "ms");
    AppMethodBeat.o(203074);
    return localc;
  }
  
  public final void a(c<T, A> paramc)
  {
    AppMethodBeat.i(203073);
    p.h(paramc, "page");
    this.cQj.lock();
    try
    {
      this.slT.addLast(paramc);
      this.length += paramc.fXm.size();
      this.slS.signal();
      this.cQj.unlock();
      ae.i("PageDataBuffer", "[offer] name=" + this.name + " page=" + paramc + " length=" + this.length);
      AppMethodBeat.o(203073);
      return;
    }
    finally
    {
      this.cQj.unlock();
      AppMethodBeat.o(203073);
    }
  }
  
  public final ArrayList<T> cDI()
  {
    AppMethodBeat.i(203075);
    this.cQj.lock();
    try
    {
      ArrayList localArrayList = new ArrayList(this.length);
      Iterator localIterator = ((Iterable)this.slT).iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll((Collection)((c)localIterator.next()).fXm);
      }
      this.cQj.unlock();
    }
    finally
    {
      this.cQj.unlock();
      AppMethodBeat.o(203075);
    }
    AppMethodBeat.o(203075);
    return localArrayList1;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Callback;", "", "request", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void cAs();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$PageData;", "T", "A", "", "list", "Ljava/util/LinkedList;", "(Ljava/util/LinkedList;)V", "args", "getArgs", "()Ljava/lang/Object;", "setArgs", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getList", "()Ljava/util/LinkedList;", "component1", "copy", "decrement", "", "count", "", "equals", "", "other", "hashCode", "isEmpty", "size", "toString", "", "plugin-finder_release"})
  public static final class c<T, A>
  {
    public final LinkedList<T> fXm;
    public A iiU;
    
    public c(LinkedList<T> paramLinkedList)
    {
      AppMethodBeat.i(203067);
      this.fXm = paramLinkedList;
      AppMethodBeat.o(203067);
    }
    
    public final List<T> ER(int paramInt)
    {
      AppMethodBeat.i(203065);
      Object localObject = new LinkedList();
      Iterator localIterator = this.fXm.iterator();
      p.g(localIterator, "list.iterator()");
      int i = 0;
      while ((localIterator.hasNext()) && (i < paramInt))
      {
        ((LinkedList)localObject).add(localIterator.next());
        localIterator.remove();
        i += 1;
      }
      localObject = (List)localObject;
      AppMethodBeat.o(203065);
      return localObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(203069);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if (!p.i(this.fXm, paramObject.fXm)) {}
        }
      }
      else
      {
        AppMethodBeat.o(203069);
        return true;
      }
      AppMethodBeat.o(203069);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(203068);
      LinkedList localLinkedList = this.fXm;
      if (localLinkedList != null)
      {
        int i = localLinkedList.hashCode();
        AppMethodBeat.o(203068);
        return i;
      }
      AppMethodBeat.o(203068);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(203066);
      StringBuilder localStringBuilder = new StringBuilder("PageData(size=").append(this.fXm.size()).append(" args=");
      Object localObject = this.iiU;
      if (localObject != null) {}
      for (localObject = Integer.valueOf(localObject.hashCode());; localObject = null)
      {
        localObject = localObject + ')';
        AppMethodBeat.o(203066);
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.k
 * JD-Core Version:    0.7.0.1
 */