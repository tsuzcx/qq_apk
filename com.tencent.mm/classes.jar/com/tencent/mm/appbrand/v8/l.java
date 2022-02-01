package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.f;
import d.g.b.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/appbrand/v8/TaskQueueWithImportantIndexUnsafe;", "T", "Ljava/util/Queue;", "q", "(Ljava/util/Queue;)V", "lastImportantTaskIndex", "", "size", "getSize", "()I", "add", "", "element", "kotlin.jvm.PlatformType", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "containsAll", "copyToWriteUnsafe", "anotherQueue", "isPaused", "()Ljava/lang/Object;", "getLastTaskIndexToExecute", "hasImportantTask", "isEmpty", "iterator", "", "markImportantTask", "offer", "p0", "offerTask", "t", "important", "(Ljava/lang/Object;Z)V", "peek", "poll", "remove", "removeAll", "retainAll", "Companion", "luggage-v8-ext_release"})
public final class l<T>
  implements Queue<T>
{
  public static final a cMW;
  int cMU;
  final Queue<T> cMV;
  
  static
  {
    AppMethodBeat.i(200849);
    cMW = new a((byte)0);
    AppMethodBeat.o(200849);
  }
  
  public l(Queue<T> paramQueue)
  {
    AppMethodBeat.i(200848);
    this.cMV = paramQueue;
    this.cMU = -1;
    AppMethodBeat.o(200848);
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(200851);
    boolean bool = this.cMV.add(paramT);
    AppMethodBeat.o(200851);
    return bool;
  }
  
  public final boolean addAll(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(200852);
    k.h(paramCollection, "elements");
    boolean bool = this.cMV.addAll(paramCollection);
    AppMethodBeat.o(200852);
    return bool;
  }
  
  public final void c(T paramT, boolean paramBoolean)
  {
    AppMethodBeat.i(200847);
    offer(paramT);
    if (paramBoolean) {
      this.cMU = (this.cMV.size() - 1);
    }
    AppMethodBeat.o(200847);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(200853);
    this.cMV.clear();
    AppMethodBeat.o(200853);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(200854);
    boolean bool = this.cMV.contains(paramObject);
    AppMethodBeat.o(200854);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(200855);
    k.h(paramCollection, "elements");
    boolean bool = this.cMV.containsAll(paramCollection);
    AppMethodBeat.o(200855);
    return bool;
  }
  
  public final T element()
  {
    AppMethodBeat.i(200856);
    Object localObject = this.cMV.element();
    AppMethodBeat.o(200856);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(200857);
    boolean bool = this.cMV.isEmpty();
    AppMethodBeat.o(200857);
    return bool;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(200858);
    Iterator localIterator = this.cMV.iterator();
    AppMethodBeat.o(200858);
    return localIterator;
  }
  
  public final boolean offer(T paramT)
  {
    AppMethodBeat.i(200859);
    boolean bool = this.cMV.offer(paramT);
    AppMethodBeat.o(200859);
    return bool;
  }
  
  public final T peek()
  {
    AppMethodBeat.i(200860);
    Object localObject = this.cMV.peek();
    AppMethodBeat.o(200860);
    return localObject;
  }
  
  public final T poll()
  {
    AppMethodBeat.i(200861);
    Object localObject = this.cMV.poll();
    AppMethodBeat.o(200861);
    return localObject;
  }
  
  public final T remove()
  {
    AppMethodBeat.i(200862);
    Object localObject = this.cMV.remove();
    AppMethodBeat.o(200862);
    return localObject;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(200863);
    boolean bool = this.cMV.remove(paramObject);
    AppMethodBeat.o(200863);
    return bool;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(200864);
    k.h(paramCollection, "elements");
    boolean bool = this.cMV.removeAll(paramCollection);
    AppMethodBeat.o(200864);
    return bool;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(200865);
    k.h(paramCollection, "elements");
    boolean bool = this.cMV.retainAll(paramCollection);
    AppMethodBeat.o(200865);
    return bool;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(200866);
    Object[] arrayOfObject = f.s(this);
    AppMethodBeat.o(200866);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(200867);
    paramArrayOfT = f.a(this, paramArrayOfT);
    AppMethodBeat.o(200867);
    return paramArrayOfT;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/appbrand/v8/TaskQueueWithImportantIndexUnsafe$Companion;", "", "()V", "create", "Lcom/tencent/mm/appbrand/v8/TaskQueueWithImportantIndexUnsafe;", "T", "luggage-v8-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.l
 * JD-Core Version:    0.7.0.1
 */