package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.j;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/appbrand/v8/TaskQueueWithImportantIndexUnsafe;", "T", "Ljava/util/Queue;", "q", "(Ljava/util/Queue;)V", "lastImportantTaskIndex", "", "size", "getSize", "()I", "add", "", "element", "kotlin.jvm.PlatformType", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "containsAll", "copyToWriteUnsafe", "anotherQueue", "isPaused", "()Ljava/lang/Object;", "getLastTaskIndexToExecute", "hasImportantTask", "isEmpty", "iterator", "", "markImportantTask", "offer", "p0", "offerTask", "t", "important", "(Ljava/lang/Object;Z)V", "peek", "poll", "remove", "removeAll", "retainAll", "Companion", "luggage-v8-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l<T>
  implements Queue<T>
{
  public static final l.a hmH;
  private final Queue<T> hmI;
  int hmJ;
  
  static
  {
    AppMethodBeat.i(238664);
    hmH = new l.a((byte)0);
    AppMethodBeat.o(238664);
  }
  
  public l(Queue<T> paramQueue)
  {
    AppMethodBeat.i(238656);
    this.hmI = paramQueue;
    this.hmJ = -1;
    AppMethodBeat.o(238656);
  }
  
  public final void a(Queue<T> paramQueue, boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(238791);
    s.u(paramQueue, "anotherQueue");
    if (paramBoolean) {}
    int j;
    for (int i = this.hmJ;; i = this.hmI.size())
    {
      this.hmJ = -1;
      Iterator localIterator = ((Iterable)this.hmI).iterator();
      j = 0;
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (j < 0) {
          p.kkW();
        }
        if (j <= i) {
          paramQueue.offer(localObject);
        }
        j += 1;
      }
    }
    if (i >= 0) {
      j = k;
    }
    for (;;)
    {
      this.hmI.poll();
      if (j == i)
      {
        AppMethodBeat.o(238791);
        return;
      }
      j += 1;
    }
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(238677);
    boolean bool = this.hmI.add(paramT);
    AppMethodBeat.o(238677);
    return bool;
  }
  
  public final boolean addAll(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(238683);
    s.u(paramCollection, "elements");
    boolean bool = this.hmI.addAll(paramCollection);
    AppMethodBeat.o(238683);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(238691);
    this.hmI.clear();
    AppMethodBeat.o(238691);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(238700);
    boolean bool = this.hmI.contains(paramObject);
    AppMethodBeat.o(238700);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(238709);
    s.u(paramCollection, "elements");
    boolean bool = this.hmI.containsAll(paramCollection);
    AppMethodBeat.o(238709);
    return bool;
  }
  
  public final void d(T paramT, boolean paramBoolean)
  {
    AppMethodBeat.i(238800);
    offer(paramT);
    if (paramBoolean) {
      this.hmJ = (this.hmI.size() - 1);
    }
    AppMethodBeat.o(238800);
  }
  
  public final T element()
  {
    AppMethodBeat.i(238716);
    Object localObject = this.hmI.element();
    AppMethodBeat.o(238716);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(238725);
    boolean bool = this.hmI.isEmpty();
    AppMethodBeat.o(238725);
    return bool;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(238736);
    Iterator localIterator = this.hmI.iterator();
    AppMethodBeat.o(238736);
    return localIterator;
  }
  
  public final boolean offer(T paramT)
  {
    AppMethodBeat.i(238746);
    boolean bool = this.hmI.offer(paramT);
    AppMethodBeat.o(238746);
    return bool;
  }
  
  public final T peek()
  {
    AppMethodBeat.i(238668);
    Object localObject = this.hmI.peek();
    AppMethodBeat.o(238668);
    return localObject;
  }
  
  public final T poll()
  {
    AppMethodBeat.i(238672);
    Object localObject = this.hmI.poll();
    AppMethodBeat.o(238672);
    return localObject;
  }
  
  public final T remove()
  {
    AppMethodBeat.i(238757);
    Object localObject = this.hmI.remove();
    AppMethodBeat.o(238757);
    return localObject;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(238764);
    boolean bool = this.hmI.remove(paramObject);
    AppMethodBeat.o(238764);
    return bool;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(238771);
    s.u(paramCollection, "elements");
    boolean bool = this.hmI.removeAll(paramCollection);
    AppMethodBeat.o(238771);
    return bool;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(238781);
    s.u(paramCollection, "elements");
    boolean bool = this.hmI.retainAll(paramCollection);
    AppMethodBeat.o(238781);
    return bool;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(238821);
    Object[] arrayOfObject = j.L((Collection)this);
    AppMethodBeat.o(238821);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(238815);
    s.u(paramArrayOfT, "array");
    paramArrayOfT = j.b((Collection)this, paramArrayOfT);
    AppMethodBeat.o(238815);
    return paramArrayOfT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.l
 * JD-Core Version:    0.7.0.1
 */