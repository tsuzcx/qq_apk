package com.tencent.mm.plugin.finder.event.base;

import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "T", "", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getEventDispatcher", "()Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "setEventDispatcher", "getBehavior", "()Ljava/lang/Object;", "onDecorateEvent", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "publish", "plugin-finder_release"})
public abstract class g<T>
{
  protected d qsx;
  
  public g(d paramd)
  {
    this.qsx = paramd;
  }
  
  public void b(c paramc)
  {
    k.h(paramc, "event");
    k.h(paramc, "event");
    d locald = this.qsx;
    if (locald != null) {
      locald.d(paramc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.g
 * JD-Core Version:    0.7.0.1
 */