package com.tencent.mm.plugin.finder.event.base;

import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "T", "", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getEventDispatcher", "()Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "setEventDispatcher", "getBehavior", "()Ljava/lang/Object;", "onDecorateEvent", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "publish", "plugin-finder_release"})
public abstract class e<T>
{
  private c rQJ;
  
  public e(c paramc)
  {
    this.rQJ = paramc;
  }
  
  public final void c(b paramb)
  {
    p.h(paramb, "event");
    p.h(paramb, "event");
    c localc = this.rQJ;
    if (localc != null) {
      localc.b(paramb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.e
 * JD-Core Version:    0.7.0.1
 */