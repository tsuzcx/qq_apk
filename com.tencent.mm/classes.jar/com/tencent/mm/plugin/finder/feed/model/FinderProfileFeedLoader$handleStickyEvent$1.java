package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.a.ht;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "event", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;", "invoke"})
final class FinderProfileFeedLoader$handleStickyEvent$1
  extends q
  implements b<ht, x>
{
  public static final 1 INSTANCE;
  
  static
  {
    AppMethodBeat.i(286935);
    INSTANCE = new 1();
    AppMethodBeat.o(286935);
  }
  
  FinderProfileFeedLoader$handleStickyEvent$1()
  {
    super(1);
  }
  
  public final void invoke(ht paramht)
  {
    AppMethodBeat.i(286934);
    p.k(paramht, "event");
    d.uiThread((a)1.INSTANCE);
    AppMethodBeat.o(286934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader.handleStickyEvent.1
 * JD-Core Version:    0.7.0.1
 */