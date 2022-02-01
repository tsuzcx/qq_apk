package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.a.ie;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "event", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;"}, k=3, mv={1, 5, 1}, xi=48)
final class FinderProfileFeedLoader$handleStickyEvent$1
  extends u
  implements b<ie, ah>
{
  public static final 1 INSTANCE;
  
  static
  {
    AppMethodBeat.i(366264);
    INSTANCE = new 1();
    AppMethodBeat.o(366264);
  }
  
  FinderProfileFeedLoader$handleStickyEvent$1()
  {
    super(1);
  }
  
  public final void invoke(ie paramie)
  {
    AppMethodBeat.i(366269);
    s.u(paramie, "event");
    d.uiThread((a)1.INSTANCE);
    AppMethodBeat.o(366269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader.handleStickyEvent.1
 * JD-Core Version:    0.7.0.1
 */