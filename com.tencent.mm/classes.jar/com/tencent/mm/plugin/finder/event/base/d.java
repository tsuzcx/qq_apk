package com.tencent.mm.plugin.finder.event.base;

import com.tencent.mm.plugin.finder.life.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "()V", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "onRelease", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
  extends a
{
  public abstract void a(b paramb);
  
  public boolean a(c paramc, b paramb)
  {
    s.u(paramc, "dispatcher");
    s.u(paramb, "event");
    return true;
  }
  
  public boolean dXA()
  {
    return true;
  }
  
  public void onRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.d
 * JD-Core Version:    0.7.0.1
 */