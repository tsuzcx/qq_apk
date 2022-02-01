package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.life.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "", "threadTag", "", "(Ljava/lang/String;)V", "eventObservers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isRelease", "", "addObserver", "", "observer", "doEvent", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onRelease", "removeObserver", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a ANU;
  private final ConcurrentHashMap<d, Object> ANV;
  private final MMHandler handler;
  private volatile boolean nzB;
  private final String threadTag;
  
  static
  {
    AppMethodBeat.i(165556);
    ANU = new c.a((byte)0);
    AppMethodBeat.o(165556);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(330310);
    this.threadTag = paramString;
    this.ANV = new ConcurrentHashMap();
    paramString = new MMHandler(this.threadTag);
    paramString.setLogging(false);
    ah localah = ah.aiuX;
    this.handler = paramString;
    AppMethodBeat.o(330310);
  }
  
  private static final void a(Map.Entry paramEntry, b paramb)
  {
    AppMethodBeat.i(330319);
    s.u(paramEntry, "$entry");
    s.u(paramb, "$event");
    ((d)paramEntry.getKey()).a(paramb);
    AppMethodBeat.o(330319);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(165553);
    s.u(paramd, "observer");
    ((Map)this.ANV).put(paramd, new Object());
    AppMethodBeat.o(165553);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(330336);
    s.u(paramb, "event");
    if (this.nzB)
    {
      AppMethodBeat.o(330336);
      return;
    }
    Iterator localIterator = ((Map)this.ANV).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((d)localEntry.getKey()).a(this, paramb))
      {
        d locald = (d)localEntry.getKey();
        if (k.contains(locald.Bvo, locald.Bvn)) {
          if (((d)localEntry.getKey()).dXA()) {
            this.handler.post(new c..ExternalSyntheticLambda0(localEntry, paramb));
          } else {
            ((d)localEntry.getKey()).a(paramb);
          }
        }
      }
    }
    AppMethodBeat.o(330336);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(165554);
    if ((paramd == null) || (!this.ANV.containsKey(paramd)))
    {
      AppMethodBeat.o(165554);
      return;
    }
    this.ANV.remove(paramd);
    AppMethodBeat.o(165554);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(330350);
    this.nzB = true;
    this.handler.quitSafely();
    Iterator localIterator = ((Map)this.ANV).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getKey()).onRelease();
    }
    this.ANV.clear();
    AppMethodBeat.o(330350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.c
 * JD-Core Version:    0.7.0.1
 */