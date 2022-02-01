package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/FinderPlayProgressObserver;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.finder.event.base.d
{
  private final String TAG = "FinderPlayProgressObserver";
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(330285);
    s.u(paramb, "ev");
    if ((paramb instanceof c.a))
    {
      Log.i(this.TAG, "offset = " + ((c.a)paramb).offset + ",total = " + ((c.a)paramb).total);
      Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.eUj().bmg()).intValue() == 1) && (((c.a)paramb).offset >= ((c.a)paramb).total - 1))
      {
        localObject = av.GiL;
        av.a(((c.a)paramb).feedId, true, 2);
      }
    }
    AppMethodBeat.o(330285);
  }
  
  public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(330290);
    s.u(paramc, "dispatcher");
    s.u(paramb, "event");
    if (((paramb instanceof c.a)) && (((c.a)paramb).type == 3))
    {
      AppMethodBeat.o(330290);
      return true;
    }
    AppMethodBeat.o(330290);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.b
 * JD-Core Version:    0.7.0.1
 */