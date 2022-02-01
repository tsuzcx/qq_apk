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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "", "threadTag", "", "(Ljava/lang/String;)V", "eventObservers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isRelease", "", "addObserver", "", "observer", "doEvent", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onRelease", "removeObserver", "Companion", "plugin-finder_release"})
public final class d
{
  public static final a qsq;
  private final String KMa;
  private volatile boolean gqu;
  private final ConcurrentHashMap<f, Object> qsp;
  
  static
  {
    AppMethodBeat.i(165556);
    qsq = new a((byte)0);
    AppMethodBeat.o(165556);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(197534);
    this.KMa = paramString;
    this.qsp = new ConcurrentHashMap();
    AppMethodBeat.o(197534);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(165553);
    k.h(paramf, "observer");
    ((Map)this.qsp).put(paramf, new Object());
    AppMethodBeat.o(165553);
  }
  
  public final void b(f paramf)
  {
    AppMethodBeat.i(165554);
    if ((paramf == null) || (!this.qsp.containsKey(paramf)))
    {
      AppMethodBeat.o(165554);
      return;
    }
    this.qsp.remove(paramf);
    AppMethodBeat.o(165554);
  }
  
  public final void d(final c paramc)
  {
    AppMethodBeat.i(197532);
    k.h(paramc, "event");
    if (this.gqu)
    {
      AppMethodBeat.o(197532);
      return;
    }
    Iterator localIterator = ((Map)this.qsp).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((f)localEntry.getKey()).a(this, paramc))
      {
        f localf = (f)localEntry.getKey();
        if (e.contains(localf.qBQ, localf.qBP)) {
          if (((f)localEntry.getKey()).clc()) {
            h.Iye.f((Runnable)new b(localEntry, this, paramc), this.KMa);
          } else {
            ((f)localEntry.getKey()).a(paramc);
          }
        }
      }
    }
    AppMethodBeat.o(197532);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(197533);
    this.gqu = true;
    h.Iye.aNW("EventDispatcher");
    Iterator localIterator = ((Map)this.qsp).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((f)((Map.Entry)localIterator.next()).getKey()).onRelease();
    }
    this.qsp.clear();
    AppMethodBeat.o(197533);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/event/base/EventDispatcher$doEvent$1$1"})
  static final class b
    implements Runnable
  {
    b(Map.Entry paramEntry, d paramd, c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(165552);
      ((f)this.qsr.getKey()).a(paramc);
      AppMethodBeat.o(165552);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.d
 * JD-Core Version:    0.7.0.1
 */