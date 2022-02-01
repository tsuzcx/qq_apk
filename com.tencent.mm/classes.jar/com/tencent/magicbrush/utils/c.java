package com.tencent.magicbrush.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/utils/ListenerList;", "T", "", "()V", "listeners", "", "add", "", "l", "(Ljava/lang/Object;)V", "clear", "dispatch", "", "R", "block", "Lkotlin/Function1;", "dispatchNoThrow", "default", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "remove", "lib-magicbrush-nano_release"})
public final class c<T>
{
  public final List<T> listeners;
  
  public c()
  {
    AppMethodBeat.i(140291);
    this.listeners = ((List)new ArrayList());
    AppMethodBeat.o(140291);
  }
  
  public final void add(T paramT)
  {
    AppMethodBeat.i(140289);
    synchronized (this.listeners)
    {
      this.listeners.add(paramT);
      AppMethodBeat.o(140289);
      return;
    }
  }
  
  public final <R> List<R> b(b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(140288);
    p.h(paramb, "block");
    Object localObject1 = (List)new ArrayList();
    synchronized (this.listeners)
    {
      localObject2 = ((Iterable)this.listeners).iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(((Iterator)localObject2).next());
      }
    }
    Object localObject2 = z.Nhr;
    ??? = (List)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ???.add(paramb.invoke(((Iterator)localObject1).next()));
    }
    AppMethodBeat.o(140288);
    return ???;
  }
  
  public final void c(b<? super T, z> paramb)
  {
    AppMethodBeat.i(162128);
    p.h(paramb, "block");
    b((b)new a(paramb));
    AppMethodBeat.o(162128);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(140290);
    synchronized (this.listeners)
    {
      this.listeners.clear();
      z localz = z.Nhr;
      AppMethodBeat.o(140290);
      return;
    }
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)V"})
  static final class a
    extends q
    implements b<T, z>
  {
    a(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.utils.c
 * JD-Core Version:    0.7.0.1
 */