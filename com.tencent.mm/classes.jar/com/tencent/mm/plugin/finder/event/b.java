package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/FinderPlayProgressObserver;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
public final class b
  extends com.tencent.mm.plugin.finder.event.base.d
{
  private final String TAG = "FinderPlayProgressObserver";
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(277992);
    p.k(paramb, "ev");
    if ((paramb instanceof c.a))
    {
      Log.i(this.TAG, "offset = " + ((c.a)paramb).offset + ",total = " + ((c.a)paramb).total);
      Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.dVH().aSr()).intValue() == 1) && (((c.a)paramb).offset >= ((c.a)paramb).total - 1))
      {
        localObject = aj.AGc;
        aj.a(((c.a)paramb).feedId, true, 2);
      }
    }
    AppMethodBeat.o(277992);
  }
  
  public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(277994);
    p.k(paramc, "dispatcher");
    p.k(paramb, "event");
    if (((paramb instanceof c.a)) && (((c.a)paramb).type == 3))
    {
      AppMethodBeat.o(277994);
      return true;
    }
    AppMethodBeat.o(277994);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.b
 * JD-Core Version:    0.7.0.1
 */