package com.tencent.mm.plugin.finder.event.base;

import com.tencent.mm.plugin.finder.life.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "()V", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "onRelease", "plugin-finder_release"})
public abstract class d
  extends a
{
  public abstract void a(b paramb);
  
  public boolean a(c paramc, b paramb)
  {
    p.h(paramc, "dispatcher");
    p.h(paramb, "event");
    return true;
  }
  
  public boolean cyW()
  {
    return true;
  }
  
  public void onRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.d
 * JD-Core Version:    0.7.0.1
 */