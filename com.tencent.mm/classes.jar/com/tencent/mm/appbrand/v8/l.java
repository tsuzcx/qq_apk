package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.i;
import d.g.b.p;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/appbrand/v8/TaskQueueWithImportantIndexUnsafe;", "T", "Ljava/util/Queue;", "q", "(Ljava/util/Queue;)V", "lastImportantTaskIndex", "", "size", "getSize", "()I", "add", "", "element", "kotlin.jvm.PlatformType", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "containsAll", "copyToWriteUnsafe", "anotherQueue", "isPaused", "()Ljava/lang/Object;", "getLastTaskIndexToExecute", "hasImportantTask", "isEmpty", "iterator", "", "markImportantTask", "offer", "p0", "offerTask", "t", "important", "(Ljava/lang/Object;Z)V", "peek", "poll", "remove", "removeAll", "retainAll", "Companion", "luggage-v8-ext_release"})
public final class l<T>
  implements Queue<T>
{
  public static final l.a cYm;
  int cYk;
  final Queue<T> cYl;
  
  static
  {
    AppMethodBeat.i(198724);
    cYm = new l.a((byte)0);
    AppMethodBeat.o(198724);
  }
  
  public l(Queue<T> paramQueue)
  {
    AppMethodBeat.i(198723);
    this.cYl = paramQueue;
    this.cYk = -1;
    AppMethodBeat.o(198723);
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(198726);
    boolean bool = this.cYl.add(paramT);
    AppMethodBeat.o(198726);
    return bool;
  }
  
  public final boolean addAll(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(198727);
    p.h(paramCollection, "elements");
    boolean bool = this.cYl.addAll(paramCollection);
    AppMethodBeat.o(198727);
    return bool;
  }
  
  public final void c(T paramT, boolean paramBoolean)
  {
    AppMethodBeat.i(198722);
    offer(paramT);
    if (paramBoolean) {
      this.cYk = (this.cYl.size() - 1);
    }
    AppMethodBeat.o(198722);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(198728);
    this.cYl.clear();
    AppMethodBeat.o(198728);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(198729);
    boolean bool = this.cYl.contains(paramObject);
    AppMethodBeat.o(198729);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(198730);
    p.h(paramCollection, "elements");
    boolean bool = this.cYl.containsAll(paramCollection);
    AppMethodBeat.o(198730);
    return bool;
  }
  
  public final T element()
  {
    AppMethodBeat.i(198731);
    Object localObject = this.cYl.element();
    AppMethodBeat.o(198731);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(198732);
    boolean bool = this.cYl.isEmpty();
    AppMethodBeat.o(198732);
    return bool;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(198733);
    Iterator localIterator = this.cYl.iterator();
    AppMethodBeat.o(198733);
    return localIterator;
  }
  
  public final boolean offer(T paramT)
  {
    AppMethodBeat.i(198734);
    boolean bool = this.cYl.offer(paramT);
    AppMethodBeat.o(198734);
    return bool;
  }
  
  public final T peek()
  {
    AppMethodBeat.i(198735);
    Object localObject = this.cYl.peek();
    AppMethodBeat.o(198735);
    return localObject;
  }
  
  public final T poll()
  {
    AppMethodBeat.i(198736);
    Object localObject = this.cYl.poll();
    AppMethodBeat.o(198736);
    return localObject;
  }
  
  public final T remove()
  {
    AppMethodBeat.i(198737);
    Object localObject = this.cYl.remove();
    AppMethodBeat.o(198737);
    return localObject;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(198738);
    boolean bool = this.cYl.remove(paramObject);
    AppMethodBeat.o(198738);
    return bool;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(198739);
    p.h(paramCollection, "elements");
    boolean bool = this.cYl.removeAll(paramCollection);
    AppMethodBeat.o(198739);
    return bool;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(198740);
    p.h(paramCollection, "elements");
    boolean bool = this.cYl.retainAll(paramCollection);
    AppMethodBeat.o(198740);
    return bool;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(198741);
    Object[] arrayOfObject = i.t(this);
    AppMethodBeat.o(198741);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(198742);
    paramArrayOfT = i.a(this, paramArrayOfT);
    AppMethodBeat.o(198742);
    return paramArrayOfT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.l
 * JD-Core Version:    0.7.0.1
 */