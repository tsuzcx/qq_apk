package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.f;
import d.g.b.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/appbrand/v8/TaskQueueWithImportantIndexUnsafe;", "T", "Ljava/util/Queue;", "q", "(Ljava/util/Queue;)V", "lastImportantTaskIndex", "", "size", "getSize", "()I", "add", "", "element", "kotlin.jvm.PlatformType", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "containsAll", "copyToWriteUnsafe", "anotherQueue", "isPaused", "()Ljava/lang/Object;", "getLastTaskIndexToExecute", "hasImportantTask", "isEmpty", "iterator", "", "markImportantTask", "offer", "p0", "offerTask", "t", "important", "(Ljava/lang/Object;Z)V", "peek", "poll", "remove", "removeAll", "retainAll", "Companion", "luggage-v8-ext_release"})
public final class l<T>
  implements Queue<T>
{
  public static final l.a cPB;
  final Queue<T> cPA;
  int cPz;
  
  static
  {
    AppMethodBeat.i(193523);
    cPB = new l.a((byte)0);
    AppMethodBeat.o(193523);
  }
  
  public l(Queue<T> paramQueue)
  {
    AppMethodBeat.i(193522);
    this.cPA = paramQueue;
    this.cPz = -1;
    AppMethodBeat.o(193522);
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(193525);
    boolean bool = this.cPA.add(paramT);
    AppMethodBeat.o(193525);
    return bool;
  }
  
  public final boolean addAll(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(193526);
    k.h(paramCollection, "elements");
    boolean bool = this.cPA.addAll(paramCollection);
    AppMethodBeat.o(193526);
    return bool;
  }
  
  public final void b(T paramT, boolean paramBoolean)
  {
    AppMethodBeat.i(193521);
    offer(paramT);
    if (paramBoolean) {
      this.cPz = (this.cPA.size() - 1);
    }
    AppMethodBeat.o(193521);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(193527);
    this.cPA.clear();
    AppMethodBeat.o(193527);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(193528);
    boolean bool = this.cPA.contains(paramObject);
    AppMethodBeat.o(193528);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(193529);
    k.h(paramCollection, "elements");
    boolean bool = this.cPA.containsAll(paramCollection);
    AppMethodBeat.o(193529);
    return bool;
  }
  
  public final T element()
  {
    AppMethodBeat.i(193530);
    Object localObject = this.cPA.element();
    AppMethodBeat.o(193530);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(193531);
    boolean bool = this.cPA.isEmpty();
    AppMethodBeat.o(193531);
    return bool;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(193532);
    Iterator localIterator = this.cPA.iterator();
    AppMethodBeat.o(193532);
    return localIterator;
  }
  
  public final boolean offer(T paramT)
  {
    AppMethodBeat.i(193533);
    boolean bool = this.cPA.offer(paramT);
    AppMethodBeat.o(193533);
    return bool;
  }
  
  public final T peek()
  {
    AppMethodBeat.i(193534);
    Object localObject = this.cPA.peek();
    AppMethodBeat.o(193534);
    return localObject;
  }
  
  public final T poll()
  {
    AppMethodBeat.i(193535);
    Object localObject = this.cPA.poll();
    AppMethodBeat.o(193535);
    return localObject;
  }
  
  public final T remove()
  {
    AppMethodBeat.i(193536);
    Object localObject = this.cPA.remove();
    AppMethodBeat.o(193536);
    return localObject;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(193537);
    boolean bool = this.cPA.remove(paramObject);
    AppMethodBeat.o(193537);
    return bool;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(193538);
    k.h(paramCollection, "elements");
    boolean bool = this.cPA.removeAll(paramCollection);
    AppMethodBeat.o(193538);
    return bool;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(193539);
    k.h(paramCollection, "elements");
    boolean bool = this.cPA.retainAll(paramCollection);
    AppMethodBeat.o(193539);
    return bool;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(193540);
    Object[] arrayOfObject = f.r(this);
    AppMethodBeat.o(193540);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(193541);
    paramArrayOfT = f.a(this, paramArrayOfT);
    AppMethodBeat.o(193541);
    return paramArrayOfT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.l
 * JD-Core Version:    0.7.0.1
 */