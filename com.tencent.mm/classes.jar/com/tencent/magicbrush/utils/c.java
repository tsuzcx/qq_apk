package com.tencent.magicbrush.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/utils/ListenerList;", "T", "", "()V", "listeners", "", "add", "", "l", "(Ljava/lang/Object;)V", "clear", "dispatch", "", "R", "block", "Lkotlin/Function1;", "dispatchNoThrow", "default", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "remove", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
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
  
  public final void clear()
  {
    AppMethodBeat.i(140290);
    synchronized (this.listeners)
    {
      this.listeners.clear();
      ah localah = ah.aiuX;
      AppMethodBeat.o(140290);
      return;
    }
  }
  
  public final <R> List<R> r(b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(140288);
    s.t(paramb, "block");
    Object localObject1 = (List)new ArrayList();
    synchronized (this.listeners)
    {
      localObject2 = ((Iterable)this.listeners).iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(((Iterator)localObject2).next());
      }
    }
    Object localObject2 = ah.aiuX;
    ??? = (List)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ???.add(paramb.invoke(((Iterator)localObject1).next()));
    }
    AppMethodBeat.o(140288);
    return ???;
  }
  
  public final void s(b<? super T, ah> paramb)
  {
    AppMethodBeat.i(162128);
    s.t(paramb, "block");
    r((b)new a(paramb));
    AppMethodBeat.o(162128);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)V"}, k=3, mv={1, 1, 16})
  static final class a
    extends u
    implements b<T, ah>
  {
    a(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.utils.c
 * JD-Core Version:    0.7.0.1
 */