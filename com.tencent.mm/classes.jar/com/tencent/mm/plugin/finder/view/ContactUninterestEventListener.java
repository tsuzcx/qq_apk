package com.tencent.mm.plugin.finder.view;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.jw;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderUninterestEvent;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "", "event", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ContactUninterestEventListener
  extends IListener<jw>
{
  public static final a GwE;
  private final BaseFinderFeedLoader ALH;
  
  static
  {
    AppMethodBeat.i(344540);
    GwE = new a((byte)0);
    AppMethodBeat.o(344540);
  }
  
  public ContactUninterestEventListener(BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super((q)f.hfK);
    AppMethodBeat.i(344533);
    this.ALH = paramBaseFinderFeedLoader;
    AppMethodBeat.o(344533);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.ContactUninterestEventListener
 * JD-Core Version:    0.7.0.1
 */