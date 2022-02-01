package com.tencent.mm.plugin.finder.feed;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.im;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentChangeEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "callback", "", "event", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderCommentDrawerPresenter$commentChangeEventListener$1
  extends IListener<im>
{
  FinderCommentDrawerPresenter$commentChangeEventListener$1(f paramf, com.tencent.mm.app.f paramf1)
  {
    super((q)paramf1);
    AppMethodBeat.i(363034);
    AppMethodBeat.o(363034);
  }
  
  private static final void aP(a parama)
  {
    AppMethodBeat.i(363041);
    s.u(parama, "$func");
    parama.invoke();
    AppMethodBeat.o(363041);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(im paramim, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderCommentDrawerPresenter.commentChangeEventListener.1
 * JD-Core Version:    0.7.0.1
 */