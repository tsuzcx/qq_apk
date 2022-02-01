package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/MultiEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/MultiEventSubscriber$Behavior;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "subscribes", "", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;[Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;)V", "eventSubscribes", "Ljava/util/LinkedList;", "proxy", "addSubscriber", "", "subscriber", "addSubscribers", "([Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;)V", "getBehavior", "Behavior", "plugin-finder_release"})
public class h
  extends g<a>
{
  protected final LinkedList<g<?>> qsy;
  protected final d qsz;
  
  public h(d paramd)
  {
    super(paramd);
    AppMethodBeat.i(165567);
    this.qsy = new LinkedList();
    this.qsz = new d();
    this.qsz.a((f)new f()
    {
      public final void a(c paramAnonymousc)
      {
        AppMethodBeat.i(165565);
        k.h(paramAnonymousc, "event");
        ((h.a)new h.b(this.qsA)).c(paramAnonymousc);
        AppMethodBeat.o(165565);
      }
      
      public final boolean clc()
      {
        return false;
      }
    });
    AppMethodBeat.o(165567);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/MultiEventSubscriber$Behavior;", "", "onAction", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void c(c paramc);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/event/base/MultiEventSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/event/base/MultiEventSubscriber$Behavior;", "onAction", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
  public static final class b
    implements h.a
  {
    public final void c(c paramc)
    {
      AppMethodBeat.i(165566);
      k.h(paramc, "event");
      this.qsA.b(paramc);
      AppMethodBeat.o(165566);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.h
 * JD-Core Version:    0.7.0.1
 */