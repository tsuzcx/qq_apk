package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ix;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.sdk.event.IListener;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderUninterestEvent;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "", "event", "Companion", "plugin-finder_release"})
public final class c
  extends IListener<ix>
{
  public static final a AUm;
  private final BaseFinderFeedLoader xnX;
  
  static
  {
    AppMethodBeat.i(283566);
    AUm = new a((byte)0);
    AppMethodBeat.o(283566);
  }
  
  public c(BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    AppMethodBeat.i(283565);
    this.xnX = paramBaseFinderFeedLoader;
    AppMethodBeat.o(283565);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.c
 * JD-Core Version:    0.7.0.1
 */