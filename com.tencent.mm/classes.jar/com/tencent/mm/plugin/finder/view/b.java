package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.sdk.b.c;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderUninterestEvent;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "", "event", "Companion", "plugin-finder_release"})
public final class b
  extends c<hs>
{
  public static final a sSa;
  private final BaseFinderFeedLoader rTS;
  
  static
  {
    AppMethodBeat.i(205043);
    sSa = new a((byte)0);
    AppMethodBeat.o(205043);
  }
  
  public b(BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    AppMethodBeat.i(205042);
    this.rTS = paramBaseFinderFeedLoader;
    AppMethodBeat.o(205042);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.b
 * JD-Core Version:    0.7.0.1
 */