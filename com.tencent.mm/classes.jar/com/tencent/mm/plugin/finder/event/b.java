package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/FinderPlayProgressObserver;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
public final class b
  extends d
{
  private final String TAG = "FinderPlayProgressObserver";
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(243425);
    p.h(paramb, "ev");
    if ((paramb instanceof c.a))
    {
      Log.i(this.TAG, "offset = " + ((c.a)paramb).offset + ",total = " + ((c.a)paramb).jcu);
      Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if ((((Number)com.tencent.mm.plugin.finder.storage.c.duz().value()).intValue() == 1) && (((c.a)paramb).offset >= ((c.a)paramb).jcu - 1))
      {
        localObject = y.vXH;
        y.a(((c.a)paramb).feedId, true, 2);
      }
    }
    AppMethodBeat.o(243425);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(243426);
    p.h(paramc, "dispatcher");
    p.h(paramb, "event");
    if (((paramb instanceof c.a)) && (((c.a)paramb).type == 3))
    {
      AppMethodBeat.o(243426);
      return true;
    }
    AppMethodBeat.o(243426);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.b
 * JD-Core Version:    0.7.0.1
 */