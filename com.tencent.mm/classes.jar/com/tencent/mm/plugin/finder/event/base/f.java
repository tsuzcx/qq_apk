package com.tencent.mm.plugin.finder.event.base;

import com.tencent.mm.plugin.finder.life.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "()V", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "onRelease", "plugin-finder_release"})
public abstract class f
  extends a
{
  public abstract void a(c paramc);
  
  public boolean a(d paramd, c paramc)
  {
    k.h(paramd, "dispatcher");
    k.h(paramc, "event");
    return true;
  }
  
  public boolean clc()
  {
    return true;
  }
  
  public void onRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.f
 * JD-Core Version:    0.7.0.1
 */