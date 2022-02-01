package com.tencent.mm.appbrand.v8;

import androidx.annotation.RecentlyNullable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import kotlin.a.j;
import kotlin.g.b.i;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/appbrand/v8/TaskQueueWithImportantIndexUnsafe;", "T", "Ljava/util/Queue;", "q", "(Ljava/util/Queue;)V", "lastImportantTaskIndex", "", "size", "getSize", "()I", "add", "", "element", "kotlin.jvm.PlatformType", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "containsAll", "copyToWriteUnsafe", "anotherQueue", "isPaused", "()Ljava/lang/Object;", "getLastTaskIndexToExecute", "hasImportantTask", "isEmpty", "iterator", "", "markImportantTask", "offer", "p0", "offerTask", "t", "important", "(Ljava/lang/Object;Z)V", "peek", "poll", "remove", "removeAll", "retainAll", "Companion", "luggage-v8-ext_release"})
public final class l<T>
  implements Queue<T>
{
  public static final l.a fix;
  private int fiv;
  private final Queue<T> fiw;
  
  static
  {
    AppMethodBeat.i(262369);
    fix = new l.a((byte)0);
    AppMethodBeat.o(262369);
  }
  
  public l(Queue<T> paramQueue)
  {
    AppMethodBeat.i(262365);
    this.fiw = paramQueue;
    this.fiv = -1;
    AppMethodBeat.o(262365);
  }
  
  public final void a(Queue<T> paramQueue, boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(262359);
    p.k(paramQueue, "anotherQueue");
    if (paramBoolean) {}
    int j;
    for (int i = this.fiv;; i = this.fiw.size())
    {
      this.fiv = -1;
      Iterator localIterator = ((Iterable)this.fiw).iterator();
      j = 0;
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (j < 0) {
          j.iBO();
        }
        if (j <= i) {
          paramQueue.offer(localObject);
        }
        j += 1;
      }
    }
    if (i >= 0)
    {
      j = k;
      for (;;)
      {
        this.fiw.poll();
        if (j == i) {
          break;
        }
        j += 1;
      }
    }
    AppMethodBeat.o(262359);
  }
  
  public final boolean acl()
  {
    return this.fiv >= 0;
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(262374);
    boolean bool = this.fiw.add(paramT);
    AppMethodBeat.o(262374);
    return bool;
  }
  
  public final boolean addAll(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(262377);
    p.k(paramCollection, "elements");
    boolean bool = this.fiw.addAll(paramCollection);
    AppMethodBeat.o(262377);
    return bool;
  }
  
  public final void c(T paramT, boolean paramBoolean)
  {
    AppMethodBeat.i(262361);
    offer(paramT);
    if (paramBoolean) {
      this.fiv = (this.fiw.size() - 1);
    }
    AppMethodBeat.o(262361);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(262379);
    this.fiw.clear();
    AppMethodBeat.o(262379);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(262382);
    boolean bool = this.fiw.contains(paramObject);
    AppMethodBeat.o(262382);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(262385);
    p.k(paramCollection, "elements");
    boolean bool = this.fiw.containsAll(paramCollection);
    AppMethodBeat.o(262385);
    return bool;
  }
  
  public final T element()
  {
    AppMethodBeat.i(262387);
    Object localObject = this.fiw.element();
    AppMethodBeat.o(262387);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(262388);
    boolean bool = this.fiw.isEmpty();
    AppMethodBeat.o(262388);
    return bool;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(262389);
    Iterator localIterator = this.fiw.iterator();
    AppMethodBeat.o(262389);
    return localIterator;
  }
  
  public final boolean offer(T paramT)
  {
    AppMethodBeat.i(262390);
    boolean bool = this.fiw.offer(paramT);
    AppMethodBeat.o(262390);
    return bool;
  }
  
  @RecentlyNullable
  public final T peek()
  {
    AppMethodBeat.i(262392);
    Object localObject = this.fiw.peek();
    AppMethodBeat.o(262392);
    return localObject;
  }
  
  @RecentlyNullable
  public final T poll()
  {
    AppMethodBeat.i(262393);
    Object localObject = this.fiw.poll();
    AppMethodBeat.o(262393);
    return localObject;
  }
  
  public final T remove()
  {
    AppMethodBeat.i(262395);
    Object localObject = this.fiw.remove();
    AppMethodBeat.o(262395);
    return localObject;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(262396);
    boolean bool = this.fiw.remove(paramObject);
    AppMethodBeat.o(262396);
    return bool;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(262397);
    p.k(paramCollection, "elements");
    boolean bool = this.fiw.removeAll(paramCollection);
    AppMethodBeat.o(262397);
    return bool;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(262398);
    p.k(paramCollection, "elements");
    boolean bool = this.fiw.retainAll(paramCollection);
    AppMethodBeat.o(262398);
    return bool;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(262400);
    Object[] arrayOfObject = i.u(this);
    AppMethodBeat.o(262400);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(262401);
    paramArrayOfT = i.b(this, paramArrayOfT);
    AppMethodBeat.o(262401);
    return paramArrayOfT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.l
 * JD-Core Version:    0.7.0.1
 */