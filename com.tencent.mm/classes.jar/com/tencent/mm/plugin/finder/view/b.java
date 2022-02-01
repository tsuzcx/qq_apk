package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.sdk.b.c;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderUninterestEvent;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "", "event", "Companion", "plugin-finder_release"})
public final class b
  extends c<ht>
{
  public static final b.a tdl;
  private final BaseFinderFeedLoader scw;
  
  static
  {
    AppMethodBeat.i(205668);
    tdl = new b.a((byte)0);
    AppMethodBeat.o(205668);
  }
  
  public b(BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    AppMethodBeat.i(205667);
    this.scw = paramBaseFinderFeedLoader;
    AppMethodBeat.o(205667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.b
 * JD-Core Version:    0.7.0.1
 */