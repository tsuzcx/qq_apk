package com.tencent.mm.plugin.finder.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.event.base.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$9", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
public final class e$ae
  extends f
{
  private long qGl = -1L;
  
  e$ae(com.tencent.mm.view.recyclerview.e parame) {}
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(197397);
    k.h(paramc, "ev");
    Object localObject1;
    Object localObject2;
    if ((paramc instanceof i))
    {
      localObject1 = this.nGG.fjf();
      if (((localObject1 instanceof BaseFinderFeed)) && (this.qGl != ((i)paramc).qsk))
      {
        long l = ((BaseFinderFeed)localObject1).feedObject.getExpectId();
        if (((i)paramc).qsk != l) {
          break label139;
        }
        localObject1 = this.nGG;
        localObject2 = this.nGG.fjf();
        if (localObject2 == null)
        {
          paramc = new v("null cannot be cast to non-null type T");
          AppMethodBeat.o(197397);
          throw paramc;
        }
        e.a(true, (com.tencent.mm.view.recyclerview.e)localObject1, (BaseFinderFeed)localObject2);
      }
    }
    for (;;)
    {
      this.qGl = ((i)paramc).qsk;
      AppMethodBeat.o(197397);
      return;
      label139:
      localObject1 = this.nGG;
      localObject2 = this.nGG.fjf();
      if (localObject2 == null)
      {
        paramc = new v("null cannot be cast to non-null type T");
        AppMethodBeat.o(197397);
        throw paramc;
      }
      e.a(false, (com.tencent.mm.view.recyclerview.e)localObject1, (BaseFinderFeed)localObject2);
    }
  }
  
  public final boolean a(d paramd, c paramc)
  {
    AppMethodBeat.i(197398);
    k.h(paramd, "dispatcher");
    k.h(paramc, "event");
    boolean bool = paramc instanceof i;
    AppMethodBeat.o(197398);
    return bool;
  }
  
  public final boolean clc()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e.ae
 * JD-Core Version:    0.7.0.1
 */