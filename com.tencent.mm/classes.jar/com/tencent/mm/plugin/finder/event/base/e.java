package com.tencent.mm.plugin.finder.event.base;

import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "T", "", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getEventDispatcher", "()Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "setEventDispatcher", "getBehavior", "()Ljava/lang/Object;", "onDecorateEvent", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "publish", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e<T>
{
  private c ANW;
  
  public e(c paramc)
  {
    this.ANW = paramc;
  }
  
  public final void c(b paramb)
  {
    s.u(paramb, "event");
    s.u(paramb, "event");
    c localc = this.ANW;
    if (localc != null) {
      localc.b(paramb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.e
 * JD-Core Version:    0.7.0.1
 */