package com.tencent.mm.plugin.finder.event.base;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.life.a;
import d.a.e;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "", "threadTag", "", "(Ljava/lang/String;)V", "eventObservers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isRelease", "", "addObserver", "", "observer", "doEvent", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onRelease", "removeObserver", "Companion", "plugin-finder_release"})
public final class c
{
  public static final a rZh;
  private volatile boolean hmi;
  private final ConcurrentHashMap<d, Object> rZf;
  private final String rZg;
  
  static
  {
    AppMethodBeat.i(165556);
    rZh = new a((byte)0);
    AppMethodBeat.o(165556);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(201997);
    this.rZg = paramString;
    this.rZf = new ConcurrentHashMap();
    AppMethodBeat.o(201997);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(165553);
    p.h(paramd, "observer");
    ((Map)this.rZf).put(paramd, new Object());
    AppMethodBeat.o(165553);
  }
  
  public final void b(final b paramb)
  {
    AppMethodBeat.i(201995);
    p.h(paramb, "event");
    if (this.hmi)
    {
      AppMethodBeat.o(201995);
      return;
    }
    Iterator localIterator = ((Map)this.rZf).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((d)localEntry.getKey()).a(this, paramb))
      {
        d locald = (d)localEntry.getKey();
        if (e.contains(locald.sra, locald.sqZ)) {
          if (((d)localEntry.getKey()).cAA()) {
            h.MqF.f((Runnable)new b(localEntry, this, paramb), this.rZg);
          } else {
            ((d)localEntry.getKey()).a(paramb);
          }
        }
      }
    }
    AppMethodBeat.o(201995);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(165554);
    if ((paramd == null) || (!this.rZf.containsKey(paramd)))
    {
      AppMethodBeat.o(165554);
      return;
    }
    this.rZf.remove(paramd);
    AppMethodBeat.o(165554);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(201996);
    this.hmi = true;
    h.MqF.bbc("EventDispatcher");
    Iterator localIterator = ((Map)this.rZf).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getKey()).onRelease();
    }
    this.rZf.clear();
    AppMethodBeat.o(201996);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/event/base/EventDispatcher$doEvent$1$1"})
  static final class b
    implements Runnable
  {
    b(Map.Entry paramEntry, c paramc, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(165552);
      ((d)this.rZi.getKey()).a(paramb);
      AppMethodBeat.o(165552);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.c
 * JD-Core Version:    0.7.0.1
 */