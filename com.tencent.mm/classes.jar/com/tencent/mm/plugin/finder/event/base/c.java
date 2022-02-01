package com.tencent.mm.plugin.finder.event.base;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.life.a;
import d.a.e;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "", "threadTag", "", "(Ljava/lang/String;)V", "eventObservers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isRelease", "", "addObserver", "", "observer", "doEvent", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onRelease", "removeObserver", "Companion", "plugin-finder_release"})
public final class c
{
  public static final c.a rdj;
  private volatile boolean gRc;
  private final ConcurrentHashMap<d, Object> rdh;
  private final String rdi;
  
  static
  {
    AppMethodBeat.i(165556);
    rdj = new c.a((byte)0);
    AppMethodBeat.o(165556);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(201409);
    this.rdi = paramString;
    this.rdh = new ConcurrentHashMap();
    AppMethodBeat.o(201409);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(165553);
    k.h(paramd, "observer");
    ((Map)this.rdh).put(paramd, new Object());
    AppMethodBeat.o(165553);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(201407);
    k.h(paramb, "event");
    if (this.gRc)
    {
      AppMethodBeat.o(201407);
      return;
    }
    Iterator localIterator = ((Map)this.rdh).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((d)localEntry.getKey()).a(this, paramb))
      {
        d locald = (d)localEntry.getKey();
        if (e.contains(locald.rsS, locald.rsR)) {
          if (((d)localEntry.getKey()).csW()) {
            h.JZN.f((Runnable)new c.b(localEntry, this, paramb), this.rdi);
          } else {
            ((d)localEntry.getKey()).a(paramb);
          }
        }
      }
    }
    AppMethodBeat.o(201407);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(165554);
    if ((paramd == null) || (!this.rdh.containsKey(paramd)))
    {
      AppMethodBeat.o(165554);
      return;
    }
    this.rdh.remove(paramd);
    AppMethodBeat.o(165554);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(201408);
    this.gRc = true;
    h.JZN.aTz("EventDispatcher");
    Iterator localIterator = ((Map)this.rdh).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getKey()).onRelease();
    }
    this.rdh.clear();
    AppMethodBeat.o(201408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.c
 * JD-Core Version:    0.7.0.1
 */