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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "", "threadTag", "", "(Ljava/lang/String;)V", "eventObservers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isRelease", "", "addObserver", "", "observer", "doEvent", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onRelease", "removeObserver", "Companion", "plugin-finder_release"})
public final class c
{
  public static final a rQF;
  private volatile boolean hju;
  private final ConcurrentHashMap<d, Object> rQD;
  private final String rQE;
  
  static
  {
    AppMethodBeat.i(165556);
    rQF = new a((byte)0);
    AppMethodBeat.o(165556);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(201550);
    this.rQE = paramString;
    this.rQD = new ConcurrentHashMap();
    AppMethodBeat.o(201550);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(165553);
    p.h(paramd, "observer");
    ((Map)this.rQD).put(paramd, new Object());
    AppMethodBeat.o(165553);
  }
  
  public final void b(final b paramb)
  {
    AppMethodBeat.i(201548);
    p.h(paramb, "event");
    if (this.hju)
    {
      AppMethodBeat.o(201548);
      return;
    }
    Iterator localIterator = ((Map)this.rQD).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((d)localEntry.getKey()).a(this, paramb))
      {
        d locald = (d)localEntry.getKey();
        if (e.contains(locald.sif, locald.sie)) {
          if (((d)localEntry.getKey()).cyW()) {
            h.LTJ.f((Runnable)new b(localEntry, this, paramb), this.rQE);
          } else {
            ((d)localEntry.getKey()).a(paramb);
          }
        }
      }
    }
    AppMethodBeat.o(201548);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(165554);
    if ((paramd == null) || (!this.rQD.containsKey(paramd)))
    {
      AppMethodBeat.o(165554);
      return;
    }
    this.rQD.remove(paramd);
    AppMethodBeat.o(165554);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(201549);
    this.hju = true;
    h.LTJ.aZz("EventDispatcher");
    Iterator localIterator = ((Map)this.rQD).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getKey()).onRelease();
    }
    this.rQD.clear();
    AppMethodBeat.o(201549);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/event/base/EventDispatcher$doEvent$1$1"})
  static final class b
    implements Runnable
  {
    b(Map.Entry paramEntry, c paramc, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(165552);
      ((d)this.rQG.getKey()).a(paramb);
      AppMethodBeat.o(165552);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.c
 * JD-Core Version:    0.7.0.1
 */