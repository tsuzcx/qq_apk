package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.sdk.event.IListener;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderUninterestEvent;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "", "event", "Companion", "plugin-finder_release"})
public final class b
  extends IListener<ii>
{
  public static final a wjJ;
  private final BaseFinderFeedLoader tFM;
  
  static
  {
    AppMethodBeat.i(254621);
    wjJ = new a((byte)0);
    AppMethodBeat.o(254621);
  }
  
  public b(BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    AppMethodBeat.i(254620);
    this.tFM = paramBaseFinderFeedLoader;
    AppMethodBeat.o(254620);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.b
 * JD-Core Version:    0.7.0.1
 */