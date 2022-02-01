package com.tencent.mm.plugin.finder.event.base;

import com.tencent.e.h;
import com.tencent.e.i;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "", "threadTag", "", "(Ljava/lang/String;)V", "eventObservers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isRelease", "", "addObserver", "", "observer", "doEvent", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onRelease", "removeObserver", "Companion", "plugin-finder-base_release"})
public final class c
{
  public static final a xqI;
  private volatile boolean kTS;
  private final String threadTag;
  private final ConcurrentHashMap<d, Object> xqH;
  
  static
  {
    AppMethodBeat.i(165556);
    xqI = new a((byte)0);
    AppMethodBeat.o(165556);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(258141);
    this.threadTag = paramString;
    this.xqH = new ConcurrentHashMap();
    AppMethodBeat.o(258141);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(165553);
    p.k(paramd, "observer");
    ((Map)this.xqH).put(paramd, new Object());
    AppMethodBeat.o(165553);
  }
  
  public final void b(final b paramb)
  {
    AppMethodBeat.i(258137);
    p.k(paramb, "event");
    if (this.kTS)
    {
      AppMethodBeat.o(258137);
      return;
    }
    Iterator localIterator = ((Map)this.xqH).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((d)localEntry.getKey()).a(this, paramb))
      {
        d locald = (d)localEntry.getKey();
        if (e.contains(locald.xUp, locald.xUo)) {
          if (((d)localEntry.getKey()).dpw()) {
            h.ZvG.d((Runnable)new b(localEntry, this, paramb), this.threadTag);
          } else {
            ((d)localEntry.getKey()).a(paramb);
          }
        }
      }
    }
    AppMethodBeat.o(258137);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(165554);
    if ((paramd == null) || (!this.xqH.containsKey(paramd)))
    {
      AppMethodBeat.o(165554);
      return;
    }
    this.xqH.remove(paramd);
    AppMethodBeat.o(165554);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(258140);
    this.kTS = true;
    h.ZvG.bDh("EventDispatcher");
    Iterator localIterator = ((Map)this.xqH).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getKey()).onRelease();
    }
    this.xqH.clear();
    AppMethodBeat.o(258140);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/event/base/EventDispatcher$doEvent$1$1"})
  static final class b
    implements Runnable
  {
    b(Map.Entry paramEntry, c paramc, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(165552);
      ((d)this.xqJ.getKey()).a(paramb);
      AppMethodBeat.o(165552);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.c
 * JD-Core Version:    0.7.0.1
 */