package com.tencent.mm.appbrand.v8;

import androidx.annotation.RecentlyNullable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import kotlin.a.j;
import kotlin.g.b.i;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/appbrand/v8/TaskQueueWithImportantIndexUnsafe;", "T", "Ljava/util/Queue;", "q", "(Ljava/util/Queue;)V", "lastImportantTaskIndex", "", "size", "getSize", "()I", "add", "", "element", "kotlin.jvm.PlatformType", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "containsAll", "copyToWriteUnsafe", "anotherQueue", "isPaused", "()Ljava/lang/Object;", "getLastTaskIndexToExecute", "hasImportantTask", "isEmpty", "iterator", "", "markImportantTask", "offer", "p0", "offerTask", "t", "important", "(Ljava/lang/Object;Z)V", "peek", "poll", "remove", "removeAll", "retainAll", "Companion", "luggage-v8-ext_release"})
public final class l<T>
  implements Queue<T>
{
  public static final l.a dpP;
  private int dpN;
  private final Queue<T> dpO;
  
  static
  {
    AppMethodBeat.i(216939);
    dpP = new l.a((byte)0);
    AppMethodBeat.o(216939);
  }
  
  public l(Queue<T> paramQueue)
  {
    AppMethodBeat.i(216938);
    this.dpO = paramQueue;
    this.dpN = -1;
    AppMethodBeat.o(216938);
  }
  
  public final boolean XI()
  {
    return this.dpN >= 0;
  }
  
  public final void a(Queue<T> paramQueue, boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(216936);
    p.h(paramQueue, "anotherQueue");
    if (paramBoolean) {}
    int j;
    for (int i = this.dpN;; i = this.dpO.size())
    {
      this.dpN = -1;
      Iterator localIterator = ((Iterable)this.dpO).iterator();
      j = 0;
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (j < 0) {
          j.hxH();
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
        this.dpO.poll();
        if (j == i) {
          break;
        }
        j += 1;
      }
    }
    AppMethodBeat.o(216936);
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(216941);
    boolean bool = this.dpO.add(paramT);
    AppMethodBeat.o(216941);
    return bool;
  }
  
  public final boolean addAll(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(216942);
    p.h(paramCollection, "elements");
    boolean bool = this.dpO.addAll(paramCollection);
    AppMethodBeat.o(216942);
    return bool;
  }
  
  public final void b(T paramT, boolean paramBoolean)
  {
    AppMethodBeat.i(216937);
    offer(paramT);
    if (paramBoolean) {
      this.dpN = (this.dpO.size() - 1);
    }
    AppMethodBeat.o(216937);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(216943);
    this.dpO.clear();
    AppMethodBeat.o(216943);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(216944);
    boolean bool = this.dpO.contains(paramObject);
    AppMethodBeat.o(216944);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(216945);
    p.h(paramCollection, "elements");
    boolean bool = this.dpO.containsAll(paramCollection);
    AppMethodBeat.o(216945);
    return bool;
  }
  
  public final T element()
  {
    AppMethodBeat.i(216946);
    Object localObject = this.dpO.element();
    AppMethodBeat.o(216946);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(216947);
    boolean bool = this.dpO.isEmpty();
    AppMethodBeat.o(216947);
    return bool;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(216948);
    Iterator localIterator = this.dpO.iterator();
    AppMethodBeat.o(216948);
    return localIterator;
  }
  
  public final boolean offer(T paramT)
  {
    AppMethodBeat.i(216949);
    boolean bool = this.dpO.offer(paramT);
    AppMethodBeat.o(216949);
    return bool;
  }
  
  @RecentlyNullable
  public final T peek()
  {
    AppMethodBeat.i(216950);
    Object localObject = this.dpO.peek();
    AppMethodBeat.o(216950);
    return localObject;
  }
  
  @RecentlyNullable
  public final T poll()
  {
    AppMethodBeat.i(216951);
    Object localObject = this.dpO.poll();
    AppMethodBeat.o(216951);
    return localObject;
  }
  
  public final T remove()
  {
    AppMethodBeat.i(216952);
    Object localObject = this.dpO.remove();
    AppMethodBeat.o(216952);
    return localObject;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(216953);
    boolean bool = this.dpO.remove(paramObject);
    AppMethodBeat.o(216953);
    return bool;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(216954);
    p.h(paramCollection, "elements");
    boolean bool = this.dpO.removeAll(paramCollection);
    AppMethodBeat.o(216954);
    return bool;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(216955);
    p.h(paramCollection, "elements");
    boolean bool = this.dpO.retainAll(paramCollection);
    AppMethodBeat.o(216955);
    return bool;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(216956);
    Object[] arrayOfObject = i.w(this);
    AppMethodBeat.o(216956);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(216957);
    paramArrayOfT = i.a(this, paramArrayOfT);
    AppMethodBeat.o(216957);
    return paramArrayOfT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.l
 * JD-Core Version:    0.7.0.1
 */