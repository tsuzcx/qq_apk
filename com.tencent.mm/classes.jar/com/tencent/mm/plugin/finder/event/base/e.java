package com.tencent.mm.plugin.finder.event.base;

import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "T", "", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getEventDispatcher", "()Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "setEventDispatcher", "getBehavior", "()Ljava/lang/Object;", "onDecorateEvent", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "publish", "plugin-finder_release"})
public abstract class e<T>
{
  private c rdn;
  
  public e(c paramc)
  {
    this.rdn = paramc;
  }
  
  public final void c(b paramb)
  {
    k.h(paramb, "event");
    k.h(paramb, "event");
    c localc = this.rdn;
    if (localc != null) {
      localc.b(paramb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.e
 * JD-Core Version:    0.7.0.1
 */