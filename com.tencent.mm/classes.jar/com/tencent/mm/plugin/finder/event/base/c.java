package com.tencent.mm.plugin.finder.event.base;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.life.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "", "threadTag", "", "(Ljava/lang/String;)V", "eventObservers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isRelease", "", "addObserver", "", "observer", "doEvent", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onRelease", "removeObserver", "Companion", "plugin-finder_release"})
public final class c
{
  public static final a tHZ;
  private volatile boolean ife;
  private final ConcurrentHashMap<d, Object> tHX;
  private final String tHY;
  
  static
  {
    AppMethodBeat.i(165556);
    tHZ = new a((byte)0);
    AppMethodBeat.o(165556);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(243449);
    this.tHY = paramString;
    this.tHX = new ConcurrentHashMap();
    AppMethodBeat.o(243449);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(165553);
    p.h(paramd, "observer");
    ((Map)this.tHX).put(paramd, new Object());
    AppMethodBeat.o(165553);
  }
  
  public final void b(final b paramb)
  {
    AppMethodBeat.i(243447);
    p.h(paramb, "event");
    if (this.ife)
    {
      AppMethodBeat.o(243447);
      return;
    }
    Iterator localIterator = ((Map)this.tHX).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((d)localEntry.getKey()).a(this, paramb))
      {
        d locald = (d)localEntry.getKey();
        if (e.contains(locald.ueV, locald.ueU)) {
          if (((d)localEntry.getKey()).cZD()) {
            h.RTc.b((Runnable)new b(localEntry, this, paramb), this.tHY);
          } else {
            ((d)localEntry.getKey()).a(paramb);
          }
        }
      }
    }
    AppMethodBeat.o(243447);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(165554);
    if ((paramd == null) || (!this.tHX.containsKey(paramd)))
    {
      AppMethodBeat.o(165554);
      return;
    }
    this.tHX.remove(paramd);
    AppMethodBeat.o(165554);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(243448);
    this.ife = true;
    h.RTc.bqo("EventDispatcher");
    Iterator localIterator = ((Map)this.tHX).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getKey()).onRelease();
    }
    this.tHX.clear();
    AppMethodBeat.o(243448);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/event/base/EventDispatcher$doEvent$1$1"})
  static final class b
    implements Runnable
  {
    b(Map.Entry paramEntry, c paramc, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(165552);
      ((d)this.tIa.getKey()).a(paramb);
      AppMethodBeat.o(165552);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.c
 * JD-Core Version:    0.7.0.1
 */