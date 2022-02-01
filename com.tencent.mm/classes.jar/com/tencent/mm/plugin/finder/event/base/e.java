package com.tencent.mm.plugin.finder.event.base;

import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "T", "", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getEventDispatcher", "()Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "setEventDispatcher", "getBehavior", "()Ljava/lang/Object;", "onDecorateEvent", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "publish", "plugin-finder_release"})
public abstract class e<T>
{
  public c tId;
  
  public e(c paramc)
  {
    this.tId = paramc;
  }
  
  public final void c(b paramb)
  {
    p.h(paramb, "event");
    p.h(paramb, "event");
    c localc = this.tId;
    if (localc != null) {
      localc.b(paramb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.e
 * JD-Core Version:    0.7.0.1
 */