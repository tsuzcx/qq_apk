package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.hm;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "event", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;", "invoke"})
final class FinderProfileFeedLoader$handleStickyEvent$1
  extends q
  implements b<hm, x>
{
  public static final 1 INSTANCE;
  
  static
  {
    AppMethodBeat.i(244809);
    INSTANCE = new 1();
    AppMethodBeat.o(244809);
  }
  
  FinderProfileFeedLoader$handleStickyEvent$1()
  {
    super(1);
  }
  
  public final void invoke(hm paramhm)
  {
    AppMethodBeat.i(244808);
    p.h(paramhm, "event");
    d.h((a)1.INSTANCE);
    AppMethodBeat.o(244808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader.handleStickyEvent.1
 * JD-Core Version:    0.7.0.1
 */