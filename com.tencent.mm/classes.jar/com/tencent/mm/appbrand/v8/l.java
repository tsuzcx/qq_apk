package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.i;
import d.g.b.p;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/appbrand/v8/TaskQueueWithImportantIndexUnsafe;", "T", "Ljava/util/Queue;", "q", "(Ljava/util/Queue;)V", "lastImportantTaskIndex", "", "size", "getSize", "()I", "add", "", "element", "kotlin.jvm.PlatformType", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "containsAll", "copyToWriteUnsafe", "anotherQueue", "isPaused", "()Ljava/lang/Object;", "getLastTaskIndexToExecute", "hasImportantTask", "isEmpty", "iterator", "", "markImportantTask", "offer", "p0", "offerTask", "t", "important", "(Ljava/lang/Object;Z)V", "peek", "poll", "remove", "removeAll", "retainAll", "Companion", "luggage-v8-ext_release"})
public final class l<T>
  implements Queue<T>
{
  public static final a cZk;
  private int cZi;
  private final Queue<T> cZj;
  
  static
  {
    AppMethodBeat.i(194133);
    cZk = new a((byte)0);
    AppMethodBeat.o(194133);
  }
  
  public l(Queue<T> paramQueue)
  {
    AppMethodBeat.i(194132);
    this.cZj = paramQueue;
    this.cZi = -1;
    AppMethodBeat.o(194132);
  }
  
  public final boolean Nw()
  {
    return this.cZi >= 0;
  }
  
  public final void a(Queue<T> paramQueue, boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(194130);
    p.h(paramQueue, "anotherQueue");
    if (paramBoolean) {}
    int j;
    for (int i = this.cZi;; i = this.cZj.size())
    {
      this.cZi = -1;
      Iterator localIterator = ((Iterable)this.cZj).iterator();
      j = 0;
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (j < 0) {
          j.gkd();
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
        this.cZj.poll();
        if (j == i) {
          break;
        }
        j += 1;
      }
    }
    AppMethodBeat.o(194130);
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(194135);
    boolean bool = this.cZj.add(paramT);
    AppMethodBeat.o(194135);
    return bool;
  }
  
  public final boolean addAll(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(194136);
    p.h(paramCollection, "elements");
    boolean bool = this.cZj.addAll(paramCollection);
    AppMethodBeat.o(194136);
    return bool;
  }
  
  public final void c(T paramT, boolean paramBoolean)
  {
    AppMethodBeat.i(194131);
    offer(paramT);
    if (paramBoolean) {
      this.cZi = (this.cZj.size() - 1);
    }
    AppMethodBeat.o(194131);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(194137);
    this.cZj.clear();
    AppMethodBeat.o(194137);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(194138);
    boolean bool = this.cZj.contains(paramObject);
    AppMethodBeat.o(194138);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(194139);
    p.h(paramCollection, "elements");
    boolean bool = this.cZj.containsAll(paramCollection);
    AppMethodBeat.o(194139);
    return bool;
  }
  
  public final T element()
  {
    AppMethodBeat.i(194140);
    Object localObject = this.cZj.element();
    AppMethodBeat.o(194140);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(194141);
    boolean bool = this.cZj.isEmpty();
    AppMethodBeat.o(194141);
    return bool;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(194142);
    Iterator localIterator = this.cZj.iterator();
    AppMethodBeat.o(194142);
    return localIterator;
  }
  
  public final boolean offer(T paramT)
  {
    AppMethodBeat.i(194143);
    boolean bool = this.cZj.offer(paramT);
    AppMethodBeat.o(194143);
    return bool;
  }
  
  public final T peek()
  {
    AppMethodBeat.i(194144);
    Object localObject = this.cZj.peek();
    AppMethodBeat.o(194144);
    return localObject;
  }
  
  public final T poll()
  {
    AppMethodBeat.i(194145);
    Object localObject = this.cZj.poll();
    AppMethodBeat.o(194145);
    return localObject;
  }
  
  public final T remove()
  {
    AppMethodBeat.i(194146);
    Object localObject = this.cZj.remove();
    AppMethodBeat.o(194146);
    return localObject;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(194147);
    boolean bool = this.cZj.remove(paramObject);
    AppMethodBeat.o(194147);
    return bool;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(194148);
    p.h(paramCollection, "elements");
    boolean bool = this.cZj.removeAll(paramCollection);
    AppMethodBeat.o(194148);
    return bool;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(194149);
    p.h(paramCollection, "elements");
    boolean bool = this.cZj.retainAll(paramCollection);
    AppMethodBeat.o(194149);
    return bool;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(194150);
    Object[] arrayOfObject = i.t(this);
    AppMethodBeat.o(194150);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(194151);
    paramArrayOfT = i.a(this, paramArrayOfT);
    AppMethodBeat.o(194151);
    return paramArrayOfT;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/appbrand/v8/TaskQueueWithImportantIndexUnsafe$Companion;", "", "()V", "create", "Lcom/tencent/mm/appbrand/v8/TaskQueueWithImportantIndexUnsafe;", "T", "luggage-v8-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.l
 * JD-Core Version:    0.7.0.1
 */