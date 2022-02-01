package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/FinderPlayProgressObserver;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
public final class b
  extends d
{
  private final String TAG = "FinderPlayProgressObserver";
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(201975);
    d.g.b.p.h(paramb, "ev");
    if ((paramb instanceof c.a))
    {
      ae.i(this.TAG, "offset = " + ((c.a)paramb).offset + ",total = " + ((c.a)paramb).ihz);
      Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if ((((Number)com.tencent.mm.plugin.finder.storage.b.cKF().value()).intValue() == 1) && (((c.a)paramb).offset >= ((c.a)paramb).ihz - 1))
      {
        localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
        com.tencent.mm.plugin.finder.utils.p.a(((c.a)paramb).duw, true, 2);
      }
    }
    AppMethodBeat.o(201975);
  }
  
  public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(201976);
    d.g.b.p.h(paramc, "dispatcher");
    d.g.b.p.h(paramb, "event");
    if (((paramb instanceof c.a)) && (((c.a)paramb).type == 3))
    {
      AppMethodBeat.o(201976);
      return true;
    }
    AppMethodBeat.o(201976);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.b
 * JD-Core Version:    0.7.0.1
 */